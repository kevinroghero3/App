package org.simpleframework.xml.transform;

import android.graphics.Color;
import android.media.AudioTrack;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import o.ArtificialStackFrames;
import o._CREATION;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes6.dex */
enum DateType {
    FULL("yyyy-MM-dd HH:mm:ss.S z"),
    LONG("yyyy-MM-dd HH:mm:ss z"),
    NORMAL("yyyy-MM-dd z"),
    SHORT("yyyy-MM-dd");

    private DateFormat format;

    DateType(String str) {
        this.format = new DateFormat(str);
    }

    private DateFormat getFormat() {
        return this.format;
    }

    public static String getText(Date date) throws Exception {
        return FULL.getFormat().getText(date);
    }

    public static class DateFormat {
        private static long _BOUNDARY;
        private static char[] _CREATION;
        private SimpleDateFormat format;
        private static final byte[] $$c = {5, Ascii.FF, -27, -23};
        private static final int $$d = 85;
        private static int $10 = 0;
        private static int $11 = 1;
        private static final byte[] $$a = {33, -82, -25, 84, -53, 47, Ascii.VT, 17, -5, Ascii.SYN, 1, -3, -12, Ascii.VT, -8, -8, 19, -19, 0, 17, -52, -2, 53, -13, -1};
        private static final int $$b = 40;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;

        /* JADX WARN: Code duplicated, block: B:10:0x0022  */
        /* JADX WARN: Code duplicated, block: B:8:0x001c  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0024). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$e(byte r6, short r7, byte r8) {
            /*
                int r6 = r6 * 3
                int r6 = 1 - r6
                int r7 = r7 + 103
                int r8 = r8 * 3
                int r8 = r8 + 4
                byte[] r0 = org.simpleframework.xml.transform.DateType.DateFormat.$$c
                byte[] r1 = new byte[r6]
                r2 = 0
                if (r0 != 0) goto L14
                r3 = r6
                r5 = r2
                goto L24
            L14:
                r3 = r2
            L15:
                byte r4 = (byte) r7
                int r5 = r3 + 1
                r1[r3] = r4
                if (r5 != r6) goto L22
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                return r6
            L22:
                r3 = r0[r8]
            L24:
                int r3 = -r3
                int r7 = r7 + r3
                int r8 = r8 + 1
                r3 = r5
                goto L15
            */
            throw new UnsupportedOperationException("Method not decompiled: org.simpleframework.xml.transform.DateType.DateFormat.$$e(byte, short, byte):java.lang.String");
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0023  */
        /* JADX WARN: Code duplicated, block: B:8:0x001b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0028). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static void a(short r7, byte r8, byte r9, java.lang.Object[] r10) {
            /*
                byte[] r0 = org.simpleframework.xml.transform.DateType.DateFormat.$$a
                int r9 = r9 + 2
                int r8 = r8 + 4
                int r7 = r7 + 66
                byte[] r1 = new byte[r9]
                r2 = 0
                if (r0 != 0) goto L10
                r3 = r8
                r5 = r2
                goto L28
            L10:
                r3 = r2
                r6 = r8
                r8 = r7
                r7 = r6
            L14:
                byte r4 = (byte) r8
                int r5 = r3 + 1
                r1[r3] = r4
                if (r5 != r9) goto L23
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L23:
                r3 = r0[r7]
                r6 = r3
                r3 = r7
                r7 = r6
            L28:
                int r8 = r8 + r7
                int r8 = r8 + (-2)
                int r7 = r3 + 1
                r3 = r5
                goto L14
            */
            throw new UnsupportedOperationException("Method not decompiled: org.simpleframework.xml.transform.DateType.DateFormat.a(short, byte, byte, java.lang.Object[]):void");
        }

        private static void b(char c, int i, int i2, Object[] objArr) throws Throwable {
            int i3 = 2 % 2;
            _CREATION _creation = new _CREATION();
            long[] jArr = new long[i2];
            _creation.b = 0;
            int i4 = $10 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
            $11 = i4 % 128;
            int i5 = i4 % 2;
            while (_creation.b < i2) {
                int i6 = _creation.b;
                try {
                    Object[] objArr2 = {Integer.valueOf(_CREATION[i + i6])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 0;
                        byte b2 = (byte) (b + 1);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(8 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) (9279 - View.combineMeasuredStates(0, 0)), TextUtils.getOffsetBefore("", 0) + 1977, 1113883676, false, $$e(b, b2, (byte) (b2 - 1)), new Class[]{Integer.TYPE});
                    }
                    Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i6), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 0;
                        byte b4 = (byte) (b3 + 3);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getTouchSlop() >> 8) + 30, (char) (49361 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), (ViewConfiguration.getLongPressTimeout() >> 16) + 684, -115095555, false, $$e(b3, b4, (byte) (b4 - 3)), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                    }
                    jArr[i6] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                    Object[] objArr4 = {_creation, _creation};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                    if (objAccessartificialFrame3 == null) {
                        byte b5 = (byte) 0;
                        byte b6 = b5;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(ExpandableListView.getPackedPositionGroup(0L) + 25, (char) ((-16747148) - Color.rgb(0, 0, 0)), TextUtils.lastIndexOf("", '0', 0, 0) + 817, 1897803493, false, $$e(b5, b6, b6), new Class[]{Object.class, Object.class});
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
                int i7 = $10 + 49;
                $11 = i7 % 128;
                int i8 = i7 % 2;
                cArr[_creation.b] = (char) jArr[_creation.b];
                Object[] objArr5 = {_creation, _creation};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-293902099);
                if (objAccessartificialFrame4 == null) {
                    byte b7 = (byte) 0;
                    byte b8 = b7;
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(KeyEvent.getDeadChar(0, 0) + 25, (char) (Color.green(0) + 30068), 815 - TextUtils.indexOf((CharSequence) "", '0'), 1897803493, false, $$e(b7, b8, b8), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
            }
            objArr[0] = new String(cArr);
        }

        public DateFormat(String str) {
            this.format = new SimpleDateFormat(str);
        }

        public String getText(Date date) throws Exception {
            String str;
            synchronized (this) {
                str = this.format.format(date);
            }
            return str;
        }

        public Date getDate(String str) throws Exception {
            Date date;
            synchronized (this) {
                date = this.format.parse(str);
            }
            return date;
        }

        static {
            char[] cArr = new char[1957];
            ByteBuffer.wrap("\u009dº§rèö2jw¶¹}Âè\u0004lIé\u0093hÔâ\u001eG#Ùem®Þð\\5Á\u007fT\u0080ÆÊ_\u000fÚQu\u009a¤Ü á¼+=l¾\u0002X8\u0090w\u0014\u00ad\u0088èT&\u009f]\n\u009b\u008eÖ\u000b\f\u008aK\u0000\u0081¥¼;ú\u008f1-o³ª7à¡\u001f\u001eUª\u0090;Îº\u0005VCÆ~[á\u008fÛG\u0094ÃN_\u000b\u0083ÅH¾ÝxY5Üï]¨×br_ì\u0019XÒù\u008ctIþ\u0003pý\u0096ÇI\u0088ÆRC\u0017\u009aÙ[¢ÄdH)ÔóN´Â~7Cú\u0005qÎÿ\u0090pUï\u001fcàüªhoÚ1dú\u009a¼\b\u0081\u0085K\u0017\f\u0085Ö\u0011\u0019Ñ#\u0018l\u008c¶\u0014óÝ=\u0015F\u008b\u0080EÍ\u0096\u0017\u0017P\u008f\u009a/\u0019Ñ#\u0018l\u008c¶\u0014óÝ=\u0002F\u0085\u0080\u0006ÍÈ\u0017\u0015P\u0092\u009a0§ª\u0019Ñ#\u000el\u009c¶\u0014ó\u0093=\u0003F\u0088\u0080DÍ´\u0017#P\u00ad\u009a0§¬á<*\u0090t2±ºû,\u000eó4;{»¡!ä±*|Qà\u0097*Ú´\u00002G«\u008d\u0013°\u009eö\u0014\u0019\u008c#\u0012lÖ¶\u0015ó\u009d=\u001eF\u0098\u0080EÍ\u0094\u0017\u0000P\u0084\u009a-§µá0*°t\f± û(\u0004¼N\u0018\u008b¦Õ/\u001eÏX\n\bq2ï}+§èâ`,ãWe\u0091¸Üi\u0006ýAy\u008bÐ¶HðÍ;Meñ ]êÕ\u0015A_å\u009a[ÄÒ\u000f2Iô\u0019Ñ#\u000el\u0081¶\u0004ó\u0086=\u0014F\u0081\u0080DÍ\u008a\u0017\fP\u0082\u009ap§¶á0*¶t=±¬ûc\u0004»N(\u0019\u009c#\u0014l\u009f¶\u0019ó\u009d=\t\u0013j)µf:¼¿ù=7¯L:\u008aÿÇ?\u001d·Z5\u0090Ë\u00ad\u000fë\u0087 \u0002~\u009d»#ñ»\u000e^D\u0092\u0081\u001cß\u0097\u0014rR\u00adon¥áâe8àuc³ýÈs\u0093é©6æ¹<<y¾·,Ì¹\n|G¼\u009d4Ú¶\u0010H-\u008ck\u0004 \u0081þ\u001e; q8\u008eÝÄ\u000f\u0001\u0088_\u0016\u0094ô4\"\u000eýAr\u009b÷Þu\u0010çkr\u00ad·ày:ÿ}q·\u0083\u008aEÌÃ\u0007EYÎ\u009cXÖÓ)Ncâ¦|øÂ3=u§H5\u0082èÅ0\u001f³\u0019Ñ#\u0019l\u009d¶\u0001óÝ=\u001fF\u0089\u0080\u0006Í\u0093\u0017\u0002P\u0095\u009a:§©á-\u0019\u008c#\u0012lÖ¶\u0015ó\u0087=\u0018F\u0080\u0080\u000fÍÈ\u0017\rP\u008f\u009a,§®\u0019\u0090#\u0018l\u0099¶\u0004ó\u0097=_F\u0082\u0080\u000eÍ\u0092µ)\u008fõÀr\u001aà_i\u0091¦êr,úar»øük6Þ\u000bQMÕ\u0086IØÆ\u001dE7}\rõBx\u0098ïÝl\u0013ú\u0019\u008c#\u0012lÖ¶\u0007ó\u0080=\u001eF\u0088\u0080\u001eÍ\u0085\u0017\u0011PÎ\u009a2§»á7*¡t5±¯û.\u0004¼N2\u008b°Õ$\u001eÎ\u0019\u0099#\u0018l\u0096¶\u000e\u0019\u008e#\u0018l\u008a¶\u0004ó\u009b=\u0002F\u0098\u0080EÍ\u0095\u0017\u001cP\u0093\u009aq§¸á=*út7±«û/\u0004½N \u008bìÕ&\u001eÌXNe\u0098¯SèÑ2D\u007fÏ¹vÂÃ\fSIë\u0093BÜêær#ümu¶éðy=ãGwqlKú\u0004hÞæ\u009byUà.zè§¥w\u007fþ8qò\u0093ÏZ\u0089ßB\u0018\u001cÕÙI\u0093Íl_&Âã\u000e½Äv.0¬\rzÇ±\u00803Z¦\u0017-Ñ\u0094ª!d±!\tû ´\f\u008e\u0090K\u001e\u0005\u0097Þ\u0001\u0098\u009b\u0019\u008e#\u0018l\u008a¶\u0004ó\u009b=\u0002F\u0098\u0080EÍ\u0095\u0017\u001cP\u0093\u009aq§¸á=*út7±«û/\u0004½N \u008bìÕ3\u001eÓX\u0015eÕ¯DèÙ\u0012¿()g»½5øª63M©\u008btÆ¤\u001c-[¢\u0091@¬\u0089ê\f!Ë\u007f\u0006º\u009að\u001e\u000f\u008cE\u0011\u0080ÝÞ\u0002\u0015âS$në¤eãâ\u0019\u008e#\u0018l\u008a¶\u0004ó\u009b=\u0002F\u0098\u0080EÍ\u0095\u0017\u001cP\u0093\u009aq§¸á=*út7±«û/\u0004½N \u008bìÕ3\u001eÓX\u0015eÛ¯VèÓ³k\u0089ýÆo\u001cáY~\u0097çì}* gp½ùúv0\u0094\r]KØ\u0080\u001fÞÒ\u001bNQÊ®XäÅ!\t\u007fÖ´6òðÏ>\u0005¾B6\u0019\u0088#\u001fl\u0097¶\u000fó\u0081=\u0017C\u0092yN6Éì[©Òg\u001d\u001cÂÚG\u0097ÁMS\nÏÀyýê\u0099I£ÞìV6ÎsT½ÅÆH\u0000ÙMSw:M\u009b\u0002\u0015Ø\u008d\u009d\u001cS\u009d(\u001bî\u0081£\ny\u0088H\u0092r\n=\u008aç\u0000¢\u0084l\u001f\u0017\u009b;z\u0001òNm\u0094ÿÑx\u001fÿd~¢á\u0019\u008c#\u0012lÖ¶\u0007ó\u0080=\u001eF\u0088\u0080\u001eÍ\u0085\u0017\u0011PÎ\u009a;§¿á/*½t0±«\u000f\u00075\u0090z\u0018 \u0080åE+ÈP\u0013 \u0097\u009a\u0016Õ\u0098\u000f\u001cJ\u008e\u0084\u0016ÿ\u0081´;\u008eºÁ4\u001b°^\"\u0090ºë--\u0096`<ºÿýt\\\u0091f\u0010)\u009eó\u001a¶\u0088x\u0010\u0003\u0087Å<\u0088\u0096RU\u0015Þß\bâä¤erøHf\u0007¢Ýs\u0098ôVj-üëj¦ñ|e;ºñFÌÁ\u008aIAÅ\u001fK\u0019½#)l£ú\u008dÀ\u0006\u008f\u009bU\r\u0010\u0085Þ\u0013¥\u0095c\u000f\u0019¿#\rl\u0088¶Wó =\u0004F\u0082\u0080\u001fÍ\u008f\u0017\bP\u0085\u009a\u007f§¼á6*¦ts±\u008dû%\u0004ºN(\u008b¯Õ$\u0099L£àìo6ösn½ëÆ{\u0000¸MF\u0097ÒÐX\u001a\u008c'KaßªNôÌ1I{\u009e\u0084]ÎÛ\u000bCU\u0092\u009e7Øðås\u0019¿#\u0013l\u009c¶\u0005ó\u009d=\u0018F\u0088\u0080KÍµ\u0017!P«\u009a\u007f§¸á,*½t?±ºûm\u0004®N(\u008b°Õa\u001eÄX\u0003e\u0080¯jè\u00862\u001b\u0091>« äd>\u00ad{!µ±Î:\b®E5\u009f¥Ø7\t[3Ð|V¦ÑãV-ÚV]\u0090Á\u0019\u0088#\u001fl\u0097¶\u000fóÊ=G\u0019\u008c#\u001cl\u0096¶\u0014ó\u009a=\u0004\u0019\u008c#\u0012lÖ¶\u0007ó\u0080=\u001eF\u0088\u0080\u001eÍ\u0085\u0017\u0011PÎ\u009a=§¨á8*ºt7ô\u0082Î\u001c\u0081Ø[\u0012\u001e\u0099Ð\r«\u008cm\u0000 \u0084úE½\u009fw4J¹\f\"\u0019Ï\u0019\u008c#\u0012lÖ¶\u0004ó\u0097=\u0012F\u0099\u0080\u0019Í\u0083\u0019Î\u0019\u008c#\u0012lÖ¶\u0015ó\u0087=\u0018F\u0080\u0080\u000fÍÈ\u0017\u0015P\u0092\u009a0§¾á,*·t'\u0019\u0098#\bl\u0094¶\u001bó\u00ad=\tFÔ\u0080]\u0019\u008c#\u0012lÖ¶\u0015ó\u0087=\u0018F\u0080\u0080\u000fÍÈ\u0017\u0003P\u0089\u009a1§½á<*¦t#±¼û$\u0004¦N3!~\u001bÿTq\u008eõËg\u0005ÿ~h¸£õr/æhl¢\u0097\u009fZÙÛ\u0012]LÑ\u0089[ÃÃ<L`FZÇ\u0015IÏÍ\u008a_DÇ?Pùë´An\u0082)\tã¯Þv\u0098âS`\rÓÈi\u0082ª}!7·òz¬ûg\r!\u0081\u001c\u001bÖ\u0083\u0091\fK¯\u0006\rÀÎ»M\u0019\u0099#\u0018l\u0096¶\u0012ó\u0080=\u0018F\u008f\u0080DÍ\u0081\u0017\nP\u008f\u009a8§¶á<*\u008bt ±ªû&\u0004çN \u008b§Õ/\u001eÙXIeß¯V¨Y\u0092ØÝV\u0007ÒB@\u008cØ÷O1\u0084|P¦ÇáO+ç\u0016\"P¯\u009bdÅ¼\u0000xJïµgÿÿ::d·¯\f\u0004Á>JqÏ«HîÆ L[\u009b\u009d@ÐÚ\nVMç\u0087`ºòüi7ãie¬óæJ\u0019èS'\u0096¬È6\u0003\u0083E\u0006x\u0080²\bõ\u009a/\u001eb\u0091¤.ß\u0084\u0011CTðºô\u0080jÏ®\u0015mPå\u009efåà#\u007fnñ´|óü9B\u0004ÐC y¾6zì¹©1g²\u001c4Ú®\u0097'M¨\n+À\u0096ýX»\u0097p\r.\u0096ë\u000e¡\u0085^J\u0014\u008dÑ\u0007\u008f\u0083Dw\u0002ò?hõé²nhê%hãñÃ7ù\u009b¶\u0014l\u008d)\u0015ç\u0090\u009c\u0000ZÎ\u0017\u0016ÍÕ\u008a^\u008a9°§ÿc% `2®\u00adÕ5\u0013º^}\u0084´Ã<\t\u00994\u001fr\u0080¹\u0000ç\u009f\"Uh\u0091\u0097\u0019\u0019\u008a#\u0018l\u008b¶\u0003óß\u008eß´[ûÙ!Kd\u0094ªJÑÒ\u0017@Z\u0080\u0080\\ÇÍ\rz0çv<½ìãi&élu\u0093ó\u0019\u008f#\u0018l\u0095¶\u0002óÜ=\u0019F\u009b\u0080EÍ\u008b\u0017\u0004P\u0089\u009a1§±á<*\u00adt D\u0016~\u00811\fë\u009b®E`\u009b\u001b\u0013ÝÜ\u0090\u0019J\u009d\r\u0012Ç£ú\u001c¼£w,)§ì2¦¦Y0]jgý(pòç·9yç\u0002oÄ \u0089oSã\u0014aÞåã[¥Ùn_0ÅõB¿Ü@T\u0019\u008c#\u0012lÖ¶\u001có\u0097=\u0003F\u0082\u0080\u000eÍ\u008a\u0017KP\u0081\u009a1§¾á+*»t:±ªûc\u0004¹N\"\u008b¯Õ4\u001eØ\u0019\u008c#\u0012lÖ¶\u0015ó\u009d=\u001eF\u0098\u0080EÍ\u0097\u0017\u0000P\u008d\u009a*§ôá8*¢t7±\u0091û#\u0004©N*\u008b§\u009br¡ìî(4æqh¿âÄ<\u0002÷Om\u0095òÒr\u0018Å%\ncÁ¨CöÃ3WyÖ\u0086DÌÉ\tNWÖ\u009c,Ú±\u0019\u008c#\u0012lÖ¶\u0007ó\u0080=\u001eF\u0088\u0080\u001eÍ\u0085\u0017\u0011PÎ\u009a=§¯á0*¸t7±àû+\u0004¡N)\u008b¥Õ$\u001eÎXKeÄ¯\\èÞ2[\u0019\u008c#\u0012lÖ¶\u0004ó\u008b=\u0002F\u0098\u0080\u000eÍ\u008b\u0017KP\u0082\u009a*§³á5*°t}±¨û$\u0004¦N \u008b§Õ3\u001eÌXIeß¯[èÄ\u0019\u008c#\u0012lÖ¶\u0004ó\u008b=\u0002F\u0098\u0080\u000eÍ\u008b\u0017:P\u0085\u009a'§®áw*¶t&±§û!\u0004¬Ni\u008b¤Õ(\u001eÒX\\eÓ¯GèÀ2]\u007fÃ¹GÂÐ\u0080\nº\u0094õP/\u0087j\u0011¤\u0099ß\u000e\u0019\u0082T\u0012\u008eÍÉ\u0004\u0003¬>5x³³6íû(.b¢\u009d ×¦\u0012!Lµ\u0087JÁÏüY6ÝqB\u0019\u008c#\u0012lÖ¶\u0001ó\u0097=\u001fF\u0088\u0080\u0004Í\u0094\u0017:P\u0084\u009a3§±á4*út1±»û$\u0004¤N#\u008bìÕ'\u001eÕXUeÑ¯PèÂ2_\u007fØ¹@ÂÊ\fW\u0019ÄÞ#äë«oqó4/úò\u0081{Gô\naÐÈ\u0097b]Ä`X&Î\u0019Ñ#\u0019l\u009d¶\u0001óÝ=\u0002F\u0083\u0080\bÍ\u008d\u0017\u0000P\u0094\u009ap§¸á8*§t6±¬û,\u0004¦N#\u008b\u009dÕ&\u001eÙXUeÏ¯Q\u0019Ñ#\u0019l\u009d¶\u0001óÝ=\u0002F\u0083\u0080\bÍ\u008d\u0017\u0000P\u0094\u009ap§½á<*ºt*±ªSli¤& ü¼¹`w¿\f>Êµ\u00870]½\u001a)ÐÍí\u0016«\u0081`\u0004>\u009bû\u0017\u0019Ñ#\u000el\u0081¶\u0004óÝ=\u0000F\u0089\u0080\u0006Í\u0093\u0017:P\u0094\u009a-§»á:*±\u009dý§\"è\u00ad2(wª¹8Â\u00ad\u0004hI¦\u0093 Ô®\u001e\\#\u009ae\u001c®\u009að\u001c5½\u007f\f\u0080\u0085Ê\u0007\u000f\u0082Q\u0002\u009aóÜHáþ+|lþ¶vûá=ZFù\u0088jÍß\u0017DX\u009abH§Ñ\u0019Ñ#\u0019l\u009d¶\u0001óÝ=\u0013F\u009f\u0080\u001fÍ¹\u0017\u0002P\u0090\u009a,þ¾Äv\u008bòQn\u0014²Ú|¡ðgp*Öð~·æ}]@Ð\u0019Ñ#\u0019l\u009d¶\u0001óÝ=\u0002F\u0083\u0080\bÍ\u008d\u0017\u0000P\u0094\u009ap§¸á** t5±¡û!\u0004¬N\"\u008b°Õ%\u0019Ñ#\u000el\u0081¶\u0004ó\u0086=\u0014F\u0081\u0080DÍ\u008a\u0017\fP\u0082\u009ap§¶á0*¶t1±½û9\u0004®N(\u008b®Õ%\u001eÙXIeé¯_èÞ2F\u007f\u0084¹ZÂË\u0019Ñ#\u0019l\u009d¶\u0001óÝ=\u0013F\u009f\u0080\u001fÍ\u0087\u0017\u0006P\u0083\u009a:\u0019Ñ#\u0019l\u009d¶\u0001óÝ=\u0013F\u009f\u0080\u001fÍ\u0081\u0017\u001cP\u0092\u009a0\u0019Ñ#\u0019l\u009d¶\u0001óÝ=\u0013F\u009f\u0080\u001fÍ\u008b\u0017\u0000P\u0087\u009a1\u0019Ñ#\u0019l\u009d¶\u0001óÝ=\u0013F\u009f\u0080\u001fÍ\u0089\u0017\u0017P\u0089\u009a:\u0019Ñ#\u0019l\u009d¶\u0001óÝ=\u0013F\u009f\u0080\u001fÍ\u0090\u0017\bP\u0093\u009a8¦O\u009c\u0087Ó\u0003\t\u009fLC\u0082\u008dù\u0001?\u0081r\b¨\u009cï\u001f%¨\u00184^¤ýæÇ.\u0088ªR6\u0017êÙ$¢¨d()\u008eó;´º~\r\u0019Ñ#\u0019l\u0099¶\u0003ó\u0093=^F\u0088\u0080\u0004Í\u0091\u0017\u000bP\u008c\u009a0§»á=*§t|±àû5\u0004ªNh\u008b Õ2\u001eÈXPZ\r`Ì/Jõß°\u0001~Ú\u0005YÃÙ\u008e^TÖ\u0013KÙðä)¢Çi{7ûòA¸ùGu\réÈ{\u0096ù]&\u001b\u0088&\u0006ì\u008d«\tq\u0081\u008c\u0090¶LùË#YfÐ¨\u001fÓÄ\u0015EX×\u0082KÅÓ\u000fj2è\u0019Î#\u001bl\u009e¶WóÈÀ=úáµfoô*}ä²\u009fsYâ\u0014fÎï\u0089#CÞ~W8ÅóK\u0019\u0099#\u000fl\u0099¶\u001bó\u009e=\u001eF\u008f\u0080EÍ\u0081\u0017\nP\u008c\u009a;§¼á0*§t;±àû>\u0004§\u0019\u0092#\u0014l\u009a¶0ó¾=4F¿\u00804Í\u0084\u0017\u0016P\u0094\u009aq§©á6UPo\u0099 \rú\u0095¿\\q\u009d\n\bÌ\u008e\u0081\u000e[\u0085\u001c>Ö½ë4\u00ad¼f08±ý<·âH1\u0002«Ç/\u0019\u009c#\u0011l\u008d¶\u0012ó\u0081=\u0005F\u008d\u0080\bÍ\u008d\u0017\u0016\u0019Ñ#\u0018l\u008c¶\u0014óÝ=\u001cF\u0083\u0080\u001eÍ\u0088\u0017\u0011P\u00938ì\u0002$M¤\u0097>Ò®\u001ccgµ¡9ì¬66q±»\r\u0086\u0086À\u0000\u000b\u009aUA\u0090ÝÚ\u0014%\u0085oUª\u009eô\f?ñyuD¥\u008epÉà\u0013~áñÛ-\u0094ªN8\u000b±Å~¾¯x;5³ï,¨®b\u0019_\u0095\u0014\u0092.9a¿»8þ¿03K´\u008d(\u0094|®´á4;®~>°óË,\r¯@8\u009a«Ýb\u0017\u0082*\u0005l\u009b§\u001fù\u0097<\u000fv\u0085\u0089\u0016ÃÅ\u0006\fX\u0099\u0093cÕ¹è+\"·e~¿íòj4ªOd\u0081çÄP\u001eÂQZkÌ®VàÎ;U}\u0088°FÊÍ\r@@'\u009a¾Ý9\u0017¼".getBytes(CharEncoding.ISO_8859_1)).asCharBuffer().get(cArr, 0, 1957);
            _CREATION = cArr;
            _BOUNDARY = -3602950908522716291L;
        }

        /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
            java.util.NoSuchElementException
            	at java.base/java.util.TreeMap.key(Unknown Source)
            	at java.base/java.util.TreeMap.lastKey(Unknown Source)
            	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
            	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
            	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
            */
        public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r67, int r68, int r69, int r70) {
            /*
                Method dump skipped, instruction units count: 15972
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: org.simpleframework.xml.transform.DateType.DateFormat.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
        }
    }

    public static Date getDate(String str) throws Exception {
        return getType(str).getFormat().getDate(str);
    }

    public static DateType getType(String str) {
        int length = str.length();
        if (length > 23) {
            return FULL;
        }
        if (length > 20) {
            return LONG;
        }
        if (length > 11) {
            return NORMAL;
        }
        return SHORT;
    }
}
