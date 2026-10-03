package com.facebook.imagepipeline.producers;

import android.graphics.Color;
import android.os.Process;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import o.ArtificialStackFrames;
import o._CREATION;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes2.dex */
public class EncodedCacheKeyMultiplexProducer extends MultiplexProducer<Pair<CacheKey, ImageRequest.RequestLevel>, EncodedImage> {
    private static long _BOUNDARY;
    private static char[] _CREATION;
    private final CacheKeyFactory mCacheKeyFactory;
    private static final byte[] $$c = {111, -52, 8, -63};
    private static final int $$d = b.f40o;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {33, -82, -25, 84, 2, -17, 5, -47, -11, -22, -1, 3, Ascii.FF, -11, 8, 8, -19, 19, 52, 0, -17, 53, -53, Ascii.CR, 1};
    private static final int $$b = 25;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(short r6, short r7, int r8) {
        /*
            byte[] r0 = com.facebook.imagepipeline.producers.EncodedCacheKeyMultiplexProducer.$$c
            int r8 = 106 - r8
            int r7 = r7 * 4
            int r1 = r7 + 1
            int r6 = r6 * 3
            int r6 = 3 - r6
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
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L21
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L21:
            int r6 = r6 + 1
            r4 = r0[r6]
            int r3 = r3 + 1
            r5 = r8
            r8 = r6
            r6 = r4
            r4 = r3
            r3 = r5
        L2c:
            int r6 = r6 + r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r5
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.EncodedCacheKeyMultiplexProducer.$$e(short, short, int):java.lang.String");
    }

    private static void b(byte b, int i, int i2, Object[] objArr) {
        byte[] bArr = $$a;
        int i3 = 115 - i;
        int i4 = i2 + 4;
        byte[] bArr2 = new byte[4 - b];
        int i5 = 3 - b;
        int i6 = -1;
        if (bArr == null) {
            i3 = (i5 + (-i4)) - 2;
            i4 = i4;
            i6 = -1;
        }
        while (true) {
            int i7 = i6 + 1;
            int i8 = i4 + 1;
            bArr2[i7] = (byte) i3;
            if (i7 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            } else {
                i3 = (i3 + (-bArr[i8])) - 2;
                i4 = i8;
                i6 = i7;
            }
        }
    }

    public EncodedCacheKeyMultiplexProducer(CacheKeyFactory cacheKeyFactory, boolean z, Producer producer) {
        super(producer, "EncodedCacheKeyMultiplexProducer", "multiplex_enc_cnt", z);
        this.mCacheKeyFactory = cacheKeyFactory;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    public Pair<CacheKey, ImageRequest.RequestLevel> getKey(ProducerContext producerContext) {
        return Pair.create(this.mCacheKeyFactory.getEncodedCacheKey(producerContext.getImageRequest(), producerContext.getCallerContext()), producerContext.getLowestPermittedRequestLevel());
    }

    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    @Nullable
    public EncodedImage cloneOrNull(@Nullable EncodedImage encodedImage) {
        return EncodedImage.cloneOrNull(encodedImage);
    }

    private static void a(char c, int i, int i2, Object[] objArr) throws Throwable {
        int i3 = 2;
        int i4 = 2 % 2;
        _CREATION _creation = new _CREATION();
        long[] jArr = new long[i2];
        _creation.b = 0;
        while (_creation.b < i2) {
            int i5 = $10 + 15;
            $11 = i5 % 128;
            int i6 = i5 % i3;
            int i7 = _creation.b;
            try {
                Object[] objArr2 = {Integer.valueOf(_CREATION[i + i7])};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) 0;
                    byte b2 = b;
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.getSize(0) + 8, (char) (9279 - View.resolveSizeAndState(0, 0, 0)), (Process.myTid() >> 22) + 1977, 1113883676, false, $$e(b, b2, (byte) (b2 + 2)), new Class[]{Integer.TYPE});
                }
                Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i7), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                if (objAccessartificialFrame2 == null) {
                    byte b3 = (byte) 0;
                    byte b4 = b3;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(30 - Color.green(0), (char) (49362 - KeyEvent.getDeadChar(0, 0)), View.MeasureSpec.getMode(0) + 684, -115095555, false, $$e(b3, b4, b4), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                }
                jArr[i7] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                Object[] objArr4 = {_creation, _creation};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) 0;
                    byte b6 = b5;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getPressedStateDuration() >> 16) + 25, (char) (30068 - (ViewConfiguration.getScrollBarSize() >> 8)), KeyEvent.normalizeMetaState(0) + 816, 1897803493, false, $$e(b5, b6, (byte) (b6 + 3)), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                int i8 = $11 + 41;
                $10 = i8 % 128;
                int i9 = i8 % 2;
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
        while (_creation.b < i2) {
            int i10 = $10 + 63;
            $11 = i10 % 128;
            int i11 = i10 % 2;
            cArr[_creation.b] = (char) jArr[_creation.b];
            try {
                Object[] objArr5 = {_creation, _creation};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-293902099);
                if (objAccessartificialFrame4 == null) {
                    byte b7 = (byte) 0;
                    byte b8 = b7;
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(25 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) (30068 - ExpandableListView.getPackedPositionType(0L)), (ViewConfiguration.getJumpTapTimeout() >> 16) + 816, 1897803493, false, $$e(b7, b8, (byte) (b8 + 3)), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
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
        ByteBuffer.wrap("\u0098Vz:\\R>z\u0010ÊòÝÔü·\u0004\u0089%k@M\u0096/§\u0001ÅãÝÆ:ØTºm\u009c\u009c~¢Pï3\u0006\u0015\u0015÷PÉ\u0088«°\u008dÕoêî\u0018\ft*\u001cH4f\u0084\u0084\u0093¢²ÁJÿk\u001d\u000e;ØYéw\u008b\u0095\u0093°e®\u0017Ì7êÅ\bÖ&¶EKcv\u0081\u000e¿ÂÝûÿ^\u001d2;ZYrwÂ\u0095Õ³ôÐ\fî-\fH*\u009eH¯fÍ\u0084Õ¡ ¿AÝoû\u0085x-\u009aV¼5Þ\u0004ð±\u0012¬4\u0087WwiO\u008b1\u00adáÏ\u0080á±\u0003\u0096&L8/Z\u0014|ü\u009eÏ°\u008fÓQõS\u00179)÷KÞm¨\u008f\u0086¢f\u0019Ñû¼ÝÄ¿è\u0091MsYUs6Á\b¶êÓÌ\u0017®#\u0019Ñû¼ÝÄ¿è\u0091MsNU}6\u0082\bèêÑÌ\n®<\u0080Z\u0019ÑûªÝÔ¿è\u0091\u0003sOUp6À\b\u0094êçÌ5®<\u0080\\b`G\u0098YÖ;ú\u001d\bù \u001bÌ= _\u008eqr\u0093cµKÖýèÇ\n¥,`NL`=\u0082\u001b\u0019\u008cû¶Ý\u009e¿é\u0091\rsRU`6Á\b´êÄÌ\u001c®!\u0080EblG¸Yè;à\u001d\fÿ4ÑD²\u0096\u0094£v×HN\u0019\u008cû¶Ý\u009e¿é\u0091\rsRU`6Á\b´êÄÌ\u001c®!\u0080EblG¸Yè;à\u001d\fÿ4ÑD²\u0096\u0094£v×HM\u0019ÑûªÝÉ¿ø\u0091\u0016sXUy6À\bªêÈÌ\u001a®|\u0080FblG¾YÙ;ì\u001dGÿ3Ñt¨\nJ&lA\u000es \u009bÂÓn¿\u008c\u0085\u0019ÑûªÝÉ¿ø\u0091\u0016sXUy6À\b¤êÈÌ\u0016®|\u0080Db`G±YÂ;Ø\u001d$ÿmÑu²\u0097\u0094 vÑHR*5\f^îfÃ\u0097¥È\u0087ú\u0099\u0000®kL\u0010js\bB&¬ÄââÃ\u0081z¿\u001e]r{¬\u0019Æ7þÕÚð\u000bîx\u008cbª\u009eH×fÑ\u0005:#\u0018Ánq]\u0093&µE×tù\u009a\u001bÔ=õ^L`&\u0082D¤\u0096ÆðèÊ\nà/21USgu\u0088\u0097¹¹ÁÚ3ü1\u001eZ \u009cBªd\u0093\u0086÷«\u0000(\u009cÊðì\u0098\u008e° \u0000B\u001ed<\u0007Ï9þÛ\u008bý@\u009f{±\u0014S<\u0019\u008cû¶Ý\u009e¿é\u0091\u0017sTUx6\u008b\bèêÉÌ\u0017® \u0080^\u0019\u0090û¼ÝÑ¿ø\u0091\u0007s\u0013Uz6\u008a\b²\u0019Ñû©ÝÂ¿ä\u0091\u0001s\u0012Ur6\u0086\bªêÄÌ\u000b®*\u0080YbqG¹YÚ;ý\u0019\u0090û¼ÝÝ¿þ\u0091\u0011s[\u0082\"`\u0018F0$U\n¾èüÎÞ\u00ad4\u0093\u000bq{Wø5\u0090\u001båùÅÜ\u0007Â\u007f A\u0086¤d\u009aJÀ).\u000f\u0006íxH&ª\u0003\u008caîM\u0019\u008eû¼ÝÂ¿ø\u0091\u000bsNU`6Á\bµêØÌ\u000b®}\u0080HbaGòYÓ;ë\u001d\u000bÿ5Ñ|²Ü\u0094ªvÔH\n*x\fWîiÃ\u0088¥ß\u0087Ê\u0099\u000b{7]k>¦\u0010¢òÎÔì¶9\u0088Qj}O\u0083!³\u0019\u008eû¼ÝÂ¿ø\u0091\u000bsNU`6Á\bµêØÌ\u000b®}\u0080HbaGòYÓ;ë\u001d\u000bÿ5Ñ|²Ü\u0094ªvÔH\n*x\fWîiÃ\u0088¥ß\u0087Ê\u0099\u000b{7]k>¦\u0010¦òÎÔì¶9\u0088[j}dq\u0086C =Â\u0007ìô\u000e±(\u009fK>uJ\u0097'±ôÓ\u0082ý·\u001f\u009e:\r$,F\u0014`ô\u0082Ê¬\u0083Ï#é@\u000b45®WÊq¿\u0093\u009e\u0019\u008eû¼ÝÂ¿ø\u0091\u000bsNU`6Á\bµêØÌ\u000b®}\u0080HbaGòYÓ;ë\u001d\u000bÿ5Ñ|²Ü\u0094¿vËHQ*:\fPîk¯ÔMæk\u0098\t¢'QÅ\u0014ã:\u0080\u009b¾ï\\\u0082zQ\u0018'6\u0012Ô;ñ¨ï\u0089\u008d±«QIog&\u0004\u0086\"åÀ\u0091þ\u000b\u009caº\bX1\u0019\u008eû¼ÝÂ¿ø\u0091\u000bsNU`6Á\bµêØÌ\u000b®}\u0080HbaGòYÓ;ë\u001d\u000bÿ5Ñ|²Ü\u0094¿vËHQ*;\f_îk\u0019\u0088û»Ýß¿ó\u0091\u0011s[*+ÈSî8\u008c\u001e¢û@èf\u0083\u0005z;XÙ.ÿî\u009dÌ³£\u0019\u0088û»Ýß¿ó\u0091\u0005sHUq6\u009c\b²\u0019¹û¼ÝÞ¿ò\u0091\u000fsRU`6\u0086\b©êÏXÓºï\u009c\u0083þ½ÐU2\u0012\u0014\"\u0019\u009dû±ÝÂ¿ä\u0091\u000fsTUa6\u0082àf\u0002\\$tF\u0011hú\u008a¸¬\u009aÏpñO\u0013?5¼WÝy¥\u009b\u0099¾_ >Â\u0001¸UZf|\u0002\u001e.0\u0087ÒÖô¹\u0019\u0099û¼ÝÞ¿î\u0091\u0010sTUw\u0019\u0099û¼ÝÞ¿î\u0091\u0010sTUw6°\b¾ê\u0099ÌNþA\u001cd:\u0006X6vÈ\u0094\u008c²¯Ñhïf\rA+\u0096IÔgÄ\u0085é\u009fX}b[J9/\u0017Äõ\u0086Ó¤°N\u008eql\u0001J\u0082(ê\u0006\u0091äµÁmß\u000fcH\u0081x§\u001eÕ\u00877¨\u0011Ùsû]\u001f¿U\u0099gú\u0081\u0080\u008bb\u009dDô&\u009f\b\u0004ê|ÌN¯¯\u0091\u009bsøU)7G\u0019xû^Þ\u009aÀ£¢ù\u00845f\u0006H@+«\r\u009c\u008fÁmÉKª)\u0087\u0007så*Ã\u000e ±\u009eë|\u009bZM8\r\u00166ô\u000eÑËÏ¥\u00ad\u0084\u008b7iXG\n$þ\u0002\u0093à¢Þ9¼\u001e\u0019¿û·ÝÔ¿ù\u0091\rsTUp6Ï\b\u0095êåÌ3®s\u0080HbpGµYÛ;ú\u001dIÿ&Ñt²\u0080\u0094ívÜHG*`\fnî>Ã×w3\u0095\t³!Ñ\\ÿ¼\u001dð;ÏX'f\u0018\u0084l¢¢\u0019\u0099û¶ÝÜ¿ï\u0091\u0004sTUg6\u0087J\u0015¨&\u008eBìnÂÇ \u0096´ÿVËp\u00ad\u0012\u009b<yÞ;èÛ\ná,ÉN¬`G\u0082\u0005¤'ÇÍùò\u001b\u0082=\u0001_fq\u000f\u00933¶å¨\u0084\u0019\u008cû¶Ý\u009e¿à\u0091\u0007sOUz6\u008a\bªê\u008fÌ\t®6\u0080GbpÆ\u007fX6º\f\u009c$þBÐ½2ä\u0014Ûw'I\u0019G@\u0099\u001f{%]\r?z\u0011\u0084óÇÕë¶\u0018\u0088{jBL\u0099.¯\u0000ÝâãÇ,ÙP\u00127ð\u0003Ös´H\u009a\u0092xê^\u0083=v\u0019\u008cû¶Ý\u009e¿é\u0091\u0017sTUx6\u008b\bèêÇÌ\u0011®=\u0080Mb`G®YÇ;ü\u001d\u0000ÿ.Ñoâ\u0089\u0000¬&ÎDþj\u0000\u0088D®gÍÐó¥\u0011Õ7\u0003Ul{]\u0099p¼¢¢ÂÀìæ\u0010\u00043ÄÈ&í\u0000\u008fb¿LA®\u0005\u0088&ëáÕï7È\u0011\u001fs-]\b¿0\u009aæ\u0084¹æ§À\u0000\"'\feoÄIù«\u009b\u0095K÷uÑ\t3:\u001eíx\u0093ZüD\u000b\u0019\u0099û¼ÝÞ¿î\u0091\u0010sTUw6À\b¡êÎÌ\u0017®4\u0080Fb`G\u0083YÄ;ê\u001d\u0002ÿoÑ|²\u0097\u0094£vÁH\r*?\fR£uAPg2\u0005\u0002+üÉ¸ï\u009b\u008c,²\\P/vû\u0014Ç:þØßý@ãt\u0081\u0014§çEÃk\u008f\b&.\u0017Ì8/ Í\u000fëf\u0089U§·Eác\u0082\u0000%>\u001bÜsú\u009e\u0098\u008d¶ãTÔq\no`\rR+\u008fÉ\u0081ç\u009a\u0084}¢[@z~£\u001c\u0081:íØÃõ3\u0093`±s¯\u00adMÆk\u0091\u0019\u008cû¶Ý\u009e¿é\u0091\rsRU`6\u0083\b©êÀÌ\u001c®6\u0080X\u0019\u008cû¶Ý\u009e¿é\u0091\rsRU`6\u0086\b«êÀÌ\u001f®6\u0080\u0004bgG©YÞ;â\u001d\rÿnÑ}²\u009b\u0094£vÃH\u001a*$\fAîzÃ\u008a¥Ô\u0087á\u0019¿û·ÝÔ¿ù\u0091\rsTUp6Â\b¾ê\u0099ÌN¢ç@Ýfõ\u0004\u0082*|È?î\u0013\u008dà³\u0083Q®wz\u0015K;1Ù\u0002üÖâ¥\u0080Ë¦kDO\u0019\u008aû¼ÝÃ¿ÿ\u0091O\u0019úûÚÝ´¿\u0092\u0091!s#U\u000f6á\b\u0085ê½Ìp®S\u00802bEGÁY¨;\u008c\u001dtÿ^\u0019\u008fû¼ÝÝ¿þ\u0091LsUUc6Á\b«êÀÌ\u0011®=\u0080Ab`G¥YÄïi\rZ+;I\u0018gª\u0085¨£\u0094À'þF\u001c&:õXÐv\u0093\u0094\u0080±[¯<Í\rëý\tÇ\u0019\u008fû¼ÝÝ¿þ\u0091LsNUr6Á\bªêÂÌ\u001c®\f\u0080Nb`G²YÄ;ç\u001d\u001dÿ9\u0019\u008cû¶Ý\u009e¿à\u0091\u0007sOUz6\u008a\bªê\u008fÌ\u0019®=\u0080NbwG³YÞ;ê\u001dGÿ1Ñ~²\u009f\u0094¸vÀ\u0019\u008cû¶Ý\u009e¿é\u0091\rsRU`6Á\b·êÄÌ\u0015®&\u0080\u0004bdGªYÓ;Ñ\u001d\u0007ÿ!Ñv²\u0097\u0019\u008cû¶Ý\u009e¿ä\u0091\u0006sPU:6\u008d\b³êÈÌ\u0014®7\u0080\u0004bcGµYÙ;é\u001d\fÿ2Ñk²\u0080\u0094¤vÊH\u000bÑ=3\u0007\u0015/wJY¡»ã\u009dÁþ+À\u0014\"d\u0004çf\u0080HîªÝ\u008f\u0001\u0091bó\u0011Õ¾7\u0098\u0019Äz$\\\u0019¾g\u0080¾â\u0095Äé&×\u000b&\u0019\u008cû¶Ý\u009e¿ø\u0091\u001bsNU`6\u008a\b«ê\u008fÌ\u001a®&\u0080CbiG¸Y\u0099;è\u001d\u0000ÿ.Ñ|²\u0097\u0094¿vÔH\r*?\f_î|\u0019\u008cû¶Ý\u009e¿ø\u0091\u001bsNU`6\u008a\b«êþÌ\u001d®+\u0080^b+G¾YÂ;ç\u001d\u0005ÿ$Ñ5²\u0094\u0094¤vÊH\u0018*3\fCîxÃ\u0091¥Ó\u0087û\u0099\u0018\u0019\u008cû¶Ý\u009e¿ý\u0091\u0007sSUp6\u0080\b´ê\u008fÌ\u001a®&\u0080CbiG¸Y\u0099;è\u001d\u0000ÿ.Ñ|²\u0097\u0094¿vÔH\r*?\f_î|ïZ\r`+HI+gÑ\u0085\u0085£¦ÀVþb\u001c(:ÊXév\u0097\u0094¾±$¯\u0003Í-ëÖ\tú'©D\nb}\u0080\u001b¾ÇÜçú\u0082\u0018¬5ES\u001eq*oÔ\u008dåÖU\u0019Ñû½ÝÕ¿ý\u0091MsLUq6\u0082\b³êþÌ\b®:\u0080Zb`t\\\u00960°XÒpüÀ\u001eÃ8ö[\u0001e \u0087I¡\u0081ÃñíÅ\u000fé*\"4_Vap\u0085\u0092£¼òß ù'\u001bL%\u009cG¢aØµÉW¥qÍ\u0013å=UßVùc\u009a\u0094¤µFÜ`\u0014\u0002d,UÎxëªõÖ\u0097ò\u0019Ñû½ÝÕ¿ý\u0091MsNU{6\u008c\b\u00adêÄÌ\f®|\u0080[b`G±YÂ;ê\u0019ÑûªÝÉ¿ø\u0091MsLUq6\u0082\b³êþÌ\f®!\u0080KbfG¹\u0019ÑûªÝÉ¿ø\u0091\u0016sXUy6À\bªêÈÌ\u001a®|\u0080FblG¾YÔ;Ñ\u001d\u0004ÿ!Ñw²\u009e\u0094¢vÇH *2\fTîjÃ\u0096¥Ý\u0087Ê\u0099\u001d{\"]s>\u008c\u0010þòØÔí\u0019Ñû½ÝÕ¿ý\u0091Ms_Ug6\u009b\b\u0099êÆÌ\b® \u0019Ñû½ÝÕ¿ý\u0091Ms_Ug6\u009b\b\u0099êÕÌ\u0011®>\u0080O\u0019Ñû½ÝÕ¿ý\u0091MsNU{6\u008c\b\u00adêÄÌ\f®|\u0080HbvG¨YÑ;á\u001d\u0005ÿ$Ñ~²\u0080\u0094©\u0019ÑûªÝÉ¿ø\u0091\u0016sXUy6À\bªêÈÌ\u001a®|\u0080FblG¾YÕ;ý\u001d\u001dÿ&Ñt²\u009e\u0094©vÁH\r*\t\f[îfÃ\u008a¥\u0094\u0087æ\u0099\u000323Ð_ö7\u0094\u001fº¯X½~\u0085\u001dy#EÁ çù\u0085Ô\u0019Ñû½ÝÕ¿ý\u0091Ms_Ug6\u009b\b¡êØÌ\n®<\u0019Ñû½ÝÕ¿ý\u0091Ms_Ug6\u009b\b«êÄÌ\u001f®=>àÜ\u008cúä\u0098Ì¶|TnrV\u0011ª/\u0098Íâë \u0089\u0007æÍ\u0004¡\"É@ánQ\u008cCª{É\u0087÷¬\u0015Ð3\u0017Q(ö\u0096\u0014ú2\u0092Pº~\n\u009c\u0018º ÙÜçñ\u0005\u0081#^A}o\u001d\u008d!{\u001d\u0099q¿\u0019Ý1ó\u0081\u0011\u00937«TWjU\u0088\u0004®ÙÌú\u0019Ñû½ÝÑ¿ÿ\u0091\u0003s\u0012Up6\u0080\b±êÏÌ\u0014®<\u0080KbaG¯Y\u0098; \u001d\u0011ÿ\"Ñ4²\u0090\u0094¾vÐH\u0014/\u000eÍkë\u0001\u0089 §\u0092E\u0095c¢\u0000^>}Ü\u0011úÐ\u0098ÿ¶ÚT\u0098qpo\u001c\r\u0002+ÞÉþç¶\u0084H¢v@=~Ï\u001cå:\u008aØ²õNéü\u000b\u0084-ïOÉa,\u0083?¥PÆ\u00adø\u009b\u001aã<'^\npt\u009fp}\u0001[h9\u0015\u0017æµ\u0013Wkq\u0000\u0013&=ÃßÐù¥\u009aH¤hF\u0005`\u0095\u0002ü,\u0089Î·ëm}º\u009f\u0088¹òÛÄõ-\u0017q1TRâl\u0082\u008eí¨7Ê\u0014äo\u0006O#\u008c=ü_\u0083y9\u009b\f\u0019\u0092û°ÝÒ¿Ì\u0091.sxUG6°\b¤êÒÌ\f®}\u0080Ybj\u0019Ñû¼ÝÄ¿è\u0091MsPUq6\u008b\b¯êÀÌ'®0\u0080EbaG¹YÔ;ý\u001dGÿ8Ñv²\u009e¡ECle\u001c\u00077)ÈË\u0090í¬\u008eU°tR\u000bk\u0099\u0089ô¯\u008cÍ ã\u0005\u0001\u0018'3DÒzà\u0098\u009d¾C\u0019Ñû½ÝÑ¿ÿ\u0091\u0003s\u0012Up6\u0080\b±êÏÌ\u0014®<\u0080KbaG¯Y\u0098; \u001d\rÿ0Ñ4²\u0093\u0094½vÔH\f*x\fIîeÃ\u008f\u001emü\u0015Ú~¸X\u0096½t®RË1#\u000f\u000fítËª©\u0089\u0087ù4ÓÖÜð¶\u0092\u0085¼n^>x\r\u001bíÃ]!1\u0007]esK\u008f©\u009e\u008fõì\nÒ90N\u0016Ût¯ZÔ¸æ\u009d6\u0083RánÇ\u0080%¿\u000b¸h\u001dN4¬Z\u0092ÜðêÖ\u00924ç\u0019\u0000\u007f[]7C\u008d¡¢\u0087ñä\u0007Ê3(Q\u000egl£RÌ°\u00ad\u0095\u0007û(Ùy?\u008a\u001d¯\u0003Ä`\u0015".getBytes(CharEncoding.ISO_8859_1)).asCharBuffer().get(cArr, 0, 1959);
        _CREATION = cArr;
        _BOUNDARY = -7562338783446500391L;
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(Unknown Source)
        	at java.base/java.util.TreeMap.lastKey(Unknown Source)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r83, int r84, int r85, int r86) {
        /*
            Method dump skipped, instruction units count: 15364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.EncodedCacheKeyMultiplexProducer.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
    }
}
