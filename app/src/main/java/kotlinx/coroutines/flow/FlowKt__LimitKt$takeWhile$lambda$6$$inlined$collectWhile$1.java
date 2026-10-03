package kotlinx.coroutines.flow;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.bridge.CatalystInstanceImpl;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import o.ArtificialStackFrames;
import o.ICustomTabsCallback;
import o.artificialFrame;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes6.dex */
public final class FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1<T> implements FlowCollector<T> {
    final /* synthetic */ Function2 $predicate$inlined;
    final /* synthetic */ FlowCollector $this_flow$inlined;

    public FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1(Function2 function2, FlowCollector flowCollector) {
        this.$predicate$inlined = function2;
        this.$this_flow$inlined = flowCollector;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x007e  */
    /* JADX WARN: Code duplicated, block: B:29:0x0081  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Object obj;
        Object obj2;
        FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1<T> flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj3 = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        boolean z = true;
        if (i2 != 0) {
            if (i2 == 1) {
                Object obj4 = anonymousClass1.L$1;
                FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1<T> flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$2 = (FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj3);
                obj2 = obj4;
                flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1 = flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$2;
                obj = obj3;
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1 = (FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj3);
            }
            if (z) {
                throw new AbortFlowException(flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj3);
        Function2 function2 = this.$predicate$inlined;
        anonymousClass1.L$0 = this;
        anonymousClass1.L$1 = t;
        anonymousClass1.label = 1;
        InlineMarker.mark(6);
        Object objInvoke = function2.invoke(t, anonymousClass1);
        InlineMarker.mark(7);
        if (objInvoke == coroutine_suspended) {
            return coroutine_suspended;
        }
        obj = objInvoke;
        obj2 = t;
        flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1 = this;
        if (((Boolean) obj).booleanValue()) {
            FlowCollector flowCollector = flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1.$this_flow$inlined;
            anonymousClass1.L$0 = flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1;
            anonymousClass1.L$1 = null;
            anonymousClass1.label = 2;
            if (flowCollector.emit(obj2, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            z = false;
        }
        if (z) {
            throw new AbortFlowException(flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$1, reason: invalid class name */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1", f = "Limit.kt", i = {0, 0, 1}, l = {131, 132}, m = "emit", n = {"this", "value", "this"}, s = {"L$0", "L$1", "L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        private static short[] ICustomTabsService;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        private static final byte[] $$a = {125, 126, -45, -128};
        private static final int $$b = 161;
        private static int $10 = 0;
        private static int $11 = 1;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static int[] ICustomTabsCallbackStub = {-774560193, -2018414909, -417667072, -402992939, 1332169792, 104317868, -1541940510, -69271981, -355427092, 1340080664, -1567653405, -281800489, -1654843690, 1770037485, -681529284, 931152718, -1034309682, -748058194};
        private static int onTransact = -1204200907;
        private static int mayLaunchUrl = -81862410;
        private static int getInterfaceDescriptor = -1584605191;
        private static byte[] ICustomTabsCallbackStubProxy = {41, 100, -126, 96, -115, 82, 97, 96, 103, -108, 108, -73, -98, 116, -71, 95, 104, -119, 103, -69, -66, 38, 97, 96, 103, -108, 108, -73, -98, 117, -111, 41, 117, -108, 122, -90, -93, 59, 124, 125, 122, -119, 113, -86, -125, 104, -116, -112, 79, 124, 125, 122, -119, 113, -86, -125, 105, -92, 94, 121, -97, 125, 17, Ascii.FS, -13, 17, -26, Ascii.US, -52, -11, 90, -26, -23, 17, -26, Ascii.US, -20, -43, 42, Ascii.ESC, Ascii.SUB, Ascii.GS, -18, Ascii.SYN, -19, Ascii.US, -10, 5, -3, 8, -10, -17, 19, 5, -3, Ascii.CR, -13, -7, -22, 39, -12, 5, 47, 55, -60, 60, -55, 55, 46, -46, -60, 60, -52, 50, 56, 43, Ascii.CAN, -5, -57, 120, -128, 60, 51, -53, 60, -59, 54, Ascii.SI, -16, -63, -64, -57, 52, -52, 55, Ascii.SUB, 43, -38, 7, -58, -36, 36, -44, 42, 32, 51, -2, 45, -36, 42, Base64.padSymbol, -52, 17, -48, -54, 50, -62, 60, 54, 37, Ascii.SYN, -11, -55, 118, -114, 50, Base64.padSymbol, -59, 50, -53, 56, 1, -2, -49, -50, -55, 58, -62, 57, 6, -15, Ascii.FF, 2, -2, -20, Ascii.FF, -8, 1, 9, 3, 121, -117, 119, -90, 5, -66, 73, -79, 81, -67, -71, -103, 105, -77, 66, 5, -58, 49, -34, -17, 2, 47, 37, -23, Ascii.CR, 37, Ascii.GS, -127, 99, -114, -118, 115, -115, -123, 114, 125, 82, -82, -127, 99, -97, 125, -121, 121, -114, 46, 4, -26, Ascii.VT, Ascii.SI, -10, 8, 0, -9, -8, -41, -1, -4, Ascii.SO, 40, -33, 79, -9, -8, -9, -64, SignedBytes.MAX_POWER_OF_TWO, -16, -2, 2, 8, -25, Ascii.VT, 7, -80, 56, Ascii.RS, -32, 2};

        private static String $$c(int i, byte b, byte b2) {
            int i2 = b * 4;
            int i3 = i + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
            int i4 = 4 - (b2 * 4);
            byte[] bArr = $$a;
            byte[] bArr2 = new byte[1 - i2];
            int i5 = 0 - i2;
            int i6 = -1;
            if (bArr == null) {
                i4++;
                i3 += i4;
            }
            while (true) {
                i6++;
                bArr2[i6] = (byte) i3;
                if (i6 == i5) {
                    return new String(bArr2, 0);
                }
                byte b3 = bArr[i4];
                i4++;
                i3 += b3;
            }
        }

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1.this.emit(null, this);
        }

        private static void a(int i, int[] iArr, Object[] objArr) throws Throwable {
            int i2 = 2;
            int i3 = 2 % 2;
            artificialFrame artificialframe = new artificialFrame();
            char[] cArr = new char[4];
            char[] cArr2 = new char[iArr.length * 2];
            int[] iArr2 = ICustomTabsCallbackStub;
            int i4 = -1780896814;
            int i5 = 16;
            int i6 = 1;
            int i7 = 0;
            if (iArr2 != null) {
                int length = iArr2.length;
                int[] iArr3 = new int[length];
                int i8 = 0;
                while (i8 < length) {
                    int i9 = $11 + b.i;
                    $10 = i9 % 128;
                    int i10 = i9 % i2;
                    try {
                        Object[] objArr2 = new Object[1];
                        objArr2[i7] = Integer.valueOf(iArr2[i8]);
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i4);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) i7;
                            byte b2 = b;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - (ViewConfiguration.getJumpTapTimeout() >> i5), (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1), Process.getGidForName("") + 1563, 180153818, false, $$c(b, b2, b2), new Class[]{Integer.TYPE});
                        }
                        iArr3[i8] = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                        i8++;
                        int i11 = $11 + 17;
                        $10 = i11 % 128;
                        int i12 = i11 % 2;
                        i2 = 2;
                        i4 = -1780896814;
                        i5 = 16;
                        i7 = 0;
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
            char c = '0';
            if (iArr5 != null) {
                int length3 = iArr5.length;
                int[] iArr6 = new int[length3];
                int i13 = 0;
                while (i13 < length3) {
                    try {
                        Object[] objArr3 = new Object[i6];
                        objArr3[0] = Integer.valueOf(iArr5[i13]);
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                        if (objAccessartificialFrame2 == null) {
                            byte b3 = (byte) 0;
                            byte b4 = b3;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(10 - TextUtils.lastIndexOf("", c, 0, 0), (char) ((-1) - Process.getGidForName("")), 1562 - ExpandableListView.getPackedPositionGroup(0L), 180153818, false, $$c(b3, b4, b4), new Class[]{Integer.TYPE});
                        }
                        iArr6[i13] = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                        i13++;
                        iArr5 = iArr5;
                        c = '0';
                        i6 = 1;
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                }
                iArr5 = iArr6;
            }
            char c2 = 0;
            System.arraycopy(iArr5, 0, iArr4, 0, length2);
            artificialframe.e = 0;
            while (artificialframe.e < iArr.length) {
                cArr[c2] = (char) (iArr[artificialframe.e] >> 16);
                cArr[1] = (char) iArr[artificialframe.e];
                cArr[2] = (char) (iArr[artificialframe.e + 1] >> 16);
                cArr[3] = (char) iArr[artificialframe.e + 1];
                artificialframe.c = (cArr[0] << 16) + cArr[1];
                artificialframe.b = (cArr[2] << 16) + cArr[3];
                artificialFrame.coroutineBoundary(iArr4);
                int i14 = 0;
                for (int i15 = 16; i14 < i15; i15 = 16) {
                    int i16 = $11 + 41;
                    $10 = i16 % 128;
                    if (i16 % 2 != 0) {
                        artificialframe.c ^= iArr4[i14];
                        Object[] objArr4 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                        if (objAccessartificialFrame3 == null) {
                            byte b5 = (byte) 0;
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(((Process.getThreadPriority(0) + 20) >> 6) + 26, (char) View.MeasureSpec.makeMeasureSpec(0, 0), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 1040, 995482881, false, $$c((byte) 6, b5, b5), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                        }
                        int iIntValue = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
                        artificialframe.c = artificialframe.b;
                        artificialframe.b = iIntValue;
                        i14 += 30;
                    } else {
                        artificialframe.c ^= iArr4[i14];
                        Object[] objArr5 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                        if (objAccessartificialFrame4 == null) {
                            byte b6 = (byte) 0;
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(25 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (ViewConfiguration.getScrollBarSize() >> 8), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 1040, 995482881, false, $$c((byte) 6, b6, b6), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                        }
                        int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                        artificialframe.c = artificialframe.b;
                        artificialframe.b = iIntValue2;
                        i14++;
                    }
                    int i17 = $11 + 29;
                    $10 = i17 % 128;
                    int i18 = i17 % 2;
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
                Object[] objArr6 = {artificialframe, artificialframe};
                Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1348396126);
                if (objAccessartificialFrame5 == null) {
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(37 - Color.blue(0), (char) (28010 - View.getDefaultSize(0, 0)), View.resolveSize(0, 0) + 306, -818175402, false, "q", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame5).invoke(null, objArr6);
                c2 = 0;
            }
            objArr[0] = new String(cArr2, 0, i);
        }

        /* JADX WARN: Code duplicated, block: B:40:0x01a9  */
        private static void b(int i, short s, byte b, int i2, int i3, Object[] objArr) throws Throwable {
            boolean z;
            int i4;
            int i5;
            int length;
            byte[] bArr;
            int i6 = 2 % 2;
            ICustomTabsCallback iCustomTabsCallback = new ICustomTabsCallback();
            StringBuilder sb = new StringBuilder();
            try {
                Object[] objArr2 = {Integer.valueOf(i2), Integer.valueOf(mayLaunchUrl)};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1991297565);
                if (objAccessartificialFrame == null) {
                    byte b2 = (byte) 3;
                    byte b3 = (byte) (b2 - 3);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(40 - KeyEvent.keyCodeFromString(""), (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 36241), View.combineMeasuredStates(0, 0) + 2342, 371880939, false, $$c(b2, b3, b3), new Class[]{Integer.TYPE, Integer.TYPE});
                }
                int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                if (iIntValue == -1) {
                    int i7 = $10 + 93;
                    $11 = i7 % 128;
                    int i8 = i7 % 2;
                    z = true;
                } else {
                    z = false;
                }
                float f = 0.0f;
                if (z) {
                    byte[] bArr2 = ICustomTabsCallbackStubProxy;
                    if (bArr2 != null) {
                        int length2 = bArr2.length;
                        byte[] bArr3 = new byte[length2];
                        int i9 = 0;
                        while (i9 < length2) {
                            Object[] objArr3 = {Integer.valueOf(bArr2[i9])};
                            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1557994855);
                            if (objAccessartificialFrame2 == null) {
                                byte b4 = (byte) 0;
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((AudioTrack.getMinVolume() > f ? 1 : (AudioTrack.getMinVolume() == f ? 0 : -1)) + 44, (char) View.getDefaultSize(0, 0), TextUtils.getTrimmedLength("") + 1215, 1011328145, false, $$c((byte) 8, b4, b4), new Class[]{Integer.TYPE});
                            }
                            bArr3[i9] = ((Byte) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).byteValue();
                            i9++;
                            f = 0.0f;
                        }
                        bArr2 = bArr3;
                    }
                    if (bArr2 != null) {
                        int i10 = $10 + b.f40o;
                        $11 = i10 % 128;
                        int i11 = i10 % 2;
                        byte[] bArr4 = ICustomTabsCallbackStubProxy;
                        Object[] objArr4 = {Integer.valueOf(i), Integer.valueOf(onTransact)};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1991297565);
                        if (objAccessartificialFrame3 == null) {
                            byte b5 = (byte) 3;
                            byte b6 = (byte) (b5 - 3);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(40 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (36240 - TextUtils.lastIndexOf("", '0')), MotionEvent.axisFromString("") + 2343, 371880939, false, $$c(b5, b6, b6), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        iIntValue = (byte) (((byte) (((long) bArr4[((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue()]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                    } else {
                        iIntValue = (short) (((short) (((long) ICustomTabsService[i + ((int) (((long) onTransact) ^ (-4629754035390455669L)))]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                    }
                }
                if (iIntValue > 0) {
                    int i12 = $11 + 49;
                    int i13 = i12 % 128;
                    $10 = i13;
                    int i14 = i12 % 2;
                    int i15 = ((i + iIntValue) - 2) + ((int) (((long) onTransact) ^ (-4629754035390455669L)));
                    if (z) {
                        int i16 = i13 + 69;
                        $11 = i16 % 128;
                        if (i16 % 2 == 0) {
                            i4 = 0;
                        } else {
                            i4 = 1;
                        }
                    } else {
                        i4 = 0;
                    }
                    iCustomTabsCallback.c = i15 + i4;
                    try {
                        Object[] objArr5 = {iCustomTabsCallback, Integer.valueOf(i3), Integer.valueOf(getInterfaceDescriptor), sb};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(216546027);
                        if (objAccessartificialFrame4 == null) {
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(41 - ((Process.getThreadPriority(0) + 20) >> 6), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 4066 - (ViewConfiguration.getPressedStateDuration() >> 16), -1819443997, false, "x", new Class[]{Object.class, Integer.TYPE, Integer.TYPE, Object.class});
                        }
                        ((StringBuilder) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).append(iCustomTabsCallback.createConnectionCallback);
                        iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                        byte[] bArr5 = ICustomTabsCallbackStubProxy;
                        if (bArr5 != null) {
                            int i17 = $11 + 69;
                            $10 = i17 % 128;
                            if (i17 % 2 != 0) {
                                length = bArr5.length;
                                bArr = new byte[length];
                            } else {
                                length = bArr5.length;
                                bArr = new byte[length];
                            }
                            for (int i18 = 0; i18 < length; i18++) {
                                int i19 = $10 + 75;
                                $11 = i19 % 128;
                                int i20 = i19 % 2;
                                bArr[i18] = (byte) (((long) bArr5[i18]) ^ (-4629754035390455669L));
                            }
                            bArr5 = bArr;
                        }
                        boolean z2 = bArr5 != null;
                        iCustomTabsCallback.a = 1;
                        while (iCustomTabsCallback.a < iIntValue) {
                            int i21 = $10 + 41;
                            int i22 = i21 % 128;
                            $11 = i22;
                            int i23 = i21 % 2;
                            if (z2) {
                                int i24 = i22 + 73;
                                $10 = i24 % 128;
                                if (i24 % 2 != 0) {
                                    byte[] bArr6 = ICustomTabsCallbackStubProxy;
                                    int i25 = iCustomTabsCallback.c;
                                    iCustomTabsCallback.c = i25 % 0;
                                    i5 = iCustomTabsCallback.createBrowser * (((byte) (((byte) (((long) bArr6[i25]) - 4629754035390455669L)) + s)) ^ b);
                                } else {
                                    byte[] bArr7 = ICustomTabsCallbackStubProxy;
                                    int i26 = iCustomTabsCallback.c;
                                    iCustomTabsCallback.c = i26 - 1;
                                    i5 = iCustomTabsCallback.createBrowser + (((byte) (((byte) (((long) bArr7[i26]) ^ (-4629754035390455669L))) + s)) ^ b);
                                }
                                iCustomTabsCallback.createConnectionCallback = (char) i5;
                            } else {
                                short[] sArr = ICustomTabsService;
                                int i27 = iCustomTabsCallback.c;
                                iCustomTabsCallback.c = i27 - 1;
                                iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((short) (((short) (((long) sArr[i27]) ^ (-4629754035390455669L))) + s)) ^ b));
                            }
                            sb.append(iCustomTabsCallback.createConnectionCallback);
                            iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                            iCustomTabsCallback.a++;
                            int i28 = $10 + 97;
                            $11 = i28 % 128;
                            if (i28 % 2 == 0) {
                                int i29 = 5 % 3;
                            }
                        }
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                objArr[0] = sb.toString();
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }

        /* JADX WARN: Code duplicated, block: B:102:0x0dd1  */
        /* JADX WARN: Code duplicated, block: B:105:0x0dda A[Catch: all -> 0x0ead, TryCatch #11 {all -> 0x0ead, blocks: (B:31:0x034f, B:32:0x0366, B:37:0x03d3, B:47:0x06b3, B:49:0x081d, B:53:0x09e6, B:61:0x0b33, B:72:0x0cb3, B:78:0x0cbf, B:89:0x0d79, B:98:0x0da4, B:103:0x0dd2, B:106:0x0de1, B:105:0x0dda, B:99:0x0db2, B:92:0x0d86, B:75:0x0cba, B:33:0x0369), top: B:184:0x033f }] */
        /* JADX WARN: Code duplicated, block: B:97:0x0da3  */
        /* JADX WARN: Code duplicated, block: B:99:0x0db2 A[Catch: all -> 0x0ead, TRY_LEAVE, TryCatch #11 {all -> 0x0ead, blocks: (B:31:0x034f, B:32:0x0366, B:37:0x03d3, B:47:0x06b3, B:49:0x081d, B:53:0x09e6, B:61:0x0b33, B:72:0x0cb3, B:78:0x0cbf, B:89:0x0d79, B:98:0x0da4, B:103:0x0dd2, B:106:0x0de1, B:105:0x0dda, B:99:0x0db2, B:92:0x0d86, B:75:0x0cba, B:33:0x0369), top: B:184:0x033f }] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v109 */
        /* JADX WARN: Type inference failed for: r0v17, types: [java.lang.reflect.Method] */
        /* JADX WARN: Type inference failed for: r0v21 */
        /* JADX WARN: Type inference failed for: r0v62 */
        /* JADX WARN: Type inference failed for: r33v1 */
        /* JADX WARN: Type inference failed for: r3v25 */
        /* JADX WARN: Type inference failed for: r5v104, types: [java.lang.reflect.Method] */
        /* JADX WARN: Type inference failed for: r7v0 */
        /* JADX WARN: Type inference failed for: r7v1 */
        /* JADX WARN: Type inference failed for: r7v134, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v142 */
        /* JADX WARN: Type inference failed for: r7v2, types: [int] */
        /* JADX WARN: Type inference failed for: r7v206, types: [int] */
        /* JADX WARN: Type inference failed for: r7v209, types: [int] */
        /* JADX WARN: Type inference failed for: r7v22 */
        /* JADX WARN: Type inference failed for: r7v24 */
        /* JADX WARN: Type inference failed for: r7v247 */
        /* JADX WARN: Type inference failed for: r7v29, types: [java.lang.reflect.Constructor] */
        /* JADX WARN: Type inference failed for: r7v4 */
        /* JADX WARN: Type inference failed for: r7v56, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r7v59, types: [int] */
        /* JADX WARN: Type inference failed for: r7v78 */
        /* JADX WARN: Type inference failed for: r7v80, types: [java.lang.Object[]] */
        public static Object[] accessartificialFrame(Context context, int i, int i2) {
            int i3;
            int i4;
            int i5;
            int iBlue;
            Object obj;
            int i6;
            int i7;
            int packedPositionType;
            byte b;
            int i8;
            Object objInvoke;
            int i9;
            int i10;
            short s;
            byte keyRepeatDelay;
            char c;
            int i11;
            int i12;
            int i13;
            int i14;
            int i15;
            Object[] objArr;
            int i16;
            char c2;
            int i17;
            int i18 = 2 % 2;
            ?? declaredConstructor = 0;
            if (context == null) {
                int i19 = artificialFrame;
                int i20 = ((i19 | 65) << 1) - (i19 ^ 65);
                getARTIFICIAL_FRAME_PACKAGE_NAME = i20 % 128;
                int i21 = i20 % 2;
                Object[] objArr2 = {new int[]{i}, new int[]{i}, new int[1], null};
                int i22 = ~((int) Runtime.getRuntime().maxMemory());
                int i23 = (-469710298) + (((~(936677374 | i22)) | 41946400) * (-828)) + ((i22 | 936677374) * (-828)) + 1820214076;
                int i24 = (i23 << 1) - i23;
                int iOnTransact = CatalystInstanceImpl.InstanceCallback.onTransact();
                int i25 = (i24 * 495) + (i2 * (-493));
                int i26 = ~i2;
                int i27 = ((i26 & i24) | (i24 ^ i26)) * (-988);
                int i28 = (i25 ^ i27) + ((i25 & i27) << 1);
                int i29 = ~i24;
                int i30 = (i2 ^ i29) | (i2 & i29);
                int i31 = ~iOnTransact;
                int i32 = i28 + (((i30 & i31) | (i30 ^ i31)) * 494);
                int i33 = ~i2;
                int i34 = ~((i29 & i33) | (i29 ^ i33));
                int i35 = ~((i31 & i2) | (i31 ^ i2));
                int i36 = (i35 & i34) | (i34 ^ i35);
                int i37 = ~((i24 & i2) | (i24 ^ i2));
                int i38 = -(-(((i37 & i36) | (i36 ^ i37)) * 494));
                int i39 = (i32 ^ i38) + ((i38 & i32) << 1);
                int i40 = (i39 << 13) ^ i39;
                int i41 = i40 >>> 17;
                int i42 = (i40 | i41) & (~(i40 & i41));
                int i43 = i42 << 5;
                ((int[]) objArr2[2])[0] = (i42 | i43) & (~(i42 & i43));
                return objArr2;
            }
            try {
                int i44 = -(-View.MeasureSpec.getMode(0));
                Object[] objArr3 = new Object[1];
                a((i44 & 38) + (i44 | 38), new int[]{1799092661, 23155291, 1781680970, -1082175897, 1504638751, 683320153, 236542451, 1132337704, 1302713485, 1375121380, 822525901, 1422962908, -2141766854, 1734982773, 288731055, -202615391, 1428689355, 1365373235, -959244439, -591873057}, objArr3);
                Object[] objArr4 = (Object[]) Array.newInstance(Class.forName((String) objArr3[0]), 2);
                int i45 = -(-(ViewConfiguration.getJumpTapTimeout() >> 16));
                int i46 = (i45 ^ (-1126677182)) + ((i45 & (-1126677182)) << 1);
                int offsetBefore = TextUtils.getOffsetBefore("", 0);
                int i47 = getARTIFICIAL_FRAME_PACKAGE_NAME + 91;
                artificialFrame = i47 % 128;
                int i48 = i47 % 2;
                short s2 = (short) offsetBefore;
                int i49 = -(-Drawable.resolveOpacity(0, 0));
                byte b2 = (byte) ((i49 ^ 17) + ((i49 & 17) << 1));
                int iResolveOpacity = Drawable.resolveOpacity(0, 0);
                int i50 = artificialFrame;
                int i51 = ((i50 | 11) << 1) - (i50 ^ 11);
                getARTIFICIAL_FRAME_PACKAGE_NAME = i51 % 128;
                int i52 = i51 % 2;
                int iOnTransact2 = CatalystInstanceImpl.InstanceCallback.onTransact();
                int i53 = iResolveOpacity * 860;
                int i54 = (i53 ^ 108108) + ((i53 & 108108) << 1);
                int i55 = -(-(((iResolveOpacity ^ iOnTransact2) | (iResolveOpacity & iOnTransact2)) * (-859)));
                int i56 = (i54 ^ i55) + ((i54 & i55) << 1);
                int i57 = ~iOnTransact2;
                int i58 = ~((i57 ^ iResolveOpacity) | (i57 & iResolveOpacity));
                int i59 = getARTIFICIAL_FRAME_PACKAGE_NAME + 75;
                artificialFrame = i59 % 128;
                int i60 = i59 % 2;
                int i61 = ~iResolveOpacity;
                int i62 = (i61 & 125) | (i61 ^ 125);
                int i63 = ~((i62 & iOnTransact2) | (i62 ^ iOnTransact2));
                int i64 = i56 + (((i58 & i63) | (i58 ^ i63)) * 859);
                int i65 = ~((~iOnTransact2) | 125);
                int i66 = ~((125 & iResolveOpacity) | (125 ^ iResolveOpacity));
                int i67 = -(-(((i65 & i66) | (i65 ^ i66)) * 859));
                int i68 = (i64 & i67) + (i64 | i67);
                int i69 = -View.MeasureSpec.getMode(0);
                int i70 = ((i69 | (-1519531823)) << 1) - (i69 ^ (-1519531823));
                Object[] objArr5 = new Object[1];
                b(i46, s2, b2, i68, i70, objArr5);
                try {
                    try {
                        Object[] objArr6 = {(String) objArr5[0]};
                        int i71 = -(ViewConfiguration.getFadingEdgeLength() >> 16);
                        int i72 = i71 * 595;
                        int i73 = (i72 & (-45106)) + (i72 | (-45106));
                        CatalystInstanceImpl.InstanceCallback.onTransact();
                        int i74 = ~i;
                        int i75 = ~i71;
                        int i76 = ~((i75 & 38) | (i75 ^ 38));
                        int i77 = ~i;
                        int i78 = ~(i77 | 38);
                        int i79 = (-1188) * ((i76 ^ i78) | (i78 & i76));
                        int i80 = (i73 ^ i79) + ((i73 & i79) << 1);
                        int i81 = ~(((-39) ^ i) | ((-39) & i));
                        int i82 = (i76 ^ i81) | (i81 & i76);
                        int i83 = getARTIFICIAL_FRAME_PACKAGE_NAME + 123;
                        int i84 = i83 % 128;
                        artificialFrame = i84;
                        if (i83 % 2 == 0) {
                            int i85 = ~((i74 ^ i71) | (i74 & i71));
                            i4 = i80 >> (594 >> ((i82 ^ i85) | (i82 & i85)));
                            int i86 = ~((-39) | i77);
                            int i87 = ~((i71 & (-39)) | ((-39) ^ i71));
                            i5 = (i87 & i86) | (i86 ^ i87) | i85;
                        } else {
                            int i88 = ~(i77 | i71);
                            int i89 = ((i82 ^ i88) | (i82 & i88)) * 594;
                            i4 = (i80 & i89) + (i89 | i80);
                            int i90 = ~(((-39) & i77) | ((-39) ^ i77));
                            int i91 = ~(((-39) ^ i71) | ((-39) & i71));
                            int i92 = (i90 & i91) | (i90 ^ i91);
                            int i93 = ~((i71 & i74) | (i74 ^ i71));
                            i5 = (i93 & i92) | (i92 ^ i93);
                        }
                        int i94 = i84 + 45;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i94 % 128;
                        if (i94 % 2 != 0) {
                            Object[] objArr7 = new Object[1];
                            a(i4 + (594 >>> i5), new int[]{1799092661, 23155291, 1781680970, -1082175897, 1504638751, 683320153, 236542451, 1132337704, 1302713485, 1375121380, 822525901, 1422962908, -2141766854, 1734982773, 288731055, -202615391, 1428689355, 1365373235, -959244439, -591873057}, objArr7);
                            Class<?> cls = Class.forName((String) objArr7[0]);
                            Class<?>[] clsArr = new Class[0];
                            clsArr[1] = String.class;
                            objArr4[0] = cls.getDeclaredConstructor(clsArr).newInstance(objArr6);
                            iBlue = Color.blue(1);
                        } else {
                            Object[] objArr8 = new Object[1];
                            a(i4 + (594 * i5), new int[]{1799092661, 23155291, 1781680970, -1082175897, 1504638751, 683320153, 236542451, 1132337704, 1302713485, 1375121380, 822525901, 1422962908, -2141766854, 1734982773, 288731055, -202615391, 1428689355, 1365373235, -959244439, -591873057}, objArr8);
                            objArr4[0] = Class.forName((String) objArr8[0]).getDeclaredConstructor(String.class).newInstance(objArr6);
                            iBlue = Color.blue(0);
                        }
                        int i95 = ((-1126677151) ^ iBlue) + ((iBlue & (-1126677151)) << 1);
                        short sMyTid = (short) (Process.myTid() >> 22);
                        int i96 = -(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                        byte b3 = (byte) (((i96 | 13) << 1) - (i96 ^ 13));
                        int i97 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                        int iOnTransact3 = CatalystInstanceImpl.InstanceCallback.onTransact();
                        int i98 = artificialFrame;
                        int i99 = (i98 ^ 23) + ((i98 & 23) << 1);
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i99 % 128;
                        int i100 = i99 % 2;
                        int i101 = ~iOnTransact3;
                        int i102 = ~((126 ^ i101) | (126 & i101));
                        int i103 = ~(126 | i97);
                        int i104 = (i102 ^ i103) | (i103 & i102);
                        int i105 = ~iOnTransact3;
                        int i106 = (~((i105 ^ i97) | (i105 & i97))) | i104;
                        int i107 = ~i97;
                        int i108 = (i107 ^ (-127)) | (i107 & (-127));
                        int i109 = ~((i108 ^ iOnTransact3) | (i108 & iOnTransact3));
                        int i110 = (((i97 * (-589)) - 75057) - (~(((i106 ^ i109) | (i106 & i109)) * 590))) - 1;
                        int i111 = (~((126 & i105) | (126 ^ i105))) | (~((126 ^ i97) | (126 & i97)));
                        int i112 = ~((i97 & i101) | (i101 ^ i97));
                        int i113 = ((i111 & i112) | (i111 ^ i112)) * (-1180);
                        int i114 = ((i110 | i113) << 1) - (i113 ^ i110);
                        int i115 = i98 + 1;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i115 % 128;
                        int i116 = i115 % 2;
                        int i117 = ~((i107 & i105) | (i107 ^ i105));
                        int i118 = ~((i105 ^ (-127)) | (i105 & (-127)));
                        try {
                            if (i116 != 0) {
                                int i119 = (i117 & i118) | (i117 ^ i118);
                                int i120 = i114 - (((i119 | 590) << 1) - (i119 ^ 590));
                                Object[] objArr9 = new Object[1];
                                b(i95, sMyTid, b3, i120, TextUtils.getOffsetBefore("", 0) * (-1519531823), objArr9);
                                obj = objArr9[0];
                            } else {
                                int i121 = (i117 | i118) * 590;
                                int i122 = (i114 ^ i121) + ((i121 & i114) << 1);
                                int i123 = -(-TextUtils.getOffsetBefore("", 0));
                                int i124 = (i123 & (-1519531823)) + (i123 | (-1519531823));
                                Object[] objArr10 = new Object[1];
                                b(i95, sMyTid, b3, i122, i124, objArr10);
                                obj = objArr10[0];
                            }
                            String str = (String) obj;
                            int i125 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                            declaredConstructor = 1;
                            int i126 = (i125 ^ 115) + ((i125 & 115) << 1);
                            artificialFrame = i126 % 128;
                            int i127 = i126 % 2;
                            try {
                                char c3 = '0';
                                int iLastIndexOf = TextUtils.lastIndexOf("", '0');
                                Object[] objArr11 = new Object[1];
                                a((iLastIndexOf & 39) + (iLastIndexOf | 39), new int[]{1799092661, 23155291, 1781680970, -1082175897, 1504638751, 683320153, 236542451, 1132337704, 1302713485, 1375121380, 822525901, 1422962908, -2141766854, 1734982773, 288731055, -202615391, 1428689355, 1365373235, -959244439, -591873057}, objArr11);
                                declaredConstructor = Class.forName((String) objArr11[0]).getDeclaredConstructor(String.class);
                                objArr4[1] = declaredConstructor.newInstance(str);
                                try {
                                    int i128 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                                    int i129 = artificialFrame;
                                    int i130 = i129 + 85;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i130 % 128;
                                    int i131 = i130 % 2;
                                    int i132 = ~((1126677120 ^ i) | (1126677120 & i));
                                    int i133 = ~(((-1126677121) & i128) | (i128 ^ (-1126677121)));
                                    int i134 = ((i128 * (-501)) - (-217091209)) + ((-502) * ((i132 & i133) | (i132 ^ i133)));
                                    int i135 = ~((1126677120 ^ i74) | (1126677120 & i74) | i128);
                                    int i136 = ((i129 | 125) << 1) - (i129 ^ 125);
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i136 % 128;
                                    int i137 = i136 % 2;
                                    int i138 = (-502) * i135;
                                    int i139 = ~i128;
                                    int i140 = (i134 & i138) + (i134 | i138) + (((~((i139 & i) | (i139 ^ i))) | 1126677120) * TypedValues.PositionType.TYPE_DRAWPATH);
                                    short defaultSize = (short) View.getDefaultSize(0, 0);
                                    int packedPositionType2 = ExpandableListView.getPackedPositionType(0L);
                                    int i141 = -(-(ViewConfiguration.getScrollDefaultDelay() >> 16));
                                    Object[] objArr12 = new Object[1];
                                    b(i140, defaultSize, (byte) (((packedPositionType2 | 107) << 1) - (packedPositionType2 ^ 107)), (i141 & (-126)) + (i141 | (-126)), (-1519531793) - TextUtils.getCapsMode("", 0, 0), objArr12);
                                    Class<?> cls2 = Class.forName((String) objArr12[0]);
                                    int i142 = -(ViewConfiguration.getScrollBarSize() >> 8);
                                    int iOnTransact4 = CatalystInstanceImpl.InstanceCallback.onTransact();
                                    int i143 = i142 * (-949);
                                    int i144 = (i143 & (-230291651)) + (i143 | (-230291651));
                                    int i145 = ~iOnTransact4;
                                    int i146 = ~((1126677096 & i145) | (1126677096 ^ i145));
                                    int i147 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                    int i148 = ((i147 | 89) << 1) - (i147 ^ 89);
                                    artificialFrame = i148 % 128;
                                    int i149 = i148 % 2;
                                    int i150 = ~i142;
                                    int i151 = ~((i150 & iOnTransact4) | (i150 ^ iOnTransact4));
                                    int i152 = (i144 - (~(-(-(1900 * ((i146 & i151) | (i146 ^ i151))))))) - 1;
                                    int i153 = ~((i145 ^ i142) | (i145 & i142));
                                    int i154 = ~(((-1126677097) ^ iOnTransact4) | ((-1126677097) & iOnTransact4));
                                    int i155 = ~((i145 & (-1126677097)) | (i145 ^ (-1126677097)));
                                    int i156 = ~((i142 & iOnTransact4) | (i142 ^ iOnTransact4));
                                    int i157 = i152 + (((i153 ^ i154) | (i153 & i154)) * (-950)) + (((i156 & i155) | (i155 ^ i156)) * 950);
                                    short s3 = (short) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                                    int i158 = -MotionEvent.axisFromString("");
                                    byte b4 = (byte) ((i158 & b.f40o) + (i158 | b.f40o));
                                    int i159 = (-127) - (~(ViewConfiguration.getPressedStateDuration() >> 16));
                                    int i160 = -(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                                    Object[] objArr13 = new Object[1];
                                    b(i157, s3, b4, i159, (i160 & (-1519531786)) + (i160 | (-1519531786)), objArr13);
                                    declaredConstructor = (String) objArr13[0];
                                    Object objInvoke2 = cls2.getMethod(declaredConstructor, null).invoke(context, null);
                                    int i161 = getARTIFICIAL_FRAME_PACKAGE_NAME + 61;
                                    int i162 = i161 % 128;
                                    artificialFrame = i162;
                                    int i163 = i161 % 2;
                                    int i164 = (i162 & 107) + (i162 | 107);
                                    declaredConstructor = i164 % 128;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = declaredConstructor;
                                    int i165 = i164 % 2;
                                    try {
                                        int i166 = (-1126677122) - (~(-(-(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)))));
                                        short s4 = (short) ((-2) - ((-(-(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)))) ^ (-1)));
                                        byte bGreen = (byte) (107 - Color.green(0));
                                        int i167 = -View.getDefaultSize(0, 0);
                                        Object[] objArr14 = new Object[1];
                                        b(i166, s4, bGreen, ((i167 | (-126)) << 1) - (i167 ^ (-126)), (-1519531794) - (~(-KeyEvent.normalizeMetaState(0))), objArr14);
                                        Class<?> cls3 = Class.forName((String) objArr14[0]);
                                        int i168 = -(-(ViewConfiguration.getTapTimeout() >> 16));
                                        Object[] objArr15 = new Object[1];
                                        a(((i168 | 14) << 1) - (i168 ^ 14), new int[]{1582280154, 739807362, -1343046991, 826799986, -1701670996, 862953384, 1168547335, -1651556169}, objArr15);
                                        declaredConstructor = 0;
                                        declaredConstructor = 0;
                                        try {
                                            declaredConstructor = new Object[]{cls3.getMethod((String) objArr15[0], null).invoke(context, null), 64};
                                            int iRgb = Color.rgb(0, 0, 0) - 1109899864;
                                            short s5 = (short) ((-TextUtils.indexOf((CharSequence) "", '0', 0, 0)) - 1);
                                            int iResolveSizeAndState = View.resolveSizeAndState(0, 0, 0);
                                            int i169 = -TextUtils.getCapsMode("", 0, 0);
                                            Object[] objArr16 = new Object[1];
                                            b(iRgb, s5, (byte) ((iResolveSizeAndState & (-79)) + (iResolveSizeAndState | (-79))), ((i169 | (-126)) << 1) - (i169 ^ (-126)), (-1519531793) - (ViewConfiguration.getScrollBarSize() >> 8), objArr16);
                                            Class<?> cls4 = Class.forName((String) objArr16[0]);
                                            int mode = View.MeasureSpec.getMode(0);
                                            int i170 = ((mode | (-1126677047)) << 1) - (mode ^ (-1126677047));
                                            short absoluteGravity = (short) Gravity.getAbsoluteGravity(0, 0);
                                            int i171 = -(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                                            int i172 = (i171 * 303) + 26187;
                                            int i173 = ~i171;
                                            int i174 = ~(i173 | i77 | (-87));
                                            int i175 = (i171 ^ (-87)) | (i171 & (-87));
                                            int i176 = ~((i175 ^ i) | (i175 & i));
                                            int i177 = -(-(((i174 ^ i176) | (i174 & i176)) * (-302)));
                                            int i178 = (i172 & i177) + (i172 | i177);
                                            int i179 = (i173 ^ (-87)) | (i173 & (-87));
                                            int i180 = -(-((~((i179 & i) | (i179 ^ i))) * (-604)));
                                            int i181 = (i178 & i180) + (i180 | i178);
                                            int i182 = ~((i171 & 86) | (86 ^ i171));
                                            int i183 = ~((i ^ (-87)) | (i & (-87)));
                                            int i184 = -(-(((i182 & i183) | (i182 ^ i183)) * 302));
                                            byte b5 = (byte) ((i181 & i184) + (i184 | i181));
                                            int i185 = (-127) - (~(Process.myPid() >> 22));
                                            int i186 = -(-(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)));
                                            Object[] objArr17 = new Object[1];
                                            b(i170, absoluteGravity, b5, i185, (i186 & (-1519531787)) + (i186 | (-1519531787)), objArr17);
                                            Object objInvoke3 = cls4.getMethod((String) objArr17[0], String.class, Integer.TYPE).invoke(objInvoke2, declaredConstructor);
                                            int i187 = -(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                                            int i188 = (i187 & (-1126677032)) + (i187 | (-1126677032));
                                            short scrollDefaultDelay = (short) (ViewConfiguration.getScrollDefaultDelay() >> 16);
                                            int i189 = -((byte) KeyEvent.getModifierMetaStateMask());
                                            int i190 = i189 * (-716);
                                            int i191 = ((i190 | (-94710)) << 1) - (i190 ^ (-94710));
                                            int i192 = ~i189;
                                            int i193 = -(-((i192 | (-66)) * (-1434)));
                                            int i194 = (i191 ^ i193) + ((i193 & i191) << 1);
                                            int i195 = ~((i77 ^ (-66)) | (i77 & (-66)));
                                            int i196 = ~(i189 | (-66));
                                            int i197 = (i195 & i196) | (i195 ^ i196);
                                            int i198 = (i192 & 65) | (i192 ^ 65);
                                            int i199 = ~((i198 & i) | (i198 ^ i));
                                            int i200 = (i194 - (~(-(-(((i199 & i197) | (i197 ^ i199)) * 717))))) - 1;
                                            int i201 = ~i189;
                                            int i202 = (i201 & 65) | (i201 ^ 65);
                                            int i203 = (~((i202 & i77) | (i202 ^ i77))) | i196;
                                            int i204 = ~((i ^ (-66)) | (i & (-66)));
                                            int i205 = -(-(((i203 & i204) | (i203 ^ i204)) * 717));
                                            int i206 = -(-(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                                            Object[] objArr18 = new Object[1];
                                            b(i188, scrollDefaultDelay, (byte) ((i200 & i205) + (i205 | i200)), (i206 ^ (-127)) + ((i206 & (-127)) << 1), (-1519531794) - (~(-(-Color.blue(0)))), objArr18);
                                            Class<?> cls5 = Class.forName((String) objArr18[0]);
                                            int i207 = (-1126677004) - (~(-ExpandableListView.getPackedPositionType(0L)));
                                            short deadChar = (short) KeyEvent.getDeadChar(0, 0);
                                            int iIndexOf = TextUtils.indexOf("", "");
                                            int i208 = iIndexOf * (-1335);
                                            int i209 = (i208 ^ (-77372)) + ((i208 & (-77372)) << 1);
                                            int i210 = (iIndexOf ^ i) | (iIndexOf & i);
                                            int i211 = i209 + (((~i210) | (-117)) * (-668));
                                            int i212 = ~((-117) | i);
                                            int i213 = -(-(((iIndexOf & i212) | (iIndexOf ^ i212)) * 1336));
                                            int i214 = (i211 ^ i213) + ((i213 & i211) << 1);
                                            int i215 = -(-(((i210 ^ (-117)) | (i210 & (-117))) * 668));
                                            byte b6 = (byte) ((i214 & i215) + (i215 | i214));
                                            int i216 = -(-TextUtils.getOffsetAfter("", 0));
                                            int i217 = (i216 & (-126)) + (i216 | (-126));
                                            int i218 = -(ViewConfiguration.getLongPressTimeout() >> 16);
                                            int i219 = i218 * 829;
                                            int i220 = (i219 & (-1266423747)) + (i219 | (-1266423747));
                                            int i221 = ~i218;
                                            int i222 = ~((i221 & 1519531774) | (i221 ^ 1519531774));
                                            int i223 = i77 | i218;
                                            int i224 = ~((i223 ^ (-1519531775)) | (i223 & (-1519531775)));
                                            int i225 = i220 + (((i222 ^ i224) | (i222 & i224)) * (-828));
                                            int i226 = (i218 ^ (-1519531775)) | (i218 & (-1519531775));
                                            int i227 = (i225 - (~(((i226 & i77) | (i226 ^ i77)) * (-828)))) - 1;
                                            int i228 = -(-((~(i218 | (-1519531775))) * 828));
                                            int i229 = (i227 & i228) + (i228 | i227);
                                            Object[] objArr19 = new Object[1];
                                            b(i207, deadChar, b6, i217, i229, objArr19);
                                            Object[] objArr20 = (Object[]) cls5.getField((String) objArr19[0]).get(objInvoke3);
                                            int length = objArr20.length;
                                            int i230 = 0;
                                            ?? r0 = objArr20;
                                            while (true) {
                                                if (i230 < length) {
                                                    declaredConstructor = r0[i230];
                                                    int i231 = -View.combineMeasuredStates(0, 0);
                                                    int i232 = i231 * 370;
                                                    int i233 = i231 | (-1126676993);
                                                    int i234 = (i232 & (-258659698)) + (i232 | (-258659698)) + (((i233 & i77) | (i233 ^ i77)) * (-369));
                                                    int i235 = ~i231;
                                                    int i236 = -(-(((~((i235 & i77) | (i235 ^ i77))) | (-1126676993)) * (-369)));
                                                    int i237 = (i234 ^ i236) + ((i236 & i234) << 1);
                                                    int i238 = ~(1126676992 | i231);
                                                    int i239 = ~((i231 ^ i) | (i231 & i));
                                                    int i240 = (i238 ^ i239) | (i238 & i239);
                                                    int i241 = ~i231;
                                                    int i242 = (i241 & i77) | (i241 ^ i77);
                                                    int i243 = ~((i242 & (-1126676993)) | (i242 ^ (-1126676993)));
                                                    int i244 = (i237 - (~(((i243 & i240) | (i240 ^ i243)) * 369))) - 1;
                                                    short defaultSize2 = (short) View.getDefaultSize(0, 0);
                                                    int i245 = -(ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                                                    int mirror = AndroidCharacter.getMirror(c3) - 174;
                                                    int maximumDrawingCacheSize = ViewConfiguration.getMaximumDrawingCacheSize() >> 24;
                                                    int iOnTransact5 = CatalystInstanceImpl.InstanceCallback.onTransact();
                                                    int i246 = (maximumDrawingCacheSize * 881) + 1322278790;
                                                    int i247 = ~maximumDrawingCacheSize;
                                                    ?? r33 = r0;
                                                    int i248 = ~(i247 | 1519531801);
                                                    int i249 = ~((i247 ^ iOnTransact5) | (i247 & iOnTransact5));
                                                    int i250 = (i248 ^ i249) | (i248 & i249);
                                                    int i251 = ~((1519531801 ^ iOnTransact5) | (1519531801 & iOnTransact5));
                                                    int i252 = -(-(((i250 ^ i251) | (i250 & i251)) * (-880)));
                                                    int i253 = ((i246 | i252) << 1) - (i252 ^ i246);
                                                    int i254 = ~maximumDrawingCacheSize;
                                                    int i255 = ~iOnTransact5;
                                                    int i256 = ~((i254 ^ i255) | (i254 & i255));
                                                    int i257 = (i256 ^ (-1519531802)) | (i256 & (-1519531802));
                                                    int i258 = (maximumDrawingCacheSize ^ iOnTransact5) | (maximumDrawingCacheSize & iOnTransact5);
                                                    int i259 = ~i258;
                                                    int i260 = -(-(((i257 & i259) | (i257 ^ i259)) * (-880)));
                                                    int i261 = (((i253 ^ i260) + ((i260 & i253) << 1)) - (~(-(-((~i258) * 880))))) - 1;
                                                    Object[] objArr21 = new Object[1];
                                                    b(i244, defaultSize2, (byte) ((i245 & (-5)) + (i245 | (-5))), mirror, i261, objArr21);
                                                    try {
                                                        Object[] objArr22 = {(String) objArr21[0]};
                                                        int offsetBefore2 = TextUtils.getOffsetBefore("", 0);
                                                        Object[] objArr23 = new Object[1];
                                                        a(((offsetBefore2 | 37) << 1) - (offsetBefore2 ^ 37), new int[]{1799092661, 23155291, -2044264295, 980582368, 1740386176, 177810427, -662855990, 1334442412, 1961116101, 238885966, 461867789, 1016317725, 1353359652, 1371242959, 242583144, -433126523, 1753824189, -1847170993, -1638800049, 1098668983}, objArr23);
                                                        Class<?> cls6 = Class.forName((String) objArr23[0]);
                                                        int i262 = -(ViewConfiguration.getKeyRepeatDelay() >> 16);
                                                        int i263 = (i262 & (-1126676988)) + (i262 | (-1126676988));
                                                        short maximumDrawingCacheSize2 = (short) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                                                        byte bitsPerPixel = (byte) (ImageFormat.getBitsPerPixel(0) + 56);
                                                        int i264 = -TextUtils.lastIndexOf("", '0', 0);
                                                        int i265 = (i264 & (-127)) + (i264 | (-127));
                                                        int packedPositionType3 = ExpandableListView.getPackedPositionType(0L);
                                                        int i266 = packedPositionType3 * 624;
                                                        int i267 = (i266 ^ 255966394) + ((i266 & 255966394) << 1);
                                                        int i268 = 1519531786 | packedPositionType3;
                                                        int i269 = (i267 - (~(-(-((~((i268 & i) | (i268 ^ i))) * 623))))) - 1;
                                                        int i270 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                        int i271 = (i270 & 123) + (i270 | 123);
                                                        artificialFrame = i271 % 128;
                                                        int i272 = i271 % 2;
                                                        int i273 = ~packedPositionType3;
                                                        int i274 = -(-((-623) * ((~((i273 ^ (-1519531787)) | (i273 & (-1519531787)))) | i74)));
                                                        int i275 = (i269 ^ i274) + ((i274 & i269) << 1);
                                                        int i276 = ~((1519531786 ^ packedPositionType3) | (1519531786 & packedPositionType3));
                                                        int i277 = ~((1519531786 ^ i) | (1519531786 & i));
                                                        int i278 = (i276 ^ i277) | (i277 & i276);
                                                        int i279 = ~((packedPositionType3 & i) | (packedPositionType3 ^ i));
                                                        int i280 = -(-(((i279 & i278) | (i278 ^ i279)) * 623));
                                                        int i281 = (i275 ^ i280) + ((i280 & i275) << 1);
                                                        Object[] objArr24 = new Object[1];
                                                        b(i263, maximumDrawingCacheSize2, bitsPerPixel, i265, i281, objArr24);
                                                        Object objInvoke4 = cls6.getMethod((String) objArr24[0], String.class).invoke(null, objArr22);
                                                        try {
                                                            Object[] objArr25 = new Object[1];
                                                            a(27 - ((byte) KeyEvent.getModifierMetaStateMask()), new int[]{-1222722970, -2101226585, -180008945, 1278137955, -1473021833, -1230635954, 220295624, -2087171122, 1365819760, 699017953, 2011070401, 1480529390, 1565171983, -1034402566}, objArr25);
                                                            Class<?> cls7 = Class.forName((String) objArr25[0]);
                                                            int iIndexOf2 = (-1126676977) - TextUtils.indexOf("", "");
                                                            short sIndexOf = (short) TextUtils.indexOf("", "", 0, 0);
                                                            int i282 = -Color.red(0);
                                                            int iOnTransact6 = CatalystInstanceImpl.InstanceCallback.onTransact();
                                                            int i283 = (i282 * (-958)) - 81430;
                                                            int i284 = artificialFrame + 1;
                                                            int i285 = length;
                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i284 % 128;
                                                            if (i284 % 2 != 0) {
                                                                int i286 = ~iOnTransact6;
                                                                int i287 = ~((-86) | i286);
                                                                int i288 = ~i282;
                                                                int i289 = ~((i288 ^ iOnTransact6) | (i288 & iOnTransact6));
                                                                int i290 = (i287 ^ i289) | (i287 & i289);
                                                                int i291 = ~((i286 ^ i282) | (i286 & i282));
                                                                i6 = i283 * (959 / ((i290 & i291) | (i290 ^ i291)));
                                                            } else {
                                                                int i292 = ~iOnTransact6;
                                                                int i293 = ~(((-86) & i292) | ((-86) ^ i292));
                                                                int i294 = ~i282;
                                                                int i295 = -(-(((~((i292 & i282) | (i292 ^ i282))) | i293 | (~((i294 ^ iOnTransact6) | (i294 & iOnTransact6)))) * 959));
                                                                i6 = (i283 ^ i295) + ((i295 & i283) << 1);
                                                            }
                                                            int i296 = (i6 - (~(-(-((-959) * (~((i282 ^ 85) | (i282 & 85)))))))) - 1;
                                                            int i297 = ~((~i282) | (~iOnTransact6));
                                                            int i298 = ~(((-86) & iOnTransact6) | ((-86) ^ iOnTransact6));
                                                            int i299 = -(-(((i297 & i298) | (i297 ^ i298) | (~((i282 & iOnTransact6) | (i282 ^ iOnTransact6)))) * 959));
                                                            byte b7 = (byte) ((i296 ^ i299) + ((i299 & i296) << 1));
                                                            int i300 = -Process.getGidForName("");
                                                            int i301 = ((i300 | (-127)) << 1) - (i300 ^ (-127));
                                                            int i302 = -(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                                                            int iOnTransact7 = CatalystInstanceImpl.InstanceCallback.onTransact();
                                                            int i303 = ~((~i302) | 1519531773);
                                                            int i304 = ~(1519531773 | iOnTransact7);
                                                            int i305 = (i303 ^ i304) | (i303 & i304);
                                                            int i306 = ~iOnTransact7;
                                                            int i307 = (i306 ^ i302) | (i306 & i302);
                                                            int i308 = ~((i307 ^ (-1519531774)) | (i307 & (-1519531774)));
                                                            int i309 = ((((i302 * 471) + 1560072878) + (((i302 ^ (-1519531774)) | (i302 & (-1519531774))) * (-470))) - (~(((i305 ^ i308) | (i305 & i308)) * (-470)))) - 1;
                                                            int i310 = 1519531773 | i302;
                                                            int i311 = ~((i310 & iOnTransact7) | (i310 ^ iOnTransact7));
                                                            int i312 = -(-(((i311 & i308) | (i311 ^ i308)) * 470));
                                                            int i313 = (i309 ^ i312) + ((i312 & i309) << 1);
                                                            Object[] objArr26 = new Object[1];
                                                            b(iIndexOf2, sIndexOf, b7, i301, i313, objArr26);
                                                            try {
                                                                Object[] objArr27 = {new ByteArrayInputStream((byte[]) cls7.getMethod((String) objArr26[0], null).invoke(declaredConstructor, null))};
                                                                int i314 = -(-(ViewConfiguration.getTapTimeout() >> 16));
                                                                Object[] objArr28 = new Object[1];
                                                                a((i314 ^ 37) + ((i314 & 37) << 1), new int[]{1799092661, 23155291, -2044264295, 980582368, 1740386176, 177810427, -662855990, 1334442412, 1961116101, 238885966, 461867789, 1016317725, 1353359652, 1371242959, 242583144, -433126523, 1753824189, -1847170993, -1638800049, 1098668983}, objArr28);
                                                                Class<?> cls8 = Class.forName((String) objArr28[0]);
                                                                int i315 = -Color.blue(0);
                                                                int i316 = (i315 ^ (-1126676966)) + ((i315 & (-1126676966)) << 1);
                                                                short sMyTid2 = (short) (Process.myTid() >> 22);
                                                                declaredConstructor = 0;
                                                                int offsetAfter = TextUtils.getOffsetAfter("", 0);
                                                                int iOnTransact8 = CatalystInstanceImpl.InstanceCallback.onTransact();
                                                                int i317 = -(-(((~iOnTransact8) | 1386263103) * (-757)));
                                                                int i318 = ((-1658931554) ^ i317) + ((i317 & (-1658931554)) << 1);
                                                                int i319 = -(-((~(((-17239297) & iOnTransact8) | ((-17239297) ^ iOnTransact8))) * 1514));
                                                                int i320 = (i318 ^ i319) + ((i319 & i318) << 1);
                                                                int i321 = ~iOnTransact8;
                                                                int i322 = (i320 - (~(((~(iOnTransact8 | 1403502399)) | ((~((i321 & (-1091022616)) | ((-1091022616) ^ i321))) | 1073783319)) * 757))) - 1;
                                                                int i323 = ~(128180952 | i);
                                                                int i324 = (i323 & 943983904) | (943983904 ^ i323);
                                                                int i325 = ~(((-977653113) & i) | ((-977653113) ^ i));
                                                                int i326 = ((i324 & i325) | (i324 ^ i325)) * (-744);
                                                                int i327 = ((-202376889) ^ i326) + ((i326 & (-202376889)) << 1);
                                                                int i328 = ((94511744 & i77) | (i77 ^ 94511744)) * 744;
                                                                int i329 = ((i327 | i328) << 1) - (i328 ^ i327);
                                                                int i330 = -(-((((-943983905) & i) | ((-943983905) ^ i)) * 744));
                                                                if (i322 > ((i329 | i330) << 1) - (i330 ^ i329)) {
                                                                    byte b8 = (byte) ((-5) >> offsetAfter);
                                                                    int i331 = -Color.rgb(1, 1, 0);
                                                                    int i332 = (i331 ^ 16777090) + ((i331 & 16777090) << 1);
                                                                    packedPositionType = ExpandableListView.getPackedPositionType(0L);
                                                                    b = b8;
                                                                    i8 = i332;
                                                                    i7 = 1;
                                                                } else {
                                                                    byte b9 = (byte) (((offsetAfter | (-5)) << 1) - (offsetAfter ^ (-5)));
                                                                    int i333 = -(-Color.rgb(0, 0, 0));
                                                                    i7 = 1;
                                                                    int i334 = (i333 ^ 16777090) + ((i333 & 16777090) << 1);
                                                                    packedPositionType = ExpandableListView.getPackedPositionType(0L);
                                                                    b = b9;
                                                                    i8 = i334;
                                                                }
                                                                int i335 = packedPositionType * (-1939);
                                                                int i336 = (i335 ^ 2003384647) + ((i335 & 2003384647) << i7);
                                                                int i337 = ~((1519531786 & packedPositionType) | (1519531786 ^ packedPositionType));
                                                                int i338 = ~((i77 ^ (-1519531787)) | (i77 & (-1519531787)));
                                                                int i339 = (i336 - (~(((i337 & i338) | (i337 ^ i338)) * (-970)))) - 1;
                                                                int i340 = -(-((~((~packedPositionType) | (-1519531787))) * 1940));
                                                                int i341 = (i339 ^ i340) + ((i340 & i339) << 1);
                                                                int i342 = ~((~packedPositionType) | 1519531786);
                                                                int i343 = ~((i77 ^ (-1519531787)) | ((-1519531787) & i77));
                                                                int i344 = -(-(((i342 & i343) | (i342 ^ i343)) * 970));
                                                                int i345 = (i341 ^ i344) + ((i344 & i341) << 1);
                                                                Object[] objArr29 = new Object[1];
                                                                b(i316, sMyTid2, b, i8, i345, objArr29);
                                                                Method method = cls8.getMethod((String) objArr29[0], InputStream.class);
                                                                int i346 = getARTIFICIAL_FRAME_PACKAGE_NAME + 105;
                                                                artificialFrame = i346 % 128;
                                                                if (i346 % 2 == 0) {
                                                                    objInvoke = method.invoke(objInvoke4, objArr27);
                                                                    int length2 = objArr4.length;
                                                                    i9 = 1;
                                                                } else {
                                                                    objInvoke = method.invoke(objInvoke4, objArr27);
                                                                    int length3 = objArr4.length;
                                                                    i9 = 0;
                                                                }
                                                                while (true) {
                                                                    if (i9 < 2) {
                                                                        Object obj2 = objArr4[i9];
                                                                        int i347 = artificialFrame;
                                                                        int i348 = (i347 ^ 39) + ((i347 & 39) << 1);
                                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i348 % 128;
                                                                        declaredConstructor = i348 % 2;
                                                                        try {
                                                                            int iNormalizeMetaState = KeyEvent.normalizeMetaState(0) - 1126676947;
                                                                            declaredConstructor = Color.argb(0, 0, 0, 0);
                                                                            int i349 = artificialFrame + 105;
                                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i349 % 128;
                                                                            if (i349 % 2 != 0) {
                                                                                i12 = 69;
                                                                                s = (short) declaredConstructor;
                                                                                keyRepeatDelay = (byte) (32 >>> (ViewConfiguration.getKeyRepeatDelay() % 93));
                                                                                c = '0';
                                                                                i11 = 0;
                                                                                i10 = 1;
                                                                            } else {
                                                                                short s6 = (short) declaredConstructor;
                                                                                int i350 = -(-(ViewConfiguration.getKeyRepeatDelay() >> 16));
                                                                                i10 = 1;
                                                                                s = s6;
                                                                                keyRepeatDelay = (byte) ((i350 ^ WebSocketProtocol.PAYLOAD_SHORT) + ((i350 & WebSocketProtocol.PAYLOAD_SHORT) << 1));
                                                                                c = '0';
                                                                                i11 = 0;
                                                                                i12 = -127;
                                                                            }
                                                                            int i351 = -TextUtils.lastIndexOf("", c, i11, i11);
                                                                            int i352 = ((i12 | i351) << i10) - (i351 ^ i12);
                                                                            int edgeSlop = ViewConfiguration.getEdgeSlop() >> 16;
                                                                            int i353 = ((edgeSlop | (-1519531784)) << i10) - (edgeSlop ^ (-1519531784));
                                                                            Object[] objArr30 = new Object[i10];
                                                                            b(iNormalizeMetaState, s, keyRepeatDelay, i352, i353, objArr30);
                                                                            Class<?> cls9 = Class.forName((String) objArr30[0]);
                                                                            Object[] objArr31 = new Object[1];
                                                                            a(22 - (~(-(ViewConfiguration.getPressedStateDuration() >> 16))), new int[]{-42097795, -598117062, -1558840494, -879388456, -988973208, 1066808237, 185065741, 1042104012, 177703628, -15268328, -1385703372, 420904002}, objArr31);
                                                                            Object objInvoke5 = cls9.getMethod((String) objArr31[0], null).invoke(objInvoke, null);
                                                                            int i354 = artificialFrame + 65;
                                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i354 % 128;
                                                                            if (i354 % 2 != 0) {
                                                                                boolean zEquals = obj2.equals(objInvoke5);
                                                                                int i355 = 45 / 0;
                                                                                i13 = 1;
                                                                                if (!(!zEquals)) {
                                                                                    int i356 = artificialFrame;
                                                                                    i14 = i356 + 95;
                                                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i14 % 128;
                                                                                    if (i14 % 2 != 0) {
                                                                                        objArr = new Object[3];
                                                                                        objArr[1] = new int[0];
                                                                                        objArr[0] = new int[0];
                                                                                        i15 = i;
                                                                                    } else {
                                                                                        i15 = (i & (-2)) | (i77 & 1);
                                                                                        objArr = new Object[4];
                                                                                        objArr[0] = new int[1];
                                                                                        objArr[1] = new int[1];
                                                                                    }
                                                                                    i16 = (i356 & 79) + (i356 | 79);
                                                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i16 % 128;
                                                                                    if (i16 % 2 != 0) {
                                                                                        c2 = 1;
                                                                                        objArr[2] = new int[1];
                                                                                        i17 = 38;
                                                                                    } else {
                                                                                        c2 = 1;
                                                                                        objArr[2] = new int[1];
                                                                                        i17 = 16;
                                                                                    }
                                                                                    ((int[]) objArr[0])[0] = i;
                                                                                    ((int[]) objArr[c2])[0] = i15;
                                                                                    objArr[3] = null;
                                                                                    int i357 = 1647719580 + (((~((-6603297) | i77)) | (-972020479)) * (-591)) + (((-6603297) | i) * 591);
                                                                                    int i358 = -(-i17);
                                                                                    int i359 = ((i357 | i358) << 1) - (i358 ^ i357);
                                                                                    int i360 = i359 * 522;
                                                                                    int i361 = i2 * (-520);
                                                                                    int i362 = (((i360 | i361) << 1) - (i360 ^ i361)) + (((~((i74 ^ i2) | (i74 & i2))) | i359) * (-1042));
                                                                                    int i363 = -(-(((i2 ^ i) | (i2 & i)) * 521));
                                                                                    int i364 = (i362 ^ i363) + ((i363 & i362) << 1);
                                                                                    int i365 = ~i359;
                                                                                    int i366 = (~((i365 & i) | (i365 ^ i))) | (~((~i2) | i365));
                                                                                    int i367 = i359 | i77;
                                                                                    int i368 = ~((i367 & i2) | (i367 ^ i2));
                                                                                    int i369 = i364 + (((i366 & i368) | (i366 ^ i368)) * 521);
                                                                                    int i370 = i369 << 13;
                                                                                    int i371 = (i370 & (~i369)) | ((~i370) & i369);
                                                                                    int i372 = i371 >>> 17;
                                                                                    int i373 = ((~i371) & i372) | ((~i372) & i371);
                                                                                    int i374 = i373 << 5;
                                                                                    ((int[]) objArr[2])[0] = (i373 | i374) & (~(i373 & i374));
                                                                                    return objArr;
                                                                                }
                                                                                int i375 = i9 - 56;
                                                                                i9 = ((i375 & 57) << i13) + (i375 ^ 57);
                                                                            } else {
                                                                                i13 = 1;
                                                                                if (obj2.equals(objInvoke5)) {
                                                                                    int i3510 = artificialFrame;
                                                                                    i14 = i3510 + 95;
                                                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i14 % 128;
                                                                                    if (i14 % 2 != 0) {
                                                                                        objArr = new Object[3];
                                                                                        objArr[1] = new int[0];
                                                                                        objArr[0] = new int[0];
                                                                                        i15 = i;
                                                                                    } else {
                                                                                        i15 = (i & (-2)) | (i77 & 1);
                                                                                        objArr = new Object[4];
                                                                                        objArr[0] = new int[1];
                                                                                        objArr[1] = new int[1];
                                                                                    }
                                                                                    i16 = (i3510 & 79) + (i3510 | 79);
                                                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i16 % 128;
                                                                                    if (i16 % 2 != 0) {
                                                                                        c2 = 1;
                                                                                        objArr[2] = new int[1];
                                                                                        i17 = 38;
                                                                                    } else {
                                                                                        c2 = 1;
                                                                                        objArr[2] = new int[1];
                                                                                        i17 = 16;
                                                                                    }
                                                                                    ((int[]) objArr[0])[0] = i;
                                                                                    ((int[]) objArr[c2])[0] = i15;
                                                                                    objArr[3] = null;
                                                                                    int i3511 = 1647719580 + (((~((-6603297) | i77)) | (-972020479)) * (-591)) + (((-6603297) | i) * 591);
                                                                                    int i3512 = -(-i17);
                                                                                    int i3513 = ((i3511 | i3512) << 1) - (i3512 ^ i3511);
                                                                                    int i3610 = i3513 * 522;
                                                                                    int i3611 = i2 * (-520);
                                                                                    int i3612 = (((i3610 | i3611) << 1) - (i3610 ^ i3611)) + (((~((i74 ^ i2) | (i74 & i2))) | i3513) * (-1042));
                                                                                    int i3613 = -(-(((i2 ^ i) | (i2 & i)) * 521));
                                                                                    int i3614 = (i3612 ^ i3613) + ((i3613 & i3612) << 1);
                                                                                    int i3615 = ~i3513;
                                                                                    int i3616 = (~((i3615 & i) | (i3615 ^ i))) | (~((~i2) | i3615));
                                                                                    int i3617 = i3513 | i77;
                                                                                    int i3618 = ~((i3617 & i2) | (i3617 ^ i2));
                                                                                    int i3619 = i3614 + (((i3616 & i3618) | (i3616 ^ i3618)) * 521);
                                                                                    int i376 = i3619 << 13;
                                                                                    int i377 = (i376 & (~i3619)) | ((~i376) & i3619);
                                                                                    int i378 = i377 >>> 17;
                                                                                    int i379 = ((~i377) & i378) | ((~i378) & i377);
                                                                                    int i3710 = i379 << 5;
                                                                                    ((int[]) objArr[2])[0] = (i379 | i3710) & (~(i379 & i3710));
                                                                                    return objArr;
                                                                                }
                                                                                int i3711 = i9 - 56;
                                                                                i9 = ((i3711 & 57) << i13) + (i3711 ^ 57);
                                                                            }
                                                                        } catch (Throwable th) {
                                                                            Throwable cause = th.getCause();
                                                                            if (cause != null) {
                                                                                throw cause;
                                                                            }
                                                                            throw th;
                                                                        }
                                                                    } else {
                                                                        c3 = '0';
                                                                        length = i285;
                                                                        i230 = (i230 ^ 1) + ((i230 & 1) << 1);
                                                                        r0 = r33;
                                                                    }
                                                                }
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
                                                declaredConstructor = i2;
                                                Object[] objArr32 = {new int[]{i}, new int[]{i}, new int[1], null};
                                                int startUptimeMillis = (int) Process.getStartUptimeMillis();
                                                int i380 = 1338925754 + ((556044830 | startUptimeMillis) * 614);
                                                int i381 = ~startUptimeMillis;
                                                int i382 = i380 + (((~((-748422541) | i381)) | 537133068 | (~(230201234 | i381))) * (-1228)) + (((~(i381 | 767334302)) | (~((-211289473) | i381))) * 614);
                                                int iOnTransact9 = CatalystInstanceImpl.InstanceCallback.onTransact();
                                                int i383 = -(-(i382 * (-858)));
                                                int i384 = (i383 << 1) - i383;
                                                int i385 = -(-(iOnTransact9 * (-859)));
                                                int i386 = (i384 & i385) + (i385 | i384);
                                                int i387 = ~iOnTransact9;
                                                int i388 = ~i387;
                                                int i389 = ~i;
                                                int i390 = ((~((i389 & (-136865086)) | ((-136865086) ^ i389))) | (~(951910399 | i))) * (-272);
                                                int i391 = ((-971861156) ^ i390) + ((i390 & (-971861156)) << 1);
                                                int i392 = -(-(((~((-406382080) | i)) | 269516994) * (-272)));
                                                int i393 = ~((i & 406382079) | (406382079 ^ i));
                                                int i394 = (((i391 | i392) << 1) - (i392 ^ i391)) + (((i393 & 682393405) | (682393405 ^ i393)) * 272);
                                                int iOnTransact10 = CatalystInstanceImpl.InstanceCallback.onTransact();
                                                int i395 = -(-(((2143219462 ^ iOnTransact10) | (2143219462 & iOnTransact10)) * 140));
                                                int i396 = (1184730992 ^ i395) + ((i395 & 1184730992) << 1);
                                                int i397 = ~iOnTransact10;
                                                int i398 = ((~((2143219462 & i397) | (i397 ^ 2143219462))) | 4264032) * (-280);
                                                int i399 = (i396 ^ i398) + ((i398 & i396) << 1);
                                                int i400 = ~((~iOnTransact10) | 1995144546);
                                                int i401 = ((~(iOnTransact10 | (-4264033))) | (i400 & 152338948) | (152338948 ^ i400)) * 140;
                                                if (i394 <= ((i399 | i401) << 1) - (i401 ^ i399)) {
                                                    int i402 = ~i382;
                                                    int i403 = ((-1) ^ i402) | i402;
                                                    int i404 = ~((iOnTransact9 & i403) | (i403 ^ iOnTransact9));
                                                    int i405 = i386 / (859 >>> ((i404 & i388) | (i388 ^ i404)));
                                                    int i406 = ~((i402 & i387) | (i402 ^ i387));
                                                    int i407 = ~(~i382);
                                                    i3 = i405 % (859 / ((i406 & i407) | (i406 ^ i407)));
                                                } else {
                                                    int i408 = ~i382;
                                                    int i409 = ~(iOnTransact9 | ((-1) ^ iOnTransact9));
                                                    int i410 = -(-(((i409 & i388) | (i388 ^ i409)) * 859));
                                                    int i411 = ((i386 | i410) << 1) - (i410 ^ i386);
                                                    int i412 = -(-(((~((i408 & i387) | (i408 ^ i387))) | (~(~i382))) * 859));
                                                    i3 = (i411 & i412) + (i412 | i411);
                                                }
                                                int iOnTransact11 = CatalystInstanceImpl.InstanceCallback.onTransact();
                                                int i413 = i3 * 477;
                                                int i414 = declaredConstructor * (-475);
                                                int i415 = ((i413 | i414) << 1) - (i413 ^ i414);
                                                int i416 = ~i3;
                                                int i417 = ~((i416 & declaredConstructor) | ((i416 ^ declaredConstructor) == true ? 1 : 0));
                                                int i418 = ~declaredConstructor;
                                                int i419 = ~((i418 ^ i3) | (i418 & i3) | iOnTransact11);
                                                int i420 = i415 + (((i417 & i419) | (i417 ^ i419)) * (-476));
                                                int i421 = ~declaredConstructor;
                                                int i422 = (i421 & i3) | (i421 ^ i3);
                                                int i423 = -(-((~((i422 & iOnTransact11) | (i422 ^ iOnTransact11))) * 952));
                                                int i424 = ~iOnTransact11;
                                                int i425 = (i424 & i418) | (i418 ^ i424);
                                                int i426 = (i420 & i423) + (i423 | i420) + ((~((i425 & i3) | (i425 ^ i3))) * 476);
                                                int i427 = (i426 << 13) ^ i426;
                                                int i428 = i427 >>> 17;
                                                int i429 = ((~i427) & i428) | ((~i428) & i427);
                                                ((int[]) objArr32[2])[0] = i429 ^ (i429 << 5);
                                                return objArr32;
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
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable th9) {
                        Throwable cause9 = th9.getCause();
                        if (cause9 != null) {
                            throw cause9;
                        }
                        throw th9;
                    }
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
                declaredConstructor = i2;
            }
        }
    }
}
