package com.facebook.react.bridge;

import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.infer.annotation.Assertions;
import com.facebook.systrace.SystraceMessage;
import com.google.common.base.Ascii;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import kotlin.io.encoding.Base64;
import o.ArtificialStackFrames;
import o._CREATION;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes4.dex */
class JavaMethodWrapper implements JavaModuleWrapper.NativeMethod {
    private ArgumentExtractor[] mArgumentExtractors;
    private Object[] mArguments;
    private boolean mArgumentsProcessed = false;
    private int mJSArgumentsNeeded;
    private final Method mMethod;
    private final JavaModuleWrapper mModuleWrapper;
    private final int mParamLength;
    private final Class[] mParameterTypes;
    private String mSignature;
    private String mType;
    private static final ArgumentExtractor<Boolean> ARGUMENT_EXTRACTOR_BOOLEAN = new ArgumentExtractor<Boolean>() { // from class: com.facebook.react.bridge.JavaMethodWrapper.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.facebook.react.bridge.JavaMethodWrapper.ArgumentExtractor
        public Boolean extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i) {
            return Boolean.valueOf(readableArray.getBoolean(i));
        }
    };
    private static final ArgumentExtractor<Double> ARGUMENT_EXTRACTOR_DOUBLE = new ArgumentExtractor<Double>() { // from class: com.facebook.react.bridge.JavaMethodWrapper.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.facebook.react.bridge.JavaMethodWrapper.ArgumentExtractor
        public Double extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i) {
            return Double.valueOf(readableArray.getDouble(i));
        }
    };
    private static final ArgumentExtractor<Float> ARGUMENT_EXTRACTOR_FLOAT = new ArgumentExtractor<Float>() { // from class: com.facebook.react.bridge.JavaMethodWrapper.3
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.facebook.react.bridge.JavaMethodWrapper.ArgumentExtractor
        public Float extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i) {
            return Float.valueOf((float) readableArray.getDouble(i));
        }
    };
    private static final ArgumentExtractor<Integer> ARGUMENT_EXTRACTOR_INTEGER = new ArgumentExtractor<Integer>() { // from class: com.facebook.react.bridge.JavaMethodWrapper.4
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.facebook.react.bridge.JavaMethodWrapper.ArgumentExtractor
        public Integer extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i) {
            return Integer.valueOf((int) readableArray.getDouble(i));
        }
    };
    private static final ArgumentExtractor<String> ARGUMENT_EXTRACTOR_STRING = new ArgumentExtractor<String>() { // from class: com.facebook.react.bridge.JavaMethodWrapper.5
        @Override // com.facebook.react.bridge.JavaMethodWrapper.ArgumentExtractor
        public String extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i) {
            return readableArray.getString(i);
        }
    };
    private static final ArgumentExtractor<ReadableArray> ARGUMENT_EXTRACTOR_ARRAY = new ArgumentExtractor<ReadableArray>() { // from class: com.facebook.react.bridge.JavaMethodWrapper.6
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.facebook.react.bridge.JavaMethodWrapper.ArgumentExtractor
        public ReadableArray extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i) {
            return readableArray.getArray(i);
        }
    };
    private static final ArgumentExtractor<Dynamic> ARGUMENT_EXTRACTOR_DYNAMIC = new ArgumentExtractor<Dynamic>() { // from class: com.facebook.react.bridge.JavaMethodWrapper.7
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.facebook.react.bridge.JavaMethodWrapper.ArgumentExtractor
        public Dynamic extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i) {
            return DynamicFromArray.create(readableArray, i);
        }
    };
    private static final ArgumentExtractor<ReadableMap> ARGUMENT_EXTRACTOR_MAP = new ArgumentExtractor<ReadableMap>() { // from class: com.facebook.react.bridge.JavaMethodWrapper.8
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.facebook.react.bridge.JavaMethodWrapper.ArgumentExtractor
        public ReadableMap extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i) {
            return readableArray.getMap(i);
        }
    };
    private static final ArgumentExtractor<Callback> ARGUMENT_EXTRACTOR_CALLBACK = new ArgumentExtractor<Callback>() { // from class: com.facebook.react.bridge.JavaMethodWrapper.9
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.facebook.react.bridge.JavaMethodWrapper.ArgumentExtractor
        public Callback extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i) {
            if (readableArray.isNull(i)) {
                return null;
            }
            return new CallbackImpl(jSInstance, (int) readableArray.getDouble(i));
        }
    };
    private static final ArgumentExtractor<Promise> ARGUMENT_EXTRACTOR_PROMISE = new ArgumentExtractor<Promise>() { // from class: com.facebook.react.bridge.JavaMethodWrapper.10
        private static long _BOUNDARY;
        private static char[] _CREATION;
        private static final byte[] $$c = {85, -33, -39, -30};
        private static final int $$d = 107;
        private static int $10 = 0;
        private static int $11 = 1;
        private static final byte[] $$a = {Base64.padSymbol, 55, -5, -17, 2, 52, -47, -11, -17, 5, Ascii.FF, -11, 8, 0, -17, -22, -1, 3, 53, -53, Ascii.CR, 1, 8, -19, 19};
        private static final int $$b = 183;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;

        /* JADX WARN: Code duplicated, block: B:10:0x0028  */
        /* JADX WARN: Code duplicated, block: B:8:0x0022  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x002c). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0028
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$e(int r6, short r7, short r8) {
            /*
                int r8 = r8 * 2
                int r8 = 3 - r8
                int r6 = r6 * 3
                int r0 = 1 - r6
                int r7 = 106 - r7
                byte[] r1 = com.facebook.react.bridge.JavaMethodWrapper.AnonymousClass10.$$c
                byte[] r0 = new byte[r0]
                r2 = 0
                int r6 = 0 - r6
                if (r1 != 0) goto L17
                r4 = r6
                r7 = r8
                r3 = r2
                goto L2c
            L17:
                r3 = r2
                r5 = r8
                r8 = r7
                r7 = r5
            L1b:
                byte r4 = (byte) r8
                r0[r3] = r4
                int r7 = r7 + 1
                if (r3 != r6) goto L28
                java.lang.String r6 = new java.lang.String
                r6.<init>(r0, r2)
                return r6
            L28:
                int r3 = r3 + 1
                r4 = r1[r7]
            L2c:
                int r4 = -r4
                int r8 = r8 + r4
                goto L1b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.bridge.JavaMethodWrapper.AnonymousClass10.$$e(int, short, short):java.lang.String");
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0021  */
        /* JADX WARN: Code duplicated, block: B:8:0x0019  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x002a). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static void b(short r6, byte r7, int r8, java.lang.Object[] r9) {
            /*
                byte[] r0 = com.facebook.react.bridge.JavaMethodWrapper.AnonymousClass10.$$a
                int r8 = r8 + 66
                int r6 = 22 - r6
                int r1 = r7 + 2
                byte[] r1 = new byte[r1]
                int r7 = r7 + 1
                r2 = 0
                if (r0 != 0) goto L13
                r3 = r8
                r4 = r2
                r8 = r6
                goto L2a
            L13:
                r3 = r2
            L14:
                byte r4 = (byte) r8
                r1[r3] = r4
                if (r3 != r7) goto L21
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L21:
                r4 = r0[r6]
                int r3 = r3 + 1
                r5 = r8
                r8 = r6
                r6 = r4
                r4 = r3
                r3 = r5
            L2a:
                int r6 = -r6
                int r3 = r3 + r6
                int r6 = r8 + 1
                int r8 = r3 + (-2)
                r3 = r4
                goto L14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.bridge.JavaMethodWrapper.AnonymousClass10.b(short, byte, int, java.lang.Object[]):void");
        }

        @Override // com.facebook.react.bridge.JavaMethodWrapper.ArgumentExtractor
        public int getJSArgumentsNeeded() {
            return 2;
        }

        private static void a(char c, int i, int i2, Object[] objArr) throws Throwable {
            int i3 = 2 % 2;
            _CREATION _creation = new _CREATION();
            long[] jArr = new long[i2];
            _creation.b = 0;
            while (_creation.b < i2) {
                int i4 = _creation.b;
                try {
                    Object[] objArr2 = {Integer.valueOf(_CREATION[i + i4])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 0;
                        byte b2 = (byte) (b + 2);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(8 - View.MeasureSpec.getMode(0), (char) (9278 - TextUtils.lastIndexOf("", '0')), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 1977, 1113883676, false, $$e(b, b2, (byte) (b2 - 2)), new Class[]{Integer.TYPE});
                    }
                    Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i4), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 0;
                        byte b4 = b3;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(30 - KeyEvent.normalizeMetaState(0), (char) (49362 - KeyEvent.getDeadChar(0, 0)), 684 - (ViewConfiguration.getLongPressTimeout() >> 16), -115095555, false, $$e(b3, b4, b4), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                    }
                    jArr[i4] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                    Object[] objArr4 = {_creation, _creation};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                    if (objAccessartificialFrame3 == null) {
                        byte b5 = (byte) 0;
                        byte b6 = (byte) (b5 + 3);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0') + 26, (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 30067), Drawable.resolveOpacity(0, 0) + 816, 1897803493, false, $$e(b5, b6, (byte) (b6 - 3)), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            char[] cArr = new char[i2];
            _creation.b = 0;
            while (_creation.b < i2) {
                int i5 = $10 + 45;
                $11 = i5 % 128;
                int i6 = i5 % 2;
                cArr[_creation.b] = (char) jArr[_creation.b];
                Object[] objArr5 = {_creation, _creation};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-293902099);
                if (objAccessartificialFrame4 == null) {
                    byte b7 = (byte) 0;
                    byte b8 = (byte) (b7 + 3);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(24 - ExpandableListView.getPackedPositionChild(0L), (char) (30068 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), 816 - (ViewConfiguration.getScrollBarSize() >> 8), 1897803493, false, $$e(b7, b8, (byte) (b8 - 3)), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                int i7 = $10 + 49;
                $11 = i7 % 128;
                int i8 = i7 % 2;
            }
            objArr[0] = new String(cArr);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.facebook.react.bridge.JavaMethodWrapper.ArgumentExtractor
        public Promise extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i) {
            return new PromiseImpl((Callback) JavaMethodWrapper.ARGUMENT_EXTRACTOR_CALLBACK.extractArgument(jSInstance, readableArray, i), (Callback) JavaMethodWrapper.ARGUMENT_EXTRACTOR_CALLBACK.extractArgument(jSInstance, readableArray, i + 1));
        }

        static {
            char[] cArr = new char[1959];
            ByteBuffer.wrap("\u0005\u001e\u008fr\u0011\u001a\u009b2-\u0082·\u00959´ÂLTmÞ\b`Þêï|\u008d\u0006\u0095\u008br\u001d\u001c§%)Ô³êE§ÎNP]Ú\u0018lÀöøx\u009d\u0002¢\u0019Ñ\u0093½\rÕ\u0087ý1M«Z%{Þ\u0083H¢ÂÇ|\u0011ö `B\u001aZ\u0097¬\u0001Þ»þ5\f¯\u001fY\u007fÒ\u0082L¿ÆÇp\u000bê2\u0019Ñ\u0093½\rÕ\u0087ý1M«Z%{Þ\u0083H¢ÂÇ|\u0011ö `B\u001aZ\u0097¯\u0001Î»à5\n\u0019Ñ\u0093ª\rÉ\u0087ø1M«P%{Þ\u008bH³ÂÍ|\u001dö|`M\u001aj\u0097°\u0001Ó»è5\u0000¯3YsÒ\u00adL¯ÆÅp\u000bê\"dT\u001ez\u008b\u009a\u0019Ñ\u0093¼\rÄ\u0087è1M«Y%sÞÁH¶ÂÓ|\u0017ö#\b\u0097\u0082ú\u001c\u0082\u0096® \u000bº\b4;ÏÄY®Ó\u0097mLçzq\u001c\u0019Ñ\u0093ª\rÔ\u0087è1\u0003«O%pÞÀH\u0094Âç|5ö<`\\\u001a`\u0097\u0098\u0001Ö»ú5\b\u0019Ñ\u0093½\rÑ\u0087ÿ1\u0003«\u0012%:Þ\u008cH¶ÂÔ|\u0011ö=`L\u001aj\u0019\u008c\u0093¶\r\u009e\u0087é1\r«R%`ÞÁH´ÂÄ|\u001cö!`E\u001al\u0097¸\u0001è»à5\f¯4YDÒ\u0096L£Æ×pN\u0082 \b\u009a\u0096²\u001cÅª!0~¾LEíÓ\u0098Yèç0m\rûi\u0081@\f\u0094\u009aÄ Ì® 4\u0018ÂhIº×\u008f]ûëa\u0019Ñ\u0093ª\rÉ\u0087ø1\u0016«X%yÞÀHªÂÈ|\u001aö|`F\u001al\u0097¾\u0001Ù»ì5G¯3Yt\u0019\u009c\u0093°\r×\u0087å1\r«En]ä&zEðtF\u009aÜÔRõ©L?(µD\u000b\u009a\u0081ð\u0017Èmìà=vNÌTB¨Øá.ù¥\u001b;,±]\u0007Þ\u009d¹\u0013Òiêü\u001brDÈv^\u008c}\u007f÷\u0004igãVU¸ÏöA×ºn,\n¦f\u0018¸\u0092Ò\u0004ê~Îó\u001felßvQ\u008aËÃ=Å¶.(\f¢z\u0019Ñ\u0093ª\rÉ\u0087ø1\u0016«X%yÞÀHªÂÈ|\u001aö|`F\u001al\u0097¾\u0001Ù»ë5\u0004¯5YMÒ¿L½ÆÖp\u0010ê&d\u001f\u001e{\u008b\u008c\u0019Ñ\u0093½\rÕ\u0087ý1M«S%qÞ\u0082H³ÂÆ|\rö6`Y\u001aq1\u0013»)%\u0001¯v\u0019\u0088\u0083Ë\rçö\u0014`wêVT\u0088Þ¿HÁ±\\;p¥\u001d/4\u0099Ë\u0003ß\u008d¶vFà~\u0017«\u009dÓ\u0003¸\u0089\u009e?{¥h+\bÐüFÐÌ¾rqøPn#\u0014\u000b\u0099Ã\u000f µ\u0087\u0019\u0090\u0093¼\rÝ\u0087þ1\u0011«[\u0019\u008c\u0093¶\r\u009e\u0087û1\u0010«R%pÞ\u009aH¥ÂÕ|Vö>`K\u001ak\u0097©\u0001Ñ»ï5\n¯4YnÒ\u0080L¨ÆÖ\u0019\u0099\u0093¼\rÞ\u0087òÆGLuÒ\u000bX1îÂt\u0087ú©\u0001\b\u0097|\u001d\u0011£Â)´¿\u0081Å¨H;Þ\u001ad\"êÂpü\u0086µ\r\u0015\u0093c\u0019\u001d¯Ã5±»\u009eÁ TAÚ\u0016`\u0003öÂ|þ\u0082¢\to\u009fk%\u0007«%1ðG\u0098Í´PJæzõÊ\u007føá\u0086k¼ÝOG\nÉ$2\u0085¤ñ.\u009c\u0090O\u001a9\u008c\fö%{¶í\u0097W¯ÙOCqµ8>\u0098 î*\u0090\u009cN\u0006<\u0088\u0013ò-gÌé\u009bS\u008eÅOOs±/:â¬â\u0016\u008a\u0098¨\u0002}t\u001fþ9\u0015\u0083\u009f±\u0001Ï\u008bõ=\u0006§C)mÒÌD¸ÎÕp\u0006úplE\u0016l\u009bÿ\rÞ·æ9\u0006£8UqÞÑ@²ÊÆ|\\æ8hM\u0012l\u0019\u008e\u0093¼\rÂ\u0087ø1\u000b«N%`ÞÁHµÂØ|\u000bö}`H\u001aa\u0097ò\u0001Ó»ë5\u000b¯5Y|ÒÜL¿ÆËpQê:dP\u001ek\u0019\u008e\u0093¼\rÂ\u0087ø1\u000b«N%`ÞÁHµÂØ|\u000bö}`H\u001aa\u0097ò\u0001Ó»ë5\u000b¯5Y|ÒÜL¿ÆËpQê;dR\u001ek\u0019\u008e\u0093¼\rÂ\u0087ø1\u000b«N%`ÞÁHµÂØ|\u000bö}`H\u001aa\u0097ò\u0001Ó»ë5\u000b¯5Y|ÒÜL¿ÆËpQê;d_\u001ek\u0019\u0088\u0093»\rß\u0087ó1\u0011«[\u0019¢\u0093\u0098ñø{\u0080åëoÍÙ(C;ÍP6© \u008b*ý\u0094=\u001e\u001f\u0088p\u0019\u0088\u0093»\rß\u0087ó1\u0005«H%qÞ\u009cH²Î_DZÚ8P\u0014æé|´ò\u0086\t`\u009fO\u0015)\u001eª\u0094\u0096\nú\u0080Ä6,¬k\"[\u0019\u009d\u0093±\rÂ\u0087ä1\u000f«T%aÞ\u0082\u0019\u008c\u0093¶\r\u009e\u0087û1\u0010«R%pÞ\u009aH¥ÂÕ|Vö7`O\u001as\u0097µ\u0001Ô»ë0{ºH$,®\u0000\u0018©\u0082ø\f\u0097\u0019\u0099\u0093¼\rÞ\u0087î1\u0010«T%wÈ~B[Ü9V\tà÷z³ô\u0090\u000fW\u0099Y\u0013~\u00ad©\u0019\u0099\u0093¼\rÞ\u0087î1\u0010«T%wÞ°H¾Â\u0099|Nö\f`\u001c\u001a1\u0019\u008c\u0093¶\r\u009e\u0087û1\u0010«R%pÞ\u009aH¥ÂÕ|Vö>`E\u001aa\u0097¹\u0001ÛËäAÔß²rNøaf\u0010ì2ZÖÀ\u009cN®µHvXüNb'èL^×Ä¯J\u009d±|'H\u00ad+\u0013ú\u0099\u0094\u000f«u\u008døInpÔ*ZæÀÕ6\u0093½x#O\u0019¿\u0093·\rÔ\u0087ù1\r«T%pÞÏH\u0095Âå|3ös`H\u001ap\u0097µ\u0001Û»ú5I¯&YtÒ\u0080LíÆÜpGê`\u0019¿\u0093·\rÔ\u0087ù1\r«T%pÞÏH\u0095Âå|3ös`H\u001ap\u0097µ\u0001Û»ú5I¯&YtÒ\u0080LíÆÜpGê`dn\u001e>\u008b×øãrÙìñf\u008cÐlJ Ä\u001f?÷©È#¼\u009drfIìfr\fø?NÔÔ\u0084Z·¡W*O |>\u0018´4\u0002\u009d\u0098ÌxVòbl\u0004æ2PÐÊ\u0092¼,6\u0016¨>\"[\u0094°\u000eò\u0080Ð{:í\u0005guÙöS\u0091Åø¿Ä2\u0012¤s\u0019\u008c\u0093¶\r\u009e\u0087à1\u0007«O%zÞ\u008aHªÂ\u008f|\tö6`G\u001apFÉ\u0019\u008c\u0093¶\r\u009e\u0087ø1\u0007«^%aÞ\u009dH£\u0019Î\u0019\u008c\u0093¶\r\u009e\u0087é1\u0017«T%xÞ\u008bHèÂÑ|\nö<`N\u001ap\u0097¿\u0001Ã=´·\u0080)ð£Ë\u0015\u0011\u008fi\u0001\u0000úõ\"ê¨Ð6ø¼\u008f\nq\u00902\u001e\u001eåís\u008eù¡GwÍ[[+!\u0006¬È:¡\u0080\u009a\u000ef\u0094Hb\t*µ \u0090>ò´Â\u0002<\u0098x\u0016[íì{\u0099ñéO?ÅPSa)L¤\u009e2þ\u0088Ð\u0006,\u009c\u000fì\u0097f²øÐràÄ\u001e^ZÐy+¾½°7\u0097\u0089@\u0003r\u0095Wïob¹ôæNøÀ_Zx¬:'\u009b¹¦3Ä\u0085\u0014\u001f*\u0091Vëe~²ðÌJ£ÜT\u0019\u0099\u0093¼\rÞ\u0087î1\u0010«T%wÞÀH¡ÂÎ|\u0017ö4`F\u001a`\u0097\u0083\u0001Ä»ê5\u0002¯oY|Ò\u0097L£ÆÁp\rê?dR\u0019\u0099\u0093¼\rÞ\u0087î1\u0010«T%wÞÀH°ÂÃ|\u0017ö+`\u0012\u001a3\u0097¬\u0001\u0098»ø5\u000b¯/YcÒÊLûÆÔ\u0081\u008c\u000b£\u0095Ê\u001fù©\u001b3M½.F\u0089Ð·Zßä2n!øO\u0082x\u000f¦\u0099Ì#þ\u00ad#7-Á6JÑÔ÷^Öè\u000fr-üA\u0086o\u0013\u009f\u009dÌ'ß±\u0001;jÅ=m\u009bç¡y\u0089óþE\u001aßEQwª\u0094<¾¶×\b\u000b\u0082!\u0014Oå]ogñO{8ÍÜW\u0083Ù±\"W´z>\u0011\u0080Î\nç\u009cÕæ¶kxý\u000fG3ÉÜS¿¥¬.J°r:\u0012\u008cË\u0016õ\u0098\u0090â«w[ù\u0005C0\u0019¿\u0093·\rÔ\u0087ù1\r«T%pÞÂH¾Â\u0099|Nheâ_|wö\u0000@þÚ½T\u0091¯b9\u0001³,\rø\u0087É\u0011³k\u0080æTp'ÊIDéÞÍ\u0019\u008a\u0093¼\rÃ\u0087ÿ1OÓ<Y\u001cÇrMTûçaåïÉ\u0014'\u0082C\b{¶¶<\u0095ªôÐ\u0083]\u0007ËnqJÿ²e\u0098rZøif\bì+Z\u0099À\u0080N¶µ\u0014#~©\u0015\u0017Ä\u009dè\u000b\u0094qµüpj\u0011\u0019\u008f\u0093¼\rÝ\u0087þ1L«N%rÞÁH ÂÀ|\u0013ö6`u\u001af\u0097½\u0001Ú»ë5\u001b¯!ó=y\u000eçomLÛþAüÏÀ4s¢\u0018(p\u0096®\u001c¾\u008aüðÒ}\u0000ëvQUß¯E\u008b\u0019\u008c\u0093¶\r\u009e\u0087à1\u0007«O%zÞ\u008aHªÂ\u008f|\u0019ö=`N\u001aw\u0097³\u0001Þ»ê5G¯1Y~Ò\u009fL¸ÆÀr²ø\u0088f ì×Z3ÀlN^µÿ#\u0089©ú\u0017+\u009d\u0018\u000b:qZü\u0094jíÐï^9Ä\u001f2H¹©\u001e\u009c\u0094¦\n\u008e\u0080ô6\u0016¬@\"*Ù\u009dO£ÅØ{\u0004ñ'g\u0014\u001ds\u0090¥\u0006É¼ù2\u001c¨\"^{Õ\u0090K´ÁÚw\u001b\u0019\u008c\u0093¶\r\u009e\u0087û1\u0010«R%pÞ\u009aH¥ÂÕ|Vö1`_\u001al\u0097°\u0001Ó» 5\u000f¯)YuÒ\u0095L¨ÆÖp\u000fê$dX\u001ef\u008b\u0097RfØ\\FtÌ\u0012zñà¤n\u008a\u0095`\u0003A\u0089e7ð½Ì+©Q\u0083ÜRJsð\u0002~êäÄ\u0012\u0096\u0099}\u0007U\u008d>;ç¡Õ/µU\u0096$Ó®é0Áº§\fD\u0096\u0011\u0018?ãÕuôÿ¡ABËt]\u0001'tªá<\u009d\u0086¸\bZ\u0092{djïËqûû\u0095MG×lY\u001c#'¶Î8\u008c\u0082¤\u0014G\u0019\u008c\u0093¶\r\u009e\u0087ý1\u0007«S%pÞ\u0080H´Â\u008f|\u001aö&`C\u001ai\u0097¸\u0001\u0099»è5\u0000¯.Y|Ò\u0097L¿ÆÔp\rê?d_\u001e|ù\u0000s:í\u0012gqÑ\u008bKßÅü>\f¨8\"r\u009c\u0090\u0016³\u0080Íúäw~áY[wÕ\u008cO ¹ó2P¬'&A\u0090\u009d\n½\u0084Øþök\u001fåD_pÉ\u008eC¿\u0019Äí1g]ù5s\u001dÅ\u00ad_¬Ñ\u0091*b¼S6\u001e\u0088è\u0002Ú\u0094ºî\u0080_þÕ\u0092KúÁÒwbíacT\u0098£\u000e\u0082\u0084ë:#°S&g\\KÑ\u0080GýýÃs'é\u0001\u001fP\u0094\u0082\n\u0085\u0080î6>¬\u0000\"z\u0019Ñ\u0093½\rÕ\u0087ý1M«N%{Þ\u008cH\u00adÂÄ|\fö|`M\u001a`\u0097²\u0001Î»ê|7ö[h3â\u001bT«Î¨@\u009d»j-K§\"\u0019ê\u0093\u009a\u0005½\u007f\u0086òWd$Þ\fÜMV6ÈUBdôÑnÐàí\u001b\u001e\u008d/\u0007b¹\u00903½¥×ßúR%\u0019Ñ\u0093ª\rÉ\u0087ø1\u0016«X%yÞÀHªÂÈ|\u001aö|`F\u001al\u0097¾\u0001Ô»Ñ5\u0004¯!YwÒ\u009eL¢ÆÇp ê2dT\u001ej\u008b\u0096\u0005Ý¿Ê)\u001d£\"]sÖ\u008c@þúØtínaä\rzeðMFýÜïR×©+?)µv\u000b¸\u0081\u0090ývw\u001aércZÕêOøÁÀ:<¬>&r\u0098¶\u0012\u0099\u0084èj\u0096àú~\u0092ôºB\nØ\tV<\u00adË;ê±\u0083\u000fK\u0085;\u0013\u000fi1äïr\u0096È¦FBÜc*9¡Ç?î !*Z´9>\b\u0088æ\u0012¨\u009c\u0089g0ñZ{8ÅêO\u008cÙ¶£\u009c.N¸%\u0002\r\u008cí\u0016Öà\u0084knõY\u007f1ÉýSùÝ«§\u00962z¼d\u0006\u0016\u0090ó\u0006é\u008c\u0085\u0012í\u0098Å.u´g:_Á£W\u009fÝúc#é\u000e\u0019Ñ\u0093½\rÕ\u0087ý1M«_%gÞ\u009bH¡ÂØ|\nö<b^è2vZürJÂÐÐ^è¥\u00143$¹K\u0007\u0090\u008d²\u0096À\u001c¬\u0082Ä\bì¾\\$NªvQ\u008aÇ¸MÂó\u0000y'\u0019Ñ\u0093½\rÕ\u0087ý1M«_%gÞ\u009bH°ÂÌ|\u000bö4l\u008dæáx\u0089ò¡D\u0011Þ\u0003P;«Ç=ê·\u009a\tE\u0083f\u0015\u0006o:\u0019Ñ\u0093½\rÕ\u0087ý1M«_%gÞ\u009bH\u0099ÂÈ|\u0015ö6\u0019Ñ\u0093½\rÑ\u0087ÿ1\u0003«\u0012%pÞ\u0080H±ÂÏ|\u0014ö<`K\u001aa\u0097¯\u0001\u0098» 5\u0011¯\"Y4Ò\u0090L¾ÆÐp\u0014\u0019Ñ\u0093´\rÞ\u0087ÿ1M«J%}Þ\u0081H¢ÂÎ|\u000fö `\u0005\u001aG\u0097¯\u0001Ã»Ý5\u0001¯!YiÒ\u0097L©Æâp\u0010ê:dU\u001em\u008b\u0091¼\u00ad6Õ¨¾\"\u0098\u0094}\u000en\u0080\u0001{üíÊg²ÙvS[Å%¶\u0001<p¢\u0019(d\u009e\u0097=à·\u0098)ó£Õ\u00150\u008f#\u0001Vú»l\u009bæöXfÒ\u000fDz>D³\u009eª\u0011 #¾Y4o\u0082\u0086\u0018Ú\u0096ÿmIû)qFÏ\u009cE¿ÓÄ©ä$'²W\b(\u0086\u0092\u001c§\u0017R\u009dp\u0003\u0012\u0089\f?î¥¸+\u0087ÐpFdÌ\u0012rÌø½n\u0099\u0014ª\u0019Ñ\u0093¼\rÄ\u0087è1M«P%qÞ\u008bH¯ÂÀ|'ö0`E\u001aa\u0097¹\u0001Ô»ý5G¯8YvÒ\u009e\u008a°\u0000\u0099\u009eé\u0014Â¢=8e¶YM Û\u0081Qþ´{>\u0016 n*B\u009cç\u0006ú\u0088Ñs0å\u0002o\u007fÑ¡\u0095\u0093\u001fÿ\u0081\u0093\u000b½½A'P©2RÂÄóN\u008dðVz~ì\t\u0096#\u001bí\u008dÚ7â¹O#rÕv^ÑÀÿJ\u0096üNf:è\u000b\u0092'\u0007Í\u0019Ñ\u0093©\rÂ\u0087ä1\u0001«\u0012%wÞ\u009fH³ÂÈ|\u0016ö5`E>´´»*Ñ â\u0016\t\u008cY\u0002jù\u008aÿ\nufë\na$×ØMÉÃ¢8]®n$\u0019\u009a\u008c\u0010ø\u0086\u0083ü±qaç\u0005]9Ó×Iè¿ï4Jªc \r\u0096\u008b\f½\u0082Åø°mWã\fY`ÏÚEõ»¦0P¦d\u001c\u0006\u00920\bô~\u009bôúiPß\u007fU.ËÝAø·\u0093,B".getBytes(CharEncoding.ISO_8859_1)).asCharBuffer().get(cArr, 0, 1959);
            _CREATION = cArr;
            _BOUNDARY = 7053545868360520665L;
        }

        /* JADX WARN: Multi-variable search skipped. Vars limit reached: 5644 (expected less than 5000) */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v378 */
        /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
            java.util.NoSuchElementException
            	at java.base/java.util.TreeMap.key(Unknown Source)
            	at java.base/java.util.TreeMap.lastKey(Unknown Source)
            	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
            	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
            	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
            */
        public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r62, int r63, int r64, int r65) {
            /*
                Method dump skipped, instruction units count: 14327
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.bridge.JavaMethodWrapper.AnonymousClass10.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
        }
    };
    private static final boolean DEBUG = PrinterHolder.getPrinter().shouldDisplayLogMessage(ReactDebugOverlayTags.BRIDGE_CALLS);

    static abstract class ArgumentExtractor<T> {
        public abstract T extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i);

        public int getJSArgumentsNeeded() {
            return 1;
        }

        private ArgumentExtractor() {
        }
    }

    private static char paramTypeToChar(Class cls) {
        char cCommonTypeToChar = commonTypeToChar(cls);
        if (cCommonTypeToChar != 0) {
            return cCommonTypeToChar;
        }
        if (cls == Callback.class) {
            return 'X';
        }
        if (cls == Promise.class) {
            return 'P';
        }
        if (cls == ReadableMap.class) {
            return 'M';
        }
        if (cls == ReadableArray.class) {
            return 'A';
        }
        if (cls == Dynamic.class) {
            return 'Y';
        }
        throw new RuntimeException("Got unknown param class: " + cls.getSimpleName());
    }

    private static char returnTypeToChar(Class cls) {
        char cCommonTypeToChar = commonTypeToChar(cls);
        if (cCommonTypeToChar != 0) {
            return cCommonTypeToChar;
        }
        if (cls == Void.TYPE) {
            return 'v';
        }
        if (cls == WritableMap.class) {
            return 'M';
        }
        if (cls == WritableArray.class) {
            return 'A';
        }
        throw new RuntimeException("Got unknown return class: " + cls.getSimpleName());
    }

    private static char commonTypeToChar(Class cls) {
        if (cls == Boolean.TYPE) {
            return 'z';
        }
        if (cls == Boolean.class) {
            return 'Z';
        }
        if (cls == Integer.TYPE) {
            return 'i';
        }
        if (cls == Integer.class) {
            return 'I';
        }
        if (cls == Double.TYPE) {
            return 'd';
        }
        if (cls == Double.class) {
            return 'D';
        }
        if (cls == Float.TYPE) {
            return 'f';
        }
        if (cls == Float.class) {
            return 'F';
        }
        return cls == String.class ? 'S' : (char) 0;
    }

    public JavaMethodWrapper(JavaModuleWrapper javaModuleWrapper, Method method, boolean z) {
        this.mType = BaseJavaModule.METHOD_TYPE_ASYNC;
        this.mModuleWrapper = javaModuleWrapper;
        this.mMethod = method;
        method.setAccessible(true);
        Class<?>[] parameterTypes = method.getParameterTypes();
        this.mParameterTypes = parameterTypes;
        int length = parameterTypes.length;
        this.mParamLength = length;
        if (z) {
            this.mType = "sync";
        } else {
            if (length <= 0 || parameterTypes[length - 1] != Promise.class) {
                return;
            }
            this.mType = BaseJavaModule.METHOD_TYPE_PROMISE;
        }
    }

    private void processArguments() {
        if (this.mArgumentsProcessed) {
            return;
        }
        SystraceMessage.beginSection(0L, "processArguments").arg("method", this.mModuleWrapper.getName() + "." + this.mMethod.getName()).flush();
        try {
            this.mArgumentsProcessed = true;
            this.mArgumentExtractors = buildArgumentExtractors(this.mParameterTypes);
            this.mSignature = buildSignature(this.mMethod, this.mParameterTypes, this.mType.equals("sync"));
            this.mArguments = new Object[this.mParameterTypes.length];
            this.mJSArgumentsNeeded = calculateJSArgumentsNeeded();
        } finally {
            SystraceMessage.endSection(0L).flush();
        }
    }

    public Method getMethod() {
        return this.mMethod;
    }

    public String getSignature() {
        if (!this.mArgumentsProcessed) {
            processArguments();
        }
        return (String) Assertions.assertNotNull(this.mSignature);
    }

    private String buildSignature(Method method, Class[] clsArr, boolean z) {
        StringBuilder sb = new StringBuilder(clsArr.length + 2);
        if (z) {
            sb.append(returnTypeToChar(method.getReturnType()));
            sb.append('.');
        } else {
            sb.append("v.");
        }
        int i = 0;
        while (i < clsArr.length) {
            Class cls = clsArr[i];
            if (cls == Promise.class) {
                Assertions.assertCondition(i == clsArr.length - 1, "Promise must be used as last parameter only");
            }
            sb.append(paramTypeToChar(cls));
            i++;
        }
        return sb.toString();
    }

    private ArgumentExtractor[] buildArgumentExtractors(Class[] clsArr) {
        ArgumentExtractor[] argumentExtractorArr = new ArgumentExtractor[clsArr.length];
        int jSArgumentsNeeded = 0;
        while (jSArgumentsNeeded < clsArr.length) {
            Class cls = clsArr[jSArgumentsNeeded];
            if (cls == Boolean.class || cls == Boolean.TYPE) {
                argumentExtractorArr[jSArgumentsNeeded] = ARGUMENT_EXTRACTOR_BOOLEAN;
            } else if (cls == Integer.class || cls == Integer.TYPE) {
                argumentExtractorArr[jSArgumentsNeeded] = ARGUMENT_EXTRACTOR_INTEGER;
            } else if (cls == Double.class || cls == Double.TYPE) {
                argumentExtractorArr[jSArgumentsNeeded] = ARGUMENT_EXTRACTOR_DOUBLE;
            } else if (cls == Float.class || cls == Float.TYPE) {
                argumentExtractorArr[jSArgumentsNeeded] = ARGUMENT_EXTRACTOR_FLOAT;
            } else if (cls == String.class) {
                argumentExtractorArr[jSArgumentsNeeded] = ARGUMENT_EXTRACTOR_STRING;
            } else if (cls == Callback.class) {
                argumentExtractorArr[jSArgumentsNeeded] = ARGUMENT_EXTRACTOR_CALLBACK;
            } else if (cls == Promise.class) {
                argumentExtractorArr[jSArgumentsNeeded] = ARGUMENT_EXTRACTOR_PROMISE;
                Assertions.assertCondition(jSArgumentsNeeded == clsArr.length - 1, "Promise must be used as last parameter only");
            } else if (cls == ReadableMap.class) {
                argumentExtractorArr[jSArgumentsNeeded] = ARGUMENT_EXTRACTOR_MAP;
            } else if (cls == ReadableArray.class) {
                argumentExtractorArr[jSArgumentsNeeded] = ARGUMENT_EXTRACTOR_ARRAY;
            } else if (cls == Dynamic.class) {
                argumentExtractorArr[jSArgumentsNeeded] = ARGUMENT_EXTRACTOR_DYNAMIC;
            } else {
                throw new RuntimeException("Got unknown argument class: " + cls.getSimpleName());
            }
            jSArgumentsNeeded += argumentExtractorArr[jSArgumentsNeeded].getJSArgumentsNeeded();
        }
        return argumentExtractorArr;
    }

    private int calculateJSArgumentsNeeded() {
        int jSArgumentsNeeded = 0;
        for (ArgumentExtractor argumentExtractor : (ArgumentExtractor[]) Assertions.assertNotNull(this.mArgumentExtractors)) {
            jSArgumentsNeeded += argumentExtractor.getJSArgumentsNeeded();
        }
        return jSArgumentsNeeded;
    }

    private String getAffectedRange(int i, int i2) {
        if (i2 > 1) {
            return "" + i + "-" + ((i + i2) - 1);
        }
        return "" + i;
    }

    @Override // com.facebook.react.bridge.JavaModuleWrapper.NativeMethod
    public void invoke(JSInstance jSInstance, ReadableArray readableArray) {
        String str = this.mModuleWrapper.getName() + "." + this.mMethod.getName();
        SystraceMessage.beginSection(0L, "callJavaModuleMethod").arg("method", str).flush();
        if (DEBUG) {
            PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.BRIDGE_CALLS, "JS->Java: %s.%s()", this.mModuleWrapper.getName(), this.mMethod.getName());
        }
        try {
            if (!this.mArgumentsProcessed) {
                processArguments();
            }
            if (this.mArguments == null || this.mArgumentExtractors == null) {
                throw new Error("processArguments failed");
            }
            if (this.mJSArgumentsNeeded != readableArray.size()) {
                throw new NativeArgumentsParseException(str + " got " + readableArray.size() + " arguments, expected " + this.mJSArgumentsNeeded);
            }
            int i = 0;
            int jSArgumentsNeeded = 0;
            while (true) {
                try {
                    ArgumentExtractor[] argumentExtractorArr = this.mArgumentExtractors;
                    if (i < argumentExtractorArr.length) {
                        this.mArguments[i] = argumentExtractorArr[i].extractArgument(jSInstance, readableArray, jSArgumentsNeeded);
                        jSArgumentsNeeded += this.mArgumentExtractors[i].getJSArgumentsNeeded();
                        i++;
                    } else {
                        try {
                            this.mMethod.invoke(this.mModuleWrapper.getModule(), this.mArguments);
                            SystraceMessage.endSection(0L).flush();
                            return;
                        } catch (IllegalAccessException e) {
                            e = e;
                            throw new RuntimeException(createInvokeExceptionMessage(str), e);
                        } catch (IllegalArgumentException e2) {
                            e = e2;
                            throw new RuntimeException(createInvokeExceptionMessage(str), e);
                        } catch (InvocationTargetException e3) {
                            if (e3.getCause() instanceof RuntimeException) {
                                throw ((RuntimeException) e3.getCause());
                            }
                            throw new RuntimeException(createInvokeExceptionMessage(str), e3);
                        }
                    }
                } catch (UnexpectedNativeTypeException e4) {
                    e = e4;
                    throw new NativeArgumentsParseException(e.getMessage() + " (constructing arguments for " + str + " at argument index " + getAffectedRange(jSArgumentsNeeded, this.mArgumentExtractors[i].getJSArgumentsNeeded()) + ")", e);
                } catch (NullPointerException e5) {
                    e = e5;
                    throw new NativeArgumentsParseException(e.getMessage() + " (constructing arguments for " + str + " at argument index " + getAffectedRange(jSArgumentsNeeded, this.mArgumentExtractors[i].getJSArgumentsNeeded()) + ")", e);
                }
            }
        } catch (Throwable th) {
            SystraceMessage.endSection(0L).flush();
            throw th;
        }
    }

    private static String createInvokeExceptionMessage(String str) {
        return "Could not invoke " + str;
    }

    @Override // com.facebook.react.bridge.JavaModuleWrapper.NativeMethod
    public String getType() {
        return this.mType;
    }
}
