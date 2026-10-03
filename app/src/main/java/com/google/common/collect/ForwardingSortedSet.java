package com.google.common.collect;

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
import androidx.core.view.PointerIconCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.ItemTouchHelper;
import ch.qos.logback.core.joran.action.TimestampAction;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.common.base.Ascii;
import com.google.logging.type.LogSeverity;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;
import java.util.SortedSet;
import javax.annotation.CheckForNull;
import o.ArtificialStackFrames;
import o._CREATION;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes5.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingSortedSet<E> extends ForwardingSet<E> implements SortedSet<E> {
    private static long _BOUNDARY;
    private static char[] _CREATION;
    private static final byte[] $$c = {122, -14, -75, -84};
    private static final int $$d = 32;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {5, Ascii.ESC, -76, Ascii.CR, 53, 2, -47, -11, -53, Ascii.CR, 1, -17, 5, -22, -1, 3, Ascii.FF, -11, 8, 52, 0, -17};
    private static final int $$b = 233;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;

    private static String $$e(int i, byte b, int i2) {
        int i3 = i2 * 2;
        int i4 = 106 - b;
        int i5 = 3 - (i * 4);
        byte[] bArr = $$c;
        byte[] bArr2 = new byte[i3 + 1];
        int i6 = -1;
        if (bArr == null) {
            i4 = (-i4) + i3;
            i6 = -1;
        }
        while (true) {
            int i7 = i6 + 1;
            i5++;
            bArr2[i7] = (byte) i4;
            if (i7 == i3) {
                return new String(bArr2, 0);
            }
            i4 = (-bArr[i5]) + i4;
            i6 = i7;
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0026). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(short r5, byte r6, byte r7, java.lang.Object[] r8) {
        /*
            int r7 = r7 + 4
            int r0 = 4 - r5
            byte[] r1 = com.google.common.collect.ForwardingSortedSet.$$a
            int r6 = 115 - r6
            byte[] r0 = new byte[r0]
            int r5 = 3 - r5
            r2 = 0
            if (r1 != 0) goto L12
            r4 = r5
            r3 = r2
            goto L26
        L12:
            r3 = r2
        L13:
            byte r4 = (byte) r6
            r0[r3] = r4
            int r7 = r7 + 1
            if (r3 != r5) goto L22
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            r8[r2] = r5
            return
        L22:
            int r3 = r3 + 1
            r4 = r1[r7]
        L26:
            int r4 = -r4
            int r6 = r6 + r4
            int r6 = r6 + (-2)
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ForwardingSortedSet.a(short, byte, byte, java.lang.Object[]):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract SortedSet<E> delegate();

    protected ForwardingSortedSet() {
    }

    @Override // java.util.SortedSet
    @CheckForNull
    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    @Override // java.util.SortedSet
    @ParametricNullness
    public E first() {
        return delegate().first();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> headSet(@ParametricNullness E e) {
        return delegate().headSet(e);
    }

    @Override // java.util.SortedSet
    @ParametricNullness
    public E last() {
        return delegate().last();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> subSet(@ParametricNullness E e, @ParametricNullness E e2) {
        return delegate().subSet(e, e2);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> tailSet(@ParametricNullness E e) {
        return delegate().tailSet(e);
    }

    private static void b(char c, int i, int i2, Object[] objArr) throws Throwable {
        int i3 = 2 % 2;
        _CREATION _creation = new _CREATION();
        long[] jArr = new long[i2];
        _creation.b = 0;
        while (_creation.b < i2) {
            int i4 = $10 + 57;
            $11 = i4 % 128;
            if (i4 % 2 == 0) {
                int i5 = _creation.b;
                try {
                    Object[] objArr2 = {Integer.valueOf(_CREATION[i % i5])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 0;
                        byte b2 = (byte) (b + 2);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getDoubleTapTimeout() >> 16) + 8, (char) (9279 - (Process.myTid() >> 22)), 1977 - ExpandableListView.getPackedPositionType(0L), 1113883676, false, $$e(b, b2, (byte) (b2 - 2)), new Class[]{Integer.TYPE});
                    }
                    Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i5), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 0;
                        byte b4 = b3;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(ExpandableListView.getPackedPositionType(0L) + 30, (char) (Gravity.getAbsoluteGravity(0, 0) + 49362), ImageFormat.getBitsPerPixel(0) + 685, -115095555, false, $$e(b3, b4, b4), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                    }
                    jArr[i5] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                    Object[] objArr4 = {_creation, _creation};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                    if (objAccessartificialFrame3 == null) {
                        byte b5 = (byte) 0;
                        byte b6 = (byte) (b5 + 3);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(24 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (30068 - (ViewConfiguration.getLongPressTimeout() >> 16)), TextUtils.indexOf((CharSequence) "", '0') + 817, 1897803493, false, $$e(b5, b6, (byte) (b6 - 3)), new Class[]{Object.class, Object.class});
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
                    byte b7 = (byte) 0;
                    byte b8 = (byte) (b7 + 2);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(8 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (ExpandableListView.getPackedPositionChild(0L) + 9280), 1977 - TextUtils.indexOf("", "", 0), 1113883676, false, $$e(b7, b8, (byte) (b8 - 2)), new Class[]{Integer.TYPE});
                }
                Object[] objArr6 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).longValue()), Long.valueOf(i6), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1715896821);
                if (objAccessartificialFrame5 == null) {
                    byte b9 = (byte) 0;
                    byte b10 = b9;
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(31 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) (KeyEvent.keyCodeFromString("") + 49362), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 683, -115095555, false, $$e(b9, b10, b10), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                }
                jArr[i6] = ((Long) ((Method) objAccessartificialFrame5).invoke(null, objArr6)).longValue();
                Object[] objArr7 = {_creation, _creation};
                Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-293902099);
                if (objAccessartificialFrame6 == null) {
                    byte b11 = (byte) 0;
                    byte b12 = (byte) (b11 + 3);
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation((-16777191) - Color.rgb(0, 0, 0), (char) (30067 - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), 816 - View.MeasureSpec.getMode(0), 1897803493, false, $$e(b11, b12, (byte) (b12 - 3)), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame6).invoke(null, objArr7);
            }
        }
        char[] cArr = new char[i2];
        _creation.b = 0;
        while (_creation.b < i2) {
            cArr[_creation.b] = (char) jArr[_creation.b];
            try {
                Object[] objArr8 = {_creation, _creation};
                Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-293902099);
                if (objAccessartificialFrame7 == null) {
                    byte b13 = (byte) 0;
                    byte b14 = (byte) (b13 + 3);
                    objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(ExpandableListView.getPackedPositionType(0L) + 25, (char) (30068 - (Process.myTid() >> 22)), 816 - Color.green(0), 1897803493, false, $$e(b13, b14, (byte) (b14 - 3)), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame7).invoke(null, objArr8);
                int i7 = $11 + 99;
                $10 = i7 % 128;
                int i8 = i7 % 2;
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingCollection
    protected boolean standardContains(@CheckForNull Object obj) {
        try {
            return ForwardingSortedMap.unsafeCompare(comparator(), tailSet(obj).first(), obj) == 0;
        } catch (ClassCastException | NullPointerException | NoSuchElementException unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingCollection
    protected boolean standardRemove(@CheckForNull Object obj) {
        try {
            Iterator<E> it2 = tailSet(obj).iterator();
            if (!it2.hasNext()) {
                return false;
            }
            if (ForwardingSortedMap.unsafeCompare(comparator(), it2.next(), obj) != 0) {
                return false;
            }
            it2.remove();
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    protected SortedSet<E> standardSubSet(@ParametricNullness E e, @ParametricNullness E e2) {
        return tailSet(e).headSet(e2);
    }

    static {
        char[] cArr = new char[1959];
        ByteBuffer.wrap("ÞtTdÊ\u0088A<÷\u0018mûà\u0016\u0016J\u008cç\u0003\u000e¹¼/Á¢wØ\u009bNÀÅj{\u008fî\"dX\u009aé\u00114\u0087s=ú°\u0006&²\\ÛÓ\u0000Y$Ó4MØÆlpHê«gF\u0091\u001a\u000b·\u0084^>ì¨\u0091%'_ËÉ\u0081B7üËieã2\u001d®\u0096g\u0000\u000eºº7R¡ç\u0019Ñ\u0093Á\r-\u0086\u00990½ª^'³ÑïKBÄ«~\u0019èdeÒ\u001f>\u0089w\u0002Ò¼ )\u0096×L]KÃ¬H\u0001þ dÉé.\u001fz\u0085Î\n<°\u0088&¥«@Ñ\u0093GõÌRrµç\u0001mv\u0093Ê\u0018 \u008ev4Ð¹:/\u009fUåÚ/@\u0083\u0019Ñ\u0093À\r<\u0086\u008c0½ª]'»Ñ\u00adKVÄ¿~\u001fègw%ý4cÈèx^IÄ¾IA¿\u001a%üªI\u0010ö\u0086\u008c\u000b>t]þZ` ë\u0000]\u007fÇÇJ4¼ &ø©\u0007\u0013±\u0085ô\b@r\u0088äÌoFÑ¶D\u0018\u0019Ñ\u0093Á\r)\u0086\u009b0óª\u0016'òÑàKVÄ¸~\u0019èyeÜ\u001f\u000e\u0019\u008c\u0093Ê\rf\u0086\u008d0ýªV'¨Ñ\u00adKTÄ¨~\u0014èeeÕ\u001f\b\u0089`\u0002ô¼ )\u0090£ì]`Ö\u0086@çú_wâ6Z¼\u001c\"°©[\u001f+\u0085\u0080\b~þ{d\u0082ë~QÂÇ³J\u00030Þ¦¶-\"\u0093ö\u0006F\u008c:r¶ùPo1Õ\u0089X7\u0019Ñ\u0093Ö\r1\u0086\u009c0æª\\'±Ñ¬KJÄ¤~\u0012è8eÖ\u001f\b\u0089f\u0002Å¼,)Û£ë]PÍ\"GrÙ\u0091R?äC~ÿ\u0019¢\u0093ä\u0019Ñ\u0093Ö\r1\u0086\u009c0æª\\'±Ñ¬KDÄ¤~\u001eè8eÔ\u001f\u0004\u0089i\u0002Þ¼\u0018)¸£µ]QÖ\u0087@äúYwþá\u0015\u009br\u0014®\u008e\u00138xµÞ/8\u0019Ñ\u0093Ö\r1\u0086\u009c0æª\\'±Ñ¬KDÄ¤~\u001eè8eÔ\u001f\u0004\u0089i\u0002Þ¼\u0018)¸£µ]OÖ\u0090@æú\\\u0019Ñ\u0093Ö\r1\u0086\u009c0æª\\'±Ñ¬KJÄ¤~\u0012è8eÖ\u001f\b\u0089f\u0002Å¼+)\u0098£í]iÖ¯@ùú^w¼á\u0006\u009b3\u0014³\u008e\b\u0019Ñ\u0093Á\r-\u0086\u00990½ªW'¹ÑîKSÄª~\u0005èreÉ\u001f\u0015\u0019\u008c\u0093Ê\rf\u0086\u008d0çªP'°ÑçK\bÄ¥~\u001fèdeÎ>\u0099´É* ¡\u0095\u0017þ\u008d\u001e\u0000»öïl[\u0019Ñ\u0093Õ\r:\u0086\u00800ñª\u0016'ºÑêKJÄ¨~\u0003èneÉ\u001f\u0015\u0089a\u0002Æ¼=\u0019\u0090\u0093À\r%\u0086\u009a0áª_\u008a\u0016\u0000P\u009eü\u0015\u0005£z9Ì´\"BlØßW#íÄ{àöA\u008c\u0095\u001aë\u0091W/µº\f0vÎÐE\nÓviÄ\u0010X\u009a\u0001\u0004ç\u008fWbåè«vQý÷K\u0090Ñ!\\ÃªÆ0>¿ß\u0005h\u0093R\u001e³dnòAy¤Ç@RüØ\u0086&3\u00ad§;\u0085\u00817\fÍ\u009a3à\u0010oÊõgC\u0004Î\u0085TX£à)\u0080·q\u0002ñ\u0088\u0081\u00167\u009dÖërq:üÈJt¼Ì6\u0082¨x#Þ\u0095¹\u000f\b\u0082êtïî\u0017aöÛAM{À\u009aºG,h§\u008d\u0019i\u008cÕ\u0006¯ø\u001as\u008eå¬_\u001eÒäD\u001a>9±ã+N\u009d-\u0010¬\u008aq}É÷©iXÜÜV¨È\u001eCÿ5Q¯\u0013×d]*ÃÐHvþ\u0011d éB\u001fG\u0085¿\n^°é&Ó«2ÑïGÀÌ%rÁç}m\u0007\u0093²\u0018&\u008e\u00114©¹\u0017/ÿU\u0086ÚCvÌü\u0082bxéÞ_¹Å\bHê¾ï$\u0017«ö\u0011A\u0087{\n\u009apGæhm\u008dÓiFÕÌ¯2\u001a¹\u008e/¹\u0095\u0001\u0018¿\u008eXô>{á2¢¸ì&\u0016\u00ad°\u001b×\u0081f\f\u0084ú\u0081`yï\u0098U/Ã\u0015Nô4)¢\u0006)ã\u0097\u0007\u0002»\u0088Ávtýàk×Ño\\ÑÊ7°R?\u008f\u0019\u008e\u0093À\r:\u0086\u009c0ûªJ'¨Ñ\u00adKUÄ´~\u0003è9eØ\u001f\u0005\u0089*\u0002Ï¼+)\u0097£í]XÖÌ@ûúCwýá\u001b\u009bs\u0014£\u0019\u0088\u0093Ç\r'\u0086\u00970áª_¬ð&ô¸\u001b3¡\u0085Ð\u001f7\u0092\u0090dÍþcq\u0099Ë=]SÐèÍ8GwÙ\u0097R'äE~üó\t\u0005@\u009fâ\u0019¹\u0093À\r&\u0086\u00960ÿªV'¨ÑêKIÄ£0Wº\u0017$ÿ¯]\u0019!\u0083\u0092\u000en\u0019\u009d\u0093Í\r:\u0086\u00800ÿªP'©ÑîF«ÌíRAÙ¸oÇõqx\u009f\u008eÑ\u0014b\u009b\u009e!y·T:ø@0ÖJ]ïã\f\u0019\u0088\u0093Ç\r'\u0086\u00970ªª\u000f'¬¹\u00953Ì\u00ad*&\u0086\u0090ì\n\\\u0087³\\\u0083ÖÚH<Ã\u0090uúïJb¥\u0094Æ\u000eD\u0081ï;\\¤\u0085.Ü°:;\u0096\u008dü\u0017L\u009a£lÀöByéÃZUTØ\u0090¢I\u0019\u008c\u0093Ê\rf\u0086\u009f0àªV'¸ÑöKEÄ¹~^èzeÕ\u001f\u0005\u0089a\u0002Ç³\u00899Å§'\u0019\u009b\u0093È\r=\u0086\u00830óªM'³ÑñÉÉC£ÝNV¹à¶z:÷Ä\u0001\u0081\u009b9\u0014Ö®c8AµªÏxY\u0000Òýl{ùës\u009c\u008d&\u0006ù\u0090\u009a\u0096Ã\u001c·\u0082P\tá¿\u0081%,¨Ä^ßÄ\tKõñGgKê¤\u0090h\u0006\u0011\u008d»3F¦©,\u0082Ò,YìÏÕu(ø\u0097n<q\u0091ûåe\u0002î³XÓÂ~O\u0096¹\u008d#[¬§\u0016\u0015\u0080\u0019\röw:áCjéÔ\u0014AûËÐ5~¾¾(\u0087\u0092z\u001fÅ\u0089nól|Øæ}\u009a\u001f\u0010Y\u008eõ\u0005\u0014³`)Ø¤+RgÈÔG,ý\u0086\u0019\u0099\u0093Ê\r$\u0086\u008b0ôªP'¯Ñë\u0019\u0088\u0093Ç\r'\u0086\u00970ªª\u000fð1zyä\u009bo1ÙGCñ\u0019\u008c\u0093Ê\rf\u0086\u009f0àªV'¸ÑöKEÄ¹~^èueÈ\u001f\u0000\u0089j\u0002Ïæàl¦ò\nyèÏ\u009bU'ØÞ.\u008a´&;\u008f\u0081m\u0017\u001e\u009a»àx\u0019Ï~Qô\u0017j»áAW*Í\u0087@t¶,,\u009eè\u0000\u0019\u008c\u0093Ê\rf\u0086\u008d0çªP'°ÑçK\bÄ½~\u0002èxeÞ\u001f\u0014\u0089g\u0002ßä´nüð\b{¯ÍáWmÚÈ,\u0099\u0019\u008c\u0093Ê\rf\u0086\u008d0çªP'°ÑçK\bÄ«~\u0019èyeÝ\u001f\u0004\u0089v\u0002Û¼<)\u009c£ö]K\u0019\u0099\u0093À\r&\u0086\u008a0àªP'¿Ñ¬KUÄ©~\u001bè8eÝ\u001f\u0004\u0089j\u0002Î¼<)\u009c£û\u0019\u0099\u0093À\r&\u0086\u008a0àªP'¿ÑÜK^Äõ~Fè8eÉ\u001f\u0005\u0089o\u0002ô¼6)Í£®]\u0010Ö\u0085@ìúBw¶á\u0004\u009bt\u0014£\u008e88rµ\u0089/bk\u0086áß\u007f9ô\u0095BÿØOU £³9^¶½\f\u0000\u009ao\u0017Ém\u001bûDpÇÎ5[\u0081Ñ¨/G¤\u00982ø\u0088V\u0005¾\u0093\u0000éa\u0019\u0099\u0093À\r&\u0086\u008a0àªP'¿Ñ¬KPÄ¯~\u001fèoe\u0082\u001fW\u0089t\u0002\u0084¼8)\u0097£÷]GÖÚ@¿ú\\\u0016J\u009c\u0019\u0002ô\u0089[?-¥\u008f( Þ#D\u0091Ëuqüç£j\u0019\u0010Ú\u0086¸\r\u0016³ø&y¬3RÔÙ\u0007Ouõ\u0098xeîË\u0094«\u001ba\u0081Ý7ºº= ÿ×\u0010]{yRó\u0014m¸æSP#Ê\u0088Gv±1+\u0097¤r\u001eÊ\u0088¬\u0005\u0016\u0019\u008c\u0093Ê\rf\u0086\u008d0ýªV'¨ÑêKKÄ¬~\u0017ère\u0094\u001f\u0003\u0089q\u0002Â¼\")\u0091£¶]YÖ\u008b@çúKw¶á\u0004\u009bm\u0014²\u008e\u000e8dµÅ\u0019¿\u0093Ë\r,\u0086\u009d0ýªP'¸Ñ®K^Äõ~F\u0019\u008c\u0093Ê\rf\u0086\u008d0çªP'°ÑçK\bÄ©~\u0019èdeÊ\u001f\r\u0089e\u0002Ò¼`)\u009c£ü\u0019\u008a\u0093À\r;\u0086\u009b0¿ô'~{à\u0091k+Ý\fGúÊ\u001a<P¦¸)\f\u0093¥\u0005Ê\u0088\u007fòüdÄïiQ\u0091Ä5N[\u0019\u008f\u0093À\r%\u0086\u009a0¼ªQ'«Ñ\u00adKKÄ¬~\u0019èyeÑ\u001f\u0004\u0089}\u0002Ø\u0019\u008f\u0093À\r%\u0086\u009a0¼ªJ'ºÑ\u00adK@Ä¬~\u001bèreå\u001f\u0002\u0089e\u0002Æ¼+)\u0087£ùn)äfz\u0083ñ<G\u001aÝìP\u001c¦\u000b<ì³\b\t²\u009fî\u0012xh¢þÌu~Ë\u0081^'ÔG©\u0093#Õ½y6\u009b\u0080è\u001aT\u0097\u00adaùûUtüÎ\u000eXfÕÁ¯\f9t²Ý\f5\u0099Ä\u0013öíEf\u0090ðãJW²ä8¢¦\u000e-å\u009b\u0095\u0001>\u008cÀzÅà?oÀÕuC\nÎü´h\"\u001a©§\u0017y\u0082ó\b\u0091ö:}ï\u0019\u008c\u0093Ê\rf\u0086\u00800öªT'òÑáKSÄ¤~\u001cèse\u0094\u001f\u0007\u0089m\u0002Å¼))\u0090£ê]OÖ\u0090@àúBw§|\u001aö\\hðã\tUvÏÀB.´`.Ó¡/\u001bÈ\u008dã\u0000Yz\u009eìþgYÙöL\u0005Æg8Ç³\u0013%z\u009fÈ\u00125\u0084\u0092þâq8ë\u0085^¶ÔðJ\\Á¦wÑíp`\u0092\u0096Ü\fq\u0083Ù9(¯X\"éX7ÎZE¿û\u0012n¦äÌ\u001ab\u0091½\u0007Á½f0\u009b¦%ÜIS\u008e\u0019\u008c\u0093Ê\rf\u0086\u009c0ëªJ'¨ÑæKKÄ\u0092~\u0015èoeÎ\u001fO\u0089f\u0002Þ¼')\u0099£ü]\u0011Ö\u0084@àúBw´á\u0013\u009bo\u0014°\u008e\u00158cµß/ «ü!º¿\u00164é\u0082\u0087\u0018'\u0095Èc\u009cù$v\u0093ÌbZ\u0012×£\u00ad};\u0010°õ\u000eX\u009bì\u0011\u0086ï(d÷ò\u008bH,ÅÑSo)\u0003¦Ä÷\u0094}Òã~h\u0081ÞïDOÉ ?ô¥L*\u008a\u0090\f\u0006c\u008bÉñ\u0014g2ìÑR#Ç\u0084Mì³C8Ô®÷\u0014]\u0099¥\u000f\tu`úª`\u000fÖ`[ÀÁ\"6\u00978T\u0019Ñ\u0093Á\r-\u0086\u00990½ªH'¹ÑîKSÄ\u0092~\u0000è~eÊ\u001f\u0004\\\u0095Ö\u0085HiÃÝuùï\u000eb÷\u0094¤\u000e\t\u0081ì;@\u00ad| \u009cZDÌ3G\u008aùhlÐæ²\u0018\u001f\u0093ù\u0005ª¿\r2ù¤KÞ=\u0019Ñ\u0093Á\r-\u0086\u00990½ªJ'³ÑàKMÄ¨~\u0004è8eÝ\u001f\u0004\u0089j\u0002Ò¼*å\u0013o\u0003ñïz[Ì\u007fV\u0088Ûq-\"·\u008f8j\u0082Æ\u0014ú\u0099\tãÆu«þ\u001c@è\u0019Ñ\u0093Ö\r1\u0086\u009c0½ªH'¹ÑîKSÄ\u0092~\u0004èeeÛ\u001f\u0002\u0089a\tÔ\u0083Ó\u001d4\u0096\u0099 ãºY7´Á©[OÔ¡n\u0017ø=uÓ\u000f\r\u0099c\u0012Í¬\u00149\u009d³üMVÆ\u008bPãêJg\u0089ñ\u0017\u008b}\u0004§\u009e\u0017(h¥ë? È\u009bBöÜ5iÃãù}X\u0019Ñ\u0093Á\r-\u0086\u00990½ª['¯Ñ÷KyÄª~\u0000èd\u0019Ñ\u0093Á\r-\u0086\u00990½ª['¯Ñ÷KyÄ¹~\u0019èzeß\u0019Ñ\u0093Á\r-\u0086\u00990½ªJ'³ÑàKMÄ¨~\u0004è8eØ\u001f\u0012\u0089p\u0002Í¼!)\u0099£ü]ZÖ\u0090@í¥]/Z±½:\u0010\u008cj\u0016Ð\u009b=m ÷Æx(Â\u009eT´ÙZ£\u00845ê¾E\u0000±\u0095\r\u001fráÜj\u0002üaFÅË-]¥'û¨\"2\u0082\u0084¨\tN\u0093·\u0019Ñ\u0093Á\r-\u0086\u00990½ª['¯Ñ÷KGÄ®~\u0013èr\u0019.\u0093>\rÒ\u0086f0Bª¤'PÑ\bK¾ÄK~ýè\u0087\rÝ\u0087Í\u0019!\u0092\u0095$±¾W3£Åû_GÐ¤j\u001büu\u0019Ñ\u0093Á\r-\u0086\u00990½ª['¯Ñ÷KIÄ¿~\u0019èr\u0019Ñ\u0093Á\r-\u0086\u00990½ª['¯Ñ÷KPÄ ~\u0003èp\u0019Ñ\u0093Á\r-\u0086\u00990½ª['¯Ñ÷KVÄª~\u0011è~eÊ\u001f\u0002\u001bÁ\u0091Ñ\u000f=\u0084\u00892\u00ad¨K%¿ÓçIiÆ´|\rêb\u0019Ñ\u0093Á\r)\u0086\u009b0óª\u0016'¸ÑìKQÄ£~\u001cèxeÛ\u001f\u0005\u0089w\u0002\u0084¼`)\u008d£ú]\u0010Ö\u0080@úúXw¸aeë|u\u0092þ/H\tÒú_\u0001©Y3ö¼\u0016\u0006³\u0090Ð\u001d!g\u0097ñÃzkÄ©Q)ÛM%ù®38Y\u0082Þ\u000f\b\u0099®ãÍl\u0011ö¡\u0019Ñ\u0093Õ\r:\u0086\u00800ñª\u0016'µÑìKVÄ¢~\u0002èceÉ\u0019Î\u0093Ã\r.\u0086Ï0¨ñö{òå\u001dn§ØÖB1Ï\u00889Á£m,\u008c\u0096x\u0000]\u008dü÷6aP\u0019\u0099\u0093×\r)\u0086\u00830þªV'¿Ñ\u00adKAÄ¢~\u001cèseÜ\u001f\b\u0089w\u0002Ã¼`)\u0086£÷Ö³\\íÂ\u000bI\u0089ÿÿe]è®\u001eý\u0084e\u000b\u009f±%'\u0018ªèÐ/\u0019Ñ\u0093À\r<\u0086\u008c0½ªT'¹ÑçKOÄ¬~/èteÕ\u001f\u0005\u0089a\u0002È¼=)Û£à]RÖ\u008e\u0019\u009c\u0093É\r=\u0086\u008a0áªM'½ÑàKMÄ¾\u0019Ñ\u0093À\r<\u0086\u008c0½ªT'³ÑöKHÄ¹~\u0003\u0019Ñ\u0093Á\r)\u0086\u009b0óª\u0016'¸ÑìKQÄ£~\u001cèxeÛ\u001f\u0005\u0089w\u0002\u0084¼`)\u0091£è]\u0010Ö\u0083@ùú\\w áX\u009be\u0014\u00ad\u008e\u000bÜ¡V¥ÈJCðõ\u0081ofâÏ\u0014\u0083\u008e#\u0001Ô»n-\u0001 ¥%\u0006¯u1\u009bº4\fK\u0096ï\u001b\u0010íT¡\t+\u0019µñ>C\u0088+\u0012Î\u009fii2ó\u008d|vÆ\u0087P¿Ý\u0010§Ö1ºº\u001a\u0004ú\u0091H\u001b3åÈnYø$B\u0086Ï$Y\u009e#ê¬{6Ð\u0080¿\rG\u0097á`Jê%tïÁ_K!Õ\u0083^s(Ð²Õ?s\u0089Ð\u0013¥\u009c\u001afëð´}\u0019".getBytes(CharEncoding.ISO_8859_1)).asCharBuffer().get(cArr, 0, 1959);
        _CREATION = cArr;
        _BOUNDARY = -8549172065573366875L;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0b68  */
    /* JADX WARN: Code duplicated, block: B:138:0x0f62  */
    /* JADX WARN: Code duplicated, block: B:196:0x1682  */
    /* JADX WARN: Code duplicated, block: B:247:0x1d36  */
    /* JADX WARN: Code duplicated, block: B:250:0x2891  */
    /* JADX WARN: Code duplicated, block: B:253:0x28a2 A[Catch: all -> 0x02c5, TryCatch #2 {all -> 0x02c5, blocks: (B:11:0x016c, B:13:0x0179, B:14:0x01c4, B:32:0x03e8, B:34:0x03f5, B:35:0x0440, B:44:0x059d, B:46:0x05ac, B:48:0x05f9, B:74:0x08b5, B:76:0x08bb, B:77:0x0908, B:110:0x0ca4, B:112:0x0cb1, B:113:0x0cfa, B:126:0x0e4b, B:128:0x0e58, B:129:0x0e9f, B:146:0x1056, B:148:0x1063, B:149:0x10b3, B:157:0x126f, B:159:0x127c, B:160:0x12bb, B:171:0x14e5, B:173:0x14f2, B:174:0x1535, B:212:0x18c3, B:214:0x18c9, B:215:0x1910, B:220:0x1a15, B:222:0x1a27, B:223:0x1a6d, B:231:0x1baf, B:233:0x1bbc, B:235:0x1c05, B:237:0x1c0e, B:239:0x1c26, B:240:0x1c74, B:287:0x2b42, B:289:0x2b4f, B:290:0x2b8f, B:307:0x3079, B:309:0x3086, B:310:0x30d1, B:316:0x31ae, B:318:0x31bb, B:319:0x3204, B:340:0x36a5, B:342:0x36b2, B:344:0x370a, B:379:0x3a1e, B:381:0x3a2b, B:382:0x3a67, B:293:0x2b9c, B:295:0x2bb4, B:296:0x2bf6, B:251:0x2895, B:253:0x28a2, B:255:0x28ea, B:201:0x1732, B:203:0x173f, B:204:0x1792, B:53:0x06ef, B:55:0x06fc, B:56:0x073a, B:62:0x07b1, B:64:0x07be, B:65:0x07fd), top: B:403:0x016c }] */
    /* JADX WARN: Code duplicated, block: B:254:0x28e8  */
    /* JADX WARN: Code duplicated, block: B:258:0x28fd  */
    /* JADX WARN: Code duplicated, block: B:276:0x2993  */
    /* JADX WARN: Code duplicated, block: B:278:0x29f8  */
    /* JADX WARN: Code duplicated, block: B:281:0x2a70  */
    /* JADX WARN: Code duplicated, block: B:283:0x2aa3  */
    /* JADX WARN: Code duplicated, block: B:284:0x2ac5  */
    /* JADX WARN: Code duplicated, block: B:369:0x3957  */
    /* JADX WARN: Code duplicated, block: B:430:0x2981 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    public static Object[] CoroutineDebuggingKt(Context context, int i, int i2, int i3) throws Throwable {
        Object obj;
        int i4;
        String str;
        int i5;
        String str2;
        String str3;
        int i6;
        String str4;
        String str5;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i_BOUNDARY;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        boolean z;
        boolean z2;
        int i18;
        char c;
        int i19;
        String str6;
        int i20;
        char c2;
        String[][] strArr;
        ArrayList arrayList;
        int i21;
        int i22;
        int i23;
        Object[] objArr;
        int i24;
        char c3;
        int i25;
        char c4;
        int i26;
        int i27;
        Object objAccessartificialFrame;
        String str7;
        Object obj2;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        Object[] objArr2;
        char c5;
        Object[] objArr3;
        char c6;
        char c7;
        char c8;
        int i33;
        int i34;
        Object obj3;
        int i35 = 2 % 2;
        int i36 = artificialFrame;
        int i37 = 1;
        int i38 = (i36 ^ 73) + ((i36 & 73) << 1);
        getARTIFICIAL_FRAME_PACKAGE_NAME = i38 % 128;
        int i39 = 0;
        if (i38 % 2 != 0) {
            char c9 = (char) (ExpandableListView.getPackedPositionForGroup(1) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(1) == 0L ? 0 : -1));
            int iMakeMeasureSpec = 16757 % View.MeasureSpec.makeMeasureSpec(0, 0);
            int i40 = -(-(KeyEvent.getMaxKeyCode() / 68));
            int i41 = (i40 & AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR) + (i40 | AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR);
            Object[] objArr4 = new Object[1];
            b(c9, iMakeMeasureSpec, i41, objArr4);
            obj = objArr4[0];
        } else {
            Object[] objArr5 = new Object[1];
            b((char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), View.MeasureSpec.makeMeasureSpec(0, 0) + 717, (KeyEvent.getMaxKeyCode() >> 16) + 8, objArr5);
            obj = objArr5[0];
        }
        String str8 = (String) obj;
        int i42 = 4;
        char c10 = (char) (51110 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
        String str9 = "";
        int capsMode = TextUtils.getCapsMode("", 0, 0);
        int i43 = -(-(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
        int i44 = ((i43 | 26) << 1) - (i43 ^ 26);
        Object[] objArr6 = new Object[1];
        b(c10, capsMode, i44, objArr6);
        char cRed = (char) (Color.red(0) + 16629);
        int i45 = -(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
        int i46 = ((i45 | 28) << 1) - (i45 ^ 28);
        int i47 = -Drawable.resolveOpacity(0, 0);
        int i48 = (i47 ^ 25) + ((i47 & 25) << 1);
        Object[] objArr7 = new Object[1];
        b(cRed, i46, i48, objArr7);
        char cKeyCodeFromString = (char) KeyEvent.keyCodeFromString("");
        int i49 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
        Object[] objArr8 = new Object[1];
        b(cKeyCodeFromString, (i49 ^ 52) + ((i49 & 52) << 1), 17 - (~(-(-View.combineMeasuredStates(0, 0)))), objArr8);
        int iBlue = Color.blue(0);
        int i50 = -TextUtils.lastIndexOf("", '0', 0);
        int i51 = i50 * 193;
        int i52 = (i51 & 13317) + (i51 | 13317);
        int i53 = ~i;
        int i54 = ~i50;
        int i55 = ((~((i54 ^ 69) | (i54 & 69))) | i53) * (-192);
        int i56 = (i52 & i55) + (i55 | i52);
        int i57 = ~((~i50) | (-70));
        int i58 = ~(((-70) ^ i53) | ((-70) & i53));
        int i59 = i56 + (((i57 & i58) | (i57 ^ i58)) * (-384));
        int i60 = (i54 ^ (-70)) | (i54 & (-70));
        int i61 = ~((i60 & i) | (i60 ^ i));
        int i62 = ~i;
        int i63 = ((-70) ^ i62) | ((-70) & i62);
        int i64 = getARTIFICIAL_FRAME_PACKAGE_NAME + 89;
        artificialFrame = i64 % 128;
        int i65 = i64 % 2;
        int i66 = i61 | (~((i63 & i50) | (i63 ^ i50)));
        int i67 = (i50 ^ 69) | (i50 & 69);
        int i68 = ~((i67 & i) | (i67 ^ i));
        int i69 = JfifUtil.MARKER_SOFn * ((i66 & i68) | (i66 ^ i68));
        Object[] objArr9 = new Object[1];
        b((char) ((iBlue ^ 52893) + ((iBlue & 52893) << 1)), ((i59 | i69) << 1) - (i59 ^ i69), 27 - (~Color.argb(0, 0, 0, 0)), objArr9);
        String[] strArr2 = {(String) objArr6[0], (String) objArr7[0], (String) objArr8[0], (String) objArr9[0]};
        int i70 = 0;
        while (true) {
            if (i70 >= i42) {
                i4 = i62;
                str = str9;
                i5 = i;
                break;
            }
            try {
                Object[] objArr10 = {strArr2[i70]};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(267846469);
                if (objAccessartificialFrame2 == null) {
                    int scrollBarSize = (ViewConfiguration.getScrollBarSize() >> 8) + 17;
                    char c11 = (char) (24342 - (ExpandableListView.getPackedPositionForChild(i39, i39) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(i39, i39) == 0L ? 0 : -1)));
                    int maxKeyCode = 2014 - (KeyEvent.getMaxKeyCode() >> 16);
                    byte[] bArr = $$a;
                    Object[] objArr11 = new Object[i37];
                    a(bArr[5], (byte) (-bArr[7]), bArr[14], objArr11);
                    String str10 = (String) objArr11[i39];
                    Class[] clsArr = new Class[i37];
                    clsArr[i39] = String.class;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(scrollBarSize, c11, maxKeyCode, -1869462195, false, str10, clsArr);
                }
                long jLongValue = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr10)).longValue();
                long j = 495816409;
                String[] strArr3 = strArr2;
                i4 = i62;
                long j2 = 433;
                long j3 = -1;
                long j4 = j ^ j3;
                String str11 = str9;
                long j5 = i;
                str = str11;
                int i71 = i70;
                long j6 = (((long) (-432)) * j) + (((long) 434) * jLongValue) + ((((j4 | (j5 ^ j3)) | jLongValue) ^ j3) * j2) + (((long) (-433)) * (j4 | (((jLongValue ^ j3) | j5) ^ j3))) + (j2 * (((j4 | j5) ^ j3) | (j3 ^ (j | jLongValue)))) + ((long) (-1807448385));
                int i72 = (~((-750184988) | i)) | 682781195;
                int i73 = ~(i4 | 754445215);
                int i74 = ((int) (j6 >> 32)) & (221840860 + ((i72 | i73) * (-470)) + (((~((-67403793) | i)) | i73) * 470));
                int iNextInt = new Random().nextInt();
                int i75 = 1091534684 + (((~((~iNextInt) | (-2047597937))) | 1241649424) * (-245));
                int i76 = ~(iNextInt | (-2047597937));
                if (((((int) j6) & (i75 + (i76 * (-245)) + ((i76 | 810142949) * 245))) | i74) != 0) {
                    int i77 = ~((~i71) | (-191) | i53);
                    int i78 = ~(i71 | FacebookRequestErrorClassification.EC_INVALID_TOKEN);
                    int i79 = (i77 & i78) | (i77 ^ i78);
                    int i80 = ~((i71 ^ i) | (i71 & i));
                    int i81 = (((13110 + (i71 * (-67))) - (~(((i79 & i80) | (i79 ^ i80)) * (-68)))) - 1) + ((~(((-191) & i53) | ((-191) ^ i53) | i71)) * (-68));
                    int i82 = ~i71;
                    int i83 = ~((i82 & i4) | (i82 ^ i4));
                    int i84 = ((i83 & (-191)) | ((-191) ^ i83)) * 68;
                    i5 = i ^ ((i81 ^ i84) + ((i81 & i84) << 1));
                    break;
                }
                i70 = i71 + 1;
                i62 = i4;
                strArr2 = strArr3;
                str9 = str;
                i37 = 1;
                i39 = 0;
                i42 = 4;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
        if (i5 != i) {
            Object[] objArr12 = {null, new int[1], null, new int[]{i}, new int[]{i5}};
            int i85 = getARTIFICIAL_FRAME_PACKAGE_NAME + 119;
            int i86 = i85 % 128;
            artificialFrame = i86;
            int i87 = i85 % 2;
            int i88 = (i86 ^ 95) + ((i86 & 95) << 1);
            getARTIFICIAL_FRAME_PACKAGE_NAME = i88 % 128;
            if (i88 % 2 != 0) {
                Object obj4 = null;
                obj4.hashCode();
                throw null;
            }
            int iMyPid = Process.myPid();
            int i89 = ~iMyPid;
            int i90 = (((~(i89 | 75859460)) | (~((-529588998) | i89)) | 454058241) * (-397)) + 474952969 + ((iMyPid | 454386945) * 397);
            int i91 = i3 + (i90 & 16) + (i90 | 16);
            int i92 = i91 << 13;
            int i93 = ((~i91) & i92) | ((~i92) & i91);
            int i94 = i93 >>> 17;
            int i95 = ((~i93) & i94) | ((~i94) & i93);
            int i96 = i95 << 5;
            ((int[]) objArr12[1])[0] = ((~i95) & i96) | ((~i96) & i95);
            return objArr12;
        }
        char defaultSize = (char) View.getDefaultSize(0, 0);
        int i97 = -(-ImageFormat.getBitsPerPixel(0));
        int i98 = ((i97 | 99) << 1) - (i97 ^ 99);
        String str12 = str;
        Object[] objArr13 = new Object[1];
        b(defaultSize, i98, 11 - (~(-(-TextUtils.getOffsetAfter(str12, 0)))), objArr13);
        String str13 = (String) objArr13[0];
        char c12 = (char) (28403 - (~(ViewConfiguration.getTouchSlop() >> 8)));
        int i99 = -(-(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
        int i100 = ((i99 | AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) << 1) - (i99 ^ AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
        int i101 = -(TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
        int i102 = (i101 ^ 13) + ((i101 & 13) << 1);
        Object[] objArr14 = new Object[1];
        b(c12, i100, i102, objArr14);
        String str14 = (String) objArr14[0];
        char c13 = (char) (27995 - (~(-(-AndroidCharacter.getMirror('0')))));
        int i103 = -ImageFormat.getBitsPerPixel(0);
        int i104 = (i103 & 122) + (i103 | 122);
        int i105 = -(ViewConfiguration.getTapTimeout() >> 16);
        int i106 = ((i105 | 18) << 1) - (i105 ^ 18);
        Object[] objArr15 = new Object[1];
        b(c13, i104, i106, objArr15);
        String[] strArr4 = {str13, str14, (String) objArr15[0]};
        int i107 = 0;
        while (true) {
            if (i107 >= 3) {
                str2 = str12;
                str3 = str8;
                i6 = i;
                break;
            }
            Object[] objArr16 = {strArr4[i107]};
            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(267846469);
            if (objAccessartificialFrame3 == null) {
                int iAxisFromString = 16 - MotionEvent.axisFromString(str12);
                char cMyTid = (char) (24343 - (Process.myTid() >> 22));
                int iLastIndexOf = 2013 - TextUtils.lastIndexOf(str12, '0', 0, 0);
                byte[] bArr2 = $$a;
                Object[] objArr17 = new Object[1];
                a(bArr2[5], (byte) (-bArr2[7]), bArr2[14], objArr17);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iAxisFromString, cMyTid, iLastIndexOf, -1869462195, false, (String) objArr17[0], new Class[]{String.class});
            }
            long jLongValue2 = ((Long) ((Method) objAccessartificialFrame3).invoke(null, objArr16)).longValue();
            long j7 = -1295282448;
            long j8 = (((long) (-523)) * j7) + (((long) 263) * jLongValue2);
            long j9 = 262;
            String[] strArr5 = strArr4;
            str2 = str12;
            long j10 = -1;
            long j11 = ((j7 ^ j10) | jLongValue2) ^ j10;
            long j12 = jLongValue2 ^ j10;
            long j13 = (j7 | j12) ^ j10;
            long j14 = i;
            str3 = str8;
            int i108 = i107;
            long j15 = j8 + ((j11 | j13 | ((j12 | j14) ^ j10)) * j9) + (((long) (-786)) * j13) + (j9 * ((j10 ^ ((j14 ^ j10) | j12)) | j11 | j13)) + ((long) (-16349528));
            int i109 = ~((~new Random().nextInt(1662496912)) | 2131350700);
            int i110 = ((int) (j15 >> 32)) & ((((688477184 | i109) * (-374)) - 1534127518) + ((i109 | 1442873516) * 374));
            int startUptimeMillis = (int) Process.getStartUptimeMillis();
            int i111 = ~(1876865022 | startUptimeMillis);
            if ((i110 | (((int) j15) & ((-1277707799) + ((262532 | i111) * (-476)) + (i111 * 952) + ((~((~startUptimeMillis) | 1876865022)) * 476)))) != 0) {
                int i112 = i108 + RotationOptions.ROTATE_270;
                i6 = ((~i112) & i) | (i112 & i4);
                break;
            }
            i107 = i108 + 1;
            strArr4 = strArr5;
            str8 = str3;
            str12 = str2;
        }
        if (i6 != i) {
            Object[] objArr18 = {null, new int[]{(i | i) & (~(i & i))}, null, new int[]{i}, new int[]{i6}};
            int i113 = (-1509406251) + (((~((-605448459) | i4)) | (~((-403182130) | i)) | (~(1008630587 | i))) * 765) + (((~((-1008630588) | i4)) | 605448458) * 1530) + (((~(i | (-1008630588))) | (~(i4 | 1008630587))) * 765);
            int i114 = i3 + (i113 ^ 16) + ((16 & i113) << 1);
            int i115 = i114 ^ (i114 << 13);
            int i116 = i115 >>> 17;
            int i117 = ((~i115) & i116) | ((~i116) & i115);
            int i118 = i117 << 5;
            return objArr18;
        }
        char fadingEdgeLength = (char) (ViewConfiguration.getFadingEdgeLength() >> 16);
        int i119 = 140 - (~(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)));
        int i120 = -(-(ViewConfiguration.getScrollBarFadeDuration() >> 16));
        int i121 = ((i120 | 14) << 1) - (i120 ^ 14);
        Object[] objArr19 = new Object[1];
        b(fadingEdgeLength, i119, i121, objArr19);
        Object[] objArr20 = {(String) objArr19[0]};
        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-11453480);
        if (objAccessartificialFrame4 == null) {
            str4 = str2;
            int iIndexOf = TextUtils.indexOf(str4, str4) + 17;
            char c14 = (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 24342);
            int fadingEdgeLength2 = 2014 - (ViewConfiguration.getFadingEdgeLength() >> 16);
            byte[] bArr3 = $$a;
            Object[] objArr21 = new Object[1];
            a(bArr3[5], bArr3[16], bArr3[20], objArr21);
            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iIndexOf, c14, fadingEdgeLength2, 1614052816, false, (String) objArr21[0], new Class[]{String.class});
        } else {
            str4 = str2;
        }
        long jLongValue3 = ((Long) ((Method) objAccessartificialFrame4).invoke(null, objArr20)).longValue();
        long j16 = 283343663;
        long j17 = 85;
        long j18 = (j17 * j16) + (j17 * jLongValue3);
        long j19 = -84;
        long j20 = -1;
        long j21 = j16 ^ j20;
        long j22 = jLongValue3 ^ j20;
        String str15 = str4;
        long j23 = i;
        long j24 = j23 ^ j20;
        long j25 = j16 | jLongValue3;
        long j26 = (j24 | jLongValue3) ^ j20;
        long j27 = j18 + ((((j21 | j22) ^ j20) | ((j21 | j24) ^ j20) | ((j22 | j24) ^ j20) | ((j25 | j23) ^ j20)) * j19) + (j19 * (j16 | ((j22 | j23) ^ j20) | j26)) + (((long) 84) * (j26 | (j25 ^ j20))) + ((long) 1278787374);
        int i122 = ((int) (j27 >> 32)) & (1871737038 + (((~(764120795 | i4)) | (~(2093620089 | i))) * 1900) + (((~(i4 | (-2093620090))) | (~((-764120796) | i))) * (-950)) + (((~((-2093620090) | i)) | (~(i4 | (-764120796)))) * 950));
        int i123 = ((int) j27) & (1851573411 + (((~(1677228042 | i)) | (~(i4 | (-1638946827)))) * (-406)) + ((~(i4 | 1878948458)) * (-406)) + (((~((-240001633) | i)) | (~(i4 | (-1677228043)))) * 406));
        if (((i122 & i123) | (i122 ^ i123)) != 0) {
            i8 = (~(i & 266)) & (i | 266);
            i7 = i4;
            str5 = str15;
        } else {
            char touchSlop = (char) (ViewConfiguration.getTouchSlop() >> 8);
            int i124 = -(TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
            str5 = str15;
            Object[] objArr22 = new Object[1];
            b(touchSlop, (i124 & 155) + (i124 | 155), TextUtils.indexOf((CharSequence) str5, '0') + 25, objArr22);
            Object[] objArr23 = {(String) objArr22[0]};
            Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1483923676);
            if (objAccessartificialFrame5 == null) {
                int defaultSize2 = 23 - View.getDefaultSize(0, 0);
                char windowTouchSlop = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                int absoluteGravity = 2441 - Gravity.getAbsoluteGravity(0, 0);
                byte b = $$a[10];
                byte b2 = b;
                Object[] objArr24 = new Object[1];
                a(b2, (byte) (b2 | 48), b, objArr24);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(defaultSize2, windowTouchSlop, absoluteGravity, 954751276, false, (String) objArr24[0], new Class[]{String.class});
            }
            String str16 = (String) ((Method) objAccessartificialFrame5).invoke(null, objArr23);
            if (str16 == null || str16.length() == 0) {
                char c15 = (char) (12245 - (~(-(-KeyEvent.normalizeMetaState(0)))));
                int i125 = -(KeyEvent.getMaxKeyCode() >> 16);
                int i126 = (i125 ^ 179) + ((i125 & 179) << 1);
                int packedPositionChild = ExpandableListView.getPackedPositionChild(0L);
                int i127 = ~packedPositionChild;
                int i128 = (i127 ^ 25) | (i127 & 25);
                int i129 = ((packedPositionChild * 495) - 12325) + (((packedPositionChild ^ (-26)) | (packedPositionChild & (-26))) * (-988)) + (((i128 & i4) | (i128 ^ i4)) * 494);
                int i130 = ~((i127 & (-26)) | (i127 ^ (-26)));
                int i131 = ~(i4 | 25);
                int i132 = (i130 & i131) | (i130 ^ i131);
                int i133 = ~(packedPositionChild | 25);
                int i134 = i129 + (((i133 & i132) | (i132 ^ i133)) * 494);
                Object[] objArr25 = new Object[1];
                b(c15, i126, i134, objArr25);
                Object[] objArr26 = {(String) objArr25[0]};
                Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1483923676);
                if (objAccessartificialFrame6 == null) {
                    int iLastIndexOf2 = TextUtils.lastIndexOf(str5, '0') + 24;
                    char cAlpha = (char) Color.alpha(0);
                    int absoluteGravity2 = 2441 - Gravity.getAbsoluteGravity(0, 0);
                    byte b3 = $$a[10];
                    byte b4 = b3;
                    Object[] objArr27 = new Object[1];
                    a(b4, (byte) (b4 | 48), b3, objArr27);
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iLastIndexOf2, cAlpha, absoluteGravity2, 954751276, false, (String) objArr27[0], new Class[]{String.class});
                }
                String str17 = (String) ((Method) objAccessartificialFrame6).invoke(null, objArr26);
                if (str17 == null || str17.length() == 0) {
                    i7 = i4;
                    i8 = i;
                } else {
                    i7 = i4;
                    i8 = (i & (-268)) | (i7 & 267);
                }
            } else {
                i8 = (~(i & 267)) & (i | 267);
                i7 = i4;
            }
        }
        if (i8 != i) {
            Object[] objArr28 = {null, new int[]{i ^ (i << 5)}, null, new int[]{i}, new int[]{i8}};
            int i135 = (~(180340890 | i)) | 608186660;
            int i136 = ~((-2738203) | i7);
            int i137 = (-1309630175) + ((i135 | i136) * (-470)) + (((~(788527550 | i)) | i136) * 470);
            int i138 = i137 * (-661);
            int i139 = ((-10576) ^ i138) + ((i138 & (-10576)) << 1);
            int i140 = ~i137;
            int i141 = ((~(((-17) & i140) | ((-17) ^ i140))) | i53) * 1324;
            int i142 = ((i139 | i141) << 1) - (i141 ^ i139);
            int i143 = -(-(((~((i & i137) | (i137 ^ i))) | (~(i | 16))) * (-1324)));
            int i144 = (i142 & i143) + (i143 | i142);
            int i145 = ~((-17) | i137);
            int i146 = ~((i140 & 16) | (i140 ^ 16));
            int i147 = (i3 - (~(i144 + (((i145 & i146) | (i145 ^ i146)) * 662)))) - 1;
            int i148 = i147 << 13;
            int i149 = (i147 | i148) & (~(i147 & i148));
            int i150 = i149 ^ (i149 >>> 17);
            return objArr28;
        }
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(943212816);
        if (objAccessartificialFrame7 == null) {
            int scrollDefaultDelay = 7 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
            char threadPriority = (char) (49362 - ((Process.getThreadPriority(0) + 20) >> 6));
            int mirror = AndroidCharacter.getMirror('0') + 1720;
            byte[] bArr4 = $$a;
            byte b5 = bArr4[20];
            Object[] objArr29 = new Object[1];
            a(b5, (byte) (b5 | 46), bArr4[15], objArr29);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(scrollDefaultDelay, threadPriority, mirror, -1487073512, false, (String) objArr29[0], new Class[0]);
        }
        long jLongValue4 = ((Long) ((Method) objAccessartificialFrame7).invoke(null, null)).longValue();
        int i151 = i7;
        long j28 = -608014055;
        long j29 = SyslogConstants.LOG_LOCAL7;
        long j30 = j28 ^ j20;
        long j31 = (((long) (-183)) * j28) + (((long) 185) * jLongValue4) + ((((j30 | jLongValue4) ^ j20) | ((j24 | jLongValue4) ^ j20)) * j29) + (((long) (-184)) * (j23 | ((j28 | (jLongValue4 ^ j20)) ^ j20))) + (j29 * ((j30 | j24) ^ j20)) + ((long) 1983905805);
        int i152 = ~(i151 | (-1143084922));
        int i153 = ((int) (j31 >> 32)) & (62969522 + (((-1714655964) | i152) * 764) + (((~(i151 | (-1714655964))) | 571572354) * (-1528)) + ((i152 | 571573666) * 764));
        int iMyTid = Process.myTid();
        int i154 = i153 | (((int) j31) & (1852304502 + ((~(2143289293 | iMyTid)) * (-301)) + (((~((-2126381006) | iMyTid)) | (~((~iMyTid) | 731359880))) * (-301)) + (((~(iMyTid | (-731359881))) | (-2126381006)) * 301)));
        if (i154 != 0) {
            int i155 = -(-(i154 - 1));
            int i156 = ((i155 | 200) << 1) - (i155 ^ 200);
            i10 = ((~i156) & i) | (i156 & i151);
            i9 = 1;
        } else {
            int i157 = artificialFrame;
            i9 = 1;
            int i158 = (i157 ^ 107) + ((i157 & 107) << 1);
            getARTIFICIAL_FRAME_PACKAGE_NAME = i158 % 128;
            int i159 = i158 % 2;
            i10 = i;
        }
        if (i10 != i) {
            Object[] objArr30 = new Object[5];
            int[] iArr = new int[i9];
            objArr30[i9] = iArr;
            int[] iArr2 = new int[i9];
            objArr30[3] = iArr2;
            int[] iArr3 = new int[i9];
            objArr30[4] = iArr3;
            iArr2[0] = i;
            iArr3[0] = i10;
            objArr30[0] = null;
            objArr30[2] = null;
            int i160 = (-1536420849) + (((~((-586535510) | i151)) | (~((-18912949) | i))) * 210) + (((~(i | (-584400962))) | (~(i151 | (-16778401)))) * 210);
            int i161 = i3 + (((i160 | 16) << 1) - (16 ^ i160));
            int i162 = i161 << 13;
            int i163 = ((~i161) & i162) | ((~i162) & i161);
            int i164 = i163 >>> 17;
            int i165 = ((~i163) & i164) | ((~i164) & i163);
            int i166 = i165 << 5;
            iArr[0] = ((~i165) & i166) | ((~i166) & i165);
            return objArr30;
        }
        char c16 = (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
        int i167 = -TextUtils.indexOf((CharSequence) str5, '0');
        int i168 = (i167 & 202) + (i167 | 202);
        int i169 = artificialFrame;
        int i170 = (i169 ^ 25) + ((i169 & 25) << 1);
        getARTIFICIAL_FRAME_PACKAGE_NAME = i170 % 128;
        if (i170 % 2 != 0) {
            i11 = -(TypedValue.complexToFraction(0, 0.0f, 0.0f) > 1.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 1.0f ? 0 : -1));
            i12 = 465 % i11;
            i_BOUNDARY = TimestampAction._BOUNDARY();
        } else {
            i11 = -(TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
            i_BOUNDARY = TimestampAction._BOUNDARY();
            i12 = i11 * 465;
        }
        int i171 = (i12 & (-9260)) + (i12 | (-9260));
        int i172 = ~i_BOUNDARY;
        int i173 = ~(((-21) ^ i172) | ((-21) & i172));
        int i174 = ~(((-21) ^ i11) | ((-21) & i11));
        int i175 = (i173 & i174) | (i173 ^ i174);
        int i176 = ~(i172 | i11);
        int i177 = -(-(((i176 & i175) | (i175 ^ i176)) * 464));
        int i178 = ((i171 | i177) << 1) - (i171 ^ i177);
        int i179 = artificialFrame;
        int i180 = (i179 ^ 9) + ((i179 & 9) << 1);
        getARTIFICIAL_FRAME_PACKAGE_NAME = i180 % 128;
        int i181 = i180 % 2;
        int i182 = ~i11;
        int i183 = (i182 & i_BOUNDARY) | (i_BOUNDARY ^ i182);
        int i184 = i178 + ((-464) * ((i183 & (-21)) | (i183 ^ (-21))));
        int i185 = ~((-21) | i11);
        int i186 = ~(i_BOUNDARY | i11);
        int i187 = i184 + (((i186 & i185) | (i185 ^ i186)) * 464);
        Object[] objArr31 = new Object[1];
        b(c16, i168, i187, objArr31);
        String str18 = (String) objArr31[0];
        int i188 = -KeyEvent.normalizeMetaState(0);
        char c17 = (char) (((i188 | 54462) << 1) - (i188 ^ 54462));
        int mode = View.MeasureSpec.getMode(0) + 223;
        int i189 = -(-TextUtils.indexOf((CharSequence) str5, '0'));
        int i190 = (i189 ^ 7) + ((i189 & 7) << 1);
        Object[] objArr32 = new Object[1];
        b(c17, mode, i190, objArr32);
        String str19 = (String) objArr32[0];
        File file = new File(str18);
        if (file.exists() && file.isFile()) {
            try {
                Scanner scanner = new Scanner(new FileInputStream(file));
                char c18 = (char) ((-2) - ((-(-(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)))) ^ (-1)));
                int iRed = Color.red(0) + 229;
                int i191 = -(ViewConfiguration.getMaximumFlingVelocity() >> 16);
                Object[] objArr33 = new Object[1];
                b(c18, iRed, (i191 & 2) + (i191 | 2), objArr33);
                Scanner scannerUseDelimiter = scanner.useDelimiter((String) objArr33[0]);
                String next = scannerUseDelimiter.hasNext() ? scannerUseDelimiter.next() : str5;
                scannerUseDelimiter.close();
                if (!(!next.contains(str19))) {
                    i13 = i ^ 262;
                } else {
                    i13 = i;
                }
            } catch (IOException unused) {
            }
        } else {
            i13 = i;
        }
        if (i13 != i) {
            Object[] objArr34 = {null, new int[]{((~i) & i) | ((~i) & i)}, null, new int[]{i}, new int[]{i13}};
            int i192 = ~(i151 | 867327076);
            int i193 = ((59920448 | i192) * (-374)) + 218491377 + ((i192 | 807406628) * 374);
            int i194 = -(-(((i193 | 16) << 1) - (i193 ^ 16)));
            int i195 = ((i3 | i194) << 1) - (i3 ^ i194);
            int i196 = i195 << 13;
            int i197 = (i196 & (~i195)) | ((~i196) & i195);
            int i198 = i197 >>> 17;
            int i199 = ((~i197) & i198) | ((~i198) & i197);
            int i200 = i199 << 5;
            return objArr34;
        }
        String[] strArr6 = new String[4];
        char pressedStateDuration = (char) (ViewConfiguration.getPressedStateDuration() >> 16);
        int iResolveSizeAndState = View.resolveSizeAndState(0, 0, 0);
        int i201 = (iResolveSizeAndState ^ 231) + ((iResolveSizeAndState & 231) << 1);
        int i202 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
        int i203 = ((i202 | 31) << 1) - (i202 ^ 31);
        Object[] objArr35 = new Object[1];
        b(pressedStateDuration, i201, i203, objArr35);
        strArr6[0] = (String) objArr35[0];
        char pressedStateDuration2 = (char) (ViewConfiguration.getPressedStateDuration() >> 16);
        int iGreen = Color.green(0);
        int i204 = (iGreen ^ 262) + ((iGreen & 262) << 1);
        int i205 = -(ViewConfiguration.getWindowTouchSlop() >> 8);
        int i206 = (i205 & 23) + (i205 | 23);
        Object[] objArr36 = new Object[1];
        b(pressedStateDuration2, i204, i206, objArr36);
        strArr6[1] = (String) objArr36[0];
        char packedPositionGroup = (char) ExpandableListView.getPackedPositionGroup(0L);
        int i207 = 284 - (~(-Gravity.getAbsoluteGravity(0, 0)));
        int i208 = getARTIFICIAL_FRAME_PACKAGE_NAME;
        int i209 = ((i208 | 67) << 1) - (i208 ^ 67);
        artificialFrame = i209 % 128;
        if (i209 % 2 == 0) {
            i14 = 1;
            Object[] objArr37 = new Object[1];
            b(packedPositionGroup, i207, 13 << (PointF.length(0.0f, 0.0f) > 1.0f ? 1 : (PointF.length(0.0f, 0.0f) == 1.0f ? 0 : -1)), objArr37);
            strArr6[2] = (String) objArr37[0];
        } else {
            Object[] objArr38 = new Object[1];
            b(packedPositionGroup, i207, 28 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), objArr38);
            strArr6[2] = (String) objArr38[0];
            i14 = 0;
        }
        Object[] objArr39 = new Object[1];
        b((char) Color.red(i14), 312 - ((byte) KeyEvent.getModifierMetaStateMask()), 14 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), objArr39);
        strArr6[3] = (String) objArr39[0];
        int i210 = 0;
        int i211 = 4;
        while (true) {
            if (i210 >= i211) {
                i15 = i;
                break;
            }
            Object[] objArr40 = {strArr6[i210]};
            Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(479197382);
            if (objAccessartificialFrame8 == null) {
                int scrollDefaultDelay2 = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 17;
                char cIndexOf = (char) (24342 - TextUtils.indexOf((CharSequence) str5, '0', 0, 0));
                int doubleTapTimeout = 2014 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                byte[] bArr5 = $$a;
                byte b6 = bArr5[5];
                byte b7 = (byte) (-bArr5[7]);
                Object[] objArr41 = new Object[1];
                a(b6, b7, (byte) (b7 + 3), objArr41);
                objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(scrollDefaultDelay2, cIndexOf, doubleTapTimeout, -2081767730, false, (String) objArr41[0], new Class[]{String.class});
            }
            long jLongValue5 = ((Long) ((Method) objAccessartificialFrame8).invoke(null, objArr40)).longValue();
            int i212 = getARTIFICIAL_FRAME_PACKAGE_NAME + 87;
            artificialFrame = i212 % 128;
            if (i212 % 2 == 0) {
                new Random().nextInt(52794852);
                throw null;
            }
            long j32 = -273746642;
            long j33 = j32 ^ j20;
            long j34 = (j24 | j32) ^ j20;
            long j35 = (((long) 375) * j32) + (((long) (-747)) * jLongValue5) + (((long) (-374)) * (((j33 | jLongValue5) ^ j20) | j34));
            long j36 = jLongValue5 ^ j20;
            long j37 = j35 + (((long) 748) * ((j32 | j36) ^ j20)) + (((long) 374) * (((j33 | j36) ^ j20) | j34)) + ((long) 770358033);
            int i213 = ((int) (j37 >> 32)) & (1293412682 + (((-34214145) | i151) * SyslogConstants.LOG_LOCAL7) + (((~(i151 | 1372603562)) | (-1376409003)) * SyslogConstants.LOG_LOCAL7));
            int i214 = ((int) j37) & (((~((-17039394) | i)) * 521) + 1990062820 + (((~(i151 | (-17039394))) | 536953864) * 521));
            if (((i213 & i214) | (i213 ^ i214)) != 0) {
                int i215 = i210 + 252;
                i15 = (i215 & i151) | ((~i215) & i);
                break;
            }
            i210++;
            i211 = 4;
        }
        if (i15 != i) {
            Object[] objArr42 = {null, new int[]{i ^ (i << 5)}, null, new int[]{i}, new int[]{i15}};
            int i216 = 1513034809 + (((~(i151 | (-281004821))) | 278265876) * (-108)) + (((~((-886453279) | i)) | (-889192223) | (~(i151 | 886453278))) * 54) + ((i | (-889192223)) * 54);
            int i217 = i3 + (((i216 | 16) << 1) - (16 ^ i216));
            int i218 = i217 << 13;
            int i219 = (i217 | i218) & (~(i217 & i218));
            int i220 = i219 >>> 17;
            int i221 = (i219 | i220) & (~(i219 & i220));
            return objArr42;
        }
        char cBlue = (char) Color.blue(0);
        float maxVolume = AudioTrack.getMaxVolume();
        int i222 = getARTIFICIAL_FRAME_PACKAGE_NAME;
        int i223 = (i222 ^ 17) + ((i222 & 17) << 1);
        artificialFrame = i223 % 128;
        int i224 = i223 % 2;
        int i225 = -(maxVolume > 0.0f ? 1 : (maxVolume == 0.0f ? 0 : -1));
        int i226 = (328 & i225) + (i225 | 328);
        int i227 = -TextUtils.indexOf((CharSequence) str5, '0', 0);
        int i228 = ((i227 | 12) << 1) - (i227 ^ 12);
        Object[] objArr43 = new Object[1];
        b(cBlue, i226, i228, objArr43);
        Object[] objArr44 = {(String) objArr43[0]};
        Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1483923676);
        if (objAccessartificialFrame9 == null) {
            int tapTimeout = 23 - (ViewConfiguration.getTapTimeout() >> 16);
            char cIndexOf2 = (char) TextUtils.indexOf(str5, str5, 0, 0);
            int threadPriority2 = 2441 - ((Process.getThreadPriority(0) + 20) >> 6);
            byte b8 = $$a[10];
            byte b9 = b8;
            Object[] objArr45 = new Object[1];
            a(b9, (byte) (b9 | 48), b8, objArr45);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(tapTimeout, cIndexOf2, threadPriority2, 954751276, false, (String) objArr45[0], new Class[]{String.class});
        }
        String str20 = (String) ((Method) objAccessartificialFrame9).invoke(null, objArr44);
        if (str20 != null) {
            int i229 = -(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
            char c19 = (char) ((i229 ^ 9994) + ((i229 & 9994) << 1));
            int i230 = ~(((-377416124) & i) | ((-377416124) ^ i));
            int i231 = (i230 & 102017280) | (102017280 ^ i230);
            int i232 = ~(946491579 | i);
            int i233 = -(-(((i231 & i232) | (i231 ^ i232)) * (-744)));
            int i234 = (((-1916268057) | i233) << 1) - (i233 ^ (-1916268057));
            int i235 = ((i151 & 671092736) | (i151 ^ 671092736)) * 744;
            int i236 = (i234 & i235) + (i235 | i234) + (((-102017281) | i) * 744);
            int i237 = ~((-948783247) | i);
            int i238 = ((i237 & (-1910826797)) | ((-1910826797) ^ i237)) * (-366);
            if (i236 <= (1133677373 & i238) + (i238 | 1133677373) + (((~(((-813973517) & i) | ((-813973517) ^ i))) | (-2045636527)) * 366)) {
                Object[] objArr46 = new Object[1];
                b(c19, 339 % TextUtils.indexOf((CharSequence) str5, 'd'), 119 >> (ViewConfiguration.getKeyRepeatDelay() >>> 52), objArr46);
                obj3 = objArr46[0];
            } else {
                int iIndexOf2 = 339 - TextUtils.indexOf((CharSequence) str5, '0');
                int i239 = -(-(ViewConfiguration.getKeyRepeatDelay() >> 16));
                int i240 = (i239 ^ 9) + ((i239 & 9) << 1);
                Object[] objArr47 = new Object[1];
                b(c19, iIndexOf2, i240, objArr47);
                obj3 = objArr47[0];
            }
            if (str20.contains((String) obj3)) {
                i16 = i ^ ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
            } else {
                i16 = i;
            }
        } else {
            i16 = i;
        }
        if (i16 != i) {
            Object[] objArr48 = {null, new int[1], null, new int[]{i}, new int[]{i16}};
            int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
            int i241 = ~((-698835952) | startElapsedRealtime);
            int i242 = ~startElapsedRealtime;
            int i243 = (-484095695) + ((i241 | (~((-93387494) | i242))) * (-1808)) + (((~((-673644811) | startElapsedRealtime)) | (~(i242 | (-68196353)))) * TypedValues.Custom.TYPE_BOOLEAN) + (((~(startElapsedRealtime | 93387493)) | 25191141 | (~(698835951 | i242))) * TypedValues.Custom.TYPE_BOOLEAN);
            int i244 = artificialFrame + 63;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i244 % 128;
            if (i244 % 2 != 0) {
                int i245 = (i243 << 16) * i3;
                int i246 = i245 + b.f39n;
                int i247 = (i245 | i246) & (~(i245 & i246));
                i34 = i247 ^ (i247 >>> 51);
            } else {
                int i248 = i243 + 16;
                int i249 = ((i3 | i248) << 1) - (i3 ^ i248);
                int i250 = i249 << 13;
                int i251 = (i249 | i250) & (~(i249 & i250));
                int i252 = i251 >>> 17;
                i34 = (i251 | i252) & (~(i251 & i252));
            }
            int i253 = i34 << 5;
            ((int[]) objArr48[1])[0] = (i34 | i253) & (~(i34 & i253));
            return objArr48;
        }
        char threadPriority3 = (char) ((Process.getThreadPriority(0) + 20) >> 6);
        int i254 = -Color.rgb(0, 0, 0);
        Object[] objArr49 = new Object[1];
        b(threadPriority3, ((i254 | (-16776867)) << 1) - (i254 ^ (-16776867)), 17 - (Process.myTid() >> 22), objArr49);
        String str21 = (String) objArr49[0];
        char c20 = (char) (0 - (~(-(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)))));
        int iMyTid2 = (Process.myTid() >> 22) + 366;
        int iLastIndexOf3 = TextUtils.lastIndexOf(str5, '0', 0, 0);
        Object[] objArr50 = new Object[1];
        b(c20, iMyTid2, (iLastIndexOf3 & 7) + (iLastIndexOf3 | 7), objArr50);
        Object[] objArr51 = {str21, (String) objArr50[0]};
        Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-883653127);
        if (objAccessartificialFrame10 == null) {
            int fadingEdgeLength3 = (ViewConfiguration.getFadingEdgeLength() >> 16) + 31;
            char offsetAfter = (char) (57022 - TextUtils.getOffsetAfter(str5, 0));
            int scrollBarFadeDuration = 2311 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
            byte[] bArr6 = $$a;
            Object[] objArr52 = new Object[1];
            a(bArr6[10], (byte) 18, (byte) (bArr6[0] + 1), objArr52);
            objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength3, offsetAfter, scrollBarFadeDuration, 1412547569, false, (String) objArr52[0], new Class[]{String.class, String.class});
        }
        long jLongValue6 = ((Long) ((Method) objAccessartificialFrame10).invoke(null, objArr51)).longValue();
        long j38 = 326077036;
        long j39 = (((long) (-589)) * j38) + (((long) 591) * jLongValue6);
        long j40 = 590;
        long j41 = jLongValue6 ^ j20;
        long jUptimeMillis = (int) SystemClock.uptimeMillis();
        long j42 = jUptimeMillis ^ j20;
        long j43 = ((j41 | j42) ^ j20) | ((j41 | j38) ^ j20) | ((j42 | j38) ^ j20);
        long j44 = j38 ^ j20;
        long j45 = j39 + ((j43 | (((j44 | jLongValue6) | jUptimeMillis) ^ j20)) * j40) + (((long) (-1180)) * j43) + (j40 * (((j42 | jLongValue6) ^ j20) | ((j44 | j42) ^ j20))) + ((long) (-480828665));
        int i255 = ((int) (j45 >> 32)) & (2117358202 + (((~((-1158339182) | i151)) | (~(1436547965 | i))) * (-831)) + ((~((-1157660737) | i)) * (-1662)) + (((~((-278887230) | i151)) | (~(278887229 | i)) | (~(1158339181 | i))) * 831));
        int i256 = ((int) j45) & (((((~(1755317476 | i)) | 1102423409) * 56) - 2024491635) + ((1755317476 | (~(i151 | 1102423409))) * 56));
        int i257 = ((int) ((long) ((i255 & i256) | (i255 ^ i256)))) != 0 ? i ^ 251 : i;
        if (i257 != i) {
            Object[] objArr53 = {null, new int[1], null, new int[]{i}, new int[]{i257}};
            int i258 = artificialFrame;
            int i259 = ((i258 | 85) << 1) - (i258 ^ 85);
            getARTIFICIAL_FRAME_PACKAGE_NAME = i259 % 128;
            int i260 = i259 % 2;
            int iUptimeMillis = (int) SystemClock.uptimeMillis();
            int i261 = i3 + (((1715647279 + (((-69238801) | (~iUptimeMillis)) * (-490))) + (((~(iUptimeMillis | (-69312530))) | 73729) * 490)) - 713600138);
            int i262 = i261 << 13;
            int i263 = ((~i261) & i262) | ((~i262) & i261);
            int i264 = i263 >>> 17;
            int i265 = (i263 | i264) & (~(i263 & i264));
            int i266 = i265 << 5;
            ((int[]) objArr53[1])[0] = (i265 | i266) & (~(i265 & i266));
            return objArr53;
        }
        int fadingEdgeLength4 = ViewConfiguration.getFadingEdgeLength() >> 16;
        int i267 = fadingEdgeLength4 * (-919);
        int i268 = ((i267 | (-34725334)) << 1) - (i267 ^ (-34725334));
        int i269 = ~fadingEdgeLength4;
        int i270 = (-37787) | i269;
        int i271 = ~((i270 ^ i) | (i270 & i));
        int i272 = ((-37787) ^ i53) | ((-37787) & i53);
        int i273 = ~((i272 & fadingEdgeLength4) | (i272 ^ fadingEdgeLength4));
        int i274 = -(-(((i271 & i273) | (i271 ^ i273)) * 920));
        int i275 = ((i268 | i274) << 1) - (i274 ^ i268);
        int i276 = ~i270;
        int i277 = ~((i269 ^ i151) | (i269 & i151));
        int i278 = ((i276 & i277) | (i276 ^ i277)) * 920;
        int i279 = (i275 & i278) + (i278 | i275);
        int i280 = ~(((-37787) & i269) | (i269 ^ (-37787)) | i53);
        int i281 = (i269 & 37786) | (i269 ^ 37786);
        int i282 = (~((i281 & i) | (i281 ^ i))) | i280;
        int i283 = (fadingEdgeLength4 & (-37787)) | ((-37787) ^ fadingEdgeLength4);
        int i284 = ~((i283 & i) | (i283 ^ i));
        int i285 = -(-(((i282 & i284) | (i282 ^ i284)) * 920));
        char c21 = (char) (((i279 | i285) << 1) - (i285 ^ i279));
        int packedPositionType = ExpandableListView.getPackedPositionType(0L);
        int i286 = (packedPositionType ^ 372) + ((packedPositionType & 372) << 1);
        int i287 = -(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
        int i288 = (i287 ^ 24) + ((i287 & 24) << 1);
        Object[] objArr54 = new Object[1];
        b(c21, i286, i288, objArr54);
        Object[] objArr55 = {(String) objArr54[0]};
        Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-1483923676);
        if (objAccessartificialFrame11 == null) {
            int iAxisFromString2 = 22 - MotionEvent.axisFromString(str5);
            char cResolveSizeAndState = (char) View.resolveSizeAndState(0, 0, 0);
            int offsetBefore = 2441 - TextUtils.getOffsetBefore(str5, 0);
            byte b10 = $$a[10];
            byte b11 = b10;
            Object[] objArr56 = new Object[1];
            a(b11, (byte) (b11 | 48), b10, objArr56);
            objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(iAxisFromString2, cResolveSizeAndState, offsetBefore, 954751276, false, (String) objArr56[0], new Class[]{String.class});
        }
        String lowerCase = ((String) ((Method) objAccessartificialFrame11).invoke(null, objArr55)).toLowerCase();
        char cIndexOf3 = (char) (TextUtils.indexOf(str5, str5, 0) + 2497);
        int i289 = 394 - (~(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
        int i290 = -(Process.myTid() >> 22);
        int i291 = (i290 ^ 4) + ((i290 & 4) << 1);
        Object[] objArr57 = new Object[1];
        b(cIndexOf3, i289, i291, objArr57);
        int i292 = lowerCase.contains((String) objArr57[0]) ? (~(i & 264)) & (i | 264) : i;
        if (i292 != i) {
            Object[] objArr58 = {null, new int[]{((~i) & i) | ((~i) & i)}, null, new int[]{i}, new int[]{i292}};
            int i293 = (-1206929137) + (((~((-675285267) | i)) | (~(i151 | (-69836809)))) * (-318)) + (((~(717512566 | i)) | (-787349375)) * (-318)) + (((~(i | (-717512567))) | 112064108) * TypedValues.AttributesType.TYPE_PIVOT_TARGET);
            int i294 = (i3 - (~(-(-((i293 & 16) + (16 | i293)))))) - 1;
            int i295 = i294 << 13;
            int i296 = ((~i294) & i295) | ((~i295) & i294);
            int i297 = i296 ^ (i296 >>> 17);
            int i298 = i297 << 5;
            return objArr58;
        }
        int i299 = -TextUtils.indexOf((CharSequence) str5, '0', 0, 0);
        int i300 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
        int i301 = (i300 ^ 398) + ((i300 & 398) << 1);
        int i302 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
        int i303 = ((i302 | 41) << 1) - (i302 ^ 41);
        Object[] objArr59 = new Object[1];
        b((char) ((i299 & 31594) + (i299 | 31594)), i301, i303, objArr59);
        String str22 = (String) objArr59[0];
        char c22 = (char) (42306 - (~(-(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)))));
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int i304 = iMakeMeasureSpec2 * 141;
        int i305 = (i304 ^ (-123039)) + ((i304 & (-123039)) << 1);
        int i306 = -(-(((i ^ 441) | (i & 441)) * 140));
        int i307 = (i305 ^ i306) + ((i306 & i305) << 1);
        int i308 = ~iMakeMeasureSpec2;
        int i309 = ((~((i308 & 441) | (i308 ^ 441))) | (~(i151 | 441))) * (-280);
        int i310 = ((i307 | i309) << 1) - (i309 ^ i307);
        int i311 = (~(((-442) & iMakeMeasureSpec2) | ((-442) ^ iMakeMeasureSpec2))) | (~(i151 | iMakeMeasureSpec2));
        int i312 = (~iMakeMeasureSpec2) | 441;
        int i313 = ~((i312 & i) | (i312 ^ i));
        int i314 = -(-(((i311 & i313) | (i311 ^ i313)) * 140));
        int i315 = (i310 & i314) + (i314 | i310);
        int i316 = -(-MotionEvent.axisFromString(str5));
        Object[] objArr60 = new Object[1];
        b(c22, i315, (i316 & 41) + (i316 | 41), objArr60);
        String str23 = (String) objArr60[0];
        int i317 = -(-TextUtils.lastIndexOf(str5, '0'));
        Object[] objArr61 = new Object[1];
        b((char) ((i317 & 52971) + (i317 | 52971)), 480 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 27 - (KeyEvent.getMaxKeyCode() >> 16), objArr61);
        String str24 = (String) objArr61[0];
        char mirror2 = (char) (AndroidCharacter.getMirror('0') + 28434);
        int i318 = -((byte) KeyEvent.getModifierMetaStateMask());
        int i319 = (i318 & TypedValues.PositionType.TYPE_PERCENT_Y) + (i318 | TypedValues.PositionType.TYPE_PERCENT_Y);
        int i320 = -(-(ViewConfiguration.getJumpTapTimeout() >> 16));
        int i321 = ((i320 | 27) << 1) - (i320 ^ 27);
        Object[] objArr62 = new Object[1];
        b(mirror2, i319, i321, objArr62);
        String str25 = (String) objArr62[0];
        char cRgb = (char) (Color.rgb(0, 0, 0) + 16788268);
        int i322 = 535 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
        int i323 = -(ViewConfiguration.getEdgeSlop() >> 16);
        int i324 = (i323 ^ 27) + ((i323 & 27) << 1);
        Object[] objArr63 = new Object[1];
        b(cRgb, i322, i324, objArr63);
        String str26 = (String) objArr63[0];
        char c23 = (char) (0 - (~(-(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)))));
        int i325 = -(-(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
        Object[] objArr64 = new Object[1];
        b(c23, ((i325 | 561) << 1) - (i325 ^ 561), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 27, objArr64);
        int i326 = i151;
        String[] strArr7 = {str22, str23, str24, str25, str26, (String) objArr64[0]};
        int i327 = 0;
        while (true) {
            if (i327 >= 6) {
                i17 = i;
                break;
            }
            Object[] objArr65 = {strArr7[i327]};
            Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-1483923676);
            if (objAccessartificialFrame12 == null) {
                int offsetAfter2 = 23 - TextUtils.getOffsetAfter(str5, 0);
                char packedPositionGroup2 = (char) ExpandableListView.getPackedPositionGroup(0L);
                int i328 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 2440;
                byte b12 = $$a[10];
                byte b13 = b12;
                Object[] objArr66 = new Object[1];
                a(b13, (byte) (b13 | 48), b12, objArr66);
                objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(offsetAfter2, packedPositionGroup2, i328, 954751276, false, (String) objArr66[0], new Class[]{String.class});
            }
            String str27 = (String) ((Method) objAccessartificialFrame12).invoke(null, objArr65);
            if (str27 != null && str27.length() != 0) {
                i17 = (~(i & 265)) & (i | 265);
                break;
            }
            i327++;
        }
        if (i17 == i) {
            char trimmedLength = (char) TextUtils.getTrimmedLength(str5);
            int i329 = -(-TextUtils.indexOf(str5, str5));
            int i330 = (i329 ^ 349) + ((i329 & 349) << 1);
            int i331 = -(ViewConfiguration.getScrollDefaultDelay() >> 16);
            int i332 = (i331 & 17) + (i331 | 17);
            Object[] objArr67 = new Object[1];
            b(trimmedLength, i330, i332, objArr67);
            String str28 = (String) objArr67[0];
            Object[] objArr68 = new Object[1];
            b((char) (ViewConfiguration.getFadingEdgeLength() >> 16), 588 - (~(-(ViewConfiguration.getLongPressTimeout() >> 16))), 6 - (~TextUtils.indexOf((CharSequence) str5, '0', 0, 0)), objArr68);
            String str29 = (String) objArr68[0];
            File file2 = new File(str28);
            if (file2.exists() && file2.isFile()) {
                try {
                    Scanner scanner2 = new Scanner(new FileInputStream(file2));
                    char cNormalizeMetaState = (char) KeyEvent.normalizeMetaState(0);
                    int i333 = -(-(TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)));
                    int i334 = (i333 & 229) + (i333 | 229);
                    int i335 = -(ViewConfiguration.getLongPressTimeout() >> 16);
                    int i336 = (i335 ^ 2) + ((i335 & 2) << 1);
                    Object[] objArr69 = new Object[1];
                    b(cNormalizeMetaState, i334, i336, objArr69);
                    Scanner scannerUseDelimiter2 = scanner2.useDelimiter((String) objArr69[0]);
                    String next2 = scannerUseDelimiter2.hasNext() ? scannerUseDelimiter2.next() : str5;
                    scannerUseDelimiter2.close();
                    if (next2.contains(str29)) {
                        int i337 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i338 = (i337 ^ 39) + ((i337 & 39) << 1);
                        artificialFrame = i338 % 128;
                        int i339 = i338 % 2;
                        z = true;
                        z2 = true;
                    } else {
                        z = true;
                        z2 = false;
                    }
                } catch (IOException unused2) {
                }
            } else {
                z = true;
                z2 = false;
            }
            if ((!z2) != z) {
                i18 = (i & (-261)) | (i326 & 260);
            } else {
                Object[] objArr70 = new Object[1];
                b((char) (46369 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1))), 595 - (ViewConfiguration.getPressedStateDuration() >> 16), TextUtils.indexOf(str5, str5, 0) + 13, objArr70);
                String str30 = (String) objArr70[0];
                char deadChar = (char) (KeyEvent.getDeadChar(0, 0) + 54448);
                int iBlue2 = Color.blue(0);
                int i340 = ((iBlue2 | TypedValues.MotionType.TYPE_DRAW_PATH) << 1) - (iBlue2 ^ TypedValues.MotionType.TYPE_DRAW_PATH);
                int i341 = -View.MeasureSpec.getMode(0);
                int i342 = (i341 * (-813)) + 3672;
                int i343 = ~((-10) | i341);
                int i344 = ~(i341 | i);
                int i345 = ((i343 & i344) | (i343 ^ i344)) * (-814);
                int i346 = (i342 & i345) + (i342 | i345);
                int i347 = ~(((-10) & i53) | ((-10) ^ i53));
                int i348 = ~i341;
                int i349 = i347 | (~(i348 | 9));
                int i350 = ~((i341 ^ i) | (i341 & i));
                int i351 = -(-(((i349 & i350) | (i349 ^ i350)) * 407));
                int i352 = (i346 & i351) + (i351 | i346);
                int i353 = ~i341;
                int i354 = ~((i353 & 9) | (i353 ^ 9));
                int i355 = ~((i348 ^ i) | (i348 & i));
                int i356 = (i354 & i355) | (i354 ^ i355);
                int i357 = ~((i ^ 9) | (i & 9));
                int i358 = -(-(((i356 & i357) | (i356 ^ i357)) * 407));
                int i359 = ((i352 | i358) << 1) - (i358 ^ i352);
                Object[] objArr71 = new Object[1];
                b(deadChar, i340, i359, objArr71);
                Object[] objArr72 = {str30, (String) objArr71[0]};
                Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-883653127);
                if (objAccessartificialFrame13 == null) {
                    int i360 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 30;
                    char offsetBefore2 = (char) (TextUtils.getOffsetBefore(str5, 0) + 57022);
                    int longPressTimeout = 2311 - (ViewConfiguration.getLongPressTimeout() >> 16);
                    byte[] bArr7 = $$a;
                    Object[] objArr73 = new Object[1];
                    a(bArr7[10], (byte) 18, (byte) (bArr7[0] + 1), objArr73);
                    objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(i360, offsetBefore2, longPressTimeout, 1412547569, false, (String) objArr73[0], new Class[]{String.class, String.class});
                }
                long jLongValue7 = ((Long) ((Method) objAccessartificialFrame13).invoke(null, objArr72)).longValue();
                long j46 = 1594211250;
                long j47 = -68;
                long j48 = j46 ^ j20;
                long j49 = jLongValue7 ^ j20;
                long j50 = (((long) 69) * j46) + (((long) (-67)) * jLongValue7) + (((((j48 | j49) | j24) ^ j20) | ((j46 | jLongValue7) ^ j20) | ((jLongValue7 | j23) ^ j20)) * j47) + (j47 * ((jLongValue7 | (j48 | j24)) ^ j20)) + (((long) 68) * (j48 | ((j49 | j24) ^ j20))) + ((long) (-1748962879));
                int i361 = ((int) (j50 >> 32)) & (1738041050 + (((~((-1869734783) | i326)) | 1714446892 | (~(432508371 | i326))) * (-1136)) + (((~((-1869734783) | i)) | (~(432508371 | i)) | (~((-277220482) | i326))) * (-568)) + (((~(1869734782 | i326)) | (~((-432508372) | i326)) | (~((-1714446893) | i))) * 568));
                int iMyPid2 = Process.myPid();
                int i362 = ((int) j50) & (2005432269 + (((~(931471216 | iMyPid2)) | (-1067794298)) * 104) + ((~((~iMyPid2) | (-369432113))) * (-104)) + ((iMyPid2 | (-505755194)) * 104));
                i18 = ((int) ((long) ((i361 & i362) | (i361 ^ i362)))) != 0 ? (~(i & 261)) & (i | 261) : i;
            }
            if (i18 != i) {
                Object[] objArr74 = {null, new int[1], null, new int[]{i}, new int[]{i18}};
                int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
                int i363 = (((~((-524374465) | iMaxMemory)) | 462702217) * 262) + 1442734365 + (((~((~iMaxMemory) | (-524374465))) | 462702217) * 262);
                int i364 = (i363 ^ 16) + ((16 & i363) << 1);
                int i365 = (i3 ^ i364) + ((i3 & i364) << 1);
                int i366 = i365 << 13;
                int i367 = (i366 | i365) & (~(i365 & i366));
                int i368 = i367 >>> 17;
                int i369 = (i367 | i368) & (~(i367 & i368));
                int i370 = i369 << 5;
                ((int[]) objArr74[1])[0] = ((~i369) & i370) | ((~i370) & i369);
                return objArr74;
            }
            Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-913150042);
            if (objAccessartificialFrame14 == null) {
                int i371 = 28 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                char cIndexOf4 = (char) ((-1) - TextUtils.indexOf((CharSequence) str5, '0', 0, 0));
                int deadChar2 = 764 - KeyEvent.getDeadChar(0, 0);
                byte[] bArr8 = $$a;
                byte b14 = bArr8[20];
                Object[] objArr75 = new Object[1];
                a(b14, (byte) (b14 | Ascii.DC2), bArr8[18], objArr75);
                objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(i371, cIndexOf4, deadChar2, 1459038638, false, (String) objArr75[0], new Class[0]);
            }
            long jLongValue8 = ((Long) ((Method) objAccessartificialFrame14).invoke(null, null)).longValue();
            long j51 = 1090919209;
            long j52 = 302;
            long j53 = -301;
            long j54 = (((long) (-300)) * j51) + (j52 * jLongValue8) + ((((j51 | jLongValue8) | j23) ^ j20) * j53);
            long j55 = jLongValue8 ^ j20;
            long j56 = j54 + ((((j55 | j23) ^ j20) | ((j24 | j51) ^ j20)) * j53) + (((long) 301) * (j55 | (((j51 ^ j20) | j23) ^ j20))) + ((long) 847682443);
            int iMaxMemory2 = (int) Runtime.getRuntime().maxMemory();
            int i372 = ~iMaxMemory2;
            int i373 = ((int) (j56 >> 32)) & (((((~(2054778230 | i372)) | (~((-802962655) | iMaxMemory2))) * 959) - 662478127) + (((~(iMaxMemory2 | 2054778230)) | (~(i372 | (-802962655)))) * 959));
            int i374 = ~((~((int) Process.getStartElapsedRealtime())) | 2066095578);
            int i375 = ((int) j56) & (((1342181760 | i374) * (-970)) + 1282223185 + ((i374 | 723913818) * 970));
            if (((i373 & i375) | (i373 ^ i375)) == 1) {
                Object[] objArr76 = {null, new int[1], null, new int[]{i}, new int[]{i}};
                int startUptimeMillis2 = (int) Process.getStartUptimeMillis();
                int i376 = i3 + (-2102461940) + (((-318832642) | startUptimeMillis2) * (-381)) + (((~((~startUptimeMillis2) | 214623940)) | (-461464706)) * 381) + 1216151933;
                int i377 = i376 << 13;
                int i378 = (i376 | i377) & (~(i376 & i377));
                int i379 = i378 >>> 17;
                int i380 = ((~i378) & i379) | ((~i379) & i378);
                int i381 = i380 << 5;
                ((int[]) objArr76[1])[0] = (i380 | i381) & (~(i380 & i381));
                int i382 = getARTIFICIAL_FRAME_PACKAGE_NAME + 5;
                artificialFrame = i382 % 128;
                int i383 = i382 % 2;
                return objArr76;
            }
            Object[] objArr77 = {1};
            Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1671772348);
            if (objAccessartificialFrame15 == null) {
                int iMyPid3 = 18 - (Process.myPid() >> 22);
                char c24 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                int iMyTid3 = (Process.myTid() >> 22) + 1573;
                byte[] bArr9 = $$a;
                byte b15 = bArr9[20];
                Object[] objArr78 = new Object[1];
                a(b15, b15, (byte) (-bArr9[7]), objArr78);
                objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(iMyPid3, c24, iMyTid3, -54493516, false, (String) objArr78[0], new Class[]{Integer.TYPE});
            }
            long jLongValue9 = ((Long) ((Method) objAccessartificialFrame15).invoke(null, objArr77)).longValue();
            long j57 = -1064378343;
            long j58 = -743;
            long j59 = j57 | jLongValue9;
            long jMyTid = Process.myTid();
            long j60 = 744;
            long j61 = (j58 * j57) + (j58 * jLongValue9) + (((long) (-744)) * ((j59 ^ j20) | ((j57 | jMyTid) ^ j20) | ((jLongValue9 | jMyTid) ^ j20))) + (((jMyTid ^ j20) | (((jLongValue9 ^ j20) | (j57 ^ j20)) ^ j20)) * j60) + (j60 * (j59 | jMyTid)) + ((long) 1548963060);
            int iMyUid = Process.myUid();
            int i384 = ((int) (j61 >> 32)) & (1276784514 + (((~(1400460158 | iMyUid)) | 36766252) * (-756)) + (((~iMyUid) | 1400460158) * 756));
            int i385 = ((int) j61) & ((-588607485) + (((~(839920460 | i)) | 1212503041) * (-140)) + ((~(2052423501 | i)) * 70) + (((~(2017820425 | i)) | 1247106117) * 70));
            int i386 = ((int) ((long) ((i384 & i385) | (i384 ^ i385)))) != 0 ? (~(i & 220)) & (i | 220) : i;
            if (i386 != i) {
                Object[] objArr79 = {null, new int[1], null, new int[]{i}, new int[]{i386}};
                int iNextInt2 = new Random().nextInt();
                int i387 = ((((~((-190525595) | iNextInt2)) | 54526096) * (-283)) - 1143535559) + ((~(iNextInt2 | (-135999499))) * 283);
                int i388 = i3 + (((i387 | 16) << 1) - (i387 ^ 16));
                int i389 = i388 << 13;
                int i390 = ((~i388) & i389) | ((~i389) & i388);
                int i391 = i390 >>> 17;
                int i392 = (i390 | i391) & (~(i390 & i391));
                int i393 = i392 << 5;
                ((int[]) objArr79[1])[0] = (i392 | i393) & (~(i392 & i393));
                return objArr79;
            }
            int scrollBarSize2 = ViewConfiguration.getScrollBarSize() >> 8;
            char c25 = (char) (((scrollBarSize2 | 37786) << 1) - (scrollBarSize2 ^ 37786));
            int packedPositionGroup3 = 372 - ExpandableListView.getPackedPositionGroup(0L);
            int i394 = -(-TextUtils.lastIndexOf(str5, '0', 0));
            int i395 = (i394 ^ 24) + ((i394 & 24) << 1);
            Object[] objArr80 = new Object[1];
            b(c25, packedPositionGroup3, i395, objArr80);
            Object[] objArr81 = {(String) objArr80[0]};
            Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-1483923676);
            if (objAccessartificialFrame16 == null) {
                int doubleTapTimeout2 = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 23;
                char c26 = (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1);
                int iResolveOpacity = Drawable.resolveOpacity(0, 0) + 2441;
                byte b16 = $$a[10];
                byte b17 = b16;
                Object[] objArr82 = new Object[1];
                a(b17, (byte) (b17 | 48), b16, objArr82);
                objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout2, c26, iResolveOpacity, 954751276, false, (String) objArr82[0], new Class[]{String.class});
            }
            Object objInvoke = ((Method) objAccessartificialFrame16).invoke(null, objArr81);
            if (objInvoke != null) {
                Object[] objArr83 = {objInvoke, 42};
                Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-287841710);
                if (objAccessartificialFrame17 == null) {
                    int capsMode2 = 20 - TextUtils.getCapsMode(str5, 0, 0);
                    char offsetAfter3 = (char) TextUtils.getOffsetAfter(str5, 0);
                    int i396 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 2244;
                    byte[] bArr10 = $$a;
                    byte b18 = bArr10[10];
                    byte b19 = bArr10[16];
                    Object[] objArr84 = new Object[1];
                    a(b18, b19, (byte) (b19 + 3), objArr84);
                    objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(capsMode2, offsetAfter3, i396, 1907532890, false, (String) objArr84[0], new Class[]{String.class, Integer.TYPE});
                }
                long jLongValue10 = ((Long) ((Method) objAccessartificialFrame17).invoke(null, objArr83)).longValue();
                long j62 = 1348307509;
                long j63 = j62 ^ j20;
                long jFreeMemory = (((long) ((int) Runtime.getRuntime().freeMemory())) | jLongValue10) ^ j20;
                long j64 = (((long) (-109)) * j62) + (((long) b.f40o) * jLongValue10) + (((long) (-220)) * (j63 | jFreeMemory)) + (((long) 220) * (((j62 | jLongValue10) ^ j20) | jFreeMemory)) + (((long) b.f39n) * ((((jLongValue10 ^ j20) | j62) ^ j20) | ((j63 | jLongValue10) ^ j20))) + ((long) 284777819);
                int iNextInt3 = new Random().nextInt(1935538407);
                int i397 = ~iNextInt3;
                int i398 = ((int) (j64 >> 32)) & ((-351366592) + (((-1722409306) | iNextInt3) * (-859)) + (((~(iNextInt3 | 1739319803)) | (~((-1722409306) | i397))) * 859) + (((~(1135331579 | i397)) | 603988224) * 859));
                int i399 = (~((-1534019465) | i326)) | 1248215688;
                int i400 = ~(1609525197 | i);
                if ((i398 | (((int) j64) & ((-1898176251) + ((i399 | i400) * (-502)) + (((~((-285803777) | i326)) | i400) * TypedValues.PositionType.TYPE_DRAWPATH)))) == 1986687685) {
                    int i401 = artificialFrame + 123;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i401 % 128;
                    if (i401 % 2 != 0) {
                        int offsetAfter4 = TextUtils.getOffsetAfter(str5, 0);
                        int iKeyCodeFromString = KeyEvent.keyCodeFromString(str5) + 372;
                        int i402 = -Color.rgb(0, 0, 0);
                        int i403 = ((-16777193) ^ i402) + ((i402 & (-16777193)) << 1);
                        Object[] objArr85 = new Object[1];
                        b((char) (((37786 | offsetAfter4) << 1) - (offsetAfter4 ^ 37786)), iKeyCodeFromString, i403, objArr85);
                        String str31 = (String) objArr85[0];
                        char windowTouchSlop2 = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                        int i404 = -(-Color.green(0));
                        int i405 = (i404 ^ 617) + ((i404 & 617) << 1);
                        int scrollDefaultDelay3 = ViewConfiguration.getScrollDefaultDelay() >> 16;
                        Object[] objArr86 = new Object[1];
                        b(windowTouchSlop2, i405, ((scrollDefaultDelay3 | 10) << 1) - (scrollDefaultDelay3 ^ 10), objArr86);
                        String str32 = (String) objArr86[0];
                        int i406 = -(-(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                        int i407 = -(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                        int iIndexOf3 = TextUtils.indexOf((CharSequence) str5, '0', 0, 0);
                        Object[] objArr87 = new Object[1];
                        b((char) ((i406 & 10715) + (i406 | 10715)), (i407 & 628) + (i407 | 628), (iIndexOf3 & 8) + (iIndexOf3 | 8), objArr87);
                        String str33 = (String) objArr87[0];
                        int i408 = -(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                        Object[] objArr88 = new Object[1];
                        b((char) ((i408 & 1) + (i408 | 1)), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 634, 8 - KeyEvent.keyCodeFromString(str5), objArr88);
                        String[] strArr8 = {str31, str32, str33, (String) objArr88[0]};
                        char cRgb2 = (char) (Color.rgb(0, 0, 0) + 16801575);
                        int i409 = -(ViewConfiguration.getLongPressTimeout() >> 16);
                        int i410 = ((i409 | 642) << 1) - (i409 ^ 642);
                        int trimmedLength2 = TextUtils.getTrimmedLength(str5);
                        int i411 = (trimmedLength2 & 17) + (trimmedLength2 | 17);
                        Object[] objArr89 = new Object[1];
                        b(cRgb2, i410, i411, objArr89);
                        String str34 = (String) objArr89[0];
                        char c27 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                        int i412 = -Drawable.resolveOpacity(0, 0);
                        int i413 = (i412 ^ 659) + ((i412 & 659) << 1);
                        c = '0';
                        Object[] objArr90 = new Object[1];
                        b(c27, i413, '7' - AndroidCharacter.getMirror('0'), objArr90);
                        String str35 = (String) objArr90[0];
                        int i414 = -(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                        int longPressTimeout2 = 666 - (ViewConfiguration.getLongPressTimeout() >> 16);
                        int i415 = -(ViewConfiguration.getScrollBarFadeDuration() >> 16);
                        int i416 = ((i415 | 7) << 1) - (i415 ^ 7);
                        Object[] objArr91 = new Object[1];
                        b((char) ((40972 ^ i414) + ((i414 & 40972) << 1)), longPressTimeout2, i416, objArr91);
                        String str36 = (String) objArr91[0];
                        int i417 = -TextUtils.indexOf(str5, str5, 0);
                        int i418 = -TextUtils.getOffsetBefore(str5, 0);
                        int i419 = (i418 & 673) + (i418 | 673);
                        int i420 = -TextUtils.indexOf(str5, str5, 0);
                        Object[] objArr92 = new Object[1];
                        b((char) ((i417 & 17690) + (i417 | 17690)), i419, (i420 & 11) + (i420 | 11), objArr92);
                        String str37 = (String) objArr92[0];
                        int doubleTapTimeout3 = ViewConfiguration.getDoubleTapTimeout() >> 16;
                        int i421 = -(-(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                        int i422 = (i421 ^ 685) + ((i421 & 685) << 1);
                        int size = View.MeasureSpec.getSize(0);
                        Object[] objArr93 = new Object[1];
                        b((char) (((48412 | doubleTapTimeout3) << 1) - (doubleTapTimeout3 ^ 48412)), i422, (size ^ 14) + ((size & 14) << 1), objArr93);
                        String[] strArr9 = {str34, str35, str36, str37, (String) objArr93[0]};
                        char longPressTimeout3 = (char) (ViewConfiguration.getLongPressTimeout() >> 16);
                        int i423 = -(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                        Object[] objArr94 = new Object[1];
                        b(longPressTimeout3, (i423 & 699) + (i423 | 699), 16 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), objArr94);
                        String str38 = (String) objArr94[0];
                        Object[] objArr95 = new Object[1];
                        b((char) (43523 - (~(-TextUtils.getOffsetAfter(str5, 0)))), 713 - (~View.combineMeasuredStates(0, 0)), 2 - (~(-(ViewConfiguration.getEdgeSlop() >> 16))), objArr95);
                        String str39 = (String) objArr95[0];
                        char c28 = (char) (53365 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                        int i424 = -(-View.MeasureSpec.getMode(0));
                        int i425 = ((i424 | 725) << 1) - (i424 ^ 725);
                        int i426 = -TextUtils.getOffsetAfter(str5, 0);
                        int i427 = ((i426 | 22) << 1) - (i426 ^ 22);
                        Object[] objArr96 = new Object[1];
                        b(c28, i425, i427, objArr96);
                        String str40 = (String) objArr96[0];
                        char c29 = (char) (36731 - (~(-TextUtils.getOffsetBefore(str5, 0))));
                        int defaultSize3 = View.getDefaultSize(0, 0);
                        int i428 = ((defaultSize3 | 747) << 1) - (defaultSize3 ^ 747);
                        int i429 = -(KeyEvent.getMaxKeyCode() >> 16);
                        int i430 = ((i429 | 25) << 1) - (i429 ^ 25);
                        Object[] objArr97 = new Object[1];
                        b(c29, i428, i430, objArr97);
                        String str41 = (String) objArr97[0];
                        Object[] objArr98 = new Object[1];
                        b((char) (26671 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), 771 - (~(-(-(ViewConfiguration.getScrollDefaultDelay() >> 16)))), 27 - (~(-(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)))), objArr98);
                        i19 = i53;
                        str6 = str5;
                        i20 = -1;
                        String[] strArr10 = {str38, str39, str3, str40, str41, (String) objArr98[0]};
                        int i431 = -(ViewConfiguration.getWindowTouchSlop() >> 8);
                        Object[] objArr99 = new Object[1];
                        b((char) (((33683 | i431) << 1) - (i431 ^ 33683)), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + LogSeverity.EMERGENCY_VALUE, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 11, objArr99);
                        String str42 = (String) objArr99[0];
                        Object[] objArr100 = new Object[1];
                        b((char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), 811 - TextUtils.indexOf(str6, str6, 0, 0), 8 - (~(-(-TextUtils.indexOf((CharSequence) str6, '0')))), objArr100);
                        String str43 = (String) objArr100[0];
                        Object[] objArr101 = new Object[1];
                        b((char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1), 818 - (~(ViewConfiguration.getTouchSlop() >> 8)), 5 - (~(-(ViewConfiguration.getWindowTouchSlop() >> 8))), objArr101);
                        String str44 = (String) objArr101[0];
                        int i432 = -(ViewConfiguration.getTouchSlop() >> 8);
                        Object[] objArr102 = new Object[1];
                        b((char) ((59837 ^ i432) + ((i432 & 59837) << 1)), 825 - ExpandableListView.getPackedPositionType(0L), 6 - (ViewConfiguration.getPressedStateDuration() >> 16), objArr102);
                        String[] strArr11 = {str42, str43, str44, (String) objArr102[0]};
                        int i433 = -(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                        Object[] objArr103 = new Object[1];
                        b((char) ((i433 & 1) + (i433 | 1)), ExpandableListView.getPackedPositionType(0L) + 831, 15 - (~(-Gravity.getAbsoluteGravity(0, 0))), objArr103);
                        String str45 = (String) objArr103[0];
                        char pressedStateDuration3 = (char) (40972 - (ViewConfiguration.getPressedStateDuration() >> 16));
                        int i434 = -(-(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                        int i435 = (i434 & 665) + (i434 | 665);
                        int i436 = -TextUtils.indexOf(str6, str6, 0);
                        Object[] objArr104 = new Object[1];
                        b(pressedStateDuration3, i435, (i436 & 7) + (i436 | 7), objArr104);
                        String str46 = (String) objArr104[0];
                        Object[] objArr105 = new Object[1];
                        b((char) Gravity.getAbsoluteGravity(0, 0), 634 - (~((byte) KeyEvent.getModifierMetaStateMask())), 7 - (~(-(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))), objArr105);
                        String[] strArr12 = {str45, str46, (String) objArr105[0]};
                        char c30 = (char) (65387 - (~View.combineMeasuredStates(0, 0)));
                        int fadingEdgeLength5 = ViewConfiguration.getFadingEdgeLength() >> 16;
                        int i437 = (fadingEdgeLength5 ^ 847) + ((fadingEdgeLength5 & 847) << 1);
                        int i438 = -(-ExpandableListView.getPackedPositionType(0L));
                        int i439 = (i438 ^ 14) + ((i438 & 14) << 1);
                        Object[] objArr106 = new Object[1];
                        b(c30, i437, i439, objArr106);
                        String str47 = (String) objArr106[0];
                        Object[] objArr107 = new Object[1];
                        b((char) View.resolveSizeAndState(0, 0, 0), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 860, Color.rgb(0, 0, 0) + 16777217, objArr107);
                        String[] strArr13 = {str47, (String) objArr107[0]};
                        char cNormalizeMetaState2 = (char) (26589 - KeyEvent.normalizeMetaState(0));
                        int i440 = -(-ExpandableListView.getPackedPositionType(0L));
                        Object[] objArr108 = new Object[1];
                        b(cNormalizeMetaState2, (i440 ^ 862) + ((i440 & 862) << 1), 7 - (~(-ExpandableListView.getPackedPositionChild(0L))), objArr108);
                        String str48 = (String) objArr108[0];
                        int packedPositionGroup4 = ExpandableListView.getPackedPositionGroup(0L);
                        int i441 = (packedPositionGroup4 * (-589)) + 36584082;
                        int i442 = ~((-61903) | i326);
                        int i443 = ~((-61903) | packedPositionGroup4);
                        int i444 = (i442 & i443) | (i442 ^ i443);
                        int i445 = ~((i326 ^ packedPositionGroup4) | (i326 & packedPositionGroup4));
                        int i446 = (i444 & i445) | (i444 ^ i445);
                        int i447 = ~packedPositionGroup4;
                        int i448 = ~((i447 & 61902) | (61902 ^ i447) | i);
                        int i449 = ((i446 & i448) | (i446 ^ i448)) * 590;
                        int i450 = ((i441 | i449) << 1) - (i441 ^ i449);
                        int i451 = ~(((-61903) ^ i326) | ((-61903) & i326));
                        int i452 = ~((-61903) | packedPositionGroup4);
                        int i453 = (i450 - (~(-(-((((i451 & i452) | (i451 ^ i452)) | (~((i19 ^ packedPositionGroup4) | (i19 & packedPositionGroup4)))) * (-1180)))))) - 1;
                        int i454 = ~((~packedPositionGroup4) | i19);
                        int i455 = ~((61902 ^ i326) | (61902 & i326));
                        char c31 = (char) ((i453 - (~(-(-(((i454 & i455) | (i454 ^ i455)) * 590))))) - 1);
                        int i456 = -(ViewConfiguration.getDoubleTapTimeout() >> 16);
                        int i457 = (i456 ^ 871) + ((i456 & 871) << 1);
                        int scrollDefaultDelay4 = ViewConfiguration.getScrollDefaultDelay() >> 16;
                        int i458 = ((scrollDefaultDelay4 | 1) << 1) - (scrollDefaultDelay4 ^ 1);
                        Object[] objArr109 = new Object[1];
                        b(c31, i457, i458, objArr109);
                        String[] strArr14 = {str48, (String) objArr109[0]};
                        char c32 = (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)));
                        int packedPositionType2 = ExpandableListView.getPackedPositionType(0L);
                        int i_BOUNDARY2 = TimestampAction._BOUNDARY();
                        int i459 = packedPositionType2 * (-813);
                        int i460 = (355776 & i459) + (i459 | 355776);
                        int i461 = ~((-873) | packedPositionType2);
                        int i462 = ~((packedPositionType2 ^ i_BOUNDARY2) | (packedPositionType2 & i_BOUNDARY2));
                        int i463 = (i460 - (~(-(-(((i461 & i462) | (i461 ^ i462)) * (-814)))))) - 1;
                        int i464 = ~i_BOUNDARY2;
                        int i465 = ~(((-873) & i464) | ((-873) ^ i464));
                        int i466 = ~packedPositionType2;
                        int i467 = ~((i466 ^ 872) | (i466 & 872));
                        int i468 = (i467 & i465) | (i465 ^ i467);
                        int i469 = ((i468 & i462) | (i468 ^ i462)) * 407;
                        int i470 = (i463 & i469) + (i469 | i463);
                        int i471 = ~packedPositionType2;
                        int i472 = ~((i471 ^ 872) | (i471 & 872));
                        int i473 = ~((i471 & i_BOUNDARY2) | (i471 ^ i_BOUNDARY2));
                        Object[] objArr110 = new Object[1];
                        b(c32, (i470 - (~((((i473 & i472) | (i472 ^ i473)) | (~(i_BOUNDARY2 | 872))) * 407))) - 1, 15 - (~(-(-(PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))))), objArr110);
                        String str49 = (String) objArr110[0];
                        int i474 = -TextUtils.indexOf(str6, str6);
                        Object[] objArr111 = new Object[1];
                        b((char) (((43524 | i474) << 1) - (43524 ^ i474)), 713 - (~(-ExpandableListView.getPackedPositionType(0L))), 2 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), objArr111);
                        String str50 = (String) objArr111[0];
                        Object[] objArr112 = new Object[1];
                        b((char) ExpandableListView.getPackedPositionType(0L), 658 - (~(-(ViewConfiguration.getFadingEdgeLength() >> 16))), 7 - Gravity.getAbsoluteGravity(0, 0), objArr112);
                        String str51 = (String) objArr112[0];
                        int i475 = -(ViewConfiguration.getDoubleTapTimeout() >> 16);
                        int i476 = 887 - (~(-(-ExpandableListView.getPackedPositionGroup(0L))));
                        int i477 = -(-ExpandableListView.getPackedPositionGroup(0L));
                        int i478 = ((i477 | 8) << 1) - (i477 ^ 8);
                        Object[] objArr113 = new Object[1];
                        b((char) (((64812 | i475) << 1) - (i475 ^ 64812)), i476, i478, objArr113);
                        String str52 = (String) objArr113[0];
                        char cLastIndexOf = (char) (17689 - TextUtils.lastIndexOf(str6, '0', 0));
                        int iRgb = (-16776543) - Color.rgb(0, 0, 0);
                        int keyRepeatDelay = ViewConfiguration.getKeyRepeatDelay() >> 16;
                        int i479 = ((keyRepeatDelay | 11) << 1) - (keyRepeatDelay ^ 11);
                        Object[] objArr114 = new Object[1];
                        b(cLastIndexOf, iRgb, i479, objArr114);
                        String str53 = (String) objArr114[0];
                        int i480 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                        int i481 = 682 - (~(-ExpandableListView.getPackedPositionChild(0L)));
                        int edgeSlop = ViewConfiguration.getEdgeSlop() >> 16;
                        Object[] objArr115 = new Object[1];
                        b((char) ((48411 ^ i480) + ((i480 & 48411) << 1)), i481, (edgeSlop & 14) + (edgeSlop | 14), objArr115);
                        String[] strArr15 = {str49, str50, str51, str52, str53, (String) objArr115[0]};
                        char packedPositionGroup5 = (char) ExpandableListView.getPackedPositionGroup(0L);
                        int i482 = -(ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                        int i_BOUNDARY3 = TimestampAction._BOUNDARY();
                        int i483 = ~i482;
                        int i484 = ((i482 * (-496)) - 444416) + ((~((i483 ^ (-897)) | (i483 & (-897)))) * 497);
                        int i485 = i483 | (-897);
                        int i486 = ~((i485 & i_BOUNDARY3) | (i485 ^ i_BOUNDARY3));
                        int i487 = ~i_BOUNDARY3;
                        int i488 = ~(((-897) ^ i487) | ((-897) & i487) | i482);
                        int i489 = i484 + (((i486 ^ i488) | (i488 & i486)) * 497);
                        int i490 = ~((i483 ^ i487) | (i483 & i487));
                        int i491 = ~((i483 & 896) | (i483 ^ 896));
                        int i492 = (i490 & i491) | (i490 ^ i491);
                        int i493 = ~((i482 & (-897)) | ((-897) ^ i482) | i_BOUNDARY3);
                        int i494 = ((i492 & i493) | (i492 ^ i493)) * 497;
                        Object[] objArr116 = new Object[1];
                        b(packedPositionGroup5, ((i489 | i494) << 1) - (i494 ^ i489), 19 - (~(-(-(ViewConfiguration.getMinimumFlingVelocity() >> 16)))), objArr116);
                        String str54 = (String) objArr116[0];
                        char bitsPerPixel = (char) (ImageFormat.getBitsPerPixel(0) + 1);
                        int offsetBefore3 = 916 - TextUtils.getOffsetBefore(str6, 0);
                        int i495 = -Color.blue(0);
                        int i496 = ((i495 | 19) << 1) - (i495 ^ 19);
                        Object[] objArr117 = new Object[1];
                        b(bitsPerPixel, offsetBefore3, i496, objArr117);
                        String str55 = (String) objArr117[0];
                        char cIndexOf5 = (char) ((-1) - TextUtils.indexOf((CharSequence) str6, '0'));
                        int i497 = -(ViewConfiguration.getMaximumFlingVelocity() >> 16);
                        Object[] objArr118 = new Object[1];
                        b(cIndexOf5, (i497 & 935) + (i497 | 935), 30 - (~(-TextUtils.indexOf(str6, str6))), objArr118);
                        String str56 = (String) objArr118[0];
                        char c33 = (char) (29215 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                        int i498 = 965 - (~View.MeasureSpec.getSize(0));
                        int i499 = -(ViewConfiguration.getDoubleTapTimeout() >> 16);
                        int i500 = (i499 ^ 26) + ((i499 & 26) << 1);
                        Object[] objArr119 = new Object[1];
                        b(c33, i498, i500, objArr119);
                        String str57 = (String) objArr119[0];
                        char scrollBarFadeDuration2 = (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                        int i501 = -(-(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                        Object[] objArr120 = new Object[1];
                        b(scrollBarFadeDuration2, (i501 ^ 991) + ((i501 & 991) << 1), (ViewConfiguration.getPressedStateDuration() >> 16) + 23, objArr120);
                        String str58 = (String) objArr120[0];
                        int i502 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                        int i503 = -(-(ViewConfiguration.getPressedStateDuration() >> 16));
                        Object[] objArr121 = new Object[1];
                        b((char) (((i502 | 4051) << 1) - (i502 ^ 4051)), ((i503 | PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW) << 1) - (i503 ^ PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW), 33 - TextUtils.getTrimmedLength(str6), objArr121);
                        String[] strArr16 = {str54, str55, str56, str57, str58, (String) objArr121[0], str3};
                        Object[] objArr122 = new Object[1];
                        b((char) (24798 - (~(-(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))))), (ViewConfiguration.getEdgeSlop() >> 16) + 1048, Color.green(0) + 13, objArr122);
                        String str59 = (String) objArr122[0];
                        char c34 = (char) (10715 - (~(-(-(Process.myPid() >> 22)))));
                        int modifierMetaStateMask = 626 - ((byte) KeyEvent.getModifierMetaStateMask());
                        int i504 = -(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                        int i505 = ((i504 | 8) << 1) - (i504 ^ 8);
                        Object[] objArr123 = new Object[1];
                        b(c34, modifierMetaStateMask, i505, objArr123);
                        String[] strArr17 = {str59, (String) objArr123[0]};
                        Object[] objArr124 = new Object[1];
                        b((char) ((-1) - TextUtils.lastIndexOf(str6, '0')), 1061 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 29 - (~(-(-Drawable.resolveOpacity(0, 0)))), objArr124);
                        String str60 = (String) objArr124[0];
                        char packedPositionGroup6 = (char) ExpandableListView.getPackedPositionGroup(0L);
                        int i506 = 1090 - (~(ViewConfiguration.getDoubleTapTimeout() >> 16));
                        int iResolveSize = View.resolveSize(0, 0);
                        int i507 = ((iResolveSize | 11) << 1) - (iResolveSize ^ 11);
                        Object[] objArr125 = new Object[1];
                        b(packedPositionGroup6, i506, i507, objArr125);
                        String[] strArr18 = {str60, (String) objArr125[0]};
                        Object[] objArr126 = new Object[1];
                        b((char) View.resolveSizeAndState(0, 0, 0), MotionEvent.axisFromString(str6) + 1103, 19 - Drawable.resolveOpacity(0, 0), objArr126);
                        String str61 = (String) objArr126[0];
                        Object[] objArr127 = new Object[1];
                        b((char) Color.red(0), 1121 - TextUtils.indexOf(str6, str6, 0), 4 - (~(-(ViewConfiguration.getMaximumFlingVelocity() >> 16))), objArr127);
                        String[] strArr19 = {str61, (String) objArr127[0]};
                        char c35 = (char) (60847 - (~(-(-Gravity.getAbsoluteGravity(0, 0)))));
                        int maximumFlingVelocity = 1126 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                        int i508 = -(-(ViewConfiguration.getDoubleTapTimeout() >> 16));
                        int i509 = ((i508 | 19) << 1) - (i508 ^ 19);
                        Object[] objArr128 = new Object[1];
                        b(c35, maximumFlingVelocity, i509, objArr128);
                        String[] strArr20 = {(String) objArr128[0]};
                        char packedPositionType3 = (char) ExpandableListView.getPackedPositionType(0L);
                        int i510 = -(ViewConfiguration.getTouchSlop() >> 8);
                        int i511 = ((i510 | 1145) << 1) - (i510 ^ 1145);
                        int i512 = -(-(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                        int i513 = (i512 ^ 17) + ((i512 & 17) << 1);
                        Object[] objArr129 = new Object[1];
                        b(packedPositionType3, i511, i513, objArr129);
                        String[] strArr21 = {(String) objArr129[0]};
                        char mode2 = (char) View.MeasureSpec.getMode(0);
                        int i514 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                        int i_BOUNDARY4 = TimestampAction._BOUNDARY();
                        int i515 = (i514 * (-751)) - 871911;
                        int i516 = ~((~i514) | (-1162));
                        int i517 = ~i514;
                        int i518 = (i516 | (~((i517 ^ i_BOUNDARY4) | (i517 & i_BOUNDARY4)))) * 1504;
                        int i519 = ((((i515 | i518) << 1) - (i515 ^ i518)) - (~((~(i_BOUNDARY4 | ((i517 ^ 1161) | (i517 & 1161)))) * (-1504)))) - 1;
                        int i520 = ((~((i514 & (-1162)) | ((-1162) ^ i514))) | (~(i517 | 1161))) * 752;
                        int i521 = (i519 & i520) + (i520 | i519);
                        int iLastIndexOf4 = TextUtils.lastIndexOf(str6, '0', 0, 0);
                        Object[] objArr130 = new Object[1];
                        b(mode2, i521, (iLastIndexOf4 & 20) + (iLastIndexOf4 | 20), objArr130);
                        String[] strArr22 = {(String) objArr130[0]};
                        char doubleTapTimeout4 = (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 30630);
                        int i522 = -(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                        int i523 = ((i522 | 1181) << 1) - (i522 ^ 1181);
                        int i524 = -TextUtils.lastIndexOf(str6, '0', 0, 0);
                        int i525 = (i524 * (-300)) + 5436;
                        int i526 = (~((i524 ^ 18) | (i524 & 18) | i)) * (-301);
                        int i527 = (i525 & i526) + (i525 | i526);
                        int i528 = ~(((-19) ^ i) | ((-19) & i));
                        int i529 = ~((i19 ^ i524) | (i19 & i524));
                        int i530 = ((i528 & i529) | (i528 ^ i529)) * (-301);
                        int i531 = ((i527 | i530) << 1) - (i530 ^ i527);
                        int i532 = ~i524;
                        int i533 = ~((i532 & i) | (i532 ^ i));
                        int i534 = ((i533 & (-19)) | ((-19) ^ i533)) * 301;
                        int i535 = (i531 ^ i534) + ((i534 & i531) << 1);
                        Object[] objArr131 = new Object[1];
                        b(doubleTapTimeout4, i523, i535, objArr131);
                        String[] strArr23 = {(String) objArr131[0]};
                        char c36 = (char) (45087 - (~(-(-TextUtils.indexOf((CharSequence) str6, '0', 0)))));
                        int i536 = 1198 - (~(-(-(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))));
                        int i537 = -(-KeyEvent.normalizeMetaState(0));
                        int i538 = ((i537 | 23) << 1) - (i537 ^ 23);
                        Object[] objArr132 = new Object[1];
                        b(c36, i536, i538, objArr132);
                        String[] strArr24 = {(String) objArr132[0]};
                        char c37 = (char) (43880 - (~TextUtils.lastIndexOf(str6, '0')));
                        int i539 = 1221 - (~(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)));
                        int i540 = -(ViewConfiguration.getEdgeSlop() >> 16);
                        Object[] objArr133 = new Object[1];
                        b(c37, i539, (i540 & 21) + (i540 | 21), objArr133);
                        String[] strArr25 = {(String) objArr133[0]};
                        char pressedStateDuration4 = (char) (ViewConfiguration.getPressedStateDuration() >> 16);
                        int i541 = -(-(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                        int i542 = (i541 ^ 1242) + ((i541 & 1242) << 1);
                        int i543 = -(ViewConfiguration.getMaximumFlingVelocity() >> 16);
                        int i544 = ((i543 | 24) << 1) - (i543 ^ 24);
                        Object[] objArr134 = new Object[1];
                        b(pressedStateDuration4, i542, i544, objArr134);
                        String str62 = (String) objArr134[0];
                        String str63 = str3;
                        String[] strArr26 = {str62, str63};
                        int i545 = -TextUtils.getTrimmedLength(str6);
                        int i546 = -(-Process.getGidForName(str6));
                        int i547 = ((i546 | 1268) << 1) - (i546 ^ 1268);
                        int i548 = -(-TextUtils.lastIndexOf(str6, '0', 0, 0));
                        int i549 = (i548 ^ 29) + ((i548 & 29) << 1);
                        Object[] objArr135 = new Object[1];
                        b((char) ((i545 ^ 26006) + ((i545 & 26006) << 1)), i547, i549, objArr135);
                        String[] strArr27 = {(String) objArr135[0], str63};
                        int i550 = -(-(ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                        int i551 = -TextUtils.indexOf((CharSequence) str6, '0');
                        int i552 = (i551 ^ 1294) + ((i551 & 1294) << 1);
                        int i553 = -View.resolveSize(0, 0);
                        int i554 = ((i553 | 27) << 1) - (i553 ^ 27);
                        Object[] objArr136 = new Object[1];
                        b((char) ((i550 ^ 18234) + ((i550 & 18234) << 1)), i552, i554, objArr136);
                        String[] strArr28 = {(String) objArr136[0], str63};
                        char c38 = (char) (0 - (~(-(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)))));
                        int i555 = -(-TextUtils.lastIndexOf(str6, '0'));
                        int i556 = (i555 ^ 1323) + ((i555 & 1323) << 1);
                        int i557 = -View.getDefaultSize(0, 0);
                        int i558 = (i557 & 31) + (i557 | 31);
                        Object[] objArr137 = new Object[1];
                        b(c38, i556, i558, objArr137);
                        String[] strArr29 = {(String) objArr137[0], str63};
                        int i559 = -(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                        int i560 = 1352 - (~(-Color.blue(0)));
                        int i561 = -(-(ViewConfiguration.getFadingEdgeLength() >> 16));
                        int i562 = (i561 ^ 27) + ((i561 & 27) << 1);
                        Object[] objArr138 = new Object[1];
                        b((char) (((45681 | i559) << 1) - (i559 ^ 45681)), i560, i562, objArr138);
                        String[] strArr30 = {(String) objArr138[0], str63};
                        int i563 = -TextUtils.indexOf(str6, str6, 0);
                        Object[] objArr139 = new Object[1];
                        b((char) ((60952 ^ i563) + ((i563 & 60952) << 1)), 1381 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), TextUtils.indexOf((CharSequence) str6, '0') + 33, objArr139);
                        c2 = 0;
                        strArr = new String[][]{strArr8, strArr9, strArr10, strArr11, strArr12, strArr13, strArr14, strArr15, strArr16, strArr17, strArr18, strArr19, strArr20, strArr21, strArr22, strArr23, strArr24, strArr25, strArr26, strArr27, strArr28, strArr29, strArr30, new String[]{(String) objArr139[0], str63}};
                        arrayList = new ArrayList();
                        i21 = i;
                        i22 = 0;
                        i23 = 0;
                        while (i22 < 24) {
                            String[] strArr31 = strArr[i22];
                            Object[] objArr140 = {strArr31[c2]};
                            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1483923676);
                            if (objAccessartificialFrame == null) {
                                int i564 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 23;
                                char cArgb = (char) Color.argb(0, 0, 0, 0);
                                int iLastIndexOf5 = TextUtils.lastIndexOf(str6, c) + 2442;
                                byte b20 = $$a[10];
                                byte b21 = b20;
                                Object[] objArr141 = new Object[1];
                                a(b21, (byte) (b21 | 48), b20, objArr141);
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i564, cArgb, iLastIndexOf5, 954751276, false, (String) objArr141[0], new Class[]{String.class});
                            }
                            str7 = (String) ((Method) objAccessartificialFrame).invoke(null, objArr140);
                            String[] strArr32 = (String[]) Arrays.copyOfRange(strArr31, 1, strArr31.length);
                            if (str7 == null && str7.length() != 0) {
                                if (strArr31.length == 1) {
                                    int i565 = ((i23 | 14) << 1) - (i23 ^ 14);
                                    int i566 = ((i565 | (-13)) << 1) - (i565 ^ (-13));
                                    int i567 = i22 + 10;
                                    i21 = ((~i567) & i) | (i567 & i326);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(str7);
                                    int i568 = -TextUtils.indexOf(str6, str6);
                                    int iKeyCodeFromString2 = 1412 - KeyEvent.keyCodeFromString(str6);
                                    int i569 = -(Process.myPid() >> 22);
                                    int i570 = (i569 & 1) + (i569 | 1);
                                    Object[] objArr142 = new Object[1];
                                    b((char) ((i568 ^ 8592) + ((i568 & 8592) << 1)), iKeyCodeFromString2, i570, objArr142);
                                    sb.append((String) objArr142[0]);
                                    sb.append(str7);
                                    arrayList.add(sb.toString());
                                    i23 = i566;
                                    break;
                                    break;
                                }
                                int length = strArr32.length;
                                for (int i571 = 0; i571 < length; i571 = ((i571 | 1) << 1) - (i571 ^ 1)) {
                                    int i572 = artificialFrame + 93;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i572 % 128;
                                    if (i572 % 2 != 0) {
                                        str7.contains(strArr32[i571]);
                                        throw null;
                                    }
                                    if (str7.contains(strArr32[i571])) {
                                        int i5610 = ((i23 | 14) << 1) - (i23 ^ 14);
                                        int i5611 = ((i5610 | (-13)) << 1) - (i5610 ^ (-13));
                                        int i5612 = i22 + 10;
                                        i21 = ((~i5612) & i) | (i5612 & i326);
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append(str7);
                                        int i5613 = -TextUtils.indexOf(str6, str6);
                                        int iKeyCodeFromString3 = 1412 - KeyEvent.keyCodeFromString(str6);
                                        int i5614 = -(Process.myPid() >> 22);
                                        int i573 = (i5614 & 1) + (i5614 | 1);
                                        Object[] objArr143 = new Object[1];
                                        b((char) ((i5613 ^ 8592) + ((i5613 & 8592) << 1)), iKeyCodeFromString3, i573, objArr143);
                                        sb2.append((String) objArr143[0]);
                                        sb2.append(str7);
                                        arrayList.add(sb2.toString());
                                        i23 = i5611;
                                        break;
                                    }
                                }
                            }
                            i22 = (i22 ^ 1) + ((i22 & 1) << 1);
                            strArr = strArr;
                            c2 = 0;
                            c = '0';
                        }
                        if (i23 > 2) {
                            objArr = new Object[]{arrayList, new int[1], null, new int[]{i}, new int[]{i21}};
                            int i574 = (int) Runtime.getRuntime().totalMemory();
                            int i575 = -(-((((~((-25167554) | i574)) * 521) - 16844584) + (((~((~i574) | (-25167554))) | 437674024) * 521)));
                            int i576 = i575 << 13;
                            int i577 = (i575 | i576) & (~(i575 & i576));
                            int i578 = i577 >>> 17;
                            int i579 = (i577 | i578) & (~(i577 & i578));
                            int i580 = i579 << 5;
                            ((int[]) objArr[1])[0] = (i579 | i580) & (~(i579 & i580));
                            c3 = 0;
                            i24 = 1;
                        } else {
                            objArr = new Object[]{null, new int[1], null, new int[]{i}, new int[]{i}};
                            int i581 = artificialFrame + 81;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i581 % 128;
                            int i582 = i581 % 2;
                            int iMaxMemory3 = (int) Runtime.getRuntime().maxMemory();
                            int i583 = ~iMaxMemory3;
                            int i584 = (-1447101183) + (((~((-209708089) | i583)) | 1459200) * (-108)) + (((~(i583 | 815156546)) | (~((-815156547) | iMaxMemory3)) | (-1023405435)) * 54) + ((iMaxMemory3 | (-1023405435)) * 54);
                            int i585 = (i584 << 13) ^ i584;
                            int i586 = i585 ^ (i585 >>> 17);
                            int i587 = i586 << 5;
                            int i588 = ((~i586) & i587) | ((~i587) & i586);
                            i24 = 1;
                            c3 = 0;
                            ((int[]) objArr[1])[0] = i588;
                        }
                        i25 = ((int[]) objArr[4])[c3];
                        c4 = 5;
                        if (i25 != i) {
                            Object[] objArr144 = new Object[5];
                            objArr144[i24] = new int[i24];
                            int[] iArr4 = new int[i24];
                            objArr144[3] = iArr4;
                            int[] iArr5 = new int[i24];
                            objArr144[4] = iArr5;
                            List list = (List) objArr[c3];
                            iArr4[c3] = i;
                            iArr5[c3] = i25;
                            objArr144[c3] = list;
                            objArr144[2] = null;
                            int i589 = artificialFrame;
                            i26 = ((i589 | 119) << 1) - (i589 ^ 119);
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i26 % 128;
                            if (i26 % 2 != 0) {
                                int iMyUid2 = Process.myUid();
                                i27 = i3 >> ((((((~((-902570182) | iMyUid2)) | 293871745) * (-566)) - 566868417) + ((~(iMyUid2 | (-608698437))) * 566)) >>> 16);
                            } else {
                                int iNextInt4 = new Random().nextInt(1060830923);
                                i27 = (i3 - (~(-(-((((-26741855) + (((~((-475940821) | iNextInt4)) | 129507637) * (-366))) + (((~(iNextInt4 | (-407258817))) | 60825633) * 366)) + 16))))) - 1;
                            }
                            int i590 = i27 ^ (i27 << 13);
                            int i591 = i590 >>> 17;
                            int i592 = ((~i590) & i591) | ((~i591) & i590);
                            int i593 = i592 << 5;
                            ((int[]) objArr144[1])[0] = (i592 | i593) & (~(i592 & i593));
                            return objArr144;
                        }
                    } else {
                        str6 = str5;
                        i19 = i53;
                        c4 = 5;
                        i20 = -1;
                    }
                } else {
                    int offsetAfter5 = TextUtils.getOffsetAfter(str5, 0);
                    int iKeyCodeFromString4 = KeyEvent.keyCodeFromString(str5) + 372;
                    int i4010 = -Color.rgb(0, 0, 0);
                    int i4011 = ((-16777193) ^ i4010) + ((i4010 & (-16777193)) << 1);
                    Object[] objArr810 = new Object[1];
                    b((char) (((37786 | offsetAfter5) << 1) - (offsetAfter5 ^ 37786)), iKeyCodeFromString4, i4011, objArr810);
                    String str310 = (String) objArr810[0];
                    char windowTouchSlop3 = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                    int i4012 = -(-Color.green(0));
                    int i4013 = (i4012 ^ 617) + ((i4012 & 617) << 1);
                    int scrollDefaultDelay5 = ViewConfiguration.getScrollDefaultDelay() >> 16;
                    Object[] objArr811 = new Object[1];
                    b(windowTouchSlop3, i4013, ((scrollDefaultDelay5 | 10) << 1) - (scrollDefaultDelay5 ^ 10), objArr811);
                    String str311 = (String) objArr811[0];
                    int i4014 = -(-(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                    int i4015 = -(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                    int iIndexOf4 = TextUtils.indexOf((CharSequence) str5, '0', 0, 0);
                    Object[] objArr812 = new Object[1];
                    b((char) ((i4014 & 10715) + (i4014 | 10715)), (i4015 & 628) + (i4015 | 628), (iIndexOf4 & 8) + (iIndexOf4 | 8), objArr812);
                    String str312 = (String) objArr812[0];
                    int i4016 = -(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                    Object[] objArr813 = new Object[1];
                    b((char) ((i4016 & 1) + (i4016 | 1)), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 634, 8 - KeyEvent.keyCodeFromString(str5), objArr813);
                    String[] strArr33 = {str310, str311, str312, (String) objArr813[0]};
                    char cRgb3 = (char) (Color.rgb(0, 0, 0) + 16801575);
                    int i4017 = -(ViewConfiguration.getLongPressTimeout() >> 16);
                    int i4110 = ((i4017 | 642) << 1) - (i4017 ^ 642);
                    int trimmedLength3 = TextUtils.getTrimmedLength(str5);
                    int i4111 = (trimmedLength3 & 17) + (trimmedLength3 | 17);
                    Object[] objArr814 = new Object[1];
                    b(cRgb3, i4110, i4111, objArr814);
                    String str313 = (String) objArr814[0];
                    char c210 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                    int i4112 = -Drawable.resolveOpacity(0, 0);
                    int i4113 = (i4112 ^ 659) + ((i4112 & 659) << 1);
                    c = '0';
                    Object[] objArr910 = new Object[1];
                    b(c210, i4113, '7' - AndroidCharacter.getMirror('0'), objArr910);
                    String str314 = (String) objArr910[0];
                    int i4114 = -(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                    int longPressTimeout4 = 666 - (ViewConfiguration.getLongPressTimeout() >> 16);
                    int i4115 = -(ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    int i4116 = ((i4115 | 7) << 1) - (i4115 ^ 7);
                    Object[] objArr911 = new Object[1];
                    b((char) ((40972 ^ i4114) + ((i4114 & 40972) << 1)), longPressTimeout4, i4116, objArr911);
                    String str315 = (String) objArr911[0];
                    int i4117 = -TextUtils.indexOf(str5, str5, 0);
                    int i4118 = -TextUtils.getOffsetBefore(str5, 0);
                    int i4119 = (i4118 & 673) + (i4118 | 673);
                    int i4210 = -TextUtils.indexOf(str5, str5, 0);
                    Object[] objArr912 = new Object[1];
                    b((char) ((i4117 & 17690) + (i4117 | 17690)), i4119, (i4210 & 11) + (i4210 | 11), objArr912);
                    String str316 = (String) objArr912[0];
                    int doubleTapTimeout5 = ViewConfiguration.getDoubleTapTimeout() >> 16;
                    int i4211 = -(-(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                    int i4212 = (i4211 ^ 685) + ((i4211 & 685) << 1);
                    int size2 = View.MeasureSpec.getSize(0);
                    Object[] objArr913 = new Object[1];
                    b((char) (((48412 | doubleTapTimeout5) << 1) - (doubleTapTimeout5 ^ 48412)), i4212, (size2 ^ 14) + ((size2 & 14) << 1), objArr913);
                    String[] strArr34 = {str313, str314, str315, str316, (String) objArr913[0]};
                    char longPressTimeout5 = (char) (ViewConfiguration.getLongPressTimeout() >> 16);
                    int i4213 = -(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                    Object[] objArr914 = new Object[1];
                    b(longPressTimeout5, (i4213 & 699) + (i4213 | 699), 16 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), objArr914);
                    String str317 = (String) objArr914[0];
                    Object[] objArr915 = new Object[1];
                    b((char) (43523 - (~(-TextUtils.getOffsetAfter(str5, 0)))), 713 - (~View.combineMeasuredStates(0, 0)), 2 - (~(-(ViewConfiguration.getEdgeSlop() >> 16))), objArr915);
                    String str318 = (String) objArr915[0];
                    char c211 = (char) (53365 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                    int i4214 = -(-View.MeasureSpec.getMode(0));
                    int i4215 = ((i4214 | 725) << 1) - (i4214 ^ 725);
                    int i4216 = -TextUtils.getOffsetAfter(str5, 0);
                    int i4217 = ((i4216 | 22) << 1) - (i4216 ^ 22);
                    Object[] objArr916 = new Object[1];
                    b(c211, i4215, i4217, objArr916);
                    String str410 = (String) objArr916[0];
                    char c212 = (char) (36731 - (~(-TextUtils.getOffsetBefore(str5, 0))));
                    int defaultSize4 = View.getDefaultSize(0, 0);
                    int i4218 = ((defaultSize4 | 747) << 1) - (defaultSize4 ^ 747);
                    int i4219 = -(KeyEvent.getMaxKeyCode() >> 16);
                    int i4310 = ((i4219 | 25) << 1) - (i4219 ^ 25);
                    Object[] objArr917 = new Object[1];
                    b(c212, i4218, i4310, objArr917);
                    String str411 = (String) objArr917[0];
                    Object[] objArr918 = new Object[1];
                    b((char) (26671 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), 771 - (~(-(-(ViewConfiguration.getScrollDefaultDelay() >> 16)))), 27 - (~(-(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)))), objArr918);
                    i19 = i53;
                    str6 = str5;
                    i20 = -1;
                    String[] strArr110 = {str317, str318, str3, str410, str411, (String) objArr918[0]};
                    int i4311 = -(ViewConfiguration.getWindowTouchSlop() >> 8);
                    Object[] objArr919 = new Object[1];
                    b((char) (((33683 | i4311) << 1) - (i4311 ^ 33683)), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + LogSeverity.EMERGENCY_VALUE, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 11, objArr919);
                    String str412 = (String) objArr919[0];
                    Object[] objArr1010 = new Object[1];
                    b((char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), 811 - TextUtils.indexOf(str6, str6, 0, 0), 8 - (~(-(-TextUtils.indexOf((CharSequence) str6, '0')))), objArr1010);
                    String str413 = (String) objArr1010[0];
                    Object[] objArr1011 = new Object[1];
                    b((char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1), 818 - (~(ViewConfiguration.getTouchSlop() >> 8)), 5 - (~(-(ViewConfiguration.getWindowTouchSlop() >> 8))), objArr1011);
                    String str414 = (String) objArr1011[0];
                    int i4312 = -(ViewConfiguration.getTouchSlop() >> 8);
                    Object[] objArr1012 = new Object[1];
                    b((char) ((59837 ^ i4312) + ((i4312 & 59837) << 1)), 825 - ExpandableListView.getPackedPositionType(0L), 6 - (ViewConfiguration.getPressedStateDuration() >> 16), objArr1012);
                    String[] strArr111 = {str412, str413, str414, (String) objArr1012[0]};
                    int i4313 = -(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                    Object[] objArr1013 = new Object[1];
                    b((char) ((i4313 & 1) + (i4313 | 1)), ExpandableListView.getPackedPositionType(0L) + 831, 15 - (~(-Gravity.getAbsoluteGravity(0, 0))), objArr1013);
                    String str415 = (String) objArr1013[0];
                    char pressedStateDuration5 = (char) (40972 - (ViewConfiguration.getPressedStateDuration() >> 16));
                    int i4314 = -(-(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                    int i4315 = (i4314 & 665) + (i4314 | 665);
                    int i4316 = -TextUtils.indexOf(str6, str6, 0);
                    Object[] objArr1014 = new Object[1];
                    b(pressedStateDuration5, i4315, (i4316 & 7) + (i4316 | 7), objArr1014);
                    String str416 = (String) objArr1014[0];
                    Object[] objArr1015 = new Object[1];
                    b((char) Gravity.getAbsoluteGravity(0, 0), 634 - (~((byte) KeyEvent.getModifierMetaStateMask())), 7 - (~(-(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))), objArr1015);
                    String[] strArr112 = {str415, str416, (String) objArr1015[0]};
                    char c39 = (char) (65387 - (~View.combineMeasuredStates(0, 0)));
                    int fadingEdgeLength6 = ViewConfiguration.getFadingEdgeLength() >> 16;
                    int i4317 = (fadingEdgeLength6 ^ 847) + ((fadingEdgeLength6 & 847) << 1);
                    int i4318 = -(-ExpandableListView.getPackedPositionType(0L));
                    int i4319 = (i4318 ^ 14) + ((i4318 & 14) << 1);
                    Object[] objArr1016 = new Object[1];
                    b(c39, i4317, i4319, objArr1016);
                    String str417 = (String) objArr1016[0];
                    Object[] objArr1017 = new Object[1];
                    b((char) View.resolveSizeAndState(0, 0, 0), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 860, Color.rgb(0, 0, 0) + 16777217, objArr1017);
                    String[] strArr113 = {str417, (String) objArr1017[0]};
                    char cNormalizeMetaState3 = (char) (26589 - KeyEvent.normalizeMetaState(0));
                    int i4410 = -(-ExpandableListView.getPackedPositionType(0L));
                    Object[] objArr1018 = new Object[1];
                    b(cNormalizeMetaState3, (i4410 ^ 862) + ((i4410 & 862) << 1), 7 - (~(-ExpandableListView.getPackedPositionChild(0L))), objArr1018);
                    String str418 = (String) objArr1018[0];
                    int packedPositionGroup7 = ExpandableListView.getPackedPositionGroup(0L);
                    int i4411 = (packedPositionGroup7 * (-589)) + 36584082;
                    int i4412 = ~((-61903) | i326);
                    int i4413 = ~((-61903) | packedPositionGroup7);
                    int i4414 = (i4412 & i4413) | (i4412 ^ i4413);
                    int i4415 = ~((i326 ^ packedPositionGroup7) | (i326 & packedPositionGroup7));
                    int i4416 = (i4414 & i4415) | (i4414 ^ i4415);
                    int i4417 = ~packedPositionGroup7;
                    int i4418 = ~((i4417 & 61902) | (61902 ^ i4417) | i);
                    int i4419 = ((i4416 & i4418) | (i4416 ^ i4418)) * 590;
                    int i4510 = ((i4411 | i4419) << 1) - (i4411 ^ i4419);
                    int i4511 = ~(((-61903) ^ i326) | ((-61903) & i326));
                    int i4512 = ~((-61903) | packedPositionGroup7);
                    int i4513 = (i4510 - (~(-(-((((i4511 & i4512) | (i4511 ^ i4512)) | (~((i19 ^ packedPositionGroup7) | (i19 & packedPositionGroup7)))) * (-1180)))))) - 1;
                    int i4514 = ~((~packedPositionGroup7) | i19);
                    int i4515 = ~((61902 ^ i326) | (61902 & i326));
                    char c310 = (char) ((i4513 - (~(-(-(((i4514 & i4515) | (i4514 ^ i4515)) * 590))))) - 1);
                    int i4516 = -(ViewConfiguration.getDoubleTapTimeout() >> 16);
                    int i4517 = (i4516 ^ 871) + ((i4516 & 871) << 1);
                    int scrollDefaultDelay6 = ViewConfiguration.getScrollDefaultDelay() >> 16;
                    int i4518 = ((scrollDefaultDelay6 | 1) << 1) - (scrollDefaultDelay6 ^ 1);
                    Object[] objArr1019 = new Object[1];
                    b(c310, i4517, i4518, objArr1019);
                    String[] strArr114 = {str418, (String) objArr1019[0]};
                    char c311 = (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)));
                    int packedPositionType4 = ExpandableListView.getPackedPositionType(0L);
                    int i_BOUNDARY5 = TimestampAction._BOUNDARY();
                    int i4519 = packedPositionType4 * (-813);
                    int i4610 = (355776 & i4519) + (i4519 | 355776);
                    int i4611 = ~((-873) | packedPositionType4);
                    int i4612 = ~((packedPositionType4 ^ i_BOUNDARY5) | (packedPositionType4 & i_BOUNDARY5));
                    int i4613 = (i4610 - (~(-(-(((i4611 & i4612) | (i4611 ^ i4612)) * (-814)))))) - 1;
                    int i4614 = ~i_BOUNDARY5;
                    int i4615 = ~(((-873) & i4614) | ((-873) ^ i4614));
                    int i4616 = ~packedPositionType4;
                    int i4617 = ~((i4616 ^ 872) | (i4616 & 872));
                    int i4618 = (i4617 & i4615) | (i4615 ^ i4617);
                    int i4619 = ((i4618 & i4612) | (i4618 ^ i4612)) * 407;
                    int i4710 = (i4613 & i4619) + (i4619 | i4613);
                    int i4711 = ~packedPositionType4;
                    int i4712 = ~((i4711 ^ 872) | (i4711 & 872));
                    int i4713 = ~((i4711 & i_BOUNDARY5) | (i4711 ^ i_BOUNDARY5));
                    Object[] objArr1110 = new Object[1];
                    b(c311, (i4710 - (~((((i4713 & i4712) | (i4712 ^ i4713)) | (~(i_BOUNDARY5 | 872))) * 407))) - 1, 15 - (~(-(-(PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))))), objArr1110);
                    String str419 = (String) objArr1110[0];
                    int i4714 = -TextUtils.indexOf(str6, str6);
                    Object[] objArr1111 = new Object[1];
                    b((char) (((43524 | i4714) << 1) - (43524 ^ i4714)), 713 - (~(-ExpandableListView.getPackedPositionType(0L))), 2 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), objArr1111);
                    String str510 = (String) objArr1111[0];
                    Object[] objArr1112 = new Object[1];
                    b((char) ExpandableListView.getPackedPositionType(0L), 658 - (~(-(ViewConfiguration.getFadingEdgeLength() >> 16))), 7 - Gravity.getAbsoluteGravity(0, 0), objArr1112);
                    String str511 = (String) objArr1112[0];
                    int i4715 = -(ViewConfiguration.getDoubleTapTimeout() >> 16);
                    int i4716 = 887 - (~(-(-ExpandableListView.getPackedPositionGroup(0L))));
                    int i4717 = -(-ExpandableListView.getPackedPositionGroup(0L));
                    int i4718 = ((i4717 | 8) << 1) - (i4717 ^ 8);
                    Object[] objArr1113 = new Object[1];
                    b((char) (((64812 | i4715) << 1) - (i4715 ^ 64812)), i4716, i4718, objArr1113);
                    String str512 = (String) objArr1113[0];
                    char cLastIndexOf2 = (char) (17689 - TextUtils.lastIndexOf(str6, '0', 0));
                    int iRgb2 = (-16776543) - Color.rgb(0, 0, 0);
                    int keyRepeatDelay2 = ViewConfiguration.getKeyRepeatDelay() >> 16;
                    int i4719 = ((keyRepeatDelay2 | 11) << 1) - (keyRepeatDelay2 ^ 11);
                    Object[] objArr1114 = new Object[1];
                    b(cLastIndexOf2, iRgb2, i4719, objArr1114);
                    String str513 = (String) objArr1114[0];
                    int i4810 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                    int i4811 = 682 - (~(-ExpandableListView.getPackedPositionChild(0L)));
                    int edgeSlop2 = ViewConfiguration.getEdgeSlop() >> 16;
                    Object[] objArr1115 = new Object[1];
                    b((char) ((48411 ^ i4810) + ((i4810 & 48411) << 1)), i4811, (edgeSlop2 & 14) + (edgeSlop2 | 14), objArr1115);
                    String[] strArr115 = {str419, str510, str511, str512, str513, (String) objArr1115[0]};
                    char packedPositionGroup8 = (char) ExpandableListView.getPackedPositionGroup(0L);
                    int i4812 = -(ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                    int i_BOUNDARY6 = TimestampAction._BOUNDARY();
                    int i4813 = ~i4812;
                    int i4814 = ((i4812 * (-496)) - 444416) + ((~((i4813 ^ (-897)) | (i4813 & (-897)))) * 497);
                    int i4815 = i4813 | (-897);
                    int i4816 = ~((i4815 & i_BOUNDARY6) | (i4815 ^ i_BOUNDARY6));
                    int i4817 = ~i_BOUNDARY6;
                    int i4818 = ~(((-897) ^ i4817) | ((-897) & i4817) | i4812);
                    int i4819 = i4814 + (((i4816 ^ i4818) | (i4818 & i4816)) * 497);
                    int i4910 = ~((i4813 ^ i4817) | (i4813 & i4817));
                    int i4911 = ~((i4813 & 896) | (i4813 ^ 896));
                    int i4912 = (i4910 & i4911) | (i4910 ^ i4911);
                    int i4913 = ~((i4812 & (-897)) | ((-897) ^ i4812) | i_BOUNDARY6);
                    int i4914 = ((i4912 & i4913) | (i4912 ^ i4913)) * 497;
                    Object[] objArr1116 = new Object[1];
                    b(packedPositionGroup8, ((i4819 | i4914) << 1) - (i4914 ^ i4819), 19 - (~(-(-(ViewConfiguration.getMinimumFlingVelocity() >> 16)))), objArr1116);
                    String str514 = (String) objArr1116[0];
                    char bitsPerPixel2 = (char) (ImageFormat.getBitsPerPixel(0) + 1);
                    int offsetBefore4 = 916 - TextUtils.getOffsetBefore(str6, 0);
                    int i4915 = -Color.blue(0);
                    int i4916 = ((i4915 | 19) << 1) - (i4915 ^ 19);
                    Object[] objArr1117 = new Object[1];
                    b(bitsPerPixel2, offsetBefore4, i4916, objArr1117);
                    String str515 = (String) objArr1117[0];
                    char cIndexOf6 = (char) ((-1) - TextUtils.indexOf((CharSequence) str6, '0'));
                    int i4917 = -(ViewConfiguration.getMaximumFlingVelocity() >> 16);
                    Object[] objArr1118 = new Object[1];
                    b(cIndexOf6, (i4917 & 935) + (i4917 | 935), 30 - (~(-TextUtils.indexOf(str6, str6))), objArr1118);
                    String str516 = (String) objArr1118[0];
                    char c312 = (char) (29215 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                    int i4918 = 965 - (~View.MeasureSpec.getSize(0));
                    int i4919 = -(ViewConfiguration.getDoubleTapTimeout() >> 16);
                    int i5010 = (i4919 ^ 26) + ((i4919 & 26) << 1);
                    Object[] objArr1119 = new Object[1];
                    b(c312, i4918, i5010, objArr1119);
                    String str517 = (String) objArr1119[0];
                    char scrollBarFadeDuration3 = (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    int i5011 = -(-(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                    Object[] objArr1210 = new Object[1];
                    b(scrollBarFadeDuration3, (i5011 ^ 991) + ((i5011 & 991) << 1), (ViewConfiguration.getPressedStateDuration() >> 16) + 23, objArr1210);
                    String str518 = (String) objArr1210[0];
                    int i5012 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                    int i5013 = -(-(ViewConfiguration.getPressedStateDuration() >> 16));
                    Object[] objArr1211 = new Object[1];
                    b((char) (((i5012 | 4051) << 1) - (i5012 ^ 4051)), ((i5013 | PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW) << 1) - (i5013 ^ PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW), 33 - TextUtils.getTrimmedLength(str6), objArr1211);
                    String[] strArr116 = {str514, str515, str516, str517, str518, (String) objArr1211[0], str3};
                    Object[] objArr1212 = new Object[1];
                    b((char) (24798 - (~(-(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))))), (ViewConfiguration.getEdgeSlop() >> 16) + 1048, Color.green(0) + 13, objArr1212);
                    String str519 = (String) objArr1212[0];
                    char c313 = (char) (10715 - (~(-(-(Process.myPid() >> 22)))));
                    int modifierMetaStateMask2 = 626 - ((byte) KeyEvent.getModifierMetaStateMask());
                    int i5014 = -(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                    int i5015 = ((i5014 | 8) << 1) - (i5014 ^ 8);
                    Object[] objArr1213 = new Object[1];
                    b(c313, modifierMetaStateMask2, i5015, objArr1213);
                    String[] strArr117 = {str519, (String) objArr1213[0]};
                    Object[] objArr1214 = new Object[1];
                    b((char) ((-1) - TextUtils.lastIndexOf(str6, '0')), 1061 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 29 - (~(-(-Drawable.resolveOpacity(0, 0)))), objArr1214);
                    String str64 = (String) objArr1214[0];
                    char packedPositionGroup9 = (char) ExpandableListView.getPackedPositionGroup(0L);
                    int i5016 = 1090 - (~(ViewConfiguration.getDoubleTapTimeout() >> 16));
                    int iResolveSize2 = View.resolveSize(0, 0);
                    int i5017 = ((iResolveSize2 | 11) << 1) - (iResolveSize2 ^ 11);
                    Object[] objArr1215 = new Object[1];
                    b(packedPositionGroup9, i5016, i5017, objArr1215);
                    String[] strArr118 = {str64, (String) objArr1215[0]};
                    Object[] objArr1216 = new Object[1];
                    b((char) View.resolveSizeAndState(0, 0, 0), MotionEvent.axisFromString(str6) + 1103, 19 - Drawable.resolveOpacity(0, 0), objArr1216);
                    String str65 = (String) objArr1216[0];
                    Object[] objArr1217 = new Object[1];
                    b((char) Color.red(0), 1121 - TextUtils.indexOf(str6, str6, 0), 4 - (~(-(ViewConfiguration.getMaximumFlingVelocity() >> 16))), objArr1217);
                    String[] strArr119 = {str65, (String) objArr1217[0]};
                    char c314 = (char) (60847 - (~(-(-Gravity.getAbsoluteGravity(0, 0)))));
                    int maximumFlingVelocity2 = 1126 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                    int i5018 = -(-(ViewConfiguration.getDoubleTapTimeout() >> 16));
                    int i5019 = ((i5018 | 19) << 1) - (i5018 ^ 19);
                    Object[] objArr1218 = new Object[1];
                    b(c314, maximumFlingVelocity2, i5019, objArr1218);
                    String[] strArr210 = {(String) objArr1218[0]};
                    char packedPositionType5 = (char) ExpandableListView.getPackedPositionType(0L);
                    int i5110 = -(ViewConfiguration.getTouchSlop() >> 8);
                    int i5111 = ((i5110 | 1145) << 1) - (i5110 ^ 1145);
                    int i5112 = -(-(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                    int i5113 = (i5112 ^ 17) + ((i5112 & 17) << 1);
                    Object[] objArr1219 = new Object[1];
                    b(packedPositionType5, i5111, i5113, objArr1219);
                    String[] strArr211 = {(String) objArr1219[0]};
                    char mode3 = (char) View.MeasureSpec.getMode(0);
                    int i5114 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                    int i_BOUNDARY7 = TimestampAction._BOUNDARY();
                    int i5115 = (i5114 * (-751)) - 871911;
                    int i5116 = ~((~i5114) | (-1162));
                    int i5117 = ~i5114;
                    int i5118 = (i5116 | (~((i5117 ^ i_BOUNDARY7) | (i5117 & i_BOUNDARY7)))) * 1504;
                    int i5119 = ((((i5115 | i5118) << 1) - (i5115 ^ i5118)) - (~((~(i_BOUNDARY7 | ((i5117 ^ 1161) | (i5117 & 1161)))) * (-1504)))) - 1;
                    int i5210 = ((~((i5114 & (-1162)) | ((-1162) ^ i5114))) | (~(i5117 | 1161))) * 752;
                    int i5211 = (i5119 & i5210) + (i5210 | i5119);
                    int iLastIndexOf6 = TextUtils.lastIndexOf(str6, '0', 0, 0);
                    Object[] objArr1310 = new Object[1];
                    b(mode3, i5211, (iLastIndexOf6 & 20) + (iLastIndexOf6 | 20), objArr1310);
                    String[] strArr212 = {(String) objArr1310[0]};
                    char doubleTapTimeout6 = (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 30630);
                    int i5212 = -(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                    int i5213 = ((i5212 | 1181) << 1) - (i5212 ^ 1181);
                    int i5214 = -TextUtils.lastIndexOf(str6, '0', 0, 0);
                    int i5215 = (i5214 * (-300)) + 5436;
                    int i5216 = (~((i5214 ^ 18) | (i5214 & 18) | i)) * (-301);
                    int i5217 = (i5215 & i5216) + (i5215 | i5216);
                    int i5218 = ~(((-19) ^ i) | ((-19) & i));
                    int i5219 = ~((i19 ^ i5214) | (i19 & i5214));
                    int i5310 = ((i5218 & i5219) | (i5218 ^ i5219)) * (-301);
                    int i5311 = ((i5217 | i5310) << 1) - (i5310 ^ i5217);
                    int i5312 = ~i5214;
                    int i5313 = ~((i5312 & i) | (i5312 ^ i));
                    int i5314 = ((i5313 & (-19)) | ((-19) ^ i5313)) * 301;
                    int i5315 = (i5311 ^ i5314) + ((i5314 & i5311) << 1);
                    Object[] objArr1311 = new Object[1];
                    b(doubleTapTimeout6, i5213, i5315, objArr1311);
                    String[] strArr213 = {(String) objArr1311[0]};
                    char c315 = (char) (45087 - (~(-(-TextUtils.indexOf((CharSequence) str6, '0', 0)))));
                    int i5316 = 1198 - (~(-(-(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))));
                    int i5317 = -(-KeyEvent.normalizeMetaState(0));
                    int i5318 = ((i5317 | 23) << 1) - (i5317 ^ 23);
                    Object[] objArr1312 = new Object[1];
                    b(c315, i5316, i5318, objArr1312);
                    String[] strArr214 = {(String) objArr1312[0]};
                    char c316 = (char) (43880 - (~TextUtils.lastIndexOf(str6, '0')));
                    int i5319 = 1221 - (~(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)));
                    int i5410 = -(ViewConfiguration.getEdgeSlop() >> 16);
                    Object[] objArr1313 = new Object[1];
                    b(c316, i5319, (i5410 & 21) + (i5410 | 21), objArr1313);
                    String[] strArr215 = {(String) objArr1313[0]};
                    char pressedStateDuration6 = (char) (ViewConfiguration.getPressedStateDuration() >> 16);
                    int i5411 = -(-(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                    int i5412 = (i5411 ^ 1242) + ((i5411 & 1242) << 1);
                    int i5413 = -(ViewConfiguration.getMaximumFlingVelocity() >> 16);
                    int i5414 = ((i5413 | 24) << 1) - (i5413 ^ 24);
                    Object[] objArr1314 = new Object[1];
                    b(pressedStateDuration6, i5412, i5414, objArr1314);
                    String str66 = (String) objArr1314[0];
                    String str67 = str3;
                    String[] strArr216 = {str66, str67};
                    int i5415 = -TextUtils.getTrimmedLength(str6);
                    int i5416 = -(-Process.getGidForName(str6));
                    int i5417 = ((i5416 | 1268) << 1) - (i5416 ^ 1268);
                    int i5418 = -(-TextUtils.lastIndexOf(str6, '0', 0, 0));
                    int i5419 = (i5418 ^ 29) + ((i5418 & 29) << 1);
                    Object[] objArr1315 = new Object[1];
                    b((char) ((i5415 ^ 26006) + ((i5415 & 26006) << 1)), i5417, i5419, objArr1315);
                    String[] strArr217 = {(String) objArr1315[0], str67};
                    int i5510 = -(-(ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                    int i5511 = -TextUtils.indexOf((CharSequence) str6, '0');
                    int i5512 = (i5511 ^ 1294) + ((i5511 & 1294) << 1);
                    int i5513 = -View.resolveSize(0, 0);
                    int i5514 = ((i5513 | 27) << 1) - (i5513 ^ 27);
                    Object[] objArr1316 = new Object[1];
                    b((char) ((i5510 ^ 18234) + ((i5510 & 18234) << 1)), i5512, i5514, objArr1316);
                    String[] strArr218 = {(String) objArr1316[0], str67};
                    char c317 = (char) (0 - (~(-(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)))));
                    int i5515 = -(-TextUtils.lastIndexOf(str6, '0'));
                    int i5516 = (i5515 ^ 1323) + ((i5515 & 1323) << 1);
                    int i5517 = -View.getDefaultSize(0, 0);
                    int i5518 = (i5517 & 31) + (i5517 | 31);
                    Object[] objArr1317 = new Object[1];
                    b(c317, i5516, i5518, objArr1317);
                    String[] strArr219 = {(String) objArr1317[0], str67};
                    int i5519 = -(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                    int i5615 = 1352 - (~(-Color.blue(0)));
                    int i5616 = -(-(ViewConfiguration.getFadingEdgeLength() >> 16));
                    int i5617 = (i5616 ^ 27) + ((i5616 & 27) << 1);
                    Object[] objArr1318 = new Object[1];
                    b((char) (((45681 | i5519) << 1) - (i5519 ^ 45681)), i5615, i5617, objArr1318);
                    String[] strArr35 = {(String) objArr1318[0], str67};
                    int i5618 = -TextUtils.indexOf(str6, str6, 0);
                    Object[] objArr1319 = new Object[1];
                    b((char) ((60952 ^ i5618) + ((i5618 & 60952) << 1)), 1381 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), TextUtils.indexOf((CharSequence) str6, '0') + 33, objArr1319);
                    c2 = 0;
                    strArr = new String[][]{strArr33, strArr34, strArr110, strArr111, strArr112, strArr113, strArr114, strArr115, strArr116, strArr117, strArr118, strArr119, strArr210, strArr211, strArr212, strArr213, strArr214, strArr215, strArr216, strArr217, strArr218, strArr219, strArr35, new String[]{(String) objArr1319[0], str67}};
                    arrayList = new ArrayList();
                    i21 = i;
                    i22 = 0;
                    i23 = 0;
                    while (i22 < 24) {
                        String[] strArr36 = strArr[i22];
                        Object[] objArr145 = {strArr36[c2]};
                        objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1483923676);
                        if (objAccessartificialFrame == null) {
                            int i5619 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 23;
                            char cArgb2 = (char) Color.argb(0, 0, 0, 0);
                            int iLastIndexOf7 = TextUtils.lastIndexOf(str6, c) + 2442;
                            byte b22 = $$a[10];
                            byte b23 = b22;
                            Object[] objArr146 = new Object[1];
                            a(b23, (byte) (b23 | 48), b22, objArr146);
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i5619, cArgb2, iLastIndexOf7, 954751276, false, (String) objArr146[0], new Class[]{String.class});
                        }
                        str7 = (String) ((Method) objAccessartificialFrame).invoke(null, objArr145);
                        String[] strArr37 = (String[]) Arrays.copyOfRange(strArr36, 1, strArr36.length);
                        if (str7 == null) {
                        }
                        i22 = (i22 ^ 1) + ((i22 & 1) << 1);
                        strArr = strArr;
                        c2 = 0;
                        c = '0';
                    }
                    if (i23 > 2) {
                        objArr = new Object[]{arrayList, new int[1], null, new int[]{i}, new int[]{i21}};
                        int i5710 = (int) Runtime.getRuntime().totalMemory();
                        int i5711 = -(-((((~((-25167554) | i5710)) * 521) - 16844584) + (((~((~i5710) | (-25167554))) | 437674024) * 521)));
                        int i5712 = i5711 << 13;
                        int i5713 = (i5711 | i5712) & (~(i5711 & i5712));
                        int i5714 = i5713 >>> 17;
                        int i5715 = (i5713 | i5714) & (~(i5713 & i5714));
                        int i5810 = i5715 << 5;
                        ((int[]) objArr[1])[0] = (i5715 | i5810) & (~(i5715 & i5810));
                        c3 = 0;
                        i24 = 1;
                    } else {
                        objArr = new Object[]{null, new int[1], null, new int[]{i}, new int[]{i}};
                        int i5811 = artificialFrame + 81;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i5811 % 128;
                        int i5812 = i5811 % 2;
                        int iMaxMemory4 = (int) Runtime.getRuntime().maxMemory();
                        int i5813 = ~iMaxMemory4;
                        int i5814 = (-1447101183) + (((~((-209708089) | i5813)) | 1459200) * (-108)) + (((~(i5813 | 815156546)) | (~((-815156547) | iMaxMemory4)) | (-1023405435)) * 54) + ((iMaxMemory4 | (-1023405435)) * 54);
                        int i5815 = (i5814 << 13) ^ i5814;
                        int i5816 = i5815 ^ (i5815 >>> 17);
                        int i5817 = i5816 << 5;
                        int i5818 = ((~i5816) & i5817) | ((~i5817) & i5816);
                        i24 = 1;
                        c3 = 0;
                        ((int[]) objArr[1])[0] = i5818;
                    }
                    i25 = ((int[]) objArr[4])[c3];
                    c4 = 5;
                    if (i25 != i) {
                        Object[] objArr147 = new Object[5];
                        objArr147[i24] = new int[i24];
                        int[] iArr6 = new int[i24];
                        objArr147[3] = iArr6;
                        int[] iArr7 = new int[i24];
                        objArr147[4] = iArr7;
                        List list2 = (List) objArr[c3];
                        iArr6[c3] = i;
                        iArr7[c3] = i25;
                        objArr147[c3] = list2;
                        objArr147[2] = null;
                        int i5819 = artificialFrame;
                        i26 = ((i5819 | 119) << 1) - (i5819 ^ 119);
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i26 % 128;
                        if (i26 % 2 != 0) {
                            int iMyUid3 = Process.myUid();
                            i27 = i3 >> ((((((~((-902570182) | iMyUid3)) | 293871745) * (-566)) - 566868417) + ((~(iMyUid3 | (-608698437))) * 566)) >>> 16);
                        } else {
                            int iNextInt5 = new Random().nextInt(1060830923);
                            i27 = (i3 - (~(-(-((((-26741855) + (((~((-475940821) | iNextInt5)) | 129507637) * (-366))) + (((~(iNextInt5 | (-407258817))) | 60825633) * 366)) + 16))))) - 1;
                        }
                        int i594 = i27 ^ (i27 << 13);
                        int i595 = i594 >>> 17;
                        int i596 = ((~i594) & i595) | ((~i595) & i594);
                        int i597 = i596 << 5;
                        ((int[]) objArr147[1])[0] = (i596 | i597) & (~(i596 & i597));
                        return objArr147;
                    }
                }
            } else {
                int offsetAfter6 = TextUtils.getOffsetAfter(str5, 0);
                int iKeyCodeFromString5 = KeyEvent.keyCodeFromString(str5) + 372;
                int i4018 = -Color.rgb(0, 0, 0);
                int i4019 = ((-16777193) ^ i4018) + ((i4018 & (-16777193)) << 1);
                Object[] objArr815 = new Object[1];
                b((char) (((37786 | offsetAfter6) << 1) - (offsetAfter6 ^ 37786)), iKeyCodeFromString5, i4019, objArr815);
                String str319 = (String) objArr815[0];
                char windowTouchSlop4 = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                int i40110 = -(-Color.green(0));
                int i40111 = (i40110 ^ 617) + ((i40110 & 617) << 1);
                int scrollDefaultDelay7 = ViewConfiguration.getScrollDefaultDelay() >> 16;
                Object[] objArr816 = new Object[1];
                b(windowTouchSlop4, i40111, ((scrollDefaultDelay7 | 10) << 1) - (scrollDefaultDelay7 ^ 10), objArr816);
                String str3110 = (String) objArr816[0];
                int i40112 = -(-(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                int i40113 = -(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                int iIndexOf5 = TextUtils.indexOf((CharSequence) str5, '0', 0, 0);
                Object[] objArr817 = new Object[1];
                b((char) ((i40112 & 10715) + (i40112 | 10715)), (i40113 & 628) + (i40113 | 628), (iIndexOf5 & 8) + (iIndexOf5 | 8), objArr817);
                String str3111 = (String) objArr817[0];
                int i40114 = -(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                Object[] objArr818 = new Object[1];
                b((char) ((i40114 & 1) + (i40114 | 1)), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 634, 8 - KeyEvent.keyCodeFromString(str5), objArr818);
                String[] strArr38 = {str319, str3110, str3111, (String) objArr818[0]};
                char cRgb4 = (char) (Color.rgb(0, 0, 0) + 16801575);
                int i40115 = -(ViewConfiguration.getLongPressTimeout() >> 16);
                int i41110 = ((i40115 | 642) << 1) - (i40115 ^ 642);
                int trimmedLength4 = TextUtils.getTrimmedLength(str5);
                int i41111 = (trimmedLength4 & 17) + (trimmedLength4 | 17);
                Object[] objArr819 = new Object[1];
                b(cRgb4, i41110, i41111, objArr819);
                String str3112 = (String) objArr819[0];
                char c213 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                int i41112 = -Drawable.resolveOpacity(0, 0);
                int i41113 = (i41112 ^ 659) + ((i41112 & 659) << 1);
                c = '0';
                Object[] objArr9110 = new Object[1];
                b(c213, i41113, '7' - AndroidCharacter.getMirror('0'), objArr9110);
                String str3113 = (String) objArr9110[0];
                int i41114 = -(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                int longPressTimeout6 = 666 - (ViewConfiguration.getLongPressTimeout() >> 16);
                int i41115 = -(ViewConfiguration.getScrollBarFadeDuration() >> 16);
                int i41116 = ((i41115 | 7) << 1) - (i41115 ^ 7);
                Object[] objArr9111 = new Object[1];
                b((char) ((40972 ^ i41114) + ((i41114 & 40972) << 1)), longPressTimeout6, i41116, objArr9111);
                String str3114 = (String) objArr9111[0];
                int i41117 = -TextUtils.indexOf(str5, str5, 0);
                int i41118 = -TextUtils.getOffsetBefore(str5, 0);
                int i41119 = (i41118 & 673) + (i41118 | 673);
                int i42110 = -TextUtils.indexOf(str5, str5, 0);
                Object[] objArr9112 = new Object[1];
                b((char) ((i41117 & 17690) + (i41117 | 17690)), i41119, (i42110 & 11) + (i42110 | 11), objArr9112);
                String str3115 = (String) objArr9112[0];
                int doubleTapTimeout7 = ViewConfiguration.getDoubleTapTimeout() >> 16;
                int i42111 = -(-(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                int i42112 = (i42111 ^ 685) + ((i42111 & 685) << 1);
                int size3 = View.MeasureSpec.getSize(0);
                Object[] objArr9113 = new Object[1];
                b((char) (((48412 | doubleTapTimeout7) << 1) - (doubleTapTimeout7 ^ 48412)), i42112, (size3 ^ 14) + ((size3 & 14) << 1), objArr9113);
                String[] strArr39 = {str3112, str3113, str3114, str3115, (String) objArr9113[0]};
                char longPressTimeout7 = (char) (ViewConfiguration.getLongPressTimeout() >> 16);
                int i42113 = -(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                Object[] objArr9114 = new Object[1];
                b(longPressTimeout7, (i42113 & 699) + (i42113 | 699), 16 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), objArr9114);
                String str3116 = (String) objArr9114[0];
                Object[] objArr9115 = new Object[1];
                b((char) (43523 - (~(-TextUtils.getOffsetAfter(str5, 0)))), 713 - (~View.combineMeasuredStates(0, 0)), 2 - (~(-(ViewConfiguration.getEdgeSlop() >> 16))), objArr9115);
                String str3117 = (String) objArr9115[0];
                char c214 = (char) (53365 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                int i42114 = -(-View.MeasureSpec.getMode(0));
                int i42115 = ((i42114 | 725) << 1) - (i42114 ^ 725);
                int i42116 = -TextUtils.getOffsetAfter(str5, 0);
                int i42117 = ((i42116 | 22) << 1) - (i42116 ^ 22);
                Object[] objArr9116 = new Object[1];
                b(c214, i42115, i42117, objArr9116);
                String str4110 = (String) objArr9116[0];
                char c215 = (char) (36731 - (~(-TextUtils.getOffsetBefore(str5, 0))));
                int defaultSize5 = View.getDefaultSize(0, 0);
                int i42118 = ((defaultSize5 | 747) << 1) - (defaultSize5 ^ 747);
                int i42119 = -(KeyEvent.getMaxKeyCode() >> 16);
                int i43110 = ((i42119 | 25) << 1) - (i42119 ^ 25);
                Object[] objArr9117 = new Object[1];
                b(c215, i42118, i43110, objArr9117);
                String str4111 = (String) objArr9117[0];
                Object[] objArr9118 = new Object[1];
                b((char) (26671 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), 771 - (~(-(-(ViewConfiguration.getScrollDefaultDelay() >> 16)))), 27 - (~(-(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)))), objArr9118);
                i19 = i53;
                str6 = str5;
                i20 = -1;
                String[] strArr1110 = {str3116, str3117, str3, str4110, str4111, (String) objArr9118[0]};
                int i43111 = -(ViewConfiguration.getWindowTouchSlop() >> 8);
                Object[] objArr9119 = new Object[1];
                b((char) (((33683 | i43111) << 1) - (i43111 ^ 33683)), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + LogSeverity.EMERGENCY_VALUE, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 11, objArr9119);
                String str4112 = (String) objArr9119[0];
                Object[] objArr10110 = new Object[1];
                b((char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), 811 - TextUtils.indexOf(str6, str6, 0, 0), 8 - (~(-(-TextUtils.indexOf((CharSequence) str6, '0')))), objArr10110);
                String str4113 = (String) objArr10110[0];
                Object[] objArr10111 = new Object[1];
                b((char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1), 818 - (~(ViewConfiguration.getTouchSlop() >> 8)), 5 - (~(-(ViewConfiguration.getWindowTouchSlop() >> 8))), objArr10111);
                String str4114 = (String) objArr10111[0];
                int i43112 = -(ViewConfiguration.getTouchSlop() >> 8);
                Object[] objArr10112 = new Object[1];
                b((char) ((59837 ^ i43112) + ((i43112 & 59837) << 1)), 825 - ExpandableListView.getPackedPositionType(0L), 6 - (ViewConfiguration.getPressedStateDuration() >> 16), objArr10112);
                String[] strArr1111 = {str4112, str4113, str4114, (String) objArr10112[0]};
                int i43113 = -(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                Object[] objArr10113 = new Object[1];
                b((char) ((i43113 & 1) + (i43113 | 1)), ExpandableListView.getPackedPositionType(0L) + 831, 15 - (~(-Gravity.getAbsoluteGravity(0, 0))), objArr10113);
                String str4115 = (String) objArr10113[0];
                char pressedStateDuration7 = (char) (40972 - (ViewConfiguration.getPressedStateDuration() >> 16));
                int i43114 = -(-(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                int i43115 = (i43114 & 665) + (i43114 | 665);
                int i43116 = -TextUtils.indexOf(str6, str6, 0);
                Object[] objArr10114 = new Object[1];
                b(pressedStateDuration7, i43115, (i43116 & 7) + (i43116 | 7), objArr10114);
                String str4116 = (String) objArr10114[0];
                Object[] objArr10115 = new Object[1];
                b((char) Gravity.getAbsoluteGravity(0, 0), 634 - (~((byte) KeyEvent.getModifierMetaStateMask())), 7 - (~(-(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))), objArr10115);
                String[] strArr1112 = {str4115, str4116, (String) objArr10115[0]};
                char c318 = (char) (65387 - (~View.combineMeasuredStates(0, 0)));
                int fadingEdgeLength7 = ViewConfiguration.getFadingEdgeLength() >> 16;
                int i43117 = (fadingEdgeLength7 ^ 847) + ((fadingEdgeLength7 & 847) << 1);
                int i43118 = -(-ExpandableListView.getPackedPositionType(0L));
                int i43119 = (i43118 ^ 14) + ((i43118 & 14) << 1);
                Object[] objArr10116 = new Object[1];
                b(c318, i43117, i43119, objArr10116);
                String str4117 = (String) objArr10116[0];
                Object[] objArr10117 = new Object[1];
                b((char) View.resolveSizeAndState(0, 0, 0), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 860, Color.rgb(0, 0, 0) + 16777217, objArr10117);
                String[] strArr1113 = {str4117, (String) objArr10117[0]};
                char cNormalizeMetaState4 = (char) (26589 - KeyEvent.normalizeMetaState(0));
                int i44110 = -(-ExpandableListView.getPackedPositionType(0L));
                Object[] objArr10118 = new Object[1];
                b(cNormalizeMetaState4, (i44110 ^ 862) + ((i44110 & 862) << 1), 7 - (~(-ExpandableListView.getPackedPositionChild(0L))), objArr10118);
                String str4118 = (String) objArr10118[0];
                int packedPositionGroup10 = ExpandableListView.getPackedPositionGroup(0L);
                int i44111 = (packedPositionGroup10 * (-589)) + 36584082;
                int i44112 = ~((-61903) | i326);
                int i44113 = ~((-61903) | packedPositionGroup10);
                int i44114 = (i44112 & i44113) | (i44112 ^ i44113);
                int i44115 = ~((i326 ^ packedPositionGroup10) | (i326 & packedPositionGroup10));
                int i44116 = (i44114 & i44115) | (i44114 ^ i44115);
                int i44117 = ~packedPositionGroup10;
                int i44118 = ~((i44117 & 61902) | (61902 ^ i44117) | i);
                int i44119 = ((i44116 & i44118) | (i44116 ^ i44118)) * 590;
                int i45110 = ((i44111 | i44119) << 1) - (i44111 ^ i44119);
                int i45111 = ~(((-61903) ^ i326) | ((-61903) & i326));
                int i45112 = ~((-61903) | packedPositionGroup10);
                int i45113 = (i45110 - (~(-(-((((i45111 & i45112) | (i45111 ^ i45112)) | (~((i19 ^ packedPositionGroup10) | (i19 & packedPositionGroup10)))) * (-1180)))))) - 1;
                int i45114 = ~((~packedPositionGroup10) | i19);
                int i45115 = ~((61902 ^ i326) | (61902 & i326));
                char c319 = (char) ((i45113 - (~(-(-(((i45114 & i45115) | (i45114 ^ i45115)) * 590))))) - 1);
                int i45116 = -(ViewConfiguration.getDoubleTapTimeout() >> 16);
                int i45117 = (i45116 ^ 871) + ((i45116 & 871) << 1);
                int scrollDefaultDelay8 = ViewConfiguration.getScrollDefaultDelay() >> 16;
                int i45118 = ((scrollDefaultDelay8 | 1) << 1) - (scrollDefaultDelay8 ^ 1);
                Object[] objArr10119 = new Object[1];
                b(c319, i45117, i45118, objArr10119);
                String[] strArr1114 = {str4118, (String) objArr10119[0]};
                char c3110 = (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)));
                int packedPositionType6 = ExpandableListView.getPackedPositionType(0L);
                int i_BOUNDARY8 = TimestampAction._BOUNDARY();
                int i45119 = packedPositionType6 * (-813);
                int i46110 = (355776 & i45119) + (i45119 | 355776);
                int i46111 = ~((-873) | packedPositionType6);
                int i46112 = ~((packedPositionType6 ^ i_BOUNDARY8) | (packedPositionType6 & i_BOUNDARY8));
                int i46113 = (i46110 - (~(-(-(((i46111 & i46112) | (i46111 ^ i46112)) * (-814)))))) - 1;
                int i46114 = ~i_BOUNDARY8;
                int i46115 = ~(((-873) & i46114) | ((-873) ^ i46114));
                int i46116 = ~packedPositionType6;
                int i46117 = ~((i46116 ^ 872) | (i46116 & 872));
                int i46118 = (i46117 & i46115) | (i46115 ^ i46117);
                int i46119 = ((i46118 & i46112) | (i46118 ^ i46112)) * 407;
                int i47110 = (i46113 & i46119) + (i46119 | i46113);
                int i47111 = ~packedPositionType6;
                int i47112 = ~((i47111 ^ 872) | (i47111 & 872));
                int i47113 = ~((i47111 & i_BOUNDARY8) | (i47111 ^ i_BOUNDARY8));
                Object[] objArr11110 = new Object[1];
                b(c3110, (i47110 - (~((((i47113 & i47112) | (i47112 ^ i47113)) | (~(i_BOUNDARY8 | 872))) * 407))) - 1, 15 - (~(-(-(PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))))), objArr11110);
                String str4119 = (String) objArr11110[0];
                int i47114 = -TextUtils.indexOf(str6, str6);
                Object[] objArr11111 = new Object[1];
                b((char) (((43524 | i47114) << 1) - (43524 ^ i47114)), 713 - (~(-ExpandableListView.getPackedPositionType(0L))), 2 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), objArr11111);
                String str5110 = (String) objArr11111[0];
                Object[] objArr11112 = new Object[1];
                b((char) ExpandableListView.getPackedPositionType(0L), 658 - (~(-(ViewConfiguration.getFadingEdgeLength() >> 16))), 7 - Gravity.getAbsoluteGravity(0, 0), objArr11112);
                String str5111 = (String) objArr11112[0];
                int i47115 = -(ViewConfiguration.getDoubleTapTimeout() >> 16);
                int i47116 = 887 - (~(-(-ExpandableListView.getPackedPositionGroup(0L))));
                int i47117 = -(-ExpandableListView.getPackedPositionGroup(0L));
                int i47118 = ((i47117 | 8) << 1) - (i47117 ^ 8);
                Object[] objArr11113 = new Object[1];
                b((char) (((64812 | i47115) << 1) - (i47115 ^ 64812)), i47116, i47118, objArr11113);
                String str5112 = (String) objArr11113[0];
                char cLastIndexOf3 = (char) (17689 - TextUtils.lastIndexOf(str6, '0', 0));
                int iRgb3 = (-16776543) - Color.rgb(0, 0, 0);
                int keyRepeatDelay3 = ViewConfiguration.getKeyRepeatDelay() >> 16;
                int i47119 = ((keyRepeatDelay3 | 11) << 1) - (keyRepeatDelay3 ^ 11);
                Object[] objArr11114 = new Object[1];
                b(cLastIndexOf3, iRgb3, i47119, objArr11114);
                String str5113 = (String) objArr11114[0];
                int i48110 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                int i48111 = 682 - (~(-ExpandableListView.getPackedPositionChild(0L)));
                int edgeSlop3 = ViewConfiguration.getEdgeSlop() >> 16;
                Object[] objArr11115 = new Object[1];
                b((char) ((48411 ^ i48110) + ((i48110 & 48411) << 1)), i48111, (edgeSlop3 & 14) + (edgeSlop3 | 14), objArr11115);
                String[] strArr1115 = {str4119, str5110, str5111, str5112, str5113, (String) objArr11115[0]};
                char packedPositionGroup11 = (char) ExpandableListView.getPackedPositionGroup(0L);
                int i48112 = -(ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                int i_BOUNDARY9 = TimestampAction._BOUNDARY();
                int i48113 = ~i48112;
                int i48114 = ((i48112 * (-496)) - 444416) + ((~((i48113 ^ (-897)) | (i48113 & (-897)))) * 497);
                int i48115 = i48113 | (-897);
                int i48116 = ~((i48115 & i_BOUNDARY9) | (i48115 ^ i_BOUNDARY9));
                int i48117 = ~i_BOUNDARY9;
                int i48118 = ~(((-897) ^ i48117) | ((-897) & i48117) | i48112);
                int i48119 = i48114 + (((i48116 ^ i48118) | (i48118 & i48116)) * 497);
                int i49110 = ~((i48113 ^ i48117) | (i48113 & i48117));
                int i49111 = ~((i48113 & 896) | (i48113 ^ 896));
                int i49112 = (i49110 & i49111) | (i49110 ^ i49111);
                int i49113 = ~((i48112 & (-897)) | ((-897) ^ i48112) | i_BOUNDARY9);
                int i49114 = ((i49112 & i49113) | (i49112 ^ i49113)) * 497;
                Object[] objArr11116 = new Object[1];
                b(packedPositionGroup11, ((i48119 | i49114) << 1) - (i49114 ^ i48119), 19 - (~(-(-(ViewConfiguration.getMinimumFlingVelocity() >> 16)))), objArr11116);
                String str5114 = (String) objArr11116[0];
                char bitsPerPixel3 = (char) (ImageFormat.getBitsPerPixel(0) + 1);
                int offsetBefore5 = 916 - TextUtils.getOffsetBefore(str6, 0);
                int i49115 = -Color.blue(0);
                int i49116 = ((i49115 | 19) << 1) - (i49115 ^ 19);
                Object[] objArr11117 = new Object[1];
                b(bitsPerPixel3, offsetBefore5, i49116, objArr11117);
                String str5115 = (String) objArr11117[0];
                char cIndexOf7 = (char) ((-1) - TextUtils.indexOf((CharSequence) str6, '0'));
                int i49117 = -(ViewConfiguration.getMaximumFlingVelocity() >> 16);
                Object[] objArr11118 = new Object[1];
                b(cIndexOf7, (i49117 & 935) + (i49117 | 935), 30 - (~(-TextUtils.indexOf(str6, str6))), objArr11118);
                String str5116 = (String) objArr11118[0];
                char c3111 = (char) (29215 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                int i49118 = 965 - (~View.MeasureSpec.getSize(0));
                int i49119 = -(ViewConfiguration.getDoubleTapTimeout() >> 16);
                int i50110 = (i49119 ^ 26) + ((i49119 & 26) << 1);
                Object[] objArr11119 = new Object[1];
                b(c3111, i49118, i50110, objArr11119);
                String str5117 = (String) objArr11119[0];
                char scrollBarFadeDuration4 = (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                int i50111 = -(-(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                Object[] objArr12110 = new Object[1];
                b(scrollBarFadeDuration4, (i50111 ^ 991) + ((i50111 & 991) << 1), (ViewConfiguration.getPressedStateDuration() >> 16) + 23, objArr12110);
                String str5118 = (String) objArr12110[0];
                int i50112 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                int i50113 = -(-(ViewConfiguration.getPressedStateDuration() >> 16));
                Object[] objArr12111 = new Object[1];
                b((char) (((i50112 | 4051) << 1) - (i50112 ^ 4051)), ((i50113 | PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW) << 1) - (i50113 ^ PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW), 33 - TextUtils.getTrimmedLength(str6), objArr12111);
                String[] strArr1116 = {str5114, str5115, str5116, str5117, str5118, (String) objArr12111[0], str3};
                Object[] objArr12112 = new Object[1];
                b((char) (24798 - (~(-(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))))), (ViewConfiguration.getEdgeSlop() >> 16) + 1048, Color.green(0) + 13, objArr12112);
                String str5119 = (String) objArr12112[0];
                char c3112 = (char) (10715 - (~(-(-(Process.myPid() >> 22)))));
                int modifierMetaStateMask3 = 626 - ((byte) KeyEvent.getModifierMetaStateMask());
                int i50114 = -(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                int i50115 = ((i50114 | 8) << 1) - (i50114 ^ 8);
                Object[] objArr12113 = new Object[1];
                b(c3112, modifierMetaStateMask3, i50115, objArr12113);
                String[] strArr1117 = {str5119, (String) objArr12113[0]};
                Object[] objArr12114 = new Object[1];
                b((char) ((-1) - TextUtils.lastIndexOf(str6, '0')), 1061 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 29 - (~(-(-Drawable.resolveOpacity(0, 0)))), objArr12114);
                String str68 = (String) objArr12114[0];
                char packedPositionGroup12 = (char) ExpandableListView.getPackedPositionGroup(0L);
                int i50116 = 1090 - (~(ViewConfiguration.getDoubleTapTimeout() >> 16));
                int iResolveSize3 = View.resolveSize(0, 0);
                int i50117 = ((iResolveSize3 | 11) << 1) - (iResolveSize3 ^ 11);
                Object[] objArr12115 = new Object[1];
                b(packedPositionGroup12, i50116, i50117, objArr12115);
                String[] strArr1118 = {str68, (String) objArr12115[0]};
                Object[] objArr12116 = new Object[1];
                b((char) View.resolveSizeAndState(0, 0, 0), MotionEvent.axisFromString(str6) + 1103, 19 - Drawable.resolveOpacity(0, 0), objArr12116);
                String str69 = (String) objArr12116[0];
                Object[] objArr12117 = new Object[1];
                b((char) Color.red(0), 1121 - TextUtils.indexOf(str6, str6, 0), 4 - (~(-(ViewConfiguration.getMaximumFlingVelocity() >> 16))), objArr12117);
                String[] strArr1119 = {str69, (String) objArr12117[0]};
                char c3113 = (char) (60847 - (~(-(-Gravity.getAbsoluteGravity(0, 0)))));
                int maximumFlingVelocity3 = 1126 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                int i50118 = -(-(ViewConfiguration.getDoubleTapTimeout() >> 16));
                int i50119 = ((i50118 | 19) << 1) - (i50118 ^ 19);
                Object[] objArr12118 = new Object[1];
                b(c3113, maximumFlingVelocity3, i50119, objArr12118);
                String[] strArr2110 = {(String) objArr12118[0]};
                char packedPositionType7 = (char) ExpandableListView.getPackedPositionType(0L);
                int i51110 = -(ViewConfiguration.getTouchSlop() >> 8);
                int i51111 = ((i51110 | 1145) << 1) - (i51110 ^ 1145);
                int i51112 = -(-(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                int i51113 = (i51112 ^ 17) + ((i51112 & 17) << 1);
                Object[] objArr12119 = new Object[1];
                b(packedPositionType7, i51111, i51113, objArr12119);
                String[] strArr2111 = {(String) objArr12119[0]};
                char mode4 = (char) View.MeasureSpec.getMode(0);
                int i51114 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                int i_BOUNDARY10 = TimestampAction._BOUNDARY();
                int i51115 = (i51114 * (-751)) - 871911;
                int i51116 = ~((~i51114) | (-1162));
                int i51117 = ~i51114;
                int i51118 = (i51116 | (~((i51117 ^ i_BOUNDARY10) | (i51117 & i_BOUNDARY10)))) * 1504;
                int i51119 = ((((i51115 | i51118) << 1) - (i51115 ^ i51118)) - (~((~(i_BOUNDARY10 | ((i51117 ^ 1161) | (i51117 & 1161)))) * (-1504)))) - 1;
                int i52110 = ((~((i51114 & (-1162)) | ((-1162) ^ i51114))) | (~(i51117 | 1161))) * 752;
                int i52111 = (i51119 & i52110) + (i52110 | i51119);
                int iLastIndexOf8 = TextUtils.lastIndexOf(str6, '0', 0, 0);
                Object[] objArr13110 = new Object[1];
                b(mode4, i52111, (iLastIndexOf8 & 20) + (iLastIndexOf8 | 20), objArr13110);
                String[] strArr2112 = {(String) objArr13110[0]};
                char doubleTapTimeout8 = (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 30630);
                int i52112 = -(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                int i52113 = ((i52112 | 1181) << 1) - (i52112 ^ 1181);
                int i52114 = -TextUtils.lastIndexOf(str6, '0', 0, 0);
                int i52115 = (i52114 * (-300)) + 5436;
                int i52116 = (~((i52114 ^ 18) | (i52114 & 18) | i)) * (-301);
                int i52117 = (i52115 & i52116) + (i52115 | i52116);
                int i52118 = ~(((-19) ^ i) | ((-19) & i));
                int i52119 = ~((i19 ^ i52114) | (i19 & i52114));
                int i53110 = ((i52118 & i52119) | (i52118 ^ i52119)) * (-301);
                int i53111 = ((i52117 | i53110) << 1) - (i53110 ^ i52117);
                int i53112 = ~i52114;
                int i53113 = ~((i53112 & i) | (i53112 ^ i));
                int i53114 = ((i53113 & (-19)) | ((-19) ^ i53113)) * 301;
                int i53115 = (i53111 ^ i53114) + ((i53114 & i53111) << 1);
                Object[] objArr13111 = new Object[1];
                b(doubleTapTimeout8, i52113, i53115, objArr13111);
                String[] strArr2113 = {(String) objArr13111[0]};
                char c3114 = (char) (45087 - (~(-(-TextUtils.indexOf((CharSequence) str6, '0', 0)))));
                int i53116 = 1198 - (~(-(-(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))));
                int i53117 = -(-KeyEvent.normalizeMetaState(0));
                int i53118 = ((i53117 | 23) << 1) - (i53117 ^ 23);
                Object[] objArr13112 = new Object[1];
                b(c3114, i53116, i53118, objArr13112);
                String[] strArr2114 = {(String) objArr13112[0]};
                char c3115 = (char) (43880 - (~TextUtils.lastIndexOf(str6, '0')));
                int i53119 = 1221 - (~(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)));
                int i54110 = -(ViewConfiguration.getEdgeSlop() >> 16);
                Object[] objArr13113 = new Object[1];
                b(c3115, i53119, (i54110 & 21) + (i54110 | 21), objArr13113);
                String[] strArr2115 = {(String) objArr13113[0]};
                char pressedStateDuration8 = (char) (ViewConfiguration.getPressedStateDuration() >> 16);
                int i54111 = -(-(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                int i54112 = (i54111 ^ 1242) + ((i54111 & 1242) << 1);
                int i54113 = -(ViewConfiguration.getMaximumFlingVelocity() >> 16);
                int i54114 = ((i54113 | 24) << 1) - (i54113 ^ 24);
                Object[] objArr13114 = new Object[1];
                b(pressedStateDuration8, i54112, i54114, objArr13114);
                String str610 = (String) objArr13114[0];
                String str611 = str3;
                String[] strArr2116 = {str610, str611};
                int i54115 = -TextUtils.getTrimmedLength(str6);
                int i54116 = -(-Process.getGidForName(str6));
                int i54117 = ((i54116 | 1268) << 1) - (i54116 ^ 1268);
                int i54118 = -(-TextUtils.lastIndexOf(str6, '0', 0, 0));
                int i54119 = (i54118 ^ 29) + ((i54118 & 29) << 1);
                Object[] objArr13115 = new Object[1];
                b((char) ((i54115 ^ 26006) + ((i54115 & 26006) << 1)), i54117, i54119, objArr13115);
                String[] strArr2117 = {(String) objArr13115[0], str611};
                int i55110 = -(-(ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                int i55111 = -TextUtils.indexOf((CharSequence) str6, '0');
                int i55112 = (i55111 ^ 1294) + ((i55111 & 1294) << 1);
                int i55113 = -View.resolveSize(0, 0);
                int i55114 = ((i55113 | 27) << 1) - (i55113 ^ 27);
                Object[] objArr13116 = new Object[1];
                b((char) ((i55110 ^ 18234) + ((i55110 & 18234) << 1)), i55112, i55114, objArr13116);
                String[] strArr2118 = {(String) objArr13116[0], str611};
                char c3116 = (char) (0 - (~(-(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)))));
                int i55115 = -(-TextUtils.lastIndexOf(str6, '0'));
                int i55116 = (i55115 ^ 1323) + ((i55115 & 1323) << 1);
                int i55117 = -View.getDefaultSize(0, 0);
                int i55118 = (i55117 & 31) + (i55117 | 31);
                Object[] objArr13117 = new Object[1];
                b(c3116, i55116, i55118, objArr13117);
                String[] strArr2119 = {(String) objArr13117[0], str611};
                int i55119 = -(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                int i56110 = 1352 - (~(-Color.blue(0)));
                int i56111 = -(-(ViewConfiguration.getFadingEdgeLength() >> 16));
                int i56112 = (i56111 ^ 27) + ((i56111 & 27) << 1);
                Object[] objArr13118 = new Object[1];
                b((char) (((45681 | i55119) << 1) - (i55119 ^ 45681)), i56110, i56112, objArr13118);
                String[] strArr310 = {(String) objArr13118[0], str611};
                int i56113 = -TextUtils.indexOf(str6, str6, 0);
                Object[] objArr13119 = new Object[1];
                b((char) ((60952 ^ i56113) + ((i56113 & 60952) << 1)), 1381 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), TextUtils.indexOf((CharSequence) str6, '0') + 33, objArr13119);
                c2 = 0;
                strArr = new String[][]{strArr38, strArr39, strArr1110, strArr1111, strArr1112, strArr1113, strArr1114, strArr1115, strArr1116, strArr1117, strArr1118, strArr1119, strArr2110, strArr2111, strArr2112, strArr2113, strArr2114, strArr2115, strArr2116, strArr2117, strArr2118, strArr2119, strArr310, new String[]{(String) objArr13119[0], str611}};
                arrayList = new ArrayList();
                i21 = i;
                i22 = 0;
                i23 = 0;
                while (i22 < 24) {
                    String[] strArr311 = strArr[i22];
                    Object[] objArr148 = {strArr311[c2]};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1483923676);
                    if (objAccessartificialFrame == null) {
                        int i56114 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 23;
                        char cArgb3 = (char) Color.argb(0, 0, 0, 0);
                        int iLastIndexOf9 = TextUtils.lastIndexOf(str6, c) + 2442;
                        byte b24 = $$a[10];
                        byte b25 = b24;
                        Object[] objArr149 = new Object[1];
                        a(b25, (byte) (b25 | 48), b24, objArr149);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i56114, cArgb3, iLastIndexOf9, 954751276, false, (String) objArr149[0], new Class[]{String.class});
                    }
                    str7 = (String) ((Method) objAccessartificialFrame).invoke(null, objArr148);
                    String[] strArr312 = (String[]) Arrays.copyOfRange(strArr311, 1, strArr311.length);
                    if (str7 == null) {
                    }
                    i22 = (i22 ^ 1) + ((i22 & 1) << 1);
                    strArr = strArr;
                    c2 = 0;
                    c = '0';
                }
                if (i23 > 2) {
                    objArr = new Object[]{arrayList, new int[1], null, new int[]{i}, new int[]{i21}};
                    int i5716 = (int) Runtime.getRuntime().totalMemory();
                    int i5717 = -(-((((~((-25167554) | i5716)) * 521) - 16844584) + (((~((~i5716) | (-25167554))) | 437674024) * 521)));
                    int i5718 = i5717 << 13;
                    int i5719 = (i5717 | i5718) & (~(i5717 & i5718));
                    int i57110 = i5719 >>> 17;
                    int i57111 = (i5719 | i57110) & (~(i5719 & i57110));
                    int i58110 = i57111 << 5;
                    ((int[]) objArr[1])[0] = (i57111 | i58110) & (~(i57111 & i58110));
                    c3 = 0;
                    i24 = 1;
                } else {
                    objArr = new Object[]{null, new int[1], null, new int[]{i}, new int[]{i}};
                    int i58111 = artificialFrame + 81;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i58111 % 128;
                    int i58112 = i58111 % 2;
                    int iMaxMemory5 = (int) Runtime.getRuntime().maxMemory();
                    int i58113 = ~iMaxMemory5;
                    int i58114 = (-1447101183) + (((~((-209708089) | i58113)) | 1459200) * (-108)) + (((~(i58113 | 815156546)) | (~((-815156547) | iMaxMemory5)) | (-1023405435)) * 54) + ((iMaxMemory5 | (-1023405435)) * 54);
                    int i58115 = (i58114 << 13) ^ i58114;
                    int i58116 = i58115 ^ (i58115 >>> 17);
                    int i58117 = i58116 << 5;
                    int i58118 = ((~i58116) & i58117) | ((~i58117) & i58116);
                    i24 = 1;
                    c3 = 0;
                    ((int[]) objArr[1])[0] = i58118;
                }
                i25 = ((int[]) objArr[4])[c3];
                c4 = 5;
                if (i25 != i) {
                    Object[] objArr1410 = new Object[5];
                    objArr1410[i24] = new int[i24];
                    int[] iArr8 = new int[i24];
                    objArr1410[3] = iArr8;
                    int[] iArr9 = new int[i24];
                    objArr1410[4] = iArr9;
                    List list3 = (List) objArr[c3];
                    iArr8[c3] = i;
                    iArr9[c3] = i25;
                    objArr1410[c3] = list3;
                    objArr1410[2] = null;
                    int i58119 = artificialFrame;
                    i26 = ((i58119 | 119) << 1) - (i58119 ^ 119);
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i26 % 128;
                    if (i26 % 2 != 0) {
                        int iMyUid4 = Process.myUid();
                        i27 = i3 >> ((((((~((-902570182) | iMyUid4)) | 293871745) * (-566)) - 566868417) + ((~(iMyUid4 | (-608698437))) * 566)) >>> 16);
                    } else {
                        int iNextInt6 = new Random().nextInt(1060830923);
                        i27 = (i3 - (~(-(-((((-26741855) + (((~((-475940821) | iNextInt6)) | 129507637) * (-366))) + (((~(iNextInt6 | (-407258817))) | 60825633) * 366)) + 16))))) - 1;
                    }
                    int i598 = i27 ^ (i27 << 13);
                    int i599 = i598 >>> 17;
                    int i5910 = ((~i598) & i599) | ((~i599) & i598);
                    int i5911 = i5910 << 5;
                    ((int[]) objArr1410[1])[0] = (i5910 | i5911) & (~(i5910 & i5911));
                    return objArr1410;
                }
            }
            char pressedStateDuration9 = (char) (ViewConfiguration.getPressedStateDuration() >> 16);
            int i600 = -(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
            int i601 = (i600 ^ 699) + ((i600 & 699) << 1);
            int i602 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
            int i603 = ((i602 | 16) << 1) - (i602 ^ 16);
            Object[] objArr150 = new Object[1];
            b(pressedStateDuration9, i601, i603, objArr150);
            Object[] objArr151 = {(String) objArr150[0]};
            Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-1483923676);
            if (objAccessartificialFrame18 == null) {
                int keyRepeatDelay4 = 23 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                char c40 = (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1);
                int i604 = 2442 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                byte b26 = $$a[10];
                byte b27 = b26;
                Object[] objArr152 = new Object[1];
                a(b27, (byte) (b27 | 48), b26, objArr152);
                objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay4, c40, i604, 954751276, false, (String) objArr152[0], new Class[]{String.class});
            }
            Object objInvoke2 = ((Method) objAccessartificialFrame18).invoke(null, objArr151);
            if (objInvoke2 == null) {
                obj2 = null;
                i28 = 0;
            } else {
                Object[] objArr153 = {objInvoke2, 42};
                Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-287841710);
                if (objAccessartificialFrame19 == null) {
                    int iIndexOf6 = 20 - TextUtils.indexOf(str6, str6, 0);
                    char cResolveSize = (char) View.resolveSize(0, 0);
                    int iResolveSizeAndState2 = 2245 - View.resolveSizeAndState(0, 0, 0);
                    byte[] bArr11 = $$a;
                    byte b28 = bArr11[10];
                    byte b29 = bArr11[16];
                    Object[] objArr154 = new Object[1];
                    a(b28, b29, (byte) (b29 + 3), objArr154);
                    objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(iIndexOf6, cResolveSize, iResolveSizeAndState2, 1907532890, false, (String) objArr154[0], new Class[]{String.class, Integer.TYPE});
                }
                obj2 = null;
                long jLongValue11 = ((Long) ((Method) objAccessartificialFrame19).invoke(null, objArr153)).longValue();
                long j65 = 969876704;
                long j66 = j65 ^ j20;
                long j67 = (((long) 303) * j65) + (j53 * jLongValue11) + (((long) (-302)) * ((((j66 | j24) | jLongValue11) ^ j20) | (((j65 | jLongValue11) | j23) ^ j20))) + (((long) (-604)) * (((j66 | jLongValue11) | j23) ^ j20)) + ((((jLongValue11 | j23) ^ j20) | ((j65 | (jLongValue11 ^ j20)) ^ j20)) * j52) + ((long) 663208624);
                int startUptimeMillis3 = (int) Process.getStartUptimeMillis();
                int i605 = ((int) (j67 >> 32)) & (501358106 + (((~((-1719960894) | startUptimeMillis3)) | 1711570989) * 336) + (((~((-282734483) | startUptimeMillis3)) | 274344578) * (-168)) + (((~((~startUptimeMillis3) | (-282734483))) | (-1719960894)) * 168));
                int i606 = ((int) j67) & (((1771465493 + (((~(1402630392 | i)) | (-1402991866)) * 576)) + (((~((-361474) | i326)) | 1368395848) * 576)) - 669463168);
                i28 = (i605 & i606) | (i605 ^ i606);
            }
            if (i28 == 1986687685 || i28 == -1514516938) {
                i29 = i326;
            } else {
                char size4 = (char) View.MeasureSpec.getSize(0);
                int i607 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 1413;
                int bitsPerPixel4 = ImageFormat.getBitsPerPixel(0);
                int i608 = ((bitsPerPixel4 | 15) << 1) - (bitsPerPixel4 ^ 15);
                Object[] objArr155 = new Object[1];
                b(size4, i607, i608, objArr155);
                String str70 = (String) objArr155[0];
                int i609 = -TextUtils.indexOf(str6, str6, 0);
                Object[] objArr156 = new Object[1];
                b((char) ((i609 & 17732) + (i609 | 17732)), 1426 - (~(-TextUtils.getOffsetBefore(str6, 0))), 25 - (~(-(-Color.argb(0, 0, 0, 0)))), objArr156);
                String str71 = (String) objArr156[0];
                int iRgb4 = Color.rgb(0, 0, 0);
                char c41 = c4;
                int i610 = 1453 - (~ExpandableListView.getPackedPositionChild(0L));
                int i611 = -(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                int i612 = i611 * 595;
                int i613 = (i612 & (-21366)) + (i612 | (-21366));
                int i614 = ~i611;
                int i615 = ~((i614 ^ 18) | (i614 & 18));
                int i616 = ~((i19 ^ 18) | (i19 & 18));
                int i617 = -(-(((i615 & i616) | (i615 ^ i616)) * (-1188)));
                int i618 = (i613 & i617) + (i613 | i617);
                int i619 = ~(i614 | 18);
                int i620 = ~(((-19) ^ i) | ((-19) & i));
                int i621 = ((i619 & i620) | (i619 ^ i620) | (~((i326 ^ i611) | (i326 & i611)))) * 594;
                int i622 = ((i618 | i621) << 1) - (i621 ^ i618);
                int i623 = ~(((-19) & i326) | ((-19) ^ i326));
                int i624 = ~(((-19) & i611) | ((-19) ^ i611));
                int i625 = ((~(i19 | i611)) | (i623 & i624) | (i623 ^ i624)) * 594;
                int i626 = ((i622 | i625) << 1) - (i625 ^ i622);
                Object[] objArr157 = new Object[1];
                b((char) ((iRgb4 ^ 16777216) + ((iRgb4 & 16777216) << 1)), i610, i626, objArr157);
                String str72 = (String) objArr157[0];
                int longPressTimeout8 = ViewConfiguration.getLongPressTimeout() >> 16;
                int i627 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                Object[] objArr158 = new Object[1];
                b((char) (((longPressTimeout8 | 64706) << 1) - (longPressTimeout8 ^ 64706)), (i627 ^ 1469) + ((i627 & 1469) << 1), Process.getGidForName(str6) + 18, objArr158);
                String str73 = (String) objArr158[0];
                char c42 = (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                int i628 = -TextUtils.indexOf((CharSequence) str6, '0', 0);
                int i629 = (i628 & 1486) + (i628 | 1486);
                int i630 = -(-(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                int i631 = (i630 ^ 15) + ((i630 & 15) << 1);
                Object[] objArr159 = new Object[1];
                b(c42, i629, i631, objArr159);
                String str74 = (String) objArr159[0];
                int i632 = -((byte) KeyEvent.getModifierMetaStateMask());
                Object[] objArr160 = new Object[1];
                b((char) (((i632 | FragmentTransaction.TRANSIT_FRAGMENT_MATCH_ACTIVITY_OPEN) << 1) - (i632 ^ FragmentTransaction.TRANSIT_FRAGMENT_MATCH_ACTIVITY_OPEN)), 1500 - (~(-(-(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))), 36 - (~(-(-(Process.myPid() >> 22)))), objArr160);
                String str75 = (String) objArr160[0];
                int i633 = -(-(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                int packedPositionGroup13 = ExpandableListView.getPackedPositionGroup(0L);
                int i634 = (packedPositionGroup13 & 1539) + (packedPositionGroup13 | 1539);
                int i635 = -((byte) KeyEvent.getModifierMetaStateMask());
                int i636 = ((i635 | 11) << 1) - (i635 ^ 11);
                Object[] objArr161 = new Object[1];
                b((char) ((i633 ^ (-1)) + (i633 << 1)), i634, i636, objArr161);
                String str76 = (String) objArr161[0];
                char deadChar3 = (char) KeyEvent.getDeadChar(0, 0);
                int mode5 = View.MeasureSpec.getMode(0);
                int i637 = (mode5 & 1551) + (mode5 | 1551);
                int i638 = -(ViewConfiguration.getMaximumFlingVelocity() >> 16);
                int i639 = ((i638 | 13) << 1) - (i638 ^ 13);
                Object[] objArr162 = new Object[1];
                b(deadChar3, i637, i639, objArr162);
                String str77 = (String) objArr162[0];
                char c43 = (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                int i640 = -Color.blue(0);
                int i641 = (i640 & 1564) + (i640 | 1564);
                byte modifierMetaStateMask4 = (byte) KeyEvent.getModifierMetaStateMask();
                int i642 = ((modifierMetaStateMask4 | Ascii.ETB) << 1) - (modifierMetaStateMask4 ^ Ascii.ETB);
                Object[] objArr163 = new Object[1];
                b(c43, i641, i642, objArr163);
                String str78 = (String) objArr163[0];
                int i643 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                int i644 = -KeyEvent.normalizeMetaState(0);
                int i645 = ((i644 | 1586) << 1) - (i644 ^ 1586);
                int i646 = -Gravity.getAbsoluteGravity(0, 0);
                int i647 = ((i646 | 31) << 1) - (i646 ^ 31);
                Object[] objArr164 = new Object[1];
                b((char) (((i643 | 48269) << 1) - (i643 ^ 48269)), i645, i647, objArr164);
                String str79 = (String) objArr164[0];
                Object[] objArr165 = new Object[1];
                b((char) (KeyEvent.getMaxKeyCode() >> 16), 1615 - (~(-MotionEvent.axisFromString(str6))), 12 - View.MeasureSpec.makeMeasureSpec(0, 0), objArr165);
                String str80 = (String) objArr165[0];
                char c44 = (char) (254 - (~(-(-TextUtils.getOffsetAfter(str6, 0)))));
                int i648 = -(ViewConfiguration.getPressedStateDuration() >> 16);
                int i649 = i648 * 829;
                int i650 = (i649 & 1350441) + (i649 | 1350441);
                int i651 = ~i648;
                int i652 = ~((i651 & (-1630)) | (i651 ^ (-1630)));
                int i653 = ~(i19 | i648 | 1629);
                int i654 = i650 + (((i652 & i653) | (i652 ^ i653)) * (-828));
                int i655 = (i648 & 1629) | (i648 ^ 1629);
                int i656 = ((i655 ^ i326) | (i655 & i326)) * (-828);
                int i657 = ((i654 | i656) << 1) - (i656 ^ i654);
                int i658 = (~i655) * 828;
                int i659 = (i657 & i658) + (i658 | i657);
                int i660 = -(-(ViewConfiguration.getScrollBarSize() >> 8));
                int i661 = ((i660 | 12) << 1) - (i660 ^ 12);
                Object[] objArr166 = new Object[1];
                b(c44, i659, i661, objArr166);
                String str81 = (String) objArr166[0];
                int i662 = -(-TextUtils.lastIndexOf(str6, '0', 0, 0));
                int iAlpha = Color.alpha(0);
                Object[] objArr167 = new Object[1];
                b((char) (((i662 | 5133) << 1) - (i662 ^ 5133)), (iAlpha & 1641) + (iAlpha | 1641), 12 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), objArr167);
                String str82 = (String) objArr167[0];
                char c45 = (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1);
                int threadPriority4 = Process.getThreadPriority(0);
                int i663 = threadPriority4 & 20;
                int i664 = threadPriority4 | 20;
                Object obj5 = obj2;
                int i665 = -((i663 + i664) >> 6);
                Object[] objArr168 = new Object[1];
                b(c45, (i665 ^ 1653) + ((i665 & 1653) << 1), 11 - (~(-Color.green(0))), objArr168);
                String str83 = (String) objArr168[0];
                char cIndexOf8 = (char) TextUtils.indexOf(str6, str6, 0, 0);
                int i666 = -(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                Object[] objArr169 = new Object[1];
                b(cIndexOf8, (i666 ^ 1665) + ((i666 & 1665) << 1), 12 - (~(-(-((byte) KeyEvent.getModifierMetaStateMask())))), objArr169);
                String str84 = (String) objArr169[0];
                char modifierMetaStateMask5 = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1);
                int i667 = -Color.alpha(0);
                Object[] objArr170 = new Object[1];
                b(modifierMetaStateMask5, (i667 ^ 1677) + ((i667 & 1677) << 1), 13 - (~(-(-View.MeasureSpec.getSize(0)))), objArr170);
                String str85 = (String) objArr170[0];
                char c46 = (char) ((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 528);
                int gidForName = Process.getGidForName(str6);
                int i668 = (gidForName ^ 1692) + ((gidForName & 1692) << 1);
                int i669 = -MotionEvent.axisFromString(str6);
                int i670 = (i669 & 11) + (i669 | 11);
                Object[] objArr171 = new Object[1];
                b(c46, i668, i670, objArr171);
                String str86 = (String) objArr171[0];
                Object[] objArr172 = new Object[1];
                b((char) TextUtils.getCapsMode(str6, 0, 0), 1702 - (~(-Drawable.resolveOpacity(0, 0))), 22 - (~(-TextUtils.lastIndexOf(str6, '0'))), objArr172);
                String str87 = (String) objArr172[0];
                char c47 = (char) (30899 - (~(Process.myTid() >> 22)));
                int size5 = 1727 - View.MeasureSpec.getSize(0);
                int i671 = -(ViewConfiguration.getMaximumFlingVelocity() >> 16);
                int i672 = ((i671 | 28) << 1) - (i671 ^ 28);
                Object[] objArr173 = new Object[1];
                b(c47, size5, i672, objArr173);
                String[] strArr40 = {str70, str71, str72, str73, str74, str75, str76, str77, str78, str79, str80, str81, str82, str83, str84, str85, str86, str87, (String) objArr173[0]};
                int i673 = 0;
                while (true) {
                    if (i673 >= 19) {
                        i29 = i326;
                        i673 = i20;
                        break;
                    }
                    String str88 = strArr40[i673];
                    Object[] objArr174 = {str88};
                    Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-11453480);
                    if (objAccessartificialFrame20 == null) {
                        int scrollBarSize3 = 17 - (ViewConfiguration.getScrollBarSize() >> 8);
                        char c48 = (char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 24343);
                        int i674 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 2014;
                        byte[] bArr12 = $$a;
                        Object[] objArr175 = new Object[1];
                        a(bArr12[c41], bArr12[16], bArr12[20], objArr175);
                        objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(scrollBarSize3, c48, i674, 1614052816, false, (String) objArr175[0], new Class[]{String.class});
                    }
                    long jLongValue12 = ((Long) ((Method) objAccessartificialFrame20).invoke(obj5, objArr174)).longValue();
                    long j68 = 1150581370;
                    long j69 = -103;
                    long j70 = (j69 * j68) + (j69 * jLongValue12);
                    long j71 = 104;
                    long j72 = jLongValue12 ^ j20;
                    long jElapsedRealtime = (int) SystemClock.elapsedRealtime();
                    i29 = i326;
                    long j73 = j70 + (((((j68 ^ j20) | j72) ^ j20) | ((j72 | jElapsedRealtime) ^ j20)) * j71) + (((long) (-104)) * ((((jElapsedRealtime ^ j20) | j68) | jLongValue12) ^ j20)) + (j71 * (j68 | jElapsedRealtime)) + ((long) 411549667);
                    int i675 = ~new Random().nextInt(1680322182);
                    int i676 = ~(1407857008 | i675);
                    int i677 = ((int) (j73 >> 32)) & (1371383226 + ((29369402 | i676) * 764) + (((~(i675 | 29369402)) | 1378488640) * (-1528)) + ((1378489674 | i676) * 764));
                    int i678 = ~((int) Process.getStartElapsedRealtime());
                    int i679 = ((int) j73) & (((((~(1775243806 | i678)) | 338013280) * (-241)) - 1581396511) + (((~(i678 | 2113257086)) | 4116) * 241));
                    if (((i679 & i677) | (i677 ^ i679)) != 0) {
                        break;
                    }
                    char gidForName2 = (char) (Process.getGidForName(str6) + 1);
                    int i680 = -(-Color.alpha(0));
                    int i681 = (i680 & 1677) + (i680 | 1677);
                    int i682 = -(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                    Object[] objArr176 = new Object[1];
                    b(gidForName2, i681, (i682 & 15) + (i682 | 15), objArr176);
                    if (str88.equals((String) objArr176[0])) {
                        Object[] objArr177 = {str88};
                        Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(479197382);
                        if (objAccessartificialFrame21 == null) {
                            int iLastIndexOf10 = TextUtils.lastIndexOf(str6, '0') + 18;
                            char maximumDrawingCacheSize = (char) (24343 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                            int tapTimeout2 = 2014 - (ViewConfiguration.getTapTimeout() >> 16);
                            byte[] bArr13 = $$a;
                            byte b30 = bArr13[5];
                            byte b31 = (byte) (-bArr13[7]);
                            Object[] objArr178 = new Object[1];
                            a(b30, b31, (byte) (b31 + 3), objArr178);
                            objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(iLastIndexOf10, maximumDrawingCacheSize, tapTimeout2, -2081767730, false, (String) objArr178[0], new Class[]{String.class});
                        }
                        long jLongValue13 = ((Long) ((Method) objAccessartificialFrame21).invoke(null, objArr177)).longValue();
                        long j74 = 390241825;
                        long j75 = -754;
                        long j76 = j74 ^ j20;
                        long j77 = j76 | jLongValue13;
                        long jElapsedRealtime2 = (int) SystemClock.elapsedRealtime();
                        long j78 = (((long) 755) * j74) + (((long) (-753)) * jLongValue13) + (((j77 ^ j20) | ((j76 | jElapsedRealtime2) ^ j20) | ((jLongValue13 | jElapsedRealtime2) ^ j20)) * j75);
                        long j79 = (j77 | jElapsedRealtime2) ^ j20;
                        long j80 = jElapsedRealtime2 ^ j20;
                        long j81 = j78 + (j75 * (j79 | (((j74 | j80) | jLongValue13) ^ j20))) + (((long) 754) * (j80 | j76)) + ((long) 106369566);
                        int i683 = ((int) (j81 >> 32)) & ((-826426159) + (((~(135691595 | i29)) | (~(1572918006 | i))) * 333) + (((~(135691595 | i)) | (~(i29 | 1572918006))) * 333));
                        int i684 = ((int) j81) & ((-1520785380) + (((~(i29 | (-1617197927))) | 1615092290) * 529) + (((~((-1617197927) | i)) | (-179971517)) * 529));
                        if (((i683 & i684) | (i683 ^ i684)) != 0) {
                            break;
                        }
                    }
                    i673 = (i673 ^ 1) + ((i673 & 1) << 1);
                    c41 = 5;
                    obj5 = null;
                    i326 = i29;
                }
                if (i673 >= 0) {
                    int i685 = i673 + 130;
                    int i686 = ((~i685) & i) | (i685 & i29);
                    if (i686 != i) {
                        objArr3 = new Object[5];
                        objArr3[1] = new int[1];
                        objArr3[3] = new int[1];
                        int i687 = ~((1801903900 ^ i29) | (1801903900 & i29));
                        int i688 = ~((-1508919495) | i);
                        int i689 = ((i687 & i688) | (i687 ^ i688)) * 1150;
                        int i690 = (669325074 & i689) + (i689 | 669325074);
                        int i691 = ~(((-1508919495) & i) | ((-1508919495) ^ i));
                        int i692 = ~((i29 & 1508919494) | (i29 ^ 1508919494));
                        int i693 = ((i691 & i692) | (i691 ^ i692)) * (-575);
                        int i694 = (i690 & i693) + (i693 | i690);
                        int i695 = ~((1801903900 & i) | (1801903900 ^ i));
                        int i696 = ~(i29 | (-1801903901));
                        int i697 = ((i695 & i696) | (i695 ^ i696)) * 575;
                        int i698 = (i694 & i697) + (i697 | i694);
                        int i699 = ~TimestampAction._BOUNDARY();
                        int i700 = (i699 & (-1880925170)) | ((-1880925170) ^ i699);
                        if (i698 <= 1730288545 + (i700 * 495) + (((~i700) | 115496970) * 495)) {
                            c7 = 4;
                            objArr3[4] = new int[1];
                            i33 = 78;
                            c8 = 3;
                        } else {
                            c7 = 4;
                            objArr3[4] = new int[1];
                            c8 = 3;
                            i33 = 16;
                        }
                        ((int[]) objArr3[c8])[0] = i;
                        ((int[]) objArr3[c7])[0] = i686;
                        objArr3[0] = null;
                        objArr3[2] = null;
                        int i701 = ~(Process.myPid() | (-114666726));
                        int i702 = ((((-1026248317) + (((-720115184) | i701) * (-220))) + ((i701 | 68265984) * 220)) - 13468346) + i33;
                        int i703 = (i3 ^ i702) + ((i3 & i702) << 1);
                        int i704 = i703 << 13;
                        int i705 = ((~i703) & i704) | ((~i704) & i703);
                        int i706 = i705 ^ (i705 >>> 17);
                        ((int[]) objArr3[1])[0] = i706 ^ (i706 << 5);
                    }
                    return objArr3;
                }
            }
            char maximumDrawingCacheSize2 = (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
            int i707 = -(-Color.green(0));
            Object[] objArr179 = new Object[1];
            b(maximumDrawingCacheSize2, ((i707 | 1755) << 1) - (i707 ^ 1755), ExpandableListView.getPackedPositionGroup(0L) + 13, objArr179);
            String str89 = (String) objArr179[0];
            char cBlue2 = (char) Color.blue(0);
            int i708 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
            int i709 = (i708 & 1767) + (i708 | 1767);
            int i710 = -(-(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
            Object[] objArr180 = new Object[1];
            b(cBlue2, i709, (i710 & 4) + (i710 | 4), objArr180);
            String[] strArr41 = {str89, (String) objArr180[0]};
            int i711 = -(-(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
            Object[] objArr181 = new Object[1];
            b((char) ((i711 & 59430) + (i711 | 59430)), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 1772, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 14, objArr181);
            String str90 = (String) objArr181[0];
            int i712 = -ImageFormat.getBitsPerPixel(0);
            int iNormalizeMetaState = 1788 - KeyEvent.normalizeMetaState(0);
            int i713 = -Color.red(0);
            int i714 = i713 * (-51);
            int i715 = (i714 ^ PointerIconCompat.TYPE_CROSSHAIR) + ((i714 & PointerIconCompat.TYPE_CROSSHAIR) << 1);
            int i716 = (i29 ^ i713) | (i29 & i713);
            int i717 = -(-((~(i716 | 19)) * 52));
            int i718 = ((i715 | i717) << 1) - (i715 ^ i717);
            int i719 = ~(((-20) & i29) | ((-20) ^ i29));
            int i720 = ~(((-20) & i713) | ((-20) ^ i713));
            int i721 = (i719 & i720) | (i719 ^ i720);
            int i722 = ~i716;
            int i723 = ((i722 & i721) | (i721 ^ i722)) * (-52);
            int i724 = (i718 ^ i723) + ((i723 & i718) << 1);
            int i725 = ~i713;
            int i726 = ~((i725 ^ i29) | (i725 & i29));
            int i727 = ~((i725 & 19) | (i725 ^ 19));
            int i728 = i724 + (((i727 & i726) | (i726 ^ i727)) * 52);
            Object[] objArr182 = new Object[1];
            b((char) ((i712 ^ (-1)) + (i712 << 1)), iNormalizeMetaState, i728, objArr182);
            String str91 = (String) objArr182[0];
            int i729 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
            int i730 = -(KeyEvent.getMaxKeyCode() >> 16);
            int i731 = (i730 ^ 1807) + ((i730 & 1807) << 1);
            int scrollBarSize4 = ViewConfiguration.getScrollBarSize() >> 8;
            int i732 = (scrollBarSize4 & 14) + (scrollBarSize4 | 14);
            Object[] objArr183 = new Object[1];
            b((char) ((i729 ^ 53025) + ((i729 & 53025) << 1)), i731, i732, objArr183);
            String[] strArr42 = {str90, str91, (String) objArr183[0]};
            char jumpTapTimeout = (char) (ViewConfiguration.getJumpTapTimeout() >> 16);
            int i733 = -(-TextUtils.indexOf((CharSequence) str6, '0', 0));
            int i734 = (i733 & 1822) + (i733 | 1822);
            int threadPriority5 = Process.getThreadPriority(0);
            Object[] objArr184 = new Object[1];
            b(jumpTapTimeout, i734, 20 - (~(-((((threadPriority5 | 20) << 1) - (threadPriority5 ^ 20)) >> 6))), objArr184);
            String str92 = (String) objArr184[0];
            int threadPriority6 = Process.getThreadPriority(0);
            int i_BOUNDARY11 = TimestampAction._BOUNDARY();
            int i735 = (-10380) + (threadPriority6 * 521);
            int i736 = ~threadPriority6;
            int i737 = -(-(((~(((-21) ^ i736) | ((-21) & i736) | (~i_BOUNDARY11))) | (~((threadPriority6 ^ i_BOUNDARY11) | (threadPriority6 & i_BOUNDARY11)))) * 520));
            int i738 = (i735 ^ i737) + ((i735 & i737) << 1);
            int i739 = ~i_BOUNDARY11;
            int i740 = ((~((i736 & i739) | (i736 ^ i739))) | (~((i_BOUNDARY11 ^ 20) | (i_BOUNDARY11 & 20)))) * (-1040);
            int i741 = ((i738 | i740) << 1) - (i740 ^ i738);
            int i742 = ~((-21) | i739);
            int i743 = ~threadPriority6;
            int i744 = (~((i743 & 20) | (i743 ^ 20))) | i742;
            int i745 = ~(i_BOUNDARY11 | 20);
            int i746 = -(-(((i745 & i744) | (i744 ^ i745)) * 520));
            char c49 = (char) (((i741 ^ i746) + ((i746 & i741) << 1)) >> 6);
            int i747 = -TextUtils.indexOf((CharSequence) str6, '0');
            Object[] objArr185 = new Object[1];
            b(c49, (i747 ^ 1841) + ((i747 & 1841) << 1), View.MeasureSpec.getSize(0) + 10, objArr185);
            String[] strArr43 = {str92, (String) objArr185[0]};
            char touchSlop2 = (char) (ViewConfiguration.getTouchSlop() >> 8);
            int i748 = -TextUtils.indexOf((CharSequence) str6, '0', 0, 0);
            int i749 = (i748 ^ 1851) + ((i748 & 1851) << 1);
            int keyRepeatDelay5 = ViewConfiguration.getKeyRepeatDelay() >> 16;
            int i750 = ((keyRepeatDelay5 | 11) << 1) - (keyRepeatDelay5 ^ 11);
            Object[] objArr186 = new Object[1];
            b(touchSlop2, i749, i750, objArr186);
            String str93 = (String) objArr186[0];
            char cIndexOf9 = (char) (TextUtils.indexOf((CharSequence) str6, '0', 0, 0) + 1);
            int threadPriority7 = Process.getThreadPriority(0);
            int i751 = (((threadPriority7 & 20) + (20 | threadPriority7)) >> 6) + 589;
            int i752 = -Color.red(0);
            int i753 = (i752 ^ 6) + ((i752 & 6) << 1);
            Object[] objArr187 = new Object[1];
            b(cIndexOf9, i751, i753, objArr187);
            String[] strArr44 = {str93, (String) objArr187[0]};
            char trimmedLength5 = (char) TextUtils.getTrimmedLength(str6);
            int bitsPerPixel5 = ImageFormat.getBitsPerPixel(0);
            int i_BOUNDARY12 = TimestampAction._BOUNDARY();
            int i754 = bitsPerPixel5 * 595;
            int i755 = (i754 ^ (-2212568)) + ((i754 & (-2212568)) << 1);
            int i756 = ~bitsPerPixel5;
            int i757 = ~((i756 ^ 1864) | (i756 & 1864));
            int i758 = ~i_BOUNDARY12;
            int i759 = ~((i758 & 1864) | (i758 ^ 1864));
            int i760 = ((i759 & i757) | (i757 ^ i759)) * (-1188);
            int i761 = (i755 & i760) + (i760 | i755);
            int i762 = ~(i756 | 1864);
            int i763 = ~(((-1865) ^ i_BOUNDARY12) | ((-1865) & i_BOUNDARY12));
            int i764 = -(-(((i762 & i763) | (i762 ^ i763) | (~((i758 ^ bitsPerPixel5) | (i758 & bitsPerPixel5)))) * 594));
            int i765 = (i761 ^ i764) + ((i764 & i761) << 1);
            int i766 = ~i_BOUNDARY12;
            int i767 = -(-(((~(i766 | bitsPerPixel5)) | (~(((-1865) ^ i766) | ((-1865) & i766))) | (~(((-1865) & bitsPerPixel5) | ((-1865) ^ bitsPerPixel5)))) * 594));
            char c50 = 0;
            Object[] objArr188 = new Object[1];
            b(trimmedLength5, (i765 & i767) + (i767 | i765), TextUtils.lastIndexOf(str6, '0', 0, 0) + 29, objArr188);
            String str94 = (String) objArr188[0];
            char doubleTapTimeout9 = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
            int iMyTid4 = (Process.myTid() >> 22) + 1842;
            int i768 = -Color.alpha(0);
            Object[] objArr189 = new Object[1];
            b(doubleTapTimeout9, iMyTid4, (i768 ^ 10) + ((i768 & 10) << 1), objArr189);
            String[][] strArr45 = {strArr41, strArr42, strArr43, strArr44, new String[]{str94, (String) objArr189[0]}};
            int i769 = 0;
            int i770 = i20;
            int i771 = 5;
            loop5: while (true) {
                if (i769 >= i771) {
                    i30 = 1;
                    i31 = i;
                    break;
                }
                String[] strArr46 = strArr45[i769];
                String str95 = strArr46[c50];
                String[] strArr47 = (String[]) Arrays.copyOfRange(strArr46, 1, strArr46.length);
                int length2 = strArr47.length;
                int i772 = 0;
                while (i772 < length2) {
                    int i773 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i774 = i773 + 15;
                    artificialFrame = i774 % 128;
                    int i775 = i774 % 2;
                    String str96 = strArr47[i772];
                    int i776 = i770 + 1;
                    int i777 = (i773 & 55) + (i773 | 55);
                    artificialFrame = i777 % 128;
                    int i778 = i777 % 2;
                    Object[] objArr190 = {str95, str96};
                    Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-883653127);
                    if (objAccessartificialFrame22 == null) {
                        int scrollBarSize5 = (ViewConfiguration.getScrollBarSize() >> 8) + 31;
                        char cCombineMeasuredStates = (char) (57022 - View.combineMeasuredStates(0, 0));
                        int defaultSize6 = 2311 - View.getDefaultSize(0, 0);
                        byte[] bArr14 = $$a;
                        Object[] objArr191 = new Object[1];
                        a(bArr14[10], (byte) 18, (byte) (bArr14[0] + 1), objArr191);
                        objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(scrollBarSize5, cCombineMeasuredStates, defaultSize6, 1412547569, false, (String) objArr191[0], new Class[]{String.class, String.class});
                    }
                    long jLongValue14 = ((Long) ((Method) objAccessartificialFrame22).invoke(null, objArr190)).longValue();
                    long j82 = 170421333;
                    long j83 = -344;
                    long j84 = (j83 * j82) + (j83 * jLongValue14);
                    long j85 = 345;
                    long j86 = j82 ^ j20;
                    long j87 = jLongValue14 ^ j20;
                    long j88 = j86 | j87;
                    long j89 = j84 + (((j88 ^ j20) | ((j86 | j23) ^ j20)) * j85) + ((((j86 | j24) ^ j20) | ((j87 | j82) ^ j20)) * j85) + (j85 * ((j88 | j23) ^ j20)) + ((long) (-325172962));
                    int startElapsedRealtime2 = (int) Process.getStartElapsedRealtime();
                    int i779 = ~startElapsedRealtime2;
                    int i780 = ((int) (j89 >> 32)) & ((-1483132274) + (((-1468769737) | (~(i779 | (-1388971149)))) * (-1042)) + (((-1388971149) | startElapsedRealtime2) * 521) + (((~(startElapsedRealtime2 | 1468769736)) | (-1472964045) | (~(i779 | (-1384776841)))) * 521));
                    int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
                    int i781 = ((int) j89) & ((((-384374209) + (((~((~iElapsedRealtime) | 836388236)) | (-869946782)) * 446)) + (((~(iElapsedRealtime | (-33558546))) | 269108608) * 446)) - 1449208132);
                    if (((i780 & i781) | (i780 ^ i781)) != 0) {
                        int i782 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i783 = (i782 & 57) + (i782 | 57);
                        artificialFrame = i783 % 128;
                        if (i783 % 2 == 0) {
                            int i784 = ((i776 | 20332) << 1) - (i776 ^ 20332);
                            i31 = (i784 | i) & (~(i & i784));
                        } else {
                            int i785 = i770 + 171;
                            i31 = ((~i785) & i) | (i785 & i29);
                        }
                        i30 = 1;
                        break loop5;
                    }
                    i772 = (i772 & 1) + (i772 | 1);
                    strArr45 = strArr45;
                    i770 = i776;
                    strArr47 = strArr47;
                }
                i769 = ((i769 & 1) << 1) + (i769 ^ 1);
                strArr45 = strArr45;
                i771 = 5;
                c50 = 0;
            }
            if (i31 != i) {
                objArr3 = new Object[5];
                int[] iArr10 = new int[i30];
                objArr3[i30] = iArr10;
                int[] iArr11 = new int[i30];
                objArr3[3] = iArr11;
                int[] iArr12 = new int[i30];
                objArr3[4] = iArr12;
                iArr11[0] = i;
                iArr12[0] = i31;
                objArr3[0] = null;
                objArr3[2] = null;
                int i786 = i3 + (-599936655) + ((i | 424169697) * 988) + (((~(i29 | 1029627121)) | (-1029636088)) * (-1976)) + (((~(i | 424178663)) | 424169697 | (~(i29 | (-424178664)))) * 988) + 16;
                int i787 = i786 << 13;
                int i788 = (i786 | i787) & (~(i786 & i787));
                int i789 = i788 >>> 17;
                int i790 = ((~i788) & i789) | ((~i789) & i788);
                int i791 = i790 << 5;
                iArr10[0] = ((~i790) & i791) | ((~i791) & i790);
            } else {
                try {
                    char maximumDrawingCacheSize3 = (char) (50544 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                    int i792 = -TextUtils.indexOf(str6, str6);
                    Object[] objArr192 = new Object[1];
                    b(maximumDrawingCacheSize3, ((i792 | 1891) << 1) - (i792 ^ 1891), 12 - (~KeyEvent.keyCodeFromString(str6)), objArr192);
                    String str97 = (String) objArr192[0];
                    char c51 = (char) (15550 - (~(-(ViewConfiguration.getScrollBarFadeDuration() >> 16))));
                    int minimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity() >> 16;
                    int i_BOUNDARY13 = TimestampAction._BOUNDARY();
                    int i793 = minimumFlingVelocity * (-563);
                    int i794 = (i793 ^ 1075760) + ((i793 & 1075760) << 1);
                    int i795 = ~minimumFlingVelocity;
                    int i796 = ~i_BOUNDARY13;
                    int i797 = ~((i796 & (-1905)) | ((-1905) ^ i796));
                    int i798 = (i795 & i797) | (i795 ^ i797);
                    int i799 = ~(i_BOUNDARY13 | 1904);
                    int i800 = i794 + (((i798 & i799) | (i798 ^ i799)) * (-564));
                    int i801 = ~minimumFlingVelocity;
                    int i802 = (~((i801 ^ 1904) | (i801 & 1904) | i_BOUNDARY13)) * 1128;
                    int i803 = (i800 ^ i802) + ((i802 & i800) << 1);
                    int i804 = ~((~i_BOUNDARY13) | i801);
                    int i805 = ~((minimumFlingVelocity & 1904) | (minimumFlingVelocity ^ 1904));
                    int i806 = -(-(((i804 & i805) | (i804 ^ i805)) * 564));
                    int i807 = (i803 & i806) + (i806 | i803);
                    int i808 = -TextUtils.getCapsMode(str6, 0, 0);
                    int i809 = ((i808 | 8) << 1) - (i808 ^ 8);
                    Object[] objArr193 = new Object[1];
                    b(c51, i807, i809, objArr193);
                    String str98 = (String) objArr193[0];
                    File file3 = new File(str97);
                    if (file3.exists() && file3.isFile()) {
                        try {
                            Scanner scanner3 = new Scanner(new FileInputStream(file3));
                            char cResolveOpacity = (char) Drawable.resolveOpacity(0, 0);
                            int i810 = 229 - (~MotionEvent.axisFromString(str6));
                            int i811 = -View.MeasureSpec.getSize(0);
                            Object[] objArr194 = new Object[1];
                            b(cResolveOpacity, i810, (i811 & 2) + (i811 | 2), objArr194);
                            Scanner scannerUseDelimiter3 = scanner3.useDelimiter((String) objArr194[0]);
                            String next3 = scannerUseDelimiter3.hasNext() ? scannerUseDelimiter3.next() : str6;
                            scannerUseDelimiter3.close();
                            if (next3.contains(str98)) {
                                i32 = i ^ 150;
                            } else {
                                i32 = i;
                            }
                        } catch (IOException unused3) {
                        }
                    } else {
                        i32 = i;
                    }
                } catch (Exception unused4) {
                    i32 = i ^ 151;
                }
                if (i32 != i) {
                    objArr3 = new Object[5];
                    objArr3[1] = new int[1];
                    int[] iArr13 = new int[1];
                    objArr3[3] = iArr13;
                    int[] iArr14 = new int[1];
                    objArr3[4] = iArr14;
                    int i812 = artificialFrame;
                    int i813 = (i812 & 95) + (i812 | 95);
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i813 % 128;
                    if (i813 % 2 != 0) {
                        c6 = 0;
                        iArr13[0] = i;
                    } else {
                        c6 = 0;
                        iArr13[0] = i;
                    }
                    iArr14[c6] = i32;
                    objArr3[c6] = null;
                    objArr3[2] = null;
                    int iNextInt7 = new Random().nextInt();
                    int i814 = ~iNextInt7;
                    int i815 = 887435209 + ((553976960 | i814) * (-192)) + (((~((-47242086) | i814)) | 4229412) * (-384)) + (((~(iNextInt7 | 601219045)) | (~(i814 | (-43012674))) | (~((-4229413) | iNextInt7))) * JfifUtil.MARKER_SOFn);
                    int i816 = i3 + (i815 ^ 16) + ((16 & i815) << 1);
                    int i817 = i816 ^ (i816 << 13);
                    int i818 = i817 >>> 17;
                    int i819 = ((~i817) & i818) | ((~i818) & i817);
                    int i820 = i819 << 5;
                    ((int[]) objArr3[1])[0] = (i819 | i820) & (~(i819 & i820));
                } else {
                    int i821 = 16;
                    int i822 = -View.MeasureSpec.makeMeasureSpec(0, 0);
                    Object[] objArr195 = new Object[1];
                    b((char) (((i822 | 47320) << 1) - (i822 ^ 47320)), 1910 - (~(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), 46 - (~(-TextUtils.getOffsetBefore(str6, 0))), objArr195);
                    Object[] objArr196 = {(String) objArr195[0]};
                    Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(267846469);
                    if (objAccessartificialFrame23 == null) {
                        int capsMode3 = 17 - TextUtils.getCapsMode(str6, 0, 0);
                        char bitsPerPixel6 = (char) (ImageFormat.getBitsPerPixel(0) + 24344);
                        int iRed2 = Color.red(0) + 2014;
                        byte[] bArr15 = $$a;
                        Object[] objArr197 = new Object[1];
                        a(bArr15[5], (byte) (-bArr15[7]), bArr15[14], objArr197);
                        objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(capsMode3, bitsPerPixel6, iRed2, -1869462195, false, (String) objArr197[0], new Class[]{String.class});
                    }
                    long jLongValue15 = ((Long) ((Method) objAccessartificialFrame23).invoke(null, objArr196)).longValue();
                    long j90 = -486015280;
                    long j91 = (int) Runtime.getRuntime().totalMemory();
                    long j92 = j91 ^ j20;
                    long j93 = 164;
                    long j94 = jLongValue15 ^ j20;
                    long j95 = (((long) 165) * j90) + (((long) (-163)) * jLongValue15) + (((long) (-328)) * (j90 | ((j92 | jLongValue15) ^ j20))) + ((j90 | j91) * j93) + (j93 * (((jLongValue15 | (j90 | j92)) ^ j20) | (((j90 ^ j20) | j94) ^ j20) | ((j94 | j91) ^ j20))) + ((long) (-825616696));
                    int startUptimeMillis4 = (int) Process.getStartUptimeMillis();
                    int i823 = ~startUptimeMillis4;
                    int i824 = ((int) (j95 >> 32)) & ((-790775146) + (((~(563556431 | i823)) | (~((-2000782843) | startUptimeMillis4))) * 210) + (((~(startUptimeMillis4 | 2010625535)) | (~(i823 | (-553713739)))) * 210));
                    int iUptimeMillis2 = (int) SystemClock.uptimeMillis();
                    int i825 = ((i824 | (((int) j95) & (((1251142178 + (((~((~iUptimeMillis2) | 254082940)) | (-1183143470)) * (-235))) + (((~(254082940 | iUptimeMillis2)) | (-1183143470)) * (-470))) + (((~(iUptimeMillis2 | (-1082195970))) | 153135440) * 235)))) * 263) ^ i;
                    if (i825 != i) {
                        objArr2 = new Object[5];
                        objArr2[1] = new int[1];
                        int[] iArr15 = new int[1];
                        objArr2[3] = iArr15;
                        int i826 = getARTIFICIAL_FRAME_PACKAGE_NAME + 113;
                        artificialFrame = i826 % 128;
                        if (i826 % 2 == 0) {
                            c5 = 4;
                            objArr2[4] = new int[1];
                            i821 = 107;
                        } else {
                            c5 = 4;
                            objArr2[4] = new int[1];
                        }
                        iArr15[0] = i;
                        ((int[]) objArr2[c5])[0] = i825;
                        objArr2[0] = null;
                        objArr2[2] = null;
                        int iMyUid5 = Process.myUid();
                        int i827 = (((((-773208680) + (((~(iMyUid5 | (-20584808))) | (-626033266)) * (-465))) + (((-20584808) | (~((-626033266) | iMyUid5))) * 930)) + ((iMyUid5 | (-17825890)) * 465)) - (~(-(-i821)))) - 1;
                        int i828 = ((i3 | i827) << 1) - (i3 ^ i827);
                        int i829 = (i828 << 13) ^ i828;
                        int i830 = i829 >>> 17;
                        int i831 = ((~i829) & i830) | ((~i830) & i829);
                        ((int[]) objArr2[1])[0] = i831 ^ (i831 << 5);
                    } else {
                        objArr2 = new Object[]{null, new int[]{(i | i) & (~(i & i))}, null, new int[]{i}, new int[]{i}};
                        int i832 = i3 + (-1437154475) + (((~(i29 | (-794681))) | 606243138) * 220) + (((~(i29 | (-4994750))) | 610443207) * (-440)) + ((i | (-794681)) * 220);
                        int i833 = i832 ^ (i832 << 13);
                        int i834 = i833 >>> 17;
                        int i835 = (i833 | i834) & (~(i833 & i834));
                        int i836 = i835 << 5;
                    }
                }
            }
            return objArr3;
        }
        objArr2 = new Object[]{null, new int[]{(i | i) & (~(i & i))}, null, new int[]{i}, new int[]{i17}};
        int i837 = 1016972525 + ((i | 282645234) * 140) + (((~(282645234 | i326)) | 52757509) * (-280)) + (((~(i | (-52757510))) | (~(322803223 | i326)) | 12599520) * 140);
        int i838 = (i3 - (~(((i837 | 16) << 1) - (16 ^ i837)))) - 1;
        int i839 = i838 ^ (i838 << 13);
        int i840 = i839 >>> 17;
        int i841 = (i839 | i840) & (~(i839 & i840));
        int i842 = i841 << 5;
        return objArr2;
    }
}
