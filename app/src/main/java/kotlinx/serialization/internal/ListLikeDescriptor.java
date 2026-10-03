package kotlinx.serialization.internal;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import ch.qos.logback.core.CoreConstants;
import com.google.common.base.Ascii;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import o.ArtificialStackFrames;
import o._CREATION;
import org.apache.commons.lang3.CharEncoding;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
@ExperimentalSerializationApi
public abstract class ListLikeDescriptor implements SerialDescriptor {
    private static long _BOUNDARY;
    private static char[] _CREATION;
    private final SerialDescriptor elementDescriptor;
    private final int elementsCount;
    private static final byte[] $$c = {4, -24, -50, 10};
    private static final int $$d = 140;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {92, 127, 52, -8, 52, -47, -11, -17, 5, 8, -19, 19, 53, 2, 0, -17, -53, Ascii.CR, 1, -22, -1, 3, Ascii.FF, -11, 8};
    private static final int $$b = 124;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x0028). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(short r6, int r7, short r8) {
        /*
            int r6 = r6 * 2
            int r6 = r6 + 4
            int r7 = r7 * 4
            int r7 = r7 + 1
            byte[] r0 = kotlinx.serialization.internal.ListLikeDescriptor.$$c
            int r8 = 106 - r8
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L15
            r8 = r6
            r4 = r7
            r3 = r2
            goto L28
        L15:
            r3 = r2
            r5 = r8
            r8 = r6
            r6 = r5
        L19:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r7) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L26:
            r4 = r0[r8]
        L28:
            int r4 = -r4
            int r6 = r6 + r4
            int r8 = r8 + 1
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.ListLikeDescriptor.$$e(short, int, short):java.lang.String");
    }

    public /* synthetic */ ListLikeDescriptor(SerialDescriptor serialDescriptor, DefaultConstructorMarker defaultConstructorMarker) {
        this(serialDescriptor);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0020  */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0020 -> B:11:0x0028). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0020
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(int r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 + 4
            byte[] r0 = kotlinx.serialization.internal.ListLikeDescriptor.$$a
            int r1 = 4 - r7
            int r6 = 115 - r6
            byte[] r1 = new byte[r1]
            int r7 = 3 - r7
            r2 = 0
            if (r0 != 0) goto L12
            r3 = r8
            r4 = r2
            goto L28
        L12:
            r3 = r2
        L13:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L20
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L20:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r3
            r3 = r8
            r8 = r4
            r4 = r5
        L28:
            int r8 = -r8
            int r3 = r3 + 1
            int r6 = r6 + r8
            int r6 = r6 + (-2)
            r8 = r3
            r3 = r4
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.ListLikeDescriptor.a(int, int, byte, java.lang.Object[]):void");
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List<Annotation> getAnnotations() {
        return SerialDescriptor.DefaultImpls.getAnnotations(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return SerialDescriptor.DefaultImpls.isInline(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isNullable() {
        return SerialDescriptor.DefaultImpls.isNullable(this);
    }

    private ListLikeDescriptor(SerialDescriptor serialDescriptor) {
        this.elementDescriptor = serialDescriptor;
        this.elementsCount = 1;
    }

    public final SerialDescriptor getElementDescriptor() {
        return this.elementDescriptor;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialKind getKind() {
        return StructureKind.LIST.INSTANCE;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int getElementsCount() {
        return this.elementsCount;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String getElementName(int i) {
        return String.valueOf(i);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int getElementIndex(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(name);
        if (intOrNull != null) {
            return intOrNull.intValue();
        }
        throw new IllegalArgumentException(name + " is not a valid list index");
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isElementOptional(int i) {
        if (i >= 0) {
            return false;
        }
        throw new IllegalArgumentException(("Illegal index " + i + ", " + getSerialName() + " expects only non-negative indices").toString());
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List<Annotation> getElementAnnotations(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(("Illegal index " + i + ", " + getSerialName() + " expects only non-negative indices").toString());
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor getElementDescriptor(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(("Illegal index " + i + ", " + getSerialName() + " expects only non-negative indices").toString());
        }
        return this.elementDescriptor;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ListLikeDescriptor)) {
            return false;
        }
        ListLikeDescriptor listLikeDescriptor = (ListLikeDescriptor) obj;
        return Intrinsics.areEqual(this.elementDescriptor, listLikeDescriptor.elementDescriptor) && Intrinsics.areEqual(getSerialName(), listLikeDescriptor.getSerialName());
    }

    public int hashCode() {
        return (this.elementDescriptor.hashCode() * 31) + getSerialName().hashCode();
    }

    public String toString() {
        return getSerialName() + CoreConstants.LEFT_PARENTHESIS_CHAR + this.elementDescriptor + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    private static void b(char c, int i, int i2, Object[] objArr) throws Throwable {
        int i3 = 2 % 2;
        _CREATION _creation = new _CREATION();
        long[] jArr = new long[i2];
        _creation.b = 0;
        int i4 = $11 + 95;
        $10 = i4 % 128;
        int i5 = i4 % 2;
        while (_creation.b < i2) {
            int i6 = $10 + 47;
            $11 = i6 % 128;
            int i7 = i6 % 2;
            int i8 = _creation.b;
            try {
                Object[] objArr2 = {Integer.valueOf(_CREATION[i + i8])};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) 0;
                    byte b2 = b;
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getTapTimeout() >> 16) + 8, (char) (KeyEvent.keyCodeFromString("") + 9279), Color.alpha(0) + 1977, 1113883676, false, $$e(b, b2, (byte) (b2 + 2)), new Class[]{Integer.TYPE});
                }
                Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i8), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                if (objAccessartificialFrame2 == null) {
                    byte b3 = (byte) 0;
                    byte b4 = b3;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(29 - TextUtils.lastIndexOf("", '0', 0, 0), (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 49362), 685 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), -115095555, false, $$e(b3, b4, b4), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                }
                jArr[i8] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                Object[] objArr4 = {_creation, _creation};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) 0;
                    byte b6 = b5;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(26 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) (30068 - Drawable.resolveOpacity(0, 0)), 816 - (ViewConfiguration.getWindowTouchSlop() >> 8), 1897803493, false, $$e(b5, b6, (byte) (b6 + 3)), new Class[]{Object.class, Object.class});
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
            cArr[_creation.b] = (char) jArr[_creation.b];
            Object[] objArr5 = {_creation, _creation};
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-293902099);
            if (objAccessartificialFrame4 == null) {
                byte b7 = (byte) 0;
                byte b8 = b7;
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(KeyEvent.getDeadChar(0, 0) + 25, (char) (ExpandableListView.getPackedPositionType(0L) + 30068), 816 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), 1897803493, false, $$e(b7, b8, (byte) (b8 + 3)), new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame4).invoke(null, objArr5);
            int i9 = $11 + 27;
            $10 = i9 % 128;
            int i10 = i9 % 2;
        }
        objArr[0] = new String(cArr);
    }

    static {
        char[] cArr = new char[1959];
        ByteBuffer.wrap("\u0019ÑvÿÇQW§¤E5`\u0085Ï\u0012Qb²ó\u0015@eÐÚ!*±\u0080\u000e\u0019\u009fqïÊ|9Ì\u0081]òªi:è\u008b#\u001b\u009dhçù@IÙ\u009féðÇAiÑ\u009f\"}³X\u0003÷\u0094iä\u008au-Æ]Vâ§\u00127¸\u00880\u0019Diæú\u0016J\u0083ÛÝ,R¼ý\r\u000b\u009d¡îÚW\u00138=\u0089\u0093\u0019eê\u0087{¢Ë\r\\\u0093,p½×\u000e§\u009e\u0018oèÿB@ÉÑ®¡\u00022ê\u0019ÑvèÇMW¢¤E5j\u0085Ï\u0012Yb£ó\u001f@iÐ\u0086!%±°\u000e\u0014\u009fqïÈ|\"Ì\u0097]éªE:Õ\u008b1\u001b\u0099hòùFIÎ¦ \u0019ÑvþÇ@W²¤E5c\u0085Ç\u0012\u0013b¦ó\u0001@cÐÙ\u0019ÑvþÇ@W²¤E5t\u0085É\u0012Pbøó\u0003@~ÐÆ!2\u0019ÑvèÇPW²¤\u000b5u\u0085Ä\u0012\u0012b\u0084ó5@AÐÆ!4±º\u000e<\u009ftïÚ|*\u0019ÑvÿÇUW¥¤\u000b5(\u0085\u008e\u0012^b¦ó\u0006@eÐÇ!$±°\u0019\u008cvôÇ\u001aW³¤\u00055h\u0085Ô\u0012\u0013b¤ó\u0016@hÐÛ!-±¶\u000e\u001c\u009fJïÀ|.Ì\u0090]Þª~:Ù\u008b#\u001bÜ\u0019\u008cvôÇ\u001aW³¤\u00055h\u0085Ô\u0012\u0013b¤ó\u0016@hÐÛ!-±¶\u000e\u001c\u009fJïÀ|.Ì\u0090]Þª~:Ù\u008b#\u001bß\u0019ÑvèÇMW¢¤\u001e5b\u0085Í\u0012\u0012bºó\u001a@nÐ\u0086!.±¶\u000e\u001a\u009f{ïÌ|eÌ\u0097]î\u0019\u009cvòÇSW¿¤\u00055\u007fÊ«¥Ó\u008eTámPÈÀ'3\u009b¢ç\u0012H\u0085\u0097õ1d\u009f×çG\u0003¶©&?\u0099\u0090\båx}ë\u0083[LÊj=ú\u00ad_\u001c \u008cEÿ`nÉÞW1¨¡\u0005\u0010e\u0083Á\u0019ÑvèÇMW¢¤\u001e5b\u0085Í\u0012\u0012b´ó\u001a@bÐ\u0086!,±º\u000e\u0015\u009f`ïø|\u0006ÌÉ]ñªh:Ø\u008b Ïô Í\u0011h\u0081\u0087r;ãGSèÄ7´\u009f%?\u0096K\u0006£÷\u000bg\u0093Ø?I^9îª\u0003\u001a´\u008bò|rìâ]\u0007Í§¾Ó/(\u009fêp\u00130\u001a_4î\u009a~l\u008d\u008e\u001c¢¬\u000e;\u009bKhÚßi²ù\u0007\bú\u0098`æH\u008908Þ¨w[ÛÊªz\bí\u009d\u009d<\fß¿§/\u001eÞò\b2g\\Ö÷F\u0000µ\u00ad$\u008b\u0094l\u0003ús\u0000\\!3\u001b\u0082¶\u0012NáùpØÀ6W¤'J¶æ\u0005\u008f\u0095 dÁô[KíÚ\u0088ª-\u0019\u0090vþÇYW¤¤\u00195a\u0019\u008cvôÇ\u001aW¡¤\u00185h\u0085Ä\u0012Hbµó\u0007@\"ÐÄ!#±±\u000e\r\u009fsïÏ|(Ì\u0090]ôªh:Ò\u008b\"@Ú/½\u009e\u0019\u000eë\u0003Hl8Ý\u0080Md¾Å/²\u009f\u0012\bÕxcéÌZ¹ÊA;æ«}\u0014\u0090\u0085·õ\rfïÖWG °ò \u0016\u0091æ\u0001^rnã\u0083S\u001b¼ô,Q\u009d\u0016\u000e\u0089~sïí_bÈ 9\u0092©b\u001aÅ\u008b£û)d\u0095Ôg\u0019\u008evþÇFW¢¤\u00035t\u0085Ô\u0012\u0013b¥ó\n@\u007fÐ\u0087! ±»\u000eV\u009fqïË|)Ì\u0091]æª4:Ð\u008b \u001b\u0098h¨ùEIÝ¦26\u0097\u0087Ð\u0014Odµõ+E¤Òâ#T³¤\u0000\u0003\u0091oáï`¯\u000fß¾g.\u0083Ý\"LUüõk2\u001b\u0084\u008a+9^©¦X\u0001È\u009awwæP\u0096ê\u0005\bµ°$ÇÓ\u0015Cäò\u001ebâ\u0011Ä\u0080s0ôþá\u0091\u0091 )°ÍClÒ\u001bb»õ|\u0085Ê\u0014e§\u00107èÆOVÔé9x\u001e\b¤\u009bF+þº\u0089M[ÝªlPü¬\u008f\u0085\u001e-®°xÛ\u0017«¦\u00136÷ÅVT!ä\u0081sF\u0003ð\u0092_!*±Ò@uÐîo\u0003þ$\u008e\u009e\u001d|\u00adÄ<³Ëa[\u0090êjz\u0096\t¾\u0098\u0015(\u008a\u0019\u008evþÇFW¢¤\u00035t\u0085Ô\u0012\u0013b¥ó\n@\u007fÐ\u0087! ±»\u000eV\u009fqïË|)Ì\u0091]æª4:Å\u008b?\u001bÃhëùMIß\u0019\u0088vùÇ[W©¤\u00195ao¡\u0000\u009b±6!ÎÒyCXó½d\"\u0014Â\u0085v6\u0010¦¼WAÆ:©K\u0018é\u0088\u001b{¿êÀZwÍü½\u0010\b]g\u001aÖ¾FLµã$\u008c\u00940\u0003°s]âùê¤\u0085Ú4p¤\u0090W*Æ_vá\u0019\u009dvóÇFW¾¤\u00075n\u0085Õ\u0012PÔ&»^\n°\u009a\u000bi²øÂHnßâ¯\u001f>\u00ad\u008d\u0088\u001dgì\u008d|\u0003Ã»RÜ\"a_\u001f0n\u0081Ì\u0011>âÅs¦ÃG\rjb\rÓ©CG°ë!\u009d\u00910ý`\u0092\u0007#£³M@áÑ\u0097a:ö\u009b\u0086W\u0017²¤Ã\u0019\u0099vþÇZW´¤\u00185n\u0085Ã\u0012bb®óK@:Ðö!t±ëë\u0014\u0084l5\u0082¥9V\u0080Çðw\\àÐ\u0090-\u0001\u009f²º\"\\ÓµC#ü\u0085má\u0019\u008dvÿÇ_«\u0004ÄiuÞå\"\u0016\u0094\u0087ì7P Ð\u0019¿vëÇDWñ¤85r\u0085Î\u0012Ib¿ó\u001e@iÐ\u0089!$±°\u000e\n\u009f5ïí|#Ì\u0096]îªw:Ò\u001eñq»À\u001ePí£K2 \u0082\u008a\u0015SeËôyG\t×Ç&n¶ä\t_\u00987è\u0094{%ËÌZ \u00ad&=Ù\u008cf\u001c\u009boþZ³5ù\u0084\\\u0014¯ç\tvbÆÈQ\u0011!\u0089°;\u0003K\u0093\u0085b,ò¦M\u001dÜu¬Ö?g\u008f\u008e\u001eâédy\u009bÈ$XÙ+¼ºp\n\u0086åaQS>+\u008fÅ\u001ffìÔ}ªÍ\u001bZ\u0095*h»Þ\b¶3²\\ßís}\u009e\u008e'\u001fE¯ø8~Aæ.\u0097\u009f5\u000fÇü<m_^ó1\u0085\u0080%\u0010Íã}r\rO\" Z\u0091´\u0001\u000fò¶cÆÓjDæ4\u001b¥©\u0016\u008c\u0086ew\u009eç\u0010X¸Éß\u0019\u008cvôÇ\u001aWº¤\u000f5u\u0085Î\u0012Xbºó]@}ÐÌ!/±ª\u0019ÏÙ³¶Ë\u0007%\u0097\u009dd0õ[EêÒp¢\u008có\n\u0003\u0082lúÝ\u0014M½¾\u0011/`\u009fÂ\bWxöé\rZpÊÈ;(«¤\u0014\u0015\u0085o\u00890æFWðÇ\u00154\u009d¥×\u00150\u0082£fp\t\b¸æ(OÛãJ\u0092ú0m¥\u001d\u0004\u008cé?\u0099¯;^ÙÎFqöà\u0099\u0090 \u0003Þ³v\"\t\u0019\u0099vþÇZW´¤\u00185n\u0085Ã\u0012\u0012b¥ó\u0017@gÐ\u0086!%±º\u000e\u0016\u009fpïÜ|\"Ì\u0087ãÓ\u008c´=\u0010\u00adþ^RÏ$\u007f\u0089è(\u0098ä\t\u0001ºp*ÌÛ{KñôYe\u0000\u0015\u009c\u008696\u0098§äP7À\u0098qtáÂ\u0092¾\u0003\u0000³\u0095\\LÌÀ}ýîTü5\u0093R\"ö²\u0018A´ÐÂ`o÷¾\u0087\u001d\u0016°¥Ï5bÄ\u0082T\u0016ë\u008bzÊ\nf\u0099\u008c)g¸JOÓßun\u0099þ3\u008dC\u001cì\u0019\u0099vþÇZW´¤\u00185n\u0085Ã\u0012\u0012b ó\u0011@cÐÑ!z±é\u000e\b\u009f:ïØ|)Ì\u008b]ùª\":\u0081\u008b \u0019\u0099vôÇ[W¶¤\u00065b\u0085\u008f\u0012Nb²ó\u0018@SÐÎ!2±·\u000e\u0017\u009f{ïË|\u0014Ì\u009c]¹ª,:\u0098\u008b7\u001b\u0088hèùFIÎ¦06\u0091\u0087Ð\u0014Pdýõh\u0019\u008cvôÇ\u001aW³¤\u00055h\u0085Ô\u0012Qb¹ó\u0012@hÐÌ!0üh\u0093\u0010\"þ²WAáÐ\u008c`0÷°\u0087_\u0016ö¥\u008f5(Ä\u0088TYëéz\u0098\n&\u0099Ë).¸\u0003O\u0097ß=nÓþl\u008d\u0010\u001c·¬*CÔÓxb\u001f²eÝ/l\u008aüy\u000fß\u009e´.\u001e¹ÊÉtX\u0091ëà\u0082\u008eíö\\\u0018Ì±?\u001d®l\u001eÎ\u0089[ùúh\u0015ÛgKØº0*±\u0095\u001b\u0004nt\u0082ç W\u0082ëß\u0084«5\u0012¥ðV\u0012\u0019\u0097võÇ]W¥¤D5t\u0085Ö\u0012^bøó\u0002@iÐÄ!7±ò\u000e\b\u009fgïÁ|;Ì\u0097\u0019\u008fvþÇYW¤¤D5o\u0085×\u0012\u0013b»ó\u0012@eÐÇ!)±º\u000e\u0001\u009ff'åH\u0094ù3iÎ\u009a.\u000b\u001e»¬,y\\ÚÍx~\rî¦\u001fw\u008fÖ0s¡\u0012Ñ¡BSòï\u0091»þÊOmß\u0090,p½@\rò\u009a'ê\u008e{$È\\XÂ©\u00129\u008e\u0086\"\u0017Rgóô\u000bD©\u0006\u0096iîØ\u0000H »\u0015*o\u009aÔ\rB} ìG_wÏÝ><®·\u0011\r\u0080fðÐc\u007fÓ\u008fBþµm%Ø\u0094.\u0019\u008cvôÇ\u001aW³¤\u00055h\u0085Ô\u0012\u0013b§ó\u0016@aÐÜ!l±¾\u000e\u000e\u009fqïñ|%Ì\u0085]ìª\u007f\u0019\u008cvôÇ\u001aW¾¤\u000e5j\u0085\u008e\u0012_b£ó\u001a@`ÐÍ!l±¹\u000e\u0011\u009f{ïÉ|.Ì\u0096]ñªh:Þ\u008b>\u001b\u0099\u0019\u008cvôÇ\u001aW¡¤\u00185h\u0085Ä\u0012Hbµó\u0007@\"ÐË!7±¶\u000e\u0014\u009fqï\u0080|-Ì\u008d]ïª}:Ò\u008b\"\u001b\u009dhôùJIÒ¦-\u0019\u008cvôÇ\u001aW¢¤\u00135t\u0085Ô\u0012Xb»ó]@nÐÜ!+±³\u000e\u001c\u009f;ïÈ|\"Ì\u008a]æª\u007f:Å\u008b \u001b\u009fhïùMIÈ\u0019\u008cvôÇ\u001aW¢¤\u00135t\u0085Ô\u0012Xb»ó,@iÐÑ!6±ñ\u000e\u001a\u009f`ïÇ|'Ì\u0080]¯ª|:Þ\u008b>\u001b\u008ahãùQIÌ¦+6\u009b\u0087á\u0014\\\u0083õì\u008d]cÍÞ>v¯\u0010\u001f½\u0088+øÝi$Ú\u0017J¥»R+Ê\u0094e\u0005Bu±æ[VóÇ\u009f0\u0006 ¼\u0011Y\u0081æò\u0096c4Ó±Ã\b¬p\u001d\u009e\u008d#~\u008bïí_@ÈÖ¸ )¨\u009aì\nAû\u00adk6ÔÒEó5_¦¦\u0016\f\u0087ap°àUQ½Á\u0007²e#Â\u0093J|\u00adì\u0004]bÎÂ¾5ÉÈF\u0005)+\u0098\u0085\bsû\u0091j¢Ú\u0011M\u0084=w¬ø\u001f¨\u008f\u0014~æîn\u0019ÑvÿÇQW§¤E5t\u0085Ï\u0012^b½ó\u0016@xÐ\u0086! ±¾\u000e\u000b\u009fpïÌ|*Ì\u008a]åªE:Ð\u008b5\u001b\u0083hÿùG¥\u0097Ê¹{\u0017ëá\u0018\u0003\u008929\u0089®\u0018ÞûOPü>lÀ\u009dc\rü²P#*S\u008cßï°Á\u0001o\u0091\u0099b{óJCñÔ`¤\u00835(\u0086F\u0016¸ç\rw\u0084È+Y^)ôD\u001f+&\u009a\u0083\nlù\u008bh¸Ø\u000bO\u009e?m®â\u001d¶\u008d\u0015|íìrSÓ\u0019ÑvèÇMW¢¤\u001e5b\u0085Í\u0012\u0012bºó\u001a@nÐ\u0086!.±¶\u000e\u001a\u009fvïñ|&Ì\u0085]íªv:Ø\u008b3\u001b²hâùFIÞ¦,6\u0095\u0087Ð\u0014Yd õ3E\u008eÒº#B³¥Ø±·\u009f\u00061\u0096Çe%ô\u0005D³Ó)£é2t\u0081\u001c\u0011ºWU8{\u0089Õ\u0019#êÁ{áËW\\Í,\r½\u0083\u000eá\u009e@o£\u0019ÑvÿÇQW§¤E5t\u0085Ï\u0012^b½ó\u0016@xÐ\u0086! ±¬\u000e\f\u009fsïÁ|'Ì\u0080]äªh:Ó\u009cpóIBìÒ\u0003!¿°Ã\u0000l\u0097³ç\u001bv»ÅÏU'¤\u008f4\u0017\u008b»\u001aÖj|ù\u009eI#ØO/×¿r\u000e\u0094\u009e>íx|èÌs#\u0091³}\u0002]\u0091ætû\u001bÕª{:\u008dÉoXOèù\u007fc\u000f\u009d\u009e:-E½æ\u0019ÑvÿÇQW§¤E5e\u0085Ó\u0012Ib±ó\n@~ÐÆ¢\u0091Í¿|\u0011ìç\u001f\u0005\u008e%>\u0093©\tÙûHVû+k\u0087´\u009dÛ³j\u001dúë\t\t\u0098)(\u009f¿\u0005Ïõ^Mí)}\u0080cM\fc½Í-;ÞÙOùÿOhÕ\u0018<\u0089\u0082:ãªR\u0096\u0091ù¿H\u0011Øç+\u0005º%\n\u0093\u009d\tíæ|TÏ-_\u0080®r>ü\u0019ÑvÿÇQW§¤E5e\u0085Ó\u0012Ib\u0089ó\u001a@aÐÌHN'`\u0096Ê\u0006:õ\u0094d·Ô[CÍ3>¢\u0082\u0011ÿ\u0081Yp¼à$_\u0094Î¥¾\u001f-¬\u009d\u0019\f1ûçk[Ú»J\u0019±\u009dÞºo\u0016ÿé\f\t\u009d<-\u0085º\u001fÊþ[Pè7x\u0096\u0089!\u0019Ñ¦G7-G±ÔodÉõ¿\u00023\u0092\u009f#Z³ÎÀ¦Q\u000bá\u0095\u000egûÓ\u0094é%Dµ¼F\u000b×*gËðP\u0080¤\u0011\u001e¢|2ßÃ3Dì+ß\u009ap\nÓùr\u0087°è\u008aY'Éß:h«I\u001b²\u008c9üÛmtÞBN¥¿B/Î\u0090j\u008fØà¨Q\u0014Áü2G£)\u0013\u0082\u0084Rôðe]Ö!F\u008c·e'÷\u0098J\t<yÁêyZÊ\u0019\u0092vòÇVW\u0096¤&5B\u0085ó\u0012bb´ó\u0000@xÐ\u0087!1±°\\\u008f3 \u0082\u001e\u0012ìá\u001bp4À\u009bW\u0007'á¶L\u0005\r\u0095\u0094dsôåKCÚ(ª\u00839;\u0089Â\u0018²ï(ÇÇ¨¬\u0019\u001a\u0089ïzBë([\u009aÌ\u0005¼æ-[\u0019ÑvþÇ@W²¤E5j\u0085Ï\u0012Hb¸ó\u0007@\u007fÕ\u000bº%\u000b\u008f\u009b\u007fhÑùòI\u001eÞ\u0088®{?Ç\u008cº\u001c\u001cíù}aÂÑSà#Z°õ\u0000N\u0091tf¡ö\u001dGú×D¤r5\u0081\u0085\u000bjï\u0019ÑvëÇFW¾¤\t5(\u0085Ã\u0012Mb£ó\u001a@bÐÏ!-\u0019¹vôÇXWµ¤\f5n\u0085Ó\u0012U¬BÃlrÆâ6\u0011\u0098\u0080»0^§Ç×6F\u0083õ°eJ\u0094£\u0004#»\u008d*ïZQÉ½y\u0004è=\u001fê\u008fQ>±®QÝ%L\u009füL\u0013¥\u0083\f22¡ÖÑ?@®ð\u001agh\u0096Ô\u00060µ\u0086$çT ËÈ{%ê\u0092\u0019ï\u0089X8Á¨.".getBytes(CharEncoding.ISO_8859_1)).asCharBuffer().get(cArr, 0, 1959);
        _CREATION = cArr;
        _BOUNDARY = 5947874668199573147L;
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
            Method dump skipped, instruction units count: 15409
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.ListLikeDescriptor.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
    }
}
