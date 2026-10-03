package kotlinx.coroutines.flow;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import ch.qos.logback.classic.net.SimpleSSLSocketServer;
import ch.qos.logback.core.net.SyslogConstants;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Random;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import o.ArtificialStackFrames;
import o.onMessageChannelReady;
import o.onRelationshipValidationResult;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes6.dex */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1", f = "Delay.kt", i = {}, l = {204}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__DelayKt$debounceInternal$1$values$1 extends SuspendLambda implements Function2<ProducerScope<? super Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<T> $this_debounceInternal;
    private /* synthetic */ Object L$0;
    int label;
    private static final byte[] $$a = {Ascii.FF, 109, 62, -103};
    private static final int $$b = 46;
    private static int $10 = 0;
    private static int $11 = 1;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static long onPostMessage = 3787268712684819830L;
    private static char[] validateRelationship = {55978, 55988, 55973, 56129, 55984, 55990, 55982, 56131, 55980, 55971, 55989, 55975, 55970, 55976, 56163, 55969, 56140, 56136, 55979, 55993, 56164, 56161, 56152, 55983, 55963, 55974, 55972, 55960, 56150, 56139, 56134, 56151, 56144};
    private static int warmup = -1044260079;
    private static boolean requestPostMessageChannelWithExtras = true;
    private static boolean ICustomTabsServiceDefault = true;

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0028). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$c(int r7, byte r8, short r9) {
        /*
            int r7 = r7 + 66
            int r8 = r8 * 3
            int r8 = 1 - r8
            int r9 = r9 + 4
            byte[] r0 = kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1.$$a
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L13
            r3 = r8
            r7 = r9
            r4 = r2
            goto L28
        L13:
            r3 = r2
        L14:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r8) goto L21
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            return r7
        L21:
            int r9 = r9 + 1
            r3 = r0[r9]
            r6 = r9
            r9 = r7
            r7 = r6
        L28:
            int r3 = -r3
            int r9 = r9 + r3
            r3 = r4
            r6 = r9
            r9 = r7
            r7 = r6
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1.$$c(int, byte, short):java.lang.String");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__DelayKt$debounceInternal$1$values$1(Flow<? extends T> flow, Continuation<? super FlowKt__DelayKt$debounceInternal$1$values$1> continuation) {
        super(2, continuation);
        this.$this_debounceInternal = flow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FlowKt__DelayKt$debounceInternal$1$values$1 flowKt__DelayKt$debounceInternal$1$values$1 = new FlowKt__DelayKt$debounceInternal$1$values$1(this.$this_debounceInternal, continuation);
        flowKt__DelayKt$debounceInternal$1$values$1.L$0 = obj;
        return flowKt__DelayKt$debounceInternal$1$values$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super Object> producerScope, Continuation<? super Unit> continuation) {
        return invoke2((ProducerScope<Object>) producerScope, continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(ProducerScope<Object> producerScope, Continuation<? super Unit> continuation) {
        return ((FlowKt__DelayKt$debounceInternal$1$values$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    private static void a(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        onRelationshipValidationResult onrelationshipvalidationresult = new onRelationshipValidationResult();
        char[] cArrAccessartificialFrame = onRelationshipValidationResult.accessartificialFrame(onPostMessage ^ 2573525503365829440L, cArr, i);
        onrelationshipvalidationresult.e = 4;
        int i3 = $11 + b.f40o;
        $10 = i3 % 128;
        int i4 = i3 % 2;
        while (onrelationshipvalidationresult.e < cArrAccessartificialFrame.length) {
            int i5 = $11 + 97;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            onrelationshipvalidationresult.d = onrelationshipvalidationresult.e - 4;
            int i7 = onrelationshipvalidationresult.e;
            try {
                Object[] objArr2 = {Long.valueOf(cArrAccessartificialFrame[onrelationshipvalidationresult.e] ^ cArrAccessartificialFrame[onrelationshipvalidationresult.e % 4]), Long.valueOf(onrelationshipvalidationresult.d), Long.valueOf(onPostMessage)};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(797310229);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(27 - Color.green(0), (char) (30690 - Color.blue(0)), 188 - ((Process.getThreadPriority(0) + 20) >> 6), -1327449315, false, "k", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                }
                cArrAccessartificialFrame[i7] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                Object[] objArr3 = {onrelationshipvalidationresult, onrelationshipvalidationresult};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(321542193);
                if (objAccessartificialFrame2 == null) {
                    byte b = (byte) 0;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(MotionEvent.axisFromString("") + 34, (char) (ViewConfiguration.getWindowTouchSlop() >> 8), 1483 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), -1940971975, false, $$c((byte) ($$b - 1), b, (byte) (b - 1)), new Class[]{Object.class, Object.class});
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
        objArr[0] = new String(cArrAccessartificialFrame, 4, cArrAccessartificialFrame.length - 4);
    }

    private static void b(char[] cArr, byte[] bArr, int i, int[] iArr, Object[] objArr) throws Throwable {
        int i2;
        char[] cArr2;
        int i3 = 2 % 2;
        onMessageChannelReady onmessagechannelready = new onMessageChannelReady();
        char[] cArr3 = validateRelationship;
        float f = 0.0f;
        int i4 = 0;
        if (cArr3 != null) {
            int length = cArr3.length;
            char[] cArr4 = new char[length];
            int i5 = 0;
            while (i5 < length) {
                try {
                    Object[] objArr2 = new Object[1];
                    objArr2[i4] = Integer.valueOf(cArr3[i5]);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(115862995);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) i4;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(26 - View.resolveSize(i4, i4), (char) Color.alpha(i4), 1042 - (ViewConfiguration.getScrollFriction() > f ? 1 : (ViewConfiguration.getScrollFriction() == f ? 0 : -1)), -1719489573, false, $$c((byte) 55, b, (byte) (b - 1)), new Class[]{Integer.TYPE});
                    }
                    cArr4[i5] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i5++;
                    f = 0.0f;
                    i4 = 0;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            cArr3 = cArr4;
        }
        Object[] objArr3 = {Integer.valueOf(warmup)};
        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1820173622);
        if (objAccessartificialFrame2 == null) {
            byte b2 = (byte) 1;
            byte b3 = (byte) (b2 - 1);
            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(14 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (20489 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), 2148 - View.MeasureSpec.getSize(0), 216472770, false, $$c(b2, b3, (byte) (b3 - 1)), new Class[]{Integer.TYPE});
        }
        int iIntValue = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
        int i6 = -2083387879;
        if (ICustomTabsServiceDefault) {
            int i7 = $10 + 119;
            $11 = i7 % 128;
            if (i7 % 2 == 0) {
                onmessagechannelready.c = bArr.length;
                cArr2 = new char[onmessagechannelready.c];
                i2 = 0;
            } else {
                i2 = 0;
                onmessagechannelready.c = bArr.length;
                cArr2 = new char[onmessagechannelready.c];
            }
            onmessagechannelready.a = i2;
            while (onmessagechannelready.a < onmessagechannelready.c) {
                cArr2[onmessagechannelready.a] = (char) (cArr3[bArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] + i] - iIntValue);
                Object[] objArr4 = {onmessagechannelready, onmessagechannelready};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(i6);
                if (objAccessartificialFrame3 == null) {
                    byte b4 = (byte) 0;
                    byte b5 = b4;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(21 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 59174), 1943 - View.resolveSizeAndState(0, 0, 0), 481771537, false, $$c(b4, b5, (byte) (b5 - 1)), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                int i8 = $11 + 95;
                $10 = i8 % 128;
                int i9 = i8 % 2;
                i6 = -2083387879;
            }
            objArr[0] = new String(cArr2);
            return;
        }
        if (requestPostMessageChannelWithExtras) {
            onmessagechannelready.c = cArr.length;
            char[] cArr5 = new char[onmessagechannelready.c];
            onmessagechannelready.a = 0;
            while (onmessagechannelready.a < onmessagechannelready.c) {
                cArr5[onmessagechannelready.a] = (char) (cArr3[cArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                Object[] objArr5 = {onmessagechannelready, onmessagechannelready};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                if (objAccessartificialFrame4 == null) {
                    byte b6 = (byte) 0;
                    byte b7 = b6;
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 21, (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 59173), 1942 - ((byte) KeyEvent.getModifierMetaStateMask()), 481771537, false, $$c(b6, b7, (byte) (b7 - 1)), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                int i10 = $11 + 97;
                $10 = i10 % 128;
                int i11 = i10 % 2;
            }
            objArr[0] = new String(cArr5);
            return;
        }
        int i12 = 0;
        onmessagechannelready.c = iArr.length;
        char[] cArr6 = new char[onmessagechannelready.c];
        while (true) {
            onmessagechannelready.a = i12;
            if (onmessagechannelready.a >= onmessagechannelready.c) {
                objArr[0] = new String(cArr6);
                return;
            }
            int i13 = $11 + 123;
            $10 = i13 % 128;
            if (i13 % 2 != 0) {
                cArr6[onmessagechannelready.a] = (char) (cArr3[iArr[onmessagechannelready.c >>> onmessagechannelready.a] >> i] + iIntValue);
                int i14 = onmessagechannelready.a;
                i12 = 0;
            } else {
                cArr6[onmessagechannelready.a] = (char) (cArr3[iArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                i12 = onmessagechannelready.a + 1;
            }
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1$1, reason: invalid class name */
    static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ ProducerScope<Object> $$this$produce;

        AnonymousClass1(ProducerScope<Object> producerScope) {
            this.$$this$produce = producerScope;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(T t, Continuation<? super Unit> continuation) {
            FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1 flowKt__DelayKt$debounceInternal$1$values$1$1$emit$1;
            if (continuation instanceof FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1) {
                flowKt__DelayKt$debounceInternal$1$values$1$1$emit$1 = (FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1) continuation;
                int i = flowKt__DelayKt$debounceInternal$1$values$1$1$emit$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    flowKt__DelayKt$debounceInternal$1$values$1$1$emit$1.label = i - Integer.MIN_VALUE;
                } else {
                    flowKt__DelayKt$debounceInternal$1$values$1$1$emit$1 = new FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1(this, continuation);
                }
            } else {
                flowKt__DelayKt$debounceInternal$1$values$1$1$emit$1 = new FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1(this, continuation);
            }
            Object obj = flowKt__DelayKt$debounceInternal$1$values$1$1$emit$1.result;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = flowKt__DelayKt$debounceInternal$1$values$1$1$emit$1.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                ProducerScope<Object> producerScope = this.$$this$produce;
                if (t == null) {
                    t = (T) NullSurrogateKt.NULL;
                }
                flowKt__DelayKt$debounceInternal$1$values$1$1$emit$1.label = 1;
                if (producerScope.send(t, flowKt__DelayKt$debounceInternal$1$values$1$1$emit$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.Continuation to kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1 for r4v1 'this'  kotlin.coroutines.Continuation
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L17
            if (r1 != r2) goto Lf
            kotlin.ResultKt.throwOnFailure(r5)
            goto L2e
        Lf:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L17:
            kotlin.ResultKt.throwOnFailure(r5)
            java.lang.Object r5 = r4.L$0
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlinx.coroutines.flow.Flow<T> r1 = r4.$this_debounceInternal
            kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1$1 r3 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1$1
            r3.<init>(r5)
            r4.label = r2
            java.lang.Object r5 = r1.collect(r3, r4)
            if (r5 != r0) goto L2e
            return r0
        L2e:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    public static Object[] accessartificialFrame(Context context, int i, int i2) {
        int iCoroutineDebuggingKt;
        int i3;
        Class<?> cls;
        Object obj;
        int i4;
        int i5;
        int i6;
        Class<?> cls2;
        int i7;
        char[] cArr;
        int i8;
        int iCoroutineDebuggingKt2;
        int i9;
        int i10 = 2 % 2;
        char[] cArr2 = null;
        int i11 = 1;
        if (context == null) {
            int i12 = artificialFrame;
            int i13 = ((i12 | 45) << 1) - (i12 ^ 45);
            int i14 = i13 % 128;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i14;
            int i15 = i13 % 2;
            int i16 = i14 + 5;
            artificialFrame = i16 % 128;
            int i17 = i16 % 2;
            Object[] objArr = {new int[]{i}, new int[]{i}, new int[1], null};
            int iNextInt = new Random().nextInt();
            int i18 = (((-1695882534) + (((~((~iNextInt) | (-198636866))) | 173319489) * 446)) + (((~(iNextInt | (-25317377))) | 606667420) * 446)) - 8919234;
            int i19 = ~i18;
            int i20 = artificialFrame + 25;
            int i21 = i20 % 128;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i21;
            int i22 = i20 % 2;
            int i23 = ~i;
            int i24 = ~(((-1) ^ i23) | i23);
            int i25 = ((i18 * (-932)) - (~((-933) * ((i24 & i19) | (i19 ^ i24))))) - 1;
            int i26 = ~i18;
            int i27 = ~(i23 | i26);
            int i28 = ~i26;
            int i29 = -(-(((i25 - (~(((i27 & i28) | (i27 ^ i28)) * 933))) - 1) + ((~i18) * 933)));
            int i30 = (i2 ^ i29) + ((i29 & i2) << 1);
            int i31 = i30 << 13;
            int i32 = (i31 | i30) & (~(i30 & i31));
            int i33 = i21 + 19;
            artificialFrame = i33 % 128;
            int i34 = i33 % 2;
            int i35 = i32 >>> 17;
            int i36 = (i32 | i35) & (~(i32 & i35));
            int i37 = i36 << 5;
            ((int[]) objArr[2])[0] = ((~i36) & i37) | ((~i37) & i36);
            return objArr;
        }
        try {
            Object[] objArr2 = new Object[1];
            a((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), new char[]{1363, 1337, 50061, 1498, 33109, 27507, 3407, 14768, 7667, 56058, 43128, 21167, 13440, 62025, 45857, 48523, 20399, 5405, 56213, 42235, 26182, 11320, 58091, 36764, 30995, 18305, 1499, 63322, 36973, 24260, 11270, 56882, 43147, 29076, 14185, 14675, 50173, 35151, 24074, 8354, 55978, 41080}, objArr2);
            String str = (String) objArr2[0];
            int i38 = getARTIFICIAL_FRAME_PACKAGE_NAME;
            int i39 = (i38 & 69) + (i38 | 69);
            artificialFrame = i39 % 128;
            int i40 = i39 % 2;
            Object[] objArr3 = (Object[]) Array.newInstance(Class.forName(str), 2);
            Object[] objArr4 = new Object[1];
            a(ViewConfiguration.getEdgeSlop() >> 16, new char[]{59353, 59290, 49958, 1374, 56584, 8626, 20825, 29521, 65391, 55860, 62575, 6212, 54784, 62172, 61285, 63303, 44340, 5506, 34776, 60956, 33941, 11399, 48808, 50450, 39823, 18260, 22927, 48612, 29344, 24188, 28681, 38048, 18956, 28949, 27486}, objArr4);
            try {
                Object[] objArr5 = {(String) objArr4[0]};
                Object[] objArr6 = new Object[1];
                a(TextUtils.getCapsMode("", 0, 0), new char[]{1363, 1337, 50061, 1498, 33109, 27507, 3407, 14768, 7667, 56058, 43128, 21167, 13440, 62025, 45857, 48523, 20399, 5405, 56213, 42235, 26182, 11320, 58091, 36764, 30995, 18305, 1499, 63322, 36973, 24260, 11270, 56882, 43147, 29076, 14185, 14675, 50173, 35151, 24074, 8354, 55978, 41080}, objArr6);
                objArr3[0] = Class.forName((String) objArr6[0]).getDeclaredConstructor(String.class).newInstance(objArr5);
                Object[] objArr7 = new Object[1];
                a(ViewConfiguration.getTouchSlop() >> 8, new char[]{13416, 13355, 41810, 25945, 51925, 49304, 18156, 37481, 11420, 47640, 58261, 63826, 1462, 37595, 63618, 5716, 32393, 30083, 36916, 3840, 22342, 19698, 43361, 9221, 18484, 10053, 20007, 23770, 41244, 15935, 26580, 30142, 39394, 4402, 31967}, objArr7);
                String str2 = (String) objArr7[0];
                int i41 = artificialFrame;
                int i42 = ((i41 | 87) << 1) - (i41 ^ 87);
                getARTIFICIAL_FRAME_PACKAGE_NAME = i42 % 128;
                int i43 = i42 % 2;
                try {
                    Object[] objArr8 = new Object[1];
                    a(Color.red(0), new char[]{1363, 1337, 50061, 1498, 33109, 27507, 3407, 14768, 7667, 56058, 43128, 21167, 13440, 62025, 45857, 48523, 20399, 5405, 56213, 42235, 26182, 11320, 58091, 36764, 30995, 18305, 1499, 63322, 36973, 24260, 11270, 56882, 43147, 29076, 14185, 14675, 50173, 35151, 24074, 8354, 55978, 41080}, objArr8);
                    objArr3[1] = Class.forName((String) objArr8[0]).getDeclaredConstructor(String.class).newInstance(str2);
                    try {
                        Object[] objArr9 = new Object[1];
                        a(Color.alpha(0), new char[]{48590, 48559, 16087, 63631, 35779, 60392, 1995, 47416, 42361, 10216, 41707, 53868, 35869, 3846, 47545, 15646, 63267, 59487, 53579, 9276, 57069, 53622, 59497, 3918, 49555, 47769, 3867}, objArr9);
                        Class<?> cls3 = Class.forName((String) objArr9[0]);
                        Object[] objArr10 = new Object[1];
                        a((-2) - ((-MotionEvent.axisFromString("")) ^ (-1)), new char[]{36033, 36006, 40174, 23229, 63212, 60807, 31476, 49013, 38008, 34256, 57307, 54382, 48406, 44350, 50341, 15174, 50727, 19042, 44135, 8762, 61395}, objArr10);
                        Method method = cls3.getMethod((String) objArr10[0], null);
                        int i44 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i45 = (i44 ^ 61) + ((i44 & 61) << 1);
                        artificialFrame = i45 % 128;
                        int i46 = i45 % 2;
                        Object objInvoke = method.invoke(context, null);
                        try {
                            Object[] objArr11 = new Object[1];
                            a(Process.myTid() >> 22, new char[]{48590, 48559, 16087, 63631, 35779, 60392, 1995, 47416, 42361, 10216, 41707, 53868, 35869, 3846, 47545, 15646, 63267, 59487, 53579, 9276, 57069, 53622, 59497, 3918, 49555, 47769, 3867}, objArr11);
                            Class<?> cls4 = Class.forName((String) objArr11[0]);
                            Object[] objArr12 = new Object[1];
                            b(null, new byte[]{-126, -119, -123, -120, -126, -127, -123, -121, -122, -123, -124, -125, -126, -127}, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + WebSocketProtocol.PAYLOAD_SHORT, null, objArr12);
                            try {
                                Object[] objArr13 = {cls4.getMethod((String) objArr12[0], null).invoke(context, null), 64};
                                byte[] bArr = {-116, -126, -127, -123, -118, -123, -111, -126, -127, -123, -121, -122, -123, -124, -113, -119, -112, -113, -125, -118, -126, -125, -118, -115, -122, -113, -117, -114, -115, -116, -117, -118, -123};
                                int bitsPerPixel = ImageFormat.getBitsPerPixel(0);
                                int i47 = artificialFrame + 101;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i47 % 128;
                                if (i47 % 2 != 0) {
                                    iCoroutineDebuggingKt = SimpleSSLSocketServer.CoroutineDebuggingKt();
                                    i3 = (bitsPerPixel * 70) >>> (-68);
                                } else {
                                    iCoroutineDebuggingKt = SimpleSSLSocketServer.CoroutineDebuggingKt();
                                    int i48 = bitsPerPixel * 70;
                                    i3 = ((i48 | (-8704)) << 1) - (i48 ^ (-8704));
                                }
                                int i49 = (bitsPerPixel ^ 128) | ((bitsPerPixel ^ (-1)) & (-129));
                                int i50 = (bitsPerPixel & 128) | (bitsPerPixel ^ 128);
                                int i51 = (i3 - (~(69 * ((~((i50 & iCoroutineDebuggingKt) | (i50 ^ iCoroutineDebuggingKt))) | (~((i49 & iCoroutineDebuggingKt) | (i49 ^ iCoroutineDebuggingKt))))))) - 1;
                                int i52 = ~bitsPerPixel;
                                int i53 = ~((i52 & 128) | (i52 ^ 128));
                                int i54 = ~bitsPerPixel;
                                int i55 = i53 | (~((i54 ^ iCoroutineDebuggingKt) | (i54 & iCoroutineDebuggingKt)));
                                int i56 = ~((iCoroutineDebuggingKt ^ 128) | (iCoroutineDebuggingKt & 128));
                                int i57 = -(-(((i55 & i56) | (i55 ^ i56)) * (-69)));
                                int i58 = (i51 & i57) + (i57 | i51);
                                int i59 = -(-((~(((-129) ^ bitsPerPixel) | ((-129) & bitsPerPixel))) * 69));
                                int i60 = (i58 ^ i59) + ((i59 & i58) << 1);
                                Object[] objArr14 = new Object[1];
                                b(null, bArr, i60, null, objArr14);
                                Class<?> cls5 = Class.forName((String) objArr14[0]);
                                byte[] bArr2 = {-115, -109, -118, -110, -126, -127, -123, -121, -122, -123, -124, -125, -126, -127};
                                float maxVolume = AudioTrack.getMaxVolume();
                                int i61 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                int i62 = (i61 ^ 123) + ((i61 & 123) << 1);
                                artificialFrame = i62 % 128;
                                int i63 = i62 % 2;
                                int i64 = -(maxVolume > 0.0f ? 1 : (maxVolume == 0.0f ? 0 : -1));
                                int i65 = (128 ^ i64) + ((i64 & 128) << 1);
                                Object[] objArr15 = new Object[1];
                                b(null, bArr2, i65, null, objArr15);
                                Object objInvoke2 = cls5.getMethod((String) objArr15[0], String.class, Integer.TYPE).invoke(objInvoke, objArr13);
                                int i66 = artificialFrame + 77;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i66 % 128;
                                if (i66 % 2 != 0) {
                                    Object[] objArr16 = new Object[1];
                                    a(Color.red(1), new char[]{11199, 11230, 11320, 60000, 519, 62677, 36367, 42501, 13064, 13575, 11055, 52561, 6764, 7657, 12413, 8739, 24914, 64176, 22671, 15105, 18607, 50075, 25069, 4183, 22502, 43117, 34496, 26814, 48840, 45379, 44858, 16857, 34353, 40465}, objArr16);
                                    cls = Class.forName((String) objArr16[0]);
                                    Object[] objArr17 = new Object[1];
                                    a(ViewConfiguration.getMaximumFlingVelocity() << 84, new char[]{47919, 47964, 8948, 58539, 21034, 32420, 56865, 11368, 41878, 15313, 31504, 18272, 35578, 4926}, objArr17);
                                    obj = objArr17[0];
                                } else {
                                    Object[] objArr18 = new Object[1];
                                    a(Color.red(0), new char[]{11199, 11230, 11320, 60000, 519, 62677, 36367, 42501, 13064, 13575, 11055, 52561, 6764, 7657, 12413, 8739, 24914, 64176, 22671, 15105, 18607, 50075, 25069, 4183, 22502, 43117, 34496, 26814, 48840, 45379, 44858, 16857, 34353, 40465}, objArr18);
                                    cls = Class.forName((String) objArr18[0]);
                                    Object[] objArr19 = new Object[1];
                                    a(ViewConfiguration.getMaximumFlingVelocity() >> 16, new char[]{47919, 47964, 8948, 58539, 21034, 32420, 56865, 11368, 41878, 15313, 31504, 18272, 35578, 4926}, objArr19);
                                    obj = objArr19[0];
                                }
                                Object[] objArr20 = (Object[]) cls.getField((String) obj).get(objInvoke2);
                                int length = objArr20.length;
                                int i67 = 0;
                                while (i67 < length) {
                                    Object obj2 = objArr20[i67];
                                    byte[] bArr3 = {-105, -106, -107, -113, -108};
                                    int windowTouchSlop = ViewConfiguration.getWindowTouchSlop();
                                    int i68 = artificialFrame + 21;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i68 % 128;
                                    int i69 = i68 % 2;
                                    int i70 = -(windowTouchSlop >> 8);
                                    int iCoroutineDebuggingKt3 = SimpleSSLSocketServer.CoroutineDebuggingKt();
                                    int i71 = (i70 * 165) - 20701;
                                    int i72 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                    int i73 = (i72 & 95) + (i72 | 95);
                                    int i74 = i73 % 128;
                                    artificialFrame = i74;
                                    if (i73 % 2 == 0) {
                                        int i75 = ~iCoroutineDebuggingKt3;
                                        int i76 = ~((i75 ^ 127) | (i75 & 127));
                                        int i77 = -((-328) / ((i70 ^ i76) | (i76 & i70)));
                                        i4 = (i71 & i77) + (i77 | i71);
                                    } else {
                                        int i78 = ~iCoroutineDebuggingKt3;
                                        i4 = (((~((i78 ^ 127) | (i78 & 127))) | i70) * (-328)) + i71;
                                    }
                                    int i79 = i74 + 115;
                                    int i80 = i79 % 128;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i80;
                                    if (i79 % 2 != 0) {
                                        i5 = i4 / (164 / ((i70 ^ iCoroutineDebuggingKt3) | (i70 & iCoroutineDebuggingKt3)));
                                    } else {
                                        int i81 = 164 * ((i70 ^ iCoroutineDebuggingKt3) | (i70 & iCoroutineDebuggingKt3));
                                        i5 = (i4 & i81) + (i81 | i4);
                                    }
                                    int i82 = (~((~i70) | (-128))) | (~(((-128) ^ iCoroutineDebuggingKt3) | ((-128) & iCoroutineDebuggingKt3)));
                                    int i83 = ((i80 | 71) << i11) - (i80 ^ 71);
                                    int i84 = i83 % 128;
                                    artificialFrame = i84;
                                    int i85 = i83 % 2;
                                    int i86 = ~iCoroutineDebuggingKt3;
                                    int i87 = ~((i70 & i86) | (i86 ^ i70) | 127);
                                    int i88 = -(-(164 * ((i82 & i87) | (i82 ^ i87))));
                                    int i89 = (i5 ^ i88) + ((i88 & i5) << i11);
                                    int i90 = i84 + 55;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i90 % 128;
                                    int i91 = i90 % 2;
                                    Object[] objArr21 = new Object[i11];
                                    b(cArr2, bArr3, i89, cArr2, objArr21);
                                    try {
                                        Object[] objArr22 = {(String) objArr21[0]};
                                        byte[] bArr4 = {-100, -116, -115, -125, -122, -123, -98, -126, -125, -123, -122, -114, -109, -114, -125, -116, -126, -99, -113, -125, -116, -126, -122, -113, -100, -125, -114, -116, -101, -122, -126, -102, -113, -123, -103, -123, -104};
                                        int i92 = -Color.green(0);
                                        int i93 = artificialFrame + 87;
                                        int i94 = i93 % 128;
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i94;
                                        int i95 = i93 % 2;
                                        int i96 = i92 * (-380);
                                        int i97 = (i96 ^ 48514) + ((i96 & 48514) << i11);
                                        int i98 = i | 127;
                                        int i99 = ~i92;
                                        int i100 = i97 + (((i98 ^ i99) | (i98 & i99)) * (-381));
                                        int i101 = ~i92;
                                        int i102 = ~(i101 | (-128));
                                        int i103 = ~i;
                                        Object[] objArr23 = objArr20;
                                        int i104 = ~(i103 | 127);
                                        int i105 = (i94 ^ 117) + ((i94 & 117) << 1);
                                        int i106 = length;
                                        artificialFrame = i105 % 128;
                                        if (i105 % 2 == 0) {
                                            i6 = i100 >> (381 / (((i104 & i102) | (i102 ^ i104)) | (~((i92 ^ 127) | (i92 & 127)))));
                                        } else {
                                            int i107 = (i104 & i102) | (i102 ^ i104);
                                            int i108 = ~((i92 ^ 127) | (i92 & 127));
                                            int i109 = ((i107 & i108) | (i107 ^ i108)) * 381;
                                            i6 = (i109 | i100) + (i100 & i109);
                                            i99 = i101;
                                        }
                                        int i110 = 381 * (~((i99 ^ 127) | (i99 & 127)));
                                        int i111 = ((i6 | i110) << 1) - (i6 ^ i110);
                                        Object[] objArr24 = new Object[1];
                                        b(null, bArr4, i111, null, objArr24);
                                        Class<?> cls6 = Class.forName((String) objArr24[0]);
                                        Object[] objArr25 = new Object[1];
                                        b(null, new byte[]{-126, -122, -118, -123, -125, -102, -118, -110, -125, -126, -127}, 126 - (~(-(ViewConfiguration.getScrollBarSize() >> 8))), null, objArr25);
                                        Object objInvoke3 = cls6.getMethod((String) objArr25[0], String.class).invoke(null, objArr22);
                                        try {
                                            Object[] objArr26 = new Object[1];
                                            b(null, new byte[]{-126, -116, -101, -125, -123, -118, -127, -114, -97, -113, -119, -112, -113, -125, -118, -126, -125, -118, -115, -122, -113, -117, -114, -115, -116, -117, -118, -123}, 127 - View.MeasureSpec.getMode(0), null, objArr26);
                                            Class<?> cls7 = Class.forName((String) objArr26[0]);
                                            int i112 = -(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                                            int i113 = (i112 ^ 127) + ((i112 & 127) << 1);
                                            Object[] objArr27 = new Object[1];
                                            b(null, new byte[]{-100, -123, -116, -116, -95, -126, -125, -100, -96, -115, -125}, i113, null, objArr27);
                                            try {
                                                Object[] objArr28 = {new ByteArrayInputStream((byte[]) cls7.getMethod((String) objArr27[0], null).invoke(obj2, null))};
                                                int i114 = -(-(ViewConfiguration.getKeyRepeatDelay() >> 16));
                                                Object[] objArr29 = new Object[1];
                                                b(null, new byte[]{-100, -116, -115, -125, -122, -123, -98, -126, -125, -123, -122, -114, -109, -114, -125, -116, -126, -99, -113, -125, -116, -126, -122, -113, -100, -125, -114, -116, -101, -122, -126, -102, -113, -123, -103, -123, -104}, (i114 & 127) + (i114 | 127), null, objArr29);
                                                Class<?> cls8 = Class.forName((String) objArr29[0]);
                                                Object[] objArr30 = new Object[1];
                                                a(TextUtils.getCapsMode("", 0, 0), new char[]{44874, 44845, 43133, 28206, 22107, 55332, 55897, 35555, 47072, 45377, 32617, 57852, 40633, 39341, 25655, 3781, 58795, 32502, 3268, 6058, 52299, 18380, 13808}, objArr30);
                                                Object objInvoke4 = cls8.getMethod((String) objArr30[0], InputStream.class).invoke(objInvoke3, objArr28);
                                                int length2 = objArr3.length;
                                                int i115 = 0;
                                                while (i115 < 2) {
                                                    Object obj3 = objArr3[i115];
                                                    int i116 = getARTIFICIAL_FRAME_PACKAGE_NAME + 85;
                                                    artificialFrame = i116 % 128;
                                                    int i117 = i116 % 2;
                                                    try {
                                                        byte[] bArr5 = {-126, -125, -123, -122, -114, -109, -114, -125, -116, -126, -99, -105, -106, -107, -108, -113, -125, -116, -126, -122, -113, -100, -125, -114, -116, -101, -122, -126, -102, -113, -123, -103, -123, -104};
                                                        int iLastIndexOf = TextUtils.lastIndexOf("", '0', 0);
                                                        int i118 = artificialFrame;
                                                        int i119 = (i118 & 125) + (i118 | 125);
                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i119 % 128;
                                                        int i120 = -iLastIndexOf;
                                                        if (i119 % 2 != 0) {
                                                            Object[] objArr31 = new Object[1];
                                                            b(null, bArr5, (i120 & WebSocketProtocol.PAYLOAD_SHORT) + (i120 | WebSocketProtocol.PAYLOAD_SHORT), null, objArr31);
                                                            cls2 = Class.forName((String) objArr31[0]);
                                                            i7 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                                                            cArr = new char[27];
                                                        } else {
                                                            Object[] objArr32 = new Object[1];
                                                            b(null, bArr5, 125 - (~i120), null, objArr32);
                                                            cls2 = Class.forName((String) objArr32[0]);
                                                            i7 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                                                            cArr = new char[27];
                                                        }
                                                        // fill-array-data instruction
                                                        cArr[0] = 31741;
                                                        cArr[1] = 31642;
                                                        cArr[2] = 5051;
                                                        cArr[3] = 54760;
                                                        cArr[4] = 46316;
                                                        cArr[5] = 61370;
                                                        cArr[6] = 14580;
                                                        cArr[7] = 48459;
                                                        cArr[8] = 25424;
                                                        cArr[9] = 2692;
                                                        cArr[10] = 40410;
                                                        cArr[11] = 54868;
                                                        cArr[12] = 18990;
                                                        cArr[13] = 8826;
                                                        cArr[14] = 34480;
                                                        cArr[15] = 14636;
                                                        cArr[16] = 12613;
                                                        cArr[17] = 50534;
                                                        cArr[18] = 61008;
                                                        cArr[19] = 8211;
                                                        cArr[20] = 6388;
                                                        cArr[21] = 64528;
                                                        cArr[22] = 55131;
                                                        cArr[23] = 2848;
                                                        cArr[24] = 1973;
                                                        cArr[25] = 38887;
                                                        cArr[26] = 12348;
                                                        Object[] objArr33 = new Object[1];
                                                        a(i7, cArr, objArr33);
                                                        if (obj3.equals(cls2.getMethod((String) objArr33[0], null).invoke(objInvoke4, null))) {
                                                            int i121 = (~(i & 1)) & (i | 1);
                                                            Object[] objArr34 = new Object[4];
                                                            objArr34[0] = new int[]{i};
                                                            int[] iArr = new int[1];
                                                            objArr34[1] = iArr;
                                                            objArr34[2] = new int[1];
                                                            int i122 = artificialFrame;
                                                            int i123 = (i122 ^ 37) + ((i122 & 37) << 1);
                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i123 % 128;
                                                            if (i123 % 2 != 0) {
                                                                iArr[1] = i121;
                                                                objArr34[3] = null;
                                                                int iMyUid = Process.myUid();
                                                                int i124 = ~iMyUid;
                                                                i8 = 1849234826 + (((~(638979508 | i124)) | 271090250) * (-108)) + (((~(i124 | 339644266)) | (~((-339644267) | iMyUid)) | 570425492) * 54) + ((iMyUid | 570425492) * 54);
                                                                iCoroutineDebuggingKt2 = SimpleSSLSocketServer.CoroutineDebuggingKt();
                                                            } else {
                                                                iArr[0] = i121;
                                                                objArr34[3] = null;
                                                                i8 = (((-1479022264) + (((~((-695147585) | i103)) | (-283476191)) * (-933))) + (((~((-283476191) | i103)) | 276856990) * 933)) - 642169019;
                                                                iCoroutineDebuggingKt2 = SimpleSSLSocketServer.CoroutineDebuggingKt();
                                                            }
                                                            int i125 = getARTIFICIAL_FRAME_PACKAGE_NAME + 59;
                                                            artificialFrame = i125 % 128;
                                                            if (i125 % 2 == 0) {
                                                                int i126 = ~((~i8) | (~iCoroutineDebuggingKt2));
                                                                i9 = ((65535 << ((-112) >> i8)) - (~(-(-(225 - (~((i126 & 16) | (i126 ^ 16)))))))) - 1;
                                                            } else {
                                                                int i127 = -(-(i8 * (-112)));
                                                                int i128 = (((-1792) | i127) << 1) - (i127 ^ (-1792));
                                                                int i129 = ~i8;
                                                                int i130 = ~iCoroutineDebuggingKt2;
                                                                int i131 = ~((i129 & i130) | (i129 ^ i130));
                                                                int i132 = -(-(((i131 & 16) | (i131 ^ 16)) * 226));
                                                                i9 = ((i132 & i128) << 1) + (i128 ^ i132);
                                                            }
                                                            int i133 = ~(((-17) & i8) | ((-17) ^ i8));
                                                            int i134 = ~(((-17) & iCoroutineDebuggingKt2) | ((-17) ^ iCoroutineDebuggingKt2));
                                                            int i135 = (i133 & i134) | (i133 ^ i134);
                                                            int i136 = ~i8;
                                                            int i137 = ~iCoroutineDebuggingKt2;
                                                            int i138 = (i136 & i137) | (i136 ^ i137);
                                                            int i139 = ~((i138 & 16) | (i138 ^ 16));
                                                            int i140 = (-113) * ((i135 & i139) | (i135 ^ i139));
                                                            int i141 = (i9 & i140) + (i9 | i140);
                                                            int i142 = ~i8;
                                                            int i143 = (i141 - (~((~((iCoroutineDebuggingKt2 & i142) | (i142 ^ iCoroutineDebuggingKt2))) * 113))) - 1;
                                                            int iCoroutineDebuggingKt4 = SimpleSSLSocketServer.CoroutineDebuggingKt();
                                                            int i144 = i143 * (-159);
                                                            int i145 = i2 * (-159);
                                                            int i146 = ((((i144 | i145) << 1) - (i144 ^ i145)) - (~(((~i143) | i2) * SyslogConstants.LOG_LOCAL4))) - 1;
                                                            SimpleSSLSocketServer.CoroutineDebuggingKt();
                                                            int i147 = ~iCoroutineDebuggingKt4;
                                                            int i148 = ~(i147 | i143);
                                                            int i149 = ~((i143 ^ i2) | (i143 & i2));
                                                            int i150 = (-160) * ((i148 & i149) | (i148 ^ i149));
                                                            int i151 = (i146 & i150) + (i150 | i146);
                                                            int i152 = ~i2;
                                                            int i153 = ~((i147 & i152) | (i152 ^ i147));
                                                            int i154 = -(-(((i153 & i143) | (i143 ^ i153)) * SyslogConstants.LOG_LOCAL4));
                                                            int i155 = (i151 & i154) + (i154 | i151);
                                                            int i156 = i155 << 13;
                                                            int i157 = (i156 | i155) & (~(i155 & i156));
                                                            int i158 = i157 >>> 17;
                                                            int i159 = ((~i157) & i158) | ((~i158) & i157);
                                                            ((int[]) objArr34[2])[0] = i159 ^ (i159 << 5);
                                                            return objArr34;
                                                        }
                                                        int i160 = i115 - 115;
                                                        i115 = ((i160 | 116) << 1) - (i160 ^ 116);
                                                    } catch (Throwable th) {
                                                        Throwable cause = th.getCause();
                                                        if (cause != null) {
                                                            throw cause;
                                                        }
                                                        throw th;
                                                    }
                                                }
                                                int i161 = (i67 ^ 9) + ((i67 & 9) << 1);
                                                i67 = ((i161 | (-8)) << 1) - (i161 ^ (-8));
                                                int i162 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                int i163 = (i162 & 107) + (i162 | 107);
                                                artificialFrame = i163 % 128;
                                                int i164 = i163 % 2;
                                                objArr20 = objArr23;
                                                length = i106;
                                                cArr2 = null;
                                                i11 = 1;
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
                                int i165 = artificialFrame;
                                int i166 = (i165 & AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) + (i165 | AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i166 % 128;
                                int i167 = i166 % 2;
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
        int i168 = (int) Runtime.getRuntime().totalMemory();
        int i169 = ((((~((-553813081) | i168)) | 944807070) * 262) - 314062794) + (((~((~i168) | (-553813081))) | 944807070) * 262);
        int i170 = ~i169;
        int i171 = ~i169;
        int i172 = ~i171;
        int i173 = ~i;
        int i174 = ((((i169 * (-675)) + ((i | i170) * (-676))) + ((i172 | (~i173)) * 676)) - (~(-(-(((~((i & i169) | (i169 ^ i))) | ((~(i170 | ((-1) ^ i170))) | (~((i171 & i173) | (i171 ^ i173))))) * 676))))) - 1;
        int iCoroutineDebuggingKt5 = SimpleSSLSocketServer.CoroutineDebuggingKt();
        int i175 = i174 * 483;
        int i176 = -(-(i2 * 242));
        int i177 = ((i175 | i176) << 1) - (i175 ^ i176);
        int i178 = ~i174;
        int i179 = ~i2;
        int i180 = ~((i178 & i179) | (i178 ^ i179));
        int i181 = ~i174;
        int i182 = ~iCoroutineDebuggingKt5;
        int i183 = (i182 & i181) | (i181 ^ i182);
        int i184 = (i180 | (~i183)) * (-241);
        int i185 = (i177 & i184) + (i184 | i177);
        int i186 = -(-(((i174 ^ i2) | (i174 & i2)) * (-482)));
        int i187 = ((i185 | i186) << 1) - (i186 ^ i185);
        int i188 = ~((i179 ^ i174) | (i174 & i179));
        int i189 = ~((i2 & i183) | (i183 ^ i2));
        int i190 = i187 + (((i188 & i189) | (i188 ^ i189)) * 241);
        int i191 = i190 << 13;
        int i192 = (i191 & (~i190)) | ((~i191) & i190);
        int i193 = i192 >>> 17;
        int i194 = ((~i192) & i193) | ((~i193) & i192);
        int i195 = i194 << 5;
        ((int[]) objArr35[2])[0] = (i194 | i195) & (~(i194 & i195));
        int i196 = getARTIFICIAL_FRAME_PACKAGE_NAME - (-113);
        artificialFrame = i196 % 128;
        int i197 = i196 % 2;
        return objArr35;
    }
}
