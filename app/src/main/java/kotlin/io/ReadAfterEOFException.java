package kotlin.io;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.PointerIconCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.common.base.Ascii;
import com.google.crypto.tink.proto.JwtEcdsaAlgorithm;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import o.ArtificialStackFrames;
import o._CREATION;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.commons.lang3.CharEncoding;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class ReadAfterEOFException extends RuntimeException {
    private static long _BOUNDARY;
    private static char[] _CREATION;
    private static final byte[] $$c = {122, -14, -75, -84};
    private static final int $$d = 246;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {103, 5, 74, Ascii.SYN, 53, 3, -52, Ascii.SO, 2, -46, -10, -16, 6, 1, -16, -21, 0, 4, Ascii.CR, -10, 9};
    private static final int $$b = 0;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(short r6, byte r7, byte r8) {
        /*
            int r6 = r6 * 4
            int r6 = 1 - r6
            byte[] r0 = kotlin.io.ReadAfterEOFException.$$c
            int r7 = 106 - r7
            int r8 = r8 * 3
            int r8 = 3 - r8
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r8
            r4 = r2
            goto L2a
        L14:
            r3 = r2
        L15:
            int r8 = r8 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r6) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L24:
            r4 = r0[r8]
            r5 = r3
            r3 = r8
            r8 = r4
            r4 = r5
        L2a:
            int r7 = r7 + r8
            r8 = r3
            r3 = r4
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.ReadAfterEOFException.$$e(short, byte, byte):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(int r7, byte r8, byte r9, java.lang.Object[] r10) {
        /*
            int r7 = 17 - r7
            byte[] r0 = kotlin.io.ReadAfterEOFException.$$a
            int r8 = 115 - r8
            int r9 = 4 - r9
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L11
            r3 = r8
            r4 = r2
            r8 = r7
            goto L29
        L11:
            r3 = r2
        L12:
            int r7 = r7 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r9) goto L23
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L23:
            r3 = r0[r7]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r6
        L29:
            int r7 = -r7
            int r3 = r3 + r7
            int r7 = r3 + (-1)
            r3 = r4
            r6 = r8
            r8 = r7
            r7 = r6
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.ReadAfterEOFException.a(int, byte, byte, java.lang.Object[]):void");
    }

    public ReadAfterEOFException(@Nullable String str) {
        super(str);
    }

    private static void b(char c, int i, int i2, Object[] objArr) throws Throwable {
        int i3 = 2 % 2;
        _CREATION _creation = new _CREATION();
        long[] jArr = new long[i2];
        _creation.b = 0;
        while (_creation.b < i2) {
            int i4 = $11 + 5;
            $10 = i4 % 128;
            int i5 = i4 % 2;
            int i6 = _creation.b;
            try {
                Object[] objArr2 = {Integer.valueOf(_CREATION[i + i6])};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) 0;
                    byte b2 = (byte) (b + 2);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(8 - Color.argb(0, 0, 0, 0), (char) (Process.getGidForName("") + 9280), 1977 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 1113883676, false, $$e(b, b2, (byte) (b2 - 2)), new Class[]{Integer.TYPE});
                }
                Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i6), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                if (objAccessartificialFrame2 == null) {
                    byte b3 = (byte) 0;
                    byte b4 = b3;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 30, (char) (49362 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))), Color.alpha(0) + 684, -115095555, false, $$e(b3, b4, b4), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                }
                jArr[i6] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                Object[] objArr4 = {_creation, _creation};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) 0;
                    byte b6 = (byte) (b5 + 3);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(View.resolveSizeAndState(0, 0, 0) + 25, (char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 30068), 864 - AndroidCharacter.getMirror('0'), 1897803493, false, $$e(b5, b6, (byte) (b6 - 3)), new Class[]{Object.class, Object.class});
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
        int i7 = $10 + b.i;
        $11 = i7 % 128;
        int i8 = i7 % 2;
        while (_creation.b < i2) {
            int i9 = $11 + 29;
            $10 = i9 % 128;
            int i10 = i9 % 2;
            cArr[_creation.b] = (char) jArr[_creation.b];
            Object[] objArr5 = {_creation, _creation};
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-293902099);
            if (objAccessartificialFrame4 == null) {
                byte b7 = (byte) 0;
                byte b8 = (byte) (b7 + 3);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollBarSize() >> 8) + 25, (char) (30068 - TextUtils.getOffsetAfter("", 0)), TextUtils.indexOf("", "", 0, 0) + 816, 1897803493, false, $$e(b7, b8, (byte) (b8 - 3)), new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame4).invoke(null, objArr5);
        }
        objArr[0] = new String(cArr);
    }

    static {
        char[] cArr = new char[1959];
        ByteBuffer.wrap("\u0019Ñ\u0086C&)Æ\u0003fµ\u0006¤¦\u0087G}çR\u00879'íÇÞgº\u0007¤¤AD-ä\n\u0084å$ÙÄ\u0096ey\u0005l¥+EñåÇ\u0085¬%\u0091\u0019Ñ\u0086C&)Æ\u0003fµ\u0006¤¦\u0087G}çR\u00879'íÇÞgº\u0007¤¤PD ä\u001e\u0084ò$ãÄ\u0081ez\u0005A¥;EõåÂ\u0019Ñ\u0086C&)Æ\u0003fµ\u0006¤¦\u0087G}çR\u00879'íÇÞgº\u0007¤¤SD0ä\u0000\u0084ôÐoOêï\u008b\u000f¸¯\u000bÏ\u0010o9\u008eË.ýN\u008dî_\u000e<®\u000bÎ*mò\u008d\u0093-¶M@íq\r3¬ëÌïl\u0087\u008cK,lL\u0014ì8\u000bÚ\u0019Ñ\u0086B&8Æ\u0016fµ\u0006§¦\u008fG?çF\u0087-'ëÇÝVöÉei\u001f\u00891)\u0092I\u0097é¦\b[¨?È\bhÑ\u0088å(\u0085\u0019Ñ\u0086T&(Æ\u0016fû\u0006±¦\u008cG>çd\u0087\u0019'ÉÇÂg¤\u0007\u009e¤dD(ä\u001a\u0084ö\u0019Ñ\u0086C&-Æ\u0001fû\u0006ì¦ÆGrçF\u0087*'íÇÃg´\u0007\u0094ý²bvÂ\\\")\u0082Ëâ\u0092B¢£\u0001\u0003zc\u0004ÃÞ#á\u0083\u0083ã¬@z (\u0000>`ÌÀö \u0084\u0081PácA\u0015¡\u008e\u0019\u008c\u0086H&bÆ\u0017fõ\u0006¬¦\u009cG?çD\u0087:'àÇßg½\u0007\u0092¤DD\u0016ä\u0000\u0084ò$ÈÄºen\u0005]¥+E³[\u0010Ä\u0095dô\u0084Ç$/DgäD\u0005ÿ¥\u009bÅ÷e'\u0085C%\u007fESæ\u0083\u0006æ¦ÍÆxf\u000e\u0086Kb¤ýv]\u0013½#\u001dÍ}\u0083\u0019\u0080\u0086\u0005&dÆWf¿\u0006÷¦ÔGoç\u0005\u0087g'»ÇÓgí\u0007Ï¤\u001cDmäi\u0084\u008b$ÀÄÚe>\u0005\u000f¥|Eýå\u0094\u0085ñ%ËÂ8ba\u0002U¢\u00ad\u0019Ñ\u0086T&5Æ\u0006fî\u0006¦¦\u0085G>çT\u00876'êÇ\u0082g¼\u0007\u009e¤MD<ä8\u0084Ú$\u0091Ä\u0095ex\u0005\\¥(\u001a \u0085¥%ÄÅ÷e\u001f\u0005W¥tDÏä«\u0084Ç$\u0017ÄsdO\u0004c§³GÖçú\u0087\u000b'8ÇBf¶\u0006²¦ÛF\u001fæ'\u0086\u0010&vÁ\u0083À'_µÿß\u001fõ¿Cß[\u007f{\u009e\u008a>µ^Îþ\u0007\u001e>¾WÞy´û+?\u008b\u0015k`Ë\u0098«Ý\u000bóê\u0002Jo*@\u008a\u009cj©ÊÑ\u0019\u0090\u0086B&-Æ\u0006fÿ\u0006í¦\u0086GtçB\u0019Ñ\u0086W&>Æ\u001afù\u0006ì¦\u008eGxçZ\u0087:'÷ÇÔg¡\u0007\u008f¤ED$ä\u001d\u0019\u0090\u0086B&!Æ\u0000fé\u0006¥\u001c;\u0083ÿ¹¼&x\u0086Rf5ÆØ¦\u009c\u0006¼çTGe'\u001b\u0087\u009agðÇ\u0083§¥\u0004eä\u001fD?$Ä\u0084ød ÅH¥f\u0005\u001aJÒÕ\tui\u0095GTsË¿kÃ\u008bû+\u000eKMëa\nÂª¸ÊÛj\n\u008a~*MJbéó\tÐ©öÉ\bi4\u0089\u007f(ÙH©èÕ\b\t¨uÈThh\u008f\u008b/ÚOÉï\n\u000f4¯VÎ¥n£\u008eÍ.éN:îP\u000e~\u00ad\u008eÍ°Q?Îón\u008f\u008e·.BN\u0001î-\u000f\u008e¯ôÏ\u0097oF\u008f2/\u0001O.ì¿\f\u009c¬ºÌDlx\u008c3-\u0095Måí\u0099\rE\u00ad9Í\u0018m$\u008aÇ*\u0096J\u0085êF\nxª\u001aËékë\u008b\u0081+¥Kvë\u0016\u000b2WNÈ\u0082hþ\u0088Æ(3Hpè\\\tÿ©\u0085Éæi7\u0089C)pI_êÎ\níªËÊ5j\t\u008aB+äK\u0081ë÷\u000bo«\u0005Ë~k]\u0019\u008e\u0086B&>Æ\u0006fó\u0006°¦\u009cG?çE\u0087&'÷Ç\u0083g°\u0007\u009f¤\u000eD-ä\u000b\u0084õ$ÉÄ\u0082e$\u0005A¥7E¯åÊ\u0085®%\u00971p®¼\u000eÀîøN\r.N\u008eboÁÏ»¯Ø\u000f\tï}ON/a\u008cðlÓÌõ¬\u000b\f7ì|MÚ-¿\u008dÉmQÍ5\u00adR\ri\u0019\u008e\u0086B&>Æ\u0006fó\u0006°¦\u009cG?çE\u0087&'÷Ç\u0083g°\u0007\u009f¤\u000eD-ä\u000b\u0084õ$ÉÄ\u0082e$\u0005A¥7E¯åË\u0085¡%\u0097Ú`E\u00adåË\u0005å¥\u0001ÅM\u000b°\u009464_Ô{t\u0098\u0014\u008d´äU\u001fõ3\u0095K5\u0089Õ©uÀ\u0019\u0088\u0086E&#Æ\rfý\u0006¶¦\u008dGbçBÖ$Ißé¿\t\u0091©jÉ1i\u0001\u0088å(ÄH¬\u0019\u008b\u0086I&'Æ\u001bfõ\u0006´¦\u0086W*Èøh\u0089\u0088\u00ad(@H\u001dè*\tË\u0019\u008c\u0086H&bÆ\u0005fè\u0006¬¦\u008cGdçU\u0087+'ªÇÉg·\u0007\u008d¤ID*ä\u000bâÄ}\tÝo=A\u009dîý¹]Ô³£,x\u008c\u0018l*ÌÒ¬\u0090\f±\u0019\u0099\u0086B&\"Æ\u0010fè\u0006ª¦\u008bGNçN\u0087g'²C²Üi|\t\u009c;<Ã\\\u0081ü \u001de½eÝL}\u0099\u009dÙ=Ï]ä\u0019\u008c\u0086H&bÆ\u0005fè\u0006¬¦\u008cGdçU\u0087+'ªÇÀg½\u0007\u009f¤ED%º¿%q\u0085\u0015\u0019\u009b\u0086J&9Æ\u0019fû\u0006·¦\u0087Gc\u0019¿\u0086W&<ÆUfÈ\u0006¶¦\u0086Geç_\u00872'áÇ\u008dg´\u0007\u0094¤RDiä-\u0084ÿ$ÎÄ\u008aeg\u0005V&ò¹\u0004\u0019eùJY¸9ç\u0099Áx|Ø(¸V\u0018\u0082øÀXý8Ã\u009b\u0004{hÛW»ú\u001b\u0097ûÇZ5:^\u009amzôÚÝ\u0019¿\u0086I&(Æ\u0007fõ\u0006ª¦\u008cG1çe\u0087\u001b'ÏÇ\u008dg°\u0007\u008e¤ID%ä\u001a\u0084·$ÚÄ\u008aex\u0005\u0013¥ E¹å\u0090\u0085\u0090%ÂÂ)\u009f\u008c\u0000H b@\u001dàû\u0080± \u008cÁfaW\u0001-¡á\u0019\u0099\u0086H& Æ\u0011fü\u0006ª¦\u009bGy\u0019\u0088\u0086E&#Æ\rf¢\u0006õ\u0019\u008c\u0086F&\"Æ\u0016fò\u0006¶\u0019\u008c\u0086H&bÆ\u0005fè\u0006¬¦\u008cGdçU\u0087+'ªÇÏg \u0007\u009a¤ND-\u0019\u008c\u0086H&bÆ\u001efÿ\u0006±¦\u0086GtçZ\u0087q'õÇÈg¿\u0007\u008eô\u009a\u0019\u008c\u0086H&bÆ\u0006fÿ\u0006 ¦\u009dGcçS@ð\u0019\u008c\u0086H&bÆ\u0017fï\u0006ª¦\u0084Guç\u0018\u0087/'öÇÂg¶\u0007\u008e¤CD=\u0019\u0098\u0086R& Æ\u0019fÅ\u0006»¦ÐG'\u0019\u008c\u0086H&bÆ\u0017fï\u0006ª¦\u0084Guç\u0018\u00879'íÇÃgµ\u0007\u009e¤RD9ä\u001c\u0084þ$ÒÄ\u0091\u0019\u0099\u0086B&\"Æ\u0010fè\u0006ª¦\u008bG>çE\u0087;'ïÇ\u0082gµ\u0007\u009e¤ND,ä\u001c\u0084þ$ß\u0019\u0099\u0086B&\"Æ\u0010fè\u0006ª¦\u008bGNçN\u0087g'²Ç\u0082g¡\u0007\u009f¤KD\u0016ä\u0016\u0084¯$\u008aÄÊem\u0005V¥6EäåÔ\u0085¦%\u0097ÂBb:\u0002S¢¦\u0019\u0099\u0086B&\"Æ\u0010fè\u0006ª¦\u008bG>çQ\u00870'ëÇÊg¾\u0007\u009e¤\u007fD:ä\n\u0084ü$\u0093Ä\u0082eo\u0005]¥=EóåÏ\u0085¬R\u0090ÍKm+\u008d\u0019-áM£í\u0082\f7¬IÌ4lâ\u008cÜ,ãLÄïY\u000fo¯\u0011ÏüoÚ\u008f\u0094.;N\fî!I³Öbv\t\u009686ÜV\u008cöí\u0017H·x×\u001ewñ\u0097à7\u0088W¹ôe\u0014\r´!Ôâtî\u0094÷5\u0016U6õ\u0015\u0015ÎµâÕ\u0080u¬\u0092^2\u000bR\u001eòÂ\u0012«²Â×OH\u008bè¡\bÔ¨6Èoh_\u0089¾)\u009aIýé#\t\u000b©cä²{vÛ\\;)\u009bËû\u0092[¢ºF\u001aez\u0000ÚÝ:ö\u009aÂú§Yk¹\u001e\u0019<yÍÙ¬9½\u0098]øcX\u0001¸Ú\u0018êx\u0081Ø¸?J\u009f\u0012ÿ!\u0010×\u008f!/@Ïoo\u009d\u000fÂ¯äNTî&\u008e\u000f.ÚÁµ^qþ[\u001e.¾ÖÞ\u0093~½\u009fL?!_\u0002ÿÔ\u001fç¿\u009bß®|x\u009c\t<y\\ÇüáÊöU>õC\u0015}µË{ïä1D]¤y\u0004ÌdÈÄæ%\n\u0085`åVE\u0099¥¸\u0005ße®Æ(&C\u0086yæ\u009fF·\u0019\u008f\u0086B&!Æ\u0000f´\u0006«¦\u009fG?ç[\u0087>'íÇÃg¹\u0007\u009e¤YD:l\u0080óMS.³\u000f\u0013»s¿Ó\u008120\u0092_ò1Rà²Ç\u0012\u0082r\u0097ÑN1+\u0091\u0004ñêQÒ\u0019\u008f\u0086B&!Æ\u0000f´\u0006°¦\u008eG?çZ\u0087<'àÇòg¶\u0007\u009e¤ND:ä\u0007\u0084ã$Å\u0019\u008c\u0086H&bÆ\u001efÿ\u0006±¦\u0086GtçZ\u0087q'åÇÃg¶\u0007\u0089¤OD ä\n\u0084¹$ÍÄ\u0080eg\u0005F¥<éHv\u008cÖ¦6Ó\u00961öhVX·û\u0017\u0083wþ×-7\u001c\u00978÷^T\u0092´é\u0014õt=Ô\u00194L\u0095«\u0019\u008c\u0086H&bÆ\u001afþ\u0006®¦ÆGsçC\u00876'èÇÉgü\u0007\u009d¤ID'ä\t\u0084ò$ÎÄ\u0095ex\u0005Z¥6Eõ\u0019\u008c\u0086H&bÆ\u0005fè\u0006¬¦\u008cGdçU\u0087+'ªÇÏg§\u0007\u0092¤LD-ä@\u0084ñ$ÕÄ\u008bem\u0005V¥*EñåÔ\u0085¦%\u009aÂi\u0091Ó\u000e\u0017®=NYî¼\u008eï.ÃÏ+o\u0004\u000f.¯¹O\u0087ïä\u008fÈ,\u001bÌ8lW\f¡¬\u008dLÝí0\u008d\u001e-wÍ¬m\u0090\rþ\u00adßh\u001c÷ØWò·\u0096\u0017sw ×\f6ä\u0096Ëö\u0090Vq¶E\u00166vEÕÒ5¬\u0095\u0097õkUHµ[\u0014ütÊÔ¦4v\u0094Sô-T\u0014³ÿ\u0013»s\u0095Ót¾f!¢\u0081\u0088aéÁ\u0015¡G\u0001fà\u0094@® \u009b\u0080\f`2ÀQ }\u0003®ã\u008dCâ#\u0014\u00838chÂ\u0085¢«\u0002Ââ\u0019B%\"K\u0082jèRw\u0096×¼7Ý\u0097!÷sWR¶ \u0016\u009avÞÖ>6\u001f\u0096göHUÐµõ\u0015Åu Õ\u000e5_\u0094úô\u008bTï´1\u0014\u001fttÔX3³\u0093îóÜS ³\u0013\u0019Ä\u0019Ñ\u0086C&)Æ\u0003fµ\u0006²¦\u008dG|çC\u0087\u0000'ôÇÄg¢\u0007\u009e\u0019Ñ\u0086C&)Æ\u0003fµ\u0006°¦\u0087Grç]\u0087:'ðÇ\u0082g°\u0007\u009a¤SD,ä\f\u0084ö$ÒÄ\u0081eU\u0005T¥=Eïåß\u0085«\u0019Ñ\u0086C&)Æ\u0003fµ\u0006°¦\u0087Grç]\u0087:'ðÇ\u0082gµ\u0007\u009e¤ND0ä\n\u0019Ñ\u0086C&)Æ\u0003fµ\u0006°¦\u0087Grç]\u0087:'ðÇ\u0082g£\u0007\u009e¤MD<ä\n\u0019Ñ\u0086T&5Æ\u0006fµ\u0006²¦\u008dG|çC\u0087\u0000'ðÇßg³\u0007\u0098¤E³\u0089,\f\u008cml^Ì¶¬þ\fÝífM\u0002-n\u008d¾mÚÍæ\u00adÊ\u000e\u001aîrNi.¢\u008e\u0085nÑÏ>¯\u0004\u000fcï\u0086O\u009a/ò\u008fÎh0È}¨l\b¹è\u0084Hë)*\u0089Zi~ÉM\u0019Ñ\u0086C&)Æ\u0003fµ\u0006¡¦\u009bGeçi\u00878'ôÇÞ\u008cY\u0013Ë³¡S\u008bó=\u0093)3\u0013Òírá\u0012£²eRHò?ß\b@\u009aàð\u0000Ú lÀi`^\u0081«!\u0084Aãá)\u0001[¡iÁQb\u008d\u0082ö\"ØB\"â\u0001\u0002Y£¡Ã\u008e\u0019Ñ\u0086T&5Æ\u0006fî\u0006¦¦\u0085G>çZ\u00876'æÇ\u0082g¾\u0007\u0092¤BD+ä\u001d\u0084ã$ÚÄ\u008aef\u0005W¥=Eóåù\u0085¥%\u009aÂtbl\u0002\u0018¢ÿ\u0019Ñ\u0086C&)Æ\u0003fµ\u0006¡¦\u009bGeçW\u0087<'çÇÈ\u0019Ñ\u0086C&)Æ\u0003fµ\u0006¡¦\u009bGeçQ\u0087&'öÇÂ\u0099 \u0006²¦ØFòæD\u0086P&jÇ\u0094gª\u0007Ë§\u0012G2\u0019Ñ\u0086C&)Æ\u0003fµ\u0006¡¦\u009bGeçY\u0087-'íÇÈdµû'[M»g\u001bÑ{ÅÛÿ:\u0001\u009a$úVZ\u0093º®\u0019Ñ\u0086C&)Æ\u0003fµ\u0006¡¦\u009bGeçF\u00878'åÇÄg¢\u0007\u0098(ó·a\u0017\u000b÷!W\u00977\u0083\u0097¹vGÖK¶\u0014\u0016ËöêÊrUàõ\u008e\u0015¢µXÕOu/\u0094Ý4âT\u0092ôK\u0014a´\u0010Ô<wð\u0097Å7ãWL÷}\u0017i¶ËÖãv\u008f\u0096I²l-÷\u008d\u009fm¼Í\b\u00ad\t\r<ìÂLï,\u008d\u008cNlcÌ@¬\u0004\u000fîï\u0080O\u0080/B\u008f`o*ÎÒ®ê\u000e£îSNw.\u0016\u008e,iÒÖ£I%éL\th©\u008bÉ\u009eió\u0088\f(4HBè\u0084\b«¨ÓõdjëÊ\u0080*ÿ\u008a\n\u0019Ñ\u0086W&>Æ\u001afù\u0006ì¦\u009bGtçZ\u00879'«ÇÀg³\u0007\u008b¤S¡~>²\u009eÊ~þÞ\u0011¾K\u001elÿØ_¶?×\u009f\u000f\u007f.ßS¿u\u001c´üÆ\\§<\u0003\u009c4\u00860\u0019ì¹\u008cY\u0090ùt\u0099$9\u0019Øìxö\u0018\u008e¸RX!ø\u0003\u00986\u0081õ\u001ef¾\u001c^2þ\u0091\u009e\u008a>©ßQ\u007f{\u001f\u001a¿ÿ_êÿ\u0099\u009f»<aÜ\u000e|9\u001c\u009d¼à\\¬ýB\u0019\u009c\u0086K&9Æ\u0010fé\u0006·¦\u0089Grç]\u0087,H7×¤wÞ\u0097ð7SWH÷a\u0016\u0082¶¾ÖÍv\u0011\u0019Ñ\u0086C&-Æ\u0001fû\u0006ì¦\u008cG~çA\u00871'èÇÂg³\u0007\u009f¤SDfä@\u0084ó$ÌÄÊek\u0005C¥(Eòå\u0088\u0085·%\u0099Âq6´©2\t[é\u007fI\u009c)\u0089\u0089îh\u0004È&¨S\b\u008fè®HØ\u0019¹\u0086H& Æ\u0011fü\u0006ª¦\u009bGy\u0012M\u008dß-±Í\u009dmg\rp\u00ad\u0019LäìÙ\u008c ,7ÌAl<\f\b¯ÚO¼ï\u009e\u008fn/SÏVnõ\u000eÚ®¶N2î\n\u008e|.\u000bÉîi³\tÙ©aILé!\u0088é(ßÈ¿h\u008f\bM¨ HCëç\u008bÆ+\u0095ËdkG\u000b*ªù".getBytes(CharEncoding.ISO_8859_1)).asCharBuffer().get(cArr, 0, 1959);
        _CREATION = cArr;
        _BOUNDARY = -4593709437335271897L;
    }

    /* JADX WARN: Code duplicated, block: B:121:0x0fa4  */
    /* JADX WARN: Code duplicated, block: B:140:0x112c  */
    /* JADX WARN: Code duplicated, block: B:189:0x1641  */
    /* JADX WARN: Code duplicated, block: B:191:0x169f  */
    /* JADX WARN: Code duplicated, block: B:195:0x16f3 A[Catch: IOException -> 0x1717, TryCatch #0 {IOException -> 0x1717, blocks: (B:193:0x16af, B:195:0x16f3, B:197:0x16f9), top: B:381:0x16af }] */
    /* JADX WARN: Code duplicated, block: B:196:0x16f8  */
    /* JADX WARN: Code duplicated, block: B:201:0x1704  */
    /* JADX WARN: Code duplicated, block: B:202:0x1717  */
    /* JADX WARN: Code duplicated, block: B:242:0x1c78  */
    /* JADX WARN: Code duplicated, block: B:245:0x2737  */
    /* JADX WARN: Code duplicated, block: B:248:0x2749 A[Catch: all -> 0x0229, TryCatch #2 {all -> 0x0229, blocks: (B:6:0x0112, B:8:0x011f, B:9:0x0165, B:23:0x0311, B:25:0x031e, B:26:0x0363, B:35:0x0576, B:37:0x0583, B:38:0x05cb, B:69:0x0861, B:71:0x0867, B:72:0x08ab, B:80:0x0a35, B:82:0x0a42, B:84:0x0a9d, B:95:0x0cb3, B:97:0x0cc0, B:99:0x0d13, B:112:0x0f0b, B:114:0x0f18, B:116:0x0f64, B:144:0x11e0, B:146:0x11ed, B:147:0x123c, B:158:0x1453, B:160:0x1460, B:162:0x14b6, B:206:0x1795, B:208:0x179b, B:209:0x17dc, B:214:0x18e0, B:216:0x18f1, B:217:0x1934, B:229:0x1b0c, B:231:0x1b19, B:232:0x1b67, B:234:0x1b70, B:236:0x1b88, B:237:0x1bd5, B:278:0x29c5, B:280:0x29d2, B:282:0x2a1c, B:300:0x2f85, B:302:0x2f92, B:303:0x2fd9, B:309:0x30a8, B:311:0x30b5, B:312:0x30f2, B:330:0x3528, B:332:0x3535, B:334:0x3594, B:360:0x3872, B:362:0x387f, B:363:0x38c3, B:286:0x2a3c, B:288:0x2a53, B:289:0x2a9b, B:246:0x273c, B:248:0x2749, B:250:0x2798, B:47:0x06d9, B:49:0x06e6, B:50:0x0735, B:57:0x0770, B:59:0x077d, B:60:0x07c8), top: B:385:0x0112 }] */
    /* JADX WARN: Code duplicated, block: B:249:0x2794  */
    /* JADX WARN: Code duplicated, block: B:263:0x27cd  */
    /* JADX WARN: Code duplicated, block: B:266:0x27d7 A[LOOP:8: B:262:0x27cb->B:266:0x27d7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:271:0x282e  */
    /* JADX WARN: Code duplicated, block: B:272:0x2897  */
    /* JADX WARN: Code duplicated, block: B:275:0x28f4  */
    /* JADX WARN: Code duplicated, block: B:276:0x299b  */
    /* JADX WARN: Code duplicated, block: B:355:0x37eb  */
    /* JADX WARN: Code duplicated, block: B:381:0x16af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:415:0x27db A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x0751  */
    /* JADX WARN: Code duplicated, block: B:59:0x077d A[Catch: all -> 0x0229, TryCatch #2 {all -> 0x0229, blocks: (B:6:0x0112, B:8:0x011f, B:9:0x0165, B:23:0x0311, B:25:0x031e, B:26:0x0363, B:35:0x0576, B:37:0x0583, B:38:0x05cb, B:69:0x0861, B:71:0x0867, B:72:0x08ab, B:80:0x0a35, B:82:0x0a42, B:84:0x0a9d, B:95:0x0cb3, B:97:0x0cc0, B:99:0x0d13, B:112:0x0f0b, B:114:0x0f18, B:116:0x0f64, B:144:0x11e0, B:146:0x11ed, B:147:0x123c, B:158:0x1453, B:160:0x1460, B:162:0x14b6, B:206:0x1795, B:208:0x179b, B:209:0x17dc, B:214:0x18e0, B:216:0x18f1, B:217:0x1934, B:229:0x1b0c, B:231:0x1b19, B:232:0x1b67, B:234:0x1b70, B:236:0x1b88, B:237:0x1bd5, B:278:0x29c5, B:280:0x29d2, B:282:0x2a1c, B:300:0x2f85, B:302:0x2f92, B:303:0x2fd9, B:309:0x30a8, B:311:0x30b5, B:312:0x30f2, B:330:0x3528, B:332:0x3535, B:334:0x3594, B:360:0x3872, B:362:0x387f, B:363:0x38c3, B:286:0x2a3c, B:288:0x2a53, B:289:0x2a9b, B:246:0x273c, B:248:0x2749, B:250:0x2798, B:47:0x06d9, B:49:0x06e6, B:50:0x0735, B:57:0x0770, B:59:0x077d, B:60:0x07c8), top: B:385:0x0112 }] */
    public static Object[] CoroutineDebuggingKt(Context context, int i, int i2, int i3) throws Throwable {
        String str;
        int i4;
        int i5;
        int maximumDrawingCacheSize;
        int iIndexOf;
        int i6;
        Object objAccessartificialFrame;
        String str2;
        int i7;
        int i8;
        int i9;
        int i10;
        String str3;
        int i11;
        int i12;
        int i13;
        String str4;
        File file;
        int i14;
        Scanner scannerUseDelimiter;
        String next;
        long j;
        int i15;
        int i16;
        String[][] strArr;
        ArrayList arrayList;
        int i17;
        int i18;
        int i19;
        String str5;
        Object[] objArr;
        int i20;
        int i21;
        int i22;
        int i23;
        Object[] objArr2;
        Object objAccessartificialFrame2;
        String str6;
        boolean z;
        int length;
        int i24;
        int i25;
        String str7;
        int i26;
        int i27;
        int i28;
        Object obj;
        int i29;
        int i30 = 2 % 2;
        char packedPositionGroup = (char) ExpandableListView.getPackedPositionGroup(0L);
        float f = 0.0f;
        int i31 = 718 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
        int gidForName = Process.getGidForName("");
        int iITrustedWebActivityCallbackStub = JwtEcdsaAlgorithm.AnonymousClass1.ITrustedWebActivityCallbackStub();
        int i32 = getARTIFICIAL_FRAME_PACKAGE_NAME;
        int i33 = 1;
        int i34 = ((i32 | 29) << 1) - (i32 ^ 29);
        artificialFrame = i34 % 128;
        int i35 = i34 % 2;
        int i36 = ~iITrustedWebActivityCallbackStub;
        int i37 = (((gidForName * 980) - 8802) - (~(-(-((~((i36 & (-10)) | ((-10) ^ i36))) * 979))))) - 1;
        int i38 = ((gidForName ^ iITrustedWebActivityCallbackStub) | (gidForName & iITrustedWebActivityCallbackStub)) * (-979);
        int i39 = ((i37 | i38) << 1) - (i37 ^ i38);
        int i40 = ~(((-10) ^ iITrustedWebActivityCallbackStub) | ((-10) & iITrustedWebActivityCallbackStub));
        int i41 = ~iITrustedWebActivityCallbackStub;
        int i42 = i39 + (((~((gidForName & i41) | (i41 ^ gidForName))) | i40) * 979);
        Object[] objArr3 = new Object[1];
        b(packedPositionGroup, i31, i42, objArr3);
        int i43 = 0;
        String str8 = (String) objArr3[0];
        char maximumDrawingCacheSize2 = (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
        int packedPositionGroup2 = ExpandableListView.getPackedPositionGroup(0L);
        int i44 = -(-(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)));
        int i45 = (i44 ^ 27) + ((i44 & 27) << 1);
        Object[] objArr4 = new Object[1];
        b(maximumDrawingCacheSize2, packedPositionGroup2, i45, objArr4);
        String str9 = (String) objArr4[0];
        char jumpTapTimeout = (char) (ViewConfiguration.getJumpTapTimeout() >> 16);
        int i46 = 26 - (~KeyEvent.keyCodeFromString(""));
        int i47 = -View.resolveSizeAndState(0, 0, 0);
        Object[] objArr5 = new Object[1];
        b(jumpTapTimeout, i46, (i47 ^ 25) + ((i47 & 25) << 1), objArr5);
        String str10 = (String) objArr5[0];
        char packedPositionGroup3 = (char) ExpandableListView.getPackedPositionGroup(0L);
        int iGreen = Color.green(0);
        int i48 = ((iGreen | 52) << 1) - (iGreen ^ 52);
        int deadChar = KeyEvent.getDeadChar(0, 0);
        Object[] objArr6 = new Object[1];
        b(packedPositionGroup3, i48, ((deadChar | 18) << 1) - (deadChar ^ 18), objArr6);
        String str11 = (String) objArr6[0];
        int i49 = -(-(ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
        int i50 = -Gravity.getAbsoluteGravity(0, 0);
        int i51 = (i50 & 70) + (i50 | 70);
        int i52 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
        Object[] objArr7 = new Object[1];
        b((char) ((i49 ^ 51646) + ((i49 & 51646) << 1)), i51, (i52 & 29) + (i52 | 29), objArr7);
        String[] strArr2 = {str9, str10, str11, (String) objArr7[0]};
        int i53 = 0;
        while (true) {
            if (i53 >= 4) {
                str = str8;
                i4 = i;
                break;
            }
            try {
                Object[] objArr8 = {strArr2[i53]};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(479197382);
                if (objAccessartificialFrame3 == null) {
                    int doubleTapTimeout = 17 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                    char tapTimeout = (char) ((ViewConfiguration.getTapTimeout() >> 16) + 24343);
                    int i54 = 2014 - (TypedValue.complexToFloat(i43) > f ? 1 : (TypedValue.complexToFloat(i43) == f ? 0 : -1));
                    byte[] bArr = $$a;
                    byte b = bArr[7];
                    Object[] objArr9 = new Object[i33];
                    a(b, (byte) (b - 3), bArr[8], objArr9);
                    String str12 = (String) objArr9[i43];
                    Class[] clsArr = new Class[i33];
                    clsArr[i43] = String.class;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout, tapTimeout, i54, -2081767730, false, str12, clsArr);
                }
                long jLongValue = ((Long) ((Method) objAccessartificialFrame3).invoke(null, objArr8)).longValue();
                long j2 = -360666441;
                long j3 = 371;
                long j4 = (j3 * j2) + (j3 * jLongValue);
                long j5 = -370;
                str = str8;
                long j6 = -1;
                long j7 = jLongValue ^ j6;
                long startUptimeMillis = (int) Process.getStartUptimeMillis();
                long j8 = startUptimeMillis ^ j6;
                long j9 = j2 ^ j6;
                long j10 = (jLongValue | j2) ^ j6;
                long j11 = j4 + ((((j7 | j8) ^ j6) | ((j9 | startUptimeMillis) ^ j6)) * j5) + (j5 * (((j9 | j8) ^ j6) | ((j7 | startUptimeMillis) ^ j6) | j10)) + (((long) 370) * j10) + ((long) 857277832);
                int i55 = ~i;
                int i56 = ~((-1153315632) | i55);
                int i57 = ~((-283910780) | i);
                if (((((int) j11) & ((-780594041) + (((~(1159636612 | i)) | 276891937 | (~((-277589798) | i))) * (-754)) + (((~((-276891938) | i)) | (~((-697861) | i55))) * (-754)) + ((1159636612 | i55) * 754))) | (((int) (j11 >> 32)) & ((-334238508) + ((i56 | i57) * 1150) + (((~(283910779 | i55)) | i57) * (-575)) + (((~((-1153315632) | i)) | (~(1153315631 | i55))) * 575)))) != 0) {
                    i4 = i ^ (i53 + FacebookRequestErrorClassification.EC_INVALID_TOKEN);
                    break;
                }
                i53++;
                str8 = str;
                i43 = 0;
                f = 0.0f;
                i33 = 1;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
        int i58 = 3;
        if (i4 != i) {
            Object[] objArr10 = {null, new int[]{i ^ (i << 5)}, null, new int[]{i}, new int[]{i4}};
            int i59 = ~i;
            int i60 = -(-((((((~((-292610712) | i59)) | (~((-312837747) | i))) | (~(i59 | 312837746))) * 959) - 1169216678) + (((~(i | 312837746)) | (~(i59 | (-312837747))) | (~((-292610712) | i))) * 959) + 16));
            int i61 = ((i3 | i60) << 1) - (i60 ^ i3);
            int i62 = i61 << 13;
            int i63 = (i62 | i61) & (~(i61 & i62));
            int i64 = i63 ^ (i63 >>> 17);
            return objArr10;
        }
        Object[] objArr11 = new Object[1];
        b((char) View.resolveSize(0, 0), 97 - (~(-ExpandableListView.getPackedPositionGroup(0L))), (ViewConfiguration.getLongPressTimeout() >> 16) + 12, objArr11);
        String str13 = (String) objArr11[0];
        char absoluteGravity = (char) (Gravity.getAbsoluteGravity(0, 0) + 20263);
        char c = '0';
        int i65 = -(-TextUtils.lastIndexOf("", '0'));
        int i66 = (i65 & b.f40o) + (i65 | b.f40o);
        int i67 = -TextUtils.indexOf((CharSequence) "", '0', 0);
        Object[] objArr12 = new Object[1];
        b(absoluteGravity, i66, (i67 & 12) + (i67 | 12), objArr12);
        String str14 = (String) objArr12[0];
        char cIndexOf = (char) TextUtils.indexOf("", "");
        int i68 = -(-Process.getGidForName(""));
        Object[] objArr13 = new Object[1];
        b(cIndexOf, ((i68 | 124) << 1) - (i68 ^ 124), 17 - (~(-(ViewConfiguration.getPressedStateDuration() >> 16))), objArr13);
        String[] strArr3 = {str13, str14, (String) objArr13[0]};
        int i69 = 0;
        while (true) {
            if (i69 >= i58) {
                i5 = i;
                break;
            }
            Object[] objArr14 = {strArr3[i69]};
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-11453480);
            if (objAccessartificialFrame4 == null) {
                int scrollBarFadeDuration = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 17;
                char cLastIndexOf = (char) (TextUtils.lastIndexOf("", c, 0) + 24344);
                int iGreen2 = 2014 - Color.green(0);
                byte[] bArr2 = $$a;
                byte b2 = bArr2[18];
                Object[] objArr15 = new Object[1];
                a(b2, (byte) (b2 - 1), bArr2[8], objArr15);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration, cLastIndexOf, iGreen2, 1614052816, false, (String) objArr15[0], new Class[]{String.class});
            }
            long jLongValue2 = ((Long) ((Method) objAccessartificialFrame4).invoke(null, objArr14)).longValue();
            long j12 = 867115576;
            long jElapsedRealtime = (int) SystemClock.elapsedRealtime();
            long j13 = (((long) 51) * j12) + (((long) (-49)) * jLongValue2) + (((long) (-50)) * (j12 | jElapsedRealtime));
            long j14 = 50;
            String[] strArr4 = strArr3;
            long j15 = -1;
            long j16 = jLongValue2 ^ j15;
            long j17 = (((j12 ^ j15) | j16) | jElapsedRealtime) ^ j15;
            long j18 = jElapsedRealtime ^ j15;
            long j19 = j16 | j18;
            long j20 = j13 + ((j17 | ((j19 | j12) ^ j15)) * j14) + (j14 * ((j15 ^ (j18 | j12)) | (j19 ^ j15) | ((j16 | j12) ^ j15))) + ((long) 695015461);
            int iMyPid = Process.myPid();
            int i70 = ((int) (j20 >> 32)) & (((1848624322 + (((~((-1110723301) | iMyPid)) | (-326503111)) * (-948))) + ((~((~iMyPid) | (-36965061))) * (-948))) - 15563316);
            int i71 = ((int) j20) & (((1771465493 + (((~((-141492868) | i)) | 6685314) * 576)) + (((~((~i) | (-134807554))) | (-1585404592)) * 576)) - 444226432);
            if (((i70 & i71) | (i70 ^ i71)) != 0) {
                int iITrustedWebActivityCallbackStub2 = JwtEcdsaAlgorithm.AnonymousClass1.ITrustedWebActivityCallbackStub();
                int i72 = 177930 + (i69 * (-657));
                int i73 = ~((-271) | i69);
                int i74 = ~i69;
                int i75 = (i74 & RotationOptions.ROTATE_270) | (i74 ^ RotationOptions.ROTATE_270);
                int i76 = i73 | (~i75);
                int i77 = (iITrustedWebActivityCallbackStub2 & RotationOptions.ROTATE_270) | (iITrustedWebActivityCallbackStub2 ^ RotationOptions.ROTATE_270);
                int i78 = (i76 | (~i77)) * (-658);
                int i79 = (i72 ^ i78) + ((i78 & i72) << 1);
                int i80 = ~i69;
                int i81 = (~((i80 & RotationOptions.ROTATE_270) | (i80 ^ RotationOptions.ROTATE_270))) * 658;
                int i82 = (i79 ^ i81) + ((i81 & i79) << 1);
                int i83 = ~i75;
                int i84 = ~i77;
                int i85 = ((i84 & i83) | (i83 ^ i84)) * 658;
                int i86 = ((i82 | i85) << 1) - (i85 ^ i82);
                i5 = (~(i & i86)) & (i86 | i);
                break;
            }
            i69++;
            strArr3 = strArr4;
            i58 = 3;
            c = '0';
        }
        if (i5 != i) {
            Object[] objArr16 = {null, new int[1], null, new int[]{i}, new int[]{i5}};
            int iNextInt = new Random().nextInt();
            int i87 = ~((-268669313) | iNextInt);
            int i88 = (-339993571) + ((65536 | i87) * (-280)) + ((i87 | (~((-336779146) | iNextInt))) * 140);
            int i89 = ~((-268603777) | iNextInt);
            int i90 = ~iNextInt;
            int i91 = i88 + (((~(i90 | (-68175370))) | i89 | (~((-65537) | i90))) * 140);
            int i92 = -(-((i91 ^ 16) + ((i91 & 16) << 1)));
            int i93 = (i3 ^ i92) + ((i92 & i3) << 1);
            int i94 = i93 << 13;
            int i95 = (i94 & (~i93)) | ((~i94) & i93);
            int i96 = i95 >>> 17;
            int i97 = ((~i95) & i96) | ((~i96) & i95);
            int i98 = i97 << 5;
            ((int[]) objArr16[1])[0] = ((~i97) & i98) | ((~i98) & i97);
            return objArr16;
        }
        int threadPriority = Process.getThreadPriority(0);
        int iITrustedWebActivityCallbackStub3 = JwtEcdsaAlgorithm.AnonymousClass1.ITrustedWebActivityCallbackStub();
        int i99 = -(-(threadPriority * (-575)));
        int i100 = ((-11500) ^ i99) + ((i99 & (-11500)) << 1);
        int i101 = ~threadPriority;
        int i102 = ~(((-21) & i101) | ((-21) ^ i101));
        int i103 = ~threadPriority;
        int i104 = ~((i103 ^ iITrustedWebActivityCallbackStub3) | (i103 & iITrustedWebActivityCallbackStub3));
        int i105 = i100 + (((i102 & i104) | (i102 ^ i104)) * 576);
        int i106 = getARTIFICIAL_FRAME_PACKAGE_NAME;
        int i107 = ((i106 | 17) << 1) - (i106 ^ 17);
        int i108 = i107 % 128;
        artificialFrame = i108;
        int i109 = i107 % 2;
        int i110 = ~(threadPriority | (-21));
        int i111 = ~iITrustedWebActivityCallbackStub3;
        int i112 = (i111 & i103) | (i103 ^ i111);
        int i113 = (i105 - (~(-(-(576 * ((~((i112 & 20) | (i112 ^ 20))) | i110)))))) - 1;
        int i114 = ((i108 | 51) << 1) - (i108 ^ 51);
        getARTIFICIAL_FRAME_PACKAGE_NAME = i114 % 128;
        int i115 = i114 % 2;
        int i116 = -(-(576 * (~((-21) | i101))));
        char c2 = (char) (((i113 & i116) + (i116 | i113)) >> 6);
        int iAxisFromString = 140 - MotionEvent.axisFromString("");
        int i117 = -(-(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
        int i118 = (i117 ^ 13) + ((i117 & 13) << 1);
        Object[] objArr17 = new Object[1];
        b(c2, iAxisFromString, i118, objArr17);
        Object[] objArr18 = {(String) objArr17[0]};
        Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-11453480);
        if (objAccessartificialFrame5 == null) {
            int packedPositionGroup4 = ExpandableListView.getPackedPositionGroup(0L) + 17;
            char maximumFlingVelocity = (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 24343);
            int doubleTapTimeout2 = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 2014;
            byte[] bArr3 = $$a;
            byte b3 = bArr3[18];
            Object[] objArr19 = new Object[1];
            a(b3, (byte) (b3 - 1), bArr3[8], objArr19);
            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(packedPositionGroup4, maximumFlingVelocity, doubleTapTimeout2, 1614052816, false, (String) objArr19[0], new Class[]{String.class});
        }
        long jLongValue3 = ((Long) ((Method) objAccessartificialFrame5).invoke(null, objArr18)).longValue();
        long j21 = -543413509;
        long j22 = 46;
        long j23 = -1;
        long j24 = jLongValue3 ^ j23;
        long startUptimeMillis2 = (int) Process.getStartUptimeMillis();
        long j25 = startUptimeMillis2 ^ j23;
        long j26 = (j22 * j21) + (j22 * jLongValue3) + (((long) (-90)) * (j21 | ((j24 | j25) ^ j23))) + (((long) (-45)) * (((j24 | startUptimeMillis2) ^ j23) | ((j21 | jLongValue3) ^ j23))) + (((long) 45) * (j24 | (((j21 ^ j23) | startUptimeMillis2) ^ j23) | ((j25 | j21) ^ j23))) + ((long) 2105544546);
        int iMyTid = Process.myTid();
        int i119 = ~iMyTid;
        int i120 = ((int) (j26 >> 32)) & (669849210 + (((~((-578964912) | i119)) | 536871178) * SyslogConstants.LOG_LOCAL7) + ((iMyTid | (-2058285056)) * (-184)) + ((~((-2016191323) | i119)) * SyslogConstants.LOG_LOCAL7));
        int iNextInt2 = new Random().nextInt(1761590792);
        int i121 = ~iNextInt2;
        int i122 = ((int) j26) & (885718813 + (((~(407225424 | i121)) | 622858505) * 98) + (((~(i121 | 1030000985)) | 407225424 | (~((-1030000986) | iNextInt2))) * (-49)) + (((~(iNextInt2 | 407225424)) | 407142480) * 49));
        if (((i120 & i122) | (i120 ^ i122)) != 0) {
            i7 = i ^ 266;
        } else {
            int i123 = -(ViewConfiguration.getScrollBarSize() >> 8);
            char c3 = (char) ((i123 ^ 58430) + ((i123 & 58430) << 1));
            int i124 = artificialFrame + 101;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i124 % 128;
            if (i124 % 2 != 0) {
                maximumDrawingCacheSize = ViewConfiguration.getMaximumDrawingCacheSize() + 177;
                iIndexOf = TextUtils.indexOf("", "");
                i6 = 15;
            } else {
                int maximumDrawingCacheSize3 = ViewConfiguration.getMaximumDrawingCacheSize() >> 24;
                maximumDrawingCacheSize = (maximumDrawingCacheSize3 | 155) + (maximumDrawingCacheSize3 & 155);
                iIndexOf = TextUtils.indexOf("", "");
                i6 = 24;
            }
            Object[] objArr20 = new Object[1];
            b(c3, maximumDrawingCacheSize, (i6 - (~iIndexOf)) - 1, objArr20);
            Object[] objArr21 = {(String) objArr20[0]};
            Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1483923676);
            if (objAccessartificialFrame6 == null) {
                int scrollDefaultDelay = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 23;
                char c4 = (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                int i125 = 2442 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                byte[] bArr4 = $$a;
                Object[] objArr22 = new Object[1];
                a(bArr4[20], (byte) ($$b | 49), bArr4[13], objArr22);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(scrollDefaultDelay, c4, i125, 954751276, false, (String) objArr22[0], new Class[]{String.class});
            }
            String str15 = (String) ((Method) objAccessartificialFrame6).invoke(null, objArr21);
            if (str15 != null) {
                int i126 = ~i;
                JwtEcdsaAlgorithm.AnonymousClass1.ITrustedWebActivityCallbackStub();
                if (str15.length() != 0) {
                    i8 = i & (-268);
                } else {
                    Object[] objArr23 = new Object[1];
                    b((char) View.MeasureSpec.getMode(0), 178 - (~TextUtils.getCapsMode("", 0, 0)), 23 - TextUtils.lastIndexOf("", '0'), objArr23);
                    Object[] objArr24 = {(String) objArr23[0]};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1483923676);
                    if (objAccessartificialFrame == null) {
                        int i127 = 23 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                        char cLastIndexOf2 = (char) (TextUtils.lastIndexOf("", '0') + 1);
                        int iAxisFromString2 = MotionEvent.axisFromString("") + 2442;
                        byte[] bArr5 = $$a;
                        Object[] objArr25 = new Object[1];
                        a(bArr5[20], (byte) ($$b | 49), bArr5[13], objArr25);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i127, cLastIndexOf2, iAxisFromString2, 954751276, false, (String) objArr25[0], new Class[]{String.class});
                    }
                    str2 = (String) ((Method) objAccessartificialFrame).invoke(null, objArr24);
                    if (str2 != null || str2.length() == 0) {
                        i7 = i;
                    } else {
                        i8 = i & (-268);
                        i126 = ~i;
                    }
                }
                i7 = i8 | (i126 & 267);
            } else {
                Object[] objArr26 = new Object[1];
                b((char) View.MeasureSpec.getMode(0), 178 - (~TextUtils.getCapsMode("", 0, 0)), 23 - TextUtils.lastIndexOf("", '0'), objArr26);
                Object[] objArr27 = {(String) objArr26[0]};
                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1483923676);
                if (objAccessartificialFrame == null) {
                    int i128 = 23 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                    char cLastIndexOf3 = (char) (TextUtils.lastIndexOf("", '0') + 1);
                    int iAxisFromString3 = MotionEvent.axisFromString("") + 2442;
                    byte[] bArr6 = $$a;
                    Object[] objArr28 = new Object[1];
                    a(bArr6[20], (byte) ($$b | 49), bArr6[13], objArr28);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i128, cLastIndexOf3, iAxisFromString3, 954751276, false, (String) objArr28[0], new Class[]{String.class});
                }
                str2 = (String) ((Method) objAccessartificialFrame).invoke(null, objArr27);
                if (str2 != null) {
                }
                i7 = i;
            }
        }
        if (i7 != i) {
            int i129 = artificialFrame;
            int i130 = ((i129 | 37) << 1) - (i129 ^ 37);
            getARTIFICIAL_FRAME_PACKAGE_NAME = i130 % 128;
            int i131 = i130 % 2;
            Object[] objArr29 = {null, new int[1], null, new int[]{i}, new int[]{i7}};
            int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
            int i132 = -(-(1969322785 + (((~((-577484777) | startElapsedRealtime)) | 2797856) * 336) + (((~(startElapsedRealtime | 27963681)) | (-602650602)) * (-168)) + (((~((~startElapsedRealtime) | 27963681)) | (-577484777)) * 168) + 16));
            int i133 = ((i3 | i132) << 1) - (i132 ^ i3);
            int i134 = (i133 << 13) ^ i133;
            int i135 = i134 >>> 17;
            int i136 = ((~i134) & i135) | ((~i135) & i134);
            int i137 = i136 << 5;
            ((int[]) objArr29[1])[0] = ((~i136) & i137) | ((~i137) & i136);
            return objArr29;
        }
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(943212816);
        if (objAccessartificialFrame7 == null) {
            int bitsPerPixel = 6 - ImageFormat.getBitsPerPixel(0);
            char maxKeyCode = (char) ((KeyEvent.getMaxKeyCode() >> 16) + 49362);
            int iResolveSize = View.resolveSize(0, 0) + 1768;
            int i138 = $$b;
            Object[] objArr30 = new Object[1];
            a((byte) (i138 | 12), (byte) (-$$a[9]), (byte) i138, objArr30);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(bitsPerPixel, maxKeyCode, iResolveSize, -1487073512, false, (String) objArr30[0], new Class[0]);
        }
        long jLongValue4 = ((Long) ((Method) objAccessartificialFrame7).invoke(null, null)).longValue();
        long j27 = -272162044;
        long j28 = 375;
        long j29 = -747;
        long j30 = (j28 * j27) + (j29 * jLongValue4);
        long j31 = -374;
        long j32 = j27 ^ j23;
        long j33 = i;
        long j34 = j33 ^ j23;
        long j35 = (j34 | j27) ^ j23;
        long j36 = j30 + ((((j32 | jLongValue4) ^ j23) | j35) * j31);
        long j37 = 748;
        long j38 = jLongValue4 ^ j23;
        long j39 = j36 + (((j27 | j38) ^ j23) * j37);
        long j40 = 374;
        long j41 = j39 + ((((j32 | j38) ^ j23) | j35) * j40) + ((long) 1648053794);
        int i139 = ~((~((int) SystemClock.elapsedRealtime())) | 1219725831);
        int i140 = ((int) (j41 >> 32)) & (((1073807364 | i139) * (-374)) + 575322912 + ((i139 | 145918467) * 374));
        int i141 = (int) j41;
        int i142 = ~i;
        int i143 = 229225925 + (((~((-10022625) | i142)) | 8947744) * (-1188));
        int i144 = 8947744 | (~(10022624 | i));
        int i145 = ~((-1427203786) | i142);
        int i146 = i141 & (i143 + ((i144 | i145) * 594) + (((~(10022624 | i142)) | 1426128905 | i145) * 594));
        int i147 = (i140 & i146) | (i140 ^ i146);
        if (i147 != 0) {
            int i148 = -(-(i147 - 1));
            int i149 = (i148 ^ 200) + ((i148 & 200) << 1);
            i9 = (~(i & i149)) & (i149 | i);
        } else {
            i9 = i;
        }
        if (i9 != i) {
            Object[] objArr31 = {null, new int[]{(i | i) & (~(i & i))}, null, new int[]{i}, new int[]{i9}};
            int i150 = ((574742169 + (((~((-115129165) | i)) | 68725004) * 1504)) + ((~(i | (-46404161))) * (-1504))) - 252484624;
            int i151 = (i150 & 16) + (i150 | 16);
            int i152 = (i3 & i151) + (i151 | i3);
            int i153 = i152 << 13;
            int i154 = (i153 | i152) & (~(i152 & i153));
            int i155 = i154 >>> 17;
            int i156 = (i154 | i155) & (~(i154 & i155));
            int i157 = i156 << 5;
            return objArr31;
        }
        char c5 = (char) (17088 - (~(-(-Color.red(0)))));
        int i158 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
        int i159 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
        int i160 = (i159 ^ 20) + ((i159 & 20) << 1);
        Object[] objArr32 = new Object[1];
        b(c5, (i158 ^ 202) + ((i158 & 202) << 1), i160, objArr32);
        String str16 = (String) objArr32[0];
        char offsetBefore = (char) (31544 - TextUtils.getOffsetBefore("", 0));
        int maximumDrawingCacheSize4 = ViewConfiguration.getMaximumDrawingCacheSize();
        int i161 = getARTIFICIAL_FRAME_PACKAGE_NAME;
        int i162 = (i161 & 71) + (i161 | 71);
        artificialFrame = i162 % 128;
        int i163 = i162 % 2;
        int i164 = 222 - (~(-(maximumDrawingCacheSize4 >> 24)));
        int keyRepeatDelay = ViewConfiguration.getKeyRepeatDelay() >> 16;
        int i165 = ((keyRepeatDelay | 6) << 1) - (keyRepeatDelay ^ 6);
        Object[] objArr33 = new Object[1];
        b(offsetBefore, i164, i165, objArr33);
        Object[] objArr34 = {str16, (String) objArr33[0]};
        Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-883653127);
        if (objAccessartificialFrame8 == null) {
            int tapTimeout2 = (ViewConfiguration.getTapTimeout() >> 16) + 31;
            char threadPriority2 = (char) (((Process.getThreadPriority(0) + 20) >> 6) + 57022);
            int longPressTimeout = 2311 - (ViewConfiguration.getLongPressTimeout() >> 16);
            int i166 = $$b;
            Object[] objArr35 = new Object[1];
            a((byte) (i166 | 7), (byte) (i166 | 18), $$a[13], objArr35);
            objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(tapTimeout2, threadPriority2, longPressTimeout, 1412547569, false, (String) objArr35[0], new Class[]{String.class, String.class});
        }
        long jLongValue5 = ((Long) ((Method) objAccessartificialFrame8).invoke(null, objArr34)).longValue();
        long j42 = 510464214;
        long j43 = j42 ^ j23;
        long j44 = (((long) 302) * j42) + (((long) TypedValues.MotionType.TYPE_EASING) * jLongValue5) + (((long) (-602)) * (jLongValue5 | ((j43 | j34) ^ j23))) + (((long) (-301)) * (((j43 | (jLongValue5 ^ j23)) ^ j23) | ((j43 | j33) ^ j23) | (((j34 | j42) | jLongValue5) ^ j23))) + (((long) 301) * ((j34 | jLongValue5) ^ j23)) + ((long) (-665215843));
        int i167 = ~(771588878 | i142);
        int i168 = ((int) (j44 >> 32)) & (((139526402 | i167) * (-970)) + 418604486 + ((i167 | 632062476) * 970));
        int i169 = (int) j44;
        int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
        int i170 = ~iElapsedRealtime;
        int i171 = i169 & ((-1980715125) + (((~((-1244572772) | i170)) | 1074005025) * (-108)) + (((~(i170 | (-192653639))) | (~(192653638 | iElapsedRealtime)) | 22085892) * 54) + ((iElapsedRealtime | 22085892) * 54));
        int i172 = ((int) ((long) ((i168 & i171) | (i168 ^ i171)))) != 0 ? i ^ 262 : i;
        if (i172 != i) {
            Object[] objArr36 = {null, new int[]{(i | i) & (~(i & i))}, null, new int[]{i}, new int[]{i172}};
            int i173 = (-76488707) + (((~((-66623655) | i142)) | 1609762 | (~((-538824804) | i142)) | (~(603838695 | i))) * (-84));
            int i174 = (~(i | (-538824804))) | 66623654;
            int i175 = ~(538824803 | i142);
            int i176 = i173 + ((i174 | i175) * (-84)) + (((-603838696) | i175) * 84);
            int i177 = ((i176 | 16) << 1) - (i176 ^ 16);
            int i178 = (i3 & i177) + (i177 | i3);
            int i179 = i178 << 13;
            int i180 = (i179 | i178) & (~(i178 & i179));
            int i181 = i180 >>> 17;
            int i182 = ((~i180) & i181) | ((~i181) & i180);
            int i183 = i182 << 5;
            return objArr36;
        }
        int keyRepeatTimeout = ViewConfiguration.getKeyRepeatTimeout() >> 16;
        int i184 = 228 - (~TextUtils.getOffsetBefore("", 0));
        int i185 = -(ViewConfiguration.getPressedStateDuration() >> 16);
        int iITrustedWebActivityCallbackStub4 = JwtEcdsaAlgorithm.AnonymousClass1.ITrustedWebActivityCallbackStub();
        int i186 = (i185 * (-55)) - 1705;
        int i187 = ~((i185 ^ iITrustedWebActivityCallbackStub4) | (i185 & iITrustedWebActivityCallbackStub4));
        int i188 = ((i187 & 31) | (i187 ^ 31)) * 56;
        int i189 = (i186 & i188) + (i186 | i188);
        int i190 = -(-((~((i185 ^ 31) | (i185 & 31))) * (-56)));
        int i191 = ((i189 | i190) << 1) - (i190 ^ i189);
        int i192 = ~((~iITrustedWebActivityCallbackStub4) | 31);
        int i193 = -(-(((i185 & i192) | (i185 ^ i192)) * 56));
        Object[] objArr37 = new Object[1];
        b((char) ((keyRepeatTimeout & 81) + (keyRepeatTimeout | 81)), i184, (i191 & i193) + (i193 | i191), objArr37);
        String str17 = (String) objArr37[0];
        int iIndexOf2 = TextUtils.indexOf((CharSequence) "", '0');
        char c6 = (char) ((iIndexOf2 & 1) + (iIndexOf2 | 1));
        int i194 = -(Process.myPid() >> 22);
        Object[] objArr38 = new Object[1];
        b(c6, (i194 ^ 260) + ((i194 & 260) << 1), 22 - (~(-(-View.resolveSizeAndState(0, 0, 0)))), objArr38);
        String str18 = (String) objArr38[0];
        int i195 = -(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
        char c7 = (char) (((i195 | PointerIconCompat.TYPE_VERTICAL_TEXT) << 1) - (i195 ^ PointerIconCompat.TYPE_VERTICAL_TEXT));
        int i196 = -(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
        int iResolveOpacity = Drawable.resolveOpacity(0, 0);
        Object[] objArr39 = new Object[1];
        b(c7, ((i196 | 284) << 1) - (i196 ^ 284), ((iResolveOpacity | 28) << 1) - (iResolveOpacity ^ 28), objArr39);
        String str19 = (String) objArr39[0];
        int i197 = -(ViewConfiguration.getTapTimeout() >> 16);
        char c8 = (char) ((i197 ^ 55798) + ((i197 & 55798) << 1));
        int absoluteGravity2 = Gravity.getAbsoluteGravity(0, 0);
        Object[] objArr40 = new Object[1];
        b(c8, (absoluteGravity2 & 311) + (absoluteGravity2 | 311), 14 - View.MeasureSpec.makeMeasureSpec(0, 0), objArr40);
        String[] strArr5 = {str17, str18, str19, (String) objArr40[0]};
        int i198 = 0;
        while (true) {
            if (i198 >= 4) {
                i10 = i;
                break;
            }
            Object[] objArr41 = {strArr5[i198]};
            Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(479197382);
            if (objAccessartificialFrame9 == null) {
                int i199 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 17;
                char windowTouchSlop = (char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 24343);
                int i200 = 2014 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                byte[] bArr7 = $$a;
                byte b4 = bArr7[7];
                Object[] objArr42 = new Object[1];
                a(b4, (byte) (b4 - 3), bArr7[8], objArr42);
                objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(i199, windowTouchSlop, i200, -2081767730, false, (String) objArr42[0], new Class[]{String.class});
            }
            long jLongValue6 = ((Long) ((Method) objAccessartificialFrame9).invoke(null, objArr41)).longValue();
            long j45 = -864362969;
            int i201 = i198;
            long j46 = -112;
            long j47 = jLongValue6 ^ j23;
            long j48 = j47 | j34;
            long j49 = j45 ^ j23;
            long j50 = (j46 * j45) + (j46 * jLongValue6) + (((long) 226) * (j45 | (j48 ^ j23))) + (((long) (-113)) * (((j49 | jLongValue6) ^ j23) | ((j49 | j33) ^ j23) | ((j48 | j45) ^ j23))) + (((long) 113) * ((j47 | j33) ^ j23)) + ((long) 1360974360);
            if (((((int) j50) & ((-1704616964) + (((~(577841839 | i)) | 1477083216) * 305) + (((~(577841839 | i142)) | 2015068249) * 305))) | (((int) (j50 >> 32)) & (40574898 + (((~((-2093817793) | i)) | 1346704704) * (-140)) + ((~((-747113089) | i)) * 70) + (((~((-763923093) | i)) | 1363514708) * 70)))) != 0) {
                int i202 = (i201 ^ 252) + ((i201 & 252) << 1);
                i10 = (i202 | i) & (~(i & i202));
                break;
            }
            i198 = i201 + 1;
            strArr5 = strArr5;
        }
        if (i10 != i) {
            int[] iArr = new int[1];
            Object[] objArr43 = {null, iArr, null, new int[]{i}, new int[]{i10}};
            int i203 = ~(862920113 | i);
            int i204 = 851364131 + (((-1065336248) | i203) * (-814)) + ((i203 | (~(257471655 | i142)) | 55055521) * 407) + (((~(i | (-257471656))) | (~((-862920114) | i)) | 55055521) * 407);
            int i205 = artificialFrame;
            int i206 = ((i205 | 5) << 1) - (i205 ^ 5);
            getARTIFICIAL_FRAME_PACKAGE_NAME = i206 % 128;
            if (i206 % 2 != 0) {
                int i207 = i3 + (i204 * 16);
                int i208 = i207 ^ (i207 >>> 81);
                i29 = i208 ^ (i208 >>> WebSocketProtocol.PAYLOAD_SHORT);
            } else {
                int i209 = -(-(i204 + 16));
                int i210 = ((i3 | i209) << 1) - (i209 ^ i3);
                int i211 = i210 << 13;
                int i212 = (i211 | i210) & (~(i210 & i211));
                int i213 = i212 >>> 17;
                i29 = ((~i212) & i213) | ((~i213) & i212);
            }
            int i214 = i29 << 5;
            iArr[0] = (i29 | i214) & (~(i29 & i214));
            return objArr43;
        }
        int i215 = -(-(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)));
        int packedPositionGroup5 = ExpandableListView.getPackedPositionGroup(0L);
        int iITrustedWebActivityCallbackStub5 = JwtEcdsaAlgorithm.AnonymousClass1.ITrustedWebActivityCallbackStub();
        int i216 = packedPositionGroup5 * (-494);
        int i217 = ((i216 | (-160550)) << 1) - (i216 ^ (-160550));
        int i218 = (~(packedPositionGroup5 | 325)) * (-495);
        int i219 = (i217 & i218) + (i218 | i217);
        int i220 = ~iITrustedWebActivityCallbackStub5;
        int i221 = -(-(((i220 & packedPositionGroup5) | (packedPositionGroup5 ^ i220)) * 495));
        int i222 = ((i219 | i221) << 1) - (i221 ^ i219);
        int i223 = ~packedPositionGroup5;
        int i224 = ~((i223 & (-326)) | (i223 ^ (-326)));
        int i225 = ~iITrustedWebActivityCallbackStub5;
        int i226 = -(-(((~((packedPositionGroup5 & i225) | (i225 ^ packedPositionGroup5))) | i224) * 495));
        int i227 = (i222 ^ i226) + ((i226 & i222) << 1);
        int iBlue = Color.blue(0);
        int iITrustedWebActivityCallbackStub6 = JwtEcdsaAlgorithm.AnonymousClass1.ITrustedWebActivityCallbackStub();
        int i228 = iBlue * 70;
        int i229 = ((i228 | (-884)) << 1) - (i228 ^ (-884));
        int i230 = ~iBlue;
        int i231 = i230 | (-14);
        int i232 = ~((i231 & iITrustedWebActivityCallbackStub6) | (i231 ^ iITrustedWebActivityCallbackStub6));
        int i233 = (iBlue ^ 13) | (iBlue & 13);
        int i234 = ~((i233 ^ iITrustedWebActivityCallbackStub6) | (i233 & iITrustedWebActivityCallbackStub6));
        int i235 = i229 + (((i232 ^ i234) | (i232 & i234)) * 69);
        int i236 = ~((i230 & 13) | (i230 ^ 13));
        int i237 = ~((~iBlue) | iITrustedWebActivityCallbackStub6);
        int i238 = (i236 ^ i237) | (i236 & i237);
        int i239 = ~((iITrustedWebActivityCallbackStub6 & 13) | (iITrustedWebActivityCallbackStub6 ^ 13));
        int i240 = -(-(((i239 & i238) | (i238 ^ i239)) * (-69)));
        int i241 = ((((i235 | i240) << 1) - (i240 ^ i235)) - (~(-(-((~(((-14) & iBlue) | ((-14) ^ iBlue))) * 69))))) - 1;
        Object[] objArr44 = new Object[1];
        b((char) (((i215 | 44406) << 1) - (i215 ^ 44406)), i227, i241, objArr44);
        Object[] objArr45 = {(String) objArr44[0]};
        Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1483923676);
        if (objAccessartificialFrame10 == null) {
            str3 = "";
            int iIndexOf3 = TextUtils.indexOf(str3, str3, 0) + 23;
            char cRed = (char) Color.red(0);
            int touchSlop = 2441 - (ViewConfiguration.getTouchSlop() >> 8);
            byte[] bArr8 = $$a;
            Object[] objArr46 = new Object[1];
            a(bArr8[20], (byte) ($$b | 49), bArr8[13], objArr46);
            objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iIndexOf3, cRed, touchSlop, 954751276, false, (String) objArr46[0], new Class[]{String.class});
        } else {
            str3 = "";
        }
        String str20 = (String) ((Method) objAccessartificialFrame10).invoke(null, objArr45);
        if (str20 != null) {
            char cAlpha = (char) Color.alpha(0);
            char mirror = AndroidCharacter.getMirror('0');
            int i242 = (mirror ^ 290) + ((mirror & 290) << 1);
            int i243 = -KeyEvent.keyCodeFromString(str3);
            int i244 = ((i243 | 9) << 1) - (i243 ^ 9);
            Object[] objArr47 = new Object[1];
            b(cAlpha, i242, i244, objArr47);
            if (str20.contains((String) objArr47[0])) {
                i11 = (~(i & ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION)) & (i | ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
            } else {
                i11 = i;
            }
        } else {
            i11 = i;
        }
        if (i11 == i) {
            Object[] objArr48 = new Object[1];
            b((char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), 345 - (~(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), 16 - (~(-(-Color.red(0)))), objArr48);
            String str21 = (String) objArr48[0];
            char c9 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
            int packedPositionType = ExpandableListView.getPackedPositionType(0L);
            int i245 = (packedPositionType & 364) + (packedPositionType | 364);
            int i246 = -(-Color.green(0));
            Object[] objArr49 = new Object[1];
            b(c9, i245, (i246 & 6) + (i246 | 6), objArr49);
            String str22 = (String) objArr49[0];
            File file2 = new File(str21);
            if (file2.exists() && file2.isFile()) {
                try {
                    Scanner scanner = new Scanner(new FileInputStream(file2));
                    char c10 = (char) (1431 - (~(-TextUtils.lastIndexOf(str3, '0', 0, 0))));
                    int i247 = 369 - (~(-View.MeasureSpec.makeMeasureSpec(0, 0)));
                    int i248 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                    int i249 = (i248 & 1) + (i248 | 1);
                    Object[] objArr50 = new Object[1];
                    b(c10, i247, i249, objArr50);
                    Scanner scannerUseDelimiter2 = scanner.useDelimiter((String) objArr50[0]);
                    String next2 = scannerUseDelimiter2.hasNext() ? scannerUseDelimiter2.next() : str3;
                    scannerUseDelimiter2.close();
                    if (next2.contains(str22)) {
                        i12 = i ^ 251;
                    } else {
                        i12 = i;
                    }
                } catch (IOException unused) {
                }
            } else {
                i12 = i;
            }
            if (i12 != i) {
                Object[] objArr51 = {null, new int[1], null, new int[]{i}, new int[]{i12}};
                int iElapsedRealtime2 = (int) SystemClock.elapsedRealtime();
                int i250 = ~iElapsedRealtime2;
                int i251 = (-76488707) + (((~((-645752326) | i250)) | 605618692 | (~(40303867 | i250)) | (~((-170235) | iElapsedRealtime2))) * (-84));
                int i252 = (~(iElapsedRealtime2 | 40303867)) | 645752325;
                int i253 = ~(i250 | (-40303868));
                int i254 = i251 + ((i252 | i253) * (-84)) + ((170234 | i253) * 84);
                int i255 = ((i254 | 16) << 1) - (i254 ^ 16);
                int i256 = (i3 & i255) + (i255 | i3);
                int i257 = i256 << 13;
                int i258 = (i257 & (~i256)) | ((~i257) & i256);
                int i259 = i258 ^ (i258 >>> 17);
                int i260 = i259 << 5;
                ((int[]) objArr51[1])[0] = ((~i259) & i260) | ((~i260) & i259);
                return objArr51;
            }
            int trimmedLength = TextUtils.getTrimmedLength(str3);
            char c11 = (char) ((trimmedLength ^ 41008) + ((trimmedLength & 41008) << 1));
            int i261 = 371 - (~(-(PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))));
            int i262 = -(-(Process.myPid() >> 22));
            int i263 = ((i262 | 23) << 1) - (i262 ^ 23);
            Object[] objArr52 = new Object[1];
            b(c11, i261, i263, objArr52);
            Object[] objArr53 = {(String) objArr52[0]};
            Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-1483923676);
            if (objAccessartificialFrame11 == null) {
                int iRgb = Color.rgb(0, 0, 0) + 16777239;
                char cIndexOf2 = (char) ((-1) - TextUtils.indexOf((CharSequence) str3, '0', 0));
                int windowTouchSlop2 = 2441 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                byte[] bArr9 = $$a;
                Object[] objArr54 = new Object[1];
                a(bArr9[20], (byte) ($$b | 49), bArr9[13], objArr54);
                objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(iRgb, cIndexOf2, windowTouchSlop2, 954751276, false, (String) objArr54[0], new Class[]{String.class});
            }
            String lowerCase = ((String) ((Method) objAccessartificialFrame11).invoke(null, objArr53)).toLowerCase();
            char c12 = (char) (21322 - (~Color.red(0)));
            int pressedStateDuration = ViewConfiguration.getPressedStateDuration() >> 16;
            int i264 = (pressedStateDuration * (-112)) - 44240;
            int i265 = ~i;
            int i266 = ~(((-396) & i265) | ((-396) ^ i265));
            int i267 = ((i266 & pressedStateDuration) | (pressedStateDuration ^ i266)) * 226;
            int i268 = ((i264 | i267) << 1) - (i264 ^ i267);
            int i269 = ~pressedStateDuration;
            int i270 = ~((i269 & 395) | (i269 ^ 395));
            int i271 = ~((~pressedStateDuration) | i);
            int i272 = (i270 ^ i271) | (i270 & i271);
            int i273 = ((-396) ^ i142) | ((-396) & i142);
            int i274 = ~((i273 ^ pressedStateDuration) | (i273 & pressedStateDuration));
            int i275 = i268 + (((i272 ^ i274) | (i274 & i272)) * (-113));
            int i276 = (~((-396) | i)) * 113;
            Object[] objArr55 = new Object[1];
            b(c12, ((i275 | i276) << 1) - (i276 ^ i275), 4 - (ViewConfiguration.getEdgeSlop() >> 16), objArr55);
            int i277 = !lowerCase.contains((String) objArr55[0]) ? i : (i & (-265)) | (i142 & 264);
            if (i277 != i) {
                Object[] objArr56 = {null, new int[1], null, new int[]{i}, new int[]{i277}};
                int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
                int i278 = ~iFreeMemory;
                int i279 = (-828405642) + (((~((-136347971) | i278)) | (~((-332416133) | iFreeMemory)) | (~((-336386) | iFreeMemory))) * 765) + (((~((-468764103) | i278)) | 136347970) * 1530) + (((~(iFreeMemory | (-468764103))) | (~(i278 | (-336386)))) * 765);
                int i280 = (i3 - (~((i279 ^ 16) + ((i279 & 16) << 1)))) - 1;
                int i281 = i280 << 13;
                int i282 = ((~i280) & i281) | ((~i281) & i280);
                int i283 = i282 ^ (i282 >>> 17);
                int i284 = i283 << 5;
                ((int[]) objArr56[1])[0] = ((~i283) & i284) | ((~i284) & i283);
                return objArr56;
            }
            int i285 = -(-((Process.getThreadPriority(0) + 20) >> 6));
            int i286 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 399;
            int i287 = -ExpandableListView.getPackedPositionType(0L);
            int i288 = (i287 ^ 42) + ((i287 & 42) << 1);
            Object[] objArr57 = new Object[1];
            b((char) (((i285 | 19965) << 1) - (i285 ^ 19965)), i286, i288, objArr57);
            String str23 = (String) objArr57[0];
            char modifierMetaStateMask = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 18610);
            int i289 = -Drawable.resolveOpacity(0, 0);
            int i290 = (i289 ^ 441) + ((i289 & 441) << 1);
            int offsetAfter = TextUtils.getOffsetAfter(str3, 0);
            int i291 = (offsetAfter ^ 40) + ((offsetAfter & 40) << 1);
            Object[] objArr58 = new Object[1];
            b(modifierMetaStateMask, i290, i291, objArr58);
            String str24 = (String) objArr58[0];
            int i292 = -(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
            int iResolveSize2 = View.resolveSize(0, 0);
            int i293 = ((iResolveSize2 | 481) << 1) - (iResolveSize2 ^ 481);
            int scrollDefaultDelay2 = ViewConfiguration.getScrollDefaultDelay() >> 16;
            int i294 = ((scrollDefaultDelay2 | 27) << 1) - (scrollDefaultDelay2 ^ 27);
            Object[] objArr59 = new Object[1];
            b((char) ((i292 ^ 20161) + ((i292 & 20161) << 1)), i293, i294, objArr59);
            String str25 = (String) objArr59[0];
            char c13 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
            int iIndexOf4 = TextUtils.indexOf(str3, str3, 0, 0);
            Object[] objArr60 = new Object[1];
            b(c13, (iIndexOf4 & TypedValues.PositionType.TYPE_CURVE_FIT) + (iIndexOf4 | TypedValues.PositionType.TYPE_CURVE_FIT), 27 - (ViewConfiguration.getScrollBarSize() >> 8), objArr60);
            String str26 = (String) objArr60[0];
            Object[] objArr61 = new Object[1];
            b((char) (10494 - Color.red(0)), (ViewConfiguration.getScrollBarSize() >> 8) + 535, 26 - (~(-Color.blue(0))), objArr61);
            String str27 = (String) objArr61[0];
            char absoluteGravity3 = (char) Gravity.getAbsoluteGravity(0, 0);
            int i295 = -((byte) KeyEvent.getModifierMetaStateMask());
            Object[] objArr62 = new Object[1];
            b(absoluteGravity3, (i295 ^ 561) + ((i295 & 561) << 1), TextUtils.lastIndexOf(str3, '0', 0) + 28, objArr62);
            String[] strArr6 = {str23, str24, str25, str26, str27, (String) objArr62[0]};
            int i296 = 0;
            while (true) {
                if (i296 >= 6) {
                    j33 = j33;
                    i265 = i265;
                    i13 = i;
                    break;
                }
                Object[] objArr63 = {strArr6[i296]};
                Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                if (objAccessartificialFrame12 == null) {
                    int iIndexOf5 = 22 - TextUtils.indexOf((CharSequence) str3, '0', 0, 0);
                    char deadChar2 = (char) KeyEvent.getDeadChar(0, 0);
                    int packedPositionType2 = ExpandableListView.getPackedPositionType(0L) + 2441;
                    byte[] bArr10 = $$a;
                    Object[] objArr64 = new Object[1];
                    a(bArr10[20], (byte) ($$b | 49), bArr10[13], objArr64);
                    objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iIndexOf5, deadChar2, packedPositionType2, 954751276, false, (String) objArr64[0], new Class[]{String.class});
                }
                String str28 = (String) ((Method) objAccessartificialFrame12).invoke(null, objArr63);
                if (str28 != null && str28.length() != 0) {
                    i13 = (i & (-266)) | (i142 & 265);
                    break;
                }
                int i297 = (i296 & 61) + (i296 | 61);
                i296 = ((i297 | (-60)) << 1) - (i297 ^ (-60));
                strArr6 = strArr6;
                i265 = i265;
                j33 = j33;
            }
            if (i13 != i) {
                Object[] objArr65 = {null, new int[1], null, new int[]{i}, new int[]{i13}};
                int i298 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i299 = (i298 & 105) + (i298 | 105);
                artificialFrame = i299 % 128;
                if (i299 % 2 == 0) {
                    Process.getElapsedCpuTime();
                    throw null;
                }
                int iMyPid2 = Process.myPid();
                int i300 = (((~((-50075651) | iMyPid2)) | 602294533) * 398) + 1587706465 + (((~((~iMyPid2) | (-50075651))) | 602294533) * 398);
                int i301 = -(-((i300 & 16) + (i300 | 16)));
                int i302 = (i3 ^ i301) + ((i301 & i3) << 1);
                int i303 = i302 << 13;
                int i304 = (i303 | i302) & (~(i302 & i303));
                int i305 = i304 >>> 17;
                int i306 = ((~i304) & i305) | ((~i305) & i304);
                int i307 = artificialFrame + 99;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i307 % 128;
                if (i307 % 2 != 0) {
                    ((int[]) objArr65[0])[1] = i306 ^ (i306 >>> 3);
                    return objArr65;
                }
                int i308 = i306 << 5;
                ((int[]) objArr65[1])[0] = ((~i306) & i308) | ((~i308) & i306);
                return objArr65;
            }
            char keyRepeatDelay2 = (char) (ViewConfiguration.getKeyRepeatDelay() >> 16);
            int i309 = -(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
            int i310 = (i309 ^ 347) + ((i309 & 347) << 1);
            int i311 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
            int i312 = ((i311 | 18) << 1) - (i311 ^ 18);
            Object[] objArr66 = new Object[1];
            b(keyRepeatDelay2, i310, i312, objArr66);
            String str29 = (String) objArr66[0];
            int i313 = -(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
            int keyRepeatTimeout2 = ViewConfiguration.getKeyRepeatTimeout() >> 16;
            int i314 = ((keyRepeatTimeout2 | 589) << 1) - (keyRepeatTimeout2 ^ 589);
            int i315 = -ExpandableListView.getPackedPositionChild(0L);
            int i316 = (i315 ^ 5) + ((i315 & 5) << 1);
            Object[] objArr67 = new Object[1];
            b((char) (((i313 | 50153) << 1) - (i313 ^ 50153)), i314, i316, objArr67);
            String str30 = (String) objArr67[0];
            File file3 = new File(str29);
            if (file3.exists() && file3.isFile()) {
                try {
                    Scanner scanner2 = new Scanner(new FileInputStream(file3));
                    char cKeyCodeFromString = (char) (KeyEvent.keyCodeFromString(str3) + 1433);
                    int iLastIndexOf = TextUtils.lastIndexOf(str3, '0', 0, 0) + 371;
                    int windowTouchSlop3 = ViewConfiguration.getWindowTouchSlop() >> 8;
                    int i317 = (windowTouchSlop3 ^ 2) + ((windowTouchSlop3 & 2) << 1);
                    Object[] objArr68 = new Object[1];
                    b(cKeyCodeFromString, iLastIndexOf, i317, objArr68);
                    Scanner scannerUseDelimiter3 = scanner2.useDelimiter((String) objArr68[0]);
                    String next3 = scannerUseDelimiter3.hasNext() ? scannerUseDelimiter3.next() : str3;
                    scannerUseDelimiter3.close();
                    if (next3.contains(str30)) {
                        i14 = i ^ 260;
                    } else {
                        int i318 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                        int i319 = 594 - (~(-Drawable.resolveOpacity(0, 0)));
                        int jumpTapTimeout2 = ViewConfiguration.getJumpTapTimeout() >> 16;
                        int i320 = (jumpTapTimeout2 ^ 13) + ((jumpTapTimeout2 & 13) << 1);
                        Object[] objArr69 = new Object[1];
                        b((char) ((i318 & 4704) + (i318 | 4704)), i319, i320, objArr69);
                        String str31 = (String) objArr69[0];
                        char maximumDrawingCacheSize5 = (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                        int iIndexOf6 = TextUtils.indexOf((CharSequence) str3, '0', 0, 0);
                        Object[] objArr70 = new Object[1];
                        b(maximumDrawingCacheSize5, (iIndexOf6 ^ TypedValues.MotionType.TYPE_POLAR_RELATIVETO) + ((iIndexOf6 & TypedValues.MotionType.TYPE_POLAR_RELATIVETO) << 1), Color.red(0) + 9, objArr70);
                        str4 = (String) objArr70[0];
                        file = new File(str31);
                        if (file.exists()) {
                            int i321 = getARTIFICIAL_FRAME_PACKAGE_NAME + 107;
                            artificialFrame = i321 % 128;
                            int i322 = i321 % 2;
                            if (file.isFile()) {
                                Scanner scanner3 = new Scanner(new FileInputStream(file));
                                char c14 = (char) (1432 - (~(-(-TextUtils.getOffsetBefore(str3, 0)))));
                                int i323 = -(ViewConfiguration.getJumpTapTimeout() >> 16);
                                Object[] objArr71 = new Object[1];
                                b(c14, ((i323 | 370) << 1) - (i323 ^ 370), 0 - (~(-(-(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))))), objArr71);
                                scannerUseDelimiter = scanner3.useDelimiter((String) objArr71[0]);
                                if (scannerUseDelimiter.hasNext()) {
                                    next = scannerUseDelimiter.next();
                                } else {
                                    next = str3;
                                }
                                scannerUseDelimiter.close();
                                if (!next.contains(str4)) {
                                    i14 = i;
                                } else {
                                    int i324 = artificialFrame;
                                    int i325 = (i324 & 61) + (i324 | 61);
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i325 % 128;
                                    int i326 = i325 % 2;
                                    i14 = (i & (-262)) | (i142 & 261);
                                }
                            } else {
                                i14 = i;
                            }
                        } else {
                            i14 = i;
                        }
                    }
                } catch (IOException unused2) {
                }
            } else {
                int i3110 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                int i3111 = 594 - (~(-Drawable.resolveOpacity(0, 0)));
                int jumpTapTimeout3 = ViewConfiguration.getJumpTapTimeout() >> 16;
                int i327 = (jumpTapTimeout3 ^ 13) + ((jumpTapTimeout3 & 13) << 1);
                Object[] objArr610 = new Object[1];
                b((char) ((i3110 & 4704) + (i3110 | 4704)), i3111, i327, objArr610);
                String str32 = (String) objArr610[0];
                char maximumDrawingCacheSize6 = (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                int iIndexOf7 = TextUtils.indexOf((CharSequence) str3, '0', 0, 0);
                Object[] objArr72 = new Object[1];
                b(maximumDrawingCacheSize6, (iIndexOf7 ^ TypedValues.MotionType.TYPE_POLAR_RELATIVETO) + ((iIndexOf7 & TypedValues.MotionType.TYPE_POLAR_RELATIVETO) << 1), Color.red(0) + 9, objArr72);
                str4 = (String) objArr72[0];
                file = new File(str32);
                if (file.exists()) {
                    int i328 = getARTIFICIAL_FRAME_PACKAGE_NAME + 107;
                    artificialFrame = i328 % 128;
                    int i329 = i328 % 2;
                    if (file.isFile()) {
                        try {
                            Scanner scanner4 = new Scanner(new FileInputStream(file));
                            char c15 = (char) (1432 - (~(-(-TextUtils.getOffsetBefore(str3, 0)))));
                            int i3210 = -(ViewConfiguration.getJumpTapTimeout() >> 16);
                            Object[] objArr73 = new Object[1];
                            b(c15, ((i3210 | 370) << 1) - (i3210 ^ 370), 0 - (~(-(-(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))))), objArr73);
                            scannerUseDelimiter = scanner4.useDelimiter((String) objArr73[0]);
                            if (scannerUseDelimiter.hasNext()) {
                                next = scannerUseDelimiter.next();
                            } else {
                                next = str3;
                            }
                            scannerUseDelimiter.close();
                            if (!next.contains(str4)) {
                                i14 = i;
                            } else {
                                int i3211 = artificialFrame;
                                int i3212 = (i3211 & 61) + (i3211 | 61);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i3212 % 128;
                                int i3213 = i3212 % 2;
                                i14 = (i & (-262)) | (i142 & 261);
                            }
                        } catch (IOException unused3) {
                        }
                    } else {
                        i14 = i;
                    }
                } else {
                    i14 = i;
                }
            }
            if (i14 != i) {
                int i330 = artificialFrame;
                int i331 = (i330 ^ 49) + ((i330 & 49) << 1);
                getARTIFICIAL_FRAME_PACKAGE_NAME = i331 % 128;
                int i332 = i331 % 2;
                Object[] objArr74 = {null, new int[1], null, new int[]{i}, new int[]{i14}};
                int i333 = ~((int) Process.getStartElapsedRealtime());
                int i334 = ((1975987798 + (((~((-821340618) | i333)) | 215892159) * (-933))) + (((~(i333 | 215892159)) | (-1023339008)) * 933)) - 514063154;
                int i335 = (((i334 | 16) << 1) - (i334 ^ 16)) + i3;
                int i336 = i335 << 13;
                int i337 = ((~i335) & i336) | ((~i336) & i335);
                int i338 = i337 >>> 17;
                int i339 = ((~i337) & i338) | ((~i338) & i337);
                int i340 = i339 << 5;
                ((int[]) objArr74[1])[0] = (i339 | i340) & (~(i339 & i340));
                return objArr74;
            }
            Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-913150042);
            if (objAccessartificialFrame13 == null) {
                int i341 = 28 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                char gidForName2 = (char) ((-1) - Process.getGidForName(str3));
                int iAxisFromString4 = MotionEvent.axisFromString(str3) + 765;
                byte b5 = $$a[5];
                int i342 = $$b;
                Object[] objArr75 = new Object[1];
                a(b5, (byte) (i342 | 18), (byte) i342, objArr75);
                objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(i341, gidForName2, iAxisFromString4, 1459038638, false, (String) objArr75[0], new Class[0]);
            }
            long jLongValue7 = ((Long) ((Method) objAccessartificialFrame13).invoke(null, null)).longValue();
            long j51 = 939379953;
            long j52 = -167;
            long j53 = jLongValue7 ^ j23;
            long j54 = ((long) 999221699) + (j52 * j51) + (j52 * jLongValue7) + (((long) 336) * ((((j51 ^ j23) | j53) ^ j23) | ((j53 | j33) ^ j23))) + (((long) (-168)) * (((jLongValue7 | j51) ^ j23) | ((j51 | j33) ^ j23))) + (((long) 168) * (j53 | ((j34 | j51) ^ j23)));
            int i343 = ~Process.myTid();
            int i344 = ((int) (j54 >> 32)) & (49522195 + (((~(204921421 | i343)) | (-1642147833)) * (-983)) + (((~(i343 | (-1642147833))) | 2099784) * 983));
            int iMyTid2 = Process.myTid();
            int i345 = ((int) j54) & ((-393930413) + (((~((~iMyTid2) | (-546440578))) | (~((-437002241) | iMyTid2))) * (-302)) + ((~((-546440578) | iMyTid2)) * (-604)) + (((~(iMyTid2 | (-983442818))) | 16781352) * 302));
            if (((i345 & i344) | (i344 ^ i345)) == 1) {
                Object[] objArr76 = {null, new int[]{((~i) & i) | ((~i) & i)}, null, new int[]{i}, new int[]{i}};
                int i346 = (i3 - (~((((-2030458348) + (((-303056577) | i) * (-627))) + (((~(370861760 | i)) | 976310218) * (-627))) + (((~(i | 976310218)) | (~((-370861761) | i142))) * 627)))) - 1;
                int i347 = i346 << 13;
                int i348 = (i346 | i347) & (~(i346 & i347));
                int i349 = i348 >>> 17;
                int i350 = ((~i348) & i349) | ((~i349) & i348);
                int i351 = i350 << 5;
                return objArr76;
            }
            Object[] objArr77 = {1};
            Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1671772348);
            if (objAccessartificialFrame14 == null) {
                int i352 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 17;
                char cLastIndexOf4 = (char) ((-1) - TextUtils.lastIndexOf(str3, '0', 0));
                int minimumFlingVelocity = 1573 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                byte b6 = (byte) $$b;
                byte b7 = b6;
                Object[] objArr78 = new Object[1];
                a(b6, b7, b7, objArr78);
                objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(i352, cLastIndexOf4, minimumFlingVelocity, -54493516, false, (String) objArr78[0], new Class[]{Integer.TYPE});
            }
            long jLongValue8 = ((Long) ((Method) objAccessartificialFrame14).invoke(null, objArr77)).longValue();
            int i353 = getARTIFICIAL_FRAME_PACKAGE_NAME;
            int i354 = i353 + 3;
            artificialFrame = i354 % 128;
            int i355 = i354 % 2;
            int i356 = i353 + 37;
            artificialFrame = i356 % 128;
            if (i356 % 2 == 0) {
                long j55 = -1053929789;
                long j56 = jLongValue8 ^ j23;
                j = (((long) 758) * j55) + (((long) (-756)) * jLongValue8) + (((long) (-757)) * (j55 | j34)) + (((long) 1514) * (((j56 | j55) | j33) ^ j23)) + (((long) 757) * ((((jLongValue8 | j55) | j33) ^ j23) | (((j55 ^ j23) | j56) ^ j23) | ((j56 | j34) ^ j23))) + ((long) 1538514506);
                i15 = (int) (j >>> 52);
                int i357 = ~((-340893729) | i);
                i16 = (-1789430078) + ((262538 | i357) * (-476)) + (i357 * 952) + ((~((-340893729) | i142)) * 476);
            } else {
                long j57 = -1322402242;
                long j58 = jLongValue8 ^ j23;
                long jMyUid = Process.myUid();
                long j59 = TypedValues.AttributesType.TYPE_PIVOT_TARGET;
                long j60 = jMyUid ^ j23;
                j = (((long) 319) * j57) + (((long) (-317)) * jLongValue8) + (((long) (-318)) * (j58 | (((j57 ^ j23) | jMyUid) ^ j23))) + ((((j58 | jMyUid) ^ j23) | (((j60 | j57) | jLongValue8) ^ j23)) * j59) + (j59 * ((((j58 | j60) | j57) ^ j23) | ((jMyUid | (j57 | jLongValue8)) ^ j23))) + ((long) 1806986959);
                i15 = (int) (j >> 32);
                int iMyPid3 = Process.myPid();
                int i358 = ~iMyPid3;
                i16 = 1871737038 + (((~((-750139970) | i358)) | (~((-687086442) | iMyPid3))) * 1900) + (((~(i358 | 687086441)) | (~(750139969 | iMyPid3))) * (-950)) + (((~(iMyPid3 | 687086441)) | (~(i358 | 750139969))) * 950);
            }
            int i359 = i15 & i16;
            int i360 = (~((-1641083817) | i142)) | 558907648;
            int i361 = ~((-134480902) | i);
            int i362 = ((int) j) & (531333480 + ((i360 | i361) * (-713)) + (i361 * 1426) + ((~((-1216657070) | i142)) * 713));
            long j61 = (i359 & i362) | (i359 ^ i362);
            int i363 = artificialFrame;
            int i364 = (i363 ^ 71) + ((i363 & 71) << 1);
            getARTIFICIAL_FRAME_PACKAGE_NAME = i364 % 128;
            int i365 = i364 % 2;
            int i366 = ((int) j61) != 0 ? i ^ 220 : i;
            if (i366 != i) {
                Object[] objArr79 = {null, new int[1], null, new int[]{i}, new int[]{i366}};
                int iFreeMemory2 = (int) Runtime.getRuntime().freeMemory();
                int i367 = ~iFreeMemory2;
                int i368 = ((((~(i367 | (-170350454))) | ((~((-775798912) | i367)) | 170213493)) * (-397)) - 585655671) + ((iFreeMemory2 | (-605722379)) * 397);
                int i369 = (((i368 | 16) << 1) - (i368 ^ 16)) + i3;
                int i370 = i369 ^ (i369 << 13);
                int i371 = i370 >>> 17;
                int i372 = ((~i370) & i371) | ((~i371) & i370);
                int i373 = i372 << 5;
                ((int[]) objArr79[1])[0] = ((~i372) & i373) | ((~i373) & i372);
                return objArr79;
            }
            char edgeSlop = (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 41008);
            int i374 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 372;
            int i375 = -(ViewConfiguration.getWindowTouchSlop() >> 8);
            int i376 = ((i375 | 23) << 1) - (i375 ^ 23);
            Object[] objArr80 = new Object[1];
            b(edgeSlop, i374, i376, objArr80);
            Object[] objArr81 = {(String) objArr80[0]};
            Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-1483923676);
            if (objAccessartificialFrame15 == null) {
                int i377 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 23;
                char c16 = (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1);
                int scrollBarFadeDuration2 = 2441 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                byte[] bArr11 = $$a;
                Object[] objArr82 = new Object[1];
                a(bArr11[20], (byte) ($$b | 49), bArr11[13], objArr82);
                objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(i377, c16, scrollBarFadeDuration2, 954751276, false, (String) objArr82[0], new Class[]{String.class});
            }
            Object objInvoke = ((Method) objAccessartificialFrame15).invoke(null, objArr81);
            if (objInvoke != null) {
                Object[] objArr83 = {objInvoke, 42};
                Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-287841710);
                if (objAccessartificialFrame16 == null) {
                    int packedPositionGroup6 = 20 - ExpandableListView.getPackedPositionGroup(0L);
                    char mode = (char) View.MeasureSpec.getMode(0);
                    int iGreen3 = 2245 - Color.green(0);
                    byte[] bArr12 = $$a;
                    Object[] objArr84 = new Object[1];
                    a(bArr12[1], (byte) ($$b | 12), bArr12[13], objArr84);
                    objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(packedPositionGroup6, mode, iGreen3, 1907532890, false, (String) objArr84[0], new Class[]{String.class, Integer.TYPE});
                }
                long jLongValue9 = ((Long) ((Method) objAccessartificialFrame16).invoke(null, objArr83)).longValue();
                long j62 = 864008340;
                long j63 = j62 ^ j23;
                long j64 = (j34 | j62) ^ j23;
                long j65 = (j28 * j62) + (j29 * jLongValue9) + ((((j63 | jLongValue9) ^ j23) | j64) * j31);
                long j66 = jLongValue9 ^ j23;
                long j67 = j65 + (((j62 | j66) ^ j23) * j37) + ((((j66 | j63) ^ j23) | j64) * j40) + ((long) 769076988);
                int iElapsedRealtime3 = (int) SystemClock.elapsedRealtime();
                int i378 = ~iElapsedRealtime3;
                int i379 = ((int) (j67 >> 32)) & (1624770726 + (((~(905045839 | iElapsedRealtime3)) | (~(1952695045 | i378))) * JfifUtil.MARKER_EOI) + (((~(1952695045 | iElapsedRealtime3)) | (-1978918736)) * JfifUtil.MARKER_EOI) + (((~(905045839 | i378)) | (-1952695046)) * JfifUtil.MARKER_EOI));
                int iUptimeMillis = (int) SystemClock.uptimeMillis();
                int i380 = ((int) j67) & (((((~(478514170 | iUptimeMillis)) | 631325269) * 262) - 1141855143) + (((~((~iUptimeMillis) | 478514170)) | 631325269) * 262));
                if (((i379 & i380) | (i379 ^ i380)) == 1986687685) {
                    i22 = i3;
                    str5 = str3;
                    i23 = 1;
                    i20 = 0;
                } else {
                    int i381 = -(ViewConfiguration.getJumpTapTimeout() >> 16);
                    int iAlpha = 372 - Color.alpha(0);
                    int i382 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                    int i383 = ((i382 | 22) << 1) - (i382 ^ 22);
                    Object[] objArr85 = new Object[1];
                    b((char) ((i381 ^ 41008) + ((i381 & 41008) << 1)), iAlpha, i383, objArr85);
                    String str33 = (String) objArr85[0];
                    char cIndexOf3 = (char) (TextUtils.indexOf(str3, str3) + 53149);
                    int i384 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                    int i385 = (i384 & 616) + (i384 | 616);
                    int i386 = -KeyEvent.keyCodeFromString(str3);
                    int i387 = ((i386 | 10) << 1) - (i386 ^ 10);
                    Object[] objArr86 = new Object[1];
                    b(cIndexOf3, i385, i387, objArr86);
                    String str34 = (String) objArr86[0];
                    char absoluteGravity4 = (char) Gravity.getAbsoluteGravity(0, 0);
                    int iLastIndexOf2 = 626 - TextUtils.lastIndexOf(str3, '0', 0);
                    int i388 = -KeyEvent.normalizeMetaState(0);
                    int i389 = (i388 ^ 7) + ((i388 & 7) << 1);
                    Object[] objArr87 = new Object[1];
                    b(absoluteGravity4, iLastIndexOf2, i389, objArr87);
                    String str35 = (String) objArr87[0];
                    int i390 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                    int i391 = -(Process.myPid() >> 22);
                    int i392 = ((i391 | 634) << 1) - (i391 ^ 634);
                    int i393 = -(-Process.getGidForName(str3));
                    int i394 = (i393 ^ 9) + ((i393 & 9) << 1);
                    Object[] objArr88 = new Object[1];
                    b((char) (((i390 | 20150) << 1) - (i390 ^ 20150)), i392, i394, objArr88);
                    String[] strArr7 = {str33, str34, str35, (String) objArr88[0]};
                    char cCombineMeasuredStates = (char) View.combineMeasuredStates(0, 0);
                    int i395 = -(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                    int iITrustedWebActivityCallbackStub7 = JwtEcdsaAlgorithm.AnonymousClass1.ITrustedWebActivityCallbackStub();
                    int i396 = (i395 * (-716)) + 922705;
                    int i397 = -(-(((~i395) | 643) * (-1434)));
                    int i398 = ((i396 | i397) << 1) - (i396 ^ i397);
                    int i399 = ~iITrustedWebActivityCallbackStub7;
                    int i400 = ~(i399 | 643);
                    int i401 = ~(i395 | 643);
                    int i402 = (i400 & i401) | (i400 ^ i401);
                    int i403 = ~i395;
                    int i404 = (i403 ^ (-644)) | (i403 & (-644));
                    int i405 = (i398 - (~((i402 | (~((i404 & iITrustedWebActivityCallbackStub7) | (i404 ^ iITrustedWebActivityCallbackStub7)))) * 717))) - 1;
                    int i406 = (i403 ^ (-644)) | (i403 & (-644));
                    int i407 = ~((i399 & i406) | (i406 ^ i399));
                    int i408 = ~((i395 & 643) | (i395 ^ 643));
                    int i409 = (i408 & i407) | (i407 ^ i408);
                    int i410 = ~(iITrustedWebActivityCallbackStub7 | 643);
                    int i411 = (i405 - (~(((i409 & i410) | (i409 ^ i410)) * 717))) - 1;
                    int i412 = -(-ImageFormat.getBitsPerPixel(0));
                    int i413 = (i412 & 18) + (i412 | 18);
                    Object[] objArr89 = new Object[1];
                    b(cCombineMeasuredStates, i411, i413, objArr89);
                    String str36 = (String) objArr89[0];
                    char cRgb = (char) (Color.rgb(0, 0, 0) + 16841548);
                    int i414 = -(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                    int i415 = (i414 ^ 660) + ((i414 & 660) << 1);
                    int i416 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                    int i417 = (i416 ^ 6) + ((i416 & 6) << 1);
                    Object[] objArr90 = new Object[1];
                    b(cRgb, i415, i417, objArr90);
                    String str37 = (String) objArr90[0];
                    int fadingEdgeLength = ViewConfiguration.getFadingEdgeLength() >> 16;
                    int i418 = -(-(ViewConfiguration.getMinimumFlingVelocity() >> 16));
                    Object[] objArr91 = new Object[1];
                    b((char) ((fadingEdgeLength & 43578) + (fadingEdgeLength | 43578)), (i418 & 666) + (i418 | 666), 6 - (~(-(-View.MeasureSpec.getMode(0)))), objArr91);
                    String str38 = (String) objArr91[0];
                    int i419 = -(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                    Object[] objArr92 = new Object[1];
                    b((char) (((i419 | 1) << 1) - (i419 ^ 1)), ExpandableListView.getPackedPositionType(0L) + 673, 10 - (~(ViewConfiguration.getScrollBarSize() >> 8)), objArr92);
                    String str39 = (String) objArr92[0];
                    int i420 = -(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                    int i421 = -(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                    int i422 = (i421 ^ 684) + ((i421 & 684) << 1);
                    int i423 = -(-(ViewConfiguration.getKeyRepeatDelay() >> 16));
                    int i424 = (i423 & 14) + (i423 | 14);
                    Object[] objArr93 = new Object[1];
                    b((char) ((i420 ^ 23083) + ((i420 & 23083) << 1)), i422, i424, objArr93);
                    String[] strArr8 = {str36, str37, str38, str39, (String) objArr93[0]};
                    char fadingEdgeLength2 = (char) (ViewConfiguration.getFadingEdgeLength() >> 16);
                    int i425 = -(ViewConfiguration.getKeyRepeatDelay() >> 16);
                    int absoluteGravity5 = Gravity.getAbsoluteGravity(0, 0);
                    int i426 = (absoluteGravity5 & 16) + (absoluteGravity5 | 16);
                    Object[] objArr94 = new Object[1];
                    b(fadingEdgeLength2, ((i425 | 698) << 1) - (i425 ^ 698), i426, objArr94);
                    String str40 = (String) objArr94[0];
                    char edgeSlop2 = (char) (41778 - (ViewConfiguration.getEdgeSlop() >> 16));
                    int i427 = -(-(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                    int i428 = (i427 & 713) + (i427 | 713);
                    int i429 = -MotionEvent.axisFromString(str3);
                    int i430 = (i429 ^ 2) + ((i429 & 2) << 1);
                    Object[] objArr95 = new Object[1];
                    b(edgeSlop2, i428, i430, objArr95);
                    String str41 = (String) objArr95[0];
                    char cBlue = (char) Color.blue(0);
                    int i431 = 724 - (~(-TextUtils.indexOf(str3, str3)));
                    int i432 = -((byte) KeyEvent.getModifierMetaStateMask());
                    int i433 = (i432 ^ 21) + ((i432 & 21) << 1);
                    Object[] objArr96 = new Object[1];
                    b(cBlue, i431, i433, objArr96);
                    String str42 = (String) objArr96[0];
                    int i434 = -TextUtils.indexOf((CharSequence) str3, '0');
                    int i435 = -(-(ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                    Object[] objArr97 = new Object[1];
                    b((char) (((i434 | 16204) << 1) - (i434 ^ 16204)), ((i435 | 747) << 1) - (i435 ^ 747), 24 - (~(-(-ExpandableListView.getPackedPositionGroup(0L)))), objArr97);
                    String str43 = (String) objArr97[0];
                    char keyRepeatTimeout3 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                    int i436 = -(-(ViewConfiguration.getScrollBarSize() >> 8));
                    int i437 = -(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                    int i438 = (i437 ^ 28) + ((i437 & 28) << 1);
                    Object[] objArr98 = new Object[1];
                    b(keyRepeatTimeout3, (i436 ^ 772) + ((i436 & 772) << 1), i438, objArr98);
                    String[] strArr9 = {str40, str41, str, str42, str43, (String) objArr98[0]};
                    int i439 = -View.resolveSizeAndState(0, 0, 0);
                    int packedPositionChild = 799 - ExpandableListView.getPackedPositionChild(0L);
                    int i440 = -ExpandableListView.getPackedPositionGroup(0L);
                    int i441 = (i440 ^ 11) + ((i440 & 11) << 1);
                    Object[] objArr99 = new Object[1];
                    b((char) ((i439 & 34304) + (i439 | 34304)), packedPositionChild, i441, objArr99);
                    String str44 = (String) objArr99[0];
                    char keyRepeatTimeout4 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                    int maximumDrawingCacheSize7 = ViewConfiguration.getMaximumDrawingCacheSize() >> 24;
                    Object[] objArr100 = new Object[1];
                    b(keyRepeatTimeout4, (maximumDrawingCacheSize7 ^ 811) + ((maximumDrawingCacheSize7 & 811) << 1), 8 - (~(-(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)))), objArr100);
                    String str45 = (String) objArr100[0];
                    Object[] objArr101 = new Object[1];
                    b((char) TextUtils.getOffsetAfter(str3, 0), 819 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 5 - (~(-(ViewConfiguration.getEdgeSlop() >> 16))), objArr101);
                    String str46 = (String) objArr101[0];
                    char c17 = (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                    int i442 = -View.MeasureSpec.getMode(0);
                    int i443 = (i442 ^ 825) + ((i442 & 825) << 1);
                    int i444 = -((byte) KeyEvent.getModifierMetaStateMask());
                    int i445 = ((i444 | 5) << 1) - (i444 ^ 5);
                    Object[] objArr102 = new Object[1];
                    b(c17, i443, i445, objArr102);
                    String[] strArr10 = {str44, str45, str46, (String) objArr102[0]};
                    char c18 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                    int i446 = -(-(ViewConfiguration.getWindowTouchSlop() >> 8));
                    int iRed = Color.red(0);
                    Object[] objArr103 = new Object[1];
                    b(c18, (i446 & 831) + (i446 | 831), (iRed & 16) + (iRed | 16), objArr103);
                    String str47 = (String) objArr103[0];
                    int i447 = -ExpandableListView.getPackedPositionType(0L);
                    int scrollDefaultDelay3 = ViewConfiguration.getScrollDefaultDelay() >> 16;
                    int i448 = ((scrollDefaultDelay3 | 666) << 1) - (scrollDefaultDelay3 ^ 666);
                    int i449 = -(-(ViewConfiguration.getLongPressTimeout() >> 16));
                    int i450 = (i449 ^ 7) + ((i449 & 7) << 1);
                    Object[] objArr104 = new Object[1];
                    b((char) ((i447 ^ 43578) + ((i447 & 43578) << 1)), i448, i450, objArr104);
                    String str48 = (String) objArr104[0];
                    int i451 = -TextUtils.indexOf((CharSequence) str3, '0', 0);
                    int i452 = -(-(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                    int i453 = (i452 ^ 633) + ((i452 & 633) << 1);
                    int i454 = -(-TextUtils.lastIndexOf(str3, '0'));
                    int i455 = (i454 ^ 9) + ((i454 & 9) << 1);
                    Object[] objArr105 = new Object[1];
                    b((char) ((i451 ^ 20150) + ((i451 & 20150) << 1)), i453, i455, objArr105);
                    String[] strArr11 = {str47, str48, (String) objArr105[0]};
                    int i456 = -(-(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                    int threadPriority3 = Process.getThreadPriority(0);
                    int i457 = -(((threadPriority3 ^ 20) + ((threadPriority3 & 20) << 1)) >> 6);
                    int i458 = -Color.blue(0);
                    int i459 = (i458 ^ 14) + ((i458 & 14) << 1);
                    Object[] objArr106 = new Object[1];
                    b((char) ((i456 ^ (-1)) + (i456 << 1)), (i457 ^ 847) + ((i457 & 847) << 1), i459, objArr106);
                    String str49 = (String) objArr106[0];
                    int i460 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                    Object[] objArr107 = new Object[1];
                    b((char) (((i460 | 60757) << 1) - (60757 ^ i460)), 860 - (~(-(-View.MeasureSpec.getMode(0)))), -TextUtils.lastIndexOf(str3, '0'), objArr107);
                    String[] strArr12 = {str49, (String) objArr107[0]};
                    char defaultSize = (char) View.getDefaultSize(0, 0);
                    int i461 = -(ViewConfiguration.getKeyRepeatDelay() >> 16);
                    int i462 = (i461 ^ 862) + ((i461 & 862) << 1);
                    int i463 = -(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                    int i464 = (i463 ^ 10) + ((i463 & 10) << 1);
                    Object[] objArr108 = new Object[1];
                    b(defaultSize, i462, i464, objArr108);
                    String str50 = (String) objArr108[0];
                    Object[] objArr109 = new Object[1];
                    b((char) (22846 - TextUtils.indexOf(str3, str3)), 871 - (~(-(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)))), View.resolveSize(0, 0) + 1, objArr109);
                    String[] strArr13 = {str50, (String) objArr109[0]};
                    char c19 = (char) (0 - (~(-(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)))));
                    int i465 = -(ViewConfiguration.getDoubleTapTimeout() >> 16);
                    int i466 = (i465 & 872) + (i465 | 872);
                    int i467 = -(-KeyEvent.normalizeMetaState(0));
                    int i468 = ((i467 | 16) << 1) - (i467 ^ 16);
                    Object[] objArr110 = new Object[1];
                    b(c19, i466, i468, objArr110);
                    String str51 = (String) objArr110[0];
                    int i469 = -(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                    int keyRepeatTimeout5 = ViewConfiguration.getKeyRepeatTimeout() >> 16;
                    Object[] objArr111 = new Object[1];
                    b((char) ((i469 & 41779) + (i469 | 41779)), (keyRepeatTimeout5 & 714) + (keyRepeatTimeout5 | 714), Color.alpha(0) + 3, objArr111);
                    String str52 = (String) objArr111[0];
                    char c20 = (char) (64330 - (~(-(-(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))));
                    int i470 = -ImageFormat.getBitsPerPixel(0);
                    int i471 = ((i470 | 658) << 1) - (i470 ^ 658);
                    int i472 = -AndroidCharacter.getMirror('0');
                    int i473 = (i472 & 55) + (i472 | 55);
                    Object[] objArr112 = new Object[1];
                    b(c20, i471, i473, objArr112);
                    String str53 = (String) objArr112[0];
                    char cMakeMeasureSpec = (char) View.MeasureSpec.makeMeasureSpec(0, 0);
                    int iIndexOf8 = TextUtils.indexOf(str3, str3, 0);
                    Object[] objArr113 = new Object[1];
                    b(cMakeMeasureSpec, (iIndexOf8 ^ com.salesforce.marketingcloud.analytics.b.q) + ((iIndexOf8 & com.salesforce.marketingcloud.analytics.b.q) << 1), (-41) - (~(-(-AndroidCharacter.getMirror('0')))), objArr113);
                    String str54 = (String) objArr113[0];
                    Object[] objArr114 = new Object[1];
                    b((char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 672 - (~(-(-(KeyEvent.getMaxKeyCode() >> 16)))), 11 - (~(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), objArr114);
                    String str55 = (String) objArr114[0];
                    int doubleTapTimeout3 = ViewConfiguration.getDoubleTapTimeout() >> 16;
                    Object[] objArr115 = new Object[1];
                    b((char) ((doubleTapTimeout3 & 23083) + (doubleTapTimeout3 | 23083)), 683 - (~(-(-TextUtils.getTrimmedLength(str3)))), 13 - (~(-Color.red(0))), objArr115);
                    String[] strArr14 = {str51, str52, str53, str54, str55, (String) objArr115[0]};
                    char cLastIndexOf5 = (char) (TextUtils.lastIndexOf(str3, '0', 0, 0) + 1);
                    int i474 = -(-(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)));
                    Object[] objArr116 = new Object[1];
                    b(cLastIndexOf5, ((i474 | 895) << 1) - (i474 ^ 895), 19 - (~(-(-(ViewConfiguration.getMinimumFlingVelocity() >> 16)))), objArr116);
                    String str56 = (String) objArr116[0];
                    char cLastIndexOf6 = (char) (TextUtils.lastIndexOf(str3, '0', 0) + 1);
                    int i475 = -(-View.resolveSizeAndState(0, 0, 0));
                    int i476 = (i475 ^ 916) + ((i475 & 916) << 1);
                    int i477 = -(-(TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)));
                    int i478 = ((i477 | 19) << 1) - (i477 ^ 19);
                    Object[] objArr117 = new Object[1];
                    b(cLastIndexOf6, i476, i478, objArr117);
                    String str57 = (String) objArr117[0];
                    char cIndexOf4 = (char) (TextUtils.indexOf((CharSequence) str3, '0', 0) + 1);
                    int i479 = 934 - (~(-KeyEvent.keyCodeFromString(str3)));
                    int iIndexOf9 = TextUtils.indexOf(str3, str3, 0, 0);
                    Object[] objArr118 = new Object[1];
                    b(cIndexOf4, i479, (iIndexOf9 & 31) + (iIndexOf9 | 31), objArr118);
                    String str58 = (String) objArr118[0];
                    char packedPositionGroup7 = (char) ExpandableListView.getPackedPositionGroup(0L);
                    int iResolveOpacity2 = Drawable.resolveOpacity(0, 0) + 966;
                    int i480 = -MotionEvent.axisFromString(str3);
                    Object[] objArr119 = new Object[1];
                    b(packedPositionGroup7, iResolveOpacity2, (i480 & 25) + (i480 | 25), objArr119);
                    String str59 = (String) objArr119[0];
                    int i481 = -(-(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                    int i482 = -TextUtils.getOffsetAfter(str3, 0);
                    int i483 = ((i482 | 992) << 1) - (i482 ^ 992);
                    int edgeSlop3 = ViewConfiguration.getEdgeSlop() >> 16;
                    int i484 = (edgeSlop3 ^ 23) + ((edgeSlop3 & 23) << 1);
                    Object[] objArr120 = new Object[1];
                    b((char) ((i481 & 19208) + (i481 | 19208)), i483, i484, objArr120);
                    String str60 = (String) objArr120[0];
                    char c21 = (char) (20520 - (~(-(-(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))));
                    int i485 = -(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                    int iITrustedWebActivityCallbackStub8 = JwtEcdsaAlgorithm.AnonymousClass1.ITrustedWebActivityCallbackStub();
                    int i486 = (i485 * TypedValues.Custom.TYPE_DIMENSION) - 916545;
                    int i487 = ~i485;
                    int i488 = ~((i487 ^ iITrustedWebActivityCallbackStub8) | (i487 & iITrustedWebActivityCallbackStub8));
                    int i489 = ~iITrustedWebActivityCallbackStub8;
                    int i490 = ~((i489 & PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW) | (i489 ^ PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW));
                    int i491 = ((i490 & i488) | (i488 ^ i490)) * (-1808);
                    int i492 = ((i486 | i491) << 1) - (i486 ^ i491);
                    int i493 = (i487 ^ (-1016)) | (i487 & (-1016));
                    int i494 = ~((i493 & iITrustedWebActivityCallbackStub8) | (i493 ^ iITrustedWebActivityCallbackStub8));
                    int i495 = (i489 ^ i485) | (i489 & i485);
                    int i496 = ~((i495 & PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW) | (i495 ^ PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW));
                    int i497 = ((i494 & i496) | (i494 ^ i496)) * TypedValues.Custom.TYPE_BOOLEAN;
                    int i498 = (i492 & i497) + (i497 | i492);
                    int i499 = ~((~i485) | PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW);
                    int i500 = ~(((-1016) & iITrustedWebActivityCallbackStub8) | ((-1016) ^ iITrustedWebActivityCallbackStub8));
                    int i501 = (i499 & i500) | (i499 ^ i500);
                    int i502 = ~(i485 | (~iITrustedWebActivityCallbackStub8));
                    int i503 = ((i502 & i501) | (i501 ^ i502)) * TypedValues.Custom.TYPE_BOOLEAN;
                    Object[] objArr121 = new Object[1];
                    b(c21, ((i498 | i503) << 1) - (i503 ^ i498), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 32, objArr121);
                    String[] strArr15 = {str56, str57, str58, str59, str60, (String) objArr121[0], str};
                    char scrollDefaultDelay4 = (char) (52931 - (ViewConfiguration.getScrollDefaultDelay() >> 16));
                    int i504 = 1047 - (~(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)));
                    int i505 = -KeyEvent.normalizeMetaState(0);
                    Object[] objArr122 = new Object[1];
                    b(scrollDefaultDelay4, i504, (i505 & 13) + (i505 | 13), objArr122);
                    String str61 = (String) objArr122[0];
                    Object[] objArr123 = new Object[1];
                    b((char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), 626 - (~Gravity.getAbsoluteGravity(0, 0)), 5 - (~(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), objArr123);
                    String[] strArr16 = {str61, (String) objArr123[0]};
                    int i506 = -(ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    int iMyTid3 = 1061 - (Process.myTid() >> 22);
                    int i507 = -ExpandableListView.getPackedPositionType(0L);
                    int i508 = ((i507 | 30) << 1) - (i507 ^ 30);
                    Object[] objArr124 = new Object[1];
                    b((char) (((i506 | 64830) << 1) - (i506 ^ 64830)), iMyTid3, i508, objArr124);
                    String str62 = (String) objArr124[0];
                    char cCombineMeasuredStates2 = (char) (2408 - View.combineMeasuredStates(0, 0));
                    int i509 = -TextUtils.lastIndexOf(str3, '0', 0, 0);
                    Object[] objArr125 = new Object[1];
                    b(cCombineMeasuredStates2, (i509 ^ 1090) + ((i509 & 1090) << 1), 10 - (~(-(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)))), objArr125);
                    String[] strArr17 = {str62, (String) objArr125[0]};
                    int i510 = -KeyEvent.keyCodeFromString(str3);
                    int fadingEdgeLength3 = ViewConfiguration.getFadingEdgeLength() >> 16;
                    Object[] objArr126 = new Object[1];
                    b((char) ((i510 & 55353) + (i510 | 55353)), ((fadingEdgeLength3 | 1102) << 1) - (fadingEdgeLength3 ^ 1102), 18 - (~(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))), objArr126);
                    String str63 = (String) objArr126[0];
                    Object[] objArr127 = new Object[1];
                    b((char) (Color.green(0) + 54140), 1121 - View.MeasureSpec.makeMeasureSpec(0, 0), TextUtils.lastIndexOf(str3, '0', 0) + 6, objArr127);
                    String[] strArr18 = {str63, (String) objArr127[0]};
                    int i511 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                    int i512 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                    int i513 = (i512 ^ 1126) + ((i512 & 1126) << 1);
                    int i514 = -AndroidCharacter.getMirror('0');
                    int i515 = ((i514 | 67) << 1) - (i514 ^ 67);
                    Object[] objArr128 = new Object[1];
                    b((char) ((i511 & 25207) + (i511 | 25207)), i513, i515, objArr128);
                    String[] strArr19 = {(String) objArr128[0]};
                    char size = (char) View.MeasureSpec.getSize(0);
                    int i516 = 1144 - (~(-(ViewConfiguration.getMinimumFlingVelocity() >> 16)));
                    int i517 = -(-Color.blue(0));
                    Object[] objArr129 = new Object[1];
                    b(size, i516, (i517 & 16) + (i517 | 16), objArr129);
                    String[] strArr20 = {(String) objArr129[0]};
                    int i518 = -(-Color.argb(0, 0, 0, 0));
                    int i519 = 1160 - (~(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)));
                    int i520 = -(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                    Object[] objArr130 = new Object[1];
                    b((char) (((i518 | 29967) << 1) - (i518 ^ 29967)), i519, (i520 & 20) + (i520 | 20), objArr130);
                    String[] strArr21 = {(String) objArr130[0]};
                    char scrollBarSize = (char) (ViewConfiguration.getScrollBarSize() >> 8);
                    int maximumFlingVelocity2 = ViewConfiguration.getMaximumFlingVelocity() >> 16;
                    Object[] objArr131 = new Object[1];
                    b(scrollBarSize, ((maximumFlingVelocity2 | 1180) << 1) - (maximumFlingVelocity2 ^ 1180), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 18, objArr131);
                    String[] strArr22 = {(String) objArr131[0]};
                    int iIndexOf10 = TextUtils.indexOf((CharSequence) str3, '0', 0);
                    int i521 = -(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                    Object[] objArr132 = new Object[1];
                    b((char) ((iIndexOf10 & 1) + (iIndexOf10 | 1)), (i521 ^ 1199) + ((i521 & 1199) << 1), 22 - (~(ViewConfiguration.getPressedStateDuration() >> 16)), objArr132);
                    String[] strArr23 = {(String) objArr132[0]};
                    int longPressTimeout2 = ViewConfiguration.getLongPressTimeout() >> 16;
                    int i522 = -(ViewConfiguration.getWindowTouchSlop() >> 8);
                    int i523 = (i522 ^ 1222) + ((i522 & 1222) << 1);
                    int i524 = -(ViewConfiguration.getMaximumFlingVelocity() >> 16);
                    int i525 = (i524 & 21) + (i524 | 21);
                    Object[] objArr133 = new Object[1];
                    b((char) ((longPressTimeout2 ^ 61636) + ((longPressTimeout2 & 61636) << 1)), i523, i525, objArr133);
                    String[] strArr24 = {(String) objArr133[0]};
                    char c22 = (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                    int i526 = -KeyEvent.getDeadChar(0, 0);
                    int i527 = (i526 ^ 1243) + ((i526 & 1243) << 1);
                    int i528 = -TextUtils.indexOf(str3, str3);
                    int i529 = (i528 ^ 24) + ((i528 & 24) << 1);
                    Object[] objArr134 = new Object[1];
                    b(c22, i527, i529, objArr134);
                    String str64 = str;
                    String[] strArr25 = {(String) objArr134[0], str64};
                    char edgeSlop4 = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                    int i530 = -(ViewConfiguration.getTapTimeout() >> 16);
                    Object[] objArr135 = new Object[1];
                    b(edgeSlop4, ((i530 | 1267) << 1) - (i530 ^ 1267), 28 - (~(-(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)))), objArr135);
                    String[] strArr26 = {(String) objArr135[0], str64};
                    Object[] objArr136 = new Object[1];
                    b((char) (34911 - View.resolveSizeAndState(0, 0, 0)), TextUtils.indexOf((CharSequence) str3, '0', 0, 0) + 1296, View.resolveSizeAndState(0, 0, 0) + 27, objArr136);
                    String[] strArr27 = {(String) objArr136[0], str64};
                    int i531 = -(ViewConfiguration.getMaximumFlingVelocity() >> 16);
                    int i532 = 1322 - (~(-(-TextUtils.indexOf((CharSequence) str3, '0', 0, 0))));
                    int iCombineMeasuredStates = View.combineMeasuredStates(0, 0);
                    int i533 = ((iCombineMeasuredStates | 31) << 1) - (iCombineMeasuredStates ^ 31);
                    Object[] objArr137 = new Object[1];
                    b((char) ((i531 ^ 29072) + ((i531 & 29072) << 1)), i532, i533, objArr137);
                    String[] strArr28 = {(String) objArr137[0], str64};
                    int i534 = -((Process.getThreadPriority(0) + 20) >> 6);
                    int i535 = 1352 - (~(-(-Color.red(0))));
                    int i536 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                    Object[] objArr138 = new Object[1];
                    b((char) ((i534 & 42986) + (i534 | 42986)), i535, (i536 & 26) + (i536 | 26), objArr138);
                    String[] strArr29 = {(String) objArr138[0], str64};
                    int i537 = -(ViewConfiguration.getPressedStateDuration() >> 16);
                    int i538 = -ImageFormat.getBitsPerPixel(0);
                    int i539 = ((i538 | 1379) << 1) - (i538 ^ 1379);
                    int i540 = -(-Process.getGidForName(str3));
                    int i541 = (i540 ^ 33) + ((i540 & 33) << 1);
                    Object[] objArr139 = new Object[1];
                    b((char) ((i537 ^ 61918) + ((i537 & 61918) << 1)), i539, i541, objArr139);
                    strArr = new String[][]{strArr7, strArr8, strArr9, strArr10, strArr11, strArr12, strArr13, strArr14, strArr15, strArr16, strArr17, strArr18, strArr19, strArr20, strArr21, strArr22, strArr23, strArr24, strArr25, strArr26, strArr27, strArr28, strArr29, new String[]{(String) objArr139[0], str64}};
                    arrayList = new ArrayList();
                    i17 = i;
                    i18 = 0;
                    i19 = 0;
                    while (i18 < 24) {
                        String[] strArr30 = strArr[i18];
                        Object[] objArr140 = {strArr30[0]};
                        objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                        if (objAccessartificialFrame2 == null) {
                            int iIndexOf11 = 23 - TextUtils.indexOf(str3, str3, 0);
                            char c23 = (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                            int keyRepeatTimeout6 = 2441 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                            byte[] bArr13 = $$a;
                            Object[] objArr141 = new Object[1];
                            a(bArr13[20], (byte) ($$b | 49), bArr13[13], objArr141);
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iIndexOf11, c23, keyRepeatTimeout6, 954751276, false, (String) objArr141[0], new Class[]{String.class});
                        }
                        str6 = (String) ((Method) objAccessartificialFrame2).invoke(null, objArr140);
                        String[] strArr31 = (String[]) Arrays.copyOfRange(strArr30, 1, strArr30.length);
                        if (str6 == null && str6.length() != 0) {
                            int i542 = artificialFrame;
                            int i543 = ((i542 | 51) << 1) - (i542 ^ 51);
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i543 % 128;
                            int i544 = i543 % 2;
                            int length2 = strArr30.length;
                            if (i544 == 0) {
                                z = true;
                                if (length2 != 1) {
                                    length = strArr31.length;
                                    i24 = 0;
                                    while (i24 < length) {
                                        if ((str6.contains(strArr31[i24]) ^ z) != z) {
                                            i24++;
                                            z = true;
                                        }
                                    }
                                }
                            } else if (length2 != 0) {
                                z = true;
                                length = strArr31.length;
                                i24 = 0;
                                while (i24 < length) {
                                    if ((str6.contains(strArr31[i24]) ^ z) != z) {
                                        i24++;
                                        z = true;
                                    }
                                }
                            }
                            i19++;
                            int i545 = i18 + 10;
                            i17 = ((~i545) & i) | (i545 & i142);
                            StringBuilder sb = new StringBuilder();
                            sb.append(str6);
                            char size2 = (char) View.MeasureSpec.getSize(0);
                            int i546 = -(-Gravity.getAbsoluteGravity(0, 0));
                            int i547 = (i546 ^ 1412) + ((i546 & 1412) << 1);
                            int i548 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                            int i549 = (i548 & 1) + (i548 | 1);
                            Object[] objArr142 = new Object[1];
                            b(size2, i547, i549, objArr142);
                            sb.append((String) objArr142[0]);
                            sb.append(str6);
                            arrayList.add(sb.toString());
                            break;
                        }
                        i18++;
                        strArr = strArr;
                        str3 = str3;
                    }
                    str5 = str3;
                    if (i19 > 2) {
                        objArr = new Object[]{arrayList, new int[]{i}, null, new int[]{i}, new int[]{i17}};
                        int i550 = (-2132968639) + (((~((-496003489) | i)) | (~(109444969 | i142))) * (-1808)) + (((~((-75524385) | i)) | (~(529924073 | i142))) * TypedValues.Custom.TYPE_BOOLEAN) + (((~((-109444970) | i)) | 420479104 | (~(496003488 | i142))) * TypedValues.Custom.TYPE_BOOLEAN);
                        int i551 = i550 << 13;
                        int i552 = (i551 | i550) & (~(i550 & i551));
                        int i553 = i552 ^ (i552 >>> 17);
                        int i554 = i553 << 5;
                        int i555 = ((~i553) & i554) | ((~i554) & i553);
                        i20 = 0;
                    } else {
                        objArr = new Object[]{null, new int[]{i}, null, new int[]{i}, new int[]{i}};
                        int i556 = (-2115839000) + (((~((-417310351) | i)) | 135692810) * 345) + (((~((-417310351) | i142)) | 52445297) * 345) + ((~((-135692811) | i)) * 345);
                        int i557 = (i556 << 13) ^ i556;
                        int i558 = i557 ^ (i557 >>> 17);
                        int i559 = i558 << 5;
                        int i560 = (i558 | i559) & (~(i558 & i559));
                        i20 = 0;
                    }
                    i21 = ((int[]) objArr[4])[i20];
                    if (i21 != i) {
                        objArr2 = new Object[5];
                        objArr2[1] = new int[1];
                        int[] iArr2 = new int[1];
                        objArr2[3] = iArr2;
                        int[] iArr3 = new int[1];
                        objArr2[4] = iArr3;
                        List list = (List) objArr[i20];
                        iArr2[i20] = i;
                        iArr3[i20] = i21;
                        objArr2[i20] = list;
                        objArr2[2] = null;
                        int i561 = (-637919239) + (((~(334627192 | i142)) | (-1006267387) | (~(i142 | 940075650))) * 464) + (((-671640195) | i) * (-464)) + (((~(i | 940075650)) | (-1006267387)) * 464);
                        int iITrustedWebActivityCallbackStub9 = JwtEcdsaAlgorithm.AnonymousClass1.ITrustedWebActivityCallbackStub();
                        int i562 = ((5872 + (i561 * 367)) - (~((i561 | 16) * (-366)))) - 1;
                        int i563 = ~i561;
                        int i564 = ~((i563 ^ iITrustedWebActivityCallbackStub9) | (i563 & iITrustedWebActivityCallbackStub9));
                        int i565 = (i562 - (~(((i564 & 16) | (i564 ^ 16)) * (-366)))) - 1;
                        int i566 = ~(((-17) & i561) | ((-17) ^ i561));
                        int i567 = (i563 & 16) | (i563 ^ 16);
                        int i568 = ~((iITrustedWebActivityCallbackStub9 & i567) | (i567 ^ iITrustedWebActivityCallbackStub9));
                        int i569 = ((i568 & i566) | (i566 ^ i568)) * 366;
                        int i570 = ((i565 | i569) << 1) - (i569 ^ i565);
                        int i571 = (i3 & i570) + (i570 | i3);
                        int i572 = i571 ^ (i571 << 13);
                        int i573 = i572 >>> 17;
                        int i574 = (i572 | i573) & (~(i572 & i573));
                        int i575 = i574 << 5;
                        ((int[]) objArr2[1])[0] = ((~i574) & i575) | ((~i575) & i574);
                    } else {
                        i22 = i3;
                        i23 = 1;
                    }
                }
            } else {
                int i3810 = -(ViewConfiguration.getJumpTapTimeout() >> 16);
                int iAlpha2 = 372 - Color.alpha(0);
                int i3811 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                int i3812 = ((i3811 | 22) << 1) - (i3811 ^ 22);
                Object[] objArr810 = new Object[1];
                b((char) ((i3810 ^ 41008) + ((i3810 & 41008) << 1)), iAlpha2, i3812, objArr810);
                String str310 = (String) objArr810[0];
                char cIndexOf5 = (char) (TextUtils.indexOf(str3, str3) + 53149);
                int i3813 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                int i3814 = (i3813 & 616) + (i3813 | 616);
                int i3815 = -KeyEvent.keyCodeFromString(str3);
                int i3816 = ((i3815 | 10) << 1) - (i3815 ^ 10);
                Object[] objArr811 = new Object[1];
                b(cIndexOf5, i3814, i3816, objArr811);
                String str311 = (String) objArr811[0];
                char absoluteGravity6 = (char) Gravity.getAbsoluteGravity(0, 0);
                int iLastIndexOf3 = 626 - TextUtils.lastIndexOf(str3, '0', 0);
                int i3817 = -KeyEvent.normalizeMetaState(0);
                int i3818 = (i3817 ^ 7) + ((i3817 & 7) << 1);
                Object[] objArr812 = new Object[1];
                b(absoluteGravity6, iLastIndexOf3, i3818, objArr812);
                String str312 = (String) objArr812[0];
                int i3910 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                int i3911 = -(Process.myPid() >> 22);
                int i3912 = ((i3911 | 634) << 1) - (i3911 ^ 634);
                int i3913 = -(-Process.getGidForName(str3));
                int i3914 = (i3913 ^ 9) + ((i3913 & 9) << 1);
                Object[] objArr813 = new Object[1];
                b((char) (((i3910 | 20150) << 1) - (i3910 ^ 20150)), i3912, i3914, objArr813);
                String[] strArr32 = {str310, str311, str312, (String) objArr813[0]};
                char cCombineMeasuredStates3 = (char) View.combineMeasuredStates(0, 0);
                int i3915 = -(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                int iITrustedWebActivityCallbackStub10 = JwtEcdsaAlgorithm.AnonymousClass1.ITrustedWebActivityCallbackStub();
                int i3916 = (i3915 * (-716)) + 922705;
                int i3917 = -(-(((~i3915) | 643) * (-1434)));
                int i3918 = ((i3916 | i3917) << 1) - (i3916 ^ i3917);
                int i3919 = ~iITrustedWebActivityCallbackStub10;
                int i4010 = ~(i3919 | 643);
                int i4011 = ~(i3915 | 643);
                int i4012 = (i4010 & i4011) | (i4010 ^ i4011);
                int i4013 = ~i3915;
                int i4014 = (i4013 ^ (-644)) | (i4013 & (-644));
                int i4015 = (i3918 - (~((i4012 | (~((i4014 & iITrustedWebActivityCallbackStub10) | (i4014 ^ iITrustedWebActivityCallbackStub10)))) * 717))) - 1;
                int i4016 = (i4013 ^ (-644)) | (i4013 & (-644));
                int i4017 = ~((i3919 & i4016) | (i4016 ^ i3919));
                int i4018 = ~((i3915 & 643) | (i3915 ^ 643));
                int i4019 = (i4018 & i4017) | (i4017 ^ i4018);
                int i4110 = ~(iITrustedWebActivityCallbackStub10 | 643);
                int i4111 = (i4015 - (~(((i4019 & i4110) | (i4019 ^ i4110)) * 717))) - 1;
                int i4112 = -(-ImageFormat.getBitsPerPixel(0));
                int i4113 = (i4112 & 18) + (i4112 | 18);
                Object[] objArr814 = new Object[1];
                b(cCombineMeasuredStates3, i4111, i4113, objArr814);
                String str313 = (String) objArr814[0];
                char cRgb2 = (char) (Color.rgb(0, 0, 0) + 16841548);
                int i4114 = -(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                int i4115 = (i4114 ^ 660) + ((i4114 & 660) << 1);
                int i4116 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                int i4117 = (i4116 ^ 6) + ((i4116 & 6) << 1);
                Object[] objArr910 = new Object[1];
                b(cRgb2, i4115, i4117, objArr910);
                String str314 = (String) objArr910[0];
                int fadingEdgeLength4 = ViewConfiguration.getFadingEdgeLength() >> 16;
                int i4118 = -(-(ViewConfiguration.getMinimumFlingVelocity() >> 16));
                Object[] objArr911 = new Object[1];
                b((char) ((fadingEdgeLength4 & 43578) + (fadingEdgeLength4 | 43578)), (i4118 & 666) + (i4118 | 666), 6 - (~(-(-View.MeasureSpec.getMode(0)))), objArr911);
                String str315 = (String) objArr911[0];
                int i4119 = -(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                Object[] objArr912 = new Object[1];
                b((char) (((i4119 | 1) << 1) - (i4119 ^ 1)), ExpandableListView.getPackedPositionType(0L) + 673, 10 - (~(ViewConfiguration.getScrollBarSize() >> 8)), objArr912);
                String str316 = (String) objArr912[0];
                int i4210 = -(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                int i4211 = -(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                int i4212 = (i4211 ^ 684) + ((i4211 & 684) << 1);
                int i4213 = -(-(ViewConfiguration.getKeyRepeatDelay() >> 16));
                int i4214 = (i4213 & 14) + (i4213 | 14);
                Object[] objArr913 = new Object[1];
                b((char) ((i4210 ^ 23083) + ((i4210 & 23083) << 1)), i4212, i4214, objArr913);
                String[] strArr33 = {str313, str314, str315, str316, (String) objArr913[0]};
                char fadingEdgeLength5 = (char) (ViewConfiguration.getFadingEdgeLength() >> 16);
                int i4215 = -(ViewConfiguration.getKeyRepeatDelay() >> 16);
                int absoluteGravity7 = Gravity.getAbsoluteGravity(0, 0);
                int i4216 = (absoluteGravity7 & 16) + (absoluteGravity7 | 16);
                Object[] objArr914 = new Object[1];
                b(fadingEdgeLength5, ((i4215 | 698) << 1) - (i4215 ^ 698), i4216, objArr914);
                String str410 = (String) objArr914[0];
                char edgeSlop5 = (char) (41778 - (ViewConfiguration.getEdgeSlop() >> 16));
                int i4217 = -(-(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                int i4218 = (i4217 & 713) + (i4217 | 713);
                int i4219 = -MotionEvent.axisFromString(str3);
                int i4310 = (i4219 ^ 2) + ((i4219 & 2) << 1);
                Object[] objArr915 = new Object[1];
                b(edgeSlop5, i4218, i4310, objArr915);
                String str411 = (String) objArr915[0];
                char cBlue2 = (char) Color.blue(0);
                int i4311 = 724 - (~(-TextUtils.indexOf(str3, str3)));
                int i4312 = -((byte) KeyEvent.getModifierMetaStateMask());
                int i4313 = (i4312 ^ 21) + ((i4312 & 21) << 1);
                Object[] objArr916 = new Object[1];
                b(cBlue2, i4311, i4313, objArr916);
                String str412 = (String) objArr916[0];
                int i4314 = -TextUtils.indexOf((CharSequence) str3, '0');
                int i4315 = -(-(ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                Object[] objArr917 = new Object[1];
                b((char) (((i4314 | 16204) << 1) - (i4314 ^ 16204)), ((i4315 | 747) << 1) - (i4315 ^ 747), 24 - (~(-(-ExpandableListView.getPackedPositionGroup(0L)))), objArr917);
                String str413 = (String) objArr917[0];
                char keyRepeatTimeout7 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                int i4316 = -(-(ViewConfiguration.getScrollBarSize() >> 8));
                int i4317 = -(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                int i4318 = (i4317 ^ 28) + ((i4317 & 28) << 1);
                Object[] objArr918 = new Object[1];
                b(keyRepeatTimeout7, (i4316 ^ 772) + ((i4316 & 772) << 1), i4318, objArr918);
                String[] strArr34 = {str410, str411, str, str412, str413, (String) objArr918[0]};
                int i4319 = -View.resolveSizeAndState(0, 0, 0);
                int packedPositionChild2 = 799 - ExpandableListView.getPackedPositionChild(0L);
                int i4410 = -ExpandableListView.getPackedPositionGroup(0L);
                int i4411 = (i4410 ^ 11) + ((i4410 & 11) << 1);
                Object[] objArr919 = new Object[1];
                b((char) ((i4319 & 34304) + (i4319 | 34304)), packedPositionChild2, i4411, objArr919);
                String str414 = (String) objArr919[0];
                char keyRepeatTimeout8 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                int maximumDrawingCacheSize8 = ViewConfiguration.getMaximumDrawingCacheSize() >> 24;
                Object[] objArr1010 = new Object[1];
                b(keyRepeatTimeout8, (maximumDrawingCacheSize8 ^ 811) + ((maximumDrawingCacheSize8 & 811) << 1), 8 - (~(-(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)))), objArr1010);
                String str415 = (String) objArr1010[0];
                Object[] objArr1011 = new Object[1];
                b((char) TextUtils.getOffsetAfter(str3, 0), 819 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 5 - (~(-(ViewConfiguration.getEdgeSlop() >> 16))), objArr1011);
                String str416 = (String) objArr1011[0];
                char c110 = (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                int i4412 = -View.MeasureSpec.getMode(0);
                int i4413 = (i4412 ^ 825) + ((i4412 & 825) << 1);
                int i4414 = -((byte) KeyEvent.getModifierMetaStateMask());
                int i4415 = ((i4414 | 5) << 1) - (i4414 ^ 5);
                Object[] objArr1012 = new Object[1];
                b(c110, i4413, i4415, objArr1012);
                String[] strArr110 = {str414, str415, str416, (String) objArr1012[0]};
                char c111 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                int i4416 = -(-(ViewConfiguration.getWindowTouchSlop() >> 8));
                int iRed2 = Color.red(0);
                Object[] objArr1013 = new Object[1];
                b(c111, (i4416 & 831) + (i4416 | 831), (iRed2 & 16) + (iRed2 | 16), objArr1013);
                String str417 = (String) objArr1013[0];
                int i4417 = -ExpandableListView.getPackedPositionType(0L);
                int scrollDefaultDelay5 = ViewConfiguration.getScrollDefaultDelay() >> 16;
                int i4418 = ((scrollDefaultDelay5 | 666) << 1) - (scrollDefaultDelay5 ^ 666);
                int i4419 = -(-(ViewConfiguration.getLongPressTimeout() >> 16));
                int i4510 = (i4419 ^ 7) + ((i4419 & 7) << 1);
                Object[] objArr1014 = new Object[1];
                b((char) ((i4417 ^ 43578) + ((i4417 & 43578) << 1)), i4418, i4510, objArr1014);
                String str418 = (String) objArr1014[0];
                int i4511 = -TextUtils.indexOf((CharSequence) str3, '0', 0);
                int i4512 = -(-(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                int i4513 = (i4512 ^ 633) + ((i4512 & 633) << 1);
                int i4514 = -(-TextUtils.lastIndexOf(str3, '0'));
                int i4515 = (i4514 ^ 9) + ((i4514 & 9) << 1);
                Object[] objArr1015 = new Object[1];
                b((char) ((i4511 ^ 20150) + ((i4511 & 20150) << 1)), i4513, i4515, objArr1015);
                String[] strArr111 = {str417, str418, (String) objArr1015[0]};
                int i4516 = -(-(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                int threadPriority4 = Process.getThreadPriority(0);
                int i4517 = -(((threadPriority4 ^ 20) + ((threadPriority4 & 20) << 1)) >> 6);
                int i4518 = -Color.blue(0);
                int i4519 = (i4518 ^ 14) + ((i4518 & 14) << 1);
                Object[] objArr1016 = new Object[1];
                b((char) ((i4516 ^ (-1)) + (i4516 << 1)), (i4517 ^ 847) + ((i4517 & 847) << 1), i4519, objArr1016);
                String str419 = (String) objArr1016[0];
                int i4610 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                Object[] objArr1017 = new Object[1];
                b((char) (((i4610 | 60757) << 1) - (60757 ^ i4610)), 860 - (~(-(-View.MeasureSpec.getMode(0)))), -TextUtils.lastIndexOf(str3, '0'), objArr1017);
                String[] strArr112 = {str419, (String) objArr1017[0]};
                char defaultSize2 = (char) View.getDefaultSize(0, 0);
                int i4611 = -(ViewConfiguration.getKeyRepeatDelay() >> 16);
                int i4612 = (i4611 ^ 862) + ((i4611 & 862) << 1);
                int i4613 = -(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                int i4614 = (i4613 ^ 10) + ((i4613 & 10) << 1);
                Object[] objArr1018 = new Object[1];
                b(defaultSize2, i4612, i4614, objArr1018);
                String str510 = (String) objArr1018[0];
                Object[] objArr1019 = new Object[1];
                b((char) (22846 - TextUtils.indexOf(str3, str3)), 871 - (~(-(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)))), View.resolveSize(0, 0) + 1, objArr1019);
                String[] strArr113 = {str510, (String) objArr1019[0]};
                char c112 = (char) (0 - (~(-(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)))));
                int i4615 = -(ViewConfiguration.getDoubleTapTimeout() >> 16);
                int i4616 = (i4615 & 872) + (i4615 | 872);
                int i4617 = -(-KeyEvent.normalizeMetaState(0));
                int i4618 = ((i4617 | 16) << 1) - (i4617 ^ 16);
                Object[] objArr1110 = new Object[1];
                b(c112, i4616, i4618, objArr1110);
                String str511 = (String) objArr1110[0];
                int i4619 = -(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                int keyRepeatTimeout9 = ViewConfiguration.getKeyRepeatTimeout() >> 16;
                Object[] objArr1111 = new Object[1];
                b((char) ((i4619 & 41779) + (i4619 | 41779)), (keyRepeatTimeout9 & 714) + (keyRepeatTimeout9 | 714), Color.alpha(0) + 3, objArr1111);
                String str512 = (String) objArr1111[0];
                char c24 = (char) (64330 - (~(-(-(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))));
                int i4710 = -ImageFormat.getBitsPerPixel(0);
                int i4711 = ((i4710 | 658) << 1) - (i4710 ^ 658);
                int i4712 = -AndroidCharacter.getMirror('0');
                int i4713 = (i4712 & 55) + (i4712 | 55);
                Object[] objArr1112 = new Object[1];
                b(c24, i4711, i4713, objArr1112);
                String str513 = (String) objArr1112[0];
                char cMakeMeasureSpec2 = (char) View.MeasureSpec.makeMeasureSpec(0, 0);
                int iIndexOf12 = TextUtils.indexOf(str3, str3, 0);
                Object[] objArr1113 = new Object[1];
                b(cMakeMeasureSpec2, (iIndexOf12 ^ com.salesforce.marketingcloud.analytics.b.q) + ((iIndexOf12 & com.salesforce.marketingcloud.analytics.b.q) << 1), (-41) - (~(-(-AndroidCharacter.getMirror('0')))), objArr1113);
                String str514 = (String) objArr1113[0];
                Object[] objArr1114 = new Object[1];
                b((char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 672 - (~(-(-(KeyEvent.getMaxKeyCode() >> 16)))), 11 - (~(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), objArr1114);
                String str515 = (String) objArr1114[0];
                int doubleTapTimeout4 = ViewConfiguration.getDoubleTapTimeout() >> 16;
                Object[] objArr1115 = new Object[1];
                b((char) ((doubleTapTimeout4 & 23083) + (doubleTapTimeout4 | 23083)), 683 - (~(-(-TextUtils.getTrimmedLength(str3)))), 13 - (~(-Color.red(0))), objArr1115);
                String[] strArr114 = {str511, str512, str513, str514, str515, (String) objArr1115[0]};
                char cLastIndexOf7 = (char) (TextUtils.lastIndexOf(str3, '0', 0, 0) + 1);
                int i4714 = -(-(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)));
                Object[] objArr1116 = new Object[1];
                b(cLastIndexOf7, ((i4714 | 895) << 1) - (i4714 ^ 895), 19 - (~(-(-(ViewConfiguration.getMinimumFlingVelocity() >> 16)))), objArr1116);
                String str516 = (String) objArr1116[0];
                char cLastIndexOf8 = (char) (TextUtils.lastIndexOf(str3, '0', 0) + 1);
                int i4715 = -(-View.resolveSizeAndState(0, 0, 0));
                int i4716 = (i4715 ^ 916) + ((i4715 & 916) << 1);
                int i4717 = -(-(TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)));
                int i4718 = ((i4717 | 19) << 1) - (i4717 ^ 19);
                Object[] objArr1117 = new Object[1];
                b(cLastIndexOf8, i4716, i4718, objArr1117);
                String str517 = (String) objArr1117[0];
                char cIndexOf6 = (char) (TextUtils.indexOf((CharSequence) str3, '0', 0) + 1);
                int i4719 = 934 - (~(-KeyEvent.keyCodeFromString(str3)));
                int iIndexOf13 = TextUtils.indexOf(str3, str3, 0, 0);
                Object[] objArr1118 = new Object[1];
                b(cIndexOf6, i4719, (iIndexOf13 & 31) + (iIndexOf13 | 31), objArr1118);
                String str518 = (String) objArr1118[0];
                char packedPositionGroup8 = (char) ExpandableListView.getPackedPositionGroup(0L);
                int iResolveOpacity3 = Drawable.resolveOpacity(0, 0) + 966;
                int i4810 = -MotionEvent.axisFromString(str3);
                Object[] objArr1119 = new Object[1];
                b(packedPositionGroup8, iResolveOpacity3, (i4810 & 25) + (i4810 | 25), objArr1119);
                String str519 = (String) objArr1119[0];
                int i4811 = -(-(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                int i4812 = -TextUtils.getOffsetAfter(str3, 0);
                int i4813 = ((i4812 | 992) << 1) - (i4812 ^ 992);
                int edgeSlop6 = ViewConfiguration.getEdgeSlop() >> 16;
                int i4814 = (edgeSlop6 ^ 23) + ((edgeSlop6 & 23) << 1);
                Object[] objArr1210 = new Object[1];
                b((char) ((i4811 & 19208) + (i4811 | 19208)), i4813, i4814, objArr1210);
                String str65 = (String) objArr1210[0];
                char c25 = (char) (20520 - (~(-(-(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))));
                int i4815 = -(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                int iITrustedWebActivityCallbackStub11 = JwtEcdsaAlgorithm.AnonymousClass1.ITrustedWebActivityCallbackStub();
                int i4816 = (i4815 * TypedValues.Custom.TYPE_DIMENSION) - 916545;
                int i4817 = ~i4815;
                int i4818 = ~((i4817 ^ iITrustedWebActivityCallbackStub11) | (i4817 & iITrustedWebActivityCallbackStub11));
                int i4819 = ~iITrustedWebActivityCallbackStub11;
                int i4910 = ~((i4819 & PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW) | (i4819 ^ PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW));
                int i4911 = ((i4910 & i4818) | (i4818 ^ i4910)) * (-1808);
                int i4912 = ((i4816 | i4911) << 1) - (i4816 ^ i4911);
                int i4913 = (i4817 ^ (-1016)) | (i4817 & (-1016));
                int i4914 = ~((i4913 & iITrustedWebActivityCallbackStub11) | (i4913 ^ iITrustedWebActivityCallbackStub11));
                int i4915 = (i4819 ^ i4815) | (i4819 & i4815);
                int i4916 = ~((i4915 & PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW) | (i4915 ^ PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW));
                int i4917 = ((i4914 & i4916) | (i4914 ^ i4916)) * TypedValues.Custom.TYPE_BOOLEAN;
                int i4918 = (i4912 & i4917) + (i4917 | i4912);
                int i4919 = ~((~i4815) | PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW);
                int i5010 = ~(((-1016) & iITrustedWebActivityCallbackStub11) | ((-1016) ^ iITrustedWebActivityCallbackStub11));
                int i5011 = (i4919 & i5010) | (i4919 ^ i5010);
                int i5012 = ~(i4815 | (~iITrustedWebActivityCallbackStub11));
                int i5013 = ((i5012 & i5011) | (i5011 ^ i5012)) * TypedValues.Custom.TYPE_BOOLEAN;
                Object[] objArr1211 = new Object[1];
                b(c25, ((i4918 | i5013) << 1) - (i5013 ^ i4918), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 32, objArr1211);
                String[] strArr115 = {str516, str517, str518, str519, str65, (String) objArr1211[0], str};
                char scrollDefaultDelay6 = (char) (52931 - (ViewConfiguration.getScrollDefaultDelay() >> 16));
                int i5014 = 1047 - (~(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)));
                int i5015 = -KeyEvent.normalizeMetaState(0);
                Object[] objArr1212 = new Object[1];
                b(scrollDefaultDelay6, i5014, (i5015 & 13) + (i5015 | 13), objArr1212);
                String str66 = (String) objArr1212[0];
                Object[] objArr1213 = new Object[1];
                b((char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), 626 - (~Gravity.getAbsoluteGravity(0, 0)), 5 - (~(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), objArr1213);
                String[] strArr116 = {str66, (String) objArr1213[0]};
                int i5016 = -(ViewConfiguration.getScrollBarFadeDuration() >> 16);
                int iMyTid4 = 1061 - (Process.myTid() >> 22);
                int i5017 = -ExpandableListView.getPackedPositionType(0L);
                int i5018 = ((i5017 | 30) << 1) - (i5017 ^ 30);
                Object[] objArr1214 = new Object[1];
                b((char) (((i5016 | 64830) << 1) - (i5016 ^ 64830)), iMyTid4, i5018, objArr1214);
                String str67 = (String) objArr1214[0];
                char cCombineMeasuredStates4 = (char) (2408 - View.combineMeasuredStates(0, 0));
                int i5019 = -TextUtils.lastIndexOf(str3, '0', 0, 0);
                Object[] objArr1215 = new Object[1];
                b(cCombineMeasuredStates4, (i5019 ^ 1090) + ((i5019 & 1090) << 1), 10 - (~(-(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)))), objArr1215);
                String[] strArr117 = {str67, (String) objArr1215[0]};
                int i5110 = -KeyEvent.keyCodeFromString(str3);
                int fadingEdgeLength6 = ViewConfiguration.getFadingEdgeLength() >> 16;
                Object[] objArr1216 = new Object[1];
                b((char) ((i5110 & 55353) + (i5110 | 55353)), ((fadingEdgeLength6 | 1102) << 1) - (fadingEdgeLength6 ^ 1102), 18 - (~(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))), objArr1216);
                String str68 = (String) objArr1216[0];
                Object[] objArr1217 = new Object[1];
                b((char) (Color.green(0) + 54140), 1121 - View.MeasureSpec.makeMeasureSpec(0, 0), TextUtils.lastIndexOf(str3, '0', 0) + 6, objArr1217);
                String[] strArr118 = {str68, (String) objArr1217[0]};
                int i5111 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                int i5112 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                int i5113 = (i5112 ^ 1126) + ((i5112 & 1126) << 1);
                int i5114 = -AndroidCharacter.getMirror('0');
                int i5115 = ((i5114 | 67) << 1) - (i5114 ^ 67);
                Object[] objArr1218 = new Object[1];
                b((char) ((i5111 & 25207) + (i5111 | 25207)), i5113, i5115, objArr1218);
                String[] strArr119 = {(String) objArr1218[0]};
                char size3 = (char) View.MeasureSpec.getSize(0);
                int i5116 = 1144 - (~(-(ViewConfiguration.getMinimumFlingVelocity() >> 16)));
                int i5117 = -(-Color.blue(0));
                Object[] objArr1219 = new Object[1];
                b(size3, i5116, (i5117 & 16) + (i5117 | 16), objArr1219);
                String[] strArr210 = {(String) objArr1219[0]};
                int i5118 = -(-Color.argb(0, 0, 0, 0));
                int i5119 = 1160 - (~(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)));
                int i5210 = -(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                Object[] objArr1310 = new Object[1];
                b((char) (((i5118 | 29967) << 1) - (i5118 ^ 29967)), i5119, (i5210 & 20) + (i5210 | 20), objArr1310);
                String[] strArr211 = {(String) objArr1310[0]};
                char scrollBarSize2 = (char) (ViewConfiguration.getScrollBarSize() >> 8);
                int maximumFlingVelocity3 = ViewConfiguration.getMaximumFlingVelocity() >> 16;
                Object[] objArr1311 = new Object[1];
                b(scrollBarSize2, ((maximumFlingVelocity3 | 1180) << 1) - (maximumFlingVelocity3 ^ 1180), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 18, objArr1311);
                String[] strArr212 = {(String) objArr1311[0]};
                int iIndexOf14 = TextUtils.indexOf((CharSequence) str3, '0', 0);
                int i5211 = -(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                Object[] objArr1312 = new Object[1];
                b((char) ((iIndexOf14 & 1) + (iIndexOf14 | 1)), (i5211 ^ 1199) + ((i5211 & 1199) << 1), 22 - (~(ViewConfiguration.getPressedStateDuration() >> 16)), objArr1312);
                String[] strArr213 = {(String) objArr1312[0]};
                int longPressTimeout3 = ViewConfiguration.getLongPressTimeout() >> 16;
                int i5212 = -(ViewConfiguration.getWindowTouchSlop() >> 8);
                int i5213 = (i5212 ^ 1222) + ((i5212 & 1222) << 1);
                int i5214 = -(ViewConfiguration.getMaximumFlingVelocity() >> 16);
                int i5215 = (i5214 & 21) + (i5214 | 21);
                Object[] objArr1313 = new Object[1];
                b((char) ((longPressTimeout3 ^ 61636) + ((longPressTimeout3 & 61636) << 1)), i5213, i5215, objArr1313);
                String[] strArr214 = {(String) objArr1313[0]};
                char c26 = (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                int i5216 = -KeyEvent.getDeadChar(0, 0);
                int i5217 = (i5216 ^ 1243) + ((i5216 & 1243) << 1);
                int i5218 = -TextUtils.indexOf(str3, str3);
                int i5219 = (i5218 ^ 24) + ((i5218 & 24) << 1);
                Object[] objArr1314 = new Object[1];
                b(c26, i5217, i5219, objArr1314);
                String str69 = str;
                String[] strArr215 = {(String) objArr1314[0], str69};
                char edgeSlop7 = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                int i5310 = -(ViewConfiguration.getTapTimeout() >> 16);
                Object[] objArr1315 = new Object[1];
                b(edgeSlop7, ((i5310 | 1267) << 1) - (i5310 ^ 1267), 28 - (~(-(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)))), objArr1315);
                String[] strArr216 = {(String) objArr1315[0], str69};
                Object[] objArr1316 = new Object[1];
                b((char) (34911 - View.resolveSizeAndState(0, 0, 0)), TextUtils.indexOf((CharSequence) str3, '0', 0, 0) + 1296, View.resolveSizeAndState(0, 0, 0) + 27, objArr1316);
                String[] strArr217 = {(String) objArr1316[0], str69};
                int i5311 = -(ViewConfiguration.getMaximumFlingVelocity() >> 16);
                int i5312 = 1322 - (~(-(-TextUtils.indexOf((CharSequence) str3, '0', 0, 0))));
                int iCombineMeasuredStates2 = View.combineMeasuredStates(0, 0);
                int i5313 = ((iCombineMeasuredStates2 | 31) << 1) - (iCombineMeasuredStates2 ^ 31);
                Object[] objArr1317 = new Object[1];
                b((char) ((i5311 ^ 29072) + ((i5311 & 29072) << 1)), i5312, i5313, objArr1317);
                String[] strArr218 = {(String) objArr1317[0], str69};
                int i5314 = -((Process.getThreadPriority(0) + 20) >> 6);
                int i5315 = 1352 - (~(-(-Color.red(0))));
                int i5316 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                Object[] objArr1318 = new Object[1];
                b((char) ((i5314 & 42986) + (i5314 | 42986)), i5315, (i5316 & 26) + (i5316 | 26), objArr1318);
                String[] strArr219 = {(String) objArr1318[0], str69};
                int i5317 = -(ViewConfiguration.getPressedStateDuration() >> 16);
                int i5318 = -ImageFormat.getBitsPerPixel(0);
                int i5319 = ((i5318 | 1379) << 1) - (i5318 ^ 1379);
                int i5410 = -(-Process.getGidForName(str3));
                int i5411 = (i5410 ^ 33) + ((i5410 & 33) << 1);
                Object[] objArr1319 = new Object[1];
                b((char) ((i5317 ^ 61918) + ((i5317 & 61918) << 1)), i5319, i5411, objArr1319);
                strArr = new String[][]{strArr32, strArr33, strArr34, strArr110, strArr111, strArr112, strArr113, strArr114, strArr115, strArr116, strArr117, strArr118, strArr119, strArr210, strArr211, strArr212, strArr213, strArr214, strArr215, strArr216, strArr217, strArr218, strArr219, new String[]{(String) objArr1319[0], str69}};
                arrayList = new ArrayList();
                i17 = i;
                i18 = 0;
                i19 = 0;
                while (i18 < 24) {
                    String[] strArr35 = strArr[i18];
                    Object[] objArr143 = {strArr35[0]};
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                    if (objAccessartificialFrame2 == null) {
                        int iIndexOf15 = 23 - TextUtils.indexOf(str3, str3, 0);
                        char c27 = (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                        int keyRepeatTimeout10 = 2441 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                        byte[] bArr14 = $$a;
                        Object[] objArr144 = new Object[1];
                        a(bArr14[20], (byte) ($$b | 49), bArr14[13], objArr144);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iIndexOf15, c27, keyRepeatTimeout10, 954751276, false, (String) objArr144[0], new Class[]{String.class});
                    }
                    str6 = (String) ((Method) objAccessartificialFrame2).invoke(null, objArr143);
                    String[] strArr36 = (String[]) Arrays.copyOfRange(strArr35, 1, strArr35.length);
                    if (str6 == null) {
                    }
                    i18++;
                    strArr = strArr;
                    str3 = str3;
                }
                str5 = str3;
                if (i19 > 2) {
                    objArr = new Object[]{arrayList, new int[]{i555}, null, new int[]{i}, new int[]{i17}};
                    int i5510 = (-2132968639) + (((~((-496003489) | i)) | (~(109444969 | i142))) * (-1808)) + (((~((-75524385) | i)) | (~(529924073 | i142))) * TypedValues.Custom.TYPE_BOOLEAN) + (((~((-109444970) | i)) | 420479104 | (~(496003488 | i142))) * TypedValues.Custom.TYPE_BOOLEAN);
                    int i5511 = i5510 << 13;
                    int i5512 = (i5511 | i5510) & (~(i5510 & i5511));
                    int i5513 = i5512 ^ (i5512 >>> 17);
                    int i5514 = i5513 << 5;
                    int i5515 = ((~i5513) & i5514) | ((~i5514) & i5513);
                    i20 = 0;
                } else {
                    objArr = new Object[]{null, new int[]{i560}, null, new int[]{i}, new int[]{i}};
                    int i5516 = (-2115839000) + (((~((-417310351) | i)) | 135692810) * 345) + (((~((-417310351) | i142)) | 52445297) * 345) + ((~((-135692811) | i)) * 345);
                    int i5517 = (i5516 << 13) ^ i5516;
                    int i5518 = i5517 ^ (i5517 >>> 17);
                    int i5519 = i5518 << 5;
                    int i5610 = (i5518 | i5519) & (~(i5518 & i5519));
                    i20 = 0;
                }
                i21 = ((int[]) objArr[4])[i20];
                if (i21 != i) {
                    objArr2 = new Object[5];
                    objArr2[1] = new int[1];
                    int[] iArr4 = new int[1];
                    objArr2[3] = iArr4;
                    int[] iArr5 = new int[1];
                    objArr2[4] = iArr5;
                    List list2 = (List) objArr[i20];
                    iArr4[i20] = i;
                    iArr5[i20] = i21;
                    objArr2[i20] = list2;
                    objArr2[2] = null;
                    int i5611 = (-637919239) + (((~(334627192 | i142)) | (-1006267387) | (~(i142 | 940075650))) * 464) + (((-671640195) | i) * (-464)) + (((~(i | 940075650)) | (-1006267387)) * 464);
                    int iITrustedWebActivityCallbackStub12 = JwtEcdsaAlgorithm.AnonymousClass1.ITrustedWebActivityCallbackStub();
                    int i5612 = ((5872 + (i5611 * 367)) - (~((i5611 | 16) * (-366)))) - 1;
                    int i5613 = ~i5611;
                    int i5614 = ~((i5613 ^ iITrustedWebActivityCallbackStub12) | (i5613 & iITrustedWebActivityCallbackStub12));
                    int i5615 = (i5612 - (~(((i5614 & 16) | (i5614 ^ 16)) * (-366)))) - 1;
                    int i5616 = ~(((-17) & i5611) | ((-17) ^ i5611));
                    int i5617 = (i5613 & 16) | (i5613 ^ 16);
                    int i5618 = ~((iITrustedWebActivityCallbackStub12 & i5617) | (i5617 ^ iITrustedWebActivityCallbackStub12));
                    int i5619 = ((i5618 & i5616) | (i5616 ^ i5618)) * 366;
                    int i576 = ((i5615 | i5619) << 1) - (i5619 ^ i5615);
                    int i577 = (i3 & i576) + (i576 | i3);
                    int i578 = i577 ^ (i577 << 13);
                    int i579 = i578 >>> 17;
                    int i5710 = (i578 | i579) & (~(i578 & i579));
                    int i5711 = i5710 << 5;
                    ((int[]) objArr2[1])[0] = ((~i5710) & i5711) | ((~i5711) & i5710);
                } else {
                    i22 = i3;
                    i23 = 1;
                }
            }
            char packedPositionChild3 = (char) ((-1) - ExpandableListView.getPackedPositionChild(0L));
            int bitsPerPixel2 = ImageFormat.getBitsPerPixel(i20);
            Object[] objArr145 = new Object[i23];
            b(packedPositionChild3, ((bitsPerPixel2 | 699) << i23) - (bitsPerPixel2 ^ 699), (-16777201) - (~(-Color.rgb(i20, i20, i20))), objArr145);
            Object[] objArr146 = {(String) objArr145[i20]};
            Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-1483923676);
            if (objAccessartificialFrame17 == null) {
                int i580 = 24 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                char bitsPerPixel3 = (char) ((-1) - ImageFormat.getBitsPerPixel(0));
                int maxKeyCode2 = (KeyEvent.getMaxKeyCode() >> 16) + 2441;
                byte[] bArr15 = $$a;
                Object[] objArr147 = new Object[1];
                a(bArr15[20], (byte) ($$b | 49), bArr15[13], objArr147);
                objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(i580, bitsPerPixel3, maxKeyCode2, 954751276, false, (String) objArr147[0], new Class[]{String.class});
            }
            Object objInvoke2 = ((Method) objAccessartificialFrame17).invoke(null, objArr146);
            if (objInvoke2 == null) {
                int i581 = artificialFrame + 19;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i581 % 128;
                int i582 = i581 % 2;
                i25 = 0;
            } else {
                int i583 = artificialFrame + 79;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i583 % 128;
                int i584 = i583 % 2;
                Object[] objArr148 = {objInvoke2, 42};
                Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-287841710);
                if (objAccessartificialFrame18 == null) {
                    int threadPriority5 = ((Process.getThreadPriority(0) + 20) >> 6) + 20;
                    char pressedStateDuration2 = (char) (ViewConfiguration.getPressedStateDuration() >> 16);
                    int defaultSize3 = 2245 - View.getDefaultSize(0, 0);
                    byte[] bArr16 = $$a;
                    Object[] objArr149 = new Object[1];
                    a(bArr16[1], (byte) ($$b | 12), bArr16[13], objArr149);
                    objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(threadPriority5, pressedStateDuration2, defaultSize3, 1907532890, false, (String) objArr149[0], new Class[]{String.class, Integer.TYPE});
                }
                long jLongValue10 = ((Long) ((Method) objAccessartificialFrame18).invoke(null, objArr148)).longValue();
                long j68 = 1214285163;
                long j69 = (((long) (-665)) * j68) + (((long) 334) * jLongValue10);
                long j70 = j68 ^ j23;
                long j71 = 333;
                long j72 = j69 + (((long) (-333)) * j70) + ((((j70 | j34) ^ j23) | ((jLongValue10 | j33) ^ j23)) * j71) + (j71 * (((j34 | jLongValue10) ^ j23) | ((j70 | j33) ^ j23))) + ((long) 418800165);
                int iMyPid4 = Process.myPid();
                int i585 = ((int) (j72 >> 32)) & ((((~((-1935558488) | iMyPid4)) | 286408964) * (-566)) + 335942786 + ((~(iMyPid4 | (-1649149524))) * 566));
                int i586 = ~(1752214108 | i);
                i25 = i585 | (((int) j72) & (1462431404 + ((25449889 | i586) * (-814)) + ((i586 | (~((-1105526778) | i142)) | 672137220) * 407) + (((~((-1752214109) | i)) | 672137220 | (~(1105526777 | i))) * 407)));
            }
            if (i25 == 1986687685 || i25 == -1514516938) {
                str7 = str5;
            } else {
                char scrollDefaultDelay7 = (char) (ViewConfiguration.getScrollDefaultDelay() >> 16);
                int fadingEdgeLength7 = ViewConfiguration.getFadingEdgeLength() >> 16;
                int i587 = (fadingEdgeLength7 & 1413) + (fadingEdgeLength7 | 1413);
                int gidForName3 = Process.getGidForName(str5);
                int iITrustedWebActivityCallbackStub13 = JwtEcdsaAlgorithm.AnonymousClass1.ITrustedWebActivityCallbackStub();
                int i588 = gidForName3 * (-183);
                int i589 = (i588 ^ 2775) + ((i588 & 2775) << 1);
                int i590 = ~gidForName3;
                int i591 = ~(i590 | 15);
                int i592 = ~iITrustedWebActivityCallbackStub13;
                int i593 = ~((i592 ^ 15) | (i592 & 15));
                int i594 = -(-(((i591 & i593) | (i591 ^ i593)) * SyslogConstants.LOG_LOCAL7));
                int i595 = ~((gidForName3 & (-16)) | ((-16) ^ gidForName3));
                int i596 = (((i589 ^ i594) + ((i589 & i594) << 1)) - (~(-(-(((i595 & iITrustedWebActivityCallbackStub13) | (iITrustedWebActivityCallbackStub13 ^ i595)) * (-184)))))) - 1;
                int i597 = -(-((~(i590 | i592)) * SyslogConstants.LOG_LOCAL7));
                int i598 = ((i596 | i597) << 1) - (i597 ^ i596);
                Object[] objArr150 = new Object[1];
                b(scrollDefaultDelay7, i587, i598, objArr150);
                String str70 = (String) objArr150[0];
                char maxKeyCode3 = (char) (KeyEvent.getMaxKeyCode() >> 16);
                int edgeSlop8 = (ViewConfiguration.getEdgeSlop() >> 16) + 1427;
                str7 = str5;
                int iIndexOf16 = TextUtils.indexOf((CharSequence) str7, '0');
                int i599 = iIndexOf16 * (-830);
                int i600 = ((i599 | 22464) << 1) - (i599 ^ 22464);
                int i601 = ~(((-28) & i142) | ((-28) ^ i142));
                int i602 = (iIndexOf16 ^ 27) | (iIndexOf16 & 27);
                int i603 = ~((i602 & i) | (i602 ^ i));
                int i604 = (i600 - (~(((i601 & i603) | (i601 ^ i603)) * (-831)))) - 1;
                int i605 = ((-28) & iIndexOf16) | ((-28) ^ iIndexOf16);
                int i606 = i604 + ((~((i605 & i) | (i605 ^ i))) * (-1662));
                int i607 = ~iIndexOf16;
                int i608 = (~((i607 & i265) | (i607 ^ i265))) | (~((iIndexOf16 & i) | (iIndexOf16 ^ i)));
                int i609 = ~((i ^ 27) | (i & 27));
                int i610 = -(-(((i608 & i609) | (i608 ^ i609)) * 831));
                int i611 = (i606 ^ i610) + ((i610 & i606) << 1);
                Object[] objArr151 = new Object[1];
                b(maxKeyCode3, edgeSlop8, i611, objArr151);
                String str71 = (String) objArr151[0];
                char threadPriority6 = (char) ((Process.getThreadPriority(0) + 20) >> 6);
                int iLastIndexOf4 = TextUtils.lastIndexOf(str7, '0', 0, 0);
                Object[] objArr152 = new Object[1];
                b(threadPriority6, (iLastIndexOf4 ^ 1454) + ((iLastIndexOf4 & 1454) << 1), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 17, objArr152);
                String str72 = (String) objArr152[0];
                char size4 = (char) View.MeasureSpec.getSize(0);
                int capsMode = TextUtils.getCapsMode(str7, 0, 0);
                int i612 = ((capsMode | 1470) << 1) - (capsMode ^ 1470);
                int i613 = -(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                int i614 = ((i613 | 17) << 1) - (i613 ^ 17);
                Object[] objArr153 = new Object[1];
                b(size4, i612, i614, objArr153);
                String str73 = (String) objArr153[0];
                char cLastIndexOf9 = (char) (TextUtils.lastIndexOf(str7, '0') + 1);
                int iResolveSize3 = View.resolveSize(0, 0) + 1487;
                int i615 = -TextUtils.getOffsetBefore(str7, 0);
                Object[] objArr154 = new Object[1];
                b(cLastIndexOf9, iResolveSize3, (i615 & 15) + (i615 | 15), objArr154);
                String str74 = (String) objArr154[0];
                int i616 = -(ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                int i617 = -(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                int i618 = (i617 & 1503) + (i617 | 1503);
                int i619 = -(-(ViewConfiguration.getDoubleTapTimeout() >> 16));
                Object[] objArr155 = new Object[1];
                b((char) ((i616 & 43608) + (i616 | 43608)), i618, (i619 & 37) + (i619 | 37), objArr155);
                String str75 = (String) objArr155[0];
                char cResolveSize = (char) View.resolveSize(0, 0);
                int i620 = -(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                Object[] objArr156 = new Object[1];
                b(cResolveSize, (i620 ^ 1540) + ((i620 & 1540) << 1), TextUtils.indexOf((CharSequence) str7, '0', 0) + 13, objArr156);
                String str76 = (String) objArr156[0];
                char gidForName4 = (char) (38279 - Process.getGidForName(str7));
                int defaultSize4 = View.getDefaultSize(0, 0);
                int iITrustedWebActivityCallbackStub14 = JwtEcdsaAlgorithm.AnonymousClass1.ITrustedWebActivityCallbackStub();
                int i621 = ~((-1552) | iITrustedWebActivityCallbackStub14);
                int i622 = ~(defaultSize4 | 1551);
                int i623 = (((defaultSize4 * (-501)) + 780153) - (~(((i621 & i622) | (i621 ^ i622)) * (-502)))) - 1;
                int i624 = ~iITrustedWebActivityCallbackStub14;
                int i625 = (i624 & (-1552)) | ((-1552) ^ i624);
                int i626 = -(-((~((i625 & defaultSize4) | (i625 ^ defaultSize4))) * (-502)));
                int i627 = (i623 & i626) + (i623 | i626);
                int i628 = ((~(iITrustedWebActivityCallbackStub14 | (~defaultSize4))) | (-1552)) * TypedValues.PositionType.TYPE_DRAWPATH;
                int i629 = (i627 & i628) + (i628 | i627);
                int jumpTapTimeout4 = ViewConfiguration.getJumpTapTimeout() >> 16;
                int i630 = (jumpTapTimeout4 ^ 13) + ((jumpTapTimeout4 & 13) << 1);
                Object[] objArr157 = new Object[1];
                b(gidForName4, i629, i630, objArr157);
                String str77 = (String) objArr157[0];
                int windowTouchSlop4 = ViewConfiguration.getWindowTouchSlop() >> 8;
                int packedPositionGroup9 = 1564 - ExpandableListView.getPackedPositionGroup(0L);
                int doubleTapTimeout5 = ViewConfiguration.getDoubleTapTimeout() >> 16;
                Object[] objArr158 = new Object[1];
                b((char) ((windowTouchSlop4 & 50905) + (windowTouchSlop4 | 50905)), packedPositionGroup9, (doubleTapTimeout5 & 22) + (doubleTapTimeout5 | 22), objArr158);
                String str78 = (String) objArr158[0];
                char mode2 = (char) View.MeasureSpec.getMode(0);
                int i631 = -Color.red(0);
                int i632 = (i631 & 1586) + (i631 | 1586);
                int i633 = -(-KeyEvent.getDeadChar(0, 0));
                int i634 = (i633 ^ 31) + ((i633 & 31) << 1);
                Object[] objArr159 = new Object[1];
                b(mode2, i632, i634, objArr159);
                String str79 = (String) objArr159[0];
                char keyRepeatTimeout11 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                int iRgb2 = Color.rgb(0, 0, 0) + 16778833;
                int i635 = -((byte) KeyEvent.getModifierMetaStateMask());
                Object[] objArr160 = new Object[1];
                b(keyRepeatTimeout11, iRgb2, (i635 & 11) + (i635 | 11), objArr160);
                String str80 = (String) objArr160[0];
                int i636 = -ExpandableListView.getPackedPositionChild(0L);
                char c28 = (char) ((i636 ^ (-1)) + (i636 << 1));
                int mode3 = View.MeasureSpec.getMode(0) + 1629;
                int i637 = -(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                int i638 = (i637 ^ 12) + ((i637 & 12) << 1);
                Object[] objArr161 = new Object[1];
                b(c28, mode3, i638, objArr161);
                String str81 = (String) objArr161[0];
                int pressedStateDuration3 = ViewConfiguration.getPressedStateDuration() >> 16;
                int i639 = (pressedStateDuration3 * (-344)) - 11355096;
                int i640 = ~pressedStateDuration3;
                int i641 = ~((i640 ^ (-33010)) | (i640 & (-33010)));
                int i642 = ~(i640 | i);
                int i643 = ((i641 & i642) | (i641 ^ i642)) * 345;
                int i644 = (i639 ^ i643) + ((i639 & i643) << 1);
                int i645 = ~pressedStateDuration3;
                int i646 = ~((i645 & i265) | (i645 ^ i265));
                int i647 = ~(pressedStateDuration3 | (-33010));
                int i648 = i644 + (((i647 & i646) | (i646 ^ i647)) * 345);
                int i649 = (i640 ^ (-33010)) | (i640 & (-33010));
                int i650 = -(-((~((i649 & i) | (i649 ^ i))) * 345));
                Object[] objArr162 = new Object[1];
                b((char) (((i648 | i650) << 1) - (i650 ^ i648)), 1641 - TextUtils.indexOf(str7, str7, 0), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 12, objArr162);
                String str82 = (String) objArr162[0];
                char c29 = (char) (0 - (~((byte) KeyEvent.getModifierMetaStateMask())));
                int i651 = -TextUtils.indexOf((CharSequence) str7, '0');
                int i652 = (i651 ^ 1652) + ((i651 & 1652) << 1);
                int i653 = -TextUtils.getOffsetBefore(str7, 0);
                int i654 = (i653 ^ 12) + ((i653 & 12) << 1);
                Object[] objArr163 = new Object[1];
                b(c29, i652, i654, objArr163);
                String str83 = (String) objArr163[0];
                int i655 = -TextUtils.indexOf((CharSequence) str7, '0');
                int i656 = -(-(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                int i657 = (i656 ^ 1664) + ((i656 & 1664) << 1);
                int i658 = -(ViewConfiguration.getMaximumFlingVelocity() >> 16);
                int i659 = (i658 ^ 12) + ((i658 & 12) << 1);
                Object[] objArr164 = new Object[1];
                b((char) ((i655 & 32099) + (i655 | 32099)), i657, i659, objArr164);
                String str84 = (String) objArr164[0];
                char edgeSlop9 = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                int i660 = 1676 - (~(-(-View.resolveSizeAndState(0, 0, 0))));
                int i661 = -View.MeasureSpec.getMode(0);
                int i662 = (i661 ^ 14) + ((i661 & 14) << 1);
                Object[] objArr165 = new Object[1];
                b(edgeSlop9, i660, i662, objArr165);
                String str85 = (String) objArr165[0];
                int i663 = -(-(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)));
                Object[] objArr166 = new Object[1];
                b((char) ((i663 ^ 12577) + ((i663 & 12577) << 1)), 1690 - (~(-TextUtils.getCapsMode(str7, 0, 0))), TextUtils.indexOf((CharSequence) str7, '0') + 13, objArr166);
                String str86 = (String) objArr166[0];
                int defaultSize5 = View.getDefaultSize(0, 0);
                int i664 = 1703 - (~(-(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))));
                int i665 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                int i666 = (i665 ^ 24) + ((i665 & 24) << 1);
                Object[] objArr167 = new Object[1];
                b((char) ((defaultSize5 & 54179) + (defaultSize5 | 54179)), i664, i666, objArr167);
                String str87 = (String) objArr167[0];
                char c30 = (char) (43966 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
                int iAxisFromString5 = 1726 - MotionEvent.axisFromString(str7);
                int i667 = -TextUtils.lastIndexOf(str7, '0', 0, 0);
                int i668 = (i667 ^ 27) + ((i667 & 27) << 1);
                Object[] objArr168 = new Object[1];
                b(c30, iAxisFromString5, i668, objArr168);
                String[] strArr37 = {str70, str71, str72, str73, str74, str75, str76, str77, str78, str79, str80, str81, str82, str83, str84, str85, str86, str87, (String) objArr168[0]};
                int i669 = 0;
                while (true) {
                    if (i669 >= 19) {
                        i669 = -1;
                        break;
                    }
                    String str88 = strArr37[i669];
                    Object[] objArr169 = {str88};
                    Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-11453480);
                    if (objAccessartificialFrame19 == null) {
                        int iRgb3 = Color.rgb(0, 0, 0) + 16777233;
                        char cNormalizeMetaState = (char) (24343 - KeyEvent.normalizeMetaState(0));
                        int i670 = 2015 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                        byte[] bArr17 = $$a;
                        byte b8 = bArr17[18];
                        Object[] objArr170 = new Object[1];
                        a(b8, (byte) (b8 - 1), bArr17[8], objArr170);
                        objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(iRgb3, cNormalizeMetaState, i670, 1614052816, false, (String) objArr170[0], new Class[]{String.class});
                    }
                    long jLongValue11 = ((Long) ((Method) objAccessartificialFrame19).invoke(null, objArr169)).longValue();
                    long j73 = -507198660;
                    long j74 = 399;
                    long j75 = (j74 * j73) + (j74 * jLongValue11);
                    long j76 = 398;
                    long j77 = ((j73 ^ j23) | jLongValue11) ^ j23;
                    long j78 = jLongValue11 ^ j23;
                    long j79 = (j78 | j73) ^ j23;
                    String[] strArr38 = strArr37;
                    long j80 = j75 + ((j77 | j79 | ((j78 | j33) ^ j23)) * j76) + (((long) (-1194)) * (jLongValue11 | j73)) + (j76 * (((j78 | j34) ^ j23) | j77 | j79)) + ((long) 2069329697);
                    int i671 = ((int) (j80 >> 32)) & ((-818884594) + ((46832128 | i142) * 1324) + (((~(47102856 | i)) | (~(1390123554 | i))) * (-1324)) + 379915676);
                    int iMyPid5 = Process.myPid();
                    int i672 = 167378231 + (((~((-1147763491) | iMyPid5)) | (-1709977396)) * (-318));
                    int i673 = ~((-1709977396) | iMyPid5);
                    int i674 = ~iMyPid5;
                    if ((i671 | (((int) j80) & (i672 + ((i673 | (~(1710063411 | i674))) * TypedValues.AttributesType.TYPE_PIVOT_TARGET) + (((~(iMyPid5 | 1710063411)) | (~((-562299922) | i674))) * TypedValues.AttributesType.TYPE_PIVOT_TARGET)))) != 0) {
                        break;
                    }
                    char cResolveSize2 = (char) View.resolveSize(0, 0);
                    int iLastIndexOf5 = 1676 - TextUtils.lastIndexOf(str7, '0');
                    int i675 = -(ViewConfiguration.getLongPressTimeout() >> 16);
                    int i676 = (i675 ^ 14) + ((i675 & 14) << 1);
                    Object[] objArr171 = new Object[1];
                    b(cResolveSize2, iLastIndexOf5, i676, objArr171);
                    if (str88.equals((String) objArr171[0])) {
                        Object[] objArr172 = {str88};
                        Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(479197382);
                        if (objAccessartificialFrame20 == null) {
                            int iIndexOf17 = 16 - TextUtils.indexOf((CharSequence) str7, '0', 0);
                            char cNormalizeMetaState2 = (char) (KeyEvent.normalizeMetaState(0) + 24343);
                            int iNormalizeMetaState = 2014 - KeyEvent.normalizeMetaState(0);
                            byte[] bArr18 = $$a;
                            byte b9 = bArr18[7];
                            Object[] objArr173 = new Object[1];
                            a(b9, (byte) (b9 - 3), bArr18[8], objArr173);
                            objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(iIndexOf17, cNormalizeMetaState2, iNormalizeMetaState, -2081767730, false, (String) objArr173[0], new Class[]{String.class});
                        }
                        long jLongValue12 = ((Long) ((Method) objAccessartificialFrame20).invoke(null, objArr172)).longValue();
                        long j81 = -82048755;
                        long j82 = (((long) (-419)) * j81) + (((long) 421) * jLongValue12);
                        long j83 = TypedValues.CycleType.TYPE_EASING;
                        long j84 = j81 ^ j23;
                        long j85 = j82 + (((jLongValue12 | j33) ^ j23) * j83) + (((long) (-420)) * (jLongValue12 | j84)) + (j83 * (((j34 | jLongValue12) ^ j23) | ((j84 | (jLongValue12 ^ j23)) ^ j23))) + ((long) 578660146);
                        int i677 = ~(499376006 | i142);
                        int i678 = ((int) (j85 >> 32)) & (((289543424 | i677 | (~((-499376007) | i))) * (-338)) + 518655914 + ((i677 | (~((-209832583) | i))) * 338));
                        int i679 = ((int) j85) & (265417846 + (((~(i142 | (-753222018))) | (-684004393)) * (-1042)) + (((-753222018) | i) * 521) + (((~(684004392 | i)) | (-753227178) | (~((-683999233) | i142))) * 521));
                        if (((i678 & i679) | (i678 ^ i679)) != 0) {
                            break;
                        }
                    }
                    i669++;
                    strArr37 = strArr38;
                }
                if (i669 >= 0) {
                    int iITrustedWebActivityCallbackStub15 = JwtEcdsaAlgorithm.AnonymousClass1.ITrustedWebActivityCallbackStub();
                    int i680 = 39259 - (~(-(-(i669 * TypedValues.MotionType.TYPE_EASING))));
                    int i681 = ~iITrustedWebActivityCallbackStub15;
                    int i682 = ~(((-131) ^ i681) | ((-131) & i681));
                    int i683 = -(-(((i682 & i669) | (i669 ^ i682)) * (-602)));
                    int i684 = (i680 ^ i683) + ((i680 & i683) << 1);
                    int i685 = ~((-131) | (~i669));
                    int i686 = ~((iITrustedWebActivityCallbackStub15 & (-131)) | ((-131) ^ iITrustedWebActivityCallbackStub15));
                    int i687 = (i686 & i685) | (i685 ^ i686);
                    int i688 = (i681 ^ 130) | (i681 & 130);
                    int i689 = ~((i688 & i669) | (i688 ^ i669));
                    int i690 = ((i687 & i689) | (i687 ^ i689)) * (-301);
                    int i691 = ((((i684 | i690) << 1) - (i690 ^ i684)) - (~(-(-((~((i681 ^ i669) | (i681 & i669))) * 301))))) - 1;
                    int i692 = ((~i691) & i) | (i691 & i142);
                    if (i692 != i) {
                        int i693 = artificialFrame;
                        int i694 = (i693 ^ 45) + ((i693 & 45) << 1);
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i694 % 128;
                        int i695 = i694 % 2;
                        Object[] objArr174 = {null, new int[1], null, new int[]{i}, new int[]{i692}};
                        int iMyUid = Process.myUid();
                        int i696 = 716071099 + (((~((-96884325) | iMyUid)) | 29628004) * (-140)) + ((~((-67256321) | iMyUid)) * 70) + (((~(iMyUid | 702332782)) | (-739961099)) * 70);
                        int i697 = ((i696 | 16) << 1) - (i696 ^ 16);
                        int i698 = ((i3 | i697) << 1) - (i697 ^ i3);
                        int i699 = i698 << 13;
                        int i700 = (i699 | i698) & (~(i698 & i699));
                        int i701 = i700 >>> 17;
                        int i702 = (i700 | i701) & (~(i700 & i701));
                        ((int[]) objArr174[1])[0] = i702 ^ (i702 << 5);
                        return objArr174;
                    }
                }
                i22 = i3;
            }
            int i703 = -(-KeyEvent.getDeadChar(0, 0));
            int i704 = -KeyEvent.keyCodeFromString(str7);
            int i705 = (i704 & 1755) + (i704 | 1755);
            int keyRepeatTimeout12 = ViewConfiguration.getKeyRepeatTimeout() >> 16;
            Object[] objArr175 = new Object[1];
            b((char) ((i703 & 53106) + (i703 | 53106)), i705, (keyRepeatTimeout12 & 13) + (keyRepeatTimeout12 | 13), objArr175);
            String str89 = (String) objArr175[0];
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            char c31 = (char) ((iMakeMeasureSpec ^ 60586) + ((iMakeMeasureSpec & 60586) << 1));
            int i706 = 1767 - (~TextUtils.getCapsMode(str7, 0, 0));
            int i707 = -(-(PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)));
            int i708 = (i707 ^ 5) + ((i707 & 5) << 1);
            Object[] objArr176 = new Object[1];
            b(c31, i706, i708, objArr176);
            char c32 = (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
            int scrollBarFadeDuration3 = ViewConfiguration.getScrollBarFadeDuration() >> 16;
            int i709 = (scrollBarFadeDuration3 & 1773) + (scrollBarFadeDuration3 | 1773);
            int iResolveSizeAndState = View.resolveSizeAndState(0, 0, 0);
            Object[] objArr177 = new Object[1];
            b(c32, i709, (iResolveSizeAndState & 15) + (iResolveSizeAndState | 15), objArr177);
            String str90 = (String) objArr177[0];
            char c33 = (char) (47334 - (~(-(ViewConfiguration.getFadingEdgeLength() >> 16))));
            int packedPositionChild4 = 1787 - ExpandableListView.getPackedPositionChild(0L);
            int i710 = -(ViewConfiguration.getDoubleTapTimeout() >> 16);
            int i711 = ((i710 | 19) << 1) - (i710 ^ 19);
            Object[] objArr178 = new Object[1];
            b(c33, packedPositionChild4, i711, objArr178);
            String str91 = (String) objArr178[0];
            char tapTimeout3 = (char) ((ViewConfiguration.getTapTimeout() >> 16) + 40866);
            int i712 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
            int iITrustedWebActivityCallbackStub16 = JwtEcdsaAlgorithm.AnonymousClass1.ITrustedWebActivityCallbackStub();
            int i713 = i712 * 483;
            int i714 = (i713 ^ 437052) + ((i713 & 437052) << 1);
            int i715 = ~i712;
            int i716 = ~((i715 ^ (-1807)) | (i715 & (-1807)));
            int i717 = ~iITrustedWebActivityCallbackStub16;
            int i718 = (i716 | (~((i715 ^ i717) | (i715 & i717)))) * (-241);
            int i719 = (i714 ^ i718) + ((i718 & i714) << 1) + (((i712 ^ 1806) | (i712 & 1806)) * (-482));
            int i720 = ~((i712 & (-1807)) | ((-1807) ^ i712));
            int i721 = (i717 & i715) | (i715 ^ i717);
            int i722 = ~((i721 & 1806) | (i721 ^ 1806));
            int i723 = -(-(((i720 & i722) | (i720 ^ i722)) * 241));
            Object[] objArr179 = new Object[1];
            b(tapTimeout3, ((i719 | i723) << 1) - (i723 ^ i719), 14 - View.resolveSize(0, 0), objArr179);
            Object[] objArr180 = new Object[1];
            b((char) ((-16738269) - (~(-Color.rgb(0, 0, 0)))), 1821 - ((Process.getThreadPriority(0) + 20) >> 6), KeyEvent.keyCodeFromString(str7) + 21, objArr180);
            String str92 = (String) objArr180[0];
            char cMyTid = (char) (Process.myTid() >> 22);
            int i724 = -(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
            int threadPriority7 = Process.getThreadPriority(0);
            Object[] objArr181 = new Object[1];
            b(cMyTid, (i724 ^ 1843) + ((i724 & 1843) << 1), 9 - (~(((threadPriority7 & 20) + (threadPriority7 | 20)) >> 6)), objArr181);
            int i725 = -TextUtils.lastIndexOf(str7, '0', 0);
            int deadChar3 = KeyEvent.getDeadChar(0, 0);
            int i726 = getARTIFICIAL_FRAME_PACKAGE_NAME + 95;
            artificialFrame = i726 % 128;
            int i727 = i726 % 2;
            int i728 = -deadChar3;
            int i729 = (1852 ^ i728) + ((i728 & 1852) << 1);
            int i730 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
            int i731 = (i730 & 11) + (i730 | 11);
            Object[] objArr182 = new Object[1];
            b((char) (((i725 | 20965) << 1) - (i725 ^ 20965)), i729, i731, objArr182);
            int i732 = -View.MeasureSpec.makeMeasureSpec(0, 0);
            Object[] objArr183 = new Object[1];
            b((char) ((i732 ^ 50152) + ((i732 & 50152) << 1)), 589 - ExpandableListView.getPackedPositionGroup(0L), 4 - (~(-ImageFormat.getBitsPerPixel(0))), objArr183);
            String[] strArr39 = {(String) objArr182[0], (String) objArr183[0]};
            char c34 = (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
            int keyRepeatTimeout13 = ViewConfiguration.getKeyRepeatTimeout() >> 16;
            Object[] objArr184 = new Object[1];
            b(c34, (keyRepeatTimeout13 & 1863) + (keyRepeatTimeout13 | 1863), 28 - (~(-(-TextUtils.lastIndexOf(str7, '0', 0, 0)))), objArr184);
            String str93 = (String) objArr184[0];
            char c35 = (char) ((-2) - (~(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))));
            int i733 = -(-KeyEvent.keyCodeFromString(str7));
            int i734 = (i733 ^ 1842) + ((i733 & 1842) << 1);
            int i735 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
            int i736 = ~i735;
            int i737 = ~((i736 & i265) | (i736 ^ i265));
            int i738 = (i735 * 236) + 4239 + (((i737 & 9) | (i737 ^ 9)) * (-235));
            int i739 = ~i735;
            int i740 = (i738 - (~(-(-(((~((i739 ^ i) | (i739 & i))) | 9) * (-470)))))) - 1;
            int i741 = ~(i735 | (-10));
            int i742 = (i739 & 9) | (i739 ^ 9);
            int i743 = ~((i742 & i) | (i742 ^ i));
            int i744 = i740 - (~(-(-(((i741 & i743) | (i741 ^ i743)) * 235))));
            int i745 = 1;
            Object[] objArr185 = new Object[1];
            b(c35, i734, i744 - 1, objArr185);
            char c36 = 0;
            String[][] strArr40 = {new String[]{str89, (String) objArr176[0]}, new String[]{str90, str91, (String) objArr179[0]}, new String[]{str92, (String) objArr181[0]}, strArr39, new String[]{str93, (String) objArr185[0]}};
            int i746 = 0;
            int i747 = 5;
            int i748 = -1;
            loop5: while (true) {
                if (i746 >= i747) {
                    i26 = i;
                    break;
                }
                String[] strArr41 = strArr40[i746];
                String str94 = strArr41[c36];
                String[] strArr42 = (String[]) Arrays.copyOfRange(strArr41, i745, strArr41.length);
                int length3 = strArr42.length;
                int i749 = 0;
                while (i749 < length3) {
                    int i750 = ((i748 | 83) << i745) - (i748 ^ 83);
                    i748 = (i750 ^ (-82)) + ((i750 & (-82)) << i745);
                    Object[] objArr186 = {str94, strArr42[i749]};
                    Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(-883653127);
                    if (objAccessartificialFrame21 == null) {
                        int iRgb4 = Color.rgb(0, 0, 0) + 16777247;
                        char cNormalizeMetaState3 = (char) (KeyEvent.normalizeMetaState(0) + 57022);
                        int iMyPid6 = 2311 - (Process.myPid() >> 22);
                        int i751 = $$b;
                        Object[] objArr187 = new Object[1];
                        a((byte) (i751 | 7), (byte) (i751 | 18), $$a[13], objArr187);
                        objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(iRgb4, cNormalizeMetaState3, iMyPid6, 1412547569, false, (String) objArr187[0], new Class[]{String.class, String.class});
                    }
                    long jLongValue13 = ((Long) ((Method) objAccessartificialFrame21).invoke(null, objArr186)).longValue();
                    long j86 = 1717717860;
                    long j87 = 628;
                    long j88 = (j87 * j86) + (j87 * jLongValue13);
                    long j89 = -627;
                    long j90 = j88 + ((jLongValue13 | j33 | (j86 ^ j23)) * j89) + (j89 * (j86 | (((jLongValue13 ^ j23) | j33) ^ j23))) + (((long) 627) * (((j34 | jLongValue13) ^ j23) | ((j86 | j33) ^ j23))) + ((long) (-1872469489));
                    int iNextInt3 = new Random().nextInt();
                    int i752 = ~iNextInt3;
                    int i753 = ((int) (j90 >> 32)) & (670980951 + (((~((-75751995) | iNextInt3)) | (~((-1512978406) | i752))) * 333) + (((~(iNextInt3 | (-1512978406))) | (~(i752 | (-75751995)))) * 333));
                    int i754 = ((int) j90) & (723056901 + ((~((-1192221474) | i142)) * (-560)) + ((~((-1090879778) | i)) * (-560)) + (((~((-245004937) | i142)) | 143663240) * 560));
                    if (((i754 & i753) | (i753 ^ i754)) != 0) {
                        i26 = i ^ (i748 + 170);
                        break loop5;
                    }
                    int i755 = (i749 & 105) + (i749 | 105);
                    i749 = ((i755 | (-104)) << 1) - (i755 ^ (-104));
                    strArr42 = strArr42;
                    strArr40 = strArr40;
                    str94 = str94;
                    i745 = 1;
                }
                i746++;
                strArr40 = strArr40;
                i747 = 5;
                i745 = 1;
                c36 = 0;
            }
            if (i26 != i) {
                Object[] objArr188 = {null, new int[1], null, new int[]{i}, new int[]{i26}};
                int i756 = 887435209 + ((328949 | i142) * (-192)) + (((~((-453565195) | i142)) | 151554314) * (-384)) + (((~(i | 453894143)) | (~((-151554315) | i)) | (~((-302010881) | i142))) * JfifUtil.MARKER_SOFn) + 16;
                int iITrustedWebActivityCallbackStub17 = JwtEcdsaAlgorithm.AnonymousClass1.ITrustedWebActivityCallbackStub();
                int i757 = (i756 * 868) + (i22 * 868);
                int i758 = ~i756;
                int i759 = ~iITrustedWebActivityCallbackStub17;
                int i760 = ~(i758 | i759);
                int i761 = ~i22;
                int i762 = ~iITrustedWebActivityCallbackStub17;
                int i763 = ~((i762 & i761) | (i761 ^ i762));
                int i764 = ((i760 & i763) | (i760 ^ i763)) * (-867);
                int i765 = (i757 ^ i764) + ((i757 & i764) << 1);
                int i766 = ~i22;
                int i767 = ~(i758 | i766);
                int i768 = ~((i758 ^ iITrustedWebActivityCallbackStub17) | (i758 & iITrustedWebActivityCallbackStub17));
                int i769 = (i767 & i768) | (i767 ^ i768);
                int i770 = ~(i761 | iITrustedWebActivityCallbackStub17);
                int i771 = (i765 - (~(-(-(((i769 & i770) | (i769 ^ i770)) * (-1734)))))) - 1;
                int i772 = ~((i758 & i761) | (i758 ^ i761) | i759);
                int i773 = ~i756;
                int i774 = ~((i22 & i773) | (i773 ^ i22) | iITrustedWebActivityCallbackStub17);
                int i775 = (i774 & i772) | (i772 ^ i774);
                int i776 = (i766 & i756) | (i766 ^ i756);
                int i777 = ~((iITrustedWebActivityCallbackStub17 & i776) | (i776 ^ iITrustedWebActivityCallbackStub17));
                int i778 = ((i777 & i775) | (i775 ^ i777)) * 867;
                int i779 = (i771 & i778) + (i778 | i771);
                int i780 = i779 << 13;
                int i781 = (i780 | i779) & (~(i779 & i780));
                int i782 = i781 >>> 17;
                int i783 = (i781 | i782) & (~(i781 & i782));
                int i784 = i783 << 5;
                ((int[]) objArr188[1])[0] = ((~i783) & i784) | ((~i784) & i783);
                return objArr188;
            }
            try {
                char c37 = (char) (12131 - (~(-Process.getGidForName(str7))));
                int iResolveSizeAndState2 = 1891 - View.resolveSizeAndState(0, 0, 0);
                int capsMode2 = TextUtils.getCapsMode(str7, 0, 0);
                int i785 = ((capsMode2 | 13) << 1) - (capsMode2 ^ 13);
                Object[] objArr189 = new Object[1];
                b(c37, iResolveSizeAndState2, i785, objArr189);
                String str95 = (String) objArr189[0];
                char c38 = (char) (0 - (~(-(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)))));
                int iMyPid7 = Process.myPid() >> 22;
                int i786 = (iMyPid7 ^ 1904) + ((iMyPid7 & 1904) << 1);
                int i787 = -(-(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)));
                int i788 = (i787 & 8) + (i787 | 8);
                Object[] objArr190 = new Object[1];
                b(c38, i786, i788, objArr190);
                String str96 = (String) objArr190[0];
                File file4 = new File(str95);
                if (file4.exists() && file4.isFile()) {
                    try {
                        Scanner scanner5 = new Scanner(new FileInputStream(file4));
                        int i789 = -Gravity.getAbsoluteGravity(0, 0);
                        int i790 = -(ViewConfiguration.getScrollBarSize() >> 8);
                        int i791 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                        Object[] objArr191 = new Object[1];
                        b((char) ((i789 & 1433) + (i789 | 1433)), (i790 & 370) + (i790 | 370), (i791 & 2) + (i791 | 2), objArr191);
                        Scanner scannerUseDelimiter4 = scanner5.useDelimiter((String) objArr191[0]);
                        String next4 = scannerUseDelimiter4.hasNext() ? scannerUseDelimiter4.next() : str7;
                        scannerUseDelimiter4.close();
                        if (next4.contains(str96)) {
                            i27 = i ^ 150;
                        } else {
                            i27 = i;
                        }
                    } catch (IOException unused4) {
                    }
                } else {
                    i27 = i;
                }
            } catch (Exception unused5) {
                i27 = i ^ 151;
            }
            if (i27 != i) {
                Object[] objArr192 = {null, new int[]{(i | i) & (~(i & i))}, null, new int[]{i}, new int[]{i27}};
                int i792 = i22 + (-240511799) + (((~(i | (-584489622))) | 1477140) * 576) + (((~((-583012482) | i142)) | 19481696) * 576) + 850832656;
                int i793 = i792 << 13;
                int i794 = ((~i792) & i793) | ((~i793) & i792);
                int i795 = i794 ^ (i794 >>> 17);
                int i796 = i795 << 5;
                return objArr192;
            }
            char c39 = (char) (2971 - (~View.combineMeasuredStates(0, 0)));
            int offsetAfter2 = 1912 - TextUtils.getOffsetAfter(str7, 0);
            int i797 = -(ViewConfiguration.getLongPressTimeout() >> 16);
            int i798 = ((i797 | 47) << 1) - (i797 ^ 47);
            Object[] objArr193 = new Object[1];
            b(c39, offsetAfter2, i798, objArr193);
            Object[] objArr194 = {(String) objArr193[0]};
            Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-11453480);
            if (objAccessartificialFrame22 == null) {
                int i799 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 17;
                char c40 = (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 24342);
                int scrollBarSize3 = 2014 - (ViewConfiguration.getScrollBarSize() >> 8);
                byte[] bArr19 = $$a;
                byte b10 = bArr19[18];
                Object[] objArr195 = new Object[1];
                a(b10, (byte) (b10 - 1), bArr19[8], objArr195);
                objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(i799, c40, scrollBarSize3, 1614052816, false, (String) objArr195[0], new Class[]{String.class});
            }
            long jLongValue14 = ((Long) ((Method) objAccessartificialFrame22).invoke(null, objArr194)).longValue();
            long j91 = -534529070;
            long j92 = j91 ^ j23;
            long j93 = 191;
            long j94 = (((long) (-381)) * j91) + (((long) JfifUtil.MARKER_SOFn) * jLongValue14) + (((long) (-191)) * j92) + ((j91 | ((jLongValue14 | j33) ^ j23)) * j93) + (j93 * (((j34 | jLongValue14) ^ j23) | ((j92 | jLongValue14) ^ j23))) + ((long) 2096660107);
            int i800 = ((int) (j94 >> 32)) & ((-1289368670) + (((~((-844746838) | i)) | (-2012994048)) * (-756)) + (((-844746838) | i142) * 756));
            int iMyTid5 = Process.myTid();
            int i801 = ~iMyTid5;
            int i802 = (~((-1459076051) | i801)) | 77730128 | (~(1398664835 | i801));
            int i803 = ((int) j94) & ((-154347929) + (((~(iMyTid5 | (-17318914))) | i802) * 590) + (i802 * (-1180)) + (((~((-1398664836) | i801)) | (~(i801 | 1459076050))) * 590));
            int i804 = ((i800 & i803) | (i800 ^ i803)) * 263;
            int i805 = (i804 & i142) | ((~i804) & i);
            if (i805 != i) {
                int i806 = artificialFrame + 101;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i806 % 128;
                int i807 = i806 % 2;
                Object[] objArr196 = {null, new int[]{((~i) & i) | ((~i) & i)}, null, new int[]{i}, new int[]{i805}};
                int i808 = -(-(1834574975 + ((i | 333539049) * 614) + (((~((-408651058) | i142)) | 272696353 | (~(196797400 | i142))) * (-1228)) + (((~((-135954705) | i142)) | (~(469493753 | i142))) * 614) + 16));
                int i809 = (i22 & i808) + (i808 | i22);
                int i810 = i809 << 13;
                int i811 = (i810 & (~i809)) | ((~i810) & i809);
                int i812 = i811 >>> 17;
                int i813 = (i811 | i812) & (~(i811 & i812));
                int i814 = i813 << 5;
                return objArr196;
            }
            Object[] objArr197 = new Object[5];
            objArr197[1] = new int[1];
            objArr197[3] = new int[]{i};
            int i815 = getARTIFICIAL_FRAME_PACKAGE_NAME;
            int i816 = (i815 ^ 117) + ((i815 & 117) << 1);
            artificialFrame = i816 % 128;
            int i817 = i816 % 2;
            objArr197[4] = new int[]{i};
            int iITrustedWebActivityCallbackStub18 = JwtEcdsaAlgorithm.AnonymousClass1.ITrustedWebActivityCallbackStub();
            int i818 = ~iITrustedWebActivityCallbackStub18;
            int i819 = ~((-1762317133) | i818);
            int i820 = ((-159258139) & iITrustedWebActivityCallbackStub18) | ((-159258139) ^ iITrustedWebActivityCallbackStub18);
            int i821 = ~i820;
            int i822 = -(-(((i819 & i821) | (i819 ^ i821)) * 1150));
            int i823 = (822390092 ^ i822) + ((i822 & 822390092) << 1);
            int i824 = ~i820;
            int i825 = ~((159258138 & i818) | (i818 ^ 159258138));
            int i826 = ((i824 & i825) | (i824 ^ i825)) * (-575);
            int i827 = (i823 & i826) + (i826 | i823);
            int i828 = ~((iITrustedWebActivityCallbackStub18 & (-1762317133)) | ((-1762317133) ^ iITrustedWebActivityCallbackStub18));
            int i829 = ~(i818 | 1762317132);
            int i830 = -(-(((i828 & i829) | (i828 ^ i829)) * 575));
            int i831 = (i827 ^ i830) + ((i830 & i827) << 1);
            int i832 = (-627902288) - (~(-(-((~((788750726 ^ i) | (788750726 & i))) * TypedValues.CycleType.TYPE_EASING))));
            int i833 = ~((788750726 & i142) | (i142 ^ 788750726));
            if (i831 <= i832 + (((i833 & 553779590) | (553779590 ^ i833)) * TypedValues.CycleType.TYPE_EASING)) {
                objArr197[1] = null;
                objArr197[2] = null;
                i28 = ((1849009924 + ((i | (-9437194)) * (-381))) + (((~(591814640 | i142)) | (-597055210)) * 381)) - 699396763;
            } else {
                objArr197[0] = null;
                objArr197[2] = null;
                int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
                i28 = 1969322785 + (((~((-55419325) | iMaxMemory)) | 4751628) * 336) + (((~(iMaxMemory | 550029133)) | (-600696830)) * (-168)) + (((~((~iMaxMemory) | 550029133)) | (-55419325)) * 168);
            }
            int i834 = (i22 & i28) + (i28 | i22);
            int i835 = i834 << 13;
            int i836 = (i834 | i835) & (~(i834 & i835));
            int i837 = i836 >>> 17;
            int i838 = ((~i836) & i837) | ((~i837) & i836);
            ((int[]) objArr197[1])[0] = i838 ^ (i838 << 5);
            return objArr197;
        }
        objArr2 = new Object[5];
        objArr2[1] = new int[1];
        int[] iArr6 = new int[1];
        objArr2[3] = iArr6;
        int[] iArr7 = new int[1];
        objArr2[4] = iArr7;
        int i839 = getARTIFICIAL_FRAME_PACKAGE_NAME;
        int i840 = (i839 ^ 55) + ((i839 & 55) << 1);
        artificialFrame = i840 % 128;
        if (i840 % 2 == 0) {
            iArr6[0] = i;
            ((int[]) objArr2[5])[1] = i11;
            obj = null;
            objArr2[0] = null;
        } else {
            obj = null;
            iArr6[0] = i;
            iArr7[0] = i11;
            objArr2[0] = null;
        }
        objArr2[2] = obj;
        int iMyTid6 = Process.myTid();
        int i841 = ~(244033776 | iMyTid6);
        int i842 = ~iMyTid6;
        int i843 = i841 | (~(849482234 | i842));
        int i844 = ~((-244033777) | i842);
        int i845 = (-1008097443) + ((i843 | i844) * (-516)) + (((~(iMyTid6 | (-807407883))) | (~((-42074353) | i842))) * 516) + ((42074352 | i844) * 516);
        int i846 = (i845 & 16) + (i845 | 16);
        int iITrustedWebActivityCallbackStub19 = JwtEcdsaAlgorithm.AnonymousClass1.ITrustedWebActivityCallbackStub();
        int i847 = i846 * (-665);
        int i848 = -(-(i3 * 334));
        int i849 = (i847 & i848) + (i847 | i848);
        int i850 = ~i846;
        int i851 = i849 + (i850 * (-333));
        int i852 = ~iITrustedWebActivityCallbackStub19;
        int i853 = ~((i850 & i852) | (i850 ^ i852));
        int i854 = ~((i3 ^ iITrustedWebActivityCallbackStub19) | (i3 & iITrustedWebActivityCallbackStub19));
        int i855 = ((i853 & i854) | (i853 ^ i854)) * 333;
        int i856 = (i851 & i855) + (i855 | i851);
        int i857 = ~i846;
        int i858 = ~((i857 & iITrustedWebActivityCallbackStub19) | (i857 ^ iITrustedWebActivityCallbackStub19));
        int i859 = ~iITrustedWebActivityCallbackStub19;
        int i860 = ~((i3 & i859) | (i859 ^ i3));
        int i861 = ((i858 & i860) | (i858 ^ i860)) * 333;
        int i862 = ((i856 | i861) << 1) - (i861 ^ i856);
        int i863 = i862 << 13;
        int i864 = (i863 & (~i862)) | ((~i863) & i862);
        int i865 = i864 >>> 17;
        int i866 = ((~i864) & i865) | ((~i865) & i864);
        ((int[]) objArr2[1])[0] = i866 ^ (i866 << 5);
        return objArr2;
    }
}
