package n.o.t.i.f.e.e;

import android.graphics.Color;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import o.ArtificialStackFrames;
import o._CREATION;
import okio.Utf8;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes6.dex */
public class q {
    private static long _BOUNDARY;
    private static char[] _CREATION;
    public String a;
    public byte[] b;
    public byte[] c;
    public Boolean d;
    private static final byte[] $$c = {52, -35, -61, -47};
    private static final int $$d = 222;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {84, -77, Utf8.REPLACEMENT_BYTE, -18, -53, 47, Ascii.VT, 17, -5, -12, Ascii.VT, -8, 0, 17, -8, 19, -19, -2, -52, Ascii.SYN, 1, -3, 53, -13, -1};
    private static final int $$b = 0;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(int r6, short r7, byte r8) {
        /*
            int r8 = 106 - r8
            byte[] r0 = n.o.t.i.f.e.e.q.$$c
            int r6 = r6 * 4
            int r6 = r6 + 4
            int r7 = r7 * 3
            int r1 = 1 - r7
            byte[] r1 = new byte[r1]
            r2 = 0
            int r7 = 0 - r7
            if (r0 != 0) goto L17
            r4 = r8
            r3 = r2
            r8 = r6
            goto L2a
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L23:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r8
            r8 = r6
            r6 = r5
        L2a:
            int r4 = -r4
            int r6 = r6 + r4
            int r8 = r8 + 1
            r5 = r8
            r8 = r6
            r6 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: n.o.t.i.f.e.e.q.$$e(int, short, byte):java.lang.String");
    }

    public q(String str, byte[] bArr, byte[] bArr2, Boolean bool) {
        this.a = str;
        this.b = bArr;
        this.c = bArr2;
        this.d = bool;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void e(byte r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 + 4
            int r0 = r8 + 2
            byte[] r1 = n.o.t.i.f.e.e.q.$$a
            int r7 = 115 - r7
            byte[] r0 = new byte[r0]
            int r8 = r8 + 1
            r2 = 0
            if (r1 != 0) goto L13
            r4 = r7
            r3 = r2
            r7 = r6
            goto L2a
        L13:
            r3 = r2
        L14:
            int r6 = r6 + 1
            byte r4 = (byte) r7
            r0[r3] = r4
            if (r3 != r8) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L23:
            int r3 = r3 + 1
            r4 = r1[r6]
            r5 = r7
            r7 = r6
            r6 = r5
        L2a:
            int r6 = r6 + r4
            int r6 = r6 + (-2)
            r5 = r7
            r7 = r6
            r6 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: n.o.t.i.f.e.e.q.e(byte, byte, int, java.lang.Object[]):void");
    }

    private static void f(char c, int i, int i2, Object[] objArr) throws Throwable {
        int i3 = 2;
        int i4 = 2 % 2;
        _CREATION _creation = new _CREATION();
        long[] jArr = new long[i2];
        _creation.b = 0;
        while (_creation.b < i2) {
            int i5 = $11 + 101;
            $10 = i5 % 128;
            int i6 = i5 % i3;
            int i7 = _creation.b;
            try {
                Object[] objArr2 = {Integer.valueOf(_CREATION[i + i7])};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) 0;
                    byte b2 = b;
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(Color.alpha(0) + 8, (char) (Color.argb(0, 0, 0, 0) + 9279), Color.red(0) + 1977, 1113883676, false, $$e(b, b2, (byte) (b2 + 2)), new Class[]{Integer.TYPE});
                }
                Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i7), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                if (objAccessartificialFrame2 == null) {
                    byte b3 = (byte) 0;
                    byte b4 = b3;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(29 - Process.getGidForName(""), (char) (49362 - TextUtils.getTrimmedLength("")), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 684, -115095555, false, $$e(b3, b4, b4), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                }
                jArr[i7] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                Object[] objArr4 = {_creation, _creation};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) 0;
                    byte b6 = b5;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 24, (char) (30068 - View.MeasureSpec.getMode(0)), TextUtils.indexOf("", "", 0) + 816, 1897803493, false, $$e(b5, b6, (byte) (b6 + 3)), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                i3 = 2;
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
        int i8 = $10 + 57;
        $11 = i8 % 128;
        int i9 = i8 % 2;
        while (_creation.b < i2) {
            int i10 = $10 + 19;
            $11 = i10 % 128;
            int i11 = i10 % 2;
            cArr[_creation.b] = (char) jArr[_creation.b];
            Object[] objArr5 = {_creation, _creation};
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-293902099);
            if (objAccessartificialFrame4 == null) {
                byte b7 = (byte) 0;
                byte b8 = b7;
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(KeyEvent.keyCodeFromString("") + 25, (char) (30067 - TextUtils.lastIndexOf("", '0')), 815 - TextUtils.indexOf((CharSequence) "", '0', 0), 1897803493, false, $$e(b7, b8, (byte) (b8 + 3)), new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame4).invoke(null, objArr5);
        }
        objArr[0] = new String(cArr);
    }

    static {
        char[] cArr = new char[1959];
        ByteBuffer.wrap("\u0019Ñ¹«Yùù\u001b\u0099\u00159lØ·xÅ\u0018\u0012¸!X}û\u0096\u009bÚ;ÜÛ1{E\u001a\u008aºÍZéú.\u009aY=¤Ý»}é\u001d\u0007½T]a´\f\u0014vô$TÆ4È\u0094±ujÕ\u0018µÏ\u0015üõ VK6\u0007\u0096\u0001výÖ\u0095·C\u0017\u0007÷\u000eWä7\u0087\u0090TpvÐ0°ßãlC\u0016£D\u0003¦c¨ÃÑ\"\n\u0082xâ¯B\u009c¢À\u0001+agÁa!\u009e\u0081åà=@a\u0089H)%É|i\u0087\t\u008c©ÿH.èT\u0088\u009a(²ÈèkS\u000bL«uK¥ëÜ\u008a\u0011*OÊfj¬\nì\u00ad\u0000M0ít\u008d\u008b-ËÍïl5\u0084K$0Ärd\u0094\u0004\u008f¤õE%å\u001d\u0085\u009c%¯Åáf\u000fV\u008aöñ\u0016³¶UÖNv#\u0097ê7\u009fW\u0003÷l\u0017=´ÑÔ\u0099\u0019Ñ¹¼Yøù\u000e\u0099[9yØ¼x\u0086\u0018$¸\u0001XYû\u008a\u009bÄ;æÛ\u0014{@\u001a\u009aºÞ\u0019Ñ¹«Yýù\u0019\u0099[9$ØöxÊ\u0018\u0006¸2X}û\u008b\u009bÔ;ì\u0019\u008c¹ Y²ù\u000f\u0099U9dØ¬x\u0087\u0018\u0004¸\"Xpû\u0097\u009bÝ;êÛ4{~\u001a\u0080ºÚZøú\u0002\u009aN=\u0095Ý»}¨\u00856%\u001aÅ\beµ\u0005ï¥ÞD\u0016ä=\u0084¾$\u0098ÄÊg-\u0007g§PG\u008eçÄ\u0086:&`ÆBf¸\u0006ô¡/A\u0001á\u0011\u0019Ñ¹¼Yåù\u001e\u0099N9nØµx\u0086\u0018\u001a¸.XvûÊ\u009bÞ;êÛ2{O\u001a\u008cº\u0091Zÿú2JùêÃ\n\u009eªfÊ0j\u0016\u0005 ¥ME\u0014åï\u0085¿%\u009fÄDdw\u0004å¤ßD\u008bç;\u0087-'\u0017ÇÌg¥\u0006I¦\u0003FPæÂ\u0086¾!gÁLaE\u0001ô¡©A\u009bàP\u0080! íÀÝXÌø¡\u0018ø¸\u0003ØSxs\u0099¨9\u009bY\tù3\u0019gº×ÚÁzû\u009a :I[¥ûï\u001b¼»0ÛE|\u0089\u009c¥\u0019Ñ¹¼Yåù\u001e\u0099N9nØµx\u0086\u0018\u001a¸.XvûÊ\u009bÞ;êÛ2{O\u001a\u008bºÒZùú\u000b\u009ag=\u008bÝº}ö\u001d\u0016½\u0019]wüº\u0019Ñ¹«Yùù\u001b\u0099\u00159eØ½xÄ\u0018\u0003¸ Xaû\u0080\u009bÁ;÷\u0019\u008c¹ Y²ù\u000f\u0099O9bØ´xÍ\u0018X¸/X{û\u0096\u009bÆ¼7\u001c\rüZ\\¹<ø\u009c\u0082}\u0011Ýk½¥\nÚª´Jåê\t\u008aR*/ËµkË\u000b\u0011«)Klè\u0097\u0088Ê(üÈ>hG\t\u0096\u0019\u0090¹ªYñù\u0018\u0099I9m3ª\u0093\u0086s\u0094Ó;³n\u0013Bò\u009aRú23\u0092\u0015r\u001cÑ®±õ\u0011Ëñ\u0003Qa0©\u0090úpÞÐ\u000e°~\u0017¸÷\u009c\u0019\u0099¹ªYòù\u0014\u0019\u008e¹ªYîù\u001e\u0099S9xØ¬x\u0087\u0018\u0005¸>XgûË\u009bÐ;çÛ~{E\u001a\u008bºÝZùú:\u009a\u0004=\u009cÝ¸}ì\u001dH½Q]eü¾\u009cÇ<,Ü'|a\u001f«¿ð_\u000eÿ(\u009ft>\u008fÞÝ~û\u001e3¾U\u0019\u008e¹ªYîù\u001e\u0099S9xØ¬x\u0087\u0018\u0005¸>XgûË\u009bÐ;çÛ~{E\u001a\u008bºÝZùú:\u009a\u0004=\u009cÝ¸}ì\u001dH½Q]eü¾\u009cÇ<,Ü'|a\u001f«¿ð_\nÿ(\u009ft>\u008fÞ×~û\u0081l!HÁ\faü\u0001±¡\u009a@Nàe\u0080ç ÜÀ\u0085c)\u00032£\u0005C\u009cã§\u0082i\"?Â\u001bbØ\u0002æ¥kEEåU\u0085ç%¤Å\u008f\u0019\u008e¹ªYîù\u001e\u0099S9xØ¬x\u0087\u0018\u0005¸>XgûË\u009bÐ;çÛ~{E\u001a\u008bºÝZùú:\u009a\u0004=\u0089Ý§}·\u001d\n½V]góåSÁ³\u0085\u0013us8Ó\u00132Ç\u0092ìònRU²\f\u0011 q»Ñ\u008c1\u0015\u0091.ðàP¶°\u0092\u0010Qpo×â7Ì\u0097Ü÷`W?·\f`ùÀÝ \u0099\u0080ià$@\u000f¡Û\u0001ðarÁI!\u0010\u0082¼â§B\u0090¢\t\u00022cüÃª#\u008e\u0083MãsDþ¤Ð\u0004Àd|Ä.$\u0010ÆæfÃ\u0086\u009d&{F'æ\u0003\u0019Ñ¹¿Yîù\u0002\u0099Y9$ØµxÆ\u0018\u0012¸2Xxû\u0080\u009bÁ5\u001b\u0095>u`Õ\u0086µÎ\u0015íô.TI4\u0091\u0019¢¹\u008e\u001a»º¨Zðú\u0016\u009aU:fÛ®{Â\u001b\u001b»+º+\u001a\u0001úWZ£:õ\u009aÜ{\u0016\u0011U±oQ&ñÊ\u0091\u009f1ªÐep\f¼t\u001cXüJ\\å<°\u009c\u009c}DÝ$½í\u001dËýÂ^y>/\u009e\r~ÁÞº¿s}¯Ý\u008a=Ô\u009d2ý%]\u001a¼\u008f\u0019\u0099¹ªYòù\b\u0099H9bØ»\u0019\u0099¹ªYòù\b\u0099H9bØ»xö\u0018\u000e¸\u007fX\"\u0019\u0099¹ªYòù\b\u0099H9bØ»xö\u0018\u000e¸\u007fX\"ûº\u009b\u0084;·iCÉo)}\u0089Òé\u0087I«¨s\b\u0013hÚÈü(õ\u008bGë\u0012K(«ú\u000b\u0082\u0019\u008d¹«Y÷;*\u009b\u0013{XÛ°»ê\u001bÎú\u0006Zj\u0019¿¹¿YìùM\u0099h9~Ø¶xÝ\u0018\u001f¸*XqûÅ\u009bÔ;ìÛ\"{\u0001\u001a\u00adº×Zþú2\u009aG=\u009e\u0019¿¹¡Yøù\u001f\u0099U9bØ¼x\u0089\u0018%¸\u0003X_ûÅ\u009bÐ;öÛ9{M\u001a\u009aº\u009fZêú2\u009aX=ÛÝ°}¡\u001dP¬\u0095\f\u008bìÒL5,\u007f\u008cHm\u0096Í£\u00ad\u000f\r)íuNï.ú\u008eÜn\u0013Îg¯°\u000fµïÀO\u0018/r\u0088ñh\u009aÈ\u008b¨z\bBè\u0018IË\u0019\u008c¹ Y²ù\u0005\u0099[9yØ¼xÞ\u0018\u0017¸5Xq\u0019\u0099¹ Yðù\t\u0099\\9bØ«xÁ\u0019\u0088¹\u00adYóù\u0015\u0099\u00029=L£ì\u0081\fÝ¬!Ì}lQºI\u001aeúwZØ:\u008d\u009a¡{yÛ\u0019»Ð\u001böûÿXB8\u0005\u0098'xûØ\u0080\u0019\u008c¹ Y²ù\u0006\u0099_9yØ¶xÌ\u0018\u001a¸iXeû\u0080\u009bß;öì\rWD÷h\u0017z·Ö×\u0097w \u0096e6\u0013VÛ\u0019Î\u0019\u008c¹ Y²ù\u000f\u0099O9bØ´xÍ\u0018X¸7Xfû\u008a\u009bÖ;öÛ3{UýI]k½!\u001dÐ}´Ý¢<1\u009cN\u0019\u008c¹ Y²ù\u000f\u0099O9bØ´xÍ\u0018X¸!X}û\u008b\u009bÕ;æÛ\"{Q\u001a\u009cºÖZâú)÷=W\u000e·V\u0017¬wì×Æ6\u001f\u0096\"ö¡V\u0087¶Û\u0015nuqÕB5\u009a\u0095àô8Tr´KZÕúæ\u001a¾ºDÚ\u0004z.\u009b÷;º[Bû3\u001bn¸\u0086Ø\u008dx«\u0098w82YÚùË\u0019ö¹>Ù\u0001~Ò\u009eê>°^Xþ\u0012\u001e+¿Æß\u0096\u007f\u0007\u009f:b\tÂ:\"b\u0082\u0098âØBò£+\u0003\u0016c\u0081Ã¸#ë\u0080\u0012àN@v \u009f\u0000Âa\u001aÁD!3\u0081ªáßF\u0005¦=\u0006{f\u009fÆÄ\u0016ù¶ÊV\u0092öh\u0096(6\u0002×Ûwæ\u0017`·EW\u001bôý\u0094ê4ÕÔ@tn\u0015øµ½U\u0083õE\u0095r2\u00adÒØ\u0019\u0099¹ Yóù\n\u0099V9nØ÷xÚ\u0018\u0012¸,XKû\u0082\u009bÂ;ëÛ?{O\u001a\u008bºàZôúe\u009a\u001c=ÔÝ¯}ü\u001d\b½R]vü¼\u009cÁ<,Ü8|)\u001fè\u0019\u008c¹ Y²ù\u000f\u0099U9dØ¬xÅ\u0018\u0019¸&Xpû\u0080\u009bÀ¨1\b\u001dè\u000fH²(è\u0088Ùi\u0011É}©¦\t\u009béÎJ=*!\u008a\\j\u0098Êõ«?\u000bfë\u001fK\u0086+þ\u008c(l\u0012ÌA¬©\fúìËM\u0001-q\u008dº\u0019¿¹¡Yøù\u001f\u0099U9bØ¼x\u0084\u0018\u000e¸\u007fX\"\u0018õ¸ÙXËøv\u009868\u001bÙÍy´\u0019!¹ZY\u0004úï\u009a»:\u0096ÚHz!\u001b¹»¯[\u0091î¡N\u0081®Ä\u000e2n<2·\u0092\u0081rÕÒ9²4\u0012Xó\u008eSê3x\u0093\u0016sQÐ¨°ç\u0010\u008eð\u0000Ps1¡\u0091ïqß\f°¬\u0095LÎì'\u008c+,\\Í\u0090m¸\r$\u00ad\u0019MBî´\u008eæ.ÙÎ\u0016nm\u0019\u008f¹ªYñù\u0018\u0099\u00149xØ¾x\u0087\u0018\u0010¸&X\u007fû\u0080\u009bí;àÛ1{L\u001a\u008bºÍZí-&\u008d\u0003mXÍ±\u00ad½\rÑì\u0017L.,³\u008c\u008dlÙÏ\u0013¯\u007f\u000fOï\u0097Oû..\u008ebn\\\u0019\u008c¹ Y²ù\u0006\u0099_9yØ¶xÌ\u0018\u001a¸iXuû\u008b\u009bÖ;ñÛ?{H\u001a\u008aº\u0091Zýú8\u009aG=\u008eÝ¬\u0019\u008c¹ Y²ù\u000f\u0099U9dØ¬x\u0087\u0018\u0007¸\"Xyû\u0090\u009b\u009c;âÛ&{E\u001a±ºÑZíú0\u009aOöFVj¶x\u0016Èv\u0094Ö¬7<\u0097\u0001÷ÉWä·²\u0014KtVÔ/4ó\u0094\u0085õCU\u0010µ4\u0015çu\u0092ÒX2l\u0092'\u0003z£VCDãë\u0083¾#\u0092ÂJb*\u0002ã¢ÅBÌáq\u00811!\u001cÁÊa³\u00006 /@\u0013àÅ\u0080»'hÇLg\u001f\u0007â§¨G\u009cæW\u0019\u008c¹ Y²ù\u001e\u0099C9xØ¬xÌ\u0018\u001b¸iXvû\u0090\u009bÛ;ïÛ4{\u000f\u001a\u0088ºÖZâú:\u009aO=\u0089Ý¸}ë\u001d\u000f½Y]p\u0019\u008c¹ Y²ù\u001e\u0099C9xØ¬xÌ\u0018\u001b¸\u0018Xqû\u009d\u009bÆ;\u00adÛ2{T\u001a\u0087ºÓZèús\u009aL=\u0092Ý¦}þ\u001d\u0003½E]tü§\u009cË<\u001dÜ4\u00876'\u001aÇ\bg¡\u0007å§ßF\u0006æ|\u0086¾&ÓÆÌe*\u0005a¥UE\u008eåµ\u00842$lÄXd\u0080\u0004õ£3C\u0002ãQ\u0083µ#ãÃÊ3L\u0093`srÓÛ³\u009f\u0013¥ò|R\u00062Ä\u0092Ør°ÑI±\u0019\u0011.ñ¾Q\u00830[\u0090\u0016p Ðù°Ä\u0017]÷aW77Á\u0097\u0092w¶Öe¶\u0010\u0016ÚöîV¥\u0019Äû\u0089[ó»¡\u001bC{MÛ\":å\u009a\u009cú[Z@º<\u0019Ôy\u009aÙ¾é\u009fIå©·\tUi[É6(ù\u0088\u0084èSHl¨.\u000b\u0084k\u009eË¬+m\u008b\nêÂJ\u0090ª¬\nwj;ÍÒ-ã\u008d¹íQM\u001dß&\u007f\\\u009f\u000e?ì_âÿ\u008f\u001e@¾=Þê~Õ\u009e\u0097==]\"ý\u0011\u001dÉ½¯Ü}\u0019Ñ¹«Yùù\u001b\u0099\u00159xØ·xÊ\u0018\u001d¸\"X`ûÊ\u009bÃ;æÛ={T\u001a\u008a\u0019Ñ¹¼Yåù\u001e\u0099\u00159zØ½xÄ\u0018\u0003¸\u0018X`û\u0097\u009bÓ;àÛ5\u001eÐ¾½^äþ\u001f\u009eO>oß´\u007f\u0087\u001f\u001b¿/_wüË\u009cß<ëÜ3|C\u001d°½Ó]ìý0\u009dG:\u0095ÚªzÇ\u001a\u0003ºSZgû¡\u009bÄ;-Û0{u\u0018²¸ÛXSø?\u0098t¼»\u001cÁü\u0093\\q<\u007f\u009c\u0003}ÁÝ·½C\u001dJý\u000e^ü\u0019Ñ¹«Yùù\u001b\u0099\u00159iØ«xÝ\u0018)¸3X}û\u0088\u009b×\u0019Ñ¹«Yùù\u001b\u0099\u00159xØ·xÊ\u0018\u001d¸\"X`ûÊ\u009bÐ;ðÛ${G\u001a\u0081ºÓZèú8\u009aX=\u009f\u0019Ñ¹¼Yåù\u001e\u0099N9nØµx\u0086\u0018\u001a¸.XvûÊ\u009bÞ;êÛ2{C\u001a\u009dºËZêú2\u009aF=\u009fÝ\u00ad}ë\u001d9½]]jü¼\u009c\u008c<\u0000Ü/<\u0095\u009cï|½Ü_¼Q\u001c-ýï]\u0099=S\u009d`}3ÞÄ\u0019Ñ¹«Yùù\u001b\u0099\u00159iØ«xÝ\u0018\u0011¸>Xfû\u008a\u0019Ñ¹«Yùù\u001b\u0099\u00159iØ«xÝ\u0018\u001b¸\"Xsû\u008boéÏ\u0093/Á\u008f#ï-OQ®\u0093\u000eån!Î\r.E\u008d¸\\Aü;\u001ci¼\u008bÜ\u0085|ù\u009d;=M]\u0090ýº\u001d÷¾\u0012\u0019Ñ¹«Yùù\u001b\u0099\u00159iØ«xÝ\u0018\u0006¸ Xuû\u008c\u009bÂ;à\u0088K(1Èch\u0081\b\u008f¨óI1éG\u0089³)´Éãj\u001aVëö\u0091\u0016Ç¶#Öav\u001e\u0097\u00867üW;÷\u0013\u0017B´°ÔétÝ\u0094\u001944Uúõý\u0015ÔµHÕrr²\u0092\u00862ÈÂôb\u0087\u0082×\"<B0âY\u0003\u0094£âÃ7c\r\u0083F ³@¸àä\u0000\u0006 pÁ\u0098aò\u0081È!\nAjæº\u0006«¦ÓÆ/fv\u0086D'\u0082\u001c\\¼2\\cü\u008f\u009cÔ<©Ý<}K\u001d\u008b½¥]ëþ\u001c\u009eLÖ5vR\u0096\u00016¶Vû{ÁÛ¯;þ\u009b\u0012ûI[4º»\u001aÜz\nÚ1:+\u0099\u0098ùÃYã¹3\u001bñ»Õ[\u0095ûi\u009b>;\fÚÓzï\u001ayº@Z\u0010ùé\u0099¼9\u0082ÙKy!\u0018¨¸¤X\u008b\u0019\u0092¹¦Yþù*\u0099v9NØ\u008bxö\u0018\u0014¸4X`ûË\u009bÁ;ì\u0019Ñ¹ªYèù\u000e\u0099\u00159fØ½xÍ\u0018\u001f¸&XKû\u0086\u009bÝ;çÛ5{B\u001a\u009dº\u0091Zôú0\u009aF\u0019\u009c¹£Yéù\b\u0099I9\u007fØ¹xÊ\u0018\u001d¸4ÍSm(\u008dj-\u008cM\u0097íä\f5¬^Ì\u009al±\u008cåK0ëJ\u000b\u001c«øËºkÅ\u008a]*'JàêÈ\n\u0099©kÉ2i\u0006\u0089Â)ïH!è:\b\u001d¨\u0093Èªoj\u008fY/\u000bO©ï®\u000f\u0088®X\u0019Ñ¹¿Yîù\u0002\u0099Y9$Ø»xÙ\u0018\u0003¸.Xzû\u0083\u009bÝ\u0019¹¹ Yðù\t\u0099\\9bØ«xÁÔ0tJ\u0094\u001c4øTºôÅ\u0015Tµ!ÕäuÅ\u0095Ú6tV!ö\r\u0016×¶©×cw;\u0097\u001e7\u0093W¨ðo\u0010[°WÐ·pù\u0090\u00861[Q.ñ¼\u0011Ì±\u0099Ò\\r<\u0092ò2ÚR\u0092óx\u0013-³FÓÚs£\u009cx<Q\\\u001aüï\u001c´".getBytes(CharEncoding.ISO_8859_1)).asCharBuffer().get(cArr, 0, 1959);
        _CREATION = cArr;
        _BOUNDARY = 8614923299539696079L;
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(Unknown Source)
        	at java.base/java.util.TreeMap.lastKey(Unknown Source)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] TopicBuilder(android.content.Context r71, int r72, int r73, int r74) {
        /*
            Method dump skipped, instruction units count: 15962
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: n.o.t.i.f.e.e.q.TopicBuilder(android.content.Context, int, int, int):java.lang.Object[]");
    }
}
