package com.google.crypto.tink.jwt;

import android.graphics.Color;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Process;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import ch.qos.logback.core.net.SyslogConstants;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.crypto.tink.internal.EllipticCurvesUtil;
import com.google.errorprone.annotations.Immutable;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.spec.ECParameterSpec;
import java.util.Objects;
import java.util.Optional;
import o.ArtificialStackFrames;
import o._CREATION;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes5.dex */
public final class JwtEcdsaParameters extends JwtSignatureParameters {
    private final Algorithm algorithm;
    private final KidStrategy kidStrategy;

    @Immutable
    public static final class KidStrategy {
        private final String name;
        public static final KidStrategy BASE64_ENCODED_KEY_ID = new KidStrategy("BASE64_ENCODED_KEY_ID");
        public static final KidStrategy IGNORED = new KidStrategy("IGNORED");
        public static final KidStrategy CUSTOM = new KidStrategy("CUSTOM");

        private KidStrategy(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }

    @Immutable
    public static final class Algorithm {
        public static final Algorithm ES256 = new Algorithm("ES256", EllipticCurvesUtil.NIST_P256_PARAMS);
        public static final Algorithm ES384 = new Algorithm("ES384", EllipticCurvesUtil.NIST_P384_PARAMS);
        public static final Algorithm ES512 = new Algorithm("ES512", EllipticCurvesUtil.NIST_P521_PARAMS);
        private final ECParameterSpec ecParameterSpec;
        private final String name;

        private Algorithm(String str, ECParameterSpec eCParameterSpec) {
            this.name = str;
            this.ecParameterSpec = eCParameterSpec;
        }

        public String toString() {
            return this.name;
        }

        public String getStandardName() {
            return this.name;
        }

        public ECParameterSpec getEcParameterSpec() {
            return this.ecParameterSpec;
        }
    }

    public static final class Builder {
        private static long _BOUNDARY;
        private static char[] _CREATION;
        Optional<Algorithm> algorithm;
        Optional<KidStrategy> kidStrategy;
        private static final byte[] $$c = {67, 32, -18, 9};
        private static final int $$d = 14;
        private static int $10 = 0;
        private static int $11 = 1;
        private static final byte[] $$a = {SignedBytes.MAX_POWER_OF_TWO, -46, -98, Ascii.DC2, 52, 2, -47, -11, 0, -17, -53, Ascii.CR, 1, Ascii.FF, -11, 8, -22, -1, 3, -17, 5, 53};
        private static final int $$b = SyslogConstants.LOG_LOCAL1;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;

        /* JADX WARN: Code duplicated, block: B:10:0x0026  */
        /* JADX WARN: Code duplicated, block: B:8:0x0020  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002b). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$e(int r6, short r7, short r8) {
            /*
                byte[] r0 = com.google.crypto.tink.jwt.JwtEcdsaParameters.Builder.$$c
                int r6 = r6 * 3
                int r6 = 4 - r6
                int r8 = 106 - r8
                int r7 = r7 * 3
                int r1 = r7 + 1
                byte[] r1 = new byte[r1]
                r2 = 0
                if (r0 != 0) goto L15
                r8 = r6
                r3 = r7
                r4 = r2
                goto L2b
            L15:
                r3 = r2
            L16:
                r5 = r8
                r8 = r6
                r6 = r5
                byte r4 = (byte) r6
                r1[r3] = r4
                int r4 = r3 + 1
                if (r3 != r7) goto L26
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                return r6
            L26:
                r3 = r0[r8]
                r5 = r8
                r8 = r6
                r6 = r5
            L2b:
                int r6 = r6 + 1
                int r3 = -r3
                int r8 = r8 + r3
                r3 = r4
                goto L16
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.jwt.JwtEcdsaParameters.Builder.$$e(int, short, short):java.lang.String");
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
        private static void a(int r6, int r7, byte r8, java.lang.Object[] r9) {
            /*
                int r0 = 4 - r7
                int r6 = r6 + 4
                int r8 = r8 + 66
                byte[] r1 = com.google.crypto.tink.jwt.JwtEcdsaParameters.Builder.$$a
                byte[] r0 = new byte[r0]
                int r7 = 3 - r7
                r2 = 0
                if (r1 != 0) goto L13
                r3 = r8
                r4 = r2
                r8 = r6
                goto L2a
            L13:
                r3 = r2
            L14:
                byte r4 = (byte) r8
                r0[r3] = r4
                if (r3 != r7) goto L21
                java.lang.String r6 = new java.lang.String
                r6.<init>(r0, r2)
                r9[r2] = r6
                return
            L21:
                int r3 = r3 + 1
                r4 = r1[r6]
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.jwt.JwtEcdsaParameters.Builder.a(int, int, byte, java.lang.Object[]):void");
        }

        private static void b(char c, int i, int i2, Object[] objArr) throws Throwable {
            int i3 = 2;
            int i4 = 2 % 2;
            _CREATION _creation = new _CREATION();
            long[] jArr = new long[i2];
            _creation.b = 0;
            while (_creation.b < i2) {
                int i5 = $11 + 75;
                $10 = i5 % 128;
                if (i5 % i3 != 0) {
                    int i6 = _creation.b;
                    try {
                        Object[] objArr2 = {Integer.valueOf(_CREATION[i << i6])};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) 0;
                            byte b2 = b;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getWindowTouchSlop() >> 8) + 8, (char) (9279 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))), 1977 - (Process.myPid() >> 22), 1113883676, false, $$e(b, b2, (byte) (b2 + 2)), new Class[]{Integer.TYPE});
                        }
                        Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i6), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                        if (objAccessartificialFrame2 == null) {
                            byte b3 = (byte) 0;
                            byte b4 = b3;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(KeyEvent.getDeadChar(0, 0) + 30, (char) (49362 - (ViewConfiguration.getLongPressTimeout() >> 16)), KeyEvent.keyCodeFromString("") + 684, -115095555, false, $$e(b3, b4, b4), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                        }
                        jArr[i6] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                        Object[] objArr4 = {_creation, _creation};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                        if (objAccessartificialFrame3 == null) {
                            byte b5 = (byte) 0;
                            byte b6 = b5;
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(25 - KeyEvent.keyCodeFromString(""), (char) (30068 - (ViewConfiguration.getScrollDefaultDelay() >> 16)), 816 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 1897803493, false, $$e(b5, b6, (byte) (b6 + 3)), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } else {
                    int i7 = _creation.b;
                    Object[] objArr5 = {Integer.valueOf(_CREATION[i + i7])};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-587087340);
                    if (objAccessartificialFrame4 == null) {
                        byte b7 = (byte) 0;
                        byte b8 = b7;
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 7, (char) (9279 - View.resolveSizeAndState(0, 0, 0)), 1977 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 1113883676, false, $$e(b7, b8, (byte) (b8 + 2)), new Class[]{Integer.TYPE});
                    }
                    Object[] objArr6 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).longValue()), Long.valueOf(i7), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1715896821);
                    if (objAccessartificialFrame5 == null) {
                        byte b9 = (byte) 0;
                        byte b10 = b9;
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(((Process.getThreadPriority(0) + 20) >> 6) + 30, (char) (ExpandableListView.getPackedPositionType(0L) + 49362), 685 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), -115095555, false, $$e(b9, b10, b10), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                    }
                    jArr[i7] = ((Long) ((Method) objAccessartificialFrame5).invoke(null, objArr6)).longValue();
                    Object[] objArr7 = {_creation, _creation};
                    Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-293902099);
                    if (objAccessartificialFrame6 == null) {
                        byte b11 = (byte) 0;
                        byte b12 = b11;
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 25, (char) (Color.blue(0) + 30068), 815 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 1897803493, false, $$e(b11, b12, (byte) (b12 + 3)), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame6).invoke(null, objArr7);
                }
                i3 = 2;
            }
            char[] cArr = new char[i2];
            _creation.b = 0;
            while (_creation.b < i2) {
                int i8 = $11 + 41;
                $10 = i8 % 128;
                int i9 = i8 % 2;
                cArr[_creation.b] = (char) jArr[_creation.b];
                try {
                    Object[] objArr8 = {_creation, _creation};
                    Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-293902099);
                    if (objAccessartificialFrame7 == null) {
                        byte b13 = (byte) 0;
                        byte b14 = b13;
                        objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(KeyEvent.getDeadChar(0, 0) + 25, (char) (30067 - MotionEvent.axisFromString("")), ((byte) KeyEvent.getModifierMetaStateMask()) + 817, 1897803493, false, $$e(b13, b14, (byte) (b14 + 3)), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame7).invoke(null, objArr8);
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            }
            objArr[0] = new String(cArr);
        }

        public Builder setKidStrategy(KidStrategy kidStrategy) {
            this.kidStrategy = Optional.of(kidStrategy);
            return this;
        }

        public Builder setAlgorithm(Algorithm algorithm) {
            this.algorithm = Optional.of(algorithm);
            return this;
        }

        public JwtEcdsaParameters build() throws GeneralSecurityException {
            if (!this.algorithm.isPresent()) {
                throw new GeneralSecurityException("Algorithm must be set");
            }
            if (!this.kidStrategy.isPresent()) {
                throw new GeneralSecurityException("KidStrategy must be set");
            }
            return new JwtEcdsaParameters(this.kidStrategy.get(), this.algorithm.get());
        }

        private Builder() {
            this.kidStrategy = Optional.empty();
            this.algorithm = Optional.empty();
        }

        static {
            char[] cArr = new char[1959];
            ByteBuffer.wrap("TUw\u009f\u0013\u001d>\u008fÚQå\u0098\u0081\u0013¬\u0091H\u0016k\u00957\u0019Ò\u0082þ\u001e\u0099¨¥\u0015@\u0091l\u000e\u000f\u0099+\rö\u009a\u0092\u001d½°Y\u001fd\u009d\u0000\u0003#\u0080Ï\u0005\u0019Ñ:\u001b^\u0099s\u000b\u0097Õ¨\u001cÌ\u0097á\u0015\u0005\u0092&\u0011z\u009d\u009f\u0006³\u009aÔ,è\u0080\r\u0018!\u009eB\nf³»\tß\u009að\u0019\u0014\u008b)\u001dM\u0082Azb°\u00062+ Ï~ð·\u0094<¹¾]9~º\"6Ç\u00adë1\u008c\u0087°(U£y+\u001a§\u0019Ñ:\f^\u0085s\u000e\u0097Õ¨\u0016Ì\u0097á\u001d\u0005\u0083&\u001bz\u0091\u009fZ³\u0095Ô\u001cè\u009c\r\u0015!\u0088B\u0006f\u009f»\u0005ßµð\t\u0014\u0089)\u001dM\u0092n\u0002\u0082\u0096§\u001c\u0019Ñ:\u001a^\u0088s\u001e\u0097Õ¨\u001fÌ\u009fáW\u0005\u0086&\u0005z\u009b\u009f\u0005\u0019Ñ:\u001a^\u0088s\u001e\u0097Õ¨\bÌ\u0091á\u0014\u0005Ø&\u0007z\u0086\u009f\u001a³\u0082®\\\u008d\u0081é\u0015Ä\u0093 \u0016\u001f\u0084{\u0011VÛ²)\u0091¼Í4(\u0097\u0004\tc\u009b_9º\u009d\u0096\u0017õ\u0083\u0019Ñ:\u001b^\u009ds\t\u0097\u009b¨TÌÖá\u001a\u0005\u0086&\u0002z\u009d\u009f\u001b³\u0094Ô\u001c\u0096ÓµOÑ\u008dü@\u0018Ê'KCÓn\b\u008aÛ©MõÏ\u0010X<Â[EgË\u0082q®ßÍUéÇ4mPÑ\u007fZ\u009bÄ¦\u0007\u0019\u008c:\u0010^Òs\u001f\u0097\u0095¨\u0014Ì\u008cáW\u0005\u0084&\u0012z\u0090\u009f\u0007³\u009dÔ\u001aè\u0094\r.!\u0080B\nf\u0098»2ß\u008eð\u0005\u0014\u009b)[\u0019Ñ:\f^\u0085s\u000e\u0097\u008e¨\u001eÌ\u0095áV\u0005\u009a&\u001ez\u0096\u009fZ³\u009eÔ\u001aè\u0092\r\u001f!\u008cBAf\u009f»\u0002\u001aØ9R]ßpW\u0094Ñ«GÉ\u0080ê\u001c \u0092\u0083OçÆÊM.Í\u0011]uÖX\u0015¼×\u009f]ÃÙ&\u0019\nßmUQÞ´G\u0098ûûaß\u0082\u0002@fÌIE\u00adÞ\u0090\u0007ôÆ×K;É\u001eRBÓ¥O\u0089ÏP&sû\u0017r:ùÞyáé\u0085b¨¡Lcoé3mÖ\u00adúk\u009dá¡jDóhO\u000bÕ/6òê\u0096o¹ó]o\u0014ÿ7\"S«~ \u009a ¥0Á»ìx\b´+0w¸\u0092t¾°Ù4å¼\u00001,¥O,k·¶\u0015Ò\u0089ý5\u0019´$(@¸cg\u008f¹ª$\u0019Ñ:\u001b^\u0099s\u000b\u0097Õ¨\u0015Ì\u009dá\u0014\u0005\u0083&\u0010z\u0081\u009f\u0010³\u0081Ô\u0007\u0019\u008c:\u0010^Òs\u001f\u0097\u008f¨\u0012Ì\u0094á\u001d\u0005Ø&\u001fz\u009b\u009f\u0006³\u0086\u0019\u0090:\u001a^\u009ds\u000e\u0097\u009f¨UÌ\u0096á\u001c\u0005\u0082\u001fJ<\u0094X\u0015u\u0089\u0091\u0002®ÏÊ\u0005ç\u008b\u0003\u0001 \u0089|\u001c\u0099\u0097µ\u001aÒ\u009cî\u000e\u000b\u0087'\u0006\u0000Q#ÛGPjÉ\u008eH±Ü\u0019\u008c:\u0010^Òs\r\u0097\u0088¨\u0014Ì\u009cá\f\u0005\u0095&\u0003zÚ\u009f\u0018³\u0093Ô\u001dè\u0085\r\u0017!\u008fB\ff\u0098»\u0018ß\u0098ð\u000e\u0014\u009a\u0019\u0099:\u001a^\u0092s\u0004\u0019\u008e:\u001a^\u008es\u000e\u0097\u0093¨\bÌ\u008cáW\u0005\u0085&\u000ez\u0087\u009f[³\u0090Ô\u0017èÞ\r\u0015!\u008bB\rf\u0099»\nßÄð\f\u0014\u0098)\u001cMÈn\u0001\u0082\u0085§\u000eû\u0087\u001c<0\u0087U\u0011i«\u008a\u0000®®Ã8ç´8?\\½q+\u0095³¶%e>Fª\">\u000f¾ë#Ô¸°<\u009dçy5Z¾\u00067ãëÏ ¨§\u0094nq¥];>½\u001a)Çº£t\u008c¼h(U¬1x\u0012±þ5Û¾\u00877`\u008cL7)¡\u0015\u001bö°Ò\u001a¿\u0088\u009b\u0004D\u008f \u0007\r\u009bOòlf\bò%rÁïþt\u009að·+Sùpr,ûÉ'åì\u0082k¾¢[iw÷\u0014q0åív\u0089¸¦eBû\u007f;\u001bù8jÔñ\u0019\u008e:\u001a^\u008es\u000e\u0097\u0093¨\bÌ\u008cáW\u0005\u0085&\u000ez\u0087\u009f[³\u0090Ô\u0017èÞ\r\u0015!\u008bB\rf\u0099»\nßÄð\u0019\u0014\u0087)GM\u008an\u0006\u0082\u0087\u0019\u008e:\u001a^\u008es\u000e\u0097\u0093¨\bÌ\u008cáW\u0005\u0085&\u000ez\u0087\u009f[³\u0090Ô\u0017èÞ\r\u0015!\u008bB\rf\u0099»\nßÄð\u0019\u0014\u0087)GM\u008bn\u0004\u0082\u0087\u007fE\\Ñ8E\u0015ÅñXÎÃªG\u0087\u009ccN@Å\u001cLù\u0090Õ[²Ü\u008e\u0015kÞG@$Æ\u0000RÝÁ¹\u000f\u0096ÒrLO\u008c+@\bÂäL\u0019\u0088:\u001d^\u0093s\u0005\u0097\u0089¨\u001d\u0019Ñ:\u000f^\u008es\u0012\u0097\u0099¨TÌ\u0095á\u0016\u0005\u0092&\u0002z\u0098\u009f\u0010³\u0081ºë\u0099~ýðÐf4þ\u000bmoþBi¦áèçËD¯Ì\u0082ZfÉYJ=Ò\u0010NôÇ×GeÙFC\"Å\u000fAëÇÔ^°Ä\u008b5¨¿Ì&áº\u0005?:º^%s¼\u0019\u008c:\u0010^Òs\r\u0097\u0088¨\u0014Ì\u009cá\f\u0005\u0095&\u0003zÚ\u009f\u0011³\u0097Ô\u0005è\u0099\r\u0012!\u008b\u0019\u0088:\u001d^\u0093s\u0005\u0097Â¨MÌ\u0088\u0019\u0099:\u001a^\u0092s\u0018\u0097\u0088¨\u0012Ì\u009b\u0017\u000b4\u0088P\u0000}\u008a\u0099\u001a¦\u0080Â\tï´\u000b\u001c(ÝtP\u0019\u0099:\u001a^\u0092s\u0018\u0097\u0088¨\u0012Ì\u009bá&\u0005\u008e&OzÂ\u009f*³ÄÔGß ü<\u0098þµ!Q¤n8\n°' Ã¹à/¼öY4u±\u0012;.¹Ë1Ñxòî\u0096b\u0019\u009b:\u0012^\u0089s\u0011\u0097\u009b¨\u000fÌ\u0097á\u000b\u0019¿:\u000f^\u008cs]\u0097¨¨\u000eÌ\u0096á\r\u0005\u009f&\u001az\u0091\u009fU³\u0094Ô\u001cè\u0082\rQ!\u00adB\u0007f\u009e»\u0002ß\u0087ð\u000e\u0019¿:\u0011^\u0098s\u000f\u0097\u0095¨\u0012Ì\u009cáY\u0005¥&3z¿\u009fU³\u0090Ô\u0006è\u0099\r\u001d!\u009aBOf\u008a»\u0002ß\u0098ðK\u0014\u0090)QMÐ\u0019¿:\u0011^\u0098s\u000f\u0097\u0095¨\u0012Ì\u009cáY\u0005¥&3z¿\u009fU³\u0090Ô\u0006è\u0099\r\u001d!\u009aBOf\u008a»\u0002ß\u0098ðK\u0014\u0090)QMÐn8\u0082Ò§Q\u0019\u008c:\u0010^Òs\u0015\u0097\u009b¨\tÌ\u009cá\u000e\u0005\u0097&\u0005z\u0091\u0019\u0099:\u0010^\u0090s\u0019\u0097\u009c¨\u0012Ì\u008bá\u0011\u0019\u0088:\u001d^\u0093s\u0005\u0097Â¨M\u0019\u008c:\u001e^\u0092s\u001e\u0097\u0092¨\u000e1)\u0012µvw[¨¿-\u0080±ä9É©-0\u000e¦R\u007f·²\u009b%ü·À;%°ù\u0082Ú\u001e¾Ü\u0093\u0018w\u0091H\u0007,\u0098\u0001\u0012å\u0094ÆW\u009a\u008b\u007f\u001eS\u00914\b\u0013í¿ÿ\u009ccø¡Õ}1ì\u000ekjþGx£à\u0019Î\u0019\u008c:\u0010^Òs\u001f\u0097\u008f¨\u0012Ì\u0094á\u001d\u0005Ø&\u0007z\u0086\u009f\u001a³\u0096Ô\u0006è\u0093\r\u0005\u0019\u0098:\n^\u0090s\u0011\u0097¥¨\u0003ÌÀáO\u0019\u008c:\u0010^Òs\u001f\u0097\u008f¨\u0012Ì\u0094á\u001d\u0005Ø&\u0011z\u009d\u009f\u001b³\u0095Ô\u0016è\u0082\r\u0001!\u009cB\u0006f\u0082»\u0019\u0019\u0099:\u001a^\u0092s\u0018\u0097\u0088¨\u0012Ì\u009báV\u0005\u0085&\u0013z\u009f\u009fZ³\u0095Ô\u0016è\u009e\r\u0014!\u009cB\u0006f\u008f\r<.¿J7g½\u0083-¼·Ø>õ\u0083\u0011+2êng\u008bÿ§$À²ü>\u0019\u008b53Vòr\u007f¯çË(ä«\u0000#=©Y1z«\u0096\"³\u009fï?\bþ$s\u0019\u0099:\u001a^\u0092s\u0018\u0097\u0088¨\u0012Ì\u009báV\u0005\u0091&\u0018z\u009b\u009f\u0012³\u009eÔ\u0016è¯\r\u0002!\u008aB\u0004fÃ»\nß\u008fð\u0005\u0014\u008d)\u001bM\u008fn\u0004\u0019\u0099:\u001a^\u0092s\u0018\u0097\u0088¨\u0012Ì\u009báV\u0005\u0080&\u0015z\u009b\u009f\r³ÊÔEè\u0080\r^!\u0098B\rf\u0083»\u0015ßÒð]\u0014\u0098\u0019\u0099:\u0010^\u0093s\u001a\u0097\u0096¨\u001eÌ×á\n\u0005\u0092&\u001cz«\u009f\u0012³\u0082Ô\u001bè\u009f\r\u001f!\u008bB0f\u0094»UßÜðD\u0014\u008f)\fM\u0088n\u0002\u0082\u0096§\fû\u0081\u001c<0\u0098UYiè\u0019\u008c:\u0010^Òs\u001f\u0097\u0095¨\u0014Ì\u008cá\u0015\u0005\u0099&\u0016z\u0090\u009f\u0010³\u0080\u0019\u008c:\u0010^Òs\u001f\u0097\u0095¨\u0014Ì\u008cá\u0010\u0005\u009b&\u0016z\u0093\u009f\u0010³ÜÔ\u0011è\u0085\r\u0018!\u0082B\u000bfÂ»\u000bß\u0083ð\u0005\u0014\u008f)\fM\u0094n\u0017\u0082\u0096§\fû\u008c\u001c\u0017% \u0006\u008eb\u0007O\u0090«\n\u0094\u008dð\u0003ÝË9\u0011\u001aÐF]\u0005´&(Bêo'\u008b·´*Ð¬ý%\u0019à:+f¥\u0083>¯ºÈ'ô©\u00110=ø^>z°\u0019\u008a:\u001a^\u008fs\t\u0097×\u0019\u0097:\u0011^\u0095s\t\u0097Ô¨\bÌ\u008eá\u001a\u0005Ø&\u0006z\u0091\u009f\u0018³\u0087Ô^è\u0080\r\u0003!\u0081B\u001ff\u009fu\u0018V\u008d2\u0006\u001f\u009fûCÄ\u0084 \u0018\u008dÀi\fJ\u0081\u0016\nó\u008cß\u000e¸\u0081\u0084\u001ea\u0095\u0004\u0011'\u0084C\u000fn\u0096\u008aJµ\u0096Ñ\u0000üÉ\u0018\u000e;\u0088g\u0001\u0082\u008e®3É\u008eõ\u000f\u0010\u0082<\u0015_\u0083{\u0013\u0003U ÀDKiÒ\u008d\u000e²ÒÖDû\u008d\u001f@<Î`J\u0085ð©LÎÌòD\u0017Ø;]XÁ|O\u0080ò£nÇ¬êh\u000eá1wUèxb\u009cä¿'ãë\u0006e*èM\u007fqá\u0094f¸ôÛ?ÿã\"vFùi`\u008dò\u0019\u008c:\u0010^Òs\u001f\u0097\u0095¨\u0014Ì\u008cáW\u0005\u0087&\u0012z\u0099\u009f\u0000³ÜÔ\u0012è\u0086\r\u0015!±B\u0001f\u008d»\u0000ß\u008fÔ\u0007÷\u009b\u0093Y¾\u0099Z\u0015e\u009d\u0001],\u0090È\bë\u0095·\u0013R\u009a~W\u0019\u009e%\u0012À\u0094ì\u0002\u008f\u0081«\u0015v\u0096\u0012\u0013=\u0089Ù\rä\u0096hvKê/(\u0002÷ærÙî½f\u0090ötoWù\u000b îíÂ}¥à\u0099f|ïP:3ó\u0017\u007fÊù®w\u0081ôe`Xã<n\u001fôópÖëèÂË^¯\u009c\u0082@fÍYF=Â\u0010RôÕ×\u0017\u008bØnNBÕ%Q\u0019Úü\u0011ÐÆ³H\u0097ÌJD.Á\u0001WåÖØU¼Á\u009fGsÞ\u009aè¹tÝ¶ðj\u0014ç+lOèbx\u0086ÿ¥Lùõ\u001ci0âW9kö\u008e`¢ãÁgåì8'\\èsf\u0097âªjÎçíq\u0001ð$sxï\u009fi³ð\u0019\u008c:\u0010^Òs\u000b\u0097\u009f¨\u0015Ì\u009cá\u0016\u0005\u0084&Yz\u0096\u009f\u0000³\u009bÔ\u001fè\u0094\r_!\u0088B\u0006f\u0082»\nß\u008fð\u0019\u0014\u0098)\u001bM\u008fn\t\u0082\u0090B]aÁ\u0005\u0003(ÚÌNóÄ\u0097MºÇ^U}ù!AÄÈèH\u008fÏ³\u000fVÂzJ\u0019×=QàØ\u0084\u0015«ÜOPrÖ\u0016P5ÓÙGüÄ AGÛk_\u000eÄ\u00ad\u0091\u0019Ñ:\u001b^\u0099s\u000b\u0097Õ¨\nÌ\u009dá\u0014\u0005\u0083&(z\u0084\u009f\u001c³\u0082Ô\u0016\u0019Ñ:\u001b^\u0099s\u000b\u0097Õ¨\bÌ\u0097á\u001a\u0005\u009d&\u0012z\u0080\u009fZ³\u0090Ô\u0012è\u0083\r\u0014!\u008cB\u000ef\u0082»\tßµð\f\u0014\u008d)\u0007M\u009fn\u0003\u008cÞ¯\u0014Ë\u0096æ\u0004\u0002Ú=\u0007Y\u0098t\u0015\u0090\u0092³\u001dï\u008f\nU&\u009aA\u0019}\u0091\u0098\u0007´\u0085A\u0010bÚ\u0006X+ÊÏ\u0014ðÉ\u0094V¹Û]\\~Ó\"AÇ\u009bëB\u008c×°\\UÅyK!\u009f\u0002BfËK@¯\u009b\u0090DôÓÙZ=Í\u001efBÎ§I\u008bÝì^ÐÛ\u0019Ñ:\f^\u0085s\u000e\u0097\u008e¨\u001eÌ\u0095áV\u0005\u009a&\u001ez\u0096\u009fZ³\u009eÔ\u001aè\u0092\r\u0012!±B\u0002f\u008d»\u0001ß\u0086ð\u0004\u0014\u008b)6M\u0082n\u0002\u0082\u0086§\u0010û\u0085\u001c<0\u0091U\u0004i³\u008a*®òÃ.çµ\u0019Ñ:\u001b^\u0099s\u000b\u0097Õ¨\u0019Ì\u008bá\r\u0005©&\u0010z\u0084\u009f\u0006b\u0000AÊ%H\bÚì\u0004ÓÈ·Z\u009aÜ~x]Ò\u0001LäÉÈF\u0019Ñ:\u001b^\u0099s\u000b\u0097Õ¨\bÌ\u0097á\u001a\u0005\u009d&\u0012z\u0080\u009fZ³\u0090Ô\u0000è\u0084\r\u0017!\u0081B\u0003f\u0088»\bß\u0098ð\u000f\u009e\u008d½PÙÙôR\u0010Ò/BKÉf\n\u0082Æ¡BýÊ\u0018\u00064ÂSFoÎ\u008aO¦ÁÅGáÖ<^XÚwS\u0093Ñ®GÊåéQ\u0005Ö P|\u0090\u009bL·ÓüÃß\t»\u008b\u0096\u0019rÇM\u000b)\u0099\u0004\u001fà\u0085Ã\u0006\u009f\u0085z\u0002¼\u008a\u009f@ûÂÖP2\u008e\rBiÐDV Ê\u0083UßÝ:A\u0019Ñ:\u001b^\u0099s\u000b\u0097Õ¨\u0019Ì\u008bá\r\u0005\u009b&\u0012z\u0093\u009f\u001bÇ\u0081äK\u0080É\u00ad[I\u0085vI\u0012Û?]ÛÉøU¤ÍA@ìIÏ\u0083«\u0001\u0086\u0093bM]\u00819\u0013\u0014\u0095ð\u0018Ó\u0082\u008f\u001fj\u008a\u008d}®·Ê5ç§\u0003y<µX'u¡\u0091*²¼î9\u000b°'.@¼\u0019Ñ:\u001b^\u0099s\u000b\u0097Õ¨\u0019Ì\u008bá\r\u0005©&\u001ez\u0099\u009f\u0010\u0019Ñ:\u001b^\u009ds\t\u0097\u009b¨TÌ\u009cá\u0016\u0005\u0081&\u0019z\u0098\u009f\u001a³\u0093Ô\u0017è\u0083\r^!ÀB\u0017f\u008e»Bß\u0088ð\u0018\u0014\u009c)\u0002\u00855¦öÂvïí\u000b14èPu}ó\u0099vºüæg\u0003â/9HÕtg\u0091á½YÞãúi'ûCklë\u0088JµâÑnòç\u001ee;ó\u0019Ñ:\u000f^\u008es\u0012\u0097\u0099¨TÌ\u0091á\u0016\u0005\u0086&\u0018z\u0086\u009f\u0001³\u0081\u0019Î:\u0019^\u009as]\u0097Àe¢F|\"ý\u000faëêÔ'°ø\u009doyéZb\u0006¨ãkÏà¨p\u0094ð[\u0096x\u0002\u001c\u00921\u001eÕ\u0099ê\u001b\u008e\u0094£XG\u009ed\u00178\u0097Ý\u001eñ\u009b\u0096\u0015ª\u008cO\u0016cÏ\u0000\u0013$\u008c3¨\u0010,t¤Y\u0000½\u008c\u0082\u0004æ\u0091Ë\u001c/®\f>Pºµa\u0099»þ&\u0019Ñ:\u001a^\u0088s\u001e\u0097Õ¨\u0016Ì\u009dá\u001d\u0005\u009f&\u0016z«\u009f\u0016³\u009dÔ\u0017è\u0095\r\u0012!\u009dBAf\u0094»\u0000ß\u0086Õ\u0019ö\u0096\u0092\f¿\u009d[\fd\u008a\u0000\u001c-\u009fÉ\u0018ê\u0081\u0019Ñ:\u001a^\u0088s\u001e\u0097Õ¨\u0016Ì\u0097á\f\u0005\u0098&\u0003z\u0087Çúä0\u0080¶\u00ad\"I°v\u007f\u0012·?=Ûªø2¤³A1m¸\n<6¨Óuÿë\u009c ¸·ei\u0001 .0Ê³÷1\u0093ã°4\\¢y\"\u0019Ñ:\u000f^\u008es\u0012\u0097\u0099¨TÌ\u009bá\t\u0005\u0083&\u001ez\u009a\u009f\u0013³\u009d\u0019¹:\u0010^\u0090s\u0019\u0097\u009c¨\u0012Ì\u008bá\u0011\u0019Ñ:\u001b^\u009ds\t\u0097\u009b¨TÌ\u0095á\u0010\u0005\u0085&\u0014zÛ\u009f\u0005³\u0080Ô\u001cè\u0096\r\u0018!\u0082B\nf\u009f»Bß\u0089ð\u001e\u0014\u009a)FMÖnH\u0082\u0087§\nû\u008f\u001cM0\u008dU\bi½\u008a-®³Ã+ç³8)\\¬qw\u0095»¶2Ê¹ï \u0003»$>xµ".getBytes(CharEncoding.ISO_8859_1)).asCharBuffer().get(cArr, 0, 1959);
            _CREATION = cArr;
            _BOUNDARY = -1189691340806604161L;
        }

        /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
            java.util.NoSuchElementException
            	at java.base/java.util.TreeMap.key(Unknown Source)
            	at java.base/java.util.TreeMap.lastKey(Unknown Source)
            	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
            	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
            	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
            */
        public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r73, int r74, int r75, int r76) {
            /*
                Method dump skipped, instruction units count: 13523
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.jwt.JwtEcdsaParameters.Builder.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private JwtEcdsaParameters(KidStrategy kidStrategy, Algorithm algorithm) {
        this.kidStrategy = kidStrategy;
        this.algorithm = algorithm;
    }

    public KidStrategy getKidStrategy() {
        return this.kidStrategy;
    }

    public Algorithm getAlgorithm() {
        return this.algorithm;
    }

    @Override // com.google.crypto.tink.Parameters
    public boolean hasIdRequirement() {
        return this.kidStrategy.equals(KidStrategy.BASE64_ENCODED_KEY_ID);
    }

    @Override // com.google.crypto.tink.jwt.JwtSignatureParameters
    public boolean allowKidAbsent() {
        return this.kidStrategy.equals(KidStrategy.CUSTOM) || this.kidStrategy.equals(KidStrategy.IGNORED);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof JwtEcdsaParameters)) {
            return false;
        }
        JwtEcdsaParameters jwtEcdsaParameters = (JwtEcdsaParameters) obj;
        return jwtEcdsaParameters.kidStrategy.equals(this.kidStrategy) && jwtEcdsaParameters.algorithm.equals(this.algorithm);
    }

    public int hashCode() {
        return Objects.hash(JwtEcdsaParameters.class, this.kidStrategy, this.algorithm);
    }

    public String toString() {
        return "JWT ECDSA Parameters (kidStrategy: " + this.kidStrategy + ", Algorithm " + this.algorithm + ")";
    }
}
