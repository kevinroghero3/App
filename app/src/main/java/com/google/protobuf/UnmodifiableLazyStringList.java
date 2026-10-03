package com.google.protobuf;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.io.encoding.Base64;
import o.ArtificialStackFrames;
import o.ICustomTabsCallback;
import o.ICustomTabsCallbackDefault;

/* JADX INFO: loaded from: classes3.dex */
public class UnmodifiableLazyStringList extends AbstractList<String> implements LazyStringList, RandomAccess {
    private static short[] ICustomTabsService;
    private final LazyStringList list;
    private static final byte[] $$c = {87, 9, 66, Ascii.SYN};
    private static final int $$d = 133;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {115, -32, -105, -45, -12, -6, Ascii.ESC, -22, -26, 4, -12, 0, -8, -2, -8};
    private static final int $$b = 146;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static int onTransact = 279354528;
    private static int mayLaunchUrl = -81862432;
    private static int getInterfaceDescriptor = 1379057580;
    private static byte[] ICustomTabsCallbackStubProxy = {35, -122, 116, -117, 122, -72, 80, 114, 116, -88, -107, 52, -115, 112, -53, 70, 96, -98, 124, Ascii.GS, 40, 122, -104, -106, -99, 73, -120, 126, 116, -52, 70, 96, -98, 124, 47, 120, -120, 112, -86, 81, -97, -111, 108, 112, 113, 118, -123, 125, -90, 19, -117, -120, Ascii.ETB, 115, -113, -98, 107, -124, 117, Ascii.NAK, 52, -73, -118, -120, 73, -122, 117, 121, 49, 117, 126, -106, 106, -122, 122, -124, 115, -121, 100, -102, -102, 105, -126, -107, -113, 117, -100, SignedBytes.MAX_POWER_OF_TWO, 117, 126, 118, -50, 62, -114, -128, 124, 118, -103, 117, 121, -50, 70, 96, -98, 124, Ascii.FS, 117, Ascii.DC4, 116, -118, 126, -121, 126, -94, 90, -124, 117, 38, -115, -120, 118, -120, 119, -113, 126, -116, -118, -117, -117, -120, 118, -120, 113, -115, 118, -120, 115, -125, 112, -114, 118, 60, 122, -104, 117, 113, -120, 118, 126, -119, -122, -87, -127, -126, 112, 86, -95, 49, -119, -122, -119, -66, 62, -114, -128, 124, 118, -103, 117, 121, -50, 70, 96, -98, 124, 45, 123, -126, -128, -128, 99, 116, -115, 125, -114, -126, 122, 119, -72, 90, -124, 117, Ascii.DC2, -124, 100, 112, 47, -122, 116, -117, 122, -72, -97, 52, -115, 112, -53, 70, 96, -98, 124, 43, 114, -114, 124, 117, -86, 80, -104, -106, 82, 112, 40, 115, -121, -104, 98, 117, -115, 125, -125, -119, -102, 87, -124, 117, Base64.padSymbol, -122, 117, -115, 120, -122, -97, 99, 117, -115, 125, -125, -119, -102, -87, 74, 118, -55, 49, -115, -126, 122, -115, 116, -121, -66, 65, 112, 113, 118, -123, 125, -122, 40, -126, 115, -82, 111, 117, -115, 125, -125, -119, -102, 87, -124, 117, 19, 122, 124, 56, -126, 115, -82, 111, 117, -115, 125, -125, -119, -102, -87, 74, 118, -55, 49, -115, -126, 122, -115, 116, -121, -66, 65, 112, 113, 118, -123, 125, -122, Ascii.DC4, -123, 120, 118, -118, -104, 120, -116, 117, 125, 59, -118, -123, 117, 117, -82, 84, 117, -115, 101, -117, -123, -109, -108, 62, -114, -128, 124, 118, -103, 117, 121, -50, 70, 96, -98, 124, 43, -109, 100, -117, -70, 87, 122, 112, -68, 88, 112};
    private static long coroutineBoundary = -1026825672522352113L;
    private static int accessartificialFrame = -1151259316;
    private static char CoroutineDebuggingKt = 11596;

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0028). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(byte r6, byte r7, int r8) {
        /*
            int r7 = r7 * 3
            int r0 = r7 + 1
            int r6 = r6 + 4
            int r8 = r8 + 98
            byte[] r1 = com.google.protobuf.UnmodifiableLazyStringList.$$c
            byte[] r0 = new byte[r0]
            r2 = 0
            if (r1 != 0) goto L13
            r8 = r6
            r3 = r7
            r4 = r2
            goto L28
        L13:
            r3 = r2
            r5 = r8
            r8 = r6
            r6 = r5
        L17:
            byte r4 = (byte) r6
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L24:
            int r8 = r8 + 1
            r3 = r1[r8]
        L28:
            int r3 = -r3
            int r6 = r6 + r3
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.UnmodifiableLazyStringList.$$e(byte, byte, int):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0029  */
    /* JADX WARN: Code duplicated, block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x002f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0029
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void c(short r7, byte r8, byte r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 8
            int r8 = 11 - r8
            int r9 = r9 * 3
            int r9 = r9 + 112
            int r7 = r7 * 5
            int r7 = 9 - r7
            byte[] r0 = com.google.protobuf.UnmodifiableLazyStringList.$$a
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r7
            r9 = r8
            r4 = r2
            goto L2f
        L17:
            r3 = r2
        L18:
            int r8 = r8 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r7) goto L29
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L29:
            r3 = r0[r8]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r6
        L2f:
            int r8 = -r8
            int r3 = r3 + r8
            int r8 = r3 + (-7)
            r3 = r4
            r6 = r9
            r9 = r8
            r8 = r6
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.UnmodifiableLazyStringList.c(short, byte, byte, java.lang.Object[]):void");
    }

    @Override // com.google.protobuf.LazyStringList
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

    @Override // com.google.protobuf.LazyStringList
    public Object getRaw(int i) {
        return this.list.getRaw(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.list.size();
    }

    @Override // com.google.protobuf.LazyStringList
    public ByteString getByteString(int i) {
        return this.list.getByteString(i);
    }

    @Override // com.google.protobuf.LazyStringList
    public void add(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public void set(int i, ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public boolean addAllByteString(Collection<? extends ByteString> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public byte[] getByteArray(int i) {
        return this.list.getByteArray(i);
    }

    @Override // com.google.protobuf.LazyStringList
    public void add(byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public void set(int i, byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public boolean addAllByteArray(Collection<byte[]> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<String> listIterator(int i) {
        return new ListIterator<String>(i) { // from class: com.google.protobuf.UnmodifiableLazyStringList.1
            ListIterator<String> iter;
            final /* synthetic */ int val$index;

            {
                this.val$index = i;
                this.iter = UnmodifiableLazyStringList.this.list.listIterator(i);
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

    private static void a(char[] cArr, char c, int i, char[] cArr2, char[] cArr3, Object[] objArr) throws Throwable {
        int i2 = 2;
        int i3 = 2 % 2;
        ICustomTabsCallbackDefault iCustomTabsCallbackDefault = new ICustomTabsCallbackDefault();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr3.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr3, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr.length;
        char[] cArr6 = new char[length3];
        iCustomTabsCallbackDefault.a = 0;
        while (iCustomTabsCallbackDefault.a < length3) {
            int i4 = $10 + 41;
            $11 = i4 % 128;
            int i5 = i4 % i2;
            try {
                Object[] objArr2 = {iCustomTabsCallbackDefault};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-10548171);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) (-1);
                    byte b2 = (byte) (b + 1);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(33 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1), 1483 - (ViewConfiguration.getEdgeSlop() >> 16), 1614432829, false, $$e(b, b2, (byte) (b2 + 1)), new Class[]{Object.class});
                }
                int iIntValue = ((Integer) ((java.lang.reflect.Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                Object[] objArr3 = {iCustomTabsCallbackDefault};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1818210492);
                if (objAccessartificialFrame2 == null) {
                    byte b3 = (byte) (-1);
                    byte b4 = (byte) (b3 + 1);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(((Process.getThreadPriority(0) + 20) >> 6) + 32, (char) (TextUtils.indexOf((CharSequence) "", '0') + 49169), 900 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 214239564, false, $$e(b3, b4, (byte) (b4 + 3)), new Class[]{Object.class});
                }
                int iIntValue2 = ((Integer) ((java.lang.reflect.Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                Object[] objArr4 = {iCustomTabsCallbackDefault, Integer.valueOf(cArr4[iCustomTabsCallbackDefault.a % 4] * 32718), Integer.valueOf(cArr5[iIntValue])};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1532285801);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) (-1);
                    byte b6 = (byte) (b5 + 1);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(23 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), Gravity.getAbsoluteGravity(0, 0) + 2441, -1003383455, false, $$e(b5, b6, b6), new Class[]{Object.class, Integer.TYPE, Integer.TYPE});
                }
                ((java.lang.reflect.Method) objAccessartificialFrame3).invoke(null, objArr4);
                Object[] objArr5 = {Integer.valueOf(cArr4[iIntValue2] * 32718), Integer.valueOf(cArr5[iIntValue])};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-950633141);
                if (objAccessartificialFrame4 == null) {
                    byte b7 = (byte) (-1);
                    byte b8 = (byte) (b7 + 1);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(KeyEvent.normalizeMetaState(0) + 20, (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 29753), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 1748, 1479752515, false, $$e(b7, b8, (byte) (b8 + 2)), new Class[]{Integer.TYPE, Integer.TYPE});
                }
                cArr5[iIntValue2] = ((Character) ((java.lang.reflect.Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                cArr4[iIntValue2] = iCustomTabsCallbackDefault.MediaBrowserCompatApi21ConnectionCallback;
                cArr6[iCustomTabsCallbackDefault.a] = (char) (((((long) (cArr[iCustomTabsCallbackDefault.a] ^ cArr4[iIntValue2])) ^ (coroutineBoundary ^ (-899883803867009716L))) ^ ((long) ((int) (((long) accessartificialFrame) ^ (-899883803867009716L))))) ^ ((long) ((char) (((long) CoroutineDebuggingKt) ^ (-899883803867009716L)))));
                iCustomTabsCallbackDefault.a++;
                int i6 = $11 + 51;
                $10 = i6 % 128;
                int i7 = i6 % 2;
                i2 = 2;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        objArr[0] = new String(cArr6);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<String> iterator() {
        return new Iterator<String>() { // from class: com.google.protobuf.UnmodifiableLazyStringList.2
            Iterator<String> iter;

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
        };
    }

    @Override // com.google.protobuf.LazyStringList
    public List<?> getUnderlyingElements() {
        return this.list.getUnderlyingElements();
    }

    @Override // com.google.protobuf.LazyStringList
    public void mergeFrom(LazyStringList lazyStringList) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public List<byte[]> asByteArrayList() {
        return Collections.unmodifiableList(this.list.asByteArrayList());
    }

    @Override // com.google.protobuf.ProtocolStringList
    public List<ByteString> asByteStringList() {
        return Collections.unmodifiableList(this.list.asByteStringList());
    }

    /* JADX WARN: Code duplicated, block: B:38:0x01a3 A[PHI: r1
  0x01a3: PHI (r1v8 int) = (r1v7 int), (r1v58 int) binds: [B:37:0x01a1, B:34:0x018f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:39:0x01a5 A[PHI: r1
  0x01a5: PHI (r1v55 int) = (r1v7 int), (r1v58 int) binds: [B:37:0x01a1, B:34:0x018f] A[DONT_GENERATE, DONT_INLINE]] */
    private static void b(int i, byte b, int i2, short s, int i3, Object[] objArr) throws Throwable {
        int i4;
        int i5;
        char c;
        int i6;
        int i7 = 2 % 2;
        ICustomTabsCallback iCustomTabsCallback = new ICustomTabsCallback();
        StringBuilder sb = new StringBuilder();
        try {
            Object[] objArr2 = {Integer.valueOf(i2), Integer.valueOf(mayLaunchUrl)};
            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1991297565);
            int i8 = -1;
            if (objAccessartificialFrame == null) {
                byte b2 = (byte) (-1);
                byte b3 = (byte) (b2 + 1);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.getTrimmedLength("") + 40, (char) (KeyEvent.keyCodeFromString("") + 36241), 2342 - TextUtils.indexOf("", "", 0), 371880939, false, $$e(b2, b3, (byte) (b3 | Ascii.SO)), new Class[]{Integer.TYPE, Integer.TYPE});
            }
            int iIntValue = ((Integer) ((java.lang.reflect.Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
            boolean z = iIntValue == -1;
            if (z) {
                byte[] bArr = ICustomTabsCallbackStubProxy;
                if (bArr != null) {
                    int length = bArr.length;
                    byte[] bArr2 = new byte[length];
                    int i9 = 0;
                    while (i9 < length) {
                        Object[] objArr3 = {Integer.valueOf(bArr[i9])};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1557994855);
                        if (objAccessartificialFrame2 == null) {
                            byte b4 = (byte) i8;
                            byte b5 = (byte) (b4 + 1);
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(44 - Gravity.getAbsoluteGravity(0, 0), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16), 1215 - Color.argb(0, 0, 0, 0), 1011328145, false, $$e(b4, b5, (byte) (b5 | 19)), new Class[]{Integer.TYPE});
                        }
                        bArr2[i9] = ((Byte) ((java.lang.reflect.Method) objAccessartificialFrame2).invoke(null, objArr3)).byteValue();
                        i9++;
                        i8 = -1;
                    }
                    bArr = bArr2;
                }
                if (bArr != null) {
                    byte[] bArr3 = ICustomTabsCallbackStubProxy;
                    Object[] objArr4 = {Integer.valueOf(i3), Integer.valueOf(onTransact)};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1991297565);
                    if (objAccessartificialFrame3 == null) {
                        byte b6 = (byte) (-1);
                        byte b7 = (byte) (b6 + 1);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(KeyEvent.normalizeMetaState(0) + 40, (char) (36241 - (KeyEvent.getMaxKeyCode() >> 16)), 2342 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 371880939, false, $$e(b6, b7, (byte) (b7 | Ascii.SO)), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    iIntValue = (byte) (((byte) (((long) bArr3[((Integer) ((java.lang.reflect.Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue()]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                } else {
                    iIntValue = (short) (((short) (((long) ICustomTabsService[i3 + ((int) (((long) onTransact) ^ (-4629754035390455669L)))]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                }
            }
            if (iIntValue > 0) {
                int i10 = $11 + 25;
                $10 = i10 % 128;
                if (i10 % 2 != 0) {
                    i4 = ((i3 / iIntValue) >> 3) * ((int) (((long) onTransact) ^ (-4629754035390455669L)));
                    if (z) {
                        i5 = 1;
                    } else {
                        i5 = 0;
                    }
                } else {
                    i4 = ((i3 + iIntValue) - 2) + ((int) (((long) onTransact) ^ (-4629754035390455669L)));
                    if (z) {
                        i5 = 1;
                    } else {
                        i5 = 0;
                    }
                }
                iCustomTabsCallback.c = i4 + i5;
                Object[] objArr5 = {iCustomTabsCallback, Integer.valueOf(i), Integer.valueOf(getInterfaceDescriptor), sb};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(216546027);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(ImageFormat.getBitsPerPixel(0) + 42, (char) (ImageFormat.getBitsPerPixel(0) + 1), 4114 - AndroidCharacter.getMirror('0'), -1819443997, false, "x", new Class[]{Object.class, Integer.TYPE, Integer.TYPE, Object.class});
                }
                ((StringBuilder) ((java.lang.reflect.Method) objAccessartificialFrame4).invoke(null, objArr5)).append(iCustomTabsCallback.createConnectionCallback);
                iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                byte[] bArr4 = ICustomTabsCallbackStubProxy;
                if (bArr4 != null) {
                    int length2 = bArr4.length;
                    byte[] bArr5 = new byte[length2];
                    int i11 = 0;
                    while (i11 < length2) {
                        int i12 = $10 + 115;
                        $11 = i12 % 128;
                        if (i12 % 2 == 0) {
                            bArr5[i11] = (byte) (((long) bArr4[i11]) | (-4629754035390455669L));
                            i11 %= 0;
                        } else {
                            bArr5[i11] = (byte) (((long) bArr4[i11]) ^ (-4629754035390455669L));
                            i11++;
                        }
                    }
                    bArr4 = bArr5;
                }
                boolean z2 = bArr4 != null;
                iCustomTabsCallback.a = 1;
                while (iCustomTabsCallback.a < iIntValue) {
                    if (z2) {
                        int i13 = $11 + 65;
                        $10 = i13 % 128;
                        if (i13 % 2 != 0) {
                            byte[] bArr6 = ICustomTabsCallbackStubProxy;
                            int i14 = iCustomTabsCallback.c;
                            iCustomTabsCallback.c = i14 + 1;
                            byte b8 = (byte) (((long) bArr6[i14]) % (-4629754035390455669L));
                            c = iCustomTabsCallback.createBrowser;
                            i6 = b8 / s;
                        } else {
                            byte[] bArr7 = ICustomTabsCallbackStubProxy;
                            int i15 = iCustomTabsCallback.c;
                            iCustomTabsCallback.c = i15 - 1;
                            byte b9 = (byte) (((long) bArr7[i15]) ^ (-4629754035390455669L));
                            c = iCustomTabsCallback.createBrowser;
                            i6 = b9 + s;
                        }
                        iCustomTabsCallback.createConnectionCallback = (char) (c + (((byte) i6) ^ b));
                    } else {
                        short[] sArr = ICustomTabsService;
                        int i16 = iCustomTabsCallback.c;
                        iCustomTabsCallback.c = i16 - 1;
                        iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((short) (((short) (((long) sArr[i16]) ^ (-4629754035390455669L))) + s)) ^ b));
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
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 176941. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public static java.lang.Object[] accessartificialFrame(android.content.Context r50, java.lang.String[] r51, int r52, int r53, int r54) {
        /*
            Method dump skipped, instruction units count: 17694
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.UnmodifiableLazyStringList.accessartificialFrame(android.content.Context, java.lang.String[], int, int, int):java.lang.Object[]");
    }
}
