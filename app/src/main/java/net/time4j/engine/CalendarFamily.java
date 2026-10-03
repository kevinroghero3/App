package net.time4j.engine;

import android.graphics.Color;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import net.time4j.engine.CalendarVariant;
import o.ArtificialStackFrames;
import o._CREATION;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes3.dex */
public final class CalendarFamily<T extends CalendarVariant<T>> extends Chronology<T> {
    private final Map<String, ? extends CalendarSystem<T>> calendars;

    @Override // net.time4j.engine.Chronology
    public boolean hasCalendarSystem() {
        return true;
    }

    /* synthetic */ CalendarFamily(Class cls, ChronoMerger chronoMerger, Map map, List list, Map map2, AnonymousClass1 anonymousClass1) {
        this(cls, chronoMerger, map, list, map2);
    }

    private CalendarFamily(Class<T> cls, ChronoMerger<T> chronoMerger, Map<ChronoElement<?>, ElementRule<T, ?>> map, List<ChronoExtension> list, Map<String, ? extends CalendarSystem<T>> map2) {
        super(cls, chronoMerger, map, list);
        this.calendars = map2;
    }

    @Override // net.time4j.engine.Chronology
    public CalendarSystem<T> getCalendarSystem() {
        throw new ChronoException("Cannot determine calendar system without variant.");
    }

    /* JADX INFO: renamed from: net.time4j.engine.CalendarFamily$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        private static long _BOUNDARY;
        private static char[] _CREATION;
        private static final byte[] $$c = {53, 69, 94, -115};
        private static final int $$d = 212;
        private static int $10 = 0;
        private static int $11 = 1;
        private static final byte[] $$a = {110, 48, -111, -89, 3, -46, -10, -16, 6, Ascii.CR, -10, 9, 1, -16, 53, -52, Ascii.SO, 2, -21, 0, 4, 9, -18, Ascii.DC4};
        private static final int $$b = 94;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;

        private static String $$e(int i, int i2, int i3) {
            int i4 = i * 2;
            int i5 = 3 - (i2 * 3);
            int i6 = i3 + b.i;
            byte[] bArr = $$c;
            byte[] bArr2 = new byte[i4 + 1];
            int i7 = -1;
            if (bArr == null) {
                i7 = -1;
                i6 = (-i5) + i6;
                i5 = i5;
            }
            while (true) {
                int i8 = i7 + 1;
                bArr2[i8] = (byte) i6;
                int i9 = i5 + 1;
                if (i8 == i4) {
                    return new String(bArr2, 0);
                }
                i7 = i8;
                i6 = (-bArr[i9]) + i6;
                i5 = i9;
            }
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0021  */
        /* JADX WARN: Code duplicated, block: B:8:0x0019  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0025). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static void a(byte r5, int r6, short r7, java.lang.Object[] r8) {
            /*
                byte[] r0 = net.time4j.engine.CalendarFamily.AnonymousClass1.$$a
                int r1 = 4 - r7
                int r6 = r6 + 66
                int r5 = r5 + 4
                byte[] r1 = new byte[r1]
                int r7 = 3 - r7
                r2 = 0
                if (r0 != 0) goto L13
                r6 = r5
                r4 = r7
                r3 = r2
                goto L25
            L13:
                r3 = r2
            L14:
                byte r4 = (byte) r6
                r1[r3] = r4
                if (r3 != r7) goto L21
                java.lang.String r5 = new java.lang.String
                r5.<init>(r1, r2)
                r8[r2] = r5
                return
            L21:
                r4 = r0[r5]
                int r3 = r3 + 1
            L25:
                int r5 = r5 + 1
                int r4 = -r4
                int r6 = r6 + r4
                int r6 = r6 + (-1)
                goto L14
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.engine.CalendarFamily.AnonymousClass1.a(byte, int, short, java.lang.Object[]):void");
        }

        private static void b(char c, int i, int i2, Object[] objArr) throws Throwable {
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
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "", 0) + 8, (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 9280), 1978 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 1113883676, false, $$e(b, b2, (byte) (b2 + 1)), new Class[]{Integer.TYPE});
                    }
                    Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i4), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 0;
                        byte b4 = b3;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(Process.getGidForName("") + 31, (char) (View.getDefaultSize(0, 0) + 49362), 683 - ((byte) KeyEvent.getModifierMetaStateMask()), -115095555, false, $$e(b3, b4, (byte) (b4 + 3)), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                    }
                    jArr[i4] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                    Object[] objArr4 = {_creation, _creation};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                    if (objAccessartificialFrame3 == null) {
                        byte b5 = (byte) 0;
                        byte b6 = b5;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(26 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (Color.alpha(0) + 30068), TextUtils.indexOf((CharSequence) "", '0') + 817, 1897803493, false, $$e(b5, b6, b6), new Class[]{Object.class, Object.class});
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
            int i5 = $10 + 27;
            $11 = i5 % 128;
            int i6 = i5 % 2;
            while (_creation.b < i2) {
                int i7 = $11 + 47;
                $10 = i7 % 128;
                if (i7 % 2 != 0) {
                    cArr[_creation.b] = (char) jArr[_creation.b];
                    try {
                        Object[] objArr5 = {_creation, _creation};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-293902099);
                        if (objAccessartificialFrame4 == null) {
                            byte b7 = (byte) 0;
                            byte b8 = b7;
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(25 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) (30068 - ExpandableListView.getPackedPositionType(0L)), 816 - (KeyEvent.getMaxKeyCode() >> 16), 1897803493, false, $$e(b7, b8, b8), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                        int i8 = 45 / 0;
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                } else {
                    cArr[_creation.b] = (char) jArr[_creation.b];
                    Object[] objArr6 = {_creation, _creation};
                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-293902099);
                    if (objAccessartificialFrame5 == null) {
                        byte b9 = (byte) 0;
                        byte b10 = b9;
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation((Process.myPid() >> 22) + 25, (char) (30068 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1))), MotionEvent.axisFromString("") + 817, 1897803493, false, $$e(b9, b10, b10), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame5).invoke(null, objArr6);
                }
            }
            objArr[0] = new String(cArr);
        }

        static {
            char[] cArr = new char[1959];
            ByteBuffer.wrap("Ì½|õ¬ñÜí\f±¼úìï\u001cëLîüï,å\\À\u008cÞ<êlÙ\u009cÛÌÆ|Ó¬ÁÜØ\fÝ¼òì£\u001c§L»üº,¹téÄ¡\u0014¥d¹´å\u0004®T»¤¿ôºD»\u0094±ä\u00944\u008a\u0084¾Ô\u009c$\u0082t\u0086Ä\u0090\u0014¯d\u009b´\u008a\u0004\u008bTç¤÷ôê\u0019Ñ©\u0099y\u009d\t\u0081ÙÝi\u00969\u0083É\u0087\u0099\u0082)\u0083ù\u0089\u0089¬Y²é\u0086¹§Iª\u0019 ©®ÀÛp\u0084 \u008bÐ\u008e\u0000×°\u0096à\u0089\u0010\u0085@\u0099ð\u0083 \u008fPú\u0080·0¼`²\u0090½À¢p® ±Ð¥\u0000\u0097°©à×\u0010Å@ÈðÚ ÈPÜ{ËË\u0082\u001b\u0096k\u008e»Ç\u000b\u008f[\u0091«ßû\u008cK\u008d\u009b\u0095ëµ\u0011æ¡¯q»\u0001£Ñêaµ1²Á±\u0091ÿ!¢ñ¥\u0081\u0087Q\u009d\u0019Ñ©\u008ey\u009c\t\u0094Ù\u0093i\u00839\u0088ÉÄ\u0099´)£ù\u00ad\u0089°Y¬é¼¹\u0090I²\u0019º©¬\u0019Ñ©\u0099y\u0099\t\u0083Ù\u0093iÞ9ÂÉ\u0088\u0099\u0096)\u0090ù\u0089\u0089±Y¼é¶Ð\u008c`\u0092°ÖÀ\u0095\u0010\u009d \u009eð\u0098\u0000ÅP\u0094à\u00800\u0084@\u00ad\u0090µ °p°\u0080\u008cÐ `¨°¼À\u0098\u0010¦ ¯ðÏ\u0000\u008aÁ\u0015q\u000b¡OÑ\f\u0001\u0004±\u0007á\u0001\u0011\\A\rñ\u0019!\u001dQ4\u0081,1)a)\u0091\u0015Á9q1¡%Ñ\u0001\u0001?±6áV\u0011\u0010\u0019Ñ©\u008ey\u0081\t\u0084Ù\u0086i\u00949\u0081ÉÄ\u0099\u008a)\u008cù\u0082\u0089ðY¶é°¹¶I½\u0019¬©ãy»\t¨\u0019\u009c©\u0094y\u009f\t\u0099Ù\u009di\u0089!`\u0091~\u0019Ñ©\u008ey\u0081\t\u0084Ù\u0086i\u00949\u0081ÉÄ\u0099\u0084)\u008cù\u008e\u0089ðY´é¼¹¹I¦\u0019\u0098©\u0080yå\t©Ù§i¬9ÉÉ\u0096\u0099Õ)ÚùÞ\u0089ÛYØéÆ¹È\u009d·-èýç\u008dâ]àíò½çM¢\u001dâ\u00adê}è\r\u0096ÝÒmÚ=ßÍÀ\u009dþ-æý\u0083\u008dÑ]ÖíÈ½ªvAÆ\u001e\u0016\u0011f\u0014¶\u0016\u0006\u0004V\u0011¦Tö\u001aF\u001c\u0096\u0012æ`6&\u0086 Ö&&-v;Æ0\u0016-f\u0001¶\u001f\u0006!V^¦DöVF\u000b\u0096SæP\u0099ì)¤ù \u0089¼Yàé¢¹´I»\u0019®©¿y¨\t\u0087Ù\u0094i\u0090*\u0013\u009a\rJI:\nê\u0018Z\u0007\n\u001fú\u0010ªW\u001a\u0012Ê\u0010º3j1\u0019\u0090©\u0098y\u0099\t\u0084Ù\u0097iß9\u0082É\u008e\u0099\u0092LËü\u0097,\u0090\\\u0082\u008c\u008b<Äl\u0090\u009c\u0098Ì\u0090|\u009a¬\u0089Ü¼\f³¼·ì«\u001c¤L§õ¥E\u00ad\u0095 å·5´\u0085¢\u0019\u008c©\u0092yÖ\t\u0087Ù\u0080i\u009e9\u0088É\u009e\u0099\u0085)\u0091ùÎ\u0089²Y»é·¹¡Iµ\u0019¯©®y¼\t²Ù°i¤9Î\u0013~£\u007fsq\u0003i\u0019\u008e©\u0098y\u008a\t\u0084Ù\u009bi\u00829\u0098ÉÅ\u0099\u0095)\u009cù\u0093\u0089ñY¸é½¹úI·\u0019«©¯y½\t Ùìi¦9ÌÉÎ\u0099\u0098)ÓùÑ\u0089ÄYÏéö¹ÃIÓ\u0019ë©Âyê\tòÙüiõ9éÉù\u0099ã)÷\u0019\u008e©\u0098y\u008a\t\u0084Ù\u009bi\u00829\u0098ÉÅ\u0099\u0095)\u009cù\u0093\u0089ñY¸é½¹úI·\u0019«©¯y½\t Ùìi¦9ÌÉÎ\u0099\u0098)ÓùÑ\u0089ÄYÏéö¹ÃIÓ\u0019ë©Âyî\tòÙüiõ9ãÉùþ\u0082N\u0094\u009e\u0086î\u0088>\u0097\u008e\u008eÞ\u0094.É~\u0099Î\u0090\u001e\u009fný¾´\u000e±^ö®»þ§N£\u009e±î¬>à\u008e¿Þß.\u0099~ÙÎÈ\u001eÕ7\u0007\u0087\u0011W\u0003'\r÷\u0012G\u000b\u0017\u0011çL·\u001c\u0007\u0015×\u001a§xw1Ç4\u0097sg>7\"\u0087&W4')÷eG:\u0017Zç\u001c·S\u0007]×ZtÛÄÍ\u0014ßdÑ´Î\u0004×TÍ¤\u0090ôÀDÉ\u0094Æä¤4í\u0084èÔ¯$âtþÄú\u0014èdõ´¹\u0004æT\u0086¤Àô\u008eD\u0083\u0094\u0086\u0019\u008e©\u0098y\u008a\t\u0084Ù\u009bi\u00829\u0098ÉÅ\u0099\u0095)\u009cù\u0093\u0089ñY¸é½¹úI·\u0019«©¯y½\t Ùìi³9ÓÉ\u0095\u0099Û)ÛùÓ\u0094B$Uô]\u0084ETKä]-Y\u009d\u0005M\u0002=\u0010í\u0019]V\r\tý\f\u00ad\n\u001d\u0018Í\u0004½2m!\u0019\u0088©\u009fy\u0097\t\u008fÙ\u0095i\u00849\u0089É\u0098\u0099\u0092¸X\byØw¨ox~È\u007f\u0098yhc8h\u0088jà\u008dP\u0095\u0080\u0095ð\u009f \u009b\u0090\u0080À\u0084Óìcä³ûÃé\u0013î£éóè\u0003÷§H\u0017VÇ\u0012·CgD×Z\u0087LwZ'A\u0097UG\n7\u007fç{Wk\u0007y÷t§o\u0019\u0088©\u009fy\u0097\t\u008fÙÊiÇ9\u009c\u0019\u0099©\u0098y\u0096\t\u0092Ù\u0080i\u00989\u008f*C\u009aBJL:HêZZB\nUúnªD\u001a\u0007Ê\f¤[\u0014ZÄT´PdBÔZ\u0084Mtv$\\\u0094\u001fD\u00144Bä.T/rþÂà\u0012¤bõ²ò\u0002ìRú¢ìò÷Bã\u0092¼âÀ2Ç\u0082ÏÒÃ\"Íb@ÒT\u0002^\u0019\u009b©\u0090y\u008d\t\u009bÙ\u0093i\u00859\u0083É\u0099\u0019¿©\u008dy\u0088\t×Ù i\u00849\u0082É\u009f\u0099\u008f)\u0088ù\u0085\u0089ÿY¼é¶¹¦Ió\u0019\u008d©¥yº\t¨Ù¯i¤\u0019¿©\u0093y\u009c\t\u0085Ù\u009di\u00989\u0088ÉË\u0099µ)¡ù«\u0089ÿY¸é¬¹½I¿\u0019º©íy®\t¨Ù°iá9ÄÉ\u0083\u0099\u0080\u0019¿©\u0093y\u009c\t\u0085Ù\u009di\u00989\u0088ÉË\u0099µ)¡ù«\u0089ÿY¸é¬¹½I¿\u0019º©íy®\t¨Ù°iá9ÄÉ\u0083\u0099\u0080)êù\u0086\u0089\u009bÃssm£)Ó`\u0003l³|ãw\u0013cCxóh#z\u0019\u0099©\u0092y\u0094\t\u0093Ù\u0094i\u00989\u009fÉ\u0083i\u0086Ù\u0091\t\u0099y\u0081©Ä\u0019Éý¤M´\u009d¾í¼=²\u008d¬\u0019\u008c©\u0092yÖ\t\u0087Ù\u0080i\u009e9\u0088É\u009e\u0099\u0085)\u0091ùÎ\u0089½Y¨é¸¹ºI·éKYU\u0089\u0011ù[)P\u0099DÉE9IiMÙ\f\tVy}©p\u0019k\u0010\u000bÆpvn¦*Öx\u0006k¶næe\u0016eF\u007f\u0019Î\u0019\u008c©\u0092yÖ\t\u0095Ù\u0087i\u00989\u0080É\u008f\u0099È)\u0095ù\u0092\u0089°Y¾é¬¹·I§\u0019\u0098©\u0088y\u0094\t\u009bÙ\u00adi\u00899ÔÉÝ\u008aÒ:Ìê\u0088\u009aËJÙúÆªÞZÑ\n\u0096ºÝj×\u001aïÊãzâ*øÚý\u008aâ:úêø\u009aí*\u0090\u009a\u0091J\u009f:\u009bê\u0089Z\u0091\n\u0086úÍª\u009c\u001a\u0088Ê\u0082ºùj´Úµ\u008a³z¿*µ\u009a\u00adJ¢\u0019\u0099©\u0098y\u0096\t\u0092Ù\u0080i\u00989\u008fÉ´\u0099\u009e)ÝùÖ\u0089ðY©é½¹¿I\u008c\u0019¶©õyþ\tèÙ¥i¤9ÒÉÞ\u0099Ä)ÜùÓ\u0089ðYÒé\u0091¹\u0092Ùúiû¹õÉñ\u0019ã©ûùì\t§Yâéé9ìIÛ\u0099Õ)ßyè\u0089ÃÙÉiÅ¹\u0084ÉÃ\u0019Ä©Ìùº\tªY¼éµlvÜw\fy|}¬o\u001cwL`¼+ì\u007f\\h\u008c`üH,\r\u009c\u0000ÌK<\u0013lWÜ@\fH|P¬\u0015\u001c\u0018L#\u0019\u0099©\u0092y\u0097\t\u0090Ù\u009ei\u00949ÃÉ\u0098\u0099\u0082)\u008eù¿\u0089¸Yªé±¹»I½\u0019«©\u0092y°\tÿÙôiî9ÛÉÞ\u0099Ø)ÐùÂ\u0089ÆYÉéö¹ÜI\u009b\u0019¨HÅøÛ(\u009fXÜ\u0088Ô8×hÑ\u0098ÎÈÀxÍ¨ÍØó\bá:Â\u008aÜZ\u0098*ÛúÓJÐ\u001aÖêÌºÅ\nÊÚÉªôzºÊõ\u009aïjô:ì\u008açZ¨*ïúåJá\u001a\u0095ê\u0090º\u008a\n\u008bÚ\u008cª\u0088z\u008aÊ\u0093\u0019¿©\u0093y\u009c\t\u0085Ù\u009di\u00989\u0088ÉÆ\u0099\u009e)ÝùÖ·v\u0007h×,§ow}Çb\u0097zgu72\u0087{Ws'V÷PGO\u0017OçP·\u001a\u0007^×V\u0085\u009a5\u0088å\u009b\u0095\u0093EÏ\u0083p3tãv\u0093dC;óe£}So\u0003/³scb\u0013UÃHs\u0013#CÓF\u0083F3Zã\\\u0019\u008f©\u0098y\u0095\t\u0082ÙÜi\u00999\u009bÉÅ\u0099\u008b)\u0084ù\u0089\u0089±Y±é¼¹\u00adI \u0019\u008f©\u0098y\u0095\t\u0082ÙÜi\u00829\u008aÉÅ\u0099\u0080)\u0084ù\u008b\u0089ºY\u0085éº¹µI¾\u0019«©¿y©û\u0017K\u0000\u009b\rë\u001a;D\u008b\u001aÛ\u0012+]{\u0012Ë\u001e\u001b\u001ck\u0018»&\u000b$[\"«8û?K!\u009b)\u0019\u008c©\u0092yÖ\t\u009cÙ\u0097i\u00839\u0082É\u008e\u0099\u008a)Ëù\u0081\u0089±Y¾é«¹»Iº\u0019ª©ãy¹\t¢Ù¯i´9Ø\u0019\u008c©\u0092yÖ\t\u0095Ù\u009di\u009e9\u0098ÉÅ\u0099\u0097)\u0080ù\u008d\u0089ªYôé¸¹¢I·\u0019\u0091©£y©\tªÙ§\u0019\u008c©\u0092yÖ\t\u0098Ù\u0096i\u009c9ÂÉ\u0089\u0099\u0093)\u008cù\u008c\u0089»Yôé¿¹½I½\u0019©©¨yº\t·Ù°i¨9ÒÉÏ\u0019\u008c©\u0092yÖ\t\u0087Ù\u0080i\u009e9\u0088É\u009e\u0099\u0085)\u0091ùÎ\u0089½Y¯é°¹¸I·\u0019à©«y¡\t©Ù¥i¤9ÎÉË\u0099Ä)ÜùÞ\u0089ÛÊ\u0096z\u0088ªÌÚ\u009e\n\u0091º\u0098ê\u0082\u001a\u0094J\u0091úÑ*\u0098Z°\u008a©:¯jª\u009açÊ²z¾ª¼Úº\n½º©êÖ\u001aÓJÅúÁ*Þ#\u0097\u0093\u0089CÍ3\u009fã\u0090S\u0099\u0003\u0083ó\u0095£\u0090\u0013¡Ã\u009e³¼cµÓì\u0083\u00ads½#¼\u0093ºC·3òã¿S³\u0003ÉóÇ£È\u0013ÜÃÛ³ÆcØÓÜ\u0083Ë[øëæ;¢Kõ\u009bã+ë{ü\u008bðÛàk¿»öËÞ\u001bÇ«ÁûÄ\u000b\u0089[ÜëÐ;ÒKÔ\u009bÓ+Ç{¸\u008b½Û«k¯»°fÔÖÊ\u0006\u008evÙ¦Ï\u0016ÇFÐ¶ÜæÌVâ\u0086Üöë&é\u0096ìÆ¢6éfãÖü\u0006üvû¦´\u0016ÿF\u008d¶\u008dæ\u0089V\u0088\u0086\u009aö\u0087&\u0080\u0096\u0098Æ\u00926\u008f,Ì\u0019Ñ©\u0099y\u009d\t\u0081ÙÝi\u00809\u0089É\u0086\u0099\u0093)ºù\u0090\u0089¶Yªé¼r¾Âö\u0012òbî²²\u0002íRì¢çòâBï\u0092ûâ\u009f2×\u0082×ÒÈ\"ÙrÃÂÃ\u0012ÉbÌ²ò\u0002ÉR¶¢ºò B¾\u0019Ñ©\u0099y\u009d\t\u0081ÙÝi\u00829\u0083É\u0088\u0099\u008d)\u0080ù\u0094\u0089ðY½é¼¹ºIª\u0019ª\u0019Ñ©\u0099y\u009d\t\u0081ÙÝi\u00829\u0083É\u0088\u0099\u008d)\u0080ù\u0094\u0089ðY«é¼¹¹I¦\u0019ª\u0019Ñ©\u008ey\u0081\t\u0084ÙÝi\u00809\u0089É\u0086\u0099\u0093)ºù\u0094\u0089\u00adY»éº¹±éçY¸\u0089·ù²)°\u0099¢É·9òi¼Ùº\t´yÆ©\u0080\u0019\u0086I\u0080¹\u0086é§Y\u0096\u0089\u009fù\u009d)\u0098\u0099\u0098Éé9ÒiäÙæ\täyì©û\u0019ÀIã¹ðéÅYÞ\u0089\u0080ùÒ)Ë\u0001Ð±\u0098a\u009c\u0011\u0080ÁÜq\u0092!\u009eÑ\u009e\u0081¸1\u0083á\u0091\u0091\u00ad\u0019Ñ©\u0099y\u009d\t\u0081ÙÝi\u00939\u009fÉ\u009f\u0099¹)\u0091ù\u0089\u0089²Y¿\u001eÕ®\u009d~\u0099\u000e\u0085ÞÙn\u0086>\u0087Î\u008c\u009e\u0089.\u0084þ\u0090\u008eô^¼î®¾¤N±\u001e¥®¥~¨\u000e¦Þ´n¡\u0019Ñ©\u008ey\u0081\t\u0084Ù\u0086i\u00949\u0081ÉÄ\u0099\u008a)\u008cù\u0082\u0089ðY¶é°¹¶I±\u0019½©¹y®\t¨Ù®i¥9ÙÉÉ\u0099é)ßùÞ\u0089ÆY\u0084éÚ¹Ë³ª\u0003âÓæ£ús¦Ãè\u0093äcä3ü\u0083ýSø#Á±©\u0001áÑå¡ùq¥Áë\u0091çaç1ù\u0081äQê!È\u0019Ñ©\u0099y\u009d\t\u0081ÙÝi\u00939\u009fÉ\u009f\u0099\u008b)\u0080ù\u0087\u0089±\u001có¬»|¿\f£Üÿl±<½Ì½\u009c«,µü«\u008c\u0098\u000e¶¾þnú\u001eæÎº~ô.øÞø\u008e÷>ïîô\u009eßÛ\nkB»FËZ\u001b\u0006«HûD\u000bD[MëY;ZKm\u009bq+a\u0007`·(g,\u00170Çlw\"'.×.\u0087\b7=ç<\u0097\u000b\u0019Ñ©\u0099y\u0099\t\u0083Ù\u0093iÞ9\u0088É\u0084\u0099\u0091)\u008bù\u008c\u0089°Y»é½¹§Iü\u0019à©µyª\tèÙ i²9ÈÉÐ\u0019Ñ©\u0090y\u0096\t\u0083ÙÝi\u00869\u0085É\u0085\u0099\u0082)\u008aù\u0097\u0089¬Yõé\u009b¹§I§\u0019\u009d©¥y©\tµÙ§i¥9úÉÔ\u0099Ú)ÑùÕ\u0089Ý\u0019Ñ©\u008dy\u008a\t\u0098Ù\u0091iÞ9\u0085É\u0084\u0099\u0096)\u008aù\u0092\u0089«Y©\u0019Î©\u009by\u009e\t×ÙÈ\u009e,.pþw\u008ee^lî#¾bNs\u001ew®~~2\u000eOÞFnT>Z\u0019\u0099©\u008fy\u0099\t\u009bÙ\u009ei\u009e9\u008fÉÅ\u0099\u0081)\u008aù\u008c\u0089»Y¼é°¹§I»\u0019à©¾y§\u0019\u0092©\u0094y\u009a\t°Ù¾i´9¿É´\u0099\u0084)\u0096ù\u0094\u0089ñY©é¶\u0019Ñ©\u0098y\u008c\t\u0094ÙÝi\u009c9\u0089É\u008f\u0099\u008f)\u0084ù¿\u0089¼Yµé½¹±I°\u0019½©ãy°\tªÙ®\u0019\u009c©\u0091y\u008d\t\u0092Ù\u0081i\u00859\u008dÉ\u0088\u0099\u008d)\u0096G?÷v'bWz\u008737rgm\u0097pÇfw\u007f§}×\u0015g]·]ÇG\u0017W§\u001a÷L\u0007@WUçO7HGt\u0097\u007f'ywc\u00878×$gm·|Ç,\u0017g§u÷\b\u0007\fW\\ç\t7\u0019G\u0007\u0019Ñ©\u008dy\u008a\t\u0098Ù\u0091iÞ9\u008fÉ\u009b\u0099\u0093)\u008cù\u008e\u0089¹Yµ\u0019¹©\u0092y\u0094\t\u0093Ù\u0094i\u00989\u009fÉ\u0083\u001e\b®@~@\u000eZÞJn\u0007>XÎ[\u009eL._þ\u0016\u008ev^qîo¾kNc\u001e{®q~b\u000e1Þxnm>\u0017ÎM\u009e_.Cþ\n\u008e\u0019^\u001eî^¾\u0010N\u0013\u001e$®6~.\u000e8Þ\"n:>!Î|\u009e2.9þ4\u008eÓ^ÊîÍ¾È".getBytes(CharEncoding.ISO_8859_1)).asCharBuffer().get(cArr, 0, 1959);
            _CREATION = cArr;
            _BOUNDARY = -4468001331287381507L;
        }

        /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
            java.util.NoSuchElementException
            	at java.base/java.util.TreeMap.key(Unknown Source)
            	at java.base/java.util.TreeMap.lastKey(Unknown Source)
            	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
            	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
            	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
            */
        public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r61, int r62, int r63, int r64) {
            /*
                Method dump skipped, instruction units count: 15271
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.engine.CalendarFamily.AnonymousClass1.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
        }
    }

    @Override // net.time4j.engine.Chronology
    public CalendarSystem<T> getCalendarSystem(String str) {
        if (str.isEmpty()) {
            return getCalendarSystem();
        }
        CalendarSystem<T> calendarSystem = this.calendars.get(str);
        return calendarSystem == null ? super.getCalendarSystem(str) : calendarSystem;
    }

    public TimeLine<T> getTimeLine(String str) {
        return new CalendarTimeLine(this, str, null);
    }

    public TimeLine<T> getTimeLine(VariantSource variantSource) {
        return getTimeLine(variantSource.getVariant());
    }

    @Override // net.time4j.engine.Chronology
    public boolean isSupported(ChronoElement<?> chronoElement) {
        return super.isSupported(chronoElement) || (chronoElement instanceof EpochDays);
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class Builder<T extends CalendarVariant<T>> extends Chronology.Builder<T> {
        private final Map<String, ? extends CalendarSystem<T>> calendars;

        private Builder(Class<T> cls, ChronoMerger<T> chronoMerger, Map<String, ? extends CalendarSystem<T>> map) {
            super(cls, chronoMerger);
            if (map.isEmpty()) {
                throw new IllegalArgumentException("Missing calendar variants.");
            }
            this.calendars = map;
        }

        public static <T extends CalendarVariant<T>> Builder<T> setUp(Class<T> cls, ChronoMerger<T> chronoMerger, Map<String, ? extends CalendarSystem<T>> map) {
            return new Builder<>(cls, chronoMerger, map);
        }

        @Override // net.time4j.engine.Chronology.Builder
        public <V> Builder<T> appendElement(ChronoElement<V> chronoElement, ElementRule<T, V> elementRule) {
            super.appendElement((ChronoElement) chronoElement, (ElementRule) elementRule);
            return this;
        }

        @Override // net.time4j.engine.Chronology.Builder
        public Builder<T> appendExtension(ChronoExtension chronoExtension) {
            super.appendExtension(chronoExtension);
            return this;
        }

        @Override // net.time4j.engine.Chronology.Builder
        public CalendarFamily<T> build() {
            CalendarFamily<T> calendarFamily = new CalendarFamily<>(this.chronoType, this.merger, this.ruleMap, this.extensions, this.calendars, null);
            Chronology.register(calendarFamily);
            return calendarFamily;
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    static class CalendarTimeLine<D extends CalendarVariant<D>> implements TimeLine<D>, Serializable {
        private final transient CalendarSystem<D> calsys;
        private final Class<D> chronoType;
        private final String variant;

        @Override // net.time4j.engine.TimeLine
        public boolean isCalendrical() {
            return true;
        }

        /* synthetic */ CalendarTimeLine(Chronology chronology, String str, AnonymousClass1 anonymousClass1) {
            this(chronology, str);
        }

        private CalendarTimeLine(Chronology<D> chronology, String str) {
            this.calsys = chronology.getCalendarSystem(str);
            this.chronoType = chronology.getChronoType();
            this.variant = str;
        }

        @Override // net.time4j.engine.TimeLine
        public D stepForward(D d) {
            if (d.getDaysSinceEpochUTC() == this.calsys.getMaximumSinceUTC()) {
                return null;
            }
            return (D) d.plus(CalendarDays.ONE);
        }

        @Override // net.time4j.engine.TimeLine
        public D stepBackwards(D d) {
            if (d.getDaysSinceEpochUTC() == this.calsys.getMinimumSinceUTC()) {
                return null;
            }
            return (D) d.minus(CalendarDays.ONE);
        }

        @Override // java.util.Comparator
        public int compare(D d, D d2) {
            long daysSinceEpochUTC = d.getDaysSinceEpochUTC();
            long daysSinceEpochUTC2 = d2.getDaysSinceEpochUTC();
            if (daysSinceEpochUTC < daysSinceEpochUTC2) {
                return -1;
            }
            return daysSinceEpochUTC > daysSinceEpochUTC2 ? 1 : 0;
        }

        @Override // java.util.Comparator
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CalendarTimeLine)) {
                return false;
            }
            CalendarTimeLine calendarTimeLine = (CalendarTimeLine) obj;
            return this.chronoType == calendarTimeLine.chronoType && this.variant.equals(calendarTimeLine.variant);
        }

        public int hashCode() {
            return this.chronoType.hashCode() + (this.variant.hashCode() * 31);
        }

        private Object readResolve() throws ObjectStreamException {
            return new CalendarTimeLine(Chronology.lookup(this.chronoType), this.variant);
        }
    }
}
