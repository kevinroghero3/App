package androidx.compose.ui.graphics.vector;

import java.nio.ByteBuffer;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.CharEncoding;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class FastFloatParserKt {
    private static final int FloatMaxExponent = 10;
    private static final int FloatMaxExponentNumber = 1024;
    private static final int FloatMinExponent = -10;
    private static final int FloatSmallestExponent = -325;
    private static final long[] Mantissa64;
    private static final float[] PowersOfTen = {1.0f, 10.0f, 100.0f, 1000.0f, 10000.0f, 100000.0f, 1000000.0f, 1.0E7f, 1.0E8f, 1.0E9f, 1.0E10f};

    private static final long fullMultiplicationHighBits(long j, long j2) {
        long j3 = j & 4294967295L;
        long j4 = j >>> 32;
        long j5 = j2 & 4294967295L;
        long j6 = j2 >>> 32;
        long j7 = j6 * j3;
        return (j6 * j4) + ((((j4 * j5) + ((j3 * j5) >>> 32)) + (4294967295L & j7)) >>> 32) + (j7 >>> 32);
    }

    public static final int getIndex(long j) {
        return (int) (j >>> 32);
    }

    public static /* synthetic */ void getMantissa64$annotations() {
    }

    public static /* synthetic */ void getPowersOfTen$annotations() {
    }

    public static final boolean isDigit(char c) {
        return ((char) (c + 65488)) < '\n';
    }

    public static final float[] getPowersOfTen() {
        return PowersOfTen;
    }

    static {
        long[] jArr = new long[634];
        long[] jArr2 = new long[634];
        ByteBuffer.wrap("¥ÎÔ;~>\u0091\u0088ÏB\u0089J]Î5ê\u0081\u0089\u0095Îz á²¡ëûB\u0019I\u001a\u001fÊfú\u0012\u009f\u009b`¦ý\u0000¸\u0097G\u00828Ð\u009e s^\u008c±c\u0082Å¨\u00906/Ý¼b÷\u0012´C»Õ+{\u009ak°ªUe;-Á\u0006\u009cÔê¾\u0089øñHD\n%n,v\u0096Í*\u0086WdÛÊ¼\u0080u'í>\u0012¼ë \u0092qè\u008d\u0097k\u0093D[\u00871X~£¸\u0015rhý®\u009eLæ\u001aÏ\u0003=\u001aEß\u008fÐÁb\u00060k«³Äñº\u0087¼\u0086\u0096à¶.))«¨<\u008cqÜÙº\u000bI%¯\u008eT\u0010(\u008e\u001boÛqé\u00142±¢J\u0089'1¬\u009f¯\u0005n«pþ\u0017Ç\u009aÆÊÖM=\u009d¹\u0081x}\u0085ðF\u0082\u0093ðëN§lX#8í&!ÑGn,\u0007(oª\u0082Ì¤Û\u0084yEÊ£\u007fÎ\u0012e\u0097\u0097<Ì_Á\u0096þý}\fÿw±ü¾¼ÜO\u009fªÏ=÷6\t±Ç\u0095\u0083\ru\u0003\u008c\u001dùzãÐÒDo%\u009bìÎb\u0083jÅwÂè\u0001û$EvÕó¢\u0002yíVÔ\u008a\u0098EA\u008c4VDÖ¾V\u0091ïAkÖ\fíì6k\u0011ÆË\u008f\u0094³¢\u0002ë\u001c?9¹à\u008a\u0083¥ãO\u0007èX\u00ad$\u008f\\\"É\u00917l6Ù\u0099\u0095¾µ\u0085GD\u008fÿû-âæ\u0099\u0015³ÿùù\u008dÐ\u001f\u00ad\u0090\u007fü;±D'\u0098ô\u009fûJÝ\u00951\u007f1Çú\u001d\u008a}>ï\u007f\u001cüR\u00ad\u001c\u008e«^ä;fØc²V6\u009dJ@\u0087>Ouâ\"Nh©\rãSZªâ\u0002ÓQ\\(1U\u009a\u0083\u0084\u0012Ù\u0099\u001eÕ\u0080\u0091¥\u0017\u008fÿf\u008aà¶Î]sÿ@-\u0098ã\u0080úh\u007f\u0088\u001c\u007f\u008e¡9\u0002\u009fj#\u009frÉ\u0087CGD¬\u0087Nûé\u0014\u0019\u0015×©\"\u009dq¬\u008f\u00ad¦ÉµÄÎ\u0017³\u0099\u0010|\"ö\u0001\u009d \u007fT\u009b+\u0099Á\u0002\u0084O\u0094àûÀ1C%cz\u00199ð=\u0093î¼X\u009f\u0088\u0096&|u5·cµ»°\u001b\u0092\u0083%<¢ê\u009c\"w#î\u008bË\u0092¡\u0095\u008avu\u0017_·Iúí\u0014\u0012]6å\u001cy¨Y\u0016ô\u0084\u008f1Ì\t7®XÒ²þ?\u000b\u0085\u0099ï\u0007ß½ÎÎg\u0000jÉ\u008bÖ¡A\u0000`B½®ÌI\u0091@xSmÚ\u007f[õ\u0090\u0096hH\u0088\u008f\u0099yz^\u0001-ª³\u007f×Øõ\u0081xÕ`_ÍÏ2áÖ\u0085\\;à¡\u007fÍ&¦³JØÉßÀoÐ`\u001d\u008eüW°\u008b\u0082<\u0012y]¶ÎW¢Ë\u0017\u0017µ$\u0081íË}ÜÝ¢m¢hþ]T\u0015\u000b\t\u000b\u0002\u009eúT\u008d&å¦áÆ¸é°p\u009f\u0010\u009aøg$\u001c\u008cÆÔÀ\u009b@v\u0091×üDøÂ\u0010\u00946MûV6ò\u0094¹Cáz+Ä\u0097\u009cóÊlì[Z½\u00840½\b'r1ìå<ìJ1N½\u0094\u000fF\u0013®^Ñ6¹\u0013\u0017\u0098\u0099ö\u0085\u0084çWÝ~Àt&å\u0090\u0096êo8H\u0098O´¼¥\u000b\u0006Z¾cáëÎMÇñmû\u008d3`ð\u009cöä½°\u00809,Ä4\u009dìÜ GwõAÅg\u0089ä,ªùI\u001b`¬]7Õ·\u009bb9×t\u0085Ë%\u0082:Ç\u0086¨Ó\u009e÷qd¼¨S\b\u0086µM½ëÒgÊ¨b¡-f\u0083\u0080Þ©=¤¼`¤a\u0016S\u008d\rëxÍy[èpQfV\u0080kÙqF2ßö \u0086ÏÍ\u0097¿\u0097óÈ¨\u0083Àý¯}ðúÒ¤±=\u001b]l\u009cÃ¦îÆ1\u001acÃô\u0090ªw½`üôñ´Õ\u0015¬¹;\u0099\u0017\u0011\u0005-\u008bóÅ¿\\ÕFxîð¶ï4\n\u0098\u0017*¬ä\u0095\u0080\u0086\u009f\u000ez¬\u000eºà¨FÒ\u0019W\u0012é\u0098ÒX\u0086\u009f¬×\u0091ÿ\u0083wT#Ì\u0006¶\u007fdU),¿\bä\u001f=jswîÊ\u008e\u0093\u0086b\u0088*õ>²8gû*5²\u008dÞÆ\u0081ùôÃ\u001f1\u008b<\u0011<8ùó~®\u000b\u0015\u008bG8p^Ù\u008dÚî\u0019\u0006\u008cv\u0087ø¨ÔÏ¤\u0017É©öÓ\n\u0003\u008d\u001d¼Ôt\u0087Ì\u0084pe+\u0084ÈÔßÒÆ?;¥û\n\u0017ÇwÏ\tÏyÌ\u009d¹UÂÌ\u0081¬\u001fâ\u0093Õ\u0099¿¢\u0017'Û8Ë\u0000/Ê\u009cñÒ\u0006ýÀ;ýD.F\u0088½0J\u009eJ\u009cì\u0015v>.ÅÝD'\u001aÓÍº÷T\u00950á\u0088Á(\u009a\u0094Ý>\u008cõx¹Á:\u0014\u008e02Öçñ\u0088\u0099±¼?\u008c¡\u0096õ`\u000f\u0015§·å¼²¸\u0012Û\u0011¥Þëßf\u0017\u0091Ö\u000fV\u0093k\u009fÎ»%É\u0095¸F\u0087Âiï;ûæX)³\u0004k\nú\u008f÷\u001a\u000fâÂæÜ³ôà\u0093Ûs \u0093àò\u0018¸ÒP\u0088¸\u008c\u0097Os\u0083rUs¯½#PdNêÏÛ¬l$}b¥\u0083\u0089KÃ\u0096Î]§r«\u009e´|\u0081õ\u0011OÖ\u0086a\u009b¢rU¢\u0086\u0013ý\u0001E\u0087u\u0085§\u0098üA\u0096éRçÑ\u007f;Qü£§ \u0082ï\u0085\u0013=æHÄ£«fX\r_ÚõÌ\u0096?î\u0010·Ñ³ÿ»Ïé\u0094åÆ\u001f\u009fÕañý\u000f\u009bÓÇÊºn|S\u0082Èù½i\n\u001bhc{\u009c\u0016a¦Q!>-Ã\u001bú\u000fåi\u008d¸óâø\u0093ÞÃñ&\u0098mÛ\\k:v·¾\u0089R3\u0086\t\u0014eî+¦Àg\u008bY\u007f\u0094ÛH8@·\u0017ïº\u0012\u001aFPäÝëè\u0096 ×å\u001e\u0015f\u0091^$\u0086ï2Í`µµ\u00ad¨ªÿ\u0080¸ã#\u0019\u0012Õ¿`æ\u008dõï«Å\u0097\u009c\u008f±sk\u0096¶ý\u0083³ÝÐF|d¼ä \u008a¢,\r¾ö\u000eä\u00adJ·\u0011.³\u0092\u009dØ\u009ddÕz`wD\u0087b_\u0005l|J\u008b©:öÆÇ\u009b]-Ó\u0089´xy\u00824y\u00846\u0010ËKñ`Ë¥C\u0094þ\u001eí¸þÎ\u0094z=¦©'>\u0081\u001cÌf\u0088)¸\u0087¡cÿ\u0080*4&¨É¼ÿ`4Á0Rü,?8Añ|g\u009d\u009b§\u0083)6íÀÅ\u0002\u0091có\u0084©1öC5¼ðeÓ}\u0099ê\u0001\u0096\u0016?¤.Àd\u0081û\u009bÏ\u008d9ð}¢z\u0082Ãp\u0088\u0096N\u0085\u008c\u0091º&U»â&ï¶(¯êêÚ°«£²Ûå\u0092È®kFOÉo·zÚ\u0006\u0017ã»ËåY\u0090\u0087\u009dÜª½\u008fWúTÂ©ê¶³-øéóTedßùw$p)~½\u008bûêvÆ\u0019ï6®úå\u0014w k\u0003Ú¹\u009eY\u0095\u0088\u0085Ä\u0088´\u0002÷ýuS\u009bªá\u0003µüÒ¨\u0081Õ\u0099D£|\u0007R¢\u0085\u007fÊæ-\u0084\u0093¥¦ß½\u009f¸å¸\u008eÐ\u0097\u00ad\u0007§\u001f&²\u0082^Ì$Èsx/¢ö\u007f-ú\u0090V;Ë´\u001eùy4kÊþ¡&·×\u0081\u0086¼\u009f$¸2æ°ô6Æíæ? ]1Cø©_Ï\u0088t}\u0094\u009biÛáµHÎ|ÂDRÚ\"\u009b\u0002\u001bòÕg\u0090«AÂ¢\u0097Å`ºk\t\u0019¥½¶¸é\u0005Ë`\u000fí$g#G>8\u0013\u00946Àv\f\u0086ã\u000b¹Dp\u0093\u008f¨\u009bÎç\u0095\u008c¸s\u0092ÂÂ\u0090½wóH;¹¹´ìÕð\u001aJ¨(â(\u000bl ÝR2\u008dY\u0007#\u0094\u008aS_°¯Hìy¬è7ÜÛ\u001b'\u0098\u0018\"D\u008a\bðø¿\u000f\u0015k¬\u008b-6îÒÚÅ×\u00adø\u0084ª\u0087\u0091w\u0086Ì»Rê\u0094ºê¨\u007fê'¥9é¥Ò\u009fä±\u008e\u0088d\u000e\u0083£îîù\u0015>\u0089¤\u008cêª·Z\u008e+Í°%Ue11¶\u0080\u008e\u0017U_>¿\u0011 ±\u009d*·\u000enÖÈÞ\u0004udÒ\n\u008bû\u0015\u0085\u0092¾\u0006\u008d.\u009cís{¶Ä\u0018=Ä(ÐZ¤u\u001eLõ3\u0004qM\u0092eß\u0099?âÆÐ{\u007f«¿\u008fÛx\u0084\u009a_\u0096ïsÒV¥À÷|\u0095¨cv'\u0098\u009a\u00ad»\u0012|S±~ÁYé×\u001bh\u009dÞq¯\u0092&q!b«\u0007\r¶°\ri»UÈÑä\\\u0010Ä*+;\u0005\u008e¹\u008az\u009a[\u0004ã²gí\u0019@ñÆ\u001cß\u0001è_\u0091.7£\u008ba1;º¼âÆ®9}\u008a©l\u001bwÙÇÜíSÇ\"U\u0088\u001cê\u0014T\\uuª$$\u0099is\u0092ÒÔ\u00ad-¿ÃÐw\u0087\u0084ì<\u0097ÚbJ´¦'K½ÐúÝaÏ±\u001e\u00adE9\u0094º\u0081Î³,KCüô¢B_÷^\u0014ü1ÊÒ÷õ5\u009a;>ý\u0087µò\u0083\u0000Ê\r\u009etÑ·\u0091à~HÆ\u0012\u0006%vX\u009dÚ÷\u0096\u0087®ÓîÅQ\u009a¾\u0014ÍDu;RÁm\u009a\u0000\u0095\u0092\u008a'ñÉ\u0000\u0080º÷,±\u0097\u001d PtÚ{î¼å\bd\u0092\u0011\u001aêì\u001eJ}¶\u0095a¥\u0093\u0092î\u008e\u0092\u001d]\u0007¸wª26¤´Iæ\u0095\u0094¾ÄMá[\u0090\u001d|÷:°¬Ù´$Ü5\t\\Ø\u000fá.\u0013BK´\u000e\u0013\u008c¼Ì\toP\u0088Ë¯ëÿ\u000bË$ªþÛæþÎ½íÕ¾\u0089p_A6´¥\u0097«Ìw\u0011\u0084aÎüÖ¿\u0094ÕåzB¼\u00867½\u0005¯liµ§Å¬G\u001bG\u0084#Ñ·\u0017Xâ\u0019e+\u0083\u0012n\u0097\u008dOß;£×\n=p£×\nÌÌÌÌÌÌÌÌ\u0080\u0000\u0000\u0000\u0000\u0000\u0000\u0000 \u0000\u0000\u0000\u0000\u0000\u0000\u0000È\u0000\u0000\u0000\u0000\u0000\u0000\u0000ú\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u009c@\u0000\u0000\u0000\u0000\u0000\u0000ÃP\u0000\u0000\u0000\u0000\u0000\u0000ô$\u0000\u0000\u0000\u0000\u0000\u0000\u0098\u0096\u0080\u0000\u0000\u0000\u0000\u0000¾¼ \u0000\u0000\u0000\u0000\u0000îk(\u0000\u0000\u0000\u0000\u0000\u0095\u0002ù\u0000\u0000\u0000\u0000\u0000ºC·@\u0000\u0000\u0000\u0000èÔ¥\u0010\u0000\u0000\u0000\u0000\u0091\u0084ç*\u0000\u0000\u0000\u0000µæ ô\u0080\u0000\u0000\u0000ã_©1 \u0000\u0000\u0000\u008e\u001bÉ¿\u0004\u0000\u0000\u0000±¢¼.Å\u0000\u0000\u0000Þ\u000bk:v@\u0000\u0000\u008aÇ#\u0004\u0089è\u0000\u0000\u00adxëÅ¬b\u0000\u0000Ø×&·\u0017z\u0080\u0000\u0087\u0086x2n¬\u0090\u0000©h\u0016?\nW´\u0000ÓÂ\u001bÎÌí¡\u0000\u0084YQa@\u0014\u0084 ¥o¥¹\u0090\u0019¥ÈÎË\u008f'ô \u000f:\u0081?9xø\u0094\t\u0084¡\u008f\u0007×6¹\u000båÉòÉÍ\u0004gNÞüo|@E\u0081\"\u0096\u009dÅ\u00ad¨+pµ\u009dÅ7\u0019\u00126Lã\u0005ö\u0084ßVÃà\u001bÆ\u009a\u0013\u000b\u0096:l\u0011\\À\u0097Î{É\u0007\u0015³ð½Â\u001a»HÛ \u0096v\u0099Pµ\r\u0088ô¼\u0014?¤âPë1ë\u0019O\u008e\u001aå%ý\u0092ïÑ¸ÐÏ7¾·«Æ'\u0005\u0003\u0005\u00adå\u0096·°ÆCÇ\u0019\u008f~2Î{ê\\o³]¿\u0082\u001aäó\u008bà5/b¡\u009e0n\u008c!=\u009d¥\u0002ÞE¯)\u008d\u0005\u000eC\u0095ÖÚóðFQÔ{L\u0088Øv+ó$Í\u000f«\u000e\u0093¶ïî\u0000SÕÒ8¤«é\u0080h\u0085£cfëqðA§\f<@¦NlQÐÏKPÏâ\u0007e\u0082\u0081\u008f\u0012\u0081íD\u009f£!ò×\"h\u0095ÇËêo\u008cë\u0002»9þå\u000bp%Ãj\b\u009fO'&\u0017\u009a\"EÇ\"ðï\u009d\u0080ªÖøë\u00ad+\u0084àÕ\u008b\u009b\u0093L;3\f\u0085wÂx\u001fIÿÏ¦Õó\u0016'\u001c\u007fÃ\u0090\u008a\u0097íØqÏÚ:V½éN\u008eCÐÈìíc¢1ÔÄû'\u0094^E_$û\u001cø¹uÖ¶î9ä6çÓLd©È]D\u0090ä\u000f¾ê\u001d:Jµ\u001d\u0013®¤¤\u0088ÝâdX\u009aMÍ«\u0014\u008d~·`p \u008aì°Þe8\u008cÈ\u00ad¨Ý\u0015þ\u0086¯úÙ\u0012\u008a-¿\u0014-üÇ«¬¹.Ù9{ù\u0096×çz\u008f\u0087Ú÷û\u0086ð¬\u0099´èÚý¨¬×À\"#\u0011¼ÒØ\r°*«Ö+\u0083Ç\b\u008e\u001a«eÛ¤¸Ê±¡V?RÍæý^\t«Ï&\u0080°^ZÆ\u000bax Üuñw\u008e9ÖÉ\u0013\u0093mÕqÈLûXxIJÎ:_\u009d\u0017K-ÎÀä{Ä]\u001dùBq\u001d\u009aõtew\u0093\re\u0000\u0099h¿j»è_ ¿ÂïEjâvèï³«\u0016Å\u009b\u0014¢\u0095ÐJî;\u0080ìå»D]©Êa(\u001fê\u0015u\u0014<ùr&\u0092Mi,¦\u001bçX¶àÃwÏ¢á.ä\u0098ôUÃ\u008b\u0099z\u008eß\u0098µ\u009a7?ì²\u0097~ã\u0000Å\u000fçß=^\u009bÀöSá\u008b\u0086[!X\u0099ôl®gñé®Àq\u0087Ú\u0001îd\u001ap\u008dé\u0088A4þ\u0090\u0086X²ªQ\u0082>4§îÞÔåâÍÁÑê\u0096\u0085\u000f\u00adÀ\u0099#2\u009e¦S\u00990¿kÿEÏè\u007f|ïFÿ\u0016\u0081ñO®\u0015\u008c_n¢m£\u0099\u009aïwIË\t\f\u0080\u0001«U\u001cýËO \u0002\u0016*c\u009e\u009f\u0011Ä\u0001MÚ~ÆFÖ5\u0001¡Q\u001d÷Ø\u008bÂB\t¥e\u009açWYiF\u0007_Á¡-/Ã\u0097\u00897ò\tx{´}k\u0084\u0097EëMPÎc2½\u0017f ¥\u0001ûÿì]?¨ÎBzÿ\u0093ºGÉ\u0080é\u008cß¸¨Ù»á#ð\u0017æÓ\u0010*Ùlì\u001d\u0090Cê\u001aÇä\u0013\u0092´Tä¡yÝ\u0018wáj\u001dÉØT^\u0094\u008câR\u009e'4»\u001d°\u001açE±\u0001éäÜ!¡\u0017\u001dBd]\u0089\u0095\u0004®rI~º«úEÚ\u000eÛÞiÖø×P\u0092\u0092Ö\u0003\u0086[\u0086\u0092[\u009bÅÂ§òh6ò\u0082·2Ñï\u0002D¯#dÿ\u00835ajív\u001f\u001f¤\u0002¹Å¨Ó¦çÍ\u0003h7\u0013\b\u0090¡\u0080\"!\"kåZd *©k\u0006Þ°ýÈ5SÅÈ\u0096]=úB¨·:»ô\u008c\u009ci©r\u0084µx×Ã\u0084\u0013Ï%â×\rôe\u0018Âï[\u008cÑ\u0098¿/yÕ\u00998\u0002¾îûXJÿ\u0086\u0003îªº.]¿g\u0084\u0095*´\\ú\u0097 ²ºuat9=\u0088ßé\u0012¹ÑG\u008cë\u0017\u0091«´\"Ì¸\u0012î¶\u0016¡+\u007fæ\u0017ªã\u009cIv_ß\u009d\u0094\u008eA\u00adéûëÂ}±Ò\u0019dzæ³\u001cÞF\u009f½\u0099 _ã\u008aì#Ö\u0080\u0004;î\u00ad§,Ì \u0005JéÙ\u0010÷ÿ(\u0006\u009d¤\u0087ª\u009aÿy\u0004\"\u0086©\u0095A¿WE+(Óú\u0092/-\u0016uò\u0084|\u009b]|.\t·¥\u009bÂ4Û9\u008c%Ï\u0002²Â\u0012\u0007ï.\u0081a¯¹KDõ}¡º\u001b§\u009e\u00162ÜÊ(¢\u0091\u0085\u009b¿\u0093ü²Ë5ç\u0002¯x\u009dï¿\u0001°a\u00ad«Åk®Â\u001cz\u0019\u0016öÆ\u009ar£\u0098\u009f[\u009a< \u0087¦?c\u0099ÀË(©\u008fÏ<\u007fðýòÓóÃ\u000b\u009f\u0096\u009e·ÄxYçC¼Feµ\u0096pa\u0014ëWÿ\"ü\fyY\u0093\u0016ÿuÝ\u0087ËØ·Ü¿STé¾ÎåÓï(*$.\u0081\u008f¤uy\u001aV\u009d\u0010³\u008d\u0092×`ìDUàp÷\u008d9'Uj\u008cF\u009a¸C¸\u0095b¯XAfT¦º»Û.Q¿éÐij\u0088üó\u0017ò\"Aâ«</ÝîªÒZÖ\u000b;ÕjU\u0086ñ\u0085Ç\u0005ebutV§8Æ¾»\u0012ÑlÑ\u0006øni×\u0085Ç\u0082¤[E\u0002&³\u009c£Mr\u0016B°`\u0084Ì Î\u009bÓ\\x¥ÿ)\u0002BÈ3\u0096Î\u009fy¡i½ >AÇX\tÄ,hMÑù.\f57\u0082aE\u009b¼Ç¡B±|ËÂ«ù\u0089\u0093]ÛþóV÷ëø5Rþ\u0098\u0016Zó{!SÞ¾\u001bñ°Yé¨Öí¢î\u001cpd\u0013\f\u0094\u0085ÔÑÆ>\u008bç¹§J\u00067Î.áè\u0011\u001c\u0087ÅÁº\u0099\u0091\n±ÔÛ\u0099\u0014 µM^J\u0012\u007fYÈâ µÜ\u0097\u001f0:\u008d¤q©Þs~$±\r\u008e\u0014V\u0010]\u00adÝPñ\u0099k\u0094u\u0018\u008aR\u0096ÿã<É/¬ç<¿Ü\u000bû{Ø!\u000bïÓ\u000eúZ\u0087\u0014§uãé\\x¨ÙÑS\\ã³\u0096Ó\u0010E¨4\u001c |\u0083ê+\u0089 \u0091äM¤ä¶kh¶]`Î\u001dä\u0006Bãô¹\u0080Ò®\u0083éÎxó¡\u0007Z$äB\u00170ÉI0®\u001dR\u009cüû\u009b|Ù¤§D<\u009dA.\b\u0006è\u008a¥Ä\u0091y\u008a\b¢\u00adNõµ×ì\u008aËX¢\u0099\u0091¦óÖ¿\u0017e¿ö\u0010°ÌnÝ?ïó\u0094Üÿ\u008a\u0094\u008e\u0095ø=\n\u001f¶\u009cÙ»vLL§¤D\u000fêSß_Ñ\u008dU\u0013\u0092tk\u009bâøU,·\u0011\u0086\u0082Û¶jwäÕè#\u0092¤\u0005\u0015\u008f\u0005±\u0016;¦\u0083-²Ç\u001d[Ê\u0090#øßxä²½4,ö\u008b«\u008eï¶@\u009c\u001a®\u0096r«£ÐÃ Ú<\u000fV\u008cÄóè\u0088e\u0089\u0096\u0017û\u0018qª~ëû\u009dùÞ\u008dÕ\u001e¦ú\u0085xV1\u00853(\\\u0093k5Þ¦\u007fòs¸F\u0003VÐ\u001fï\u0010¦W\u0084,\u0082\u0013õjgö²\u009b¢\u0098òÅ\u0001ô_BË?/vBqw\u0013þ\u000eûSÓ\rÔ×\u009eÉ]\u0014cè¥\u0006Æ{´Y|âÎHø\u001a¡oÜ\u001b\u0081Ú\u009b\u0010¤åé\u00911(ÁÔÎ\u001fcõ}ròJ\u0001§<òÜÏ\u0097nA\b\u0086\u0017Ê\u0001½IÑJ§\u009d¼\u0082ì\u009cE\u009dQ\u0085+¢\u0093á«\u0082Ró;E¸Ú\u0016bç°\n\u0017ç\u0010\u009bû¡\u009c\f\u009d\u0090ja}E\u0001\u0087â´\u0084ùÜ\u0096AéÚá¦8S»ÒdQ\u008d\u0007ã4Uc~²°IÜ\u0001j¼^_Ü\\S\u0001Åku÷\u0089¹³á\u001bc)º¬( Ùb;ô)×2)\u000fºÊñ3\u0086\u007fY©Ô¾ÖÀ¨\u001f0\u0014Iî\u008cpÒ&ü\u0019\\j/\u008c\u0083X]\u008fÙÂ]·¤.tóÐ2õ%Í:\u00120Ä?²o\u0080DK^z§Ï\u0085 U^6\u0019QÃfÈjµÃ\u009f¦4@ú\u0085c4\u0087\u008fÁP\u009c\u0093^\u0000Ô¹ØÒÃ¸5\u0081\tèO\u0007ô¦BáLbbÈ\u0098çéÌÏ½}½¿!ä@\u0003¬Ý,îê]P\u0004\u0098\u0014x\u0095RzR\u0002ß\fËº§\u0018æ\u0083\u0096ÏýéPß $|\u0083ý\u0091Ò\u008bt\u0016ÍÒ~¶G.Q\u001c\u0081G\u001dãØùåc¡\u0098å\u008eg\u009c/^Dÿ\u008f".getBytes(CharEncoding.ISO_8859_1)).asLongBuffer().get(jArr2, 0, 634);
        System.arraycopy(jArr2, 0, jArr, 0, 634);
        Mantissa64 = jArr;
    }

    public static final long[] getMantissa64() {
        return Mantissa64;
    }

    private static final long pack(int i, float f) {
        return (((long) Float.floatToRawIntBits(f)) & 4294967295L) | (((long) i) << 32);
    }

    private static final int parseFourDigits(String str, int i) {
        long jCharAt = (((long) str.charAt(i + 3)) << 48) | ((long) str.charAt(i)) | (((long) str.charAt(i + 1)) << 16) | (((long) str.charAt(i + 2)) << 32);
        long j = jCharAt - 13511005043687472L;
        if ((((jCharAt + 19703549022044230L) | j) & (-35747867511423104L)) != 0) {
            return -1;
        }
        return (int) ((j * 281475406208040961L) >>> 48);
    }

    public static final float getFloatValue(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* JADX WARN: Code duplicated, block: B:130:0x0220  */
    public static final long nextFloat(@NotNull String str, int i, int i2) {
        char cCharAt;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z;
        int i9;
        int i10;
        long j;
        boolean z2;
        float f;
        long j2;
        if (i != i2) {
            char cCharAt2 = str.charAt(i);
            boolean z3 = cCharAt2 == '-';
            if (z3) {
                i3 = i + 1;
                if (i3 != i2) {
                    cCharAt = str.charAt(i3);
                    if (((char) (cCharAt - '0')) >= '\n' && cCharAt != '.') {
                        return (((long) i3) << 32) | (((long) Float.floatToRawIntBits(Float.NaN)) & 4294967295L);
                    }
                } else {
                    return (((long) i3) << 32) | (((long) Float.floatToRawIntBits(Float.NaN)) & 4294967295L);
                }
            } else {
                cCharAt = cCharAt2;
                i3 = i;
            }
            int length = str.length();
            int i11 = i3;
            long j3 = 0;
            while (i11 != i2) {
                int i12 = cCharAt - '0';
                if (((char) i12) >= '\n') {
                    break;
                }
                j3 = (j3 * 10) + ((long) i12);
                i11++;
                cCharAt = i11 < length ? str.charAt(i11) : (char) 0;
            }
            int i13 = i11 - i3;
            if (i11 == i2 || cCharAt != '.') {
                i4 = i11;
                i5 = i4;
                i6 = i5;
                i7 = i3;
                i8 = 0;
            } else {
                i6 = i11 + 1;
                i5 = i6;
                while (true) {
                    if (i2 - i5 < 4) {
                        i7 = i3;
                        i4 = i11;
                        break;
                    }
                    i4 = i11;
                    i7 = i3;
                    int i14 = i5;
                    long jCharAt = (((long) str.charAt(i5 + 1)) << 16) | ((long) str.charAt(i5)) | (((long) str.charAt(i5 + 2)) << 32) | (((long) str.charAt(i14 + 3)) << 48);
                    long j4 = jCharAt - 13511005043687472L;
                    int i15 = (((jCharAt + 19703549022044230L) | j4) & (-35747867511423104L)) != 0 ? -1 : (int) ((j4 * 281475406208040961L) >>> 48);
                    if (i15 < 0) {
                        i5 = i14;
                        break;
                    }
                    j3 = (j3 * 10000) + ((long) i15);
                    i5 = i14 + 4;
                    i11 = i4;
                    i3 = i7;
                }
                if (i5 < length) {
                    cCharAt = str.charAt(i5);
                } else {
                    i4 = i4;
                    cCharAt = 0;
                }
                while (i5 != i2) {
                    int i16 = cCharAt - '0';
                    if (((char) i16) >= '\n') {
                        break;
                    }
                    j3 = (j3 * 10) + ((long) i16);
                    i5++;
                    if (i5 < length) {
                        cCharAt = str.charAt(i5);
                    } else {
                        i4 = i4;
                        i5 = i5;
                        cCharAt = 0;
                    }
                }
                i8 = i6 - i5;
                i13 -= i8;
            }
            if (i13 == 0) {
                return (((long) i5) << 32) | (((long) Float.floatToRawIntBits(Float.NaN)) & 4294967295L);
            }
            if ((cCharAt | ' ') == 101) {
                i9 = i5 + 1;
                char cCharAt3 = i9 < length ? str.charAt(i9) : (char) 0;
                boolean z4 = cCharAt3 == '-';
                if (z4 || cCharAt3 == '+') {
                    i9 = i5 + 2;
                }
                char cCharAt4 = str.charAt(i9);
                i10 = 0;
                while (true) {
                    if (i9 == i2) {
                        z = z3;
                        break;
                    }
                    int i17 = cCharAt4 - '0';
                    z = z3;
                    if (((char) i17) >= '\n') {
                        break;
                    }
                    if (i10 < 1024) {
                        i10 = (i10 * 10) + i17;
                    }
                    i9++;
                    cCharAt4 = i9 < length ? str.charAt(i9) : (char) 0;
                    z3 = z;
                }
                if (z4) {
                    i10 = -i10;
                }
                i8 += i10;
            } else {
                z = z3;
                i9 = i5;
                i10 = 0;
            }
            if (i13 > 19) {
                char cCharAt5 = str.charAt(i7);
                int i18 = i7;
                while (i9 != i2 && (cCharAt5 == '0' || cCharAt5 == '.')) {
                    if (cCharAt5 == '0') {
                        i13--;
                    }
                    i18++;
                    cCharAt5 = i18 < length ? str.charAt(i18) : (char) 0;
                }
                if (i13 > 19) {
                    char cCharAt6 = str.charAt(i7);
                    long j5 = 0;
                    while (i7 != i4 && Long.compare(ULong.m5646constructorimpl(j5) ^ Long.MIN_VALUE, 1000000000000000000L ^ Long.MIN_VALUE) < 0) {
                        j5 = (j5 * 10) + ((long) (cCharAt6 - '0'));
                        i7++;
                        cCharAt6 = i7 < length ? str.charAt(i7) : (char) 0;
                    }
                    if (Long.compare(ULong.m5646constructorimpl(j5) ^ Long.MIN_VALUE, 1000000000000000000L ^ Long.MIN_VALUE) >= 0) {
                        j2 = j5;
                        i8 = (i4 - i7) + i10;
                    } else {
                        char cCharAt7 = str.charAt(i6);
                        int i19 = i6;
                        while (i19 != i5 && Long.compare(ULong.m5646constructorimpl(j5) ^ Long.MIN_VALUE, 1000000000000000000L ^ Long.MIN_VALUE) < 0) {
                            j5 = (j5 * 10) + ((long) (cCharAt7 - '0'));
                            i19++;
                            cCharAt7 = i19 < length ? str.charAt(i19) : (char) 0;
                        }
                        j2 = j5;
                        i8 = (i6 - i19) + i10;
                    }
                    j = j2;
                    z2 = true;
                } else {
                    j = j3;
                    z2 = false;
                }
            } else {
                j = j3;
                z2 = false;
            }
            if (FloatMinExponent <= i8 && i8 < 11 && !z2 && Long.compare(ULong.m5646constructorimpl(j) ^ Long.MIN_VALUE, ULong.m5646constructorimpl(16777216L) ^ Long.MIN_VALUE) <= 0) {
                float f2 = j;
                if (i8 < 0) {
                    f = f2 / PowersOfTen[-i8];
                } else {
                    f = f2 * PowersOfTen[i8];
                }
                if (z) {
                    f = -f;
                }
                return (((long) i9) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L);
            }
            if (j == 0) {
                return (((long) i9) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L);
            }
            if (-126 > i8 || i8 >= 128) {
                String strSubstring = str.substring(i, i9);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                return (((long) i9) << 32) | (((long) Float.floatToRawIntBits(Float.parseFloat(strSubstring))) & 4294967295L);
            }
            long jM5706getsVKNKU = ULongArray.m5706getsVKNKU(Mantissa64, i8 + 325);
            int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(j);
            long j6 = j << iNumberOfLeadingZeros;
            long j7 = j6 & 4294967295L;
            long j8 = j6 >>> 32;
            long j9 = jM5706getsVKNKU & 4294967295L;
            long j10 = jM5706getsVKNKU >>> 32;
            long j11 = j10 * j7;
            long j12 = (j10 * j8) + ((((j8 * j9) + ((j7 * j9) >>> 32)) + (j11 & 4294967295L)) >>> 32) + (j11 >>> 32);
            int i20 = (int) (j12 >>> 63);
            long j13 = j12 >>> (i20 + 9);
            int i21 = iNumberOfLeadingZeros + (i20 ^ 1);
            long j14 = j12 & 511;
            if (j14 == 511 || (j14 == 0 && (3 & j13) == 1)) {
                String strSubstring2 = str.substring(i, i9);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                return (((long) i9) << 32) | (((long) Float.floatToRawIntBits(Float.parseFloat(strSubstring2))) & 4294967295L);
            }
            long j15 = (j13 + 1) >>> 1;
            if (j15 >= 9007199254740992L) {
                i21--;
                j15 = 4503599627370496L;
            }
            long j16 = ((((((long) i8) * 217706) >> 16) + ((long) 1024)) + ((long) 63)) - ((long) i21);
            if (j16 < 1 || j16 > 2046) {
                char c = ' ';
                long j17 = 4294967295L;
                String strSubstring3 = str.substring(i, i9);
                Intrinsics.checkNotNullExpressionValue(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                return (((long) i9) << c) | (((long) Float.floatToRawIntBits(Float.parseFloat(strSubstring3))) & j17);
            }
            return (((long) i9) << 32) | (((long) Float.floatToRawIntBits((float) Double.longBitsToDouble((j16 << 52) | ((-4503599627370497L) & j15) | (z ? Long.MIN_VALUE : 0L)))) & 4294967295L);
        }
        return (((long) i) << 32) | (((long) Float.floatToRawIntBits(Float.NaN)) & 4294967295L);
    }
}
