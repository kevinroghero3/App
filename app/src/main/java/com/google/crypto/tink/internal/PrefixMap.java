package com.google.crypto.tink.internal;

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
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.FrameMetricsAggregator;
import androidx.recyclerview.widget.ItemTouchHelper;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.common.base.Ascii;
import com.google.crypto.tink.ConfigurationV0$1$$ExternalSyntheticLambda9;
import com.google.crypto.tink.util.Bytes;
import com.google.errorprone.annotations.Immutable;
import com.google.logging.type.LogSeverity;
import com.salesforce.marketingcloud.analytics.stats.b;
import com.transistorsoft.locationmanager.location.TSLocationManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import o.ArtificialStackFrames;
import o._CREATION;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes2.dex */
@Immutable
public final class PrefixMap<P> {
    private static final Bytes EMPTY_BYTES = Bytes.copyFrom(new byte[0]);
    private final Map<Bytes, List<P>> entries;

    public static class Builder<P> {
        private static long _BOUNDARY;
        private static char[] _CREATION;
        private final Map<Bytes, List<P>> entries = new HashMap();
        private static final byte[] $$c = {32, Ascii.FF, 47, 51};
        private static final int $$d = 3;
        private static int $10 = 0;
        private static int $11 = 1;
        private static final byte[] $$a = {67, 87, 59, -10, -2, 47, Ascii.VT, 17, -5, Ascii.SYN, 1, -3, -8, 19, -19, -52, 0, 17, 53, -13, -1, -53, -12, Ascii.VT, -8};
        private static final int $$b = 71;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;

        /* JADX WARN: Code duplicated, block: B:10:0x0022  */
        /* JADX WARN: Code duplicated, block: B:8:0x001c  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0026). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$e(short r5, int r6, short r7) {
            /*
                int r7 = 106 - r7
                int r6 = r6 * 3
                int r6 = r6 + 4
                int r5 = r5 * 3
                int r0 = 1 - r5
                byte[] r1 = com.google.crypto.tink.internal.PrefixMap.Builder.$$c
                byte[] r0 = new byte[r0]
                r2 = 0
                int r5 = 0 - r5
                if (r1 != 0) goto L16
                r4 = r5
                r3 = r2
                goto L26
            L16:
                r3 = r2
            L17:
                byte r4 = (byte) r7
                r0[r3] = r4
                if (r3 != r5) goto L22
                java.lang.String r5 = new java.lang.String
                r5.<init>(r0, r2)
                return r5
            L22:
                r4 = r1[r6]
                int r3 = r3 + 1
            L26:
                int r6 = r6 + 1
                int r4 = -r4
                int r7 = r7 + r4
                goto L17
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.internal.PrefixMap.Builder.$$e(short, int, short):java.lang.String");
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0023  */
        /* JADX WARN: Code duplicated, block: B:8:0x001b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0027). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static void b(byte r5, int r6, short r7, java.lang.Object[] r8) {
            /*
                byte[] r0 = com.google.crypto.tink.internal.PrefixMap.Builder.$$a
                int r6 = r6 + 4
                int r1 = 4 - r7
                int r5 = 115 - r5
                byte[] r1 = new byte[r1]
                int r7 = 3 - r7
                r2 = 0
                if (r0 != 0) goto L13
                r4 = r5
                r5 = r7
                r3 = r2
                goto L27
            L13:
                r3 = r2
            L14:
                byte r4 = (byte) r5
                int r6 = r6 + 1
                r1[r3] = r4
                if (r3 != r7) goto L23
                java.lang.String r5 = new java.lang.String
                r5.<init>(r1, r2)
                r8[r2] = r5
                return
            L23:
                r4 = r0[r6]
                int r3 = r3 + 1
            L27:
                int r5 = r5 + r4
                int r5 = r5 + (-2)
                goto L14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.internal.PrefixMap.Builder.b(byte, int, short, java.lang.Object[]):void");
        }

        public Builder<P> put(Bytes bytes, P p) throws GeneralSecurityException {
            List<P> list;
            if (bytes.size() != 0 && bytes.size() != 5) {
                throw new GeneralSecurityException("PrefixMap only supports 0 and 5 byte prefixes");
            }
            if (this.entries.containsKey(bytes)) {
                list = this.entries.get(bytes);
            } else {
                ArrayList arrayList = new ArrayList();
                this.entries.put(bytes, arrayList);
                list = arrayList;
            }
            list.add(p);
            return this;
        }

        public PrefixMap<P> build() {
            return new PrefixMap<>(this.entries);
        }

        /* JADX WARN: Code duplicated, block: B:38:0x01bf  */
        /* JADX WARN: Code duplicated, block: B:39:0x01c0  */
        private static void a(char c, int i, int i2, Object[] objArr) throws Throwable {
            Object obj;
            Throwable cause;
            int i3 = 2;
            int i4 = 2 % 2;
            _CREATION _creation = new _CREATION();
            long[] jArr = new long[i2];
            _creation.b = 0;
            int i5 = $11 + 119;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            while (true) {
                obj = null;
                if (_creation.b >= i2) {
                    break;
                }
                int i7 = $10 + 121;
                $11 = i7 % 128;
                int i8 = i7 % i3;
                int i9 = _creation.b;
                try {
                    Object[] objArr2 = {Integer.valueOf(_CREATION[i + i9])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                    if (objAccessartificialFrame == null) {
                        int iMakeMeasureSpec = 8 - View.MeasureSpec.makeMeasureSpec(0, 0);
                        char cIndexOf = (char) (9278 - TextUtils.indexOf((CharSequence) "", '0'));
                        int scrollBarFadeDuration = 1977 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                        byte b = (byte) ($$d - 3);
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec, cIndexOf, scrollBarFadeDuration, 1113883676, false, $$e(b, b2, (byte) (b2 + 2)), new Class[]{Integer.TYPE});
                    }
                    Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i9), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                    if (objAccessartificialFrame2 == null) {
                        int iResolveOpacity = Drawable.resolveOpacity(0, 0) + 30;
                        char cIndexOf2 = (char) (TextUtils.indexOf("", "", 0) + 49362);
                        int maxKeyCode = 684 - (KeyEvent.getMaxKeyCode() >> 16);
                        byte b3 = (byte) ($$d - 3);
                        byte b4 = b3;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iResolveOpacity, cIndexOf2, maxKeyCode, -115095555, false, $$e(b3, b4, b4), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                    }
                    jArr[i9] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                    Object[] objArr4 = {_creation, _creation};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                    if (objAccessartificialFrame3 == null) {
                        int iRgb = Color.rgb(0, 0, 0) + 16777241;
                        char mirror = (char) (30116 - AndroidCharacter.getMirror('0'));
                        int iAlpha = Color.alpha(0) + 816;
                        int i10 = $$d;
                        byte b5 = (byte) (i10 - 3);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iRgb, mirror, iAlpha, 1897803493, false, $$e(b5, b5, (byte) i10), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                    i3 = 2;
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
                int i11 = $11 + 87;
                $10 = i11 % 128;
                if (i11 % 2 != 0) {
                    cArr[_creation.b] = (char) jArr[_creation.b];
                    Object[] objArr5 = {_creation, _creation};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-293902099);
                    if (objAccessartificialFrame4 == null) {
                        int iMyPid = 25 - (Process.myPid() >> 22);
                        char modifierMetaStateMask = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 30069);
                        int i12 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 815;
                        int i13 = $$d;
                        byte b6 = (byte) (i13 - 3);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iMyPid, modifierMetaStateMask, i12, 1897803493, false, $$e(b6, b6, (byte) i13), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                    obj.hashCode();
                    throw null;
                }
                cArr[_creation.b] = (char) jArr[_creation.b];
                try {
                    Object[] objArr6 = {_creation, _creation};
                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-293902099);
                    if (objAccessartificialFrame5 == null) {
                        int i14 = 25 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                        char c2 = (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 30067);
                        int iArgb = 816 - Color.argb(0, 0, 0, 0);
                        int i15 = $$d;
                        byte b7 = (byte) (i15 - 3);
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i14, c2, iArgb, 1897803493, false, $$e(b7, b7, (byte) i15), new Class[]{Object.class, Object.class});
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
            ByteBuffer.wrap("\u0019Ñ\u0003\u0017,\u0081V/så\u009dX\u0086ß IÍò÷m\u0010\u0015=\u0082'\n@\u0088j)\u0097Ù±JÚÑÄqáú\n\u008940Q\u0093{%d§\u008eX«É\u0019Ñ\u0003\u0017,\u0081V/så\u009dX\u0086ß IÍò÷m\u0010\u0015=\u0082'\n@\u0088j8\u0097Ô±^ÚÆÄKáí\n\u008a4\u001dQ\u0083{!d¢\u0019Ñ\u0003\u0017,\u0081V/så\u009dX\u0086ß IÍò÷m\u0010\u0015=\u0082'\n@\u0088j;\u0097Ä±@ÚÀ\u0019Ñ\u0003\u0000,\u009dV*så\u009dR\u0086ß AÍã÷g\u0010\u0019=Þ'\u0005@¸j$\u0097Ù±HÚÊÄgáá\n¥4\rQ\u0081{!d²\u008e^«ÞÕX°\u001aªÝ\u0085[ÿñÚ.4\u0090/\u001c\tÀd-^²¹Ø\u0094JáÈû\u000fÔ\u0089®#\u008büeU~ÀXQ5¡\u000fbè\u0017Å\u0087ß\u000b<6&ç\tgsÝVL¸ª£3\u0085íè#Òª5Ö\u0018y\u0002óeUOë²;\u0094½ÿ%{¹a\u007fNí4E\u0011ÃÿxäöÂ.¯\u008e\u0095\u0016r}_÷El\"Ðj\u0003p\u0093_E%´\u0000*îßõKÓ\u0084¾k\u0084ác\u0097N\fT\u008231\u0019£ämÂÏ©I·ï\u0092Yy\u0011G\u008e\"\u001c\bë\u0019\u008c\u0003\u001c,ÊV;s¥\u009dP\u0086Ä \u000bÍä÷n\u0010\u0018=\u0083'\r@¾j,\u0097â±@ÚÆÄ`áÖ\n\u009e4\u0001Q\u0093{g\u0019Ñ\u0003\u0000,\u009dV*s¾\u009dZ\u0086Ý \nÍú÷b\u0010\u001e=Þ'\u000e@¾j*\u0097Ó±LÚ\u008dÄgáæ¶ç¬a\u0083øùLÜÞ2<\u0019Ñ\u0003\u0000,\u009dV*s¾\u009dZ\u0086Ý \nÍô÷b\u0010\u0012=Þ'\f@²j%\u0097È±xÚîÄ9áç\n\u009f4\u0002Q\u0095{xd¥\u008eT«ÂÕUþà\u0018h\u0005\u0014§³½b\u0092ÿèHÍÜ#88¿\u001ehs\u0096I\u0000®p\u0083¼\u0099nþÐÔG)ª\u000f\u001ad\u008cz[_\u009b´ê\u008abïòB¤Xuwè\r_(ËÆ/Ý¨û\u007f\u0096\u008f¬\u0017Kkf«|{\u001bË1_Ì¦ê>\u0081»\u009f\u0014ºªQÂoj\nç O?ÃÕ`ðª\u008e;\u0019Ñ\u0003\u0017,\u0081V/så\u009dQ\u0086Õ HÍã÷l\u0010\t=\u0094'\u0011@£±0« \u0084vþ\u0087Û\u00035ê.`\býe\u0004_ß¸¯\u0095>\u008fª}DgÂHQ2þ\u0017{ùÅâ\nÄ\u0094©6\u0019Ñ\u0003\u0003,\u0096V6s©\u009d\u0010\u0086Ö LÍú÷n\u0010\u000f=\u0088'\u0011@£j-\u0097Ð±]óãéeÆú¼_\u0099Êw*\u0081¸\u009b(%\u0097?\u0007\u0010Ñj2O£¡KºÏ\u009cKñîËd,I\u0001\u0087\u001b\u0018|¢V&«À\u008dTæÛø{Ýç6\u0093\b\u0011m\u00895U/Ú\u0000Fzì\u0019\u008e\u0003\u0016,\u0096V*s£\u009dL\u0086Ä \u000bÍå÷r\u0010\u000f=ß'\u0000@³jf\u0097Ù±KÚÁÄaáî\nÔ4\bQ\u0090{ dè\u008e]«ÍÕJþ÷\u0018X\u0005\u001f.\u009dH+u\u008c\u009f6¸Ü¢DÏûéu\u0012÷?\u0093Y\u0019\u0019\u008e\u0003\u0016,\u0096V*s£\u009dL\u0086Ä \u000bÍå÷r\u0010\u000f=ß'\u0000@³jf\u0097Ù±KÚÁÄaáî\nÔ4\bQ\u0090{ dè\u008e]«ÍÕJþ÷\u0018X\u0005\u001f.\u009dH+u\u008c\u009f2¸Ü¢DÏûé\u007f\u0012÷\u0019\u008e\u0003\u0016,\u0096V*s£\u009dL\u0086Ä \u000bÍå÷r\u0010\u000f=ß'\u0000@³jf\u0097Ù±KÚÁÄaáî\nÔ4\u001dQ\u008f{{d¥\u008eJ«ÅCÂYZvÚ\ff)ïÇ\u0000Ü\u0088úG\u0097©\u00ad>JCg\u0093}L\u001aÿ0*Í\u0095ë\u0007\u0080\u008d\u009e-»¢P\u0098nQ\u000bÃ!7>æÔ\u0016ñ\u0083E¸_ p \n\u001c/\u0095ÁzÚòü=\u0091Ó«DL9aé{6\u001c\u00856PËïí}\u0086÷\u0098W½ØVâh+\r¹'M8\u009dÒn÷ùF{\\ãsc\tß,VÂ¹Ù1ÿþ\u0092\u0010¨\u0087Oúb*xõ\u001fF5\u0093È,î¾\u00854\u009b\u0094¾\u001bU!kè\u000ez$\u008e;^Ñ ô:\u0019\u0088\u0003\u0011,\u008bV!s¹\u009dY\u0019Ñ\u0003\u0003,\u0096V6s©\u009d\u0010\u0086Ý JÍò÷~\u0010\u0010=\u0094'\u0011\u0019\u0088\u0003\u0011,\u008bV!s\u00ad\u009dJ\u0086Õ VÍâUÙOv`ê\u001a@?ÇÑ0Ê¤ì,\u0081\u0099»\u0005C\u008cY\u001av\u0088\f0)¢ÇOÜÙ\u0019\u009d\u0003\u001b,\u0096V6s§\u009dV\u0086Å H\u0019\u008c\u0003\u001c,ÊV)s¸\u009dP\u0086Ô PÍõ÷\u007f\u0010R=\u0095'\u0007@¡j!\u0097Þ±K\u0019\u0088\u0003\u0011,\u008bV!sò\u009d\t\u0086À\u0019\u0099\u0003\u0016,\u008aV<s¸\u009dV\u0086Ó\u0099\u000f\u0083\u0080¬\u001cÖªó.\u001dÀ\u0006E ìMxw¥\u0090Ü\bZ\u0012Õ=IGÿb{\u008c\u0095\u0097\u0010±¹Ü-æð\u0001\u0089,m6\u0097Q \u0019\u008c\u0003\u001c,ÊV)s¸\u009dP\u0086Ô PÍõ÷\u007f\u0010R=\u009c'\r@³j-\u0097ÑM\u0085W\u001fx\u0087\u0010\u00ad\n(%§_\u0003z\u009d\u0094}\u008fé©a@oZÓuD\u000f©*HÄ\u009aß\u000eù\u0081\u0094/®¶IÉd\u0001~Ô\u0019h3êÎMè½\u0083\u001b\u009d¶¸6SGmÚ\u0019¿\u0003\u001d,\u0080V+s¥\u009dV\u0086Ô \u0005ÍÅ÷O\u00107=Ñ'\u0000@¢j!\u0097Ñ±ZÚ\u0083Äráæ\n\u00884OQ\u0098{mdðnTtö[k!À\u0004Nê½ñ?×îº.\u0080¤gÜJ:Pë7I\u001dÊà:Æ±\u00adh³\u0099\u0096\r}cC¤&s\f\u0086\u0013\u001bù\u008fÜq¢þ4p.à\u00016{Í^W°±«(\u008d®à\u000bÚ\u0085=å\u0019\u0099\u0003\u001c,\u0088V=s¬\u009dV\u0086Ã M¨õ²l\u009döç\\Â\u008f,t\u0092/\u0088±§)Ý\u0099ø\u0001\u0016é\u0019\u008c\u0003\u001c,ÊV)s¸\u009dP\u0086Ô PÍõ÷\u007f\u0010R=\u0093'\u0010@¶j&\u0097Ùv:lªC|9\u0084\u001c\u0019òûéhÏö¢L\u0098\u0093\u007f»R\"H¹/\u0014<MÉÍÓ]ü\u008b\u0086k£îM\u001dV\u0084p\u0016\u001d²\u0019Îm¾w.Xø\"\t\u0007\u008dédòîÔs¹\u008a\u0083Id<I¬S44\u0090\u001e\u0019ãûo\u009du\u0003Z\u008d 0\u0005\u0090ëBð\u008dÖ\u0016\u0019\u008c\u0003\u001c,ÊV;s¿\u009dV\u0086Ü AÍ¸÷m\u0010\u0015=\u009f'\u0005@²j:\u0097Í±\\ÚÊÄzáý\u0019\u0099\u0003\u0016,\u008aV<s¸\u009dV\u0086Ó \nÍå÷o\u0010\u0017=Þ'\u0005@²j&\u0097Ø±\\ÚÊÄwL¦V)yµ\u0003\u0003&\u0087ÈiÓìõE\u0098Ñ¢\fEuhár.\u0015\u008c?\u001cÂÝäi\u008f¤\u0091\u001d´\u0099_¢a5\u0004±.\u000f1\u008bÛmþð\u0080A«ÕM\u0000PqmÔw[XÇ\"q\u0007õé\u001bò\u009eÔG¹¼\u0083)d^IÛSC4ÿ\u001eZã\u0083Å\u0007®\u0085°v\u0095£~Ò@L%È\u000fj\u0010âú\u0015<÷&x\täsRVÖ¸8£½\u0085dè\u008eÒ\u00075}\u0018ç\u00024e\u008fOV²ü\u00946ÿ¯á\u0015Ä\u009f/¬\u00117tþ=ü'y\bîr[WÃ¹?¢ú\u00843é\u0097Ó\u00054F\u0019ó\u0003wdÚNB³¶\u0095.þ\u0099à\tÅÔ.©\u0010%uâ_U@Íª;\u008f»ñ-Ú\u0094<=!e\n°l\r\u0019\u008c\u0003\u001c,ÊV;s¥\u009dP\u0086Ä IÍù÷j\u0010\u0018=\u0094'\u0010\u0019\u008c\u0003\u001c,ÊV;s¥\u009dP\u0086Ä LÍû÷j\u0010\u001b=\u0094'L@µj=\u0097Ô±BÚÇÄ:áï\n\u00934\u0001Q\u0087{0d´\u008eK«ÞÕHþü\u0018s\u0001^\u001bü4aNÊkD\u0085·\u009e5¸éÕ\u000fïÒ\b«qåkuD£>R\u001bÖõ?îµÈ(¥Ñ\u009f\u0006x|UëO{(Ò\u0002@ÿ\u00adÙi²£¬\u0019\u0019\u008a\u0003\u0016,\u0097V-sç\u0019\u0097\u0003\u001d,\u008dV-sä\u009dL\u0086Æ FÍ¸÷z\u0010\u0019=\u009c'\u0017@új8\u0097Ï±AÚÓÄg\u0019\u008f\u0003\u0016,\u0089V,sä\u009dW\u0086Ç \u000bÍû÷j\u0010\u0015=\u009f'\t@²j1\u0097Î°ÏªV\u0085ÉÿlÚ¤4\f/\u0096\tKd°^*¹W\u0094Ô\u008e}éôÃi>\u0090\u0018\u000bs\u0091m5c\u0097y\u000eV\u0091,4\tüçTüÎÚ\u0013·â\u008dpj\u0000G¶]\u001e:ª\u0010>íÖË_ Ï¾uö\u0014ì\u0084ÃR¹ª\u009c7rÕiFOØ\"b\u0018½ÿ\u0085Ò\u0007È\u009e¯=\u0085¿xL^Ò5\u0015+ý\u000etå\u000fÛ\u0082¾\u001c©µ³%\u009cóæ\u0002Ã\u009c-i6ý\u00102}ÞGW (\u008d½\u0097uð\u008fÚ\u0007'à\u0001HjôtLQÝº¦\u007fÃeSJ\u00850y\u0015áû\u001dàÑÆ\b«¬\u0091-v_[ÚA\u0003&þ\fnñ\u009c×\u0006¼\u0089¢)\u0087¶lÇRI7Á\u001dn\u0019\u008c\u0003\u001c,ÊV)s¸\u009dP\u0086Ô PÍõ÷\u007f\u0010R=\u0093'\u0017@¾j$\u0097Ù±\u0000ÚÅÄ}áç\n\u009d4\nQ\u0092{%d´\u008eR«ÂÕU\u0019\u008c\u0003\u001c,ÊV*s³\u009dL\u0086Ä @Íû÷%\u0010\u001e=\u0084'\u000b@»j,\u0097\u0093±HÚÊÄzáî\n\u009f4\u001dQ\u0090{'d¯\u008eU«Øhër{]\u00ad'M\u0002Ôì+÷£Ñ'¼\u009c\u00863a~LîVq1\u009e\u001bMæ¯À «¨µ\u0017\u0090À{ûEa é\nU\u0015Äÿ.Ú»¤4\u008f\u009ci\u000etk.Û4K\u001b\u009daxDøª\u0006±\u0083\u0097\u001dú³Àr'I\nÓ\u0010\\wì]{ Ä\u0086\u001fí\u009dó-Ö¹=È\u0003JfÇLpSø¹\u0002\u009c\u008f\u0092Ð\u0088@§\u0096Ýsøó\u0016\r\r\u0088+\u0016F¸|\b\u009bD¶Á¬UËæá:\u001c\u0083:\u0007Q\u0096O$j±\u0081\u0088¿UÚÕðgïý\u0005\u0002 \u0082^\ru¼\u00932\u008eJ¥Å\u0019Ä\u000fs\u0015µ:#@\u008deG\u008bì\u0090w¶êÛAáö\u0006®+:1°V\u0010\u0019Ñ\u0003\u0017,\u0081V/så\u009dL\u0086ß FÍý÷n\u0010\b=Þ'\u0000@¶j;\u0097Ø±LÚÂÄzáí\n¥4\bQ\u0085{;d¿\u008e_\u0019Ñ\u0003\u0017,\u0081V/så\u009dL\u0086ß FÍý÷n\u0010\b=Þ'\u0005@²j&\u0097Ä±J\u0019Ñ\u0003\u0017,\u0081V/så\u009dL\u0086ß FÍý÷n\u0010\b=Þ'\u0013@²j%\u0097È±J\u0019Ñ\u0003\u0000,\u009dV*så\u009dN\u0086Õ HÍã÷T\u0010\b=\u0083'\u0003@´j-\u0019Ñ\u0003\u0000,\u009dV*s¾\u009dZ\u0086Ý \nÍú÷b\u0010\u001e=Þ'\u000e@¾j*\u0097Þ±qÚÎÄuáå\n\u00964\u0000Q\u0083{\nd¢\u008e^«ÎÕTþõ\u0018X\u0005\t.\u0088H3u¦\u009fj¸Ê¢Eðßê\u0019Å\u008f¿!\u009aëtSoÍI_$Ç\u001ebù\u0002Ô\u008c\u0019Ñ\u0003\u0017,\u0081V/så\u009d]\u0086Ã QÍÉ÷\u007f\u0010\u0015=\u009c'\u0007àGú\u0081Õ\u0017¯¹\u008asdÚ\u007fIYÐ4k\u000eøé\u009eÄHÞ\u0096¹2\u0093ªnMH×#Y=æ\u0018zó\u001eÍ\u009dé$óõÜh¦ß\u0083Km¯v(Pÿ=\u000f\u0007\u0097àëÍ+×û°K\u009aßg*A¨*\"4\u0087\u0011\u0013úcÄþ¡p\u008bÒ\u0094l~¤[7%½\u000eIè\u0081õâ¹\u0083£E\u008cÓö}Ó·=\u000f&\u0091\u0000\u0003m¥W:°M\u009dÆ\u0019Ñ\u0003\u0017,\u0081V/så\u009d]\u0086Ã QÍñ÷r\u0010\u000e=\u009e\u0019Ñ\u0003\u0017,\u0081V/så\u009d]\u0086Ã QÍû÷n\u0010\u001b=\u009f\u0019Ñ\u0003\u0017,\u0081V/så\u009d]\u0086Ã QÍù÷y\u0010\u0015=\u0094$Æ>\u0000\u0011\u0096k8Nò J»Ô\u009dFð÷Êq-\u0018\u0000\u0081\u0019Ñ\u0003\u0017,\u0081V/så\u009d]\u0086Ã QÍæ÷l\u0010\u001d=\u0098'\u0012@´\u0019Ñ\u0003\u0017,\u0081V/så\u009d]\u0086Ã QÍÉ÷b\u0010\u0011=\u0094\u0019Ñ\u0003\u0017,\u0085V-s«\u009d\u0010\u0086Ô JÍá÷e\u0010\u0010=\u009e'\u0003@³j;\u0097\u0092±\u0000ÚÛÄvá¦\n\u00984\u001cQ\u0094{>¹é£&\u008c²ö\u0015ÓÝ=p&á\u0000smÊW\\°3\u009dº\u0087uà\u00adÊ\u00037ñ\u0011EzódMAÃª§\u00943ñ\u009eÛ\u0002Ä\u0092.g\u000bñukô¹îkÁþ»^\u009eÁpxk±M\" \u008e\u001a\fýfÐíÊy\u0019Î\u0003\u0015,\u0082Vysð\u0019Ñ\u0003\u0003,\u0096V6s©\u009d\u0010\u0086Ã @Íú÷m\u0010S=\u009c'\u0003@§j;\u0019\u0099\u0003\u0001,\u0085V5s¦\u009dP\u0086Ó \u000bÍñ÷d\u0010\u0010=\u0095'\u0004@¾j;\u0097Õ±\u0000ÚÐÄ{\u0019\u0092\u0003\u001a,\u0086V\u001es\u0086\u009dz\u0086ã zÍô÷x\u0010\b=ß'\u0011@¸\u0019Ñ\u0003\u0016,\u0090V:så\u009dR\u0086Õ AÍÿ÷j\u0010#=\u0092'\r@³j-\u0097Þ±]Ú\u008dÄláä\n\u0096\u0019\u009c\u0003\u001f,\u0091V<s¹\u009dK\u0086Ñ FÍý÷x\u0004-\u001eê1lKÆn\u0019\u0080®\u009b#½¬Ð\u0004ê\u0083\ró¸o¢©\u008d;÷\u0093Ò\u0015<®'j\u0001ôl_VÛ±®\u009c \u0086½á\rË\u00856,\u0010¾{yeÚ@\u0018«%\u0095¡ð.Ú\u0098ÅV/ý\n\u007ftó\u0019Ñ\u0003\u0003,\u0096V6s©\u009d\u0010\u0086Ó UÍã÷b\u0010\u0012=\u0097'\r\u0019¹\u0003\u001c,\u0088V=s¬\u009dV\u0086Ã M\u0019Ñ\u0003\u0017,\u0085V-s«\u009d\u0010\u0086Ý LÍå÷h\u0010S=\u0081'\u0010@¸j.\u0097Ô±BÚÆÄgá¦\n\u00994\u001aQ\u0092{zdö\u008e\u0014«ÏÕNþÿ\u0018)\u0005\u0015.\u0084H=u¡\u009f+¸Ï¢CÏíéd\u0012«?\u009bY\u000eB±l$\u0089«³ZÜÍ".getBytes(CharEncoding.ISO_8859_1)).asCharBuffer().get(cArr, 0, 1959);
            _CREATION = cArr;
            _BOUNDARY = -3973308243200441485L;
        }

        /* JADX WARN: Code duplicated, block: B:101:0x0f35 A[LOOP:2: B:91:0x0e04->B:101:0x0f35, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:104:0x0f4e  */
        /* JADX WARN: Code duplicated, block: B:106:0x0fc2  */
        /* JADX WARN: Code duplicated, block: B:109:0x100d A[Catch: all -> 0x0264, TryCatch #1 {all -> 0x0264, blocks: (B:6:0x0146, B:8:0x0153, B:9:0x019a, B:24:0x03af, B:26:0x03bc, B:27:0x040c, B:36:0x05af, B:38:0x05bc, B:39:0x0603, B:66:0x087e, B:68:0x0884, B:69:0x08cd, B:80:0x0ab4, B:82:0x0ac1, B:83:0x0b11, B:94:0x0e09, B:96:0x0e16, B:97:0x0e65, B:107:0x1000, B:109:0x100d, B:110:0x1053, B:133:0x1275, B:135:0x1282, B:136:0x12cd, B:151:0x14ad, B:153:0x14ba, B:154:0x1501, B:189:0x181f, B:191:0x1825, B:192:0x1860, B:197:0x1968, B:199:0x1979, B:200:0x19b9, B:208:0x1af3, B:210:0x1b00, B:211:0x1b48, B:213:0x1b51, B:215:0x1b69, B:216:0x1bbf, B:271:0x2cc0, B:273:0x2ccd, B:275:0x2d10, B:291:0x322d, B:293:0x323a, B:294:0x3285, B:300:0x3362, B:302:0x336f, B:303:0x33bb, B:371:0x3a70, B:373:0x3a7d, B:374:0x3ac0, B:278:0x2d1e, B:280:0x2d36, B:281:0x2d85, B:226:0x28ef, B:228:0x28fc, B:230:0x294d, B:250:0x29f6, B:252:0x2a03, B:253:0x2a4e, B:235:0x296a, B:237:0x2977, B:238:0x29c2, B:178:0x169a, B:180:0x16a7, B:181:0x16ef, B:45:0x0702, B:47:0x070f, B:48:0x0757, B:54:0x079a, B:56:0x07a7, B:57:0x07ef), top: B:391:0x0146 }] */
        /* JADX WARN: Code duplicated, block: B:112:0x105e  */
        /* JADX WARN: Code duplicated, block: B:114:0x109f  */
        /* JADX WARN: Code duplicated, block: B:115:0x10a7  */
        /* JADX WARN: Code duplicated, block: B:117:0x10aa  */
        /* JADX WARN: Code duplicated, block: B:118:0x1113  */
        /* JADX WARN: Code duplicated, block: B:129:0x11d4  */
        /* JADX WARN: Code duplicated, block: B:131:0x11d7  */
        /* JADX WARN: Code duplicated, block: B:132:0x124c  */
        /* JADX WARN: Code duplicated, block: B:135:0x1282 A[Catch: all -> 0x0264, TryCatch #1 {all -> 0x0264, blocks: (B:6:0x0146, B:8:0x0153, B:9:0x019a, B:24:0x03af, B:26:0x03bc, B:27:0x040c, B:36:0x05af, B:38:0x05bc, B:39:0x0603, B:66:0x087e, B:68:0x0884, B:69:0x08cd, B:80:0x0ab4, B:82:0x0ac1, B:83:0x0b11, B:94:0x0e09, B:96:0x0e16, B:97:0x0e65, B:107:0x1000, B:109:0x100d, B:110:0x1053, B:133:0x1275, B:135:0x1282, B:136:0x12cd, B:151:0x14ad, B:153:0x14ba, B:154:0x1501, B:189:0x181f, B:191:0x1825, B:192:0x1860, B:197:0x1968, B:199:0x1979, B:200:0x19b9, B:208:0x1af3, B:210:0x1b00, B:211:0x1b48, B:213:0x1b51, B:215:0x1b69, B:216:0x1bbf, B:271:0x2cc0, B:273:0x2ccd, B:275:0x2d10, B:291:0x322d, B:293:0x323a, B:294:0x3285, B:300:0x3362, B:302:0x336f, B:303:0x33bb, B:371:0x3a70, B:373:0x3a7d, B:374:0x3ac0, B:278:0x2d1e, B:280:0x2d36, B:281:0x2d85, B:226:0x28ef, B:228:0x28fc, B:230:0x294d, B:250:0x29f6, B:252:0x2a03, B:253:0x2a4e, B:235:0x296a, B:237:0x2977, B:238:0x29c2, B:178:0x169a, B:180:0x16a7, B:181:0x16ef, B:45:0x0702, B:47:0x070f, B:48:0x0757, B:54:0x079a, B:56:0x07a7, B:57:0x07ef), top: B:391:0x0146 }] */
        /* JADX WARN: Code duplicated, block: B:139:0x12fb  */
        /* JADX WARN: Code duplicated, block: B:140:0x1314  */
        /* JADX WARN: Code duplicated, block: B:143:0x1333  */
        /* JADX WARN: Code duplicated, block: B:144:0x1339  */
        /* JADX WARN: Code duplicated, block: B:146:0x133c  */
        /* JADX WARN: Code duplicated, block: B:147:0x13a5  */
        /* JADX WARN: Code duplicated, block: B:150:0x14ab  */
        /* JADX WARN: Code duplicated, block: B:153:0x14ba A[Catch: all -> 0x0264, TryCatch #1 {all -> 0x0264, blocks: (B:6:0x0146, B:8:0x0153, B:9:0x019a, B:24:0x03af, B:26:0x03bc, B:27:0x040c, B:36:0x05af, B:38:0x05bc, B:39:0x0603, B:66:0x087e, B:68:0x0884, B:69:0x08cd, B:80:0x0ab4, B:82:0x0ac1, B:83:0x0b11, B:94:0x0e09, B:96:0x0e16, B:97:0x0e65, B:107:0x1000, B:109:0x100d, B:110:0x1053, B:133:0x1275, B:135:0x1282, B:136:0x12cd, B:151:0x14ad, B:153:0x14ba, B:154:0x1501, B:189:0x181f, B:191:0x1825, B:192:0x1860, B:197:0x1968, B:199:0x1979, B:200:0x19b9, B:208:0x1af3, B:210:0x1b00, B:211:0x1b48, B:213:0x1b51, B:215:0x1b69, B:216:0x1bbf, B:271:0x2cc0, B:273:0x2ccd, B:275:0x2d10, B:291:0x322d, B:293:0x323a, B:294:0x3285, B:300:0x3362, B:302:0x336f, B:303:0x33bb, B:371:0x3a70, B:373:0x3a7d, B:374:0x3ac0, B:278:0x2d1e, B:280:0x2d36, B:281:0x2d85, B:226:0x28ef, B:228:0x28fc, B:230:0x294d, B:250:0x29f6, B:252:0x2a03, B:253:0x2a4e, B:235:0x296a, B:237:0x2977, B:238:0x29c2, B:178:0x169a, B:180:0x16a7, B:181:0x16ef, B:45:0x0702, B:47:0x070f, B:48:0x0757, B:54:0x079a, B:56:0x07a7, B:57:0x07ef), top: B:391:0x0146 }] */
        /* JADX WARN: Code duplicated, block: B:162:0x151f  */
        /* JADX WARN: Code duplicated, block: B:163:0x157c  */
        /* JADX WARN: Code duplicated, block: B:177:0x1645  */
        /* JADX WARN: Code duplicated, block: B:180:0x16a7 A[Catch: all -> 0x0264, TryCatch #1 {all -> 0x0264, blocks: (B:6:0x0146, B:8:0x0153, B:9:0x019a, B:24:0x03af, B:26:0x03bc, B:27:0x040c, B:36:0x05af, B:38:0x05bc, B:39:0x0603, B:66:0x087e, B:68:0x0884, B:69:0x08cd, B:80:0x0ab4, B:82:0x0ac1, B:83:0x0b11, B:94:0x0e09, B:96:0x0e16, B:97:0x0e65, B:107:0x1000, B:109:0x100d, B:110:0x1053, B:133:0x1275, B:135:0x1282, B:136:0x12cd, B:151:0x14ad, B:153:0x14ba, B:154:0x1501, B:189:0x181f, B:191:0x1825, B:192:0x1860, B:197:0x1968, B:199:0x1979, B:200:0x19b9, B:208:0x1af3, B:210:0x1b00, B:211:0x1b48, B:213:0x1b51, B:215:0x1b69, B:216:0x1bbf, B:271:0x2cc0, B:273:0x2ccd, B:275:0x2d10, B:291:0x322d, B:293:0x323a, B:294:0x3285, B:300:0x3362, B:302:0x336f, B:303:0x33bb, B:371:0x3a70, B:373:0x3a7d, B:374:0x3ac0, B:278:0x2d1e, B:280:0x2d36, B:281:0x2d85, B:226:0x28ef, B:228:0x28fc, B:230:0x294d, B:250:0x29f6, B:252:0x2a03, B:253:0x2a4e, B:235:0x296a, B:237:0x2977, B:238:0x29c2, B:178:0x169a, B:180:0x16a7, B:181:0x16ef, B:45:0x0702, B:47:0x070f, B:48:0x0757, B:54:0x079a, B:56:0x07a7, B:57:0x07ef), top: B:391:0x0146 }] */
        /* JADX WARN: Code duplicated, block: B:184:0x17a2  */
        /* JADX WARN: Code duplicated, block: B:185:0x17a5  */
        /* JADX WARN: Code duplicated, block: B:187:0x17a8  */
        /* JADX WARN: Code duplicated, block: B:188:0x181b  */
        /* JADX WARN: Code duplicated, block: B:191:0x1825 A[Catch: all -> 0x0264, TryCatch #1 {all -> 0x0264, blocks: (B:6:0x0146, B:8:0x0153, B:9:0x019a, B:24:0x03af, B:26:0x03bc, B:27:0x040c, B:36:0x05af, B:38:0x05bc, B:39:0x0603, B:66:0x087e, B:68:0x0884, B:69:0x08cd, B:80:0x0ab4, B:82:0x0ac1, B:83:0x0b11, B:94:0x0e09, B:96:0x0e16, B:97:0x0e65, B:107:0x1000, B:109:0x100d, B:110:0x1053, B:133:0x1275, B:135:0x1282, B:136:0x12cd, B:151:0x14ad, B:153:0x14ba, B:154:0x1501, B:189:0x181f, B:191:0x1825, B:192:0x1860, B:197:0x1968, B:199:0x1979, B:200:0x19b9, B:208:0x1af3, B:210:0x1b00, B:211:0x1b48, B:213:0x1b51, B:215:0x1b69, B:216:0x1bbf, B:271:0x2cc0, B:273:0x2ccd, B:275:0x2d10, B:291:0x322d, B:293:0x323a, B:294:0x3285, B:300:0x3362, B:302:0x336f, B:303:0x33bb, B:371:0x3a70, B:373:0x3a7d, B:374:0x3ac0, B:278:0x2d1e, B:280:0x2d36, B:281:0x2d85, B:226:0x28ef, B:228:0x28fc, B:230:0x294d, B:250:0x29f6, B:252:0x2a03, B:253:0x2a4e, B:235:0x296a, B:237:0x2977, B:238:0x29c2, B:178:0x169a, B:180:0x16a7, B:181:0x16ef, B:45:0x0702, B:47:0x070f, B:48:0x0757, B:54:0x079a, B:56:0x07a7, B:57:0x07ef), top: B:391:0x0146 }] */
        /* JADX WARN: Code duplicated, block: B:195:0x190f  */
        /* JADX WARN: Code duplicated, block: B:196:0x1966  */
        /* JADX WARN: Code duplicated, block: B:199:0x1979 A[Catch: all -> 0x0264, TryCatch #1 {all -> 0x0264, blocks: (B:6:0x0146, B:8:0x0153, B:9:0x019a, B:24:0x03af, B:26:0x03bc, B:27:0x040c, B:36:0x05af, B:38:0x05bc, B:39:0x0603, B:66:0x087e, B:68:0x0884, B:69:0x08cd, B:80:0x0ab4, B:82:0x0ac1, B:83:0x0b11, B:94:0x0e09, B:96:0x0e16, B:97:0x0e65, B:107:0x1000, B:109:0x100d, B:110:0x1053, B:133:0x1275, B:135:0x1282, B:136:0x12cd, B:151:0x14ad, B:153:0x14ba, B:154:0x1501, B:189:0x181f, B:191:0x1825, B:192:0x1860, B:197:0x1968, B:199:0x1979, B:200:0x19b9, B:208:0x1af3, B:210:0x1b00, B:211:0x1b48, B:213:0x1b51, B:215:0x1b69, B:216:0x1bbf, B:271:0x2cc0, B:273:0x2ccd, B:275:0x2d10, B:291:0x322d, B:293:0x323a, B:294:0x3285, B:300:0x3362, B:302:0x336f, B:303:0x33bb, B:371:0x3a70, B:373:0x3a7d, B:374:0x3ac0, B:278:0x2d1e, B:280:0x2d36, B:281:0x2d85, B:226:0x28ef, B:228:0x28fc, B:230:0x294d, B:250:0x29f6, B:252:0x2a03, B:253:0x2a4e, B:235:0x296a, B:237:0x2977, B:238:0x29c2, B:178:0x169a, B:180:0x16a7, B:181:0x16ef, B:45:0x0702, B:47:0x070f, B:48:0x0757, B:54:0x079a, B:56:0x07a7, B:57:0x07ef), top: B:391:0x0146 }] */
        /* JADX WARN: Code duplicated, block: B:203:0x1a56  */
        /* JADX WARN: Code duplicated, block: B:204:0x1a68  */
        /* JADX WARN: Code duplicated, block: B:206:0x1a6b  */
        /* JADX WARN: Code duplicated, block: B:207:0x1acd  */
        /* JADX WARN: Code duplicated, block: B:210:0x1b00 A[Catch: all -> 0x0264, TryCatch #1 {all -> 0x0264, blocks: (B:6:0x0146, B:8:0x0153, B:9:0x019a, B:24:0x03af, B:26:0x03bc, B:27:0x040c, B:36:0x05af, B:38:0x05bc, B:39:0x0603, B:66:0x087e, B:68:0x0884, B:69:0x08cd, B:80:0x0ab4, B:82:0x0ac1, B:83:0x0b11, B:94:0x0e09, B:96:0x0e16, B:97:0x0e65, B:107:0x1000, B:109:0x100d, B:110:0x1053, B:133:0x1275, B:135:0x1282, B:136:0x12cd, B:151:0x14ad, B:153:0x14ba, B:154:0x1501, B:189:0x181f, B:191:0x1825, B:192:0x1860, B:197:0x1968, B:199:0x1979, B:200:0x19b9, B:208:0x1af3, B:210:0x1b00, B:211:0x1b48, B:213:0x1b51, B:215:0x1b69, B:216:0x1bbf, B:271:0x2cc0, B:273:0x2ccd, B:275:0x2d10, B:291:0x322d, B:293:0x323a, B:294:0x3285, B:300:0x3362, B:302:0x336f, B:303:0x33bb, B:371:0x3a70, B:373:0x3a7d, B:374:0x3ac0, B:278:0x2d1e, B:280:0x2d36, B:281:0x2d85, B:226:0x28ef, B:228:0x28fc, B:230:0x294d, B:250:0x29f6, B:252:0x2a03, B:253:0x2a4e, B:235:0x296a, B:237:0x2977, B:238:0x29c2, B:178:0x169a, B:180:0x16a7, B:181:0x16ef, B:45:0x0702, B:47:0x070f, B:48:0x0757, B:54:0x079a, B:56:0x07a7, B:57:0x07ef), top: B:391:0x0146 }] */
        /* JADX WARN: Code duplicated, block: B:213:0x1b51 A[Catch: all -> 0x0264, TryCatch #1 {all -> 0x0264, blocks: (B:6:0x0146, B:8:0x0153, B:9:0x019a, B:24:0x03af, B:26:0x03bc, B:27:0x040c, B:36:0x05af, B:38:0x05bc, B:39:0x0603, B:66:0x087e, B:68:0x0884, B:69:0x08cd, B:80:0x0ab4, B:82:0x0ac1, B:83:0x0b11, B:94:0x0e09, B:96:0x0e16, B:97:0x0e65, B:107:0x1000, B:109:0x100d, B:110:0x1053, B:133:0x1275, B:135:0x1282, B:136:0x12cd, B:151:0x14ad, B:153:0x14ba, B:154:0x1501, B:189:0x181f, B:191:0x1825, B:192:0x1860, B:197:0x1968, B:199:0x1979, B:200:0x19b9, B:208:0x1af3, B:210:0x1b00, B:211:0x1b48, B:213:0x1b51, B:215:0x1b69, B:216:0x1bbf, B:271:0x2cc0, B:273:0x2ccd, B:275:0x2d10, B:291:0x322d, B:293:0x323a, B:294:0x3285, B:300:0x3362, B:302:0x336f, B:303:0x33bb, B:371:0x3a70, B:373:0x3a7d, B:374:0x3ac0, B:278:0x2d1e, B:280:0x2d36, B:281:0x2d85, B:226:0x28ef, B:228:0x28fc, B:230:0x294d, B:250:0x29f6, B:252:0x2a03, B:253:0x2a4e, B:235:0x296a, B:237:0x2977, B:238:0x29c2, B:178:0x169a, B:180:0x16a7, B:181:0x16ef, B:45:0x0702, B:47:0x070f, B:48:0x0757, B:54:0x079a, B:56:0x07a7, B:57:0x07ef), top: B:391:0x0146 }] */
        /* JADX WARN: Code duplicated, block: B:215:0x1b69 A[Catch: all -> 0x0264, TryCatch #1 {all -> 0x0264, blocks: (B:6:0x0146, B:8:0x0153, B:9:0x019a, B:24:0x03af, B:26:0x03bc, B:27:0x040c, B:36:0x05af, B:38:0x05bc, B:39:0x0603, B:66:0x087e, B:68:0x0884, B:69:0x08cd, B:80:0x0ab4, B:82:0x0ac1, B:83:0x0b11, B:94:0x0e09, B:96:0x0e16, B:97:0x0e65, B:107:0x1000, B:109:0x100d, B:110:0x1053, B:133:0x1275, B:135:0x1282, B:136:0x12cd, B:151:0x14ad, B:153:0x14ba, B:154:0x1501, B:189:0x181f, B:191:0x1825, B:192:0x1860, B:197:0x1968, B:199:0x1979, B:200:0x19b9, B:208:0x1af3, B:210:0x1b00, B:211:0x1b48, B:213:0x1b51, B:215:0x1b69, B:216:0x1bbf, B:271:0x2cc0, B:273:0x2ccd, B:275:0x2d10, B:291:0x322d, B:293:0x323a, B:294:0x3285, B:300:0x3362, B:302:0x336f, B:303:0x33bb, B:371:0x3a70, B:373:0x3a7d, B:374:0x3ac0, B:278:0x2d1e, B:280:0x2d36, B:281:0x2d85, B:226:0x28ef, B:228:0x28fc, B:230:0x294d, B:250:0x29f6, B:252:0x2a03, B:253:0x2a4e, B:235:0x296a, B:237:0x2977, B:238:0x29c2, B:178:0x169a, B:180:0x16a7, B:181:0x16ef, B:45:0x0702, B:47:0x070f, B:48:0x0757, B:54:0x079a, B:56:0x07a7, B:57:0x07ef), top: B:391:0x0146 }] */
        /* JADX WARN: Code duplicated, block: B:219:0x1c90  */
        /* JADX WARN: Code duplicated, block: B:220:0x1c99  */
        /* JADX WARN: Code duplicated, block: B:223:0x28db  */
        /* JADX WARN: Code duplicated, block: B:225:0x28ea  */
        /* JADX WARN: Code duplicated, block: B:228:0x28fc A[Catch: all -> 0x0264, TryCatch #1 {all -> 0x0264, blocks: (B:6:0x0146, B:8:0x0153, B:9:0x019a, B:24:0x03af, B:26:0x03bc, B:27:0x040c, B:36:0x05af, B:38:0x05bc, B:39:0x0603, B:66:0x087e, B:68:0x0884, B:69:0x08cd, B:80:0x0ab4, B:82:0x0ac1, B:83:0x0b11, B:94:0x0e09, B:96:0x0e16, B:97:0x0e65, B:107:0x1000, B:109:0x100d, B:110:0x1053, B:133:0x1275, B:135:0x1282, B:136:0x12cd, B:151:0x14ad, B:153:0x14ba, B:154:0x1501, B:189:0x181f, B:191:0x1825, B:192:0x1860, B:197:0x1968, B:199:0x1979, B:200:0x19b9, B:208:0x1af3, B:210:0x1b00, B:211:0x1b48, B:213:0x1b51, B:215:0x1b69, B:216:0x1bbf, B:271:0x2cc0, B:273:0x2ccd, B:275:0x2d10, B:291:0x322d, B:293:0x323a, B:294:0x3285, B:300:0x3362, B:302:0x336f, B:303:0x33bb, B:371:0x3a70, B:373:0x3a7d, B:374:0x3ac0, B:278:0x2d1e, B:280:0x2d36, B:281:0x2d85, B:226:0x28ef, B:228:0x28fc, B:230:0x294d, B:250:0x29f6, B:252:0x2a03, B:253:0x2a4e, B:235:0x296a, B:237:0x2977, B:238:0x29c2, B:178:0x169a, B:180:0x16a7, B:181:0x16ef, B:45:0x0702, B:47:0x070f, B:48:0x0757, B:54:0x079a, B:56:0x07a7, B:57:0x07ef), top: B:391:0x0146 }] */
        /* JADX WARN: Code duplicated, block: B:229:0x2949  */
        /* JADX WARN: Code duplicated, block: B:234:0x2961  */
        /* JADX WARN: Code duplicated, block: B:237:0x2977 A[Catch: all -> 0x0264, TryCatch #1 {all -> 0x0264, blocks: (B:6:0x0146, B:8:0x0153, B:9:0x019a, B:24:0x03af, B:26:0x03bc, B:27:0x040c, B:36:0x05af, B:38:0x05bc, B:39:0x0603, B:66:0x087e, B:68:0x0884, B:69:0x08cd, B:80:0x0ab4, B:82:0x0ac1, B:83:0x0b11, B:94:0x0e09, B:96:0x0e16, B:97:0x0e65, B:107:0x1000, B:109:0x100d, B:110:0x1053, B:133:0x1275, B:135:0x1282, B:136:0x12cd, B:151:0x14ad, B:153:0x14ba, B:154:0x1501, B:189:0x181f, B:191:0x1825, B:192:0x1860, B:197:0x1968, B:199:0x1979, B:200:0x19b9, B:208:0x1af3, B:210:0x1b00, B:211:0x1b48, B:213:0x1b51, B:215:0x1b69, B:216:0x1bbf, B:271:0x2cc0, B:273:0x2ccd, B:275:0x2d10, B:291:0x322d, B:293:0x323a, B:294:0x3285, B:300:0x3362, B:302:0x336f, B:303:0x33bb, B:371:0x3a70, B:373:0x3a7d, B:374:0x3ac0, B:278:0x2d1e, B:280:0x2d36, B:281:0x2d85, B:226:0x28ef, B:228:0x28fc, B:230:0x294d, B:250:0x29f6, B:252:0x2a03, B:253:0x2a4e, B:235:0x296a, B:237:0x2977, B:238:0x29c2, B:178:0x169a, B:180:0x16a7, B:181:0x16ef, B:45:0x0702, B:47:0x070f, B:48:0x0757, B:54:0x079a, B:56:0x07a7, B:57:0x07ef), top: B:391:0x0146 }] */
        /* JADX WARN: Code duplicated, block: B:241:0x29d5 A[PHI: r6 r9 r11 r23 r30
  0x29d5: PHI (r6v341 java.lang.String[]) = (r6v337 java.lang.String[]), (r6v371 java.lang.String[]) binds: [B:240:0x29d3, B:232:0x295e] A[DONT_GENERATE, DONT_INLINE]
  0x29d5: PHI (r9v433 java.lang.String) = (r9v432 java.lang.String), (r9v438 java.lang.String) binds: [B:240:0x29d3, B:232:0x295e] A[DONT_GENERATE, DONT_INLINE]
  0x29d5: PHI (r11v291 java.lang.String[]) = (r11v290 java.lang.String[]), (r11v299 java.lang.String[]) binds: [B:240:0x29d3, B:232:0x295e] A[DONT_GENERATE, DONT_INLINE]
  0x29d5: PHI (r23v4 java.lang.String) = (r23v3 java.lang.String), (r5v83 java.lang.String) binds: [B:240:0x29d3, B:232:0x295e] A[DONT_GENERATE, DONT_INLINE]
  0x29d5: PHI (r30v2 int) = (r30v1 int), (r9v425 int) binds: [B:240:0x29d3, B:232:0x295e] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:243:0x29e1  */
        /* JADX WARN: Code duplicated, block: B:246:0x29ec  */
        /* JADX WARN: Code duplicated, block: B:248:0x29f2  */
        /* JADX WARN: Code duplicated, block: B:250:0x29f6 A[Catch: all -> 0x0264, TRY_ENTER, TryCatch #1 {all -> 0x0264, blocks: (B:6:0x0146, B:8:0x0153, B:9:0x019a, B:24:0x03af, B:26:0x03bc, B:27:0x040c, B:36:0x05af, B:38:0x05bc, B:39:0x0603, B:66:0x087e, B:68:0x0884, B:69:0x08cd, B:80:0x0ab4, B:82:0x0ac1, B:83:0x0b11, B:94:0x0e09, B:96:0x0e16, B:97:0x0e65, B:107:0x1000, B:109:0x100d, B:110:0x1053, B:133:0x1275, B:135:0x1282, B:136:0x12cd, B:151:0x14ad, B:153:0x14ba, B:154:0x1501, B:189:0x181f, B:191:0x1825, B:192:0x1860, B:197:0x1968, B:199:0x1979, B:200:0x19b9, B:208:0x1af3, B:210:0x1b00, B:211:0x1b48, B:213:0x1b51, B:215:0x1b69, B:216:0x1bbf, B:271:0x2cc0, B:273:0x2ccd, B:275:0x2d10, B:291:0x322d, B:293:0x323a, B:294:0x3285, B:300:0x3362, B:302:0x336f, B:303:0x33bb, B:371:0x3a70, B:373:0x3a7d, B:374:0x3ac0, B:278:0x2d1e, B:280:0x2d36, B:281:0x2d85, B:226:0x28ef, B:228:0x28fc, B:230:0x294d, B:250:0x29f6, B:252:0x2a03, B:253:0x2a4e, B:235:0x296a, B:237:0x2977, B:238:0x29c2, B:178:0x169a, B:180:0x16a7, B:181:0x16ef, B:45:0x0702, B:47:0x070f, B:48:0x0757, B:54:0x079a, B:56:0x07a7, B:57:0x07ef), top: B:391:0x0146 }] */
        /* JADX WARN: Code duplicated, block: B:252:0x2a03 A[Catch: all -> 0x0264, TryCatch #1 {all -> 0x0264, blocks: (B:6:0x0146, B:8:0x0153, B:9:0x019a, B:24:0x03af, B:26:0x03bc, B:27:0x040c, B:36:0x05af, B:38:0x05bc, B:39:0x0603, B:66:0x087e, B:68:0x0884, B:69:0x08cd, B:80:0x0ab4, B:82:0x0ac1, B:83:0x0b11, B:94:0x0e09, B:96:0x0e16, B:97:0x0e65, B:107:0x1000, B:109:0x100d, B:110:0x1053, B:133:0x1275, B:135:0x1282, B:136:0x12cd, B:151:0x14ad, B:153:0x14ba, B:154:0x1501, B:189:0x181f, B:191:0x1825, B:192:0x1860, B:197:0x1968, B:199:0x1979, B:200:0x19b9, B:208:0x1af3, B:210:0x1b00, B:211:0x1b48, B:213:0x1b51, B:215:0x1b69, B:216:0x1bbf, B:271:0x2cc0, B:273:0x2ccd, B:275:0x2d10, B:291:0x322d, B:293:0x323a, B:294:0x3285, B:300:0x3362, B:302:0x336f, B:303:0x33bb, B:371:0x3a70, B:373:0x3a7d, B:374:0x3ac0, B:278:0x2d1e, B:280:0x2d36, B:281:0x2d85, B:226:0x28ef, B:228:0x28fc, B:230:0x294d, B:250:0x29f6, B:252:0x2a03, B:253:0x2a4e, B:235:0x296a, B:237:0x2977, B:238:0x29c2, B:178:0x169a, B:180:0x16a7, B:181:0x16ef, B:45:0x0702, B:47:0x070f, B:48:0x0757, B:54:0x079a, B:56:0x07a7, B:57:0x07ef), top: B:391:0x0146 }] */
        /* JADX WARN: Code duplicated, block: B:257:0x2af3  */
        /* JADX WARN: Code duplicated, block: B:264:0x2b5b  */
        /* JADX WARN: Code duplicated, block: B:265:0x2bbf  */
        /* JADX WARN: Code duplicated, block: B:268:0x2c2a  */
        /* JADX WARN: Code duplicated, block: B:269:0x2c93  */
        /* JADX WARN: Code duplicated, block: B:273:0x2ccd A[Catch: all -> 0x0264, TryCatch #1 {all -> 0x0264, blocks: (B:6:0x0146, B:8:0x0153, B:9:0x019a, B:24:0x03af, B:26:0x03bc, B:27:0x040c, B:36:0x05af, B:38:0x05bc, B:39:0x0603, B:66:0x087e, B:68:0x0884, B:69:0x08cd, B:80:0x0ab4, B:82:0x0ac1, B:83:0x0b11, B:94:0x0e09, B:96:0x0e16, B:97:0x0e65, B:107:0x1000, B:109:0x100d, B:110:0x1053, B:133:0x1275, B:135:0x1282, B:136:0x12cd, B:151:0x14ad, B:153:0x14ba, B:154:0x1501, B:189:0x181f, B:191:0x1825, B:192:0x1860, B:197:0x1968, B:199:0x1979, B:200:0x19b9, B:208:0x1af3, B:210:0x1b00, B:211:0x1b48, B:213:0x1b51, B:215:0x1b69, B:216:0x1bbf, B:271:0x2cc0, B:273:0x2ccd, B:275:0x2d10, B:291:0x322d, B:293:0x323a, B:294:0x3285, B:300:0x3362, B:302:0x336f, B:303:0x33bb, B:371:0x3a70, B:373:0x3a7d, B:374:0x3ac0, B:278:0x2d1e, B:280:0x2d36, B:281:0x2d85, B:226:0x28ef, B:228:0x28fc, B:230:0x294d, B:250:0x29f6, B:252:0x2a03, B:253:0x2a4e, B:235:0x296a, B:237:0x2977, B:238:0x29c2, B:178:0x169a, B:180:0x16a7, B:181:0x16ef, B:45:0x0702, B:47:0x070f, B:48:0x0757, B:54:0x079a, B:56:0x07a7, B:57:0x07ef), top: B:391:0x0146 }] */
        /* JADX WARN: Code duplicated, block: B:274:0x2d0e  */
        /* JADX WARN: Code duplicated, block: B:277:0x2d19  */
        /* JADX WARN: Code duplicated, block: B:278:0x2d1e A[Catch: all -> 0x0264, TryCatch #1 {all -> 0x0264, blocks: (B:6:0x0146, B:8:0x0153, B:9:0x019a, B:24:0x03af, B:26:0x03bc, B:27:0x040c, B:36:0x05af, B:38:0x05bc, B:39:0x0603, B:66:0x087e, B:68:0x0884, B:69:0x08cd, B:80:0x0ab4, B:82:0x0ac1, B:83:0x0b11, B:94:0x0e09, B:96:0x0e16, B:97:0x0e65, B:107:0x1000, B:109:0x100d, B:110:0x1053, B:133:0x1275, B:135:0x1282, B:136:0x12cd, B:151:0x14ad, B:153:0x14ba, B:154:0x1501, B:189:0x181f, B:191:0x1825, B:192:0x1860, B:197:0x1968, B:199:0x1979, B:200:0x19b9, B:208:0x1af3, B:210:0x1b00, B:211:0x1b48, B:213:0x1b51, B:215:0x1b69, B:216:0x1bbf, B:271:0x2cc0, B:273:0x2ccd, B:275:0x2d10, B:291:0x322d, B:293:0x323a, B:294:0x3285, B:300:0x3362, B:302:0x336f, B:303:0x33bb, B:371:0x3a70, B:373:0x3a7d, B:374:0x3ac0, B:278:0x2d1e, B:280:0x2d36, B:281:0x2d85, B:226:0x28ef, B:228:0x28fc, B:230:0x294d, B:250:0x29f6, B:252:0x2a03, B:253:0x2a4e, B:235:0x296a, B:237:0x2977, B:238:0x29c2, B:178:0x169a, B:180:0x16a7, B:181:0x16ef, B:45:0x0702, B:47:0x070f, B:48:0x0757, B:54:0x079a, B:56:0x07a7, B:57:0x07ef), top: B:391:0x0146 }] */
        /* JADX WARN: Code duplicated, block: B:280:0x2d36 A[Catch: all -> 0x0264, TryCatch #1 {all -> 0x0264, blocks: (B:6:0x0146, B:8:0x0153, B:9:0x019a, B:24:0x03af, B:26:0x03bc, B:27:0x040c, B:36:0x05af, B:38:0x05bc, B:39:0x0603, B:66:0x087e, B:68:0x0884, B:69:0x08cd, B:80:0x0ab4, B:82:0x0ac1, B:83:0x0b11, B:94:0x0e09, B:96:0x0e16, B:97:0x0e65, B:107:0x1000, B:109:0x100d, B:110:0x1053, B:133:0x1275, B:135:0x1282, B:136:0x12cd, B:151:0x14ad, B:153:0x14ba, B:154:0x1501, B:189:0x181f, B:191:0x1825, B:192:0x1860, B:197:0x1968, B:199:0x1979, B:200:0x19b9, B:208:0x1af3, B:210:0x1b00, B:211:0x1b48, B:213:0x1b51, B:215:0x1b69, B:216:0x1bbf, B:271:0x2cc0, B:273:0x2ccd, B:275:0x2d10, B:291:0x322d, B:293:0x323a, B:294:0x3285, B:300:0x3362, B:302:0x336f, B:303:0x33bb, B:371:0x3a70, B:373:0x3a7d, B:374:0x3ac0, B:278:0x2d1e, B:280:0x2d36, B:281:0x2d85, B:226:0x28ef, B:228:0x28fc, B:230:0x294d, B:250:0x29f6, B:252:0x2a03, B:253:0x2a4e, B:235:0x296a, B:237:0x2977, B:238:0x29c2, B:178:0x169a, B:180:0x16a7, B:181:0x16ef, B:45:0x0702, B:47:0x070f, B:48:0x0757, B:54:0x079a, B:56:0x07a7, B:57:0x07ef), top: B:391:0x0146 }] */
        /* JADX WARN: Code duplicated, block: B:314:0x34fe  */
        /* JADX WARN: Code duplicated, block: B:317:0x36dc  */
        /* JADX WARN: Code duplicated, block: B:319:0x36eb  */
        /* JADX WARN: Code duplicated, block: B:338:0x3782  */
        /* JADX WARN: Code duplicated, block: B:344:0x37a3  */
        /* JADX WARN: Code duplicated, block: B:345:0x384c  */
        /* JADX WARN: Code duplicated, block: B:349:0x38a0 A[Catch: all -> 0x39c5, TryCatch #2 {all -> 0x39c5, blocks: (B:347:0x3893, B:349:0x38a0, B:350:0x38f5), top: B:393:0x3893, outer: #7 }] */
        /* JADX WARN: Code duplicated, block: B:355:0x39a7  */
        /* JADX WARN: Code duplicated, block: B:356:0x39ad  */
        /* JADX WARN: Code duplicated, block: B:358:0x39be  */
        /* JADX WARN: Code duplicated, block: B:359:0x39c0  */
        /* JADX WARN: Code duplicated, block: B:369:0x39d6  */
        /* JADX WARN: Code duplicated, block: B:370:0x3a35  */
        /* JADX WARN: Code duplicated, block: B:373:0x3a7d A[Catch: all -> 0x0264, TryCatch #1 {all -> 0x0264, blocks: (B:6:0x0146, B:8:0x0153, B:9:0x019a, B:24:0x03af, B:26:0x03bc, B:27:0x040c, B:36:0x05af, B:38:0x05bc, B:39:0x0603, B:66:0x087e, B:68:0x0884, B:69:0x08cd, B:80:0x0ab4, B:82:0x0ac1, B:83:0x0b11, B:94:0x0e09, B:96:0x0e16, B:97:0x0e65, B:107:0x1000, B:109:0x100d, B:110:0x1053, B:133:0x1275, B:135:0x1282, B:136:0x12cd, B:151:0x14ad, B:153:0x14ba, B:154:0x1501, B:189:0x181f, B:191:0x1825, B:192:0x1860, B:197:0x1968, B:199:0x1979, B:200:0x19b9, B:208:0x1af3, B:210:0x1b00, B:211:0x1b48, B:213:0x1b51, B:215:0x1b69, B:216:0x1bbf, B:271:0x2cc0, B:273:0x2ccd, B:275:0x2d10, B:291:0x322d, B:293:0x323a, B:294:0x3285, B:300:0x3362, B:302:0x336f, B:303:0x33bb, B:371:0x3a70, B:373:0x3a7d, B:374:0x3ac0, B:278:0x2d1e, B:280:0x2d36, B:281:0x2d85, B:226:0x28ef, B:228:0x28fc, B:230:0x294d, B:250:0x29f6, B:252:0x2a03, B:253:0x2a4e, B:235:0x296a, B:237:0x2977, B:238:0x29c2, B:178:0x169a, B:180:0x16a7, B:181:0x16ef, B:45:0x0702, B:47:0x070f, B:48:0x0757, B:54:0x079a, B:56:0x07a7, B:57:0x07ef), top: B:391:0x0146 }] */
        /* JADX WARN: Code duplicated, block: B:377:0x3b76  */
        /* JADX WARN: Code duplicated, block: B:378:0x3bd2  */
        /* JADX WARN: Code duplicated, block: B:408:0x0f2b A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:409:0x0f49 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:410:0x151c A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:420:0x37a0 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:64:0x0809  */
        /* JADX WARN: Code duplicated, block: B:65:0x087b  */
        /* JADX WARN: Code duplicated, block: B:68:0x0884 A[Catch: all -> 0x0264, TryCatch #1 {all -> 0x0264, blocks: (B:6:0x0146, B:8:0x0153, B:9:0x019a, B:24:0x03af, B:26:0x03bc, B:27:0x040c, B:36:0x05af, B:38:0x05bc, B:39:0x0603, B:66:0x087e, B:68:0x0884, B:69:0x08cd, B:80:0x0ab4, B:82:0x0ac1, B:83:0x0b11, B:94:0x0e09, B:96:0x0e16, B:97:0x0e65, B:107:0x1000, B:109:0x100d, B:110:0x1053, B:133:0x1275, B:135:0x1282, B:136:0x12cd, B:151:0x14ad, B:153:0x14ba, B:154:0x1501, B:189:0x181f, B:191:0x1825, B:192:0x1860, B:197:0x1968, B:199:0x1979, B:200:0x19b9, B:208:0x1af3, B:210:0x1b00, B:211:0x1b48, B:213:0x1b51, B:215:0x1b69, B:216:0x1bbf, B:271:0x2cc0, B:273:0x2ccd, B:275:0x2d10, B:291:0x322d, B:293:0x323a, B:294:0x3285, B:300:0x3362, B:302:0x336f, B:303:0x33bb, B:371:0x3a70, B:373:0x3a7d, B:374:0x3ac0, B:278:0x2d1e, B:280:0x2d36, B:281:0x2d85, B:226:0x28ef, B:228:0x28fc, B:230:0x294d, B:250:0x29f6, B:252:0x2a03, B:253:0x2a4e, B:235:0x296a, B:237:0x2977, B:238:0x29c2, B:178:0x169a, B:180:0x16a7, B:181:0x16ef, B:45:0x0702, B:47:0x070f, B:48:0x0757, B:54:0x079a, B:56:0x07a7, B:57:0x07ef), top: B:391:0x0146 }] */
        /* JADX WARN: Code duplicated, block: B:72:0x0951  */
        /* JADX WARN: Code duplicated, block: B:74:0x09c9  */
        /* JADX WARN: Code duplicated, block: B:75:0x09d2  */
        /* JADX WARN: Code duplicated, block: B:76:0x09de  */
        /* JADX WARN: Code duplicated, block: B:78:0x09e1  */
        /* JADX WARN: Code duplicated, block: B:79:0x0a57  */
        /* JADX WARN: Code duplicated, block: B:82:0x0ac1 A[Catch: all -> 0x0264, TryCatch #1 {all -> 0x0264, blocks: (B:6:0x0146, B:8:0x0153, B:9:0x019a, B:24:0x03af, B:26:0x03bc, B:27:0x040c, B:36:0x05af, B:38:0x05bc, B:39:0x0603, B:66:0x087e, B:68:0x0884, B:69:0x08cd, B:80:0x0ab4, B:82:0x0ac1, B:83:0x0b11, B:94:0x0e09, B:96:0x0e16, B:97:0x0e65, B:107:0x1000, B:109:0x100d, B:110:0x1053, B:133:0x1275, B:135:0x1282, B:136:0x12cd, B:151:0x14ad, B:153:0x14ba, B:154:0x1501, B:189:0x181f, B:191:0x1825, B:192:0x1860, B:197:0x1968, B:199:0x1979, B:200:0x19b9, B:208:0x1af3, B:210:0x1b00, B:211:0x1b48, B:213:0x1b51, B:215:0x1b69, B:216:0x1bbf, B:271:0x2cc0, B:273:0x2ccd, B:275:0x2d10, B:291:0x322d, B:293:0x323a, B:294:0x3285, B:300:0x3362, B:302:0x336f, B:303:0x33bb, B:371:0x3a70, B:373:0x3a7d, B:374:0x3ac0, B:278:0x2d1e, B:280:0x2d36, B:281:0x2d85, B:226:0x28ef, B:228:0x28fc, B:230:0x294d, B:250:0x29f6, B:252:0x2a03, B:253:0x2a4e, B:235:0x296a, B:237:0x2977, B:238:0x29c2, B:178:0x169a, B:180:0x16a7, B:181:0x16ef, B:45:0x0702, B:47:0x070f, B:48:0x0757, B:54:0x079a, B:56:0x07a7, B:57:0x07ef), top: B:391:0x0146 }] */
        /* JADX WARN: Code duplicated, block: B:86:0x0bce  */
        /* JADX WARN: Code duplicated, block: B:87:0x0bd5  */
        /* JADX WARN: Code duplicated, block: B:89:0x0bd8  */
        /* JADX WARN: Code duplicated, block: B:90:0x0c3a  */
        /* JADX WARN: Code duplicated, block: B:93:0x0e07  */
        /* JADX WARN: Code duplicated, block: B:96:0x0e16 A[Catch: all -> 0x0264, TryCatch #1 {all -> 0x0264, blocks: (B:6:0x0146, B:8:0x0153, B:9:0x019a, B:24:0x03af, B:26:0x03bc, B:27:0x040c, B:36:0x05af, B:38:0x05bc, B:39:0x0603, B:66:0x087e, B:68:0x0884, B:69:0x08cd, B:80:0x0ab4, B:82:0x0ac1, B:83:0x0b11, B:94:0x0e09, B:96:0x0e16, B:97:0x0e65, B:107:0x1000, B:109:0x100d, B:110:0x1053, B:133:0x1275, B:135:0x1282, B:136:0x12cd, B:151:0x14ad, B:153:0x14ba, B:154:0x1501, B:189:0x181f, B:191:0x1825, B:192:0x1860, B:197:0x1968, B:199:0x1979, B:200:0x19b9, B:208:0x1af3, B:210:0x1b00, B:211:0x1b48, B:213:0x1b51, B:215:0x1b69, B:216:0x1bbf, B:271:0x2cc0, B:273:0x2ccd, B:275:0x2d10, B:291:0x322d, B:293:0x323a, B:294:0x3285, B:300:0x3362, B:302:0x336f, B:303:0x33bb, B:371:0x3a70, B:373:0x3a7d, B:374:0x3ac0, B:278:0x2d1e, B:280:0x2d36, B:281:0x2d85, B:226:0x28ef, B:228:0x28fc, B:230:0x294d, B:250:0x29f6, B:252:0x2a03, B:253:0x2a4e, B:235:0x296a, B:237:0x2977, B:238:0x29c2, B:178:0x169a, B:180:0x16a7, B:181:0x16ef, B:45:0x0702, B:47:0x070f, B:48:0x0757, B:54:0x079a, B:56:0x07a7, B:57:0x07ef), top: B:391:0x0146 }] */
        public static Object[] CoroutineDebuggingKt(Context context, int i, int i2, int i3) throws Throwable {
            String str;
            String str2;
            int i4;
            String str3;
            int i5;
            int i6;
            int i7;
            Object objAccessartificialFrame;
            int i8;
            int i9;
            String str4;
            Object objAccessartificialFrame2;
            int i10;
            int i11;
            int i12;
            String[] strArr;
            int i13;
            String str5;
            int i14;
            String str6;
            Object objAccessartificialFrame3;
            String str7;
            int i15;
            File file;
            int i16;
            Object objAccessartificialFrame4;
            String lowerCase;
            char c;
            int minimumFlingVelocity;
            int i17;
            Object obj;
            int i18;
            String[] strArr2;
            int i19;
            int i20;
            File file2;
            Object objAccessartificialFrame5;
            long j;
            int i21;
            int i22;
            int i23;
            int i24;
            int i25;
            Object objAccessartificialFrame6;
            int i26;
            int i27;
            Object objAccessartificialFrame7;
            int i28;
            int i29;
            int i30;
            Object objAccessartificialFrame8;
            Object objInvoke;
            String[][] strArr3;
            char c2;
            int i31;
            String str8;
            ArrayList arrayList;
            int i32;
            int i33;
            int i34;
            String str9;
            int i35;
            Object[] objArr;
            int i36;
            int i37;
            char c3;
            int i38;
            int i39;
            Object[] objArr2;
            int i40;
            String[] strArr4;
            Object objAccessartificialFrame9;
            String str10;
            String[] strArr5;
            int i41;
            String[][] strArr6;
            int i42;
            Object objAccessartificialFrame10;
            int i43;
            int i44;
            Object objAccessartificialFrame11;
            Object objAccessartificialFrame12;
            String str11;
            Object objInvoke2;
            Object objAccessartificialFrame13;
            int i45;
            String str12;
            char c4;
            int i46;
            String[][] strArr7;
            int i47;
            int i48;
            int i49;
            int i50;
            int i51;
            Object objAccessartificialFrame14;
            int i52;
            Object objAccessartificialFrame15;
            int i53;
            int i54;
            int i55;
            String str13;
            String[] strArr8;
            int length;
            int i56;
            File file3;
            String[][] strArr9;
            String[] strArr10;
            Object objAccessartificialFrame16;
            int i57;
            int i58;
            String next;
            Object objAccessartificialFrame17;
            String str14;
            Object[] objArr3;
            Object objAccessartificialFrame18;
            String[] strArr11;
            int i59;
            int i60;
            int i61;
            int i62;
            int i63;
            int i64;
            int i65 = 2 % 2;
            int i66 = -ExpandableListView.getPackedPositionGroup(0L);
            int i67 = 1;
            int i68 = -(-(Process.myTid() >> 22));
            int i69 = (i68 ^ 717) + ((i68 & 717) << 1);
            int i70 = 0;
            int bitsPerPixel = ImageFormat.getBitsPerPixel(0);
            int i71 = ((bitsPerPixel | 9) << 1) - (bitsPerPixel ^ 9);
            Object[] objArr4 = new Object[1];
            a((char) ((i66 ^ 2358) + ((i66 & 2358) << 1)), i69, i71, objArr4);
            String str15 = (String) objArr4[0];
            String str16 = "";
            char capsMode = (char) TextUtils.getCapsMode("", 0, 0);
            int threadPriority = Process.getThreadPriority(0);
            int i72 = -(-Color.argb(0, 0, 0, 0));
            int i73 = ((i72 | 27) << 1) - (i72 ^ 27);
            Object[] objArr5 = new Object[1];
            a(capsMode, ((threadPriority ^ 20) + ((threadPriority & 20) << 1)) >> 6, i73, objArr5);
            String str17 = (String) objArr5[0];
            char cIndexOf = (char) TextUtils.indexOf("", "", 0, 0);
            int tapTimeout = ViewConfiguration.getTapTimeout() >> 16;
            int i74 = ((tapTimeout | 27) << 1) - (tapTimeout ^ 27);
            int i75 = -(ViewConfiguration.getMinimumFlingVelocity() >> 16);
            int i76 = ((i75 | 25) << 1) - (i75 ^ 25);
            Object[] objArr6 = new Object[1];
            a(cIndexOf, i74, i76, objArr6);
            String str18 = (String) objArr6[0];
            int i77 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
            int i78 = i77 * (-109);
            int i79 = (i78 & (-111)) + (i78 | (-111));
            int i80 = ~i77;
            int i81 = (i ^ (-1)) | i;
            int i82 = ((~i81) | i80) * (-220);
            int i83 = (i79 ^ i82) + ((i82 & i79) << 1);
            int i84 = ~(i80 | i77);
            int i85 = ~i81;
            int i86 = ((i84 & i85) | (i84 ^ i85)) * 220;
            int i87 = ((i83 | i86) << 1) - (i83 ^ i86);
            int i88 = ~i77;
            char c5 = (char) ((i87 - (~(((~(i88 | (~i88))) | (~i77)) * b.f39n))) - 1);
            int i89 = -KeyEvent.keyCodeFromString("");
            int i90 = -TextUtils.lastIndexOf("", '0', 0, 0);
            int iIPostMessageServiceStubProxy = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
            int i91 = ~((-18) | i90);
            int i92 = ~iIPostMessageServiceStubProxy;
            int i93 = ~((i92 ^ 17) | (i92 & 17));
            int i94 = (i90 * (-1939)) + 16507 + (((i91 ^ i93) | (i91 & i93)) * (-970));
            int i95 = ~i90;
            int i96 = i94 + ((~(i95 | 17)) * 1940);
            int i97 = ~((i95 & (-18)) | (i95 ^ (-18)));
            int i98 = ~iIPostMessageServiceStubProxy;
            int i99 = ~((i98 & 17) | (i98 ^ 17));
            int i100 = -(-(((i97 & i99) | (i97 ^ i99)) * 970));
            int i101 = ((i96 | i100) << 1) - (i100 ^ i96);
            Object[] objArr7 = new Object[1];
            a(c5, (i89 ^ 52) + ((i89 & 52) << 1), i101, objArr7);
            String str19 = (String) objArr7[0];
            char defaultSize = (char) View.getDefaultSize(0, 0);
            int trimmedLength = TextUtils.getTrimmedLength("");
            Object[] objArr8 = new Object[1];
            a(defaultSize, ((trimmedLength | 70) << 1) - (trimmedLength ^ 70), AndroidCharacter.getMirror('0') - 20, objArr8);
            String[] strArr12 = {str17, str18, str19, (String) objArr8[0]};
            int i102 = 0;
            while (true) {
                if (i102 >= 4) {
                    str = str15;
                    str2 = str16;
                    i4 = i;
                    break;
                }
                try {
                    Object[] objArr9 = {strArr12[i102]};
                    Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(267846469);
                    if (objAccessartificialFrame19 == null) {
                        int i103 = (ExpandableListView.getPackedPositionForGroup(i70) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(i70) == 0L ? 0 : -1)) + 17;
                        char capsMode2 = (char) (TextUtils.getCapsMode(str16, i70, i70) + 24343);
                        int i104 = 2015 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                        byte[] bArr = $$a;
                        byte b = bArr[6];
                        Object[] objArr10 = new Object[i67];
                        b(b, (byte) (b + 5), (byte) (-bArr[4]), objArr10);
                        String str20 = (String) objArr10[i70];
                        Class[] clsArr = new Class[i67];
                        clsArr[i70] = String.class;
                        objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(i103, capsMode2, i104, -1869462195, false, str20, clsArr);
                    }
                    long jLongValue = ((Long) ((Method) objAccessartificialFrame19).invoke(null, objArr9)).longValue();
                    long j2 = -91326326;
                    str = str15;
                    long j3 = (((long) (-665)) * j2) + (((long) 334) * jLongValue);
                    str2 = str16;
                    long j4 = -1;
                    long j5 = j2 ^ j4;
                    long j6 = 333;
                    long startElapsedRealtime = (int) Process.getStartElapsedRealtime();
                    long j7 = startElapsedRealtime ^ j4;
                    long j8 = j3 + (((long) (-333)) * j5) + ((((j5 | j7) ^ j4) | ((jLongValue | startElapsedRealtime) ^ j4)) * j6) + (j6 * (((startElapsedRealtime | j5) ^ j4) | ((j7 | jLongValue) ^ j4))) + ((long) (-1220305650));
                    int i105 = (int) Runtime.getRuntime().totalMemory();
                    int i106 = ~i105;
                    int i107 = ((int) (j8 >> 32)) & (646215559 + (((~((-426021568) | i106)) | 18878484) * 98) + (((~(i106 | (-1011204844))) | (-426021568) | (~(1011204843 | i105))) * (-49)) + (((~(i105 | (-426021568))) | (-1030083328)) * 49));
                    int iUptimeMillis = (int) SystemClock.uptimeMillis();
                    int i108 = (~((-857607911) | iUptimeMillis)) | 857082470;
                    if (((((int) j8) & ((-1537497691) + (i108 * 992) + ((i108 | (~((~iUptimeMillis) | 2000658415))) * (-496)) + ((iUptimeMillis | 2000132975) * 496))) | i107) != 0) {
                        int i109 = i102 + FacebookRequestErrorClassification.EC_INVALID_TOKEN;
                        i4 = ((~i109) & i) | (i109 & (~i));
                        break;
                    }
                    int i110 = i102 - 23;
                    i102 = ((i110 & 24) << 1) + (i110 ^ 24);
                    str15 = str;
                    str16 = str2;
                    i70 = 0;
                    i67 = 1;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            }
            int i111 = 3;
            if (i4 != i) {
                Object[] objArr11 = {null, new int[]{((~i) & i) | ((~i) & i)}, null, new int[]{i}, new int[]{i4}};
                int i112 = i3 + (((~(i | 578394499)) * TypedValues.CycleType.TYPE_EASING) - 1957385135) + (((~((~i) | 578394499)) | 1608066) * TypedValues.CycleType.TYPE_EASING) + 16;
                int i113 = i112 ^ (i112 << 13);
                int i114 = i113 >>> 17;
                int i115 = ((~i113) & i114) | ((~i114) & i113);
                int i116 = i115 << 5;
                return objArr11;
            }
            int i117 = -(-TextUtils.getTrimmedLength(str2));
            int scrollBarFadeDuration = ViewConfiguration.getScrollBarFadeDuration() >> 16;
            int i118 = (scrollBarFadeDuration ^ 98) + ((scrollBarFadeDuration & 98) << 1);
            int i119 = -(-(KeyEvent.getMaxKeyCode() >> 16));
            int i120 = (i119 ^ 12) + ((i119 & 12) << 1);
            Object[] objArr12 = new Object[1];
            a((char) ((i117 ^ 43467) + ((i117 & 43467) << 1)), i118, i120, objArr12);
            String str21 = (String) objArr12[0];
            int jumpTapTimeout = ViewConfiguration.getJumpTapTimeout() >> 16;
            int i121 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
            int i122 = -(Process.myPid() >> 22);
            int iIPostMessageServiceStubProxy2 = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
            int i123 = (i122 * 236) + 6123;
            int i124 = ~i122;
            int i125 = -(-(((~((~iIPostMessageServiceStubProxy2) | i124)) | 13) * (-235)));
            int i126 = (i123 ^ i125) + ((i123 & i125) << 1);
            int i127 = ~((i124 ^ iIPostMessageServiceStubProxy2) | (i124 & iIPostMessageServiceStubProxy2));
            int i128 = i126 + (((i127 & 13) | (i127 ^ 13)) * (-470));
            int i129 = ~(((-14) & i122) | ((-14) ^ i122));
            int i130 = (~i122) | 13;
            int i131 = ~((i130 & iIPostMessageServiceStubProxy2) | (i130 ^ iIPostMessageServiceStubProxy2));
            int i132 = -(-(((i131 & i129) | (i129 ^ i131)) * 235));
            int i133 = (i128 ^ i132) + ((i132 & i128) << 1);
            Object[] objArr13 = new Object[1];
            a((char) ((jumpTapTimeout ^ 63513) + ((jumpTapTimeout & 63513) << 1)), i121, i133, objArr13);
            String str22 = (String) objArr13[0];
            int i134 = -(TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
            String str23 = str2;
            int i135 = 121 - (~(-TextUtils.lastIndexOf(str23, '0', 0)));
            int i136 = -(-Color.red(0));
            int i137 = 1;
            int i138 = ((i136 | 18) << 1) - (i136 ^ 18);
            Object[] objArr14 = new Object[1];
            a((char) (((i134 | 9703) << 1) - (i134 ^ 9703)), i135, i138, objArr14);
            String[] strArr13 = {str21, str22, (String) objArr14[0]};
            int i139 = 0;
            while (true) {
                if (i139 >= i111) {
                    str3 = str23;
                    i5 = i;
                    break;
                }
                int i140 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i141 = ((i140 | 9) << i137) - (i140 ^ 9);
                artificialFrame = i141 % 128;
                int i142 = i141 % 2;
                Object[] objArr15 = {strArr13[i139]};
                Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-11453480);
                if (objAccessartificialFrame20 == null) {
                    int windowTouchSlop = 17 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                    char cRgb = (char) ((-16752873) - Color.rgb(0, 0, 0));
                    int i143 = 2014 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                    byte[] bArr2 = $$a;
                    Object[] objArr16 = new Object[1];
                    b((byte) (-bArr2[22]), bArr2[20], (byte) (-bArr2[4]), objArr16);
                    objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(windowTouchSlop, cRgb, i143, 1614052816, false, (String) objArr16[0], new Class[]{String.class});
                }
                long jLongValue2 = ((Long) ((Method) objAccessartificialFrame20).invoke(null, objArr15)).longValue();
                long j9 = 1433517912;
                str3 = str23;
                int i144 = i139;
                long j10 = -1;
                long j11 = jLongValue2 ^ j10;
                long jMyTid = Process.myTid();
                long j12 = (j9 | jMyTid) ^ j10;
                long j13 = 407;
                long j14 = j9 ^ j10;
                long j15 = (j14 | jLongValue2) ^ j10;
                long j16 = (((long) (-813)) * j9) + (((long) TSLocationManager.LOCATION_ERROR_TIMEOUT) * jLongValue2) + (((long) (-814)) * (((j11 | j9) ^ j10) | j12)) + ((((j11 | (jMyTid ^ j10)) ^ j10) | j15 | j12) * j13) + (j13 * ((j10 ^ (jLongValue2 | jMyTid)) | j15 | ((j14 | jMyTid) ^ j10))) + ((long) 128613125);
                int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
                int i145 = ~((-338008900) | iElapsedRealtime);
                int i146 = ((int) (j16 >> 32)) & ((-1630137788) + ((364610 | i145) * (-814)) + ((i145 | (~((~iElapsedRealtime) | (-1775235311))) | (-2112879600)) * 407) + (((~(iElapsedRealtime | 1775235310)) | (~(338008899 | iElapsedRealtime)) | (-2112879600)) * 407));
                int i147 = ~i;
                int i148 = ~(1609161938 | i147);
                if ((i146 | (((int) j16) & (((360714320 | i148) * (-374)) + 1557969225 + ((i148 | 1248447618) * 374)))) != 0) {
                    int iIPostMessageServiceStubProxy3 = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                    int i149 = i144 * (-493);
                    int i150 = ((133650 | i149) << 1) - (i149 ^ 133650);
                    int i151 = ~i144;
                    int i152 = i150 + (((i151 & RotationOptions.ROTATE_270) | (i151 ^ RotationOptions.ROTATE_270)) * (-988));
                    int i153 = (i144 ^ (-271)) | (i144 & (-271));
                    int i154 = ~iIPostMessageServiceStubProxy3;
                    int i155 = i152 + (((i153 & i154) | (i153 ^ i154)) * 494);
                    int i156 = ~i144;
                    int i157 = (~((i154 & i144) | (i154 ^ i144))) | (~((i156 & (-271)) | ((-271) ^ i156)));
                    int i158 = ~(i144 | RotationOptions.ROTATE_270);
                    int i159 = ((i157 & i158) | (i157 ^ i158)) * 494;
                    int i160 = ((i155 | i159) << 1) - (i159 ^ i155);
                    i5 = ((~i160) & i) | (i160 & i147);
                    break;
                }
                i139 = i144 + 1;
                str23 = str3;
                i111 = 3;
                i137 = 1;
            }
            if (i5 != i) {
                Object[] objArr17 = {null, new int[1], null, new int[]{i}, new int[]{i5}};
                int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
                int i161 = 956806548 + ((~(521038073 | iFreeMemory)) * (-301)) + (((~((-353249361) | iFreeMemory)) | (~((~iFreeMemory) | 252199097))) * (-301)) + (((~(iFreeMemory | (-252199098))) | (-353249361)) * 301);
                int i162 = (i3 - (~((i161 ^ 16) + ((i161 & 16) << 1)))) - 1;
                int i163 = i162 << 13;
                int i164 = (i162 | i163) & (~(i162 & i163));
                int i165 = i164 ^ (i164 >>> 17);
                ((int[]) objArr17[1])[0] = i165 ^ (i165 << 5);
                return objArr17;
            }
            String str24 = str3;
            Object[] objArr18 = new Object[1];
            a((char) (25191 - TextUtils.indexOf((CharSequence) str24, '0', 0, 0)), 142 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 14 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), objArr18);
            Object[] objArr19 = {(String) objArr18[0]};
            Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(-11453480);
            if (objAccessartificialFrame21 == null) {
                int size = 17 - View.MeasureSpec.getSize(0);
                char absoluteGravity = (char) (24343 - Gravity.getAbsoluteGravity(0, 0));
                int iGreen = Color.green(0) + 2014;
                byte[] bArr3 = $$a;
                Object[] objArr20 = new Object[1];
                b((byte) (-bArr3[22]), bArr3[20], (byte) (-bArr3[4]), objArr20);
                objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(size, absoluteGravity, iGreen, 1614052816, false, (String) objArr20[0], new Class[]{String.class});
            }
            long jLongValue3 = ((Long) ((Method) objAccessartificialFrame21).invoke(null, objArr19)).longValue();
            int i166 = artificialFrame;
            int i167 = ((i166 | 49) << 1) - (i166 ^ 49);
            getARTIFICIAL_FRAME_PACKAGE_NAME = i167 % 128;
            int i168 = i167 % 2;
            long j17 = 1553004486;
            long j18 = -721;
            long j19 = i;
            long j20 = -1;
            long j21 = j19 ^ j20;
            long j22 = j17 ^ j20;
            long j23 = jLongValue3 ^ j20;
            long j24 = (j17 | jLongValue3) ^ j20;
            long j25 = (j18 * j17) + (j18 * jLongValue3) + (((long) 1444) * (j21 | ((j22 | j23) ^ j20) | j24)) + (((long) (-1444)) * (j24 | ((j17 | j19) ^ j20) | ((jLongValue3 | j19) ^ j20))) + (((long) 722) * (((j22 | jLongValue3) ^ j20) | ((j23 | j17) ^ j20))) + ((long) 9126551);
            int i169 = ~i;
            int i170 = ((int) (j25 >> 32)) & ((-2072279902) + ((~((-811076711) | i169)) * (-116)) + (((-1887243631) | i) * 116) + (((~(970497254 | i)) | (-2046664175)) * 116));
            int i171 = ((int) j25) & (2055568080 + (((~((-438452158) | i169)) | (-1875678568)) * 226) + (((~(1875678567 | i)) | (-2146353152) | (~((-167777574) | i169))) * (-113)) + ((~((-438452158) | i)) * 113));
            if (((i170 & i171) | (i170 ^ i171)) == 0) {
                int i172 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                char c6 = (char) (((i172 | 29583) << 1) - (i172 ^ 29583));
                int i173 = -(Process.myTid() >> 22);
                int i174 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                int i175 = (i174 ^ 24) + ((i174 & 24) << 1);
                Object[] objArr21 = new Object[1];
                a(c6, (i173 ^ 155) + ((i173 & 155) << 1), i175, objArr21);
                Object[] objArr22 = {(String) objArr21[0]};
                Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                if (objAccessartificialFrame22 == null) {
                    int modifierMetaStateMask = 22 - ((byte) KeyEvent.getModifierMetaStateMask());
                    char gidForName = (char) ((-1) - Process.getGidForName(str24));
                    int i176 = 2442 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                    byte[] bArr4 = $$a;
                    Object[] objArr23 = new Object[1];
                    b((byte) 49, bArr4[16], bArr4[10], objArr23);
                    objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask, gidForName, i176, 954751276, false, (String) objArr23[0], new Class[]{String.class});
                }
                String str25 = (String) ((Method) objAccessartificialFrame22).invoke(null, objArr22);
                if (str25 == null || str25.length() == 0) {
                    char cCombineMeasuredStates = (char) View.combineMeasuredStates(0, 0);
                    int i177 = -Color.red(0);
                    Object[] objArr24 = new Object[1];
                    a(cCombineMeasuredStates, ((i177 | 179) << 1) - (i177 ^ 179), 22 - (~(-(-(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))))), objArr24);
                    Object[] objArr25 = {(String) objArr24[0]};
                    Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                    if (objAccessartificialFrame23 == null) {
                        int iRgb = Color.rgb(0, 0, 0) + 16777239;
                        char mirror = (char) ('0' - AndroidCharacter.getMirror('0'));
                        int touchSlop = (ViewConfiguration.getTouchSlop() >> 8) + 2441;
                        byte[] bArr5 = $$a;
                        Object[] objArr26 = new Object[1];
                        b((byte) 49, bArr5[16], bArr5[10], objArr26);
                        objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(iRgb, mirror, touchSlop, 954751276, false, (String) objArr26[0], new Class[]{String.class});
                    }
                    String str26 = (String) ((Method) objAccessartificialFrame23).invoke(null, objArr25);
                    i6 = (str26 == null || str26.length() == 0) ? i : (i & (-268)) | (i169 & 267);
                } else {
                    i7 = (i & (-268)) | (i169 & 267);
                }
                if (i6 != i) {
                    Object[] objArr27 = {null, new int[]{(i | i) & (~(i & i))}, null, new int[]{i}, new int[]{i6}};
                    int i178 = (((~((-270887960) | i169)) | 327685 | (~(i169 | 334560498))) * (-397)) + 967163305 + ((i | 64327909) * 397);
                    int i179 = -(-(((i178 | 16) << 1) - (i178 ^ 16)));
                    int i180 = (i3 ^ i179) + ((i3 & i179) << 1);
                    int i181 = i180 << 13;
                    int i182 = (i181 | i180) & (~(i180 & i181));
                    int i183 = i182 >>> 17;
                    int i184 = (i182 | i183) & (~(i182 & i183));
                    int i185 = getARTIFICIAL_FRAME_PACKAGE_NAME + 119;
                    artificialFrame = i185 % 128;
                    int i186 = i185 % 2;
                    int i187 = i184 << 5;
                    return objArr27;
                }
                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(943212816);
                if (objAccessartificialFrame == null) {
                    int packedPositionType = 7 - ExpandableListView.getPackedPositionType(0L);
                    char cMyPid = (char) ((Process.myPid() >> 22) + 49362);
                    int packedPositionGroup = 1768 - ExpandableListView.getPackedPositionGroup(0L);
                    byte[] bArr6 = $$a;
                    Object[] objArr28 = new Object[1];
                    b((byte) (bArr6[5] - 1), (byte) (-bArr6[19]), bArr6[16], objArr28);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(packedPositionType, cMyPid, packedPositionGroup, -1487073512, false, (String) objArr28[0], new Class[0]);
                }
                long jLongValue4 = ((Long) ((Method) objAccessartificialFrame).invoke(null, null)).longValue();
                long j26 = 589903974;
                long j27 = -743;
                long j28 = j26 | jLongValue4;
                long j29 = (j27 * j26) + (j27 * jLongValue4) + (((long) (-744)) * ((j28 ^ j20) | ((j26 | j19) ^ j20) | ((jLongValue4 | j19) ^ j20)));
                long j30 = 744;
                long j31 = j29 + ((j21 | (((jLongValue4 ^ j20) | (j26 ^ j20)) ^ j20)) * j30) + (j30 * (j28 | j19)) + ((long) 785987776);
                int i188 = ~((-1892224307) | i169);
                int i189 = ((int) (j31 >> 32)) & (((151293952 | i188) * (-374)) + 1958239788 + ((i188 | (-2043518259)) * 374));
                int i190 = ((int) j31) & ((((~(930795069 | i)) | 134545728) * (-566)) + 1701211605 + ((~(1065340797 | i)) * 566));
                i8 = (i190 & i189) | (i189 ^ i190);
                if (i8 != 0) {
                    int i191 = ((1970767624 ^ i) | (1970767624 & i)) * 140;
                    int i192 = ((-637605803) & i191) + (i191 | (-637605803));
                    int i193 = ~i;
                    int i194 = ~((1970767624 & i193) | (i193 ^ 1970767624));
                    int i195 = i192 + (((i194 & 142618753) | (142618753 ^ i194)) * (-280));
                    int i196 = ~((1305917313 & i193) | (i193 ^ 1305917313));
                    int i197 = (i196 & 807469064) | (807469064 ^ i196);
                    int i198 = ~(((-142618754) & i) | ((-142618754) ^ i));
                    i62 = i195 + (((i197 & i198) | (i197 ^ i198)) * 140);
                    int iIPostMessageServiceStubProxy4 = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                    int i199 = ~((~iIPostMessageServiceStubProxy4) | 2131956);
                    int i200 = -(-(((i199 ^ (-708677632)) | (i199 & (-708677632))) * (-160)));
                    i63 = ((-1351673309) ^ i200) + ((i200 & (-1351673309)) << 1);
                    int i201 = ~iIPostMessageServiceStubProxy4;
                    i64 = ~((i201 & (-706579120)) | ((-706579120) ^ i201));
                    if (i62 > (i63 - (~(-(-(((i64 & 2131956) | (2131956 ^ i64)) * SyslogConstants.LOG_LOCAL4))))) - 1) {
                        int i202 = 13667 >>> i8;
                        i9 = (i202 & i169) | ((~i202) & i);
                    } else {
                        int i203 = i8 - 1;
                        int i204 = (i203 & 200) + (i203 | 200);
                        i9 = (~(i & i204)) & (i204 | i);
                    }
                } else {
                    i9 = i;
                }
                if (i9 != i) {
                    Object[] objArr29 = {null, new int[1], null, new int[]{i}, new int[]{i9}};
                    int iUptimeMillis2 = (int) SystemClock.uptimeMillis();
                    int i205 = ~iUptimeMillis2;
                    int i206 = -(-((-161126627) + (((~(97752846 | i205)) | (-703201305) | (~((-97752847) | iUptimeMillis2))) * (-564)) + ((~(iUptimeMillis2 | (-29491209))) * 1128) + (((~((-703201305) | i205)) | 68261638) * 564) + 16));
                    int i207 = (i3 & i206) + (i3 | i206);
                    int i208 = i207 << 13;
                    int i209 = (i208 & (~i207)) | ((~i208) & i207);
                    int i210 = i209 >>> 17;
                    int i211 = ((~i209) & i210) | ((~i210) & i209);
                    int i212 = i211 << 5;
                    ((int[]) objArr29[1])[0] = (i211 | i212) & (~(i211 & i212));
                    return objArr29;
                }
                char deadChar = (char) KeyEvent.getDeadChar(0, 0);
                int tapTimeout2 = ViewConfiguration.getTapTimeout() >> 16;
                int i213 = (tapTimeout2 & 203) + (tapTimeout2 | 203);
                str4 = str24;
                int i214 = -TextUtils.lastIndexOf(str4, '0');
                int i215 = (i214 ^ 19) + ((i214 & 19) << 1);
                Object[] objArr30 = new Object[1];
                a(deadChar, i213, i215, objArr30);
                String str27 = (String) objArr30[0];
                int keyRepeatTimeout = ViewConfiguration.getKeyRepeatTimeout() >> 16;
                int i216 = -View.getDefaultSize(0, 0);
                int i217 = (i216 ^ 223) + ((i216 & 223) << 1);
                int i218 = -TextUtils.indexOf(str4, str4, 0);
                Object[] objArr31 = new Object[1];
                a((char) ((keyRepeatTimeout ^ 44923) + ((keyRepeatTimeout & 44923) << 1)), i217, ((i218 | 6) << 1) - (i218 ^ 6), objArr31);
                Object[] objArr32 = {str27, (String) objArr31[0]};
                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-883653127);
                if (objAccessartificialFrame2 == null) {
                    int offsetBefore = TextUtils.getOffsetBefore(str4, 0) + 31;
                    char cMyTid = (char) (57022 - (Process.myTid() >> 22));
                    int absoluteGravity2 = Gravity.getAbsoluteGravity(0, 0) + 2311;
                    byte[] bArr7 = $$a;
                    Object[] objArr33 = new Object[1];
                    b((byte) (bArr7[13] - 1), (byte) (-bArr7[4]), bArr7[10], objArr33);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(offsetBefore, cMyTid, absoluteGravity2, 1412547569, false, (String) objArr33[0], new Class[]{String.class, String.class});
                }
                long jLongValue5 = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr32)).longValue();
                long j32 = 637823228;
                long j33 = 868;
                long j34 = j32 ^ j20;
                long jElapsedRealtime = (int) SystemClock.elapsedRealtime();
                long j35 = jElapsedRealtime ^ j20;
                long j36 = jLongValue5 ^ j20;
                long j37 = j34 | j36;
                long j38 = (j33 * j32) + (j33 * jLongValue5) + (((long) (-867)) * (((j34 | j35) ^ j20) | ((j36 | j35) ^ j20))) + (((long) (-1734)) * ((j37 ^ j20) | ((j34 | jElapsedRealtime) ^ j20) | ((j36 | jElapsedRealtime) ^ j20))) + (((long) 867) * (((jElapsedRealtime | (j36 | j32)) ^ j20) | ((j37 | j35) ^ j20) | (((j34 | jLongValue5) | jElapsedRealtime) ^ j20))) + ((long) (-792574857));
                i10 = ((int) (j38 >> 32)) & (749017786 + ((~(i169 | (-705757253))) * (-783)) + (((~(i169 | (-1781748805))) | 1075992080) * 783));
                int elapsedCpuTime = (int) Process.getElapsedCpuTime();
                i11 = ((int) j38) & (10666256 + ((~((-289440145) | elapsedCpuTime)) * 623) + (((~elapsedCpuTime) | (-2079774715)) * (-623)) + (((~(elapsedCpuTime | (-1903220635))) | (~((-465994225) | elapsedCpuTime)) | 289440144) * 623));
                if (((i11 & i10) | (i10 ^ i11)) != 0) {
                    i12 = (~(i & 262)) & (i | 262);
                } else {
                    i12 = i;
                }
                if (i12 != i) {
                    Object[] objArr34 = {null, new int[]{(i | i) & (~(i & i))}, null, new int[]{i}, new int[]{i12}};
                    int i219 = (~((-1023031548) | i)) | 605564938;
                    int i220 = 950724505 + (i219 * 992) + ((i219 | (~(i169 | (-116481)))) * (-496)) + ((i | (-417583090)) * 496);
                    int i221 = i3 + (((i220 | 16) << 1) - (i220 ^ 16));
                    int i222 = i221 << 13;
                    int i223 = (i221 | i222) & (~(i221 & i222));
                    int i224 = i223 ^ (i223 >>> 17);
                    int i225 = i224 << 5;
                    return objArr34;
                }
                int i226 = -(-TextUtils.lastIndexOf(str4, '0'));
                int i227 = -TextUtils.lastIndexOf(str4, '0', 0);
                int i228 = i227 * (-721);
                int i229 = ((i228 | (-164388)) << 1) - (i228 ^ (-164388));
                int i230 = ~i227;
                int i231 = ~((i230 & (-229)) | (i230 ^ (-229)));
                int i232 = (i169 & i231) | (i169 ^ i231);
                int i233 = ~((i227 ^ 228) | (i227 & 228));
                int i234 = ((i232 & i233) | (i232 ^ i233)) * 1444;
                int i235 = ((i229 | i234) << 1) - (i234 ^ i229);
                int i236 = (~((i227 ^ i) | (i227 & i))) | i233;
                int i237 = ~((i ^ 228) | (i & 228));
                int i238 = (i235 - (~(-(-(((i236 & i237) | (i236 ^ i237)) * (-1444)))))) - 1;
                int i239 = ~i227;
                int i240 = ~((i239 & 228) | (i239 ^ 228));
                int i241 = ~((i227 & (-229)) | ((-229) ^ i227));
                int i242 = i240 ^ i241;
                Object[] objArr35 = new Object[1];
                a((char) ((i226 ^ 1) + ((i226 & 1) << 1)), i238 + (((i241 & i240) | i242) * 722), 30 - (~(KeyEvent.getMaxKeyCode() >> 16)), objArr35);
                int iIndexOf = TextUtils.indexOf((CharSequence) str4, '0');
                char c7 = (char) (((iIndexOf | 48739) << 1) - (48739 ^ iIndexOf));
                int i243 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                int i244 = (i243 ^ 259) + ((i243 & 259) << 1);
                int iResolveSize = View.resolveSize(0, 0);
                int i245 = (iResolveSize ^ 23) + ((iResolveSize & 23) << 1);
                Object[] objArr36 = new Object[1];
                a(c7, i244, i245, objArr36);
                int iIndexOf2 = TextUtils.indexOf((CharSequence) str4, '0', 0, 0);
                int i246 = (((iIndexOf2 * 628) - (-14703992)) - (~(-(-(((i | 23414) | (~iIndexOf2)) * (-627)))))) - 1;
                int i247 = ~(((-23415) & i) | ((-23415) ^ i));
                int i248 = ((i247 & iIndexOf2) | (iIndexOf2 ^ i247)) * (-627);
                int i249 = ((i246 | i248) << 1) - (i246 ^ i248);
                int i250 = ~((i169 ^ 23414) | (i169 & 23414));
                int i251 = ~((iIndexOf2 & i) | (iIndexOf2 ^ i));
                char c8 = (char) (i249 + (((i250 & i251) | (i250 ^ i251)) * 627));
                int keyRepeatDelay = ViewConfiguration.getKeyRepeatDelay() >> 16;
                Object[] objArr37 = new Object[1];
                a(c8, (keyRepeatDelay ^ 283) + ((keyRepeatDelay & 283) << 1), View.MeasureSpec.makeMeasureSpec(0, 0) + 28, objArr37);
                char modifierMetaStateMask2 = (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask()));
                int i252 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                int iIPostMessageServiceStubProxy5 = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                int i253 = i252 * (-589);
                int i254 = (i253 & 183210) + (i253 | 183210);
                int i255 = ~iIPostMessageServiceStubProxy5;
                int i256 = ~(((-311) ^ i255) | ((-311) & i255));
                int i257 = ((-311) ^ i252) | ((-311) & i252);
                int i258 = ~i257;
                int i259 = (i256 ^ i258) | (i256 & i258);
                int i260 = ~((i255 ^ i252) | (i255 & i252));
                int i261 = (i259 ^ i260) | (i259 & i260);
                int i262 = ~i252;
                int i263 = (i262 ^ 310) | (i262 & 310);
                int i264 = ~((i263 & iIPostMessageServiceStubProxy5) | (i263 ^ iIPostMessageServiceStubProxy5));
                int i265 = i254 + (((i261 & i264) | (i261 ^ i264)) * 590);
                int i266 = (~((-311) | i255)) | (~i257);
                int i267 = artificialFrame;
                int i268 = (i267 ^ 7) + ((i267 & 7) << 1);
                getARTIFICIAL_FRAME_PACKAGE_NAME = i268 % 128;
                int i269 = i268 % 2;
                int i270 = ~(i255 | i252);
                int i271 = (i265 - (~(-(-((-1180) * ((i266 & i270) | (i266 ^ i270))))))) - 1;
                int i272 = ~((i262 ^ i255) | (i262 & i255));
                int i273 = ~iIPostMessageServiceStubProxy5;
                int i274 = (i271 - (~(-(-((i272 | (~((i273 & 310) | (i273 ^ 310)))) * 590))))) - 1;
                int i275 = -Drawable.resolveOpacity(0, 0);
                int i276 = ((i275 | 14) << 1) - (i275 ^ 14);
                Object[] objArr38 = new Object[1];
                a(modifierMetaStateMask2, i274, i276, objArr38);
                strArr = new String[]{(String) objArr35[0], (String) objArr36[0], (String) objArr37[0], (String) objArr38[0]};
                i13 = 0;
                while (true) {
                    if (i13 < 4) {
                        str5 = str4;
                        i14 = i;
                        break;
                    }
                    Object[] objArr39 = {strArr[i13]};
                    objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-11453480);
                    if (objAccessartificialFrame18 == null) {
                        int maximumDrawingCacheSize = 17 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                        char c9 = (char) (24344 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                        int mirror2 = AndroidCharacter.getMirror('0') + 1966;
                        byte[] bArr8 = $$a;
                        Object[] objArr40 = new Object[1];
                        b((byte) (-bArr8[22]), bArr8[20], (byte) (-bArr8[4]), objArr40);
                        objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize, c9, mirror2, 1614052816, false, (String) objArr40[0], new Class[]{String.class});
                    }
                    long jLongValue6 = ((Long) ((Method) objAccessartificialFrame18).invoke(null, objArr39)).longValue();
                    long j39 = 255187823;
                    int iNextInt = new java.util.Random().nextInt();
                    strArr11 = strArr;
                    long j40 = -500;
                    long j41 = (j40 * j39) + (j40 * jLongValue6);
                    long j42 = TypedValues.PositionType.TYPE_TRANSITION_EASING;
                    long j43 = jLongValue6 ^ j20;
                    long j44 = (j43 | j39) ^ j20;
                    long j45 = j39 ^ j20;
                    i59 = i13;
                    long j46 = iNextInt;
                    long j47 = j41 + ((j44 | (((j45 | jLongValue6) | j46) ^ j20)) * j42);
                    str5 = str4;
                    long j48 = j47 + (((long) 1002) * ((j45 | j43) ^ j20)) + (j42 * ((((j46 ^ j20) | j45) | jLongValue6) ^ j20)) + ((long) 1306943214);
                    int startElapsedRealtime2 = (int) Process.getStartElapsedRealtime();
                    int i277 = 1355781082 + ((417151041 | startElapsedRealtime2) * (-50));
                    int i278 = ~((-416094274) | startElapsedRealtime2);
                    int i279 = ~startElapsedRealtime2;
                    i60 = ((int) (j48 >> 32)) & (i277 + ((i278 | (~((-603981097) | i279))) * 50) + (((~(i279 | 417151041)) | (~((-1020075370) | i279)) | 603981096) * 50));
                    int iMyTid = Process.myTid();
                    int i280 = ~iMyTid;
                    int i281 = (~((-1047661337) | i280)) | 336592896 | (~(1810079549 | i280));
                    i61 = ((int) j48) & ((-292406001) + (((~(iMyTid | (-1099011110))) | i281) * 590) + (i281 * (-1180)) + (((~((-1810079550) | i280)) | (~(i280 | 1047661336))) * 590));
                    if (((i61 & i60) | (i60 ^ i61)) != 0) {
                        int i282 = i59 + 252;
                        i14 = (~(i & i282)) & (i282 | i);
                        break;
                    }
                    int i283 = (i59 & 59) + (i59 | 59);
                    i13 = ((i283 & (-58)) << 1) + (i283 ^ (-58));
                    strArr = strArr11;
                    str4 = str5;
                }
                if (i14 == i) {
                    objArr2 = new Object[]{null, new int[1], null, new int[]{i}, new int[]{i14}};
                    int iNextInt2 = new java.util.Random().nextInt(1319388537);
                    int i284 = ~iNextInt2;
                    int i285 = -(-((-1101664569) + (((~((-584334129) | i284)) | (~((-21114330) | iNextInt2))) * 210) + (((~(iNextInt2 | (-580129313))) | (~(i284 | (-16909514)))) * 210) + 16));
                    int i286 = ((i3 | i285) << 1) - (i3 ^ i285);
                    int i287 = i286 << 13;
                    int i288 = (i287 & (~i286)) | ((~i287) & i286);
                    int i289 = i288 >>> 17;
                    int i290 = (i288 | i289) & (~(i288 & i289));
                    ((int[]) objArr2[1])[0] = i290 ^ (i290 << 5);
                } else {
                    char size2 = (char) (View.MeasureSpec.getSize(0) + 43196);
                    int i291 = artificialFrame;
                    int i292 = ((i291 | 3) << 1) - (i291 ^ 3);
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i292 % 128;
                    int i293 = i292 % 2;
                    int i294 = -(ViewConfiguration.getKeyRepeatTimeout() >> 16);
                    int i295 = (325 & i294) + (i294 | 325);
                    str6 = str5;
                    int i296 = -TextUtils.getOffsetAfter(str6, 0);
                    int i297 = ((i296 | 13) << 1) - (i296 ^ 13);
                    Object[] objArr41 = new Object[1];
                    a(size2, i295, i297, objArr41);
                    Object[] objArr42 = {(String) objArr41[0]};
                    objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                    if (objAccessartificialFrame3 == null) {
                        int iAlpha = 23 - Color.alpha(0);
                        char cIndexOf2 = (char) (TextUtils.indexOf((CharSequence) str6, '0', 0) + 1);
                        int edgeSlop = 2441 - (ViewConfiguration.getEdgeSlop() >> 16);
                        byte[] bArr9 = $$a;
                        Object[] objArr43 = new Object[1];
                        b((byte) 49, bArr9[16], bArr9[10], objArr43);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iAlpha, cIndexOf2, edgeSlop, 954751276, false, (String) objArr43[0], new Class[]{String.class});
                    }
                    str7 = (String) ((Method) objAccessartificialFrame3).invoke(null, objArr42);
                    if (str7 != null) {
                        int i298 = artificialFrame;
                        int i299 = ((i298 | 7) << 1) - (i298 ^ 7);
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i299 % 128;
                        int i300 = i299 % 2;
                        int i301 = -(-(ViewConfiguration.getMinimumFlingVelocity() >> 16));
                        int keyRepeatTimeout2 = ViewConfiguration.getKeyRepeatTimeout() >> 16;
                        objArr3 = new Object[1];
                        a((char) ((i301 ^ 25812) + ((i301 & 25812) << 1)), (keyRepeatTimeout2 & 338) + (keyRepeatTimeout2 | 338), Color.red(0) + 9, objArr3);
                        if (str7.contains((String) objArr3[0])) {
                            i15 = (~(i & ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION)) & (i | ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
                        } else {
                            i15 = i;
                        }
                    } else {
                        i15 = i;
                    }
                    if (i15 != i) {
                        Object[] objArr44 = {null, new int[1], null, new int[]{i}, new int[]{i15}};
                        int elapsedCpuTime2 = (int) Process.getElapsedCpuTime();
                        int i302 = (-1676222545) + (((-2634001) | (~elapsedCpuTime2)) * (-490)) + (((~(elapsedCpuTime2 | (-11416946))) | 8782945) * 490) + 982334758;
                        int i303 = i3 + (((i302 | 16) << 1) - (i302 ^ 16));
                        int i304 = i303 << 13;
                        int i305 = ((~i303) & i304) | ((~i304) & i303);
                        int i306 = i305 >>> 17;
                        int i307 = (i305 | i306) & (~(i305 & i306));
                        int i308 = i307 << 5;
                        ((int[]) objArr44[1])[0] = (i307 | i308) & (~(i307 & i308));
                        return objArr44;
                    }
                    char doubleTapTimeout = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                    int i309 = -(-Color.rgb(0, 0, 0));
                    Object[] objArr45 = new Object[1];
                    a(doubleTapTimeout, (i309 & 16777563) + (i309 | 16777563), TextUtils.lastIndexOf(str6, '0', 0) + 18, objArr45);
                    String str28 = (String) objArr45[0];
                    int i310 = -Color.rgb(0, 0, 0);
                    int keyRepeatTimeout3 = ViewConfiguration.getKeyRepeatTimeout() >> 16;
                    int i311 = (keyRepeatTimeout3 ^ 364) + ((keyRepeatTimeout3 & 364) << 1);
                    int i312 = -TextUtils.lastIndexOf(str6, '0', 0, 0);
                    int i313 = (i312 ^ 5) + ((i312 & 5) << 1);
                    Object[] objArr46 = new Object[1];
                    a((char) (((i310 | (-16717197)) << 1) - (i310 ^ (-16717197))), i311, i313, objArr46);
                    String str29 = (String) objArr46[0];
                    file = new File(str28);
                    if (file.exists() || !file.isFile()) {
                        i16 = i;
                    } else {
                        try {
                            Scanner scanner = new Scanner(new FileInputStream(file));
                            int i314 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                            int iResolveSizeAndState = View.resolveSizeAndState(0, 0, 0);
                            Object[] objArr47 = new Object[1];
                            a((char) (((i314 | 38937) << 1) - (i314 ^ 38937)), (iResolveSizeAndState & 370) + (iResolveSizeAndState | 370), 0 - (~(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), objArr47);
                            Scanner scannerUseDelimiter = scanner.useDelimiter((String) objArr47[0]);
                            String next2 = scannerUseDelimiter.hasNext() ? scannerUseDelimiter.next() : str6;
                            scannerUseDelimiter.close();
                            if (next2.contains(str29)) {
                                i16 = i ^ 251;
                            } else {
                                i16 = i;
                            }
                        } catch (IOException unused) {
                        }
                    }
                    if (i16 != i) {
                        Object[] objArr48 = {null, new int[1], null, new int[]{i}, new int[]{i16}};
                        int iUptimeMillis3 = (int) SystemClock.uptimeMillis();
                        int i315 = ~iUptimeMillis3;
                        int i316 = 909249552 + (((~((-366196766) | i315)) | 239251692) * 226) + (((~(i315 | (-294717458))) | (~((-239251693) | iUptimeMillis3)) | 167772384) * (-113)) + ((~(iUptimeMillis3 | (-366196766))) * 113);
                        int i317 = (i3 - (~(-(-((i316 & 16) + (i316 | 16)))))) - 1;
                        int i318 = i317 ^ (i317 << 13);
                        int i319 = i318 >>> 17;
                        int i320 = (i318 | i319) & (~(i318 & i319));
                        int i321 = i320 << 5;
                        ((int[]) objArr48[1])[0] = (i320 | i321) & (~(i320 & i321));
                        return objArr48;
                    }
                    char mode = (char) (View.MeasureSpec.getMode(0) + 15387);
                    int i322 = -(-(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)));
                    Object[] objArr49 = new Object[1];
                    a(mode, (i322 & 372) + (i322 | 372), (ViewConfiguration.getEdgeSlop() >> 16) + 23, objArr49);
                    Object[] objArr50 = {(String) objArr49[0]};
                    objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                    if (objAccessartificialFrame4 == null) {
                        int i323 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 23;
                        char c10 = (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1);
                        int scrollBarFadeDuration2 = 2441 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                        byte[] bArr10 = $$a;
                        Object[] objArr51 = new Object[1];
                        b((byte) 49, bArr10[16], bArr10[10], objArr51);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i323, c10, scrollBarFadeDuration2, 954751276, false, (String) objArr51[0], new Class[]{String.class});
                    }
                    lowerCase = ((String) ((Method) objAccessartificialFrame4).invoke(null, objArr50)).toLowerCase();
                    int i324 = -(-View.MeasureSpec.getSize(0));
                    c = (char) ((i324 ^ 11468) + ((i324 & 11468) << 1));
                    minimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
                    i17 = getARTIFICIAL_FRAME_PACKAGE_NAME + 93;
                    artificialFrame = i17 % 128;
                    if (i17 % 2 == 0) {
                        int i325 = 395 % ((minimumFlingVelocity ^ 1) + ((minimumFlingVelocity & 1) << 1));
                        int iGreen2 = Color.green(0);
                        int i326 = (iGreen2 & 2) + (iGreen2 | 2);
                        Object[] objArr52 = new Object[1];
                        a(c, i325, i326, objArr52);
                        obj = objArr52[0];
                    } else {
                        int i327 = -Color.green(0);
                        int i328 = ((i327 | 4) << 1) - (i327 ^ 4);
                        Object[] objArr53 = new Object[1];
                        a(c, (minimumFlingVelocity >> 16) + 395, i328, objArr53);
                        obj = objArr53[0];
                    }
                    if (lowerCase.contains((String) obj)) {
                        i18 = (i & (-265)) | (i169 & 264);
                    } else {
                        i18 = i;
                    }
                    if (i18 != i) {
                        Object[] objArr54 = {null, new int[1], null, new int[]{i}, new int[]{i18}};
                        int iNextInt3 = new java.util.Random().nextInt();
                        int i329 = (-1311348395) + (((~((-2791427) | iNextInt3)) | 608239884) * (-756)) + (((~iNextInt3) | (-2791427)) * 756);
                        int i330 = -(-(((i329 | 16) << 1) - (i329 ^ 16)));
                        int i331 = ((i3 | i330) << 1) - (i3 ^ i330);
                        int i332 = (i331 << 13) ^ i331;
                        int i333 = i332 >>> 17;
                        int i334 = ((~i332) & i333) | ((~i333) & i332);
                        int i335 = i334 << 5;
                        ((int[]) objArr54[1])[0] = (i334 | i335) & (~(i334 & i335));
                        return objArr54;
                    }
                    char packedPositionGroup2 = (char) ExpandableListView.getPackedPositionGroup(0L);
                    int i336 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 400;
                    int keyRepeatTimeout4 = ViewConfiguration.getKeyRepeatTimeout() >> 16;
                    Object[] objArr55 = new Object[1];
                    a(packedPositionGroup2, i336, (keyRepeatTimeout4 & 42) + (keyRepeatTimeout4 | 42), objArr55);
                    String str30 = (String) objArr55[0];
                    char deadChar2 = (char) KeyEvent.getDeadChar(0, 0);
                    int tapTimeout3 = (ViewConfiguration.getTapTimeout() >> 16) + 441;
                    int i337 = -(-AndroidCharacter.getMirror('0'));
                    int i338 = (i337 & (-8)) + (i337 | (-8));
                    Object[] objArr56 = new Object[1];
                    a(deadChar2, tapTimeout3, i338, objArr56);
                    String str31 = (String) objArr56[0];
                    Object[] objArr57 = new Object[1];
                    a((char) ((-2) - (~(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)))), 481 - KeyEvent.getDeadChar(0, 0), 26 - (~(-TextUtils.indexOf(str6, str6))), objArr57);
                    String str32 = (String) objArr57[0];
                    char c11 = (char) (16800331 - (~Color.rgb(0, 0, 0)));
                    int bitsPerPixel2 = 507 - ImageFormat.getBitsPerPixel(0);
                    int i339 = -(-(Process.myPid() >> 22));
                    int i340 = (i339 & 27) + (i339 | 27);
                    Object[] objArr58 = new Object[1];
                    a(c11, bitsPerPixel2, i340, objArr58);
                    String str33 = (String) objArr58[0];
                    int i341 = -(ViewConfiguration.getMaximumFlingVelocity() >> 16);
                    int i342 = -((byte) KeyEvent.getModifierMetaStateMask());
                    int i343 = (i342 ^ 534) + ((i342 & 534) << 1);
                    int i344 = -ExpandableListView.getPackedPositionChild(0L);
                    int i345 = (i344 ^ 26) + ((i344 & 26) << 1);
                    Object[] objArr59 = new Object[1];
                    a((char) (((i341 | 23606) << 1) - (i341 ^ 23606)), i343, i345, objArr59);
                    String str34 = (String) objArr59[0];
                    char touchSlop2 = (char) (24565 - (ViewConfiguration.getTouchSlop() >> 8));
                    int i346 = -(-Color.red(0));
                    int i347 = (i346 ^ 562) + ((i346 & 562) << 1);
                    int iIndexOf3 = TextUtils.indexOf(str6, str6, 0, 0);
                    Object[] objArr60 = new Object[1];
                    a(touchSlop2, i347, ((iIndexOf3 | 27) << 1) - (iIndexOf3 ^ 27), objArr60);
                    strArr2 = new String[]{str30, str31, str32, str33, str34, (String) objArr60[0]};
                    i19 = 0;
                    while (true) {
                        if (i19 < 6) {
                            i20 = i;
                            break;
                        }
                        Object[] objArr61 = {strArr2[i19]};
                        objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                        if (objAccessartificialFrame17 == null) {
                            int i348 = 24 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                            char c12 = (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                            int i349 = 2441 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                            byte[] bArr11 = $$a;
                            Object[] objArr62 = new Object[1];
                            b((byte) 49, bArr11[16], bArr11[10], objArr62);
                            objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(i348, c12, i349, 954751276, false, (String) objArr62[0], new Class[]{String.class});
                        }
                        str14 = (String) ((Method) objAccessartificialFrame17).invoke(null, objArr61);
                        if (str14 == null && str14.length() != 0) {
                            i20 = (~(i & 265)) & (i | 265);
                            break;
                        }
                        i19++;
                    }
                    if (i20 != i) {
                        Object[] objArr63 = {null, new int[]{(i | i) & (~(i & i))}, null, new int[]{i}, new int[]{i20}};
                        int i350 = 56479429 + (((~(i | 438311253)) | (-1043759712)) * (-948)) + ((~((-605454859) | i169)) * (-948)) + 1647795148;
                        int i351 = i3 + (((i350 | 16) << 1) - (i350 ^ 16));
                        int i352 = i351 << 13;
                        int i353 = (i351 | i352) & (~(i351 & i352));
                        int i354 = i353 ^ (i353 >>> 17);
                        int i355 = i354 << 5;
                        return objArr63;
                    }
                    char offsetBefore2 = (char) TextUtils.getOffsetBefore(str6, 0);
                    int iLastIndexOf = TextUtils.lastIndexOf(str6, '0', 0);
                    Object[] objArr64 = new Object[1];
                    a(offsetBefore2, (iLastIndexOf ^ 348) + ((iLastIndexOf & 348) << 1), 17 - (Process.myPid() >> 22), objArr64);
                    String str35 = (String) objArr64[0];
                    char c13 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                    int i356 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                    Object[] objArr65 = new Object[1];
                    a(c13, (i356 & 589) + (i356 | 589), 6 - (~TextUtils.lastIndexOf(str6, '0', 0, 0)), objArr65);
                    String str36 = (String) objArr65[0];
                    file2 = new File(str35);
                    if (file2.exists() || !file2.isFile()) {
                        char cResolveSize = (char) View.resolveSize(0, 0);
                        int i357 = -(-(ViewConfiguration.getMaximumFlingVelocity() >> 16));
                        int i358 = ((i357 | 595) << 1) - (i357 ^ 595);
                        int iIndexOf4 = TextUtils.indexOf((CharSequence) str6, '0', 0, 0);
                        int i359 = ((iIndexOf4 | 14) << 1) - (iIndexOf4 ^ 14);
                        Object[] objArr66 = new Object[1];
                        a(cResolveSize, i358, i359, objArr66);
                        String str37 = (String) objArr66[0];
                        char packedPositionType2 = (char) ExpandableListView.getPackedPositionType(0L);
                        int i360 = -(ViewConfiguration.getDoubleTapTimeout() >> 16);
                        Object[] objArr67 = new Object[1];
                        a(packedPositionType2, (i360 ^ TypedValues.MotionType.TYPE_DRAW_PATH) + ((i360 & TypedValues.MotionType.TYPE_DRAW_PATH) << 1), 8 - (~(-(-View.MeasureSpec.getSize(0)))), objArr67);
                        Object[] objArr68 = {str37, (String) objArr67[0]};
                        objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-883653127);
                        if (objAccessartificialFrame5 == null) {
                            int iIndexOf5 = TextUtils.indexOf(str6, str6) + 31;
                            char deadChar3 = (char) (57022 - KeyEvent.getDeadChar(0, 0));
                            int fadingEdgeLength = 2311 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                            byte[] bArr12 = $$a;
                            Object[] objArr69 = new Object[1];
                            b((byte) (bArr12[13] - 1), (byte) (-bArr12[4]), bArr12[10], objArr69);
                            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iIndexOf5, deadChar3, fadingEdgeLength, 1412547569, false, (String) objArr69[0], new Class[]{String.class, String.class});
                        }
                        long jLongValue7 = ((Long) ((Method) objAccessartificialFrame5).invoke(null, objArr68)).longValue();
                        int i361 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i362 = (i361 ^ 57) + ((i361 & 57) << 1);
                        artificialFrame = i362 % 128;
                        int i363 = i362 % 2;
                        long j49 = 736527736;
                        long j50 = -495;
                        long j51 = j49 ^ j20;
                        long jElapsedRealtime2 = (int) SystemClock.elapsedRealtime();
                        long j52 = ((j51 | (jLongValue7 ^ j20)) ^ j20) | ((j51 | jElapsedRealtime2) ^ j20);
                        j = (j50 * j49) + (j50 * jLongValue7) + (((long) 992) * j52) + (((long) (-496)) * (j52 | ((((jElapsedRealtime2 ^ j20) | j49) | jLongValue7) ^ j20))) + (((long) 496) * (jLongValue7 | jElapsedRealtime2)) + ((long) (-891279365));
                        int iUptimeMillis4 = (int) SystemClock.uptimeMillis();
                        i21 = ((int) (j >> 32)) & ((-2072279902) + ((~((~iUptimeMillis4) | (-806881898))) * (-116)) + (((-1914215020) | iUptimeMillis4) * 116) + (((~(iUptimeMillis4 | 943525865)) | (-2050858988)) * 116));
                        i22 = 818884229 + (((~(1725358459 | i)) | 287836800 | (~((-288132050) | i))) * (-880));
                        i23 = (~(1725358459 | i169)) | 288132049;
                        i24 = ~((-1725358460) | i);
                        if ((i21 | (((int) j) & (i22 + ((i23 | i24) * (-880)) + (i24 * 880)))) != 0) {
                            i25 = i ^ 261;
                        } else {
                            i25 = i;
                        }
                    } else {
                        try {
                            Scanner scanner2 = new Scanner(new FileInputStream(file2));
                            int i364 = getARTIFICIAL_FRAME_PACKAGE_NAME + 17;
                            artificialFrame = i364 % 128;
                            int i365 = i364 % 2;
                            char cResolveSizeAndState = (char) (38938 - View.resolveSizeAndState(0, 0, 0));
                            int i366 = -ExpandableListView.getPackedPositionType(0L);
                            Object[] objArr70 = new Object[1];
                            a(cResolveSizeAndState, (i366 & 370) + (i366 | 370), 1 - (~(-(-TextUtils.getCapsMode(str6, 0, 0)))), objArr70);
                            Scanner scannerUseDelimiter2 = scanner2.useDelimiter((String) objArr70[0]);
                            if (scannerUseDelimiter2.hasNext()) {
                                int i367 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                int i368 = (i367 ^ 69) + ((i367 & 69) << 1);
                                artificialFrame = i368 % 128;
                                int i369 = i368 % 2;
                                next = scannerUseDelimiter2.next();
                            } else {
                                next = str6;
                            }
                            scannerUseDelimiter2.close();
                            if (next.contains(str36)) {
                                i25 = i ^ 260;
                            } else {
                                char cResolveSize2 = (char) View.resolveSize(0, 0);
                                int i3510 = -(-(ViewConfiguration.getMaximumFlingVelocity() >> 16));
                                int i3511 = ((i3510 | 595) << 1) - (i3510 ^ 595);
                                int iIndexOf6 = TextUtils.indexOf((CharSequence) str6, '0', 0, 0);
                                int i3512 = ((iIndexOf6 | 14) << 1) - (iIndexOf6 ^ 14);
                                Object[] objArr610 = new Object[1];
                                a(cResolveSize2, i3511, i3512, objArr610);
                                String str38 = (String) objArr610[0];
                                char packedPositionType3 = (char) ExpandableListView.getPackedPositionType(0L);
                                int i3610 = -(ViewConfiguration.getDoubleTapTimeout() >> 16);
                                Object[] objArr611 = new Object[1];
                                a(packedPositionType3, (i3610 ^ TypedValues.MotionType.TYPE_DRAW_PATH) + ((i3610 & TypedValues.MotionType.TYPE_DRAW_PATH) << 1), 8 - (~(-(-View.MeasureSpec.getSize(0)))), objArr611);
                                Object[] objArr612 = {str38, (String) objArr611[0]};
                                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-883653127);
                                if (objAccessartificialFrame5 == null) {
                                    int iIndexOf7 = TextUtils.indexOf(str6, str6) + 31;
                                    char deadChar4 = (char) (57022 - KeyEvent.getDeadChar(0, 0));
                                    int fadingEdgeLength2 = 2311 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                                    byte[] bArr13 = $$a;
                                    Object[] objArr613 = new Object[1];
                                    b((byte) (bArr13[13] - 1), (byte) (-bArr13[4]), bArr13[10], objArr613);
                                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iIndexOf7, deadChar4, fadingEdgeLength2, 1412547569, false, (String) objArr613[0], new Class[]{String.class, String.class});
                                }
                                long jLongValue8 = ((Long) ((Method) objAccessartificialFrame5).invoke(null, objArr612)).longValue();
                                int i3611 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                int i3612 = (i3611 ^ 57) + ((i3611 & 57) << 1);
                                artificialFrame = i3612 % 128;
                                int i3613 = i3612 % 2;
                                long j410 = 736527736;
                                long j53 = -495;
                                long j54 = j410 ^ j20;
                                long jElapsedRealtime3 = (int) SystemClock.elapsedRealtime();
                                long j55 = ((j54 | (jLongValue8 ^ j20)) ^ j20) | ((j54 | jElapsedRealtime3) ^ j20);
                                j = (j53 * j410) + (j53 * jLongValue8) + (((long) 992) * j55) + (((long) (-496)) * (j55 | ((((jElapsedRealtime3 ^ j20) | j410) | jLongValue8) ^ j20))) + (((long) 496) * (jLongValue8 | jElapsedRealtime3)) + ((long) (-891279365));
                                int iUptimeMillis5 = (int) SystemClock.uptimeMillis();
                                i21 = ((int) (j >> 32)) & ((-2072279902) + ((~((~iUptimeMillis5) | (-806881898))) * (-116)) + (((-1914215020) | iUptimeMillis5) * 116) + (((~(iUptimeMillis5 | 943525865)) | (-2050858988)) * 116));
                                i22 = 818884229 + (((~(1725358459 | i)) | 287836800 | (~((-288132050) | i))) * (-880));
                                i23 = (~(1725358459 | i169)) | 288132049;
                                i24 = ~((-1725358460) | i);
                                if ((i21 | (((int) j) & (i22 + ((i23 | i24) * (-880)) + (i24 * 880)))) != 0) {
                                    i25 = i ^ 261;
                                } else {
                                    i25 = i;
                                }
                            }
                        } catch (IOException unused2) {
                        }
                    }
                    if (i25 != i) {
                        Object[] objArr71 = {null, new int[]{((~i) & i) | ((~i) & i)}, null, new int[]{i}, new int[]{i25}};
                        int i370 = 824145913 + (((~((-140802648) | i)) | 136342034 | (~((-464645811) | i))) * (-880));
                        int i371 = (~(i169 | (-140802648))) | 464645810;
                        int i372 = ~(i | 140802647);
                        int i373 = i370 + ((i371 | i372) * (-880)) + (i372 * 880);
                        int i374 = -(-((i373 ^ 16) + ((i373 & 16) << 1)));
                        int i375 = (i3 & i374) + (i3 | i374);
                        int i376 = i375 << 13;
                        int i377 = (i376 & (~i375)) | ((~i376) & i375);
                        int i378 = i377 >>> 17;
                        int i379 = (i377 | i378) & (~(i377 & i378));
                        int i380 = i379 << 5;
                        return objArr71;
                    }
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-913150042);
                    if (objAccessartificialFrame6 == null) {
                        int doubleTapTimeout2 = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 28;
                        char threadPriority2 = (char) ((Process.getThreadPriority(0) + 20) >> 6);
                        int iLastIndexOf2 = 763 - TextUtils.lastIndexOf(str6, '0', 0);
                        byte[] bArr14 = $$a;
                        byte b2 = (byte) (bArr14[13] - 1);
                        Object[] objArr72 = new Object[1];
                        b(b2, (byte) (b2 >>> 2), bArr14[16], objArr72);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout2, threadPriority2, iLastIndexOf2, 1459038638, false, (String) objArr72[0], new Class[0]);
                    }
                    long jLongValue9 = ((Long) ((Method) objAccessartificialFrame6).invoke(null, null)).longValue();
                    long j56 = 936725282;
                    long j57 = 140;
                    long j58 = (j56 ^ j20) | jLongValue9;
                    long j59 = (((long) 141) * j56) + (((long) (-279)) * jLongValue9) + ((jLongValue9 | j19) * j57) + (((long) (-280)) * ((j58 ^ j20) | ((j21 | jLongValue9) ^ j20))) + (j57 * ((((jLongValue9 ^ j20) | j56) ^ j20) | ((j21 | j56) ^ j20) | ((j58 | j19) ^ j20))) + ((long) 1001876370);
                    int elapsedCpuTime3 = (int) Process.getElapsedCpuTime();
                    int i381 = (~((-212443641) | elapsedCpuTime3)) | 134259120;
                    int i382 = ~((~elapsedCpuTime3) | 1302967290);
                    i26 = ((int) (j59 >> 32)) & (114503370 + ((i381 | i382) * (-470)) + (((~(elapsedCpuTime3 | (-78184521))) | i382) * 470));
                    int iElapsedRealtime2 = (int) SystemClock.elapsedRealtime();
                    i27 = ((int) j59) & (876805573 + (((~(1062883193 | (~iElapsedRealtime2))) | (~((-374343217) | iElapsedRealtime2))) * (-272)) + (((~(911738481 | iElapsedRealtime2)) | 151144712) * (-272)) + (((~(iElapsedRealtime2 | (-911738482))) | (-525487929)) * 272));
                    if (((i26 & i27) | (i26 ^ i27)) == 1) {
                        Object[] objArr73 = {null, new int[]{i ^ (i << 5)}, null, new int[]{i}, new int[]{i}};
                        int i383 = (~(171932929 | i169)) | 608207370;
                        int i384 = ~(i | (-2758913));
                        int i385 = (i3 - (~((((i383 | i384) * (-252)) - 745116959) + ((i384 | (~(i169 | 780140299))) * 252)))) - 1;
                        int i386 = i385 << 13;
                        int i387 = ((~i385) & i386) | ((~i386) & i385);
                        int i388 = i387 ^ (i387 >>> 17);
                        return objArr73;
                    }
                    Object[] objArr74 = {1};
                    objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(1671772348);
                    if (objAccessartificialFrame7 == null) {
                        int i389 = 19 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                        char cRed = (char) Color.red(0);
                        int iIndexOf8 = 1573 - TextUtils.indexOf(str6, str6, 0);
                        byte[] bArr15 = $$a;
                        byte b3 = bArr15[16];
                        Object[] objArr75 = new Object[1];
                        b(b3, bArr15[7], b3, objArr75);
                        objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(i389, cRed, iIndexOf8, -54493516, false, (String) objArr75[0], new Class[]{Integer.TYPE});
                    }
                    long jLongValue10 = ((Long) ((Method) objAccessartificialFrame7).invoke(null, objArr74)).longValue();
                    long j60 = -998325424;
                    long j61 = (((long) (-244)) * j60) + (((long) 246) * jLongValue10);
                    long j62 = -245;
                    long j63 = jLongValue10 ^ j20;
                    long j64 = j61 + ((((j63 | j21) ^ j20) | ((j63 | j60) ^ j20)) * j62);
                    long j65 = (j63 | j19) ^ j20;
                    long j66 = j64 + (j62 * j65) + (((long) 245) * (j65 | j60)) + ((long) 1482910141);
                    int i390 = ~((-1795993737) | i169);
                    i28 = ((int) (j66 >> 32)) & ((((-2137979614) | i390 | (~(1795993736 | i))) * (-338)) + 354622606 + ((i390 | (~((-341985878) | i))) * 338));
                    int startUptimeMillis = (int) Process.getStartUptimeMillis();
                    int i391 = ~((-420937154) | startUptimeMillis);
                    i29 = ((int) j66) & (590333378 + ((17082369 | i391) * (-814)) + ((i391 | (~((~startUptimeMillis) | 1016289256)) | 612434472) * 407) + (((~(startUptimeMillis | (-1016289257))) | (~(420937153 | startUptimeMillis)) | 612434472) * 407));
                    if (((i28 & i29) | (i28 ^ i29)) != 0) {
                        int i392 = (~(i & 220)) & (i | 220);
                        int i393 = artificialFrame + 41;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i393 % 128;
                        int i394 = i393 % 2;
                        i30 = i392;
                    } else {
                        i30 = i;
                    }
                    if (i30 != i) {
                        Object[] objArr76 = {null, new int[]{i ^ (i << 5)}, null, new int[]{i}, new int[]{i30}};
                        int i395 = (-55989948) + (((~(i169 | (-177550748))) | 1319194 | (~((-606767653) | i))) * 717) + (((~(i | (-177550748))) | (~(i169 | (-606767653))) | 1319194) * 717);
                        int i396 = i3 + (i395 ^ 16) + ((i395 & 16) << 1);
                        int i397 = i396 << 13;
                        int i398 = ((~i396) & i397) | ((~i397) & i396);
                        int i399 = i398 >>> 17;
                        int i400 = (i398 | i399) & (~(i398 & i399));
                        return objArr76;
                    }
                    Object[] objArr77 = new Object[1];
                    a((char) (15387 - TextUtils.getTrimmedLength(str6)), 371 - (~(-(-(ViewConfiguration.getPressedStateDuration() >> 16)))), 23 - ExpandableListView.getPackedPositionType(0L), objArr77);
                    Object[] objArr78 = {(String) objArr77[0]};
                    objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                    if (objAccessartificialFrame8 == null) {
                        int keyRepeatDelay2 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 23;
                        char keyRepeatDelay3 = (char) (ViewConfiguration.getKeyRepeatDelay() >> 16);
                        int i401 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 2440;
                        byte[] bArr16 = $$a;
                        Object[] objArr79 = new Object[1];
                        b((byte) 49, bArr16[16], bArr16[10], objArr79);
                        objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay2, keyRepeatDelay3, i401, 954751276, false, (String) objArr79[0], new Class[]{String.class});
                    }
                    objInvoke = ((Method) objAccessartificialFrame8).invoke(null, objArr78);
                    if (objInvoke != null) {
                        Object[] objArr80 = {objInvoke, 42};
                        objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-287841710);
                        if (objAccessartificialFrame16 == null) {
                            int threadPriority3 = ((Process.getThreadPriority(0) + 20) >> 6) + 20;
                            char c14 = (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
                            int i402 = 2246 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                            byte[] bArr17 = $$a;
                            Object[] objArr81 = new Object[1];
                            b((byte) (-bArr17[22]), bArr17[6], bArr17[10], objArr81);
                            objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(threadPriority3, c14, i402, 1907532890, false, (String) objArr81[0], new Class[]{String.class, Integer.TYPE});
                        }
                        long jLongValue11 = ((Long) ((Method) objAccessartificialFrame16).invoke(null, objArr80)).longValue();
                        long j67 = 1571493321;
                        long j68 = -919;
                        long j69 = (j68 * j67) + (j68 * jLongValue11);
                        long j70 = 920;
                        long j71 = j67 ^ j20;
                        long j72 = jLongValue11 ^ j20;
                        long j73 = j71 | j72;
                        long jMaxMemory = (int) Runtime.getRuntime().maxMemory();
                        long j74 = jMaxMemory ^ j20;
                        long j75 = j69 + ((((j73 | jMaxMemory) ^ j20) | (((j72 | j74) | j67) ^ j20)) * j70) + (((j73 ^ j20) | ((j71 | j74) ^ j20)) * j70) + (j70 * (((jMaxMemory | (j72 | j67)) ^ j20) | ((j73 | j74) ^ j20) | (((j71 | jLongValue11) | jMaxMemory) ^ j20))) + ((long) 61592007);
                        int startElapsedRealtime3 = (int) Process.getStartElapsedRealtime();
                        int i403 = ~startElapsedRealtime3;
                        i57 = ((int) (j75 >> 32)) & ((-1216029393) + (((~((-584777224) | i403)) | 1091588) * 98) + (((~(i403 | (-852449188))) | (-584777224) | (~(852449187 | startElapsedRealtime3))) * (-49)) + (((~(startElapsedRealtime3 | (-584777224))) | (-853540776)) * 49));
                        int iFreeMemory2 = (int) Runtime.getRuntime().freeMemory();
                        i58 = ((int) j75) & ((-496495881) + (((~((~iFreeMemory2) | (-268445825))) | (~((-46405121) | iFreeMemory2))) * (-302)) + ((~((-268445825) | iFreeMemory2)) * (-604)) + (((~(iFreeMemory2 | (-314850945))) | 1075970345) * 302));
                        if (((i57 & i58) | (i57 ^ i58)) == 1986687685) {
                            str9 = str6;
                            i39 = 0;
                            i31 = -1;
                            c2 = 6;
                        } else {
                            int i404 = -(Process.myPid() >> 22);
                            Object[] objArr82 = new Object[1];
                            a((char) ((i404 & 15387) + (i404 | 15387)), 371 - (~(-(Process.myPid() >> 22))), KeyEvent.keyCodeFromString(str6) + 23, objArr82);
                            String str39 = (String) objArr82[0];
                            char c15 = (char) (19553 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                            int i405 = 617 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                            int i406 = -(-ExpandableListView.getPackedPositionGroup(0L));
                            int i407 = (i406 ^ 10) + ((i406 & 10) << 1);
                            Object[] objArr83 = new Object[1];
                            a(c15, i405, i407, objArr83);
                            String str40 = (String) objArr83[0];
                            char c16 = (char) (23046 - (~Color.green(0)));
                            int i408 = 627 - (~TextUtils.indexOf((CharSequence) str6, '0', 0, 0));
                            int i409 = -KeyEvent.keyCodeFromString(str6);
                            int i410 = (i409 & 7) + (i409 | 7);
                            Object[] objArr84 = new Object[1];
                            a(c16, i408, i410, objArr84);
                            String str41 = (String) objArr84[0];
                            Object[] objArr85 = new Object[1];
                            a((char) Gravity.getAbsoluteGravity(0, 0), 633 - (~(-(KeyEvent.getMaxKeyCode() >> 16))), 7 - (~(-(-(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))))), objArr85);
                            char c17 = (char) ((-2) - ((-(-(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)))) ^ (-1)));
                            int iIndexOf9 = TextUtils.indexOf(str6, str6, 0, 0);
                            int i411 = ((iIndexOf9 | 642) << 1) - (iIndexOf9 ^ 642);
                            int i412 = -(ViewConfiguration.getPressedStateDuration() >> 16);
                            int i413 = (i412 ^ 17) + ((i412 & 17) << 1);
                            Object[] objArr86 = new Object[1];
                            a(c17, i411, i413, objArr86);
                            String str42 = (String) objArr86[0];
                            char windowTouchSlop2 = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                            int i414 = -(ViewConfiguration.getLongPressTimeout() >> 16);
                            int i415 = (i414 & 659) + (i414 | 659);
                            int i416 = -(-(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                            int i417 = ((i416 | 6) << 1) - (i416 ^ 6);
                            Object[] objArr87 = new Object[1];
                            a(windowTouchSlop2, i415, i417, objArr87);
                            String str43 = (String) objArr87[0];
                            char cIndexOf3 = (char) TextUtils.indexOf(str6, str6, 0, 0);
                            int i418 = -Color.red(0);
                            int iIPostMessageServiceStubProxy6 = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                            int i419 = ~i418;
                            int i420 = ~iIPostMessageServiceStubProxy6;
                            int i421 = ~(i419 | i420);
                            int i422 = ~(((-667) ^ iIPostMessageServiceStubProxy6) | ((-667) & iIPostMessageServiceStubProxy6));
                            int i423 = (((i418 * (-574)) - 382284) - (~(((i421 ^ i422) | (i421 & i422)) * 1150))) - 1;
                            int i424 = ~(((-667) ^ iIPostMessageServiceStubProxy6) | ((-667) & iIPostMessageServiceStubProxy6));
                            int i425 = ~((i420 & 666) | (i420 ^ 666));
                            int i426 = -(-(((i425 & i424) | (i424 ^ i425)) * (-575)));
                            int i427 = (i423 ^ i426) + ((i426 & i423) << 1);
                            int i428 = ~(i419 | iIPostMessageServiceStubProxy6);
                            int i429 = ~((i418 & i420) | (i420 ^ i418));
                            int i430 = ((i428 & i429) | (i428 ^ i429)) * 575;
                            int i431 = ((i427 | i430) << 1) - (i430 ^ i427);
                            int i432 = -TextUtils.lastIndexOf(str6, '0', 0);
                            int i433 = ((i432 | 6) << 1) - (i432 ^ 6);
                            Object[] objArr88 = new Object[1];
                            a(cIndexOf3, i431, i433, objArr88);
                            String str44 = (String) objArr88[0];
                            int i434 = -(ViewConfiguration.getFadingEdgeLength() >> 16);
                            Object[] objArr89 = new Object[1];
                            a((char) ((i434 & 32918) + (i434 | 32918)), 672 - (~(-View.MeasureSpec.makeMeasureSpec(0, 0))), 10 - (~(-(ViewConfiguration.getKeyRepeatTimeout() >> 16))), objArr89);
                            String str45 = (String) objArr89[0];
                            char c18 = (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 4546);
                            int i435 = -(-(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
                            int i436 = ((i435 | 683) << 1) - (i435 ^ 683);
                            int longPressTimeout = ViewConfiguration.getLongPressTimeout() >> 16;
                            int i437 = ((longPressTimeout | 14) << 1) - (longPressTimeout ^ 14);
                            Object[] objArr90 = new Object[1];
                            a(c18, i436, i437, objArr90);
                            char cIndexOf4 = (char) TextUtils.indexOf(str6, str6);
                            int i438 = -(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                            int i439 = (i438 ^ 698) + ((i438 & 698) << 1);
                            int i440 = -(KeyEvent.getMaxKeyCode() >> 16);
                            int i441 = (i440 ^ 16) + ((i440 & 16) << 1);
                            Object[] objArr91 = new Object[1];
                            a(cIndexOf4, i439, i441, objArr91);
                            String str46 = (String) objArr91[0];
                            int i442 = -(-(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)));
                            Object[] objArr92 = new Object[1];
                            a((char) ((i442 ^ 21512) + ((i442 & 21512) << 1)), 714 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (ViewConfiguration.getScrollBarSize() >> 8) + 3, objArr92);
                            String str47 = (String) objArr92[0];
                            char cResolveSize3 = (char) (22992 - View.resolveSize(0, 0));
                            int offsetAfter = TextUtils.getOffsetAfter(str6, 0);
                            int i443 = ((offsetAfter | 725) << 1) - (offsetAfter ^ 725);
                            int iMyTid2 = Process.myTid() >> 22;
                            int i444 = (iMyTid2 ^ 22) + ((iMyTid2 & 22) << 1);
                            Object[] objArr93 = new Object[1];
                            a(cResolveSize3, i443, i444, objArr93);
                            String str48 = (String) objArr93[0];
                            Object[] objArr94 = new Object[1];
                            a((char) Color.argb(0, 0, 0, 0), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 747, 24 - (~(-(-(ViewConfiguration.getEdgeSlop() >> 16)))), objArr94);
                            String str49 = (String) objArr94[0];
                            char edgeSlop2 = (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 30699);
                            int i445 = -(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                            int i446 = (i445 * (-317)) + 246587;
                            int i447 = ~i445;
                            int i448 = (i447 ^ (-774)) | (i447 & (-774));
                            int i449 = ~((i448 & i) | (i448 ^ i));
                            int i450 = ~((i169 ^ i445) | (i169 & i445) | 773);
                            int i451 = ((i449 ^ i450) | (i449 & i450)) * (-318);
                            int i452 = ((i446 | i451) << 1) - (i451 ^ i446);
                            int i453 = ~(((-774) & i445) | ((-774) ^ i445));
                            int i454 = ~((i445 & i) | (i445 ^ i));
                            int i455 = -(-(((i454 & i453) | (i453 ^ i454)) * (-318)));
                            int i456 = (i452 & i455) + (i455 | i452);
                            int i457 = ~(i447 | i);
                            int i458 = -(-(((i457 & (-774)) | ((-774) ^ i457)) * TypedValues.AttributesType.TYPE_PIVOT_TARGET));
                            Object[] objArr95 = new Object[1];
                            a(edgeSlop2, (i456 & i458) + (i458 | i456), 28 - (Process.myPid() >> 22), objArr95);
                            String str50 = (String) objArr95[0];
                            c2 = 6;
                            i31 = -1;
                            int i459 = artificialFrame + 85;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i459 % 128;
                            int i460 = i459 % 2;
                            int i461 = -(-(ViewConfiguration.getKeyRepeatTimeout() >> 16));
                            int i462 = -(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                            int iIPostMessageServiceStubProxy7 = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                            int i463 = i462 * 989;
                            int i464 = (i463 ^ (-789600)) + ((i463 & (-789600)) << 1);
                            int i465 = ~iIPostMessageServiceStubProxy7;
                            int i466 = ~(((-801) ^ i465) | (i465 & (-801)) | i462);
                            int i467 = (i462 & LogSeverity.EMERGENCY_VALUE) | (i462 ^ LogSeverity.EMERGENCY_VALUE);
                            int i468 = ~((i467 & iIPostMessageServiceStubProxy7) | (i467 ^ iIPostMessageServiceStubProxy7));
                            int i469 = ((i468 & i466) | (i466 ^ i468)) * 988;
                            int i470 = (((i464 | i469) << 1) - (i469 ^ i464)) + (((i462 ^ (-801)) | (i462 & (-801))) * (-988));
                            int i471 = ~i462;
                            int i472 = ~((i471 & (-801)) | (i471 ^ (-801)));
                            int i473 = ~(((-801) & iIPostMessageServiceStubProxy7) | ((-801) ^ iIPostMessageServiceStubProxy7));
                            int i474 = (i472 & i473) | (i472 ^ i473);
                            int i475 = ~iIPostMessageServiceStubProxy7;
                            int i476 = ~((i462 & i475) | (i475 ^ i462) | LogSeverity.EMERGENCY_VALUE);
                            Object[] objArr96 = new Object[1];
                            a((char) ((i461 & 11772) + (i461 | 11772)), (i470 - (~(((i474 & i476) | (i474 ^ i476)) * 988))) - 1, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 11, objArr96);
                            char maxKeyCode = (char) (KeyEvent.getMaxKeyCode() >> 16);
                            int i477 = -View.MeasureSpec.getSize(0);
                            Object[] objArr97 = new Object[1];
                            a(maxKeyCode, (i477 ^ 811) + ((i477 & 811) << 1), 7 - (~(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), objArr97);
                            int i478 = -(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                            int i479 = -(-View.resolveSizeAndState(0, 0, 0));
                            int i480 = ((i479 | 819) << 1) - (i479 ^ 819);
                            int i481 = -TextUtils.getCapsMode(str6, 0, 0);
                            int i482 = (i481 & 6) + (i481 | 6);
                            Object[] objArr98 = new Object[1];
                            a((char) ((i478 & 45437) + (i478 | 45437)), i480, i482, objArr98);
                            char mirror3 = (char) (AndroidCharacter.getMirror('0') + 35699);
                            int i483 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                            int i484 = (i483 & 824) + (i483 | 824);
                            int i485 = -(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                            int i486 = ((i485 | 6) << 1) - (i485 ^ 6);
                            Object[] objArr99 = new Object[1];
                            a(mirror3, i484, i486, objArr99);
                            String[] strArr14 = {(String) objArr96[0], (String) objArr97[0], (String) objArr98[0], (String) objArr99[0]};
                            int i487 = -(-Color.rgb(0, 0, 0));
                            int i488 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                            int i489 = -(-(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)));
                            int i490 = (i489 & 16) + (i489 | 16);
                            Object[] objArr100 = new Object[1];
                            a((char) ((i487 ^ 16777216) + ((i487 & 16777216) << 1)), (i488 ^ 830) + ((i488 & 830) << 1), i490, objArr100);
                            String str51 = (String) objArr100[0];
                            int i491 = -(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                            Object[] objArr101 = new Object[1];
                            a((char) ((i491 & 1) + (i491 | 1)), ImageFormat.getBitsPerPixel(0) + 667, 8 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), objArr101);
                            String str52 = (String) objArr101[0];
                            Object[] objArr102 = new Object[1];
                            a((char) Color.blue(0), 633 - (~(ViewConfiguration.getMinimumFlingVelocity() >> 16)), Color.rgb(0, 0, 0) + 16777224, objArr102);
                            Object[] objArr103 = new Object[1];
                            a((char) (28597 - TextUtils.lastIndexOf(str6, '0', 0)), View.combineMeasuredStates(0, 0) + 847, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 13, objArr103);
                            String str53 = (String) objArr103[0];
                            char scrollBarSize = (char) (9602 - (ViewConfiguration.getScrollBarSize() >> 8));
                            int i492 = -(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                            int i493 = (i492 & 861) + (i492 | 861);
                            int i494 = -View.MeasureSpec.getSize(0);
                            int i495 = (i494 & 1) + (i494 | 1);
                            Object[] objArr104 = new Object[1];
                            a(scrollBarSize, i493, i495, objArr104);
                            char modifierMetaStateMask3 = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 53314);
                            int i496 = -(-TextUtils.getOffsetAfter(str6, 0));
                            Object[] objArr105 = new Object[1];
                            a(modifierMetaStateMask3, (i496 & 862) + (i496 | 862), 9 - KeyEvent.getDeadChar(0, 0), objArr105);
                            String str54 = (String) objArr105[0];
                            char c19 = (char) ((-2) - (~(-(-(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))))));
                            int i497 = -AndroidCharacter.getMirror('0');
                            int size3 = View.MeasureSpec.getSize(0);
                            int i498 = ((size3 | 1) << 1) - (size3 ^ 1);
                            Object[] objArr106 = new Object[1];
                            a(c19, ((i497 | 919) << 1) - (i497 ^ 919), i498, objArr106);
                            char c20 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 29745);
                            int i499 = -(-TextUtils.indexOf((CharSequence) str6, '0', 0, 0));
                            int i500 = ((i499 | 873) << 1) - (i499 ^ 873);
                            int i501 = -TextUtils.indexOf((CharSequence) str6, '0');
                            int i502 = ((i501 | 15) << 1) - (i501 ^ 15);
                            Object[] objArr107 = new Object[1];
                            a(c20, i500, i502, objArr107);
                            String str55 = (String) objArr107[0];
                            char c21 = (char) (21511 - (~ExpandableListView.getPackedPositionType(0L)));
                            int longPressTimeout2 = ViewConfiguration.getLongPressTimeout() >> 16;
                            int i503 = (longPressTimeout2 & 714) + (longPressTimeout2 | 714);
                            int i504 = -(Process.myPid() >> 22);
                            int i505 = (i504 ^ 3) + ((i504 & 3) << 1);
                            Object[] objArr108 = new Object[1];
                            a(c21, i503, i505, objArr108);
                            String str56 = (String) objArr108[0];
                            char maximumDrawingCacheSize2 = (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                            int i506 = -(-TextUtils.indexOf((CharSequence) str6, '0', 0, 0));
                            int i507 = ((i506 | 660) << 1) - (i506 ^ 660);
                            int i508 = -View.getDefaultSize(0, 0);
                            int i509 = (i508 & 7) + (i508 | 7);
                            Object[] objArr109 = new Object[1];
                            a(maximumDrawingCacheSize2, i507, i509, objArr109);
                            String str57 = (String) objArr109[0];
                            int i510 = -View.resolveSize(0, 0);
                            int i511 = -(-ExpandableListView.getPackedPositionType(0L));
                            Object[] objArr110 = new Object[1];
                            a((char) ((i510 ^ 30213) + ((i510 & 30213) << 1)), (i511 ^ com.salesforce.marketingcloud.analytics.b.q) + ((i511 & com.salesforce.marketingcloud.analytics.b.q) << 1), TextUtils.getCapsMode(str6, 0, 0) + 8, objArr110);
                            String str58 = (String) objArr110[0];
                            int i512 = -MotionEvent.axisFromString(str6);
                            int i513 = 671 - (~(-(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))));
                            int doubleTapTimeout3 = ViewConfiguration.getDoubleTapTimeout() >> 16;
                            int i514 = (doubleTapTimeout3 ^ 11) + ((doubleTapTimeout3 & 11) << 1);
                            Object[] objArr111 = new Object[1];
                            a((char) ((i512 ^ 32917) + ((i512 & 32917) << 1)), i513, i514, objArr111);
                            String str59 = (String) objArr111[0];
                            int i515 = -View.resolveSizeAndState(0, 0, 0);
                            int i516 = 683 - (~(-(-(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))));
                            int edgeSlop3 = ViewConfiguration.getEdgeSlop() >> 16;
                            Object[] objArr112 = new Object[1];
                            a((char) (((i515 | 4547) << 1) - (i515 ^ 4547)), i516, (edgeSlop3 & 14) + (edgeSlop3 | 14), objArr112);
                            char modifierMetaStateMask4 = (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask()));
                            int i517 = -TextUtils.indexOf((CharSequence) str6, '0', 0, 0);
                            int i518 = (i517 & 895) + (i517 | 895);
                            int longPressTimeout3 = ViewConfiguration.getLongPressTimeout() >> 16;
                            int i519 = ((longPressTimeout3 | 20) << 1) - (longPressTimeout3 ^ 20);
                            Object[] objArr113 = new Object[1];
                            a(modifierMetaStateMask4, i518, i519, objArr113);
                            String str60 = (String) objArr113[0];
                            char offsetAfter2 = (char) TextUtils.getOffsetAfter(str6, 0);
                            int threadPriority4 = Process.getThreadPriority(0);
                            int i520 = -(-(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                            int i521 = (i520 ^ 20) + ((i520 & 20) << 1);
                            Object[] objArr114 = new Object[1];
                            a(offsetAfter2, (((threadPriority4 & 20) + (threadPriority4 | 20)) >> 6) + 916, i521, objArr114);
                            String str61 = (String) objArr114[0];
                            char c22 = (char) (21822 - (~(-(-Gravity.getAbsoluteGravity(0, 0)))));
                            int iIndexOf10 = TextUtils.indexOf(str6, str6, 0, 0);
                            int iIPostMessageServiceStubProxy8 = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                            int i522 = ~iIndexOf10;
                            int i523 = ~iIPostMessageServiceStubProxy8;
                            int i524 = ~((i523 & i522) | (i522 ^ i523));
                            int i525 = ~((-936) | iIPostMessageServiceStubProxy8);
                            int i526 = (((iIndexOf10 * (-574)) - 536690) - (~(((i524 ^ i525) | (i524 & i525)) * 1150))) - 1;
                            int i527 = ~(((-936) & iIPostMessageServiceStubProxy8) | ((-936) ^ iIPostMessageServiceStubProxy8));
                            int i528 = ~iIPostMessageServiceStubProxy8;
                            int i529 = ~((i528 ^ 935) | (i528 & 935));
                            int i530 = i526 + (((i529 & i527) | (i527 ^ i529)) * (-575));
                            int i531 = ((~((iIPostMessageServiceStubProxy8 & i522) | (i522 ^ iIPostMessageServiceStubProxy8))) | (~((i528 ^ iIndexOf10) | (iIndexOf10 & i528)))) * 575;
                            int i532 = (i530 & i531) + (i531 | i530);
                            int iAxisFromString = MotionEvent.axisFromString(str6);
                            int i533 = (iAxisFromString ^ 32) + ((iAxisFromString & 32) << 1);
                            Object[] objArr115 = new Object[1];
                            a(c22, i532, i533, objArr115);
                            String str62 = (String) objArr115[0];
                            int i534 = -Process.getGidForName(str6);
                            int i535 = -KeyEvent.normalizeMetaState(0);
                            int i536 = ((i535 | 966) << 1) - (i535 ^ 966);
                            int i537 = -(ViewConfiguration.getScrollDefaultDelay() >> 16);
                            int i538 = ((i537 | 26) << 1) - (i537 ^ 26);
                            Object[] objArr116 = new Object[1];
                            a((char) ((i534 ^ 29772) + ((i534 & 29772) << 1)), i536, i538, objArr116);
                            String str63 = (String) objArr116[0];
                            char c23 = (char) (9581 - (~(-(ViewConfiguration.getPressedStateDuration() >> 16))));
                            int i539 = -TextUtils.indexOf((CharSequence) str6, '0', 0, 0);
                            int i540 = (i539 ^ 991) + ((i539 & 991) << 1);
                            int i541 = -(ViewConfiguration.getScrollBarFadeDuration() >> 16);
                            int i542 = ((i541 | 23) << 1) - (i541 ^ 23);
                            Object[] objArr117 = new Object[1];
                            a(c23, i540, i542, objArr117);
                            String str64 = (String) objArr117[0];
                            int i543 = -Color.rgb(0, 0, 0);
                            Object[] objArr118 = new Object[1];
                            a((char) ((i543 ^ (-16767899)) + ((i543 & (-16767899)) << 1)), 1014 - (~(-(-View.MeasureSpec.getSize(0)))), 31 - (~(-TextUtils.lastIndexOf(str6, '0'))), objArr118);
                            String str65 = (String) objArr118[0];
                            str8 = str6;
                            char cResolveSizeAndState2 = (char) View.resolveSizeAndState(0, 0, 0);
                            int touchSlop3 = ViewConfiguration.getTouchSlop() >> 8;
                            int i544 = (touchSlop3 ^ 1048) + ((touchSlop3 & 1048) << 1);
                            int i545 = -(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                            int i546 = (i545 & 13) + (i545 | 13);
                            Object[] objArr119 = new Object[1];
                            a(cResolveSizeAndState2, i544, i546, objArr119);
                            String str66 = (String) objArr119[0];
                            int absoluteGravity3 = Gravity.getAbsoluteGravity(0, 0);
                            char c24 = (char) ((absoluteGravity3 & 23047) + (absoluteGravity3 | 23047));
                            int keyRepeatDelay4 = 627 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                            int i547 = -(ViewConfiguration.getLongPressTimeout() >> 16);
                            int i548 = (i547 ^ 7) + ((i547 & 7) << 1);
                            Object[] objArr120 = new Object[1];
                            a(c24, keyRepeatDelay4, i548, objArr120);
                            int packedPositionChild = ExpandableListView.getPackedPositionChild(0L);
                            int scrollDefaultDelay = 1061 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                            int i549 = -KeyEvent.normalizeMetaState(0);
                            int i550 = ((i549 | 30) << 1) - (i549 ^ 30);
                            Object[] objArr121 = new Object[1];
                            a((char) (((packedPositionChild | 1) << 1) - (packedPositionChild ^ 1)), scrollDefaultDelay, i550, objArr121);
                            String str67 = (String) objArr121[0];
                            int i551 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                            int i552 = (i551 * 866) - 5501952;
                            int i553 = ~i551;
                            int i554 = -(-(((~((i553 & i169) | (i553 ^ i169))) | (-6369)) * (-865)));
                            int i555 = (((i552 & i554) + (i552 | i554)) - (~((~((i551 ^ i) | (i551 & i))) * 865))) - 1;
                            int i556 = ~(((-6369) ^ i169) | ((-6369) & i169));
                            int i557 = ~((i551 & i169) | (i169 ^ i551));
                            int i558 = ((i557 & i556) | (i556 ^ i557)) * 865;
                            char c25 = (char) ((i555 ^ i558) + ((i558 & i555) << 1));
                            int i559 = -(-View.MeasureSpec.getSize(0));
                            int i560 = (i559 ^ 1091) + ((i559 & 1091) << 1);
                            int iIndexOf11 = TextUtils.indexOf((CharSequence) str8, '0', 0);
                            int iIPostMessageServiceStubProxy9 = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                            int i561 = (iIndexOf11 * (-380)) + 4584;
                            int i562 = ~iIndexOf11;
                            int i563 = -(-((iIPostMessageServiceStubProxy9 | 12 | i562) * (-381)));
                            int i564 = (i561 & i563) + (i561 | i563);
                            int i565 = ~((~iIndexOf11) | (-13));
                            int i566 = ~iIPostMessageServiceStubProxy9;
                            int i567 = (~((i566 & 12) | (i566 ^ 12))) | i565;
                            int i568 = ~((iIndexOf11 ^ 12) | (iIndexOf11 & 12));
                            int i569 = (i564 - (~(((i567 & i568) | (i567 ^ i568)) * 381))) - 1;
                            int i570 = (~(i562 | 12)) * 381;
                            int i571 = ((i569 | i570) << 1) - (i570 ^ i569);
                            Object[] objArr122 = new Object[1];
                            a(c25, i560, i571, objArr122);
                            int iIndexOf12 = TextUtils.indexOf((CharSequence) str8, '0', 0);
                            int i572 = -(ViewConfiguration.getScrollBarFadeDuration() >> 16);
                            Object[] objArr123 = new Object[1];
                            a((char) (((iIndexOf12 | 26730) << 1) - (iIndexOf12 ^ 26730)), (i572 ^ 1102) + ((i572 & 1102) << 1), 18 - (~(-(-TextUtils.indexOf(str8, str8, 0, 0)))), objArr123);
                            String str68 = (String) objArr123[0];
                            char c26 = (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                            int i573 = -KeyEvent.normalizeMetaState(0);
                            int i574 = ((i573 | 1121) << 1) - (i573 ^ 1121);
                            int scrollBarSize2 = ViewConfiguration.getScrollBarSize() >> 8;
                            int i575 = (scrollBarSize2 ^ 5) + ((scrollBarSize2 & 5) << 1);
                            Object[] objArr124 = new Object[1];
                            a(c26, i574, i575, objArr124);
                            char keyRepeatTimeout5 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                            int i576 = (-16776091) - (~(-Color.rgb(0, 0, 0)));
                            int iResolveSize2 = View.resolveSize(0, 0);
                            int i577 = ((iResolveSize2 | 19) << 1) - (iResolveSize2 ^ 19);
                            Object[] objArr125 = new Object[1];
                            a(keyRepeatTimeout5, i576, i577, objArr125);
                            char cIndexOf5 = (char) TextUtils.indexOf(str8, str8, 0, 0);
                            int iGreen3 = Color.green(0);
                            int i578 = ((iGreen3 | 1145) << 1) - (iGreen3 ^ 1145);
                            int i579 = -(-AndroidCharacter.getMirror('0'));
                            int i580 = (i579 ^ (-32)) + ((i579 & (-32)) << 1);
                            Object[] objArr126 = new Object[1];
                            a(cIndexOf5, i578, i580, objArr126);
                            int i581 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                            Object[] objArr127 = new Object[1];
                            a((char) (((i581 | 43328) << 1) - (i581 ^ 43328)), 1160 - (~(-(-View.resolveSize(0, 0)))), 18 - (~(ViewConfiguration.getLongPressTimeout() >> 16)), objArr127);
                            int i582 = -(Process.myPid() >> 22);
                            int i583 = -(-ExpandableListView.getPackedPositionType(0L));
                            int i584 = (i583 & 1180) + (i583 | 1180);
                            int i585 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                            int i586 = i585 * (-1975);
                            int i587 = (i586 & 18791) + (i586 | 18791);
                            int i588 = ~i585;
                            int i589 = ~(i588 | 19);
                            int i590 = i587 + (((i589 & i) | (i ^ i589)) * 988);
                            int i591 = ~((-20) | i585);
                            int i592 = ~(i585 | i169);
                            int i593 = -(-(((i592 & i591) | (i591 ^ i592)) * (-1976)));
                            int i594 = (i590 ^ i593) + ((i593 & i590) << 1);
                            int i595 = ~((i588 & 19) | (i588 ^ 19));
                            int i596 = ~(((-20) & i) | ((-20) ^ i));
                            int i597 = (i595 & i596) | (i595 ^ i596);
                            int i598 = ~((i169 ^ 19) | (i169 & 19));
                            int i599 = -(-(((i597 & i598) | (i597 ^ i598)) * 988));
                            int i600 = (i594 & i599) + (i599 | i594);
                            Object[] objArr128 = new Object[1];
                            a((char) (((i582 | 31256) << 1) - (i582 ^ 31256)), i584, i600, objArr128);
                            int i601 = -(-TextUtils.indexOf((CharSequence) str8, '0', 0, 0));
                            int i602 = -AndroidCharacter.getMirror('0');
                            Object[] objArr129 = new Object[1];
                            a((char) ((i601 & 61337) + (i601 | 61337)), ((i602 | 1247) << 1) - (i602 ^ 1247), 23 - (KeyEvent.getMaxKeyCode() >> 16), objArr129);
                            int i603 = -(ViewConfiguration.getDoubleTapTimeout() >> 16);
                            int i604 = -(-(i603 * (-963)));
                            int i605 = (i604 & (-964)) + (i604 | (-964)) + 43534045;
                            int i606 = ~i603;
                            int i607 = ~(((-45114) ^ i) | ((-45114) & i));
                            int i608 = i605 + (((i606 & i607) | (i606 ^ i607)) * (-964));
                            int i609 = -(-(((~(i603 | (-45114))) | (~(((-45114) ^ i169) | ((-45114) & i169)))) * (-964)));
                            char c27 = (char) ((i608 & i609) + (i609 | i608));
                            int i610 = -View.resolveSize(0, 0);
                            int i611 = (i610 ^ 1222) + ((i610 & 1222) << 1);
                            int i612 = -(-(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                            int i613 = (i612 & 20) + (i612 | 20);
                            Object[] objArr130 = new Object[1];
                            a(c27, i611, i613, objArr130);
                            int i614 = -(-(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                            int i615 = -Color.rgb(0, 0, 0);
                            int i616 = ((i615 | (-16775973)) << 1) - (i615 ^ (-16775973));
                            int i617 = -ExpandableListView.getPackedPositionType(0L);
                            int i618 = (i617 & 24) + (i617 | 24);
                            Object[] objArr131 = new Object[1];
                            a((char) (((i614 | 26190) << 1) - (i614 ^ 26190)), i616, i618, objArr131);
                            String str69 = str;
                            char c28 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                            int i619 = -View.MeasureSpec.getSize(0);
                            Object[] objArr132 = new Object[1];
                            a(c28, ((i619 | 1267) << 1) - (i619 ^ 1267), View.getDefaultSize(0, 0) + 28, objArr132);
                            char c29 = (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                            int i620 = -Color.rgb(0, 0, 0);
                            Object[] objArr133 = new Object[1];
                            a(c29, (i620 ^ (-16775921)) + ((i620 & (-16775921)) << 1), 26 - (~(-(-(Process.myPid() >> 22)))), objArr133);
                            char c30 = (char) (29032 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                            int i621 = 1321 - (~ExpandableListView.getPackedPositionGroup(0L));
                            int i622 = -Color.blue(0);
                            int i623 = (i622 & 31) + (i622 | 31);
                            Object[] objArr134 = new Object[1];
                            a(c30, i621, i623, objArr134);
                            char defaultSize2 = (char) (14167 - View.getDefaultSize(0, 0));
                            int i624 = 1352 - (~(ViewConfiguration.getMinimumFlingVelocity() >> 16));
                            int size4 = View.MeasureSpec.getSize(0);
                            int i625 = ((size4 | 27) << 1) - (size4 ^ 27);
                            Object[] objArr135 = new Object[1];
                            a(defaultSize2, i624, i625, objArr135);
                            int i626 = -KeyEvent.normalizeMetaState(0);
                            int maximumDrawingCacheSize3 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 1380;
                            int scrollBarSize3 = ViewConfiguration.getScrollBarSize() >> 8;
                            int i627 = (scrollBarSize3 ^ 32) + ((scrollBarSize3 & 32) << 1);
                            Object[] objArr136 = new Object[1];
                            a((char) (((i626 | 35676) << 1) - (i626 ^ 35676)), maximumDrawingCacheSize3, i627, objArr136);
                            strArr3 = new String[][]{new String[]{str39, str40, str41, (String) objArr85[0]}, new String[]{str42, str43, str44, str45, (String) objArr90[0]}, new String[]{str46, str47, str, str48, str49, str50}, strArr14, new String[]{str51, str52, (String) objArr102[0]}, new String[]{str53, (String) objArr104[0]}, new String[]{str54, (String) objArr106[0]}, new String[]{str55, str56, str57, str58, str59, (String) objArr112[0]}, new String[]{str60, str61, str62, str63, str64, str65, str}, new String[]{str66, (String) objArr120[0]}, new String[]{str67, (String) objArr122[0]}, new String[]{str68, (String) objArr124[0]}, new String[]{(String) objArr125[0]}, new String[]{(String) objArr126[0]}, new String[]{(String) objArr127[0]}, new String[]{(String) objArr128[0]}, new String[]{(String) objArr129[0]}, new String[]{(String) objArr130[0]}, new String[]{(String) objArr131[0], str69}, new String[]{(String) objArr132[0], str69}, new String[]{(String) objArr133[0], str69}, new String[]{(String) objArr134[0], str69}, new String[]{(String) objArr135[0], str69}, new String[]{(String) objArr136[0], str69}};
                            arrayList = new ArrayList();
                            i32 = i;
                            i33 = 0;
                            i34 = 0;
                            while (i33 < 24) {
                                int i628 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                i40 = (i628 & 73) + (i628 | 73);
                                artificialFrame = i40 % 128;
                                if (i40 % 2 == 0) {
                                    strArr4 = strArr3[i33];
                                    Object[] objArr137 = {strArr4[1]};
                                    objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                                    if (objAccessartificialFrame11 == null) {
                                        int minimumFlingVelocity2 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 23;
                                        char mirror4 = (char) (AndroidCharacter.getMirror('0') - '0');
                                        int minimumFlingVelocity3 = 2441 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                                        byte[] bArr18 = $$a;
                                        Object[] objArr138 = new Object[1];
                                        b((byte) 49, bArr18[16], bArr18[10], objArr138);
                                        objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity2, mirror4, minimumFlingVelocity3, 954751276, false, (String) objArr138[0], new Class[]{String.class});
                                    }
                                    str10 = (String) ((Method) objAccessartificialFrame11).invoke(null, objArr137);
                                    strArr5 = (String[]) Arrays.copyOfRange(strArr4, 1, strArr4.length);
                                    if (str10 != null) {
                                        i41 = artificialFrame + 27;
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i41 % 128;
                                        if (i41 % 2 != 0) {
                                            int i629 = 23 / 0;
                                            if (str10.length() != 0) {
                                                if (strArr4.length != 1) {
                                                    Object[] objArr139 = {str10, strArr5};
                                                    objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(311378445);
                                                    if (objAccessartificialFrame10 == null) {
                                                        int keyRepeatDelay5 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 29;
                                                        char keyRepeatTimeout6 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                                                        int i630 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + FrameMetricsAggregator.EVERY_DURATION;
                                                        byte b4 = $$a[16];
                                                        byte b5 = b4;
                                                        Object[] objArr140 = new Object[1];
                                                        b(b5, (byte) (b5 | 7), b4, objArr140);
                                                        objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay5, keyRepeatTimeout6, i630, -1914043387, false, (String) objArr140[0], new Class[]{String.class, String[].class});
                                                    }
                                                    long jLongValue12 = ((Long) ((Method) objAccessartificialFrame10).invoke(null, objArr139)).longValue();
                                                    long j76 = -1961190699;
                                                    strArr6 = strArr3;
                                                    long j77 = -406;
                                                    long j78 = jLongValue12 ^ j20;
                                                    i42 = i33;
                                                    long jUptimeMillis = (int) SystemClock.uptimeMillis();
                                                    long j79 = jUptimeMillis ^ j20;
                                                    long j80 = (((long) (-405)) * j76) + (((long) 407) * jLongValue12) + ((((j78 | jUptimeMillis) ^ j20) | (((j79 | j76) | jLongValue12) ^ j20)) * j77) + (j77 * (((j78 | j79) | j76) ^ j20)) + (((long) 406) * (((jUptimeMillis | (j76 ^ j20)) ^ j20) | ((j79 | jLongValue12) ^ j20))) + ((long) 1986464153);
                                                    i43 = ((int) (j80 >> 32)) & (785016995 + (((~(132250616 | i)) | 1304975794) * 191) + (((~(132250616 | i169)) | 1208483842) * 191));
                                                    int elapsedCpuTime4 = (int) Process.getElapsedCpuTime();
                                                    i44 = ((int) j80) & (922154449 + (((~(1909484194 | elapsedCpuTime4)) | (-948256692)) * (-668)) + ((1909484194 | (~((-948256692) | elapsedCpuTime4))) * 1336) + ((elapsedCpuTime4 | (-134550802)) * 668));
                                                    if (((i43 & i44) | (i43 ^ i44)) != 0) {
                                                    }
                                                } else {
                                                    strArr6 = strArr3;
                                                    i42 = i33;
                                                }
                                                int i631 = ((i34 | 1) << 1) - (i34 ^ 1);
                                                int i632 = ((i42 | 10) << 1) - (i42 ^ 10);
                                                int i633 = (i632 & i169) | ((~i632) & i);
                                                StringBuilder sb = new StringBuilder();
                                                sb.append(str10);
                                                char deadChar5 = (char) KeyEvent.getDeadChar(0, 0);
                                                int i634 = -(-(ViewConfiguration.getEdgeSlop() >> 16));
                                                Object[] objArr141 = new Object[1];
                                                a(deadChar5, (i634 & 1412) + (i634 | 1412), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), objArr141);
                                                sb.append((String) objArr141[0]);
                                                sb.append(str10);
                                                arrayList.add(sb.toString());
                                                i34 = i631;
                                                i32 = i633;
                                            }
                                            i32 = i32;
                                        } else {
                                            if (str10.length() != 0) {
                                                if (strArr4.length != 1) {
                                                    Object[] objArr1310 = {str10, strArr5};
                                                    objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(311378445);
                                                    if (objAccessartificialFrame10 == null) {
                                                        int keyRepeatDelay6 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 29;
                                                        char keyRepeatTimeout7 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                                                        int i635 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + FrameMetricsAggregator.EVERY_DURATION;
                                                        byte b6 = $$a[16];
                                                        byte b7 = b6;
                                                        Object[] objArr142 = new Object[1];
                                                        b(b7, (byte) (b7 | 7), b6, objArr142);
                                                        objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay6, keyRepeatTimeout7, i635, -1914043387, false, (String) objArr142[0], new Class[]{String.class, String[].class});
                                                    }
                                                    long jLongValue13 = ((Long) ((Method) objAccessartificialFrame10).invoke(null, objArr1310)).longValue();
                                                    long j710 = -1961190699;
                                                    strArr6 = strArr3;
                                                    long j711 = -406;
                                                    long j712 = jLongValue13 ^ j20;
                                                    i42 = i33;
                                                    long jUptimeMillis2 = (int) SystemClock.uptimeMillis();
                                                    long j713 = jUptimeMillis2 ^ j20;
                                                    long j81 = (((long) (-405)) * j710) + (((long) 407) * jLongValue13) + ((((j712 | jUptimeMillis2) ^ j20) | (((j713 | j710) | jLongValue13) ^ j20)) * j711) + (j711 * (((j712 | j713) | j710) ^ j20)) + (((long) 406) * (((jUptimeMillis2 | (j710 ^ j20)) ^ j20) | ((j713 | jLongValue13) ^ j20))) + ((long) 1986464153);
                                                    i43 = ((int) (j81 >> 32)) & (785016995 + (((~(132250616 | i)) | 1304975794) * 191) + (((~(132250616 | i169)) | 1208483842) * 191));
                                                    int elapsedCpuTime5 = (int) Process.getElapsedCpuTime();
                                                    i44 = ((int) j81) & (922154449 + (((~(1909484194 | elapsedCpuTime5)) | (-948256692)) * (-668)) + ((1909484194 | (~((-948256692) | elapsedCpuTime5))) * 1336) + ((elapsedCpuTime5 | (-134550802)) * 668));
                                                    if (((i43 & i44) | (i43 ^ i44)) != 0) {
                                                    }
                                                } else {
                                                    strArr6 = strArr3;
                                                    i42 = i33;
                                                }
                                                int i636 = ((i34 | 1) << 1) - (i34 ^ 1);
                                                int i637 = ((i42 | 10) << 1) - (i42 ^ 10);
                                                int i638 = (i637 & i169) | ((~i637) & i);
                                                StringBuilder sb2 = new StringBuilder();
                                                sb2.append(str10);
                                                char deadChar6 = (char) KeyEvent.getDeadChar(0, 0);
                                                int i639 = -(-(ViewConfiguration.getEdgeSlop() >> 16));
                                                Object[] objArr143 = new Object[1];
                                                a(deadChar6, (i639 & 1412) + (i639 | 1412), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), objArr143);
                                                sb2.append((String) objArr143[0]);
                                                sb2.append(str10);
                                                arrayList.add(sb2.toString());
                                                i34 = i636;
                                                i32 = i638;
                                            }
                                            i32 = i32;
                                        }
                                    }
                                    i33 = i42 + 1;
                                    str8 = str8;
                                    strArr3 = strArr6;
                                } else {
                                    str8 = str8;
                                    i32 = i32;
                                    strArr4 = strArr3[i33];
                                    Object[] objArr144 = {strArr4[0]};
                                    objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                                    if (objAccessartificialFrame9 == null) {
                                        int i640 = 23 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                                        char packedPositionChild2 = (char) ((-1) - ExpandableListView.getPackedPositionChild(0L));
                                        int touchSlop4 = 2441 - (ViewConfiguration.getTouchSlop() >> 8);
                                        byte[] bArr19 = $$a;
                                        Object[] objArr145 = new Object[1];
                                        b((byte) 49, bArr19[16], bArr19[10], objArr145);
                                        objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(i640, packedPositionChild2, touchSlop4, 954751276, false, (String) objArr145[0], new Class[]{String.class});
                                    }
                                    str10 = (String) ((Method) objAccessartificialFrame9).invoke(null, objArr144);
                                    strArr5 = (String[]) Arrays.copyOfRange(strArr4, 1, strArr4.length);
                                    if (str10 != null) {
                                        i41 = artificialFrame + 27;
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i41 % 128;
                                        if (i41 % 2 != 0) {
                                            int i6210 = 23 / 0;
                                            if (str10.length() != 0) {
                                                if (strArr4.length != 1) {
                                                    Object[] objArr1311 = {str10, strArr5};
                                                    objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(311378445);
                                                    if (objAccessartificialFrame10 == null) {
                                                        int keyRepeatDelay7 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 29;
                                                        char keyRepeatTimeout8 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                                                        int i6310 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + FrameMetricsAggregator.EVERY_DURATION;
                                                        byte b8 = $$a[16];
                                                        byte b9 = b8;
                                                        Object[] objArr146 = new Object[1];
                                                        b(b9, (byte) (b9 | 7), b8, objArr146);
                                                        objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay7, keyRepeatTimeout8, i6310, -1914043387, false, (String) objArr146[0], new Class[]{String.class, String[].class});
                                                    }
                                                    long jLongValue14 = ((Long) ((Method) objAccessartificialFrame10).invoke(null, objArr1311)).longValue();
                                                    long j714 = -1961190699;
                                                    strArr6 = strArr3;
                                                    long j715 = -406;
                                                    long j716 = jLongValue14 ^ j20;
                                                    i42 = i33;
                                                    long jUptimeMillis3 = (int) SystemClock.uptimeMillis();
                                                    long j717 = jUptimeMillis3 ^ j20;
                                                    long j82 = (((long) (-405)) * j714) + (((long) 407) * jLongValue14) + ((((j716 | jUptimeMillis3) ^ j20) | (((j717 | j714) | jLongValue14) ^ j20)) * j715) + (j715 * (((j716 | j717) | j714) ^ j20)) + (((long) 406) * (((jUptimeMillis3 | (j714 ^ j20)) ^ j20) | ((j717 | jLongValue14) ^ j20))) + ((long) 1986464153);
                                                    i43 = ((int) (j82 >> 32)) & (785016995 + (((~(132250616 | i)) | 1304975794) * 191) + (((~(132250616 | i169)) | 1208483842) * 191));
                                                    int elapsedCpuTime6 = (int) Process.getElapsedCpuTime();
                                                    i44 = ((int) j82) & (922154449 + (((~(1909484194 | elapsedCpuTime6)) | (-948256692)) * (-668)) + ((1909484194 | (~((-948256692) | elapsedCpuTime6))) * 1336) + ((elapsedCpuTime6 | (-134550802)) * 668));
                                                    if (((i43 & i44) | (i43 ^ i44)) != 0) {
                                                    }
                                                } else {
                                                    strArr6 = strArr3;
                                                    i42 = i33;
                                                }
                                                int i6311 = ((i34 | 1) << 1) - (i34 ^ 1);
                                                int i6312 = ((i42 | 10) << 1) - (i42 ^ 10);
                                                int i6313 = (i6312 & i169) | ((~i6312) & i);
                                                StringBuilder sb3 = new StringBuilder();
                                                sb3.append(str10);
                                                char deadChar7 = (char) KeyEvent.getDeadChar(0, 0);
                                                int i6314 = -(-(ViewConfiguration.getEdgeSlop() >> 16));
                                                Object[] objArr147 = new Object[1];
                                                a(deadChar7, (i6314 & 1412) + (i6314 | 1412), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), objArr147);
                                                sb3.append((String) objArr147[0]);
                                                sb3.append(str10);
                                                arrayList.add(sb3.toString());
                                                i34 = i6311;
                                                i32 = i6313;
                                            }
                                            i32 = i32;
                                        } else {
                                            if (str10.length() != 0) {
                                                if (strArr4.length != 1) {
                                                    Object[] objArr1312 = {str10, strArr5};
                                                    objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(311378445);
                                                    if (objAccessartificialFrame10 == null) {
                                                        int keyRepeatDelay8 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 29;
                                                        char keyRepeatTimeout9 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                                                        int i6315 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + FrameMetricsAggregator.EVERY_DURATION;
                                                        byte b10 = $$a[16];
                                                        byte b11 = b10;
                                                        Object[] objArr148 = new Object[1];
                                                        b(b11, (byte) (b11 | 7), b10, objArr148);
                                                        objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay8, keyRepeatTimeout9, i6315, -1914043387, false, (String) objArr148[0], new Class[]{String.class, String[].class});
                                                    }
                                                    long jLongValue15 = ((Long) ((Method) objAccessartificialFrame10).invoke(null, objArr1312)).longValue();
                                                    long j718 = -1961190699;
                                                    strArr6 = strArr3;
                                                    long j719 = -406;
                                                    long j7110 = jLongValue15 ^ j20;
                                                    i42 = i33;
                                                    long jUptimeMillis4 = (int) SystemClock.uptimeMillis();
                                                    long j7111 = jUptimeMillis4 ^ j20;
                                                    long j83 = (((long) (-405)) * j718) + (((long) 407) * jLongValue15) + ((((j7110 | jUptimeMillis4) ^ j20) | (((j7111 | j718) | jLongValue15) ^ j20)) * j719) + (j719 * (((j7110 | j7111) | j718) ^ j20)) + (((long) 406) * (((jUptimeMillis4 | (j718 ^ j20)) ^ j20) | ((j7111 | jLongValue15) ^ j20))) + ((long) 1986464153);
                                                    i43 = ((int) (j83 >> 32)) & (785016995 + (((~(132250616 | i)) | 1304975794) * 191) + (((~(132250616 | i169)) | 1208483842) * 191));
                                                    int elapsedCpuTime7 = (int) Process.getElapsedCpuTime();
                                                    i44 = ((int) j83) & (922154449 + (((~(1909484194 | elapsedCpuTime7)) | (-948256692)) * (-668)) + ((1909484194 | (~((-948256692) | elapsedCpuTime7))) * 1336) + ((elapsedCpuTime7 | (-134550802)) * 668));
                                                    if (((i43 & i44) | (i43 ^ i44)) != 0) {
                                                    }
                                                } else {
                                                    strArr6 = strArr3;
                                                    i42 = i33;
                                                }
                                                int i6316 = ((i34 | 1) << 1) - (i34 ^ 1);
                                                int i6317 = ((i42 | 10) << 1) - (i42 ^ 10);
                                                int i6318 = (i6317 & i169) | ((~i6317) & i);
                                                StringBuilder sb4 = new StringBuilder();
                                                sb4.append(str10);
                                                char deadChar8 = (char) KeyEvent.getDeadChar(0, 0);
                                                int i6319 = -(-(ViewConfiguration.getEdgeSlop() >> 16));
                                                Object[] objArr149 = new Object[1];
                                                a(deadChar8, (i6319 & 1412) + (i6319 | 1412), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), objArr149);
                                                sb4.append((String) objArr149[0]);
                                                sb4.append(str10);
                                                arrayList.add(sb4.toString());
                                                i34 = i6316;
                                                i32 = i6318;
                                            }
                                            i32 = i32;
                                        }
                                    }
                                    i33 = i42 + 1;
                                    str8 = str8;
                                    strArr3 = strArr6;
                                }
                                strArr6 = strArr3;
                                i42 = i33;
                                i32 = i32;
                                i33 = i42 + 1;
                                str8 = str8;
                                strArr3 = strArr6;
                            }
                            str9 = str8;
                            i35 = i32;
                            if (i34 > 2) {
                                objArr = new Object[]{arrayList, new int[]{(i | i) & (~(i & i))}, null, new int[]{i}, new int[]{i35}};
                                int i641 = (-1) - (~(-(-(((1283078155 + (((~((-397000172) | i169)) | (~((-208448287) | i))) * (-370))) + ((((~((-397000172) | i)) | (~((-208448287) | i169))) | (-535674880)) * (-370))) - 631209984))));
                                int i642 = i641 << 13;
                                int i643 = (i642 & (~i641)) | ((~i642) & i641);
                                int i644 = i643 ^ (i643 >>> 17);
                                int i645 = i644 << 5;
                                i37 = 0;
                                c3 = 4;
                                i36 = 1;
                            } else {
                                objArr = new Object[]{null, new int[1], null, new int[]{i}, new int[]{i}};
                                int elapsedCpuTime8 = (int) Process.getElapsedCpuTime();
                                int i646 = 2063318369 + (((~((-439154682) | elapsedCpuTime8)) | 136868112) * 104) + ((~((~elapsedCpuTime8) | 468580345)) * (-104)) + ((elapsedCpuTime8 | 166293776) * 104);
                                int i647 = (-1) - (~(-(-((i646 << 1) - i646))));
                                int i648 = (i647 << 13) ^ i647;
                                int i649 = i648 ^ (i648 >>> 17);
                                int i650 = i649 << 5;
                                int i651 = (i649 | i650) & (~(i649 & i650));
                                i36 = 1;
                                i37 = 0;
                                ((int[]) objArr[1])[0] = i651;
                                c3 = 4;
                            }
                            i38 = ((int[]) objArr[c3])[i37];
                            if (i38 != i) {
                                objArr2 = new Object[5];
                                objArr2[i36] = new int[i36];
                                int[] iArr = new int[i36];
                                objArr2[3] = iArr;
                                int[] iArr2 = new int[i36];
                                objArr2[c3] = iArr2;
                                List list = (List) objArr[i37];
                                iArr[i37] = i;
                                iArr2[i37] = i38;
                                objArr2[i37] = list;
                                objArr2[2] = null;
                                int elapsedCpuTime9 = (int) Process.getElapsedCpuTime();
                                int i652 = i3 + (-441151705) + (((~((-57940110) | elapsedCpuTime9)) | 50331781) * (-140)) + ((~((-7608329) | elapsedCpuTime9)) * 70) + (((~(elapsedCpuTime9 | 663388567)) | (-620665115)) * 70) + 16;
                                int i653 = i652 << 13;
                                int i654 = ((~i652) & i653) | ((~i653) & i652);
                                int i655 = i654 ^ (i654 >>> 17);
                                int i656 = i655 << 5;
                                ((int[]) objArr2[1])[0] = (i655 | i656) & (~(i655 & i656));
                            } else {
                                i39 = i37;
                            }
                        }
                    } else {
                        int i4010 = -(Process.myPid() >> 22);
                        Object[] objArr810 = new Object[1];
                        a((char) ((i4010 & 15387) + (i4010 | 15387)), 371 - (~(-(Process.myPid() >> 22))), KeyEvent.keyCodeFromString(str6) + 23, objArr810);
                        String str310 = (String) objArr810[0];
                        char c110 = (char) (19553 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                        int i4011 = 617 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                        int i4012 = -(-ExpandableListView.getPackedPositionGroup(0L));
                        int i4013 = (i4012 ^ 10) + ((i4012 & 10) << 1);
                        Object[] objArr811 = new Object[1];
                        a(c110, i4011, i4013, objArr811);
                        String str410 = (String) objArr811[0];
                        char c111 = (char) (23046 - (~Color.green(0)));
                        int i4014 = 627 - (~TextUtils.indexOf((CharSequence) str6, '0', 0, 0));
                        int i4015 = -KeyEvent.keyCodeFromString(str6);
                        int i4110 = (i4015 & 7) + (i4015 | 7);
                        Object[] objArr812 = new Object[1];
                        a(c111, i4014, i4110, objArr812);
                        String str411 = (String) objArr812[0];
                        Object[] objArr813 = new Object[1];
                        a((char) Gravity.getAbsoluteGravity(0, 0), 633 - (~(-(KeyEvent.getMaxKeyCode() >> 16))), 7 - (~(-(-(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))))), objArr813);
                        char c112 = (char) ((-2) - ((-(-(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)))) ^ (-1)));
                        int iIndexOf13 = TextUtils.indexOf(str6, str6, 0, 0);
                        int i4111 = ((iIndexOf13 | 642) << 1) - (iIndexOf13 ^ 642);
                        int i4112 = -(ViewConfiguration.getPressedStateDuration() >> 16);
                        int i4113 = (i4112 ^ 17) + ((i4112 & 17) << 1);
                        Object[] objArr814 = new Object[1];
                        a(c112, i4111, i4113, objArr814);
                        String str412 = (String) objArr814[0];
                        char windowTouchSlop3 = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                        int i4114 = -(ViewConfiguration.getLongPressTimeout() >> 16);
                        int i4115 = (i4114 & 659) + (i4114 | 659);
                        int i4116 = -(-(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                        int i4117 = ((i4116 | 6) << 1) - (i4116 ^ 6);
                        Object[] objArr815 = new Object[1];
                        a(windowTouchSlop3, i4115, i4117, objArr815);
                        String str413 = (String) objArr815[0];
                        char cIndexOf6 = (char) TextUtils.indexOf(str6, str6, 0, 0);
                        int i4118 = -Color.red(0);
                        int iIPostMessageServiceStubProxy10 = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                        int i4119 = ~i4118;
                        int i4210 = ~iIPostMessageServiceStubProxy10;
                        int i4211 = ~(i4119 | i4210);
                        int i4212 = ~(((-667) ^ iIPostMessageServiceStubProxy10) | ((-667) & iIPostMessageServiceStubProxy10));
                        int i4213 = (((i4118 * (-574)) - 382284) - (~(((i4211 ^ i4212) | (i4211 & i4212)) * 1150))) - 1;
                        int i4214 = ~(((-667) ^ iIPostMessageServiceStubProxy10) | ((-667) & iIPostMessageServiceStubProxy10));
                        int i4215 = ~((i4210 & 666) | (i4210 ^ 666));
                        int i4216 = -(-(((i4215 & i4214) | (i4214 ^ i4215)) * (-575)));
                        int i4217 = (i4213 ^ i4216) + ((i4216 & i4213) << 1);
                        int i4218 = ~(i4119 | iIPostMessageServiceStubProxy10);
                        int i4219 = ~((i4118 & i4210) | (i4210 ^ i4118));
                        int i4310 = ((i4218 & i4219) | (i4218 ^ i4219)) * 575;
                        int i4311 = ((i4217 | i4310) << 1) - (i4310 ^ i4217);
                        int i4312 = -TextUtils.lastIndexOf(str6, '0', 0);
                        int i4313 = ((i4312 | 6) << 1) - (i4312 ^ 6);
                        Object[] objArr816 = new Object[1];
                        a(cIndexOf6, i4311, i4313, objArr816);
                        String str414 = (String) objArr816[0];
                        int i4314 = -(ViewConfiguration.getFadingEdgeLength() >> 16);
                        Object[] objArr817 = new Object[1];
                        a((char) ((i4314 & 32918) + (i4314 | 32918)), 672 - (~(-View.MeasureSpec.makeMeasureSpec(0, 0))), 10 - (~(-(ViewConfiguration.getKeyRepeatTimeout() >> 16))), objArr817);
                        String str415 = (String) objArr817[0];
                        char c113 = (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 4546);
                        int i4315 = -(-(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
                        int i4316 = ((i4315 | 683) << 1) - (i4315 ^ 683);
                        int longPressTimeout4 = ViewConfiguration.getLongPressTimeout() >> 16;
                        int i4317 = ((longPressTimeout4 | 14) << 1) - (longPressTimeout4 ^ 14);
                        Object[] objArr910 = new Object[1];
                        a(c113, i4316, i4317, objArr910);
                        char cIndexOf7 = (char) TextUtils.indexOf(str6, str6);
                        int i4318 = -(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                        int i4319 = (i4318 ^ 698) + ((i4318 & 698) << 1);
                        int i4410 = -(KeyEvent.getMaxKeyCode() >> 16);
                        int i4411 = (i4410 ^ 16) + ((i4410 & 16) << 1);
                        Object[] objArr911 = new Object[1];
                        a(cIndexOf7, i4319, i4411, objArr911);
                        String str416 = (String) objArr911[0];
                        int i4412 = -(-(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)));
                        Object[] objArr912 = new Object[1];
                        a((char) ((i4412 ^ 21512) + ((i4412 & 21512) << 1)), 714 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (ViewConfiguration.getScrollBarSize() >> 8) + 3, objArr912);
                        String str417 = (String) objArr912[0];
                        char cResolveSize4 = (char) (22992 - View.resolveSize(0, 0));
                        int offsetAfter3 = TextUtils.getOffsetAfter(str6, 0);
                        int i4413 = ((offsetAfter3 | 725) << 1) - (offsetAfter3 ^ 725);
                        int iMyTid3 = Process.myTid() >> 22;
                        int i4414 = (iMyTid3 ^ 22) + ((iMyTid3 & 22) << 1);
                        Object[] objArr913 = new Object[1];
                        a(cResolveSize4, i4413, i4414, objArr913);
                        String str418 = (String) objArr913[0];
                        Object[] objArr914 = new Object[1];
                        a((char) Color.argb(0, 0, 0, 0), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 747, 24 - (~(-(-(ViewConfiguration.getEdgeSlop() >> 16)))), objArr914);
                        String str419 = (String) objArr914[0];
                        char edgeSlop4 = (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 30699);
                        int i4415 = -(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                        int i4416 = (i4415 * (-317)) + 246587;
                        int i4417 = ~i4415;
                        int i4418 = (i4417 ^ (-774)) | (i4417 & (-774));
                        int i4419 = ~((i4418 & i) | (i4418 ^ i));
                        int i4510 = ~((i169 ^ i4415) | (i169 & i4415) | 773);
                        int i4511 = ((i4419 ^ i4510) | (i4419 & i4510)) * (-318);
                        int i4512 = ((i4416 | i4511) << 1) - (i4511 ^ i4416);
                        int i4513 = ~(((-774) & i4415) | ((-774) ^ i4415));
                        int i4514 = ~((i4415 & i) | (i4415 ^ i));
                        int i4515 = -(-(((i4514 & i4513) | (i4513 ^ i4514)) * (-318)));
                        int i4516 = (i4512 & i4515) + (i4515 | i4512);
                        int i4517 = ~(i4417 | i);
                        int i4518 = -(-(((i4517 & (-774)) | ((-774) ^ i4517)) * TypedValues.AttributesType.TYPE_PIVOT_TARGET));
                        Object[] objArr915 = new Object[1];
                        a(edgeSlop4, (i4516 & i4518) + (i4518 | i4516), 28 - (Process.myPid() >> 22), objArr915);
                        String str510 = (String) objArr915[0];
                        c2 = 6;
                        i31 = -1;
                        int i4519 = artificialFrame + 85;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i4519 % 128;
                        int i4610 = i4519 % 2;
                        int i4611 = -(-(ViewConfiguration.getKeyRepeatTimeout() >> 16));
                        int i4612 = -(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                        int iIPostMessageServiceStubProxy11 = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                        int i4613 = i4612 * 989;
                        int i4614 = (i4613 ^ (-789600)) + ((i4613 & (-789600)) << 1);
                        int i4615 = ~iIPostMessageServiceStubProxy11;
                        int i4616 = ~(((-801) ^ i4615) | (i4615 & (-801)) | i4612);
                        int i4617 = (i4612 & LogSeverity.EMERGENCY_VALUE) | (i4612 ^ LogSeverity.EMERGENCY_VALUE);
                        int i4618 = ~((i4617 & iIPostMessageServiceStubProxy11) | (i4617 ^ iIPostMessageServiceStubProxy11));
                        int i4619 = ((i4618 & i4616) | (i4616 ^ i4618)) * 988;
                        int i4710 = (((i4614 | i4619) << 1) - (i4619 ^ i4614)) + (((i4612 ^ (-801)) | (i4612 & (-801))) * (-988));
                        int i4711 = ~i4612;
                        int i4712 = ~((i4711 & (-801)) | (i4711 ^ (-801)));
                        int i4713 = ~(((-801) & iIPostMessageServiceStubProxy11) | ((-801) ^ iIPostMessageServiceStubProxy11));
                        int i4714 = (i4712 & i4713) | (i4712 ^ i4713);
                        int i4715 = ~iIPostMessageServiceStubProxy11;
                        int i4716 = ~((i4612 & i4715) | (i4715 ^ i4612) | LogSeverity.EMERGENCY_VALUE);
                        Object[] objArr916 = new Object[1];
                        a((char) ((i4611 & 11772) + (i4611 | 11772)), (i4710 - (~(((i4714 & i4716) | (i4714 ^ i4716)) * 988))) - 1, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 11, objArr916);
                        char maxKeyCode2 = (char) (KeyEvent.getMaxKeyCode() >> 16);
                        int i4717 = -View.MeasureSpec.getSize(0);
                        Object[] objArr917 = new Object[1];
                        a(maxKeyCode2, (i4717 ^ 811) + ((i4717 & 811) << 1), 7 - (~(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), objArr917);
                        int i4718 = -(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                        int i4719 = -(-View.resolveSizeAndState(0, 0, 0));
                        int i4810 = ((i4719 | 819) << 1) - (i4719 ^ 819);
                        int i4811 = -TextUtils.getCapsMode(str6, 0, 0);
                        int i4812 = (i4811 & 6) + (i4811 | 6);
                        Object[] objArr918 = new Object[1];
                        a((char) ((i4718 & 45437) + (i4718 | 45437)), i4810, i4812, objArr918);
                        char mirror5 = (char) (AndroidCharacter.getMirror('0') + 35699);
                        int i4813 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                        int i4814 = (i4813 & 824) + (i4813 | 824);
                        int i4815 = -(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                        int i4816 = ((i4815 | 6) << 1) - (i4815 ^ 6);
                        Object[] objArr919 = new Object[1];
                        a(mirror5, i4814, i4816, objArr919);
                        String[] strArr15 = {(String) objArr916[0], (String) objArr917[0], (String) objArr918[0], (String) objArr919[0]};
                        int i4817 = -(-Color.rgb(0, 0, 0));
                        int i4818 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                        int i4819 = -(-(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)));
                        int i4910 = (i4819 & 16) + (i4819 | 16);
                        Object[] objArr1010 = new Object[1];
                        a((char) ((i4817 ^ 16777216) + ((i4817 & 16777216) << 1)), (i4818 ^ 830) + ((i4818 & 830) << 1), i4910, objArr1010);
                        String str511 = (String) objArr1010[0];
                        int i4911 = -(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                        Object[] objArr1011 = new Object[1];
                        a((char) ((i4911 & 1) + (i4911 | 1)), ImageFormat.getBitsPerPixel(0) + 667, 8 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), objArr1011);
                        String str512 = (String) objArr1011[0];
                        Object[] objArr1012 = new Object[1];
                        a((char) Color.blue(0), 633 - (~(ViewConfiguration.getMinimumFlingVelocity() >> 16)), Color.rgb(0, 0, 0) + 16777224, objArr1012);
                        Object[] objArr1013 = new Object[1];
                        a((char) (28597 - TextUtils.lastIndexOf(str6, '0', 0)), View.combineMeasuredStates(0, 0) + 847, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 13, objArr1013);
                        String str513 = (String) objArr1013[0];
                        char scrollBarSize4 = (char) (9602 - (ViewConfiguration.getScrollBarSize() >> 8));
                        int i4912 = -(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                        int i4913 = (i4912 & 861) + (i4912 | 861);
                        int i4914 = -View.MeasureSpec.getSize(0);
                        int i4915 = (i4914 & 1) + (i4914 | 1);
                        Object[] objArr1014 = new Object[1];
                        a(scrollBarSize4, i4913, i4915, objArr1014);
                        char modifierMetaStateMask5 = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 53314);
                        int i4916 = -(-TextUtils.getOffsetAfter(str6, 0));
                        Object[] objArr1015 = new Object[1];
                        a(modifierMetaStateMask5, (i4916 & 862) + (i4916 | 862), 9 - KeyEvent.getDeadChar(0, 0), objArr1015);
                        String str514 = (String) objArr1015[0];
                        char c114 = (char) ((-2) - (~(-(-(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))))));
                        int i4917 = -AndroidCharacter.getMirror('0');
                        int size5 = View.MeasureSpec.getSize(0);
                        int i4918 = ((size5 | 1) << 1) - (size5 ^ 1);
                        Object[] objArr1016 = new Object[1];
                        a(c114, ((i4917 | 919) << 1) - (i4917 ^ 919), i4918, objArr1016);
                        char c210 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 29745);
                        int i4919 = -(-TextUtils.indexOf((CharSequence) str6, '0', 0, 0));
                        int i5010 = ((i4919 | 873) << 1) - (i4919 ^ 873);
                        int i5011 = -TextUtils.indexOf((CharSequence) str6, '0');
                        int i5012 = ((i5011 | 15) << 1) - (i5011 ^ 15);
                        Object[] objArr1017 = new Object[1];
                        a(c210, i5010, i5012, objArr1017);
                        String str515 = (String) objArr1017[0];
                        char c211 = (char) (21511 - (~ExpandableListView.getPackedPositionType(0L)));
                        int longPressTimeout5 = ViewConfiguration.getLongPressTimeout() >> 16;
                        int i5013 = (longPressTimeout5 & 714) + (longPressTimeout5 | 714);
                        int i5014 = -(Process.myPid() >> 22);
                        int i5015 = (i5014 ^ 3) + ((i5014 & 3) << 1);
                        Object[] objArr1018 = new Object[1];
                        a(c211, i5013, i5015, objArr1018);
                        String str516 = (String) objArr1018[0];
                        char maximumDrawingCacheSize4 = (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                        int i5016 = -(-TextUtils.indexOf((CharSequence) str6, '0', 0, 0));
                        int i5017 = ((i5016 | 660) << 1) - (i5016 ^ 660);
                        int i5018 = -View.getDefaultSize(0, 0);
                        int i5019 = (i5018 & 7) + (i5018 | 7);
                        Object[] objArr1019 = new Object[1];
                        a(maximumDrawingCacheSize4, i5017, i5019, objArr1019);
                        String str517 = (String) objArr1019[0];
                        int i5110 = -View.resolveSize(0, 0);
                        int i5111 = -(-ExpandableListView.getPackedPositionType(0L));
                        Object[] objArr1110 = new Object[1];
                        a((char) ((i5110 ^ 30213) + ((i5110 & 30213) << 1)), (i5111 ^ com.salesforce.marketingcloud.analytics.b.q) + ((i5111 & com.salesforce.marketingcloud.analytics.b.q) << 1), TextUtils.getCapsMode(str6, 0, 0) + 8, objArr1110);
                        String str518 = (String) objArr1110[0];
                        int i5112 = -MotionEvent.axisFromString(str6);
                        int i5113 = 671 - (~(-(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))));
                        int doubleTapTimeout4 = ViewConfiguration.getDoubleTapTimeout() >> 16;
                        int i5114 = (doubleTapTimeout4 ^ 11) + ((doubleTapTimeout4 & 11) << 1);
                        Object[] objArr1111 = new Object[1];
                        a((char) ((i5112 ^ 32917) + ((i5112 & 32917) << 1)), i5113, i5114, objArr1111);
                        String str519 = (String) objArr1111[0];
                        int i5115 = -View.resolveSizeAndState(0, 0, 0);
                        int i5116 = 683 - (~(-(-(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))));
                        int edgeSlop5 = ViewConfiguration.getEdgeSlop() >> 16;
                        Object[] objArr1112 = new Object[1];
                        a((char) (((i5115 | 4547) << 1) - (i5115 ^ 4547)), i5116, (edgeSlop5 & 14) + (edgeSlop5 | 14), objArr1112);
                        char modifierMetaStateMask6 = (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask()));
                        int i5117 = -TextUtils.indexOf((CharSequence) str6, '0', 0, 0);
                        int i5118 = (i5117 & 895) + (i5117 | 895);
                        int longPressTimeout6 = ViewConfiguration.getLongPressTimeout() >> 16;
                        int i5119 = ((longPressTimeout6 | 20) << 1) - (longPressTimeout6 ^ 20);
                        Object[] objArr1113 = new Object[1];
                        a(modifierMetaStateMask6, i5118, i5119, objArr1113);
                        String str610 = (String) objArr1113[0];
                        char offsetAfter4 = (char) TextUtils.getOffsetAfter(str6, 0);
                        int threadPriority5 = Process.getThreadPriority(0);
                        int i5210 = -(-(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                        int i5211 = (i5210 ^ 20) + ((i5210 & 20) << 1);
                        Object[] objArr1114 = new Object[1];
                        a(offsetAfter4, (((threadPriority5 & 20) + (threadPriority5 | 20)) >> 6) + 916, i5211, objArr1114);
                        String str611 = (String) objArr1114[0];
                        char c212 = (char) (21822 - (~(-(-Gravity.getAbsoluteGravity(0, 0)))));
                        int iIndexOf14 = TextUtils.indexOf(str6, str6, 0, 0);
                        int iIPostMessageServiceStubProxy12 = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                        int i5212 = ~iIndexOf14;
                        int i5213 = ~iIPostMessageServiceStubProxy12;
                        int i5214 = ~((i5213 & i5212) | (i5212 ^ i5213));
                        int i5215 = ~((-936) | iIPostMessageServiceStubProxy12);
                        int i5216 = (((iIndexOf14 * (-574)) - 536690) - (~(((i5214 ^ i5215) | (i5214 & i5215)) * 1150))) - 1;
                        int i5217 = ~(((-936) & iIPostMessageServiceStubProxy12) | ((-936) ^ iIPostMessageServiceStubProxy12));
                        int i5218 = ~iIPostMessageServiceStubProxy12;
                        int i5219 = ~((i5218 ^ 935) | (i5218 & 935));
                        int i5310 = i5216 + (((i5219 & i5217) | (i5217 ^ i5219)) * (-575));
                        int i5311 = ((~((iIPostMessageServiceStubProxy12 & i5212) | (i5212 ^ iIPostMessageServiceStubProxy12))) | (~((i5218 ^ iIndexOf14) | (iIndexOf14 & i5218)))) * 575;
                        int i5312 = (i5310 & i5311) + (i5311 | i5310);
                        int iAxisFromString2 = MotionEvent.axisFromString(str6);
                        int i5313 = (iAxisFromString2 ^ 32) + ((iAxisFromString2 & 32) << 1);
                        Object[] objArr1115 = new Object[1];
                        a(c212, i5312, i5313, objArr1115);
                        String str612 = (String) objArr1115[0];
                        int i5314 = -Process.getGidForName(str6);
                        int i5315 = -KeyEvent.normalizeMetaState(0);
                        int i5316 = ((i5315 | 966) << 1) - (i5315 ^ 966);
                        int i5317 = -(ViewConfiguration.getScrollDefaultDelay() >> 16);
                        int i5318 = ((i5317 | 26) << 1) - (i5317 ^ 26);
                        Object[] objArr1116 = new Object[1];
                        a((char) ((i5314 ^ 29772) + ((i5314 & 29772) << 1)), i5316, i5318, objArr1116);
                        String str613 = (String) objArr1116[0];
                        char c213 = (char) (9581 - (~(-(ViewConfiguration.getPressedStateDuration() >> 16))));
                        int i5319 = -TextUtils.indexOf((CharSequence) str6, '0', 0, 0);
                        int i5410 = (i5319 ^ 991) + ((i5319 & 991) << 1);
                        int i5411 = -(ViewConfiguration.getScrollBarFadeDuration() >> 16);
                        int i5412 = ((i5411 | 23) << 1) - (i5411 ^ 23);
                        Object[] objArr1117 = new Object[1];
                        a(c213, i5410, i5412, objArr1117);
                        String str614 = (String) objArr1117[0];
                        int i5413 = -Color.rgb(0, 0, 0);
                        Object[] objArr1118 = new Object[1];
                        a((char) ((i5413 ^ (-16767899)) + ((i5413 & (-16767899)) << 1)), 1014 - (~(-(-View.MeasureSpec.getSize(0)))), 31 - (~(-TextUtils.lastIndexOf(str6, '0'))), objArr1118);
                        String str615 = (String) objArr1118[0];
                        str8 = str6;
                        char cResolveSizeAndState3 = (char) View.resolveSizeAndState(0, 0, 0);
                        int touchSlop5 = ViewConfiguration.getTouchSlop() >> 8;
                        int i5414 = (touchSlop5 ^ 1048) + ((touchSlop5 & 1048) << 1);
                        int i5415 = -(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                        int i5416 = (i5415 & 13) + (i5415 | 13);
                        Object[] objArr1119 = new Object[1];
                        a(cResolveSizeAndState3, i5414, i5416, objArr1119);
                        String str616 = (String) objArr1119[0];
                        int absoluteGravity4 = Gravity.getAbsoluteGravity(0, 0);
                        char c214 = (char) ((absoluteGravity4 & 23047) + (absoluteGravity4 | 23047));
                        int keyRepeatDelay9 = 627 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                        int i5417 = -(ViewConfiguration.getLongPressTimeout() >> 16);
                        int i5418 = (i5417 ^ 7) + ((i5417 & 7) << 1);
                        Object[] objArr1210 = new Object[1];
                        a(c214, keyRepeatDelay9, i5418, objArr1210);
                        int packedPositionChild3 = ExpandableListView.getPackedPositionChild(0L);
                        int scrollDefaultDelay2 = 1061 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                        int i5419 = -KeyEvent.normalizeMetaState(0);
                        int i5510 = ((i5419 | 30) << 1) - (i5419 ^ 30);
                        Object[] objArr1211 = new Object[1];
                        a((char) (((packedPositionChild3 | 1) << 1) - (packedPositionChild3 ^ 1)), scrollDefaultDelay2, i5510, objArr1211);
                        String str617 = (String) objArr1211[0];
                        int i5511 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                        int i5512 = (i5511 * 866) - 5501952;
                        int i5513 = ~i5511;
                        int i5514 = -(-(((~((i5513 & i169) | (i5513 ^ i169))) | (-6369)) * (-865)));
                        int i5515 = (((i5512 & i5514) + (i5512 | i5514)) - (~((~((i5511 ^ i) | (i5511 & i))) * 865))) - 1;
                        int i5516 = ~(((-6369) ^ i169) | ((-6369) & i169));
                        int i5517 = ~((i5511 & i169) | (i169 ^ i5511));
                        int i5518 = ((i5517 & i5516) | (i5516 ^ i5517)) * 865;
                        char c215 = (char) ((i5515 ^ i5518) + ((i5518 & i5515) << 1));
                        int i5519 = -(-View.MeasureSpec.getSize(0));
                        int i5610 = (i5519 ^ 1091) + ((i5519 & 1091) << 1);
                        int iIndexOf15 = TextUtils.indexOf((CharSequence) str8, '0', 0);
                        int iIPostMessageServiceStubProxy13 = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                        int i5611 = (iIndexOf15 * (-380)) + 4584;
                        int i5612 = ~iIndexOf15;
                        int i5613 = -(-((iIPostMessageServiceStubProxy13 | 12 | i5612) * (-381)));
                        int i5614 = (i5611 & i5613) + (i5611 | i5613);
                        int i5615 = ~((~iIndexOf15) | (-13));
                        int i5616 = ~iIPostMessageServiceStubProxy13;
                        int i5617 = (~((i5616 & 12) | (i5616 ^ 12))) | i5615;
                        int i5618 = ~((iIndexOf15 ^ 12) | (iIndexOf15 & 12));
                        int i5619 = (i5614 - (~(((i5617 & i5618) | (i5617 ^ i5618)) * 381))) - 1;
                        int i5710 = (~(i5612 | 12)) * 381;
                        int i5711 = ((i5619 | i5710) << 1) - (i5710 ^ i5619);
                        Object[] objArr1212 = new Object[1];
                        a(c215, i5610, i5711, objArr1212);
                        int iIndexOf16 = TextUtils.indexOf((CharSequence) str8, '0', 0);
                        int i5712 = -(ViewConfiguration.getScrollBarFadeDuration() >> 16);
                        Object[] objArr1213 = new Object[1];
                        a((char) (((iIndexOf16 | 26730) << 1) - (iIndexOf16 ^ 26730)), (i5712 ^ 1102) + ((i5712 & 1102) << 1), 18 - (~(-(-TextUtils.indexOf(str8, str8, 0, 0)))), objArr1213);
                        String str618 = (String) objArr1213[0];
                        char c216 = (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                        int i5713 = -KeyEvent.normalizeMetaState(0);
                        int i5714 = ((i5713 | 1121) << 1) - (i5713 ^ 1121);
                        int scrollBarSize5 = ViewConfiguration.getScrollBarSize() >> 8;
                        int i5715 = (scrollBarSize5 ^ 5) + ((scrollBarSize5 & 5) << 1);
                        Object[] objArr1214 = new Object[1];
                        a(c216, i5714, i5715, objArr1214);
                        char keyRepeatTimeout10 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                        int i5716 = (-16776091) - (~(-Color.rgb(0, 0, 0)));
                        int iResolveSize3 = View.resolveSize(0, 0);
                        int i5717 = ((iResolveSize3 | 19) << 1) - (iResolveSize3 ^ 19);
                        Object[] objArr1215 = new Object[1];
                        a(keyRepeatTimeout10, i5716, i5717, objArr1215);
                        char cIndexOf8 = (char) TextUtils.indexOf(str8, str8, 0, 0);
                        int iGreen4 = Color.green(0);
                        int i5718 = ((iGreen4 | 1145) << 1) - (iGreen4 ^ 1145);
                        int i5719 = -(-AndroidCharacter.getMirror('0'));
                        int i5810 = (i5719 ^ (-32)) + ((i5719 & (-32)) << 1);
                        Object[] objArr1216 = new Object[1];
                        a(cIndexOf8, i5718, i5810, objArr1216);
                        int i5811 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                        Object[] objArr1217 = new Object[1];
                        a((char) (((i5811 | 43328) << 1) - (i5811 ^ 43328)), 1160 - (~(-(-View.resolveSize(0, 0)))), 18 - (~(ViewConfiguration.getLongPressTimeout() >> 16)), objArr1217);
                        int i5812 = -(Process.myPid() >> 22);
                        int i5813 = -(-ExpandableListView.getPackedPositionType(0L));
                        int i5814 = (i5813 & 1180) + (i5813 | 1180);
                        int i5815 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                        int i5816 = i5815 * (-1975);
                        int i5817 = (i5816 & 18791) + (i5816 | 18791);
                        int i5818 = ~i5815;
                        int i5819 = ~(i5818 | 19);
                        int i5910 = i5817 + (((i5819 & i) | (i ^ i5819)) * 988);
                        int i5911 = ~((-20) | i5815);
                        int i5912 = ~(i5815 | i169);
                        int i5913 = -(-(((i5912 & i5911) | (i5911 ^ i5912)) * (-1976)));
                        int i5914 = (i5910 ^ i5913) + ((i5913 & i5910) << 1);
                        int i5915 = ~((i5818 & 19) | (i5818 ^ 19));
                        int i5916 = ~(((-20) & i) | ((-20) ^ i));
                        int i5917 = (i5915 & i5916) | (i5915 ^ i5916);
                        int i5918 = ~((i169 ^ 19) | (i169 & 19));
                        int i5919 = -(-(((i5917 & i5918) | (i5917 ^ i5918)) * 988));
                        int i6010 = (i5914 & i5919) + (i5919 | i5914);
                        Object[] objArr1218 = new Object[1];
                        a((char) (((i5812 | 31256) << 1) - (i5812 ^ 31256)), i5814, i6010, objArr1218);
                        int i6011 = -(-TextUtils.indexOf((CharSequence) str8, '0', 0, 0));
                        int i6012 = -AndroidCharacter.getMirror('0');
                        Object[] objArr1219 = new Object[1];
                        a((char) ((i6011 & 61337) + (i6011 | 61337)), ((i6012 | 1247) << 1) - (i6012 ^ 1247), 23 - (KeyEvent.getMaxKeyCode() >> 16), objArr1219);
                        int i6013 = -(ViewConfiguration.getDoubleTapTimeout() >> 16);
                        int i6014 = -(-(i6013 * (-963)));
                        int i6015 = (i6014 & (-964)) + (i6014 | (-964)) + 43534045;
                        int i6016 = ~i6013;
                        int i6017 = ~(((-45114) ^ i) | ((-45114) & i));
                        int i6018 = i6015 + (((i6016 & i6017) | (i6016 ^ i6017)) * (-964));
                        int i6019 = -(-(((~(i6013 | (-45114))) | (~(((-45114) ^ i169) | ((-45114) & i169)))) * (-964)));
                        char c217 = (char) ((i6018 & i6019) + (i6019 | i6018));
                        int i6110 = -View.resolveSize(0, 0);
                        int i6111 = (i6110 ^ 1222) + ((i6110 & 1222) << 1);
                        int i6112 = -(-(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                        int i6113 = (i6112 & 20) + (i6112 | 20);
                        Object[] objArr1313 = new Object[1];
                        a(c217, i6111, i6113, objArr1313);
                        int i6114 = -(-(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                        int i6115 = -Color.rgb(0, 0, 0);
                        int i6116 = ((i6115 | (-16775973)) << 1) - (i6115 ^ (-16775973));
                        int i6117 = -ExpandableListView.getPackedPositionType(0L);
                        int i6118 = (i6117 & 24) + (i6117 | 24);
                        Object[] objArr1314 = new Object[1];
                        a((char) (((i6114 | 26190) << 1) - (i6114 ^ 26190)), i6116, i6118, objArr1314);
                        String str619 = str;
                        char c218 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                        int i6119 = -View.MeasureSpec.getSize(0);
                        Object[] objArr1315 = new Object[1];
                        a(c218, ((i6119 | 1267) << 1) - (i6119 ^ 1267), View.getDefaultSize(0, 0) + 28, objArr1315);
                        char c219 = (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                        int i6211 = -Color.rgb(0, 0, 0);
                        Object[] objArr1316 = new Object[1];
                        a(c219, (i6211 ^ (-16775921)) + ((i6211 & (-16775921)) << 1), 26 - (~(-(-(Process.myPid() >> 22)))), objArr1316);
                        char c31 = (char) (29032 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                        int i6212 = 1321 - (~ExpandableListView.getPackedPositionGroup(0L));
                        int i6213 = -Color.blue(0);
                        int i6214 = (i6213 & 31) + (i6213 | 31);
                        Object[] objArr1317 = new Object[1];
                        a(c31, i6212, i6214, objArr1317);
                        char defaultSize3 = (char) (14167 - View.getDefaultSize(0, 0));
                        int i6215 = 1352 - (~(ViewConfiguration.getMinimumFlingVelocity() >> 16));
                        int size6 = View.MeasureSpec.getSize(0);
                        int i6216 = ((size6 | 27) << 1) - (size6 ^ 27);
                        Object[] objArr1318 = new Object[1];
                        a(defaultSize3, i6215, i6216, objArr1318);
                        int i6217 = -KeyEvent.normalizeMetaState(0);
                        int maximumDrawingCacheSize5 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 1380;
                        int scrollBarSize6 = ViewConfiguration.getScrollBarSize() >> 8;
                        int i6218 = (scrollBarSize6 ^ 32) + ((scrollBarSize6 & 32) << 1);
                        Object[] objArr1319 = new Object[1];
                        a((char) (((i6217 | 35676) << 1) - (i6217 ^ 35676)), maximumDrawingCacheSize5, i6218, objArr1319);
                        strArr3 = new String[][]{new String[]{str310, str410, str411, (String) objArr813[0]}, new String[]{str412, str413, str414, str415, (String) objArr910[0]}, new String[]{str416, str417, str, str418, str419, str510}, strArr15, new String[]{str511, str512, (String) objArr1012[0]}, new String[]{str513, (String) objArr1014[0]}, new String[]{str514, (String) objArr1016[0]}, new String[]{str515, str516, str517, str518, str519, (String) objArr1112[0]}, new String[]{str610, str611, str612, str613, str614, str615, str}, new String[]{str616, (String) objArr1210[0]}, new String[]{str617, (String) objArr1212[0]}, new String[]{str618, (String) objArr1214[0]}, new String[]{(String) objArr1215[0]}, new String[]{(String) objArr1216[0]}, new String[]{(String) objArr1217[0]}, new String[]{(String) objArr1218[0]}, new String[]{(String) objArr1219[0]}, new String[]{(String) objArr1313[0]}, new String[]{(String) objArr1314[0], str619}, new String[]{(String) objArr1315[0], str619}, new String[]{(String) objArr1316[0], str619}, new String[]{(String) objArr1317[0], str619}, new String[]{(String) objArr1318[0], str619}, new String[]{(String) objArr1319[0], str619}};
                        arrayList = new ArrayList();
                        i32 = i;
                        i33 = 0;
                        i34 = 0;
                        while (i33 < 24) {
                            int i6219 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                            i40 = (i6219 & 73) + (i6219 | 73);
                            artificialFrame = i40 % 128;
                            if (i40 % 2 == 0) {
                                strArr4 = strArr3[i33];
                                Object[] objArr1320 = {strArr4[1]};
                                objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                                if (objAccessartificialFrame11 == null) {
                                    int minimumFlingVelocity4 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 23;
                                    char mirror6 = (char) (AndroidCharacter.getMirror('0') - '0');
                                    int minimumFlingVelocity5 = 2441 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                                    byte[] bArr110 = $$a;
                                    Object[] objArr1321 = new Object[1];
                                    b((byte) 49, bArr110[16], bArr110[10], objArr1321);
                                    objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity4, mirror6, minimumFlingVelocity5, 954751276, false, (String) objArr1321[0], new Class[]{String.class});
                                }
                                str10 = (String) ((Method) objAccessartificialFrame11).invoke(null, objArr1320);
                                strArr5 = (String[]) Arrays.copyOfRange(strArr4, 1, strArr4.length);
                                if (str10 != null) {
                                    i41 = artificialFrame + 27;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i41 % 128;
                                    if (i41 % 2 != 0) {
                                        int i62110 = 23 / 0;
                                        if (str10.length() != 0) {
                                            if (strArr4.length != 1) {
                                                Object[] objArr13110 = {str10, strArr5};
                                                objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(311378445);
                                                if (objAccessartificialFrame10 == null) {
                                                    int keyRepeatDelay10 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 29;
                                                    char keyRepeatTimeout11 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                                                    int i63110 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + FrameMetricsAggregator.EVERY_DURATION;
                                                    byte b12 = $$a[16];
                                                    byte b13 = b12;
                                                    Object[] objArr1410 = new Object[1];
                                                    b(b13, (byte) (b13 | 7), b12, objArr1410);
                                                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay10, keyRepeatTimeout11, i63110, -1914043387, false, (String) objArr1410[0], new Class[]{String.class, String[].class});
                                                }
                                                long jLongValue16 = ((Long) ((Method) objAccessartificialFrame10).invoke(null, objArr13110)).longValue();
                                                long j7112 = -1961190699;
                                                strArr6 = strArr3;
                                                long j7113 = -406;
                                                long j7114 = jLongValue16 ^ j20;
                                                i42 = i33;
                                                long jUptimeMillis5 = (int) SystemClock.uptimeMillis();
                                                long j7115 = jUptimeMillis5 ^ j20;
                                                long j84 = (((long) (-405)) * j7112) + (((long) 407) * jLongValue16) + ((((j7114 | jUptimeMillis5) ^ j20) | (((j7115 | j7112) | jLongValue16) ^ j20)) * j7113) + (j7113 * (((j7114 | j7115) | j7112) ^ j20)) + (((long) 406) * (((jUptimeMillis5 | (j7112 ^ j20)) ^ j20) | ((j7115 | jLongValue16) ^ j20))) + ((long) 1986464153);
                                                i43 = ((int) (j84 >> 32)) & (785016995 + (((~(132250616 | i)) | 1304975794) * 191) + (((~(132250616 | i169)) | 1208483842) * 191));
                                                int elapsedCpuTime10 = (int) Process.getElapsedCpuTime();
                                                i44 = ((int) j84) & (922154449 + (((~(1909484194 | elapsedCpuTime10)) | (-948256692)) * (-668)) + ((1909484194 | (~((-948256692) | elapsedCpuTime10))) * 1336) + ((elapsedCpuTime10 | (-134550802)) * 668));
                                                if (((i43 & i44) | (i43 ^ i44)) != 0) {
                                                }
                                            } else {
                                                strArr6 = strArr3;
                                                i42 = i33;
                                            }
                                            int i63111 = ((i34 | 1) << 1) - (i34 ^ 1);
                                            int i63112 = ((i42 | 10) << 1) - (i42 ^ 10);
                                            int i63113 = (i63112 & i169) | ((~i63112) & i);
                                            StringBuilder sb5 = new StringBuilder();
                                            sb5.append(str10);
                                            char deadChar9 = (char) KeyEvent.getDeadChar(0, 0);
                                            int i63114 = -(-(ViewConfiguration.getEdgeSlop() >> 16));
                                            Object[] objArr1411 = new Object[1];
                                            a(deadChar9, (i63114 & 1412) + (i63114 | 1412), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), objArr1411);
                                            sb5.append((String) objArr1411[0]);
                                            sb5.append(str10);
                                            arrayList.add(sb5.toString());
                                            i34 = i63111;
                                            i32 = i63113;
                                        }
                                        i32 = i32;
                                    } else {
                                        if (str10.length() != 0) {
                                            if (strArr4.length != 1) {
                                                Object[] objArr13111 = {str10, strArr5};
                                                objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(311378445);
                                                if (objAccessartificialFrame10 == null) {
                                                    int keyRepeatDelay11 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 29;
                                                    char keyRepeatTimeout12 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                                                    int i63115 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + FrameMetricsAggregator.EVERY_DURATION;
                                                    byte b14 = $$a[16];
                                                    byte b15 = b14;
                                                    Object[] objArr1412 = new Object[1];
                                                    b(b15, (byte) (b15 | 7), b14, objArr1412);
                                                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay11, keyRepeatTimeout12, i63115, -1914043387, false, (String) objArr1412[0], new Class[]{String.class, String[].class});
                                                }
                                                long jLongValue17 = ((Long) ((Method) objAccessartificialFrame10).invoke(null, objArr13111)).longValue();
                                                long j7116 = -1961190699;
                                                strArr6 = strArr3;
                                                long j7117 = -406;
                                                long j7118 = jLongValue17 ^ j20;
                                                i42 = i33;
                                                long jUptimeMillis6 = (int) SystemClock.uptimeMillis();
                                                long j7119 = jUptimeMillis6 ^ j20;
                                                long j85 = (((long) (-405)) * j7116) + (((long) 407) * jLongValue17) + ((((j7118 | jUptimeMillis6) ^ j20) | (((j7119 | j7116) | jLongValue17) ^ j20)) * j7117) + (j7117 * (((j7118 | j7119) | j7116) ^ j20)) + (((long) 406) * (((jUptimeMillis6 | (j7116 ^ j20)) ^ j20) | ((j7119 | jLongValue17) ^ j20))) + ((long) 1986464153);
                                                i43 = ((int) (j85 >> 32)) & (785016995 + (((~(132250616 | i)) | 1304975794) * 191) + (((~(132250616 | i169)) | 1208483842) * 191));
                                                int elapsedCpuTime11 = (int) Process.getElapsedCpuTime();
                                                i44 = ((int) j85) & (922154449 + (((~(1909484194 | elapsedCpuTime11)) | (-948256692)) * (-668)) + ((1909484194 | (~((-948256692) | elapsedCpuTime11))) * 1336) + ((elapsedCpuTime11 | (-134550802)) * 668));
                                                if (((i43 & i44) | (i43 ^ i44)) != 0) {
                                                }
                                            } else {
                                                strArr6 = strArr3;
                                                i42 = i33;
                                            }
                                            int i63116 = ((i34 | 1) << 1) - (i34 ^ 1);
                                            int i63117 = ((i42 | 10) << 1) - (i42 ^ 10);
                                            int i63118 = (i63117 & i169) | ((~i63117) & i);
                                            StringBuilder sb6 = new StringBuilder();
                                            sb6.append(str10);
                                            char deadChar10 = (char) KeyEvent.getDeadChar(0, 0);
                                            int i63119 = -(-(ViewConfiguration.getEdgeSlop() >> 16));
                                            Object[] objArr1413 = new Object[1];
                                            a(deadChar10, (i63119 & 1412) + (i63119 | 1412), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), objArr1413);
                                            sb6.append((String) objArr1413[0]);
                                            sb6.append(str10);
                                            arrayList.add(sb6.toString());
                                            i34 = i63116;
                                            i32 = i63118;
                                        }
                                        i32 = i32;
                                    }
                                }
                                i33 = i42 + 1;
                                str8 = str8;
                                strArr3 = strArr6;
                            } else {
                                str8 = str8;
                                i32 = i32;
                                strArr4 = strArr3[i33];
                                Object[] objArr1414 = {strArr4[0]};
                                objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                                if (objAccessartificialFrame9 == null) {
                                    int i6410 = 23 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                                    char packedPositionChild4 = (char) ((-1) - ExpandableListView.getPackedPositionChild(0L));
                                    int touchSlop6 = 2441 - (ViewConfiguration.getTouchSlop() >> 8);
                                    byte[] bArr111 = $$a;
                                    Object[] objArr1415 = new Object[1];
                                    b((byte) 49, bArr111[16], bArr111[10], objArr1415);
                                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(i6410, packedPositionChild4, touchSlop6, 954751276, false, (String) objArr1415[0], new Class[]{String.class});
                                }
                                str10 = (String) ((Method) objAccessartificialFrame9).invoke(null, objArr1414);
                                strArr5 = (String[]) Arrays.copyOfRange(strArr4, 1, strArr4.length);
                                if (str10 != null) {
                                    i41 = artificialFrame + 27;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i41 % 128;
                                    if (i41 % 2 != 0) {
                                        int i62111 = 23 / 0;
                                        if (str10.length() != 0) {
                                            if (strArr4.length != 1) {
                                                Object[] objArr13112 = {str10, strArr5};
                                                objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(311378445);
                                                if (objAccessartificialFrame10 == null) {
                                                    int keyRepeatDelay12 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 29;
                                                    char keyRepeatTimeout13 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                                                    int i631110 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + FrameMetricsAggregator.EVERY_DURATION;
                                                    byte b16 = $$a[16];
                                                    byte b17 = b16;
                                                    Object[] objArr1416 = new Object[1];
                                                    b(b17, (byte) (b17 | 7), b16, objArr1416);
                                                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay12, keyRepeatTimeout13, i631110, -1914043387, false, (String) objArr1416[0], new Class[]{String.class, String[].class});
                                                }
                                                long jLongValue18 = ((Long) ((Method) objAccessartificialFrame10).invoke(null, objArr13112)).longValue();
                                                long j71110 = -1961190699;
                                                strArr6 = strArr3;
                                                long j71111 = -406;
                                                long j71112 = jLongValue18 ^ j20;
                                                i42 = i33;
                                                long jUptimeMillis7 = (int) SystemClock.uptimeMillis();
                                                long j71113 = jUptimeMillis7 ^ j20;
                                                long j86 = (((long) (-405)) * j71110) + (((long) 407) * jLongValue18) + ((((j71112 | jUptimeMillis7) ^ j20) | (((j71113 | j71110) | jLongValue18) ^ j20)) * j71111) + (j71111 * (((j71112 | j71113) | j71110) ^ j20)) + (((long) 406) * (((jUptimeMillis7 | (j71110 ^ j20)) ^ j20) | ((j71113 | jLongValue18) ^ j20))) + ((long) 1986464153);
                                                i43 = ((int) (j86 >> 32)) & (785016995 + (((~(132250616 | i)) | 1304975794) * 191) + (((~(132250616 | i169)) | 1208483842) * 191));
                                                int elapsedCpuTime12 = (int) Process.getElapsedCpuTime();
                                                i44 = ((int) j86) & (922154449 + (((~(1909484194 | elapsedCpuTime12)) | (-948256692)) * (-668)) + ((1909484194 | (~((-948256692) | elapsedCpuTime12))) * 1336) + ((elapsedCpuTime12 | (-134550802)) * 668));
                                                if (((i43 & i44) | (i43 ^ i44)) != 0) {
                                                }
                                            } else {
                                                strArr6 = strArr3;
                                                i42 = i33;
                                            }
                                            int i631111 = ((i34 | 1) << 1) - (i34 ^ 1);
                                            int i631112 = ((i42 | 10) << 1) - (i42 ^ 10);
                                            int i631113 = (i631112 & i169) | ((~i631112) & i);
                                            StringBuilder sb7 = new StringBuilder();
                                            sb7.append(str10);
                                            char deadChar11 = (char) KeyEvent.getDeadChar(0, 0);
                                            int i631114 = -(-(ViewConfiguration.getEdgeSlop() >> 16));
                                            Object[] objArr1417 = new Object[1];
                                            a(deadChar11, (i631114 & 1412) + (i631114 | 1412), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), objArr1417);
                                            sb7.append((String) objArr1417[0]);
                                            sb7.append(str10);
                                            arrayList.add(sb7.toString());
                                            i34 = i631111;
                                            i32 = i631113;
                                        }
                                        i32 = i32;
                                    } else {
                                        if (str10.length() != 0) {
                                            if (strArr4.length != 1) {
                                                Object[] objArr13113 = {str10, strArr5};
                                                objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(311378445);
                                                if (objAccessartificialFrame10 == null) {
                                                    int keyRepeatDelay13 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 29;
                                                    char keyRepeatTimeout14 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                                                    int i631115 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + FrameMetricsAggregator.EVERY_DURATION;
                                                    byte b18 = $$a[16];
                                                    byte b19 = b18;
                                                    Object[] objArr1418 = new Object[1];
                                                    b(b19, (byte) (b19 | 7), b18, objArr1418);
                                                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay13, keyRepeatTimeout14, i631115, -1914043387, false, (String) objArr1418[0], new Class[]{String.class, String[].class});
                                                }
                                                long jLongValue19 = ((Long) ((Method) objAccessartificialFrame10).invoke(null, objArr13113)).longValue();
                                                long j71114 = -1961190699;
                                                strArr6 = strArr3;
                                                long j71115 = -406;
                                                long j71116 = jLongValue19 ^ j20;
                                                i42 = i33;
                                                long jUptimeMillis8 = (int) SystemClock.uptimeMillis();
                                                long j71117 = jUptimeMillis8 ^ j20;
                                                long j87 = (((long) (-405)) * j71114) + (((long) 407) * jLongValue19) + ((((j71116 | jUptimeMillis8) ^ j20) | (((j71117 | j71114) | jLongValue19) ^ j20)) * j71115) + (j71115 * (((j71116 | j71117) | j71114) ^ j20)) + (((long) 406) * (((jUptimeMillis8 | (j71114 ^ j20)) ^ j20) | ((j71117 | jLongValue19) ^ j20))) + ((long) 1986464153);
                                                i43 = ((int) (j87 >> 32)) & (785016995 + (((~(132250616 | i)) | 1304975794) * 191) + (((~(132250616 | i169)) | 1208483842) * 191));
                                                int elapsedCpuTime13 = (int) Process.getElapsedCpuTime();
                                                i44 = ((int) j87) & (922154449 + (((~(1909484194 | elapsedCpuTime13)) | (-948256692)) * (-668)) + ((1909484194 | (~((-948256692) | elapsedCpuTime13))) * 1336) + ((elapsedCpuTime13 | (-134550802)) * 668));
                                                if (((i43 & i44) | (i43 ^ i44)) != 0) {
                                                }
                                            } else {
                                                strArr6 = strArr3;
                                                i42 = i33;
                                            }
                                            int i631116 = ((i34 | 1) << 1) - (i34 ^ 1);
                                            int i631117 = ((i42 | 10) << 1) - (i42 ^ 10);
                                            int i631118 = (i631117 & i169) | ((~i631117) & i);
                                            StringBuilder sb8 = new StringBuilder();
                                            sb8.append(str10);
                                            char deadChar12 = (char) KeyEvent.getDeadChar(0, 0);
                                            int i631119 = -(-(ViewConfiguration.getEdgeSlop() >> 16));
                                            Object[] objArr1419 = new Object[1];
                                            a(deadChar12, (i631119 & 1412) + (i631119 | 1412), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), objArr1419);
                                            sb8.append((String) objArr1419[0]);
                                            sb8.append(str10);
                                            arrayList.add(sb8.toString());
                                            i34 = i631116;
                                            i32 = i631118;
                                        }
                                        i32 = i32;
                                    }
                                }
                                i33 = i42 + 1;
                                str8 = str8;
                                strArr3 = strArr6;
                            }
                            strArr6 = strArr3;
                            i42 = i33;
                            i32 = i32;
                            i33 = i42 + 1;
                            str8 = str8;
                            strArr3 = strArr6;
                        }
                        str9 = str8;
                        i35 = i32;
                        if (i34 > 2) {
                            objArr = new Object[]{arrayList, new int[]{(i644 | i645) & (~(i644 & i645))}, null, new int[]{i}, new int[]{i35}};
                            int i6411 = (-1) - (~(-(-(((1283078155 + (((~((-397000172) | i169)) | (~((-208448287) | i))) * (-370))) + ((((~((-397000172) | i)) | (~((-208448287) | i169))) | (-535674880)) * (-370))) - 631209984))));
                            int i6412 = i6411 << 13;
                            int i6413 = (i6412 & (~i6411)) | ((~i6412) & i6411);
                            int i6414 = i6413 ^ (i6413 >>> 17);
                            int i6415 = i6414 << 5;
                            i37 = 0;
                            c3 = 4;
                            i36 = 1;
                        } else {
                            objArr = new Object[]{null, new int[1], null, new int[]{i}, new int[]{i}};
                            int elapsedCpuTime14 = (int) Process.getElapsedCpuTime();
                            int i6416 = 2063318369 + (((~((-439154682) | elapsedCpuTime14)) | 136868112) * 104) + ((~((~elapsedCpuTime14) | 468580345)) * (-104)) + ((elapsedCpuTime14 | 166293776) * 104);
                            int i6417 = (-1) - (~(-(-((i6416 << 1) - i6416))));
                            int i6418 = (i6417 << 13) ^ i6417;
                            int i6419 = i6418 ^ (i6418 >>> 17);
                            int i657 = i6419 << 5;
                            int i658 = (i6419 | i657) & (~(i6419 & i657));
                            i36 = 1;
                            i37 = 0;
                            ((int[]) objArr[1])[0] = i658;
                            c3 = 4;
                        }
                        i38 = ((int[]) objArr[c3])[i37];
                        if (i38 != i) {
                            objArr2 = new Object[5];
                            objArr2[i36] = new int[i36];
                            int[] iArr3 = new int[i36];
                            objArr2[3] = iArr3;
                            int[] iArr4 = new int[i36];
                            objArr2[c3] = iArr4;
                            List list2 = (List) objArr[i37];
                            iArr3[i37] = i;
                            iArr4[i37] = i38;
                            objArr2[i37] = list2;
                            objArr2[2] = null;
                            int elapsedCpuTime15 = (int) Process.getElapsedCpuTime();
                            int i659 = i3 + (-441151705) + (((~((-57940110) | elapsedCpuTime15)) | 50331781) * (-140)) + ((~((-7608329) | elapsedCpuTime15)) * 70) + (((~(elapsedCpuTime15 | 663388567)) | (-620665115)) * 70) + 16;
                            int i6510 = i659 << 13;
                            int i6511 = ((~i659) & i6510) | ((~i6510) & i659);
                            int i6512 = i6511 ^ (i6511 >>> 17);
                            int i6513 = i6512 << 5;
                            ((int[]) objArr2[1])[0] = (i6512 | i6513) & (~(i6512 & i6513));
                        } else {
                            i39 = i37;
                        }
                    }
                    char doubleTapTimeout5 = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                    int iAlpha2 = Color.alpha(i39);
                    int i660 = getARTIFICIAL_FRAME_PACKAGE_NAME + 113;
                    artificialFrame = i660 % 128;
                    int i661 = i660 % 2;
                    Object[] objArr150 = new Object[1];
                    a(doubleTapTimeout5, 697 - (~iAlpha2), 15 - (~(-(-Color.alpha(0)))), objArr150);
                    Object[] objArr151 = {(String) objArr150[0]};
                    objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                    if (objAccessartificialFrame12 == null) {
                        int iGreen5 = Color.green(0) + 23;
                        str11 = str9;
                        char cIndexOf9 = (char) (TextUtils.indexOf((CharSequence) str11, '0', 0, 0) + 1);
                        int keyRepeatDelay14 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 2441;
                        byte[] bArr20 = $$a;
                        Object[] objArr152 = new Object[1];
                        b((byte) 49, bArr20[16], bArr20[10], objArr152);
                        objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iGreen5, cIndexOf9, keyRepeatDelay14, 954751276, false, (String) objArr152[0], new Class[]{String.class});
                    } else {
                        str11 = str9;
                    }
                    objInvoke2 = ((Method) objAccessartificialFrame12).invoke(null, objArr151);
                    if (objInvoke2 == null) {
                        i45 = 0;
                    } else {
                        Object[] objArr153 = {objInvoke2, 42};
                        objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-287841710);
                        if (objAccessartificialFrame13 == null) {
                            int iIndexOf17 = TextUtils.indexOf((CharSequence) str11, '0', 0, 0) + 21;
                            char cMyTid2 = (char) (Process.myTid() >> 22);
                            int touchSlop7 = (ViewConfiguration.getTouchSlop() >> 8) + 2245;
                            byte[] bArr21 = $$a;
                            Object[] objArr154 = new Object[1];
                            b((byte) (-bArr21[22]), bArr21[c2], bArr21[10], objArr154);
                            objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(iIndexOf17, cMyTid2, touchSlop7, 1907532890, false, (String) objArr154[0], new Class[]{String.class, Integer.TYPE});
                        }
                        long jLongValue20 = ((Long) ((Method) objAccessartificialFrame13).invoke(null, objArr153)).longValue();
                        long j88 = -210517596;
                        long j89 = 764;
                        long j90 = (j21 | j88) ^ j20;
                        long j91 = ((j88 ^ j20) | jLongValue20) ^ j20;
                        long j92 = (((long) 765) * j88) + (((long) (-1527)) * jLongValue20) + ((jLongValue20 | j90) * j89) + (((long) (-1528)) * (j91 | ((j21 | jLongValue20) ^ j20))) + (j89 * (j91 | (((jLongValue20 ^ j20) | j88) ^ j20) | j90)) + ((long) 1843602924);
                        int i662 = ((int) (j92 >> 32)) & (((~((-1441952981) | i)) * TypedValues.CycleType.TYPE_EASING) + 1464859470 + (((~((-1441952981) | i169)) | (-1442018773)) * TypedValues.CycleType.TYPE_EASING));
                        int iElapsedRealtime3 = (int) SystemClock.elapsedRealtime();
                        int i663 = ~iElapsedRealtime3;
                        i45 = i662 | (((int) j92) & (20405895 + (((~((-358315138) | i663)) | 16859137) * 98) + (((~(i663 | 1795541547)) | (-358315138) | (~((-1795541548) | iElapsedRealtime3))) * (-49)) + (((~(iElapsedRealtime3 | (-358315138))) | 1778682410) * 49)));
                    }
                    if (i45 != 1986687685 || i45 == -1514516938) {
                        str12 = str11;
                    } else {
                        int i664 = 19;
                        String[] strArr16 = new String[19];
                        str12 = str11;
                        int i665 = -TextUtils.indexOf(str12, str12);
                        int i666 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                        int i667 = -(-Color.red(0));
                        int i668 = (i667 & 14) + (i667 | 14);
                        Object[] objArr155 = new Object[1];
                        a((char) ((i665 ^ 5794) + ((i665 & 5794) << 1)), ((i666 | 1412) << 1) - (i666 ^ 1412), i668, objArr155);
                        strArr16[0] = (String) objArr155[0];
                        char absoluteGravity5 = (char) Gravity.getAbsoluteGravity(0, 0);
                        int i669 = -(PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                        int i670 = (i669 ^ 1427) + ((i669 & 1427) << 1);
                        int iCombineMeasuredStates = View.combineMeasuredStates(0, 0);
                        int i671 = (iCombineMeasuredStates & 26) + (iCombineMeasuredStates | 26);
                        Object[] objArr156 = new Object[1];
                        a(absoluteGravity5, i670, i671, objArr156);
                        strArr16[1] = (String) objArr156[0];
                        char jumpTapTimeout2 = (char) (ViewConfiguration.getJumpTapTimeout() >> 16);
                        int i672 = -TextUtils.indexOf(str12, str12);
                        Object[] objArr157 = new Object[1];
                        a(jumpTapTimeout2, (i672 ^ 1453) + ((i672 & 1453) << 1), 16 - (~(-(KeyEvent.getMaxKeyCode() >> 16))), objArr157);
                        strArr16[2] = (String) objArr157[0];
                        char cIndexOf10 = (char) TextUtils.indexOf(str12, str12);
                        int iResolveSize4 = View.resolveSize(0, 0) + 1470;
                        int i673 = -(-(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                        int i674 = (i673 & 16) + (i673 | 16);
                        Object[] objArr158 = new Object[1];
                        a(cIndexOf10, iResolveSize4, i674, objArr158);
                        strArr16[3] = (String) objArr158[0];
                        char offsetBefore3 = (char) TextUtils.getOffsetBefore(str12, 0);
                        int i675 = -(ViewConfiguration.getPressedStateDuration() >> 16);
                        Object[] objArr159 = new Object[1];
                        a(offsetBefore3, (i675 ^ 1487) + ((i675 & 1487) << 1), TextUtils.indexOf(str12, str12, 0, 0) + 15, objArr159);
                        strArr16[4] = (String) objArr159[0];
                        char c32 = (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                        int iLastIndexOf3 = TextUtils.lastIndexOf(str12, '0', 0);
                        int i676 = iLastIndexOf3 * 273;
                        int i677 = ((i676 | (-407313)) << 1) - (i676 ^ (-407313));
                        int i678 = ~iLastIndexOf3;
                        int i679 = (i678 ^ (-1504)) | (i678 & (-1504));
                        int i680 = ~i;
                        int i681 = ~((i679 & i680) | (i679 ^ i680));
                        int i682 = ~(iLastIndexOf3 | 1503 | i);
                        int i683 = i677 + (((i681 & i682) | (i681 ^ i682)) * (-272));
                        int i684 = ~((i678 & 1503) | (i678 ^ 1503));
                        int i685 = ~iLastIndexOf3;
                        int i686 = ~((i685 & i) | (i685 ^ i));
                        int i687 = -(-(((i684 & i686) | (i684 ^ i686)) * (-272)));
                        int i688 = (i683 & i687) + (i687 | i683);
                        int i689 = ~((iLastIndexOf3 ^ i) | (iLastIndexOf3 & i));
                        int i690 = -(-(((i689 & 1503) | (i689 ^ 1503)) * 272));
                        int i691 = (i688 & i690) + (i690 | i688);
                        int longPressTimeout7 = ViewConfiguration.getLongPressTimeout() >> 16;
                        int i692 = (longPressTimeout7 ^ 37) + ((longPressTimeout7 & 37) << 1);
                        Object[] objArr160 = new Object[1];
                        a(c32, i691, i692, objArr160);
                        strArr16[5] = (String) objArr160[0];
                        int i693 = -(-(TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)));
                        int i694 = 1538 - (~(-(-(ViewConfiguration.getMinimumFlingVelocity() >> 16))));
                        int i695 = -(ViewConfiguration.getTapTimeout() >> 16);
                        int iIPostMessageServiceStubProxy14 = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                        int i696 = (i695 * 659) - 7884;
                        int i697 = ~i695;
                        int i698 = ~((i697 & 12) | (i697 ^ 12));
                        int i699 = ~(((-13) & i695) | ((-13) ^ i695));
                        int i700 = (i698 & i699) | (i698 ^ i699);
                        int i701 = ~((i695 ^ iIPostMessageServiceStubProxy14) | (i695 & iIPostMessageServiceStubProxy14));
                        int i702 = -(-(((i700 & i701) | (i700 ^ i701)) * (-658)));
                        int i703 = (i696 ^ i702) + ((i696 & i702) << 1);
                        int i704 = (~(((-13) & i695) | ((-13) ^ i695))) * 658;
                        int i705 = (i703 ^ i704) + ((i704 & i703) << 1) + (((~(i695 | iIPostMessageServiceStubProxy14)) | i699) * 658);
                        Object[] objArr161 = new Object[1];
                        a((char) ((i693 ^ 59662) + ((i693 & 59662) << 1)), i694, i705, objArr161);
                        strArr16[c2] = (String) objArr161[0];
                        char c33 = (char) ((-2) - (~(-MotionEvent.axisFromString(str12))));
                        int i706 = -(PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                        int i707 = (i706 ^ 1551) + ((i706 & 1551) << 1);
                        int i708 = -(-(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                        int i709 = (i708 ^ 14) + ((i708 & 14) << 1);
                        Object[] objArr162 = new Object[1];
                        a(c33, i707, i709, objArr162);
                        strArr16[7] = (String) objArr162[0];
                        int i710 = -View.getDefaultSize(0, 0);
                        int i711 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                        int i712 = -(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                        int i713 = (i712 & 22) + (i712 | 22);
                        Object[] objArr163 = new Object[1];
                        a((char) ((i710 & 63894) + (i710 | 63894)), ((i711 | 1563) << 1) - (i711 ^ 1563), i713, objArr163);
                        strArr16[8] = (String) objArr163[0];
                        char c34 = (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 61684);
                        int i714 = -Color.red(0);
                        int i715 = (i714 & 1586) + (i714 | 1586);
                        int i716 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                        int i717 = ((i716 | 30) << 1) - (i716 ^ 30);
                        Object[] objArr164 = new Object[1];
                        a(c34, i715, i717, objArr164);
                        strArr16[9] = (String) objArr164[0];
                        char bitsPerPixel3 = (char) (41041 - ImageFormat.getBitsPerPixel(0));
                        int i718 = -Color.argb(0, 0, 0, 0);
                        int i719 = ((i718 | 1617) << 1) - (i718 ^ 1617);
                        int i720 = -(-(ViewConfiguration.getWindowTouchSlop() >> 8));
                        int i721 = (i720 & 12) + (i720 | 12);
                        Object[] objArr165 = new Object[1];
                        a(bitsPerPixel3, i719, i721, objArr165);
                        strArr16[10] = (String) objArr165[0];
                        Object[] objArr166 = new Object[1];
                        a((char) (ViewConfiguration.getKeyRepeatTimeout() >> 16), ExpandableListView.getPackedPositionGroup(0L) + 1629, 10 - (~(-Process.getGidForName(str12))), objArr166);
                        strArr16[11] = (String) objArr166[0];
                        char cIndexOf11 = (char) (TextUtils.indexOf((CharSequence) str12, '0', 0) + 1);
                        int i722 = 1639 - (~(-TextUtils.indexOf((CharSequence) str12, '0', 0)));
                        int i723 = -View.MeasureSpec.getSize(0);
                        int i724 = ((i723 | 12) << 1) - (i723 ^ 12);
                        int i725 = getARTIFICIAL_FRAME_PACKAGE_NAME + 55;
                        artificialFrame = i725 % 128;
                        int i726 = i725 % 2;
                        Object[] objArr167 = new Object[1];
                        a(cIndexOf11, i722, i724, objArr167);
                        strArr16[12] = (String) objArr167[0];
                        char windowTouchSlop4 = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                        int i727 = -(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                        Object[] objArr168 = new Object[1];
                        a(windowTouchSlop4, (i727 & 1654) + (i727 | 1654), 11 - (~Color.red(0)), objArr168);
                        strArr16[13] = (String) objArr168[0];
                        char c35 = (char) (15638 - (~(-KeyEvent.keyCodeFromString(str12))));
                        int iLastIndexOf4 = 1664 - TextUtils.lastIndexOf(str12, '0');
                        int iMyPid = Process.myPid() >> 22;
                        int i728 = ((iMyPid | 12) << 1) - (iMyPid ^ 12);
                        Object[] objArr169 = new Object[1];
                        a(c35, iLastIndexOf4, i728, objArr169);
                        strArr16[14] = (String) objArr169[0];
                        int i729 = -(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                        int i730 = -(-(ViewConfiguration.getMaximumFlingVelocity() >> 16));
                        int i731 = -Color.rgb(0, 0, 0);
                        int i732 = (i731 ^ (-16777202)) + ((i731 & (-16777202)) << 1);
                        Object[] objArr170 = new Object[1];
                        a((char) ((i729 ^ 1) + ((i729 & 1) << 1)), (i730 ^ 1677) + ((i730 & 1677) << 1), i732, objArr170);
                        strArr16[15] = (String) objArr170[0];
                        char cNormalizeMetaState = (char) KeyEvent.normalizeMetaState(0);
                        int i733 = -KeyEvent.normalizeMetaState(0);
                        Object[] objArr171 = new Object[1];
                        a(cNormalizeMetaState, (i733 ^ 1691) + ((i733 & 1691) << 1), 11 - (~Color.green(0)), objArr171);
                        strArr16[16] = (String) objArr171[0];
                        char cMyTid3 = (char) (Process.myTid() >> 22);
                        int i734 = 1702 - (~(-(-Drawable.resolveOpacity(0, 0))));
                        int i735 = -(-View.MeasureSpec.makeMeasureSpec(0, 0));
                        int i736 = ((i735 | 24) << 1) - (i735 ^ 24);
                        Object[] objArr172 = new Object[1];
                        a(cMyTid3, i734, i736, objArr172);
                        strArr16[17] = (String) objArr172[0];
                        char defaultSize4 = (char) (View.getDefaultSize(0, 0) + 41016);
                        int i737 = -(-ExpandableListView.getPackedPositionType(0L));
                        int i738 = (i737 ^ 1727) + ((i737 & 1727) << 1);
                        int i739 = -(Process.myTid() >> 22);
                        int i740 = ((i739 | 28) << 1) - (i739 ^ 28);
                        Object[] objArr173 = new Object[1];
                        a(defaultSize4, i738, i740, objArr173);
                        strArr16[18] = (String) objArr173[0];
                        int i741 = 0;
                        while (true) {
                            if (i741 >= i664) {
                                i741 = i31;
                                break;
                            }
                            String str70 = strArr16[i741];
                            Object[] objArr174 = {str70};
                            Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-11453480);
                            if (objAccessartificialFrame24 == null) {
                                int iKeyCodeFromString = KeyEvent.keyCodeFromString(str12) + 17;
                                char offsetAfter5 = (char) (TextUtils.getOffsetAfter(str12, 0) + 24343);
                                int i742 = 2014 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                                byte[] bArr22 = $$a;
                                Object[] objArr175 = new Object[1];
                                b((byte) (-bArr22[22]), bArr22[20], (byte) (-bArr22[4]), objArr175);
                                objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString, offsetAfter5, i742, 1614052816, false, (String) objArr175[0], new Class[]{String.class});
                            }
                            long jLongValue21 = ((Long) ((Method) objAccessartificialFrame24).invoke(null, objArr174)).longValue();
                            long j93 = -357381754;
                            long j94 = -167;
                            long j95 = (j94 * j93) + (j94 * jLongValue21);
                            long j96 = 168;
                            long j97 = j93 ^ j20;
                            long j98 = jLongValue21 ^ j20;
                            long j99 = j97 | j98;
                            long j100 = j95 + (((j99 ^ j20) | ((j98 | j21) ^ j20)) * j96) + (((j99 | j19) ^ j20) * j96) + (j96 * (((j97 | j21) ^ j20) | ((j97 | jLongValue21) ^ j20) | (((j98 | j93) | j19) ^ j20))) + ((long) 1919512791);
                            int elapsedCpuTime16 = (int) Process.getElapsedCpuTime();
                            int i743 = ((int) (j100 >> 32)) & (141631168 + ((~((~elapsedCpuTime16) | (-352323595))) * 433) + (((~(1603950639 | elapsedCpuTime16)) | 1253790245) * (-433)) + (((~(elapsedCpuTime16 | 1253790245)) | 1251627045) * 433));
                            int i744 = (-1602182410) + (((~(201800726 | i169)) | 1101005185) * (-245));
                            int i745 = ~(201800726 | i);
                            int i746 = i744 + (i745 * (-245)) + ((i745 | (-1235425684)) * 245);
                            int i747 = getARTIFICIAL_FRAME_PACKAGE_NAME + 113;
                            artificialFrame = i747 % 128;
                            int i748 = i747 % 2;
                            int i749 = ((int) j100) & i746;
                            if (((i749 & i743) | (i743 ^ i749)) != 0) {
                                break;
                            }
                            char maxKeyCode3 = (char) (KeyEvent.getMaxKeyCode() >> 16);
                            int i750 = 1676 - (~(-(-Color.green(0))));
                            int i751 = -(ViewConfiguration.getLongPressTimeout() >> 16);
                            int i752 = (i751 ^ 14) + ((i751 & 14) << 1);
                            Object[] objArr176 = new Object[1];
                            a(maxKeyCode3, i750, i752, objArr176);
                            if (str70.equals((String) objArr176[0])) {
                                Object[] objArr177 = {str70};
                                Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(479197382);
                                if (objAccessartificialFrame25 == null) {
                                    int i753 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 16;
                                    char c36 = (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 24342);
                                    int packedPositionType4 = 2014 - ExpandableListView.getPackedPositionType(0L);
                                    byte[] bArr23 = $$a;
                                    Object[] objArr178 = new Object[1];
                                    b(bArr23[c2], (byte) (-bArr23[3]), (byte) (-bArr23[4]), objArr178);
                                    objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(i753, c36, packedPositionType4, -2081767730, false, (String) objArr178[0], new Class[]{String.class});
                                }
                                long jLongValue22 = ((Long) ((Method) objAccessartificialFrame25).invoke(null, objArr177)).longValue();
                                long j101 = -647603659;
                                long j102 = -502;
                                long j103 = jLongValue22 ^ j20;
                                long j104 = (((long) (-501)) * j101) + (((long) TypedValues.PositionType.TYPE_PERCENT_WIDTH) * jLongValue22) + ((((j103 | j19) ^ j20) | ((jLongValue22 | j101) ^ j20)) * j102) + (j102 * (((j103 | j21) | j101) ^ j20)) + (((long) TypedValues.PositionType.TYPE_DRAWPATH) * (j103 | (((j101 ^ j20) | j19) ^ j20))) + ((long) 1144215050);
                                int i754 = ((int) (j104 >> 32)) & (635053406 + (((~((-25179285) | i169)) | (~((-1412047127) | i))) * (-370)) + (((~((-25179285) | i)) | (~((-1412047127) | i169)) | (-1437218199)) * (-370)) + 805211074);
                                int iFreeMemory3 = (int) Runtime.getRuntime().freeMemory();
                                int i755 = ~iFreeMemory3;
                                int i756 = (~(911288397 | i755)) | 151520528 | (~((-525938013) | i755));
                                int i757 = ((int) j104) & ((-1160686873) + (((~(iFreeMemory3 | (-536870914))) | i756) * 590) + (i756 * (-1180)) + (((~(525938012 | i755)) | (~(i755 | (-911288398)))) * 590));
                                if (((i754 & i757) | (i754 ^ i757)) != 0) {
                                    break;
                                }
                            }
                            i741++;
                            i664 = 19;
                        }
                        if (i741 >= 0) {
                            int i758 = i741 + 130;
                            int i759 = ((~i758) & i) | (i758 & i169);
                            if (i759 != i) {
                                int i760 = getARTIFICIAL_FRAME_PACKAGE_NAME + 65;
                                int i761 = i760 % 128;
                                artificialFrame = i761;
                                int i762 = i760 % 2;
                                Object[] objArr179 = {null, new int[]{(i | i) & (~(i & i))}, null, new int[]{i}, new int[]{i759}};
                                int i763 = ((i761 | 113) << 1) - (i761 ^ 113);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i763 % 128;
                                int i764 = i763 % 2;
                                int i765 = 980279857 + (((~((-174772586) | i169)) | 167776353) * SyslogConstants.LOG_LOCAL7) + ((i | (-787217276)) * (-184)) + ((~((-780221044) | i169)) * SyslogConstants.LOG_LOCAL7);
                                int i766 = -(-(((i765 | 16) << 1) - (i765 ^ 16)));
                                int i767 = (i3 & i766) + (i3 | i766);
                                int i768 = i767 << 13;
                                int i769 = (i768 & (~i767)) | ((~i768) & i767);
                                int i770 = i769 >>> 17;
                                int i771 = ((~i769) & i770) | ((~i770) & i769);
                                int i772 = i771 << 5;
                                return objArr179;
                            }
                        }
                    }
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    char c37 = (char) ((iMakeMeasureSpec & 60776) + (60776 | iMakeMeasureSpec));
                    int i773 = -(ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    int i774 = -TextUtils.indexOf(str12, str12, 0, 0);
                    int i775 = ((i774 | 13) << 1) - (i774 ^ 13);
                    Object[] objArr180 = new Object[1];
                    a(c37, (i773 ^ 1755) + ((i773 & 1755) << 1), i775, objArr180);
                    String str71 = (String) objArr180[0];
                    char cMakeMeasureSpec = (char) View.MeasureSpec.makeMeasureSpec(0, 0);
                    int i776 = -(-(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                    Object[] objArr181 = new Object[1];
                    a(cMakeMeasureSpec, (i776 ^ 1767) + ((i776 & 1767) << 1), 4 - (~(-(ViewConfiguration.getEdgeSlop() >> 16))), objArr181);
                    String[] strArr17 = {str71, (String) objArr181[0]};
                    int i777 = -(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                    Object[] objArr182 = new Object[1];
                    a((char) (((i777 | 1) << 1) - (i777 ^ 1)), 1772 - ((byte) KeyEvent.getModifierMetaStateMask()), 14 - (~(-TextUtils.getCapsMode(str12, 0, 0))), objArr182);
                    String str72 = (String) objArr182[0];
                    char absoluteGravity6 = (char) Gravity.getAbsoluteGravity(0, 0);
                    int i778 = -(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                    int i779 = ((i778 | 1789) << 1) - (i778 ^ 1789);
                    int i780 = -MotionEvent.axisFromString(str12);
                    int i781 = (i780 & 18) + (i780 | 18);
                    Object[] objArr183 = new Object[1];
                    a(absoluteGravity6, i779, i781, objArr183);
                    String str73 = (String) objArr183[0];
                    char cResolveSizeAndState4 = (char) View.resolveSizeAndState(0, 0, 0);
                    int absoluteGravity7 = Gravity.getAbsoluteGravity(0, 0);
                    int i782 = ((absoluteGravity7 | 1807) << 1) - (absoluteGravity7 ^ 1807);
                    int i783 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                    int i784 = (i783 & 13) + (i783 | 13);
                    Object[] objArr184 = new Object[1];
                    a(cResolveSizeAndState4, i782, i784, objArr184);
                    String[] strArr18 = {str72, str73, (String) objArr184[0]};
                    char c38 = (char) ((-2) - ((-TextUtils.lastIndexOf(str12, '0', 0)) ^ (-1)));
                    int i785 = 1819 - (~(-(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))));
                    int i786 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                    int i787 = (i786 ^ 21) + ((i786 & 21) << 1);
                    Object[] objArr185 = new Object[1];
                    a(c38, i785, i787, objArr185);
                    String str74 = (String) objArr185[0];
                    char c39 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1);
                    int iMyPid2 = Process.myPid() >> 22;
                    Object[] objArr186 = new Object[1];
                    a(c39, ((iMyPid2 | 1842) << 1) - (iMyPid2 ^ 1842), 9 - (~(-(-Color.red(0)))), objArr186);
                    String[] strArr19 = {str74, (String) objArr186[0]};
                    char cAxisFromString = (char) (7675 - MotionEvent.axisFromString(str12));
                    int i788 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 1852;
                    int i789 = -(-TextUtils.getOffsetBefore(str12, 0));
                    int i790 = (i789 & 11) + (i789 | 11);
                    Object[] objArr187 = new Object[1];
                    a(cAxisFromString, i788, i790, objArr187);
                    String str75 = (String) objArr187[0];
                    char c40 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                    int trimmedLength2 = TextUtils.getTrimmedLength(str12);
                    Object[] objArr188 = new Object[1];
                    a(c40, ((trimmedLength2 | 589) << 1) - (trimmedLength2 ^ 589), 5 - ((byte) KeyEvent.getModifierMetaStateMask()), objArr188);
                    c4 = 0;
                    String[] strArr20 = {str75, (String) objArr188[0]};
                    char cCombineMeasuredStates2 = (char) (View.combineMeasuredStates(0, 0) + 41406);
                    int doubleTapTimeout6 = ViewConfiguration.getDoubleTapTimeout() >> 16;
                    Object[] objArr189 = new Object[1];
                    a(cCombineMeasuredStates2, (doubleTapTimeout6 ^ 1863) + ((doubleTapTimeout6 & 1863) << 1), 27 - (~(-(-Color.blue(0)))), objArr189);
                    String str76 = (String) objArr189[0];
                    i46 = 1;
                    Object[] objArr190 = new Object[1];
                    a((char) ExpandableListView.getPackedPositionGroup(0L), 1842 - TextUtils.getOffsetBefore(str12, 0), 9 - (~(-Color.green(0))), objArr190);
                    strArr7 = new String[][]{strArr17, strArr18, strArr19, strArr20, new String[]{str76, (String) objArr190[0]}};
                    i47 = 0;
                    i48 = i31;
                    i49 = 5;
                    loop5: while (true) {
                        if (i47 < i49) {
                            i50 = i;
                            break;
                        }
                        String[] strArr21 = strArr7[i47];
                        str13 = strArr21[c4];
                        strArr8 = (String[]) Arrays.copyOfRange(strArr21, i46, strArr21.length);
                        length = strArr8.length;
                        i56 = 0;
                        while (i56 < length) {
                            String str77 = strArr8[i56];
                            i48 = ((i48 | 1) << i46) - (i48 ^ 1);
                            file3 = new File(str13);
                            if (file3.exists() || !file3.isFile()) {
                                strArr9 = strArr7;
                                strArr10 = strArr8;
                            } else {
                                try {
                                    Scanner scanner3 = new Scanner(new FileInputStream(file3));
                                    int iIndexOf18 = TextUtils.indexOf(str12, str12, 0, 0);
                                    char c41 = (char) (((iIndexOf18 | 38938) << 1) - (38938 ^ iIndexOf18));
                                    int iIndexOf19 = TextUtils.indexOf((CharSequence) str12, '0');
                                    strArr9 = strArr7;
                                    int i791 = (iIndexOf19 ^ 371) + ((iIndexOf19 & 371) << 1);
                                    try {
                                        int i792 = -View.MeasureSpec.makeMeasureSpec(0, 0);
                                        strArr10 = strArr8;
                                        try {
                                            Object[] objArr191 = new Object[1];
                                            a(c41, i791, ((i792 & 2) << 1) + (i792 ^ 2), objArr191);
                                            Scanner scannerUseDelimiter3 = scanner3.useDelimiter((String) objArr191[0]);
                                            String next3 = scannerUseDelimiter3.hasNext() ? scannerUseDelimiter3.next() : str12;
                                            scannerUseDelimiter3.close();
                                            if (next3.contains(str77)) {
                                                int i793 = artificialFrame + 69;
                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i793 % 128;
                                                if (i793 % 2 != 0) {
                                                    int i794 = i48 * 29807;
                                                    i50 = ((~i794) & i) | (i794 & i169);
                                                } else {
                                                    int i795 = i48 + 170;
                                                    i50 = (~(i & i795)) & (i | i795);
                                                }
                                                i46 = 1;
                                                break loop5;
                                            }
                                        } catch (IOException unused3) {
                                            continue;
                                        }
                                    } catch (IOException unused4) {
                                        strArr10 = strArr8;
                                    }
                                } catch (IOException unused5) {
                                    strArr9 = strArr7;
                                }
                            }
                            i56++;
                            strArr7 = strArr9;
                            strArr8 = strArr10;
                            i46 = 1;
                        }
                        int i796 = i47 + 78;
                        i46 = 1;
                        i47 = ((i796 & (-77)) << 1) + (i796 ^ (-77));
                        strArr7 = strArr7;
                        i49 = 5;
                        c4 = 0;
                    }
                    if (i50 != i) {
                        Object[] objArr192 = new Object[5];
                        objArr192[i46] = new int[i46];
                        int[] iArr5 = new int[i46];
                        objArr192[3] = iArr5;
                        int[] iArr6 = new int[i46];
                        objArr192[4] = iArr6;
                        iArr5[0] = i;
                        iArr6[0] = i50;
                        objArr192[0] = null;
                        objArr192[2] = null;
                        int i797 = (-497965718) + (((~(i169 | (-758680880))) | (-153232422)) * (-235)) + (((~((-758680880) | i)) | (-153232422)) * (-470)) + (((~(i | (-153093158))) | (-758820144)) * 235);
                        int iIPostMessageServiceStubProxy15 = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                        int i798 = -(-(i797 * 829));
                        int i799 = ((13264 | i798) << 1) - (i798 ^ 13264);
                        int i800 = ~i797;
                        int i801 = ~((i800 & (-17)) | ((-17) ^ i800));
                        int i802 = (~iIPostMessageServiceStubProxy15) | 16;
                        int i803 = ~((i802 & i797) | (i802 ^ i797));
                        int i804 = ((i801 & i803) | (i801 ^ i803)) * (-828);
                        int i805 = (i799 ^ i804) + ((i804 & i799) << 1);
                        int i806 = (i797 ^ 16) | (i797 & 16);
                        int i807 = ~iIPostMessageServiceStubProxy15;
                        int i808 = ((i807 & i806) | (i806 ^ i807)) * (-828);
                        int i809 = -(-((((i805 ^ i808) + ((i808 & i805) << 1)) - (~((~i806) * 828))) - 1));
                        int i810 = (i3 ^ i809) + ((i3 & i809) << 1);
                        int i811 = (i810 << 13) ^ i810;
                        int i812 = i811 >>> 17;
                        int i813 = ((~i811) & i812) | ((~i812) & i811);
                        int i814 = i813 << 5;
                        ((int[]) objArr192[1])[0] = (i813 | i814) & (~(i813 & i814));
                        return objArr192;
                    }
                    try {
                        Object[] objArr193 = new Object[1];
                        a((char) ExpandableListView.getPackedPositionType(0L), (Process.myPid() >> 22) + 1891, TextUtils.getOffsetAfter(str12, 0) + 13, objArr193);
                        String str78 = (String) objArr193[0];
                        char packedPositionGroup3 = (char) ExpandableListView.getPackedPositionGroup(0L);
                        int modifierMetaStateMask7 = ((byte) KeyEvent.getModifierMetaStateMask()) + 1905;
                        int i815 = -(ViewConfiguration.getWindowTouchSlop() >> 8);
                        int i816 = (i815 ^ 8) + ((i815 & 8) << 1);
                        Object[] objArr194 = new Object[1];
                        a(packedPositionGroup3, modifierMetaStateMask7, i816, objArr194);
                        try {
                            Object[] objArr195 = {str78, (String) objArr194[0]};
                            objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-883653127);
                            if (objAccessartificialFrame15 == null) {
                                int i817 = 31 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                                char longPressTimeout8 = (char) (57022 - (ViewConfiguration.getLongPressTimeout() >> 16));
                                int i818 = 2312 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                                byte[] bArr24 = $$a;
                                Object[] objArr196 = new Object[1];
                                b((byte) (bArr24[13] - 1), (byte) (-bArr24[4]), bArr24[10], objArr196);
                                objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(i817, longPressTimeout8, i818, 1412547569, false, (String) objArr196[0], new Class[]{String.class, String.class});
                            }
                            long jLongValue23 = ((Long) ((Method) objAccessartificialFrame15).invoke(null, objArr195)).longValue();
                            long j105 = 219577950;
                            long j106 = j105 ^ j20;
                            long elapsedCpuTime17 = (int) Process.getElapsedCpuTime();
                            long j107 = elapsedCpuTime17 ^ j20;
                            long j108 = (((long) 302) * j105) + (((long) TypedValues.MotionType.TYPE_EASING) * jLongValue23) + (((long) (-602)) * (jLongValue23 | ((j106 | j107) ^ j20))) + (((long) (-301)) * (((j106 | (jLongValue23 ^ j20)) ^ j20) | ((j106 | elapsedCpuTime17) ^ j20) | (((j107 | j105) | jLongValue23) ^ j20))) + (((long) 301) * ((j107 | jLongValue23) ^ j20)) + ((long) (-374329579));
                            int i819 = (~((-1046398404) | i169)) | 373982659;
                            int i820 = ~(1063243751 | i);
                            i53 = ((int) (j108 >> 32)) & (197960204 + ((i819 | i820) * (-502)) + (((~((-672415745) | i169)) | i820) * TypedValues.PositionType.TYPE_DRAWPATH));
                            int i821 = (int) j108;
                            int iNextInt4 = new java.util.Random().nextInt();
                            int i822 = ~iNextInt4;
                            i54 = i821 & ((((~((-1998387830) | i822)) | (~((-859353057) | iNextInt4)) | (~(i822 | 859353056))) * 959) + 1089433716 + (((~(iNextInt4 | 859353056)) | (~(i822 | (-859353057))) | (~((-1998387830) | iNextInt4))) * 959));
                            if (((i53 & i54) | (i53 ^ i54)) != 0) {
                                i51 = (i & (-151)) | (i169 & 150);
                            } else {
                                int i823 = artificialFrame;
                                i55 = (i823 ^ 49) + ((i823 & 49) << 1);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i55 % 128;
                                if (i55 % 2 == 0) {
                                    Object obj2 = null;
                                    obj2.hashCode();
                                    throw null;
                                }
                                i51 = i;
                            }
                            if (i51 != i) {
                                Object[] objArr197 = {null, new int[1], null, new int[]{i}, new int[]{i51}};
                                int iMyUid = Process.myUid();
                                int i824 = (-161785490) + (((~((-672706827) | (~iMyUid))) | 67258368) * (-591)) + ((iMyUid | (-672706827)) * 591);
                                int i825 = (i824 & 16) + (i824 | 16);
                                int i826 = (i3 ^ i825) + ((i3 & i825) << 1);
                                int i827 = (i826 << 13) ^ i826;
                                int i828 = i827 >>> 17;
                                int i829 = (i827 | i828) & (~(i827 & i828));
                                ((int[]) objArr197[1])[0] = i829 ^ (i829 << 5);
                                return objArr197;
                            }
                            char absoluteGravity8 = (char) Gravity.getAbsoluteGravity(0, 0);
                            int doubleTapTimeout7 = ViewConfiguration.getDoubleTapTimeout();
                            int i830 = artificialFrame + 97;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i830 % 128;
                            int i831 = i830 % 2;
                            int i832 = doubleTapTimeout7 >> 16;
                            Object[] objArr198 = new Object[1];
                            a(absoluteGravity8, (1912 & i832) + (i832 | 1912), Drawable.resolveOpacity(0, 0) + 47, objArr198);
                            String str79 = (String) objArr198[0];
                            int i833 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                            int i834 = (i833 ^ 13) + ((i833 & 13) << 1);
                            artificialFrame = i834 % 128;
                            int i835 = i834 % 2;
                            Object[] objArr199 = {str79};
                            objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-11453480);
                            if (objAccessartificialFrame14 == null) {
                                int i836 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 16;
                                char cIndexOf12 = (char) (TextUtils.indexOf(str12, str12) + 24343);
                                int iRed = Color.red(0) + 2014;
                                byte[] bArr25 = $$a;
                                Object[] objArr200 = new Object[1];
                                b((byte) (-bArr25[22]), bArr25[20], (byte) (-bArr25[4]), objArr200);
                                objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(i836, cIndexOf12, iRed, 1614052816, false, (String) objArr200[0], new Class[]{String.class});
                            }
                            long jLongValue24 = ((Long) ((Method) objAccessartificialFrame14).invoke(null, objArr199)).longValue();
                            long j109 = 78428149;
                            long j110 = jLongValue24 ^ j20;
                            long jElapsedRealtime4 = (int) SystemClock.elapsedRealtime();
                            long j111 = jElapsedRealtime4 ^ j20;
                            long j112 = (((long) 50) * j109) + (((long) (-97)) * jLongValue24) + (((long) 98) * (((j110 | j111) ^ j20) | ((j110 | j109) ^ j20))) + (((long) (-49)) * (j110 | (((j109 ^ j20) | j111) ^ j20) | ((j109 | jElapsedRealtime4) ^ j20))) + (((long) 49) * (((j110 | jElapsedRealtime4) ^ j20) | ((j109 | jLongValue24) ^ j20))) + ((long) 1483702888);
                            int i837 = ((int) (j112 >> 32)) & ((-871420054) + (((~(23744409 | i169)) | 1409286144) * SyslogConstants.LOG_LOCAL7) + ((19548552 | i) * (-184)) + ((~((-1413482002) | i169)) * SyslogConstants.LOG_LOCAL7));
                            int startElapsedRealtime4 = (int) Process.getStartElapsedRealtime();
                            int i838 = ~startElapsedRealtime4;
                            int i839 = ~((-2041828274) | i838);
                            int i840 = (i837 | (((int) j112) & (1625355485 + ((536957441 | i839) * (-712)) + (((~(startElapsedRealtime4 | (-1504870833))) | (~(i838 | (-536957442)))) * (-712)) + (((-604601864) | i839) * 712)))) * 263;
                            i52 = (i840 & i169) | ((~i840) & i);
                            if (i52 != i) {
                                Object[] objArr201 = {null, new int[]{((~i) & i) | ((~i) & i)}, null, new int[]{i}, new int[]{i52}};
                                int i841 = (i3 - (~(-(-((((-769471549) + ((i169 | 136479042) * 1324)) + (((~(i | 464691654)) | (~(140756803 | i))) * (-1324))) + 1065294846))))) - 1;
                                int i842 = i841 ^ (i841 << 13);
                                int i843 = i842 >>> 17;
                                int i844 = ((~i842) & i843) | ((~i843) & i842);
                                int i845 = i844 << 5;
                                return objArr201;
                            }
                            Object[] objArr202 = {null, new int[1], null, new int[]{i}, new int[]{i}};
                            int i846 = artificialFrame + 23;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i846 % 128;
                            int i847 = i846 % 2;
                            int startUptimeMillis2 = (int) Process.getStartUptimeMillis();
                            int i848 = 1413520873 + (((~((-412089841) | startUptimeMillis2)) | 193358617) * (-366)) + (((~(startUptimeMillis2 | (-269063393))) | 50332169) * 366);
                            int iIPostMessageServiceStubProxy16 = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                            int i849 = i848 * (-743);
                            int i850 = (i849 << 1) - i849;
                            int i851 = ~i848;
                            int i852 = ~iIPostMessageServiceStubProxy16;
                            int i853 = (i851 & i852) | (i851 ^ i852);
                            int i854 = ~((i848 ^ iIPostMessageServiceStubProxy16) | (i848 & iIPostMessageServiceStubProxy16));
                            int i855 = ((i853 & i854) | (i853 ^ i854)) * (-744);
                            int i856 = (i850 & i855) + (i855 | i850);
                            int i857 = ~iIPostMessageServiceStubProxy16;
                            int i858 = ~i848;
                            int i859 = (i856 - (~((i857 | (~(i858 | (i31 ^ i858)))) * 744))) - 1;
                            int i860 = -(-((iIPostMessageServiceStubProxy16 | i848) * 744));
                            int i861 = i3 + (((i859 | i860) << 1) - (i860 ^ i859));
                            int i862 = i861 << 13;
                            int i863 = (i861 | i862) & (~(i861 & i862));
                            int i864 = i863 >>> 17;
                            int i865 = ((~i863) & i864) | ((~i864) & i863);
                            int i866 = i865 << 5;
                            ((int[]) objArr202[1])[0] = ((~i865) & i866) | ((~i866) & i865);
                            return objArr202;
                        } catch (Throwable th2) {
                            Throwable cause2 = th2.getCause();
                            if (cause2 != null) {
                                throw cause2;
                            }
                            throw th2;
                        }
                    } catch (Exception unused6) {
                        i51 = (i & (-152)) | (i169 & 151);
                    }
                }
                return objArr2;
            }
            i7 = (~(i & 266)) & (i | 266);
            i6 = i7;
            if (i6 != i) {
                Object[] objArr210 = {null, new int[]{(i184 | i187) & (~(i184 & i187))}, null, new int[]{i}, new int[]{i6}};
                int i1710 = (((~((-270887960) | i169)) | 327685 | (~(i169 | 334560498))) * (-397)) + 967163305 + ((i | 64327909) * 397);
                int i1711 = -(-(((i1710 | 16) << 1) - (i1710 ^ 16)));
                int i1810 = (i3 ^ i1711) + ((i3 & i1711) << 1);
                int i1811 = i1810 << 13;
                int i1812 = (i1811 | i1810) & (~(i1810 & i1811));
                int i1813 = i1812 >>> 17;
                int i1814 = (i1812 | i1813) & (~(i1812 & i1813));
                int i1815 = getARTIFICIAL_FRAME_PACKAGE_NAME + 119;
                artificialFrame = i1815 % 128;
                int i1816 = i1815 % 2;
                int i1817 = i1814 << 5;
                return objArr210;
            }
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(943212816);
            if (objAccessartificialFrame == null) {
                int packedPositionType5 = 7 - ExpandableListView.getPackedPositionType(0L);
                char cMyPid2 = (char) ((Process.myPid() >> 22) + 49362);
                int packedPositionGroup4 = 1768 - ExpandableListView.getPackedPositionGroup(0L);
                byte[] bArr26 = $$a;
                Object[] objArr211 = new Object[1];
                b((byte) (bArr26[5] - 1), (byte) (-bArr26[19]), bArr26[16], objArr211);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(packedPositionType5, cMyPid2, packedPositionGroup4, -1487073512, false, (String) objArr211[0], new Class[0]);
            }
            long jLongValue25 = ((Long) ((Method) objAccessartificialFrame).invoke(null, null)).longValue();
            long j210 = 589903974;
            long j211 = -743;
            long j212 = j210 | jLongValue25;
            long j213 = (j211 * j210) + (j211 * jLongValue25) + (((long) (-744)) * ((j212 ^ j20) | ((j210 | j19) ^ j20) | ((jLongValue25 | j19) ^ j20)));
            long j310 = 744;
            long j311 = j213 + ((j21 | (((jLongValue25 ^ j20) | (j210 ^ j20)) ^ j20)) * j310) + (j310 * (j212 | j19)) + ((long) 785987776);
            int i1818 = ~((-1892224307) | i169);
            int i1819 = ((int) (j311 >> 32)) & (((151293952 | i1818) * (-374)) + 1958239788 + ((i1818 | (-2043518259)) * 374));
            int i1910 = ((int) j311) & ((((~(930795069 | i)) | 134545728) * (-566)) + 1701211605 + ((~(1065340797 | i)) * 566));
            i8 = (i1910 & i1819) | (i1819 ^ i1910);
            if (i8 != 0) {
                int i1911 = ((1970767624 ^ i) | (1970767624 & i)) * 140;
                int i1912 = ((-637605803) & i1911) + (i1911 | (-637605803));
                int i1913 = ~i;
                int i1914 = ~((1970767624 & i1913) | (i1913 ^ 1970767624));
                int i1915 = i1912 + (((i1914 & 142618753) | (142618753 ^ i1914)) * (-280));
                int i1916 = ~((1305917313 & i1913) | (i1913 ^ 1305917313));
                int i1917 = (i1916 & 807469064) | (807469064 ^ i1916);
                int i1918 = ~(((-142618754) & i) | ((-142618754) ^ i));
                i62 = i1915 + (((i1917 & i1918) | (i1917 ^ i1918)) * 140);
                int iIPostMessageServiceStubProxy17 = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                int i1919 = ~((~iIPostMessageServiceStubProxy17) | 2131956);
                int i2010 = -(-(((i1919 ^ (-708677632)) | (i1919 & (-708677632))) * (-160)));
                i63 = ((-1351673309) ^ i2010) + ((i2010 & (-1351673309)) << 1);
                int i2011 = ~iIPostMessageServiceStubProxy17;
                i64 = ~((i2011 & (-706579120)) | ((-706579120) ^ i2011));
                if (i62 > (i63 - (~(-(-(((i64 & 2131956) | (2131956 ^ i64)) * SyslogConstants.LOG_LOCAL4))))) - 1) {
                    int i2012 = 13667 >>> i8;
                    i9 = (i2012 & i169) | ((~i2012) & i);
                } else {
                    int i2013 = i8 - 1;
                    int i2014 = (i2013 & 200) + (i2013 | 200);
                    i9 = (~(i & i2014)) & (i2014 | i);
                }
            } else {
                i9 = i;
            }
            if (i9 != i) {
                Object[] objArr212 = {null, new int[1], null, new int[]{i}, new int[]{i9}};
                int iUptimeMillis6 = (int) SystemClock.uptimeMillis();
                int i2015 = ~iUptimeMillis6;
                int i2016 = -(-((-161126627) + (((~(97752846 | i2015)) | (-703201305) | (~((-97752847) | iUptimeMillis6))) * (-564)) + ((~(iUptimeMillis6 | (-29491209))) * 1128) + (((~((-703201305) | i2015)) | 68261638) * 564) + 16));
                int i2017 = (i3 & i2016) + (i3 | i2016);
                int i2018 = i2017 << 13;
                int i2019 = (i2018 & (~i2017)) | ((~i2018) & i2017);
                int i2110 = i2019 >>> 17;
                int i2111 = ((~i2019) & i2110) | ((~i2110) & i2019);
                int i2112 = i2111 << 5;
                ((int[]) objArr212[1])[0] = (i2111 | i2112) & (~(i2111 & i2112));
                return objArr212;
            }
            char deadChar13 = (char) KeyEvent.getDeadChar(0, 0);
            int tapTimeout4 = ViewConfiguration.getTapTimeout() >> 16;
            int i2113 = (tapTimeout4 & 203) + (tapTimeout4 | 203);
            str4 = str24;
            int i2114 = -TextUtils.lastIndexOf(str4, '0');
            int i2115 = (i2114 ^ 19) + ((i2114 & 19) << 1);
            Object[] objArr310 = new Object[1];
            a(deadChar13, i2113, i2115, objArr310);
            String str210 = (String) objArr310[0];
            int keyRepeatTimeout15 = ViewConfiguration.getKeyRepeatTimeout() >> 16;
            int i2116 = -View.getDefaultSize(0, 0);
            int i2117 = (i2116 ^ 223) + ((i2116 & 223) << 1);
            int i2118 = -TextUtils.indexOf(str4, str4, 0);
            Object[] objArr311 = new Object[1];
            a((char) ((keyRepeatTimeout15 ^ 44923) + ((keyRepeatTimeout15 & 44923) << 1)), i2117, ((i2118 | 6) << 1) - (i2118 ^ 6), objArr311);
            Object[] objArr312 = {str210, (String) objArr311[0]};
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-883653127);
            if (objAccessartificialFrame2 == null) {
                int offsetBefore4 = TextUtils.getOffsetBefore(str4, 0) + 31;
                char cMyTid4 = (char) (57022 - (Process.myTid() >> 22));
                int absoluteGravity9 = Gravity.getAbsoluteGravity(0, 0) + 2311;
                byte[] bArr27 = $$a;
                Object[] objArr313 = new Object[1];
                b((byte) (bArr27[13] - 1), (byte) (-bArr27[4]), bArr27[10], objArr313);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(offsetBefore4, cMyTid4, absoluteGravity9, 1412547569, false, (String) objArr313[0], new Class[]{String.class, String.class});
            }
            long jLongValue26 = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr312)).longValue();
            long j312 = 637823228;
            long j313 = 868;
            long j314 = j312 ^ j20;
            long jElapsedRealtime5 = (int) SystemClock.elapsedRealtime();
            long j315 = jElapsedRealtime5 ^ j20;
            long j316 = jLongValue26 ^ j20;
            long j317 = j314 | j316;
            long j318 = (j313 * j312) + (j313 * jLongValue26) + (((long) (-867)) * (((j314 | j315) ^ j20) | ((j316 | j315) ^ j20))) + (((long) (-1734)) * ((j317 ^ j20) | ((j314 | jElapsedRealtime5) ^ j20) | ((j316 | jElapsedRealtime5) ^ j20))) + (((long) 867) * (((jElapsedRealtime5 | (j316 | j312)) ^ j20) | ((j317 | j315) ^ j20) | (((j314 | jLongValue26) | jElapsedRealtime5) ^ j20))) + ((long) (-792574857));
            i10 = ((int) (j318 >> 32)) & (749017786 + ((~(i169 | (-705757253))) * (-783)) + (((~(i169 | (-1781748805))) | 1075992080) * 783));
            int elapsedCpuTime18 = (int) Process.getElapsedCpuTime();
            i11 = ((int) j318) & (10666256 + ((~((-289440145) | elapsedCpuTime18)) * 623) + (((~elapsedCpuTime18) | (-2079774715)) * (-623)) + (((~(elapsedCpuTime18 | (-1903220635))) | (~((-465994225) | elapsedCpuTime18)) | 289440144) * 623));
            if (((i11 & i10) | (i10 ^ i11)) != 0) {
                i12 = (~(i & 262)) & (i | 262);
            } else {
                i12 = i;
            }
            if (i12 != i) {
                Object[] objArr314 = {null, new int[]{(i224 | i225) & (~(i224 & i225))}, null, new int[]{i}, new int[]{i12}};
                int i2119 = (~((-1023031548) | i)) | 605564938;
                int i2210 = 950724505 + (i2119 * 992) + ((i2119 | (~(i169 | (-116481)))) * (-496)) + ((i | (-417583090)) * 496);
                int i2211 = i3 + (((i2210 | 16) << 1) - (i2210 ^ 16));
                int i2212 = i2211 << 13;
                int i2213 = (i2211 | i2212) & (~(i2211 & i2212));
                int i2214 = i2213 ^ (i2213 >>> 17);
                int i2215 = i2214 << 5;
                return objArr314;
            }
            int i2216 = -(-TextUtils.lastIndexOf(str4, '0'));
            int i2217 = -TextUtils.lastIndexOf(str4, '0', 0);
            int i2218 = i2217 * (-721);
            int i2219 = ((i2218 | (-164388)) << 1) - (i2218 ^ (-164388));
            int i2310 = ~i2217;
            int i2311 = ~((i2310 & (-229)) | (i2310 ^ (-229)));
            int i2312 = (i169 & i2311) | (i169 ^ i2311);
            int i2313 = ~((i2217 ^ 228) | (i2217 & 228));
            int i2314 = ((i2312 & i2313) | (i2312 ^ i2313)) * 1444;
            int i2315 = ((i2219 | i2314) << 1) - (i2314 ^ i2219);
            int i2316 = (~((i2217 ^ i) | (i2217 & i))) | i2313;
            int i2317 = ~((i ^ 228) | (i & 228));
            int i2318 = (i2315 - (~(-(-(((i2316 & i2317) | (i2316 ^ i2317)) * (-1444)))))) - 1;
            int i2319 = ~i2217;
            int i2410 = ~((i2319 & 228) | (i2319 ^ 228));
            int i2411 = ~((i2217 & (-229)) | ((-229) ^ i2217));
            int i2412 = i2410 ^ i2411;
            Object[] objArr315 = new Object[1];
            a((char) ((i2216 ^ 1) + ((i2216 & 1) << 1)), i2318 + (((i2411 & i2410) | i2412) * 722), 30 - (~(KeyEvent.getMaxKeyCode() >> 16)), objArr315);
            int iIndexOf20 = TextUtils.indexOf((CharSequence) str4, '0');
            char c42 = (char) (((iIndexOf20 | 48739) << 1) - (48739 ^ iIndexOf20));
            int i2413 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
            int i2414 = (i2413 ^ 259) + ((i2413 & 259) << 1);
            int iResolveSize5 = View.resolveSize(0, 0);
            int i2415 = (iResolveSize5 ^ 23) + ((iResolveSize5 & 23) << 1);
            Object[] objArr316 = new Object[1];
            a(c42, i2414, i2415, objArr316);
            int iIndexOf21 = TextUtils.indexOf((CharSequence) str4, '0', 0, 0);
            int i2416 = (((iIndexOf21 * 628) - (-14703992)) - (~(-(-(((i | 23414) | (~iIndexOf21)) * (-627)))))) - 1;
            int i2417 = ~(((-23415) & i) | ((-23415) ^ i));
            int i2418 = ((i2417 & iIndexOf21) | (iIndexOf21 ^ i2417)) * (-627);
            int i2419 = ((i2416 | i2418) << 1) - (i2416 ^ i2418);
            int i2510 = ~((i169 ^ 23414) | (i169 & 23414));
            int i2511 = ~((iIndexOf21 & i) | (iIndexOf21 ^ i));
            char c43 = (char) (i2419 + (((i2510 & i2511) | (i2510 ^ i2511)) * 627));
            int keyRepeatDelay15 = ViewConfiguration.getKeyRepeatDelay() >> 16;
            Object[] objArr317 = new Object[1];
            a(c43, (keyRepeatDelay15 ^ 283) + ((keyRepeatDelay15 & 283) << 1), View.MeasureSpec.makeMeasureSpec(0, 0) + 28, objArr317);
            char modifierMetaStateMask8 = (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask()));
            int i2512 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
            int iIPostMessageServiceStubProxy18 = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
            int i2513 = i2512 * (-589);
            int i2514 = (i2513 & 183210) + (i2513 | 183210);
            int i2515 = ~iIPostMessageServiceStubProxy18;
            int i2516 = ~(((-311) ^ i2515) | ((-311) & i2515));
            int i2517 = ((-311) ^ i2512) | ((-311) & i2512);
            int i2518 = ~i2517;
            int i2519 = (i2516 ^ i2518) | (i2516 & i2518);
            int i2610 = ~((i2515 ^ i2512) | (i2515 & i2512));
            int i2611 = (i2519 ^ i2610) | (i2519 & i2610);
            int i2612 = ~i2512;
            int i2613 = (i2612 ^ 310) | (i2612 & 310);
            int i2614 = ~((i2613 & iIPostMessageServiceStubProxy18) | (i2613 ^ iIPostMessageServiceStubProxy18));
            int i2615 = i2514 + (((i2611 & i2614) | (i2611 ^ i2614)) * 590);
            int i2616 = (~((-311) | i2515)) | (~i2517);
            int i2617 = artificialFrame;
            int i2618 = (i2617 ^ 7) + ((i2617 & 7) << 1);
            getARTIFICIAL_FRAME_PACKAGE_NAME = i2618 % 128;
            int i2619 = i2618 % 2;
            int i2710 = ~(i2515 | i2512);
            int i2711 = (i2615 - (~(-(-((-1180) * ((i2616 & i2710) | (i2616 ^ i2710))))))) - 1;
            int i2712 = ~((i2612 ^ i2515) | (i2612 & i2515));
            int i2713 = ~iIPostMessageServiceStubProxy18;
            int i2714 = (i2711 - (~(-(-((i2712 | (~((i2713 & 310) | (i2713 ^ 310)))) * 590))))) - 1;
            int i2715 = -Drawable.resolveOpacity(0, 0);
            int i2716 = ((i2715 | 14) << 1) - (i2715 ^ 14);
            Object[] objArr318 = new Object[1];
            a(modifierMetaStateMask8, i2714, i2716, objArr318);
            strArr = new String[]{(String) objArr315[0], (String) objArr316[0], (String) objArr317[0], (String) objArr318[0]};
            i13 = 0;
            while (true) {
                if (i13 < 4) {
                    str5 = str4;
                    i14 = i;
                    break;
                }
                Object[] objArr319 = {strArr[i13]};
                objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-11453480);
                if (objAccessartificialFrame18 == null) {
                    int maximumDrawingCacheSize6 = 17 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                    char c44 = (char) (24344 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                    int mirror7 = AndroidCharacter.getMirror('0') + 1966;
                    byte[] bArr28 = $$a;
                    Object[] objArr410 = new Object[1];
                    b((byte) (-bArr28[22]), bArr28[20], (byte) (-bArr28[4]), objArr410);
                    objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize6, c44, mirror7, 1614052816, false, (String) objArr410[0], new Class[]{String.class});
                }
                long jLongValue27 = ((Long) ((Method) objAccessartificialFrame18).invoke(null, objArr319)).longValue();
                long j319 = 255187823;
                int iNextInt5 = new java.util.Random().nextInt();
                strArr11 = strArr;
                long j411 = -500;
                long j412 = (j411 * j319) + (j411 * jLongValue27);
                long j413 = TypedValues.PositionType.TYPE_TRANSITION_EASING;
                long j414 = jLongValue27 ^ j20;
                long j415 = (j414 | j319) ^ j20;
                long j416 = j319 ^ j20;
                i59 = i13;
                long j417 = iNextInt5;
                long j418 = j412 + ((j415 | (((j416 | jLongValue27) | j417) ^ j20)) * j413);
                str5 = str4;
                long j419 = j418 + (((long) 1002) * ((j416 | j414) ^ j20)) + (j413 * ((((j417 ^ j20) | j416) | jLongValue27) ^ j20)) + ((long) 1306943214);
                int startElapsedRealtime5 = (int) Process.getStartElapsedRealtime();
                int i2717 = 1355781082 + ((417151041 | startElapsedRealtime5) * (-50));
                int i2718 = ~((-416094274) | startElapsedRealtime5);
                int i2719 = ~startElapsedRealtime5;
                i60 = ((int) (j419 >> 32)) & (i2717 + ((i2718 | (~((-603981097) | i2719))) * 50) + (((~(i2719 | 417151041)) | (~((-1020075370) | i2719)) | 603981096) * 50));
                int iMyTid4 = Process.myTid();
                int i2810 = ~iMyTid4;
                int i2811 = (~((-1047661337) | i2810)) | 336592896 | (~(1810079549 | i2810));
                i61 = ((int) j419) & ((-292406001) + (((~(iMyTid4 | (-1099011110))) | i2811) * 590) + (i2811 * (-1180)) + (((~((-1810079550) | i2810)) | (~(i2810 | 1047661336))) * 590));
                if (((i61 & i60) | (i60 ^ i61)) != 0) {
                    int i2812 = i59 + 252;
                    i14 = (~(i & i2812)) & (i2812 | i);
                    break;
                }
                int i2813 = (i59 & 59) + (i59 | 59);
                i13 = ((i2813 & (-58)) << 1) + (i2813 ^ (-58));
                strArr = strArr11;
                str4 = str5;
            }
            if (i14 == i) {
                char size7 = (char) (View.MeasureSpec.getSize(0) + 43196);
                int i2910 = artificialFrame;
                int i2911 = ((i2910 | 3) << 1) - (i2910 ^ 3);
                getARTIFICIAL_FRAME_PACKAGE_NAME = i2911 % 128;
                int i2912 = i2911 % 2;
                int i2913 = -(ViewConfiguration.getKeyRepeatTimeout() >> 16);
                int i2914 = (325 & i2913) + (i2913 | 325);
                str6 = str5;
                int i2915 = -TextUtils.getOffsetAfter(str6, 0);
                int i2916 = ((i2915 | 13) << 1) - (i2915 ^ 13);
                Object[] objArr411 = new Object[1];
                a(size7, i2914, i2916, objArr411);
                Object[] objArr412 = {(String) objArr411[0]};
                objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                if (objAccessartificialFrame3 == null) {
                    int iAlpha3 = 23 - Color.alpha(0);
                    char cIndexOf13 = (char) (TextUtils.indexOf((CharSequence) str6, '0', 0) + 1);
                    int edgeSlop6 = 2441 - (ViewConfiguration.getEdgeSlop() >> 16);
                    byte[] bArr29 = $$a;
                    Object[] objArr413 = new Object[1];
                    b((byte) 49, bArr29[16], bArr29[10], objArr413);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iAlpha3, cIndexOf13, edgeSlop6, 954751276, false, (String) objArr413[0], new Class[]{String.class});
                }
                str7 = (String) ((Method) objAccessartificialFrame3).invoke(null, objArr412);
                if (str7 != null) {
                    int i2917 = artificialFrame;
                    int i2918 = ((i2917 | 7) << 1) - (i2917 ^ 7);
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i2918 % 128;
                    int i3010 = i2918 % 2;
                    int i3011 = -(-(ViewConfiguration.getMinimumFlingVelocity() >> 16));
                    int keyRepeatTimeout16 = ViewConfiguration.getKeyRepeatTimeout() >> 16;
                    objArr3 = new Object[1];
                    a((char) ((i3011 ^ 25812) + ((i3011 & 25812) << 1)), (keyRepeatTimeout16 & 338) + (keyRepeatTimeout16 | 338), Color.red(0) + 9, objArr3);
                    if (str7.contains((String) objArr3[0])) {
                        i15 = (~(i & ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION)) & (i | ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
                    } else {
                        i15 = i;
                    }
                } else {
                    i15 = i;
                }
                if (i15 != i) {
                    Object[] objArr414 = {null, new int[1], null, new int[]{i}, new int[]{i15}};
                    int elapsedCpuTime19 = (int) Process.getElapsedCpuTime();
                    int i3012 = (-1676222545) + (((-2634001) | (~elapsedCpuTime19)) * (-490)) + (((~(elapsedCpuTime19 | (-11416946))) | 8782945) * 490) + 982334758;
                    int i3013 = i3 + (((i3012 | 16) << 1) - (i3012 ^ 16));
                    int i3014 = i3013 << 13;
                    int i3015 = ((~i3013) & i3014) | ((~i3014) & i3013);
                    int i3016 = i3015 >>> 17;
                    int i3017 = (i3015 | i3016) & (~(i3015 & i3016));
                    int i3018 = i3017 << 5;
                    ((int[]) objArr414[1])[0] = (i3017 | i3018) & (~(i3017 & i3018));
                    return objArr414;
                }
                char doubleTapTimeout8 = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                int i3019 = -(-Color.rgb(0, 0, 0));
                Object[] objArr415 = new Object[1];
                a(doubleTapTimeout8, (i3019 & 16777563) + (i3019 | 16777563), TextUtils.lastIndexOf(str6, '0', 0) + 18, objArr415);
                String str211 = (String) objArr415[0];
                int i3110 = -Color.rgb(0, 0, 0);
                int keyRepeatTimeout17 = ViewConfiguration.getKeyRepeatTimeout() >> 16;
                int i3111 = (keyRepeatTimeout17 ^ 364) + ((keyRepeatTimeout17 & 364) << 1);
                int i3112 = -TextUtils.lastIndexOf(str6, '0', 0, 0);
                int i3113 = (i3112 ^ 5) + ((i3112 & 5) << 1);
                Object[] objArr416 = new Object[1];
                a((char) (((i3110 | (-16717197)) << 1) - (i3110 ^ (-16717197))), i3111, i3113, objArr416);
                String str212 = (String) objArr416[0];
                file = new File(str211);
                if (file.exists()) {
                    i16 = i;
                } else {
                    i16 = i;
                }
                if (i16 != i) {
                    Object[] objArr417 = {null, new int[1], null, new int[]{i}, new int[]{i16}};
                    int iUptimeMillis7 = (int) SystemClock.uptimeMillis();
                    int i3114 = ~iUptimeMillis7;
                    int i3115 = 909249552 + (((~((-366196766) | i3114)) | 239251692) * 226) + (((~(i3114 | (-294717458))) | (~((-239251693) | iUptimeMillis7)) | 167772384) * (-113)) + ((~(iUptimeMillis7 | (-366196766))) * 113);
                    int i3116 = (i3 - (~(-(-((i3115 & 16) + (i3115 | 16)))))) - 1;
                    int i3117 = i3116 ^ (i3116 << 13);
                    int i3118 = i3117 >>> 17;
                    int i3210 = (i3117 | i3118) & (~(i3117 & i3118));
                    int i3211 = i3210 << 5;
                    ((int[]) objArr417[1])[0] = (i3210 | i3211) & (~(i3210 & i3211));
                    return objArr417;
                }
                char mode2 = (char) (View.MeasureSpec.getMode(0) + 15387);
                int i3212 = -(-(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)));
                Object[] objArr418 = new Object[1];
                a(mode2, (i3212 & 372) + (i3212 | 372), (ViewConfiguration.getEdgeSlop() >> 16) + 23, objArr418);
                Object[] objArr510 = {(String) objArr418[0]};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                if (objAccessartificialFrame4 == null) {
                    int i3213 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 23;
                    char c115 = (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1);
                    int scrollBarFadeDuration3 = 2441 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    byte[] bArr112 = $$a;
                    Object[] objArr511 = new Object[1];
                    b((byte) 49, bArr112[16], bArr112[10], objArr511);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i3213, c115, scrollBarFadeDuration3, 954751276, false, (String) objArr511[0], new Class[]{String.class});
                }
                lowerCase = ((String) ((Method) objAccessartificialFrame4).invoke(null, objArr510)).toLowerCase();
                int i3214 = -(-View.MeasureSpec.getSize(0));
                c = (char) ((i3214 ^ 11468) + ((i3214 & 11468) << 1));
                minimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
                i17 = getARTIFICIAL_FRAME_PACKAGE_NAME + 93;
                artificialFrame = i17 % 128;
                if (i17 % 2 == 0) {
                    int i3215 = 395 % ((minimumFlingVelocity ^ 1) + ((minimumFlingVelocity & 1) << 1));
                    int iGreen6 = Color.green(0);
                    int i3216 = (iGreen6 & 2) + (iGreen6 | 2);
                    Object[] objArr512 = new Object[1];
                    a(c, i3215, i3216, objArr512);
                    obj = objArr512[0];
                } else {
                    int i3217 = -Color.green(0);
                    int i3218 = ((i3217 | 4) << 1) - (i3217 ^ 4);
                    Object[] objArr513 = new Object[1];
                    a(c, (minimumFlingVelocity >> 16) + 395, i3218, objArr513);
                    obj = objArr513[0];
                }
                if (lowerCase.contains((String) obj)) {
                    i18 = (i & (-265)) | (i169 & 264);
                } else {
                    i18 = i;
                }
                if (i18 != i) {
                    Object[] objArr514 = {null, new int[1], null, new int[]{i}, new int[]{i18}};
                    int iNextInt6 = new java.util.Random().nextInt();
                    int i3219 = (-1311348395) + (((~((-2791427) | iNextInt6)) | 608239884) * (-756)) + (((~iNextInt6) | (-2791427)) * 756);
                    int i3310 = -(-(((i3219 | 16) << 1) - (i3219 ^ 16)));
                    int i3311 = ((i3 | i3310) << 1) - (i3 ^ i3310);
                    int i3312 = (i3311 << 13) ^ i3311;
                    int i3313 = i3312 >>> 17;
                    int i3314 = ((~i3312) & i3313) | ((~i3313) & i3312);
                    int i3315 = i3314 << 5;
                    ((int[]) objArr514[1])[0] = (i3314 | i3315) & (~(i3314 & i3315));
                    return objArr514;
                }
                char packedPositionGroup5 = (char) ExpandableListView.getPackedPositionGroup(0L);
                int i3316 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 400;
                int keyRepeatTimeout18 = ViewConfiguration.getKeyRepeatTimeout() >> 16;
                Object[] objArr515 = new Object[1];
                a(packedPositionGroup5, i3316, (keyRepeatTimeout18 & 42) + (keyRepeatTimeout18 | 42), objArr515);
                String str311 = (String) objArr515[0];
                char deadChar14 = (char) KeyEvent.getDeadChar(0, 0);
                int tapTimeout5 = (ViewConfiguration.getTapTimeout() >> 16) + 441;
                int i3317 = -(-AndroidCharacter.getMirror('0'));
                int i3318 = (i3317 & (-8)) + (i3317 | (-8));
                Object[] objArr516 = new Object[1];
                a(deadChar14, tapTimeout5, i3318, objArr516);
                String str312 = (String) objArr516[0];
                Object[] objArr517 = new Object[1];
                a((char) ((-2) - (~(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)))), 481 - KeyEvent.getDeadChar(0, 0), 26 - (~(-TextUtils.indexOf(str6, str6))), objArr517);
                String str313 = (String) objArr517[0];
                char c116 = (char) (16800331 - (~Color.rgb(0, 0, 0)));
                int bitsPerPixel4 = 507 - ImageFormat.getBitsPerPixel(0);
                int i3319 = -(-(Process.myPid() >> 22));
                int i3410 = (i3319 & 27) + (i3319 | 27);
                Object[] objArr518 = new Object[1];
                a(c116, bitsPerPixel4, i3410, objArr518);
                String str314 = (String) objArr518[0];
                int i3411 = -(ViewConfiguration.getMaximumFlingVelocity() >> 16);
                int i3412 = -((byte) KeyEvent.getModifierMetaStateMask());
                int i3413 = (i3412 ^ 534) + ((i3412 & 534) << 1);
                int i3414 = -ExpandableListView.getPackedPositionChild(0L);
                int i3415 = (i3414 ^ 26) + ((i3414 & 26) << 1);
                Object[] objArr519 = new Object[1];
                a((char) (((i3411 | 23606) << 1) - (i3411 ^ 23606)), i3413, i3415, objArr519);
                String str315 = (String) objArr519[0];
                char touchSlop8 = (char) (24565 - (ViewConfiguration.getTouchSlop() >> 8));
                int i3416 = -(-Color.red(0));
                int i3417 = (i3416 ^ 562) + ((i3416 & 562) << 1);
                int iIndexOf22 = TextUtils.indexOf(str6, str6, 0, 0);
                Object[] objArr614 = new Object[1];
                a(touchSlop8, i3417, ((iIndexOf22 | 27) << 1) - (iIndexOf22 ^ 27), objArr614);
                strArr2 = new String[]{str311, str312, str313, str314, str315, (String) objArr614[0]};
                i19 = 0;
                while (true) {
                    if (i19 < 6) {
                        i20 = i;
                        break;
                    }
                    Object[] objArr615 = {strArr2[i19]};
                    objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                    if (objAccessartificialFrame17 == null) {
                        int i3418 = 24 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                        char c117 = (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                        int i3419 = 2441 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                        byte[] bArr113 = $$a;
                        Object[] objArr616 = new Object[1];
                        b((byte) 49, bArr113[16], bArr113[10], objArr616);
                        objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(i3418, c117, i3419, 954751276, false, (String) objArr616[0], new Class[]{String.class});
                    }
                    str14 = (String) ((Method) objAccessartificialFrame17).invoke(null, objArr615);
                    if (str14 == null) {
                    }
                    i19++;
                }
                if (i20 != i) {
                    Object[] objArr617 = {null, new int[]{(i354 | i355) & (~(i354 & i355))}, null, new int[]{i}, new int[]{i20}};
                    int i3513 = 56479429 + (((~(i | 438311253)) | (-1043759712)) * (-948)) + ((~((-605454859) | i169)) * (-948)) + 1647795148;
                    int i3514 = i3 + (((i3513 | 16) << 1) - (i3513 ^ 16));
                    int i3515 = i3514 << 13;
                    int i3516 = (i3514 | i3515) & (~(i3514 & i3515));
                    int i3517 = i3516 ^ (i3516 >>> 17);
                    int i3518 = i3517 << 5;
                    return objArr617;
                }
                char offsetBefore5 = (char) TextUtils.getOffsetBefore(str6, 0);
                int iLastIndexOf5 = TextUtils.lastIndexOf(str6, '0', 0);
                Object[] objArr618 = new Object[1];
                a(offsetBefore5, (iLastIndexOf5 ^ 348) + ((iLastIndexOf5 & 348) << 1), 17 - (Process.myPid() >> 22), objArr618);
                String str316 = (String) objArr618[0];
                char c118 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                int i3519 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                Object[] objArr619 = new Object[1];
                a(c118, (i3519 & 589) + (i3519 | 589), 6 - (~TextUtils.lastIndexOf(str6, '0', 0, 0)), objArr619);
                String str317 = (String) objArr619[0];
                file2 = new File(str316);
                if (file2.exists()) {
                    char cResolveSize5 = (char) View.resolveSize(0, 0);
                    int i35110 = -(-(ViewConfiguration.getMaximumFlingVelocity() >> 16));
                    int i35111 = ((i35110 | 595) << 1) - (i35110 ^ 595);
                    int iIndexOf23 = TextUtils.indexOf((CharSequence) str6, '0', 0, 0);
                    int i35112 = ((iIndexOf23 | 14) << 1) - (iIndexOf23 ^ 14);
                    Object[] objArr6110 = new Object[1];
                    a(cResolveSize5, i35111, i35112, objArr6110);
                    String str318 = (String) objArr6110[0];
                    char packedPositionType6 = (char) ExpandableListView.getPackedPositionType(0L);
                    int i3614 = -(ViewConfiguration.getDoubleTapTimeout() >> 16);
                    Object[] objArr6111 = new Object[1];
                    a(packedPositionType6, (i3614 ^ TypedValues.MotionType.TYPE_DRAW_PATH) + ((i3614 & TypedValues.MotionType.TYPE_DRAW_PATH) << 1), 8 - (~(-(-View.MeasureSpec.getSize(0)))), objArr6111);
                    Object[] objArr6112 = {str318, (String) objArr6111[0]};
                    objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-883653127);
                    if (objAccessartificialFrame5 == null) {
                        int iIndexOf24 = TextUtils.indexOf(str6, str6) + 31;
                        char deadChar15 = (char) (57022 - KeyEvent.getDeadChar(0, 0));
                        int fadingEdgeLength3 = 2311 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                        byte[] bArr114 = $$a;
                        Object[] objArr6113 = new Object[1];
                        b((byte) (bArr114[13] - 1), (byte) (-bArr114[4]), bArr114[10], objArr6113);
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iIndexOf24, deadChar15, fadingEdgeLength3, 1412547569, false, (String) objArr6113[0], new Class[]{String.class, String.class});
                    }
                    long jLongValue28 = ((Long) ((Method) objAccessartificialFrame5).invoke(null, objArr6112)).longValue();
                    int i3615 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i3616 = (i3615 ^ 57) + ((i3615 & 57) << 1);
                    artificialFrame = i3616 % 128;
                    int i3617 = i3616 % 2;
                    long j4110 = 736527736;
                    long j510 = -495;
                    long j511 = j4110 ^ j20;
                    long jElapsedRealtime6 = (int) SystemClock.elapsedRealtime();
                    long j512 = ((j511 | (jLongValue28 ^ j20)) ^ j20) | ((j511 | jElapsedRealtime6) ^ j20);
                    j = (j510 * j4110) + (j510 * jLongValue28) + (((long) 992) * j512) + (((long) (-496)) * (j512 | ((((jElapsedRealtime6 ^ j20) | j4110) | jLongValue28) ^ j20))) + (((long) 496) * (jLongValue28 | jElapsedRealtime6)) + ((long) (-891279365));
                    int iUptimeMillis8 = (int) SystemClock.uptimeMillis();
                    i21 = ((int) (j >> 32)) & ((-2072279902) + ((~((~iUptimeMillis8) | (-806881898))) * (-116)) + (((-1914215020) | iUptimeMillis8) * 116) + (((~(iUptimeMillis8 | 943525865)) | (-2050858988)) * 116));
                    i22 = 818884229 + (((~(1725358459 | i)) | 287836800 | (~((-288132050) | i))) * (-880));
                    i23 = (~(1725358459 | i169)) | 288132049;
                    i24 = ~((-1725358460) | i);
                    if ((i21 | (((int) j) & (i22 + ((i23 | i24) * (-880)) + (i24 * 880)))) != 0) {
                        i25 = i ^ 261;
                    } else {
                        i25 = i;
                    }
                } else {
                    char cResolveSize6 = (char) View.resolveSize(0, 0);
                    int i35113 = -(-(ViewConfiguration.getMaximumFlingVelocity() >> 16));
                    int i35114 = ((i35113 | 595) << 1) - (i35113 ^ 595);
                    int iIndexOf25 = TextUtils.indexOf((CharSequence) str6, '0', 0, 0);
                    int i35115 = ((iIndexOf25 | 14) << 1) - (iIndexOf25 ^ 14);
                    Object[] objArr6114 = new Object[1];
                    a(cResolveSize6, i35114, i35115, objArr6114);
                    String str319 = (String) objArr6114[0];
                    char packedPositionType7 = (char) ExpandableListView.getPackedPositionType(0L);
                    int i3618 = -(ViewConfiguration.getDoubleTapTimeout() >> 16);
                    Object[] objArr6115 = new Object[1];
                    a(packedPositionType7, (i3618 ^ TypedValues.MotionType.TYPE_DRAW_PATH) + ((i3618 & TypedValues.MotionType.TYPE_DRAW_PATH) << 1), 8 - (~(-(-View.MeasureSpec.getSize(0)))), objArr6115);
                    Object[] objArr6116 = {str319, (String) objArr6115[0]};
                    objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-883653127);
                    if (objAccessartificialFrame5 == null) {
                        int iIndexOf26 = TextUtils.indexOf(str6, str6) + 31;
                        char deadChar16 = (char) (57022 - KeyEvent.getDeadChar(0, 0));
                        int fadingEdgeLength4 = 2311 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                        byte[] bArr115 = $$a;
                        Object[] objArr6117 = new Object[1];
                        b((byte) (bArr115[13] - 1), (byte) (-bArr115[4]), bArr115[10], objArr6117);
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iIndexOf26, deadChar16, fadingEdgeLength4, 1412547569, false, (String) objArr6117[0], new Class[]{String.class, String.class});
                    }
                    long jLongValue29 = ((Long) ((Method) objAccessartificialFrame5).invoke(null, objArr6116)).longValue();
                    int i3619 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i36110 = (i3619 ^ 57) + ((i3619 & 57) << 1);
                    artificialFrame = i36110 % 128;
                    int i36111 = i36110 % 2;
                    long j4111 = 736527736;
                    long j513 = -495;
                    long j514 = j4111 ^ j20;
                    long jElapsedRealtime7 = (int) SystemClock.elapsedRealtime();
                    long j515 = ((j514 | (jLongValue29 ^ j20)) ^ j20) | ((j514 | jElapsedRealtime7) ^ j20);
                    j = (j513 * j4111) + (j513 * jLongValue29) + (((long) 992) * j515) + (((long) (-496)) * (j515 | ((((jElapsedRealtime7 ^ j20) | j4111) | jLongValue29) ^ j20))) + (((long) 496) * (jLongValue29 | jElapsedRealtime7)) + ((long) (-891279365));
                    int iUptimeMillis9 = (int) SystemClock.uptimeMillis();
                    i21 = ((int) (j >> 32)) & ((-2072279902) + ((~((~iUptimeMillis9) | (-806881898))) * (-116)) + (((-1914215020) | iUptimeMillis9) * 116) + (((~(iUptimeMillis9 | 943525865)) | (-2050858988)) * 116));
                    i22 = 818884229 + (((~(1725358459 | i)) | 287836800 | (~((-288132050) | i))) * (-880));
                    i23 = (~(1725358459 | i169)) | 288132049;
                    i24 = ~((-1725358460) | i);
                    if ((i21 | (((int) j) & (i22 + ((i23 | i24) * (-880)) + (i24 * 880)))) != 0) {
                        i25 = i ^ 261;
                    } else {
                        i25 = i;
                    }
                }
                if (i25 != i) {
                    Object[] objArr710 = {null, new int[]{((~i379) & i380) | ((~i380) & i379)}, null, new int[]{i}, new int[]{i25}};
                    int i3710 = 824145913 + (((~((-140802648) | i)) | 136342034 | (~((-464645811) | i))) * (-880));
                    int i3711 = (~(i169 | (-140802648))) | 464645810;
                    int i3712 = ~(i | 140802647);
                    int i3713 = i3710 + ((i3711 | i3712) * (-880)) + (i3712 * 880);
                    int i3714 = -(-((i3713 ^ 16) + ((i3713 & 16) << 1)));
                    int i3715 = (i3 & i3714) + (i3 | i3714);
                    int i3716 = i3715 << 13;
                    int i3717 = (i3716 & (~i3715)) | ((~i3716) & i3715);
                    int i3718 = i3717 >>> 17;
                    int i3719 = (i3717 | i3718) & (~(i3717 & i3718));
                    int i3810 = i3719 << 5;
                    return objArr710;
                }
                objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-913150042);
                if (objAccessartificialFrame6 == null) {
                    int doubleTapTimeout9 = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 28;
                    char threadPriority6 = (char) ((Process.getThreadPriority(0) + 20) >> 6);
                    int iLastIndexOf6 = 763 - TextUtils.lastIndexOf(str6, '0', 0);
                    byte[] bArr116 = $$a;
                    byte b20 = (byte) (bArr116[13] - 1);
                    Object[] objArr711 = new Object[1];
                    b(b20, (byte) (b20 >>> 2), bArr116[16], objArr711);
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout9, threadPriority6, iLastIndexOf6, 1459038638, false, (String) objArr711[0], new Class[0]);
                }
                long jLongValue30 = ((Long) ((Method) objAccessartificialFrame6).invoke(null, null)).longValue();
                long j516 = 936725282;
                long j517 = 140;
                long j518 = (j516 ^ j20) | jLongValue30;
                long j519 = (((long) 141) * j516) + (((long) (-279)) * jLongValue30) + ((jLongValue30 | j19) * j517) + (((long) (-280)) * ((j518 ^ j20) | ((j21 | jLongValue30) ^ j20))) + (j517 * ((((jLongValue30 ^ j20) | j516) ^ j20) | ((j21 | j516) ^ j20) | ((j518 | j19) ^ j20))) + ((long) 1001876370);
                int elapsedCpuTime20 = (int) Process.getElapsedCpuTime();
                int i3811 = (~((-212443641) | elapsedCpuTime20)) | 134259120;
                int i3812 = ~((~elapsedCpuTime20) | 1302967290);
                i26 = ((int) (j519 >> 32)) & (114503370 + ((i3811 | i3812) * (-470)) + (((~(elapsedCpuTime20 | (-78184521))) | i3812) * 470));
                int iElapsedRealtime4 = (int) SystemClock.elapsedRealtime();
                i27 = ((int) j519) & (876805573 + (((~(1062883193 | (~iElapsedRealtime4))) | (~((-374343217) | iElapsedRealtime4))) * (-272)) + (((~(911738481 | iElapsedRealtime4)) | 151144712) * (-272)) + (((~(iElapsedRealtime4 | (-911738482))) | (-525487929)) * 272));
                if (((i26 & i27) | (i26 ^ i27)) == 1) {
                    Object[] objArr712 = {null, new int[]{i388 ^ (i388 << 5)}, null, new int[]{i}, new int[]{i}};
                    int i3813 = (~(171932929 | i169)) | 608207370;
                    int i3814 = ~(i | (-2758913));
                    int i3815 = (i3 - (~((((i3813 | i3814) * (-252)) - 745116959) + ((i3814 | (~(i169 | 780140299))) * 252)))) - 1;
                    int i3816 = i3815 << 13;
                    int i3817 = ((~i3815) & i3816) | ((~i3816) & i3815);
                    int i3818 = i3817 ^ (i3817 >>> 17);
                    return objArr712;
                }
                Object[] objArr713 = {1};
                objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(1671772348);
                if (objAccessartificialFrame7 == null) {
                    int i3819 = 19 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                    char cRed2 = (char) Color.red(0);
                    int iIndexOf27 = 1573 - TextUtils.indexOf(str6, str6, 0);
                    byte[] bArr117 = $$a;
                    byte b21 = bArr117[16];
                    Object[] objArr714 = new Object[1];
                    b(b21, bArr117[7], b21, objArr714);
                    objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(i3819, cRed2, iIndexOf27, -54493516, false, (String) objArr714[0], new Class[]{Integer.TYPE});
                }
                long jLongValue110 = ((Long) ((Method) objAccessartificialFrame7).invoke(null, objArr713)).longValue();
                long j610 = -998325424;
                long j611 = (((long) (-244)) * j610) + (((long) 246) * jLongValue110);
                long j612 = -245;
                long j613 = jLongValue110 ^ j20;
                long j614 = j611 + ((((j613 | j21) ^ j20) | ((j613 | j610) ^ j20)) * j612);
                long j615 = (j613 | j19) ^ j20;
                long j616 = j614 + (j612 * j615) + (((long) 245) * (j615 | j610)) + ((long) 1482910141);
                int i3910 = ~((-1795993737) | i169);
                i28 = ((int) (j616 >> 32)) & ((((-2137979614) | i3910 | (~(1795993736 | i))) * (-338)) + 354622606 + ((i3910 | (~((-341985878) | i))) * 338));
                int startUptimeMillis3 = (int) Process.getStartUptimeMillis();
                int i3911 = ~((-420937154) | startUptimeMillis3);
                i29 = ((int) j616) & (590333378 + ((17082369 | i3911) * (-814)) + ((i3911 | (~((~startUptimeMillis3) | 1016289256)) | 612434472) * 407) + (((~(startUptimeMillis3 | (-1016289257))) | (~(420937153 | startUptimeMillis3)) | 612434472) * 407));
                if (((i28 & i29) | (i28 ^ i29)) != 0) {
                    int i3912 = (~(i & 220)) & (i | 220);
                    int i3913 = artificialFrame + 41;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i3913 % 128;
                    int i3914 = i3913 % 2;
                    i30 = i3912;
                } else {
                    i30 = i;
                }
                if (i30 != i) {
                    Object[] objArr715 = {null, new int[]{i400 ^ (i400 << 5)}, null, new int[]{i}, new int[]{i30}};
                    int i3915 = (-55989948) + (((~(i169 | (-177550748))) | 1319194 | (~((-606767653) | i))) * 717) + (((~(i | (-177550748))) | (~(i169 | (-606767653))) | 1319194) * 717);
                    int i3916 = i3 + (i3915 ^ 16) + ((i3915 & 16) << 1);
                    int i3917 = i3916 << 13;
                    int i3918 = ((~i3916) & i3917) | ((~i3917) & i3916);
                    int i3919 = i3918 >>> 17;
                    int i4016 = (i3918 | i3919) & (~(i3918 & i3919));
                    return objArr715;
                }
                Object[] objArr716 = new Object[1];
                a((char) (15387 - TextUtils.getTrimmedLength(str6)), 371 - (~(-(-(ViewConfiguration.getPressedStateDuration() >> 16)))), 23 - ExpandableListView.getPackedPositionType(0L), objArr716);
                Object[] objArr717 = {(String) objArr716[0]};
                objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                if (objAccessartificialFrame8 == null) {
                    int keyRepeatDelay16 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 23;
                    char keyRepeatDelay17 = (char) (ViewConfiguration.getKeyRepeatDelay() >> 16);
                    int i4017 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 2440;
                    byte[] bArr118 = $$a;
                    Object[] objArr718 = new Object[1];
                    b((byte) 49, bArr118[16], bArr118[10], objArr718);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay16, keyRepeatDelay17, i4017, 954751276, false, (String) objArr718[0], new Class[]{String.class});
                }
                objInvoke = ((Method) objAccessartificialFrame8).invoke(null, objArr717);
                if (objInvoke != null) {
                    Object[] objArr818 = {objInvoke, 42};
                    objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-287841710);
                    if (objAccessartificialFrame16 == null) {
                        int threadPriority7 = ((Process.getThreadPriority(0) + 20) >> 6) + 20;
                        char c119 = (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
                        int i4018 = 2246 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                        byte[] bArr119 = $$a;
                        Object[] objArr819 = new Object[1];
                        b((byte) (-bArr119[22]), bArr119[6], bArr119[10], objArr819);
                        objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(threadPriority7, c119, i4018, 1907532890, false, (String) objArr819[0], new Class[]{String.class, Integer.TYPE});
                    }
                    long jLongValue111 = ((Long) ((Method) objAccessartificialFrame16).invoke(null, objArr818)).longValue();
                    long j617 = 1571493321;
                    long j618 = -919;
                    long j619 = (j618 * j617) + (j618 * jLongValue111);
                    long j720 = 920;
                    long j721 = j617 ^ j20;
                    long j722 = jLongValue111 ^ j20;
                    long j723 = j721 | j722;
                    long jMaxMemory2 = (int) Runtime.getRuntime().maxMemory();
                    long j724 = jMaxMemory2 ^ j20;
                    long j725 = j619 + ((((j723 | jMaxMemory2) ^ j20) | (((j722 | j724) | j617) ^ j20)) * j720) + (((j723 ^ j20) | ((j721 | j724) ^ j20)) * j720) + (j720 * (((jMaxMemory2 | (j722 | j617)) ^ j20) | ((j723 | j724) ^ j20) | (((j721 | jLongValue111) | jMaxMemory2) ^ j20))) + ((long) 61592007);
                    int startElapsedRealtime6 = (int) Process.getStartElapsedRealtime();
                    int i4019 = ~startElapsedRealtime6;
                    i57 = ((int) (j725 >> 32)) & ((-1216029393) + (((~((-584777224) | i4019)) | 1091588) * 98) + (((~(i4019 | (-852449188))) | (-584777224) | (~(852449187 | startElapsedRealtime6))) * (-49)) + (((~(startElapsedRealtime6 | (-584777224))) | (-853540776)) * 49));
                    int iFreeMemory4 = (int) Runtime.getRuntime().freeMemory();
                    i58 = ((int) j725) & ((-496495881) + (((~((~iFreeMemory4) | (-268445825))) | (~((-46405121) | iFreeMemory4))) * (-302)) + ((~((-268445825) | iFreeMemory4)) * (-604)) + (((~(iFreeMemory4 | (-314850945))) | 1075970345) * 302));
                    if (((i57 & i58) | (i57 ^ i58)) == 1986687685) {
                        str9 = str6;
                        i39 = 0;
                        i31 = -1;
                        c2 = 6;
                    } else {
                        int i40110 = -(Process.myPid() >> 22);
                        Object[] objArr8110 = new Object[1];
                        a((char) ((i40110 & 15387) + (i40110 | 15387)), 371 - (~(-(Process.myPid() >> 22))), KeyEvent.keyCodeFromString(str6) + 23, objArr8110);
                        String str3110 = (String) objArr8110[0];
                        char c1110 = (char) (19553 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                        int i40111 = 617 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                        int i40112 = -(-ExpandableListView.getPackedPositionGroup(0L));
                        int i40113 = (i40112 ^ 10) + ((i40112 & 10) << 1);
                        Object[] objArr8111 = new Object[1];
                        a(c1110, i40111, i40113, objArr8111);
                        String str4110 = (String) objArr8111[0];
                        char c1111 = (char) (23046 - (~Color.green(0)));
                        int i40114 = 627 - (~TextUtils.indexOf((CharSequence) str6, '0', 0, 0));
                        int i40115 = -KeyEvent.keyCodeFromString(str6);
                        int i41110 = (i40115 & 7) + (i40115 | 7);
                        Object[] objArr8112 = new Object[1];
                        a(c1111, i40114, i41110, objArr8112);
                        String str4111 = (String) objArr8112[0];
                        Object[] objArr8113 = new Object[1];
                        a((char) Gravity.getAbsoluteGravity(0, 0), 633 - (~(-(KeyEvent.getMaxKeyCode() >> 16))), 7 - (~(-(-(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))))), objArr8113);
                        char c1112 = (char) ((-2) - ((-(-(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)))) ^ (-1)));
                        int iIndexOf110 = TextUtils.indexOf(str6, str6, 0, 0);
                        int i41111 = ((iIndexOf110 | 642) << 1) - (iIndexOf110 ^ 642);
                        int i41112 = -(ViewConfiguration.getPressedStateDuration() >> 16);
                        int i41113 = (i41112 ^ 17) + ((i41112 & 17) << 1);
                        Object[] objArr8114 = new Object[1];
                        a(c1112, i41111, i41113, objArr8114);
                        String str4112 = (String) objArr8114[0];
                        char windowTouchSlop5 = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                        int i41114 = -(ViewConfiguration.getLongPressTimeout() >> 16);
                        int i41115 = (i41114 & 659) + (i41114 | 659);
                        int i41116 = -(-(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                        int i41117 = ((i41116 | 6) << 1) - (i41116 ^ 6);
                        Object[] objArr8115 = new Object[1];
                        a(windowTouchSlop5, i41115, i41117, objArr8115);
                        String str4113 = (String) objArr8115[0];
                        char cIndexOf14 = (char) TextUtils.indexOf(str6, str6, 0, 0);
                        int i41118 = -Color.red(0);
                        int iIPostMessageServiceStubProxy19 = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                        int i41119 = ~i41118;
                        int i42110 = ~iIPostMessageServiceStubProxy19;
                        int i42111 = ~(i41119 | i42110);
                        int i42112 = ~(((-667) ^ iIPostMessageServiceStubProxy19) | ((-667) & iIPostMessageServiceStubProxy19));
                        int i42113 = (((i41118 * (-574)) - 382284) - (~(((i42111 ^ i42112) | (i42111 & i42112)) * 1150))) - 1;
                        int i42114 = ~(((-667) ^ iIPostMessageServiceStubProxy19) | ((-667) & iIPostMessageServiceStubProxy19));
                        int i42115 = ~((i42110 & 666) | (i42110 ^ 666));
                        int i42116 = -(-(((i42115 & i42114) | (i42114 ^ i42115)) * (-575)));
                        int i42117 = (i42113 ^ i42116) + ((i42116 & i42113) << 1);
                        int i42118 = ~(i41119 | iIPostMessageServiceStubProxy19);
                        int i42119 = ~((i41118 & i42110) | (i42110 ^ i41118));
                        int i43110 = ((i42118 & i42119) | (i42118 ^ i42119)) * 575;
                        int i43111 = ((i42117 | i43110) << 1) - (i43110 ^ i42117);
                        int i43112 = -TextUtils.lastIndexOf(str6, '0', 0);
                        int i43113 = ((i43112 | 6) << 1) - (i43112 ^ 6);
                        Object[] objArr8116 = new Object[1];
                        a(cIndexOf14, i43111, i43113, objArr8116);
                        String str4114 = (String) objArr8116[0];
                        int i43114 = -(ViewConfiguration.getFadingEdgeLength() >> 16);
                        Object[] objArr8117 = new Object[1];
                        a((char) ((i43114 & 32918) + (i43114 | 32918)), 672 - (~(-View.MeasureSpec.makeMeasureSpec(0, 0))), 10 - (~(-(ViewConfiguration.getKeyRepeatTimeout() >> 16))), objArr8117);
                        String str4115 = (String) objArr8117[0];
                        char c1113 = (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 4546);
                        int i43115 = -(-(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
                        int i43116 = ((i43115 | 683) << 1) - (i43115 ^ 683);
                        int longPressTimeout9 = ViewConfiguration.getLongPressTimeout() >> 16;
                        int i43117 = ((longPressTimeout9 | 14) << 1) - (longPressTimeout9 ^ 14);
                        Object[] objArr9110 = new Object[1];
                        a(c1113, i43116, i43117, objArr9110);
                        char cIndexOf15 = (char) TextUtils.indexOf(str6, str6);
                        int i43118 = -(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                        int i43119 = (i43118 ^ 698) + ((i43118 & 698) << 1);
                        int i44110 = -(KeyEvent.getMaxKeyCode() >> 16);
                        int i44111 = (i44110 ^ 16) + ((i44110 & 16) << 1);
                        Object[] objArr9111 = new Object[1];
                        a(cIndexOf15, i43119, i44111, objArr9111);
                        String str4116 = (String) objArr9111[0];
                        int i44112 = -(-(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)));
                        Object[] objArr9112 = new Object[1];
                        a((char) ((i44112 ^ 21512) + ((i44112 & 21512) << 1)), 714 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (ViewConfiguration.getScrollBarSize() >> 8) + 3, objArr9112);
                        String str4117 = (String) objArr9112[0];
                        char cResolveSize7 = (char) (22992 - View.resolveSize(0, 0));
                        int offsetAfter6 = TextUtils.getOffsetAfter(str6, 0);
                        int i44113 = ((offsetAfter6 | 725) << 1) - (offsetAfter6 ^ 725);
                        int iMyTid5 = Process.myTid() >> 22;
                        int i44114 = (iMyTid5 ^ 22) + ((iMyTid5 & 22) << 1);
                        Object[] objArr9113 = new Object[1];
                        a(cResolveSize7, i44113, i44114, objArr9113);
                        String str4118 = (String) objArr9113[0];
                        Object[] objArr9114 = new Object[1];
                        a((char) Color.argb(0, 0, 0, 0), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 747, 24 - (~(-(-(ViewConfiguration.getEdgeSlop() >> 16)))), objArr9114);
                        String str4119 = (String) objArr9114[0];
                        char edgeSlop7 = (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 30699);
                        int i44115 = -(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                        int i44116 = (i44115 * (-317)) + 246587;
                        int i44117 = ~i44115;
                        int i44118 = (i44117 ^ (-774)) | (i44117 & (-774));
                        int i44119 = ~((i44118 & i) | (i44118 ^ i));
                        int i45110 = ~((i169 ^ i44115) | (i169 & i44115) | 773);
                        int i45111 = ((i44119 ^ i45110) | (i44119 & i45110)) * (-318);
                        int i45112 = ((i44116 | i45111) << 1) - (i45111 ^ i44116);
                        int i45113 = ~(((-774) & i44115) | ((-774) ^ i44115));
                        int i45114 = ~((i44115 & i) | (i44115 ^ i));
                        int i45115 = -(-(((i45114 & i45113) | (i45113 ^ i45114)) * (-318)));
                        int i45116 = (i45112 & i45115) + (i45115 | i45112);
                        int i45117 = ~(i44117 | i);
                        int i45118 = -(-(((i45117 & (-774)) | ((-774) ^ i45117)) * TypedValues.AttributesType.TYPE_PIVOT_TARGET));
                        Object[] objArr9115 = new Object[1];
                        a(edgeSlop7, (i45116 & i45118) + (i45118 | i45116), 28 - (Process.myPid() >> 22), objArr9115);
                        String str5110 = (String) objArr9115[0];
                        c2 = 6;
                        i31 = -1;
                        int i45119 = artificialFrame + 85;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i45119 % 128;
                        int i46110 = i45119 % 2;
                        int i46111 = -(-(ViewConfiguration.getKeyRepeatTimeout() >> 16));
                        int i46112 = -(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                        int iIPostMessageServiceStubProxy110 = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                        int i46113 = i46112 * 989;
                        int i46114 = (i46113 ^ (-789600)) + ((i46113 & (-789600)) << 1);
                        int i46115 = ~iIPostMessageServiceStubProxy110;
                        int i46116 = ~(((-801) ^ i46115) | (i46115 & (-801)) | i46112);
                        int i46117 = (i46112 & LogSeverity.EMERGENCY_VALUE) | (i46112 ^ LogSeverity.EMERGENCY_VALUE);
                        int i46118 = ~((i46117 & iIPostMessageServiceStubProxy110) | (i46117 ^ iIPostMessageServiceStubProxy110));
                        int i46119 = ((i46118 & i46116) | (i46116 ^ i46118)) * 988;
                        int i47110 = (((i46114 | i46119) << 1) - (i46119 ^ i46114)) + (((i46112 ^ (-801)) | (i46112 & (-801))) * (-988));
                        int i47111 = ~i46112;
                        int i47112 = ~((i47111 & (-801)) | (i47111 ^ (-801)));
                        int i47113 = ~(((-801) & iIPostMessageServiceStubProxy110) | ((-801) ^ iIPostMessageServiceStubProxy110));
                        int i47114 = (i47112 & i47113) | (i47112 ^ i47113);
                        int i47115 = ~iIPostMessageServiceStubProxy110;
                        int i47116 = ~((i46112 & i47115) | (i47115 ^ i46112) | LogSeverity.EMERGENCY_VALUE);
                        Object[] objArr9116 = new Object[1];
                        a((char) ((i46111 & 11772) + (i46111 | 11772)), (i47110 - (~(((i47114 & i47116) | (i47114 ^ i47116)) * 988))) - 1, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 11, objArr9116);
                        char maxKeyCode4 = (char) (KeyEvent.getMaxKeyCode() >> 16);
                        int i47117 = -View.MeasureSpec.getSize(0);
                        Object[] objArr9117 = new Object[1];
                        a(maxKeyCode4, (i47117 ^ 811) + ((i47117 & 811) << 1), 7 - (~(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), objArr9117);
                        int i47118 = -(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                        int i47119 = -(-View.resolveSizeAndState(0, 0, 0));
                        int i48110 = ((i47119 | 819) << 1) - (i47119 ^ 819);
                        int i48111 = -TextUtils.getCapsMode(str6, 0, 0);
                        int i48112 = (i48111 & 6) + (i48111 | 6);
                        Object[] objArr9118 = new Object[1];
                        a((char) ((i47118 & 45437) + (i47118 | 45437)), i48110, i48112, objArr9118);
                        char mirror8 = (char) (AndroidCharacter.getMirror('0') + 35699);
                        int i48113 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                        int i48114 = (i48113 & 824) + (i48113 | 824);
                        int i48115 = -(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                        int i48116 = ((i48115 | 6) << 1) - (i48115 ^ 6);
                        Object[] objArr9119 = new Object[1];
                        a(mirror8, i48114, i48116, objArr9119);
                        String[] strArr110 = {(String) objArr9116[0], (String) objArr9117[0], (String) objArr9118[0], (String) objArr9119[0]};
                        int i48117 = -(-Color.rgb(0, 0, 0));
                        int i48118 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                        int i48119 = -(-(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)));
                        int i49110 = (i48119 & 16) + (i48119 | 16);
                        Object[] objArr10110 = new Object[1];
                        a((char) ((i48117 ^ 16777216) + ((i48117 & 16777216) << 1)), (i48118 ^ 830) + ((i48118 & 830) << 1), i49110, objArr10110);
                        String str5111 = (String) objArr10110[0];
                        int i49111 = -(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                        Object[] objArr10111 = new Object[1];
                        a((char) ((i49111 & 1) + (i49111 | 1)), ImageFormat.getBitsPerPixel(0) + 667, 8 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), objArr10111);
                        String str5112 = (String) objArr10111[0];
                        Object[] objArr10112 = new Object[1];
                        a((char) Color.blue(0), 633 - (~(ViewConfiguration.getMinimumFlingVelocity() >> 16)), Color.rgb(0, 0, 0) + 16777224, objArr10112);
                        Object[] objArr10113 = new Object[1];
                        a((char) (28597 - TextUtils.lastIndexOf(str6, '0', 0)), View.combineMeasuredStates(0, 0) + 847, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 13, objArr10113);
                        String str5113 = (String) objArr10113[0];
                        char scrollBarSize7 = (char) (9602 - (ViewConfiguration.getScrollBarSize() >> 8));
                        int i49112 = -(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                        int i49113 = (i49112 & 861) + (i49112 | 861);
                        int i49114 = -View.MeasureSpec.getSize(0);
                        int i49115 = (i49114 & 1) + (i49114 | 1);
                        Object[] objArr10114 = new Object[1];
                        a(scrollBarSize7, i49113, i49115, objArr10114);
                        char modifierMetaStateMask9 = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 53314);
                        int i49116 = -(-TextUtils.getOffsetAfter(str6, 0));
                        Object[] objArr10115 = new Object[1];
                        a(modifierMetaStateMask9, (i49116 & 862) + (i49116 | 862), 9 - KeyEvent.getDeadChar(0, 0), objArr10115);
                        String str5114 = (String) objArr10115[0];
                        char c1114 = (char) ((-2) - (~(-(-(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))))));
                        int i49117 = -AndroidCharacter.getMirror('0');
                        int size8 = View.MeasureSpec.getSize(0);
                        int i49118 = ((size8 | 1) << 1) - (size8 ^ 1);
                        Object[] objArr10116 = new Object[1];
                        a(c1114, ((i49117 | 919) << 1) - (i49117 ^ 919), i49118, objArr10116);
                        char c2110 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 29745);
                        int i49119 = -(-TextUtils.indexOf((CharSequence) str6, '0', 0, 0));
                        int i50110 = ((i49119 | 873) << 1) - (i49119 ^ 873);
                        int i50111 = -TextUtils.indexOf((CharSequence) str6, '0');
                        int i50112 = ((i50111 | 15) << 1) - (i50111 ^ 15);
                        Object[] objArr10117 = new Object[1];
                        a(c2110, i50110, i50112, objArr10117);
                        String str5115 = (String) objArr10117[0];
                        char c2111 = (char) (21511 - (~ExpandableListView.getPackedPositionType(0L)));
                        int longPressTimeout10 = ViewConfiguration.getLongPressTimeout() >> 16;
                        int i50113 = (longPressTimeout10 & 714) + (longPressTimeout10 | 714);
                        int i50114 = -(Process.myPid() >> 22);
                        int i50115 = (i50114 ^ 3) + ((i50114 & 3) << 1);
                        Object[] objArr10118 = new Object[1];
                        a(c2111, i50113, i50115, objArr10118);
                        String str5116 = (String) objArr10118[0];
                        char maximumDrawingCacheSize7 = (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                        int i50116 = -(-TextUtils.indexOf((CharSequence) str6, '0', 0, 0));
                        int i50117 = ((i50116 | 660) << 1) - (i50116 ^ 660);
                        int i50118 = -View.getDefaultSize(0, 0);
                        int i50119 = (i50118 & 7) + (i50118 | 7);
                        Object[] objArr10119 = new Object[1];
                        a(maximumDrawingCacheSize7, i50117, i50119, objArr10119);
                        String str5117 = (String) objArr10119[0];
                        int i51110 = -View.resolveSize(0, 0);
                        int i51111 = -(-ExpandableListView.getPackedPositionType(0L));
                        Object[] objArr11110 = new Object[1];
                        a((char) ((i51110 ^ 30213) + ((i51110 & 30213) << 1)), (i51111 ^ com.salesforce.marketingcloud.analytics.b.q) + ((i51111 & com.salesforce.marketingcloud.analytics.b.q) << 1), TextUtils.getCapsMode(str6, 0, 0) + 8, objArr11110);
                        String str5118 = (String) objArr11110[0];
                        int i51112 = -MotionEvent.axisFromString(str6);
                        int i51113 = 671 - (~(-(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))));
                        int doubleTapTimeout10 = ViewConfiguration.getDoubleTapTimeout() >> 16;
                        int i51114 = (doubleTapTimeout10 ^ 11) + ((doubleTapTimeout10 & 11) << 1);
                        Object[] objArr11111 = new Object[1];
                        a((char) ((i51112 ^ 32917) + ((i51112 & 32917) << 1)), i51113, i51114, objArr11111);
                        String str5119 = (String) objArr11111[0];
                        int i51115 = -View.resolveSizeAndState(0, 0, 0);
                        int i51116 = 683 - (~(-(-(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))));
                        int edgeSlop8 = ViewConfiguration.getEdgeSlop() >> 16;
                        Object[] objArr11112 = new Object[1];
                        a((char) (((i51115 | 4547) << 1) - (i51115 ^ 4547)), i51116, (edgeSlop8 & 14) + (edgeSlop8 | 14), objArr11112);
                        char modifierMetaStateMask10 = (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask()));
                        int i51117 = -TextUtils.indexOf((CharSequence) str6, '0', 0, 0);
                        int i51118 = (i51117 & 895) + (i51117 | 895);
                        int longPressTimeout11 = ViewConfiguration.getLongPressTimeout() >> 16;
                        int i51119 = ((longPressTimeout11 | 20) << 1) - (longPressTimeout11 ^ 20);
                        Object[] objArr11113 = new Object[1];
                        a(modifierMetaStateMask10, i51118, i51119, objArr11113);
                        String str6110 = (String) objArr11113[0];
                        char offsetAfter7 = (char) TextUtils.getOffsetAfter(str6, 0);
                        int threadPriority8 = Process.getThreadPriority(0);
                        int i52110 = -(-(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                        int i52111 = (i52110 ^ 20) + ((i52110 & 20) << 1);
                        Object[] objArr11114 = new Object[1];
                        a(offsetAfter7, (((threadPriority8 & 20) + (threadPriority8 | 20)) >> 6) + 916, i52111, objArr11114);
                        String str6111 = (String) objArr11114[0];
                        char c2112 = (char) (21822 - (~(-(-Gravity.getAbsoluteGravity(0, 0)))));
                        int iIndexOf111 = TextUtils.indexOf(str6, str6, 0, 0);
                        int iIPostMessageServiceStubProxy111 = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                        int i52112 = ~iIndexOf111;
                        int i52113 = ~iIPostMessageServiceStubProxy111;
                        int i52114 = ~((i52113 & i52112) | (i52112 ^ i52113));
                        int i52115 = ~((-936) | iIPostMessageServiceStubProxy111);
                        int i52116 = (((iIndexOf111 * (-574)) - 536690) - (~(((i52114 ^ i52115) | (i52114 & i52115)) * 1150))) - 1;
                        int i52117 = ~(((-936) & iIPostMessageServiceStubProxy111) | ((-936) ^ iIPostMessageServiceStubProxy111));
                        int i52118 = ~iIPostMessageServiceStubProxy111;
                        int i52119 = ~((i52118 ^ 935) | (i52118 & 935));
                        int i53110 = i52116 + (((i52119 & i52117) | (i52117 ^ i52119)) * (-575));
                        int i53111 = ((~((iIPostMessageServiceStubProxy111 & i52112) | (i52112 ^ iIPostMessageServiceStubProxy111))) | (~((i52118 ^ iIndexOf111) | (iIndexOf111 & i52118)))) * 575;
                        int i53112 = (i53110 & i53111) + (i53111 | i53110);
                        int iAxisFromString3 = MotionEvent.axisFromString(str6);
                        int i53113 = (iAxisFromString3 ^ 32) + ((iAxisFromString3 & 32) << 1);
                        Object[] objArr11115 = new Object[1];
                        a(c2112, i53112, i53113, objArr11115);
                        String str6112 = (String) objArr11115[0];
                        int i53114 = -Process.getGidForName(str6);
                        int i53115 = -KeyEvent.normalizeMetaState(0);
                        int i53116 = ((i53115 | 966) << 1) - (i53115 ^ 966);
                        int i53117 = -(ViewConfiguration.getScrollDefaultDelay() >> 16);
                        int i53118 = ((i53117 | 26) << 1) - (i53117 ^ 26);
                        Object[] objArr11116 = new Object[1];
                        a((char) ((i53114 ^ 29772) + ((i53114 & 29772) << 1)), i53116, i53118, objArr11116);
                        String str6113 = (String) objArr11116[0];
                        char c2113 = (char) (9581 - (~(-(ViewConfiguration.getPressedStateDuration() >> 16))));
                        int i53119 = -TextUtils.indexOf((CharSequence) str6, '0', 0, 0);
                        int i54110 = (i53119 ^ 991) + ((i53119 & 991) << 1);
                        int i54111 = -(ViewConfiguration.getScrollBarFadeDuration() >> 16);
                        int i54112 = ((i54111 | 23) << 1) - (i54111 ^ 23);
                        Object[] objArr11117 = new Object[1];
                        a(c2113, i54110, i54112, objArr11117);
                        String str6114 = (String) objArr11117[0];
                        int i54113 = -Color.rgb(0, 0, 0);
                        Object[] objArr11118 = new Object[1];
                        a((char) ((i54113 ^ (-16767899)) + ((i54113 & (-16767899)) << 1)), 1014 - (~(-(-View.MeasureSpec.getSize(0)))), 31 - (~(-TextUtils.lastIndexOf(str6, '0'))), objArr11118);
                        String str6115 = (String) objArr11118[0];
                        str8 = str6;
                        char cResolveSizeAndState5 = (char) View.resolveSizeAndState(0, 0, 0);
                        int touchSlop9 = ViewConfiguration.getTouchSlop() >> 8;
                        int i54114 = (touchSlop9 ^ 1048) + ((touchSlop9 & 1048) << 1);
                        int i54115 = -(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                        int i54116 = (i54115 & 13) + (i54115 | 13);
                        Object[] objArr11119 = new Object[1];
                        a(cResolveSizeAndState5, i54114, i54116, objArr11119);
                        String str6116 = (String) objArr11119[0];
                        int absoluteGravity10 = Gravity.getAbsoluteGravity(0, 0);
                        char c2114 = (char) ((absoluteGravity10 & 23047) + (absoluteGravity10 | 23047));
                        int keyRepeatDelay18 = 627 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                        int i54117 = -(ViewConfiguration.getLongPressTimeout() >> 16);
                        int i54118 = (i54117 ^ 7) + ((i54117 & 7) << 1);
                        Object[] objArr12110 = new Object[1];
                        a(c2114, keyRepeatDelay18, i54118, objArr12110);
                        int packedPositionChild5 = ExpandableListView.getPackedPositionChild(0L);
                        int scrollDefaultDelay3 = 1061 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                        int i54119 = -KeyEvent.normalizeMetaState(0);
                        int i55110 = ((i54119 | 30) << 1) - (i54119 ^ 30);
                        Object[] objArr12111 = new Object[1];
                        a((char) (((packedPositionChild5 | 1) << 1) - (packedPositionChild5 ^ 1)), scrollDefaultDelay3, i55110, objArr12111);
                        String str6117 = (String) objArr12111[0];
                        int i55111 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                        int i55112 = (i55111 * 866) - 5501952;
                        int i55113 = ~i55111;
                        int i55114 = -(-(((~((i55113 & i169) | (i55113 ^ i169))) | (-6369)) * (-865)));
                        int i55115 = (((i55112 & i55114) + (i55112 | i55114)) - (~((~((i55111 ^ i) | (i55111 & i))) * 865))) - 1;
                        int i55116 = ~(((-6369) ^ i169) | ((-6369) & i169));
                        int i55117 = ~((i55111 & i169) | (i169 ^ i55111));
                        int i55118 = ((i55117 & i55116) | (i55116 ^ i55117)) * 865;
                        char c2115 = (char) ((i55115 ^ i55118) + ((i55118 & i55115) << 1));
                        int i55119 = -(-View.MeasureSpec.getSize(0));
                        int i56110 = (i55119 ^ 1091) + ((i55119 & 1091) << 1);
                        int iIndexOf112 = TextUtils.indexOf((CharSequence) str8, '0', 0);
                        int iIPostMessageServiceStubProxy112 = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                        int i56111 = (iIndexOf112 * (-380)) + 4584;
                        int i56112 = ~iIndexOf112;
                        int i56113 = -(-((iIPostMessageServiceStubProxy112 | 12 | i56112) * (-381)));
                        int i56114 = (i56111 & i56113) + (i56111 | i56113);
                        int i56115 = ~((~iIndexOf112) | (-13));
                        int i56116 = ~iIPostMessageServiceStubProxy112;
                        int i56117 = (~((i56116 & 12) | (i56116 ^ 12))) | i56115;
                        int i56118 = ~((iIndexOf112 ^ 12) | (iIndexOf112 & 12));
                        int i56119 = (i56114 - (~(((i56117 & i56118) | (i56117 ^ i56118)) * 381))) - 1;
                        int i57110 = (~(i56112 | 12)) * 381;
                        int i57111 = ((i56119 | i57110) << 1) - (i57110 ^ i56119);
                        Object[] objArr12112 = new Object[1];
                        a(c2115, i56110, i57111, objArr12112);
                        int iIndexOf113 = TextUtils.indexOf((CharSequence) str8, '0', 0);
                        int i57112 = -(ViewConfiguration.getScrollBarFadeDuration() >> 16);
                        Object[] objArr12113 = new Object[1];
                        a((char) (((iIndexOf113 | 26730) << 1) - (iIndexOf113 ^ 26730)), (i57112 ^ 1102) + ((i57112 & 1102) << 1), 18 - (~(-(-TextUtils.indexOf(str8, str8, 0, 0)))), objArr12113);
                        String str6118 = (String) objArr12113[0];
                        char c2116 = (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                        int i57113 = -KeyEvent.normalizeMetaState(0);
                        int i57114 = ((i57113 | 1121) << 1) - (i57113 ^ 1121);
                        int scrollBarSize8 = ViewConfiguration.getScrollBarSize() >> 8;
                        int i57115 = (scrollBarSize8 ^ 5) + ((scrollBarSize8 & 5) << 1);
                        Object[] objArr12114 = new Object[1];
                        a(c2116, i57114, i57115, objArr12114);
                        char keyRepeatTimeout19 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                        int i57116 = (-16776091) - (~(-Color.rgb(0, 0, 0)));
                        int iResolveSize6 = View.resolveSize(0, 0);
                        int i57117 = ((iResolveSize6 | 19) << 1) - (iResolveSize6 ^ 19);
                        Object[] objArr12115 = new Object[1];
                        a(keyRepeatTimeout19, i57116, i57117, objArr12115);
                        char cIndexOf16 = (char) TextUtils.indexOf(str8, str8, 0, 0);
                        int iGreen7 = Color.green(0);
                        int i57118 = ((iGreen7 | 1145) << 1) - (iGreen7 ^ 1145);
                        int i57119 = -(-AndroidCharacter.getMirror('0'));
                        int i58110 = (i57119 ^ (-32)) + ((i57119 & (-32)) << 1);
                        Object[] objArr12116 = new Object[1];
                        a(cIndexOf16, i57118, i58110, objArr12116);
                        int i58111 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                        Object[] objArr12117 = new Object[1];
                        a((char) (((i58111 | 43328) << 1) - (i58111 ^ 43328)), 1160 - (~(-(-View.resolveSize(0, 0)))), 18 - (~(ViewConfiguration.getLongPressTimeout() >> 16)), objArr12117);
                        int i58112 = -(Process.myPid() >> 22);
                        int i58113 = -(-ExpandableListView.getPackedPositionType(0L));
                        int i58114 = (i58113 & 1180) + (i58113 | 1180);
                        int i58115 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                        int i58116 = i58115 * (-1975);
                        int i58117 = (i58116 & 18791) + (i58116 | 18791);
                        int i58118 = ~i58115;
                        int i58119 = ~(i58118 | 19);
                        int i59110 = i58117 + (((i58119 & i) | (i ^ i58119)) * 988);
                        int i59111 = ~((-20) | i58115);
                        int i59112 = ~(i58115 | i169);
                        int i59113 = -(-(((i59112 & i59111) | (i59111 ^ i59112)) * (-1976)));
                        int i59114 = (i59110 ^ i59113) + ((i59113 & i59110) << 1);
                        int i59115 = ~((i58118 & 19) | (i58118 ^ 19));
                        int i59116 = ~(((-20) & i) | ((-20) ^ i));
                        int i59117 = (i59115 & i59116) | (i59115 ^ i59116);
                        int i59118 = ~((i169 ^ 19) | (i169 & 19));
                        int i59119 = -(-(((i59117 & i59118) | (i59117 ^ i59118)) * 988));
                        int i60110 = (i59114 & i59119) + (i59119 | i59114);
                        Object[] objArr12118 = new Object[1];
                        a((char) (((i58112 | 31256) << 1) - (i58112 ^ 31256)), i58114, i60110, objArr12118);
                        int i60111 = -(-TextUtils.indexOf((CharSequence) str8, '0', 0, 0));
                        int i60112 = -AndroidCharacter.getMirror('0');
                        Object[] objArr12119 = new Object[1];
                        a((char) ((i60111 & 61337) + (i60111 | 61337)), ((i60112 | 1247) << 1) - (i60112 ^ 1247), 23 - (KeyEvent.getMaxKeyCode() >> 16), objArr12119);
                        int i60113 = -(ViewConfiguration.getDoubleTapTimeout() >> 16);
                        int i60114 = -(-(i60113 * (-963)));
                        int i60115 = (i60114 & (-964)) + (i60114 | (-964)) + 43534045;
                        int i60116 = ~i60113;
                        int i60117 = ~(((-45114) ^ i) | ((-45114) & i));
                        int i60118 = i60115 + (((i60116 & i60117) | (i60116 ^ i60117)) * (-964));
                        int i60119 = -(-(((~(i60113 | (-45114))) | (~(((-45114) ^ i169) | ((-45114) & i169)))) * (-964)));
                        char c2117 = (char) ((i60118 & i60119) + (i60119 | i60118));
                        int i61110 = -View.resolveSize(0, 0);
                        int i61111 = (i61110 ^ 1222) + ((i61110 & 1222) << 1);
                        int i61112 = -(-(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                        int i61113 = (i61112 & 20) + (i61112 | 20);
                        Object[] objArr13114 = new Object[1];
                        a(c2117, i61111, i61113, objArr13114);
                        int i61114 = -(-(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                        int i61115 = -Color.rgb(0, 0, 0);
                        int i61116 = ((i61115 | (-16775973)) << 1) - (i61115 ^ (-16775973));
                        int i61117 = -ExpandableListView.getPackedPositionType(0L);
                        int i61118 = (i61117 & 24) + (i61117 | 24);
                        Object[] objArr13115 = new Object[1];
                        a((char) (((i61114 | 26190) << 1) - (i61114 ^ 26190)), i61116, i61118, objArr13115);
                        String str6119 = str;
                        char c2118 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                        int i61119 = -View.MeasureSpec.getSize(0);
                        Object[] objArr13116 = new Object[1];
                        a(c2118, ((i61119 | 1267) << 1) - (i61119 ^ 1267), View.getDefaultSize(0, 0) + 28, objArr13116);
                        char c2119 = (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                        int i62112 = -Color.rgb(0, 0, 0);
                        Object[] objArr13117 = new Object[1];
                        a(c2119, (i62112 ^ (-16775921)) + ((i62112 & (-16775921)) << 1), 26 - (~(-(-(Process.myPid() >> 22)))), objArr13117);
                        char c310 = (char) (29032 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                        int i62113 = 1321 - (~ExpandableListView.getPackedPositionGroup(0L));
                        int i62114 = -Color.blue(0);
                        int i62115 = (i62114 & 31) + (i62114 | 31);
                        Object[] objArr13118 = new Object[1];
                        a(c310, i62113, i62115, objArr13118);
                        char defaultSize5 = (char) (14167 - View.getDefaultSize(0, 0));
                        int i62116 = 1352 - (~(ViewConfiguration.getMinimumFlingVelocity() >> 16));
                        int size9 = View.MeasureSpec.getSize(0);
                        int i62117 = ((size9 | 27) << 1) - (size9 ^ 27);
                        Object[] objArr13119 = new Object[1];
                        a(defaultSize5, i62116, i62117, objArr13119);
                        int i62118 = -KeyEvent.normalizeMetaState(0);
                        int maximumDrawingCacheSize8 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 1380;
                        int scrollBarSize9 = ViewConfiguration.getScrollBarSize() >> 8;
                        int i62119 = (scrollBarSize9 ^ 32) + ((scrollBarSize9 & 32) << 1);
                        Object[] objArr13120 = new Object[1];
                        a((char) (((i62118 | 35676) << 1) - (i62118 ^ 35676)), maximumDrawingCacheSize8, i62119, objArr13120);
                        strArr3 = new String[][]{new String[]{str3110, str4110, str4111, (String) objArr8113[0]}, new String[]{str4112, str4113, str4114, str4115, (String) objArr9110[0]}, new String[]{str4116, str4117, str, str4118, str4119, str5110}, strArr110, new String[]{str5111, str5112, (String) objArr10112[0]}, new String[]{str5113, (String) objArr10114[0]}, new String[]{str5114, (String) objArr10116[0]}, new String[]{str5115, str5116, str5117, str5118, str5119, (String) objArr11112[0]}, new String[]{str6110, str6111, str6112, str6113, str6114, str6115, str}, new String[]{str6116, (String) objArr12110[0]}, new String[]{str6117, (String) objArr12112[0]}, new String[]{str6118, (String) objArr12114[0]}, new String[]{(String) objArr12115[0]}, new String[]{(String) objArr12116[0]}, new String[]{(String) objArr12117[0]}, new String[]{(String) objArr12118[0]}, new String[]{(String) objArr12119[0]}, new String[]{(String) objArr13114[0]}, new String[]{(String) objArr13115[0], str6119}, new String[]{(String) objArr13116[0], str6119}, new String[]{(String) objArr13117[0], str6119}, new String[]{(String) objArr13118[0], str6119}, new String[]{(String) objArr13119[0], str6119}, new String[]{(String) objArr13120[0], str6119}};
                        arrayList = new ArrayList();
                        i32 = i;
                        i33 = 0;
                        i34 = 0;
                        while (i33 < 24) {
                            int i62120 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                            i40 = (i62120 & 73) + (i62120 | 73);
                            artificialFrame = i40 % 128;
                            if (i40 % 2 == 0) {
                                strArr4 = strArr3[i33];
                                Object[] objArr1322 = {strArr4[1]};
                                objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                                if (objAccessartificialFrame11 == null) {
                                    int minimumFlingVelocity6 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 23;
                                    char mirror9 = (char) (AndroidCharacter.getMirror('0') - '0');
                                    int minimumFlingVelocity7 = 2441 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                                    byte[] bArr1110 = $$a;
                                    Object[] objArr1323 = new Object[1];
                                    b((byte) 49, bArr1110[16], bArr1110[10], objArr1323);
                                    objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity6, mirror9, minimumFlingVelocity7, 954751276, false, (String) objArr1323[0], new Class[]{String.class});
                                }
                                str10 = (String) ((Method) objAccessartificialFrame11).invoke(null, objArr1322);
                                strArr5 = (String[]) Arrays.copyOfRange(strArr4, 1, strArr4.length);
                                if (str10 != null) {
                                    i41 = artificialFrame + 27;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i41 % 128;
                                    if (i41 % 2 != 0) {
                                        int i621110 = 23 / 0;
                                        if (str10.length() != 0) {
                                            if (strArr4.length != 1) {
                                                Object[] objArr131110 = {str10, strArr5};
                                                objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(311378445);
                                                if (objAccessartificialFrame10 == null) {
                                                    int keyRepeatDelay19 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 29;
                                                    char keyRepeatTimeout110 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                                                    int i6311110 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + FrameMetricsAggregator.EVERY_DURATION;
                                                    byte b110 = $$a[16];
                                                    byte b111 = b110;
                                                    Object[] objArr14110 = new Object[1];
                                                    b(b111, (byte) (b111 | 7), b110, objArr14110);
                                                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay19, keyRepeatTimeout110, i6311110, -1914043387, false, (String) objArr14110[0], new Class[]{String.class, String[].class});
                                                }
                                                long jLongValue112 = ((Long) ((Method) objAccessartificialFrame10).invoke(null, objArr131110)).longValue();
                                                long j71118 = -1961190699;
                                                strArr6 = strArr3;
                                                long j71119 = -406;
                                                long j711110 = jLongValue112 ^ j20;
                                                i42 = i33;
                                                long jUptimeMillis9 = (int) SystemClock.uptimeMillis();
                                                long j711111 = jUptimeMillis9 ^ j20;
                                                long j810 = (((long) (-405)) * j71118) + (((long) 407) * jLongValue112) + ((((j711110 | jUptimeMillis9) ^ j20) | (((j711111 | j71118) | jLongValue112) ^ j20)) * j71119) + (j71119 * (((j711110 | j711111) | j71118) ^ j20)) + (((long) 406) * (((jUptimeMillis9 | (j71118 ^ j20)) ^ j20) | ((j711111 | jLongValue112) ^ j20))) + ((long) 1986464153);
                                                i43 = ((int) (j810 >> 32)) & (785016995 + (((~(132250616 | i)) | 1304975794) * 191) + (((~(132250616 | i169)) | 1208483842) * 191));
                                                int elapsedCpuTime110 = (int) Process.getElapsedCpuTime();
                                                i44 = ((int) j810) & (922154449 + (((~(1909484194 | elapsedCpuTime110)) | (-948256692)) * (-668)) + ((1909484194 | (~((-948256692) | elapsedCpuTime110))) * 1336) + ((elapsedCpuTime110 | (-134550802)) * 668));
                                                if (((i43 & i44) | (i43 ^ i44)) != 0) {
                                                }
                                            } else {
                                                strArr6 = strArr3;
                                                i42 = i33;
                                            }
                                            int i6311111 = ((i34 | 1) << 1) - (i34 ^ 1);
                                            int i6311112 = ((i42 | 10) << 1) - (i42 ^ 10);
                                            int i6311113 = (i6311112 & i169) | ((~i6311112) & i);
                                            StringBuilder sb9 = new StringBuilder();
                                            sb9.append(str10);
                                            char deadChar17 = (char) KeyEvent.getDeadChar(0, 0);
                                            int i6311114 = -(-(ViewConfiguration.getEdgeSlop() >> 16));
                                            Object[] objArr14111 = new Object[1];
                                            a(deadChar17, (i6311114 & 1412) + (i6311114 | 1412), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), objArr14111);
                                            sb9.append((String) objArr14111[0]);
                                            sb9.append(str10);
                                            arrayList.add(sb9.toString());
                                            i34 = i6311111;
                                            i32 = i6311113;
                                        }
                                        i32 = i32;
                                    } else {
                                        if (str10.length() != 0) {
                                            if (strArr4.length != 1) {
                                                Object[] objArr131111 = {str10, strArr5};
                                                objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(311378445);
                                                if (objAccessartificialFrame10 == null) {
                                                    int keyRepeatDelay110 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 29;
                                                    char keyRepeatTimeout111 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                                                    int i6311115 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + FrameMetricsAggregator.EVERY_DURATION;
                                                    byte b112 = $$a[16];
                                                    byte b113 = b112;
                                                    Object[] objArr14112 = new Object[1];
                                                    b(b113, (byte) (b113 | 7), b112, objArr14112);
                                                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay110, keyRepeatTimeout111, i6311115, -1914043387, false, (String) objArr14112[0], new Class[]{String.class, String[].class});
                                                }
                                                long jLongValue113 = ((Long) ((Method) objAccessartificialFrame10).invoke(null, objArr131111)).longValue();
                                                long j711112 = -1961190699;
                                                strArr6 = strArr3;
                                                long j711113 = -406;
                                                long j711114 = jLongValue113 ^ j20;
                                                i42 = i33;
                                                long jUptimeMillis10 = (int) SystemClock.uptimeMillis();
                                                long j711115 = jUptimeMillis10 ^ j20;
                                                long j811 = (((long) (-405)) * j711112) + (((long) 407) * jLongValue113) + ((((j711114 | jUptimeMillis10) ^ j20) | (((j711115 | j711112) | jLongValue113) ^ j20)) * j711113) + (j711113 * (((j711114 | j711115) | j711112) ^ j20)) + (((long) 406) * (((jUptimeMillis10 | (j711112 ^ j20)) ^ j20) | ((j711115 | jLongValue113) ^ j20))) + ((long) 1986464153);
                                                i43 = ((int) (j811 >> 32)) & (785016995 + (((~(132250616 | i)) | 1304975794) * 191) + (((~(132250616 | i169)) | 1208483842) * 191));
                                                int elapsedCpuTime111 = (int) Process.getElapsedCpuTime();
                                                i44 = ((int) j811) & (922154449 + (((~(1909484194 | elapsedCpuTime111)) | (-948256692)) * (-668)) + ((1909484194 | (~((-948256692) | elapsedCpuTime111))) * 1336) + ((elapsedCpuTime111 | (-134550802)) * 668));
                                                if (((i43 & i44) | (i43 ^ i44)) != 0) {
                                                }
                                            } else {
                                                strArr6 = strArr3;
                                                i42 = i33;
                                            }
                                            int i6311116 = ((i34 | 1) << 1) - (i34 ^ 1);
                                            int i6311117 = ((i42 | 10) << 1) - (i42 ^ 10);
                                            int i6311118 = (i6311117 & i169) | ((~i6311117) & i);
                                            StringBuilder sb10 = new StringBuilder();
                                            sb10.append(str10);
                                            char deadChar18 = (char) KeyEvent.getDeadChar(0, 0);
                                            int i6311119 = -(-(ViewConfiguration.getEdgeSlop() >> 16));
                                            Object[] objArr14113 = new Object[1];
                                            a(deadChar18, (i6311119 & 1412) + (i6311119 | 1412), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), objArr14113);
                                            sb10.append((String) objArr14113[0]);
                                            sb10.append(str10);
                                            arrayList.add(sb10.toString());
                                            i34 = i6311116;
                                            i32 = i6311118;
                                        }
                                        i32 = i32;
                                    }
                                }
                                i33 = i42 + 1;
                                str8 = str8;
                                strArr3 = strArr6;
                            } else {
                                str8 = str8;
                                i32 = i32;
                                strArr4 = strArr3[i33];
                                Object[] objArr14114 = {strArr4[0]};
                                objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                                if (objAccessartificialFrame9 == null) {
                                    int i64110 = 23 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                                    char packedPositionChild6 = (char) ((-1) - ExpandableListView.getPackedPositionChild(0L));
                                    int touchSlop10 = 2441 - (ViewConfiguration.getTouchSlop() >> 8);
                                    byte[] bArr1111 = $$a;
                                    Object[] objArr14115 = new Object[1];
                                    b((byte) 49, bArr1111[16], bArr1111[10], objArr14115);
                                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(i64110, packedPositionChild6, touchSlop10, 954751276, false, (String) objArr14115[0], new Class[]{String.class});
                                }
                                str10 = (String) ((Method) objAccessartificialFrame9).invoke(null, objArr14114);
                                strArr5 = (String[]) Arrays.copyOfRange(strArr4, 1, strArr4.length);
                                if (str10 != null) {
                                    i41 = artificialFrame + 27;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i41 % 128;
                                    if (i41 % 2 != 0) {
                                        int i621111 = 23 / 0;
                                        if (str10.length() != 0) {
                                            if (strArr4.length != 1) {
                                                Object[] objArr131112 = {str10, strArr5};
                                                objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(311378445);
                                                if (objAccessartificialFrame10 == null) {
                                                    int keyRepeatDelay111 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 29;
                                                    char keyRepeatTimeout112 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                                                    int i63111110 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + FrameMetricsAggregator.EVERY_DURATION;
                                                    byte b114 = $$a[16];
                                                    byte b115 = b114;
                                                    Object[] objArr14116 = new Object[1];
                                                    b(b115, (byte) (b115 | 7), b114, objArr14116);
                                                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay111, keyRepeatTimeout112, i63111110, -1914043387, false, (String) objArr14116[0], new Class[]{String.class, String[].class});
                                                }
                                                long jLongValue114 = ((Long) ((Method) objAccessartificialFrame10).invoke(null, objArr131112)).longValue();
                                                long j711116 = -1961190699;
                                                strArr6 = strArr3;
                                                long j711117 = -406;
                                                long j711118 = jLongValue114 ^ j20;
                                                i42 = i33;
                                                long jUptimeMillis11 = (int) SystemClock.uptimeMillis();
                                                long j711119 = jUptimeMillis11 ^ j20;
                                                long j812 = (((long) (-405)) * j711116) + (((long) 407) * jLongValue114) + ((((j711118 | jUptimeMillis11) ^ j20) | (((j711119 | j711116) | jLongValue114) ^ j20)) * j711117) + (j711117 * (((j711118 | j711119) | j711116) ^ j20)) + (((long) 406) * (((jUptimeMillis11 | (j711116 ^ j20)) ^ j20) | ((j711119 | jLongValue114) ^ j20))) + ((long) 1986464153);
                                                i43 = ((int) (j812 >> 32)) & (785016995 + (((~(132250616 | i)) | 1304975794) * 191) + (((~(132250616 | i169)) | 1208483842) * 191));
                                                int elapsedCpuTime112 = (int) Process.getElapsedCpuTime();
                                                i44 = ((int) j812) & (922154449 + (((~(1909484194 | elapsedCpuTime112)) | (-948256692)) * (-668)) + ((1909484194 | (~((-948256692) | elapsedCpuTime112))) * 1336) + ((elapsedCpuTime112 | (-134550802)) * 668));
                                                if (((i43 & i44) | (i43 ^ i44)) != 0) {
                                                }
                                            } else {
                                                strArr6 = strArr3;
                                                i42 = i33;
                                            }
                                            int i63111111 = ((i34 | 1) << 1) - (i34 ^ 1);
                                            int i63111112 = ((i42 | 10) << 1) - (i42 ^ 10);
                                            int i63111113 = (i63111112 & i169) | ((~i63111112) & i);
                                            StringBuilder sb11 = new StringBuilder();
                                            sb11.append(str10);
                                            char deadChar19 = (char) KeyEvent.getDeadChar(0, 0);
                                            int i63111114 = -(-(ViewConfiguration.getEdgeSlop() >> 16));
                                            Object[] objArr14117 = new Object[1];
                                            a(deadChar19, (i63111114 & 1412) + (i63111114 | 1412), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), objArr14117);
                                            sb11.append((String) objArr14117[0]);
                                            sb11.append(str10);
                                            arrayList.add(sb11.toString());
                                            i34 = i63111111;
                                            i32 = i63111113;
                                        }
                                        i32 = i32;
                                    } else {
                                        if (str10.length() != 0) {
                                            if (strArr4.length != 1) {
                                                Object[] objArr131113 = {str10, strArr5};
                                                objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(311378445);
                                                if (objAccessartificialFrame10 == null) {
                                                    int keyRepeatDelay112 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 29;
                                                    char keyRepeatTimeout113 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                                                    int i63111115 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + FrameMetricsAggregator.EVERY_DURATION;
                                                    byte b116 = $$a[16];
                                                    byte b117 = b116;
                                                    Object[] objArr14118 = new Object[1];
                                                    b(b117, (byte) (b117 | 7), b116, objArr14118);
                                                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay112, keyRepeatTimeout113, i63111115, -1914043387, false, (String) objArr14118[0], new Class[]{String.class, String[].class});
                                                }
                                                long jLongValue115 = ((Long) ((Method) objAccessartificialFrame10).invoke(null, objArr131113)).longValue();
                                                long j7111110 = -1961190699;
                                                strArr6 = strArr3;
                                                long j7111111 = -406;
                                                long j7111112 = jLongValue115 ^ j20;
                                                i42 = i33;
                                                long jUptimeMillis12 = (int) SystemClock.uptimeMillis();
                                                long j7111113 = jUptimeMillis12 ^ j20;
                                                long j813 = (((long) (-405)) * j7111110) + (((long) 407) * jLongValue115) + ((((j7111112 | jUptimeMillis12) ^ j20) | (((j7111113 | j7111110) | jLongValue115) ^ j20)) * j7111111) + (j7111111 * (((j7111112 | j7111113) | j7111110) ^ j20)) + (((long) 406) * (((jUptimeMillis12 | (j7111110 ^ j20)) ^ j20) | ((j7111113 | jLongValue115) ^ j20))) + ((long) 1986464153);
                                                i43 = ((int) (j813 >> 32)) & (785016995 + (((~(132250616 | i)) | 1304975794) * 191) + (((~(132250616 | i169)) | 1208483842) * 191));
                                                int elapsedCpuTime113 = (int) Process.getElapsedCpuTime();
                                                i44 = ((int) j813) & (922154449 + (((~(1909484194 | elapsedCpuTime113)) | (-948256692)) * (-668)) + ((1909484194 | (~((-948256692) | elapsedCpuTime113))) * 1336) + ((elapsedCpuTime113 | (-134550802)) * 668));
                                                if (((i43 & i44) | (i43 ^ i44)) != 0) {
                                                }
                                            } else {
                                                strArr6 = strArr3;
                                                i42 = i33;
                                            }
                                            int i63111116 = ((i34 | 1) << 1) - (i34 ^ 1);
                                            int i63111117 = ((i42 | 10) << 1) - (i42 ^ 10);
                                            int i63111118 = (i63111117 & i169) | ((~i63111117) & i);
                                            StringBuilder sb12 = new StringBuilder();
                                            sb12.append(str10);
                                            char deadChar110 = (char) KeyEvent.getDeadChar(0, 0);
                                            int i63111119 = -(-(ViewConfiguration.getEdgeSlop() >> 16));
                                            Object[] objArr14119 = new Object[1];
                                            a(deadChar110, (i63111119 & 1412) + (i63111119 | 1412), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), objArr14119);
                                            sb12.append((String) objArr14119[0]);
                                            sb12.append(str10);
                                            arrayList.add(sb12.toString());
                                            i34 = i63111116;
                                            i32 = i63111118;
                                        }
                                        i32 = i32;
                                    }
                                }
                                i33 = i42 + 1;
                                str8 = str8;
                                strArr3 = strArr6;
                            }
                            strArr6 = strArr3;
                            i42 = i33;
                            i32 = i32;
                            i33 = i42 + 1;
                            str8 = str8;
                            strArr3 = strArr6;
                        }
                        str9 = str8;
                        i35 = i32;
                        if (i34 > 2) {
                            objArr = new Object[]{arrayList, new int[]{(i6414 | i6415) & (~(i6414 & i6415))}, null, new int[]{i}, new int[]{i35}};
                            int i64111 = (-1) - (~(-(-(((1283078155 + (((~((-397000172) | i169)) | (~((-208448287) | i))) * (-370))) + ((((~((-397000172) | i)) | (~((-208448287) | i169))) | (-535674880)) * (-370))) - 631209984))));
                            int i64112 = i64111 << 13;
                            int i64113 = (i64112 & (~i64111)) | ((~i64112) & i64111);
                            int i64114 = i64113 ^ (i64113 >>> 17);
                            int i64115 = i64114 << 5;
                            i37 = 0;
                            c3 = 4;
                            i36 = 1;
                        } else {
                            objArr = new Object[]{null, new int[1], null, new int[]{i}, new int[]{i}};
                            int elapsedCpuTime114 = (int) Process.getElapsedCpuTime();
                            int i64116 = 2063318369 + (((~((-439154682) | elapsedCpuTime114)) | 136868112) * 104) + ((~((~elapsedCpuTime114) | 468580345)) * (-104)) + ((elapsedCpuTime114 | 166293776) * 104);
                            int i64117 = (-1) - (~(-(-((i64116 << 1) - i64116))));
                            int i64118 = (i64117 << 13) ^ i64117;
                            int i64119 = i64118 ^ (i64118 >>> 17);
                            int i6514 = i64119 << 5;
                            int i6515 = (i64119 | i6514) & (~(i64119 & i6514));
                            i36 = 1;
                            i37 = 0;
                            ((int[]) objArr[1])[0] = i6515;
                            c3 = 4;
                        }
                        i38 = ((int[]) objArr[c3])[i37];
                        if (i38 != i) {
                            objArr2 = new Object[5];
                            objArr2[i36] = new int[i36];
                            int[] iArr7 = new int[i36];
                            objArr2[3] = iArr7;
                            int[] iArr8 = new int[i36];
                            objArr2[c3] = iArr8;
                            List list3 = (List) objArr[i37];
                            iArr7[i37] = i;
                            iArr8[i37] = i38;
                            objArr2[i37] = list3;
                            objArr2[2] = null;
                            int elapsedCpuTime115 = (int) Process.getElapsedCpuTime();
                            int i6516 = i3 + (-441151705) + (((~((-57940110) | elapsedCpuTime115)) | 50331781) * (-140)) + ((~((-7608329) | elapsedCpuTime115)) * 70) + (((~(elapsedCpuTime115 | 663388567)) | (-620665115)) * 70) + 16;
                            int i6517 = i6516 << 13;
                            int i6518 = ((~i6516) & i6517) | ((~i6517) & i6516);
                            int i6519 = i6518 ^ (i6518 >>> 17);
                            int i65110 = i6519 << 5;
                            ((int[]) objArr2[1])[0] = (i6519 | i65110) & (~(i6519 & i65110));
                        } else {
                            i39 = i37;
                        }
                    }
                } else {
                    int i40116 = -(Process.myPid() >> 22);
                    Object[] objArr8118 = new Object[1];
                    a((char) ((i40116 & 15387) + (i40116 | 15387)), 371 - (~(-(Process.myPid() >> 22))), KeyEvent.keyCodeFromString(str6) + 23, objArr8118);
                    String str3111 = (String) objArr8118[0];
                    char c1115 = (char) (19553 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                    int i40117 = 617 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                    int i40118 = -(-ExpandableListView.getPackedPositionGroup(0L));
                    int i40119 = (i40118 ^ 10) + ((i40118 & 10) << 1);
                    Object[] objArr8119 = new Object[1];
                    a(c1115, i40117, i40119, objArr8119);
                    String str41110 = (String) objArr8119[0];
                    char c1116 = (char) (23046 - (~Color.green(0)));
                    int i401110 = 627 - (~TextUtils.indexOf((CharSequence) str6, '0', 0, 0));
                    int i401111 = -KeyEvent.keyCodeFromString(str6);
                    int i411110 = (i401111 & 7) + (i401111 | 7);
                    Object[] objArr81110 = new Object[1];
                    a(c1116, i401110, i411110, objArr81110);
                    String str41111 = (String) objArr81110[0];
                    Object[] objArr81111 = new Object[1];
                    a((char) Gravity.getAbsoluteGravity(0, 0), 633 - (~(-(KeyEvent.getMaxKeyCode() >> 16))), 7 - (~(-(-(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))))), objArr81111);
                    char c1117 = (char) ((-2) - ((-(-(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)))) ^ (-1)));
                    int iIndexOf114 = TextUtils.indexOf(str6, str6, 0, 0);
                    int i411111 = ((iIndexOf114 | 642) << 1) - (iIndexOf114 ^ 642);
                    int i411112 = -(ViewConfiguration.getPressedStateDuration() >> 16);
                    int i411113 = (i411112 ^ 17) + ((i411112 & 17) << 1);
                    Object[] objArr81112 = new Object[1];
                    a(c1117, i411111, i411113, objArr81112);
                    String str41112 = (String) objArr81112[0];
                    char windowTouchSlop6 = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                    int i411114 = -(ViewConfiguration.getLongPressTimeout() >> 16);
                    int i411115 = (i411114 & 659) + (i411114 | 659);
                    int i411116 = -(-(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                    int i411117 = ((i411116 | 6) << 1) - (i411116 ^ 6);
                    Object[] objArr81113 = new Object[1];
                    a(windowTouchSlop6, i411115, i411117, objArr81113);
                    String str41113 = (String) objArr81113[0];
                    char cIndexOf17 = (char) TextUtils.indexOf(str6, str6, 0, 0);
                    int i411118 = -Color.red(0);
                    int iIPostMessageServiceStubProxy113 = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                    int i411119 = ~i411118;
                    int i421110 = ~iIPostMessageServiceStubProxy113;
                    int i421111 = ~(i411119 | i421110);
                    int i421112 = ~(((-667) ^ iIPostMessageServiceStubProxy113) | ((-667) & iIPostMessageServiceStubProxy113));
                    int i421113 = (((i411118 * (-574)) - 382284) - (~(((i421111 ^ i421112) | (i421111 & i421112)) * 1150))) - 1;
                    int i421114 = ~(((-667) ^ iIPostMessageServiceStubProxy113) | ((-667) & iIPostMessageServiceStubProxy113));
                    int i421115 = ~((i421110 & 666) | (i421110 ^ 666));
                    int i421116 = -(-(((i421115 & i421114) | (i421114 ^ i421115)) * (-575)));
                    int i421117 = (i421113 ^ i421116) + ((i421116 & i421113) << 1);
                    int i421118 = ~(i411119 | iIPostMessageServiceStubProxy113);
                    int i421119 = ~((i411118 & i421110) | (i421110 ^ i411118));
                    int i431110 = ((i421118 & i421119) | (i421118 ^ i421119)) * 575;
                    int i431111 = ((i421117 | i431110) << 1) - (i431110 ^ i421117);
                    int i431112 = -TextUtils.lastIndexOf(str6, '0', 0);
                    int i431113 = ((i431112 | 6) << 1) - (i431112 ^ 6);
                    Object[] objArr81114 = new Object[1];
                    a(cIndexOf17, i431111, i431113, objArr81114);
                    String str41114 = (String) objArr81114[0];
                    int i431114 = -(ViewConfiguration.getFadingEdgeLength() >> 16);
                    Object[] objArr81115 = new Object[1];
                    a((char) ((i431114 & 32918) + (i431114 | 32918)), 672 - (~(-View.MeasureSpec.makeMeasureSpec(0, 0))), 10 - (~(-(ViewConfiguration.getKeyRepeatTimeout() >> 16))), objArr81115);
                    String str41115 = (String) objArr81115[0];
                    char c1118 = (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 4546);
                    int i431115 = -(-(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
                    int i431116 = ((i431115 | 683) << 1) - (i431115 ^ 683);
                    int longPressTimeout12 = ViewConfiguration.getLongPressTimeout() >> 16;
                    int i431117 = ((longPressTimeout12 | 14) << 1) - (longPressTimeout12 ^ 14);
                    Object[] objArr91110 = new Object[1];
                    a(c1118, i431116, i431117, objArr91110);
                    char cIndexOf18 = (char) TextUtils.indexOf(str6, str6);
                    int i431118 = -(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                    int i431119 = (i431118 ^ 698) + ((i431118 & 698) << 1);
                    int i441110 = -(KeyEvent.getMaxKeyCode() >> 16);
                    int i441111 = (i441110 ^ 16) + ((i441110 & 16) << 1);
                    Object[] objArr91111 = new Object[1];
                    a(cIndexOf18, i431119, i441111, objArr91111);
                    String str41116 = (String) objArr91111[0];
                    int i441112 = -(-(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)));
                    Object[] objArr91112 = new Object[1];
                    a((char) ((i441112 ^ 21512) + ((i441112 & 21512) << 1)), 714 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (ViewConfiguration.getScrollBarSize() >> 8) + 3, objArr91112);
                    String str41117 = (String) objArr91112[0];
                    char cResolveSize8 = (char) (22992 - View.resolveSize(0, 0));
                    int offsetAfter8 = TextUtils.getOffsetAfter(str6, 0);
                    int i441113 = ((offsetAfter8 | 725) << 1) - (offsetAfter8 ^ 725);
                    int iMyTid6 = Process.myTid() >> 22;
                    int i441114 = (iMyTid6 ^ 22) + ((iMyTid6 & 22) << 1);
                    Object[] objArr91113 = new Object[1];
                    a(cResolveSize8, i441113, i441114, objArr91113);
                    String str41118 = (String) objArr91113[0];
                    Object[] objArr91114 = new Object[1];
                    a((char) Color.argb(0, 0, 0, 0), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 747, 24 - (~(-(-(ViewConfiguration.getEdgeSlop() >> 16)))), objArr91114);
                    String str41119 = (String) objArr91114[0];
                    char edgeSlop9 = (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 30699);
                    int i441115 = -(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                    int i441116 = (i441115 * (-317)) + 246587;
                    int i441117 = ~i441115;
                    int i441118 = (i441117 ^ (-774)) | (i441117 & (-774));
                    int i441119 = ~((i441118 & i) | (i441118 ^ i));
                    int i451110 = ~((i169 ^ i441115) | (i169 & i441115) | 773);
                    int i451111 = ((i441119 ^ i451110) | (i441119 & i451110)) * (-318);
                    int i451112 = ((i441116 | i451111) << 1) - (i451111 ^ i441116);
                    int i451113 = ~(((-774) & i441115) | ((-774) ^ i441115));
                    int i451114 = ~((i441115 & i) | (i441115 ^ i));
                    int i451115 = -(-(((i451114 & i451113) | (i451113 ^ i451114)) * (-318)));
                    int i451116 = (i451112 & i451115) + (i451115 | i451112);
                    int i451117 = ~(i441117 | i);
                    int i451118 = -(-(((i451117 & (-774)) | ((-774) ^ i451117)) * TypedValues.AttributesType.TYPE_PIVOT_TARGET));
                    Object[] objArr91115 = new Object[1];
                    a(edgeSlop9, (i451116 & i451118) + (i451118 | i451116), 28 - (Process.myPid() >> 22), objArr91115);
                    String str51110 = (String) objArr91115[0];
                    c2 = 6;
                    i31 = -1;
                    int i451119 = artificialFrame + 85;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i451119 % 128;
                    int i461110 = i451119 % 2;
                    int i461111 = -(-(ViewConfiguration.getKeyRepeatTimeout() >> 16));
                    int i461112 = -(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                    int iIPostMessageServiceStubProxy114 = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                    int i461113 = i461112 * 989;
                    int i461114 = (i461113 ^ (-789600)) + ((i461113 & (-789600)) << 1);
                    int i461115 = ~iIPostMessageServiceStubProxy114;
                    int i461116 = ~(((-801) ^ i461115) | (i461115 & (-801)) | i461112);
                    int i461117 = (i461112 & LogSeverity.EMERGENCY_VALUE) | (i461112 ^ LogSeverity.EMERGENCY_VALUE);
                    int i461118 = ~((i461117 & iIPostMessageServiceStubProxy114) | (i461117 ^ iIPostMessageServiceStubProxy114));
                    int i461119 = ((i461118 & i461116) | (i461116 ^ i461118)) * 988;
                    int i471110 = (((i461114 | i461119) << 1) - (i461119 ^ i461114)) + (((i461112 ^ (-801)) | (i461112 & (-801))) * (-988));
                    int i471111 = ~i461112;
                    int i471112 = ~((i471111 & (-801)) | (i471111 ^ (-801)));
                    int i471113 = ~(((-801) & iIPostMessageServiceStubProxy114) | ((-801) ^ iIPostMessageServiceStubProxy114));
                    int i471114 = (i471112 & i471113) | (i471112 ^ i471113);
                    int i471115 = ~iIPostMessageServiceStubProxy114;
                    int i471116 = ~((i461112 & i471115) | (i471115 ^ i461112) | LogSeverity.EMERGENCY_VALUE);
                    Object[] objArr91116 = new Object[1];
                    a((char) ((i461111 & 11772) + (i461111 | 11772)), (i471110 - (~(((i471114 & i471116) | (i471114 ^ i471116)) * 988))) - 1, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 11, objArr91116);
                    char maxKeyCode5 = (char) (KeyEvent.getMaxKeyCode() >> 16);
                    int i471117 = -View.MeasureSpec.getSize(0);
                    Object[] objArr91117 = new Object[1];
                    a(maxKeyCode5, (i471117 ^ 811) + ((i471117 & 811) << 1), 7 - (~(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), objArr91117);
                    int i471118 = -(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                    int i471119 = -(-View.resolveSizeAndState(0, 0, 0));
                    int i481110 = ((i471119 | 819) << 1) - (i471119 ^ 819);
                    int i481111 = -TextUtils.getCapsMode(str6, 0, 0);
                    int i481112 = (i481111 & 6) + (i481111 | 6);
                    Object[] objArr91118 = new Object[1];
                    a((char) ((i471118 & 45437) + (i471118 | 45437)), i481110, i481112, objArr91118);
                    char mirror10 = (char) (AndroidCharacter.getMirror('0') + 35699);
                    int i481113 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                    int i481114 = (i481113 & 824) + (i481113 | 824);
                    int i481115 = -(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                    int i481116 = ((i481115 | 6) << 1) - (i481115 ^ 6);
                    Object[] objArr91119 = new Object[1];
                    a(mirror10, i481114, i481116, objArr91119);
                    String[] strArr111 = {(String) objArr91116[0], (String) objArr91117[0], (String) objArr91118[0], (String) objArr91119[0]};
                    int i481117 = -(-Color.rgb(0, 0, 0));
                    int i481118 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                    int i481119 = -(-(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)));
                    int i491110 = (i481119 & 16) + (i481119 | 16);
                    Object[] objArr101110 = new Object[1];
                    a((char) ((i481117 ^ 16777216) + ((i481117 & 16777216) << 1)), (i481118 ^ 830) + ((i481118 & 830) << 1), i491110, objArr101110);
                    String str51111 = (String) objArr101110[0];
                    int i491111 = -(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                    Object[] objArr101111 = new Object[1];
                    a((char) ((i491111 & 1) + (i491111 | 1)), ImageFormat.getBitsPerPixel(0) + 667, 8 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), objArr101111);
                    String str51112 = (String) objArr101111[0];
                    Object[] objArr101112 = new Object[1];
                    a((char) Color.blue(0), 633 - (~(ViewConfiguration.getMinimumFlingVelocity() >> 16)), Color.rgb(0, 0, 0) + 16777224, objArr101112);
                    Object[] objArr101113 = new Object[1];
                    a((char) (28597 - TextUtils.lastIndexOf(str6, '0', 0)), View.combineMeasuredStates(0, 0) + 847, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 13, objArr101113);
                    String str51113 = (String) objArr101113[0];
                    char scrollBarSize10 = (char) (9602 - (ViewConfiguration.getScrollBarSize() >> 8));
                    int i491112 = -(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                    int i491113 = (i491112 & 861) + (i491112 | 861);
                    int i491114 = -View.MeasureSpec.getSize(0);
                    int i491115 = (i491114 & 1) + (i491114 | 1);
                    Object[] objArr101114 = new Object[1];
                    a(scrollBarSize10, i491113, i491115, objArr101114);
                    char modifierMetaStateMask11 = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 53314);
                    int i491116 = -(-TextUtils.getOffsetAfter(str6, 0));
                    Object[] objArr101115 = new Object[1];
                    a(modifierMetaStateMask11, (i491116 & 862) + (i491116 | 862), 9 - KeyEvent.getDeadChar(0, 0), objArr101115);
                    String str51114 = (String) objArr101115[0];
                    char c1119 = (char) ((-2) - (~(-(-(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))))));
                    int i491117 = -AndroidCharacter.getMirror('0');
                    int size10 = View.MeasureSpec.getSize(0);
                    int i491118 = ((size10 | 1) << 1) - (size10 ^ 1);
                    Object[] objArr101116 = new Object[1];
                    a(c1119, ((i491117 | 919) << 1) - (i491117 ^ 919), i491118, objArr101116);
                    char c21110 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 29745);
                    int i491119 = -(-TextUtils.indexOf((CharSequence) str6, '0', 0, 0));
                    int i501110 = ((i491119 | 873) << 1) - (i491119 ^ 873);
                    int i501111 = -TextUtils.indexOf((CharSequence) str6, '0');
                    int i501112 = ((i501111 | 15) << 1) - (i501111 ^ 15);
                    Object[] objArr101117 = new Object[1];
                    a(c21110, i501110, i501112, objArr101117);
                    String str51115 = (String) objArr101117[0];
                    char c21111 = (char) (21511 - (~ExpandableListView.getPackedPositionType(0L)));
                    int longPressTimeout13 = ViewConfiguration.getLongPressTimeout() >> 16;
                    int i501113 = (longPressTimeout13 & 714) + (longPressTimeout13 | 714);
                    int i501114 = -(Process.myPid() >> 22);
                    int i501115 = (i501114 ^ 3) + ((i501114 & 3) << 1);
                    Object[] objArr101118 = new Object[1];
                    a(c21111, i501113, i501115, objArr101118);
                    String str51116 = (String) objArr101118[0];
                    char maximumDrawingCacheSize9 = (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                    int i501116 = -(-TextUtils.indexOf((CharSequence) str6, '0', 0, 0));
                    int i501117 = ((i501116 | 660) << 1) - (i501116 ^ 660);
                    int i501118 = -View.getDefaultSize(0, 0);
                    int i501119 = (i501118 & 7) + (i501118 | 7);
                    Object[] objArr101119 = new Object[1];
                    a(maximumDrawingCacheSize9, i501117, i501119, objArr101119);
                    String str51117 = (String) objArr101119[0];
                    int i511110 = -View.resolveSize(0, 0);
                    int i511111 = -(-ExpandableListView.getPackedPositionType(0L));
                    Object[] objArr111110 = new Object[1];
                    a((char) ((i511110 ^ 30213) + ((i511110 & 30213) << 1)), (i511111 ^ com.salesforce.marketingcloud.analytics.b.q) + ((i511111 & com.salesforce.marketingcloud.analytics.b.q) << 1), TextUtils.getCapsMode(str6, 0, 0) + 8, objArr111110);
                    String str51118 = (String) objArr111110[0];
                    int i511112 = -MotionEvent.axisFromString(str6);
                    int i511113 = 671 - (~(-(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))));
                    int doubleTapTimeout11 = ViewConfiguration.getDoubleTapTimeout() >> 16;
                    int i511114 = (doubleTapTimeout11 ^ 11) + ((doubleTapTimeout11 & 11) << 1);
                    Object[] objArr111111 = new Object[1];
                    a((char) ((i511112 ^ 32917) + ((i511112 & 32917) << 1)), i511113, i511114, objArr111111);
                    String str51119 = (String) objArr111111[0];
                    int i511115 = -View.resolveSizeAndState(0, 0, 0);
                    int i511116 = 683 - (~(-(-(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))));
                    int edgeSlop10 = ViewConfiguration.getEdgeSlop() >> 16;
                    Object[] objArr111112 = new Object[1];
                    a((char) (((i511115 | 4547) << 1) - (i511115 ^ 4547)), i511116, (edgeSlop10 & 14) + (edgeSlop10 | 14), objArr111112);
                    char modifierMetaStateMask12 = (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask()));
                    int i511117 = -TextUtils.indexOf((CharSequence) str6, '0', 0, 0);
                    int i511118 = (i511117 & 895) + (i511117 | 895);
                    int longPressTimeout14 = ViewConfiguration.getLongPressTimeout() >> 16;
                    int i511119 = ((longPressTimeout14 | 20) << 1) - (longPressTimeout14 ^ 20);
                    Object[] objArr111113 = new Object[1];
                    a(modifierMetaStateMask12, i511118, i511119, objArr111113);
                    String str61110 = (String) objArr111113[0];
                    char offsetAfter9 = (char) TextUtils.getOffsetAfter(str6, 0);
                    int threadPriority9 = Process.getThreadPriority(0);
                    int i521110 = -(-(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                    int i521111 = (i521110 ^ 20) + ((i521110 & 20) << 1);
                    Object[] objArr111114 = new Object[1];
                    a(offsetAfter9, (((threadPriority9 & 20) + (threadPriority9 | 20)) >> 6) + 916, i521111, objArr111114);
                    String str61111 = (String) objArr111114[0];
                    char c21112 = (char) (21822 - (~(-(-Gravity.getAbsoluteGravity(0, 0)))));
                    int iIndexOf115 = TextUtils.indexOf(str6, str6, 0, 0);
                    int iIPostMessageServiceStubProxy115 = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                    int i521112 = ~iIndexOf115;
                    int i521113 = ~iIPostMessageServiceStubProxy115;
                    int i521114 = ~((i521113 & i521112) | (i521112 ^ i521113));
                    int i521115 = ~((-936) | iIPostMessageServiceStubProxy115);
                    int i521116 = (((iIndexOf115 * (-574)) - 536690) - (~(((i521114 ^ i521115) | (i521114 & i521115)) * 1150))) - 1;
                    int i521117 = ~(((-936) & iIPostMessageServiceStubProxy115) | ((-936) ^ iIPostMessageServiceStubProxy115));
                    int i521118 = ~iIPostMessageServiceStubProxy115;
                    int i521119 = ~((i521118 ^ 935) | (i521118 & 935));
                    int i531110 = i521116 + (((i521119 & i521117) | (i521117 ^ i521119)) * (-575));
                    int i531111 = ((~((iIPostMessageServiceStubProxy115 & i521112) | (i521112 ^ iIPostMessageServiceStubProxy115))) | (~((i521118 ^ iIndexOf115) | (iIndexOf115 & i521118)))) * 575;
                    int i531112 = (i531110 & i531111) + (i531111 | i531110);
                    int iAxisFromString4 = MotionEvent.axisFromString(str6);
                    int i531113 = (iAxisFromString4 ^ 32) + ((iAxisFromString4 & 32) << 1);
                    Object[] objArr111115 = new Object[1];
                    a(c21112, i531112, i531113, objArr111115);
                    String str61112 = (String) objArr111115[0];
                    int i531114 = -Process.getGidForName(str6);
                    int i531115 = -KeyEvent.normalizeMetaState(0);
                    int i531116 = ((i531115 | 966) << 1) - (i531115 ^ 966);
                    int i531117 = -(ViewConfiguration.getScrollDefaultDelay() >> 16);
                    int i531118 = ((i531117 | 26) << 1) - (i531117 ^ 26);
                    Object[] objArr111116 = new Object[1];
                    a((char) ((i531114 ^ 29772) + ((i531114 & 29772) << 1)), i531116, i531118, objArr111116);
                    String str61113 = (String) objArr111116[0];
                    char c21113 = (char) (9581 - (~(-(ViewConfiguration.getPressedStateDuration() >> 16))));
                    int i531119 = -TextUtils.indexOf((CharSequence) str6, '0', 0, 0);
                    int i541110 = (i531119 ^ 991) + ((i531119 & 991) << 1);
                    int i541111 = -(ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    int i541112 = ((i541111 | 23) << 1) - (i541111 ^ 23);
                    Object[] objArr111117 = new Object[1];
                    a(c21113, i541110, i541112, objArr111117);
                    String str61114 = (String) objArr111117[0];
                    int i541113 = -Color.rgb(0, 0, 0);
                    Object[] objArr111118 = new Object[1];
                    a((char) ((i541113 ^ (-16767899)) + ((i541113 & (-16767899)) << 1)), 1014 - (~(-(-View.MeasureSpec.getSize(0)))), 31 - (~(-TextUtils.lastIndexOf(str6, '0'))), objArr111118);
                    String str61115 = (String) objArr111118[0];
                    str8 = str6;
                    char cResolveSizeAndState6 = (char) View.resolveSizeAndState(0, 0, 0);
                    int touchSlop11 = ViewConfiguration.getTouchSlop() >> 8;
                    int i541114 = (touchSlop11 ^ 1048) + ((touchSlop11 & 1048) << 1);
                    int i541115 = -(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                    int i541116 = (i541115 & 13) + (i541115 | 13);
                    Object[] objArr111119 = new Object[1];
                    a(cResolveSizeAndState6, i541114, i541116, objArr111119);
                    String str61116 = (String) objArr111119[0];
                    int absoluteGravity11 = Gravity.getAbsoluteGravity(0, 0);
                    char c21114 = (char) ((absoluteGravity11 & 23047) + (absoluteGravity11 | 23047));
                    int keyRepeatDelay113 = 627 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                    int i541117 = -(ViewConfiguration.getLongPressTimeout() >> 16);
                    int i541118 = (i541117 ^ 7) + ((i541117 & 7) << 1);
                    Object[] objArr121110 = new Object[1];
                    a(c21114, keyRepeatDelay113, i541118, objArr121110);
                    int packedPositionChild7 = ExpandableListView.getPackedPositionChild(0L);
                    int scrollDefaultDelay4 = 1061 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                    int i541119 = -KeyEvent.normalizeMetaState(0);
                    int i551110 = ((i541119 | 30) << 1) - (i541119 ^ 30);
                    Object[] objArr121111 = new Object[1];
                    a((char) (((packedPositionChild7 | 1) << 1) - (packedPositionChild7 ^ 1)), scrollDefaultDelay4, i551110, objArr121111);
                    String str61117 = (String) objArr121111[0];
                    int i551111 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                    int i551112 = (i551111 * 866) - 5501952;
                    int i551113 = ~i551111;
                    int i551114 = -(-(((~((i551113 & i169) | (i551113 ^ i169))) | (-6369)) * (-865)));
                    int i551115 = (((i551112 & i551114) + (i551112 | i551114)) - (~((~((i551111 ^ i) | (i551111 & i))) * 865))) - 1;
                    int i551116 = ~(((-6369) ^ i169) | ((-6369) & i169));
                    int i551117 = ~((i551111 & i169) | (i169 ^ i551111));
                    int i551118 = ((i551117 & i551116) | (i551116 ^ i551117)) * 865;
                    char c21115 = (char) ((i551115 ^ i551118) + ((i551118 & i551115) << 1));
                    int i551119 = -(-View.MeasureSpec.getSize(0));
                    int i561110 = (i551119 ^ 1091) + ((i551119 & 1091) << 1);
                    int iIndexOf116 = TextUtils.indexOf((CharSequence) str8, '0', 0);
                    int iIPostMessageServiceStubProxy116 = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                    int i561111 = (iIndexOf116 * (-380)) + 4584;
                    int i561112 = ~iIndexOf116;
                    int i561113 = -(-((iIPostMessageServiceStubProxy116 | 12 | i561112) * (-381)));
                    int i561114 = (i561111 & i561113) + (i561111 | i561113);
                    int i561115 = ~((~iIndexOf116) | (-13));
                    int i561116 = ~iIPostMessageServiceStubProxy116;
                    int i561117 = (~((i561116 & 12) | (i561116 ^ 12))) | i561115;
                    int i561118 = ~((iIndexOf116 ^ 12) | (iIndexOf116 & 12));
                    int i561119 = (i561114 - (~(((i561117 & i561118) | (i561117 ^ i561118)) * 381))) - 1;
                    int i571110 = (~(i561112 | 12)) * 381;
                    int i571111 = ((i561119 | i571110) << 1) - (i571110 ^ i561119);
                    Object[] objArr121112 = new Object[1];
                    a(c21115, i561110, i571111, objArr121112);
                    int iIndexOf117 = TextUtils.indexOf((CharSequence) str8, '0', 0);
                    int i571112 = -(ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    Object[] objArr121113 = new Object[1];
                    a((char) (((iIndexOf117 | 26730) << 1) - (iIndexOf117 ^ 26730)), (i571112 ^ 1102) + ((i571112 & 1102) << 1), 18 - (~(-(-TextUtils.indexOf(str8, str8, 0, 0)))), objArr121113);
                    String str61118 = (String) objArr121113[0];
                    char c21116 = (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                    int i571113 = -KeyEvent.normalizeMetaState(0);
                    int i571114 = ((i571113 | 1121) << 1) - (i571113 ^ 1121);
                    int scrollBarSize11 = ViewConfiguration.getScrollBarSize() >> 8;
                    int i571115 = (scrollBarSize11 ^ 5) + ((scrollBarSize11 & 5) << 1);
                    Object[] objArr121114 = new Object[1];
                    a(c21116, i571114, i571115, objArr121114);
                    char keyRepeatTimeout114 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                    int i571116 = (-16776091) - (~(-Color.rgb(0, 0, 0)));
                    int iResolveSize7 = View.resolveSize(0, 0);
                    int i571117 = ((iResolveSize7 | 19) << 1) - (iResolveSize7 ^ 19);
                    Object[] objArr121115 = new Object[1];
                    a(keyRepeatTimeout114, i571116, i571117, objArr121115);
                    char cIndexOf19 = (char) TextUtils.indexOf(str8, str8, 0, 0);
                    int iGreen8 = Color.green(0);
                    int i571118 = ((iGreen8 | 1145) << 1) - (iGreen8 ^ 1145);
                    int i571119 = -(-AndroidCharacter.getMirror('0'));
                    int i581110 = (i571119 ^ (-32)) + ((i571119 & (-32)) << 1);
                    Object[] objArr121116 = new Object[1];
                    a(cIndexOf19, i571118, i581110, objArr121116);
                    int i581111 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                    Object[] objArr121117 = new Object[1];
                    a((char) (((i581111 | 43328) << 1) - (i581111 ^ 43328)), 1160 - (~(-(-View.resolveSize(0, 0)))), 18 - (~(ViewConfiguration.getLongPressTimeout() >> 16)), objArr121117);
                    int i581112 = -(Process.myPid() >> 22);
                    int i581113 = -(-ExpandableListView.getPackedPositionType(0L));
                    int i581114 = (i581113 & 1180) + (i581113 | 1180);
                    int i581115 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                    int i581116 = i581115 * (-1975);
                    int i581117 = (i581116 & 18791) + (i581116 | 18791);
                    int i581118 = ~i581115;
                    int i581119 = ~(i581118 | 19);
                    int i591110 = i581117 + (((i581119 & i) | (i ^ i581119)) * 988);
                    int i591111 = ~((-20) | i581115);
                    int i591112 = ~(i581115 | i169);
                    int i591113 = -(-(((i591112 & i591111) | (i591111 ^ i591112)) * (-1976)));
                    int i591114 = (i591110 ^ i591113) + ((i591113 & i591110) << 1);
                    int i591115 = ~((i581118 & 19) | (i581118 ^ 19));
                    int i591116 = ~(((-20) & i) | ((-20) ^ i));
                    int i591117 = (i591115 & i591116) | (i591115 ^ i591116);
                    int i591118 = ~((i169 ^ 19) | (i169 & 19));
                    int i591119 = -(-(((i591117 & i591118) | (i591117 ^ i591118)) * 988));
                    int i601110 = (i591114 & i591119) + (i591119 | i591114);
                    Object[] objArr121118 = new Object[1];
                    a((char) (((i581112 | 31256) << 1) - (i581112 ^ 31256)), i581114, i601110, objArr121118);
                    int i601111 = -(-TextUtils.indexOf((CharSequence) str8, '0', 0, 0));
                    int i601112 = -AndroidCharacter.getMirror('0');
                    Object[] objArr121119 = new Object[1];
                    a((char) ((i601111 & 61337) + (i601111 | 61337)), ((i601112 | 1247) << 1) - (i601112 ^ 1247), 23 - (KeyEvent.getMaxKeyCode() >> 16), objArr121119);
                    int i601113 = -(ViewConfiguration.getDoubleTapTimeout() >> 16);
                    int i601114 = -(-(i601113 * (-963)));
                    int i601115 = (i601114 & (-964)) + (i601114 | (-964)) + 43534045;
                    int i601116 = ~i601113;
                    int i601117 = ~(((-45114) ^ i) | ((-45114) & i));
                    int i601118 = i601115 + (((i601116 & i601117) | (i601116 ^ i601117)) * (-964));
                    int i601119 = -(-(((~(i601113 | (-45114))) | (~(((-45114) ^ i169) | ((-45114) & i169)))) * (-964)));
                    char c21117 = (char) ((i601118 & i601119) + (i601119 | i601118));
                    int i611110 = -View.resolveSize(0, 0);
                    int i611111 = (i611110 ^ 1222) + ((i611110 & 1222) << 1);
                    int i611112 = -(-(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                    int i611113 = (i611112 & 20) + (i611112 | 20);
                    Object[] objArr131114 = new Object[1];
                    a(c21117, i611111, i611113, objArr131114);
                    int i611114 = -(-(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                    int i611115 = -Color.rgb(0, 0, 0);
                    int i611116 = ((i611115 | (-16775973)) << 1) - (i611115 ^ (-16775973));
                    int i611117 = -ExpandableListView.getPackedPositionType(0L);
                    int i611118 = (i611117 & 24) + (i611117 | 24);
                    Object[] objArr131115 = new Object[1];
                    a((char) (((i611114 | 26190) << 1) - (i611114 ^ 26190)), i611116, i611118, objArr131115);
                    String str61119 = str;
                    char c21118 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                    int i611119 = -View.MeasureSpec.getSize(0);
                    Object[] objArr131116 = new Object[1];
                    a(c21118, ((i611119 | 1267) << 1) - (i611119 ^ 1267), View.getDefaultSize(0, 0) + 28, objArr131116);
                    char c21119 = (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                    int i621112 = -Color.rgb(0, 0, 0);
                    Object[] objArr131117 = new Object[1];
                    a(c21119, (i621112 ^ (-16775921)) + ((i621112 & (-16775921)) << 1), 26 - (~(-(-(Process.myPid() >> 22)))), objArr131117);
                    char c311 = (char) (29032 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                    int i621113 = 1321 - (~ExpandableListView.getPackedPositionGroup(0L));
                    int i621114 = -Color.blue(0);
                    int i621115 = (i621114 & 31) + (i621114 | 31);
                    Object[] objArr131118 = new Object[1];
                    a(c311, i621113, i621115, objArr131118);
                    char defaultSize6 = (char) (14167 - View.getDefaultSize(0, 0));
                    int i621116 = 1352 - (~(ViewConfiguration.getMinimumFlingVelocity() >> 16));
                    int size11 = View.MeasureSpec.getSize(0);
                    int i621117 = ((size11 | 27) << 1) - (size11 ^ 27);
                    Object[] objArr131119 = new Object[1];
                    a(defaultSize6, i621116, i621117, objArr131119);
                    int i621118 = -KeyEvent.normalizeMetaState(0);
                    int maximumDrawingCacheSize10 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 1380;
                    int scrollBarSize12 = ViewConfiguration.getScrollBarSize() >> 8;
                    int i621119 = (scrollBarSize12 ^ 32) + ((scrollBarSize12 & 32) << 1);
                    Object[] objArr13121 = new Object[1];
                    a((char) (((i621118 | 35676) << 1) - (i621118 ^ 35676)), maximumDrawingCacheSize10, i621119, objArr13121);
                    strArr3 = new String[][]{new String[]{str3111, str41110, str41111, (String) objArr81111[0]}, new String[]{str41112, str41113, str41114, str41115, (String) objArr91110[0]}, new String[]{str41116, str41117, str, str41118, str41119, str51110}, strArr111, new String[]{str51111, str51112, (String) objArr101112[0]}, new String[]{str51113, (String) objArr101114[0]}, new String[]{str51114, (String) objArr101116[0]}, new String[]{str51115, str51116, str51117, str51118, str51119, (String) objArr111112[0]}, new String[]{str61110, str61111, str61112, str61113, str61114, str61115, str}, new String[]{str61116, (String) objArr121110[0]}, new String[]{str61117, (String) objArr121112[0]}, new String[]{str61118, (String) objArr121114[0]}, new String[]{(String) objArr121115[0]}, new String[]{(String) objArr121116[0]}, new String[]{(String) objArr121117[0]}, new String[]{(String) objArr121118[0]}, new String[]{(String) objArr121119[0]}, new String[]{(String) objArr131114[0]}, new String[]{(String) objArr131115[0], str61119}, new String[]{(String) objArr131116[0], str61119}, new String[]{(String) objArr131117[0], str61119}, new String[]{(String) objArr131118[0], str61119}, new String[]{(String) objArr131119[0], str61119}, new String[]{(String) objArr13121[0], str61119}};
                    arrayList = new ArrayList();
                    i32 = i;
                    i33 = 0;
                    i34 = 0;
                    while (i33 < 24) {
                        int i62121 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        i40 = (i62121 & 73) + (i62121 | 73);
                        artificialFrame = i40 % 128;
                        if (i40 % 2 == 0) {
                            strArr4 = strArr3[i33];
                            Object[] objArr1324 = {strArr4[1]};
                            objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                            if (objAccessartificialFrame11 == null) {
                                int minimumFlingVelocity8 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 23;
                                char mirror11 = (char) (AndroidCharacter.getMirror('0') - '0');
                                int minimumFlingVelocity9 = 2441 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                                byte[] bArr1112 = $$a;
                                Object[] objArr1325 = new Object[1];
                                b((byte) 49, bArr1112[16], bArr1112[10], objArr1325);
                                objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity8, mirror11, minimumFlingVelocity9, 954751276, false, (String) objArr1325[0], new Class[]{String.class});
                            }
                            str10 = (String) ((Method) objAccessartificialFrame11).invoke(null, objArr1324);
                            strArr5 = (String[]) Arrays.copyOfRange(strArr4, 1, strArr4.length);
                            if (str10 != null) {
                                i41 = artificialFrame + 27;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i41 % 128;
                                if (i41 % 2 != 0) {
                                    int i6211110 = 23 / 0;
                                    if (str10.length() != 0) {
                                        if (strArr4.length != 1) {
                                            Object[] objArr1311110 = {str10, strArr5};
                                            objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(311378445);
                                            if (objAccessartificialFrame10 == null) {
                                                int keyRepeatDelay114 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 29;
                                                char keyRepeatTimeout115 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                                                int i631111110 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + FrameMetricsAggregator.EVERY_DURATION;
                                                byte b118 = $$a[16];
                                                byte b119 = b118;
                                                Object[] objArr141110 = new Object[1];
                                                b(b119, (byte) (b119 | 7), b118, objArr141110);
                                                objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay114, keyRepeatTimeout115, i631111110, -1914043387, false, (String) objArr141110[0], new Class[]{String.class, String[].class});
                                            }
                                            long jLongValue116 = ((Long) ((Method) objAccessartificialFrame10).invoke(null, objArr1311110)).longValue();
                                            long j7111114 = -1961190699;
                                            strArr6 = strArr3;
                                            long j7111115 = -406;
                                            long j7111116 = jLongValue116 ^ j20;
                                            i42 = i33;
                                            long jUptimeMillis13 = (int) SystemClock.uptimeMillis();
                                            long j7111117 = jUptimeMillis13 ^ j20;
                                            long j814 = (((long) (-405)) * j7111114) + (((long) 407) * jLongValue116) + ((((j7111116 | jUptimeMillis13) ^ j20) | (((j7111117 | j7111114) | jLongValue116) ^ j20)) * j7111115) + (j7111115 * (((j7111116 | j7111117) | j7111114) ^ j20)) + (((long) 406) * (((jUptimeMillis13 | (j7111114 ^ j20)) ^ j20) | ((j7111117 | jLongValue116) ^ j20))) + ((long) 1986464153);
                                            i43 = ((int) (j814 >> 32)) & (785016995 + (((~(132250616 | i)) | 1304975794) * 191) + (((~(132250616 | i169)) | 1208483842) * 191));
                                            int elapsedCpuTime116 = (int) Process.getElapsedCpuTime();
                                            i44 = ((int) j814) & (922154449 + (((~(1909484194 | elapsedCpuTime116)) | (-948256692)) * (-668)) + ((1909484194 | (~((-948256692) | elapsedCpuTime116))) * 1336) + ((elapsedCpuTime116 | (-134550802)) * 668));
                                            if (((i43 & i44) | (i43 ^ i44)) != 0) {
                                            }
                                        } else {
                                            strArr6 = strArr3;
                                            i42 = i33;
                                        }
                                        int i631111111 = ((i34 | 1) << 1) - (i34 ^ 1);
                                        int i631111112 = ((i42 | 10) << 1) - (i42 ^ 10);
                                        int i631111113 = (i631111112 & i169) | ((~i631111112) & i);
                                        StringBuilder sb13 = new StringBuilder();
                                        sb13.append(str10);
                                        char deadChar111 = (char) KeyEvent.getDeadChar(0, 0);
                                        int i631111114 = -(-(ViewConfiguration.getEdgeSlop() >> 16));
                                        Object[] objArr141111 = new Object[1];
                                        a(deadChar111, (i631111114 & 1412) + (i631111114 | 1412), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), objArr141111);
                                        sb13.append((String) objArr141111[0]);
                                        sb13.append(str10);
                                        arrayList.add(sb13.toString());
                                        i34 = i631111111;
                                        i32 = i631111113;
                                    }
                                    i32 = i32;
                                } else {
                                    if (str10.length() != 0) {
                                        if (strArr4.length != 1) {
                                            Object[] objArr1311111 = {str10, strArr5};
                                            objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(311378445);
                                            if (objAccessartificialFrame10 == null) {
                                                int keyRepeatDelay115 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 29;
                                                char keyRepeatTimeout116 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                                                int i631111115 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + FrameMetricsAggregator.EVERY_DURATION;
                                                byte b1110 = $$a[16];
                                                byte b1111 = b1110;
                                                Object[] objArr141112 = new Object[1];
                                                b(b1111, (byte) (b1111 | 7), b1110, objArr141112);
                                                objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay115, keyRepeatTimeout116, i631111115, -1914043387, false, (String) objArr141112[0], new Class[]{String.class, String[].class});
                                            }
                                            long jLongValue117 = ((Long) ((Method) objAccessartificialFrame10).invoke(null, objArr1311111)).longValue();
                                            long j7111118 = -1961190699;
                                            strArr6 = strArr3;
                                            long j7111119 = -406;
                                            long j71111110 = jLongValue117 ^ j20;
                                            i42 = i33;
                                            long jUptimeMillis14 = (int) SystemClock.uptimeMillis();
                                            long j71111111 = jUptimeMillis14 ^ j20;
                                            long j815 = (((long) (-405)) * j7111118) + (((long) 407) * jLongValue117) + ((((j71111110 | jUptimeMillis14) ^ j20) | (((j71111111 | j7111118) | jLongValue117) ^ j20)) * j7111119) + (j7111119 * (((j71111110 | j71111111) | j7111118) ^ j20)) + (((long) 406) * (((jUptimeMillis14 | (j7111118 ^ j20)) ^ j20) | ((j71111111 | jLongValue117) ^ j20))) + ((long) 1986464153);
                                            i43 = ((int) (j815 >> 32)) & (785016995 + (((~(132250616 | i)) | 1304975794) * 191) + (((~(132250616 | i169)) | 1208483842) * 191));
                                            int elapsedCpuTime117 = (int) Process.getElapsedCpuTime();
                                            i44 = ((int) j815) & (922154449 + (((~(1909484194 | elapsedCpuTime117)) | (-948256692)) * (-668)) + ((1909484194 | (~((-948256692) | elapsedCpuTime117))) * 1336) + ((elapsedCpuTime117 | (-134550802)) * 668));
                                            if (((i43 & i44) | (i43 ^ i44)) != 0) {
                                            }
                                        } else {
                                            strArr6 = strArr3;
                                            i42 = i33;
                                        }
                                        int i631111116 = ((i34 | 1) << 1) - (i34 ^ 1);
                                        int i631111117 = ((i42 | 10) << 1) - (i42 ^ 10);
                                        int i631111118 = (i631111117 & i169) | ((~i631111117) & i);
                                        StringBuilder sb14 = new StringBuilder();
                                        sb14.append(str10);
                                        char deadChar112 = (char) KeyEvent.getDeadChar(0, 0);
                                        int i631111119 = -(-(ViewConfiguration.getEdgeSlop() >> 16));
                                        Object[] objArr141113 = new Object[1];
                                        a(deadChar112, (i631111119 & 1412) + (i631111119 | 1412), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), objArr141113);
                                        sb14.append((String) objArr141113[0]);
                                        sb14.append(str10);
                                        arrayList.add(sb14.toString());
                                        i34 = i631111116;
                                        i32 = i631111118;
                                    }
                                    i32 = i32;
                                }
                            }
                            i33 = i42 + 1;
                            str8 = str8;
                            strArr3 = strArr6;
                        } else {
                            str8 = str8;
                            i32 = i32;
                            strArr4 = strArr3[i33];
                            Object[] objArr141114 = {strArr4[0]};
                            objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                            if (objAccessartificialFrame9 == null) {
                                int i641110 = 23 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                                char packedPositionChild8 = (char) ((-1) - ExpandableListView.getPackedPositionChild(0L));
                                int touchSlop12 = 2441 - (ViewConfiguration.getTouchSlop() >> 8);
                                byte[] bArr1113 = $$a;
                                Object[] objArr141115 = new Object[1];
                                b((byte) 49, bArr1113[16], bArr1113[10], objArr141115);
                                objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(i641110, packedPositionChild8, touchSlop12, 954751276, false, (String) objArr141115[0], new Class[]{String.class});
                            }
                            str10 = (String) ((Method) objAccessartificialFrame9).invoke(null, objArr141114);
                            strArr5 = (String[]) Arrays.copyOfRange(strArr4, 1, strArr4.length);
                            if (str10 != null) {
                                i41 = artificialFrame + 27;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i41 % 128;
                                if (i41 % 2 != 0) {
                                    int i6211111 = 23 / 0;
                                    if (str10.length() != 0) {
                                        if (strArr4.length != 1) {
                                            Object[] objArr1311112 = {str10, strArr5};
                                            objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(311378445);
                                            if (objAccessartificialFrame10 == null) {
                                                int keyRepeatDelay116 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 29;
                                                char keyRepeatTimeout117 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                                                int i6311111110 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + FrameMetricsAggregator.EVERY_DURATION;
                                                byte b1112 = $$a[16];
                                                byte b1113 = b1112;
                                                Object[] objArr141116 = new Object[1];
                                                b(b1113, (byte) (b1113 | 7), b1112, objArr141116);
                                                objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay116, keyRepeatTimeout117, i6311111110, -1914043387, false, (String) objArr141116[0], new Class[]{String.class, String[].class});
                                            }
                                            long jLongValue118 = ((Long) ((Method) objAccessartificialFrame10).invoke(null, objArr1311112)).longValue();
                                            long j71111112 = -1961190699;
                                            strArr6 = strArr3;
                                            long j71111113 = -406;
                                            long j71111114 = jLongValue118 ^ j20;
                                            i42 = i33;
                                            long jUptimeMillis15 = (int) SystemClock.uptimeMillis();
                                            long j71111115 = jUptimeMillis15 ^ j20;
                                            long j816 = (((long) (-405)) * j71111112) + (((long) 407) * jLongValue118) + ((((j71111114 | jUptimeMillis15) ^ j20) | (((j71111115 | j71111112) | jLongValue118) ^ j20)) * j71111113) + (j71111113 * (((j71111114 | j71111115) | j71111112) ^ j20)) + (((long) 406) * (((jUptimeMillis15 | (j71111112 ^ j20)) ^ j20) | ((j71111115 | jLongValue118) ^ j20))) + ((long) 1986464153);
                                            i43 = ((int) (j816 >> 32)) & (785016995 + (((~(132250616 | i)) | 1304975794) * 191) + (((~(132250616 | i169)) | 1208483842) * 191));
                                            int elapsedCpuTime118 = (int) Process.getElapsedCpuTime();
                                            i44 = ((int) j816) & (922154449 + (((~(1909484194 | elapsedCpuTime118)) | (-948256692)) * (-668)) + ((1909484194 | (~((-948256692) | elapsedCpuTime118))) * 1336) + ((elapsedCpuTime118 | (-134550802)) * 668));
                                            if (((i43 & i44) | (i43 ^ i44)) != 0) {
                                            }
                                        } else {
                                            strArr6 = strArr3;
                                            i42 = i33;
                                        }
                                        int i6311111111 = ((i34 | 1) << 1) - (i34 ^ 1);
                                        int i6311111112 = ((i42 | 10) << 1) - (i42 ^ 10);
                                        int i6311111113 = (i6311111112 & i169) | ((~i6311111112) & i);
                                        StringBuilder sb15 = new StringBuilder();
                                        sb15.append(str10);
                                        char deadChar113 = (char) KeyEvent.getDeadChar(0, 0);
                                        int i6311111114 = -(-(ViewConfiguration.getEdgeSlop() >> 16));
                                        Object[] objArr141117 = new Object[1];
                                        a(deadChar113, (i6311111114 & 1412) + (i6311111114 | 1412), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), objArr141117);
                                        sb15.append((String) objArr141117[0]);
                                        sb15.append(str10);
                                        arrayList.add(sb15.toString());
                                        i34 = i6311111111;
                                        i32 = i6311111113;
                                    }
                                    i32 = i32;
                                } else {
                                    if (str10.length() != 0) {
                                        if (strArr4.length != 1) {
                                            Object[] objArr1311113 = {str10, strArr5};
                                            objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(311378445);
                                            if (objAccessartificialFrame10 == null) {
                                                int keyRepeatDelay117 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 29;
                                                char keyRepeatTimeout118 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                                                int i6311111115 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + FrameMetricsAggregator.EVERY_DURATION;
                                                byte b1114 = $$a[16];
                                                byte b1115 = b1114;
                                                Object[] objArr141118 = new Object[1];
                                                b(b1115, (byte) (b1115 | 7), b1114, objArr141118);
                                                objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay117, keyRepeatTimeout118, i6311111115, -1914043387, false, (String) objArr141118[0], new Class[]{String.class, String[].class});
                                            }
                                            long jLongValue119 = ((Long) ((Method) objAccessartificialFrame10).invoke(null, objArr1311113)).longValue();
                                            long j71111116 = -1961190699;
                                            strArr6 = strArr3;
                                            long j71111117 = -406;
                                            long j71111118 = jLongValue119 ^ j20;
                                            i42 = i33;
                                            long jUptimeMillis16 = (int) SystemClock.uptimeMillis();
                                            long j71111119 = jUptimeMillis16 ^ j20;
                                            long j817 = (((long) (-405)) * j71111116) + (((long) 407) * jLongValue119) + ((((j71111118 | jUptimeMillis16) ^ j20) | (((j71111119 | j71111116) | jLongValue119) ^ j20)) * j71111117) + (j71111117 * (((j71111118 | j71111119) | j71111116) ^ j20)) + (((long) 406) * (((jUptimeMillis16 | (j71111116 ^ j20)) ^ j20) | ((j71111119 | jLongValue119) ^ j20))) + ((long) 1986464153);
                                            i43 = ((int) (j817 >> 32)) & (785016995 + (((~(132250616 | i)) | 1304975794) * 191) + (((~(132250616 | i169)) | 1208483842) * 191));
                                            int elapsedCpuTime119 = (int) Process.getElapsedCpuTime();
                                            i44 = ((int) j817) & (922154449 + (((~(1909484194 | elapsedCpuTime119)) | (-948256692)) * (-668)) + ((1909484194 | (~((-948256692) | elapsedCpuTime119))) * 1336) + ((elapsedCpuTime119 | (-134550802)) * 668));
                                            if (((i43 & i44) | (i43 ^ i44)) != 0) {
                                            }
                                        } else {
                                            strArr6 = strArr3;
                                            i42 = i33;
                                        }
                                        int i6311111116 = ((i34 | 1) << 1) - (i34 ^ 1);
                                        int i6311111117 = ((i42 | 10) << 1) - (i42 ^ 10);
                                        int i6311111118 = (i6311111117 & i169) | ((~i6311111117) & i);
                                        StringBuilder sb16 = new StringBuilder();
                                        sb16.append(str10);
                                        char deadChar114 = (char) KeyEvent.getDeadChar(0, 0);
                                        int i6311111119 = -(-(ViewConfiguration.getEdgeSlop() >> 16));
                                        Object[] objArr141119 = new Object[1];
                                        a(deadChar114, (i6311111119 & 1412) + (i6311111119 | 1412), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), objArr141119);
                                        sb16.append((String) objArr141119[0]);
                                        sb16.append(str10);
                                        arrayList.add(sb16.toString());
                                        i34 = i6311111116;
                                        i32 = i6311111118;
                                    }
                                    i32 = i32;
                                }
                            }
                            i33 = i42 + 1;
                            str8 = str8;
                            strArr3 = strArr6;
                        }
                        strArr6 = strArr3;
                        i42 = i33;
                        i32 = i32;
                        i33 = i42 + 1;
                        str8 = str8;
                        strArr3 = strArr6;
                    }
                    str9 = str8;
                    i35 = i32;
                    if (i34 > 2) {
                        objArr = new Object[]{arrayList, new int[]{(i64114 | i64115) & (~(i64114 & i64115))}, null, new int[]{i}, new int[]{i35}};
                        int i641111 = (-1) - (~(-(-(((1283078155 + (((~((-397000172) | i169)) | (~((-208448287) | i))) * (-370))) + ((((~((-397000172) | i)) | (~((-208448287) | i169))) | (-535674880)) * (-370))) - 631209984))));
                        int i641112 = i641111 << 13;
                        int i641113 = (i641112 & (~i641111)) | ((~i641112) & i641111);
                        int i641114 = i641113 ^ (i641113 >>> 17);
                        int i641115 = i641114 << 5;
                        i37 = 0;
                        c3 = 4;
                        i36 = 1;
                    } else {
                        objArr = new Object[]{null, new int[1], null, new int[]{i}, new int[]{i}};
                        int elapsedCpuTime1110 = (int) Process.getElapsedCpuTime();
                        int i641116 = 2063318369 + (((~((-439154682) | elapsedCpuTime1110)) | 136868112) * 104) + ((~((~elapsedCpuTime1110) | 468580345)) * (-104)) + ((elapsedCpuTime1110 | 166293776) * 104);
                        int i641117 = (-1) - (~(-(-((i641116 << 1) - i641116))));
                        int i641118 = (i641117 << 13) ^ i641117;
                        int i641119 = i641118 ^ (i641118 >>> 17);
                        int i65111 = i641119 << 5;
                        int i65112 = (i641119 | i65111) & (~(i641119 & i65111));
                        i36 = 1;
                        i37 = 0;
                        ((int[]) objArr[1])[0] = i65112;
                        c3 = 4;
                    }
                    i38 = ((int[]) objArr[c3])[i37];
                    if (i38 != i) {
                        objArr2 = new Object[5];
                        objArr2[i36] = new int[i36];
                        int[] iArr9 = new int[i36];
                        objArr2[3] = iArr9;
                        int[] iArr10 = new int[i36];
                        objArr2[c3] = iArr10;
                        List list4 = (List) objArr[i37];
                        iArr9[i37] = i;
                        iArr10[i37] = i38;
                        objArr2[i37] = list4;
                        objArr2[2] = null;
                        int elapsedCpuTime1111 = (int) Process.getElapsedCpuTime();
                        int i65113 = i3 + (-441151705) + (((~((-57940110) | elapsedCpuTime1111)) | 50331781) * (-140)) + ((~((-7608329) | elapsedCpuTime1111)) * 70) + (((~(elapsedCpuTime1111 | 663388567)) | (-620665115)) * 70) + 16;
                        int i65114 = i65113 << 13;
                        int i65115 = ((~i65113) & i65114) | ((~i65114) & i65113);
                        int i65116 = i65115 ^ (i65115 >>> 17);
                        int i65117 = i65116 << 5;
                        ((int[]) objArr2[1])[0] = (i65116 | i65117) & (~(i65116 & i65117));
                    } else {
                        i39 = i37;
                    }
                }
                char doubleTapTimeout12 = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                int iAlpha4 = Color.alpha(i39);
                int i6610 = getARTIFICIAL_FRAME_PACKAGE_NAME + 113;
                artificialFrame = i6610 % 128;
                int i6611 = i6610 % 2;
                Object[] objArr1510 = new Object[1];
                a(doubleTapTimeout12, 697 - (~iAlpha4), 15 - (~(-(-Color.alpha(0)))), objArr1510);
                Object[] objArr1511 = {(String) objArr1510[0]};
                objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                if (objAccessartificialFrame12 == null) {
                    int iGreen9 = Color.green(0) + 23;
                    str11 = str9;
                    char cIndexOf20 = (char) (TextUtils.indexOf((CharSequence) str11, '0', 0, 0) + 1);
                    int keyRepeatDelay118 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 2441;
                    byte[] bArr210 = $$a;
                    Object[] objArr1512 = new Object[1];
                    b((byte) 49, bArr210[16], bArr210[10], objArr1512);
                    objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iGreen9, cIndexOf20, keyRepeatDelay118, 954751276, false, (String) objArr1512[0], new Class[]{String.class});
                } else {
                    str11 = str9;
                }
                objInvoke2 = ((Method) objAccessartificialFrame12).invoke(null, objArr1511);
                if (objInvoke2 == null) {
                    i45 = 0;
                } else {
                    Object[] objArr1513 = {objInvoke2, 42};
                    objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-287841710);
                    if (objAccessartificialFrame13 == null) {
                        int iIndexOf118 = TextUtils.indexOf((CharSequence) str11, '0', 0, 0) + 21;
                        char cMyTid5 = (char) (Process.myTid() >> 22);
                        int touchSlop13 = (ViewConfiguration.getTouchSlop() >> 8) + 2245;
                        byte[] bArr211 = $$a;
                        Object[] objArr1514 = new Object[1];
                        b((byte) (-bArr211[22]), bArr211[c2], bArr211[10], objArr1514);
                        objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(iIndexOf118, cMyTid5, touchSlop13, 1907532890, false, (String) objArr1514[0], new Class[]{String.class, Integer.TYPE});
                    }
                    long jLongValue210 = ((Long) ((Method) objAccessartificialFrame13).invoke(null, objArr1513)).longValue();
                    long j818 = -210517596;
                    long j819 = 764;
                    long j910 = (j21 | j818) ^ j20;
                    long j911 = ((j818 ^ j20) | jLongValue210) ^ j20;
                    long j912 = (((long) 765) * j818) + (((long) (-1527)) * jLongValue210) + ((jLongValue210 | j910) * j819) + (((long) (-1528)) * (j911 | ((j21 | jLongValue210) ^ j20))) + (j819 * (j911 | (((jLongValue210 ^ j20) | j818) ^ j20) | j910)) + ((long) 1843602924);
                    int i6612 = ((int) (j912 >> 32)) & (((~((-1441952981) | i)) * TypedValues.CycleType.TYPE_EASING) + 1464859470 + (((~((-1441952981) | i169)) | (-1442018773)) * TypedValues.CycleType.TYPE_EASING));
                    int iElapsedRealtime5 = (int) SystemClock.elapsedRealtime();
                    int i6613 = ~iElapsedRealtime5;
                    i45 = i6612 | (((int) j912) & (20405895 + (((~((-358315138) | i6613)) | 16859137) * 98) + (((~(i6613 | 1795541547)) | (-358315138) | (~((-1795541548) | iElapsedRealtime5))) * (-49)) + (((~(iElapsedRealtime5 | (-358315138))) | 1778682410) * 49)));
                }
                if (i45 != 1986687685) {
                    str12 = str11;
                } else {
                    str12 = str11;
                }
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
                char c312 = (char) ((iMakeMeasureSpec2 & 60776) + (60776 | iMakeMeasureSpec2));
                int i7710 = -(ViewConfiguration.getScrollBarFadeDuration() >> 16);
                int i7711 = -TextUtils.indexOf(str12, str12, 0, 0);
                int i7712 = ((i7711 | 13) << 1) - (i7711 ^ 13);
                Object[] objArr1810 = new Object[1];
                a(c312, (i7710 ^ 1755) + ((i7710 & 1755) << 1), i7712, objArr1810);
                String str710 = (String) objArr1810[0];
                char cMakeMeasureSpec2 = (char) View.MeasureSpec.makeMeasureSpec(0, 0);
                int i7713 = -(-(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                Object[] objArr1811 = new Object[1];
                a(cMakeMeasureSpec2, (i7713 ^ 1767) + ((i7713 & 1767) << 1), 4 - (~(-(ViewConfiguration.getEdgeSlop() >> 16))), objArr1811);
                String[] strArr112 = {str710, (String) objArr1811[0]};
                int i7714 = -(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                Object[] objArr1812 = new Object[1];
                a((char) (((i7714 | 1) << 1) - (i7714 ^ 1)), 1772 - ((byte) KeyEvent.getModifierMetaStateMask()), 14 - (~(-TextUtils.getCapsMode(str12, 0, 0))), objArr1812);
                String str711 = (String) objArr1812[0];
                char absoluteGravity12 = (char) Gravity.getAbsoluteGravity(0, 0);
                int i7715 = -(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                int i7716 = ((i7715 | 1789) << 1) - (i7715 ^ 1789);
                int i7810 = -MotionEvent.axisFromString(str12);
                int i7811 = (i7810 & 18) + (i7810 | 18);
                Object[] objArr1813 = new Object[1];
                a(absoluteGravity12, i7716, i7811, objArr1813);
                String str712 = (String) objArr1813[0];
                char cResolveSizeAndState7 = (char) View.resolveSizeAndState(0, 0, 0);
                int absoluteGravity13 = Gravity.getAbsoluteGravity(0, 0);
                int i7812 = ((absoluteGravity13 | 1807) << 1) - (absoluteGravity13 ^ 1807);
                int i7813 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                int i7814 = (i7813 & 13) + (i7813 | 13);
                Object[] objArr1814 = new Object[1];
                a(cResolveSizeAndState7, i7812, i7814, objArr1814);
                String[] strArr113 = {str711, str712, (String) objArr1814[0]};
                char c313 = (char) ((-2) - ((-TextUtils.lastIndexOf(str12, '0', 0)) ^ (-1)));
                int i7815 = 1819 - (~(-(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))));
                int i7816 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                int i7817 = (i7816 ^ 21) + ((i7816 & 21) << 1);
                Object[] objArr1815 = new Object[1];
                a(c313, i7815, i7817, objArr1815);
                String str713 = (String) objArr1815[0];
                char c314 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1);
                int iMyPid3 = Process.myPid() >> 22;
                Object[] objArr1816 = new Object[1];
                a(c314, ((iMyPid3 | 1842) << 1) - (iMyPid3 ^ 1842), 9 - (~(-(-Color.red(0)))), objArr1816);
                String[] strArr114 = {str713, (String) objArr1816[0]};
                char cAxisFromString2 = (char) (7675 - MotionEvent.axisFromString(str12));
                int i7818 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 1852;
                int i7819 = -(-TextUtils.getOffsetBefore(str12, 0));
                int i7910 = (i7819 & 11) + (i7819 | 11);
                Object[] objArr1817 = new Object[1];
                a(cAxisFromString2, i7818, i7910, objArr1817);
                String str714 = (String) objArr1817[0];
                char c45 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                int trimmedLength3 = TextUtils.getTrimmedLength(str12);
                Object[] objArr1818 = new Object[1];
                a(c45, ((trimmedLength3 | 589) << 1) - (trimmedLength3 ^ 589), 5 - ((byte) KeyEvent.getModifierMetaStateMask()), objArr1818);
                c4 = 0;
                String[] strArr22 = {str714, (String) objArr1818[0]};
                char cCombineMeasuredStates3 = (char) (View.combineMeasuredStates(0, 0) + 41406);
                int doubleTapTimeout13 = ViewConfiguration.getDoubleTapTimeout() >> 16;
                Object[] objArr1819 = new Object[1];
                a(cCombineMeasuredStates3, (doubleTapTimeout13 ^ 1863) + ((doubleTapTimeout13 & 1863) << 1), 27 - (~(-(-Color.blue(0)))), objArr1819);
                String str715 = (String) objArr1819[0];
                i46 = 1;
                Object[] objArr1910 = new Object[1];
                a((char) ExpandableListView.getPackedPositionGroup(0L), 1842 - TextUtils.getOffsetBefore(str12, 0), 9 - (~(-Color.green(0))), objArr1910);
                strArr7 = new String[][]{strArr112, strArr113, strArr114, strArr22, new String[]{str715, (String) objArr1910[0]}};
                i47 = 0;
                i48 = i31;
                i49 = 5;
                loop5: while (true) {
                    if (i47 < i49) {
                        i50 = i;
                        break;
                    }
                    String[] strArr23 = strArr7[i47];
                    str13 = strArr23[c4];
                    strArr8 = (String[]) Arrays.copyOfRange(strArr23, i46, strArr23.length);
                    length = strArr8.length;
                    i56 = 0;
                    while (i56 < length) {
                        String str716 = strArr8[i56];
                        i48 = ((i48 | 1) << i46) - (i48 ^ 1);
                        file3 = new File(str13);
                        if (file3.exists()) {
                            strArr9 = strArr7;
                            strArr10 = strArr8;
                        } else {
                            strArr9 = strArr7;
                            strArr10 = strArr8;
                        }
                        i56++;
                        strArr7 = strArr9;
                        strArr8 = strArr10;
                        i46 = 1;
                    }
                    int i7911 = i47 + 78;
                    i46 = 1;
                    i47 = ((i7911 & (-77)) << 1) + (i7911 ^ (-77));
                    strArr7 = strArr7;
                    i49 = 5;
                    c4 = 0;
                }
                if (i50 != i) {
                    Object[] objArr1911 = new Object[5];
                    objArr1911[i46] = new int[i46];
                    int[] iArr11 = new int[i46];
                    objArr1911[3] = iArr11;
                    int[] iArr12 = new int[i46];
                    objArr1911[4] = iArr12;
                    iArr11[0] = i;
                    iArr12[0] = i50;
                    objArr1911[0] = null;
                    objArr1911[2] = null;
                    int i7912 = (-497965718) + (((~(i169 | (-758680880))) | (-153232422)) * (-235)) + (((~((-758680880) | i)) | (-153232422)) * (-470)) + (((~(i | (-153093158))) | (-758820144)) * 235);
                    int iIPostMessageServiceStubProxy117 = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                    int i7913 = -(-(i7912 * 829));
                    int i7914 = ((13264 | i7913) << 1) - (i7913 ^ 13264);
                    int i8010 = ~i7912;
                    int i8011 = ~((i8010 & (-17)) | ((-17) ^ i8010));
                    int i8012 = (~iIPostMessageServiceStubProxy117) | 16;
                    int i8013 = ~((i8012 & i7912) | (i8012 ^ i7912));
                    int i8014 = ((i8011 & i8013) | (i8011 ^ i8013)) * (-828);
                    int i8015 = (i7914 ^ i8014) + ((i8014 & i7914) << 1);
                    int i8016 = (i7912 ^ 16) | (i7912 & 16);
                    int i8017 = ~iIPostMessageServiceStubProxy117;
                    int i8018 = ((i8017 & i8016) | (i8016 ^ i8017)) * (-828);
                    int i8019 = -(-((((i8015 ^ i8018) + ((i8018 & i8015) << 1)) - (~((~i8016) * 828))) - 1));
                    int i8110 = (i3 ^ i8019) + ((i3 & i8019) << 1);
                    int i8111 = (i8110 << 13) ^ i8110;
                    int i8112 = i8111 >>> 17;
                    int i8113 = ((~i8111) & i8112) | ((~i8112) & i8111);
                    int i8114 = i8113 << 5;
                    ((int[]) objArr1911[1])[0] = (i8113 | i8114) & (~(i8113 & i8114));
                    return objArr1911;
                }
                Object[] objArr1912 = new Object[1];
                a((char) ExpandableListView.getPackedPositionType(0L), (Process.myPid() >> 22) + 1891, TextUtils.getOffsetAfter(str12, 0) + 13, objArr1912);
                String str717 = (String) objArr1912[0];
                char packedPositionGroup6 = (char) ExpandableListView.getPackedPositionGroup(0L);
                int modifierMetaStateMask13 = ((byte) KeyEvent.getModifierMetaStateMask()) + 1905;
                int i8115 = -(ViewConfiguration.getWindowTouchSlop() >> 8);
                int i8116 = (i8115 ^ 8) + ((i8115 & 8) << 1);
                Object[] objArr1913 = new Object[1];
                a(packedPositionGroup6, modifierMetaStateMask13, i8116, objArr1913);
                Object[] objArr1914 = {str717, (String) objArr1913[0]};
                objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-883653127);
                if (objAccessartificialFrame15 == null) {
                    int i8117 = 31 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                    char longPressTimeout15 = (char) (57022 - (ViewConfiguration.getLongPressTimeout() >> 16));
                    int i8118 = 2312 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                    byte[] bArr212 = $$a;
                    Object[] objArr1915 = new Object[1];
                    b((byte) (bArr212[13] - 1), (byte) (-bArr212[4]), bArr212[10], objArr1915);
                    objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(i8117, longPressTimeout15, i8118, 1412547569, false, (String) objArr1915[0], new Class[]{String.class, String.class});
                }
                long jLongValue211 = ((Long) ((Method) objAccessartificialFrame15).invoke(null, objArr1914)).longValue();
                long j1010 = 219577950;
                long j1011 = j1010 ^ j20;
                long elapsedCpuTime120 = (int) Process.getElapsedCpuTime();
                long j1012 = elapsedCpuTime120 ^ j20;
                long j1013 = (((long) 302) * j1010) + (((long) TypedValues.MotionType.TYPE_EASING) * jLongValue211) + (((long) (-602)) * (jLongValue211 | ((j1011 | j1012) ^ j20))) + (((long) (-301)) * (((j1011 | (jLongValue211 ^ j20)) ^ j20) | ((j1011 | elapsedCpuTime120) ^ j20) | (((j1012 | j1010) | jLongValue211) ^ j20))) + (((long) 301) * ((j1012 | jLongValue211) ^ j20)) + ((long) (-374329579));
                int i8119 = (~((-1046398404) | i169)) | 373982659;
                int i8210 = ~(1063243751 | i);
                i53 = ((int) (j1013 >> 32)) & (197960204 + ((i8119 | i8210) * (-502)) + (((~((-672415745) | i169)) | i8210) * TypedValues.PositionType.TYPE_DRAWPATH));
                int i8211 = (int) j1013;
                int iNextInt7 = new java.util.Random().nextInt();
                int i8212 = ~iNextInt7;
                i54 = i8211 & ((((~((-1998387830) | i8212)) | (~((-859353057) | iNextInt7)) | (~(i8212 | 859353056))) * 959) + 1089433716 + (((~(iNextInt7 | 859353056)) | (~(i8212 | (-859353057))) | (~((-1998387830) | iNextInt7))) * 959));
                if (((i53 & i54) | (i53 ^ i54)) != 0) {
                    i51 = (i & (-151)) | (i169 & 150);
                } else {
                    int i8213 = artificialFrame;
                    i55 = (i8213 ^ 49) + ((i8213 & 49) << 1);
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i55 % 128;
                    if (i55 % 2 == 0) {
                        Object obj3 = null;
                        obj3.hashCode();
                        throw null;
                    }
                    i51 = i;
                }
                if (i51 != i) {
                    Object[] objArr1916 = {null, new int[1], null, new int[]{i}, new int[]{i51}};
                    int iMyUid2 = Process.myUid();
                    int i8214 = (-161785490) + (((~((-672706827) | (~iMyUid2))) | 67258368) * (-591)) + ((iMyUid2 | (-672706827)) * 591);
                    int i8215 = (i8214 & 16) + (i8214 | 16);
                    int i8216 = (i3 ^ i8215) + ((i3 & i8215) << 1);
                    int i8217 = (i8216 << 13) ^ i8216;
                    int i8218 = i8217 >>> 17;
                    int i8219 = (i8217 | i8218) & (~(i8217 & i8218));
                    ((int[]) objArr1916[1])[0] = i8219 ^ (i8219 << 5);
                    return objArr1916;
                }
                char absoluteGravity14 = (char) Gravity.getAbsoluteGravity(0, 0);
                int doubleTapTimeout14 = ViewConfiguration.getDoubleTapTimeout();
                int i8310 = artificialFrame + 97;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i8310 % 128;
                int i8311 = i8310 % 2;
                int i8312 = doubleTapTimeout14 >> 16;
                Object[] objArr1917 = new Object[1];
                a(absoluteGravity14, (1912 & i8312) + (i8312 | 1912), Drawable.resolveOpacity(0, 0) + 47, objArr1917);
                String str718 = (String) objArr1917[0];
                int i8313 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i8314 = (i8313 ^ 13) + ((i8313 & 13) << 1);
                artificialFrame = i8314 % 128;
                int i8315 = i8314 % 2;
                Object[] objArr1918 = {str718};
                objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-11453480);
                if (objAccessartificialFrame14 == null) {
                    int i8316 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 16;
                    char cIndexOf110 = (char) (TextUtils.indexOf(str12, str12) + 24343);
                    int iRed2 = Color.red(0) + 2014;
                    byte[] bArr213 = $$a;
                    Object[] objArr203 = new Object[1];
                    b((byte) (-bArr213[22]), bArr213[20], (byte) (-bArr213[4]), objArr203);
                    objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(i8316, cIndexOf110, iRed2, 1614052816, false, (String) objArr203[0], new Class[]{String.class});
                }
                long jLongValue212 = ((Long) ((Method) objAccessartificialFrame14).invoke(null, objArr1918)).longValue();
                long j1014 = 78428149;
                long j113 = jLongValue212 ^ j20;
                long jElapsedRealtime8 = (int) SystemClock.elapsedRealtime();
                long j114 = jElapsedRealtime8 ^ j20;
                long j115 = (((long) 50) * j1014) + (((long) (-97)) * jLongValue212) + (((long) 98) * (((j113 | j114) ^ j20) | ((j113 | j1014) ^ j20))) + (((long) (-49)) * (j113 | (((j1014 ^ j20) | j114) ^ j20) | ((j1014 | jElapsedRealtime8) ^ j20))) + (((long) 49) * (((j113 | jElapsedRealtime8) ^ j20) | ((j1014 | jLongValue212) ^ j20))) + ((long) 1483702888);
                int i8317 = ((int) (j115 >> 32)) & ((-871420054) + (((~(23744409 | i169)) | 1409286144) * SyslogConstants.LOG_LOCAL7) + ((19548552 | i) * (-184)) + ((~((-1413482002) | i169)) * SyslogConstants.LOG_LOCAL7));
                int startElapsedRealtime7 = (int) Process.getStartElapsedRealtime();
                int i8318 = ~startElapsedRealtime7;
                int i8319 = ~((-2041828274) | i8318);
                int i8410 = (i8317 | (((int) j115) & (1625355485 + ((536957441 | i8319) * (-712)) + (((~(startElapsedRealtime7 | (-1504870833))) | (~(i8318 | (-536957442)))) * (-712)) + (((-604601864) | i8319) * 712)))) * 263;
                i52 = (i8410 & i169) | ((~i8410) & i);
                if (i52 != i) {
                    Object[] objArr204 = {null, new int[]{((~i844) & i845) | ((~i845) & i844)}, null, new int[]{i}, new int[]{i52}};
                    int i8411 = (i3 - (~(-(-((((-769471549) + ((i169 | 136479042) * 1324)) + (((~(i | 464691654)) | (~(140756803 | i))) * (-1324))) + 1065294846))))) - 1;
                    int i8412 = i8411 ^ (i8411 << 13);
                    int i8413 = i8412 >>> 17;
                    int i8414 = ((~i8412) & i8413) | ((~i8413) & i8412);
                    int i8415 = i8414 << 5;
                    return objArr204;
                }
                Object[] objArr205 = {null, new int[1], null, new int[]{i}, new int[]{i}};
                int i8416 = artificialFrame + 23;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i8416 % 128;
                int i8417 = i8416 % 2;
                int startUptimeMillis4 = (int) Process.getStartUptimeMillis();
                int i8418 = 1413520873 + (((~((-412089841) | startUptimeMillis4)) | 193358617) * (-366)) + (((~(startUptimeMillis4 | (-269063393))) | 50332169) * 366);
                int iIPostMessageServiceStubProxy118 = ConfigurationV0$1$$ExternalSyntheticLambda9.IPostMessageServiceStubProxy();
                int i8419 = i8418 * (-743);
                int i8510 = (i8419 << 1) - i8419;
                int i8511 = ~i8418;
                int i8512 = ~iIPostMessageServiceStubProxy118;
                int i8513 = (i8511 & i8512) | (i8511 ^ i8512);
                int i8514 = ~((i8418 ^ iIPostMessageServiceStubProxy118) | (i8418 & iIPostMessageServiceStubProxy118));
                int i8515 = ((i8513 & i8514) | (i8513 ^ i8514)) * (-744);
                int i8516 = (i8510 & i8515) + (i8515 | i8510);
                int i8517 = ~iIPostMessageServiceStubProxy118;
                int i8518 = ~i8418;
                int i8519 = (i8516 - (~((i8517 | (~(i8518 | (i31 ^ i8518)))) * 744))) - 1;
                int i867 = -(-((iIPostMessageServiceStubProxy118 | i8418) * 744));
                int i868 = i3 + (((i8519 | i867) << 1) - (i867 ^ i8519));
                int i869 = i868 << 13;
                int i8610 = (i868 | i869) & (~(i868 & i869));
                int i8611 = i8610 >>> 17;
                int i8612 = ((~i8610) & i8611) | ((~i8611) & i8610);
                int i8613 = i8612 << 5;
                ((int[]) objArr205[1])[0] = ((~i8612) & i8613) | ((~i8613) & i8612);
                return objArr205;
            }
            objArr2 = new Object[]{null, new int[1], null, new int[]{i}, new int[]{i14}};
            int iNextInt8 = new java.util.Random().nextInt(1319388537);
            int i2814 = ~iNextInt8;
            int i2815 = -(-((-1101664569) + (((~((-584334129) | i2814)) | (~((-21114330) | iNextInt8))) * 210) + (((~(iNextInt8 | (-580129313))) | (~(i2814 | (-16909514)))) * 210) + 16));
            int i2816 = ((i3 | i2815) << 1) - (i3 ^ i2815);
            int i2817 = i2816 << 13;
            int i2818 = (i2817 & (~i2816)) | ((~i2817) & i2816);
            int i2819 = i2818 >>> 17;
            int i2919 = (i2818 | i2819) & (~(i2818 & i2819));
            ((int[]) objArr2[1])[0] = i2919 ^ (i2919 << 5);
            return objArr2;
        }
    }

    static class ConcatenatedIterator<P> implements Iterator<P> {
        private final Iterator<P> it0;
        private final Iterator<P> it1;

        private ConcatenatedIterator(Iterator<P> it2, Iterator<P> it3) {
            this.it0 = it2;
            this.it1 = it3;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.it0.hasNext() || this.it1.hasNext();
        }

        @Override // java.util.Iterator
        public P next() {
            if (this.it0.hasNext()) {
                return this.it0.next();
            }
            return this.it1.next();
        }
    }

    public Iterable<P> getAllWithMatchingPrefix(byte[] bArr) {
        final List<P> list = this.entries.get(EMPTY_BYTES);
        final List<P> list2 = bArr.length >= 5 ? this.entries.get(Bytes.copyFrom(bArr, 0, 5)) : null;
        if (list == null && list2 == null) {
            return new ArrayList();
        }
        if (list == null) {
            return list2;
        }
        return list2 == null ? list : new Iterable<P>() { // from class: com.google.crypto.tink.internal.PrefixMap.1
            @Override // java.lang.Iterable
            public Iterator<P> iterator() {
                return new ConcatenatedIterator(list2.iterator(), list.iterator());
            }
        };
    }

    private PrefixMap(Map<Bytes, List<P>> map) {
        this.entries = map;
    }
}
