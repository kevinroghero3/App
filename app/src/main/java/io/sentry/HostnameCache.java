package io.sentry;

import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.common.base.Ascii;
import io.sentry.util.AutoClosableReentrantLock;
import io.sentry.util.Objects;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import o.ArtificialStackFrames;
import o._CREATION;
import org.apache.commons.lang3.CharEncoding;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class HostnameCache {
    private static volatile HostnameCache INSTANCE;
    private final long cacheDuration;
    private final ExecutorService executorService;
    private volatile long expirationTimestamp;
    private final Callable<InetAddress> getLocalhost;
    private volatile String hostname;
    private final AtomicBoolean updateRunning;
    private static final long HOSTNAME_CACHE_DURATION = TimeUnit.HOURS.toMillis(5);
    private static final long GET_HOSTNAME_TIMEOUT = TimeUnit.SECONDS.toMillis(1);
    private static final AutoClosableReentrantLock staticLock = new AutoClosableReentrantLock();

    public static HostnameCache getInstance() {
        if (INSTANCE == null) {
            ISentryLifecycleToken iSentryLifecycleTokenAcquire = staticLock.acquire();
            try {
                if (INSTANCE == null) {
                    INSTANCE = new HostnameCache();
                }
                if (iSentryLifecycleTokenAcquire != null) {
                    iSentryLifecycleTokenAcquire.close();
                }
            } catch (Throwable th) {
                if (iSentryLifecycleTokenAcquire != null) {
                    try {
                        iSentryLifecycleTokenAcquire.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        return INSTANCE;
    }

    private HostnameCache() {
        this(HOSTNAME_CACHE_DURATION);
    }

    HostnameCache(long j) {
        this(j, new Callable() { // from class: io.sentry.HostnameCache$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return InetAddress.getLocalHost();
            }
        });
    }

    HostnameCache(long j, @NotNull Callable<InetAddress> callable) {
        this.updateRunning = new AtomicBoolean(false);
        this.executorService = Executors.newSingleThreadExecutor(new HostnameCacheThreadFactory(null));
        this.cacheDuration = j;
        this.getLocalhost = (Callable) Objects.requireNonNull(callable, "getLocalhost is required");
        updateCache();
    }

    void close() {
        this.executorService.shutdown();
    }

    /* JADX INFO: renamed from: io.sentry.HostnameCache$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        private static long _BOUNDARY;
        private static char[] _CREATION;
        private static final byte[] $$c = {49, Ascii.SUB, -88, -35};
        private static final int $$d = 49;
        private static int $10 = 0;
        private static int $11 = 1;
        private static final byte[] $$a = {Ascii.DC2, -20, 124, 53, -2, 47, Ascii.VT, 53, -13, -1, -53, Ascii.SYN, 1, -3, -12, Ascii.VT, -8, 17, -5, -52, 0, 17};
        private static final int $$b = 66;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;

        /* JADX WARN: Code duplicated, block: B:10:0x0020  */
        /* JADX WARN: Code duplicated, block: B:8:0x001a  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0020 -> B:11:0x0028). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0020
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$e(short r6, short r7, int r8) {
            /*
                int r7 = r7 * 4
                int r0 = r7 + 1
                byte[] r1 = io.sentry.HostnameCache.AnonymousClass1.$$c
                int r6 = r6 + 4
                int r8 = 106 - r8
                byte[] r0 = new byte[r0]
                r2 = 0
                if (r1 != 0) goto L12
                r3 = r7
                r4 = r2
                goto L28
            L12:
                r3 = r2
            L13:
                int r6 = r6 + 1
                byte r4 = (byte) r8
                r0[r3] = r4
                if (r3 != r7) goto L20
                java.lang.String r6 = new java.lang.String
                r6.<init>(r0, r2)
                return r6
            L20:
                int r3 = r3 + 1
                r4 = r1[r6]
                r5 = r3
                r3 = r8
                r8 = r4
                r4 = r5
            L28:
                int r8 = -r8
                int r8 = r8 + r3
                r3 = r4
                goto L13
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.HostnameCache.AnonymousClass1.$$e(short, short, int):java.lang.String");
        }

        private static void b(int i, int i2, byte b, Object[] objArr) {
            int i3 = 115 - i2;
            byte[] bArr = $$a;
            int i4 = 19 - b;
            byte[] bArr2 = new byte[i + 2];
            int i5 = i + 1;
            int i6 = -1;
            if (bArr == null) {
                i3 = (i3 + i5) - 2;
            }
            while (true) {
                i6++;
                i4++;
                bArr2[i6] = (byte) i3;
                if (i6 == i5) {
                    objArr[0] = new String(bArr2, 0);
                    return;
                }
                i3 = (i3 + bArr[i4]) - 2;
            }
        }

        private static void a(char c, int i, int i2, Object[] objArr) throws Throwable {
            int i3 = 2 % 2;
            _CREATION _creation = new _CREATION();
            long[] jArr = new long[i2];
            _creation.b = 0;
            int i4 = $10 + 75;
            $11 = i4 % 128;
            int i5 = i4 % 2;
            while (_creation.b < i2) {
                int i6 = _creation.b;
                try {
                    Object[] objArr2 = {Integer.valueOf(_CREATION[i + i6])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) (-1);
                        byte b2 = (byte) (b + 1);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(8 - (ViewConfiguration.getEdgeSlop() >> 16), (char) (TextUtils.indexOf("", "", 0) + 9279), View.resolveSize(0, 0) + 1977, 1113883676, false, $$e(b, b2, (byte) (b2 + 2)), new Class[]{Integer.TYPE});
                    }
                    Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i6), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) (-1);
                        byte b4 = (byte) (b3 + 1);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(30 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (View.getDefaultSize(0, 0) + 49362), 684 - View.combineMeasuredStates(0, 0), -115095555, false, $$e(b3, b4, b4), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                    }
                    jArr[i6] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                    Object[] objArr4 = {_creation, _creation};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                    if (objAccessartificialFrame3 == null) {
                        byte b5 = (byte) (-1);
                        byte b6 = (byte) (b5 + 1);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(TextUtils.getTrimmedLength("") + 25, (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 30069), 817 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 1897803493, false, $$e(b5, b6, (byte) (b6 + 3)), new Class[]{Object.class, Object.class});
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
                int i7 = $11 + 51;
                $10 = i7 % 128;
                if (i7 % 2 != 0) {
                    cArr[_creation.b] = (char) jArr[_creation.b];
                    Object[] objArr5 = {_creation, _creation};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-293902099);
                    if (objAccessartificialFrame4 == null) {
                        byte b7 = (byte) (-1);
                        byte b8 = (byte) (b7 + 1);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(24 - TextUtils.lastIndexOf("", '0', 0), (char) ((-16747148) - Color.rgb(0, 0, 0)), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 816, 1897803493, false, $$e(b7, b8, (byte) (b8 + 3)), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                    throw null;
                }
                cArr[_creation.b] = (char) jArr[_creation.b];
                try {
                    Object[] objArr6 = {_creation, _creation};
                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-293902099);
                    if (objAccessartificialFrame5 == null) {
                        byte b9 = (byte) (-1);
                        byte b10 = (byte) (b9 + 1);
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(View.combineMeasuredStates(0, 0) + 25, (char) (Color.argb(0, 0, 0, 0) + 30068), 816 - Color.alpha(0), 1897803493, false, $$e(b9, b10, (byte) (b10 + 3)), new Class[]{Object.class, Object.class});
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
            String str = new String(cArr);
            int i8 = $10 + 87;
            $11 = i8 % 128;
            int i9 = i8 % 2;
            objArr[0] = str;
        }

        static {
            char[] cArr = new char[1959];
            ByteBuffer.wrap("\u0019ÑÕÛ\u0081\u0019}K(ÕäÜÐ\u0017\u008cU{\u00927Ñã\u001dßF\u008a\u009aFì2\u0011îUÝ\u008a\u0089ÝE\t1^ì\u0099Øô\u0094\u001b@Y?\u0087ëÄ§\u0001\u008f3C9\u0017ûë©¾7r>Fõ\u001a·íp¡3uÿI¤\u001cxÐ\u000e¤âxºK|\u001f(ÓÑ§«zxN;\u0002éÖ¿©`\u0019ÑÕÛ\u0081\u0019}K(ÕäÜÐ\u0017\u008cU{\u00927Ñã\u001dßF\u008a\u009aFì2\u0003îHÝ\u0080\u0089Ì÷\u0089;\u0094o]\u0093\u0016Æ\u008d\n\u008e>Ob\u0005\u0095ÛÙ\u0083\rI1BdÍ¨\u0084ÜD\u0000\r3Ðg\u009e«Gß\u001d\u0002í6\u0091zQ®\u0005ÑÊ\u0005\u009aIN}\u0004¾ßrÔ&\u0006ÚP\u008fÛCÑw\u0011+\u0019Ü\u0088\u0090ËD\u0015xK\u0019ÑÕÚ\u0081\b}^(ÕäÈÐ\u0011\u008cT{Ø7Çã\u0006ßZ\u008a\u0082\u0019ÑÕÌ\u0081\u0018}^(\u009bäÉÐ\u001c\u008c\u0016{¤7ñã9ßZ\u008a\u0084FÖ24îPÝ\u009a\u0089Î\u0019ÑÕÛ\u0081\u001d}I(\u009bä\u0094ÐV\u008cZ{\u00867Âã\u001dß[\u008a\u0094FÜ\u0019\u008cÕÐ\u0081R}_(\u0095äÔÐ\f\u008c\u0017{\u00847Òã\u0010ßG\u008a\u009dFÚ2\u0014înÝ\u0080\u0089ÊE\u00181rì\u008eØÅ\u0094\u001b@\u0018\u0019\u008cÕÐ\u0081R}_(\u0095äÔÐ\f\u008c\u0017{\u00847Òã\u0010ßG\u008a\u009dFÚ2\u0014înÝ\u0080\u0089ÊE\u00181rì\u008eØÅ\u0094\u001b@\u001báÿ-ây+\u0085`Ð \u001cð(;t8\u0083´Ïð\u001b8'4r°¾ôÊ<\u0016q%¢q¯½1Él\u0011äÝ®\u0089cu+ íì»\u0019ÑÕÌ\u0081\u0005}N(\u008eäÞÐ\u0015\u008c\u0016{\u00947Þã\u001aß\u001a\u008a\u009cFÖ2\u001dîDÝ¸\u0089âEA1Cì\u008fØÆ\u0094\u001d@\u0004?\u0085ëÈ§\n\u0093QN\u0090:Ìö\fâö.ëz\"\u0086iÓ©\u001fù+2w1\u0080³Ìù\u0018=$=q»½ñÉ:\u0015c&\u009frÅ¾fÊz\u0017¿#ão?ê\u0087&\u009arS\u008e\u0018ÛØ\u0017\u0088#C\u007f@\u0088ÌÄ\u0088\u0010@,LyÈµ\u008cÁD\u001d\t.Ýz\u0094¶OÂ-\u001fñ+\u008dgL³\u0010ÌÀ\u0018ßTA`\u001c\u0019ÑÕÛ\u0081\u0019}K(ÕäÕÐ\u001d\u008cT{\u00837Ðã\u0001ßP\u008a\u0081FÇ\u0019\u008cÕÐ\u0081R}_(\u008fäÒÐ\u0014\u008c]{Ø7ßã\u001bßF\u008a\u0086\u0019\u0090ÕÚ\u0081\u001d}N(\u009fä\u0095Ð\u0016\u008c\\{\u00829\u0093õ\u008d¡L]\u0010\bÛÄÖð\\¬\u0012[Ø\u0017\u0090ÃEÿ\u000eªÃf\u0085\u0012WÎ\u001eýßO¿\u0083õ×>+g~¦²ò\u0019\u008cÕÐ\u0081R}M(\u0088äÔÐ\u001c\u008cL{\u00957ÃãZßX\u008a\u0093FÝ2\u0005îWÝ\u008f\u0089ÌE\u00181Xì\u0098ØÎ\u0094\u001aò\u0017>Tj\u009c\u0096Ê\u0019\u008eÕÚ\u0081\u000e}N(\u0093äÈÐ\f\u008c\u0017{\u00857Îã\u0007ß\u001b\u008a\u0090F×2^îUÝ\u008b\u0089ÍE\u00191JìÄØÌ\u0094\u0018@\\?ÈëÁ§\u0005\u0093NN\u0087:üö\u0007¢Q\u0091«MÀ9.õx ´\u009cÿH=\u0004kó³¯år{¾/êû\u0016»Cf\u008f=»ùçâ\u0010p\\;\u0088ò´îáe-\"Y«\u0085 ¶~â8.ìZ¿\u00871³9ÿí+©T=\u00804Ìðø»%rQ\t\u009dòÉ¤ú^&5Rß\u009e\u008dËA÷\n#Âo\u009eY\u0097\u0095ÃÁ\u0017=Wh\u008a¤Ñ\u0090\u0015Ì\u000e;\u009cw×£\u001e\u009f\u0002Ê\u0089\u0006ÎrG®L\u009d\u0092ÉÔ\u0005\u0000qS¬Ý\u0098ÀÔ\u001e\u0000\u001e\u007f\u009c«Ïç\u0014Ðô\u001c Ht´4áé-²\u0019vEm²ÿþ´*}\u0016aCê\u008f\u00adû$'/\u0014ñ@·\u008ccø0%¾\u0011£]}\u0089}öð\"¼n}$Nè\u001a¼Î@\u008e\u0015SÙ\bíÌ±×FE\n\u000eÞÇâÛ·P{\u0017\u000f\u009eÓ\u0095àK´\rxÙ\f\u008aÑ\u0004å\u0019©Ç}Ç\u0002KÖ\u0004\u009aÇ\u0019\u008eÕÚ\u0081\u000e}N(\u0093äÈÐ\f\u008c\u0017{\u00857Îã\u0007ß\u001b\u008a\u0090F×2^îUÝ\u008b\u0089ÍE\u00191JìÄØÙ\u0094\u0007@\u0007?\u008bëÉ§\u0007¸Ît\u009b UÜ\u0003\u0089ÏE\u009b@³\u008c\u00adØl$0qû½ö\u0089wÕ4\"ðn ºz\u00862Óã\u0019\u0088ÕÝ\u0081\u0013}E(\u009däÎÐ\u001d\u008cJ{\u0082\u0019¹ÕÚ\u0081\u0012}D(\u0097äÔÐ\f\u008cP{\u00997Ù\u009f]S\u0007\u0007Áû\u0085®Cb\u001aVÀ\u0019\u009dÕ×\u0081\u000e}R(\u0097äÒÐ\r\u008cTc´¯èûj\u0007uR°\u009eìª$öt\u0001\u00adMû\u0099b¥ið¯<ýH!\u0094j§³ê~&+rå\u008e³Û4\u0017{#þ\u0019\u0099ÕÚ\u0081\u0012}X(\u0088äÒÐ\u001b\u008a\u001eF]\u0012\u0095îß»\u000fwUC\u009c\u001fáè\t¤\bpÅ\u0084¨Hë\u001c#àiµ¹yãM*\u0011Wæ¿ª¾~sB[\u0017õÛ¶m§¡ûõy\tf\\£\u0090ÿ¤7øg\u000f¾Cè\u0097q«sþ¶2üF>\u009av\u00118Ýn\u0089¢\u0019\u009bÕÒ\u0081\t}Q(\u009bäÏÐ\u0017\u008cKG\u0080\u008bðß3#\"v\u0097ºñ\u008e)Òr% iå½.\u0081*Ô«\u0018ãl=°.\u0083\u0092×ø\u001b!o}²¸\u0086ñÿõ3\u009bgR\u009b\u0005Îß\u0002\u00986VjS\u009dïÑ¹\u0005u9_lÚ \u008cÔS\b\u0017;ÐoÅ£@×\b\nÒ>ÁrZ¦[Ù\u009a\u0082\u0085Në\u001a\"æu³¯\u007fèK&\u0017#à\u009f¬Éx\u0005D/\u0011ªÝü©#ugF \u0012µÞ0ªxw¢C±\u000f*Û+¤êpÂ<h\b+ù\u001b5GaÅ\u009dÂÈ\f\u0004^0\u008blÙ\u009b\u0000×R\u0003\u0086\u0019\u0099ÕÐ\u0081\u0010}Y(\u009cäÒÐ\u000b\u008cQ\u0019\u0088ÕÝ\u0081\u0013}E(Âä\u008dÏZ\u0003\bWÄ«\u0088þD2\u0018\u0019\u008cÕÐ\u0081R}M(\u0088äÔÐ\u001c\u008cL{\u00957ÃãZßW\u008a\u0080FÒ2\u001eîUm\u009c¡ÀõB\tF\\\u008f\u0090Ù¤\u0006øL\u000f\u008aC\u0089\u0097\u0015«@þ\u008f2Öü\u008fxÇ´\u009bà\u0019\u001c\u0005IÔ\u0085\u0093±Fí\u0000\u001aØ\u008fÚ¸\u0004tX ÚÜ×\u0089\u0007EZq\u009c-ÕÚP\u0096OB\u008e~Ò+\u001eçN\u0093\u009bOÍ\u0019\u0098ÕÊ\u0081\u0010}Q(¥äÃÐ@\u008c\u000f\u0019\u008cÕÐ\u0081R}_(\u008fäÒÐ\u0014\u008c]{Ø7Ñã\u001dß[\u008a\u0095FÖ2\u0002îAÝ\u009c\u0089ÆE\u00021Y\u0019\u0099ÕÚ\u0081\u0012}X(\u0088äÒÐ\u001b\u008c\u0016{\u00857Óã\u001fß\u001a\u008a\u0095FÖ2\u001eîTÝ\u009c\u0089ÆE\u000f\u0019\u0099ÕÚ\u0081\u0012}X(\u0088äÒÐ\u001b\u008cf{\u008e7\u008fãBß\u001a\u008a\u0081F×2\u001bînÝ\u0096\u0089\u0097EZ1\u0002ì\u008dØÎ\u0094\u0006@L?\u0094ëÎ§\u0007\u0093zN\u009a:\u009böV\u0019\u0099ÕÚ\u0081\u0012}X(\u0088äÒÐ\u001b\u008c\u0016{\u00917Øã\u001bßR\u008a\u009eFÖ2/îBÝ\u008a\u0089ÄEC1Jì\u008fØÅ\u0094\r@[?\u008fëÄ\u008c4@w\u0014¿èõ½%q\u007fE¶\u0019»î-¢xv¶Jà\u001fgÓ(§\u00ad{³H5\u001c`Ð®¤øy\u007fM0\u0001µ\u0019\u0099ÕÐ\u0081\u0013}Z(\u0096äÞÐW\u008cJ{\u00927Üã+ßR\u008a\u0082FÛ2\u001fî_Ý\u008b\u0089ðE\u00141\u0015ìÜØ\u0084\u0094\u000f@L?\u0088ëÂ§\u0016\u0093LN\u0081:üö\u0018¢\u0019\u0091è\u0019\u008cÕÐ\u0081R}_(\u0095äÔÐ\f\u008cU{\u00997Öã\u0010ßP\u008a\u0080\u0099¦Uú\u0001xýu¨¿dþP&\fzû±·üc9_z\nöÆû²/nr]¨\táÅh±al©Xï\u0014%Àf¿¾ký'<\u0013fÎ¦ºýAã\u008d\u008dÙD%\u0013pÉ¼\u008e\u0088@ÔH#ÒoÓ»\u001eÍÜ\u0001\u0080U\u0002©\u000füß0\u0082\u0004DX\r¯\u0088ã\u00837M\u000b\u0016^Ò\u0092\u008fæA:\u0018\t\u0090]\u0096\u0091X\u0019\u008aÕÚ\u0081\u000f}I(×\u0019\u0097ÕÑ\u0081\u0015}I(ÔäÈÐ\u000e\u008cZ{Ø7Æã\u0011ßX\u008a\u0087F\u009e2\u0000îCÝ\u0081\u0089ßE\u001fh\u0002¤Wð\u009c\fÅYY\u0095^¡\u0082ý\u009a\n\u0016F[\u0092\u0090®Öû\u00147[C\u0084\u009fÏ\u001a<Öi\u0082¢~û+gç{Ó\u00ad\u008f¤x#4eà¬Üã\u0089\u001eEc1¢íïÞ8\u008anF¾\u0019\u008fÕÚ\u0081\u0011}H(ÔäÈÐ\u001e\u008c\u0017{\u009a7Ôã\u0010ßj\u008a\u0096FÖ2\u001eîBÝ\u0087\u0089ÛE\u0015TØ\u0098\u0084Ì\u00060\u0002eË©\u009d\u009dBÁ\b6ÎzÍ®A\u0092\u000fÇÂ\u000b\u0095\u007fK£\f\u0090ÞÄÕ\bI|\u001c¡Ó\u0095\u008aÙX\u0017RÛ\u000e\u008f\u008cs\u0081&Kê\nÞÒ\u0082ÉuY9\fíÇÑ\u009e\u0084\u0002H\f<Øà\u008bÓo\u0087\u001fKÓ?\u009eâQðn<2h°\u0094°Á|\r49´e¹\u0092aÞ<\nú6³c>¯7Ûû\u0007½4k`(¬üØ¿\u0005z1 }ä©¿´vx*,¨Ð·\u0085rI.}æ!¶Öo\u009a9N r\u00ad'}ë \u009fæC¯p:$3èÿ\u009c¹Awu49àí£\u0092nF4\nð>«\u0019\u008cÕÐ\u0081R}N(\u0083äÈÐ\f\u008c\\{\u009b7\u0099ã\u0016ß@\u008a\u009bFß2\u0014î\u001fÝ\u0088\u0089ÆE\u00021Jì\u008fØÙ\u0094\u0018@[?\u008fëÉ§\u0010\u0019\u008cÕÐ\u0081R}N(\u0083äÈÐ\f\u008c\\{\u009b7èã\u0011ßM\u008a\u0086F\u009d2\u0012îDÝ\u0087\u0089ÃE\b1\u0003ì\u008cØÂ\u0094\u0006@N?\u0083ëÕ§\u0014\u0093WN\u008b:Íö\u0014\u0019\u008cÕÐ\u0081R}K(\u009fäÕÐ\u001c\u008cV{\u00847\u0099ã\u0016ß@\u008a\u009bFß2\u0014î\u001fÝ\u0088\u0089ÆE\u00021Jì\u008fØÙ\u0094\u0018@[?\u008fëÉ§\u0010\u0019\u008cÕÐ\u0081R}K(\u009fäÕÐ\u001c\u008cV{\u00847èã\u0010ßY\u008a\u0099FÞ2^îSÝ\u009b\u0089ÆE\u00001IìÄØÍ\u0094\u0001@G?\u0081ëÂ§\u0016\u0093UN\u0090:Êö\u000e¢U¢\u0015\u0019ÑÕÛ\u0081\u0019}K(ÕäÊÐ\u001d\u008cT{\u00837èã\u0004ß\\\u008a\u0082FÖáò-øy:\u0085hÐö\u001cë(4ty\u0083¾Ïñ\u001b#'9r³¾ñÊ \u0016w%¯qí½!Éj\u0014\u0096 ïl.¸dÇ¼\u0013àw\u0010»\u001aïØ\u0013\u008aF\u0014\u008a\t¾Öâ\u009b\u0015\\Y\u0013\u008dÁ±ÛäT(\u0017\\ß\u0080\u0089³K\u0019ÑÕÛ\u0081\u0019}K(ÕäÈÐ\u0017\u008cZ{\u009d7Òã\u0000ß\u001a\u008a\u0083FÖ2\u001dîDÝ\u008a7\u0017û\n¯ÃS\u0088\u0006\u0013Ê\fþÛ¢\u0092UE\u0019.ÍÆñ\u0081¤Uh\u0016\u001cÓ\u0019ÑÕÌ\u0081\u0005}N(\u008eäÞÐ\u0015\u008c\u0016{\u009a7Þã\u0016ß\u001a\u008a\u009eFÚ2\u0012îRÝ±\u0089ÂE\r1Aì\u0086ØÄ\u0094\u000b@v?\u0082ëÂ§\u0006\u0093PN\u0085:üö\u0011¢D\u0091³Mê9rõn µ\u0019ÑÕÛ\u0081\u0019}K(ÕäÙÐ\u000b\u008cM{©7Ðã\u0004ßF\u0019ÑÕÛ\u0081\u0019}K(ÕäÙÐ\u000b\u008cM{©7Ãã\u001dßX\u008a\u0097\u0019ÑÕÛ\u0081\u0019}K(ÕäÈÐ\u0017\u008cZ{\u009d7Òã\u0000ß\u001a\u008a\u0090FÀ2\u0004îWÝ\u0081\u0089ÃE\b1Hì\u0098ØÏ\u0019ÑÕÌ\u0081\u0005}N(\u008eäÞÐ\u0015\u008c\u0016{\u009a7Þã\u0016ß\u001a\u008a\u009eFÚ2\u0012îSÝ\u009d\u0089ÛE\n1Bì\u0086ØÏ\u0094\r@[?¹ëÍ§\n\u0093LNÌ:Ðö\u000f\u0019ÑÕÛ\u0081\u0019}K(ÕäÙÐ\u000b\u008cM{\u00977Ôã\u0017ßPû\u00937\u0099c[\u009f\tÊ\u0097\u0006\u009b2In\u000f\u0099ÓÕ\u008c\u0001D=\u0018Ç\u0011\u000b\u001b_Ù£\u008bö\u0015:\u0019\u000eËR\u008d¥[é\u0012=Ó\u0001\u009b\u0019ÑÕÛ\u0081\u0019}K(ÕäÙÐ\u000b\u008cM{\u00997Åã\u001dßP\u0019ÑÕÛ\u0081\u0019}K(ÕäÙÐ\u000b\u008cM{\u00807Úã\u0007ßR\u0019ÑÕÛ\u0081\u0019}K(ÕäÙÐ\u000b\u008cM{\u00867Ðã\u0015ß\\\u008a\u0082FÐ\u0019ÑÕÛ\u0081\u0019}K(ÕäÙÐ\u000b\u008cM{©7Þã\u0019ßPãV/\\{\u009a\u0087ÎÒ\u001c\u001e\u0013*\u009bvÑ\u0081\u0006Í^\u0019\u009f%Ýp\u0014¼PÈ\u0084\u0014\u0099'GsP¿\u0089Ë\u0085\u0016\u000f\"_n\u009bºÅ9\u0095õ\u0096¡V]\r\b\u0091Ä\u0088ðU¬\u0013[Ö\u0017\u009cÃGÿ\u0002ª\u0099fµ\u0012GÎ\u0001ýù©\u0083eI\u0011\u001bÌËø\u008b´j`\u0002\u001fÎË\u0087\u0087E³\u0013S\u001e\u009f\u0000ËÁ7\u009dbV®[\u009aÞÆ\u00991I}\u0017©É\u0095\u008eÀN\u0019ÎÕÙ\u0081\u001a}\u001d(À\f\"À<\u0094ýh¡=jñgÅø\u0099¯ni\"\"ö¨Ê«\u009f`S0'ð\u0019\u0099ÕÍ\u0081\u001d}Q(\u0096äÔÐ\u001b\u008c\u0017{\u00917Øã\u0018ßQ\u008a\u0094FÚ2\u0003îYÝÀ\u0089ÜE\u0003!\u0018í\\¹\u0094Eð\u0010<Ütè¡´ìC\u001e\u000fNÛ\u008aç\u0091²\u000b~VõÁ9Êm\u0018\u0091NÄÅ\bÆ<\r`M\u0097\u008fÛÆ\u000f;3Ff\u008dªÇÞ\u0005\u0002B1\u008de\u0091©\u0004ÝP\u0000\u0096úù6¶bl\u009e=Ëì\u0007ª3|o?\u0098øÔ¡\u0094\u009cX\u0097\fEð\u0013¥\u0098i\u009b]Z\u0001\u0001öÕº\u008enJqp½zé¼\u0015è@:\u008c5¸½ä÷\u0013 _x\u008b¹·ûâ2.vZ¢\u0086¿µaáj-½Y£\u0084*°zü¹(ûWi\u0083~Ï¨ûè\u0019ÑÕÏ\u0081\u000e}R(\u0099ä\u0094Ð\u001b\u008cI{\u00837Þã\u001aßS\u008a\u009d\u008dÉA \u0015`é)¼ìp¢D{\u0018!>qò-\u0019ÑÕÛ\u0081\u001d}I(\u009bä\u0094Ð\u0015\u008cP{\u00857Ôã[ßE\u008a\u0080FÜ2\u0016îXÝ\u0082\u0089ÊE\u001f1\u0002ì\u0089ØÞ\u0094\u001a@\u0006?Öë\u0088§\u0007\u0093JN\u008f:\u008dö\r¢H\u0091½Mí93õk ³\u009céH,\u00047ó»¯ò\u009b9W`\u0002»þþª5".getBytes(CharEncoding.ISO_8859_1)).asCharBuffer().get(cArr, 0, 1959);
            _CREATION = cArr;
            _BOUNDARY = 4945102255669302719L;
        }

        /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
            java.util.NoSuchElementException
            	at java.base/java.util.TreeMap.key(Unknown Source)
            	at java.base/java.util.TreeMap.lastKey(Unknown Source)
            	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
            	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
            	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
            */
        public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r72, int r73, int r74, int r75) {
            /*
                Method dump skipped, instruction units count: 15345
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.HostnameCache.AnonymousClass1.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
        }
    }

    boolean isClosed() {
        return this.executorService.isShutdown();
    }

    public String getHostname() {
        if (this.expirationTimestamp < System.currentTimeMillis() && this.updateRunning.compareAndSet(false, true)) {
            updateCache();
        }
        return this.hostname;
    }

    private void updateCache() {
        try {
            this.executorService.submit(new Callable() { // from class: io.sentry.HostnameCache$$ExternalSyntheticLambda1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f$0.lambda$updateCache$1();
                }
            }).get(GET_HOSTNAME_TIMEOUT, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            handleCacheUpdateFailure();
        } catch (RuntimeException | ExecutionException | TimeoutException unused2) {
            handleCacheUpdateFailure();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void lambda$updateCache$1() throws Exception {
        try {
            this.hostname = this.getLocalhost.call().getCanonicalHostName();
            this.expirationTimestamp = System.currentTimeMillis() + this.cacheDuration;
            return null;
        } finally {
            this.updateRunning.set(false);
        }
    }

    private void handleCacheUpdateFailure() {
        this.expirationTimestamp = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(1L);
    }

    /* JADX INFO: loaded from: classes6.dex */
    static final class HostnameCacheThreadFactory implements ThreadFactory {
        private int cnt;

        private HostnameCacheThreadFactory() {
        }

        /* synthetic */ HostnameCacheThreadFactory(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NotNull Runnable runnable) {
            StringBuilder sb = new StringBuilder();
            sb.append("SentryHostnameCache-");
            int i = this.cnt;
            this.cnt = i + 1;
            sb.append(i);
            Thread thread = new Thread(runnable, sb.toString());
            thread.setDaemon(true);
            return thread;
        }
    }
}
