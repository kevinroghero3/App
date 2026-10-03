package com.google.zxing.datamatrix.encoder;

import android.graphics.PointF;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import ch.qos.logback.core.CoreConstants;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import o.ArtificialStackFrames;
import o._CREATION;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes3.dex */
public class C40Encoder implements Encoder {
    private static long _BOUNDARY;
    private static char[] _CREATION;
    private static final byte[] $$c = {103, 5, 74, Ascii.SYN};
    private static final int $$d = 219;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {72, -88, 5, 32, 52, 2, -47, -11, 0, -17, -17, 5, 53, -22, -1, 3, 8, -19, 19, -53, Ascii.CR, 1, Ascii.FF, -11, 8};
    private static final int $$b = 202;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0025). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(int r5, short r6, byte r7) {
        /*
            int r6 = r6 * 4
            int r6 = 4 - r6
            int r5 = r5 + 103
            byte[] r0 = com.google.zxing.datamatrix.encoder.C40Encoder.$$c
            int r7 = r7 * 4
            int r1 = r7 + 1
            byte[] r1 = new byte[r1]
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r5
            r5 = r7
            r4 = r2
            goto L25
        L15:
            r3 = r2
        L16:
            byte r4 = (byte) r5
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L23
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            return r5
        L23:
            r3 = r0[r6]
        L25:
            int r6 = r6 + 1
            int r5 = r5 + r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.datamatrix.encoder.C40Encoder.$$e(int, short, byte):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0020  */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0020 -> B:11:0x0025). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0020
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(short r7, short r8, int r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = com.google.zxing.datamatrix.encoder.C40Encoder.$$a
            int r9 = r9 + 4
            int r7 = 4 - r7
            int r8 = 115 - r8
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L10
            r3 = r9
            r4 = r2
            goto L25
        L10:
            r3 = r2
        L11:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r7) goto L20
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L20:
            r3 = r0[r9]
            r6 = r3
            r3 = r9
            r9 = r6
        L25:
            int r9 = -r9
            int r3 = r3 + 1
            int r8 = r8 + r9
            int r8 = r8 + (-2)
            r9 = r3
            r3 = r4
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.datamatrix.encoder.C40Encoder.a(short, short, int, java.lang.Object[]):void");
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        return 1;
    }

    C40Encoder() {
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void encode(EncoderContext encoderContext) {
        StringBuilder sb = new StringBuilder();
        while (encoderContext.hasMoreCharacters()) {
            char currentChar = encoderContext.getCurrentChar();
            encoderContext.pos++;
            int iEncodeChar = encodeChar(currentChar, sb);
            int codewordCount = encoderContext.getCodewordCount() + ((sb.length() / 3) << 1);
            encoderContext.updateSymbolInfo(codewordCount);
            int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - codewordCount;
            if (!encoderContext.hasMoreCharacters()) {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && (dataCapacity < 2 || dataCapacity > 2)) {
                    iEncodeChar = backtrackOneCharacter(encoderContext, sb, sb2, iEncodeChar);
                }
                while (sb.length() % 3 == 1 && ((iEncodeChar <= 3 && dataCapacity != 1) || iEncodeChar > 3)) {
                    iEncodeChar = backtrackOneCharacter(encoderContext, sb, sb2, iEncodeChar);
                }
                break;
            }
            if (sb.length() % 3 == 0 && HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode()) != getEncodingMode()) {
                encoderContext.signalEncoderChange(0);
                break;
            }
        }
        handleEOD(encoderContext, sb);
    }

    private int backtrackOneCharacter(EncoderContext encoderContext, StringBuilder sb, StringBuilder sb2, int i) {
        int length = sb.length();
        sb.delete(length - i, length);
        encoderContext.pos--;
        int iEncodeChar = encodeChar(encoderContext.getCurrentChar(), sb2);
        encoderContext.resetSymbolInfo();
        return iEncodeChar;
    }

    static void writeNextTriplet(EncoderContext encoderContext, StringBuilder sb) {
        encoderContext.writeCodewords(encodeToCodewords(sb, 0));
        sb.delete(0, 3);
    }

    void handleEOD(EncoderContext encoderContext, StringBuilder sb) {
        int length = sb.length() / 3;
        int length2 = sb.length() % 3;
        int codewordCount = encoderContext.getCodewordCount() + (length << 1);
        encoderContext.updateSymbolInfo(codewordCount);
        int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - codewordCount;
        if (length2 == 2) {
            sb.append((char) 0);
            while (sb.length() >= 3) {
                writeNextTriplet(encoderContext, sb);
            }
            if (encoderContext.hasMoreCharacters()) {
                encoderContext.writeCodeword((char) 254);
            }
        } else if (dataCapacity == 1 && length2 == 1) {
            while (sb.length() >= 3) {
                writeNextTriplet(encoderContext, sb);
            }
            if (encoderContext.hasMoreCharacters()) {
                encoderContext.writeCodeword((char) 254);
            }
            encoderContext.pos--;
        } else if (length2 == 0) {
            while (sb.length() >= 3) {
                writeNextTriplet(encoderContext, sb);
            }
            if (dataCapacity > 0 || encoderContext.hasMoreCharacters()) {
                encoderContext.writeCodeword((char) 254);
            }
        } else {
            throw new IllegalStateException("Unexpected case. Please report!");
        }
        encoderContext.signalEncoderChange(0);
    }

    private static void b(char c, int i, int i2, Object[] objArr) throws Throwable {
        int i3 = 2 % 2;
        _CREATION _creation = new _CREATION();
        long[] jArr = new long[i2];
        _creation.b = 0;
        while (_creation.b < i2) {
            int i4 = $10 + 13;
            $11 = i4 % 128;
            if (i4 % 2 == 0) {
                int i5 = _creation.b;
                try {
                    Object[] objArr2 = {Integer.valueOf(_CREATION[i + i5])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                    if (objAccessartificialFrame == null) {
                        int maximumFlingVelocity = 8 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                        char jumpTapTimeout = (char) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 9279);
                        int doubleTapTimeout = 1977 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                        byte b = (byte) ($$d & 5);
                        byte b2 = (byte) (b - 1);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity, jumpTapTimeout, doubleTapTimeout, 1113883676, false, $$e(b, b2, b2), new Class[]{Integer.TYPE});
                    }
                    Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i5), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                    if (objAccessartificialFrame2 == null) {
                        int pressedStateDuration = 30 - (ViewConfiguration.getPressedStateDuration() >> 16);
                        char c2 = (char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 49362);
                        int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 684;
                        byte b3 = (byte) ($$d & 7);
                        byte b4 = (byte) (b3 - 3);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(pressedStateDuration, c2, keyRepeatDelay, -115095555, false, $$e(b3, b4, b4), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                    }
                    jArr[i5] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                    Object[] objArr4 = {_creation, _creation};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                    if (objAccessartificialFrame3 == null) {
                        byte b5 = (byte) 0;
                        byte b6 = b5;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(25 - KeyEvent.keyCodeFromString(""), (char) (View.resolveSize(0, 0) + 30068), ExpandableListView.getPackedPositionChild(0L) + 817, 1897803493, false, $$e(b5, b6, b6), new Class[]{Object.class, Object.class});
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
                int i6 = _creation.b;
                Object[] objArr5 = {Integer.valueOf(_CREATION[i + i6])};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-587087340);
                if (objAccessartificialFrame4 == null) {
                    int i7 = 9 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                    char keyRepeatDelay2 = (char) (9279 - (ViewConfiguration.getKeyRepeatDelay() >> 16));
                    int i8 = 1978 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                    byte b7 = (byte) ($$d & 5);
                    byte b8 = (byte) (b7 - 1);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i7, keyRepeatDelay2, i8, 1113883676, false, $$e(b7, b8, b8), new Class[]{Integer.TYPE});
                }
                Object[] objArr6 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).longValue()), Long.valueOf(i6), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1715896821);
                if (objAccessartificialFrame5 == null) {
                    int i9 = 31 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                    char cResolveSize = (char) (49362 - View.resolveSize(0, 0));
                    int maxKeyCode = (KeyEvent.getMaxKeyCode() >> 16) + 684;
                    byte b9 = (byte) ($$d & 7);
                    byte b10 = (byte) (b9 - 3);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i9, cResolveSize, maxKeyCode, -115095555, false, $$e(b9, b10, b10), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                }
                jArr[i6] = ((Long) ((Method) objAccessartificialFrame5).invoke(null, objArr6)).longValue();
                Object[] objArr7 = {_creation, _creation};
                Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-293902099);
                if (objAccessartificialFrame6 == null) {
                    byte b11 = (byte) 0;
                    byte b12 = b11;
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(25 - View.combineMeasuredStates(0, 0), (char) (30068 - KeyEvent.normalizeMetaState(0)), 816 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 1897803493, false, $$e(b11, b12, b12), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame6).invoke(null, objArr7);
            }
            int i10 = $11 + 75;
            $10 = i10 % 128;
            int i11 = i10 % 2;
        }
        char[] cArr = new char[i2];
        _creation.b = 0;
        while (_creation.b < i2) {
            int i12 = $11 + b.f40o;
            $10 = i12 % 128;
            int i13 = i12 % 2;
            cArr[_creation.b] = (char) jArr[_creation.b];
            try {
                Object[] objArr8 = {_creation, _creation};
                Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-293902099);
                if (objAccessartificialFrame7 == null) {
                    byte b13 = (byte) 0;
                    byte b14 = b13;
                    objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getDoubleTapTimeout() >> 16) + 25, (char) (TextUtils.getTrimmedLength("") + 30068), (ViewConfiguration.getScrollBarSize() >> 8) + 816, 1897803493, false, $$e(b13, b14, b14), new Class[]{Object.class, Object.class});
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

    int encodeChar(char c, StringBuilder sb) {
        if (c == ' ') {
            sb.append((char) 3);
            return 1;
        }
        if (c >= '0' && c <= '9') {
            sb.append((char) (c - ','));
            return 1;
        }
        if (c >= 'A' && c <= 'Z') {
            sb.append((char) (c - '3'));
            return 1;
        }
        if (c < ' ') {
            sb.append((char) 0);
            sb.append(c);
            return 2;
        }
        if (c >= '!' && c <= '/') {
            sb.append((char) 1);
            sb.append((char) (c - '!'));
            return 2;
        }
        if (c >= ':' && c <= '@') {
            sb.append((char) 1);
            sb.append((char) (c - '+'));
            return 2;
        }
        if (c >= '[' && c <= '_') {
            sb.append((char) 1);
            sb.append((char) (c - 'E'));
            return 2;
        }
        if (c >= '`' && c <= 127) {
            sb.append((char) 2);
            sb.append((char) (c - '`'));
            return 2;
        }
        sb.append("\u0001\u001e");
        return encodeChar((char) (c - 128), sb) + 2;
    }

    private static String encodeToCodewords(CharSequence charSequence, int i) {
        int iCharAt = (charSequence.charAt(i) * 1600) + (charSequence.charAt(i + 1) * CoreConstants.LEFT_PARENTHESIS_CHAR) + charSequence.charAt(i + 2) + 1;
        return new String(new char[]{(char) (iCharAt / 256), (char) (iCharAt % 256)});
    }

    static {
        char[] cArr = new char[1959];
        ByteBuffer.wrap("\u0019Ñ\u0081þ)SÐ¤xAàm\u008bÉ3.ÚºB\u001cê\u007f\u0095Á=&¤µLçôF\u009fÚ\u0007(®\u0093Váþ]\u0099\u0095\u0001\u0015©rPÿøYc³ÍgUHýå\u0004\u0012¬÷4Û_\u007fç\u0098\u000e\f\u0096ª>ÉAwé\u0090p\u0003\u0098@ ýKxÓ\u0089z\u001f\u0082@*èM\u000eÕ³}À\u0084LÍéUÆýk\u0004\u009c¬y4U_ñç\u0016\u000e\u0082\u0096$>GAùé\u001ep\u008d\u0098Í cKèÓ\u0001\u0019Ñ\u0081é)OÐ¡xAàg\u008bÉ3&Ú«B\u0016ês\u0095\u009d=)¤\u0085LêôF\u009fØ\u00073®\u0085Vúþq\u0099¨\u0001\u0007©vPêø_c¤\u000b\u000bÝÌEâí_\u0014¬¼\\$sOÜ÷q\u001e³\u0086\u0015.dQß\u0019Ñ\u0081ÿ)BÐ±xAày\u008bÏ3/ÚðB\nêd\u0095Ý=>\u0092Ô\nì¢W[´ó\nk}\u0000Ç¸hQ\u0089É9a^\u001eØ¶=/\u008aÇÇ\u007fF\u0014Ï\u008c>\u0019Ñ\u0081þ)WÐ¦x\u000fà%\u008b\u00883!Ú®B\u000fê\u007f\u0095Ü=(¤\u0085\u0019\u008c\u0081õ)\u0018Ð°x\u0001àe\u008bÒ3lÚ¬B\u001fêr\u0095À=!¤\u0083Lâô}\u009fÐ\u0007?®\u0082VÍþJ\u0099¤\u0001\u0015©3\u0019\u008c\u0081õ)\u0018Ð°x\u0001àe\u008bÒ3lÚ¬B\u001fêr\u0095À=!¤\u0083Lâô}\u009fÐ\u0007?®\u0082VÍþJ\u0099¤\u0001\u0015©0v\u001eî&F\u0080¿n\u0017Õ\u008f ä\u0004\\¢µ}-Ü\u0085»úRRíËL#+\u009b\u0083ð\u0013h»ÁJ92\u0016Æ\u008e©&\u000bßæw[ï(4Å¬¼\u0019Ñ\u0081é)OÐ¡x\u001aào\u008bË3mÚ¼B\u0013êx\u0095\u009d= ¤\u008fLëôW\u009fè\u0007\u0017®ÛVüþK\u0099§\u0001\u0013©/PýøUc¸\u000b\u0006³|ZÅÂ* i¸Q\u0010÷é\u0019A¢Ù×²s\nÕã\u0004{«ÓÀ¬%\u0004\u0098\u009d7uSÍï¦P>¯\u0097coZÇä \u001d8®\u0011©\u0089\u0091!7ØÙpbè\u0017\u0083³;\u0015ÒÊJkâ\f\u009då5Z¬ûD\u009cü4\u0097£\u000fO¦û^¼ö\u001b\u0091Â\tl¡\u0015X\u0096ðlkÝ\u0003eÒ7J\u0018âµ\u001bB³§+\u0082@%øÉ\u0011M\u0089û!\u0085^1öÛox\u008f«\u0017Ò¿?F\u0097î<vD\u001dí¥\u0001L×Ô5|^\u0003æ«\u001d\u0019\u0090\u0081ÿ)WÐ¡x\u000bà$\u008bÈ3'Úª;m£V\u000bøò\u0001Z±Â\u0099©|\u0011\u0097ø\u000e`£ÈÙ·w\u001f\u0081\u0086\"n_Öó½q\u0019\u0090\u0081ÿ)[Ð§x\u001dàl+*³S\u001b¾â\u0004JºÒÃ¹d\u0001\u0091è\u001bp¨Ø\u009e§y\u000f\u0089\u0096\"~UÆâ\u00ady5\u009f\u009c$dAÌú«\t3²\u0019\u0099\u0081ÿ)XÐ«Ë'SVûí\u0002\bª®2ÐY{áÅ\b\u0004\u0090ª8ÌG5ï\u0085v'\u009e\u0001&ïMrÕ\u0091|*\u0084\\,©K\u0004Ó¿{Þ\u0082\u0019*õ±\u001eÙ°aÂ\u0088\\\u0010\u0088¿;Ç¢oìöm\u001e\u009e¥)ÍGUêü\u0019\u0004\u0092£!\u0019\u008e\u0081ÿ)DÐ¡x\u0007ày\u008bÒ3lÚ\u00adB\u0003êe\u0095\u009c=,¤\u008eL¨ôF\u009fÛ\u00078®\u0083Võþ\u0000\u0099\u00ad\u0001\u0016©wP°ø\\c·\u000b\u0019³kZõÂ!m\u0092\u0015\u000b½E$ÀÌ7w\u0080\u001fî\u0087I.°\u0019\u008e\u0081ÿ)DÐ¡x\u0007ày\u008bÒ3lÚ\u00adB\u0003êe\u0095\u009c=,¤\u008eL¨ôF\u009fÛ\u00078®\u0083Võþ\u0000\u0099¸\u0001\t©,PýøKc¿hÁð°X\u000b¡î\tH\u00916ú\u009dB#«â3L\u009b*äÓLcÕÁ=ç\u0085\tî\u0094vwßÌ'º\u008fOè÷pFØc!½\u0089\u0014\u0012úó\u000ek\u007fÃÄ:!\u0092\u0087\nùaRÙì0-¨\u0083\u0000å\u007f\u001c×¬N\u000e¦(\u001eÆu[í¸D\u0003¼u\u0014\u0080s8ë\u0089C¬ºs\u0012Ù\u00895 y8\b\u0090³iVÁðY\u008e2%\u008a\u009bcZûôS\u0092,k\u0084Û\u001dyõ_M±&,¾Ï\u0017tï\u0002G÷ O¸þ\u0010Ûé\u0004A£ÚBÔ\u009aLêäK\u001d¸µ\u000f-~\u0019Ñ\u0081ê)DÐ½x\rà%\u008bË3-ÚºB\u000fêz\u0095×==\u0019\u0088\u0081ø)YÐªx\tà\u007f\u008bÃ31Úª\u0092\u008e\nÈ¢o[\u009có4kR\u0000å¸\u001cQ\u0086É#\u0004\u0084\u009cû4RÍ³e\u000eýr\u0096Ç\t_\u009109\u0086À\u007fhÁð¡\u009b\u0011#íªP2)\u009aÄc~ËÀS¹8\u001e\u0080ëiañÒYä&\n\u008e÷\u0017@ÿ3G\u009d,\u0007\u000bù\u0093\u0089;(ÂÛj'òM\u0099§\u000b\u0015\u0093s;ÔÂ;j\u0090òï\u0099I\u0019\u0099\u0081ÿ)XÐ·x\u001càc\u008bÅ3\u001dÚ¦BBê BïÚ\u0089r.\u008bÁ#j»\u0015Ð³hk\u0081Ð\u00194±VÎ\u009bf\u000eÿ¨\u0090Î\b· ZYàñ^i'\u0002\u0080ºuSÿËLcz\u001c\u009d´c-ÌÅ¡}\fo\u0005÷v_Õ\u0019\u009b\u0081÷)CÐ¾x\u000fà~\u008bÉ30\u0019¿\u0081ê)FÐòx<à\u007f\u008bÈ36Ú·B\u0017ês\u0095\u0092=(¤\u0085Lôô\u0002\u009fý\u00072®\u0084VýþC\u0099¯.Ê¶\u0081\u001e'çÕOt×\u0016¼·\u0004\u0017íøuKÝ(¢ç\nY\u0093ê{\u009aÃ;¨¿0\u000f\u0099åa\u0088É)®\u009f6k\u009eOgÝ(¯°ä\u0018Bá°I\u0011ÑsºÒ\u0002rë\u009ds.ÛM¤\u0082\f<\u0095\u008f}ÿÅ^®Ú6j\u009f\u0080gíÏL¨ú0\u000e\u0098*a¸ÉuRð:V\u0019\u008c\u0081õ)\u0018Ðºx\u000fàx\u008bÂ35Ú¿B\bês\u0019\u0099\u0081õ)ZÐ¶x\bàc\u008bÕ3*¨V0&\u0098\u0087atÉ\u0088Qâ\u0019\u008c\u0081û)XÐ±x\u0006à\u007f\u0019\u008c\u0081õ)\u0018Ð¢x\u001càe\u008bÂ37Ú½B\u000eê8\u0095Ð=<¤\u008bLèôF\u0091è\t\u0091¡|XÝðoh\u001c\u0003¬»CRÖÊ0b\u0003\u001d³µG,û\u0019Ï\u0019\u008c\u0081õ)\u0018Ð¡x\u000bài\u008bÓ30Ú»\u0019Î\u0019\u008c\u0081õ)\u0018Ð°x\u001bàc\u008bÊ3&ÚðB\nêd\u0095Ý=*¤\u009fLåôVù}a\nÉ¿0[\u0098Ô\u0000\u0097k{Ó\u00911Î©·\u0001ZøòPYÈ!£\u0088\u001bdò²j^Â=½\u009e\u0015k\u008cÍd¶Ü\u0010·\u008e/q\u0086Ú~¤<k¤\r\fªõE]îÅ\u0091®7\u0016\u009fÿ_gìÏ\u008f°o\u0018Û\u0081}i\u001aÑµº>\"Á\u008bg\u0019\u0099\u0081ÿ)XÐ·x\u001càc\u008bÅ3\u001dÚ¦BBê \u0095\u009d==¤\u008eLíô}\u009fÆ\u0007b®ÀV½þI\u0099¯\u0001\b©gPìøScµ\u000b-³vZ\u0092Âp\u0096\u0095\u000eó¦T_»÷\u0010oo\u0004É¼aUµÍ\u0019eu\u001aÙ².+\u0083ÃÕ{]\u0010Ö\u0088=!ÕÙùqG\u0016¨\u008e\u000f&|ßûwUtöì\u0090D7½Ø\u0015s\u008d\fæª^\u0002·Ç/w\u0087\u0016ø¥P\u0019É³!\u0099\u0099bò§jWÃö;\u0085\u0093yô\u0093ly0\u0016¨z\u0000Öù:Q\u008dÉà¢\u0006\u001a¾ó5k\u009eÃÆ¼Z\u0014±\u008d\refÝÃ¶T.\u008a\u0087\u0001\u007f%×\u0097°j(\u008e\u0080èy\u007fÑÐJ+\"\u0094\u009aâszë±DU<Ç÷»oÂÇ/>\u0087\u00966\u000eReåÝ\u00194\u0086¬,\u0004E{àÓ\u000b\u0019\u008c\u0081õ)\u0018Ð°x\u0001àe\u008bÒ3+Ú³B\u001bêq\u0095×=`¤\u0088LóôK\u009fÒ\u0007>®ØVôþG\u0099¤\u0001\u0001©gPìøJc¤\u000b\u001b³`ZÞí\u00aduæÝ@$²\u008c\u0013\u0014q\u007fÐÇ}.´¶P\u001e2y¯áÖI;°\u0093\u00188\u0080@ëéS\u0005ºÓ\"=\u008a\\õâ]\u001dÄ¥,Ä\u0094xÿ³g\u0010Î±xGà2H\u0088±k\u0019\u008e\u0088«\u0010È¸cA\u009aé|qE\u001aì¢\u001dKÌÓ7{O\u0004ã¬\u00075ûÝÊel\u000eí\u0096\u0016?¹\u0019\u008f\u0081ÿ)[Ð§x@àb\u008bÑ3lÚ³B\u001bê\u007f\u0095Ü=%¤\u008fLÿôQ\u0019\u008f\u0081ÿ)[Ð§x@ày\u008bÀ3lÚ¸B\u001bê}\u0095×=\u0011¤\u0089LçôO\u009fÛ\u0007(®\u0097\u0019\u008f\u0081ÿ)[Ð§x@ày\u008bÀ3lÚ²B\u0019êr\u0095í=*¤\u008fLèôQ\u009f×\u0007.®\u008fZ©ÂÐj=\u0093\u009c;.£]Èíp\u0002\u0099\u0097\u0001q©RÖù~\u000fç½\u000fÌ·nÜÿDQí¢\u0015Ò½fÚ\u009aB'\u0001Ý\u0099¤1IÈá`Pø4\u0093\u0083+=ÂþZNò*\u008d\u0096%1¼ÚT¡ì\u0017\u0087°\u001fe¶ÆN®æ\u001a\u0019\u008c\u0081õ)\u0018Ð½x\nàg\u008b\u00883 Ú«B\u0013êz\u0095Ö=`¤\u008cLïôL\u009fÙ\u0007?®\u0084Vâþ\\\u0099£\u0001\b©v\u0019\u008c\u0081õ)\u0018Ð¢x\u001càe\u008bÂ37Ú½B\u000eê8\u0095Ð=;¤\u0083LêôF\u009f\u0090\u0007<®\u009fVüþI\u0099¯\u0001\u0014©rPìøSc¸\u000b\u0006\u008d;\u0015B½¯D\u0016ì tÎ\u001fe§\u0090N\u0004Öã~Ã\u0001p©\u009001ØU`»\u000bo\u0093\u0084:/ÂBjü\r\u000f\u0095¡=ÇÄ@lã÷\u0015\u0019\u008c\u0081õ)\u0018Ð¡x\u0017ày\u008bÒ3'Ú³B%ês\u0095Ê=:¤ÄLäôW\u009f×\u00076®\u0092V¼þH\u0099£\u0001\b©ePûøHc¦\u000b\u0000³gZÄÂ2Å\u0007]~õ\u0093\f/¤\u0080<ïWIï¦\u0006'\u009eß6ÿILá¬x\r\u0090i(\u0087CSÛ¸r\u0013\u008a~\"ÀE3Ý\u009duû\u008c|$ß¿)\u0019\u008c\u0081õ)\u0018Ð¤x\u000bàd\u008bÂ3-Ú¬B%êr\u0095Þ=%¤\u0087L¨ô@\u009fË\u00073®\u009aVöþ\u0000\u0099¬\u0001\u000f©lPùø_c¤\u000b\u0002³|ZÃÂ(m\u0096ãK\u0019Ñ\u0081þ)SÐ¤xAà{\u008bÃ3/Ú«B%êf\u0095Û=>¤\u008f\u0019Ñ\u0081þ)SÐ¤xAày\u008bÉ3!ÚµB\u001fêb\u0095\u009d=,¤\u008bLõôG\u009fÜ\u0007;®\u0098Vöþq\u0099\u00ad\u0001\u0003©lPçø^\u0019Ñ\u0081þ)SÐ¤xAày\u008bÉ3!ÚµB\u001fêb\u0095\u009d=)¤\u008fLèô[\u009fÚ\u0019Ñ\u0081þ)SÐ¤xAày\u008bÉ3!ÚµB\u001fêb\u0095\u009d=?¤\u008fLëôW\u009fÚ\u0004\u0095\u009c\u00ad4\u000bÍåe\u0005ý?\u0096\u0087.kÇï_a÷&\u0088\u0084 k¹ÍQ§\u0019Ñ\u0081é)OÐ¡x\u001aào\u008bË3mÚ²B\u0013êt\u0095\u009d=\"¤\u0083LäôA\u009fá\u00077®\u0097VþþB\u0099¥\u0001\u0005©]Púø_c´\u000b\u0007³iZõÂ7m\u0087\u0015\u0013½o$\u0098Ì!w\u0081\u0019Ñ\u0081þ)SÐ¤xAàh\u008bÕ36Ú\u0081B\u001dêf\u0095ÁO3×\u001c\u007f±\u0086F.£¶\u008aÝ7eÔ\u008cc\u0014ì¼\u009dÃ=kÉ\u0019Ñ\u0081þ)SÐ¤xAày\u008bÉ3!ÚµB\u001fêb\u0095\u009d=,¤\u0099LòôD\u009fÑ\u00076®\u0092V÷þ\\\u0099®\u0019Ñ\u0081é)OÐ¡x\u001aào\u008bË3mÚ²B\u0013êt\u0095\u009d=\"¤\u0083Läô@\u009fÍ\u0007.®\u0090VýþB\u0099®\u0001\u0003©pPÁøPc¸\u000b\u001b³ ZÙÂ)ßÄGëïF\u0016±¾T&}MÀõ#\u001cª\u0084\f,`SÂ\u0019Ñ\u0081þ)SÐ¤xAàh\u008bÕ36Ú¹B\u0003êd\u0095Ý\u0000b\u0098M0àÉ\u0017aòùÛ\u0092f*\u0085Ã\u0000[¬óÂ\u008co\u0019Ñ\u0081þ)SÐ¤xAàh\u008bÕ36Ú±B\bê\u007f\u0095×\u0019Ñ\u0081þ)SÐ¤xAàh\u008bÕ36Ú¨B\u0017êe\u0095Õ\u0019Ñ\u0081þ)SÐ¤xAàh\u008bÕ36Ú®B\u001dêw\u0095Û=>¤\u0089\u0019Ñ\u0081þ)SÐ¤xAàh\u008bÕ36Ú\u0081B\u0013ê{\u0095×\u0019Ñ\u0081þ)WÐ¦x\u000fà%\u008bÂ3-Ú©B\u0014êz\u0095Ý=/¤\u008eLõô\r\u009f\u0090\u0007\"®\u0094V½þL\u0099¹\u0001\u0012©i\u0019Ñ\u0081÷)XÐ¦xAà}\u008bÏ3,ÚºB\u0015êa\u0095Á=a¤¨LõôV\u009fí\u00072®\u0097VàþK\u0099®\u0001 ©mPòø^c³\u000b\u0000óókÈÃf:\u009f\u0092/\n\u0007aíÙ\u000f0\u008c¨7\u0000F\u007fä×\u001f\u0019Î\u0081ü)PÐòxT\u0019Ñ\u0081ê)DÐ½x\rà%\u008bÕ3'Ú²B\u001cê9\u0095ß=/¤\u009aLõ\"Èº¹\u0012\u0006ëïCSÛ4°\u0094\b=áèyDÑ+®\u0087\u0006y\u009fÒw¤Ï\u001b¤Á<x\u0095ÈÉ\u0093QòùU\u0000\u0094¨#0N[ôã\u001c\n½\u0092\b:cE\u009dí<t\u0084\u0019Ñ\u0081ÿ)BÐ±xAàg\u008bÃ3&Ú·B\u001bêI\u0095Ñ=!¤\u008eLãôA\u009fÍ\u0007t®\u008eVÿþBä\u0090|úÔO-»\u0085\u0011\u001drvËÎ-'¹¿\u0005\u0019Ñ\u0081ÿ)BÐ±xAàg\u008bÉ37Ú°B\u000eêe³\u0004++\u0083\u0082zsÒÚJð!\u0017\u0099øp|èÁ@¯?\b\u0097ú\u000e[æ ^Ø5E\u00adë\u0004SühT\u009a3o«Ã\u0003¤úeR\u0097Én¡ËâÒzéÒG+¾\u0083\u000e\u001b&pÆÈ1!¨¹\u0010\u0011{n×Æ\"\u0019¹\u0081õ)ZÐ¶x\bàc\u008bÕ3*U\u0091Í¾e\u0017\u009cæ4O¬eÇ\u008b\u007fk\u0096í\u000eY¦yÙ\u0082q|èÅ\u0000 ¸\u000bÓ\u0092K\u007fâÅ\u001aý²\rÕÿMTåm\u001cî´U/õG]ÿ#\u0016Ä\u008ek!ËY]ñ(h\u0099\u0080d;ÇS¸Ë\u0012b¬\u009as=ßU»Í\u0007dç\u009cG4#".getBytes(CharEncoding.ISO_8859_1)).asCharBuffer().get(cArr, 0, 1959);
        _CREATION = cArr;
        _BOUNDARY = -6465012336758783590L;
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(Unknown Source)
        	at java.base/java.util.TreeMap.lastKey(Unknown Source)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r68, int r69, int r70, int r71) {
        /*
            Method dump skipped, instruction units count: 15241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.datamatrix.encoder.C40Encoder.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
    }
}
