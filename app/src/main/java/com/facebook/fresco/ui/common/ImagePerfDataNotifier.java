package com.facebook.fresco.ui.common;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
import o.ArtificialStackFrames;
import o._CREATION;
import org.apache.commons.lang3.CharEncoding;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public class ImagePerfDataNotifier implements ImagePerfNotifier {
    private static long _BOUNDARY;
    private static char[] _CREATION;
    private final ImagePerfDataListener perfDataListener;
    private static final byte[] $$c = {67, 32, -18, 9};
    private static final int $$d = 90;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {10, -69, -10, 57, 2, -47, -11, -17, 5, Ascii.FF, -11, 8, 0, -17, 52, 53, -22, -1, 3, -53, Ascii.CR, 1};
    private static final int $$b = 104;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0028). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(short r5, byte r6, byte r7) {
        /*
            int r7 = r7 * 3
            int r7 = 3 - r7
            int r6 = r6 * 4
            int r0 = 1 - r6
            byte[] r1 = com.facebook.fresco.ui.common.ImagePerfDataNotifier.$$c
            int r5 = r5 + 103
            byte[] r0 = new byte[r0]
            r2 = 0
            int r6 = 0 - r6
            if (r1 != 0) goto L16
            r4 = r6
            r3 = r2
            goto L28
        L16:
            r3 = r2
        L17:
            int r7 = r7 + 1
            byte r4 = (byte) r5
            r0[r3] = r4
            if (r3 != r6) goto L24
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            return r5
        L24:
            int r3 = r3 + 1
            r4 = r1[r7]
        L28:
            int r4 = -r4
            int r5 = r5 + r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fresco.ui.common.ImagePerfDataNotifier.$$e(short, byte, byte):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    /* JADX WARN: Code duplicated, block: B:8:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0028). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(int r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.facebook.fresco.ui.common.ImagePerfDataNotifier.$$a
            int r7 = r7 + 66
            int r1 = r6 + 2
            int r8 = 19 - r8
            byte[] r1 = new byte[r1]
            int r6 = r6 + 1
            r2 = 0
            if (r0 != 0) goto L13
            r4 = r6
            r7 = r8
            r3 = r2
            goto L28
        L13:
            r3 = r2
        L14:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L21
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L21:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r8
            r8 = r7
            r7 = r5
        L28:
            int r4 = -r4
            int r8 = r8 + r4
            int r7 = r7 + 1
            int r8 = r8 + (-2)
            r5 = r8
            r8 = r7
            r7 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fresco.ui.common.ImagePerfDataNotifier.b(int, byte, int, java.lang.Object[]):void");
    }

    public ImagePerfDataNotifier(@NotNull ImagePerfDataListener perfDataListener) {
        Intrinsics.checkNotNullParameter(perfDataListener, "perfDataListener");
        this.perfDataListener = perfDataListener;
    }

    @Override // com.facebook.fresco.ui.common.ImagePerfNotifier
    public void notifyVisibilityUpdated(@NotNull ImagePerfState state, @NotNull VisibilityState visibilityState) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(visibilityState, "visibilityState");
        this.perfDataListener.onImageVisibilityUpdated(state.snapshot(), visibilityState);
    }

    @Override // com.facebook.fresco.ui.common.ImagePerfNotifier
    public void notifyStatusUpdated(@NotNull ImagePerfState state, @NotNull ImageLoadStatus imageLoadStatus) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(imageLoadStatus, "imageLoadStatus");
        this.perfDataListener.onImageLoadStatusUpdated(state.snapshot(), imageLoadStatus);
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
                    byte b = (byte) 1;
                    byte b2 = (byte) (b - 1);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(8 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (9279 - (ViewConfiguration.getMaximumFlingVelocity() >> 16)), Color.rgb(0, 0, 0) + 16779193, 1113883676, false, $$e(b, b2, b2), new Class[]{Integer.TYPE});
                }
                Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i4), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                if (objAccessartificialFrame2 == null) {
                    byte b3 = (byte) 3;
                    byte b4 = (byte) (b3 - 3);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(30 - Gravity.getAbsoluteGravity(0, 0), (char) ((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 49362), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 684, -115095555, false, $$e(b3, b4, b4), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                }
                jArr[i4] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                Object[] objArr4 = {_creation, _creation};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) 0;
                    byte b6 = b5;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(24 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (30067 - MotionEvent.axisFromString("")), (ViewConfiguration.getJumpTapTimeout() >> 16) + 816, 1897803493, false, $$e(b5, b6, b6), new Class[]{Object.class, Object.class});
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
        int i5 = $10 + 33;
        $11 = i5 % 128;
        int i6 = i5 % 2;
        while (_creation.b < i2) {
            int i7 = $11 + 117;
            $10 = i7 % 128;
            if (i7 % 2 != 0) {
                cArr[_creation.b] = (char) jArr[_creation.b];
                Object[] objArr5 = {_creation, _creation};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-293902099);
                if (objAccessartificialFrame4 == null) {
                    byte b7 = (byte) 0;
                    byte b8 = b7;
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(26 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (30068 - TextUtils.getOffsetAfter("", 0)), TextUtils.indexOf("", "") + 816, 1897803493, false, $$e(b7, b8, b8), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                throw null;
            }
            cArr[_creation.b] = (char) jArr[_creation.b];
            try {
                Object[] objArr6 = {_creation, _creation};
                Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-293902099);
                if (objAccessartificialFrame5 == null) {
                    byte b9 = (byte) 0;
                    byte b10 = b9;
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(25 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) (30068 - (ViewConfiguration.getLongPressTimeout() >> 16)), 815 - ImageFormat.getBitsPerPixel(0), 1897803493, false, $$e(b9, b10, b10), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame5).invoke(null, objArr6);
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

    static {
        char[] cArr = new char[1959];
        ByteBuffer.wrap("\u0019Ñ)àyo\u0088æØ9ëû;MJÄ\u009aJ\u00adÒýS\f³\\.o\u0093¿3Î¼\u001e:!\u0096q\u000f\u0080\u0083Ð\u0005ã£3ñCx\u0092ï¢wõÿ<\b\f9\\¶\u00ad?ýàÎ\"\u001e\u0094o\u001d¿\u0093\u0088\u000bØ\u008a)jy÷JJ\u009aûëh;÷\u0004XTì¥MõßÆW\u00168f¥·3\u0019Ñ)àyo\u0088æØ9ëû;MJÄ\u009aJ\u00adÒýS\f³\\.o\u0093¿!Î¡\u001e0!\u0087\u0019Ñ)÷ys\u0088ãØ9ëñ;MJÌ\u009a[\u00adØý_\fï\\!o£¿>Î¼\u001e8!\u008dq\u0019\u0080\u0098Ð)ã\u009e3ãC|\u0092ú¢qõè\u0005Y\u0019Ñ)áy~\u0088óØ9ëø;EJ\u0086\u009a^\u00adÆýU\f°ÔDät´ëEf\u0015¬&zöÞ\u0087PW\u0095`Q0ÝÁ:\u0091£=Þ\rø]a¬üüxÏá\u001fIn\u0088¾s\u0089ýÙx( x?K¦\u009b\u0019ê¶:%\u0005\u008az\u000bJ:\u001a±ë>»\u00ad\u0088iXÖ)\u0011ù\u0084Î\u001b\u009e\u0089ot?ú\fy\u0019\u008c)ëy$\u0088òØyëó;VJ\u0086\u009a\\\u00adÑý^\f²\\)o¥¿6Î\u0087\u001e0!\u0081q\u001e\u0080¯Ð\u0012ã\u00923ñC9¹ß\u0089¸Ùw(¡x*K \u009b\u0005êÕ:\u000f\r\u0082]\r¬áüzÏö\u001fenÔ¾c\u0081ÒÑM üpACÁ\u0093¢ãi\u0019Ñ)÷ys\u0088ãØbëù;OJ\u0087\u009aB\u00adÝýX\fï\\*o¥¿0Î¶\u001e<!Êq\u0019\u0080\u009fý·ÍÆ\u009dFlÕ<R\u000fÏ5Ø\u0005þUz¤êôkÇð\u0017Ff\u008e¶E\u0081ÔÑ] æp!C \u00936â¤2\u0001\r ]N¬\u0097ü\u001aÏ\u0098\u001fþo,¾ä\u008erÙý)]xÝHJ\u009b×\u0019Ñ)÷ys\u0088ãØbëù;OJ\u0087\u009aL\u00adÝýT\fï\\(o©¿?Î\u00ad\u001e\b!©qG\u0080\u0080Ð\u0004ã\u00933ò\u0089y¹_éÛ\u0018KHÊ{Q«çÚ/\nê=umð\u009cGÌ\u0082ÿ\r/\u0098^\u001e\u008e\u0093±!á·\u0010\u000e@\u0093s$£XÓÏ\u0002V2\u0092eA\u0095ç\u0019Ñ)àyo\u0088æØ9ëò;GJÅ\u009a[\u00adÓýO\f¥\\5o¸\u0019\u008c)ëy$\u0088òØcëõ;NJÌ\u009a\u0000\u00adÜýU\f³\\2\u0019\u0090)áyk\u0088ãØsë²;LJÍ\u009aZ\u0019Ñ)ôyx\u0088ÿØuë³;DJÁ\u009aB\u00adÑýI\f¹\\5o¸¿7Îµ\u001e-Ð÷à\u0086°\u0000A\u0082\u0011\u0002\"\u009d\u0019\u008c)ëy$\u0088àØdëó;FJÝ\u009aM\u00adÀý\u0014\f\u00ad\\'o¢¿'Î¾\u001e?!\u0087q\u001e\u0080\u0085Ð\u0004ã\u00993ðÒ,âT²ÑC\\µÐ\u0085¿Õ&$½t!G±\u0097\bæØ6\u0003\u0001\u0093Q\u0017 °ðzÃö\u0013\"bâ²e\u008dØÝA,É|\u0006OÅ\u009f¬ï#>þ\u000e,Y¥©\u0015ø\u009dÈ-\u001b\u008bk\u0016º\u0095\u008aEÅæ\u0015kdæ´f\u0087Ù×D&ÕvX«Í\u009b¢Ë;: j<Y¬\u0089\u0015øÅ(\u001e\u001f\u008eO\n¾\u00adîgÝë\r?|ÿ¬x\u0093ÅÃ\\2Ôb\u001bQØ\u0081±ñ> ã\u00101G¸·\bæ\u0080Ö0\u0005\u0096u\u000b¤\u0088\u0094XÛÿ\u000bvzûª{\u0099ÎÉYÇx÷\u0017§\u008eV\u0015\u0006\u00895\u0019å \u0094pD«s;#¿Ò\u0018\u0082Ò±^a\u008a\u0010JÀÍÿp¯é^a\u000e®=xí\u001b\u009dÐL\u001b|\u0093+\u0005©,\u0099CÉÚ8AhÝ[M\u008bôú$*ÿ\u001doMë¼Lì\u0086ß\n\u000fÞ~\u001e®\u0099\u0091$Á½05`úS,\u0083Oó\u0084\"@\u0012×E[]®mÁ=XÌÃ\u009c_¯Ï\u007fv\u000e¦Þ}éí¹iHÎ\u0018\u0004+\u0088û\\\u008a\u009cZ\u001be¦5?Ä·\u0094x§®wÍ\u0007\u0006ÖÃæW±Ù\u0017\u0085'êws\u0086èÖtåä5]D\u008d\u0094V£ÆóB\u0002åR/a£±wÀ·\u00100/\u008d\u007f\u0014\u008e\u009cÞSí\u0085=æM-\u009cè¬qûò¯d\u009f\nÏ\u0089>\u0004n\u0089]\u0016\u0019Ñ)ôyx\u0088ÿØuë³;OJÇ\u009aJ\u00adÁýV\f¥\\5\u0019\u0088)æye\u0088èØqëé;GJÛ\u009aZ\u0019¹)áyd\u0088éØ{ëó;VJÁ\u009aA\u00adÚ\u0015¦%ÇuL\u0084ÓÔTçÆ7a3B\u00033S§¢ ò¤Á*\u0011\u0088`\u001a\u0019\u008c)ëy$\u0088àØdëó;FJÝ\u009aM\u00adÀý\u0014\f¤\\#oº¿;Î»\u001e;\u0007Ú7´g7\u0096ºÆ|õø%\u0000\u0019\u0099)áyd\u0088õØdëõ;Að\u0082Àú\u0090\u007faî1\u007f\u0002îÒZ£ìsMD\u0097\u0014\u0017U%e]5ØÄI\u0094Ø§Iwý\u0006KÖêá0±°@#\u0010Ì#D\u0019\u008c)ëy$\u0088àØdëó;FJÝ\u009aM\u00adÀý\u0014\f\u00ad\\)o¨¿7Î´\u0019\u008d)àya\u0016K&9v¯\u0087,×§ä84\u009dE\n\u0019¿)ôyz\u0088°ØDëé;LJÜ\u009aG\u00adÙý_\fà\\ o£¿ Îø\u001e\u001d!\u008cq\u0018\u0080\u009fÐ\u001bã\u0099\u0019¿)êyn\u0088âØyëõ;FJ\u0088\u009a}\u00adðýq\fà\\$o¹¿;Î´\u001e*!Äq\f\u0080\u009fÐ\u0004ãÜ3úC0\u0092¸Òqâ$² C,\u0013· ;ð\u0088\u0081FQ³f>6¿Ç.\u0097ê¤wtõ\u0005zÕäê\nºÂKQ\u001bÊ(\u0012ø4\u0088þYvi\u0085>bÎÚ\u0019\u008c)ëy$\u0088øØwëî;FJß\u009aO\u00adÆý_Î þR®ß_M\u000fÉ<Lìè\u009dy\u0019\u0088)æye\u0088èØ.ëª\u0019\u008c)åyd\u0088óØ~ëé\u0019\u008c)ëy$\u0088àØdëó;FJÝ\u009aM\u00adÀý\u0014\f¢\\4o\u00ad¿<Î¼\u0019\u008c)ëy$\u0088ûØsëî;LJÍ\u009aB\u00ad\u009aýK\f¥\\+o¹\u0088«\u0019\u008c)ëy$\u0088ãØsëÿ;WJÚ\u009aK\u0019ÎÁàñ\u0087¡HP\u009e\u0000\u000f3\u0099ã\"\u0092 Blu¨%$ÔÃ\u0084N·Õg]\u0016À¸ \u0088ÉØ^)ÄyqJÜ\u009a\"ë¦Ö\u0084æã¶,Gú\u0017k$ýôF\u0085ÄU\bbÚ2[Ã¦\u0093) ¡p(\u0001 Ñ$î\u0085¾\fO\u008cÐ\u0004à|°ùAh\u0011ù\"hòÜ\u0083\u001aSÀdM4ÌÅr\u0095¼¦4v¡\u0007 ×±è\u0010¸\u0094\u0019\u0099)áyd\u0088õØdëõ;AJ÷\u009aV\u00ad\u008cý\f\fï\\5o¨¿9Î\u0087\u001e&!Üq\\\u0080ßÐ\u0011ã\u00993ìCm\u0092ü¢}õù\u0005\u007fTÞd\u0014·\u0084MV}.-«Ü:\u008c«¿:o\u008e\u001eHÎ\u0086ù\u0014©\u009aXh\bå;fëÂ\u009adJõu@%\u008aÔX\u0084Ü·]g(\u0017µÆ(ö¸\u0019\u0099)áyd\u0088õØdëõ;AJ\u0087\u009aX\u00adÖýU\f¸\\~oú¿\"Î÷\u001e(!\u0086q\u0005\u0080\u0088ÐNãÊ3ò\u007fþO\u008c\u001f\u0002î\u0090¾\u001d\u008d\u009e]j,¼ü-Ë¸\u009b\u0002jÀ:Q\tÃÙZ¨Ñx\\GÜ\u0017uæ¯¶'\u0085´U\u0082%\nô\u0087Ä\u0016\u0093\u008fc.2¢\u0002\u0014Ñ\u00ad¡gpïÓ3ãT³\u009bBM\u0012Æ!Lñé\u0080{Pþgj7áÆ\u001a\u0096\u008b\u0019\u008c)ëy$\u0088òØyëó;VJÁ\u009aC\u00adÕý]\f¥\\ho®¿'Î±\u001e2!\u0080qD\u0080\u0096Ð\u001fã\u00923åCm\u0092ü¢dõè\u0005ITÈdX\u0019¿)êyn\u0088âØyëõ;FJ\u0085\u009aV\u00ad\u008cý\f\u0019\u008c)ëy$\u0088òØcëõ;NJÌ\u009a\u0000\u00adÐýS\f³\\6o ¿3Î¡\u001ep!\u008dq\u000e\u0019\u008a)áyy\u0088äØ;{°KÍ\u001bDêÃº\u001f\u0089ÈYs(ìø'Ïâ\u009fxn\u008a>\u0014\rÆÝ\u0005¬\u008d|\u0016C³\u0013>\u0019\u008f)áyg\u0088åØ8ëô;UJ\u0086\u009aC\u00adÕýS\f®\\-o©¿+Î«\u0019\u008f)áyg\u0088åØ8ëï;DJ\u0086\u009aH\u00adÕýQ\f¥\\\u0019o¯¿3Îµ\u001e;!\u0096q\u000b\u009d\u0093\u00adýý{\fù\\$oó¿XÎ\u009a\u001e^)ËyB\u0088\u0083Ø>ëµ; J·\u009a+¥\u008cõ\u000f\u0019\u008c)ëy$\u0088ûØsëî;LJÍ\u009aB\u00ad\u009aý[\f®\\\"o¾¿=Î±\u001e:!Êq\u001b\u0080\u0095Ð\u001bã\u00893æz\u001dJz\u001aµëc»è\u0088bXÇ)\u0017ùÎÎ@\u009eÆo$?ù\f<Üµ\u00ad-}\u0090B\u001b\u0012\u009aã\f³\u0082\u0019\u008c)ëy$\u0088ÿØrëñ;\fJÊ\u009a[\u00adÝýV\f¤\\hoª¿;Î¶\u001e9!\u0081q\u0018\u0080\u0080Ð\u0004ã\u00953ìC|÷FÇ!\u0097îf*6®\u00059Õ\u008c¤\u0017t\u0087C\n\u0013Þâh²ù\u0081oQô vðºÏH\u009fÉnT>Û\rSÝ:\u00ad²|6L·\u001b>ë\u009e\u0081i±\u000eáÁ\u0010\u0006@\u008as\n£³Ò(\u0002¦5\u007fe½\u0094PÄÊ÷E'ÓV\u0013\u0086Ý¹héá\u0018rHö{k«\u0017Û\u009f\n\u0002:\u009fm\u000b\u0019\u008c)ëy$\u0088ãØoëï;VJÍ\u009aC\u00adëý_\f¸\\2oâ¿0Î\u00ad\u001e7!\u0088q\u000e\u0080ÞÐ\u0010ã\u00953ìCo\u0092ë¢fõê\u0005RTÏdB·Æ\u0019\u008c)ëy$\u0088æØsëò;FJÇ\u009a\\\u00ad\u009aýX\fµ\\/o ¿6Îö\u001e8!\u008dq\u0004\u0080\u0097Ð\u0013ã\u008e3òCz\u0092ç¢zõî\u0006Í6ªfe\u0097§Ç2ô³$\u0007U\u0086\u0085\u001d²ªâ\u001f\u0013íClpà =Ñû\u0001j>ÌnG\u009fÕÏ\u0019üÛ,ª\\'\u008d¨½0ê©\u001a\u0011K\u0095{\u0004¨\u009dØ\r\u001bê\u0084l´]äÒ\u0015[E\u0084vP¦ú×x\u0007æ0V`÷\u0091\u0014Á\u008bò\u0014\u0019Ñ)àyo\u0088æØ9ëï;MJË\u009aE\u00adÑýN\fï\\$o\u00ad¿!Î½\u001e<!\u0085q\u0004\u0080\u0094Ð)ã\u009b3çCf\u0092÷¢p\u0019Ñ)àyo\u0088æØ9ëï;MJË\u009aE\u00adÑýN\fï\\!o©¿<Î¡\u001e:\u0006\u009a6«f$\u0097\u00adÇrô¤$\u0006U\u0080\u0085\u000e²\u009aâ\u0005\u0013¤C|pâ tÑæ\u0001q<¦\f\u0080\\\u0004\u00ad\u0094ýNÎ\u009a\u001e0o²¿,\u0088\u009cØ9)ÅyPJØ\u009a@\u001b¯+\u0089{\r\u008a\u009dÚ\u001cé\u008791Hù\u0098<¯£ÿ&\u000e\u0091^TmÛ½NÌÅ\u001c\u007f#÷su\u0082âÒdáí1\u009fA)\u0090\u0094 \u000f÷\u0086\u0007+V¿f\rµ½Å#\u0014\u00ad$Ok\u009a»]ÊÇ\u0019Ñ)àyo\u0088æØ9ëþ;QJÜ\u009aq\u00adÓýJ\f³j«Z\u009a\n\u0015û\u009c«C\u0098\u0084H+9¦é\u000bÞº\u008e)\u007f×/Y\u0010É øpw\u0081þÑ!â÷2UCÓ\u0093]¤ÉôV\u0005÷U<f§¶>Ç¦\u0017)(\u0090x\u0016\u0089\u008dÙ\u001cê\u0080\u0019Ñ)÷ys\u0088ãØbëù;OJ\u0087\u009aB\u00adÝýX\fï\\*o¥¿0Îº\u001e-!\u0090q\f\u0080\u009fÐ\u001aã\u00983çCz\u0092Ñ¢~õô\u0005IT\u0088d_·Ý\u0019Ñ)àyo\u0088æØ9ëþ;QJÜ\u009aO\u00ad×ýY\f¥´Ó\u0084âÔm%äu;Fü\u0096SçÞ7K\u0000ÏPJ¡\u00ad\u00806°\u0007à\u0088\u0011\u0001AÞr\u0019¢¶Ó;\u0003¤46dº\u0095I\u0019Ñ)àyo\u0088æØ9ëþ;QJÜ\u009aA\u00adÆýS\f¥\u0019Ñ)àyo\u0088æØ9ëþ;QJÜ\u009aX\u00adÙýI\f§þQÎ`\u009eïof?¹\f~ÜÑ\u00ad\\}ÞJS\u001aÛë)»¶\u0088/\u0019Ñ)àyo\u0088æØ9ëþ;QJÜ\u009aq\u00adÝýW\f¥\u0019Ñ)àyk\u0088äØwë³;FJÇ\u009aY\u00adÚýV\f¯\\'o¨¿!Î÷\u001ep!\u009cq\b\u0080ßÐ\u0014ã\u008f3öCc\u0019Ñ)éyd\u0088äØ9ëë;KJÆ\u009aJ\u00adÛýM\f³\\io\u008e¿!Î¬\u001e\r!\u008cq\u000b\u0080\u0082Ð\u0013ã\u00983ÄCg\u0092â¢põÿ\u0005R\u0086N¶kæç\u0017`Gêt,¤ÔÕX\u0005Á2Db×\u0093+Ãª\u0019Î)âyl\u0088°Ø,\u0019Ñ)ôyx\u0088ÿØuë³;QJÍ\u009aB\u00adÒý\u0015\f\u00ad\\'o¼¿!\u0019\u0099)öyk\u0088üØzëó;AJ\u0086\u009aI\u00adÛýV\f¤\\ o¥¿!Î°\u001ep!\u0097q\u0005EÇu¸%=Ô\u0082\u0084\u000f·\u008cg$\u0016¢Æ\u0019ñ\u0092¡\u001bP»\u0000`3ö\u0019Ñ)áy~\u0088óØ9ëñ;GJÌ\u009aG\u00adÕýe\f£\\)o¨¿7Î»\u001e-!Êq\u0012\u0080\u009dÐ\u001aÐ3àG°ÐAZ\u0011Ê\"Gòì\u0083dSêdh\u009fV¯fÿù\u000et^¾mv½ÊÌZ\u001cÇ+G{Îi\u0097Y¦\t-ø¢¨1\u009bõK\u0000:\u0081ê\u001fÝ\u009c\u008d\u0010|é,a\u001fîÏg¾±n6QÆ\u0001\\ð\u0099 Q\u0093ÊC´3=âæÒ*\u0085±u\n\u008d\u0088½ïgÍWè\u0007döã¦i\u0095¯E]4ÄäGÓÁ\u0083Hrº\"5ýpÍ\"\u009d¯l=<¹\u000f<ß\u0098®\t\u0002#2\u0012b\u0099\u0093\u0016Ã\u0085ðA ½Q3\u0081¯¶%æç\u0017BGÆtQ¤ÆÕC\u0005À:sjë\u009b-Ëçø{(\u0002XÕ\u0089L¹Éî\u000b\u001e½O9\u007fð¬-Ü£\r/=ÄrW¢ÔÓM\u0003Ü0d`´\u0091qÁãöe&\u0007V\u009d\u0087\u0013·\u0085".getBytes(CharEncoding.ISO_8859_1)).asCharBuffer().get(cArr, 0, 1959);
        _CREATION = cArr;
        _BOUNDARY = 878524953990998404L;
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(Unknown Source)
        	at java.base/java.util.TreeMap.lastKey(Unknown Source)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r69, int r70, int r71, int r72) {
        /*
            Method dump skipped, instruction units count: 14069
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fresco.ui.common.ImagePerfDataNotifier.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
    }
}
