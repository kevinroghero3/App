package com.google.android.datatransport.cct.internal;

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
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.common.base.Ascii;
import com.google.common.collect.Lists;
import com.google.logging.type.LogSeverity;
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

/* JADX INFO: loaded from: classes4.dex */
public abstract class ClientInfo {
    private static long _BOUNDARY;
    private static char[] _CREATION;
    private static final byte[] $$c = {109, -105, -81, -102};
    private static final int $$d = WebSocketProtocol.PAYLOAD_SHORT;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {0, -128, -114, 48, -33, -47, -11, Ascii.FF, -11, 8, 53, 52, -17, 5, -22, -1, 3, 2, -53, Ascii.CR, 1, 0, -17};
    private static final int $$b = WebSocketProtocol.PAYLOAD_SHORT;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;

    public static abstract class Builder {
        public abstract ClientInfo build();

        public abstract Builder setAndroidClientInfo(@Nullable AndroidClientInfo androidClientInfo);

        public abstract Builder setClientType(@Nullable ClientType clientType);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(short r6, byte r7, short r8) {
        /*
            byte[] r0 = com.google.android.datatransport.cct.internal.ClientInfo.$$c
            int r8 = r8 * 3
            int r8 = 3 - r8
            int r6 = r6 * 4
            int r1 = r6 + 1
            int r7 = 106 - r7
            byte[] r1 = new byte[r1]
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r8
            r4 = r2
            r8 = r6
            goto L2c
        L15:
            r3 = r2
        L16:
            int r8 = r8 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L23:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r5
        L2c:
            int r7 = -r7
            int r7 = r7 + r8
            r8 = r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.cct.internal.ClientInfo.$$e(short, byte, short):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x002b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(short r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = 115 - r6
            int r8 = r8 + 5
            int r0 = r7 + 2
            byte[] r1 = com.google.android.datatransport.cct.internal.ClientInfo.$$a
            byte[] r0 = new byte[r0]
            int r7 = r7 + 1
            r2 = 0
            if (r1 != 0) goto L12
            r3 = r8
            r4 = r2
            goto L2b
        L12:
            r3 = r2
        L13:
            int r8 = r8 + 1
            byte r4 = (byte) r6
            r0[r3] = r4
            if (r3 != r7) goto L22
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L22:
            int r3 = r3 + 1
            r4 = r1[r8]
            r5 = r8
            r8 = r6
            r6 = r4
            r4 = r3
            r3 = r5
        L2b:
            int r6 = -r6
            int r8 = r8 + r6
            int r6 = r8 + (-2)
            r8 = r3
            r3 = r4
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.cct.internal.ClientInfo.b(short, short, short, java.lang.Object[]):void");
    }

    public abstract AndroidClientInfo getAndroidClientInfo();

    public abstract ClientType getClientType();

    public enum ClientType {
        UNKNOWN(0),
        ANDROID_FIREBASE(23);

        private final int value;

        ClientType(int i) {
            this.value = i;
        }
    }

    public static Builder builder() {
        return new AutoValue_ClientInfo.Builder();
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0204  */
    /* JADX WARN: Code duplicated, block: B:45:0x0205  */
    private static void a(char c, int i, int i2, Object[] objArr) throws Throwable {
        Object obj;
        Throwable cause;
        int i3 = 2 % 2;
        _CREATION _creation = new _CREATION();
        long[] jArr = new long[i2];
        _creation.b = 0;
        while (true) {
            obj = null;
            if (_creation.b >= i2) {
                break;
            }
            int i4 = _creation.b;
            try {
                Object[] objArr2 = {Integer.valueOf(_CREATION[i + i4])};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) 0;
                    byte b2 = (byte) (b + 2);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 7, (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 9278), 1977 - (ViewConfiguration.getFadingEdgeLength() >> 16), 1113883676, false, $$e(b, b2, (byte) (b2 - 2)), new Class[]{Integer.TYPE});
                }
                Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i4), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                if (objAccessartificialFrame2 == null) {
                    byte b3 = (byte) 0;
                    byte b4 = b3;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(TextUtils.getOffsetAfter("", 0) + 30, (char) (TextUtils.getTrimmedLength("") + 49362), View.MeasureSpec.getMode(0) + 684, -115095555, false, $$e(b3, b4, b4), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                }
                jArr[i4] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                Object[] objArr4 = {_creation, _creation};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) 0;
                    byte b6 = (byte) (b5 + 3);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(Process.getGidForName("") + 26, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 30067), ExpandableListView.getPackedPositionChild(0L) + 817, 1897803493, false, $$e(b5, b6, (byte) (b6 - 3)), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
            } catch (Throwable th) {
                cause = th.getCause();
                if (cause != null) {
                    throw th;
                }
                throw cause;
            }
            cause = th.getCause();
            if (cause != null) {
                throw th;
            }
            throw cause;
        }
        char[] cArr = new char[i2];
        _creation.b = 0;
        while (_creation.b < i2) {
            int i5 = $10 + 41;
            $11 = i5 % 128;
            if (i5 % 2 == 0) {
                cArr[_creation.b] = (char) jArr[_creation.b];
                Object[] objArr5 = {_creation, _creation};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-293902099);
                if (objAccessartificialFrame4 == null) {
                    byte b7 = (byte) 0;
                    byte b8 = (byte) (b7 + 3);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(25 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (30068 - View.getDefaultSize(0, 0)), 816 - Drawable.resolveOpacity(0, 0), 1897803493, false, $$e(b7, b8, (byte) (b8 - 3)), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                obj.hashCode();
                throw null;
            }
            cArr[_creation.b] = (char) jArr[_creation.b];
            Object[] objArr6 = {_creation, _creation};
            Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-293902099);
            if (objAccessartificialFrame5 == null) {
                byte b9 = (byte) 0;
                byte b10 = (byte) (b9 + 3);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(26 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) (30068 - (KeyEvent.getMaxKeyCode() >> 16)), 816 - (ViewConfiguration.getJumpTapTimeout() >> 16), 1897803493, false, $$e(b9, b10, (byte) (b10 - 3)), new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame5).invoke(null, objArr6);
        }
        String str = new String(cArr);
        int i6 = $11 + 99;
        $10 = i6 % 128;
        if (i6 % 2 == 0) {
            objArr[0] = str;
        } else {
            obj.hashCode();
            throw null;
        }
    }

    static {
        char[] cArr = new char[1959];
        ByteBuffer.wrap("yÁl,RÇ9j/Y\u0015·øeî\bÔº»^¡û\u0097¿zN`ßV\u009b=0#ê\t\u009aü'âÏÉe¿/¥Ù\u0088t~\u001fd»KW¿ãª\u000e\u0094åÿHé{Ó\u0095>G(*\u0012\u0098}|gÙQ\u009d¼l¦ý\u0090¨û\u001fåÜÏ¯:?$ú\u000fDy cëNR¸8è{ý\u0096Ã}¨Ð¾ã\u0084\riß\u007f²E\u0000*ä0A\u0006\u0005ëôñeÇ3¬\u0097²Z\u00981y\\l¦RF9ò/Ä\u0015 øøî\u009dÔ6»É¡j\u0097~zÜ`rV\u000b=\u00ad#u\t\u001cü¬âIÉÔ¿\u008f¥V\u0088í~\u0097d KÝ1\u0088\u0019Ñ\f=2ÆYoOIu¤\u0098}\u008eZ´¾ÛZÁí÷¬\u0019Ñ\f=2ÆYoOIu³\u0098s\u008e\u0019´àÛXÁð÷³\u001aF\u0019Ñ\f+2ÖYoO\u0007u²\u0098~\u008e[´\u009cÛnÁÏ÷³\u001a@\u0000õ6®]%Cêi\u0099\u0019Ñ\f<2ÓYxO\u0007uï\u00984\u008e\u0017´¾Û]Áë÷²\u001aP\u0000ÿ\u000el\u001b×%|N\u008eXébO\u008f\u008e\u0099º£\\Ì\u00adÖ\u0006àN\r¹\u0017\u0019!nJûT\u0010~}\u008bÆ\u0095\u0013¾\u0082ÈîÒ)ÿÅ\u0019\u008c\f72\u009cYnO\tu¯\u0098n\u008eZ´¼ÛMÁæ÷®\u001aY\u0000ù6\u008e]\u001bCði\u009d\u009c&\u0082ó©bß\u000eÅÉè&ïôú\u000eÄî¯Z¹7\u0083\u0080nRx~B\u0087-d7Å\u0001Öì\u007föÜÀ\u00ad«\u000fµÙ\u009fój\u0004tæ\u0019\u009c\f12ÕYbO\tu¸ó[æà\u0019Ñ\f+2ËY\u007fO\u0012u¥\u0098w\u008e[´¬ÛAÁì÷ó\u001aX\u0000õ6\u0087]1CÈiµ\u009c\u007f\u0082Â©cß\rÅÏè9\u001e\r\u0004§+LQ\bG¤j_\u0090æ\u009f>\u008aÄ´$ß\u0090ÉýóJ\u001e\u0098\b´2C]®G\u0003q\u001c\u009c·\u0086\u001a°hÛÞÅ'ïZ\u001a\u0090\u00043/\u009bYàC%\u0019Ñ\f+2ËY\u007fO\u0012u¥\u0098w\u008e[´¢ÛAÁà÷ó\u001aZ\u0000ù6\u0088]*Cûi\u0095\u009c'\u0082ú©Kß\u0010ÅÈè{\u001e\u001e\u0004æ+QQ\u0013·ÿ¢\u0012\u009cù÷TágÛ\u00806Q 7\u001a\u0095uaoÙY\u0097´k®ÊÅ\u0086Ð=î\u0096\u0085d\u0093\u0019©£D|R\u001ahê\u0007J\u001dç+¥ÆH\u0019\u0090\f=2ÓY\u007fO\u0003uî\u0098t\u008e\u0011´º\u0019Ñ\f(2ÀYcO\u0005uï\u0098|\u008e\u001d´¢ÛMÁñ÷¥\u001aE\u0000ä6\u008f])CíÊ\u0087ß*áÈ\u008an\u009c\u0002¦±âì÷WÉü¢\u001c´t\u008eÏc\u001euaOÍ <:Ì\fÑá7û\u009eÍÿ¦B¸\u009f\u0092ûgFy¹R\u0014$e>¨\u0019\u0099\f=2ÜYu\u0019\u008e\f=2ÀY\u007fO\u000fu³\u0098n\u008eZ´½ÛQÁñ÷ò\u001aT\u0000ô6Ä] Cûi\u009a\u009c'\u0082Ë©(ß\u0007ÅÊèa\u001e@\u0004®+CQ\u0017G³jo\u0090í\u0086\u0094\u00adKÓÇù\u0080ì)\u0012È9d/?UÆxkn\u001a\u0019\u008e\f=2ÀY\u007fO\u000fu³\u0098n\u008eZ´½ÛQÁñ÷ò\u001aT\u0000ô6Ä] Cûi\u009a\u009c'\u0082Ë©(ß\u0007ÅÊèa\u001e@\u0004®+CQ\u0017G³jo\u0090í\u0086\u0094\u00adKÓÇù\u0084ì)\u0012È9d/5UÆ\u0019\u008e\f=2ÀY\u007fO\u000fu³\u0098n\u008eZ´½ÛQÁñ÷ò\u001aT\u0000ô6Ä] Cûi\u009a\u009c'\u0082Ë©(ß\u0012ÅÕè:\u001e\r\u0004¹+Ki\u009c|/BÒ)m?\u001d\u0005¡è|þHÄ¯«C±ã\u0087àjFpæFÖ-23é\u0019\u0088ì5òÙÙ:¯\u0000µÇ\u0098(n\u0010t»[S\u0019\u008e\f=2ÀY\u007fO\u000fu³\u0098n\u008eZ´½ÛQÁñ÷ò\u001aT\u0000ô6Ä] Cûi\u009a\u009c'\u0082Ë©(ß\u0012ÅÕè:\u001e\u0003\u0004«+AM\u0080X3fÎ\rq\u001b\u0001!½Ì`ÚTà³\u008f_\u0095ÿ£üNZTúbÊ\t.\u0017õ=\u0094È)ÖÅý&\u008b\u001c\u0091Û¼4J\rP¨\u007fOéåüWÂ°©\u0019¿x\u0085Ë\u0019Ñ\f(2ÀYcO\u0005uï\u0098w\u008e\u001b´ªÛ]Áî÷¹\u001aEb»w\tIî\"G42\u000e\u0086ãLõ4Ï\u0089\u0085B\u0090Æ®'Å\u008eÓðéT\u0004\u0095\u0012æ(ZG½\u0019\u008b\f62ÙYbO\tu·\u0098t\u009eZ\u008b÷µ\u0007Þ¤ÈÌòn\u001f¨\tÞ\u0019\u008c\f72\u009cY|O\u0014u¯\u0098~\u008e\u0001´\u00adÛ\\Á¬÷¸\u001aS\u0000æ6\u0083]'Cû¡Q´ã\u008a\u0004á\u00ad÷\u0087Í/ ³\u0019\u0099\f=2ÜYiO\u0014u©\u0098y)U<ñ\u0002\u0010i¥\u007fØEe¨µ¾ç\u0084zëÜñxNJ[îe\u000f\u000eº\u0018Ç\"zÏªÙøãe\u008cÃ\u0096g PMÓWw\u0019\u008c\f72\u009cY|O\u0014u¯\u0098~\u008e\u0001´\u00adÛ\\Á¬÷±\u001aY\u0000ô6\u008f](\u0019\u008d\f<2Ù\u0019\u009b\f52ÇY`O\u0007u´\u0098u\u008e\u0006\n\u009f\u001f\b!âJ\f\\\u0014f\u0095\u008bT\u009d §\u0087ÈeÒÇäÜ\tp\u0013ß%¸NDPýz°\u008f\u0000\u0091ãºKÌ%\u0019¿\f62ÖY~O\tu©\u0098~\u008eT´\u009dÛlÁÉ÷ü\u001aT\u0000å6\u0083](CêiØ\u009c4\u0082Ã©tß@ÅÂè,\u001eX\u000b\u0086\u001e\u000f ïKG]0g\u0090\u008aG\u009cm¦¤ÉUÓðåÅ\bm\u0012Ü$ºO\u0011QÓ{á\u008e\r\u0090ú»MÍy×ûú\u0015\fa\u0016®9-CqÒ\nÇ±ù\u001a\u0092â\u0084\u0081¾4SøE\u0085\u007f)\u0010Ü\na³É¦g\u0098\u008eó8åPßù29$L\u0019\u0088\f:2ÝYtO^uö\u0019\u008c\f92ÜYoO\u000euµ\u0019\u008c\f72\u009cY|O\u0014u¯\u0098~\u008e\u0001´\u00adÛ\\Á¬÷¾\u001aD\u0000ñ6\u0084] º\u0014¯¯\u0091\u0004úÿì\u009bÖ*;ì-\u0089\u0017:x\u009ebkT!¹Ã£}\u0019Ï\u0019\u008c\f72\u009cY\u007fO\u0003u£\u0098o\u008e\u0006´«»\u0002\u0019\u008c\f72\u009cYnO\u0013u©\u0098v\u008e\u0010´àÛXÁð÷³\u001aR\u0000å6\u0089]0ÑmÄØú+\u0091\u0095\u0087Ì½MP×F·¡J´ñ\u008aZá¨÷ÕÍo °6Ö\f&c\u0088y-Ot¢\u0097¸3\u008e^åòû*ÑW$ú:\u001e\u0095Ò\u0080v¾\u0097Õ\"Ã_ùâ\u00142\u0002\u00108öW\u0007M¢{¸\u0096\u001a\u008c¾ºÏÑjÏ§åÚ\u0010z\u0019\u0099\f=2ÜYiO\u0014u©\u0098y\u008e+´¶Û\u0010Á´÷ó\u001aE\u0000ô6\u0081]\u001bCæiÀ\u009cd\u0082\u0083©aß\u0005ÅÔèq\u001e\u001c\u0004¡+AQ#G®j\b\u0090¼\u0019\u0099\f=2ÜYiO\u0014u©\u0098y\u008e[´©ÛGÁí÷»\u001aZ\u0000õ6µ]7Cúi\u0093\u009c}\u0082Ë©cß\u000eÅßèf\u001e\u0007\u0004«/Ë:o\u0004\u008eo;yFCû®+¸\t\u0082êí\u0018÷¿Áö,\\6ô\u0000Èk9uº_Èªo´\u0086\u009flé\u0004ó\u0098\u0019\u0099\f72ÝYkO\nu¥\u00985\u008e\u0007´ªÛCÁÝ÷»\u001aF\u0000ø6\u0085]*Cûi§\u009c*\u0082\u0094©0ßOÅÝèq\u001e\u0000\u0004\u00ad+PQ\u0015Gµjo\u0090ò\u0086Ü\u00ad\b\u0019\u008c\f72\u009cYnO\tu¯\u0098n\u008e\u0018´¡ÛIÁæ÷¹\u001aD\u0019\u008c\f72\u009cYnO\tu¯\u0098n\u008e\u001d´£ÛIÁå÷¹\u001a\u0018\u0000ò6\u009f]-Còi\u009c\u009c|\u0082Ê©oß\u000eÅÝèq\u001e\u001c\u0004¸+PQ\u0015G¸jDÓ\u0085Æ\føì\u0093D\u00853¿\u0093RDDc~\u008c\u0011*\u000b\u008e\u0019\u008c\f72\u009cYnO\u0013u©\u0098v\u008e\u0010´àÛLÁë÷¯\u001aF\u0000ü6\u008b]=C°i\u0091\u009c6\u0019\u008a\f=2ÁYxOKK\"^\u0083`n\u000bÍ\u001dý'\u0006ÊÙÜ¢æU\u0089ì\u0093R¥\u0004HöR\bd/\u000f\u0083\u0011D;=Î\u00943v&Ä\u0018&s\u0080e±_Q²\u0094¤£\u009eZñ°ë\u0012ÝK0¤*\f\u001cjwÎ«©¾\u001b\u0080ùë_ýnÇ\u0095*Z<|\u0006\u008eiosÏE\u009f¨O²Õ\u0084\u00adï\u000fñÝÛ¬.\u0015i§|\u0015B÷)Q?`\u0005\u009bèTþrÄ\u008a«c±Î\u0087«jzpÝF¬-\u001f3ß\u0019¤ì\u00032h'Ó\u0019xr\u0083dç^V³\u0090¥õ\u009fFðâê\u0007ÜV1¶+\u0006\u001davÉh\u001eB2·Ç©-\u0082\u008fôñî:\u0098`\u008dÛ³pØ\u0082ÎåôC\u0019\u0082\u000f¶5SZ¡@\u0003vE\u009bô\u0081\u001d·pÜÌÂ-èz\u001dß\u0003-(\u008f\te\u001cÞ\"uI\u008a_ëeD\u0088Ý\u009eÿ¤RË¨Ñ\u0007çQ\nñ\u0010\u001f&jMÃS\u0010yt\u008cÉ\u00925¹\u009dÏàÕ=ø\u0089Õ\u008cÀ7þ\u009c\u0095|\u0083\u0014¹¯T~B\u0001x\u00ad\u0017\\\r¬;¾ÖCÌùú\u0086\u0091 \u008f°¥\u009eP;NÂea\u0013\u0005\tÈ$dÒ\u001cÈ¡çL\u009d\bi/|\u0094B?)Ü?¼\u0005\u0010èÍþ²Ä\u0000«¥±C\u0087\njüp_F--É3[\u00192ì\u009fòhÙÀ¯±µi\u0098Ån¤t\u0005[õ\u0019\u008c\f72\u009cY\u007fO\u001fu³\u0098n\u008e\u0011´£ÛwÁç÷¤\u001aB\u0000¾6\u0088]1C÷i\u0094\u009c6\u0082\u0082©`ß\tÅÔès\u001e\u000b\u0004º+RQ\u000eG¿j^\u0090þw»b\u0000\\«7M!4\u001b\u0099öIà,Ú\u008bµ1¯×\u0099\u009ethnËX¹3]-Ï\u0007¦ò\u000bìüÇT±%«ý\u0086Qp0j\u0091Ea0½%\u0006\u001b\u00adpKf2\\\u009f±O§*\u009d\u008dòFè×Þ\u00813l)Ì\u001fõt\u0017jÚ@ µ\u000f«ù\u0080\u0019ö7ìâÁK78-\u009c\u0002ax=n\u0095Ch¹Õ¯¡\u001b\u0099\u0019Ñ\f<2×YzOIu±\u0098\u007f\u008e\u0019´»ÛwÁò÷µ\u001aF\u0000õM\u0007Xêf\u0001\r¬\u001b\u009f!eÌ£ÚÁàs\u008f\u009b\u0095 £%N\u0082T'bO\t÷\u0017*=OÈêÖ\u001eý\u008f\u008bÑ\u0091\t¼¬JÁPz\u0019Ñ\f<2×YzOIu³\u0098u\u008e\u0017´¥ÛMÁö÷ó\u001aQ\u0000õ6\u0084]=Cú\u0019Ñ\f<2×YzOIu³\u0098u\u008e\u0017´¥ÛMÁö÷ó\u001aG\u0000õ6\u0087]1CúH;]Ác!\b\u0095\u001e£$[É\u0095ßóåQ\u008a\u009d\u0090\u001c¦DK½Q\u0019ge\u0099A\u008c»²[ÙïÏ\u0082õ5\u0018ç\u000eË42[ÑApwc\u009aÊ\u0080i¶\u0018Ý·ÃQé\u0005\u001c£\u0002P)ú_\u009fEIhÛ\u009e\u009a\u0084=«ÐÑ\u0099Ç!êÿ\u0010k\u0006\u0011-ÃS}yLl¯\u0092Yxzm\u0097S|8Ñ.â\u0014\tùÂï«Õ:ºä Y\u0096\u0004\u0019Ñ\f<2×YzOIu¢\u0098i\u008e\u0000´\u0091Û\\Áë÷±\u001aS\u0019Ñ\f<2×YzOIu³\u0098u\u008e\u0017´¥ÛMÁö÷ó\u001aT\u0000ã6\u009e]\"Cñi\u0094\u009c6\u0082É©tß\u0004,¿9E\u0007¥l\u0011z|@Ë\u00ad\u0019»5\u0081Ìî/ô\u008eÂ\u009d/45\u0097\u0003æhHv\u0083\\â©Z·\u00ad\u009c\u0004êjð±Ý\b+_1Ì\u001e\"d{r\u0096_-¥\u008bÞ`Ë\u008dõf\u009eË\u0088ø²\u0013_ØI±s\u001e\u001cú\u0006P0\bÚÄÏ)ñÂ\u009ao\u008c\\¶·[|M\u0015w¼\u0018D\u0002å4¦\u0019Ñ\f<2×YzOIu¢\u0098i\u008e\u0000´£ÛMÁå÷²y½lPR»9\u0016/%\u0015Îø\u0005îlÔÍ»6¡\u0087\u0097Õ\u0019Ñ\f<2×YzOIu¢\u0098i\u008e\u0000´¸ÛEÁñ÷»\u0019Ñ\f<2×YzOIu¢\u0098i\u008e\u0000´¾ÛOÁã÷µ\u001aF\u0000óÑ\u009cÄqú\u009a\u00917\u0087\u0004½ïP$FM|Ü\u0013\f\t¢?ô\u009eO\u008b¢µMÞæÈ\u0099òq\u001fà\t\u00853'\\ØFpp-\u009dÉ\u0087j±\u0007ÚõÄ.î\u001e\u001b®\u0005\u001d.úX\u008dBPoá\u0019Ñ\f52ÜYxOIu·\u0098s\u008e\u001a´ªÛGÁõ÷¯\u001a\u0019\u0000Ò6\u0099]0CÍi\u0090\u009c3\u0082Þ©cß\u0004Åüè{\u001e\u0002\u0004¬+GQ\u000e\u0019Ñ\f(2ÀYcO\u0005uï\u0098s\u008e\u001b´¾ÛGÁð÷¨\u001aE\u0019Î\f>2ÔY,O\\\u0019Ñ\f(2ÀYcO\u0005uï\u0098i\u008e\u0011´¢ÛNÁ\u00ad÷±\u001aW\u0000à6\u0099\u0019\u0099\f*2ÓY`O\nu¯\u0098y\u008eZ´©ÛGÁî÷¸\u001aP\u0000ù6\u0099],C°i\u008b\u009c=ÅÍÐnî\u008f\u0085\u0014\u0093u©ÚD\u0016Rthó\u0007\u0004\u001d©+\u00adÆ\u001aÜ \u0019Ñ\f=2ÆYoOIu\u00ad\u0098\u007f\u008e\u0010´§ÛIÁÝ÷¿\u001aY\u0000ô6\u008f]'CíiÖ\u009c*\u0082Á©jF\u009bS3mÀ\u0006n\u0010\u0012*³Ç|Ñ\u0010ë¢\u0084\\\u0019Ñ\f=2ÆYoOIu\u00ad\u0098u\u008e\u0001´ Û\\Áñ\u0019Ñ\f<2ÓYxO\u0007uï\u0098~\u008e\u001b´¹ÛFÁî÷³\u001aW\u0000ô6\u0099]kC°i\u009c\u009c\"\u0082\u0083©gß\u0010ÅÊèg\u001e@\u0004°+OQ\u0010OLZµd]\u000fþ\u0019\u0098#rÎäØ\u0099â&\u008dÜ\u0097q¡'LÄ½Û¨U\u0096¼ý\nëbÑË<\u000b*~\u0005W\u0010º.UEþS\u0081ii\u0084ñ\u0092\u009b¨;ÇÍÝ+ë*\u0006Â\u001cy*\nA«_tu\u001b\u0080§\u009e\u0005µãÃ\u0093ÙNô½\u0002Ø\u0018a7ÇM\u0095[=v\u0098\u008ca\u009a\u000b±ÛÏlå\u001bð¼\u000eI%ô3¨I\u001cdår\u008b\u0088)§ï½\u0099Ë;æÉ".getBytes(CharEncoding.ISO_8859_1)).asCharBuffer().get(cArr, 0, 1959);
        _CREATION = cArr;
        _BOUNDARY = -4335364178944062376L;
    }

    /* JADX WARN: Code duplicated, block: B:116:0x0ddf  */
    /* JADX WARN: Code duplicated, block: B:137:0x0f38  */
    /* JADX WARN: Code duplicated, block: B:193:0x1571  */
    /* JADX WARN: Code duplicated, block: B:272:0x28e9 A[Catch: all -> 0x0262, TryCatch #0 {all -> 0x0262, blocks: (B:6:0x012d, B:8:0x013a, B:9:0x017d, B:23:0x0368, B:25:0x0375, B:26:0x03ba, B:35:0x0513, B:37:0x0520, B:38:0x0560, B:64:0x0800, B:66:0x0806, B:67:0x0842, B:96:0x0b84, B:98:0x0b91, B:99:0x0bd8, B:108:0x0d4c, B:110:0x0d59, B:111:0x0da3, B:141:0x0fe6, B:143:0x0ff3, B:144:0x1032, B:162:0x1269, B:164:0x1276, B:165:0x12c1, B:175:0x13ab, B:177:0x13b8, B:178:0x13ff, B:197:0x15e3, B:199:0x15e9, B:200:0x162f, B:210:0x1765, B:212:0x1776, B:213:0x17bd, B:221:0x18e2, B:223:0x18ef, B:224:0x1933, B:226:0x193c, B:228:0x1954, B:229:0x19a0, B:270:0x28dc, B:272:0x28e9, B:273:0x292b, B:294:0x2e81, B:296:0x2e8e, B:297:0x2ecd, B:303:0x2fab, B:305:0x2fb8, B:306:0x2ffb, B:321:0x33a9, B:323:0x33b6, B:325:0x3416, B:351:0x3700, B:353:0x370d, B:354:0x374e, B:276:0x2937, B:278:0x294f, B:279:0x298f, B:238:0x267a, B:240:0x2687, B:242:0x26d9, B:43:0x0686, B:45:0x0693, B:46:0x06da, B:52:0x071a, B:54:0x0727, B:55:0x076a), top: B:372:0x012d }] */
    /* JADX WARN: Code duplicated, block: B:275:0x2934  */
    /* JADX WARN: Code duplicated, block: B:276:0x2937 A[Catch: all -> 0x0262, TryCatch #0 {all -> 0x0262, blocks: (B:6:0x012d, B:8:0x013a, B:9:0x017d, B:23:0x0368, B:25:0x0375, B:26:0x03ba, B:35:0x0513, B:37:0x0520, B:38:0x0560, B:64:0x0800, B:66:0x0806, B:67:0x0842, B:96:0x0b84, B:98:0x0b91, B:99:0x0bd8, B:108:0x0d4c, B:110:0x0d59, B:111:0x0da3, B:141:0x0fe6, B:143:0x0ff3, B:144:0x1032, B:162:0x1269, B:164:0x1276, B:165:0x12c1, B:175:0x13ab, B:177:0x13b8, B:178:0x13ff, B:197:0x15e3, B:199:0x15e9, B:200:0x162f, B:210:0x1765, B:212:0x1776, B:213:0x17bd, B:221:0x18e2, B:223:0x18ef, B:224:0x1933, B:226:0x193c, B:228:0x1954, B:229:0x19a0, B:270:0x28dc, B:272:0x28e9, B:273:0x292b, B:294:0x2e81, B:296:0x2e8e, B:297:0x2ecd, B:303:0x2fab, B:305:0x2fb8, B:306:0x2ffb, B:321:0x33a9, B:323:0x33b6, B:325:0x3416, B:351:0x3700, B:353:0x370d, B:354:0x374e, B:276:0x2937, B:278:0x294f, B:279:0x298f, B:238:0x267a, B:240:0x2687, B:242:0x26d9, B:43:0x0686, B:45:0x0693, B:46:0x06da, B:52:0x071a, B:54:0x0727, B:55:0x076a), top: B:372:0x012d }] */
    /* JADX WARN: Code duplicated, block: B:278:0x294f A[Catch: all -> 0x0262, TryCatch #0 {all -> 0x0262, blocks: (B:6:0x012d, B:8:0x013a, B:9:0x017d, B:23:0x0368, B:25:0x0375, B:26:0x03ba, B:35:0x0513, B:37:0x0520, B:38:0x0560, B:64:0x0800, B:66:0x0806, B:67:0x0842, B:96:0x0b84, B:98:0x0b91, B:99:0x0bd8, B:108:0x0d4c, B:110:0x0d59, B:111:0x0da3, B:141:0x0fe6, B:143:0x0ff3, B:144:0x1032, B:162:0x1269, B:164:0x1276, B:165:0x12c1, B:175:0x13ab, B:177:0x13b8, B:178:0x13ff, B:197:0x15e3, B:199:0x15e9, B:200:0x162f, B:210:0x1765, B:212:0x1776, B:213:0x17bd, B:221:0x18e2, B:223:0x18ef, B:224:0x1933, B:226:0x193c, B:228:0x1954, B:229:0x19a0, B:270:0x28dc, B:272:0x28e9, B:273:0x292b, B:294:0x2e81, B:296:0x2e8e, B:297:0x2ecd, B:303:0x2fab, B:305:0x2fb8, B:306:0x2ffb, B:321:0x33a9, B:323:0x33b6, B:325:0x3416, B:351:0x3700, B:353:0x370d, B:354:0x374e, B:276:0x2937, B:278:0x294f, B:279:0x298f, B:238:0x267a, B:240:0x2687, B:242:0x26d9, B:43:0x0686, B:45:0x0693, B:46:0x06da, B:52:0x071a, B:54:0x0727, B:55:0x076a), top: B:372:0x012d }] */
    /* JADX WARN: Code duplicated, block: B:282:0x29e7  */
    /* JADX WARN: Code duplicated, block: B:283:0x2a36  */
    /* JADX WARN: Code duplicated, block: B:316:0x30f6  */
    /* JADX WARN: Code duplicated, block: B:318:0x3395  */
    /* JADX WARN: Code duplicated, block: B:320:0x33a5  */
    /* JADX WARN: Code duplicated, block: B:323:0x33b6 A[Catch: all -> 0x0262, TryCatch #0 {all -> 0x0262, blocks: (B:6:0x012d, B:8:0x013a, B:9:0x017d, B:23:0x0368, B:25:0x0375, B:26:0x03ba, B:35:0x0513, B:37:0x0520, B:38:0x0560, B:64:0x0800, B:66:0x0806, B:67:0x0842, B:96:0x0b84, B:98:0x0b91, B:99:0x0bd8, B:108:0x0d4c, B:110:0x0d59, B:111:0x0da3, B:141:0x0fe6, B:143:0x0ff3, B:144:0x1032, B:162:0x1269, B:164:0x1276, B:165:0x12c1, B:175:0x13ab, B:177:0x13b8, B:178:0x13ff, B:197:0x15e3, B:199:0x15e9, B:200:0x162f, B:210:0x1765, B:212:0x1776, B:213:0x17bd, B:221:0x18e2, B:223:0x18ef, B:224:0x1933, B:226:0x193c, B:228:0x1954, B:229:0x19a0, B:270:0x28dc, B:272:0x28e9, B:273:0x292b, B:294:0x2e81, B:296:0x2e8e, B:297:0x2ecd, B:303:0x2fab, B:305:0x2fb8, B:306:0x2ffb, B:321:0x33a9, B:323:0x33b6, B:325:0x3416, B:351:0x3700, B:353:0x370d, B:354:0x374e, B:276:0x2937, B:278:0x294f, B:279:0x298f, B:238:0x267a, B:240:0x2687, B:242:0x26d9, B:43:0x0686, B:45:0x0693, B:46:0x06da, B:52:0x071a, B:54:0x0727, B:55:0x076a), top: B:372:0x012d }] */
    /* JADX WARN: Code duplicated, block: B:324:0x3410  */
    /* JADX WARN: Code duplicated, block: B:329:0x34be A[LOOP:6: B:319:0x33a3->B:329:0x34be, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:333:0x34da  */
    /* JADX WARN: Code duplicated, block: B:334:0x3558  */
    /* JADX WARN: Code duplicated, block: B:337:0x35c0 A[Catch: Exception -> 0x3620, TRY_LEAVE, TryCatch #5 {Exception -> 0x3620, blocks: (B:335:0x355a, B:337:0x35c0, B:339:0x35c6, B:341:0x360c, B:343:0x3612), top: B:382:0x355a }] */
    /* JADX WARN: Code duplicated, block: B:346:0x361e  */
    /* JADX WARN: Code duplicated, block: B:349:0x3624  */
    /* JADX WARN: Code duplicated, block: B:350:0x369a  */
    /* JADX WARN: Code duplicated, block: B:353:0x370d A[Catch: all -> 0x0262, TryCatch #0 {all -> 0x0262, blocks: (B:6:0x012d, B:8:0x013a, B:9:0x017d, B:23:0x0368, B:25:0x0375, B:26:0x03ba, B:35:0x0513, B:37:0x0520, B:38:0x0560, B:64:0x0800, B:66:0x0806, B:67:0x0842, B:96:0x0b84, B:98:0x0b91, B:99:0x0bd8, B:108:0x0d4c, B:110:0x0d59, B:111:0x0da3, B:141:0x0fe6, B:143:0x0ff3, B:144:0x1032, B:162:0x1269, B:164:0x1276, B:165:0x12c1, B:175:0x13ab, B:177:0x13b8, B:178:0x13ff, B:197:0x15e3, B:199:0x15e9, B:200:0x162f, B:210:0x1765, B:212:0x1776, B:213:0x17bd, B:221:0x18e2, B:223:0x18ef, B:224:0x1933, B:226:0x193c, B:228:0x1954, B:229:0x19a0, B:270:0x28dc, B:272:0x28e9, B:273:0x292b, B:294:0x2e81, B:296:0x2e8e, B:297:0x2ecd, B:303:0x2fab, B:305:0x2fb8, B:306:0x2ffb, B:321:0x33a9, B:323:0x33b6, B:325:0x3416, B:351:0x3700, B:353:0x370d, B:354:0x374e, B:276:0x2937, B:278:0x294f, B:279:0x298f, B:238:0x267a, B:240:0x2687, B:242:0x26d9, B:43:0x0686, B:45:0x0693, B:46:0x06da, B:52:0x071a, B:54:0x0727, B:55:0x076a), top: B:372:0x012d }] */
    /* JADX WARN: Code duplicated, block: B:357:0x37e9  */
    /* JADX WARN: Code duplicated, block: B:358:0x3845  */
    /* JADX WARN: Code duplicated, block: B:360:0x389c  */
    /* JADX WARN: Code duplicated, block: B:361:0x38ae  */
    /* JADX WARN: Code duplicated, block: B:398:0x34b9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:399:0x34d7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x0a33  */
    public static Object[] CoroutineDebuggingKt(Context context, int i, int i2, int i3) throws Throwable {
        Object obj;
        int i4;
        String str;
        int i5;
        int i6;
        String str2;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        char packedPositionGroup;
        int i14;
        int packedPositionType;
        char c;
        int i15;
        int i16;
        String str3;
        int i17;
        char c2;
        String str4;
        long j;
        Object[] objArr;
        int i18;
        char c3;
        char c4;
        Object[] objArr2;
        Object objAccessartificialFrame;
        Object objInvoke;
        Object objAccessartificialFrame2;
        long j2;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        String[][] strArr;
        char c5;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        Object objAccessartificialFrame3;
        int i29;
        int i30;
        int i31;
        int i32;
        File file;
        String str5;
        String[] strArr2;
        int length;
        int i33;
        int i34;
        Object objAccessartificialFrame4;
        int i35;
        int i36;
        int i37;
        int i38;
        int i39;
        int i40;
        Object[] objArr3;
        int i41;
        char cResolveSize;
        int i42;
        int i43 = i;
        int i44 = 2 % 2;
        char windowTouchSlop = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
        int i45 = -(-(ViewConfiguration.getTapTimeout() >> 16));
        int i46 = 1;
        int i47 = ((i45 | 717) << 1) - (i45 ^ 717);
        int i48 = 0;
        float f = 0.0f;
        int i49 = -(-(TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)));
        int i50 = ((i49 | 8) << 1) - (i49 ^ 8);
        Object[] objArr4 = new Object[1];
        a(windowTouchSlop, i47, i50, objArr4);
        String str6 = (String) objArr4[0];
        char c6 = (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 24591);
        int i51 = -Color.rgb(0, 0, 0);
        Object[] objArr5 = new Object[1];
        a(c6, ((i51 | ViewCompat.MEASURED_STATE_MASK) << 1) - (i51 ^ ViewCompat.MEASURED_STATE_MASK), KeyEvent.normalizeMetaState(0) + 27, objArr5);
        String str7 = (String) objArr5[0];
        char gidForName = (char) (42545 - Process.getGidForName(""));
        int i52 = -Color.blue(0);
        Object[] objArr6 = new Object[1];
        a(gidForName, ((i52 | 27) << 1) - (i52 ^ 27), 24 - (~(-(-(ViewConfiguration.getFadingEdgeLength() >> 16)))), objArr6);
        String str8 = (String) objArr6[0];
        int threadPriority = Process.getThreadPriority(0);
        int i53 = 9659 - (~(-(-(threadPriority * 242))));
        int i54 = ~threadPriority;
        int i55 = ~(((-21) ^ i54) | ((-21) & i54));
        int i56 = ~i43;
        int i57 = ~(((-21) ^ i56) | ((-21) & i56));
        int i58 = ((i55 ^ i57) | (i57 & i55)) * (-241);
        int i59 = (i53 ^ i58) + ((i53 & i58) << 1);
        int i60 = -(-((threadPriority | 20) * (-482)));
        int i61 = ((i59 | i60) << 1) - (i60 ^ i59);
        int i62 = ~((i54 ^ 20) | (i54 & 20));
        int i63 = ~(threadPriority | ((-21) & i56) | ((-21) ^ i56));
        int i64 = -(-(((i63 & i62) | (i62 ^ i63)) * 241));
        char c7 = 6;
        int i65 = -Color.rgb(0, 0, 0);
        Object[] objArr7 = new Object[1];
        a((char) (61866 - ((((i61 | i64) << 1) - (i64 ^ i61)) >> 6)), ((i65 | (-16777164)) << 1) - (i65 ^ (-16777164)), 17 - MotionEvent.axisFromString(""), objArr7);
        String str9 = (String) objArr7[0];
        char deadChar = (char) (24717 - KeyEvent.getDeadChar(0, 0));
        int i66 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 71;
        int keyRepeatTimeout = ViewConfiguration.getKeyRepeatTimeout() >> 16;
        Object[] objArr8 = new Object[1];
        a(deadChar, i66, (keyRepeatTimeout ^ 28) + ((keyRepeatTimeout & 28) << 1), objArr8);
        String[] strArr3 = {str7, str8, str9, (String) objArr8[0]};
        int i67 = 0;
        while (true) {
            obj = null;
            if (i67 >= 4) {
                i4 = i56;
                str = str6;
                i5 = i43;
                break;
            }
            try {
                Object[] objArr9 = {strArr3[i67]};
                Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-11453480);
                if (objAccessartificialFrame5 == null) {
                    int iRed = Color.red(i48) + 17;
                    char windowTouchSlop2 = (char) (24343 - (ViewConfiguration.getWindowTouchSlop() >> 8));
                    int i68 = 2015 - (AudioTrack.getMaxVolume() > f ? 1 : (AudioTrack.getMaxVolume() == f ? 0 : -1));
                    byte[] bArr = $$a;
                    byte b = bArr[7];
                    byte b2 = bArr[i48];
                    byte b3 = (byte) (-bArr[c7]);
                    Object[] objArr10 = new Object[i46];
                    b(b, b2, b3, objArr10);
                    String str10 = (String) objArr10[i48];
                    Class[] clsArr = new Class[i46];
                    clsArr[i48] = String.class;
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iRed, windowTouchSlop2, i68, 1614052816, false, str10, clsArr);
                }
                long jLongValue = ((Long) ((Method) objAccessartificialFrame5).invoke(null, objArr9)).longValue();
                int i69 = artificialFrame + 21;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i69 % 128;
                int i70 = i69 % 2;
                long j3 = 508009891;
                String[] strArr4 = strArr3;
                long j4 = 765;
                i4 = i56;
                str = str6;
                long j5 = -1;
                long j6 = j3 ^ j5;
                long j7 = jLongValue ^ j5;
                long j8 = j6 | j7;
                long j9 = i43;
                long j10 = j9 ^ j5;
                long j11 = (((long) (-1529)) * j3) + (((long) (-764)) * jLongValue) + ((((j8 | j10) ^ j5) | (((j6 | jLongValue) | j9) ^ j5) | (((j7 | j3) | j9) ^ j5)) * j4) + (((long) 1530) * ((j8 ^ j5) | ((j6 | j10) ^ j5))) + (j4 * ((j5 ^ ((j7 | j10) | j3)) | ((j6 | j9) ^ j5))) + ((long) 1054121146);
                int i71 = ~(575263243 | i43);
                int i72 = ~i43;
                int i73 = i71 | (~(2012489654 | i72));
                int i74 = ~((-575263244) | i72);
                int i75 = ((int) (j11 >> 32)) & (1891560098 + ((i73 | i74) * (-516)) + (((~((-1437869493) | i43)) | (~((-574620163) | i72))) * 516) + ((574620162 | i74) * 516));
                int i76 = ((int) j11) & ((-1517237377) + (((~((-2135151530) | i43)) | 1413611777 | (~(722589356 | i43))) * (-754)) + (((~((-1413611778) | i43)) | (~(2136201133 | i72))) * (-754)) + (((-2135151530) | i72) * 754));
                if (((i75 & i76) | (i75 ^ i76)) != 0) {
                    int i77 = ((i67 | FacebookRequestErrorClassification.EC_INVALID_TOKEN) << 1) - (i67 ^ FacebookRequestErrorClassification.EC_INVALID_TOKEN);
                    i5 = (i77 & i72) | ((~i77) & i43);
                    break;
                }
                i67++;
                strArr3 = strArr4;
                str6 = str;
                i56 = i4;
                i48 = 0;
                i46 = 1;
                f = 0.0f;
                c7 = 6;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
        int i78 = 3;
        if (i5 != i43) {
            Object[] objArr11 = {null, new int[]{(i | i) & (~(i & i))}, null, new int[]{i43}, new int[]{i5}};
            int i79 = ~i43;
            int i80 = 2100993017 + ((i43 | 453312741) * 988) + (((~(1062043895 | i79)) | (-1065326592)) * (-1976)) + (((~(i43 | 456595437)) | 453312741 | (~((-456595438) | i79))) * 988);
            int i81 = (i3 - (~((i80 ^ 16) + ((i80 & 16) << 1)))) - 1;
            int i82 = i81 ^ (i81 << 13);
            int i83 = i82 >>> 17;
            int i84 = ((~i82) & i83) | ((~i83) & i82);
            int i85 = i84 << 5;
            return objArr11;
        }
        Object[] objArr12 = new Object[1];
        a((char) KeyEvent.normalizeMetaState(0), ExpandableListView.getPackedPositionChild(0L) + 99, 11 - (~(-(-(ViewConfiguration.getLongPressTimeout() >> 16)))), objArr12);
        char c8 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
        int i86 = getARTIFICIAL_FRAME_PACKAGE_NAME + 91;
        artificialFrame = i86 % 128;
        int i87 = i86 % 2;
        int i88 = -(ViewConfiguration.getTapTimeout() >> 16);
        int i89 = (i88 & b.f39n) + (i88 | b.f39n);
        int i90 = -TextUtils.lastIndexOf("", '0');
        int i91 = ((i90 | 12) << 1) - (i90 ^ 12);
        Object[] objArr13 = new Object[1];
        a(c8, i89, i91, objArr13);
        char scrollDefaultDelay = (char) (ViewConfiguration.getScrollDefaultDelay() >> 16);
        int edgeSlop = ViewConfiguration.getEdgeSlop() >> 16;
        int i92 = (edgeSlop & 123) + (edgeSlop | 123);
        int i93 = -(ViewConfiguration.getScrollDefaultDelay() >> 16);
        int i94 = (i93 ^ 18) + ((i93 & 18) << 1);
        Object[] objArr14 = new Object[1];
        a(scrollDefaultDelay, i92, i94, objArr14);
        String[] strArr5 = {(String) objArr12[0], (String) objArr13[0], (String) objArr14[0]};
        int i95 = 0;
        while (true) {
            if (i95 >= i78) {
                i6 = i43;
                break;
            }
            Object[] objArr15 = {strArr5[i95]};
            Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(267846469);
            if (objAccessartificialFrame6 == null) {
                int iIndexOf = TextUtils.indexOf("", "") + 17;
                char bitsPerPixel = (char) (ImageFormat.getBitsPerPixel(0) + 24344);
                int edgeSlop2 = 2014 - (ViewConfiguration.getEdgeSlop() >> 16);
                byte[] bArr2 = $$a;
                byte b4 = (byte) (-bArr2[6]);
                byte b5 = bArr2[0];
                Object[] objArr16 = new Object[1];
                b(b4, b5, (byte) (b5 + 4), objArr16);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iIndexOf, bitsPerPixel, edgeSlop2, -1869462195, false, (String) objArr16[0], new Class[]{String.class});
            }
            long jLongValue2 = ((Long) ((Method) objAccessartificialFrame6).invoke(obj, objArr15)).longValue();
            long j12 = -668156612;
            long j13 = 983;
            long j14 = -1;
            long j15 = jLongValue2 ^ j14;
            long j16 = (((long) (-1965)) * j12) + (((long) 984) * jLongValue2) + ((j12 | j15) * j13);
            int i96 = i95;
            long j17 = j12 ^ j14;
            long jUptimeMillis = ((long) ((int) SystemClock.uptimeMillis())) ^ j14;
            long j18 = j16 + (((long) (-983)) * (j17 | ((j15 | jUptimeMillis) ^ j14))) + (j13 * (((j17 | jUptimeMillis) ^ j14) | (j14 ^ (jLongValue2 | j17)))) + ((long) (-643475364));
            int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
            int i97 = ((int) (j18 >> 32)) & ((((-1320242614) + (((~((-1149224412) | iMaxMemory)) | 2786763) * 1504)) + ((~(iMaxMemory | (-1146437649))) * (-1504))) - 1433822528);
            i6 = i;
            int i98 = ~i6;
            int i99 = (~((-817396732) | i98)) | 2118049 | (~(2040344154 | i98));
            int i100 = ((int) j18) & ((-1421700253) + (((~((-1225065473) | i6)) | i99) * 590) + (i99 * (-1180)) + (((~(i98 | 817396731)) | (~((-2040344155) | i98))) * 590));
            if (((i97 & i100) | (i97 ^ i100)) != 0) {
                i43 = i6 ^ (i96 + RotationOptions.ROTATE_270);
                break;
            }
            i95 = ((i96 | 1) << 1) - (i96 ^ 1);
            i43 = i6;
            i78 = 3;
            obj = null;
        }
        if (i43 != i6) {
            Object[] objArr17 = {null, new int[1], null, new int[]{i6}, new int[]{i43}};
            int iMyUid = Process.myUid();
            int i101 = ~iMyUid;
            int i102 = -(-((-960678932) + ((~(264604883 | i101)) * 979) + ((iMyUid | 870053341) * (-979)) + (((~(iMyUid | 264604883)) | (~(i101 | 870053341))) * 979) + 16));
            int i103 = ((i3 | i102) << 1) - (i3 ^ i102);
            int i104 = i103 << 13;
            int i105 = (i104 & (~i103)) | ((~i104) & i103);
            int i106 = i105 >>> 17;
            int i107 = ((~i105) & i106) | ((~i106) & i105);
            ((int[]) objArr17[1])[0] = i107 ^ (i107 << 5);
            return objArr17;
        }
        char modifierMetaStateMask = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1);
        int i108 = 140 - (~(-(-(ViewConfiguration.getFadingEdgeLength() >> 16))));
        int i109 = -(-(ViewConfiguration.getPressedStateDuration() >> 16));
        int i110 = ((i109 | 14) << 1) - (i109 ^ 14);
        Object[] objArr18 = new Object[1];
        a(modifierMetaStateMask, i108, i110, objArr18);
        Object[] objArr19 = {(String) objArr18[0]};
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-11453480);
        if (objAccessartificialFrame7 == null) {
            int maximumFlingVelocity = 17 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
            char offsetAfter = (char) (24343 - TextUtils.getOffsetAfter("", 0));
            int touchSlop = 2014 - (ViewConfiguration.getTouchSlop() >> 8);
            byte[] bArr3 = $$a;
            Object[] objArr20 = new Object[1];
            b(bArr3[7], bArr3[0], (byte) (-bArr3[6]), objArr20);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity, offsetAfter, touchSlop, 1614052816, false, (String) objArr20[0], new Class[]{String.class});
        }
        long jLongValue3 = ((Long) ((Method) objAccessartificialFrame7).invoke(null, objArr19)).longValue();
        long j19 = -100214997;
        long j20 = 672;
        long startUptimeMillis = (int) Process.getStartUptimeMillis();
        long j21 = -1;
        long j22 = startUptimeMillis ^ j21;
        long j23 = (((long) 673) * j19) + (((long) (-1343)) * jLongValue3) + ((((j19 | startUptimeMillis) ^ j21) | jLongValue3) * j20) + (((long) (-672)) * ((((j19 ^ j21) | j22) ^ j21) | ((startUptimeMillis | jLongValue3) ^ j21)));
        long j24 = jLongValue3 ^ j21;
        long j25 = j23 + (j20 * (((j24 | j19) ^ j21) | ((j24 | j22) ^ j21))) + ((long) 1662346034);
        int i111 = ~((int) SystemClock.elapsedRealtime());
        int i112 = ~((-945135605) | i111);
        int i113 = ((int) (j25 >> 32)) & ((-1503729290) + (((-1912605281) | i112) * 764) + (((~(i111 | (-1912605281))) | 1107296256) * (-1528)) + ((1247122836 | i112) * 764));
        int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
        if ((i113 | (((int) j25) & (1329636070 + (((~((~iFreeMemory) | (-1152870200))) | 1704870686) * (-235)) + (((~((-1152870200) | iFreeMemory)) | 1704870686) * (-470)) + (((~(iFreeMemory | (-2171938))) | 554172424) * 235)))) != 0) {
            i7 = (~(i6 & 266)) & (i6 | 266);
            str2 = "";
        } else {
            int iArgb = Color.argb(0, 0, 0, 0);
            char c9 = (char) (((iArgb | 6112) << 1) - (iArgb ^ 6112));
            str2 = "";
            int iIndexOf2 = TextUtils.indexOf((CharSequence) str2, '0') + 156;
            int trimmedLength = TextUtils.getTrimmedLength(str2);
            int iIPostMessageService = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
            int i114 = trimmedLength * (-167);
            int i115 = (i114 ^ (-4008)) + ((i114 & (-4008)) << 1);
            int i116 = ~trimmedLength;
            int i117 = -(-(((~((i116 & (-25)) | (i116 ^ (-25)))) | (~(((-25) ^ iIPostMessageService) | ((-25) & iIPostMessageService)))) * 336));
            int i118 = (i115 & i117) + (i117 | i115);
            int i119 = ~((trimmedLength ^ 24) | (trimmedLength & 24));
            int i120 = ~((trimmedLength ^ iIPostMessageService) | (trimmedLength & iIPostMessageService));
            int i121 = -(-(((i119 & i120) | (i119 ^ i120)) * (-168)));
            int i122 = ~iIPostMessageService;
            int i123 = ~((trimmedLength & i122) | (i122 ^ trimmedLength));
            Object[] objArr21 = new Object[1];
            a(c9, iIndexOf2, ((((i118 | i121) << 1) - (i121 ^ i118)) - (~(((i123 & (-25)) | ((-25) ^ i123)) * 168))) - 1, objArr21);
            Object[] objArr22 = {(String) objArr21[0]};
            Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1483923676);
            if (objAccessartificialFrame8 == null) {
                int packedPositionGroup2 = 23 - ExpandableListView.getPackedPositionGroup(0L);
                char fadingEdgeLength = (char) (ViewConfiguration.getFadingEdgeLength() >> 16);
                int deadChar2 = KeyEvent.getDeadChar(0, 0) + 2441;
                byte[] bArr4 = $$a;
                Object[] objArr23 = new Object[1];
                b((byte) (bArr4[3] + 1), bArr4[20], bArr4[15], objArr23);
                objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(packedPositionGroup2, fadingEdgeLength, deadChar2, 954751276, false, (String) objArr23[0], new Class[]{String.class});
            }
            String str11 = (String) ((Method) objAccessartificialFrame8).invoke(null, objArr22);
            if (str11 == null || str11.length() == 0) {
                char maxKeyCode = (char) (KeyEvent.getMaxKeyCode() >> 16);
                int i124 = -ExpandableListView.getPackedPositionGroup(0L);
                Object[] objArr24 = new Object[1];
                a(maxKeyCode, (i124 ^ 179) + ((i124 & 179) << 1), (ViewConfiguration.getEdgeSlop() >> 16) + 24, objArr24);
                Object[] objArr25 = {(String) objArr24[0]};
                Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                if (objAccessartificialFrame9 == null) {
                    int minimumFlingVelocity = 23 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                    char keyRepeatTimeout2 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                    int i125 = 2442 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                    byte[] bArr5 = $$a;
                    Object[] objArr26 = new Object[1];
                    b((byte) (bArr5[3] + 1), bArr5[20], bArr5[15], objArr26);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity, keyRepeatTimeout2, i125, 954751276, false, (String) objArr26[0], new Class[]{String.class});
                }
                String str12 = (String) ((Method) objAccessartificialFrame9).invoke(null, objArr25);
                i7 = (str12 == null || str12.length() == 0) ? i6 : i6 ^ 267;
            } else {
                i7 = (i6 & (-268)) | ((~i6) & 267);
            }
        }
        if (i7 != i6) {
            Object[] objArr27 = {null, new int[1], null, new int[]{i6}, new int[]{i7}};
            int iFreeMemory2 = (int) Runtime.getRuntime().freeMemory();
            int i126 = ~iFreeMemory2;
            int i127 = 1969322785 + (((~(122646000 | i126)) | 673223178) * 168) + ((~((-673223179) | iFreeMemory2)) * 168) + (((~(iFreeMemory2 | 795869178)) | (~(i126 | (-728094459))) | 54871280) * 168);
            int i128 = (i3 - (~(-(-((i127 & 16) + (i127 | 16)))))) - 1;
            int i129 = i128 ^ (i128 << 13);
            int i130 = i129 >>> 17;
            int i131 = ((~i129) & i130) | ((~i130) & i129);
            int i132 = i131 << 5;
            ((int[]) objArr27[1])[0] = ((~i131) & i132) | ((~i132) & i131);
            return objArr27;
        }
        Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(943212816);
        if (objAccessartificialFrame10 == null) {
            int offsetBefore = TextUtils.getOffsetBefore(str2, 0) + 7;
            char cIndexOf = (char) (TextUtils.indexOf(str2, str2) + 49362);
            int maximumFlingVelocity2 = 1768 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
            byte b6 = (byte) ($$b & 175);
            byte[] bArr6 = $$a;
            Object[] objArr28 = new Object[1];
            b(b6, bArr6[17], bArr6[7], objArr28);
            objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(offsetBefore, cIndexOf, maximumFlingVelocity2, -1487073512, false, (String) objArr28[0], new Class[0]);
        }
        long jLongValue4 = ((Long) ((Method) objAccessartificialFrame10).invoke(null, null)).longValue();
        long j26 = 106727841;
        long j27 = (((long) 477) * j26) + (((long) (-475)) * jLongValue4);
        long j28 = ((j26 ^ j21) | jLongValue4) ^ j21;
        long j29 = jLongValue4 ^ j21;
        String str13 = str2;
        long jMaxMemory = (int) Runtime.getRuntime().maxMemory();
        long j30 = ((j29 | j26) | jMaxMemory) ^ j21;
        long j31 = j27 + (((long) (-476)) * (j28 | j30)) + (((long) 952) * j30) + (((long) 476) * (((j29 | (jMaxMemory ^ j21)) | j26) ^ j21)) + ((long) 1269163909);
        int i133 = 1704617878 + (((~(351497465 | i)) | (-1425534202)) * 305);
        int i134 = ~i;
        int i135 = ((int) (j31 >> 32)) & (i133 + (((~(351497465 | i134)) | (-1085728946)) * 305));
        int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
        int i136 = ((int) j31) & (1894732197 + (((~((-202817817) | (~startElapsedRealtime))) | (~((-1640044227) | startElapsedRealtime))) * (-272)) + (((~((-471785790) | startElapsedRealtime)) | 268967973) * (-272)) + (((~(startElapsedRealtime | 471785789)) | (-1909012200)) * 272));
        int i137 = (i135 & i136) | (i135 ^ i136);
        if (i137 != 0) {
            int i138 = (-2) - (i137 ^ (-1));
            i8 = 1;
            i9 = i ^ ((i138 ^ 200) + ((i138 & 200) << 1));
        } else {
            i8 = 1;
            i9 = i;
        }
        if (i9 != i) {
            objArr3 = new Object[5];
            int[] iArr = new int[i8];
            objArr3[i8] = iArr;
            int[] iArr2 = new int[i8];
            objArr3[3] = iArr2;
            int i139 = artificialFrame;
            int i140 = (i139 ^ 89) + ((i139 & 89) << i8);
            getARTIFICIAL_FRAME_PACKAGE_NAME = i140 % 128;
            int i141 = i140 % 2;
            int[] iArr3 = new int[i8];
            objArr3[4] = iArr3;
            int i142 = ((i139 | 63) << i8) - (i139 ^ 63);
            getARTIFICIAL_FRAME_PACKAGE_NAME = i142 % 128;
            int i143 = i142 % 2;
            iArr2[0] = i;
            iArr3[0] = i9;
            objArr3[0] = null;
            objArr3[2] = null;
            int i144 = 15029622 + (((~(i134 | (-345345490))) | 269812929) * (-245));
            int i145 = ~((-345345490) | i);
            int i146 = (i3 - (~(((i144 + (i145 * (-245))) + ((i145 | 260102968) * 245)) + 16))) - 1;
            int i147 = i146 << 13;
            int i148 = (i146 | i147) & (~(i146 & i147));
            int i149 = i148 ^ (i148 >>> 17);
            int i150 = i149 << 5;
            iArr[0] = (i149 | i150) & (~(i149 & i150));
        } else {
            int i151 = -((byte) KeyEvent.getModifierMetaStateMask());
            int i152 = 202 - (~(-(-(ViewConfiguration.getMinimumFlingVelocity() >> 16))));
            int i153 = -(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
            Object[] objArr29 = new Object[1];
            a((char) ((i151 & 63012) + (i151 | 63012)), i152, (i153 & 21) + (i153 | 21), objArr29);
            String str14 = (String) objArr29[0];
            char offsetAfter2 = (char) TextUtils.getOffsetAfter(str13, 0);
            int i154 = -(ViewConfiguration.getKeyRepeatTimeout() >> 16);
            int i155 = (i154 ^ 223) + ((i154 & 223) << 1);
            int i156 = -View.resolveSizeAndState(0, 0, 0);
            int i157 = (i156 & 6) + (i156 | 6);
            Object[] objArr30 = new Object[1];
            a(offsetAfter2, i155, i157, objArr30);
            String str15 = (String) objArr30[0];
            File file2 = new File(str14);
            if (!(!file2.exists()) && file2.isFile()) {
                try {
                    Scanner scanner = new Scanner(new FileInputStream(file2));
                    int i158 = -(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                    int i159 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                    int i160 = ((i159 | 229) << 1) - (i159 ^ 229);
                    int i161 = -(ViewConfiguration.getEdgeSlop() >> 16);
                    int i162 = (i161 ^ 2) + ((i161 & 2) << 1);
                    Object[] objArr31 = new Object[1];
                    a((char) ((i158 & 60154) + (i158 | 60154)), i160, i162, objArr31);
                    Scanner scannerUseDelimiter = scanner.useDelimiter((String) objArr31[0]);
                    String next = scannerUseDelimiter.hasNext() ? scannerUseDelimiter.next() : str13;
                    scannerUseDelimiter.close();
                    if (next.contains(str15)) {
                        i10 = i ^ 262;
                    } else {
                        i10 = i;
                    }
                } catch (IOException unused) {
                }
            } else {
                i10 = i;
            }
            if (i10 != i) {
                int i163 = artificialFrame;
                int i164 = ((i163 | 65) << 1) - (i163 ^ 65);
                getARTIFICIAL_FRAME_PACKAGE_NAME = i164 % 128;
                int i165 = i164 % 2;
                Object[] objArr32 = {null, new int[1], null, new int[]{i}, new int[]{i10}};
                int iNextInt = new Random().nextInt();
                int i166 = i3 + (-208875047) + (((~((-184234816) | iNextInt)) | (-421213643)) * (-964)) + (((~((~iNextInt) | (-184234816))) | 48235061) * (-964)) + 16;
                int i167 = i166 << 13;
                int i168 = ((~i166) & i167) | ((~i167) & i166);
                int i169 = i168 >>> 17;
                int i170 = ((~i168) & i169) | ((~i169) & i168);
                int i171 = getARTIFICIAL_FRAME_PACKAGE_NAME + 21;
                artificialFrame = i171 % 128;
                if (i171 % 2 == 0) {
                    int i172 = i170 >> 4;
                    ((int[]) objArr32[1])[1] = ((~i170) & i172) | ((~i172) & i170);
                    return objArr32;
                }
                int i173 = i170 << 5;
                ((int[]) objArr32[1])[0] = (i170 | i173) & (~(i170 & i173));
                return objArr32;
            }
            char scrollDefaultDelay2 = (char) (ViewConfiguration.getScrollDefaultDelay() >> 16);
            int iIndexOf3 = TextUtils.indexOf(str13, str13, 0);
            Object[] objArr33 = new Object[1];
            a(scrollDefaultDelay2, (iIndexOf3 & 231) + (iIndexOf3 | 231), 30 - (~Color.green(0)), objArr33);
            String str16 = (String) objArr33[0];
            int i174 = -(-(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
            int i175 = -Process.getGidForName(str13);
            Object[] objArr34 = new Object[1];
            a((char) ((i174 ^ 34542) + ((i174 & 34542) << 1)), (i175 & 261) + (i175 | 261), 23 - (~(-(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)))), objArr34);
            String str17 = (String) objArr34[0];
            char threadPriority2 = (char) ((Process.getThreadPriority(0) + 20) >> 6);
            int i176 = -(ViewConfiguration.getKeyRepeatTimeout() >> 16);
            Object[] objArr35 = new Object[1];
            a(threadPriority2, ((i176 | 285) << 1) - (i176 ^ 285), 27 - (~(-(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)))), objArr35);
            String str18 = (String) objArr35[0];
            int i177 = -(ViewConfiguration.getTapTimeout() >> 16);
            int packedPositionGroup3 = ExpandableListView.getPackedPositionGroup(0L);
            int i178 = ((packedPositionGroup3 | 313) << 1) - (packedPositionGroup3 ^ 313);
            int i179 = -Process.getGidForName(str13);
            int i180 = (i179 & 13) + (i179 | 13);
            Object[] objArr36 = new Object[1];
            a((char) (((i177 | 44590) << 1) - (i177 ^ 44590)), i178, i180, objArr36);
            String[] strArr6 = {str16, str17, str18, (String) objArr36[0]};
            int i181 = 0;
            int i182 = 4;
            while (true) {
                if (i181 >= i182) {
                    i11 = i;
                    break;
                }
                Object[] objArr37 = {strArr6[i181]};
                Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-11453480);
                if (objAccessartificialFrame11 == null) {
                    int offsetBefore2 = TextUtils.getOffsetBefore(str13, 0) + 17;
                    char cCombineMeasuredStates = (char) (View.combineMeasuredStates(0, 0) + 24343);
                    int maxKeyCode2 = (KeyEvent.getMaxKeyCode() >> 16) + 2014;
                    byte[] bArr7 = $$a;
                    Object[] objArr38 = new Object[1];
                    b(bArr7[7], bArr7[0], (byte) (-bArr7[6]), objArr38);
                    objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(offsetBefore2, cCombineMeasuredStates, maxKeyCode2, 1614052816, false, (String) objArr38[0], new Class[]{String.class});
                }
                long jLongValue5 = ((Long) ((Method) objAccessartificialFrame11).invoke(null, objArr37)).longValue();
                long j32 = 1424680287;
                long j33 = jLongValue5 ^ j21;
                String[] strArr7 = strArr6;
                int i183 = i181;
                long jMyUid = (((long) Process.myUid()) | jLongValue5) ^ j21;
                long j34 = (((long) (-391)) * j32) + (((long) (-195)) * jLongValue5) + (((long) (-196)) * (((j33 | j32) ^ j21) | jMyUid)) + (((long) 392) * (jLongValue5 | j32)) + (((long) 196) * (jMyUid | (((j32 ^ j21) | j33) ^ j21))) + ((long) 137450750);
                int i184 = ((int) (j34 >> 32)) & ((-1431292994) + ((~(1857340856 | i134)) * 979) + (((-1000400029) | i) * (-979)) + (((~(1857340856 | i)) | (~((-1000400029) | i134))) * 979));
                int elapsedCpuTime = (int) Process.getElapsedCpuTime();
                int i185 = ~((-335609874) | elapsedCpuTime);
                int i186 = ((int) j34) & (1631139001 + ((1099991424 | i185) * (-476)) + (i185 * 952) + ((~((~elapsedCpuTime) | (-335609874))) * 476));
                if (((i184 & i186) | (i184 ^ i186)) != 0) {
                    int i187 = i183 + 252;
                    i11 = ((~i187) & i) | (i187 & i134);
                    break;
                }
                i181 = (((i183 | (-38)) << 1) - (i183 ^ (-38))) + 39;
                strArr6 = strArr7;
                i182 = 4;
            }
            if (i11 != i) {
                int i188 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i189 = i188 + 113;
                artificialFrame = i189 % 128;
                int i190 = i189 % 2;
                Object[] objArr39 = {null, new int[1], null, new int[]{i}, new int[]{i11}};
                int i191 = i188 + 105;
                artificialFrame = i191 % 128;
                int i192 = i191 % 2;
                int iUptimeMillis = (int) SystemClock.uptimeMillis();
                int i193 = ~iUptimeMillis;
                int i194 = (~(117232683 | i193)) | (-805305664) | (~(722681141 | i193));
                int i195 = -(-((-1022469253) + (((~(iUptimeMillis | (-34608162))) | i194) * 590) + (i194 * (-1180)) + (((~((-722681142) | i193)) | (~(i193 | (-117232684)))) * 590) + 16));
                int i196 = ((i3 | i195) << 1) - (i3 ^ i195);
                int i197 = i196 << 13;
                int i198 = (i197 | i196) & (~(i196 & i197));
                int i199 = i198 ^ (i198 >>> 17);
                int i200 = i199 << 5;
                ((int[]) objArr39[1])[0] = (i199 | i200) & (~(i199 & i200));
                return objArr39;
            }
            int threadPriority3 = Process.getThreadPriority(0);
            int i201 = ((threadPriority3 & 20) + (threadPriority3 | 20)) >> 6;
            char c10 = (char) ((i201 & 56330) + (56330 | i201));
            int i202 = -(-(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
            int i203 = (i202 & 326) + (i202 | 326);
            int i204 = -(-TextUtils.lastIndexOf(str13, '0'));
            Object[] objArr40 = new Object[1];
            a(c10, i203, (i204 & 14) + (i204 | 14), objArr40);
            Object[] objArr41 = {(String) objArr40[0]};
            Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-1483923676);
            if (objAccessartificialFrame12 == null) {
                int iIndexOf4 = 22 - TextUtils.indexOf((CharSequence) str13, '0');
                char c11 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1);
                int bitsPerPixel2 = ImageFormat.getBitsPerPixel(0) + 2442;
                byte[] bArr8 = $$a;
                Object[] objArr42 = new Object[1];
                b((byte) (bArr8[3] + 1), bArr8[20], bArr8[15], objArr42);
                objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iIndexOf4, c11, bitsPerPixel2, 954751276, false, (String) objArr42[0], new Class[]{String.class});
            }
            String str19 = (String) ((Method) objAccessartificialFrame12).invoke(null, objArr41);
            if (str19 != null) {
                Object[] objArr43 = new Object[1];
                a((char) (ViewConfiguration.getScrollBarFadeDuration() >> 16), View.MeasureSpec.getMode(0) + 340, 9 - (~(-(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)))), objArr43);
                if (str19.contains((String) objArr43[0])) {
                    i12 = (i & (-251)) | (i134 & ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
                } else {
                    i12 = i;
                }
            } else {
                i12 = i;
            }
            if (i12 != i) {
                Object[] objArr44 = {null, new int[1], null, new int[]{i}, new int[]{i12}};
                int iUptimeMillis2 = (int) SystemClock.uptimeMillis();
                int i205 = ~iUptimeMillis2;
                int i206 = 909249552 + (((~((-391593162) | i205)) | 213855296) * 226) + (((~(i205 | (-322965642))) | (~((-213855297) | iUptimeMillis2)) | 145227776) * (-113)) + ((~(iUptimeMillis2 | (-391593162))) * 113);
                int i207 = -(-(((i206 | 16) << 1) - (i206 ^ 16)));
                int i208 = ((i3 | i207) << 1) - (i3 ^ i207);
                int i209 = i208 << 13;
                int i210 = (i209 | i208) & (~(i208 & i209));
                int i211 = i210 >>> 17;
                int i212 = (i210 | i211) & (~(i210 & i211));
                int i213 = i212 << 5;
                ((int[]) objArr44[1])[0] = ((~i212) & i213) | ((~i213) & i212);
                return objArr44;
            }
            char cMyTid = (char) (Process.myTid() >> 22);
            int i214 = -(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
            int i215 = ((i214 | 350) << 1) - (i214 ^ 350);
            int i216 = -(ViewConfiguration.getLongPressTimeout() >> 16);
            int i217 = ((i216 | 17) << 1) - (i216 ^ 17);
            Object[] objArr45 = new Object[1];
            a(cMyTid, i215, i217, objArr45);
            String str20 = (String) objArr45[0];
            char cResolveOpacity = (char) (Drawable.resolveOpacity(0, 0) + 54039);
            int bitsPerPixel3 = ImageFormat.getBitsPerPixel(0) + 367;
            int i218 = -MotionEvent.axisFromString(str13);
            int i219 = ((i218 | 5) << 1) - (i218 ^ 5);
            Object[] objArr46 = new Object[1];
            a(cResolveOpacity, bitsPerPixel3, i219, objArr46);
            String str21 = (String) objArr46[0];
            File file3 = new File(str20);
            if (file3.exists() && file3.isFile()) {
                try {
                    Scanner scanner2 = new Scanner(new FileInputStream(file3));
                    int i220 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i221 = (i220 ^ 65) + ((i220 & 65) << 1);
                    artificialFrame = i221 % 128;
                    if (i221 % 2 == 0) {
                        cResolveSize = (char) (60153 << View.resolveSize(1, 0));
                        i42 = 14949;
                        i41 = 1;
                    } else {
                        int i222 = -View.resolveSize(0, 0);
                        i41 = 1;
                        cResolveSize = (char) (((i222 | 60153) << 1) - (i222 ^ 60153));
                        i42 = 230;
                    }
                    int bitsPerPixel4 = ImageFormat.getBitsPerPixel(0);
                    int i223 = (i42 ^ bitsPerPixel4) + ((i42 & bitsPerPixel4) << i41);
                    int i224 = -ImageFormat.getBitsPerPixel(0);
                    int i225 = ((i224 | 1) << i41) - (i224 ^ i41);
                    Object[] objArr47 = new Object[i41];
                    a(cResolveSize, i223, i225, objArr47);
                    Scanner scannerUseDelimiter2 = scanner2.useDelimiter((String) objArr47[0]);
                    String next2 = scannerUseDelimiter2.hasNext() ? scannerUseDelimiter2.next() : str13;
                    scannerUseDelimiter2.close();
                    if (!next2.contains(str21)) {
                        i13 = i;
                    } else {
                        i13 = (i & (-252)) | (i134 & 251);
                    }
                } catch (IOException unused2) {
                }
            } else {
                i13 = i;
            }
            if (i13 == i) {
                int offsetAfter3 = TextUtils.getOffsetAfter(str13, 0);
                int i226 = getARTIFICIAL_FRAME_PACKAGE_NAME + 99;
                artificialFrame = i226 % 128;
                int i227 = i226 % 2;
                int i228 = -offsetAfter3;
                int i229 = -(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                Object[] objArr48 = new Object[1];
                a((char) ((64352 ^ i228) + ((i228 & 64352) << 1)), ((i229 | 373) << 1) - (i229 ^ 373), 23 - (~(-(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)))), objArr48);
                Object[] objArr49 = {(String) objArr48[0]};
                Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                if (objAccessartificialFrame13 == null) {
                    int modifierMetaStateMask2 = 22 - ((byte) KeyEvent.getModifierMetaStateMask());
                    char cCombineMeasuredStates2 = (char) View.combineMeasuredStates(0, 0);
                    int iLastIndexOf = 2440 - TextUtils.lastIndexOf(str13, '0', 0);
                    byte[] bArr9 = $$a;
                    Object[] objArr50 = new Object[1];
                    b((byte) (bArr9[3] + 1), bArr9[20], bArr9[15], objArr50);
                    objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask2, cCombineMeasuredStates2, iLastIndexOf, 954751276, false, (String) objArr50[0], new Class[]{String.class});
                }
                String lowerCase = ((String) ((Method) objAccessartificialFrame13).invoke(null, objArr49)).toLowerCase();
                int i230 = -(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                int i231 = 395 - (~(-(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))));
                int i232 = -(ViewConfiguration.getKeyRepeatTimeout() >> 16);
                Object[] objArr51 = new Object[1];
                a((char) ((i230 & 1) + (i230 | 1)), i231, (i232 & 4) + (i232 | 4), objArr51);
                int i233 = lowerCase.contains((String) objArr51[0]) ? (i & (-265)) | (i134 & 264) : i;
                if (i233 != i) {
                    Object[] objArr52 = {null, new int[1], null, new int[]{i}, new int[]{i233}};
                    int i234 = (int) Runtime.getRuntime().totalMemory();
                    int i235 = 674190584 + (((~((-806884371) | i234)) | (~((-201435913) | i234))) * 69) + (((~(i234 | (-226864077))) | (~((-832312535) | i234)) | 25428164) * (-69)) + 1685801205;
                    int i236 = ((i3 | i235) << 1) - (i3 ^ i235);
                    int i237 = i236 << 13;
                    int i238 = ((~i236) & i237) | ((~i237) & i236);
                    int i239 = i238 ^ (i238 >>> 17);
                    int i240 = artificialFrame + 51;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i240 % 128;
                    if (i240 % 2 == 0) {
                        ((int[]) objArr52[1])[0] = i239 ^ (i239 << 5);
                        return objArr52;
                    }
                    int i241 = i239 * 3;
                    ((int[]) objArr52[1])[1] = ((~i239) & i241) | ((~i241) & i239);
                    return objArr52;
                }
                String[] strArr8 = new String[6];
                char c12 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                int iBlue = Color.blue(0);
                int i242 = artificialFrame + 85;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i242 % 128;
                int i243 = i242 % 2;
                int i244 = (399 & iBlue) + (399 | iBlue);
                int threadPriority4 = Process.getThreadPriority(0);
                int i245 = -((((threadPriority4 | 20) << 1) - (threadPriority4 ^ 20)) >> 6);
                int i246 = ((i245 | 42) << 1) - (i245 ^ 42);
                Object[] objArr53 = new Object[1];
                a(c12, i244, i246, objArr53);
                strArr8[0] = (String) objArr53[0];
                int i247 = -(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                int i248 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                int i249 = ((i248 | 440) << 1) - (i248 ^ 440);
                int i250 = -(-(Process.myTid() >> 22));
                Object[] objArr54 = new Object[1];
                a((char) ((i247 & 1) + (i247 | 1)), i249, (i250 & 40) + (i250 | 40), objArr54);
                strArr8[1] = (String) objArr54[0];
                char cResolveSizeAndState = (char) View.resolveSizeAndState(0, 0, 0);
                int i251 = 480 - (~(ViewConfiguration.getJumpTapTimeout() >> 16));
                int i252 = -(Process.myTid() >> 22);
                Object[] objArr55 = new Object[1];
                a(cResolveSizeAndState, i251, (i252 & 27) + (i252 | 27), objArr55);
                strArr8[2] = (String) objArr55[0];
                Object[] objArr56 = new Object[1];
                a((char) (28689 - (~(-(-Color.blue(0))))), 508 - (ViewConfiguration.getFadingEdgeLength() >> 16), 28 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), objArr56);
                strArr8[3] = (String) objArr56[0];
                char windowTouchSlop3 = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                int i253 = 534 - (~(-TextUtils.getTrimmedLength(str13)));
                int i254 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i255 = ((i254 | 9) << 1) - (i254 ^ 9);
                artificialFrame = i255 % 128;
                int i256 = i255 % 2;
                int keyRepeatDelay = ViewConfiguration.getKeyRepeatDelay();
                if (i256 == 0) {
                    int i257 = -(keyRepeatDelay / 63);
                    int i258 = (i257 ^ 27) + ((i257 & 27) << 1);
                    Object[] objArr57 = new Object[1];
                    a(windowTouchSlop3, i253, i258, objArr57);
                    strArr8[4] = (String) objArr57[0];
                    packedPositionGroup = (char) (15088 >>> ExpandableListView.getPackedPositionGroup(0L));
                    packedPositionType = ExpandableListView.getPackedPositionType(1L);
                    i14 = 8560;
                    c = 3;
                } else {
                    Object[] objArr58 = new Object[1];
                    a(windowTouchSlop3, i253, 27 - (keyRepeatDelay >> 16), objArr58);
                    strArr8[4] = (String) objArr58[0];
                    packedPositionGroup = (char) (21517 - (~(-ExpandableListView.getPackedPositionGroup(0L))));
                    i14 = 562;
                    packedPositionType = ExpandableListView.getPackedPositionType(0L);
                    c = 5;
                }
                int i259 = -(-packedPositionType);
                int i260 = (i14 & i259) + (i259 | i14);
                int i261 = -View.MeasureSpec.getMode(0);
                int i262 = ((i261 | 27) << 1) - (i261 ^ 27);
                Object[] objArr59 = new Object[1];
                a(packedPositionGroup, i260, i262, objArr59);
                strArr8[c] = (String) objArr59[0];
                int i263 = 0;
                while (true) {
                    if (i263 >= 6) {
                        i15 = i;
                        break;
                    }
                    Object[] objArr60 = {strArr8[i263]};
                    Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                    if (objAccessartificialFrame14 == null) {
                        int iLastIndexOf2 = 22 - TextUtils.lastIndexOf(str13, '0', 0, 0);
                        char c13 = (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1);
                        int iArgb2 = Color.argb(0, 0, 0, 0) + 2441;
                        byte[] bArr10 = $$a;
                        Object[] objArr61 = new Object[1];
                        b((byte) (bArr10[3] + 1), bArr10[20], bArr10[15], objArr61);
                        objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(iLastIndexOf2, c13, iArgb2, 954751276, false, (String) objArr61[0], new Class[]{String.class});
                    }
                    String str22 = (String) ((Method) objAccessartificialFrame14).invoke(null, objArr60);
                    if (str22 != null && str22.length() != 0) {
                        Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                        i15 = (i & (-266)) | (i134 & 265);
                        break;
                    }
                    i263++;
                }
                if (i15 != i) {
                    Object[] objArr62 = {null, new int[1], null, new int[]{i}, new int[]{i15}};
                    int iNextInt2 = new Random().nextInt();
                    int i264 = -(-(((1558326695 + (((~iNextInt2) | (-336152806)) * 1444)) + (((~(iNextInt2 | 403607575)) | ((~(201840882 | iNextInt2)) | (-470800632))) * (-1444))) - 2110810646));
                    int i265 = (i3 ^ i264) + ((i3 & i264) << 1);
                    int i266 = (i265 << 13) ^ i265;
                    int i267 = i266 >>> 17;
                    int i268 = ((~i266) & i267) | ((~i267) & i266);
                    ((int[]) objArr62[1])[0] = i268 ^ (i268 << 5);
                    return objArr62;
                }
                Object[] objArr63 = new Object[1];
                a((char) View.MeasureSpec.makeMeasureSpec(0, 0), 349 - TextUtils.indexOf(str13, str13), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 16, objArr63);
                String str23 = (String) objArr63[0];
                int iIndexOf5 = TextUtils.indexOf(str13, str13, 0, 0);
                char c14 = (char) (((iIndexOf5 | 61549) << 1) - (61549 ^ iIndexOf5));
                int i269 = -(-(ViewConfiguration.getJumpTapTimeout() >> 16));
                int i270 = (i269 ^ 589) + ((i269 & 589) << 1);
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                int i271 = artificialFrame + 45;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i271 % 128;
                int i272 = i271 % 2;
                Object[] objArr64 = new Object[1];
                a(c14, i270, 6 - (~(-(jElapsedRealtime > 0L ? 1 : (jElapsedRealtime == 0L ? 0 : -1)))), objArr64);
                Object[] objArr65 = {str23, (String) objArr64[0]};
                Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-883653127);
                if (objAccessartificialFrame15 == null) {
                    int scrollBarFadeDuration = 31 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    char offsetAfter4 = (char) (TextUtils.getOffsetAfter(str13, 0) + 57022);
                    int iLastIndexOf3 = 2310 - TextUtils.lastIndexOf(str13, '0');
                    byte b7 = (byte) ($$b & 19);
                    byte b8 = $$a[20];
                    Object[] objArr66 = new Object[1];
                    b(b7, b8, (byte) (b8 + 5), objArr66);
                    objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration, offsetAfter4, iLastIndexOf3, 1412547569, false, (String) objArr66[0], new Class[]{String.class, String.class});
                }
                long jLongValue6 = ((Long) ((Method) objAccessartificialFrame15).invoke(null, objArr65)).longValue();
                long j35 = 250708656;
                long j36 = j35 ^ j21;
                long j37 = i;
                long j38 = (jLongValue6 | j37) ^ j21;
                long j39 = (((long) (-109)) * j35) + (((long) b.f40o) * jLongValue6) + (((long) (-220)) * (j36 | j38)) + (((long) 220) * (((j35 | jLongValue6) ^ j21) | j38)) + (((long) b.f39n) * ((((jLongValue6 ^ j21) | j35) ^ j21) | ((j36 | jLongValue6) ^ j21))) + ((long) (-405460285));
                int startUptimeMillis2 = (int) Process.getStartUptimeMillis();
                int i273 = 341660302 + (((~((~startUptimeMillis2) | (-1575370816))) | 136462356) * (-245));
                int i274 = ~(startUptimeMillis2 | (-1575370816));
                int i275 = ((int) (j39 >> 32)) & (i273 + (i274 * (-245)) + ((i274 | (-138144405)) * 245));
                int iUptimeMillis3 = (int) SystemClock.uptimeMillis();
                int i276 = 1575678741 + (((~((-1156917816) | iUptimeMillis3)) | (-280308595)) * 672);
                int i277 = ~iUptimeMillis3;
                int i278 = ((int) j39) & (i276 + (((~(iUptimeMillis3 | (-280308595))) | (~(1156917815 | i277))) * (-672)) + (((~(280308594 | i277)) | 1145044997) * 672));
                if (((i275 & i278) | (i275 ^ i278)) != 0) {
                    i16 = i134;
                    i17 = (i & (-261)) | (i16 & 260);
                    str3 = str13;
                } else {
                    i16 = i134;
                    char keyRepeatTimeout3 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                    str3 = str13;
                    int i279 = -TextUtils.getOffsetBefore(str3, 0);
                    Object[] objArr67 = new Object[1];
                    a(keyRepeatTimeout3, (i279 & 595) + (i279 | 595), 12 - (~(-View.resolveSize(0, 0))), objArr67);
                    String str24 = (String) objArr67[0];
                    char capsMode = (char) (TextUtils.getCapsMode(str3, 0, 0) + 31539);
                    int i280 = -(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                    int i281 = (i280 ^ TypedValues.MotionType.TYPE_DRAW_PATH) + ((i280 & TypedValues.MotionType.TYPE_DRAW_PATH) << 1);
                    int i282 = -(-(ViewConfiguration.getDoubleTapTimeout() >> 16));
                    int i283 = (i282 ^ 9) + ((i282 & 9) << 1);
                    Object[] objArr68 = new Object[1];
                    a(capsMode, i281, i283, objArr68);
                    String str25 = (String) objArr68[0];
                    File file4 = new File(str24);
                    if (file4.exists() && file4.isFile()) {
                        try {
                            Scanner scanner3 = new Scanner(new FileInputStream(file4));
                            int i284 = -(-(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                            int i285 = 228 - (~(-TextUtils.indexOf(str3, str3)));
                            int i286 = -View.getDefaultSize(0, 0);
                            Object[] objArr69 = new Object[1];
                            a((char) ((i284 ^ 60153) + ((i284 & 60153) << 1)), i285, (i286 & 2) + (i286 | 2), objArr69);
                            Scanner scannerUseDelimiter3 = scanner3.useDelimiter((String) objArr69[0]);
                            String next3 = scannerUseDelimiter3.hasNext() ? scannerUseDelimiter3.next() : str3;
                            scannerUseDelimiter3.close();
                            if (next3.contains(str25)) {
                                i17 = (~(i & 261)) & (i | 261);
                            } else {
                                i17 = i;
                            }
                        } catch (IOException unused3) {
                        }
                    } else {
                        i17 = i;
                    }
                }
                if (i17 != i) {
                    Object[] objArr70 = {null, new int[]{((~i) & i) | ((~i) & i)}, null, new int[]{i}, new int[]{i17}};
                    int i287 = (i3 - (~((((909249552 + (((~((-62631046) | i16)) | 542817412) * 226)) + (((~(i16 | (-60882946))) | ((~((-542817413) | i)) | 541069312)) * (-113))) + ((~((-62631046) | i)) * 113)) + 16))) - 1;
                    int i288 = i287 << 13;
                    int i289 = ((~i287) & i288) | ((~i288) & i287);
                    int i290 = i289 >>> 17;
                    int i291 = ((~i289) & i290) | ((~i290) & i289);
                    int i292 = i291 << 5;
                    return objArr70;
                }
                Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-913150042);
                if (objAccessartificialFrame16 == null) {
                    int deadChar3 = KeyEvent.getDeadChar(0, 0) + 28;
                    char c15 = (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
                    int i293 = 764 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                    byte b9 = (byte) ($$b & 19);
                    byte[] bArr11 = $$a;
                    Object[] objArr71 = new Object[1];
                    b(b9, bArr11[17], bArr11[9], objArr71);
                    objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(deadChar3, c15, i293, 1459038638, false, (String) objArr71[0], new Class[0]);
                }
                long jLongValue7 = ((Long) ((Method) objAccessartificialFrame16).invoke(null, null)).longValue();
                long j40 = 730575863;
                long j41 = ((j40 ^ j21) | jLongValue7) ^ j21;
                long jFreeMemory = (int) Runtime.getRuntime().freeMemory();
                long j42 = 70;
                long j43 = (((long) 71) * j40) + (((long) (-69)) * jLongValue7) + (((long) (-140)) * (j41 | ((jLongValue7 | jFreeMemory) ^ j21))) + ((((j40 | jLongValue7) | jFreeMemory) ^ j21) * j42) + (j42 * (((jFreeMemory | j40) ^ j21) | j41 | (((jLongValue7 ^ j21) | j40) ^ j21))) + ((long) 1208025789);
                int i294 = ((int) (j43 >> 32)) & ((((-1019427974) + (((~((-2426185) | i16)) | (~(1543467005 | i16))) * (-184))) + ((((~((-1491559801) | i16)) | 1489133616) | (~(54333389 | i16))) * SyslogConstants.LOG_LOCAL7)) - 960991312);
                int i295 = ((int) j43) & (1211845961 + (((~((-2121174496) | i)) | 736566390) * (-366)) + (((~((-1409843594) | i)) | 25235488) * 366));
                if (((i294 & i295) | (i294 ^ i295)) == 1) {
                    int[] iArr4 = new int[1];
                    objArr2 = new Object[]{null, iArr4, null, new int[]{i}, new int[]{i}};
                    int i296 = (-1330920923) + (((~(521048505 | i16)) | 83520) * (-1188));
                    int i297 = (~(i | (-521048506))) | 83520;
                    int i298 = ~(84399952 | i16);
                    int i299 = i296 + ((i297 | i298) * 594) + (((~(i16 | (-521048506))) | 436732073 | i298) * 594);
                    int i300 = artificialFrame;
                    int i301 = i300 + 119;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i301 % 128;
                    if (i301 % 2 != 0) {
                        int i302 = -(i299 % 0);
                        i39 = ((i3 | i302) << 1) - (i3 ^ i302);
                        i40 = 21;
                    } else {
                        int i303 = -(-i299);
                        i39 = (i3 & i303) + (i3 | i303);
                        i40 = 13;
                    }
                    int i304 = i300 + 125;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i304 % 128;
                    int i305 = i304 % 2;
                    int i306 = i39 << i40;
                    int i307 = (i306 | i39) & (~(i39 & i306));
                    int i308 = i307 >>> 17;
                    int i309 = ((~i307) & i308) | ((~i308) & i307);
                    int i310 = i309 << 5;
                    iArr4[0] = (i309 | i310) & (~(i309 & i310));
                } else {
                    Object[] objArr72 = {1};
                    Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(1671772348);
                    if (objAccessartificialFrame17 == null) {
                        int i311 = 19 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                        char longPressTimeout = (char) (ViewConfiguration.getLongPressTimeout() >> 16);
                        int maxKeyCode3 = 1573 - (KeyEvent.getMaxKeyCode() >> 16);
                        byte[] bArr12 = $$a;
                        Object[] objArr73 = new Object[1];
                        b(bArr12[0], bArr12[17], bArr12[20], objArr73);
                        objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(i311, longPressTimeout, maxKeyCode3, -54493516, false, (String) objArr73[0], new Class[]{Integer.TYPE});
                    }
                    long jLongValue8 = ((Long) ((Method) objAccessartificialFrame17).invoke(null, objArr72)).longValue();
                    long j44 = -1209999958;
                    long j45 = (((long) (-464)) * j44) + (((long) (-929)) * jLongValue8);
                    long j46 = j44 ^ j21;
                    long jNextInt = new Random().nextInt();
                    long j47 = jLongValue8 | jNextInt;
                    long j48 = j45 + (((long) (-465)) * (j46 | (j47 ^ j21))) + (((long) 930) * (jLongValue8 | ((jNextInt | j46) ^ j21))) + (((long) 465) * (j47 | j46)) + ((long) 1694584675);
                    int i312 = ((int) ((long) ((((int) (j48 >> 32)) & ((((-1320242614) + (((~(2105997024 | i)) | (-2110715893)) * 1504)) + ((~((-4718869) | i)) * (-1504))) + (-1001626944))) | (((int) j48) & (((146125852 + (((~((-1080165465) | i)) | (~(1777575421 | i))) * 69)) + ((((~((-1097991545) | i)) | 17826080) | (~(1759749341 | i))) * (-69))) + (-353352743)))))) != 0 ? (~(i & 220)) & (i | 220) : i;
                    if (i312 != i) {
                        Object[] objArr74 = {null, new int[]{((~i) & i) | ((~i) & i)}, null, new int[]{i}, new int[]{i312}};
                        int i313 = (((~((-463753410) | i16)) * 130) - 115457889) + (((~((-463753410) | i)) | 4326964) * 130);
                        int i314 = (i3 - (~(((i313 | 16) << 1) - (i313 ^ 16)))) - 1;
                        int i315 = i314 ^ (i314 << 13);
                        int i316 = i315 >>> 17;
                        int i317 = ((~i315) & i316) | ((~i316) & i315);
                        int i318 = i317 << 5;
                        return objArr74;
                    }
                    Object[] objArr75 = new Object[1];
                    a((char) (64351 - (~(-(-(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))))), 372 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 22 - (~(-(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))), objArr75);
                    Object[] objArr76 = {(String) objArr75[0]};
                    Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                    if (objAccessartificialFrame18 == null) {
                        int iBlue2 = Color.blue(0) + 23;
                        char longPressTimeout2 = (char) (ViewConfiguration.getLongPressTimeout() >> 16);
                        int iAxisFromString = MotionEvent.axisFromString(str3) + 2442;
                        byte[] bArr13 = $$a;
                        Object[] objArr77 = new Object[1];
                        b((byte) (bArr13[3] + 1), bArr13[20], bArr13[15], objArr77);
                        objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(iBlue2, longPressTimeout2, iAxisFromString, 954751276, false, (String) objArr77[0], new Class[]{String.class});
                    }
                    Object objInvoke2 = ((Method) objAccessartificialFrame18).invoke(null, objArr76);
                    if (objInvoke2 != null) {
                        Object[] objArr78 = {objInvoke2, 42};
                        Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-287841710);
                        if (objAccessartificialFrame19 == null) {
                            int iIndexOf6 = 19 - TextUtils.indexOf((CharSequence) str3, '0');
                            char c16 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                            int iMyPid = 2245 - (Process.myPid() >> 22);
                            byte[] bArr14 = $$a;
                            byte b10 = bArr14[7];
                            byte b11 = bArr14[20];
                            Object[] objArr79 = new Object[1];
                            b(b10, b11, (byte) (b11 | Ascii.SO), objArr79);
                            objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(iIndexOf6, c16, iMyPid, 1907532890, false, (String) objArr79[0], new Class[]{String.class, Integer.TYPE});
                        }
                        long jLongValue9 = ((Long) ((Method) objAccessartificialFrame19).invoke(null, objArr78)).longValue();
                        long j49 = 1532729032;
                        long j50 = (((long) 866) * j49) + (((long) (-864)) * jLongValue9);
                        long j51 = jLongValue9 ^ j21;
                        long j52 = j37 ^ j21;
                        long j53 = 865;
                        long j54 = j50 + (((long) (-865)) * (j51 | (((j49 ^ j21) | j52) ^ j21))) + (((j49 | j37) ^ j21) * j53) + (j53 * (((j51 | j52) ^ j21) | ((j52 | j49) ^ j21))) + ((long) 100356296);
                        int startUptimeMillis3 = (int) Process.getStartUptimeMillis();
                        int i319 = (~((-673266773) | startUptimeMillis3)) | 671160404;
                        int i320 = ~startUptimeMillis3;
                        int i321 = ((int) (j54 >> 32)) & ((-1549866438) + ((i319 | (~(766066006 | i320))) * 886) + (((~(i320 | 673266772)) | 763959638) * (-1772)) + ((~(i320 | 763959638)) * 886));
                        int i322 = ((int) j54) & (1320243365 + (((~(1749328752 | i)) | 312102022) * 1504) + ((~(2061430774 | i)) * (-1504)) + 287491696);
                        if (((i321 & i322) | (i321 ^ i322)) == 1986687685) {
                            str4 = str3;
                            j = j21;
                            c4 = '0';
                            c2 = 6;
                        }
                        char c17 = (char) (47 - (~(-AndroidCharacter.getMirror(c4))));
                        int i323 = -(-(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                        int i324 = (i323 ^ 697) + ((i323 & 697) << 1);
                        int pressedStateDuration = ViewConfiguration.getPressedStateDuration() >> 16;
                        int i325 = ((pressedStateDuration | 16) << 1) - (pressedStateDuration ^ 16);
                        Object[] objArr80 = new Object[1];
                        a(c17, i324, i325, objArr80);
                        Object[] objArr81 = {(String) objArr80[0]};
                        objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1483923676);
                        if (objAccessartificialFrame == null) {
                            int offsetBefore3 = TextUtils.getOffsetBefore(str4, 0) + 23;
                            char c18 = (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                            int i326 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 2440;
                            byte[] bArr15 = $$a;
                            Object[] objArr82 = new Object[1];
                            b((byte) (bArr15[3] + 1), bArr15[20], bArr15[15], objArr82);
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(offsetBefore3, c18, i326, 954751276, false, (String) objArr82[0], new Class[]{String.class});
                        }
                        objInvoke = ((Method) objAccessartificialFrame).invoke(null, objArr81);
                        if (objInvoke == null) {
                            i23 = 0;
                        } else {
                            Object[] objArr83 = {objInvoke, 42};
                            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-287841710);
                            if (objAccessartificialFrame2 == null) {
                                int i327 = 21 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                                char cResolveSize2 = (char) View.resolveSize(0, 0);
                                int absoluteGravity = Gravity.getAbsoluteGravity(0, 0) + 2245;
                                byte[] bArr16 = $$a;
                                byte b12 = bArr16[7];
                                byte b13 = bArr16[20];
                                Object[] objArr84 = new Object[1];
                                b(b12, b13, (byte) (b13 | Ascii.SO), objArr84);
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i327, cResolveSize2, absoluteGravity, 1907532890, false, (String) objArr84[0], new Class[]{String.class, Integer.TYPE});
                            }
                            long jLongValue10 = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr83)).longValue();
                            long j55 = -443645310;
                            long j56 = j37 ^ j;
                            long j57 = 521;
                            long j58 = j55 ^ j;
                            j2 = (((long) 522) * j55) + (((long) (-520)) * jLongValue10) + (((long) (-1042)) * (((j56 | jLongValue10) ^ j) | j55)) + ((jLongValue10 | j37) * j57) + (j57 * (((jLongValue10 | (j55 | j56)) ^ j) | ((j58 | (jLongValue10 ^ j)) ^ j) | ((j58 | j37) ^ j))) + ((long) 2076730638);
                            int i328 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                            i19 = ((i328 | 21) << 1) - (i328 ^ 21);
                            artificialFrame = i19 % 128;
                            if (i19 % 2 == 0) {
                                int elapsedCpuTime2 = (int) Process.getElapsedCpuTime();
                                i20 = ((int) (j2 >> 60)) & (1520786966 + (((~((~elapsedCpuTime2) | 253845091)) | (-1336541032)) * 529) + (((~(elapsedCpuTime2 | 253845091)) | (-1183381320)) * 529));
                                i21 = (int) j2;
                                int iNextInt3 = new Random().nextInt(1112172730);
                                int i329 = ~iNextInt3;
                                i22 = (-2040709086) + ((~(20756676 | i329)) * 979) + (((-1416469734) | iNextInt3) * (-979)) + (((~(iNextInt3 | 20756676)) | (~(i329 | (-1416469734)))) * 979);
                            } else {
                                i20 = ((int) (j2 >> 32)) & (1738041050 + (((~(1960686168 | i16)) | (-1979709437) | (~(897054716 | i16))) * (-1136)) + (((~(1960686168 | i)) | (~(897054716 | i)) | (~((-878031449) | i16))) * (-568)) + (((~((-1960686169) | i16)) | (~((-897054717) | i16)) | (~(1979709436 | i))) * 568));
                                i21 = (int) j2;
                                int iNextInt4 = new Random().nextInt();
                                int i330 = (-254716221) + (((-1442471659) | iNextInt4) * 614);
                                int i331 = ~iNextInt4;
                                i22 = i330 + (((~((-170722466) | i331)) | 168099841 | (~((-1607948876) | i331))) * (-1228)) + (((~(i331 | (-1439849035))) | (~((-2622625) | i331))) * 614);
                            }
                            int i332 = i21 & i22;
                            i23 = (i20 & i332) | (i20 ^ i332);
                        }
                        if (i23 != 1986687685 || i23 == -1514516938) {
                            char mirror = AndroidCharacter.getMirror('0');
                            int iIPostMessageService2 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                            int i333 = mirror * 765;
                            int i334 = (i333 ^ 73296) + ((i333 & 73296) << 1);
                            int i335 = ~iIPostMessageService2;
                            int i336 = ~((i335 ^ mirror) | (i335 & mirror));
                            int i337 = ((i336 & (-48)) | (i336 ^ (-48))) * 764;
                            int i338 = ((i334 | i337) << 1) - (i337 ^ i334);
                            int i339 = ~mirror;
                            int i340 = ~((i339 & (-48)) | (i339 ^ (-48)));
                            int i341 = ~((i335 & (-48)) | (i335 ^ (-48)));
                            int i342 = ((i341 & i340) | (i340 ^ i341)) * (-1528);
                            int i343 = (i338 & i342) + (i342 | i338);
                            int i344 = ~mirror;
                            int i345 = ~((i344 & (-48)) | (i344 ^ (-48)));
                            int i346 = ~('/' | mirror);
                            int i347 = (i345 & i346) | (i345 ^ i346);
                            int i348 = ~iIPostMessageService2;
                            int i349 = ~((i348 & mirror) | (i348 ^ mirror));
                            int i350 = ((i349 & i347) | (i347 ^ i349)) * 764;
                            char c19 = (char) (((i343 | i350) << 1) - (i350 ^ i343));
                            int iResolveOpacity = Drawable.resolveOpacity(0, 0);
                            Object[] objArr85 = new Object[1];
                            a(c19, (iResolveOpacity ^ 1755) + ((iResolveOpacity & 1755) << 1), 11 - (~(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), objArr85);
                            String str26 = (String) objArr85[0];
                            int i351 = -(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                            int iKeyCodeFromString = KeyEvent.keyCodeFromString(str4);
                            Object[] objArr86 = new Object[1];
                            a((char) ((i351 & 1) + (i351 | 1)), ((iKeyCodeFromString | 1768) << 1) - (iKeyCodeFromString ^ 1768), 5 - Color.blue(0), objArr86);
                            int i352 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                            Object[] objArr87 = new Object[1];
                            a((char) ((i352 ^ (-1)) + (i352 << 1)), 1773 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (ViewConfiguration.getTapTimeout() >> 16) + 15, objArr87);
                            String str27 = (String) objArr87[0];
                            char trimmedLength2 = (char) TextUtils.getTrimmedLength(str4);
                            int i353 = -TextUtils.indexOf(str4, str4, 0);
                            int i354 = (i353 & 1788) + (i353 | 1788);
                            int i355 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                            int i356 = ((i355 | 18) << 1) - (i355 ^ 18);
                            Object[] objArr88 = new Object[1];
                            a(trimmedLength2, i354, i356, objArr88);
                            String str28 = (String) objArr88[0];
                            char c20 = (char) (56413 - (~(-TextUtils.lastIndexOf(str4, '0', 0))));
                            int i357 = -(-(ViewConfiguration.getScrollDefaultDelay() >> 16));
                            Object[] objArr89 = new Object[1];
                            a(c20, ((i357 | 1807) << 1) - (i357 ^ 1807), 13 - (~(-(-TextUtils.indexOf(str4, str4)))), objArr89);
                            int i358 = -(-Color.rgb(0, 0, 0));
                            int i359 = -TextUtils.lastIndexOf(str4, '0');
                            int i360 = ((i359 | 1820) << 1) - (i359 ^ 1820);
                            int packedPositionChild = ExpandableListView.getPackedPositionChild(0L);
                            int i361 = ((packedPositionChild | 22) << 1) - (packedPositionChild ^ 22);
                            Object[] objArr90 = new Object[1];
                            a((char) ((i358 & 16777216) + (i358 | 16777216)), i360, i361, objArr90);
                            String str29 = (String) objArr90[0];
                            char cMyPid = (char) (24327 - (Process.myPid() >> 22));
                            int i362 = -(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                            int i363 = -Color.rgb(0, 0, 0);
                            int i364 = (i363 ^ (-16777206)) + ((i363 & (-16777206)) << 1);
                            Object[] objArr91 = new Object[1];
                            a(cMyPid, (i362 ^ 1843) + ((i362 & 1843) << 1), i364, objArr91);
                            char cResolveOpacity2 = (char) Drawable.resolveOpacity(0, 0);
                            Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                            int i365 = -View.combineMeasuredStates(0, 0);
                            int i366 = ((1852 | i365) << 1) - (i365 ^ 1852);
                            int i367 = -(-(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                            int i368 = (i367 ^ 10) + ((i367 & 10) << 1);
                            Object[] objArr92 = new Object[1];
                            a(cResolveOpacity2, i366, i368, objArr92);
                            int i369 = -(ViewConfiguration.getLongPressTimeout() >> 16);
                            Object[] objArr93 = new Object[1];
                            a((char) ((i369 ^ 61549) + ((i369 & 61549) << 1)), 587 - (~(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), (ViewConfiguration.getEdgeSlop() >> 16) + 6, objArr93);
                            String[] strArr9 = {(String) objArr92[0], (String) objArr93[0]};
                            char cMakeMeasureSpec = (char) View.MeasureSpec.makeMeasureSpec(0, 0);
                            int i370 = -MotionEvent.axisFromString(str4);
                            int i371 = (i370 & 1862) + (i370 | 1862);
                            int offsetAfter5 = TextUtils.getOffsetAfter(str4, 0);
                            int iIPostMessageService3 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                            int i372 = offsetAfter5 * 483;
                            int i373 = (i372 & 6776) + (i372 | 6776);
                            int i374 = ~offsetAfter5;
                            int i375 = ~((i374 ^ (-29)) | (i374 & (-29)));
                            int i376 = ~iIPostMessageService3;
                            int i377 = ~((i374 ^ i376) | (i374 & i376));
                            int i378 = -(-(((i375 & i377) | (i375 ^ i377)) * (-241)));
                            int i379 = (((i373 | i378) << 1) - (i373 ^ i378)) + (((offsetAfter5 ^ 28) | (offsetAfter5 & 28)) * (-482));
                            int i380 = ~((offsetAfter5 & (-29)) | ((-29) ^ offsetAfter5));
                            int i381 = i376 | i374;
                            int i382 = ~((i381 & 28) | (i381 ^ 28));
                            int i383 = i379 + (((i382 & i380) | (i380 ^ i382)) * 241);
                            Object[] objArr94 = new Object[1];
                            a(cMakeMeasureSpec, i371, i383, objArr94);
                            String str30 = (String) objArr94[0];
                            char c21 = (char) (24327 - (~Process.getGidForName(str4)));
                            int i384 = -(ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                            Object[] objArr95 = new Object[1];
                            a(c21, (i384 ^ 1842) + ((i384 & 1842) << 1), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 9, objArr95);
                            c5 = 0;
                            strArr = new String[][]{new String[]{str26, (String) objArr86[0]}, new String[]{str27, str28, (String) objArr89[0]}, new String[]{str29, (String) objArr91[0]}, strArr9, new String[]{str30, (String) objArr95[0]}};
                            i24 = 0;
                            i25 = 5;
                            i26 = -1;
                            loop5: while (true) {
                                if (i24 >= i25) {
                                    i27 = i;
                                    break;
                                }
                                String[] strArr10 = strArr[i24];
                                str5 = strArr10[c5];
                                strArr2 = (String[]) Arrays.copyOfRange(strArr10, 1, strArr10.length);
                                length = strArr2.length;
                                i33 = 0;
                                while (i33 < length) {
                                    i34 = i26 + 1;
                                    Object[] objArr96 = {str5, strArr2[i33]};
                                    objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-883653127);
                                    if (objAccessartificialFrame4 == null) {
                                        int iLastIndexOf4 = 30 - TextUtils.lastIndexOf(str4, '0', 0, 0);
                                        char c22 = (char) (57023 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                                        int iMyTid = 2311 - (Process.myTid() >> 22);
                                        byte b14 = (byte) ($$b & 19);
                                        byte b15 = $$a[20];
                                        Object[] objArr97 = new Object[1];
                                        b(b14, b15, (byte) (b15 + 5), objArr97);
                                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iLastIndexOf4, c22, iMyTid, 1412547569, false, (String) objArr97[0], new Class[]{String.class, String.class});
                                    }
                                    long jLongValue11 = ((Long) ((Method) objAccessartificialFrame4).invoke(null, objArr96)).longValue();
                                    long j59 = -17848847;
                                    long j60 = -754;
                                    long j61 = j59 ^ j;
                                    long j62 = j61 | jLongValue11;
                                    i35 = length;
                                    long jUptimeMillis2 = (int) SystemClock.uptimeMillis();
                                    long j63 = (((long) 755) * j59) + (((long) (-753)) * jLongValue11) + (((j62 ^ j) | ((j61 | jUptimeMillis2) ^ j) | ((jLongValue11 | jUptimeMillis2) ^ j)) * j60);
                                    long j64 = (j62 | jUptimeMillis2) ^ j;
                                    long j65 = jUptimeMillis2 ^ j;
                                    long j66 = j63 + (j60 * (j64 | ((jLongValue11 | (j59 | j65)) ^ j))) + (((long) 754) * (j61 | j65)) + ((long) (-136902782));
                                    i36 = ((int) (j66 >> 32)) & (78586646 + (((~(1125022391 | i)) | 608240904 | (~((-1732718494) | i))) * (-754)) + (((~((-608240905) | i)) | (~((-1124477590) | i16))) * (-754)) + ((1125022391 | i16) * 754));
                                    i37 = ((int) j66) & ((((~(877330483 | i)) | 1980410402) * 56) + 1210426141 + ((877330483 | (~(1980410402 | i16))) * 56));
                                    if (((i36 & i37) | (i36 ^ i37)) != 0) {
                                        i27 = i ^ (i26 + 171);
                                        break loop5;
                                    }
                                    i33++;
                                    strArr = strArr;
                                    strArr2 = strArr2;
                                    str5 = str5;
                                    i26 = i34;
                                    length = i35;
                                }
                                i24++;
                                strArr = strArr;
                                i25 = 5;
                                c5 = 0;
                            }
                            if (i27 != i) {
                                objArr2 = new Object[]{null, new int[1], null, new int[]{i}, new int[]{i27}};
                                int i385 = getARTIFICIAL_FRAME_PACKAGE_NAME + 113;
                                artificialFrame = i385 % 128;
                                int i386 = i385 % 2;
                                int elapsedCpuTime3 = (int) Process.getElapsedCpuTime();
                                int i387 = (-2030458348) + (((-306319490) | elapsedCpuTime3) * (-627)) + (((~((-229388135) | elapsedCpuTime3)) | 376060323) * (-627)) + (((~(elapsedCpuTime3 | 376060323)) | (~((~elapsedCpuTime3) | 229388134))) * 627);
                                int i388 = (i387 & 16) + (i387 | 16);
                                int i389 = (i3 ^ i388) + ((i3 & i388) << 1);
                                int i390 = i389 << 13;
                                int i391 = (i390 & (~i389)) | ((~i390) & i389);
                                int i392 = i391 ^ (i391 >>> 17);
                                int i393 = artificialFrame + 101;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i393 % 128;
                                int i394 = i393 % 2;
                                ((int[]) objArr2[1])[0] = i392 ^ (i392 << 5);
                            } else {
                                try {
                                    int i395 = -View.MeasureSpec.getSize(0);
                                    char c23 = (char) ((i395 ^ 22173) + ((i395 & 22173) << 1));
                                    int i396 = 1890 - (~(-(-(ViewConfiguration.getEdgeSlop() >> 16))));
                                    int i397 = -TextUtils.lastIndexOf(str4, '0');
                                    Object[] objArr98 = new Object[1];
                                    a(c23, i396, (i397 & 12) + (i397 | 12), objArr98);
                                    String str31 = (String) objArr98[0];
                                    int iResolveSize = View.resolveSize(0, 0);
                                    char c24 = (char) (((iResolveSize | 42082) << 1) - (42082 ^ iResolveSize));
                                    int minimumFlingVelocity2 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 1904;
                                    int i398 = -TextUtils.indexOf(str4, str4, 0);
                                    int i399 = (i398 ^ 8) + ((i398 & 8) << 1);
                                    Object[] objArr99 = new Object[1];
                                    a(c24, minimumFlingVelocity2, i399, objArr99);
                                    String str32 = (String) objArr99[0];
                                    file = new File(str31);
                                    if (file.exists() || !file.isFile()) {
                                        i28 = i;
                                    } else {
                                        try {
                                            Scanner scanner4 = new Scanner(new FileInputStream(file));
                                            int i400 = -AndroidCharacter.getMirror('0');
                                            int i401 = 228 - (~(-ExpandableListView.getPackedPositionGroup(0L)));
                                            int i402 = -(-View.MeasureSpec.getMode(0));
                                            Object[] objArr100 = new Object[1];
                                            a((char) ((i400 ^ 60201) + ((i400 & 60201) << 1)), i401, (i402 & 2) + (i402 | 2), objArr100);
                                            Scanner scannerUseDelimiter4 = scanner4.useDelimiter((String) objArr100[0]);
                                            String next4 = scannerUseDelimiter4.hasNext() ? scannerUseDelimiter4.next() : str4;
                                            scannerUseDelimiter4.close();
                                            if (next4.contains(str32)) {
                                                i28 = i ^ 150;
                                            } else {
                                                i28 = i;
                                            }
                                        } catch (IOException unused4) {
                                        }
                                    }
                                } catch (Exception unused5) {
                                    i28 = i ^ 151;
                                }
                                if (i28 == i) {
                                    int iLastIndexOf5 = TextUtils.lastIndexOf(str4, '0', 0);
                                    int iIPostMessageService4 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                    int i403 = ~iLastIndexOf5;
                                    int i404 = ~iIPostMessageService4;
                                    int i405 = ((iLastIndexOf5 * (-433)) - 1577448) + (((~((i404 & i403) | (i403 ^ i404))) | (~(((-7304) & iIPostMessageService4) | ((-7304) ^ iIPostMessageService4)))) * JfifUtil.MARKER_EOI);
                                    int i406 = ~((i403 & (-7304)) | (i403 ^ (-7304)));
                                    int i407 = ~iLastIndexOf5;
                                    int i408 = ~((i407 & iIPostMessageService4) | (i407 ^ iIPostMessageService4));
                                    int i409 = ((i406 & i408) | (i406 ^ i408)) * JfifUtil.MARKER_EOI;
                                    int i410 = ~iIPostMessageService4;
                                    int i411 = ~((i410 & (-7304)) | ((-7304) ^ i410));
                                    char c25 = (char) ((((i405 | i409) << 1) - (i405 ^ i409)) + (((i411 & iLastIndexOf5) | (iLastIndexOf5 ^ i411)) * JfifUtil.MARKER_EOI));
                                    int i412 = -View.resolveSize(0, 0);
                                    Object[] objArr101 = new Object[1];
                                    a(c25, (i412 ^ 1912) + ((i412 & 1912) << 1), TextUtils.getCapsMode(str4, 0, 0) + 47, objArr101);
                                    Object[] objArr102 = {(String) objArr101[0]};
                                    objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(479197382);
                                    if (objAccessartificialFrame3 == null) {
                                        int jumpTapTimeout = (ViewConfiguration.getJumpTapTimeout() >> 16) + 17;
                                        char cLastIndexOf = (char) (24342 - TextUtils.lastIndexOf(str4, '0', 0, 0));
                                        int iResolveSizeAndState = View.resolveSizeAndState(0, 0, 0) + 2014;
                                        byte[] bArr17 = $$a;
                                        Object[] objArr103 = new Object[1];
                                        b((byte) (-bArr17[c2]), bArr17[0], bArr17[13], objArr103);
                                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout, cLastIndexOf, iResolveSizeAndState, -2081767730, false, (String) objArr103[0], new Class[]{String.class});
                                    }
                                    long jLongValue12 = ((Long) ((Method) objAccessartificialFrame3).invoke(null, objArr102)).longValue();
                                    long j67 = -270720422;
                                    long j68 = j67 ^ j;
                                    long j69 = (((long) 236) * j67) + (((long) 471) * jLongValue12) + (((long) (-235)) * ((((j37 ^ j) | j68) ^ j) | jLongValue12)) + (((long) (-470)) * (((j68 | j37) ^ j) | jLongValue12)) + (((long) 235) * ((((jLongValue12 | j68) | j37) ^ j) | ((j67 | (jLongValue12 ^ j)) ^ j))) + ((long) 767331813);
                                    int i413 = ~(1740988638 | i);
                                    int i414 = ((int) (j69 >> 32)) & ((((-1977510894) | i413) * (-658)) + 2084340718 + ((i413 | (-2011130880)) * 658));
                                    int startElapsedRealtime2 = (int) Process.getStartElapsedRealtime();
                                    int i415 = ~startElapsedRealtime2;
                                    int i416 = ((int) j69) & (802172634 + (((-570689025) | i415) * (-369)) + (((~(839255688 | i415)) | (-597970722)) * (-369)) + (((~(startElapsedRealtime2 | (-839255689))) | 268566664 | (~(i415 | (-27281698)))) * 369));
                                    i29 = (((i414 & i416) | (i414 ^ i416)) * 263) ^ i;
                                    if (i29 != i) {
                                        Object[] objArr104 = {null, new int[]{(i | i) & (~(i & i))}, null, new int[]{i}, new int[]{i29}};
                                        int i417 = 1778863633 + ((1073216506 | i16) * SyslogConstants.LOG_LOCAL7) + (((~(1040667266 | i16)) | 670546938) * SyslogConstants.LOG_LOCAL7);
                                        int i418 = i3 + (i417 ^ 16) + ((i417 & 16) << 1);
                                        int i419 = i418 << 13;
                                        int i420 = ((~i418) & i419) | ((~i419) & i418);
                                        int i421 = i420 >>> 17;
                                        int i422 = ((~i420) & i421) | ((~i421) & i420);
                                        int i423 = i422 << 5;
                                        return objArr104;
                                    }
                                    Object[] objArr105 = {null, new int[1], null, new int[]{i}, new int[]{i}};
                                    Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                    int iMyPid2 = Process.myPid();
                                    int i424 = (((~(iMyPid2 | 712483870)) | (-107035413)) * 56) + 1596557073 + (((~((~iMyPid2) | (-107035413))) | 712483870) * 56);
                                    int i425 = -(-((i424 << 1) - i424));
                                    i30 = (i3 ^ i425) + ((i3 & i425) << 1);
                                    i31 = getARTIFICIAL_FRAME_PACKAGE_NAME + 37;
                                    artificialFrame = i31 % 128;
                                    if (i31 % 2 == 0) {
                                        int i426 = i30 % 13;
                                        int i427 = (i426 & (~i30)) | ((~i426) & i30);
                                        int i428 = i427 >> 119;
                                        int i429 = (i427 | i428) & (~(i427 & i428));
                                        i32 = i429 ^ (i429 * 2);
                                    } else {
                                        int i430 = i30 << 13;
                                        int i431 = (i430 & (~i30)) | ((~i430) & i30);
                                        int i432 = i431 >>> 17;
                                        int i433 = ((~i431) & i432) | ((~i432) & i431);
                                        int i434 = i433 << 5;
                                        i32 = ((~i433) & i434) | ((~i434) & i433);
                                    }
                                    ((int[]) objArr105[1])[0] = i32;
                                    return objArr105;
                                }
                                objArr2 = new Object[]{null, new int[1], null, new int[]{i}, new int[]{i28}};
                                int iNextInt5 = new Random().nextInt(567550856);
                                int i435 = ~iNextInt5;
                                int i436 = 654520734 + (((~(i435 | (-233448414))) | 233448216 | (~((-838896675) | iNextInt5))) * 717) + (((~(iNextInt5 | (-233448414))) | (~(i435 | (-838896675))) | 233448216) * 717);
                                int i437 = ((i436 | 16) << 1) - (i436 ^ 16);
                                int i438 = ((i3 | i437) << 1) - (i3 ^ i437);
                                int i439 = i438 << 13;
                                int i440 = (i439 & (~i438)) | ((~i439) & i438);
                                int i441 = i440 >>> 17;
                                int i442 = (i440 | i441) & (~(i440 & i441));
                                ((int[]) objArr2[1])[0] = i442 ^ (i442 << 5);
                            }
                        } else {
                            char cMyTid2 = (char) (Process.myTid() >> 22);
                            int i443 = -(-TextUtils.getOffsetAfter(str4, 0));
                            int i444 = (i443 ^ 1413) + ((i443 & 1413) << 1);
                            int scrollBarFadeDuration2 = ViewConfiguration.getScrollBarFadeDuration() >> 16;
                            int i445 = ((scrollBarFadeDuration2 | 14) << 1) - (scrollBarFadeDuration2 ^ 14);
                            Object[] objArr106 = new Object[1];
                            a(cMyTid2, i444, i445, objArr106);
                            String str33 = (String) objArr106[0];
                            char edgeSlop3 = (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 21718);
                            int iIndexOf7 = 1426 - TextUtils.indexOf((CharSequence) str4, '0', 0);
                            int i446 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                            int iIPostMessageService5 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                            int i447 = ~((~i446) | 25);
                            int i448 = ~iIPostMessageService5;
                            int i449 = ((i446 * 375) - 18675) + ((i447 | (~((i448 & i446) | (i448 ^ i446)))) * (-374));
                            int i450 = -(-((~(((-26) & i446) | ((-26) ^ i446))) * 748));
                            int i451 = ((i449 | i450) << 1) - (i449 ^ i450);
                            int i452 = ~i446;
                            int i453 = i451 + (((~(i446 | (~iIPostMessageService5))) | (~((i452 & (-26)) | (i452 ^ (-26))))) * 374);
                            Object[] objArr107 = new Object[1];
                            a(edgeSlop3, iIndexOf7, i453, objArr107);
                            String str34 = (String) objArr107[0];
                            char c26 = (char) ((-2) - ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) ^ (-1)));
                            int i454 = -(ViewConfiguration.getScrollDefaultDelay() >> 16);
                            Object[] objArr108 = new Object[1];
                            a(c26, (i454 & 1453) + (i454 | 1453), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 16, objArr108);
                            String str35 = (String) objArr108[0];
                            char c27 = (char) ((-ImageFormat.getBitsPerPixel(0)) - 1);
                            int i455 = -(Process.myTid() >> 22);
                            Object[] objArr109 = new Object[1];
                            a(c27, (i455 ^ 1470) + ((i455 & 1470) << 1), 16 - (~KeyEvent.normalizeMetaState(0)), objArr109);
                            String str36 = (String) objArr109[0];
                            Object[] objArr110 = new Object[1];
                            a((char) (20970 - KeyEvent.getDeadChar(0, 0)), 1487 - (ViewConfiguration.getTapTimeout() >> 16), 14 - (~(-(ViewConfiguration.getScrollDefaultDelay() >> 16))), objArr110);
                            String str37 = (String) objArr110[0];
                            int i456 = -ExpandableListView.getPackedPositionType(0L);
                            int packedPositionChild2 = 1501 - ExpandableListView.getPackedPositionChild(0L);
                            int iLastIndexOf6 = TextUtils.lastIndexOf(str4, '0', 0, 0);
                            int i457 = ((iLastIndexOf6 | 38) << 1) - (iLastIndexOf6 ^ 38);
                            Object[] objArr111 = new Object[1];
                            a((char) (((i456 | 32912) << 1) - (i456 ^ 32912)), packedPositionChild2, i457, objArr111);
                            String str38 = (String) objArr111[0];
                            int i458 = -(ViewConfiguration.getScrollBarFadeDuration() >> 16);
                            int i459 = -(-KeyEvent.keyCodeFromString(str4));
                            int i460 = (i459 ^ 1539) + ((i459 & 1539) << 1);
                            int i461 = -(-(ViewConfiguration.getKeyRepeatTimeout() >> 16));
                            int i462 = ((i461 | 12) << 1) - (i461 ^ 12);
                            Object[] objArr112 = new Object[1];
                            a((char) ((i458 & 25003) + (i458 | 25003)), i460, i462, objArr112);
                            String str39 = (String) objArr112[0];
                            char defaultSize = (char) View.getDefaultSize(0, 0);
                            int i463 = -TextUtils.indexOf((CharSequence) str4, '0', 0);
                            int i464 = ((i463 | 1550) << 1) - (i463 ^ 1550);
                            int i465 = -(-(ViewConfiguration.getMinimumFlingVelocity() >> 16));
                            int i466 = (i465 ^ 13) + ((i465 & 13) << 1);
                            Object[] objArr113 = new Object[1];
                            a(defaultSize, i464, i466, objArr113);
                            String str40 = (String) objArr113[0];
                            char c28 = (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                            int i467 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                            Object[] objArr114 = new Object[1];
                            a(c28, ((i467 | 1564) << 1) - (i467 ^ 1564), (ViewConfiguration.getWindowTouchSlop() >> 8) + 22, objArr114);
                            String str41 = (String) objArr114[0];
                            int i468 = -(-(ViewConfiguration.getMaximumFlingVelocity() >> 16));
                            Object[] objArr115 = new Object[1];
                            a((char) ((i468 & 13678) + (i468 | 13678)), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 1586, TextUtils.indexOf((CharSequence) str4, '0') + 32, objArr115);
                            String str42 = (String) objArr115[0];
                            char cLastIndexOf2 = (char) (TextUtils.lastIndexOf(str4, '0') + 51122);
                            int mode = View.MeasureSpec.getMode(0);
                            Object[] objArr116 = new Object[1];
                            a(cLastIndexOf2, ((mode | 1617) << 1) - (mode ^ 1617), 11 - (~(-(Process.myTid() >> 22))), objArr116);
                            String str43 = (String) objArr116[0];
                            char c29 = (char) (49939 - (~(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))));
                            int i469 = 1628 - (~(-View.MeasureSpec.makeMeasureSpec(0, 0)));
                            char mirror2 = AndroidCharacter.getMirror('0');
                            int i470 = ((mirror2 | (-36)) << 1) - (mirror2 ^ (-36));
                            Object[] objArr117 = new Object[1];
                            a(c29, i469, i470, objArr117);
                            String str44 = (String) objArr117[0];
                            char c30 = (char) (0 - (~ExpandableListView.getPackedPositionChild(0L)));
                            int touchSlop2 = (ViewConfiguration.getTouchSlop() >> 8) + 1641;
                            int i471 = -View.resolveSizeAndState(0, 0, 0);
                            Object[] objArr118 = new Object[1];
                            a(c30, touchSlop2, (i471 & 12) + (i471 | 12), objArr118);
                            String str45 = (String) objArr118[0];
                            int jumpTapTimeout2 = ViewConfiguration.getJumpTapTimeout() >> 16;
                            int iIPostMessageService6 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                            int i472 = (jumpTapTimeout2 * 483) + 5973528;
                            int i473 = ~jumpTapTimeout2;
                            int i474 = ~((i473 ^ (-24685)) | (i473 & (-24685)));
                            int i475 = ~iIPostMessageService6;
                            int i476 = ~((i475 & i473) | (i473 ^ i475));
                            int i477 = -(-(((i474 & i476) | (i474 ^ i476)) * (-241)));
                            int i478 = ((((i472 | i477) << 1) - (i472 ^ i477)) - (~(-(-((jumpTapTimeout2 | 24684) * (-482)))))) - 1;
                            int i479 = ~((jumpTapTimeout2 & (-24685)) | ((-24685) ^ jumpTapTimeout2));
                            int i480 = ~iIPostMessageService6;
                            int i481 = (i480 & i473) | (i473 ^ i480);
                            int i482 = ~((i481 & 24684) | (i481 ^ 24684));
                            int i483 = -(-(((i479 & i482) | (i479 ^ i482)) * 241));
                            Object[] objArr119 = new Object[1];
                            a((char) (((i478 | i483) << 1) - (i483 ^ i478)), 1653 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 12 - KeyEvent.keyCodeFromString(str4), objArr119);
                            String str46 = (String) objArr119[0];
                            char cMyTid3 = (char) (Process.myTid() >> 22);
                            int i484 = -Color.blue(0);
                            Object[] objArr120 = new Object[1];
                            a(cMyTid3, ((i484 | 1665) << 1) - (i484 ^ 1665), 11 - (~(-(-(ViewConfiguration.getScrollBarFadeDuration() >> 16)))), objArr120);
                            String str47 = (String) objArr120[0];
                            Object[] objArr121 = new Object[1];
                            a((char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 1677 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 14 - TextUtils.getOffsetAfter(str4, 0), objArr121);
                            String str48 = (String) objArr121[0];
                            int i485 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                            int i486 = 1689 - (~(-TextUtils.indexOf((CharSequence) str4, '0')));
                            int i487 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                            int i488 = (i487 ^ 11) + ((i487 & 11) << 1);
                            Object[] objArr122 = new Object[1];
                            a((char) ((i485 ^ 51276) + ((i485 & 51276) << 1)), i486, i488, objArr122);
                            String str49 = (String) objArr122[0];
                            int i489 = -MotionEvent.axisFromString(str4);
                            int scrollBarSize = ViewConfiguration.getScrollBarSize() >> 8;
                            Object[] objArr123 = new Object[1];
                            a((char) ((i489 ^ 34717) + ((i489 & 34717) << 1)), (scrollBarSize & 1703) + (scrollBarSize | 1703), 23 - (~(-(ViewConfiguration.getKeyRepeatDelay() >> 16))), objArr123);
                            String str50 = (String) objArr123[0];
                            Object[] objArr124 = new Object[1];
                            a((char) (ViewConfiguration.getKeyRepeatTimeout() >> 16), 1727 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), 27 - ((byte) KeyEvent.getModifierMetaStateMask()), objArr124);
                            String[] strArr11 = {str33, str34, str35, str36, str37, str38, str39, str40, str41, str42, str43, str44, str45, str46, str47, str48, str49, str50, (String) objArr124[0]};
                            int i490 = getARTIFICIAL_FRAME_PACKAGE_NAME + 75;
                            artificialFrame = i490 % 128;
                            int i491 = i490 % 2;
                            int i492 = 0;
                            while (true) {
                                if (i492 >= 19) {
                                    i38 = -1;
                                    break;
                                }
                                String str51 = strArr11[i492];
                                Object[] objArr125 = {str51};
                                Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(267846469);
                                if (objAccessartificialFrame20 == null) {
                                    int iKeyCodeFromString2 = KeyEvent.keyCodeFromString(str4) + 17;
                                    char scrollDefaultDelay3 = (char) (24343 - (ViewConfiguration.getScrollDefaultDelay() >> 16));
                                    int size = View.MeasureSpec.getSize(0) + 2014;
                                    byte[] bArr18 = $$a;
                                    byte b16 = (byte) (-bArr18[c2]);
                                    byte b17 = bArr18[0];
                                    Object[] objArr126 = new Object[1];
                                    b(b16, b17, (byte) (b17 + 4), objArr126);
                                    objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString2, scrollDefaultDelay3, size, -1869462195, false, (String) objArr126[0], new Class[]{String.class});
                                }
                                long jLongValue13 = ((Long) ((Method) objAccessartificialFrame20).invoke(null, objArr125)).longValue();
                                long j70 = -1206547423;
                                long j71 = 765;
                                long j72 = j70 ^ j;
                                long j73 = jLongValue13 ^ j;
                                long j74 = j72 | j73;
                                long j75 = j37 ^ j;
                                long j76 = (((long) (-1529)) * j70) + (((long) (-764)) * jLongValue13) + ((((j74 | j75) ^ j) | (((jLongValue13 | j72) | j37) ^ j) | (((j73 | j70) | j37) ^ j)) * j71) + (((long) 1530) * ((j74 ^ j) | ((j72 | j75) ^ j))) + (j71 * (((j72 | j37) ^ j) | ((j70 | (j73 | j75)) ^ j))) + ((long) (-105084553));
                                int i493 = ((int) (j76 >> 32)) & (1687905420 + (((~((-1329140267) | i16)) | 108086144) * (-90)) + (((~((-1329140267) | i)) | (-1333351339)) * (-45)) + (((-1329140267) | (~((-108086145) | i)) | (~(i16 | 108086144))) * 45));
                                int i494 = ((int) j76) & ((((~((-2105362) | i)) | 1074332996) * TypedValues.PositionType.TYPE_TRANSITION_EASING) + 433036028 + ((~((-2105362) | i16)) * TypedValues.PositionType.TYPE_TRANSITION_EASING));
                                if (((i493 & i494) | (i493 ^ i494)) == 0) {
                                    int i495 = -(-TextUtils.lastIndexOf(str4, '0'));
                                    int i496 = -(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                                    Object[] objArr127 = new Object[1];
                                    a((char) (((i495 | 1) << 1) - (i495 ^ 1)), ((i496 | 1678) << 1) - (i496 ^ 1678), 14 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), objArr127);
                                    if (str51.equals((String) objArr127[0])) {
                                        Object[] objArr128 = {str51};
                                        Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(479197382);
                                        if (objAccessartificialFrame21 == null) {
                                            int fadingEdgeLength2 = 17 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                                            char maximumFlingVelocity3 = (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 24343);
                                            int iRgb = Color.rgb(0, 0, 0) + 16779230;
                                            byte[] bArr19 = $$a;
                                            Object[] objArr129 = new Object[1];
                                            b((byte) (-bArr19[c2]), bArr19[0], bArr19[13], objArr129);
                                            objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength2, maximumFlingVelocity3, iRgb, -2081767730, false, (String) objArr129[0], new Class[]{String.class});
                                        }
                                        long jLongValue14 = ((Long) ((Method) objAccessartificialFrame21).invoke(null, objArr128)).longValue();
                                        long j77 = -1501734623;
                                        long j78 = 521;
                                        long j79 = j77 ^ j;
                                        long j80 = (((long) 522) * j77) + (((long) (-520)) * jLongValue14) + (((long) (-1042)) * (((j75 | jLongValue14) ^ j) | j77)) + ((jLongValue14 | j37) * j78) + (j78 * (((jLongValue14 | (j75 | j77)) ^ j) | ((j79 | (jLongValue14 ^ j)) ^ j) | ((j79 | j37) ^ j))) + ((long) 1998346014);
                                        int i497 = ((int) (j80 >> 32)) & ((-407049942) + (((~((-345387099) | i)) | 1782613509) * (-756)) + (((-345387099) | i16) * 756));
                                        int iMyUid2 = Process.myUid();
                                        if ((i497 | (((int) j80) & ((((~((-8421890) | iMyUid2)) | 1426657284) * 449) + 2133293196 + (((~((~iMyUid2) | (-8421890))) | 1426657284) * 449)))) != 0) {
                                        }
                                    }
                                    i492++;
                                }
                                i38 = i492;
                                break;
                            }
                            if (i38 >= 0) {
                                int i498 = ((i38 | 130) << 1) - (i38 ^ 130);
                                int i499 = (i498 & i16) | ((~i498) & i);
                                if (i499 != i) {
                                    objArr2 = new Object[]{null, new int[]{i ^ (i << 5)}, null, new int[]{i}, new int[]{i499}};
                                    int i500 = (-2115839000) + (((~((-978457961) | i)) | 675287328) * 345) + (((~(i16 | (-978457961))) | (-1048296831)) * 345) + ((~((-675287329) | i)) * 345) + 16;
                                    int i501 = ((i3 | i500) << 1) - (i3 ^ i500);
                                    int i502 = i501 << 13;
                                    int i503 = (i501 | i502) & (~(i501 & i502));
                                    int i504 = i503 >>> 17;
                                    int i505 = (i503 | i504) & (~(i503 & i504));
                                } else {
                                    char mirror3 = AndroidCharacter.getMirror('0');
                                    int iIPostMessageService7 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                    int i3310 = mirror3 * 765;
                                    int i3311 = (i3310 ^ 73296) + ((i3310 & 73296) << 1);
                                    int i3312 = ~iIPostMessageService7;
                                    int i3313 = ~((i3312 ^ mirror3) | (i3312 & mirror3));
                                    int i3314 = ((i3313 & (-48)) | (i3313 ^ (-48))) * 764;
                                    int i3315 = ((i3311 | i3314) << 1) - (i3314 ^ i3311);
                                    int i3316 = ~mirror3;
                                    int i3410 = ~((i3316 & (-48)) | (i3316 ^ (-48)));
                                    int i3411 = ~((i3312 & (-48)) | (i3312 ^ (-48)));
                                    int i3412 = ((i3411 & i3410) | (i3410 ^ i3411)) * (-1528);
                                    int i3413 = (i3315 & i3412) + (i3412 | i3315);
                                    int i3414 = ~mirror3;
                                    int i3415 = ~((i3414 & (-48)) | (i3414 ^ (-48)));
                                    int i3416 = ~('/' | mirror3);
                                    int i3417 = (i3415 & i3416) | (i3415 ^ i3416);
                                    int i3418 = ~iIPostMessageService7;
                                    int i3419 = ~((i3418 & mirror3) | (i3418 ^ mirror3));
                                    int i3510 = ((i3419 & i3417) | (i3417 ^ i3419)) * 764;
                                    char c110 = (char) (((i3413 | i3510) << 1) - (i3510 ^ i3413));
                                    int iResolveOpacity2 = Drawable.resolveOpacity(0, 0);
                                    Object[] objArr810 = new Object[1];
                                    a(c110, (iResolveOpacity2 ^ 1755) + ((iResolveOpacity2 & 1755) << 1), 11 - (~(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), objArr810);
                                    String str210 = (String) objArr810[0];
                                    int i3511 = -(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                                    int iKeyCodeFromString3 = KeyEvent.keyCodeFromString(str4);
                                    Object[] objArr811 = new Object[1];
                                    a((char) ((i3511 & 1) + (i3511 | 1)), ((iKeyCodeFromString3 | 1768) << 1) - (iKeyCodeFromString3 ^ 1768), 5 - Color.blue(0), objArr811);
                                    int i3512 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                                    Object[] objArr812 = new Object[1];
                                    a((char) ((i3512 ^ (-1)) + (i3512 << 1)), 1773 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (ViewConfiguration.getTapTimeout() >> 16) + 15, objArr812);
                                    String str211 = (String) objArr812[0];
                                    char trimmedLength3 = (char) TextUtils.getTrimmedLength(str4);
                                    int i3513 = -TextUtils.indexOf(str4, str4, 0);
                                    int i3514 = (i3513 & 1788) + (i3513 | 1788);
                                    int i3515 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                                    int i3516 = ((i3515 | 18) << 1) - (i3515 ^ 18);
                                    Object[] objArr813 = new Object[1];
                                    a(trimmedLength3, i3514, i3516, objArr813);
                                    String str212 = (String) objArr813[0];
                                    char c210 = (char) (56413 - (~(-TextUtils.lastIndexOf(str4, '0', 0))));
                                    int i3517 = -(-(ViewConfiguration.getScrollDefaultDelay() >> 16));
                                    Object[] objArr814 = new Object[1];
                                    a(c210, ((i3517 | 1807) << 1) - (i3517 ^ 1807), 13 - (~(-(-TextUtils.indexOf(str4, str4)))), objArr814);
                                    int i3518 = -(-Color.rgb(0, 0, 0));
                                    int i3519 = -TextUtils.lastIndexOf(str4, '0');
                                    int i3610 = ((i3519 | 1820) << 1) - (i3519 ^ 1820);
                                    int packedPositionChild3 = ExpandableListView.getPackedPositionChild(0L);
                                    int i3611 = ((packedPositionChild3 | 22) << 1) - (packedPositionChild3 ^ 22);
                                    Object[] objArr910 = new Object[1];
                                    a((char) ((i3518 & 16777216) + (i3518 | 16777216)), i3610, i3611, objArr910);
                                    String str213 = (String) objArr910[0];
                                    char cMyPid2 = (char) (24327 - (Process.myPid() >> 22));
                                    int i3612 = -(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                                    int i3613 = -Color.rgb(0, 0, 0);
                                    int i3614 = (i3613 ^ (-16777206)) + ((i3613 & (-16777206)) << 1);
                                    Object[] objArr911 = new Object[1];
                                    a(cMyPid2, (i3612 ^ 1843) + ((i3612 & 1843) << 1), i3614, objArr911);
                                    char cResolveOpacity3 = (char) Drawable.resolveOpacity(0, 0);
                                    Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                    int i3615 = -View.combineMeasuredStates(0, 0);
                                    int i3616 = ((1852 | i3615) << 1) - (i3615 ^ 1852);
                                    int i3617 = -(-(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                                    int i3618 = (i3617 ^ 10) + ((i3617 & 10) << 1);
                                    Object[] objArr912 = new Object[1];
                                    a(cResolveOpacity3, i3616, i3618, objArr912);
                                    int i3619 = -(ViewConfiguration.getLongPressTimeout() >> 16);
                                    Object[] objArr913 = new Object[1];
                                    a((char) ((i3619 ^ 61549) + ((i3619 & 61549) << 1)), 587 - (~(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), (ViewConfiguration.getEdgeSlop() >> 16) + 6, objArr913);
                                    String[] strArr12 = {(String) objArr912[0], (String) objArr913[0]};
                                    char cMakeMeasureSpec2 = (char) View.MeasureSpec.makeMeasureSpec(0, 0);
                                    int i3710 = -MotionEvent.axisFromString(str4);
                                    int i3711 = (i3710 & 1862) + (i3710 | 1862);
                                    int offsetAfter6 = TextUtils.getOffsetAfter(str4, 0);
                                    int iIPostMessageService8 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                    int i3712 = offsetAfter6 * 483;
                                    int i3713 = (i3712 & 6776) + (i3712 | 6776);
                                    int i3714 = ~offsetAfter6;
                                    int i3715 = ~((i3714 ^ (-29)) | (i3714 & (-29)));
                                    int i3716 = ~iIPostMessageService8;
                                    int i3717 = ~((i3714 ^ i3716) | (i3714 & i3716));
                                    int i3718 = -(-(((i3715 & i3717) | (i3715 ^ i3717)) * (-241)));
                                    int i3719 = (((i3713 | i3718) << 1) - (i3713 ^ i3718)) + (((offsetAfter6 ^ 28) | (offsetAfter6 & 28)) * (-482));
                                    int i3810 = ~((offsetAfter6 & (-29)) | ((-29) ^ offsetAfter6));
                                    int i3811 = i3716 | i3714;
                                    int i3812 = ~((i3811 & 28) | (i3811 ^ 28));
                                    int i3813 = i3719 + (((i3812 & i3810) | (i3810 ^ i3812)) * 241);
                                    Object[] objArr914 = new Object[1];
                                    a(cMakeMeasureSpec2, i3711, i3813, objArr914);
                                    String str310 = (String) objArr914[0];
                                    char c211 = (char) (24327 - (~Process.getGidForName(str4)));
                                    int i3814 = -(ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                                    Object[] objArr915 = new Object[1];
                                    a(c211, (i3814 ^ 1842) + ((i3814 & 1842) << 1), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 9, objArr915);
                                    c5 = 0;
                                    strArr = new String[][]{new String[]{str210, (String) objArr811[0]}, new String[]{str211, str212, (String) objArr814[0]}, new String[]{str213, (String) objArr911[0]}, strArr12, new String[]{str310, (String) objArr915[0]}};
                                    i24 = 0;
                                    i25 = 5;
                                    i26 = -1;
                                    loop5: while (true) {
                                        if (i24 >= i25) {
                                            i27 = i;
                                            break;
                                        }
                                        String[] strArr13 = strArr[i24];
                                        str5 = strArr13[c5];
                                        strArr2 = (String[]) Arrays.copyOfRange(strArr13, 1, strArr13.length);
                                        length = strArr2.length;
                                        i33 = 0;
                                        while (i33 < length) {
                                            i34 = i26 + 1;
                                            Object[] objArr916 = {str5, strArr2[i33]};
                                            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-883653127);
                                            if (objAccessartificialFrame4 == null) {
                                                int iLastIndexOf7 = 30 - TextUtils.lastIndexOf(str4, '0', 0, 0);
                                                char c212 = (char) (57023 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                                                int iMyTid2 = 2311 - (Process.myTid() >> 22);
                                                byte b18 = (byte) ($$b & 19);
                                                byte b19 = $$a[20];
                                                Object[] objArr917 = new Object[1];
                                                b(b18, b19, (byte) (b19 + 5), objArr917);
                                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iLastIndexOf7, c212, iMyTid2, 1412547569, false, (String) objArr917[0], new Class[]{String.class, String.class});
                                            }
                                            long jLongValue15 = ((Long) ((Method) objAccessartificialFrame4).invoke(null, objArr916)).longValue();
                                            long j510 = -17848847;
                                            long j610 = -754;
                                            long j611 = j510 ^ j;
                                            long j612 = j611 | jLongValue15;
                                            i35 = length;
                                            long jUptimeMillis3 = (int) SystemClock.uptimeMillis();
                                            long j613 = (((long) 755) * j510) + (((long) (-753)) * jLongValue15) + (((j612 ^ j) | ((j611 | jUptimeMillis3) ^ j) | ((jLongValue15 | jUptimeMillis3) ^ j)) * j610);
                                            long j614 = (j612 | jUptimeMillis3) ^ j;
                                            long j615 = jUptimeMillis3 ^ j;
                                            long j616 = j613 + (j610 * (j614 | ((jLongValue15 | (j510 | j615)) ^ j))) + (((long) 754) * (j611 | j615)) + ((long) (-136902782));
                                            i36 = ((int) (j616 >> 32)) & (78586646 + (((~(1125022391 | i)) | 608240904 | (~((-1732718494) | i))) * (-754)) + (((~((-608240905) | i)) | (~((-1124477590) | i16))) * (-754)) + ((1125022391 | i16) * 754));
                                            i37 = ((int) j616) & ((((~(877330483 | i)) | 1980410402) * 56) + 1210426141 + ((877330483 | (~(1980410402 | i16))) * 56));
                                            if (((i36 & i37) | (i36 ^ i37)) != 0) {
                                                i27 = i ^ (i26 + 171);
                                                break loop5;
                                            }
                                            i33++;
                                            strArr = strArr;
                                            strArr2 = strArr2;
                                            str5 = str5;
                                            i26 = i34;
                                            length = i35;
                                        }
                                        i24++;
                                        strArr = strArr;
                                        i25 = 5;
                                        c5 = 0;
                                    }
                                    if (i27 != i) {
                                        objArr2 = new Object[]{null, new int[1], null, new int[]{i}, new int[]{i27}};
                                        int i3815 = getARTIFICIAL_FRAME_PACKAGE_NAME + 113;
                                        artificialFrame = i3815 % 128;
                                        int i3816 = i3815 % 2;
                                        int elapsedCpuTime4 = (int) Process.getElapsedCpuTime();
                                        int i3817 = (-2030458348) + (((-306319490) | elapsedCpuTime4) * (-627)) + (((~((-229388135) | elapsedCpuTime4)) | 376060323) * (-627)) + (((~(elapsedCpuTime4 | 376060323)) | (~((~elapsedCpuTime4) | 229388134))) * 627);
                                        int i3818 = (i3817 & 16) + (i3817 | 16);
                                        int i3819 = (i3 ^ i3818) + ((i3 & i3818) << 1);
                                        int i3910 = i3819 << 13;
                                        int i3911 = (i3910 & (~i3819)) | ((~i3910) & i3819);
                                        int i3912 = i3911 ^ (i3911 >>> 17);
                                        int i3913 = artificialFrame + 101;
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i3913 % 128;
                                        int i3914 = i3913 % 2;
                                        ((int[]) objArr2[1])[0] = i3912 ^ (i3912 << 5);
                                    } else {
                                        int i3915 = -View.MeasureSpec.getSize(0);
                                        char c213 = (char) ((i3915 ^ 22173) + ((i3915 & 22173) << 1));
                                        int i3916 = 1890 - (~(-(-(ViewConfiguration.getEdgeSlop() >> 16))));
                                        int i3917 = -TextUtils.lastIndexOf(str4, '0');
                                        Object[] objArr918 = new Object[1];
                                        a(c213, i3916, (i3917 & 12) + (i3917 | 12), objArr918);
                                        String str311 = (String) objArr918[0];
                                        int iResolveSize2 = View.resolveSize(0, 0);
                                        char c214 = (char) (((iResolveSize2 | 42082) << 1) - (42082 ^ iResolveSize2));
                                        int minimumFlingVelocity3 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 1904;
                                        int i3918 = -TextUtils.indexOf(str4, str4, 0);
                                        int i3919 = (i3918 ^ 8) + ((i3918 & 8) << 1);
                                        Object[] objArr919 = new Object[1];
                                        a(c214, minimumFlingVelocity3, i3919, objArr919);
                                        String str312 = (String) objArr919[0];
                                        file = new File(str311);
                                        if (file.exists()) {
                                            i28 = i;
                                        } else {
                                            i28 = i;
                                        }
                                        if (i28 == i) {
                                            int iLastIndexOf8 = TextUtils.lastIndexOf(str4, '0', 0);
                                            int iIPostMessageService9 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                            int i4010 = ~iLastIndexOf8;
                                            int i4011 = ~iIPostMessageService9;
                                            int i4012 = ((iLastIndexOf8 * (-433)) - 1577448) + (((~((i4011 & i4010) | (i4010 ^ i4011))) | (~(((-7304) & iIPostMessageService9) | ((-7304) ^ iIPostMessageService9)))) * JfifUtil.MARKER_EOI);
                                            int i4013 = ~((i4010 & (-7304)) | (i4010 ^ (-7304)));
                                            int i4014 = ~iLastIndexOf8;
                                            int i4015 = ~((i4014 & iIPostMessageService9) | (i4014 ^ iIPostMessageService9));
                                            int i4016 = ((i4013 & i4015) | (i4013 ^ i4015)) * JfifUtil.MARKER_EOI;
                                            int i4110 = ~iIPostMessageService9;
                                            int i4111 = ~((i4110 & (-7304)) | ((-7304) ^ i4110));
                                            char c215 = (char) ((((i4012 | i4016) << 1) - (i4012 ^ i4016)) + (((i4111 & iLastIndexOf8) | (iLastIndexOf8 ^ i4111)) * JfifUtil.MARKER_EOI));
                                            int i4112 = -View.resolveSize(0, 0);
                                            Object[] objArr1010 = new Object[1];
                                            a(c215, (i4112 ^ 1912) + ((i4112 & 1912) << 1), TextUtils.getCapsMode(str4, 0, 0) + 47, objArr1010);
                                            Object[] objArr1011 = {(String) objArr1010[0]};
                                            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(479197382);
                                            if (objAccessartificialFrame3 == null) {
                                                int jumpTapTimeout3 = (ViewConfiguration.getJumpTapTimeout() >> 16) + 17;
                                                char cLastIndexOf3 = (char) (24342 - TextUtils.lastIndexOf(str4, '0', 0, 0));
                                                int iResolveSizeAndState2 = View.resolveSizeAndState(0, 0, 0) + 2014;
                                                byte[] bArr110 = $$a;
                                                Object[] objArr1012 = new Object[1];
                                                b((byte) (-bArr110[c2]), bArr110[0], bArr110[13], objArr1012);
                                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout3, cLastIndexOf3, iResolveSizeAndState2, -2081767730, false, (String) objArr1012[0], new Class[]{String.class});
                                            }
                                            long jLongValue16 = ((Long) ((Method) objAccessartificialFrame3).invoke(null, objArr1011)).longValue();
                                            long j617 = -270720422;
                                            long j618 = j617 ^ j;
                                            long j619 = (((long) 236) * j617) + (((long) 471) * jLongValue16) + (((long) (-235)) * ((((j37 ^ j) | j618) ^ j) | jLongValue16)) + (((long) (-470)) * (((j618 | j37) ^ j) | jLongValue16)) + (((long) 235) * ((((jLongValue16 | j618) | j37) ^ j) | ((j617 | (jLongValue16 ^ j)) ^ j))) + ((long) 767331813);
                                            int i4113 = ~(1740988638 | i);
                                            int i4114 = ((int) (j619 >> 32)) & ((((-1977510894) | i4113) * (-658)) + 2084340718 + ((i4113 | (-2011130880)) * 658));
                                            int startElapsedRealtime3 = (int) Process.getStartElapsedRealtime();
                                            int i4115 = ~startElapsedRealtime3;
                                            int i4116 = ((int) j619) & (802172634 + (((-570689025) | i4115) * (-369)) + (((~(839255688 | i4115)) | (-597970722)) * (-369)) + (((~(startElapsedRealtime3 | (-839255689))) | 268566664 | (~(i4115 | (-27281698)))) * 369));
                                            i29 = (((i4114 & i4116) | (i4114 ^ i4116)) * 263) ^ i;
                                            if (i29 != i) {
                                                Object[] objArr1013 = {null, new int[]{(i422 | i423) & (~(i422 & i423))}, null, new int[]{i}, new int[]{i29}};
                                                int i4117 = 1778863633 + ((1073216506 | i16) * SyslogConstants.LOG_LOCAL7) + (((~(1040667266 | i16)) | 670546938) * SyslogConstants.LOG_LOCAL7);
                                                int i4118 = i3 + (i4117 ^ 16) + ((i4117 & 16) << 1);
                                                int i4119 = i4118 << 13;
                                                int i4210 = ((~i4118) & i4119) | ((~i4119) & i4118);
                                                int i4211 = i4210 >>> 17;
                                                int i4212 = ((~i4210) & i4211) | ((~i4211) & i4210);
                                                int i4213 = i4212 << 5;
                                                return objArr1013;
                                            }
                                            Object[] objArr1014 = {null, new int[1], null, new int[]{i}, new int[]{i}};
                                            Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                            int iMyPid3 = Process.myPid();
                                            int i4214 = (((~(iMyPid3 | 712483870)) | (-107035413)) * 56) + 1596557073 + (((~((~iMyPid3) | (-107035413))) | 712483870) * 56);
                                            int i4215 = -(-((i4214 << 1) - i4214));
                                            i30 = (i3 ^ i4215) + ((i3 & i4215) << 1);
                                            i31 = getARTIFICIAL_FRAME_PACKAGE_NAME + 37;
                                            artificialFrame = i31 % 128;
                                            if (i31 % 2 == 0) {
                                                int i4216 = i30 % 13;
                                                int i4217 = (i4216 & (~i30)) | ((~i4216) & i30);
                                                int i4218 = i4217 >> 119;
                                                int i4219 = (i4217 | i4218) & (~(i4217 & i4218));
                                                i32 = i4219 ^ (i4219 * 2);
                                            } else {
                                                int i4310 = i30 << 13;
                                                int i4311 = (i4310 & (~i30)) | ((~i4310) & i30);
                                                int i4312 = i4311 >>> 17;
                                                int i4313 = ((~i4311) & i4312) | ((~i4312) & i4311);
                                                int i4314 = i4313 << 5;
                                                i32 = ((~i4313) & i4314) | ((~i4314) & i4313);
                                            }
                                            ((int[]) objArr1014[1])[0] = i32;
                                            return objArr1014;
                                        }
                                        objArr2 = new Object[]{null, new int[1], null, new int[]{i}, new int[]{i28}};
                                        int iNextInt6 = new Random().nextInt(567550856);
                                        int i4315 = ~iNextInt6;
                                        int i4316 = 654520734 + (((~(i4315 | (-233448414))) | 233448216 | (~((-838896675) | iNextInt6))) * 717) + (((~(iNextInt6 | (-233448414))) | (~(i4315 | (-838896675))) | 233448216) * 717);
                                        int i4317 = ((i4316 | 16) << 1) - (i4316 ^ 16);
                                        int i4318 = ((i3 | i4317) << 1) - (i3 ^ i4317);
                                        int i4319 = i4318 << 13;
                                        int i4410 = (i4319 & (~i4318)) | ((~i4319) & i4318);
                                        int i4411 = i4410 >>> 17;
                                        int i4412 = (i4410 | i4411) & (~(i4410 & i4411));
                                        ((int[]) objArr2[1])[0] = i4412 ^ (i4412 << 5);
                                    }
                                }
                            } else {
                                char mirror4 = AndroidCharacter.getMirror('0');
                                int iIPostMessageService10 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                int i3317 = mirror4 * 765;
                                int i3318 = (i3317 ^ 73296) + ((i3317 & 73296) << 1);
                                int i3319 = ~iIPostMessageService10;
                                int i33110 = ~((i3319 ^ mirror4) | (i3319 & mirror4));
                                int i33111 = ((i33110 & (-48)) | (i33110 ^ (-48))) * 764;
                                int i33112 = ((i3318 | i33111) << 1) - (i33111 ^ i3318);
                                int i33113 = ~mirror4;
                                int i34110 = ~((i33113 & (-48)) | (i33113 ^ (-48)));
                                int i34111 = ~((i3319 & (-48)) | (i3319 ^ (-48)));
                                int i34112 = ((i34111 & i34110) | (i34110 ^ i34111)) * (-1528);
                                int i34113 = (i33112 & i34112) + (i34112 | i33112);
                                int i34114 = ~mirror4;
                                int i34115 = ~((i34114 & (-48)) | (i34114 ^ (-48)));
                                int i34116 = ~('/' | mirror4);
                                int i34117 = (i34115 & i34116) | (i34115 ^ i34116);
                                int i34118 = ~iIPostMessageService10;
                                int i34119 = ~((i34118 & mirror4) | (i34118 ^ mirror4));
                                int i35110 = ((i34119 & i34117) | (i34117 ^ i34119)) * 764;
                                char c111 = (char) (((i34113 | i35110) << 1) - (i35110 ^ i34113));
                                int iResolveOpacity3 = Drawable.resolveOpacity(0, 0);
                                Object[] objArr815 = new Object[1];
                                a(c111, (iResolveOpacity3 ^ 1755) + ((iResolveOpacity3 & 1755) << 1), 11 - (~(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), objArr815);
                                String str214 = (String) objArr815[0];
                                int i35111 = -(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                                int iKeyCodeFromString4 = KeyEvent.keyCodeFromString(str4);
                                Object[] objArr816 = new Object[1];
                                a((char) ((i35111 & 1) + (i35111 | 1)), ((iKeyCodeFromString4 | 1768) << 1) - (iKeyCodeFromString4 ^ 1768), 5 - Color.blue(0), objArr816);
                                int i35112 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                                Object[] objArr817 = new Object[1];
                                a((char) ((i35112 ^ (-1)) + (i35112 << 1)), 1773 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (ViewConfiguration.getTapTimeout() >> 16) + 15, objArr817);
                                String str215 = (String) objArr817[0];
                                char trimmedLength4 = (char) TextUtils.getTrimmedLength(str4);
                                int i35113 = -TextUtils.indexOf(str4, str4, 0);
                                int i35114 = (i35113 & 1788) + (i35113 | 1788);
                                int i35115 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                                int i35116 = ((i35115 | 18) << 1) - (i35115 ^ 18);
                                Object[] objArr818 = new Object[1];
                                a(trimmedLength4, i35114, i35116, objArr818);
                                String str216 = (String) objArr818[0];
                                char c216 = (char) (56413 - (~(-TextUtils.lastIndexOf(str4, '0', 0))));
                                int i35117 = -(-(ViewConfiguration.getScrollDefaultDelay() >> 16));
                                Object[] objArr819 = new Object[1];
                                a(c216, ((i35117 | 1807) << 1) - (i35117 ^ 1807), 13 - (~(-(-TextUtils.indexOf(str4, str4)))), objArr819);
                                int i35118 = -(-Color.rgb(0, 0, 0));
                                int i35119 = -TextUtils.lastIndexOf(str4, '0');
                                int i36110 = ((i35119 | 1820) << 1) - (i35119 ^ 1820);
                                int packedPositionChild4 = ExpandableListView.getPackedPositionChild(0L);
                                int i36111 = ((packedPositionChild4 | 22) << 1) - (packedPositionChild4 ^ 22);
                                Object[] objArr9110 = new Object[1];
                                a((char) ((i35118 & 16777216) + (i35118 | 16777216)), i36110, i36111, objArr9110);
                                String str217 = (String) objArr9110[0];
                                char cMyPid3 = (char) (24327 - (Process.myPid() >> 22));
                                int i36112 = -(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                                int i36113 = -Color.rgb(0, 0, 0);
                                int i36114 = (i36113 ^ (-16777206)) + ((i36113 & (-16777206)) << 1);
                                Object[] objArr9111 = new Object[1];
                                a(cMyPid3, (i36112 ^ 1843) + ((i36112 & 1843) << 1), i36114, objArr9111);
                                char cResolveOpacity4 = (char) Drawable.resolveOpacity(0, 0);
                                Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                int i36115 = -View.combineMeasuredStates(0, 0);
                                int i36116 = ((1852 | i36115) << 1) - (i36115 ^ 1852);
                                int i36117 = -(-(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                                int i36118 = (i36117 ^ 10) + ((i36117 & 10) << 1);
                                Object[] objArr9112 = new Object[1];
                                a(cResolveOpacity4, i36116, i36118, objArr9112);
                                int i36119 = -(ViewConfiguration.getLongPressTimeout() >> 16);
                                Object[] objArr9113 = new Object[1];
                                a((char) ((i36119 ^ 61549) + ((i36119 & 61549) << 1)), 587 - (~(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), (ViewConfiguration.getEdgeSlop() >> 16) + 6, objArr9113);
                                String[] strArr14 = {(String) objArr9112[0], (String) objArr9113[0]};
                                char cMakeMeasureSpec3 = (char) View.MeasureSpec.makeMeasureSpec(0, 0);
                                int i37110 = -MotionEvent.axisFromString(str4);
                                int i37111 = (i37110 & 1862) + (i37110 | 1862);
                                int offsetAfter7 = TextUtils.getOffsetAfter(str4, 0);
                                int iIPostMessageService11 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                int i37112 = offsetAfter7 * 483;
                                int i37113 = (i37112 & 6776) + (i37112 | 6776);
                                int i37114 = ~offsetAfter7;
                                int i37115 = ~((i37114 ^ (-29)) | (i37114 & (-29)));
                                int i37116 = ~iIPostMessageService11;
                                int i37117 = ~((i37114 ^ i37116) | (i37114 & i37116));
                                int i37118 = -(-(((i37115 & i37117) | (i37115 ^ i37117)) * (-241)));
                                int i37119 = (((i37113 | i37118) << 1) - (i37113 ^ i37118)) + (((offsetAfter7 ^ 28) | (offsetAfter7 & 28)) * (-482));
                                int i38110 = ~((offsetAfter7 & (-29)) | ((-29) ^ offsetAfter7));
                                int i38111 = i37116 | i37114;
                                int i38112 = ~((i38111 & 28) | (i38111 ^ 28));
                                int i38113 = i37119 + (((i38112 & i38110) | (i38110 ^ i38112)) * 241);
                                Object[] objArr9114 = new Object[1];
                                a(cMakeMeasureSpec3, i37111, i38113, objArr9114);
                                String str313 = (String) objArr9114[0];
                                char c217 = (char) (24327 - (~Process.getGidForName(str4)));
                                int i38114 = -(ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                                Object[] objArr9115 = new Object[1];
                                a(c217, (i38114 ^ 1842) + ((i38114 & 1842) << 1), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 9, objArr9115);
                                c5 = 0;
                                strArr = new String[][]{new String[]{str214, (String) objArr816[0]}, new String[]{str215, str216, (String) objArr819[0]}, new String[]{str217, (String) objArr9111[0]}, strArr14, new String[]{str313, (String) objArr9115[0]}};
                                i24 = 0;
                                i25 = 5;
                                i26 = -1;
                                loop5: while (true) {
                                    if (i24 >= i25) {
                                        i27 = i;
                                        break;
                                    }
                                    String[] strArr15 = strArr[i24];
                                    str5 = strArr15[c5];
                                    strArr2 = (String[]) Arrays.copyOfRange(strArr15, 1, strArr15.length);
                                    length = strArr2.length;
                                    i33 = 0;
                                    while (i33 < length) {
                                        i34 = i26 + 1;
                                        Object[] objArr9116 = {str5, strArr2[i33]};
                                        objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-883653127);
                                        if (objAccessartificialFrame4 == null) {
                                            int iLastIndexOf9 = 30 - TextUtils.lastIndexOf(str4, '0', 0, 0);
                                            char c218 = (char) (57023 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                                            int iMyTid3 = 2311 - (Process.myTid() >> 22);
                                            byte b110 = (byte) ($$b & 19);
                                            byte b111 = $$a[20];
                                            Object[] objArr9117 = new Object[1];
                                            b(b110, b111, (byte) (b111 + 5), objArr9117);
                                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iLastIndexOf9, c218, iMyTid3, 1412547569, false, (String) objArr9117[0], new Class[]{String.class, String.class});
                                        }
                                        long jLongValue17 = ((Long) ((Method) objAccessartificialFrame4).invoke(null, objArr9116)).longValue();
                                        long j511 = -17848847;
                                        long j6110 = -754;
                                        long j6111 = j511 ^ j;
                                        long j6112 = j6111 | jLongValue17;
                                        i35 = length;
                                        long jUptimeMillis4 = (int) SystemClock.uptimeMillis();
                                        long j6113 = (((long) 755) * j511) + (((long) (-753)) * jLongValue17) + (((j6112 ^ j) | ((j6111 | jUptimeMillis4) ^ j) | ((jLongValue17 | jUptimeMillis4) ^ j)) * j6110);
                                        long j6114 = (j6112 | jUptimeMillis4) ^ j;
                                        long j6115 = jUptimeMillis4 ^ j;
                                        long j6116 = j6113 + (j6110 * (j6114 | ((jLongValue17 | (j511 | j6115)) ^ j))) + (((long) 754) * (j6111 | j6115)) + ((long) (-136902782));
                                        i36 = ((int) (j6116 >> 32)) & (78586646 + (((~(1125022391 | i)) | 608240904 | (~((-1732718494) | i))) * (-754)) + (((~((-608240905) | i)) | (~((-1124477590) | i16))) * (-754)) + ((1125022391 | i16) * 754));
                                        i37 = ((int) j6116) & ((((~(877330483 | i)) | 1980410402) * 56) + 1210426141 + ((877330483 | (~(1980410402 | i16))) * 56));
                                        if (((i36 & i37) | (i36 ^ i37)) != 0) {
                                            i27 = i ^ (i26 + 171);
                                            break loop5;
                                        }
                                        i33++;
                                        strArr = strArr;
                                        strArr2 = strArr2;
                                        str5 = str5;
                                        i26 = i34;
                                        length = i35;
                                    }
                                    i24++;
                                    strArr = strArr;
                                    i25 = 5;
                                    c5 = 0;
                                }
                                if (i27 != i) {
                                    objArr2 = new Object[]{null, new int[1], null, new int[]{i}, new int[]{i27}};
                                    int i38115 = getARTIFICIAL_FRAME_PACKAGE_NAME + 113;
                                    artificialFrame = i38115 % 128;
                                    int i38116 = i38115 % 2;
                                    int elapsedCpuTime5 = (int) Process.getElapsedCpuTime();
                                    int i38117 = (-2030458348) + (((-306319490) | elapsedCpuTime5) * (-627)) + (((~((-229388135) | elapsedCpuTime5)) | 376060323) * (-627)) + (((~(elapsedCpuTime5 | 376060323)) | (~((~elapsedCpuTime5) | 229388134))) * 627);
                                    int i38118 = (i38117 & 16) + (i38117 | 16);
                                    int i38119 = (i3 ^ i38118) + ((i3 & i38118) << 1);
                                    int i39110 = i38119 << 13;
                                    int i39111 = (i39110 & (~i38119)) | ((~i39110) & i38119);
                                    int i39112 = i39111 ^ (i39111 >>> 17);
                                    int i39113 = artificialFrame + 101;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i39113 % 128;
                                    int i39114 = i39113 % 2;
                                    ((int[]) objArr2[1])[0] = i39112 ^ (i39112 << 5);
                                } else {
                                    int i39115 = -View.MeasureSpec.getSize(0);
                                    char c219 = (char) ((i39115 ^ 22173) + ((i39115 & 22173) << 1));
                                    int i39116 = 1890 - (~(-(-(ViewConfiguration.getEdgeSlop() >> 16))));
                                    int i39117 = -TextUtils.lastIndexOf(str4, '0');
                                    Object[] objArr9118 = new Object[1];
                                    a(c219, i39116, (i39117 & 12) + (i39117 | 12), objArr9118);
                                    String str314 = (String) objArr9118[0];
                                    int iResolveSize3 = View.resolveSize(0, 0);
                                    char c2110 = (char) (((iResolveSize3 | 42082) << 1) - (42082 ^ iResolveSize3));
                                    int minimumFlingVelocity4 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 1904;
                                    int i39118 = -TextUtils.indexOf(str4, str4, 0);
                                    int i39119 = (i39118 ^ 8) + ((i39118 & 8) << 1);
                                    Object[] objArr9119 = new Object[1];
                                    a(c2110, minimumFlingVelocity4, i39119, objArr9119);
                                    String str315 = (String) objArr9119[0];
                                    file = new File(str314);
                                    if (file.exists()) {
                                        i28 = i;
                                    } else {
                                        i28 = i;
                                    }
                                    if (i28 == i) {
                                        int iLastIndexOf10 = TextUtils.lastIndexOf(str4, '0', 0);
                                        int iIPostMessageService12 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                        int i4017 = ~iLastIndexOf10;
                                        int i4018 = ~iIPostMessageService12;
                                        int i4019 = ((iLastIndexOf10 * (-433)) - 1577448) + (((~((i4018 & i4017) | (i4017 ^ i4018))) | (~(((-7304) & iIPostMessageService12) | ((-7304) ^ iIPostMessageService12)))) * JfifUtil.MARKER_EOI);
                                        int i40110 = ~((i4017 & (-7304)) | (i4017 ^ (-7304)));
                                        int i40111 = ~iLastIndexOf10;
                                        int i40112 = ~((i40111 & iIPostMessageService12) | (i40111 ^ iIPostMessageService12));
                                        int i40113 = ((i40110 & i40112) | (i40110 ^ i40112)) * JfifUtil.MARKER_EOI;
                                        int i41110 = ~iIPostMessageService12;
                                        int i41111 = ~((i41110 & (-7304)) | ((-7304) ^ i41110));
                                        char c2111 = (char) ((((i4019 | i40113) << 1) - (i4019 ^ i40113)) + (((i41111 & iLastIndexOf10) | (iLastIndexOf10 ^ i41111)) * JfifUtil.MARKER_EOI));
                                        int i41112 = -View.resolveSize(0, 0);
                                        Object[] objArr1015 = new Object[1];
                                        a(c2111, (i41112 ^ 1912) + ((i41112 & 1912) << 1), TextUtils.getCapsMode(str4, 0, 0) + 47, objArr1015);
                                        Object[] objArr1016 = {(String) objArr1015[0]};
                                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(479197382);
                                        if (objAccessartificialFrame3 == null) {
                                            int jumpTapTimeout4 = (ViewConfiguration.getJumpTapTimeout() >> 16) + 17;
                                            char cLastIndexOf4 = (char) (24342 - TextUtils.lastIndexOf(str4, '0', 0, 0));
                                            int iResolveSizeAndState3 = View.resolveSizeAndState(0, 0, 0) + 2014;
                                            byte[] bArr111 = $$a;
                                            Object[] objArr1017 = new Object[1];
                                            b((byte) (-bArr111[c2]), bArr111[0], bArr111[13], objArr1017);
                                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout4, cLastIndexOf4, iResolveSizeAndState3, -2081767730, false, (String) objArr1017[0], new Class[]{String.class});
                                        }
                                        long jLongValue18 = ((Long) ((Method) objAccessartificialFrame3).invoke(null, objArr1016)).longValue();
                                        long j6117 = -270720422;
                                        long j6118 = j6117 ^ j;
                                        long j6119 = (((long) 236) * j6117) + (((long) 471) * jLongValue18) + (((long) (-235)) * ((((j37 ^ j) | j6118) ^ j) | jLongValue18)) + (((long) (-470)) * (((j6118 | j37) ^ j) | jLongValue18)) + (((long) 235) * ((((jLongValue18 | j6118) | j37) ^ j) | ((j6117 | (jLongValue18 ^ j)) ^ j))) + ((long) 767331813);
                                        int i41113 = ~(1740988638 | i);
                                        int i41114 = ((int) (j6119 >> 32)) & ((((-1977510894) | i41113) * (-658)) + 2084340718 + ((i41113 | (-2011130880)) * 658));
                                        int startElapsedRealtime4 = (int) Process.getStartElapsedRealtime();
                                        int i41115 = ~startElapsedRealtime4;
                                        int i41116 = ((int) j6119) & (802172634 + (((-570689025) | i41115) * (-369)) + (((~(839255688 | i41115)) | (-597970722)) * (-369)) + (((~(startElapsedRealtime4 | (-839255689))) | 268566664 | (~(i41115 | (-27281698)))) * 369));
                                        i29 = (((i41114 & i41116) | (i41114 ^ i41116)) * 263) ^ i;
                                        if (i29 != i) {
                                            Object[] objArr1018 = {null, new int[]{(i4212 | i4213) & (~(i4212 & i4213))}, null, new int[]{i}, new int[]{i29}};
                                            int i41117 = 1778863633 + ((1073216506 | i16) * SyslogConstants.LOG_LOCAL7) + (((~(1040667266 | i16)) | 670546938) * SyslogConstants.LOG_LOCAL7);
                                            int i41118 = i3 + (i41117 ^ 16) + ((i41117 & 16) << 1);
                                            int i41119 = i41118 << 13;
                                            int i42110 = ((~i41118) & i41119) | ((~i41119) & i41118);
                                            int i42111 = i42110 >>> 17;
                                            int i42112 = ((~i42110) & i42111) | ((~i42111) & i42110);
                                            int i42113 = i42112 << 5;
                                            return objArr1018;
                                        }
                                        Object[] objArr1019 = {null, new int[1], null, new int[]{i}, new int[]{i}};
                                        Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                        int iMyPid4 = Process.myPid();
                                        int i42114 = (((~(iMyPid4 | 712483870)) | (-107035413)) * 56) + 1596557073 + (((~((~iMyPid4) | (-107035413))) | 712483870) * 56);
                                        int i42115 = -(-((i42114 << 1) - i42114));
                                        i30 = (i3 ^ i42115) + ((i3 & i42115) << 1);
                                        i31 = getARTIFICIAL_FRAME_PACKAGE_NAME + 37;
                                        artificialFrame = i31 % 128;
                                        if (i31 % 2 == 0) {
                                            int i42116 = i30 % 13;
                                            int i42117 = (i42116 & (~i30)) | ((~i42116) & i30);
                                            int i42118 = i42117 >> 119;
                                            int i42119 = (i42117 | i42118) & (~(i42117 & i42118));
                                            i32 = i42119 ^ (i42119 * 2);
                                        } else {
                                            int i43110 = i30 << 13;
                                            int i43111 = (i43110 & (~i30)) | ((~i43110) & i30);
                                            int i43112 = i43111 >>> 17;
                                            int i43113 = ((~i43111) & i43112) | ((~i43112) & i43111);
                                            int i43114 = i43113 << 5;
                                            i32 = ((~i43113) & i43114) | ((~i43114) & i43113);
                                        }
                                        ((int[]) objArr1019[1])[0] = i32;
                                        return objArr1019;
                                    }
                                    objArr2 = new Object[]{null, new int[1], null, new int[]{i}, new int[]{i28}};
                                    int iNextInt7 = new Random().nextInt(567550856);
                                    int i43115 = ~iNextInt7;
                                    int i43116 = 654520734 + (((~(i43115 | (-233448414))) | 233448216 | (~((-838896675) | iNextInt7))) * 717) + (((~(iNextInt7 | (-233448414))) | (~(i43115 | (-838896675))) | 233448216) * 717);
                                    int i43117 = ((i43116 | 16) << 1) - (i43116 ^ 16);
                                    int i43118 = ((i3 | i43117) << 1) - (i3 ^ i43117);
                                    int i43119 = i43118 << 13;
                                    int i4413 = (i43119 & (~i43118)) | ((~i43119) & i43118);
                                    int i4414 = i4413 >>> 17;
                                    int i4415 = (i4413 | i4414) & (~(i4413 & i4414));
                                    ((int[]) objArr2[1])[0] = i4415 ^ (i4415 << 5);
                                }
                            }
                        }
                    }
                    char c31 = (char) (64351 - (~(-(-TextUtils.getOffsetAfter(str3, 0)))));
                    int minimumFlingVelocity5 = ViewConfiguration.getMinimumFlingVelocity() >> 16;
                    Object[] objArr130 = new Object[1];
                    a(c31, (minimumFlingVelocity5 & 372) + (minimumFlingVelocity5 | 372), 22 - (~(-View.MeasureSpec.makeMeasureSpec(0, 0))), objArr130);
                    String str52 = (String) objArr130[0];
                    char offsetBefore4 = (char) (TextUtils.getOffsetBefore(str3, 0) + 40187);
                    int fadingEdgeLength3 = (ViewConfiguration.getFadingEdgeLength() >> 16) + 617;
                    int i506 = -(-(ViewConfiguration.getTouchSlop() >> 8));
                    int i507 = ((i506 | 10) << 1) - (i506 ^ 10);
                    Object[] objArr131 = new Object[1];
                    a(offsetBefore4, fadingEdgeLength3, i507, objArr131);
                    String str53 = (String) objArr131[0];
                    char c32 = (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                    int i508 = -KeyEvent.keyCodeFromString(str3);
                    int i509 = (i508 ^ 627) + ((i508 & 627) << 1);
                    int i510 = -TextUtils.indexOf(str3, str3, 0);
                    int i511 = (i510 & 7) + (i510 | 7);
                    Object[] objArr132 = new Object[1];
                    a(c32, i509, i511, objArr132);
                    String str54 = (String) objArr132[0];
                    char c33 = (char) (34806 - (~(-AndroidCharacter.getMirror('0'))));
                    int i512 = -(-(ViewConfiguration.getScrollDefaultDelay() >> 16));
                    int iGreen = Color.green(0);
                    int i513 = ((iGreen | 8) << 1) - (iGreen ^ 8);
                    Object[] objArr133 = new Object[1];
                    a(c33, (i512 & 634) + (i512 | 634), i513, objArr133);
                    String[] strArr16 = {str52, str53, str54, (String) objArr133[0]};
                    char minimumFlingVelocity6 = (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                    int iResolveOpacity4 = Drawable.resolveOpacity(0, 0) + 642;
                    int i514 = -TextUtils.lastIndexOf(str3, '0');
                    int iIPostMessageService13 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                    int i515 = i514 * 51;
                    int i516 = (((i515 | (-784)) << 1) - (i515 ^ (-784))) + (((i514 ^ iIPostMessageService13) | (i514 & iIPostMessageService13)) * (-50));
                    int i517 = ~i514;
                    int i518 = (i517 & (-17)) | (i517 ^ (-17));
                    int i519 = ~((i518 & iIPostMessageService13) | (i518 ^ iIPostMessageService13));
                    int i520 = ~iIPostMessageService13;
                    int i521 = ~(((-17) ^ i520) | ((-17) & i520) | i514);
                    int i522 = (i516 - (~(-(-(((i519 ^ i521) | (i519 & i521)) * 50))))) - 1;
                    int i523 = ~((-17) | i520);
                    int i524 = ~(((-17) & i514) | ((-17) ^ i514));
                    int i525 = ~iIPostMessageService13;
                    int i526 = (i522 - (~(-(-(((~((i514 & i525) | (i525 ^ i514))) | ((i523 & i524) | (i523 ^ i524))) * 50))))) - 1;
                    Object[] objArr134 = new Object[1];
                    a(minimumFlingVelocity6, iResolveOpacity4, i526, objArr134);
                    String str55 = (String) objArr134[0];
                    int i527 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                    int i528 = 658 - (~(-(-(ViewConfiguration.getMaximumDrawingCacheSize() >> 24))));
                    int i529 = -TextUtils.indexOf((CharSequence) str3, '0');
                    Object[] objArr135 = new Object[1];
                    a((char) ((i527 ^ 47320) + ((i527 & 47320) << 1)), i528, (i529 & 6) + (i529 | 6), objArr135);
                    String str56 = (String) objArr135[0];
                    char c34 = (char) ((-2) - ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) ^ (-1)));
                    int i530 = 665 - (~(-(-KeyEvent.getDeadChar(0, 0))));
                    int i531 = -(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                    Object[] objArr136 = new Object[1];
                    a(c34, i530, (i531 & 7) + (i531 | 7), objArr136);
                    String str57 = (String) objArr136[0];
                    int iIndexOf8 = TextUtils.indexOf((CharSequence) str3, '0', 0);
                    int i532 = 672 - (~(-(Process.myTid() >> 22)));
                    int packedPositionType2 = ExpandableListView.getPackedPositionType(0L);
                    int i533 = (packedPositionType2 & 11) + (packedPositionType2 | 11);
                    Object[] objArr137 = new Object[1];
                    a((char) ((iIndexOf8 ^ 12493) + ((iIndexOf8 & 12493) << 1)), i532, i533, objArr137);
                    String str58 = (String) objArr137[0];
                    char tapTimeout = (char) ((ViewConfiguration.getTapTimeout() >> 16) + 22483);
                    int i534 = 683 - (~(ViewConfiguration.getLongPressTimeout() >> 16));
                    int i535 = -TextUtils.indexOf(str3, str3, 0, 0);
                    Object[] objArr138 = new Object[1];
                    a(tapTimeout, i534, (i535 ^ 14) + ((i535 & 14) << 1), objArr138);
                    String[] strArr17 = {str55, str56, str57, str58, (String) objArr138[0]};
                    char mirror5 = AndroidCharacter.getMirror('0');
                    char c35 = (char) ((mirror5 & (-48)) + (mirror5 | (-48)));
                    int i536 = -(-View.resolveSizeAndState(0, 0, 0));
                    int i537 = (i536 & 698) + (i536 | 698);
                    int i538 = -TextUtils.indexOf((CharSequence) str3, '0');
                    int i539 = (i538 ^ 15) + ((i538 & 15) << 1);
                    Object[] objArr139 = new Object[1];
                    a(c35, i537, i539, objArr139);
                    String str59 = (String) objArr139[0];
                    char cResolveSize3 = (char) View.resolveSize(0, 0);
                    int iIndexOf9 = TextUtils.indexOf((CharSequence) str3, '0', 0, 0) + 715;
                    int i540 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                    int i541 = ((i540 | 3) << 1) - (i540 ^ 3);
                    Object[] objArr140 = new Object[1];
                    a(cResolveSize3, iIndexOf9, i541, objArr140);
                    String str60 = (String) objArr140[0];
                    int size2 = View.MeasureSpec.getSize(0);
                    int i542 = -Color.red(0);
                    Object[] objArr141 = new Object[1];
                    a((char) ((size2 & 4896) + (size2 | 4896)), (i542 & 725) + (i542 | 725), 21 - (~(ViewConfiguration.getFadingEdgeLength() >> 16)), objArr141);
                    String str61 = (String) objArr141[0];
                    char c36 = (char) (0 - (~(-(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)))));
                    int modifierMetaStateMask3 = ((byte) KeyEvent.getModifierMetaStateMask()) + 748;
                    int i543 = -(-(Process.myTid() >> 22));
                    int i544 = ((i543 | 25) << 1) - (i543 ^ 25);
                    Object[] objArr142 = new Object[1];
                    a(c36, modifierMetaStateMask3, i544, objArr142);
                    String str62 = (String) objArr142[0];
                    int i545 = -(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                    int i546 = i545 * 70;
                    int i547 = (i546 ^ (-317288)) + ((i546 & (-317288)) << 1);
                    int i548 = ~((~i545) | (-4667) | i);
                    int i549 = i545 | 4666;
                    int i550 = ~((i549 & i) | (i549 ^ i));
                    int i551 = ((i548 & i550) | (i548 ^ i550)) * 69;
                    int i552 = (i547 & i551) + (i551 | i547);
                    int i553 = ~i545;
                    int i554 = ~(i553 | 4666);
                    int i555 = ~(i553 | i);
                    int i556 = (i555 & i554) | (i554 ^ i555);
                    int i557 = ~((i ^ 4666) | (i & 4666));
                    int i558 = (i552 - (~(((i556 & i557) | (i556 ^ i557)) * (-69)))) - 1;
                    int i559 = (~((i545 & (-4667)) | ((-4667) ^ i545))) * 69;
                    char c37 = (char) ((i558 ^ i559) + ((i559 & i558) << 1));
                    int iResolveSizeAndState4 = View.resolveSizeAndState(0, 0, 0) + 772;
                    int i560 = -(-(ViewConfiguration.getKeyRepeatTimeout() >> 16));
                    Object[] objArr143 = new Object[1];
                    a(c37, iResolveSizeAndState4, (i560 & 28) + (i560 | 28), objArr143);
                    c2 = 6;
                    long j81 = j21;
                    String[] strArr18 = {str59, str60, str, str61, str62, (String) objArr143[0]};
                    char cNormalizeMetaState = (char) (KeyEvent.normalizeMetaState(0) + 52102);
                    int i561 = -(ViewConfiguration.getPressedStateDuration() >> 16);
                    Object[] objArr144 = new Object[1];
                    a(cNormalizeMetaState, ((i561 | LogSeverity.EMERGENCY_VALUE) << 1) - (i561 ^ LogSeverity.EMERGENCY_VALUE), 10 - (~((Process.getThreadPriority(0) + 20) >> 6)), objArr144);
                    String str63 = (String) objArr144[0];
                    int defaultSize2 = View.getDefaultSize(0, 0);
                    int i562 = 810 - (~(-KeyEvent.getDeadChar(0, 0)));
                    int iIndexOf10 = TextUtils.indexOf(str3, str3, 0, 0);
                    int i563 = iIndexOf10 * (-344);
                    int i564 = ((i563 | (-2752)) << 1) - (i563 ^ (-2752));
                    int i565 = ~iIndexOf10;
                    int i566 = ~((i565 ^ (-9)) | (i565 & (-9)));
                    int i567 = ~((i565 ^ i) | (i565 & i));
                    int i568 = -(-(((i566 & i567) | (i566 ^ i567)) * 345));
                    int i569 = (i564 & i568) + (i564 | i568);
                    int i570 = ~((i565 ^ i16) | (i565 & i16));
                    int i571 = ~(iIndexOf10 | (-9));
                    int i572 = ((i571 & i570) | (i570 ^ i571)) * 345;
                    int i573 = (i569 ^ i572) + ((i572 & i569) << 1);
                    int i574 = (i565 & (-9)) | (i565 ^ (-9));
                    int i575 = -(-((~((i574 & i) | (i574 ^ i))) * 345));
                    int i576 = (i573 ^ i575) + ((i575 & i573) << 1);
                    Object[] objArr145 = new Object[1];
                    a((char) ((defaultSize2 & 43600) + (defaultSize2 | 43600)), i562, i576, objArr145);
                    String str64 = (String) objArr145[0];
                    char cMakeMeasureSpec4 = (char) View.MeasureSpec.makeMeasureSpec(0, 0);
                    int i577 = -TextUtils.getOffsetBefore(str3, 0);
                    int i578 = (i577 & 819) + (i577 | 819);
                    int i579 = -(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                    int i580 = (i579 ^ 6) + ((i579 & 6) << 1);
                    Object[] objArr146 = new Object[1];
                    a(cMakeMeasureSpec4, i578, i580, objArr146);
                    String str65 = (String) objArr146[0];
                    char deadChar4 = (char) KeyEvent.getDeadChar(0, 0);
                    int i581 = -(-(ViewConfiguration.getScrollDefaultDelay() >> 16));
                    int i582 = ((i581 | 825) << 1) - (i581 ^ 825);
                    int i583 = -(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                    int i584 = ((i583 | 7) << 1) - (i583 ^ 7);
                    Object[] objArr147 = new Object[1];
                    a(deadChar4, i582, i584, objArr147);
                    String[] strArr19 = {str63, str64, str65, (String) objArr147[0]};
                    char c38 = (char) ((-(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))) - 1);
                    int i585 = -(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                    int iIPostMessageService14 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                    int i586 = (i585 * 371) + 308301;
                    int i587 = ~iIPostMessageService14;
                    int i588 = ~(((-832) & i587) | ((-832) ^ i587));
                    int i589 = ~i585;
                    int i590 = ~((i589 & iIPostMessageService14) | (i589 ^ iIPostMessageService14));
                    int i591 = ((i588 & i590) | (i588 ^ i590)) * (-370);
                    int i592 = ((i586 | i591) << 1) - (i586 ^ i591);
                    int i593 = ~i585;
                    int i594 = ~((i593 & i587) | (i593 ^ i587));
                    int i595 = ~((iIPostMessageService14 & (-832)) | ((-832) ^ iIPostMessageService14));
                    Object[] objArr148 = new Object[1];
                    a(c38, (((i592 - (~((((i595 & i594) | (i594 ^ i595)) | (~(i585 | 831))) * (-370)))) - 1) - (~(-(-((~((i585 & 831) | (i585 ^ 831))) * 370))))) - 1, 16 - (ViewConfiguration.getScrollBarSize() >> 8), objArr148);
                    String str66 = (String) objArr148[0];
                    char cResolveOpacity5 = (char) Drawable.resolveOpacity(0, 0);
                    int i596 = -(-Color.argb(0, 0, 0, 0));
                    int i597 = (i596 ^ 666) + ((i596 & 666) << 1);
                    int i598 = -View.MeasureSpec.getMode(0);
                    int i599 = i598 * (-574);
                    int i600 = (i599 & (-4018)) + (i599 | (-4018));
                    int i601 = ~((~i598) | i16);
                    int i602 = ((-8) & i) | ((-8) ^ i);
                    int i603 = ~i602;
                    int i604 = -(-(((i601 & i603) | (i601 ^ i603)) * 1150));
                    int i605 = (i600 ^ i604) + ((i604 & i600) << 1);
                    int i606 = ~i602;
                    int i607 = ~(i16 | 7);
                    int i608 = ((i606 & i607) | (i606 ^ i607)) * (-575);
                    int i609 = ((i605 | i608) << 1) - (i608 ^ i605);
                    int i610 = ~i598;
                    int i611 = ~((i610 & i) | (i610 ^ i));
                    int i612 = ~((i4 & i598) | (i4 ^ i598));
                    int i613 = -(-(((i612 & i611) | (i611 ^ i612)) * 575));
                    int i614 = (i609 & i613) + (i613 | i609);
                    Object[] objArr149 = new Object[1];
                    a(cResolveOpacity5, i597, i614, objArr149);
                    String str67 = (String) objArr149[0];
                    char c39 = (char) (34758 - (~(-(ViewConfiguration.getEdgeSlop() >> 16))));
                    int iResolveSizeAndState5 = View.resolveSizeAndState(0, 0, 0);
                    Object[] objArr150 = new Object[1];
                    a(c39, (iResolveSizeAndState5 ^ 634) + ((iResolveSizeAndState5 & 634) << 1), 7 - (~(-Color.argb(0, 0, 0, 0))), objArr150);
                    String[] strArr20 = {str66, str67, (String) objArr150[0]};
                    int i615 = -(-(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                    int i616 = 848 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                    int i617 = -(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                    Object[] objArr151 = new Object[1];
                    a((char) (((i615 | 41880) << 1) - (i615 ^ 41880)), i616, (i617 & 14) + (i617 | 14), objArr151);
                    String str68 = (String) objArr151[0];
                    int i618 = -(-TextUtils.lastIndexOf(str3, '0', 0, 0));
                    int windowTouchSlop4 = (ViewConfiguration.getWindowTouchSlop() >> 8) + 861;
                    int i619 = -TextUtils.indexOf(str3, str3, 0);
                    int i620 = (i619 & 1) + (i619 | 1);
                    Object[] objArr152 = new Object[1];
                    a((char) ((i618 & 1) + (i618 | 1)), windowTouchSlop4, i620, objArr152);
                    String[] strArr21 = {str68, (String) objArr152[0]};
                    Object[] objArr153 = new Object[1];
                    a((char) (ViewConfiguration.getKeyRepeatTimeout() >> 16), 861 - (~View.resolveSize(0, 0)), 8 - (~(-(-TextUtils.indexOf(str3, str3)))), objArr153);
                    String str69 = (String) objArr153[0];
                    int i621 = -TextUtils.lastIndexOf(str3, '0', 0, 0);
                    int i622 = -(-Color.rgb(0, 0, 0));
                    int i623 = (i622 ^ 16778087) + ((i622 & 16778087) << 1);
                    int i624 = -(TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                    int i625 = (i624 & 1) + (i624 | 1);
                    Object[] objArr154 = new Object[1];
                    a((char) ((i621 ^ 41675) + ((i621 & 41675) << 1)), i623, i625, objArr154);
                    String[] strArr22 = {str69, (String) objArr154[0]};
                    char offsetAfter8 = (char) TextUtils.getOffsetAfter(str3, 0);
                    int i626 = 871 - (~(-(PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))));
                    int i627 = -((byte) KeyEvent.getModifierMetaStateMask());
                    Object[] objArr155 = new Object[1];
                    a(offsetAfter8, i626, (i627 & 15) + (i627 | 15), objArr155);
                    String str70 = (String) objArr155[0];
                    char cResolveSize4 = (char) View.resolveSize(0, 0);
                    int i628 = -(-TextUtils.lastIndexOf(str3, '0'));
                    Object[] objArr156 = new Object[1];
                    a(cResolveSize4, (i628 & 715) + (i628 | 715), 3 - Color.argb(0, 0, 0, 0), objArr156);
                    String str71 = (String) objArr156[0];
                    int i629 = -(ViewConfiguration.getTouchSlop() >> 8);
                    int iIndexOf11 = TextUtils.indexOf((CharSequence) str3, '0', 0, 0);
                    int i630 = ((iIndexOf11 | 660) << 1) - (iIndexOf11 ^ 660);
                    int i631 = -(ViewConfiguration.getScrollBarSize() >> 8);
                    int i632 = ((i631 | 7) << 1) - (i631 ^ 7);
                    Object[] objArr157 = new Object[1];
                    a((char) ((i629 & 47321) + (i629 | 47321)), i630, i632, objArr157);
                    String str72 = (String) objArr157[0];
                    int i633 = -(-(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)));
                    Object[] objArr158 = new Object[1];
                    a((char) ((i633 & 51444) + (i633 | 51444)), 887 - (~(-TextUtils.getOffsetAfter(str3, 0))), 7 - (~(-(KeyEvent.getMaxKeyCode() >> 16))), objArr158);
                    String str73 = (String) objArr158[0];
                    int i634 = -Color.red(0);
                    int i635 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                    Object[] objArr159 = new Object[1];
                    a((char) (((i634 | 12492) << 1) - (i634 ^ 12492)), ((i635 | 672) << 1) - (i635 ^ 672), Color.rgb(0, 0, 0) + 16777227, objArr159);
                    String str74 = (String) objArr159[0];
                    char gidForName2 = (char) (22482 - Process.getGidForName(str3));
                    int i636 = 683 - (~(-TextUtils.indexOf(str3, str3, 0, 0)));
                    int i637 = -TextUtils.getTrimmedLength(str3);
                    int i638 = ((i637 | 14) << 1) - (i637 ^ 14);
                    Object[] objArr160 = new Object[1];
                    a(gidForName2, i636, i638, objArr160);
                    String[] strArr23 = {str70, str71, str72, str73, str74, (String) objArr160[0]};
                    int i639 = -(-TextUtils.lastIndexOf(str3, '0', 0, 0));
                    int fadingEdgeLength4 = ViewConfiguration.getFadingEdgeLength() >> 16;
                    int i640 = ((fadingEdgeLength4 | 896) << 1) - (fadingEdgeLength4 ^ 896);
                    int i641 = -(-(Process.myPid() >> 22));
                    int i642 = ((i641 | 20) << 1) - (i641 ^ 20);
                    Object[] objArr161 = new Object[1];
                    a((char) (((i639 | 47303) << 1) - (i639 ^ 47303)), i640, i642, objArr161);
                    String str75 = (String) objArr161[0];
                    char mirror6 = AndroidCharacter.getMirror('0');
                    char c40 = (char) ((mirror6 ^ 35867) + ((35867 & mirror6) << 1));
                    int windowTouchSlop5 = ViewConfiguration.getWindowTouchSlop() >> 8;
                    int i643 = ((windowTouchSlop5 | 916) << 1) - (windowTouchSlop5 ^ 916);
                    int i644 = -(Process.myPid() >> 22);
                    int i645 = ((i644 | 19) << 1) - (i644 ^ 19);
                    Object[] objArr162 = new Object[1];
                    a(c40, i643, i645, objArr162);
                    String str76 = (String) objArr162[0];
                    int i646 = -TextUtils.indexOf((CharSequence) str3, '0');
                    int gidForName3 = 934 - Process.getGidForName(str3);
                    int jumpTapTimeout5 = ViewConfiguration.getJumpTapTimeout() >> 16;
                    int i647 = (jumpTapTimeout5 ^ 31) + ((jumpTapTimeout5 & 31) << 1);
                    Object[] objArr163 = new Object[1];
                    a((char) ((i646 ^ (-1)) + (i646 << 1)), gidForName3, i647, objArr163);
                    String str77 = (String) objArr163[0];
                    char size3 = (char) View.MeasureSpec.getSize(0);
                    int iResolveOpacity5 = Drawable.resolveOpacity(0, 0) + 966;
                    int threadPriority5 = (Process.getThreadPriority(0) + 20) >> 6;
                    int i648 = (threadPriority5 ^ 26) + ((threadPriority5 & 26) << 1);
                    Object[] objArr164 = new Object[1];
                    a(size3, iResolveOpacity5, i648, objArr164);
                    String str78 = (String) objArr164[0];
                    char cAlpha = (char) (13906 - Color.alpha(0));
                    int scrollBarFadeDuration3 = ViewConfiguration.getScrollBarFadeDuration() >> 16;
                    Object[] objArr165 = new Object[1];
                    a(cAlpha, (scrollBarFadeDuration3 & 992) + (scrollBarFadeDuration3 | 992), 22 - (~(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), objArr165);
                    String str79 = (String) objArr165[0];
                    char capsMode2 = (char) TextUtils.getCapsMode(str3, 0, 0);
                    int threadPriority6 = Process.getThreadPriority(0);
                    int i649 = -((((threadPriority6 | 20) << 1) - (threadPriority6 ^ 20)) >> 6);
                    int i650 = i649 * 491;
                    int i651 = (i650 ^ (-496335)) + ((i650 & (-496335)) << 1);
                    int i652 = ~i649;
                    int i653 = (i652 ^ (-1016)) | (i652 & (-1016));
                    int i654 = (i651 - (~(-(-(((i653 & i4) | (i653 ^ i4)) * (-490)))))) - 1;
                    int i655 = ~((i649 & (-1016)) | ((-1016) ^ i649));
                    int i656 = ~(((-1016) & i) | ((-1016) ^ i));
                    int i657 = ((i655 & i656) | (i655 ^ i656)) * 490;
                    int i658 = (i654 ^ i657) + ((i654 & i657) << 1) + (i652 * 490);
                    int threadPriority7 = Process.getThreadPriority(0);
                    int i659 = -(-(((threadPriority7 ^ 20) + ((threadPriority7 & 20) << 1)) >> 6));
                    int i660 = (i659 ^ 33) + ((i659 & 33) << 1);
                    Object[] objArr166 = new Object[1];
                    a(capsMode2, i658, i660, objArr166);
                    str4 = str3;
                    String[] strArr24 = {str75, str76, str77, str78, str79, (String) objArr166[0], str};
                    int i661 = -(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                    int i662 = -AndroidCharacter.getMirror('0');
                    int i663 = ~i662;
                    int i664 = (((i662 * 221) - 240024) - (~(-(-(((~((i663 & (-1097)) | (i663 ^ (-1097)))) | (~(((i16 ^ i662) | (i16 & i662)) | 1096))) * 220))))) - 1;
                    int i665 = ((~((i16 ^ 1096) | (i16 & 1096))) | i662) * (-440);
                    int i666 = (i664 & i665) + (i664 | i665);
                    int i667 = ((i662 & 1096) | (i662 ^ 1096) | i) * 220;
                    int i668 = -(-KeyEvent.getDeadChar(0, 0));
                    Object[] objArr167 = new Object[1];
                    a((char) ((i661 & 1) + (i661 | 1)), (i666 & i667) + (i667 | i666), (i668 & 13) + (i668 | 13), objArr167);
                    String str80 = (String) objArr167[0];
                    char c41 = (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                    int i669 = -TextUtils.getCapsMode(str4, 0, 0);
                    int iIPostMessageService15 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                    int i670 = i669 * (-55);
                    int i671 = (i670 ^ (-34485)) + ((i670 & (-34485)) << 1);
                    int i672 = ~((i669 ^ iIPostMessageService15) | (i669 & iIPostMessageService15));
                    int i673 = -(-(((i672 & 627) | (i672 ^ 627)) * 56));
                    int i674 = ((((i671 | i673) << 1) - (i673 ^ i671)) - (~(-(-((~(i669 | 627)) * (-56)))))) - 1;
                    int i675 = ~((~iIPostMessageService15) | 627);
                    Object[] objArr168 = new Object[1];
                    a(c41, i674 + (((i669 & i675) | (i669 ^ i675)) * 56), 8 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), objArr168);
                    String[] strArr25 = {str80, (String) objArr168[0]};
                    char c42 = (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1);
                    int i676 = 1060 - (~(-KeyEvent.normalizeMetaState(0)));
                    int iRed2 = Color.red(0);
                    int i677 = (iRed2 ^ 30) + ((iRed2 & 30) << 1);
                    Object[] objArr169 = new Object[1];
                    a(c42, i676, i677, objArr169);
                    String str81 = (String) objArr169[0];
                    Object[] objArr170 = new Object[1];
                    a((char) (51770 - (~ExpandableListView.getPackedPositionChild(0L))), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 1090, 12 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), objArr170);
                    String[] strArr26 = {str81, (String) objArr170[0]};
                    Object[] objArr171 = new Object[1];
                    a((char) (ViewConfiguration.getMinimumFlingVelocity() >> 16), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 1102, 18 - (~(-TextUtils.getTrimmedLength(str4))), objArr171);
                    String str82 = (String) objArr171[0];
                    Object[] objArr172 = new Object[1];
                    a((char) ExpandableListView.getPackedPositionType(0L), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 1121, 4 - (~(-(-(ViewConfiguration.getMinimumFlingVelocity() >> 16)))), objArr172);
                    String[] strArr27 = {str82, (String) objArr172[0]};
                    int windowTouchSlop6 = ViewConfiguration.getWindowTouchSlop() >> 8;
                    int i678 = (windowTouchSlop6 * (-129)) + 2773663;
                    int i679 = ((-21174) & i16) | ((-21174) ^ i16);
                    int i680 = (~((i679 & windowTouchSlop6) | (i679 ^ windowTouchSlop6))) * 130;
                    int i681 = (((i678 ^ i680) + ((i678 & i680) << 1)) - (~((~(((-21174) & windowTouchSlop6) | ((-21174) ^ windowTouchSlop6))) * (-260)))) - 1;
                    int i682 = ~windowTouchSlop6;
                    int i683 = ~((i682 & 21173) | (i682 ^ 21173));
                    int i684 = (windowTouchSlop6 & (-21174)) | ((-21174) ^ windowTouchSlop6);
                    int i685 = ~((i684 & i) | (i684 ^ i));
                    char c43 = (char) (i681 + (((i685 & i683) | (i683 ^ i685)) * 130));
                    int i686 = -(ViewConfiguration.getJumpTapTimeout() >> 16);
                    int iRed3 = Color.red(0);
                    int i687 = (iRed3 & 19) + (iRed3 | 19);
                    Object[] objArr173 = new Object[1];
                    a(c43, ((i686 | 1126) << 1) - (i686 ^ 1126), i687, objArr173);
                    String[] strArr28 = {(String) objArr173[0]};
                    int i688 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                    int i689 = -(-(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                    Object[] objArr174 = new Object[1];
                    a((char) (((i688 | 11000) << 1) - (i688 ^ 11000)), (i689 ^ 1145) + ((i689 & 1145) << 1), 16 - (KeyEvent.getMaxKeyCode() >> 16), objArr174);
                    String[] strArr29 = {(String) objArr174[0]};
                    int i690 = -(-TextUtils.indexOf((CharSequence) str4, '0', 0, 0));
                    int i691 = 1159 - (~(-TextUtils.indexOf((CharSequence) str4, '0')));
                    int i692 = -(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                    int i693 = ((i692 | 20) << 1) - (i692 ^ 20);
                    Object[] objArr175 = new Object[1];
                    a((char) ((i690 ^ 45607) + ((i690 & 45607) << 1)), i691, i693, objArr175);
                    String[] strArr30 = {(String) objArr175[0]};
                    int iMyTid4 = Process.myTid() >> 22;
                    int windowTouchSlop7 = (ViewConfiguration.getWindowTouchSlop() >> 8) + 1180;
                    int i694 = -(-ExpandableListView.getPackedPositionType(0L));
                    Object[] objArr176 = new Object[1];
                    a((char) ((iMyTid4 ^ 28712) + ((iMyTid4 & 28712) << 1)), windowTouchSlop7, (i694 & 19) + (i694 | 19), objArr176);
                    String[] strArr31 = {(String) objArr176[0]};
                    char fadingEdgeLength5 = (char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 11236);
                    int i695 = -TextUtils.getCapsMode(str4, 0, 0);
                    Object[] objArr177 = new Object[1];
                    a(fadingEdgeLength5, ((i695 | 1199) << 1) - (i695 ^ 1199), 22 - (~(-(-(ViewConfiguration.getScrollBarFadeDuration() >> 16)))), objArr177);
                    String[] strArr32 = {(String) objArr177[0]};
                    char c44 = (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 33259);
                    int i696 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                    Object[] objArr178 = new Object[1];
                    a(c44, (i696 ^ 1221) + ((i696 & 1221) << 1), 20 - (~((Process.getThreadPriority(0) + 20) >> 6)), objArr178);
                    String[] strArr33 = {(String) objArr178[0]};
                    int i697 = -(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                    int i698 = -((Process.getThreadPriority(0) + 20) >> 6);
                    int i699 = ((i698 | 1243) << 1) - (i698 ^ 1243);
                    int i700 = -ExpandableListView.getPackedPositionGroup(0L);
                    int i701 = (i700 & 24) + (i700 | 24);
                    Object[] objArr179 = new Object[1];
                    a((char) ((i697 & 4330) + (i697 | 4330)), i699, i701, objArr179);
                    String str83 = str;
                    String[] strArr34 = {(String) objArr179[0], str83};
                    int i702 = -(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                    int maximumDrawingCacheSize = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 1267;
                    int offsetAfter9 = TextUtils.getOffsetAfter(str4, 0);
                    Object[] objArr180 = new Object[1];
                    a((char) (((i702 | 52225) << 1) - (i702 ^ 52225)), maximumDrawingCacheSize, (offsetAfter9 & 28) + (offsetAfter9 | 28), objArr180);
                    String[] strArr35 = {(String) objArr180[0], str83};
                    int i703 = -(-TextUtils.lastIndexOf(str4, '0', 0));
                    int i704 = -(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                    Object[] objArr181 = new Object[1];
                    a((char) ((i703 & 28836) + (i703 | 28836)), (i704 ^ 1295) + ((i704 & 1295) << 1), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 26, objArr181);
                    String[] strArr36 = {(String) objArr181[0], str83};
                    int i705 = -(-Color.rgb(0, 0, 0));
                    int i706 = 1321 - (~(-(ViewConfiguration.getMaximumDrawingCacheSize() >> 24)));
                    int i707 = -(-(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                    Object[] objArr182 = new Object[1];
                    a((char) ((i705 ^ 16777216) + ((i705 & 16777216) << 1)), i706, (i707 & 32) + (i707 | 32), objArr182);
                    String[] strArr37 = {(String) objArr182[0], str83};
                    int iIndexOf12 = TextUtils.indexOf((CharSequence) str4, '0', 0, 0);
                    char c45 = (char) ((iIndexOf12 & 28216) + (iIndexOf12 | 28216));
                    int gidForName4 = 1352 - Process.getGidForName(str4);
                    int i708 = -ExpandableListView.getPackedPositionType(0L);
                    int i709 = (i708 ^ 27) + ((i708 & 27) << 1);
                    Object[] objArr183 = new Object[1];
                    a(c45, gidForName4, i709, objArr183);
                    String[] strArr38 = {(String) objArr183[0], str83};
                    int i710 = -(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                    int i711 = 1380 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                    int i712 = -KeyEvent.keyCodeFromString(str4);
                    int i713 = (i712 ^ 32) + ((i712 & 32) << 1);
                    Object[] objArr184 = new Object[1];
                    a((char) (((i710 | 10546) << 1) - (i710 ^ 10546)), i711, i713, objArr184);
                    String[][] strArr39 = {strArr16, strArr17, strArr18, strArr19, strArr20, strArr21, strArr22, strArr23, strArr24, strArr25, strArr26, strArr27, strArr28, strArr29, strArr30, strArr31, strArr32, strArr33, strArr34, strArr35, strArr36, strArr37, strArr38, new String[]{(String) objArr184[0], str83}};
                    ArrayList arrayList = new ArrayList();
                    int i714 = i;
                    int i715 = 0;
                    int i716 = 0;
                    while (i715 < 24) {
                        String[] strArr40 = strArr39[i715];
                        Object[] objArr185 = {strArr40[0]};
                        Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                        if (objAccessartificialFrame22 == null) {
                            int iAxisFromString2 = 22 - MotionEvent.axisFromString(str4);
                            char c46 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                            int iGreen2 = 2441 - Color.green(0);
                            byte[] bArr20 = $$a;
                            Object[] objArr186 = new Object[1];
                            b((byte) (bArr20[3] + 1), bArr20[20], bArr20[15], objArr186);
                            objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(iAxisFromString2, c46, iGreen2, 954751276, false, (String) objArr186[0], new Class[]{String.class});
                        }
                        String str84 = (String) ((Method) objAccessartificialFrame22).invoke(null, objArr185);
                        String[] strArr41 = (String[]) Arrays.copyOfRange(strArr40, 1, strArr40.length);
                        if (str84 != null) {
                            int i717 = artificialFrame;
                            int i718 = (i717 & 73) + (i717 | 73);
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i718 % 128;
                            if (i718 % 2 != 0) {
                                str84.length();
                                Object obj2 = null;
                                obj2.hashCode();
                                throw null;
                            }
                            if (str84.length() != 0) {
                                boolean z = true;
                                if (strArr40.length == 1) {
                                    int i719 = ((i716 | 1) << 1) - (i716 ^ 1);
                                    int i720 = i715 + 10;
                                    i714 = (~(i & i720)) & (i720 | i);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(str84);
                                    Object[] objArr187 = new Object[1];
                                    a((char) (TextUtils.indexOf(str4, str4) + TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO), ((Process.getThreadPriority(0) + 20) >> 6) + 1412, 0 - (~Color.blue(0)), objArr187);
                                    sb.append((String) objArr187[0]);
                                    sb.append(str84);
                                    arrayList.add(sb.toString());
                                    i716 = i719;
                                    break;
                                    break;
                                }
                                int length2 = strArr41.length;
                                int i721 = 0;
                                while (i721 < length2) {
                                    if (str84.contains(strArr41[i721]) == z) {
                                        int i7110 = ((i716 | 1) << 1) - (i716 ^ 1);
                                        int i722 = i715 + 10;
                                        i714 = (~(i & i722)) & (i722 | i);
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append(str84);
                                        Object[] objArr188 = new Object[1];
                                        a((char) (TextUtils.indexOf(str4, str4) + TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO), ((Process.getThreadPriority(0) + 20) >> 6) + 1412, 0 - (~Color.blue(0)), objArr188);
                                        sb2.append((String) objArr188[0]);
                                        sb2.append(str84);
                                        arrayList.add(sb2.toString());
                                        i716 = i7110;
                                        break;
                                    }
                                    i721 = (i721 | 1) + (i721 & 1);
                                    z = true;
                                }
                            }
                        }
                        int i723 = (i715 & (-70)) + (i715 | (-70));
                        i715 = (i723 & 71) + (i723 | 71);
                        strArr39 = strArr39;
                        j81 = j81;
                    }
                    j = j81;
                    if (i716 > 2) {
                        objArr = new Object[]{arrayList, new int[1], null, new int[]{i}, new int[]{i714}};
                        int iMyTid5 = Process.myTid();
                        int i724 = 590095313 + (((-328570614) | iMyTid5) * 376) + (((~((~iMyTid5) | 433388922)) | (-467009536)) * (-376)) + (((~(iMyTid5 | (-433388923))) | 172059535) * 376);
                        int i725 = (i724 << 13) ^ i724;
                        int i726 = i725 >>> 17;
                        int i727 = ((~i725) & i726) | ((~i726) & i725);
                        int i728 = i727 << 5;
                        int i729 = ((~i727) & i728) | ((~i728) & i727);
                        i18 = 1;
                        c3 = 0;
                        ((int[]) objArr[1])[0] = i729;
                    } else {
                        objArr = new Object[]{null, new int[1], null, new int[]{i}, new int[]{i}};
                        int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
                        int i730 = ~iElapsedRealtime;
                        int i731 = 1149684354 + ((~(447747196 | i730)) * 979) + ((iElapsedRealtime | 1053195654) * (-979)) + (((~(iElapsedRealtime | 447747196)) | (~(i730 | 1053195654))) * 979);
                        int i732 = i731 << 13;
                        int i733 = (i732 | i731) & (~(i731 & i732));
                        int i734 = i733 >>> 17;
                        int i735 = ((~i733) & i734) | ((~i734) & i733);
                        int i736 = i735 << 5;
                        int i737 = ((~i735) & i736) | ((~i736) & i735);
                        i18 = 1;
                        c3 = 0;
                        ((int[]) objArr[1])[0] = i737;
                    }
                    int i738 = ((int[]) objArr[4])[c3];
                    if (i738 != i) {
                        objArr2 = new Object[5];
                        int[] iArr5 = new int[i18];
                        objArr2[i18] = iArr5;
                        int[] iArr6 = new int[i18];
                        objArr2[3] = iArr6;
                        int[] iArr7 = new int[i18];
                        objArr2[4] = iArr7;
                        List list = (List) objArr[c3];
                        iArr6[c3] = i;
                        iArr7[c3] = i738;
                        objArr2[c3] = list;
                        objArr2[2] = null;
                        int i739 = 1225908861 + (((~((-314604806) | i16)) | 920053263) * (-328)) + ((i | 920053263) * 164) + (((~(i16 | (-6401))) | (~(i | 314604805)) | 605454858) * 164) + 16;
                        int i740 = (i3 & i739) + (i3 | i739);
                        int i741 = i740 ^ (i740 << 13);
                        int i742 = i741 ^ (i741 >>> 17);
                        int i743 = i742 << 5;
                        iArr5[0] = (i742 | i743) & (~(i742 & i743));
                    } else {
                        c4 = '0';
                        char c112 = (char) (47 - (~(-AndroidCharacter.getMirror(c4))));
                        int i3210 = -(-(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                        int i3211 = (i3210 ^ 697) + ((i3210 & 697) << 1);
                        int pressedStateDuration2 = ViewConfiguration.getPressedStateDuration() >> 16;
                        int i3212 = ((pressedStateDuration2 | 16) << 1) - (pressedStateDuration2 ^ 16);
                        Object[] objArr820 = new Object[1];
                        a(c112, i3211, i3212, objArr820);
                        Object[] objArr821 = {(String) objArr820[0]};
                        objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1483923676);
                        if (objAccessartificialFrame == null) {
                            int offsetBefore5 = TextUtils.getOffsetBefore(str4, 0) + 23;
                            char c113 = (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                            int i3213 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 2440;
                            byte[] bArr112 = $$a;
                            Object[] objArr822 = new Object[1];
                            b((byte) (bArr112[3] + 1), bArr112[20], bArr112[15], objArr822);
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(offsetBefore5, c113, i3213, 954751276, false, (String) objArr822[0], new Class[]{String.class});
                        }
                        objInvoke = ((Method) objAccessartificialFrame).invoke(null, objArr821);
                        if (objInvoke == null) {
                            i23 = 0;
                        } else {
                            Object[] objArr823 = {objInvoke, 42};
                            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-287841710);
                            if (objAccessartificialFrame2 == null) {
                                int i3214 = 21 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                                char cResolveSize5 = (char) View.resolveSize(0, 0);
                                int absoluteGravity2 = Gravity.getAbsoluteGravity(0, 0) + 2245;
                                byte[] bArr113 = $$a;
                                byte b112 = bArr113[7];
                                byte b113 = bArr113[20];
                                Object[] objArr824 = new Object[1];
                                b(b112, b113, (byte) (b113 | Ascii.SO), objArr824);
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i3214, cResolveSize5, absoluteGravity2, 1907532890, false, (String) objArr824[0], new Class[]{String.class, Integer.TYPE});
                            }
                            long jLongValue19 = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr823)).longValue();
                            long j512 = -443645310;
                            long j513 = j37 ^ j;
                            long j514 = 521;
                            long j515 = j512 ^ j;
                            j2 = (((long) 522) * j512) + (((long) (-520)) * jLongValue19) + (((long) (-1042)) * (((j513 | jLongValue19) ^ j) | j512)) + ((jLongValue19 | j37) * j514) + (j514 * (((jLongValue19 | (j512 | j513)) ^ j) | ((j515 | (jLongValue19 ^ j)) ^ j) | ((j515 | j37) ^ j))) + ((long) 2076730638);
                            int i3215 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                            i19 = ((i3215 | 21) << 1) - (i3215 ^ 21);
                            artificialFrame = i19 % 128;
                            if (i19 % 2 == 0) {
                                int elapsedCpuTime6 = (int) Process.getElapsedCpuTime();
                                i20 = ((int) (j2 >> 60)) & (1520786966 + (((~((~elapsedCpuTime6) | 253845091)) | (-1336541032)) * 529) + (((~(elapsedCpuTime6 | 253845091)) | (-1183381320)) * 529));
                                i21 = (int) j2;
                                int iNextInt8 = new Random().nextInt(1112172730);
                                int i3216 = ~iNextInt8;
                                i22 = (-2040709086) + ((~(20756676 | i3216)) * 979) + (((-1416469734) | iNextInt8) * (-979)) + (((~(iNextInt8 | 20756676)) | (~(i3216 | (-1416469734)))) * 979);
                            } else {
                                i20 = ((int) (j2 >> 32)) & (1738041050 + (((~(1960686168 | i16)) | (-1979709437) | (~(897054716 | i16))) * (-1136)) + (((~(1960686168 | i)) | (~(897054716 | i)) | (~((-878031449) | i16))) * (-568)) + (((~((-1960686169) | i16)) | (~((-897054717) | i16)) | (~(1979709436 | i))) * 568));
                                i21 = (int) j2;
                                int iNextInt9 = new Random().nextInt();
                                int i3320 = (-254716221) + (((-1442471659) | iNextInt9) * 614);
                                int i3321 = ~iNextInt9;
                                i22 = i3320 + (((~((-170722466) | i3321)) | 168099841 | (~((-1607948876) | i3321))) * (-1228)) + (((~(i3321 | (-1439849035))) | (~((-2622625) | i3321))) * 614);
                            }
                            int i3322 = i21 & i22;
                            i23 = (i20 & i3322) | (i20 ^ i3322);
                        }
                        if (i23 != 1986687685) {
                            char mirror7 = AndroidCharacter.getMirror('0');
                            int iIPostMessageService16 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                            int i33114 = mirror7 * 765;
                            int i33115 = (i33114 ^ 73296) + ((i33114 & 73296) << 1);
                            int i33116 = ~iIPostMessageService16;
                            int i33117 = ~((i33116 ^ mirror7) | (i33116 & mirror7));
                            int i33118 = ((i33117 & (-48)) | (i33117 ^ (-48))) * 764;
                            int i33119 = ((i33115 | i33118) << 1) - (i33118 ^ i33115);
                            int i331110 = ~mirror7;
                            int i341110 = ~((i331110 & (-48)) | (i331110 ^ (-48)));
                            int i341111 = ~((i33116 & (-48)) | (i33116 ^ (-48)));
                            int i341112 = ((i341111 & i341110) | (i341110 ^ i341111)) * (-1528);
                            int i341113 = (i33119 & i341112) + (i341112 | i33119);
                            int i341114 = ~mirror7;
                            int i341115 = ~((i341114 & (-48)) | (i341114 ^ (-48)));
                            int i341116 = ~('/' | mirror7);
                            int i341117 = (i341115 & i341116) | (i341115 ^ i341116);
                            int i341118 = ~iIPostMessageService16;
                            int i341119 = ~((i341118 & mirror7) | (i341118 ^ mirror7));
                            int i351110 = ((i341119 & i341117) | (i341117 ^ i341119)) * 764;
                            char c114 = (char) (((i341113 | i351110) << 1) - (i351110 ^ i341113));
                            int iResolveOpacity6 = Drawable.resolveOpacity(0, 0);
                            Object[] objArr8110 = new Object[1];
                            a(c114, (iResolveOpacity6 ^ 1755) + ((iResolveOpacity6 & 1755) << 1), 11 - (~(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), objArr8110);
                            String str218 = (String) objArr8110[0];
                            int i351111 = -(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                            int iKeyCodeFromString5 = KeyEvent.keyCodeFromString(str4);
                            Object[] objArr8111 = new Object[1];
                            a((char) ((i351111 & 1) + (i351111 | 1)), ((iKeyCodeFromString5 | 1768) << 1) - (iKeyCodeFromString5 ^ 1768), 5 - Color.blue(0), objArr8111);
                            int i351112 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                            Object[] objArr8112 = new Object[1];
                            a((char) ((i351112 ^ (-1)) + (i351112 << 1)), 1773 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (ViewConfiguration.getTapTimeout() >> 16) + 15, objArr8112);
                            String str219 = (String) objArr8112[0];
                            char trimmedLength5 = (char) TextUtils.getTrimmedLength(str4);
                            int i351113 = -TextUtils.indexOf(str4, str4, 0);
                            int i351114 = (i351113 & 1788) + (i351113 | 1788);
                            int i351115 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                            int i351116 = ((i351115 | 18) << 1) - (i351115 ^ 18);
                            Object[] objArr8113 = new Object[1];
                            a(trimmedLength5, i351114, i351116, objArr8113);
                            String str2110 = (String) objArr8113[0];
                            char c2112 = (char) (56413 - (~(-TextUtils.lastIndexOf(str4, '0', 0))));
                            int i351117 = -(-(ViewConfiguration.getScrollDefaultDelay() >> 16));
                            Object[] objArr8114 = new Object[1];
                            a(c2112, ((i351117 | 1807) << 1) - (i351117 ^ 1807), 13 - (~(-(-TextUtils.indexOf(str4, str4)))), objArr8114);
                            int i351118 = -(-Color.rgb(0, 0, 0));
                            int i351119 = -TextUtils.lastIndexOf(str4, '0');
                            int i361110 = ((i351119 | 1820) << 1) - (i351119 ^ 1820);
                            int packedPositionChild5 = ExpandableListView.getPackedPositionChild(0L);
                            int i361111 = ((packedPositionChild5 | 22) << 1) - (packedPositionChild5 ^ 22);
                            Object[] objArr91110 = new Object[1];
                            a((char) ((i351118 & 16777216) + (i351118 | 16777216)), i361110, i361111, objArr91110);
                            String str2111 = (String) objArr91110[0];
                            char cMyPid4 = (char) (24327 - (Process.myPid() >> 22));
                            int i361112 = -(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                            int i361113 = -Color.rgb(0, 0, 0);
                            int i361114 = (i361113 ^ (-16777206)) + ((i361113 & (-16777206)) << 1);
                            Object[] objArr91111 = new Object[1];
                            a(cMyPid4, (i361112 ^ 1843) + ((i361112 & 1843) << 1), i361114, objArr91111);
                            char cResolveOpacity6 = (char) Drawable.resolveOpacity(0, 0);
                            Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                            int i361115 = -View.combineMeasuredStates(0, 0);
                            int i361116 = ((1852 | i361115) << 1) - (i361115 ^ 1852);
                            int i361117 = -(-(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                            int i361118 = (i361117 ^ 10) + ((i361117 & 10) << 1);
                            Object[] objArr91112 = new Object[1];
                            a(cResolveOpacity6, i361116, i361118, objArr91112);
                            int i361119 = -(ViewConfiguration.getLongPressTimeout() >> 16);
                            Object[] objArr91113 = new Object[1];
                            a((char) ((i361119 ^ 61549) + ((i361119 & 61549) << 1)), 587 - (~(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), (ViewConfiguration.getEdgeSlop() >> 16) + 6, objArr91113);
                            String[] strArr110 = {(String) objArr91112[0], (String) objArr91113[0]};
                            char cMakeMeasureSpec5 = (char) View.MeasureSpec.makeMeasureSpec(0, 0);
                            int i371110 = -MotionEvent.axisFromString(str4);
                            int i371111 = (i371110 & 1862) + (i371110 | 1862);
                            int offsetAfter10 = TextUtils.getOffsetAfter(str4, 0);
                            int iIPostMessageService17 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                            int i371112 = offsetAfter10 * 483;
                            int i371113 = (i371112 & 6776) + (i371112 | 6776);
                            int i371114 = ~offsetAfter10;
                            int i371115 = ~((i371114 ^ (-29)) | (i371114 & (-29)));
                            int i371116 = ~iIPostMessageService17;
                            int i371117 = ~((i371114 ^ i371116) | (i371114 & i371116));
                            int i371118 = -(-(((i371115 & i371117) | (i371115 ^ i371117)) * (-241)));
                            int i371119 = (((i371113 | i371118) << 1) - (i371113 ^ i371118)) + (((offsetAfter10 ^ 28) | (offsetAfter10 & 28)) * (-482));
                            int i381110 = ~((offsetAfter10 & (-29)) | ((-29) ^ offsetAfter10));
                            int i381111 = i371116 | i371114;
                            int i381112 = ~((i381111 & 28) | (i381111 ^ 28));
                            int i381113 = i371119 + (((i381112 & i381110) | (i381110 ^ i381112)) * 241);
                            Object[] objArr91114 = new Object[1];
                            a(cMakeMeasureSpec5, i371111, i381113, objArr91114);
                            String str316 = (String) objArr91114[0];
                            char c2113 = (char) (24327 - (~Process.getGidForName(str4)));
                            int i381114 = -(ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                            Object[] objArr91115 = new Object[1];
                            a(c2113, (i381114 ^ 1842) + ((i381114 & 1842) << 1), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 9, objArr91115);
                            c5 = 0;
                            strArr = new String[][]{new String[]{str218, (String) objArr8111[0]}, new String[]{str219, str2110, (String) objArr8114[0]}, new String[]{str2111, (String) objArr91111[0]}, strArr110, new String[]{str316, (String) objArr91115[0]}};
                            i24 = 0;
                            i25 = 5;
                            i26 = -1;
                            loop5: while (true) {
                                if (i24 >= i25) {
                                    i27 = i;
                                    break;
                                }
                                String[] strArr111 = strArr[i24];
                                str5 = strArr111[c5];
                                strArr2 = (String[]) Arrays.copyOfRange(strArr111, 1, strArr111.length);
                                length = strArr2.length;
                                i33 = 0;
                                while (i33 < length) {
                                    i34 = i26 + 1;
                                    Object[] objArr91116 = {str5, strArr2[i33]};
                                    objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-883653127);
                                    if (objAccessartificialFrame4 == null) {
                                        int iLastIndexOf11 = 30 - TextUtils.lastIndexOf(str4, '0', 0, 0);
                                        char c2114 = (char) (57023 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                                        int iMyTid6 = 2311 - (Process.myTid() >> 22);
                                        byte b114 = (byte) ($$b & 19);
                                        byte b115 = $$a[20];
                                        Object[] objArr91117 = new Object[1];
                                        b(b114, b115, (byte) (b115 + 5), objArr91117);
                                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iLastIndexOf11, c2114, iMyTid6, 1412547569, false, (String) objArr91117[0], new Class[]{String.class, String.class});
                                    }
                                    long jLongValue110 = ((Long) ((Method) objAccessartificialFrame4).invoke(null, objArr91116)).longValue();
                                    long j516 = -17848847;
                                    long j61110 = -754;
                                    long j61111 = j516 ^ j;
                                    long j61112 = j61111 | jLongValue110;
                                    i35 = length;
                                    long jUptimeMillis5 = (int) SystemClock.uptimeMillis();
                                    long j61113 = (((long) 755) * j516) + (((long) (-753)) * jLongValue110) + (((j61112 ^ j) | ((j61111 | jUptimeMillis5) ^ j) | ((jLongValue110 | jUptimeMillis5) ^ j)) * j61110);
                                    long j61114 = (j61112 | jUptimeMillis5) ^ j;
                                    long j61115 = jUptimeMillis5 ^ j;
                                    long j61116 = j61113 + (j61110 * (j61114 | ((jLongValue110 | (j516 | j61115)) ^ j))) + (((long) 754) * (j61111 | j61115)) + ((long) (-136902782));
                                    i36 = ((int) (j61116 >> 32)) & (78586646 + (((~(1125022391 | i)) | 608240904 | (~((-1732718494) | i))) * (-754)) + (((~((-608240905) | i)) | (~((-1124477590) | i16))) * (-754)) + ((1125022391 | i16) * 754));
                                    i37 = ((int) j61116) & ((((~(877330483 | i)) | 1980410402) * 56) + 1210426141 + ((877330483 | (~(1980410402 | i16))) * 56));
                                    if (((i36 & i37) | (i36 ^ i37)) != 0) {
                                        i27 = i ^ (i26 + 171);
                                        break loop5;
                                    }
                                    i33++;
                                    strArr = strArr;
                                    strArr2 = strArr2;
                                    str5 = str5;
                                    i26 = i34;
                                    length = i35;
                                }
                                i24++;
                                strArr = strArr;
                                i25 = 5;
                                c5 = 0;
                            }
                            if (i27 != i) {
                                objArr2 = new Object[]{null, new int[1], null, new int[]{i}, new int[]{i27}};
                                int i381115 = getARTIFICIAL_FRAME_PACKAGE_NAME + 113;
                                artificialFrame = i381115 % 128;
                                int i381116 = i381115 % 2;
                                int elapsedCpuTime7 = (int) Process.getElapsedCpuTime();
                                int i381117 = (-2030458348) + (((-306319490) | elapsedCpuTime7) * (-627)) + (((~((-229388135) | elapsedCpuTime7)) | 376060323) * (-627)) + (((~(elapsedCpuTime7 | 376060323)) | (~((~elapsedCpuTime7) | 229388134))) * 627);
                                int i381118 = (i381117 & 16) + (i381117 | 16);
                                int i381119 = (i3 ^ i381118) + ((i3 & i381118) << 1);
                                int i391110 = i381119 << 13;
                                int i391111 = (i391110 & (~i381119)) | ((~i391110) & i381119);
                                int i391112 = i391111 ^ (i391111 >>> 17);
                                int i391113 = artificialFrame + 101;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i391113 % 128;
                                int i391114 = i391113 % 2;
                                ((int[]) objArr2[1])[0] = i391112 ^ (i391112 << 5);
                            } else {
                                int i391115 = -View.MeasureSpec.getSize(0);
                                char c2115 = (char) ((i391115 ^ 22173) + ((i391115 & 22173) << 1));
                                int i391116 = 1890 - (~(-(-(ViewConfiguration.getEdgeSlop() >> 16))));
                                int i391117 = -TextUtils.lastIndexOf(str4, '0');
                                Object[] objArr91118 = new Object[1];
                                a(c2115, i391116, (i391117 & 12) + (i391117 | 12), objArr91118);
                                String str317 = (String) objArr91118[0];
                                int iResolveSize4 = View.resolveSize(0, 0);
                                char c2116 = (char) (((iResolveSize4 | 42082) << 1) - (42082 ^ iResolveSize4));
                                int minimumFlingVelocity7 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 1904;
                                int i391118 = -TextUtils.indexOf(str4, str4, 0);
                                int i391119 = (i391118 ^ 8) + ((i391118 & 8) << 1);
                                Object[] objArr91119 = new Object[1];
                                a(c2116, minimumFlingVelocity7, i391119, objArr91119);
                                String str318 = (String) objArr91119[0];
                                file = new File(str317);
                                if (file.exists()) {
                                    i28 = i;
                                } else {
                                    i28 = i;
                                }
                                if (i28 == i) {
                                    int iLastIndexOf12 = TextUtils.lastIndexOf(str4, '0', 0);
                                    int iIPostMessageService18 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                    int i40114 = ~iLastIndexOf12;
                                    int i40115 = ~iIPostMessageService18;
                                    int i40116 = ((iLastIndexOf12 * (-433)) - 1577448) + (((~((i40115 & i40114) | (i40114 ^ i40115))) | (~(((-7304) & iIPostMessageService18) | ((-7304) ^ iIPostMessageService18)))) * JfifUtil.MARKER_EOI);
                                    int i40117 = ~((i40114 & (-7304)) | (i40114 ^ (-7304)));
                                    int i40118 = ~iLastIndexOf12;
                                    int i40119 = ~((i40118 & iIPostMessageService18) | (i40118 ^ iIPostMessageService18));
                                    int i401110 = ((i40117 & i40119) | (i40117 ^ i40119)) * JfifUtil.MARKER_EOI;
                                    int i411110 = ~iIPostMessageService18;
                                    int i411111 = ~((i411110 & (-7304)) | ((-7304) ^ i411110));
                                    char c2117 = (char) ((((i40116 | i401110) << 1) - (i40116 ^ i401110)) + (((i411111 & iLastIndexOf12) | (iLastIndexOf12 ^ i411111)) * JfifUtil.MARKER_EOI));
                                    int i411112 = -View.resolveSize(0, 0);
                                    Object[] objArr10110 = new Object[1];
                                    a(c2117, (i411112 ^ 1912) + ((i411112 & 1912) << 1), TextUtils.getCapsMode(str4, 0, 0) + 47, objArr10110);
                                    Object[] objArr10111 = {(String) objArr10110[0]};
                                    objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(479197382);
                                    if (objAccessartificialFrame3 == null) {
                                        int jumpTapTimeout6 = (ViewConfiguration.getJumpTapTimeout() >> 16) + 17;
                                        char cLastIndexOf5 = (char) (24342 - TextUtils.lastIndexOf(str4, '0', 0, 0));
                                        int iResolveSizeAndState6 = View.resolveSizeAndState(0, 0, 0) + 2014;
                                        byte[] bArr114 = $$a;
                                        Object[] objArr10112 = new Object[1];
                                        b((byte) (-bArr114[c2]), bArr114[0], bArr114[13], objArr10112);
                                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout6, cLastIndexOf5, iResolveSizeAndState6, -2081767730, false, (String) objArr10112[0], new Class[]{String.class});
                                    }
                                    long jLongValue111 = ((Long) ((Method) objAccessartificialFrame3).invoke(null, objArr10111)).longValue();
                                    long j61117 = -270720422;
                                    long j61118 = j61117 ^ j;
                                    long j61119 = (((long) 236) * j61117) + (((long) 471) * jLongValue111) + (((long) (-235)) * ((((j37 ^ j) | j61118) ^ j) | jLongValue111)) + (((long) (-470)) * (((j61118 | j37) ^ j) | jLongValue111)) + (((long) 235) * ((((jLongValue111 | j61118) | j37) ^ j) | ((j61117 | (jLongValue111 ^ j)) ^ j))) + ((long) 767331813);
                                    int i411113 = ~(1740988638 | i);
                                    int i411114 = ((int) (j61119 >> 32)) & ((((-1977510894) | i411113) * (-658)) + 2084340718 + ((i411113 | (-2011130880)) * 658));
                                    int startElapsedRealtime5 = (int) Process.getStartElapsedRealtime();
                                    int i411115 = ~startElapsedRealtime5;
                                    int i411116 = ((int) j61119) & (802172634 + (((-570689025) | i411115) * (-369)) + (((~(839255688 | i411115)) | (-597970722)) * (-369)) + (((~(startElapsedRealtime5 | (-839255689))) | 268566664 | (~(i411115 | (-27281698)))) * 369));
                                    i29 = (((i411114 & i411116) | (i411114 ^ i411116)) * 263) ^ i;
                                    if (i29 != i) {
                                        Object[] objArr10113 = {null, new int[]{(i42112 | i42113) & (~(i42112 & i42113))}, null, new int[]{i}, new int[]{i29}};
                                        int i411117 = 1778863633 + ((1073216506 | i16) * SyslogConstants.LOG_LOCAL7) + (((~(1040667266 | i16)) | 670546938) * SyslogConstants.LOG_LOCAL7);
                                        int i411118 = i3 + (i411117 ^ 16) + ((i411117 & 16) << 1);
                                        int i411119 = i411118 << 13;
                                        int i421110 = ((~i411118) & i411119) | ((~i411119) & i411118);
                                        int i421111 = i421110 >>> 17;
                                        int i421112 = ((~i421110) & i421111) | ((~i421111) & i421110);
                                        int i421113 = i421112 << 5;
                                        return objArr10113;
                                    }
                                    Object[] objArr10114 = {null, new int[1], null, new int[]{i}, new int[]{i}};
                                    Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                    int iMyPid5 = Process.myPid();
                                    int i421114 = (((~(iMyPid5 | 712483870)) | (-107035413)) * 56) + 1596557073 + (((~((~iMyPid5) | (-107035413))) | 712483870) * 56);
                                    int i421115 = -(-((i421114 << 1) - i421114));
                                    i30 = (i3 ^ i421115) + ((i3 & i421115) << 1);
                                    i31 = getARTIFICIAL_FRAME_PACKAGE_NAME + 37;
                                    artificialFrame = i31 % 128;
                                    if (i31 % 2 == 0) {
                                        int i421116 = i30 % 13;
                                        int i421117 = (i421116 & (~i30)) | ((~i421116) & i30);
                                        int i421118 = i421117 >> 119;
                                        int i421119 = (i421117 | i421118) & (~(i421117 & i421118));
                                        i32 = i421119 ^ (i421119 * 2);
                                    } else {
                                        int i431110 = i30 << 13;
                                        int i431111 = (i431110 & (~i30)) | ((~i431110) & i30);
                                        int i431112 = i431111 >>> 17;
                                        int i431113 = ((~i431111) & i431112) | ((~i431112) & i431111);
                                        int i431114 = i431113 << 5;
                                        i32 = ((~i431113) & i431114) | ((~i431114) & i431113);
                                    }
                                    ((int[]) objArr10114[1])[0] = i32;
                                    return objArr10114;
                                }
                                objArr2 = new Object[]{null, new int[1], null, new int[]{i}, new int[]{i28}};
                                int iNextInt10 = new Random().nextInt(567550856);
                                int i431115 = ~iNextInt10;
                                int i431116 = 654520734 + (((~(i431115 | (-233448414))) | 233448216 | (~((-838896675) | iNextInt10))) * 717) + (((~(iNextInt10 | (-233448414))) | (~(i431115 | (-838896675))) | 233448216) * 717);
                                int i431117 = ((i431116 | 16) << 1) - (i431116 ^ 16);
                                int i431118 = ((i3 | i431117) << 1) - (i3 ^ i431117);
                                int i431119 = i431118 << 13;
                                int i4416 = (i431119 & (~i431118)) | ((~i431119) & i431118);
                                int i4417 = i4416 >>> 17;
                                int i4418 = (i4416 | i4417) & (~(i4416 & i4417));
                                ((int[]) objArr2[1])[0] = i4418 ^ (i4418 << 5);
                            }
                        } else {
                            char mirror8 = AndroidCharacter.getMirror('0');
                            int iIPostMessageService19 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                            int i331111 = mirror8 * 765;
                            int i331112 = (i331111 ^ 73296) + ((i331111 & 73296) << 1);
                            int i331113 = ~iIPostMessageService19;
                            int i331114 = ~((i331113 ^ mirror8) | (i331113 & mirror8));
                            int i331115 = ((i331114 & (-48)) | (i331114 ^ (-48))) * 764;
                            int i331116 = ((i331112 | i331115) << 1) - (i331115 ^ i331112);
                            int i331117 = ~mirror8;
                            int i3411110 = ~((i331117 & (-48)) | (i331117 ^ (-48)));
                            int i3411111 = ~((i331113 & (-48)) | (i331113 ^ (-48)));
                            int i3411112 = ((i3411111 & i3411110) | (i3411110 ^ i3411111)) * (-1528);
                            int i3411113 = (i331116 & i3411112) + (i3411112 | i331116);
                            int i3411114 = ~mirror8;
                            int i3411115 = ~((i3411114 & (-48)) | (i3411114 ^ (-48)));
                            int i3411116 = ~('/' | mirror8);
                            int i3411117 = (i3411115 & i3411116) | (i3411115 ^ i3411116);
                            int i3411118 = ~iIPostMessageService19;
                            int i3411119 = ~((i3411118 & mirror8) | (i3411118 ^ mirror8));
                            int i3511110 = ((i3411119 & i3411117) | (i3411117 ^ i3411119)) * 764;
                            char c115 = (char) (((i3411113 | i3511110) << 1) - (i3511110 ^ i3411113));
                            int iResolveOpacity7 = Drawable.resolveOpacity(0, 0);
                            Object[] objArr8115 = new Object[1];
                            a(c115, (iResolveOpacity7 ^ 1755) + ((iResolveOpacity7 & 1755) << 1), 11 - (~(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), objArr8115);
                            String str2112 = (String) objArr8115[0];
                            int i3511111 = -(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                            int iKeyCodeFromString6 = KeyEvent.keyCodeFromString(str4);
                            Object[] objArr8116 = new Object[1];
                            a((char) ((i3511111 & 1) + (i3511111 | 1)), ((iKeyCodeFromString6 | 1768) << 1) - (iKeyCodeFromString6 ^ 1768), 5 - Color.blue(0), objArr8116);
                            int i3511112 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                            Object[] objArr8117 = new Object[1];
                            a((char) ((i3511112 ^ (-1)) + (i3511112 << 1)), 1773 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (ViewConfiguration.getTapTimeout() >> 16) + 15, objArr8117);
                            String str2113 = (String) objArr8117[0];
                            char trimmedLength6 = (char) TextUtils.getTrimmedLength(str4);
                            int i3511113 = -TextUtils.indexOf(str4, str4, 0);
                            int i3511114 = (i3511113 & 1788) + (i3511113 | 1788);
                            int i3511115 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                            int i3511116 = ((i3511115 | 18) << 1) - (i3511115 ^ 18);
                            Object[] objArr8118 = new Object[1];
                            a(trimmedLength6, i3511114, i3511116, objArr8118);
                            String str2114 = (String) objArr8118[0];
                            char c2118 = (char) (56413 - (~(-TextUtils.lastIndexOf(str4, '0', 0))));
                            int i3511117 = -(-(ViewConfiguration.getScrollDefaultDelay() >> 16));
                            Object[] objArr8119 = new Object[1];
                            a(c2118, ((i3511117 | 1807) << 1) - (i3511117 ^ 1807), 13 - (~(-(-TextUtils.indexOf(str4, str4)))), objArr8119);
                            int i3511118 = -(-Color.rgb(0, 0, 0));
                            int i3511119 = -TextUtils.lastIndexOf(str4, '0');
                            int i3611110 = ((i3511119 | 1820) << 1) - (i3511119 ^ 1820);
                            int packedPositionChild6 = ExpandableListView.getPackedPositionChild(0L);
                            int i3611111 = ((packedPositionChild6 | 22) << 1) - (packedPositionChild6 ^ 22);
                            Object[] objArr911110 = new Object[1];
                            a((char) ((i3511118 & 16777216) + (i3511118 | 16777216)), i3611110, i3611111, objArr911110);
                            String str2115 = (String) objArr911110[0];
                            char cMyPid5 = (char) (24327 - (Process.myPid() >> 22));
                            int i3611112 = -(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                            int i3611113 = -Color.rgb(0, 0, 0);
                            int i3611114 = (i3611113 ^ (-16777206)) + ((i3611113 & (-16777206)) << 1);
                            Object[] objArr911111 = new Object[1];
                            a(cMyPid5, (i3611112 ^ 1843) + ((i3611112 & 1843) << 1), i3611114, objArr911111);
                            char cResolveOpacity7 = (char) Drawable.resolveOpacity(0, 0);
                            Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                            int i3611115 = -View.combineMeasuredStates(0, 0);
                            int i3611116 = ((1852 | i3611115) << 1) - (i3611115 ^ 1852);
                            int i3611117 = -(-(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                            int i3611118 = (i3611117 ^ 10) + ((i3611117 & 10) << 1);
                            Object[] objArr911112 = new Object[1];
                            a(cResolveOpacity7, i3611116, i3611118, objArr911112);
                            int i3611119 = -(ViewConfiguration.getLongPressTimeout() >> 16);
                            Object[] objArr911113 = new Object[1];
                            a((char) ((i3611119 ^ 61549) + ((i3611119 & 61549) << 1)), 587 - (~(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), (ViewConfiguration.getEdgeSlop() >> 16) + 6, objArr911113);
                            String[] strArr112 = {(String) objArr911112[0], (String) objArr911113[0]};
                            char cMakeMeasureSpec6 = (char) View.MeasureSpec.makeMeasureSpec(0, 0);
                            int i3711110 = -MotionEvent.axisFromString(str4);
                            int i3711111 = (i3711110 & 1862) + (i3711110 | 1862);
                            int offsetAfter11 = TextUtils.getOffsetAfter(str4, 0);
                            int iIPostMessageService110 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                            int i3711112 = offsetAfter11 * 483;
                            int i3711113 = (i3711112 & 6776) + (i3711112 | 6776);
                            int i3711114 = ~offsetAfter11;
                            int i3711115 = ~((i3711114 ^ (-29)) | (i3711114 & (-29)));
                            int i3711116 = ~iIPostMessageService110;
                            int i3711117 = ~((i3711114 ^ i3711116) | (i3711114 & i3711116));
                            int i3711118 = -(-(((i3711115 & i3711117) | (i3711115 ^ i3711117)) * (-241)));
                            int i3711119 = (((i3711113 | i3711118) << 1) - (i3711113 ^ i3711118)) + (((offsetAfter11 ^ 28) | (offsetAfter11 & 28)) * (-482));
                            int i3811110 = ~((offsetAfter11 & (-29)) | ((-29) ^ offsetAfter11));
                            int i3811111 = i3711116 | i3711114;
                            int i3811112 = ~((i3811111 & 28) | (i3811111 ^ 28));
                            int i3811113 = i3711119 + (((i3811112 & i3811110) | (i3811110 ^ i3811112)) * 241);
                            Object[] objArr911114 = new Object[1];
                            a(cMakeMeasureSpec6, i3711111, i3811113, objArr911114);
                            String str319 = (String) objArr911114[0];
                            char c2119 = (char) (24327 - (~Process.getGidForName(str4)));
                            int i3811114 = -(ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                            Object[] objArr911115 = new Object[1];
                            a(c2119, (i3811114 ^ 1842) + ((i3811114 & 1842) << 1), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 9, objArr911115);
                            c5 = 0;
                            strArr = new String[][]{new String[]{str2112, (String) objArr8116[0]}, new String[]{str2113, str2114, (String) objArr8119[0]}, new String[]{str2115, (String) objArr911111[0]}, strArr112, new String[]{str319, (String) objArr911115[0]}};
                            i24 = 0;
                            i25 = 5;
                            i26 = -1;
                            loop5: while (true) {
                                if (i24 >= i25) {
                                    i27 = i;
                                    break;
                                }
                                String[] strArr113 = strArr[i24];
                                str5 = strArr113[c5];
                                strArr2 = (String[]) Arrays.copyOfRange(strArr113, 1, strArr113.length);
                                length = strArr2.length;
                                i33 = 0;
                                while (i33 < length) {
                                    i34 = i26 + 1;
                                    Object[] objArr911116 = {str5, strArr2[i33]};
                                    objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-883653127);
                                    if (objAccessartificialFrame4 == null) {
                                        int iLastIndexOf13 = 30 - TextUtils.lastIndexOf(str4, '0', 0, 0);
                                        char c21110 = (char) (57023 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                                        int iMyTid7 = 2311 - (Process.myTid() >> 22);
                                        byte b116 = (byte) ($$b & 19);
                                        byte b117 = $$a[20];
                                        Object[] objArr911117 = new Object[1];
                                        b(b116, b117, (byte) (b117 + 5), objArr911117);
                                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iLastIndexOf13, c21110, iMyTid7, 1412547569, false, (String) objArr911117[0], new Class[]{String.class, String.class});
                                    }
                                    long jLongValue112 = ((Long) ((Method) objAccessartificialFrame4).invoke(null, objArr911116)).longValue();
                                    long j517 = -17848847;
                                    long j611110 = -754;
                                    long j611111 = j517 ^ j;
                                    long j611112 = j611111 | jLongValue112;
                                    i35 = length;
                                    long jUptimeMillis6 = (int) SystemClock.uptimeMillis();
                                    long j611113 = (((long) 755) * j517) + (((long) (-753)) * jLongValue112) + (((j611112 ^ j) | ((j611111 | jUptimeMillis6) ^ j) | ((jLongValue112 | jUptimeMillis6) ^ j)) * j611110);
                                    long j611114 = (j611112 | jUptimeMillis6) ^ j;
                                    long j611115 = jUptimeMillis6 ^ j;
                                    long j611116 = j611113 + (j611110 * (j611114 | ((jLongValue112 | (j517 | j611115)) ^ j))) + (((long) 754) * (j611111 | j611115)) + ((long) (-136902782));
                                    i36 = ((int) (j611116 >> 32)) & (78586646 + (((~(1125022391 | i)) | 608240904 | (~((-1732718494) | i))) * (-754)) + (((~((-608240905) | i)) | (~((-1124477590) | i16))) * (-754)) + ((1125022391 | i16) * 754));
                                    i37 = ((int) j611116) & ((((~(877330483 | i)) | 1980410402) * 56) + 1210426141 + ((877330483 | (~(1980410402 | i16))) * 56));
                                    if (((i36 & i37) | (i36 ^ i37)) != 0) {
                                        i27 = i ^ (i26 + 171);
                                        break loop5;
                                    }
                                    i33++;
                                    strArr = strArr;
                                    strArr2 = strArr2;
                                    str5 = str5;
                                    i26 = i34;
                                    length = i35;
                                }
                                i24++;
                                strArr = strArr;
                                i25 = 5;
                                c5 = 0;
                            }
                            if (i27 != i) {
                                objArr2 = new Object[]{null, new int[1], null, new int[]{i}, new int[]{i27}};
                                int i3811115 = getARTIFICIAL_FRAME_PACKAGE_NAME + 113;
                                artificialFrame = i3811115 % 128;
                                int i3811116 = i3811115 % 2;
                                int elapsedCpuTime8 = (int) Process.getElapsedCpuTime();
                                int i3811117 = (-2030458348) + (((-306319490) | elapsedCpuTime8) * (-627)) + (((~((-229388135) | elapsedCpuTime8)) | 376060323) * (-627)) + (((~(elapsedCpuTime8 | 376060323)) | (~((~elapsedCpuTime8) | 229388134))) * 627);
                                int i3811118 = (i3811117 & 16) + (i3811117 | 16);
                                int i3811119 = (i3 ^ i3811118) + ((i3 & i3811118) << 1);
                                int i3911110 = i3811119 << 13;
                                int i3911111 = (i3911110 & (~i3811119)) | ((~i3911110) & i3811119);
                                int i3911112 = i3911111 ^ (i3911111 >>> 17);
                                int i3911113 = artificialFrame + 101;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i3911113 % 128;
                                int i3911114 = i3911113 % 2;
                                ((int[]) objArr2[1])[0] = i3911112 ^ (i3911112 << 5);
                            } else {
                                int i3911115 = -View.MeasureSpec.getSize(0);
                                char c21111 = (char) ((i3911115 ^ 22173) + ((i3911115 & 22173) << 1));
                                int i3911116 = 1890 - (~(-(-(ViewConfiguration.getEdgeSlop() >> 16))));
                                int i3911117 = -TextUtils.lastIndexOf(str4, '0');
                                Object[] objArr911118 = new Object[1];
                                a(c21111, i3911116, (i3911117 & 12) + (i3911117 | 12), objArr911118);
                                String str3110 = (String) objArr911118[0];
                                int iResolveSize5 = View.resolveSize(0, 0);
                                char c21112 = (char) (((iResolveSize5 | 42082) << 1) - (42082 ^ iResolveSize5));
                                int minimumFlingVelocity8 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 1904;
                                int i3911118 = -TextUtils.indexOf(str4, str4, 0);
                                int i3911119 = (i3911118 ^ 8) + ((i3911118 & 8) << 1);
                                Object[] objArr911119 = new Object[1];
                                a(c21112, minimumFlingVelocity8, i3911119, objArr911119);
                                String str3111 = (String) objArr911119[0];
                                file = new File(str3110);
                                if (file.exists()) {
                                    i28 = i;
                                } else {
                                    i28 = i;
                                }
                                if (i28 == i) {
                                    int iLastIndexOf14 = TextUtils.lastIndexOf(str4, '0', 0);
                                    int iIPostMessageService111 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                    int i401111 = ~iLastIndexOf14;
                                    int i401112 = ~iIPostMessageService111;
                                    int i401113 = ((iLastIndexOf14 * (-433)) - 1577448) + (((~((i401112 & i401111) | (i401111 ^ i401112))) | (~(((-7304) & iIPostMessageService111) | ((-7304) ^ iIPostMessageService111)))) * JfifUtil.MARKER_EOI);
                                    int i401114 = ~((i401111 & (-7304)) | (i401111 ^ (-7304)));
                                    int i401115 = ~iLastIndexOf14;
                                    int i401116 = ~((i401115 & iIPostMessageService111) | (i401115 ^ iIPostMessageService111));
                                    int i401117 = ((i401114 & i401116) | (i401114 ^ i401116)) * JfifUtil.MARKER_EOI;
                                    int i4111110 = ~iIPostMessageService111;
                                    int i4111111 = ~((i4111110 & (-7304)) | ((-7304) ^ i4111110));
                                    char c21113 = (char) ((((i401113 | i401117) << 1) - (i401113 ^ i401117)) + (((i4111111 & iLastIndexOf14) | (iLastIndexOf14 ^ i4111111)) * JfifUtil.MARKER_EOI));
                                    int i4111112 = -View.resolveSize(0, 0);
                                    Object[] objArr10115 = new Object[1];
                                    a(c21113, (i4111112 ^ 1912) + ((i4111112 & 1912) << 1), TextUtils.getCapsMode(str4, 0, 0) + 47, objArr10115);
                                    Object[] objArr10116 = {(String) objArr10115[0]};
                                    objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(479197382);
                                    if (objAccessartificialFrame3 == null) {
                                        int jumpTapTimeout7 = (ViewConfiguration.getJumpTapTimeout() >> 16) + 17;
                                        char cLastIndexOf6 = (char) (24342 - TextUtils.lastIndexOf(str4, '0', 0, 0));
                                        int iResolveSizeAndState7 = View.resolveSizeAndState(0, 0, 0) + 2014;
                                        byte[] bArr115 = $$a;
                                        Object[] objArr10117 = new Object[1];
                                        b((byte) (-bArr115[c2]), bArr115[0], bArr115[13], objArr10117);
                                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout7, cLastIndexOf6, iResolveSizeAndState7, -2081767730, false, (String) objArr10117[0], new Class[]{String.class});
                                    }
                                    long jLongValue113 = ((Long) ((Method) objAccessartificialFrame3).invoke(null, objArr10116)).longValue();
                                    long j611117 = -270720422;
                                    long j611118 = j611117 ^ j;
                                    long j611119 = (((long) 236) * j611117) + (((long) 471) * jLongValue113) + (((long) (-235)) * ((((j37 ^ j) | j611118) ^ j) | jLongValue113)) + (((long) (-470)) * (((j611118 | j37) ^ j) | jLongValue113)) + (((long) 235) * ((((jLongValue113 | j611118) | j37) ^ j) | ((j611117 | (jLongValue113 ^ j)) ^ j))) + ((long) 767331813);
                                    int i4111113 = ~(1740988638 | i);
                                    int i4111114 = ((int) (j611119 >> 32)) & ((((-1977510894) | i4111113) * (-658)) + 2084340718 + ((i4111113 | (-2011130880)) * 658));
                                    int startElapsedRealtime6 = (int) Process.getStartElapsedRealtime();
                                    int i4111115 = ~startElapsedRealtime6;
                                    int i4111116 = ((int) j611119) & (802172634 + (((-570689025) | i4111115) * (-369)) + (((~(839255688 | i4111115)) | (-597970722)) * (-369)) + (((~(startElapsedRealtime6 | (-839255689))) | 268566664 | (~(i4111115 | (-27281698)))) * 369));
                                    i29 = (((i4111114 & i4111116) | (i4111114 ^ i4111116)) * 263) ^ i;
                                    if (i29 != i) {
                                        Object[] objArr10118 = {null, new int[]{(i421112 | i421113) & (~(i421112 & i421113))}, null, new int[]{i}, new int[]{i29}};
                                        int i4111117 = 1778863633 + ((1073216506 | i16) * SyslogConstants.LOG_LOCAL7) + (((~(1040667266 | i16)) | 670546938) * SyslogConstants.LOG_LOCAL7);
                                        int i4111118 = i3 + (i4111117 ^ 16) + ((i4111117 & 16) << 1);
                                        int i4111119 = i4111118 << 13;
                                        int i4211110 = ((~i4111118) & i4111119) | ((~i4111119) & i4111118);
                                        int i4211111 = i4211110 >>> 17;
                                        int i4211112 = ((~i4211110) & i4211111) | ((~i4211111) & i4211110);
                                        int i4211113 = i4211112 << 5;
                                        return objArr10118;
                                    }
                                    Object[] objArr10119 = {null, new int[1], null, new int[]{i}, new int[]{i}};
                                    Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                    int iMyPid6 = Process.myPid();
                                    int i4211114 = (((~(iMyPid6 | 712483870)) | (-107035413)) * 56) + 1596557073 + (((~((~iMyPid6) | (-107035413))) | 712483870) * 56);
                                    int i4211115 = -(-((i4211114 << 1) - i4211114));
                                    i30 = (i3 ^ i4211115) + ((i3 & i4211115) << 1);
                                    i31 = getARTIFICIAL_FRAME_PACKAGE_NAME + 37;
                                    artificialFrame = i31 % 128;
                                    if (i31 % 2 == 0) {
                                        int i4211116 = i30 % 13;
                                        int i4211117 = (i4211116 & (~i30)) | ((~i4211116) & i30);
                                        int i4211118 = i4211117 >> 119;
                                        int i4211119 = (i4211117 | i4211118) & (~(i4211117 & i4211118));
                                        i32 = i4211119 ^ (i4211119 * 2);
                                    } else {
                                        int i4311110 = i30 << 13;
                                        int i4311111 = (i4311110 & (~i30)) | ((~i4311110) & i30);
                                        int i4311112 = i4311111 >>> 17;
                                        int i4311113 = ((~i4311111) & i4311112) | ((~i4311112) & i4311111);
                                        int i4311114 = i4311113 << 5;
                                        i32 = ((~i4311113) & i4311114) | ((~i4311114) & i4311113);
                                    }
                                    ((int[]) objArr10119[1])[0] = i32;
                                    return objArr10119;
                                }
                                objArr2 = new Object[]{null, new int[1], null, new int[]{i}, new int[]{i28}};
                                int iNextInt11 = new Random().nextInt(567550856);
                                int i4311115 = ~iNextInt11;
                                int i4311116 = 654520734 + (((~(i4311115 | (-233448414))) | 233448216 | (~((-838896675) | iNextInt11))) * 717) + (((~(iNextInt11 | (-233448414))) | (~(i4311115 | (-838896675))) | 233448216) * 717);
                                int i4311117 = ((i4311116 | 16) << 1) - (i4311116 ^ 16);
                                int i4311118 = ((i3 | i4311117) << 1) - (i3 ^ i4311117);
                                int i4311119 = i4311118 << 13;
                                int i4419 = (i4311119 & (~i4311118)) | ((~i4311119) & i4311118);
                                int i44110 = i4419 >>> 17;
                                int i44111 = (i4419 | i44110) & (~(i4419 & i44110));
                                ((int[]) objArr2[1])[0] = i44111 ^ (i44111 << 5);
                            }
                        }
                    }
                }
                return objArr2;
            }
            objArr3 = new Object[]{null, new int[]{i ^ (i << 5)}, null, new int[]{i}, new int[]{i13}};
            int i744 = (~(344873786 | i134)) | (-1018093439) | (~(950322244 | i134));
            int i745 = 943968855 + (((~(i | (-277102593))) | i744) * 590) + (i744 * (-1180)) + (((~((-950322245) | i134)) | (~((-344873787) | i134))) * 590);
            int i746 = i3 + (i745 ^ 16) + ((i745 & 16) << 1);
            int i747 = i746 << 13;
            int i748 = ((~i746) & i747) | ((~i747) & i746);
            int i749 = i748 >>> 17;
            int i750 = (i748 | i749) & (~(i748 & i749));
        }
        return objArr3;
    }
}
