package com.google.crypto.tink.streamingaead.internal;

import android.graphics.Color;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.appcompat.app.AppCompatDelegate;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.internal.KeyParser;
import com.google.crypto.tink.internal.KeySerializer;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ParametersParser;
import com.google.crypto.tink.internal.ParametersSerializer;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.Serialization;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyFormat;
import com.google.crypto.tink.proto.AesGcmHkdfStreamingParams;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.streamingaead.AesGcmHkdfStreamingKey;
import com.google.crypto.tink.streamingaead.AesGcmHkdfStreamingParameters;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBytes;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;
import o.ArtificialStackFrames;
import o._CREATION;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes5.dex */
public final class AesGcmHkdfStreamingProtoSerialization {
    private static final KeyParser<ProtoKeySerialization> KEY_PARSER;
    private static final KeySerializer<AesGcmHkdfStreamingKey, ProtoKeySerialization> KEY_SERIALIZER;
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER;
    private static final ParametersSerializer<AesGcmHkdfStreamingParameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER;
    private static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.AesGcmHkdfStreamingKey";
    private static final Bytes TYPE_URL_BYTES;

    static {
        Bytes bytesFromPrintableAscii = Util.toBytesFromPrintableAscii(TYPE_URL);
        TYPE_URL_BYTES = bytesFromPrintableAscii;
        PARAMETERS_SERIALIZER = ParametersSerializer.create(new ParametersSerializer.ParametersSerializationFunction() { // from class: com.google.crypto.tink.streamingaead.internal.AesGcmHkdfStreamingProtoSerialization$$ExternalSyntheticLambda0
            @Override // com.google.crypto.tink.internal.ParametersSerializer.ParametersSerializationFunction
            public final Serialization serializeParameters(Parameters parameters) {
                return AesGcmHkdfStreamingProtoSerialization.serializeParameters((AesGcmHkdfStreamingParameters) parameters);
            }
        }, AesGcmHkdfStreamingParameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.create(new ParametersParser.ParametersParsingFunction() { // from class: com.google.crypto.tink.streamingaead.internal.AesGcmHkdfStreamingProtoSerialization$$ExternalSyntheticLambda1
            private static long _BOUNDARY;
            private static char[] _CREATION;
            private static final byte[] $$c = {88, 106, -42, -33};
            private static final int $$d = 76;
            private static int $10 = 0;
            private static int $11 = 1;
            private static final byte[] $$a = {SignedBytes.MAX_POWER_OF_TWO, -46, -98, Ascii.DC2, 47, Ascii.VT, Ascii.SYN, 1, -3, -12, Ascii.VT, -8, 0, 17, -52, -2, -53, 17, -5, -8, 19, -19, 53, -13, -1};
            private static final int $$b = 206;
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
            private static java.lang.String $$e(byte r5, short r6, int r7) {
                /*
                    int r7 = r7 + 103
                    int r5 = r5 * 4
                    int r0 = 1 - r5
                    byte[] r1 = com.google.crypto.tink.streamingaead.internal.AesGcmHkdfStreamingProtoSerialization$$ExternalSyntheticLambda1.$$c
                    int r6 = r6 + 4
                    byte[] r0 = new byte[r0]
                    r2 = 0
                    int r5 = 0 - r5
                    if (r1 != 0) goto L14
                    r4 = r5
                    r3 = r2
                    goto L26
                L14:
                    r3 = r2
                L15:
                    int r6 = r6 + 1
                    byte r4 = (byte) r7
                    r0[r3] = r4
                    if (r3 != r5) goto L22
                    java.lang.String r5 = new java.lang.String
                    r5.<init>(r0, r2)
                    return r5
                L22:
                    int r3 = r3 + 1
                    r4 = r1[r6]
                L26:
                    int r7 = r7 + r4
                    goto L15
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.streamingaead.internal.AesGcmHkdfStreamingProtoSerialization$$ExternalSyntheticLambda1.$$e(byte, short, int):java.lang.String");
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0023  */
            /* JADX WARN: Code duplicated, block: B:8:0x001b  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002b). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static void b(short r6, short r7, short r8, java.lang.Object[] r9) {
                /*
                    byte[] r0 = com.google.crypto.tink.streamingaead.internal.AesGcmHkdfStreamingProtoSerialization$$ExternalSyntheticLambda1.$$a
                    int r6 = r6 + 66
                    int r1 = 4 - r7
                    int r8 = 21 - r8
                    byte[] r1 = new byte[r1]
                    int r7 = 3 - r7
                    r2 = 0
                    if (r0 != 0) goto L13
                    r6 = r7
                    r3 = r8
                    r4 = r2
                    goto L2b
                L13:
                    r3 = r2
                L14:
                    int r8 = r8 + 1
                    byte r4 = (byte) r6
                    r1[r3] = r4
                    if (r3 != r7) goto L23
                    java.lang.String r6 = new java.lang.String
                    r6.<init>(r1, r2)
                    r9[r2] = r6
                    return
                L23:
                    r4 = r0[r8]
                    int r3 = r3 + 1
                    r5 = r3
                    r3 = r8
                    r8 = r4
                    r4 = r5
                L2b:
                    int r6 = r6 + r8
                    int r6 = r6 + (-2)
                    r8 = r3
                    r3 = r4
                    goto L14
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.streamingaead.internal.AesGcmHkdfStreamingProtoSerialization$$ExternalSyntheticLambda1.b(short, short, short, java.lang.Object[]):void");
            }

            @Override // com.google.crypto.tink.internal.ParametersParser.ParametersParsingFunction
            public final Parameters parseParameters(Serialization serialization) {
                return AesGcmHkdfStreamingProtoSerialization.parseParameters((ProtoParametersSerialization) serialization);
            }

            private static void a(char c, int i, int i2, Object[] objArr) throws Throwable {
                int i3 = 2;
                int i4 = 2 % 2;
                _CREATION _creation = new _CREATION();
                long[] jArr = new long[i2];
                _creation.b = 0;
                int i5 = $10 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                $11 = i5 % 128;
                int i6 = i5 % 2;
                while (_creation.b < i2) {
                    int i7 = $10 + 95;
                    $11 = i7 % 128;
                    int i8 = i7 % i3;
                    int i9 = _creation.b;
                    try {
                        Object[] objArr2 = {Integer.valueOf(_CREATION[i + i9])};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) 0;
                            byte b2 = (byte) (b - 1);
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "", 0, 0) + 8, (char) (9280 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), 1977 - (ViewConfiguration.getWindowTouchSlop() >> 8), 1113883676, false, $$e(b, b2, (byte) (-b2)), new Class[]{Integer.TYPE});
                        }
                        Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i9), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                        if (objAccessartificialFrame2 == null) {
                            byte b3 = (byte) 0;
                            byte b4 = (byte) (b3 - 1);
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(30 - Color.blue(0), (char) (49362 - TextUtils.indexOf("", "", 0)), 684 - (ViewConfiguration.getJumpTapTimeout() >> 16), -115095555, false, $$e(b3, b4, (byte) (b4 + 4)), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                        }
                        jArr[i9] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                        Object[] objArr4 = {_creation, _creation};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                        if (objAccessartificialFrame3 == null) {
                            byte b5 = (byte) 0;
                            byte b6 = (byte) (b5 - 1);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((Process.myPid() >> 22) + 25, (char) (Process.getGidForName("") + 30069), 816 - ((Process.getThreadPriority(0) + 20) >> 6), 1897803493, false, $$e(b5, b6, (byte) (b6 + 1)), new Class[]{Object.class, Object.class});
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
                    int i10 = $10 + 81;
                    $11 = i10 % 128;
                    int i11 = i10 % 2;
                    cArr[_creation.b] = (char) jArr[_creation.b];
                    Object[] objArr5 = {_creation, _creation};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-293902099);
                    if (objAccessartificialFrame4 == null) {
                        byte b7 = (byte) 0;
                        byte b8 = (byte) (b7 - 1);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(25 - View.getDefaultSize(0, 0), (char) (30068 - Color.green(0)), 816 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 1897803493, false, $$e(b7, b8, (byte) (b8 + 1)), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                }
                objArr[0] = new String(cArr);
            }

            static {
                char[] cArr = new char[1959];
                ByteBuffer.wrap("\u00925\u008aV¢/Ú\u0014ò\u0095êµ\u0002\u0085;nS>K\u0014cã\u009bÑ³\u0092¨MÀKø&\u0010þ\bÀ ¯X\u0091qIi\r\u0081\u0019¹òÑ»É\u0091æo\u0019Ñ\u0001²)ËQðyqaQ\u0089a°\u008aØÚÀðè\u0007\u001058v#©K¾sÏ\u009b\u000e\u00833«qÓbú®âÄ\ní2\u0012ZZ\u009dë\u0085\u0088\u00adñÕÊýKåk\r[4°\\àDÊl=\u0094\u000f¼L§\u0093Ï\u0087÷å\u001f*\u0007\u000f\u0019Ñ\u0001¥)×Qõyqa[\u0089a°\u0082ØËÀúè\u000b\u0010i8y#\u0099K¢sÂ\u009b\u0018\u0083?«]Ónú\u0081âÔ\nï2\u0012ZJBsm\u009c\u0095¿\bð\u0010\u00928û@ÄhPps\u0098H¡éÉïÑÅù \u0001\u0017\u0019Ñ\u0001³)ÚQåyqaE\u0089g°\u008bØ\u0090Àæè\u001c\u0010)8n±Ù©\u00ad\u0081ÂùíÑ7ÉL!b\u0018ÁpähØ@+¸!\u0090`\u008b\u009bã\u0082ÛÏ3\u0002+?\u0094@\u008c#¤^Ücô®ì\u0088\u0004±=\u0014U_Mre\u0096\u009d¹µé®\b\u0019\u008c\u0001¹)\u0080Qäy1aY\u0089z°ÈØÌÀóè\n\u001048q#\u009fKªsù\u009b\u0010\u00833«ZÓYúºâØ\ný2Wö\u008eî»Æ\u0082¾æ\u00963\u008e[fx_Ê7Î/ñ\u0007\bÿ6×sÌ\u009d¤¨\u009cût\u0012l1DX<[\u0015¸\rÚåÿÝV\u0019Ñ\u0001¥)×Qõy*aS\u0089c°ÉØÒÀÿè\f\u0010i8r#\u009fK¬sÈ\u009b\u001c\u0083x«]Ói¶#®\u0000\u0086vþWÖ\u008eÎñ[-CYk+\u0013\t;Ö#¯Ë\u009fò5\u009a \u0082\u0003ªüR\u0095z\u008cao\t_1/ÙÔÁçéÿ\u0091\u0094¸G 'H\u0007p·\u0018¡\u0000\u0085/|×Nÿ\u0010çå\u008fÞöKî?ÆM¾o\u0096°\u008eÉfù_S7F/e\u0007\u009aÿó×êÌ\t¤9\u009cIt²l\u0081D\u0099<ì\u00156\rCåd\u0019Ñ\u0001¥)×Qõy*aS\u0089c°ÉØÒÀÿè\f\u0010i8r#\u009fK¬sÈ\u009b\u001b\u0083;«[ÓPú\u0093âÆ\nü2\tZNB8m\u009d\u0095©\u0019Ñ\u0001²)ËQðyqaX\u0089k°\u008bØËÀñè\u001b\u0010#8m#\u0082\u0019\u008c\u0001¹)\u0080Qäy+a_\u0089b°\u0082Ø\u0090Àþè\u0001\u001058jx!`\u0002H~0D\u0018\u008a\u0000©èÑÑ2¹{\u0019Ñ\u0001¦)ÜQéy=a\u0019\u0089h°\u008fØÒÀóè\u001d\u0010?8m#\u0082K«sË\u009b\r\u0019\u0090\u0001³)ÃQóy-aP\u0019¢\u0001\u0097Fè^Ývä\u000e\u0092&H>=Ö\u000eï÷\u0087¹\u009f\u0086·$OOg\u001b|ü\u0014ß,¤Ä{ÜQô>\u008c\u0017¥È½·U\u0098\u0019\u0099\u0001³)ÀQÿCR[os\u0000\u000b)#ë;\u0099Ó¦ê\u0014\u0082\u0011\u009a3²ÁJ´b yN\u0011<)\u001eÁÇÙèñ\u0087\u0089½ ,¸\rP\"hÏ\u0000Ì\u0018¬7SÏqç'ÿõ\u0097õ¯\u008aFW^Uv\u0000\u000e?&ì>\u008eÖ·íH\u0085\u0007\u009d8y;a\u0006Ii1@\u0019\u0082\u0001ðéÏÐ}¸x Z\u0088¨pÝXÉC'+U\u0013wû®ã\u0081Ëî³Ô\u009aE\u0082djKR¦:¥\"Å\r:õ\u0018ÝNÅ\u009c\u00ad\u009c\u0095ã|>d<Lm4V\u001c\u0085\u0004çìÔ×!\u0019\u008e\u0001³)ÜQõy7aE\u0089z°ÈØÍÀïè\u001d\u0010h8|#\u0092KàsÂ\u009b\u001b\u00834«[ÓaúðâÄ\ná2HZ]Bgm\u0087\u007fÓgîO\u00817¨\u001fj\u0007\u0018ï'Ö\u0095¾\u0090¦²\u008e@v5^!EÏ-½\u0015\u009fýFåiÍ\u0006µ<\u009c\u00ad\u0084\u0099l¼T\u0015<\u000f$*\u000bÐ:P\"m\n\u0002r+ZéB\u009bª¤\u0093\u0016û\u0013ã1ËÃ3¶\u001b¢\u0000Lh>P\u001c¸Å ê\u0088\u0085ð¿Ù.Á\u001a)?\u0011\u0096y\u008da«NS\u0091\u009c\u0089¡¡ÎÙçñ%éW\u0001h8ÚPßHý`\u000f\u0098z°n«\u0080ÃòûÐ\u0013\t\u000b&#I[srâjÖ\u0082óºZÒAÊjå\u009f\u0019\u0088\u0001´)ÁQþy-aP\u0019Ñ\u0001¦)ÜQéy=a\u0019\u0089c°\u0089ØÚÀãè\u0002\u0010#8m\u0019\u0088\u0001´)ÁQþy9aC\u0089k°\u0095ØÊ¦í¾ç\u0096\u0094î«ÆgÞ\r6.\u000fÛg\u0085\u007f¬\u0086»\u009e\u0088¶õÎØæ\u0001þq\u0016P\u0019\u009d\u0001¾)ÜQéy3a_\u0089{°\u008b¬¢´\u0097\u009c®äØÌ\u0002Ôw<D\u0005½móuÌ]n¥\f\u008dU\u0096®þ\u0089Æë.5A\u0097Y«qÞ\tá!y9\u001fÑa\u0019\u0099\u0001³)ÀQãy,a_\u0089m½Ü¥ö\u008d\u0085õ¦ÝiÅ\u001a-(\u0014ü|\u0083dëL\u001d\u00902\u0088\u0018 kØHð\u0087èô\u0000Æ9\u0012QmI\u0005aó\u0099²±\u0083ªi\u0019\u008c\u0001¹)\u0080Qöy,aY\u0089j°\u0093ØÝÀâè@\u0010+8q#\u0092K«sÊ\u0019\u008d\u0001²)Å\u0019\u009b\u0001»)ÛQêy?aB\u0089a°\u0094\u0019¿\u0001¦)ÞQ¦y\faC\u0089`°\u0092Ø×Àûè\u000b\u0010f8x#\u0099K¼s\u0086\u009b=\u0083>«\\Óiú³âÓúËâÌÊ¾²\u0080\u009aE\u0082+j\u001eS²;\u0099#¦\u000bQó\u0012Û\bÀ÷¨Ó\u0090¾x~`\u0002H<0\u001d\u0019Ø\u0001âé\u0082Ñ*¹|¶v®q\u0086\u0003þ=ÖøÎ\u0096&£\u001f\u000fw$o\u001bGì¿¯\u0097µ\u008cJänÜ\u00034Ã,¿\u0004\u0081| UeM_¥?\u009d\u0097õÁí\u0080Â\u0011:;\u0019\u008c\u0001¹)\u0080Qîy?aD\u0089j°\u0091ØßÀäè\u000b\u0011C\tc!\u0018Y8qâi\u0085\u0081§¸T\u008c\u0007\u0094;¼NÄqìéô\u008f\u0019\u008c\u0001·)ÀQåy6aC\u0092\u0080\u008aµ¢\u008cÚúò êU\u0002f;\u009fSÑKîcL\u009b(³`¨\u009bÀ¬øÎ\u0019\u008c\u0001¹)\u0080Qíy;aD\u0089`°\u0083ØÒÀ¸è\u001f\u0010#8s#\u0083\u0019Ïi\u008aq¿Y\u0086!ó\t=\u0011Sù}À\u0092¨Ý\u0019Î_ÁGôoÍ\u0017©?f'\u0012Ï/öÏ\u009eÝ\u0086«®QVd~7eÎ\rà5\u009f\u0019\u0098\u0001£)ÂQêy\u0001aN\u00896°Ð\u0019\u008c\u0001¹)\u0080Qäy+a_\u0089b°\u0082Ø\u0090Àðè\u0007\u0010(8y#\u0093K¼sÖ\u009b\f\u0083?«@Ór\u0019\u0099\u0001³)ÀQãy,a_\u0089m°ÉØÍÀòè\u0005\u0010i8y#\u0093K sÃ\u009b\f\u0083?«M\u0019\u0099\u0001³)ÀQãy,a_\u0089m°¹ØÆÀ®èX\u0010i8m#\u0092K¥sù\u009b\u0006\u0083n«\u0018Ó)ú¹âÓ\nà2\u0003ZLB\u007fm\u008d\u0095\u0099½æ¥NÍx\u0019\u0099\u0001³)ÀQãy,a_\u0089m°ÉØÙÀùè\u0001\u0010!8r#\u0093K\u0091sÕ\u009b\u001a\u0083=«\u0001Óaú»âØ\në2\u0014ZWBuH\u0096P¼xÏ\u0000ì(#0PØbáÆ\u0089Ç\u0091û¹\u000eA1i)rÏ\u001a±\"\u0086Ê\u0007Ò;úN\u0082q«é³\u008f[ñ\u0019\u0099\u0001¹)ÁQáy2aS\u0089!°\u0095ØÚÀýè1\u0010!8n#\u009eK¡sÈ\u009b\u001b\u0083\t«VÓ>úèâ\u0099\né2\u0003ZPBsm\u009c\u0095¯½ý¥)Í6õ\u001e\u001cÈg\u0096\u007f£W\u009a/þ\u0007+\u001fC÷`Î\u0090¦Ë¾í\u0096\u0010n9FvâðúÅÒüª\u0098\u0082M\u009a%r\u0006Kó#¯;\u008b\u0013uë_ÃLØè°Ç\u0088³`nxNP|(\u001c\u0001Ë\u0019¤ñ\u0095É\u007f¡0¹\u001a\u0096ànÓF\u008c^~H\u0093P\u0094xæ\u0000Ø(\u001d0sØFáç\u0089ê\u0091\u0082¹t\u0019\u008c\u0001¹)\u0080Qäy+a_\u0089b°\u0082Ø\u0090Àòè\u0007\u001058n#\u009aK¯sß\u009bP\u0083?«J\u0019\u008a\u0001³)ÝQòysp#h\f@s8F\u0010Ä\bñàÌÙ1±$©S\u0081¿y\u009fQßJo\"\n\u001a`ò¥ê\u0092Âé\u0019\u008f\u0001³)ÃQóypa^\u0089y°ÈØÓÀ÷è\u0007\u0010(8u#\u0093K·sÕ\u0019\u008f\u0001³)ÃQóypaE\u0089h°ÈØØÀ÷è\u0005\u0010#8A#\u0095K¯sË\u009b\u001b\u0083$«O ¯8\u0093\u0010ãhÓ@PXe°H\u0089èáòùÕÑ*)9\u0001Z\u001a³r\u0080Jõ¢7º\u0002\u0092wt|lIDp<\u001d\u0014Ë\f´ä\u0090Ýsµ\"\u00adH\u0085ÿ}ØU\u008aNt&Q\u001e?öêî\u0088Æ¯¾\u0093\u0097C\u008f3g\u001a\u0019\u008c\u0001¹)\u0080Qäy1aY\u0089z°ÈØÏÀóè\u0003\u0010380#\u0097K¸sÂ\u009b!\u00838«OÓkú»\u0019\u008c\u0001¹)\u0080Qéy:a[\u0089 °\u0084ØËÀÿè\u0002\u0010\"80#\u0090K§sÈ\u009b\u0019\u00833«\\Óvú¬âß\nà2\u0012\u0018ó\u0000Æ(ÿP\u0089xS`&\u0088\u0015±ìÙ¢Á\u009dé?\u0011[9\u0014\"àJÝr½\u009a/\u0082Oª8Ò\u0017ûÆã¬\u000b\u00833i[3C\u0000lÿ\u0094ÍDë\\Þtç\f\u0092$@<\"Ô\u001díä\u0085´\u009dßµkMTe\u0010~ý\u0016Í.ïÆ\u007fÞXö'\u008e\u0006§Ü¿£W\u0099os\u00070\u001f\u001f0ýö¾î\u008bÆ²¾Ç\u0096\u0015\u008ewfH_±7á/û\u00079ÿ\f×XÌê¤\u009e\u009cát%l\bDx<\u001a\u0015\u008a\ríåÒÝ3µi\u00adV\u0082¬z\u0086RÅJ*\"\b\u0019\u008c\u0001¹)\u0080Qðy;aX\u0089j°\u0089ØÌÀ¸è\f\u001038w#\u009aKªs\u0088\u009b\u0018\u0083?«@Óaú»âÄ\nþ2\u0014ZWBxm\u009a\u0019\u008c\u0001¹)\u0080Qðy;aX\u0089j°\u0089ØÌÀÉè\n\u0010*8u#\u009bKàsÄ\u009b\u000b\u0083?«BÓbúðâÐ\nç2\bZYBsm\u009c\u0095¶½ì¥\u001fÍ õR\u0085\u0015\nè\u0012\u008b:òBÉjHr~\u009aR£²ËòÓðû'\u0003\u0016+W0ª\u0019Ñ\u0001²)ËQðyqaE\u0089a°\u0085ØÕÀóè\u001a\u0010i8|#\u0097K½sÃ\u009b\u001c\u00837«@Óbú\u0081âÑ\në2\bZGBr\u0019Ñ\u0001²)ËQðyqaE\u0089a°\u0085ØÕÀóè\u001a\u0010i8y#\u0093K sß\u009b\u001a\u0019Ñ\u0001²)ËQðyqaE\u0089a°\u0085ØÕÀóè\u001a\u0010i8o#\u0093K£sÓ\u009b\u001a\u0019Ñ\u0001¥)×QõyqaG\u0089k°\u008bØËÀÉè\u001a\u001048\u007f#\u0095K«\u0019Ñ\u0001¥)×Qõy*aS\u0089c°ÉØÒÀÿè\f\u0010i8r#\u009fK¬sÅ\u009b!\u0083;«OÓjú²âÙ\ní29ZZBsm\u008c\u0095³½ù¥)Í?õC\u001c\u0093\u0004£,\u0080Tõ|1\u0010Å\b¦ ßXäpeh@\u0080i¹\u0086ÑõÉåá\n\u0019!\u0019Ñ\u0001²)ËQðyqaT\u0089}°\u0092ØáÀâè\u0007\u0010+8{\u001bý\u0003\u009e+çSÜ{]ci\u008bM²©ÚùÂßê6\u0012E:P!©I\u0096qì\u0099=\u0081\u0016©fÑOø\u0080àþ\u000eÒ\u0016¦>ÔFön)vP\u009e`§ÊÏÑ×üÿ\u000f\u0007j/q4\u009c\\¯dÇ\u008c\u000e\u0094!¼KÄjí±õÑ\u001dè%\u0017MbU\u007fz\u0083\u0082¬ª³²\u0006Ú\";u#\u0016\u000bosT[ÕCð«Ù\u00926ú{âQÊ©2\u0087\u0019Ñ\u0001²)ËQðyqaT\u0089}°\u0092ØÙÀïè\u001c\u0010)\u0019Ñ\u0001²)ËQðyqaT\u0089}°\u0092ØÓÀóè\t\u0010(\u0019Ñ\u0001²)ËQðyqaT\u0089}°\u0092ØÑÀäè\u0007\u0010#\u0019Ñ\u0001²)ËQðyqaT\u0089}°\u0092ØÈÀûè\u001d\u0010!\u0019Ñ\u0001²)ËQðyqaT\u0089}°\u0092ØÎÀñè\u000f\u0010/8n#\u0095\u0019Ñ\u0001²)ËQðyqaT\u0089}°\u0092ØáÀÿè\u0003\u0010#KUS6{K\u0003v+»3\u009dÛîâ\r\u008aM\u0092|º\u0086B\u00adjûq\u0016\u00199!\rÉÔÑªùÈ\u0081\u00ad¨8°AX~`\u0089\u0019Ñ\u0001»)ÀQòyqaA\u0089g°\u0088ØÚÀùè\u0019\u0010581#´K½sÒ\u009b-\u0083>«OÓtú»âÒ\nÈ2\tZRBrm\u008b\u0095´ó?ëHÃ2»\u0007\u0093Ó\u008b÷c\u0089Zg2 *\u0017\u0002òúÜÒ\u0083\u0019Î\u0001°)ÈQ¦ydL6TA|;\u0004\u000e,Ú4þÜ\u009aåd\u008d5\u0095\u0017½¦EÌm\u0098va\u001eZ\u0084Ô\u009cé´\u0082Ì§ä\u007fü\u0014\u0014 -\u0085E\u0094]´uO\u008do¥5¾ÒÖðî\u0083\u0006\u001d\u001eh6\f\u001d~\u0005S- U-}þe\u009f\u008d±´UÜ0Ä\tìö\u0014\u0084<\u0081'uÿMç/ÏF·y\u009fí\u0087Ço÷V\u001e>K&k\u000e\u00adö¹ÞíÅ\u000e\u00ad7\u0095Y}\u0091eäMÊ5÷\u001c.ïÁ÷çß\u0086§¾\u008fp\u0097\u001f\u007f2FØ.\u00886¸\u0019Ñ\u0001³)ÚQåyqa[\u0089a°\u0093ØÐÀâè\u001d,\u009c4ÿ\u001c\u0082d¿LrTT¼'\u0085Äí\u0084õµÝO%d\r2\u0016ß~ðFÄ®\u001d¶\u007f\u009e\u0013ædÏò×\u008b?³\u0007Xo]w#XÎ ç\u0019Ñ\u0001¦)ÜQéy=a\u0019\u0089m°\u0096ØËÀÿè\u0000\u0010 8q\u0019¹\u0001¹)ÂQây8a_\u0089}°\u008e¹\u0096¡õ\u0089\u0088ñµÙxÁ^)$\u0010Èx\u008a`²H\u0006°q\u0098+\u0083ÞëïÓ\u0088;U#t\u000b\u001asnZúB\u0084ª»\u0092\u000eúIâ~ÍÊ5î\u001d´\u0005\u001fmdU\b¼Ú¤ã\u008c\u0086ô·ÜpÄ\u0003,=\u0017\u008f\u007f\u0094g´OD·t\u009f0\u0086Üîì".getBytes(CharEncoding.ISO_8859_1)).asCharBuffer().get(cArr, 0, 1959);
                _CREATION = cArr;
                _BOUNDARY = -2985584802093661738L;
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
                    Method dump skipped, instruction units count: 15414
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.streamingaead.internal.AesGcmHkdfStreamingProtoSerialization$$ExternalSyntheticLambda1.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
            }
        }, bytesFromPrintableAscii, ProtoParametersSerialization.class);
        KEY_SERIALIZER = KeySerializer.create(new KeySerializer.KeySerializationFunction() { // from class: com.google.crypto.tink.streamingaead.internal.AesGcmHkdfStreamingProtoSerialization$$ExternalSyntheticLambda2
            @Override // com.google.crypto.tink.internal.KeySerializer.KeySerializationFunction
            public final Serialization serializeKey(Key key, SecretKeyAccess secretKeyAccess) {
                return AesGcmHkdfStreamingProtoSerialization.serializeKey((AesGcmHkdfStreamingKey) key, secretKeyAccess);
            }
        }, AesGcmHkdfStreamingKey.class, ProtoKeySerialization.class);
        KEY_PARSER = KeyParser.create(new KeyParser.KeyParsingFunction() { // from class: com.google.crypto.tink.streamingaead.internal.AesGcmHkdfStreamingProtoSerialization$$ExternalSyntheticLambda3
            @Override // com.google.crypto.tink.internal.KeyParser.KeyParsingFunction
            public final Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
                return AesGcmHkdfStreamingProtoSerialization.parseKey((ProtoKeySerialization) serialization, secretKeyAccess);
            }
        }, bytesFromPrintableAscii, ProtoKeySerialization.class);
    }

    private static HashType toProtoHashType(AesGcmHkdfStreamingParameters.HashType hashType) throws GeneralSecurityException {
        if (AesGcmHkdfStreamingParameters.HashType.SHA1.equals(hashType)) {
            return HashType.SHA1;
        }
        if (AesGcmHkdfStreamingParameters.HashType.SHA256.equals(hashType)) {
            return HashType.SHA256;
        }
        if (AesGcmHkdfStreamingParameters.HashType.SHA512.equals(hashType)) {
            return HashType.SHA512;
        }
        throw new GeneralSecurityException("Unable to serialize HashType " + hashType);
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.streamingaead.internal.AesGcmHkdfStreamingProtoSerialization$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$HashType;

        static {
            int[] iArr = new int[HashType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$HashType = iArr;
            try {
                iArr[HashType.SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA256.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static AesGcmHkdfStreamingParameters.HashType toHashType(HashType hashType) throws GeneralSecurityException {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$HashType[hashType.ordinal()];
        if (i == 1) {
            return AesGcmHkdfStreamingParameters.HashType.SHA1;
        }
        if (i == 2) {
            return AesGcmHkdfStreamingParameters.HashType.SHA256;
        }
        if (i == 3) {
            return AesGcmHkdfStreamingParameters.HashType.SHA512;
        }
        throw new GeneralSecurityException("Unable to parse HashType: " + hashType.getNumber());
    }

    private static AesGcmHkdfStreamingParams toProtoParams(AesGcmHkdfStreamingParameters aesGcmHkdfStreamingParameters) throws GeneralSecurityException {
        return AesGcmHkdfStreamingParams.newBuilder().setCiphertextSegmentSize(aesGcmHkdfStreamingParameters.getCiphertextSegmentSizeBytes()).setDerivedKeySize(aesGcmHkdfStreamingParameters.getDerivedAesGcmKeySizeBytes()).setHkdfHashType(toProtoHashType(aesGcmHkdfStreamingParameters.getHkdfHashType())).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoParametersSerialization serializeParameters(AesGcmHkdfStreamingParameters aesGcmHkdfStreamingParameters) throws GeneralSecurityException {
        return ProtoParametersSerialization.create(KeyTemplate.newBuilder().setTypeUrl(TYPE_URL).setValue(AesGcmHkdfStreamingKeyFormat.newBuilder().setKeySize(aesGcmHkdfStreamingParameters.getKeySizeBytes()).setParams(toProtoParams(aesGcmHkdfStreamingParameters)).build().toByteString()).setOutputPrefixType(OutputPrefixType.RAW).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoKeySerialization serializeKey(AesGcmHkdfStreamingKey aesGcmHkdfStreamingKey, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        return ProtoKeySerialization.create(TYPE_URL, com.google.crypto.tink.proto.AesGcmHkdfStreamingKey.newBuilder().setKeyValue(ByteString.copyFrom(aesGcmHkdfStreamingKey.getInitialKeyMaterial().toByteArray(SecretKeyAccess.requireAccess(secretKeyAccess)))).setParams(toProtoParams(aesGcmHkdfStreamingKey.getParameters())).build().toByteString(), KeyData.KeyMaterialType.SYMMETRIC, OutputPrefixType.RAW, aesGcmHkdfStreamingKey.getIdRequirementOrNull());
    }

    private static AesGcmHkdfStreamingParameters toParametersObject(AesGcmHkdfStreamingParams aesGcmHkdfStreamingParams, int i) throws GeneralSecurityException {
        return AesGcmHkdfStreamingParameters.builder().setKeySizeBytes(i).setDerivedAesGcmKeySizeBytes(aesGcmHkdfStreamingParams.getDerivedKeySize()).setCiphertextSegmentSizeBytes(aesGcmHkdfStreamingParams.getCiphertextSegmentSize()).setHkdfHashType(toHashType(aesGcmHkdfStreamingParams.getHkdfHashType())).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AesGcmHkdfStreamingParameters parseParameters(ProtoParametersSerialization protoParametersSerialization) throws GeneralSecurityException {
        if (!protoParametersSerialization.getKeyTemplate().getTypeUrl().equals(TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmHkdfStreamingParameters.parseParameters: " + protoParametersSerialization.getKeyTemplate().getTypeUrl());
        }
        try {
            AesGcmHkdfStreamingKeyFormat from = AesGcmHkdfStreamingKeyFormat.parseFrom(protoParametersSerialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry());
            if (from.getVersion() != 0) {
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            }
            return toParametersObject(from.getParams(), from.getKeySize());
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("Parsing AesGcmHkdfStreamingParameters failed: ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AesGcmHkdfStreamingKey parseKey(ProtoKeySerialization protoKeySerialization, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        if (!protoKeySerialization.getTypeUrl().equals(TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmHkdfStreamingParameters.parseParameters");
        }
        try {
            com.google.crypto.tink.proto.AesGcmHkdfStreamingKey from = com.google.crypto.tink.proto.AesGcmHkdfStreamingKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            if (from.getVersion() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return AesGcmHkdfStreamingKey.create(toParametersObject(from.getParams(), from.getKeyValue().size()), SecretBytes.copyFrom(from.getKeyValue().toByteArray(), SecretKeyAccess.requireAccess(secretKeyAccess)));
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("Parsing AesGcmHkdfStreamingKey failed");
        }
    }

    public static void register() throws GeneralSecurityException {
        register(MutableSerializationRegistry.globalInstance());
    }

    public static void register(MutableSerializationRegistry mutableSerializationRegistry) throws GeneralSecurityException {
        mutableSerializationRegistry.registerParametersSerializer(PARAMETERS_SERIALIZER);
        mutableSerializationRegistry.registerParametersParser(PARAMETERS_PARSER);
        mutableSerializationRegistry.registerKeySerializer(KEY_SERIALIZER);
        mutableSerializationRegistry.registerKeyParser(KEY_PARSER);
    }

    private AesGcmHkdfStreamingProtoSerialization() {
    }
}
