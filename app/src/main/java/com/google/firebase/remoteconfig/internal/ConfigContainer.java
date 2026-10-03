package com.google.firebase.remoteconfig.internal;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.os.Process;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import o.ArtificialStackFrames;
import o._CREATION;
import org.apache.commons.lang3.CharEncoding;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ConfigContainer {
    static final String ABT_EXPERIMENTS_KEY = "abt_experiments_key";
    static final String CONFIGS_KEY = "configs_key";
    private static final Date DEFAULTS_FETCH_TIME = new Date(0);
    static final String FETCH_TIME_KEY = "fetch_time_key";
    static final String PERSONALIZATION_METADATA_KEY = "personalization_metadata_key";
    public static final String ROLLOUT_METADATA_AFFECTED_KEYS = "affectedParameterKeys";
    public static final String ROLLOUT_METADATA_ID = "rolloutId";
    static final String ROLLOUT_METADATA_KEY = "rollout_metadata_key";
    public static final String ROLLOUT_METADATA_VARIANT_ID = "variantId";
    static final String TEMPLATE_VERSION_NUMBER_KEY = "template_version_number_key";
    private JSONArray abtExperiments;
    private JSONObject configsJson;
    private JSONObject containerJson;
    private Date fetchTime;
    private JSONObject personalizationMetadata;
    private JSONArray rolloutMetadata;
    private long templateVersionNumber;

    private ConfigContainer(JSONObject jSONObject, Date date, JSONArray jSONArray, JSONObject jSONObject2, long j, JSONArray jSONArray2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(CONFIGS_KEY, jSONObject);
        jSONObject3.put(FETCH_TIME_KEY, date.getTime());
        jSONObject3.put(ABT_EXPERIMENTS_KEY, jSONArray);
        jSONObject3.put(PERSONALIZATION_METADATA_KEY, jSONObject2);
        jSONObject3.put(TEMPLATE_VERSION_NUMBER_KEY, j);
        jSONObject3.put(ROLLOUT_METADATA_KEY, jSONArray2);
        this.configsJson = jSONObject;
        this.fetchTime = date;
        this.abtExperiments = jSONArray;
        this.personalizationMetadata = jSONObject2;
        this.templateVersionNumber = j;
        this.rolloutMetadata = jSONArray2;
        this.containerJson = jSONObject3;
    }

    public static class Builder {
        private static long _BOUNDARY;
        private static char[] _CREATION;
        private JSONArray builderAbtExperiments;
        private JSONObject builderConfigsJson;
        private Date builderFetchTime;
        private JSONObject builderPersonalizationMetadata;
        private JSONArray builderRolloutMetadata;
        private long builderTemplateVersionNumber;
        private static final byte[] $$c = {Ascii.US, Ascii.FS, -113, 86};
        private static final int $$d = 224;
        private static int $10 = 0;
        private static int $11 = 1;
        private static final byte[] $$a = {70, -105, 85, -56, 53, -47, -11, -17, 5, Ascii.FF, -11, 8, 2, 52, 0, -17, -22, -1, 3, -53, Ascii.CR, 1, 8, -19, 19};
        private static final int $$b = 62;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;

        /* JADX WARN: Code duplicated, block: B:10:0x0024  */
        /* JADX WARN: Code duplicated, block: B:8:0x001e  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0026). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$e(byte r5, int r6, byte r7) {
            /*
                int r6 = r6 + 103
                int r5 = r5 * 2
                int r0 = 1 - r5
                byte[] r1 = com.google.firebase.remoteconfig.internal.ConfigContainer.Builder.$$c
                int r7 = r7 * 4
                int r7 = r7 + 4
                byte[] r0 = new byte[r0]
                r2 = 0
                int r5 = 0 - r5
                if (r1 != 0) goto L16
                r3 = r5
                r4 = r2
                goto L26
            L16:
                r3 = r2
            L17:
                byte r4 = (byte) r6
                r0[r3] = r4
                int r4 = r3 + 1
                if (r3 != r5) goto L24
                java.lang.String r5 = new java.lang.String
                r5.<init>(r0, r2)
                return r5
            L24:
                r3 = r1[r7]
            L26:
                int r3 = -r3
                int r6 = r6 + r3
                int r7 = r7 + 1
                r3 = r4
                goto L17
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.ConfigContainer.Builder.$$e(byte, int, byte):java.lang.String");
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0023  */
        /* JADX WARN: Code duplicated, block: B:8:0x001b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002a). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static void a(short r6, short r7, short r8, java.lang.Object[] r9) {
            /*
                byte[] r0 = com.google.firebase.remoteconfig.internal.ConfigContainer.Builder.$$a
                int r7 = r7 + 4
                int r1 = 4 - r6
                int r8 = 115 - r8
                byte[] r1 = new byte[r1]
                int r6 = 3 - r6
                r2 = 0
                if (r0 != 0) goto L13
                r4 = r6
                r8 = r7
                r3 = r2
                goto L2a
            L13:
                r3 = r2
            L14:
                int r7 = r7 + 1
                byte r4 = (byte) r8
                r1[r3] = r4
                if (r3 != r6) goto L23
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L23:
                int r3 = r3 + 1
                r4 = r0[r7]
                r5 = r8
                r8 = r7
                r7 = r5
            L2a:
                int r4 = -r4
                int r7 = r7 + r4
                int r7 = r7 + (-2)
                r5 = r8
                r8 = r7
                r7 = r5
                goto L14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.ConfigContainer.Builder.a(short, short, short, java.lang.Object[]):void");
        }

        private static void b(char c, int i, int i2, Object[] objArr) throws Throwable {
            int i3 = 2 % 2;
            _CREATION _creation = new _CREATION();
            long[] jArr = new long[i2];
            _creation.b = 0;
            int i4 = $10 + 73;
            $11 = i4 % 128;
            if (i4 % 2 == 0) {
                int i5 = 3 / 5;
            }
            while (_creation.b < i2) {
                int i6 = _creation.b;
                try {
                    Object[] objArr2 = {Integer.valueOf(_CREATION[i + i6])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 0;
                        byte b2 = (byte) (b + 1);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(7 - ImageFormat.getBitsPerPixel(0), (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 9278), 1977 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 1113883676, false, $$e(b, b2, (byte) (b2 - 1)), new Class[]{Integer.TYPE});
                    }
                    Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i6), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 0;
                        byte b4 = (byte) (b3 + 3);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(((Process.getThreadPriority(0) + 20) >> 6) + 30, (char) (49362 - View.MeasureSpec.getSize(0)), ImageFormat.getBitsPerPixel(0) + 685, -115095555, false, $$e(b3, b4, (byte) (b4 - 3)), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                    }
                    jArr[i6] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                    Object[] objArr4 = {_creation, _creation};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                    if (objAccessartificialFrame3 == null) {
                        byte b5 = (byte) 0;
                        byte b6 = b5;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(View.getDefaultSize(0, 0) + 25, (char) (30068 - Color.red(0)), 817 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), 1897803493, false, $$e(b5, b6, b6), new Class[]{Object.class, Object.class});
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
                int i7 = $11 + 15;
                $10 = i7 % 128;
                int i8 = i7 % 2;
                cArr[_creation.b] = (char) jArr[_creation.b];
                Object[] objArr5 = {_creation, _creation};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-293902099);
                if (objAccessartificialFrame4 == null) {
                    byte b7 = (byte) 0;
                    byte b8 = b7;
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(25 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) (30069 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), (Process.myTid() >> 22) + 816, 1897803493, false, $$e(b7, b8, b8), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                int i9 = $11 + 63;
                $10 = i9 % 128;
                int i10 = i9 % 2;
            }
            objArr[0] = new String(cArr);
        }

        private Builder() {
            this.builderConfigsJson = new JSONObject();
            this.builderFetchTime = ConfigContainer.DEFAULTS_FETCH_TIME;
            this.builderAbtExperiments = new JSONArray();
            this.builderPersonalizationMetadata = new JSONObject();
            this.builderTemplateVersionNumber = 0L;
            this.builderRolloutMetadata = new JSONArray();
        }

        public Builder(ConfigContainer configContainer) {
            this.builderConfigsJson = configContainer.getConfigs();
            this.builderFetchTime = configContainer.getFetchTime();
            this.builderAbtExperiments = configContainer.getAbtExperiments();
            this.builderPersonalizationMetadata = configContainer.getPersonalizationMetadata();
            this.builderTemplateVersionNumber = configContainer.getTemplateVersionNumber();
            this.builderRolloutMetadata = configContainer.getRolloutMetadata();
        }

        public Builder replaceConfigsWith(Map<String, String> map) {
            this.builderConfigsJson = new JSONObject(map);
            return this;
        }

        public Builder replaceConfigsWith(JSONObject jSONObject) {
            try {
                this.builderConfigsJson = new JSONObject(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public Builder withFetchTime(Date date) {
            this.builderFetchTime = date;
            return this;
        }

        public Builder withAbtExperiments(JSONArray jSONArray) {
            try {
                this.builderAbtExperiments = new JSONArray(jSONArray.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public Builder withPersonalizationMetadata(JSONObject jSONObject) {
            try {
                this.builderPersonalizationMetadata = new JSONObject(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public Builder withTemplateVersionNumber(long j) {
            this.builderTemplateVersionNumber = j;
            return this;
        }

        public Builder withRolloutMetadata(JSONArray jSONArray) {
            try {
                this.builderRolloutMetadata = new JSONArray(jSONArray.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public ConfigContainer build() throws JSONException {
            return new ConfigContainer(this.builderConfigsJson, this.builderFetchTime, this.builderAbtExperiments, this.builderPersonalizationMetadata, this.builderTemplateVersionNumber, this.builderRolloutMetadata);
        }

        static {
            char[] cArr = new char[1959];
            ByteBuffer.wrap("\u0019Ñn\u001eö\u0093\u007f\u0004ÇÁL\rÔ\u0089]\u000e¥º*<²¿;!\u0083¦\b\u0015\u0090§\u0019&aÚöH~ÓÇAOÝÔu\\Õ¥R-ÿ²y:ó\u0085lò£j.ã¹[|Ð°H4Á³9\u0007¶\u0081.\u0002§\u009c\u001f\u001b\u0094¨\f\u000b\u0085\u0096ýsjââT[ëÓcHåÀx9ë±G\u0019Ñn\u001eö\u0093\u007f\u0004ÇÁL\rÔ\u0089]\u000e¥º*<²¿;!\u0083¦\b\u0015\u0090µ\u0019;aÐöY:ÿM'Õ¡\\/äïo)÷§~(\u0086\u0085\t\u0018\u0091\u009d\u0018S \u0087+\u000b³\u0084:\bBöÕ}]ëätlß÷f\u007fé\u0086x\u000eÄ\u0091Q\u0019Ê E\u0019Ñn\u001fö\u0082\u007f\u0011ÇÁL\u000eÔ\u0081]L¥®*(²¹;\"BÅ5\u000b\u00ad\u0096$\u0005\u009cÕ\u0017\r\u008f\u009b\u0006\u001bþäq>é°`)Øª\n}}¥å>l½Ô#_´Ç.Ná¶ 9°¡7(\u0091\u0090\u0014\u001b\u0083\u0083.\n\u008frfå÷Ù\u0087®H6Á¿P\u0007Ù\u008c\u0013\u0014\u009e\u009dWeøêyréûjCþÈs\u0019\u008cn\u0015öØ\u007f\u0010Ç\u0081L\u0005Ô\u0092]L¥¬*?²²; \u0083¡\b#\u0090¢\u0019\u001daÐö_~ÂÇmOÊÔD\\Õ¥\u0013Èº¿#'î®&\u0016·\u009d3\u0005¤\u008czt\u009aû\tc\u0084ê\u0016R\u0097Ù\u0015A\u0094È+°æ'i¯ô\u0016[\u009eü\u0005r\u008dãt&ãª\u0094r\fô\u0085z=á¶t.ð§6_ÉÐHHÏÁ\u0006yÙòXjßãW\u009b§\fo\u0084¾=&ìÿ\u009bp\u0003ò\u008a\u007f2â¹qeý\u0012d\u0019Ñn\tö\u008f\u007f\u0001Ç\u009aL\u000fÔ\u008b]M¥¼*3²¸;}\u0083 \b/\u0090«\u00197aèöw~\u009bÇ\\OËÔG\\Ó¥\u000f-ý²u:ø\u0083f\u000bü\u0090e\u0018ê\u0019Ñn\tö\u008f\u007f\u0001Ç\u009aL\u000fÔ\u008b]M¥¼*3²¸;}\u0083 \b/\u0090«\u00197aèöw~\u009bÇBOÜÔE\\Ö\u0019Ñn\tö\u008f\u007f\u0001Ç\u009aL\u000fÔ\u008b]M¥²*3²´;}\u0083¢\b#\u0090¤\u0019,aÛöW~ÃÇdOãÔZ\\Ô¥M-î²4:å\u0083}Tf#©»$2³\u008av\u0001³\u00994\u0010¸è\u001cg\u008aÿ\u0014v\u0080Î\nE\u0089\u0019\u008cn\u0015öØ\u007f\u0010Ç\u009bL\u0003Ô\u008a]\u0006¥ð*2²¹;!\u0083ºÓ\u0096¤\u0019<\u0091µ\u0007\r\u008d\u0086B\u001e\u008e\u0097\u0001o¬\u0015<bçúisðË`@¨ØmQæ©_&Ò¾H7Æ\u008fP\u0004Ó\u009cN\u0015Âm \u0019\u0090n\u001fö\u009b\u007f\u0007Ç\u009dL\f\u0019\u008cn\u0015öØ\u007f\u0002Ç\u009cL\u0005Ô\u0082]\u0017¥½*.²ø;?\u0083¯\b$\u0090³\u0019$aßöY~ÂÇGOÜÔO\\Ô¼OËÉSNÚÝ\u0019\u008en\u001fö\u0084\u007f\u0001Ç\u0087L\u0019Ô\u0092]L¥\u00ad*#²¥;|\u0083¬\b.\u0090è\u0019&aÛöX~ÃÇUO\u0080ÔM\\Ö¥W-°²|:÷\u0083y\u000bë\u0090U\u0018áaré\u000bq¥Æ\u0004N\u0097×\u0000_\u008e¤\u0003,\u0090µ;=¨Ú2\u00ad£58¼½\u0004;\u008f¥\u0017.\u009eðf\u0011é\u009fq\u0019øÀ@\u0010Ë\u0092STÚ\u009a¢g5ä½\u007f\u0004é\u008c<\u0017ñ\u009fjfëî\fqÀùK@ÅÈWSéÛ]¢Î*·²\u0019\u0005¼\u008d+\u0014¼\u009c2gµï,\u0019\u008en\u001fö\u0084\u007f\u0001Ç\u0087L\u0019Ô\u0092]L¥\u00ad*#²¥;|\u0083¬\b.\u0090è\u0019&aÛöX~ÃÇUO\u0080ÔX\\É¥\f-ý²k:ÿéÛ\u009eJ\u0006Ñ\u008fT7Ò¼L$Ç\u00ad\u0019UøÚvBðË)sùø{`½és\u0091\u008e\u0006\r\u008e\u00967\u0000¿Õ$\r¬\u009cUYÝ§B.Ê \u0019\u008en\u001fö\u0084\u007f\u0001Ç\u0087L\u0019Ô\u0092]L¥\u00ad*#²¥;|\u0083¬\b.\u0090è\u0019&aÛöX~ÃÇUO\u0080ÔX\\É¥\f-ó²y:õ\u001cKkÚóAzÄÂBIÜÑWX\u0089 h/æ·`>¹\u0086i\rë\u0095-\u001cãd\u001eó\u009d{\u0006Â\u0090JEÑ\u009dY\f É(6·±?0\u0019\u0088n\u0018ö\u0099\u007f\nÇ\u009dL\f\u0019Ñn\nö\u0084\u007f\u001dÇ\u008dLEÔ\u008b]\r¥º*/²º;7\u0083½\u0019\u0088n\u0018ö\u0099\u007f\nÇ\u0089L\u001fÔ\u0083]\u0011¥ªøR\u008fô\u0017s\u009eà&h\u00adî5y¼àDZËßç&\u0090¹\b0\u0081±9,²°*%P\u001e'\u0091¿\u00076\u009e\u008e\u0000\u0005\u0080\u009d\u0010\u0014\u008c\u0019\u008cn\u0015öØ\u007f\u0002Ç\u009cL\u0005Ô\u0082]\u0017¥½*.²ø;6\u0083«\b<\u0090¯\u0019!aÛ\u0019\u0088n\u0018ö\u0099\u007f\nÇÖL\\Ô\u0096\u0094åãc{äòkJàÁ\u007fYù5\u0085B\u0003Ú\u0084S\u000bë\u0080`\u001fø\u0099q!\u0089º\u0006~\u009eü\u0019ãneöâ\u007fmÇæLyÔÿ]G¥Ü*\u0018²\u009a;w\u0083\u0082\b\u0004ûS\u008cÊ\u0014\u0007\u009dÝ%C®Ú6]¿ÈGbÈñP'Ùàa~êñr|ûñ\u0086\u0013ñ\u0080i\u0003è>\u009f²\u0007&\u008e»6*½»%,¬µê\u0080\u009d5\u0005¹\u008cm4\u0083¿ '·®)V\u0088Ù\bA\u008cÈMp\u0097û\u001ac\u008bê]\u0092Â\u0005m\u008dû4b¼ü'p\u0019¿n\u0014ö\u0092\u007f\u0000Ç\u0081L\u0003Ô\u0082]B¥\u008d*\u001e²\u009d;r\u0083¬\b?\u0090¯\u0019.aÊö\u001a~ÐÇ]OÜÔ\n\\Þ¥\u001a-¨F\u007f1Ô©R À\u0098A\u0013Ã\u008bB\u0002\u0082úMuÞí]d²ÜlWÿÏoFî>\n©Ú!\u0010\u0098\u009d\u0010\u001c\u008bÊ\u0003\u001eúÚrhí\u0085e`Üæ\u0019\u008cn\u0015öØ\u007f\u001aÇ\u008fL\u0018Ô\u0082]\u0015¥¿*(²³\"\tU\u0085Í\nD\u0086ü\u0018w\u0093ï\u0005f\u009aõÎ\u0082^\u001aß\u0093L+\u0090 \u001aK¿<(¤«-\"\u0095µ\u001e,\u0019\u008cn\u0015öØ\u007f\u0002Ç\u009cL\u0005Ô\u0082]\u0017¥½*.²ø;0\u0083¼\b+\u0090¨\u0019&?rHëÐ&Yçáujæòv{ù\u0083L\f\u008a\u0094Y\u001dÉ¥].Á\\\u009ai@\u001eÙ\u0086\u0014\u000fÍ·G<Å¤_-ÜÕwßX\u0019\u008cn\u0015öØ\u007f\u0010Ç\u009bL\u0003Ô\u008a]\u0006¥ð**²¤;=\u0083ª\b?\u0090¥\u00196G\u00810\u0016¨\u0083!\u0007\u0099¨\u0012\u000b\u008aÇ\u0003Mâi\u0095ð\r=\u0084õ<~·æ/o¦ã^\u0015ÑÙIZÀÙxLóÊkQâ×\u009a)\r¶\u0085=<£\u0019\u0099n\u001fö\u0098\u007f\u0017Ç\u009cL\u0003Ô\u0085]M¥\u00ad*>²½;}\u0083©\b/\u0090¨\u0019'aÌöS~Õ\u0019\u0099n\u001fö\u0098\u007f\u0017Ç\u009cL\u0003Ô\u0085]=¥¦*b²à;}\u0083½\b.\u0090\u00ad\u0019\u001daÆö\u0002~\u0080Ç\u001dOÉÔO\\È¥G-ì²s:õ\u0083M\u000bö\u00902\u0018°ïÞ\u0098X\u0000ß\u0089P1ÛºD\"Â«\nSþÜrDþÍruåþhfÞïv\u0097\u009d\u0000\u0016\u0088Þ1\u0012¹\u008c\"\u0003ª\u0084S\u0017Û°D>Ò·¥1=¶´9\f²\u0087-\u001f«\u0096cn\u0086á\u0016y\u0097ð\u0004HØÃR[\u0098ÒCªæ=vµ÷\fd\u0084¸\u001f2\u0097ø\u0086~ñòi~àòXeÓèK.Âö:]µÖ-n¤Ò\u001cY\u0097Å\u000fN\u0086Ëþ<i\u0082á)XíÐ\u007fKâÃ&: ²\u0017-\u0098¥\u0003\u001c\u009c\u0094\n\u000f²\u0087\u0019þÝv¯ï\u0081\u0098\u0018\u0000Õ\u0089\u001d1\u008cº\b\"\u009f«\u0003S¼Ü6D¿Í:u±0BGÛß\u0016VÞîOeËý\\tÅ\u008c}\u0003õ\u009b\u007f\u0012ùª.!æ¹}0åH\u001cß\u0090WVî\u009af\tý\u008au\u000f\u008c\u0089\u0004\"\u009b¤\u0013*ªµ\".¹°\u008b+ü\u0080d\u0006í\u0094U\u0015Þ\u0097F\u0016ÏÛ72¸ö t\u0019\u008cn\u0015öØ\u007f\u0010Ç\u009bL\u0003Ô\u008a]\u0006¥ð*>²¿;!\u0083¾\b&\u0090§\u0019;a\u0090öS~Òdl\u0013ù\u008bc\u0002àº%ê_\u009dÜ\u0005W\u008cÎ4\b¿Ñ'X®ÉV8ÙãA{È÷psû¯c~êø\u0092\u0019\u0005\u0082\u008d\r\u0085\u0085ò\u0015j\u0091ã\r[ÊÐ\bH\u009bÁF9¹¶1.µ§6\u001f¯\u0094%\fµ\u0085;\u0019\u008fn\u001fö\u009b\u007f\u0007ÇÀL\u0019Ô\u0080]L¥¸*;²½;7\u0083\u0091\b)\u0090§\u0019/aÛöH~×\u0019\u008fn\u001fö\u009b\u007f\u0007ÇÀL\u0019Ô\u0080]L¥²*9²²;\r\u0083ª\b/\u0090¨\u00191a×öN~Ï\u0019\u008cn\u0015öØ\u007f\u0019Ç\u008bL\u0018Ô\u0088]\u0007¥²*t²·;<\u0083ª\b8\u0090©\u0019+aÚö\u0014~ÇÇWOÃÔ_\\Â\u0019\u008cn\u0015öØ\u007f\u0010Ç\u0081L\u0005Ô\u0092]L¥¯*?²»;'\u0083à\b+\u0090°\u0019&aáöT~×Ç_OË½ßÊFR\u008bÛNcÙèTp\u009bùS\u0001ø\u008e`\u0016é\u009fe'³¬\u007f4ü½\u007fÅ\u008aR\fÚ\u0097c\u0011ë\u008fp\u0010ø\u009b\u0001\u0005µ\u0016Â\u008fZBÓ\u0098k\u0006à\u009fx\u0018ñ\u008d\t'\u0086´\u001eb\u0097ª/!¤¹<0µ¼Í\nZÆÒEkÆãSxÕðN\tÈ\u0081v\u001eé\u0096b/ü\u007fÇ\b^\u0090\u0093\u0019J¡Ü*R²Ù;LÃøL?Ôÿ]låìnmöé\u007f'\u0007\u0093\u0090\u0018\u0018\u0093¡\u001e)\u0080²\u0013:\u009dÃ\u001bK¼Ô?\\©\u0019\u008cn\u0015öØ\u007f\u0001Ç\u0097L\u0019Ô\u0092]\u0007¥³*\u0005²³;*\u0083º\bd\u0090¤\u00197a×öV~ÒÇ\u001cOÈÔC\\È¥E-û²h:æ\u0083`\u000bç\u0090d\u0018ò'ûPbÈ¯Asùürsêõcz\u009bÛ\u0014\u0003\u008cÃ\u0005P½Ð6Q®Õ'\u001b_¯È$@¯ù\"q¼ê/b¡\u009b'\u0013\u0080\u008c\u0003\u0004\u0095Ã°´),ä¥8\u001d·\u00968\u000e¾\u00871\u007f\u0090ð9h\u008eá\u0002Y\u0099Ò\u001bJÔÃ\u001c»÷,o¤æ\u001dj\u0095¼\u000ep\u0086ó\u007fp÷ÅhCàØY^ÑÀJ_ÂÔ»J\u0019Ä\u0019Ñn\u001eö\u0093\u007f\u0004ÇÁL\u001bÔ\u0083]\u000f¥«*\u0005²¦;;\u0083¾\b/ö\b\u0081Ç\u0019J\u0090Ý(\u0018£À;P²ØJlÅæ]{Ô¤luçò\u007flöþ\u008e\u0005\u0019\u0082\u0091\u0001(\u008f (;\u0094³\u001aJ\u0095Â>]§\u0019Ñn\u001eö\u0093\u007f\u0004ÇÁL\u0019Ô\u0089]\u0001¥µ*?²¢;}\u0083©\b/\u0090¨\u0019;aÚôÜ\u0083\u0013\u001b\u009e\u0092\t*Ì¡\u00149\u0084°\fH¸Ç2_¯Öpn²å\"}¦ô:\u008c×O\u001f8Ç A)Ï\u0091\u000f\u001aÕ\u0082M\u000bÁóe|ËälmîÕa^çÆm\u0019Ñn\tö\u008f\u007f\u0001Ç\u009aL\u000fÔ\u008b]M¥²*3²´;}\u0083¢\b#\u0090¤\u0019!aáöW~×Ç^OÂÔE\\Å¥}-ú²\u007f:ô\u0083g\u000bé\u0090U\u0018÷agé\u0013q\u008fÆXN\u0081×\u0001\u0019Ñn\u001eö\u0093\u007f\u0004ÇÁL\bÔ\u0095]\u0016¥\u0081*=²¦;!\u0019Ñn\u001eö\u0093\u007f\u0004ÇÁL\bÔ\u0095]\u0016¥\u0081*.²¿;?\u0083«\u0019Ñn\u001eö\u0093\u007f\u0004ÇÁL\u0019Ô\u0089]\u0001¥µ*?²¢;}\u0083¬\b9\u0090²\u0019$aÑöV~ÒÇWOÜÔN\u0019Ñn\tö\u008f\u007f\u0001Ç\u009aL\u000fÔ\u008b]M¥²*3²´;}\u0083¢\b#\u0090¤\u0019 aÍöN~ÐÇ]OÂÔN\\Ã¥P-Á²p:ø\u0083{\u000b \u0090y\u0018é\u0019Ñn\u001eö\u0093\u007f\u0004ÇÁL\bÔ\u0095]\u0016¥¿*9²µ;7\u0092>åñ}|ôëL.Çç_zÖù.V¡Ì9K°Ò\u0019Ñn\u001eö\u0093\u007f\u0004ÇÁL\bÔ\u0095]\u0016¥³*?²±;<\u00923åü}qôæL#Çê_wÖô.S¡Ê9]°Õ\u0019Ñn\u001eö\u0093\u007f\u0004ÇÁL\bÔ\u0095]\u0016¥¨*7²¥;5\u0019Ñn\u001eö\u0093\u007f\u0004ÇÁL\bÔ\u0095]\u0016¥®*=²·;;\u0083¾\b)\u0019Ñn\u001eö\u0093\u007f\u0004ÇÁL\bÔ\u0095]\u0016¥\u0081*3²»;7Ïë¸$ \u00ad©<\u0011µ\u009a\u007f\u0002¸\u008b7s\u0093ü\u000ed\u0080í\u0007U\u0095Þ\u0014F\u008fÏW·ª x¨î\u0011'\u0099ö\u0002c\u008aèssSð$6¼¹5'\u008dà\u0006<\u009e®\u0017-ï\u009b`\u0014ø\u0080q\u0000ÉÀB)Ú\u0094S\u0017+Ì¼s4ö\u008da\u0005ê\u009eo\u0016ÁïlgÓø_pÒÉA»ðÌ+T¥Ý<e¬îdv®ÿ,\u0007\u008f\u0088\u0014\u0010\u0085\u0099\u0007!\u009c\u0019În\u001cö\u0090\u007fRÇÔ\u009b÷ì,t¢ý;E«ÎcV³ß!'\u0094¨\u001a0ß¹\u0019\u0001\u0089\u008a\u001c\u0012\u0093N\u00929\u0003¡\u009c(\u0015\u0090\u0089\u001b\u000e\u0083\u008e\nGò²}>å±l=Ô£_(Ç¾N!6\u009b¡B)Ò\u0019\u0092n\u0013ö\u0094\u007f5Ç¢L/Ôµ]=¥¼*)²¢;|\u0083½\b%\u0019Ñn\u001fö\u0082\u007f\u0011ÇÁL\u0007Ô\u0083]\u0006¥·*;²\u0089;1\u0083¡\b.\u0090£\u0019!aÍö\u0014~ÎÇ_OÂ\u0019\u009cn\u0016ö\u0083\u007f\u0017Ç\u009dL\u001eÔ\u0087]\u0001¥µ*)\u0007rp¼è!a²ÙbR¤Ê*C´»\u00134\u008d¬\u0006!ÞV\u0011Î\u0098G\tÿ\u0080tJì\u008de\u0002\u009d¦\u0012;\u008aµ\u00032» 0!¨º!bY\u009fÎQFÉÿ\u0012wÀìUdÙ\u009d^\u0015¿\u008am\u0002ô»q\u0019Ñn\nö\u0084\u007f\u001dÇ\u008dLEÔ\u0085]\u0012¥«*3²¸;4\u0083¡\u0010\u0014g¸ÿ7v»Î%E®Ý8T§Oh8§ .)¿\u00916\u001aü\u00822\u000b²ó\u0014|\u0080ä@m\u009bÕ\u0005^\u009cÆ\u0019O\u00927k æ(|\u0091¤\u0019t\u0082æ\nmó´{\u0017ä\u008clLÕÄ]ZÆ\u009dNR7Ò¿¤'1\u0090 \u0018=\u0081¾\t!ò«zuã\u008ak\u0006Ô\u0082\\\u001eÅ\u009eM\u001e6\u009a".getBytes(CharEncoding.ISO_8859_1)).asCharBuffer().get(cArr, 0, 1959);
            _CREATION = cArr;
            _BOUNDARY = 4345526331409133178L;
        }

        /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
            java.util.NoSuchElementException
            	at java.base/java.util.TreeMap.key(Unknown Source)
            	at java.base/java.util.TreeMap.lastKey(Unknown Source)
            	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
            	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
            	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
            */
        public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r73, int r74, int r75, int r76) {
            /*
                Method dump skipped, instruction units count: 15431
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.ConfigContainer.Builder.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
        }
    }

    static ConfigContainer copyOf(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(PERSONALIZATION_METADATA_KEY);
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
        }
        JSONObject jSONObject2 = jSONObjectOptJSONObject;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(ROLLOUT_METADATA_KEY);
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
        }
        return new ConfigContainer(jSONObject.getJSONObject(CONFIGS_KEY), new Date(jSONObject.getLong(FETCH_TIME_KEY)), jSONObject.getJSONArray(ABT_EXPERIMENTS_KEY), jSONObject2, jSONObject.optLong(TEMPLATE_VERSION_NUMBER_KEY), jSONArrayOptJSONArray);
    }

    private static ConfigContainer deepCopyOf(JSONObject jSONObject) throws JSONException {
        return copyOf(new JSONObject(jSONObject.toString()));
    }

    public JSONObject getConfigs() {
        return this.configsJson;
    }

    public Date getFetchTime() {
        return this.fetchTime;
    }

    public JSONArray getAbtExperiments() {
        return this.abtExperiments;
    }

    public JSONObject getPersonalizationMetadata() {
        return this.personalizationMetadata;
    }

    public long getTemplateVersionNumber() {
        return this.templateVersionNumber;
    }

    public JSONArray getRolloutMetadata() {
        return this.rolloutMetadata;
    }

    public String toString() {
        return this.containerJson.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConfigContainer) {
            return this.containerJson.toString().equals(((ConfigContainer) obj).toString());
        }
        return false;
    }

    private Map<String, Map<String, String>> createRolloutParameterKeyMap() throws JSONException {
        HashMap map = new HashMap();
        for (int i = 0; i < getRolloutMetadata().length(); i++) {
            JSONObject jSONObject = getRolloutMetadata().getJSONObject(i);
            String string = jSONObject.getString(ROLLOUT_METADATA_ID);
            String string2 = jSONObject.getString("variantId");
            JSONArray jSONArray = jSONObject.getJSONArray(ROLLOUT_METADATA_AFFECTED_KEYS);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String string3 = jSONArray.getString(i2);
                if (!map.containsKey(string3)) {
                    map.put(string3, new HashMap());
                }
                Map map2 = (Map) map.get(string3);
                if (map2 != null) {
                    map2.put(string, string2);
                }
            }
        }
        return map;
    }

    public Set<String> getChangedParams(ConfigContainer configContainer) throws JSONException {
        JSONObject configs = deepCopyOf(configContainer.containerJson).getConfigs();
        Map<String, Map<String, String>> mapCreateRolloutParameterKeyMap = createRolloutParameterKeyMap();
        Map<String, Map<String, String>> mapCreateRolloutParameterKeyMap2 = configContainer.createRolloutParameterKeyMap();
        HashSet hashSet = new HashSet();
        Iterator<String> itKeys = getConfigs().keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!configContainer.getConfigs().has(next)) {
                hashSet.add(next);
            } else if (!getConfigs().get(next).equals(configContainer.getConfigs().get(next))) {
                hashSet.add(next);
            } else if ((getPersonalizationMetadata().has(next) && !configContainer.getPersonalizationMetadata().has(next)) || (!getPersonalizationMetadata().has(next) && configContainer.getPersonalizationMetadata().has(next))) {
                hashSet.add(next);
            } else if (getPersonalizationMetadata().has(next) && configContainer.getPersonalizationMetadata().has(next) && !getPersonalizationMetadata().getJSONObject(next).toString().equals(configContainer.getPersonalizationMetadata().getJSONObject(next).toString())) {
                hashSet.add(next);
            } else if (mapCreateRolloutParameterKeyMap.containsKey(next) != mapCreateRolloutParameterKeyMap2.containsKey(next)) {
                hashSet.add(next);
            } else if (mapCreateRolloutParameterKeyMap.containsKey(next) && mapCreateRolloutParameterKeyMap2.containsKey(next) && !mapCreateRolloutParameterKeyMap.get(next).equals(mapCreateRolloutParameterKeyMap2.get(next))) {
                hashSet.add(next);
            } else {
                configs.remove(next);
            }
        }
        Iterator<String> itKeys2 = configs.keys();
        while (itKeys2.hasNext()) {
            hashSet.add(itKeys2.next());
        }
        return hashSet;
    }

    public int hashCode() {
        return this.containerJson.hashCode();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(ConfigContainer configContainer) {
        return new Builder(configContainer);
    }
}
