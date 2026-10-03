package org.joda.time;

import android.graphics.Color;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import ch.qos.logback.core.net.SyslogConstants;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.text.DateFormatSymbols;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import o.ArtificialStackFrames;
import o._CREATION;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.time.TimeZones;
import org.joda.time.chrono.ISOChronology;

/* JADX INFO: loaded from: classes3.dex */
public class DateTimeUtils {
    public static final MillisProvider SYSTEM_MILLIS_PROVIDER;
    private static volatile MillisProvider cMillisProvider;
    private static final AtomicReference<Map<String, DateTimeZone>> cZoneNames;

    public interface MillisProvider {
        long getMillis();
    }

    public static final long fromJulianDay(double d) {
        return (long) ((d - 2440587.5d) * 8.64E7d);
    }

    public static final double toJulianDay(long j) {
        return (j / 8.64E7d) + 2440587.5d;
    }

    static {
        SystemMillisProvider systemMillisProvider = new SystemMillisProvider();
        SYSTEM_MILLIS_PROVIDER = systemMillisProvider;
        cMillisProvider = systemMillisProvider;
        cZoneNames = new AtomicReference<>();
    }

    protected DateTimeUtils() {
    }

    public static final long currentTimeMillis() {
        return cMillisProvider.getMillis();
    }

    public static final void setCurrentMillisSystem() throws SecurityException {
        checkPermission();
        cMillisProvider = SYSTEM_MILLIS_PROVIDER;
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class OffsetMillisProvider implements MillisProvider {
        private static long _BOUNDARY;
        private static char[] _CREATION;
        private final long iMillis;
        private static final byte[] $$c = {35, -73, 121, Ascii.DC2};
        private static final int $$d = 178;
        private static int $10 = 0;
        private static int $11 = 1;
        private static final byte[] $$a = {5, Ascii.FF, -27, -23, 2, -47, -11, 52, -17, 5, 8, -19, 19, 0, -17, 53, -22, -1, 3, Ascii.FF, -11, 8, -53, Ascii.CR, 1};
        private static final int $$b = SyslogConstants.LOG_LOCAL2;
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
        private static java.lang.String $$e(int r6, int r7, int r8) {
            /*
                int r6 = r6 + 4
                int r7 = r7 * 3
                int r7 = 1 - r7
                byte[] r0 = org.joda.time.DateTimeUtils.OffsetMillisProvider.$$c
                int r8 = r8 + 103
                byte[] r1 = new byte[r7]
                r2 = 0
                if (r0 != 0) goto L12
                r3 = r7
                r5 = r2
                goto L24
            L12:
                r3 = r2
            L13:
                byte r4 = (byte) r8
                int r5 = r3 + 1
                r1[r3] = r4
                int r6 = r6 + 1
                if (r5 != r7) goto L22
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                return r6
            L22:
                r3 = r0[r6]
            L24:
                int r8 = r8 + r3
                r3 = r5
                goto L13
            */
            throw new UnsupportedOperationException("Method not decompiled: org.joda.time.DateTimeUtils.OffsetMillisProvider.$$e(int, int, int):java.lang.String");
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0021  */
        /* JADX WARN: Code duplicated, block: B:8:0x0019  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0026). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static void b(byte r7, int r8, short r9, java.lang.Object[] r10) {
            /*
                int r8 = 4 - r8
                int r7 = r7 + 66
                int r9 = 22 - r9
                byte[] r0 = org.joda.time.DateTimeUtils.OffsetMillisProvider.$$a
                byte[] r1 = new byte[r8]
                r2 = 0
                if (r0 != 0) goto L11
                r3 = r8
                r7 = r9
                r4 = r2
                goto L26
            L11:
                r3 = r2
            L12:
                int r4 = r3 + 1
                byte r5 = (byte) r7
                r1[r3] = r5
                if (r4 != r8) goto L21
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L21:
                r3 = r0[r9]
                r6 = r9
                r9 = r7
                r7 = r6
            L26:
                int r3 = -r3
                int r9 = r9 + r3
                int r9 = r9 + (-2)
                int r7 = r7 + 1
                r3 = r4
                r6 = r9
                r9 = r7
                r7 = r6
                goto L12
            */
            throw new UnsupportedOperationException("Method not decompiled: org.joda.time.DateTimeUtils.OffsetMillisProvider.b(byte, int, short, java.lang.Object[]):void");
        }

        private static void a(char c, int i, int i2, Object[] objArr) throws Throwable {
            int i3 = 2 % 2;
            _CREATION _creation = new _CREATION();
            long[] jArr = new long[i2];
            _creation.b = 0;
            while (_creation.b < i2) {
                int i4 = $10 + 65;
                $11 = i4 % 128;
                int i5 = i4 % 2;
                int i6 = _creation.b;
                try {
                    Object[] objArr2 = {Integer.valueOf(_CREATION[i + i6])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) (-1);
                        byte b2 = (byte) (b + 1);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(9 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 9278), 1977 - View.MeasureSpec.getSize(0), 1113883676, false, $$e(b, b2, (byte) (b2 + 1)), new Class[]{Integer.TYPE});
                    }
                    Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i6), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) (-1);
                        byte b4 = (byte) (b3 + 1);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(30 - ((Process.getThreadPriority(0) + 20) >> 6), (char) (Color.red(0) + 49362), 684 - KeyEvent.keyCodeFromString(""), -115095555, false, $$e(b3, b4, (byte) (b4 + 3)), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                    }
                    jArr[i6] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                    Object[] objArr4 = {_creation, _creation};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                    if (objAccessartificialFrame3 == null) {
                        byte b5 = (byte) (-1);
                        byte b6 = (byte) (b5 + 1);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(((Process.getThreadPriority(0) + 20) >> 6) + 25, (char) (30069 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), 816 - View.getDefaultSize(0, 0), 1897803493, false, $$e(b5, b6, b6), new Class[]{Object.class, Object.class});
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
                int i7 = $10 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                $11 = i7 % 128;
                int i8 = i7 % 2;
                cArr[_creation.b] = (char) jArr[_creation.b];
                Object[] objArr5 = {_creation, _creation};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-293902099);
                if (objAccessartificialFrame4 == null) {
                    byte b7 = (byte) (-1);
                    byte b8 = (byte) (b7 + 1);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 24, (char) (TextUtils.indexOf("", "", 0) + 30068), 817 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 1897803493, false, $$e(b7, b8, b8), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
            }
            objArr[0] = new String(cArr);
        }

        OffsetMillisProvider(long j) {
            this.iMillis = j;
        }

        @Override // org.joda.time.DateTimeUtils.MillisProvider
        public long getMillis() {
            return System.currentTimeMillis() + this.iMillis;
        }

        static {
            char[] cArr = new char[1959];
            ByteBuffer.wrap("\u0019ÑïXô\u001fýÎÂÙÈSÑ\u001d¦Ü¯\u008aµJº\u0003\u0083Û\u0088\u008e\u009e{g\u0003lÄuº{n@?Ië^¥$K-!2à;¯\u0001o\u0016/¤çRnI)@ø\u007fïuel+\u001bê\u0012¼\b|\u00075>í5¸#MÚ$ÑÿÈ\u0098ÆOý3ôÊã\u0090\u0099P\u0090\u0007\u008fÒ\u0086\u009c\u0010zæóý´ôeËrÁøØ¶¯w¦!¼á³¨\u008ap\u0081%\u0097Ðnºer|\u001brÔ\u0019ÑïOô\u0003ýËÂÙÈYÑ\u001d¦Ô¯\u009bµ@º\u000f\u0083\u0087\u0088\u0081\u009eKg\u000elÄu¸{u@)Ið^\u0089$v-32ä;º\u0001i\u00168\u001fñ\u0019ÑïYô\u000eýÛÂÙÈPÑ\u0015¦\u009e¯\u009eµ^º\u0005\u0083Ø\u0019ÑïYô\u000eýÛÂÙÈGÑ\u001b¦Ý¯Àµ\\º\u0018\u0083Ç\u0088\u0096\u0001{÷åì´åqÚ=ÐìÉ¼¾5·\u0016\u00adÀ¢\u008d\u009bm\u0090:\u0086ë\u007f\u008ctkm\u0000c×\u0019ÑïXô\u001býÌÂ\u0097È\u001bÑ\\¦Ó¯\u009eµYº\u0003\u0083Æ\u0088\u0080\u009eK\u00adB[\u009d@\u009aI\u0014vW|\u0095eÈ\u0012P\u001bR\u0001\u0087\u000eÀ7\u0014<G*\u0083ÓÈØ1Á~Ï·ôàý\tê|\u0090´\u0099ï\u0086o+ÄÝ\u001bÆ\u001cÏ\u0092ðÑú\u0013ãN\u0094Ö\u009dÔ\u0087\u0001\u0088F±\u0092ºÁ¬\u0005UN^·GøI1rf{\u008flú\u00162\u001fi\u0000ê\u0019ÑïOô\u0003ýËÂ\u0082ÈQÑ\u001f¦\u009f¯\u0082µEº\b\u0083\u0087\u0088\u008a\u009eMg\u0000lÎu¼{2@)I÷ñ£\u0007j\u001c\"\u0015é*¦ sÇ31ì\u0019ÑïOô\u0003ýËÂ\u0082ÈQÑ\u001f¦\u009f¯\u008cµEº\u0004\u0083\u0087\u0088\u0088\u009eAg\u000flÕu\u0088{Q@wIö^³$y-'2½;\u00ad\u0001c\u0016$\u001füä´êkó.\u0019ÑïOô\u0003ýËÂ\u0082ÈQÑ\u001f¦\u009f¯\u008cµEº\u0004\u0083\u0087\u0088\u0088\u009eAg\u000flÕu\u0088{Q@wIè^¤${-\"\u0019ÑïOô\u0003ýËÂ\u0082ÈQÑ\u001f¦\u009f¯\u0082µEº\b\u0083\u0087\u0088\u008a\u009eMg\u0000lÎu»{q@/IÎ^\u009b$d- 2ÿ;¾\u0001\"\u00169\u001fçPï¦f½!´ð\u008bç\u0081d\u0098)ïãæ¥üuó!ÊóÁ«×nû\u009c\rC\u0016D\u001fÊ \u0093*M3\u000eDÄMÐWTX\u0015aËj\u0082\u0019\u0090ïYô\u001býËÂ\u0093È\u001aÑ\u001c¦Õ¯\u009aÂý4`/$&û\u0019¹\u00137\n8}õt®nea5XýS¹E|¼+·á®\u0081\u008fZy\u0093bÝk\u0007TO^\u0098\u0019\u008cïSôTýÈÂ\u0084È[Ñ\u0016¦Å¯\u008dµXºD\u0083Å\u0088\u0087\u009eJg\u0017lÆu¿{\u007f@.Ií^¤$q- \r:ûúà·éb\u0019\u008eïYô\býËÂ\u009fÈGÑ\u0006¦\u009e¯\u009dµUº\u0019\u0083\u0086\u0088\u0084\u009e@gLlÄu»{~@/Iÿ^ø$s-\"2å;à\u0001j\u0016+\u001fãä£ê[ó%øðÁËÖ£ÜH¥\u001dªØ³\u0090¹W\u008e\u0002\u0097Ë\u009c\u009e\u0087\u009dqJj\u001bcØ\\\u008cVTO\u00158\u008d1\u008e+F$\n\u001d\u0095\u0016\u0097\u0000Sù_ò×ë¨åmÞ<×ìÀëº`³1¬ö¥ó\u009fy\u00888\u0081ðz°tHm6fã_ØH°B_;\u000e4Ë-\u0083'N\u0010\u0011\u0019\u008eïYô\býËÂ\u009fÈGÑ\u0006¦\u009e¯\u009dµUº\u0019\u0083\u0086\u0088\u0084\u009e@gLlÄu»{~@/Iÿ^ø$f-=2¾;\u00ad\u0001}\u0016#\u0019\u008eïYô\býËÂ\u009fÈGÑ\u0006¦\u009e¯\u009dµUº\u0019\u0083\u0086\u0088\u0084\u009e@gLlÄu»{~@/Iÿ^ø$f-=2¾;¢\u0001m\u0016)\u0019\u008eïYô\býËÂ\u009fÈGÑ\u0006¦\u009e¯\u009dµUº\u0019\u0083\u0086\u0088\u0084\u009e@gLlÄu»{~@/Iÿ^ø$f-=2¾;£\u0001o\u0016)*\u0002ÜÕÇ\u0084ÎGñ\u0013ûËâ\u008a\u0095\u0012\u009c\u0011\u0086Ù\u0089\u0095°\n»\b\u00adÌTÀ_HF7Hòs£zsmt\u0017ê\u001e±\u00012\b/2î%¥\u0019\u0088ï^ô\u0015ýÀÂ\u0085ÈR\u0019ÑïLô\bý×Â\u0095È\u001bÑ\u001f¦ß¯\u008aµYº\u0006\u0083Í\u0088\u0095\u0019\u0088ï^ô\u0015ýÀÂ\u0091ÈAÑ\u0017¦Ã¯\u009a\u0019¹ïYô\u0014ýÁÂ\u009bÈ[Ñ\u0006¦Ù¯\u0081µB\u00193ïêô©ýnÂ!ÈûÑ¤\u0019\u009dïTô\bý×Â\u009bÈ]Ñ\u0007¦Ý\u0019\u008cïSôTýÈÂ\u0084È[Ñ\u0016¦Å¯\u008dµXºD\u0083Ì\u0088\u0083\u009eRg\u000blÃu»\u0019\u0088ï^ô\u0015ýÀÂÎÈ\u0002Ñ\u0002\u0019\u0099ïYô\u0014ýÝÂ\u0084È]Ñ\u0011\u0019\u0099ïYô\u0014ýÝÂ\u0084È]Ñ\u0011¦ï¯\u0096µ\u0014º\\\u0019\u0099ïYô\u0014ýÝÂ\u0084È]Ñ\u0011¦ï¯\u0096µ\u0014º\\\u0083÷\u0088Ð\u009e\u0010dñ\u0092.\u0089)\u0080µ¿ùµ&¬kÛ¸ÒðÈ%Ç9þ¸õôã=\u001az\u0011±\b\u008eþ[å\u0012\u0097ga\u00adzós(LkF¼_á(>\u0019¿ïLô\ný\u0098Â¤ÈAÑ\u001c¦Ä¯\u0087µAº\u000f\u0083\u0088\u0088\u0080\u009eKg\u0010l\u0080u\u009d{t@(I÷^»$qó\u0085\u0005h\u001e$\u0017ð(£\"g;,LªE\u0087_RP\u001bi²b¾tk\u008d1\u0086ö\u009f\u0090\u0091\u0006ª\u0006£Í´\u009eÎ\u000eÇ\u0010Ø\u0092ÑÂ(\u009dÞpÅ<Ìèó»ù\u007fà4\u0097²\u009e\u009f\u0084J\u008b\u0003²ª¹¦¯sV)]îD\u0088J\u001eq\u001exÕo\u0086\u0015\u0016\u001c\b\u0003\u008a\nÚ0q'^.\u009e*EÜ\u009aÇ\u009dÎ\u0019ñ^û\u008fâß\u0095\u000e\u009cF\u0086\u0097\u0089Æ\u0019\u0099ïSô\u0016ýÜÂ\u0090È]Ñ\u0001¦Ø\u0019\u0088ï^ô\u0015ýÀÂÎÈ\u0002\u0099¸oit }ïBªHu\u0091\u0005gÚ|ÝuAJ\r@ÒY\u009f.L'\u0004=Ñ2Í\u000bC\u0000\u001d\u0016Ìï\u0085äM\u0019\u008cïSôTýÓÂ\u0093ÈFÑ\u001c¦Õ¯\u0082µ\u0002º\u001b\u0083Í\u0088\u008b\u009eQ\u0019Ï\u0018Üî\u0003õ\u0004ü\u009bÃÃÉ\u0007ÐW§\u0092®Û\u0016\u0092\u0019\u008cïSôTýÚÂ\u0083È]Ñ\u001e¦Ô¯Àµ\\º\u0018\u0083Ç\u0088\u0082\u009eQg\u0001lÔÜ\u001d*Ì1\u00938Q\u0007,\rÉ\u0014Ïc\u0003e\u008c\u0093S\u0088T\u0081Ú¾\u0083´]\u00ad\u001eÚÔÓÀÉJÆ\u0003ÿÆô\u0081âA\u001b\u0010\u0010Ð\t¬\u0007u<45ì\u0019\u0099ïYô\u0014ýÝÂ\u0084È]Ñ\u0011¦\u009f¯\u009dµHº\u0001\u0083\u0087\u0088\u0081\u009eAg\flÅu¬{u@9\u0019\u0099ïYô\u0014ýÝÂ\u0084È]Ñ\u0011¦ï¯\u0096µ\u0014º\\\u0083\u0087\u0088\u0095\u009e@g\tlÿu¦{$@lI·^±$q-<2õ;¼\u0001e\u0016)\u001f×ä¾ê<ót¢\u0082TBO\u000fFÆy\u009fsFj\n\u001d\u0084\u0014\u0092\u000eX\u0001\u001e8Ô3\u0091%ZÜ&×ÈÎ¡Àlûnòäå¨\u009fa\u0096,\u0089ù\u0080¼ºt\u0019\u0099ïYô\u0014ýÝÂ\u0084È]Ñ\u0011¦\u009f¯\u0098µNº\u0005\u0083Ð\u0088Þ\u009e\u0012g\u0012l\u008fu¨{~@5Ià^î$\"-\"\u0096¨`b{$rîM«G`^l)ò »:v5\u0004\fþ\u0007§\u0011}è<ãÿú\u008aôrÏ\u0013Æ\u0091ÑÑ«\n¢\u0004½Ä´\u0091\u008eX\u0099\t\u0090Ðk\u0094ej|\u000bw\u0089N¹\u0019\u008cïSôTýÚÂ\u0099È[Ñ\u0006¦Ü¯\u0081µMº\u000e\u0083Í\u0088\u0094Ìð:/!((¦\u0017å\u001d'\u0004zs¥zÿ`1oqV±]´K:²k¹µ Î®\u0004\u0095\b\u009c\u0082\u008bÃñ\u0006øIç\u0089îÀÔ\u0000ÃDÊ\u009d1Ô?\f\u0019¿ïRô\u001eýÊÂ\u0099È]Ñ\u0016¦\u009d¯\u0096µ\u0014º\\\u0019\u008cïSôTýÚÂ\u0083È]Ñ\u001e¦Ô¯ÀµHº\u0003\u0083Û\u0088\u0096\u009eHg\u0003lÙuð{u@>\u0019\u008aïYô\týÌÂÛûK\r\u008e\u0016Ï\u001f\u0010 \u0004*\u009b3ØD\u000fM\u001cW\u0081XÓa\u0019jO|Õ\u0085Î\u008e\u000e\u0097m\u0099°¢õ1JÇ\u009cÜÒÕ\bê\u001dà\u0099ùÀ\u008e[\u0087F\u009d\u0088\u0092Æ«\u0003 H¶\u0084OÞD\u0016Ìä:2!|(¦\u0017³\u001d,\u0004\u007fsõzã`&ojV¦]ÒK,²h¹¦ Ð®\u0005\u0095P»eM³Vý_'`2j\u00adsþ\u0004t\rh\u0017¥\u0018ä!\u001d*h<«ÅæÎ9×]Ù\u0082âÉ*ÞÜ\u0001Ç\u0006Î\u0081ñÁû\u0014âN\u0095\u0087\u009cÐ\u0086P\u0089Y°\u0094»Ð\u00ad\u0004T__\u009bFèH`syz¯mé\u00173\u001ed\u0019\u008cïSôTýÚÂ\u0099È[Ñ\u0006¦\u009e¯\u009fµIº\u0007\u0083Ý\u0088È\u009eEg\u0014lÄu\u0081{r@;Iõ^³\u0019\u008cïSôTý×Â\u0092ÈYÑ\\¦Ò¯\u009bµEº\u0006\u0083Ì\u0088È\u009eBg\u000blÎu¹{y@(Iè^¤$}-<2ä\u001aÜì\u0003÷\u0004þ\u0098ÁÔË\u000bÒF¥\u0095¬Ý¶\b¹\u0014\u0080\u009a\u008bÃ\u009d\u001dd^o\u0094v x*CcJ¦]á'!.p1°8ì\u00025\u0015t\u001c¬\u0019\u008cïSôTýËÂ\u008fÈGÑ\u0006¦Õ¯\u0083µ\u0002º\b\u0083Ý\u0088\u008f\u009eHg\u0006l\u008eu¸{u@4Iÿ^³$f-\"2â;§\u0001b\u0016>\u0019\u008cïSôTýËÂ\u008fÈGÑ\u0006¦Õ¯\u0083µsº\u000f\u0083Ð\u0088\u0092\u009e\ng\u0000lÕu·{p@>I¶^°$}-<2÷;«\u0001~\u0016:\u001fúä¯êjó6\u0019\u008cïSôTýÎÂ\u0093ÈZÑ\u0016¦ß¯\u009cµ\u0002º\b\u0083Ý\u0088\u008f\u009eHg\u0006l\u008eu¸{u@4Iÿ^³$f-\"2â;§\u0001b\u0016>\u0019\u008cïSôTýÎÂ\u0093ÈZÑ\u0016¦ß¯\u009cµsº\u000e\u0083Ä\u0088\u008d\u009eIgLlÂu«{u@6Iü^ø$r-;2þ;©\u0001i\u00168\u001føä´êmó,øôY²\u0019ÑïXô\u001fýÎÂÙÈEÑ\u0017¦Ý¯\u009bµsº\u001a\u0083Á\u0088\u0096\u009eA`ð\u0096y\u008d>\u0084ï»ø±f¨<ßòÖ¤ÌhÃ?ú¦ñ¥çd\u001e0\u0015ä\f\u009d\u0002\\9\u00150Ý'¨]RT\u0016KßB\u0096xIUy£ð¸·±f\u008eq\u0084ï\u009dµê{ã-ùáö¶Ï/Ä)Òé+¤ q9\u0012Õ,#¥8â13\u000e$\u0004º\u001dàj.cxy´vãOzDjR¼«ò (¹G\u0019ÑïOô\u0003ýËÂÙÈEÑ\u0017¦Ý¯\u009bµsº\u001e\u0083Ú\u0088\u0087\u009eGg\u0007¢ºT$OhF yés:jt\u001dô\u0014é\u000e.\u0001c8ì3á%&Ük×¨ÎêÀ\u001aûPò\u009fåÑ\u009f\u0010\u0096Z\u0089¤\u0080Áº\u0002\u00adC¤\u0096_ÊQ0HXC\u008ez¸mâg\u007f\u001e`\u0011²úb\fë\u0017¬\u001e}!j+å2²EwL\u0002VøY©`h\u0019ÑïXô\u001fýÎÂÙÈVÑ\u0001¦Ä¯±µXº\u0003\u0083Å\u0088\u0083õ²\u0003;\u0018|\u0011\u00ad.º$$=~J°CæY*V}oädçr4\u008bu\u0080¥\u0099Ò\u0097\u0013¬]¥\u009e²ÇÈ\u0013wL\u0081Ò\u009a\u009e\u0093V¬\u001f¦Ì¿\u0082È\u0002Á\u001fÛØÔ\u0095í\u001aæ\u0017ðÐ\t\u009d\u0002_\u001b0\u0015õ.¡'j0'JíCª\\\u007fU\foûx¹q|\u008au\u0084ê\u009d°\u0019ÑïXô\u001fýÎÂÙÈVÑ\u0001¦Ä¯\u008fµOº\t\u0083Í\u0019ÑïXô\u001fýÎÂÙÈVÑ\u0001¦Ä¯\u0089µUº\u0018\u0083Çúa\fè\u0017¯\u001e~!i+æ2±EtL3VùY½`v\u0019ÑïXô\u001fýÎÂÙÈVÑ\u0001¦Ä¯\u0081µ^º\u0003\u0083Í\u0019ÑïXô\u001fýÎÂÙÈVÑ\u0001¦Ä¯\u0098µAº\u0019\u0083Ï7*Á£ÚäÓ5ì\"æ\u00adÿú\u0088?\u0081e\u009b°\u0094ð\u00ad:¦m°¼\u0019ÑïXô\u001fýÎÂÙÈVÑ\u0001¦Ä¯±µEº\u0007\u0083Í\u0019ÑïXô\u001býÌÂ\u0097È\u001bÑ\u0016¦ß¯\u0099µBº\u0006\u0083Ç\u0088\u0087\u009e@g\u0011l\u008fuð{d@8I·^´$g-&2û\u008b\u009b}\u001bf^o\u0086P\u0093Z\tCQ4\u0094=À'\t(W\u0011\u0091\u001a\u0083\f,õ[þ\u009eçÇé>ÒqÛ Ìù¶:¿^ µ©è\u0093\"\u0084e\u008d°\u0019ÑïLô\bý×Â\u0095È\u001bÑ\u001b¦ß¯\u009eµCº\u0018\u0083Ü\u0088\u0095ª.\\ºGüNxq,\u0084\u000er\u0093i×`\b_JUÄLÞ;\n2](\u0095'\u009a\u001e\u001a\u0015X\u0003\u008búÎ\f0úçá²è}×3ÝòÄ¸³7º  ê¯¯\u0096e\u009d)\u008bär¸ya`YnÆU\u009c\u0019\u0092ïUô\u0018ýÿÂºÈqÑ!¦ï¯\u008cµ_º\u001e\u0083\u0086\u0088\u0095\u009eK&¯Ð'ËpÂ¥ý§÷'îi\u0099ª\u0090ù\u008a3\u0085K¼µ·÷¡>XyS½JÓDL\u007f\\v\u008baÄ\u0019\u009cïPô\u000fýÝÂ\u0085È@Ñ\u0013¦Ó¯\u0085µ_\u0019ÑïYô\u000eýÛÂÙÈYÑ\u001d¦Å¯\u0080µXº\u0019ñ\u0097\u0007\u001e\u001c]\u0015\u008a*Ñ ]9PN\u0099Gß]\u0004R@k\u0081`Áv\u0006\u008fW\u0084É\u009d¶\u0093>¨l¡ñ¶ñÌ\"ÅdÚ¥Ó¦é2þa÷¢\u0019ÑïLô\bý×Â\u0095È\u001bÑ\u0011¦À¯\u009bµEº\u0004\u0083Î\u0088\u0089\u0084Jr iå`/_cU®Lò;+ZE¬Ì·\u008f¾X\u0081\u0003\u008b\u008f\u0092\u008båMì\töÛùÑÀLË\u0000Ýß$\u0090/]6&8í\u0003½\n#\u001d!gõn´q+xjB·U½\\s§?©¾°»»}\u0082I\u0095\u001a\u009fÁæ\u009aéKð\u0012úÒÍÊÔWß\u001d!Ó(\u00893[:\u001d\fÓ".getBytes(CharEncoding.ISO_8859_1)).asCharBuffer().get(cArr, 0, 1959);
            _CREATION = cArr;
            _BOUNDARY = -7211251600291532996L;
        }

        /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
            java.util.NoSuchElementException
            	at java.base/java.util.TreeMap.key(Unknown Source)
            	at java.base/java.util.TreeMap.lastKey(Unknown Source)
            	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
            	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
            	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
            */
        public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r65, int r66, int r67, int r68) {
            /*
                Method dump skipped, instruction units count: 15876
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: org.joda.time.DateTimeUtils.OffsetMillisProvider.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
        }
    }

    public static final void setCurrentMillisFixed(long j) throws SecurityException {
        checkPermission();
        cMillisProvider = new FixedMillisProvider(j);
    }

    public static final void setCurrentMillisOffset(long j) throws SecurityException {
        checkPermission();
        if (j == 0) {
            cMillisProvider = SYSTEM_MILLIS_PROVIDER;
        } else {
            cMillisProvider = new OffsetMillisProvider(j);
        }
    }

    public static final void setCurrentMillisProvider(MillisProvider millisProvider) throws SecurityException {
        if (millisProvider == null) {
            throw new IllegalArgumentException("The MillisProvider must not be null");
        }
        checkPermission();
        cMillisProvider = millisProvider;
    }

    private static void checkPermission() throws SecurityException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new JodaTimePermission("CurrentTime.setProvider"));
        }
    }

    public static final long getInstantMillis(ReadableInstant readableInstant) {
        if (readableInstant == null) {
            return currentTimeMillis();
        }
        return readableInstant.getMillis();
    }

    public static final Chronology getInstantChronology(ReadableInstant readableInstant) {
        if (readableInstant == null) {
            return ISOChronology.getInstance();
        }
        Chronology chronology = readableInstant.getChronology();
        return chronology == null ? ISOChronology.getInstance() : chronology;
    }

    public static final Chronology getIntervalChronology(ReadableInstant readableInstant, ReadableInstant readableInstant2) {
        Chronology chronology;
        if (readableInstant != null) {
            chronology = readableInstant.getChronology();
        } else {
            chronology = readableInstant2 != null ? readableInstant2.getChronology() : null;
        }
        return chronology == null ? ISOChronology.getInstance() : chronology;
    }

    public static final Chronology getIntervalChronology(ReadableInterval readableInterval) {
        if (readableInterval == null) {
            return ISOChronology.getInstance();
        }
        Chronology chronology = readableInterval.getChronology();
        return chronology == null ? ISOChronology.getInstance() : chronology;
    }

    public static final ReadableInterval getReadableInterval(ReadableInterval readableInterval) {
        if (readableInterval != null) {
            return readableInterval;
        }
        long jCurrentTimeMillis = currentTimeMillis();
        return new Interval(jCurrentTimeMillis, jCurrentTimeMillis);
    }

    public static final Chronology getChronology(Chronology chronology) {
        return chronology == null ? ISOChronology.getInstance() : chronology;
    }

    public static final DateTimeZone getZone(DateTimeZone dateTimeZone) {
        return dateTimeZone == null ? DateTimeZone.getDefault() : dateTimeZone;
    }

    public static final PeriodType getPeriodType(PeriodType periodType) {
        return periodType == null ? PeriodType.standard() : periodType;
    }

    public static final long getDurationMillis(ReadableDuration readableDuration) {
        if (readableDuration == null) {
            return 0L;
        }
        return readableDuration.getMillis();
    }

    public static final boolean isContiguous(ReadablePartial readablePartial) {
        if (readablePartial == null) {
            throw new IllegalArgumentException("Partial must not be null");
        }
        DurationFieldType type = null;
        for (int i = 0; i < readablePartial.size(); i++) {
            DateTimeField field = readablePartial.getField(i);
            if (i > 0 && (field.getRangeDurationField() == null || field.getRangeDurationField().getType() != type)) {
                return false;
            }
            type = field.getDurationField().getType();
        }
        return true;
    }

    public static final DateFormatSymbols getDateFormatSymbols(Locale locale) {
        try {
            return (DateFormatSymbols) DateFormatSymbols.class.getMethod("getInstance", Locale.class).invoke(null, locale);
        } catch (Exception unused) {
            return new DateFormatSymbols(locale);
        }
    }

    public static final Map<String, DateTimeZone> getDefaultTimeZoneNames() {
        AtomicReference<Map<String, DateTimeZone>> atomicReference = cZoneNames;
        Map<String, DateTimeZone> map = atomicReference.get();
        if (map != null) {
            return map;
        }
        Map<String, DateTimeZone> mapBuildDefaultTimeZoneNames = buildDefaultTimeZoneNames();
        return !PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, mapBuildDefaultTimeZoneNames) ? atomicReference.get() : mapBuildDefaultTimeZoneNames;
    }

    public static final void setDefaultTimeZoneNames(Map<String, DateTimeZone> map) {
        cZoneNames.set(Collections.unmodifiableMap(new HashMap(map)));
    }

    private static Map<String, DateTimeZone> buildDefaultTimeZoneNames() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        DateTimeZone dateTimeZone = DateTimeZone.UTC;
        linkedHashMap.put("UT", dateTimeZone);
        linkedHashMap.put("UTC", dateTimeZone);
        linkedHashMap.put(TimeZones.GMT_ID, dateTimeZone);
        put(linkedHashMap, "EST", "America/New_York");
        put(linkedHashMap, "EDT", "America/New_York");
        put(linkedHashMap, "CST", "America/Chicago");
        put(linkedHashMap, "CDT", "America/Chicago");
        put(linkedHashMap, "MST", "America/Denver");
        put(linkedHashMap, "MDT", "America/Denver");
        put(linkedHashMap, "PST", "America/Los_Angeles");
        put(linkedHashMap, "PDT", "America/Los_Angeles");
        return Collections.unmodifiableMap(linkedHashMap);
    }

    private static void put(Map<String, DateTimeZone> map, String str, String str2) {
        try {
            map.put(str, DateTimeZone.forID(str2));
        } catch (RuntimeException unused) {
        }
    }

    public static final long toJulianDayNumber(long j) {
        return (long) Math.floor(toJulianDay(j) + 0.5d);
    }

    static class SystemMillisProvider implements MillisProvider {
        SystemMillisProvider() {
        }

        @Override // org.joda.time.DateTimeUtils.MillisProvider
        public long getMillis() {
            return System.currentTimeMillis();
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    static class FixedMillisProvider implements MillisProvider {
        private final long iMillis;

        FixedMillisProvider(long j) {
            this.iMillis = j;
        }

        @Override // org.joda.time.DateTimeUtils.MillisProvider
        public long getMillis() {
            return this.iMillis;
        }
    }
}
