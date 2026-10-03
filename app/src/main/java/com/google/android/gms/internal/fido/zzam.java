package com.google.android.gms.internal.fido;

import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.common.base.Ascii;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import o.ArtificialStackFrames;
import o._CREATION;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes4.dex */
public final class zzam {
    private static long _BOUNDARY;
    private static char[] _CREATION;
    private static final byte[] $$c = {123, -106, -53, 126};
    private static final int $$d = 131;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {Ascii.SI, -1, -79, -103, -53, -2, 47, Ascii.VT, 53, -13, -1, Ascii.SYN, 1, -3, -12, Ascii.VT, -8, 17, -5, -52, 0, 17};
    private static final int $$b = 107;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0025). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(short r6, int r7, byte r8) {
        /*
            int r7 = r7 + 4
            int r6 = 106 - r6
            int r8 = r8 * 3
            int r8 = 1 - r8
            byte[] r0 = com.google.android.gms.internal.fido.zzam.$$c
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L13
            r3 = r6
            r6 = r8
            r4 = r2
            goto L25
        L13:
            r3 = r2
        L14:
            int r4 = r3 + 1
            byte r5 = (byte) r6
            r1[r3] = r5
            int r7 = r7 + 1
            if (r4 != r8) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L23:
            r3 = r0[r7]
        L25:
            int r6 = r6 + r3
            r3 = r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fido.zzam.$$e(short, int, byte):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0028). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(short r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = 20 - r8
            byte[] r0 = com.google.android.gms.internal.fido.zzam.$$a
            int r1 = r6 + 2
            int r7 = 115 - r7
            byte[] r1 = new byte[r1]
            int r6 = r6 + 1
            r2 = 0
            if (r0 != 0) goto L13
            r4 = r6
            r7 = r8
            r3 = r2
            goto L28
        L13:
            r3 = r2
            r5 = r8
            r8 = r7
            r7 = r5
        L17:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L24:
            int r3 = r3 + 1
            r4 = r0[r7]
        L28:
            int r8 = r8 + r4
            int r8 = r8 + (-2)
            int r7 = r7 + 1
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fido.zzam.a(short, byte, short, java.lang.Object[]):void");
    }

    public static int zza(int i, int i2, String str) {
        String strZza;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            strZza = zzan.zza("%s (%s) must not be negative", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i));
        } else {
            if (i2 < 0) {
                throw new IllegalArgumentException("negative size: " + i2);
            }
            strZza = zzan.zza("%s (%s) must be less than size (%s)", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(strZza);
    }

    public static int zzb(int i, int i2, String str) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(zzf(i, i2, FirebaseAnalytics.Param.INDEX));
        }
        return i;
    }

    public static void zzc(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void zzd(boolean z, String str, char c) {
        if (!z) {
            throw new IllegalArgumentException(zzan.zza(str, Character.valueOf(c)));
        }
    }

    private static String zzf(int i, int i2, String str) {
        if (i < 0) {
            return zzan.zza("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return zzan.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException("negative size: " + i2);
    }

    public static void zze(int i, int i2, int i3) {
        String strZzf;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                strZzf = zzf(i, i3, "start index");
            } else {
                strZzf = (i2 < 0 || i2 > i3) ? zzf(i2, i3, "end index") : zzan.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(strZzf);
        }
    }

    private static void b(char c, int i, int i2, Object[] objArr) throws Throwable {
        int i3 = 2;
        int i4 = 2 % 2;
        _CREATION _creation = new _CREATION();
        long[] jArr = new long[i2];
        _creation.b = 0;
        while (_creation.b < i2) {
            int i5 = $11 + 125;
            $10 = i5 % 128;
            int i6 = i5 % i3;
            int i7 = _creation.b;
            try {
                Object[] objArr2 = {Integer.valueOf(_CREATION[i + i7])};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                if (objAccessartificialFrame == null) {
                    int iResolveSizeAndState = 8 - View.resolveSizeAndState(0, 0, 0);
                    char keyRepeatTimeout = (char) (9279 - (ViewConfiguration.getKeyRepeatTimeout() >> 16));
                    int iKeyCodeFromString = KeyEvent.keyCodeFromString("") + 1977;
                    byte b = (byte) ($$d & 14);
                    byte b2 = (byte) (b - 3);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState, keyRepeatTimeout, iKeyCodeFromString, 1113883676, false, $$e(b, b2, (byte) (b2 + 1)), new Class[]{Integer.TYPE});
                }
                Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i7), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                if (objAccessartificialFrame2 == null) {
                    byte b3 = (byte) 0;
                    byte b4 = (byte) (b3 - 1);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(30 - View.MeasureSpec.getSize(0), (char) (49361 - MotionEvent.axisFromString("")), 684 - (ViewConfiguration.getDoubleTapTimeout() >> 16), -115095555, false, $$e(b3, b4, (byte) (b4 + 1)), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                }
                jArr[i7] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                Object[] objArr4 = {_creation, _creation};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                if (objAccessartificialFrame3 == null) {
                    int threadPriority = ((Process.getThreadPriority(0) + 20) >> 6) + 25;
                    char pressedStateDuration = (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 30068);
                    int iIndexOf = TextUtils.indexOf("", "", 0) + 816;
                    byte b5 = (byte) ($$d & 15);
                    byte b6 = (byte) (b5 - 4);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(threadPriority, pressedStateDuration, iIndexOf, 1897803493, false, $$e(b5, b6, (byte) (b6 + 1)), new Class[]{Object.class, Object.class});
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
        while (_creation.b < i2) {
            int i8 = $11 + 123;
            $10 = i8 % 128;
            int i9 = i8 % 2;
            cArr[_creation.b] = (char) jArr[_creation.b];
            Object[] objArr5 = {_creation, _creation};
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-293902099);
            if (objAccessartificialFrame4 == null) {
                int iCombineMeasuredStates = 25 - View.combineMeasuredStates(0, 0);
                char c2 = (char) (30069 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
                int i10 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 815;
                byte b7 = (byte) ($$d & 15);
                byte b8 = (byte) (b7 - 4);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates, c2, i10, 1897803493, false, $$e(b7, b8, (byte) (b8 + 1)), new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame4).invoke(null, objArr5);
        }
        objArr[0] = new String(cArr);
    }

    static {
        char[] cArr = new char[1959];
        ByteBuffer.wrap("\u0019Ñ\u000fØ5\u001f[N@ÙvÓ\u009c\u001d\u0082\\«\u008aÑÊÇ\u0003í[\u0012\u008e8û.\u0003TD}ºcî\u0089?¿k¤¥ÊËð!æ`\u000f¯5ï[/2m$d\u001e£pòke]o·¡©à\u00806úvì¿Æç92\u0013G\u0005®\u007fõV\u0012HE¢¹\u0094À\u008f\u001aáZÛ\u008dÍØ$\u0016\u0019Ñ\u000fØ5\u001f[N@ÙvÓ\u009c\u001d\u0082\\«\u008aÑÊÇ\u0003í[\u0012\u008e8û.\u0011TY}°cÿ\u0019Ñ\u000fÏ5\u0003[K@ÙvÙ\u009c\u001d\u0082T«\u009bÑÀÇ\u000fí\u0007\u0012\u00818Ë.\u000eTD}¸cõ\u0089)¿p¤\u0089Êöð3æd\u000fº5é[8Aq\u008bø\u009dð§'ÉrÒðäù\u000e<\u001079·C÷U,\u007fq\u0019Ñ\u000fÙ5\u000e[[@ÙvÇ\u009c\u001b\u0082]«ÀÑÜÇ\u0018íG\u0012\u0096\u0019Ñ\u000fÏ5\u001e[[@\u0097vÆ\u009c\u0016\u0082\u001f«¼ÑêÇ'íG\u0012\u00908Á.&TA}ªcý\u0019Ñ\u000fØ5\u001b[L@\u0097v\u009b\u009c\\\u0082S«\u009eÑÙÇ\u0003íF\u0012\u00808Ë±\u008c§Ó\u009dTóZè\u0099ÞÛ4\u0006*\u001e\u0003\u009cyÉo\u000eEZº\u0089\u0090Í\u0086\u0006ü\u007fÕ°Ëù!.\u0017G\f²búX!N!\u0019\u008c\u000fÓ5T[Z@\u0099vÛ\u009c\u0006\u0082\u001e«\u009cÑÉÇ\u000eíZ\u0012\u00898Í.\u0006T\u007f}°cù\u0089.¿G¤²Êúð!æ\"k¶}¨Gd),2å\u0004¶îxðxÙå£¢µo\u009f``íJª\\g&)\u000fÛ\u0011ÕûNÍ\u0010?o)&\u0013î}¥fjP?J¥\\»fw\b?\u0013ö%¥ÏkÑkøø\u0082±\u0094p¾sAükµ}{\u0007!.ü0¥Ú\u0003ì\u0002÷Ç\u0099\u008d£SµI\\Ùf\u0097\bP\u0012\b%ÀÏ\u009fÑZ\u0019Ñ\u000fÏ5\u0003[K@\u0082vÑ\u009c\u001f\u0082\u001f«\u008cÑÅÇ\u0004í\u0007\u0012\u00888Á.\u000fTU}\u0088cÑ\u0089w¿h¤¤Êûð\":à,þ\u00162xzc³Uà¿.¡.\u0088³òôä9Î61»\u001bü\r1w\u007f^\u008a@Àª\u001e\u009c\u007f\u0087ªéÕÓ\u0011ÅN,\u008f\u0016\u0093x\bbV\u0019Ñ\u000fØ5\u001f[N@ÙvÚ\u009c\u0017\u0082]«\u009bÑËÇ\u001fíM\u0012\u00958Ð\u0019\u008c\u000fÓ5T[Z@\u0083vÝ\u009c\u001e\u0082T«ÀÑÄÇ\u0005í[\u0012\u0092\u0019\u0090\u000fÙ5\u001b[K@\u0093v\u009a\u009c\u001c\u0082U«\u009a\u0019Ñ\u000fÌ5\b[W@\u0095v\u009b\u009c\u0014\u0082Y«\u0082ÑÉÇ\u0019íQ\u0012\u00958Ð.\u0007TM}\u00adÁ¾×÷í9\u0083c\u0098«®ü¨E¾\u001a\u0084\u009dê\u0081ñMÇ\u0012-ß3\u008c\u001aD`\u0011v\u008d\\\u008c£N\u0089\u0003\u009fÞå\u008fÌvÒ68ç\u000e¤\u0015m{8Aé\u0015\u008b\u0003Ë9\u0006WSÄLÒ\u001bèÊ\u0086\u0089\u009d]«\u0005AÄ_Üv_\f\u0017\u001aÛ0ÄÏFå\u0002ó\u008e\u0089\u0086 y¾<Tíb½y:\u00171-à;§Ò\"è(\u0086é\u009c¡«aA\u0019_çu²\f\t\u001aá0\u008aÏ_å\u001aóÒ\u0089\u0095 @¾\tTÜ¨]¾\n\u0084Ûê\u0098ñLÇ\u0014-Õ3Í\u001aN`\u0006vÊ\\Õ£W\u0089\u0013\u009f\u009få\u0097ÌhÒ-8ü\u000e¬\u0015+{ AñW¶¾3\u00849êøð°Çp-\b3ö\u0019£`\u0018vð\\\u009f£N\u0089\u000b\u009fÃå\u008eÌQ\u0014Í\u0002\u009a8KV\bMÜ{\u0084\u0091E\u008f]¦ÞÜ\u0096ÊZàE\u001fÇ5\u0083#\u000fY\u0007pøn½\u0084l²<©»Ç¥ý~ë}\u0002î8¾V`\u0095o\u00838¹é×ªÌ~ú&\u0010ç\u000eÿ'|]4Køaç\u009ee´!¢\u00adØ¥ñZï\u001f\u0005Î3\u009e(\u0019F\u0007|Üjß\u0083C¹\f×ÈLOZ\u0018`É\u000e\u008a\u0015^#\u0006ÉÇ×ßþ\\\u0084\u0014\u0092Ø¸ÇGEm\u0001{\u008d\u0001\u0085(z6?Üîê¾ñ9\u009f'¥ü³ÿZb`.\u000eè\u0019\u008e\u000fÙ5\b[K@\u009fvÇ\u009c\u0006\u0082\u001e«\u009dÑÕÇ\u0019í\u0006\u0012\u00848À.LTD}»cþ\u0089/¿\u007f¤øÊæð=æ>\u000f£5â[)ç!ñwË¼¥é¾,\u0088{¼Àª\u009f\u0019Ñ\u000fÌ5\b[W@\u0095v\u009b\u009c\u001f\u0082_«\u008aÑÙÇ\u0006íM\u0012\u0095\u0019\u0088\u000fÞ5\u0015[@@\u0091vÁ\u009c\u0017\u0082C«\u009a\u0082\u008f\u0094ï®\"ÀwÛ\u00adíí\u00070\u0019o0·JôiÓ\u007f\u008aEI+\u000e0Á\u0006\u009bìD\u0019\u009d\u000fÔ5\b[W@\u009bvÝ\u009c\u0007\u0082]\u0019\u008c\u000fÓ5T[H@\u0084vÛ\u009c\u0016\u0082E«\u008dÑØÇDíL\u0012\u00838Ò.\u000bTC}»\u0019\u0088\u000fÞ5\u0015[@@Îv\u0082\u009c\u0002ú}ì=Öð¸¹£`\u00959\u007fõ\u0007\n\u0011J+\u0087EÎ^\u0017hN\u0082\u0082\u009cüµ\u0005Ï\u0007ÙÏ^ÇH\u0087rJ\u001c\u0003\u0007Ú1\u0083ÛOÅ1ìÈ\u0096Ê\u0080\u0002ª)U\u008e\u007fÎ\u0019\u008c\u000fÓ5T[H@\u0084vÛ\u009c\u0016\u0082E«\u008dÑØÇDíE\u0012\u00898À.\u0007TL¿\u001b©N\u0093\u0087\u0019\u009b\u000fÑ5\u000f[T@\u0097vÀ\u009c\u001d\u0082B\u0019¿\u000fÌ5\n[\u0018@¤vÁ\u009c\u001c\u0082D«\u0087ÑÁÇ\u000fí\b\u0012\u00808Ë.\u0010T\u0000}\u009dcô\u0089(¿w¤»ÊñqÁg¬]`34(ç\u001e£ôhênÃÃ¹\u0096¯_\u0085vzúP¯Fu<2\u0015Ô\u000bÂáB×\tÌÚ¢Ê\u0098T\u008eVg\u0086\u0019¿\u000fÒ5\u001e[J@\u0099vÝ\u009c\u0016\u0082\u0010«½ÑèÇ!í\b\u0012\u00848Ñ.\u000bTL}ªc¼\u0089<¿w¤¤Ê´ð*æ(\u000fø5Ó[|A<\u0085Ó\u0093\u008c©\u000bÇ\u000fÜÈê\u0099\u0000I\u001e\u00187ÐM\u0081[P\u0019\u0099\u000fÓ5\u0016[\\@\u0090vÝ\u009c\u0001\u0082X\u0019\u0088\u000fÞ5\u0015[@@Îv\u0082\u0019\u008c\u000fÝ5\u0014[[@\u009evÁ\u0017®\u0001ñ;vUjN¦xù\u00924\u008cg¥¯ßúÉfãh\u001c¶6ç .Zf\u0019\u008c\u000fÓ5T[S@\u0093vÆ\u009c\u001c\u0082U«\u0082Ñ\u0082Ç\u001bíM\u0012\u008b8Ñ\u0019Ï¯+¹t\u0083óíìö4Àp* 4å\u001d,\u0019Î\u0019\u008c\u000fÓ5T[Z@\u0083vÝ\u009c\u001e\u0082T«ÀÑÜÇ\u0018íG\u0012\u00828Ñ.\u0001TT\u0019\u0098\u000fÉ5\u0016[T@©vÌ\u009cJ\u0082\u0006\u0019\u008c\u000fÓ5T[Z@\u0083vÝ\u009c\u001e\u0082T«ÀÑÊÇ\u0003íF\u0012\u00818Á.\u0010TP}¬cõ\u00894¿lBãT£nn\u0000'\u001bþ-§ÇkÙeðç\u008a²\u009c{¶}Iûc»uv\u000f?&Ö8\u008fÒC\u0019Õ\u000f\u00955X[\u0011@Èv\u0091\u009c]\u0082#«ÚÑØÇ\u0010íK\u0012Ù8\u008c.ET3}êcè\u0089 ¿{¤ýÊ½ðpæ9\u000fð5©[eA\u001bvò\u009cð\u00828\u0019\u0099\u000fÙ5\u0014[]@\u0084vÝ\u009c\u0011\u0082\u001f«\u0089ÑÃÇ\u0005íO\u0012\u008a8Á.=TS}ºc÷\u0089u¿\u007f¤³Êúð7æb\u000f§5ï\u009e3\u0088s²¾Ü÷Ç.ñw\u001b»\u0005µ,2Vd@¯jú\u0095t¿8©¸Ó¥ú\u0002äT\u000e\u009f8Ê#DM\bw\u0088\u0019\u0099\u000fÓ5\u0015[_@\u009avÑ\u009c]\u0082C«\u008aÑÇÇ5íO\u0012\u00968Ì.\rTN}»cÃ\u0089\"¿ ¤àÊ»ð5æu\u000f 5é[8Aav¥\u009cÛ\u0082:¨8Ñ\u0088\u0019\u008c\u000fÓ5T[Z@\u0099vÛ\u009c\u0006\u0082\\«\u0081ÑÍÇ\u000eíM\u0012\u0094Kà]¿g8\t6\u0012õ$·ÎjÐ5ùï\u0083¡\u0095a¿!@¤jª|{\u0006%/Þ1\u0094Û\u0018í\u0012öÓ\u0098\u0096¢Y´\u0019]Ðg\u0090\tT\u0013\r$ÄÎ\u009c5Ò#¿\u0019sw'lôZ°°{®p\u0087ûýùë1F\u000ePQjÖ\u0004Ø\u001f\u0001)_Ã\u009cÝÖôB\u008eJ\u0098\u0081²ÙM\u0014gJq\u0081\u000bÛ\"r<wÖ¼\u0019\u008a\u000fÙ5\t[L@ÛH@^\u0005dÄ\n\u009b\u0011\u000f'\u0010ÍÓÓ\u0084ú\u0017\u0080\n\u0096Ø¼\u0092CDi^\u007fÅ\u0005\u0085,f2;Øþ1\u0084'Ò\u001d\u001csFhÓ^×´\u000eª\u0015\u0083\u0088ùÆï\bÅM:\u0086\u0010Ê\u0006\u0010|X\u0019\u008f\u000fÙ5\u0017[M@ØvÇ\u009c\u0014\u0082\u001e«\u0088ÑÍÇ\u0001íM\u0012¹8Ç.\u0003TM}»cî\u0089;;ë-½\u0017sy)b¼T£¾p z\u0089æó«åjÏ\u00130æ\u001a¥\fhv7_ÓA\u008c«G\u0019\u008c\u000fÓ5T[S@\u0093vÆ\u009c\u001c\u0082U«\u0082Ñ\u0082Ç\u000bíF\u0012\u00828Ö.\rTI}ºc²\u0089+¿}¤»Êáð6\u0019\u008c\u000fÓ5T[Z@\u0099vÛ\u009c\u0006\u0082\u001e«\u009fÑÉÇ\u0007í]\u0012È8Å.\u0014TD}\u0081cò\u0089;¿u¤³\u0019\u008c\u000fÓ5T[W@\u0092vÙ\u009c\\\u0082R«\u009bÑÅÇ\u0006íL\u0012È8Â.\u000bTN}¹cù\u0089(¿h¤¤Êýð<æd\u0019\u008c\u000fÓ5T[H@\u0084vÛ\u009c\u0016\u0082E«\u008dÑØÇDíJ\u0012\u00938Í.\u000eTD}ðcú\u00893¿v¤±Êñð æ`\u000f¼5å[$A|ÚçÌ¸ö?\u0098 \u0083äµ¬_mA>hè\u0012é\u0004c.6Ñäû£ím\u0097e¾Ó \u009eJ_|\u0014gØ\t\u008d3I%\tÌÌö\u0089\u0098U\u0019\u008c\u000fÓ5T[K@\u008fvÇ\u009c\u0006\u0082U«\u0083ÑóÇ\u000fíP\u0012\u00928\u008a.\u0000TU}·cð\u0089>¿6¤°Êýð<æw\u000f«5þ[:Azv¯\u009cê\u00826Z\u001aLEvÂ\u0018Ø\u0003\u00055Lß\u0080ÁÉè\n\u0092\u0014\u0084\u009e®ËQ\u0019{^m\u0090\u0017\u0098>. cÊ¢üéç%\u0089p³´¥ôL1vt\u0018¨¢ð´¯\u008e(à2ûïÍ¦'j9#\u0010àj\u008f|rV8©ñ\u0083µ\u00950ï>Æ×Ø\u00892J\u0004\u0000\u001f\u0084q\u008eKG]\u0002´Õ\u008e\u0095àDú\u0004ÍÈ'\u00919P\u0013\bùiÞMÈDò\u0083\u009cÒ\u0087E±Y[\u008bEÁl\u0007\u0016o\u0000\u0086*ÝÕ\nÿ]È\u0087Þ\u008eäI\u008a\u0018\u0091\u008f§\u0091MKS\u0005zÓ\u0000\u009f\u0016H<QÃÒé\u0093ÿG\u0085\u0013¬ê²«Xbn*uß\u001b¥!a7(Þáä¾\u0019Ñ\u000fØ5\u001f[N@ÙvÇ\u009c\u001d\u0082S«\u0085ÑÉÇ\u001eí\u0007\u0012\u00818Á.\fTY}º\u0019Ñ\u000fØ5\u001f[N@ÙvÇ\u009c\u001d\u0082S«\u0085ÑÉÇ\u001eí\u0007\u0012\u00978Á.\u000fTU}º®e¸{\u0082·ìÿ÷mÁq+£5é\u001c/fGpªZî¥3\u008fs\u0099³S*E4\u007fø\u0011°\ny<*ÖäÈäáy\u009b>\u008dó§üXqr6dû\u001e¸7z)\nÃÀõ\u008fîA\u0080\u0000ºÊ¬´EQ\u007f\u0012\u0011Ó\u000b\u0086<ZÖ ÈÈâ\u009e\u009b(\u008dò§ïXpr\"½\u001c«\u0015\u0091Òÿ\u0083ä\u0014Ò\u001b8Ì&\u0089\u000f|u\u0006c×I\u0096\u0019Ñ\u000fØ5\u001f[N@ÙvÖ\u009c\u0001\u0082D«±ÑØÇ\u0003íE\u0012\u0083ãØõÑÏ\u0016¡GºÐ\u008cÎf\u0014xZQ\u008c+À=\u0017\u0017\u000eè\u008dÂÞÔ\u001f®O\u0087¸\u0099ùs7Et^\u00ad0ù\u0019Ñ\u000fÏ5\u0003[K@\u0082vÑ\u009c\u001f\u0082\u001f«\u0082ÑÅÇ\bí\u0007\u0012\u008a8Í.\u0000TB}\u00adcè\u0089<¿w¤ºÊðð7æb\u000f\u00915æ[$Aavè\u009c÷\u0082-\u0019Ñ\u000fØ5\u001f[N@ÙvÖ\u009c\u0001\u0082D«\u008fÑÏÇ\tíMÐ.Æ'üà\u0092±\u0089&¿)UþK»bv\u0018*\u000eç$¸FJPCj\u0084\u0004Õ\u001fB)MÃ\u009aÝßô\u0018\u008eR\u0098\u0096²Ý7¯!¦\u001bau0n§X¨²\u007f¬:\u0085ÿÿ é}Ã3\u0019Ñ\u000fØ5\u001f[N@ÙvÖ\u009c\u0001\u0082D«\u0098ÑÁÇ\u0019íO\u0019Ñ\u000fØ5\u001f[N@ÙvÖ\u009c\u0001\u0082D«\u009eÑËÇ\u000bíA\u0012\u00968Ç¶Á È\u009a\u000fô^ïÉÙÆ3\u0011-T\u0004¡~Õh\u0017B]Â¦Ô¯îl\u0080;\u009bà\u00adìGaY(pî\nµ\u001cq60Éðã·õf\u008fx¦\u0087¸\u0093ROd@\u007fÃ\u0011\u0090+Q=\f\u0019Ñ\u000fÑ5\u0014[L@ÙvÃ\u009c\u001b\u0082^«\u008aÑÃÇ\u001dí[\u0012É8æ.\u0011TT}\u008dcô\u0089;¿j¤³Êðð\u0014æ\u007f\u000f¢5è[/Az\u0019Ñ\u000fÌ5\b[W@\u0095v\u009b\u009c\u001b\u0082_«\u009eÑÃÇ\u0018í\\\u0012\u0095ÚöÌâö$\u0098 \u0083ô\u0019Ñ\u000fÌ5\b[W@\u0095v\u009b\u009c\u0001\u0082U«\u0082ÑÊÇEíE\u0012\u00878Ô.\u0011\u0019\u0099\u000fÎ5\u001b[T@\u009avÛ\u009c\u0011\u0082\u001e«\u0089ÑÃÇ\u0006íL\u0012\u00808Í.\u0011TH}ðcï\u00895\u0086\r\u0090Jª\u0087Äàß%én\u0003¾\u001dð4\u0013N@X\u0081r\u0099\u008d\n§T|ÍjÅP\u0012>G%Å\u0013Åù\u000bçHÎ\u009b´Ñ¢)\u0088Ww\u0095]ÜK\u001b1_\u0018±\u0006®ì>ÚiÁ¦ªþ¼²\u0086mè?óçÅ¢/q11\u0018çb½ælðdÊ³¤æ¿d\u0089dc }øT=.e8¤\r²\u001b»!xO/Tôbø\u0088u\u0096<¿úÅ¡Óeù$\u0006ä,£:r@li\u0093w\u009b\u009dI«T°ÔÞ\u0087äAò\u0000\u001b\u0083!\u0097ODU\u00075W#J\u0019\u008ewÑl\u0013Z\u001d°\u0097®Æ\u0087\u001dýCë\u0082ÁÈ>\u000f4¸\"Ò\u0018\u0017v]m\u0091[Ü±\u0000¯Y\u0019Ñ\u000fØ5\u001b[L@\u0097v\u009b\u009c\u001f\u0082Y«\u009dÑÏÇEíX\u0012\u00948Ë.\u0004TI}²cù\u0089)¿7¤µÊáð æ?\u000fþ5£[)Agv«\u009cª\u0082/¨iÑÝÇ\u000eíU\u0012\u008e8ß.\u0006TF}ÞcÃ\u0089\t¿G¤\u009dÊÏð\tæG".getBytes(CharEncoding.ISO_8859_1)).asCharBuffer().get(cArr, 0, 1959);
        _CREATION = cArr;
        _BOUNDARY = 7327177424771551164L;
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
            Method dump skipped, instruction units count: 15377
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fido.zzam.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
    }
}
