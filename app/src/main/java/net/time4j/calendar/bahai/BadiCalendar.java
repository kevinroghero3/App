package net.time4j.calendar.bahai;

import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.rolling.helper.DateTokenConverter;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.nio.ByteBuffer;
import java.text.ParsePosition;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import net.time4j.GeneralTimestamp;
import net.time4j.Moment;
import net.time4j.PlainDate;
import net.time4j.PlainTime;
import net.time4j.SystemClock;
import net.time4j.Weekday;
import net.time4j.Weekmodel;
import net.time4j.base.GregorianMath;
import net.time4j.base.MathUtils;
import net.time4j.base.TimeSource;
import net.time4j.calendar.StdCalendarElement;
import net.time4j.calendar.astro.SolarTime;
import net.time4j.calendar.astro.StdSolarCalculator;
import net.time4j.calendar.service.StdEnumDateElement;
import net.time4j.calendar.service.StdIntegerDateElement;
import net.time4j.calendar.service.StdWeekdayElement;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.BasicElement;
import net.time4j.engine.CalendarDays;
import net.time4j.engine.CalendarEra;
import net.time4j.engine.CalendarSystem;
import net.time4j.engine.Calendrical;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoException;
import net.time4j.engine.ChronoMerger;
import net.time4j.engine.ChronoUnit;
import net.time4j.engine.Chronology;
import net.time4j.engine.DisplayStyle;
import net.time4j.engine.ElementRule;
import net.time4j.engine.EpochDays;
import net.time4j.engine.FormattableElement;
import net.time4j.engine.IntElementRule;
import net.time4j.engine.StartOfDay;
import net.time4j.engine.TimeAxis;
import net.time4j.engine.UnitRule;
import net.time4j.engine.ValidationElement;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.CalendarType;
import net.time4j.format.DisplayElement;
import net.time4j.format.Leniency;
import net.time4j.format.OutputContext;
import net.time4j.format.TextAccessor;
import net.time4j.format.TextElement;
import net.time4j.format.TextWidth;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes6.dex */
@CalendarType("bahai")
public final class BadiCalendar extends Calendrical<Unit, BadiCalendar> {

    @FormattableElement(dynamic = true, format = ExifInterface.GPS_MEASUREMENT_IN_PROGRESS)
    public static final ChronoElement<BadiIntercalaryDays> AYYAM_I_HA;
    private static final CalendarSystem<BadiCalendar> CALSYS;

    @FormattableElement(alt = DateTokenConverter.CONVERTER_KEY, dynamic = true, format = "D")
    public static final StdCalendarElement<Integer, BadiCalendar> DAY_OF_DIVISION;
    private static final int DAY_OF_DIVISION_INDEX = 3;

    @FormattableElement(dynamic = true, format = ExifInterface.LONGITUDE_EAST)
    public static final StdCalendarElement<Weekday, BadiCalendar> DAY_OF_WEEK;
    public static final StdCalendarElement<Integer, BadiCalendar> DAY_OF_YEAR;
    private static final int DAY_OF_YEAR_INDEX = 4;
    private static final TimeAxis<Unit, BadiCalendar> ENGINE;

    @FormattableElement(dynamic = true, format = "G")
    public static final ChronoElement<BadiEra> ERA;

    @FormattableElement(alt = "k", dynamic = true, format = "K")
    public static final ChronoElement<Integer> KULL_I_SHAI;
    private static final int KULL_I_SHAI_INDEX = 0;

    @FormattableElement(alt = "m", dynamic = true, format = "M")
    public static final StdCalendarElement<BadiMonth, BadiCalendar> MONTH_OF_YEAR;
    private static final int[] NEWROZ;

    @FormattableElement(alt = "v", dynamic = true, format = ExifInterface.GPS_MEASUREMENT_INTERRUPTED)
    public static final StdCalendarElement<Integer, BadiCalendar> VAHID;
    private static final int VAHID_INDEX = 1;
    private static final int YEAR_INDEX = 2;

    @FormattableElement(alt = "y", dynamic = true, format = "Y")
    public static final StdCalendarElement<Integer, BadiCalendar> YEAR_OF_ERA;

    @FormattableElement(alt = "x", dynamic = true, format = "X")
    public static final TextElement<Integer> YEAR_OF_VAHID;
    private static final int YOE_INDEX = 5;
    private static final long serialVersionUID = 7091925253640345123L;
    private final transient int cycle;
    private final transient int day;
    private final transient int division;
    private final transient int major;
    private final transient int year;
    public static final AttributeKey<FormattedContent> TEXT_CONTENT_ATTRIBUTE = Attributes.createKey("FORMATTED_CONTENT", FormattedContent.class);
    private static final SolarTime TEHERAN = SolarTime.ofLocation().easternLongitude(51, 25, 0.0d).northernLatitude(35, 42, 0.0d).usingCalculator(StdSolarCalculator.TIME4J).build();

    private static int getRelatedGregorianYear(int i, int i2, int i3) {
        return ((i - 1) * 361) + ((i2 - 1) * 19) + i3 + 1843;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.time4j.engine.ChronoEntity
    public BadiCalendar getContext() {
        return this;
    }

    static {
        int[] iArr = new int[913];
        int[] iArr2 = new int[913];
        ByteBuffer.wrap("\u0000\u0000=©\u0000\u0000?\u0016\u0000\u0000@\u0083\u0000\u0000Añ\u0000\u0000C^\u0000\u0000DË\u0000\u0000F8\u0000\u0000G¦\u0000\u0000I\u0013\u0000\u0000J\u0080\u0000\u0000Kí\u0000\u0000M[\u0000\u0000NÈ\u0000\u0000P5\u0000\u0000Q¢\u0000\u0000S\u000f\u0000\u0000T}\u0000\u0000Uê\u0000\u0000WW\u0000\u0000XÄ\u0000\u0000Z2\u0000\u0000[\u009f\u0000\u0000]\f\u0000\u0000^y\u0000\u0000_ç\u0000\u0000aT\u0000\u0000bÁ\u0000\u0000d.\u0000\u0000e\u009c\u0000\u0000g\t\u0000\u0000hv\u0000\u0000iã\u0000\u0000kQ\u0000\u0000l¾\u0000\u0000n+\u0000\u0000o\u0098\u0000\u0000q\u0006\u0000\u0000rs\u0000\u0000sà\u0000\u0000uM\u0000\u0000v»\u0000\u0000x(\u0000\u0000y\u0095\u0000\u0000{\u0002\u0000\u0000|o\u0000\u0000}Ý\u0000\u0000\u007fJ\u0000\u0000\u0080·\u0000\u0000\u0082$\u0000\u0000\u0083\u0092\u0000\u0000\u0084ÿ\u0000\u0000\u0086l\u0000\u0000\u0087Ù\u0000\u0000\u0089G\u0000\u0000\u008a´\u0000\u0000\u008c!\u0000\u0000\u008d\u008e\u0000\u0000\u008eü\u0000\u0000\u0090i\u0000\u0000\u0091Ö\u0000\u0000\u0093C\u0000\u0000\u0094±\u0000\u0000\u0096\u001e\u0000\u0000\u0097\u008b\u0000\u0000\u0098ø\u0000\u0000\u009af\u0000\u0000\u009bÓ\u0000\u0000\u009d@\u0000\u0000\u009e\u00ad\u0000\u0000 \u001b\u0000\u0000¡\u0088\u0000\u0000¢õ\u0000\u0000¤b\u0000\u0000¥Ð\u0000\u0000§=\u0000\u0000¨ª\u0000\u0000ª\u0017\u0000\u0000«\u0084\u0000\u0000¬ò\u0000\u0000®_\u0000\u0000¯Ì\u0000\u0000±9\u0000\u0000²§\u0000\u0000´\u0014\u0000\u0000µ\u0081\u0000\u0000¶î\u0000\u0000¸\\\u0000\u0000¹É\u0000\u0000»6\u0000\u0000¼£\u0000\u0000¾\u0011\u0000\u0000¿~\u0000\u0000Àë\u0000\u0000ÂX\u0000\u0000ÃÆ\u0000\u0000Å3\u0000\u0000Æ \u0000\u0000È\r\u0000\u0000É{\u0000\u0000Êè\u0000\u0000ÌU\u0000\u0000ÍÂ\u0000\u0000Ï0\u0000\u0000Ð\u009d\u0000\u0000Ò\n\u0000\u0000Ów\u0000\u0000Ôå\u0000\u0000ÖR\u0000\u0000×¿\u0000\u0000Ù,\u0000\u0000Ú\u0099\u0000\u0000Ü\u0007\u0000\u0000Ýt\u0000\u0000Þá\u0000\u0000àN\u0000\u0000á¼\u0000\u0000ã)\u0000\u0000ä\u0096\u0000\u0000æ\u0003\u0000\u0000çq\u0000\u0000èÞ\u0000\u0000êK\u0000\u0000ë¸\u0000\u0000í&\u0000\u0000î\u0093\u0000\u0000ð\u0000\u0000\u0000ñm\u0000\u0000òÛ\u0000\u0000ôH\u0000\u0000õµ\u0000\u0000÷\"\u0000\u0000ø\u0090\u0000\u0000ùý\u0000\u0000ûj\u0000\u0000ü×\u0000\u0000þE\u0000\u0000ÿ²\u0000\u0001\u0001\u001f\u0000\u0001\u0002\u008c\u0000\u0001\u0003ú\u0000\u0001\u0005g\u0000\u0001\u0006Ô\u0000\u0001\bA\u0000\u0001\t®\u0000\u0001\u000b\u001c\u0000\u0001\f\u0089\u0000\u0001\rö\u0000\u0001\u000fc\u0000\u0001\u0010Ñ\u0000\u0001\u0012>\u0000\u0001\u0013«\u0000\u0001\u0015\u0018\u0000\u0001\u0016\u0086\u0000\u0001\u0017ó\u0000\u0001\u0019`\u0000\u0001\u001aÍ\u0000\u0001\u001c;\u0000\u0001\u001d¨\u0000\u0001\u001f\u0015\u0000\u0001 \u0082\u0000\u0001!ð\u0000\u0001#]\u0000\u0001$Ê\u0000\u0001&7\u0000\u0001'¥\u0000\u0001)\u0012\u0000\u0001*\u007f\u0000\u0001+ì\u0000\u0001-Z\u0000\u0001.Ç\u0000\u000104\u0000\u00011¡\u0000\u00013\u000f\u0000\u00014|\u0000\u00015é\u0000\u00017V\u0000\u00018Ã\u0000\u0001:1\u0000\u0001;\u009e\u0000\u0001=\u000b\u0000\u0001>x\u0000\u0001?æ\u0000\u0001AS\u0000\u0001BÀ\u0000\u0001D-\u0000\u0001E\u009b\u0000\u0001G\b\u0000\u0001Hu\u0000\u0001Iâ\u0000\u0001KP\u0000\u0001L½\u0000\u0001N*\u0000\u0001O\u0097\u0000\u0001Q\u0005\u0000\u0001Rr\u0000\u0001Sß\u0000\u0001UL\u0000\u0001Vº\u0000\u0001X'\u0000\u0001Y\u0094\u0000\u0001[\u0001\u0000\u0001\\o\u0000\u0001]Ü\u0000\u0001_I\u0000\u0001`¶\u0000\u0001b$\u0000\u0001c\u0091\u0000\u0001dþ\u0000\u0001fk\u0000\u0001gØ\u0000\u0001iF\u0000\u0001j³\u0000\u0001l \u0000\u0001m\u008d\u0000\u0001nû\u0000\u0001ph\u0000\u0001qÕ\u0000\u0001sB\u0000\u0001t°\u0000\u0001v\u001d\u0000\u0001w\u008a\u0000\u0001x÷\u0000\u0001ze\u0000\u0001{Ò\u0000\u0001}?\u0000\u0001~¬\u0000\u0001\u0080\u001a\u0000\u0001\u0081\u0087\u0000\u0001\u0082ô\u0000\u0001\u0084a\u0000\u0001\u0085Ï\u0000\u0001\u0087<\u0000\u0001\u0088©\u0000\u0001\u008a\u0016\u0000\u0001\u008b\u0084\u0000\u0001\u008cñ\u0000\u0001\u008e^\u0000\u0001\u008fË\u0000\u0001\u00919\u0000\u0001\u0092¦\u0000\u0001\u0094\u0013\u0000\u0001\u0095\u0080\u0000\u0001\u0096í\u0000\u0001\u0098[\u0000\u0001\u0099È\u0000\u0001\u009b5\u0000\u0001\u009c¢\u0000\u0001\u009e\u0010\u0000\u0001\u009f}\u0000\u0001 ê\u0000\u0001¢W\u0000\u0001£Å\u0000\u0001¥2\u0000\u0001¦\u009f\u0000\u0001¨\f\u0000\u0001©z\u0000\u0001ªç\u0000\u0001¬T\u0000\u0001\u00adÁ\u0000\u0001¯/\u0000\u0001°\u009c\u0000\u0001²\t\u0000\u0001³v\u0000\u0001´ä\u0000\u0001¶Q\u0000\u0001·¾\u0000\u0001¹+\u0000\u0001º\u0099\u0000\u0001¼\u0006\u0000\u0001½s\u0000\u0001¾à\u0000\u0001ÀN\u0000\u0001Á»\u0000\u0001Ã(\u0000\u0001Ä\u0095\u0000\u0001Æ\u0002\u0000\u0001Çp\u0000\u0001ÈÝ\u0000\u0001ÊJ\u0000\u0001Ë·\u0000\u0001Í%\u0000\u0001Î\u0092\u0000\u0001Ïÿ\u0000\u0001Ñl\u0000\u0001ÒÚ\u0000\u0001ÔG\u0000\u0001Õ´\u0000\u0001×!\u0000\u0001Ø\u008f\u0000\u0001Ùü\u0000\u0001Ûi\u0000\u0001ÜÖ\u0000\u0001ÞD\u0000\u0001ß±\u0000\u0001á\u001e\u0000\u0001â\u008b\u0000\u0001ãù\u0000\u0001åf\u0000\u0001æÓ\u0000\u0001è@\u0000\u0001é®\u0000\u0001ë\u001b\u0000\u0001ì\u0088\u0000\u0001íõ\u0000\u0001ïc\u0000\u0001ðÐ\u0000\u0001ò=\u0000\u0001óª\u0000\u0001õ\u0017\u0000\u0001ö\u0085\u0000\u0001÷ò\u0000\u0001ù_\u0000\u0001úÌ\u0000\u0001ü:\u0000\u0001ý§\u0000\u0001ÿ\u0014\u0000\u0002\u0000\u0081\u0000\u0002\u0001ï\u0000\u0002\u0003\\\u0000\u0002\u0004É\u0000\u0002\u00066\u0000\u0002\u0007¤\u0000\u0002\t\u0011\u0000\u0002\n~\u0000\u0002\u000bë\u0000\u0002\rY\u0000\u0002\u000eÆ\u0000\u0002\u00103\u0000\u0002\u0011 \u0000\u0002\u0013\u000e\u0000\u0002\u0014{\u0000\u0002\u0015è\u0000\u0002\u0017U\u0000\u0002\u0018Ã\u0000\u0002\u001a0\u0000\u0002\u001b\u009d\u0000\u0002\u001d\n\u0000\u0002\u001ex\u0000\u0002\u001få\u0000\u0002!R\u0000\u0002\"¿\u0000\u0002$,\u0000\u0002%\u009a\u0000\u0002'\u0007\u0000\u0002(t\u0000\u0002)á\u0000\u0002+O\u0000\u0002,¼\u0000\u0002.)\u0000\u0002/\u0096\u0000\u00021\u0004\u0000\u00022q\u0000\u00023Þ\u0000\u00025K\u0000\u00026¹\u0000\u00028&\u0000\u00029\u0093\u0000\u0002;\u0000\u0000\u0002<n\u0000\u0002=Û\u0000\u0002?H\u0000\u0002@µ\u0000\u0002B#\u0000\u0002C\u0090\u0000\u0002Dý\u0000\u0002Fj\u0000\u0002GØ\u0000\u0002IE\u0000\u0002J²\u0000\u0002L\u001f\u0000\u0002M\u008c\u0000\u0002Nú\u0000\u0002Pg\u0000\u0002QÔ\u0000\u0002SA\u0000\u0002T¯\u0000\u0002V\u001c\u0000\u0002W\u0089\u0000\u0002Xö\u0000\u0002Zd\u0000\u0002[Ñ\u0000\u0002]>\u0000\u0002^«\u0000\u0002`\u0019\u0000\u0002a\u0086\u0000\u0002bó\u0000\u0002d`\u0000\u0002eÎ\u0000\u0002g;\u0000\u0002h¨\u0000\u0002j\u0015\u0000\u0002k\u0083\u0000\u0002lð\u0000\u0002n]\u0000\u0002oÊ\u0000\u0002q8\u0000\u0002r¥\u0000\u0002t\u0012\u0000\u0002u\u007f\u0000\u0002ví\u0000\u0002xZ\u0000\u0002yÇ\u0000\u0002{4\u0000\u0002|¢\u0000\u0002~\u000f\u0000\u0002\u007f|\u0000\u0002\u0080é\u0000\u0002\u0082V\u0000\u0002\u0083Ä\u0000\u0002\u00851\u0000\u0002\u0086\u009e\u0000\u0002\u0088\u000b\u0000\u0002\u0089y\u0000\u0002\u008aæ\u0000\u0002\u008cS\u0000\u0002\u008dÀ\u0000\u0002\u008f.\u0000\u0002\u0090\u009b\u0000\u0002\u0092\b\u0000\u0002\u0093u\u0000\u0002\u0094ã\u0000\u0002\u0096P\u0000\u0002\u0097½\u0000\u0002\u0099*\u0000\u0002\u009a\u0098\u0000\u0002\u009c\u0005\u0000\u0002\u009dr\u0000\u0002\u009eß\u0000\u0002 M\u0000\u0002¡º\u0000\u0002£'\u0000\u0002¤\u0094\u0000\u0002¦\u0002\u0000\u0002§o\u0000\u0002¨Ü\u0000\u0002ªI\u0000\u0002«·\u0000\u0002\u00ad$\u0000\u0002®\u0091\u0000\u0002¯þ\u0000\u0002±k\u0000\u0002²Ù\u0000\u0002´F\u0000\u0002µ³\u0000\u0002· \u0000\u0002¸\u008e\u0000\u0002¹û\u0000\u0002»h\u0000\u0002¼Õ\u0000\u0002¾C\u0000\u0002¿°\u0000\u0002Á\u001d\u0000\u0002Â\u008a\u0000\u0002Ãø\u0000\u0002Åe\u0000\u0002ÆÒ\u0000\u0002È?\u0000\u0002É\u00ad\u0000\u0002Ë\u001a\u0000\u0002Ì\u0087\u0000\u0002Íô\u0000\u0002Ïb\u0000\u0002ÐÏ\u0000\u0002Ò<\u0000\u0002Ó©\u0000\u0002Õ\u0017\u0000\u0002Ö\u0084\u0000\u0002×ñ\u0000\u0002Ù^\u0000\u0002ÚÌ\u0000\u0002Ü9\u0000\u0002Ý¦\u0000\u0002ß\u0013\u0000\u0002à\u0080\u0000\u0002áî\u0000\u0002ã[\u0000\u0002äÈ\u0000\u0002æ5\u0000\u0002ç£\u0000\u0002é\u0010\u0000\u0002ê}\u0000\u0002ëê\u0000\u0002íX\u0000\u0002îÅ\u0000\u0002ð2\u0000\u0002ñ\u009f\u0000\u0002ó\r\u0000\u0002ôz\u0000\u0002õç\u0000\u0002÷T\u0000\u0002øÂ\u0000\u0002ú/\u0000\u0002û\u009c\u0000\u0002ý\t\u0000\u0002þw\u0000\u0002ÿä\u0000\u0003\u0001Q\u0000\u0003\u0002¾\u0000\u0003\u0004,\u0000\u0003\u0005\u0099\u0000\u0003\u0007\u0006\u0000\u0003\bs\u0000\u0003\tà\u0000\u0003\u000bN\u0000\u0003\f»\u0000\u0003\u000e(\u0000\u0003\u000f\u0095\u0000\u0003\u0011\u0003\u0000\u0003\u0012p\u0000\u0003\u0013Ý\u0000\u0003\u0015J\u0000\u0003\u0016¸\u0000\u0003\u0018%\u0000\u0003\u0019\u0092\u0000\u0003\u001aÿ\u0000\u0003\u001cm\u0000\u0003\u001dÚ\u0000\u0003\u001fG\u0000\u0003 ´\u0000\u0003\"\"\u0000\u0003#\u008f\u0000\u0003$ü\u0000\u0003&i\u0000\u0003'×\u0000\u0003)D\u0000\u0003*±\u0000\u0003,\u001e\u0000\u0003-\u008c\u0000\u0003.ù\u0000\u00030f\u0000\u00031Ó\u0000\u00033A\u0000\u00034®\u0000\u00036\u001b\u0000\u00037\u0088\u0000\u00038õ\u0000\u0003:c\u0000\u0003;Ð\u0000\u0003==\u0000\u0003>ª\u0000\u0003@\u0018\u0000\u0003A\u0085\u0000\u0003Bò\u0000\u0003D_\u0000\u0003EÍ\u0000\u0003G:\u0000\u0003H§\u0000\u0003J\u0014\u0000\u0003K\u0082\u0000\u0003Lï\u0000\u0003N\\\u0000\u0003OÉ\u0000\u0003Q7\u0000\u0003R¤\u0000\u0003T\u0011\u0000\u0003U~\u0000\u0003Vì\u0000\u0003XY\u0000\u0003YÆ\u0000\u0003[3\u0000\u0003\\¡\u0000\u0003^\u000e\u0000\u0003_{\u0000\u0003`è\u0000\u0003bV\u0000\u0003cÃ\u0000\u0003e0\u0000\u0003f\u009d\u0000\u0003h\n\u0000\u0003ix\u0000\u0003jå\u0000\u0003lR\u0000\u0003m¿\u0000\u0003o-\u0000\u0003p\u009a\u0000\u0003r\u0007\u0000\u0003st\u0000\u0003tâ\u0000\u0003vO\u0000\u0003w¼\u0000\u0003y)\u0000\u0003z\u0097\u0000\u0003|\u0004\u0000\u0003}q\u0000\u0003~Þ\u0000\u0003\u0080L\u0000\u0003\u0081¹\u0000\u0003\u0083&\u0000\u0003\u0084\u0093\u0000\u0003\u0086\u0001\u0000\u0003\u0087n\u0000\u0003\u0088Û\u0000\u0003\u008aH\u0000\u0003\u008b¶\u0000\u0003\u008d#\u0000\u0003\u008e\u0090\u0000\u0003\u008fý\u0000\u0003\u0091k\u0000\u0003\u0092Ø\u0000\u0003\u0094E\u0000\u0003\u0095²\u0000\u0003\u0097\u001f\u0000\u0003\u0098\u008d\u0000\u0003\u0099ú\u0000\u0003\u009bg\u0000\u0003\u009cÔ\u0000\u0003\u009eB\u0000\u0003\u009f¯\u0000\u0003¡\u001c\u0000\u0003¢\u0089\u0000\u0003£÷\u0000\u0003¥d\u0000\u0003¦Ñ\u0000\u0003¨>\u0000\u0003©¬\u0000\u0003«\u0019\u0000\u0003¬\u0086\u0000\u0003\u00adó\u0000\u0003¯a\u0000\u0003°Î\u0000\u0003²;\u0000\u0003³¨\u0000\u0003µ\u0016\u0000\u0003¶\u0083\u0000\u0003·ð\u0000\u0003¹]\u0000\u0003ºË\u0000\u0003¼8\u0000\u0003½¥\u0000\u0003¿\u0012\u0000\u0003À\u0080\u0000\u0003Áí\u0000\u0003ÃZ\u0000\u0003ÄÇ\u0000\u0003Æ4\u0000\u0003Ç¢\u0000\u0003É\u000f\u0000\u0003Ê|\u0000\u0003Ëé\u0000\u0003ÍW\u0000\u0003ÎÄ\u0000\u0003Ð1\u0000\u0003Ñ\u009e\u0000\u0003Ó\f\u0000\u0003Ôy\u0000\u0003Õæ\u0000\u0003×S\u0000\u0003ØÁ\u0000\u0003Ú.\u0000\u0003Û\u009b\u0000\u0003Ý\b\u0000\u0003Þv\u0000\u0003ßã\u0000\u0003áP\u0000\u0003â½\u0000\u0003ä+\u0000\u0003å\u0098\u0000\u0003ç\u0005\u0000\u0003èr\u0000\u0003éà\u0000\u0003ëM\u0000\u0003ìº\u0000\u0003î'\u0000\u0003ï\u0095\u0000\u0003ñ\u0002\u0000\u0003òo\u0000\u0003óÜ\u0000\u0003õI\u0000\u0003ö·\u0000\u0003ø$\u0000\u0003ù\u0091\u0000\u0003úþ\u0000\u0003ül\u0000\u0003ýÙ\u0000\u0003ÿF\u0000\u0004\u0000³\u0000\u0004\u0002!\u0000\u0004\u0003\u008e\u0000\u0004\u0004û\u0000\u0004\u0006h\u0000\u0004\u0007Ö\u0000\u0004\tC\u0000\u0004\n°\u0000\u0004\f\u001d\u0000\u0004\r\u008b\u0000\u0004\u000eø\u0000\u0004\u0010e\u0000\u0004\u0011Ò\u0000\u0004\u0013@\u0000\u0004\u0014\u00ad\u0000\u0004\u0016\u001a\u0000\u0004\u0017\u0087\u0000\u0004\u0018õ\u0000\u0004\u001ab\u0000\u0004\u001bÏ\u0000\u0004\u001d<\u0000\u0004\u001eª\u0000\u0004 \u0017\u0000\u0004!\u0084\u0000\u0004\"ñ\u0000\u0004$^\u0000\u0004%Ì\u0000\u0004'9\u0000\u0004(¦\u0000\u0004*\u0013\u0000\u0004+\u0081\u0000\u0004,î\u0000\u0004.[\u0000\u0004/È\u0000\u000416\u0000\u00042£\u0000\u00044\u0010\u0000\u00045}\u0000\u00046ë\u0000\u00048X\u0000\u00049Å\u0000\u0004;2\u0000\u0004< \u0000\u0004>\r\u0000\u0004?z\u0000\u0004@ç\u0000\u0004BU\u0000\u0004CÂ\u0000\u0004E/\u0000\u0004F\u009c\u0000\u0004H\n\u0000\u0004Iw\u0000\u0004Jä\u0000\u0004LQ\u0000\u0004M¿\u0000\u0004O,\u0000\u0004P\u0099\u0000\u0004R\u0006\u0000\u0004Ss\u0000\u0004Tá\u0000\u0004VN\u0000\u0004W»\u0000\u0004Y(\u0000\u0004Z\u0096\u0000\u0004\\\u0003\u0000\u0004]p\u0000\u0004^Ý\u0000\u0004`K\u0000\u0004a¸\u0000\u0004c%\u0000\u0004d\u0092\u0000\u0004f\u0000\u0000\u0004gm\u0000\u0004hÚ\u0000\u0004jG\u0000\u0004kµ\u0000\u0004m\"\u0000\u0004n\u008f\u0000\u0004oü\u0000\u0004qj\u0000\u0004r×\u0000\u0004tD\u0000\u0004u±\u0000\u0004w\u001f\u0000\u0004x\u008c\u0000\u0004yù\u0000\u0004{f\u0000\u0004|Ô\u0000\u0004~A\u0000\u0004\u007f®\u0000\u0004\u0081\u001b\u0000\u0004\u0082\u0088\u0000\u0004\u0083ö\u0000\u0004\u0085c\u0000\u0004\u0086Ð\u0000\u0004\u0088=\u0000\u0004\u0089«\u0000\u0004\u008b\u0018\u0000\u0004\u008c\u0085\u0000\u0004\u008dò\u0000\u0004\u008f`\u0000\u0004\u0090Í\u0000\u0004\u0092:\u0000\u0004\u0093§\u0000\u0004\u0095\u0015\u0000\u0004\u0096\u0082\u0000\u0004\u0097ï\u0000\u0004\u0099\\\u0000\u0004\u009aÊ\u0000\u0004\u009c7\u0000\u0004\u009d¤\u0000\u0004\u009f\u0011\u0000\u0004 \u007f\u0000\u0004¡ì\u0000\u0004£Y\u0000\u0004¤Æ\u0000\u0004¦4\u0000\u0004§¡\u0000\u0004©\u000e\u0000\u0004ª{\u0000\u0004«é\u0000\u0004\u00adV\u0000\u0004®Ã\u0000\u0004°0\u0000\u0004±\u009d\u0000\u0004³\u000b\u0000\u0004´x\u0000\u0004µå\u0000\u0004·R\u0000\u0004¸À\u0000\u0004º-\u0000\u0004»\u009a\u0000\u0004½\u0007\u0000\u0004¾u\u0000\u0004¿â\u0000\u0004ÁO\u0000\u0004Â¼\u0000\u0004Ä*\u0000\u0004Å\u0097\u0000\u0004Ç\u0004\u0000\u0004Èq\u0000\u0004Éß\u0000\u0004ËL\u0000\u0004Ì¹\u0000\u0004Î&\u0000\u0004Ï\u0094\u0000\u0004Ñ\u0001\u0000\u0004Òn\u0000\u0004ÓÛ\u0000\u0004ÕI\u0000\u0004Ö¶\u0000\u0004Ø#\u0000\u0004Ù\u0090\u0000\u0004Úþ\u0000\u0004Ük\u0000\u0004ÝØ\u0000\u0004ßE\u0000\u0004à²\u0000\u0004â \u0000\u0004ã\u008d\u0000\u0004äú\u0000\u0004æg\u0000\u0004çÕ\u0000\u0004éB\u0000\u0004ê¯\u0000\u0004ì\u001c\u0000\u0004í\u008a\u0000\u0004î÷\u0000\u0004ðd\u0000\u0004ñÑ\u0000\u0004ó?\u0000\u0004ô¬\u0000\u0004ö\u0019\u0000\u0004÷\u0086\u0000\u0004øô\u0000\u0004úa\u0000\u0004ûÎ\u0000\u0004ý;\u0000\u0004þ©\u0000\u0005\u0000\u0016\u0000\u0005\u0001\u0083\u0000\u0005\u0002ð\u0000\u0005\u0004^\u0000\u0005\u0005Ë\u0000\u0005\u00078\u0000\u0005\b¥\u0000\u0005\n\u0013\u0000\u0005\u000b\u0080\u0000\u0005\fí\u0000\u0005\u000eZ\u0000\u0005\u000fÇ\u0000\u0005\u00115\u0000\u0005\u0012¢\u0000\u0005\u0014\u000f\u0000\u0005\u0015|\u0000\u0005\u0016ê\u0000\u0005\u0018W\u0000\u0005\u0019Ä\u0000\u0005\u001b1\u0000\u0005\u001c\u009f\u0000\u0005\u001e\f\u0000\u0005\u001fy\u0000\u0005 æ\u0000\u0005\"T\u0000\u0005#Á\u0000\u0005%.\u0000\u0005&\u009b\u0000\u0005(\t\u0000\u0005)v\u0000\u0005*ã\u0000\u0005,P\u0000\u0005-¾\u0000\u0005/+\u0000\u00050\u0098\u0000\u00052\u0005\u0000\u00053s\u0000\u00054à\u0000\u00056M\u0000\u00057º\u0000\u00059(\u0000\u0005:\u0095\u0000\u0005<\u0002\u0000\u0005=o\u0000\u0005>Ü\u0000\u0005@J\u0000\u0005A·\u0000\u0005C$\u0000\u0005D\u0091\u0000\u0005Eÿ\u0000\u0005Gl\u0000\u0005HÙ\u0000\u0005JF\u0000\u0005K´\u0000\u0005M!\u0000\u0005N\u008e\u0000\u0005Oû\u0000\u0005Qi\u0000\u0005RÖ".getBytes(CharEncoding.ISO_8859_1)).asIntBuffer().get(iArr2, 0, 913);
        System.arraycopy(iArr2, 0, iArr, 0, 913);
        NEWROZ = iArr;
        StdEnumDateElement<BadiEra, BadiCalendar> stdEnumDateElement = new StdEnumDateElement<BadiEra, BadiCalendar>("ERA", BadiCalendar.class, BadiEra.class, 'G') { // from class: net.time4j.calendar.bahai.BadiCalendar.1
            @Override // net.time4j.calendar.service.StdEnumDateElement
            public TextAccessor accessor(AttributeQuery attributeQuery, OutputContext outputContext, boolean z) {
                return BadiEra.accessor((Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT), (TextWidth) attributeQuery.get(Attributes.TEXT_WIDTH, TextWidth.WIDE));
            }
        };
        ERA = stdEnumDateElement;
        StdIntegerDateElement stdIntegerDateElement = new StdIntegerDateElement("YEAR_OF_ERA", BadiCalendar.class, 1, 1083, 'Y');
        YEAR_OF_ERA = stdIntegerDateElement;
        StdIntegerDateElement<BadiCalendar> stdIntegerDateElement2 = new StdIntegerDateElement<BadiCalendar>("KULL_I_SHAI", BadiCalendar.class, 1, 3, 'K') { // from class: net.time4j.calendar.bahai.BadiCalendar.2
            @Override // net.time4j.format.DisplayElement, net.time4j.engine.BasicElement, net.time4j.engine.ChronoElement
            public String getDisplayName(Locale locale) {
                return CalendarText.getInstance("bahai", locale).getTextForms().get("K");
            }
        };
        KULL_I_SHAI = stdIntegerDateElement2;
        StdIntegerDateElement<BadiCalendar> stdIntegerDateElement3 = new StdIntegerDateElement<BadiCalendar>("VAHID", BadiCalendar.class, 1, 19, 'V') { // from class: net.time4j.calendar.bahai.BadiCalendar.3
            @Override // net.time4j.format.DisplayElement, net.time4j.engine.BasicElement, net.time4j.engine.ChronoElement
            public String getDisplayName(Locale locale) {
                return CalendarText.getInstance("bahai", locale).getTextForms().get(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
            }
        };
        VAHID = stdIntegerDateElement3;
        YOV yov = YOV.SINGLETON;
        YEAR_OF_VAHID = yov;
        MonthElement monthElement = MonthElement.SINGLETON;
        MONTH_OF_YEAR = monthElement;
        IntercalaryAccess intercalaryAccess = IntercalaryAccess.SINGLETON;
        AYYAM_I_HA = intercalaryAccess;
        StdIntegerDateElement stdIntegerDateElement4 = new StdIntegerDateElement("DAY_OF_DIVISION", BadiCalendar.class, 1, 19, 'D');
        DAY_OF_DIVISION = stdIntegerDateElement4;
        StdIntegerDateElement stdIntegerDateElement5 = new StdIntegerDateElement("DAY_OF_YEAR", BadiCalendar.class, 1, 365, (char) 0);
        DAY_OF_YEAR = stdIntegerDateElement5;
        DowElement dowElement = DowElement.SINGLETON;
        DAY_OF_WEEK = dowElement;
        Transformer transformer = new Transformer();
        CALSYS = transformer;
        TimeAxis.Builder builderAppendElement = TimeAxis.Builder.setUp(Unit.class, BadiCalendar.class, new Merger(), transformer).appendElement((ChronoElement) stdEnumDateElement, (ElementRule) new EraRule());
        IntegerRule integerRule = new IntegerRule(5);
        Unit unit = Unit.YEARS;
        TimeAxis.Builder builderAppendElement2 = builderAppendElement.appendElement(stdIntegerDateElement, integerRule, unit).appendElement((ChronoElement) stdIntegerDateElement2, (ElementRule) new IntegerRule(0));
        IntegerRule integerRule2 = new IntegerRule(1);
        Unit unit2 = Unit.VAHID_CYCLES;
        TimeAxis.Builder builderAppendElement3 = builderAppendElement2.appendElement(stdIntegerDateElement3, integerRule2, unit2).appendElement(yov, new IntegerRule(2), unit);
        MonthRule monthRule = new MonthRule();
        Unit unit3 = Unit.MONTHS;
        TimeAxis.Builder builderAppendElement4 = builderAppendElement3.appendElement(monthElement, monthRule, unit3).appendElement((ChronoElement) intercalaryAccess, (ElementRule) intercalaryAccess);
        IntegerRule integerRule3 = new IntegerRule(3);
        Unit unit4 = Unit.DAYS;
        TimeAxis.Builder builderAppendUnit = builderAppendElement4.appendElement(stdIntegerDateElement4, integerRule3, unit4).appendElement(stdIntegerDateElement5, new IntegerRule(4), unit4).appendElement(dowElement, new WeekdayRule(), unit4).appendUnit(unit2, new FUnitRule(unit2), unit2.getLength(), Collections.singleton(unit)).appendUnit(unit, new FUnitRule(unit), unit.getLength(), Collections.singleton(unit2)).appendUnit(unit3, new FUnitRule(unit3), unit3.getLength());
        Unit unit5 = Unit.WEEKS;
        ENGINE = builderAppendUnit.appendUnit(unit5, new FUnitRule(unit5), unit5.getLength(), Collections.singleton(unit4)).appendUnit(unit4, new FUnitRule(unit4), unit4.getLength(), Collections.singleton(unit5)).build();
    }

    private BadiCalendar(int i, int i2, int i3, int i4, int i5) {
        this.major = i;
        this.cycle = i2;
        this.year = i3;
        this.division = i4;
        this.day = i5;
    }

    public static BadiCalendar ofComplete(int i, int i2, int i3, BadiDivision badiDivision, int i4) {
        if (i < 1 || i > 3) {
            throw new IllegalArgumentException("Major cycle (kull-i-shai) out of range 1-3: " + i);
        }
        if (i2 < 1 || i2 > 19) {
            throw new IllegalArgumentException("Vahid cycle out of range 1-19: " + i2);
        }
        if (i3 < 1 || i3 > 19) {
            throw new IllegalArgumentException("Year of vahid out of range 1-19: " + i3);
        }
        if (badiDivision instanceof BadiMonth) {
            if (i4 < 1 || i4 > 19) {
                throw new IllegalArgumentException("Day out of range 1-19: " + i4);
            }
            return new BadiCalendar(i, i2, i3, ((BadiMonth) BadiMonth.class.cast(badiDivision)).getValue(), i4);
        }
        if (badiDivision != BadiIntercalaryDays.AYYAM_I_HA) {
            if (badiDivision == null) {
                throw new NullPointerException("Missing Badi month or Ayyam-i-Ha.");
            }
            throw new IllegalArgumentException("Invalid implementation of Badi division: " + badiDivision);
        }
        int i5 = isLeapYear(i, i2, i3) ? 5 : 4;
        if (i4 < 1 || i4 > i5) {
            throw new IllegalArgumentException("Day out of range 1-" + i5 + ": " + i4);
        }
        return new BadiCalendar(i, i2, i3, 0, i4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static BadiCalendar ofComplete(BadiEra badiEra, int i, BadiDivision badiDivision, int i2) {
        if (badiEra == null) {
            throw new NullPointerException("Missing Bahai era.");
        }
        if (i < 1 || i > 1083) {
            throw new IllegalArgumentException("Year of era out of range 1-1083: " + i);
        }
        BadiCalendar badiCalendar = (BadiCalendar) ((BadiCalendar) axis().getMinimum()).with((ChronoElement<Integer>) YEAR_OF_ERA, i);
        int kullishai = badiCalendar.getKullishai();
        int vahid = badiCalendar.getVahid();
        int yearOfVahid = badiCalendar.getYearOfVahid();
        if (badiDivision instanceof BadiMonth) {
            if (i2 < 1 || i2 > 19) {
                throw new IllegalArgumentException("Day out of range 1-19: " + i2);
            }
            return new BadiCalendar(kullishai, vahid, yearOfVahid, ((BadiMonth) BadiMonth.class.cast(badiDivision)).getValue(), i2);
        }
        if (badiDivision != BadiIntercalaryDays.AYYAM_I_HA) {
            if (badiDivision == null) {
                throw new NullPointerException("Missing Badi month or Ayyam-i-Ha.");
            }
            throw new IllegalArgumentException("Invalid implementation of Badi division: " + badiDivision);
        }
        int i3 = isLeapYear(kullishai, vahid, yearOfVahid) ? 5 : 4;
        if (i2 < 1 || i2 > i3) {
            throw new IllegalArgumentException("Day out of range 1-" + i3 + ": " + i2);
        }
        return new BadiCalendar(kullishai, vahid, yearOfVahid, 0, i2);
    }

    public static BadiCalendar of(int i, int i2, BadiMonth badiMonth, int i3) {
        return ofComplete(1, i, i2, badiMonth, i3);
    }

    public static BadiCalendar of(int i, int i2, int i3, int i4) {
        return ofComplete(1, i, i2, BadiMonth.valueOf(i3), i4);
    }

    public static BadiCalendar ofIntercalary(int i, int i2, int i3) {
        return ofComplete(1, i, i2, BadiIntercalaryDays.AYYAM_I_HA, i3);
    }

    public static BadiCalendar nowInSystemTime() {
        return (BadiCalendar) SystemClock.inLocalView().now(axis());
    }

    public int getKullishai() {
        return this.major;
    }

    public int getVahid() {
        return this.cycle;
    }

    public int getYearOfVahid() {
        return this.year;
    }

    public int getYearOfEra() {
        return getRelatedGregorianYear() - 1843;
    }

    public BadiMonth getMonth() {
        int i = this.division;
        if (i == 0) {
            throw new ChronoException("Intercalary days (Ayyam-i-Ha) do not represent any month: " + toString());
        }
        return BadiMonth.valueOf(i);
    }

    public BadiDivision getDivision() {
        return isIntercalaryDay() ? BadiIntercalaryDays.AYYAM_I_HA : getMonth();
    }

    public int getDayOfDivision() {
        return this.day;
    }

    public Weekday getDayOfWeek() {
        return Weekday.valueOf(MathUtils.floorModulo(CALSYS.transform(this) + 5, 7) + 1);
    }

    public int getDayOfYear() {
        int i = this.division;
        if (i == 0) {
            return this.day + 342;
        }
        if (i != 19) {
            return ((i - 1) * 19) + this.day;
        }
        return (isLeapYear() ? 5 : 4) + 342 + this.day;
    }

    public boolean isIntercalaryDay() {
        return this.division == 0;
    }

    public boolean hasMonth() {
        return this.division > 0;
    }

    public boolean isLeapYear() {
        return isLeapYear(this.major, this.cycle, this.year);
    }

    public static boolean isLeapYear(int i, int i2, int i3) {
        if (i < 1 || i > 3) {
            throw new IllegalArgumentException("Major cycle (kull-i-shai) out of range 1-3: " + i);
        }
        if (i2 < 1 || i2 > 19) {
            throw new IllegalArgumentException("Vahid cycle out of range 1-19: " + i2);
        }
        if (i3 < 1 || i3 > 19) {
            throw new IllegalArgumentException("Year out of range 1-19: " + i3);
        }
        int relatedGregorianYear = getRelatedGregorianYear(i, i2, i3);
        if (relatedGregorianYear < 2015) {
            return GregorianMath.isLeapYear(relatedGregorianYear + 1);
        }
        int[] iArr = NEWROZ;
        return iArr[relatedGregorianYear + (-2014)] - iArr[relatedGregorianYear - 2015] == 366;
    }

    public static boolean isValid(int i, int i2, int i3, BadiDivision badiDivision, int i4) {
        if (i < 1 || i > 3 || i2 < 1 || i2 > 19 || i3 < 1 || i3 > 19) {
            return false;
        }
        if (badiDivision instanceof BadiMonth) {
            return i4 >= 1 && i4 <= 19;
        }
        if (badiDivision != BadiIntercalaryDays.AYYAM_I_HA || i4 < 1) {
            return false;
        }
        return i4 <= (isLeapYear(i, i2, i3) ? 5 : 4);
    }

    public GeneralTimestamp<BadiCalendar> at(PlainTime plainTime) {
        return GeneralTimestamp.of(this, plainTime);
    }

    public GeneralTimestamp<BadiCalendar> atTime(int i, int i2) {
        return at(PlainTime.of(i, i2));
    }

    @Override // net.time4j.engine.Calendrical, net.time4j.engine.TimePoint
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BadiCalendar)) {
            return false;
        }
        BadiCalendar badiCalendar = (BadiCalendar) obj;
        return this.major == badiCalendar.major && this.cycle == badiCalendar.cycle && this.year == badiCalendar.year && this.division == badiCalendar.division && this.day == badiCalendar.day;
    }

    @Override // net.time4j.engine.Calendrical, net.time4j.engine.TimePoint
    public int hashCode() {
        return (((this.major * 361) + (this.cycle * 19) + this.year) * 512) + (this.division * 19) + this.day;
    }

    @Override // net.time4j.engine.TimePoint
    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("Bahai-");
        sb.append(this.major);
        sb.append(CoreConstants.DASH_CHAR);
        sb.append(this.cycle);
        sb.append(CoreConstants.DASH_CHAR);
        sb.append(this.year);
        sb.append(CoreConstants.DASH_CHAR);
        int i = this.division;
        if (i == 0) {
            sb.append("Ayyam-i-Ha-");
        } else {
            sb.append(i);
            sb.append(CoreConstants.DASH_CHAR);
        }
        sb.append(this.day);
        return sb.toString();
    }

    @Override // net.time4j.engine.ChronoEntity, net.time4j.engine.ChronoDisplay
    public boolean contains(ChronoElement<?> chronoElement) {
        if (chronoElement == MONTH_OF_YEAR) {
            return hasMonth();
        }
        if (chronoElement == AYYAM_I_HA) {
            return isIntercalaryDay();
        }
        if (getRegisteredElements().contains(chronoElement)) {
            return true;
        }
        return isAccessible(this, chronoElement);
    }

    @Override // net.time4j.engine.ChronoEntity
    public <V> boolean isValid(ChronoElement<V> chronoElement, V v) {
        if (chronoElement == MONTH_OF_YEAR || chronoElement == AYYAM_I_HA || chronoElement == ERA) {
            return v != null;
        }
        return super.isValid(chronoElement, v);
    }

    public static TimeAxis<Unit, BadiCalendar> axis() {
        return ENGINE;
    }

    @Override // net.time4j.engine.TimePoint, net.time4j.engine.ChronoEntity
    public TimeAxis<Unit, BadiCalendar> getChronology() {
        return ENGINE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Weekmodel getDefaultWeekmodel() {
        Weekday weekday = Weekday.SATURDAY;
        return Weekmodel.of(weekday, 1, weekday, Weekday.SUNDAY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRelatedGregorianYear() {
        return getRelatedGregorianYear(this.major, this.cycle, this.year);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BadiCalendar withDayOfYear(int i) {
        int i2;
        int i3;
        int i4;
        int i5 = 19;
        if (i <= 342) {
            int i6 = i - 1;
            i3 = (i6 % 19) + 1;
            i4 = (i6 / 19) + 1;
        } else {
            if (i <= (isLeapYear() ? 5 : 4) + 342) {
                i2 = i - 342;
                i5 = 0;
            } else {
                i2 = (i - (isLeapYear() ? 5 : 4)) - 342;
            }
            i3 = i2;
            i4 = i5;
        }
        return new BadiCalendar(this.major, this.cycle, this.year, i4, i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <V> boolean isAccessible(BadiCalendar badiCalendar, ChronoElement<V> chronoElement) {
        try {
            return badiCalendar.isValid(chronoElement, badiCalendar.get(chronoElement));
        } catch (ChronoException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Locale getLocale(AttributeQuery attributeQuery) {
        return (Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static FormattedContent getFormattedContent(AttributeQuery attributeQuery) {
        return (FormattedContent) attributeQuery.get(TEXT_CONTENT_ATTRIBUTE, FormattedContent.TRANSCRIPTION);
    }

    private Object writeReplace() {
        return new SPX(this, 19);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    public enum Unit implements ChronoUnit {
        VAHID_CYCLES(5.9958192384E8d),
        YEARS(3.155694336E7d),
        MONTHS(1641600.0d),
        WEEKS(604800.0d),
        DAYS(86400.0d);

        private final transient double length;

        @Override // net.time4j.engine.ChronoUnit
        public boolean isCalendrical() {
            return true;
        }

        Unit(double d) {
            this.length = d;
        }

        @Override // net.time4j.engine.ChronoUnit
        public double getLength() {
            return this.length;
        }

        public long between(BadiCalendar badiCalendar, BadiCalendar badiCalendar2) {
            return badiCalendar.until(badiCalendar2, this);
        }
    }

    static class Transformer implements CalendarSystem<BadiCalendar> {
        private static final long EPOCH = PlainDate.of(1844, 3, 21).getDaysSinceEpochUTC();

        private Transformer() {
        }

        @Override // net.time4j.engine.CalendarSystem
        public BadiCalendar transform(long j) {
            if (j < EPOCH) {
                throw new IllegalArgumentException("Not defined before Bahai era: " + j);
            }
            int i = 0;
            if (j >= BadiCalendar.NEWROZ[0]) {
                int length = BadiCalendar.NEWROZ.length;
                while (i <= length - 2) {
                    int i2 = i + 1;
                    if (j < BadiCalendar.NEWROZ[i2]) {
                        int iSafeCast = MathUtils.safeCast((j - ((long) BadiCalendar.NEWROZ[i])) + 1);
                        int i3 = i + 171;
                        int iFloorDivide = MathUtils.floorDivide(i3, 361);
                        return new BadiCalendar(iFloorDivide + 1, MathUtils.floorDivide(((i + 172) - (iFloorDivide * 361)) - 1, 19) + 1, MathUtils.floorModulo(i3, 19) + 1, 1, 1).withDayOfYear(iSafeCast);
                    }
                    i = i2;
                }
                throw new IllegalArgumentException("Out of range: " + j);
            }
            PlainDate plainDateOf = PlainDate.of(j, EpochDays.UTC);
            int year = plainDateOf.getYear();
            int i4 = year - 1843;
            int month = plainDateOf.getMonth();
            if (month <= 2 || (month == 3 && plainDateOf.getDayOfMonth() < 21)) {
                i4 = year - 1844;
            }
            int i5 = i4 - 1;
            BadiCalendar badiCalendar = new BadiCalendar(1, MathUtils.floorDivide(i5, 19) + 1, MathUtils.floorModulo(i5, 19) + 1, 1, 1);
            return badiCalendar.withDayOfYear(MathUtils.safeCast((j - transform(badiCalendar)) + 1));
        }

        @Override // net.time4j.engine.CalendarSystem
        public long transform(BadiCalendar badiCalendar) {
            int relatedGregorianYear = badiCalendar.getRelatedGregorianYear();
            int dayOfYear = badiCalendar.getDayOfYear();
            if (relatedGregorianYear >= 2015) {
                return (BadiCalendar.NEWROZ[relatedGregorianYear - 2015] + dayOfYear) - 1;
            }
            return (PlainDate.of(relatedGregorianYear, 3, 21).getDaysSinceEpochUTC() + ((long) dayOfYear)) - 1;
        }

        @Override // net.time4j.engine.CalendarSystem
        public long getMinimumSinceUTC() {
            return EPOCH;
        }

        @Override // net.time4j.engine.CalendarSystem
        public long getMaximumSinceUTC() {
            return BadiCalendar.NEWROZ[BadiCalendar.NEWROZ.length - 1] - 1;
        }

        @Override // net.time4j.engine.CalendarSystem
        public List<CalendarEra> getEras() {
            return Collections.singletonList(BadiEra.BAHAI);
        }
    }

    static class EraRule implements ElementRule<BadiCalendar, BadiEra> {
        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: isValid, reason: avoid collision after fix types in other method */
        public boolean isValid2(BadiCalendar badiCalendar, BadiEra badiEra) {
            return badiEra != null;
        }

        private EraRule() {
        }

        @Override // net.time4j.engine.ElementRule
        public BadiEra getValue(BadiCalendar badiCalendar) {
            return BadiEra.BAHAI;
        }

        @Override // net.time4j.engine.ElementRule
        public BadiEra getMinimum(BadiCalendar badiCalendar) {
            return BadiEra.BAHAI;
        }

        @Override // net.time4j.engine.ElementRule
        public BadiEra getMaximum(BadiCalendar badiCalendar) {
            return BadiEra.BAHAI;
        }

        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: withValue, reason: avoid collision after fix types in other method */
        public BadiCalendar withValue2(BadiCalendar badiCalendar, BadiEra badiEra, boolean z) {
            if (badiEra != null) {
                return badiCalendar;
            }
            throw new IllegalArgumentException("Missing era value.");
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtFloor(BadiCalendar badiCalendar) {
            return BadiCalendar.YEAR_OF_ERA;
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtCeiling(BadiCalendar badiCalendar) {
            return BadiCalendar.YEAR_OF_ERA;
        }
    }

    static class IntegerRule implements IntElementRule<BadiCalendar> {
        private final int index;

        IntegerRule(int i) {
            this.index = i;
        }

        @Override // net.time4j.engine.IntElementRule
        public int getInt(BadiCalendar badiCalendar) {
            int i = this.index;
            if (i == 0) {
                return badiCalendar.major;
            }
            if (i == 1) {
                return badiCalendar.cycle;
            }
            if (i == 2) {
                return badiCalendar.year;
            }
            if (i == 3) {
                return badiCalendar.day;
            }
            if (i == 4) {
                return badiCalendar.getDayOfYear();
            }
            if (i == 5) {
                return badiCalendar.getYearOfEra();
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        @Override // net.time4j.engine.IntElementRule
        public boolean isValid(BadiCalendar badiCalendar, int i) {
            return 1 <= i && getMax(badiCalendar) >= i;
        }

        @Override // net.time4j.engine.IntElementRule
        public BadiCalendar withValue(BadiCalendar badiCalendar, int i, boolean z) {
            if (isValid(badiCalendar, i)) {
                int i2 = badiCalendar.day;
                int i3 = this.index;
                if (i3 == 0) {
                    return new BadiCalendar(i, badiCalendar.cycle, badiCalendar.year, badiCalendar.division, (i2 == 5 && badiCalendar.isIntercalaryDay() && !BadiCalendar.isLeapYear(i, badiCalendar.cycle, badiCalendar.year)) ? 4 : i2);
                }
                if (i3 == 1) {
                    return new BadiCalendar(badiCalendar.major, i, badiCalendar.year, badiCalendar.division, (i2 == 5 && badiCalendar.isIntercalaryDay() && !BadiCalendar.isLeapYear(badiCalendar.major, i, badiCalendar.year)) ? 4 : i2);
                }
                if (i3 == 2) {
                    return new BadiCalendar(badiCalendar.major, badiCalendar.cycle, i, badiCalendar.division, (i2 == 5 && badiCalendar.isIntercalaryDay() && !BadiCalendar.isLeapYear(badiCalendar.major, badiCalendar.cycle, i)) ? 4 : i2);
                }
                if (i3 == 3) {
                    return new BadiCalendar(badiCalendar.major, badiCalendar.cycle, badiCalendar.year, badiCalendar.division, i);
                }
                if (i3 == 4) {
                    return badiCalendar.withDayOfYear(i);
                }
                if (i3 == 5) {
                    int i4 = i - 1;
                    int iFloorDivide = MathUtils.floorDivide(i4, 361);
                    int i5 = iFloorDivide + 1;
                    int iFloorDivide2 = MathUtils.floorDivide((i - (iFloorDivide * 361)) - 1, 19) + 1;
                    int iFloorModulo = MathUtils.floorModulo(i4, 19) + 1;
                    if (i2 == 5 && badiCalendar.isIntercalaryDay() && !BadiCalendar.isLeapYear(i5, iFloorDivide2, iFloorModulo)) {
                        i2 = 4;
                    }
                    return BadiCalendar.ofComplete(i5, iFloorDivide2, iFloorModulo, badiCalendar.getDivision(), i2);
                }
                throw new UnsupportedOperationException("Unknown element index: " + this.index);
            }
            throw new IllegalArgumentException("Out of range: " + i);
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getValue(BadiCalendar badiCalendar) {
            return Integer.valueOf(getInt(badiCalendar));
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getMinimum(BadiCalendar badiCalendar) {
            return 1;
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getMaximum(BadiCalendar badiCalendar) {
            return Integer.valueOf(getMax(badiCalendar));
        }

        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: isValid, reason: merged with bridge method [inline-methods] */
        public boolean isValid2(BadiCalendar badiCalendar, Integer num) {
            return num != null && isValid(badiCalendar, num.intValue());
        }

        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: withValue, reason: merged with bridge method [inline-methods] */
        public BadiCalendar withValue2(BadiCalendar badiCalendar, Integer num, boolean z) {
            if (num == null) {
                throw new IllegalArgumentException("Missing new value.");
            }
            return withValue(badiCalendar, num.intValue(), z);
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtFloor(BadiCalendar badiCalendar) {
            int i = this.index;
            if (i == 0) {
                return BadiCalendar.VAHID;
            }
            if (i == 1) {
                return BadiCalendar.YEAR_OF_VAHID;
            }
            if (i != 2) {
                if (i == 3 || i == 4) {
                    return null;
                }
                if (i != 5) {
                    throw new UnsupportedOperationException("Unknown element index: " + this.index);
                }
            }
            return BadiCalendar.MONTH_OF_YEAR;
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtCeiling(BadiCalendar badiCalendar) {
            int i = this.index;
            if (i == 0) {
                return BadiCalendar.VAHID;
            }
            if (i == 1) {
                return BadiCalendar.YEAR_OF_VAHID;
            }
            if (i != 2) {
                if (i == 3 || i == 4) {
                    return null;
                }
                if (i != 5) {
                    throw new UnsupportedOperationException("Unknown element index: " + this.index);
                }
            }
            return BadiCalendar.MONTH_OF_YEAR;
        }

        private int getMax(BadiCalendar badiCalendar) {
            int i = this.index;
            if (i == 0) {
                return 3;
            }
            if (i == 1 || i == 2) {
                return 19;
            }
            if (i == 3) {
                if (badiCalendar.isIntercalaryDay()) {
                    return badiCalendar.isLeapYear() ? 5 : 4;
                }
                return 19;
            }
            if (i == 4) {
                return badiCalendar.isLeapYear() ? 366 : 365;
            }
            if (i == 5) {
                return 1083;
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }
    }

    static class MonthRule implements ElementRule<BadiCalendar, BadiMonth> {
        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: isValid, reason: avoid collision after fix types in other method */
        public boolean isValid2(BadiCalendar badiCalendar, BadiMonth badiMonth) {
            return badiMonth != null;
        }

        private MonthRule() {
        }

        @Override // net.time4j.engine.ElementRule
        public BadiMonth getValue(BadiCalendar badiCalendar) {
            return badiCalendar.getMonth();
        }

        @Override // net.time4j.engine.ElementRule
        public BadiMonth getMinimum(BadiCalendar badiCalendar) {
            return BadiMonth.BAHA;
        }

        @Override // net.time4j.engine.ElementRule
        public BadiMonth getMaximum(BadiCalendar badiCalendar) {
            return BadiMonth.ALA;
        }

        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: withValue, reason: avoid collision after fix types in other method */
        public BadiCalendar withValue2(BadiCalendar badiCalendar, BadiMonth badiMonth, boolean z) {
            if (badiMonth == null) {
                throw new IllegalArgumentException("Missing Badi month.");
            }
            return new BadiCalendar(badiCalendar.major, badiCalendar.cycle, badiCalendar.year, badiMonth.getValue(), badiCalendar.isIntercalaryDay() ? 19 : badiCalendar.day);
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtFloor(BadiCalendar badiCalendar) {
            return BadiCalendar.DAY_OF_DIVISION;
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtCeiling(BadiCalendar badiCalendar) {
            return BadiCalendar.DAY_OF_DIVISION;
        }
    }

    static class MonthElement extends StdEnumDateElement<BadiMonth, BadiCalendar> {
        static final MonthElement SINGLETON = new MonthElement();
        private static final long serialVersionUID = -5483090643555757806L;

        @Override // net.time4j.engine.BasicElement
        public boolean isSingleton() {
            return true;
        }

        private MonthElement() {
            super("MONTH_OF_YEAR", BadiCalendar.class, BadiMonth.class, 'M');
        }

        @Override // net.time4j.calendar.service.StdEnumDateElement, net.time4j.format.TextElement
        public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException {
            appendable.append(accessor(attributeQuery).print((BadiMonth) chronoDisplay.get(this)));
        }

        @Override // net.time4j.calendar.service.StdEnumDateElement, net.time4j.format.TextElement
        public BadiMonth parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
            return (BadiMonth) accessor(attributeQuery).parse(charSequence, parsePosition, BadiMonth.class, attributeQuery);
        }

        private TextAccessor accessor(AttributeQuery attributeQuery) {
            return CalendarText.getInstance("bahai", BadiCalendar.getLocale(attributeQuery)).getTextForms("M", BadiMonth.class, BadiCalendar.getFormattedContent(attributeQuery).variant());
        }
    }

    static class DowElement extends StdWeekdayElement<BadiCalendar> {
        static final DowElement SINGLETON = new DowElement();
        private static final long serialVersionUID = -1733732651700208755L;

        @Override // net.time4j.engine.BasicElement
        public boolean isSingleton() {
            return true;
        }

        private DowElement() {
            super(BadiCalendar.class, BadiCalendar.getDefaultWeekmodel());
        }

        @Override // net.time4j.calendar.service.StdEnumDateElement, net.time4j.format.TextElement
        public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException {
            appendable.append(accessor(attributeQuery).print(((Weekday) chronoDisplay.get(this)).roll(2)));
        }

        @Override // net.time4j.calendar.service.StdEnumDateElement, net.time4j.format.TextElement
        public Weekday parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
            return ((Weekday) accessor(attributeQuery).parse(charSequence, parsePosition, Weekday.class, attributeQuery)).roll(-2);
        }

        private TextAccessor accessor(AttributeQuery attributeQuery) {
            return CalendarText.getInstance("bahai", BadiCalendar.getLocale(attributeQuery)).getTextForms("D", Weekday.class, BadiCalendar.getFormattedContent(attributeQuery).variant());
        }
    }

    static class YOV extends DisplayElement<Integer> implements TextElement<Integer> {
        static final YOV SINGLETON = new YOV();
        private static final long serialVersionUID = -8280579801733395557L;

        @Override // net.time4j.engine.BasicElement, net.time4j.engine.ChronoElement
        public char getSymbol() {
            return 'X';
        }

        @Override // net.time4j.engine.ChronoElement
        public boolean isDateElement() {
            return true;
        }

        @Override // net.time4j.engine.BasicElement
        public boolean isSingleton() {
            return true;
        }

        @Override // net.time4j.engine.ChronoElement
        public boolean isTimeElement() {
            return false;
        }

        private YOV() {
            super("YEAR_OF_VAHID");
        }

        @Override // net.time4j.format.TextElement
        public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException, ChronoException {
            appendable.append(accessor(attributeQuery).print(enumAccess().getEnumConstants()[chronoDisplay.getInt(this) - 1]));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // net.time4j.format.TextElement
        public Integer parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
            Enum r3 = accessor(attributeQuery).parse(charSequence, parsePosition, enumAccess(), attributeQuery);
            if (r3 == null) {
                return null;
            }
            return Integer.valueOf(r3.ordinal() + 1);
        }

        @Override // net.time4j.engine.ChronoElement
        public Class<Integer> getType() {
            return Integer.class;
        }

        @Override // net.time4j.engine.ChronoElement
        public Integer getDefaultMinimum() {
            return 1;
        }

        @Override // net.time4j.engine.ChronoElement
        public Integer getDefaultMaximum() {
            return 19;
        }

        private TextAccessor accessor(AttributeQuery attributeQuery) {
            return CalendarText.getInstance("bahai", BadiCalendar.getLocale(attributeQuery)).getTextForms("YOV", enumAccess(), BadiCalendar.getFormattedContent(attributeQuery).variant());
        }

        private static Class<BadiMonth> enumAccess() {
            return BadiMonth.class;
        }
    }

    static class IntercalaryAccess extends BasicElement<BadiIntercalaryDays> implements TextElement<BadiIntercalaryDays>, ElementRule<BadiCalendar, BadiIntercalaryDays> {
        static final IntercalaryAccess SINGLETON = new IntercalaryAccess();
        private static final long serialVersionUID = -772152174221291354L;

        @Override // net.time4j.engine.BasicElement, net.time4j.engine.ChronoElement
        public char getSymbol() {
            return 'A';
        }

        @Override // net.time4j.engine.ChronoElement
        public boolean isDateElement() {
            return true;
        }

        @Override // net.time4j.engine.BasicElement
        public boolean isSingleton() {
            return true;
        }

        @Override // net.time4j.engine.ChronoElement
        public boolean isTimeElement() {
            return false;
        }

        private IntercalaryAccess() {
            super("AYYAM_I_HA");
        }

        @Override // net.time4j.engine.ElementRule
        public BadiIntercalaryDays getValue(BadiCalendar badiCalendar) {
            if (badiCalendar.isIntercalaryDay()) {
                return BadiIntercalaryDays.AYYAM_I_HA;
            }
            throw new ChronoException("The actual calendar date is not an intercalary day: " + badiCalendar);
        }

        @Override // net.time4j.engine.ElementRule
        public BadiIntercalaryDays getMinimum(BadiCalendar badiCalendar) {
            return BadiIntercalaryDays.AYYAM_I_HA;
        }

        @Override // net.time4j.engine.ElementRule
        public BadiIntercalaryDays getMaximum(BadiCalendar badiCalendar) {
            return BadiIntercalaryDays.AYYAM_I_HA;
        }

        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: isValid, reason: avoid collision after fix types in other method */
        public boolean isValid2(BadiCalendar badiCalendar, BadiIntercalaryDays badiIntercalaryDays) {
            return badiIntercalaryDays == BadiIntercalaryDays.AYYAM_I_HA;
        }

        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: withValue, reason: avoid collision after fix types in other method */
        public BadiCalendar withValue2(BadiCalendar badiCalendar, BadiIntercalaryDays badiIntercalaryDays, boolean z) {
            if (badiIntercalaryDays != BadiIntercalaryDays.AYYAM_I_HA) {
                throw new IllegalArgumentException("Expected Ayyam-i-Ha: " + badiIntercalaryDays);
            }
            return new BadiCalendar(badiCalendar.major, badiCalendar.cycle, badiCalendar.year, 0, Math.min(badiCalendar.day, badiCalendar.isLeapYear() ? 5 : 4));
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtFloor(BadiCalendar badiCalendar) {
            return BadiCalendar.DAY_OF_DIVISION;
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtCeiling(BadiCalendar badiCalendar) {
            return BadiCalendar.DAY_OF_DIVISION;
        }

        @Override // net.time4j.format.TextElement
        public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException, ChronoException {
            appendable.append(accessor((Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT), attributeQuery).print((BadiIntercalaryDays) chronoDisplay.get(this)));
        }

        @Override // net.time4j.format.TextElement
        public BadiIntercalaryDays parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
            return (BadiIntercalaryDays) accessor((Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT), attributeQuery).parse(charSequence, parsePosition, getType(), attributeQuery);
        }

        @Override // net.time4j.engine.ChronoElement
        public Class<BadiIntercalaryDays> getType() {
            return BadiIntercalaryDays.class;
        }

        @Override // net.time4j.engine.ChronoElement
        public BadiIntercalaryDays getDefaultMinimum() {
            return BadiIntercalaryDays.AYYAM_I_HA;
        }

        @Override // net.time4j.engine.ChronoElement
        public BadiIntercalaryDays getDefaultMaximum() {
            return BadiIntercalaryDays.AYYAM_I_HA;
        }

        @Override // net.time4j.engine.BasicElement, net.time4j.engine.ChronoElement
        public String getDisplayName(Locale locale) {
            return BadiIntercalaryDays.AYYAM_I_HA.getDisplayName(locale);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0021  */
        private TextAccessor accessor(Locale locale, AttributeQuery attributeQuery) {
            String str;
            FormattedContent formattedContent = (FormattedContent) attributeQuery.get(BadiCalendar.TEXT_CONTENT_ATTRIBUTE, FormattedContent.TRANSCRIPTION);
            CalendarText calendarText = CalendarText.getInstance("bahai", locale);
            if (formattedContent == FormattedContent.MEANING) {
                str = calendarText.getTextForms().containsKey("a") ? "a" : ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
            }
            return calendarText.getTextForms(str, getType(), new String[0]);
        }
    }

    static class WeekdayRule implements ElementRule<BadiCalendar, Weekday> {
        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtCeiling(BadiCalendar badiCalendar) {
            return null;
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtFloor(BadiCalendar badiCalendar) {
            return null;
        }

        private WeekdayRule() {
        }

        @Override // net.time4j.engine.ElementRule
        public Weekday getValue(BadiCalendar badiCalendar) {
            return badiCalendar.getDayOfWeek();
        }

        @Override // net.time4j.engine.ElementRule
        public Weekday getMinimum(BadiCalendar badiCalendar) {
            if (badiCalendar.major == 1 && badiCalendar.cycle == 1 && badiCalendar.year == 1 && badiCalendar.division == 1 && badiCalendar.day <= 2) {
                return Weekday.THURSDAY;
            }
            return Weekday.SATURDAY;
        }

        @Override // net.time4j.engine.ElementRule
        public Weekday getMaximum(BadiCalendar badiCalendar) {
            if (badiCalendar.major == 3 && badiCalendar.cycle == 19 && badiCalendar.year == 19 && badiCalendar.division == 19 && badiCalendar.day >= 14) {
                return Weekday.THURSDAY;
            }
            return Weekday.FRIDAY;
        }

        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: isValid, reason: avoid collision after fix types in other method */
        public boolean isValid2(BadiCalendar badiCalendar, Weekday weekday) {
            if (weekday == null) {
                return false;
            }
            Weekmodel defaultWeekmodel = BadiCalendar.getDefaultWeekmodel();
            int value = weekday.getValue(defaultWeekmodel);
            return getMinimum(badiCalendar).getValue(defaultWeekmodel) <= value && value <= getMaximum(badiCalendar).getValue(defaultWeekmodel);
        }

        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: withValue, reason: avoid collision after fix types in other method */
        public BadiCalendar withValue2(BadiCalendar badiCalendar, Weekday weekday, boolean z) {
            if (weekday != null) {
                Weekmodel defaultWeekmodel = BadiCalendar.getDefaultWeekmodel();
                return badiCalendar.plus(CalendarDays.of(weekday.getValue(defaultWeekmodel) - badiCalendar.getDayOfWeek().getValue(defaultWeekmodel)));
            }
            throw new IllegalArgumentException("Missing weekday.");
        }
    }

    static class Merger implements ChronoMerger<BadiCalendar> {
        @Override // net.time4j.engine.ChronoMerger
        public ChronoDisplay preformat(BadiCalendar badiCalendar, AttributeQuery attributeQuery) {
            return badiCalendar;
        }

        @Override // net.time4j.engine.ChronoMerger
        public Chronology<?> preparser() {
            return null;
        }

        private Merger() {
        }

        @Override // net.time4j.engine.ChronoMerger
        public /* bridge */ /* synthetic */ BadiCalendar createFrom(TimeSource timeSource, AttributeQuery attributeQuery) {
            return createFrom2((TimeSource<?>) timeSource, attributeQuery);
        }

        @Override // net.time4j.engine.ChronoMerger
        public /* bridge */ /* synthetic */ BadiCalendar createFrom(ChronoEntity chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            return createFrom2((ChronoEntity<?>) chronoEntity, attributeQuery, z, z2);
        }

        @Override // net.time4j.engine.ChronoMerger
        /* JADX INFO: renamed from: createFrom, reason: avoid collision after fix types in other method */
        public BadiCalendar createFrom2(TimeSource<?> timeSource, AttributeQuery attributeQuery) {
            TZID id;
            AttributeKey<TZID> attributeKey = Attributes.TIMEZONE_ID;
            if (attributeQuery.contains(attributeKey)) {
                id = (TZID) attributeQuery.get(attributeKey);
            } else {
                if (!((Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART)).isLax()) {
                    return null;
                }
                id = Timezone.ofSystem().getID();
            }
            return (BadiCalendar) Moment.from(timeSource.currentTime()).toGeneralTimestamp(BadiCalendar.ENGINE, id, (StartOfDay) attributeQuery.get(Attributes.START_OF_DAY, getDefaultStartOfDay())).toDate();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // net.time4j.engine.ChronoMerger
        /* JADX INFO: renamed from: createFrom, reason: avoid collision after fix types in other method */
        public BadiCalendar createFrom2(ChronoEntity<?> chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            boolean z3;
            int vahid;
            int kullishai;
            int i;
            int i2;
            int i3 = chronoEntity.getInt(BadiCalendar.KULL_I_SHAI);
            if (i3 == Integer.MIN_VALUE) {
                i3 = 1;
            } else if (i3 < 1 || i3 > 3) {
                chronoEntity.with(ValidationElement.ERROR_MESSAGE, "Major cycle out of range: " + i3);
                return null;
            }
            int i4 = chronoEntity.getInt(BadiCalendar.VAHID);
            int i5 = 0;
            if (i4 == Integer.MIN_VALUE) {
                z3 = false;
            } else {
                if (i4 < 1 || i4 > 19) {
                    chronoEntity.with(ValidationElement.ERROR_MESSAGE, "Vahid cycle out of range: " + i4);
                    return null;
                }
                z3 = true;
            }
            int yearOfVahid = chronoEntity.getInt(BadiCalendar.YEAR_OF_VAHID);
            if (yearOfVahid == Integer.MIN_VALUE) {
                StdCalendarElement<Integer, BadiCalendar> stdCalendarElement = BadiCalendar.YEAR_OF_ERA;
                if (chronoEntity.contains(stdCalendarElement)) {
                    BadiCalendar badiCalendar = (BadiCalendar) ((BadiCalendar) BadiCalendar.axis().getMinimum()).with((ChronoElement<Integer>) stdCalendarElement, chronoEntity.getInt(stdCalendarElement));
                    kullishai = badiCalendar.getKullishai();
                    vahid = badiCalendar.getVahid();
                    yearOfVahid = badiCalendar.getYearOfVahid();
                } else {
                    chronoEntity.with(ValidationElement.ERROR_MESSAGE, "Missing year-of-vahid.");
                    return null;
                }
            } else {
                if (!z3) {
                    chronoEntity.with(ValidationElement.ERROR_MESSAGE, "Missing vahid cycle.");
                    return null;
                }
                if (yearOfVahid < 1 || yearOfVahid > 19) {
                    chronoEntity.with(ValidationElement.ERROR_MESSAGE, "Badi year-of-vahid out of range: " + yearOfVahid);
                    return null;
                }
                vahid = i4;
                kullishai = i3;
            }
            StdCalendarElement<BadiMonth, BadiCalendar> stdCalendarElement2 = BadiCalendar.MONTH_OF_YEAR;
            if (chronoEntity.contains(stdCalendarElement2)) {
                int value = ((BadiMonth) chronoEntity.get(stdCalendarElement2)).getValue();
                int i6 = chronoEntity.getInt(BadiCalendar.DAY_OF_DIVISION);
                if (i6 >= 1 && i6 <= 19) {
                    return new BadiCalendar(kullishai, vahid, yearOfVahid, value, i6);
                }
                chronoEntity.with(ValidationElement.ERROR_MESSAGE, "Invalid Badi date.");
                return null;
            }
            if (chronoEntity.contains(BadiCalendar.AYYAM_I_HA)) {
                int i7 = chronoEntity.getInt(BadiCalendar.DAY_OF_DIVISION);
                if (i7 >= 1) {
                    if (i7 <= (BadiCalendar.isLeapYear(kullishai, vahid, yearOfVahid) ? 5 : 4)) {
                        return new BadiCalendar(kullishai, vahid, yearOfVahid, 0, i7);
                    }
                }
                chronoEntity.with(ValidationElement.ERROR_MESSAGE, "Invalid Badi date.");
                return null;
            }
            int i8 = chronoEntity.getInt(BadiCalendar.DAY_OF_YEAR);
            boolean zIsLeapYear = BadiCalendar.isLeapYear(kullishai, vahid, yearOfVahid);
            if (i8 == Integer.MIN_VALUE) {
                return null;
            }
            if (i8 >= 1) {
                if (i8 <= (zIsLeapYear ? 366 : 365)) {
                    if (i8 <= 342) {
                        int i9 = i8 - 1;
                        i5 = (i9 / 19) + 1;
                        i = (i9 % 19) + 1;
                    } else {
                        if (i8 <= (zIsLeapYear ? 5 : 4) + 342) {
                            i = i8 - 342;
                        } else {
                            i = (i8 - (zIsLeapYear ? 5 : 4)) - 342;
                            i2 = 19;
                        }
                        return new BadiCalendar(kullishai, vahid, yearOfVahid, i2, i);
                    }
                    i2 = i5;
                    return new BadiCalendar(kullishai, vahid, yearOfVahid, i2, i);
                }
            }
            chronoEntity.with(ValidationElement.ERROR_MESSAGE, "Invalid Badi date.");
            return null;
        }

        @Override // net.time4j.engine.ChronoMerger
        public String getFormatPattern(DisplayStyle displayStyle, Locale locale) {
            throw new UnsupportedOperationException("Localized format patterns are not available.");
        }

        @Override // net.time4j.engine.ChronoMerger
        public int getDefaultPivotYear() {
            return PlainDate.axis().getDefaultPivotYear() - 1844;
        }

        @Override // net.time4j.engine.ChronoMerger
        public StartOfDay getDefaultStartOfDay() {
            return StartOfDay.definedBy(BadiCalendar.TEHERAN.sunset());
        }
    }

    static class FUnitRule implements UnitRule<BadiCalendar> {
        private final Unit unit;

        FUnitRule(Unit unit) {
            this.unit = unit;
        }

        @Override // net.time4j.engine.UnitRule
        public BadiCalendar addTo(BadiCalendar badiCalendar, long j) {
            int i = AnonymousClass4.$SwitchMap$net$time4j$calendar$bahai$BadiCalendar$Unit[this.unit.ordinal()];
            if (i == 1) {
                j = MathUtils.safeMultiply(j, 19L);
            } else if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        j = MathUtils.safeMultiply(j, 7L);
                    } else if (i != 5) {
                        throw new UnsupportedOperationException(this.unit.name());
                    }
                    return (BadiCalendar) BadiCalendar.CALSYS.transform(MathUtils.safeAdd(BadiCalendar.CALSYS.transform(badiCalendar), j));
                }
                long jSafeAdd = MathUtils.safeAdd(elapsedMonths(badiCalendar), j);
                int iSafeCast = MathUtils.safeCast(MathUtils.floorDivide(jSafeAdd, 6859));
                int iFloorModulo = MathUtils.floorModulo(jSafeAdd, 6859);
                int iFloorDivide = MathUtils.floorDivide(iFloorModulo, 361);
                int iFloorModulo2 = MathUtils.floorModulo(iFloorModulo, 361);
                return BadiCalendar.ofComplete(iSafeCast + 1, iFloorDivide + 1, MathUtils.floorDivide(iFloorModulo2, 19) + 1, BadiMonth.valueOf(MathUtils.floorModulo(iFloorModulo2, 19) + 1), badiCalendar.isIntercalaryDay() ? 19 : badiCalendar.day);
            }
            long jSafeAdd2 = MathUtils.safeAdd(elapsedYears(badiCalendar), j);
            int iSafeCast2 = MathUtils.safeCast(MathUtils.floorDivide(jSafeAdd2, 361)) + 1;
            int iFloorModulo3 = MathUtils.floorModulo(jSafeAdd2, 361);
            int iFloorDivide2 = MathUtils.floorDivide(iFloorModulo3, 19) + 1;
            int iFloorModulo4 = MathUtils.floorModulo(iFloorModulo3, 19) + 1;
            return BadiCalendar.ofComplete(iSafeCast2, iFloorDivide2, iFloorModulo4, badiCalendar.getDivision(), (badiCalendar.day != 5 || BadiCalendar.isLeapYear(iSafeCast2, iFloorDivide2, iFloorModulo4)) ? badiCalendar.day : 4);
        }

        @Override // net.time4j.engine.UnitRule
        public long between(BadiCalendar badiCalendar, BadiCalendar badiCalendar2) {
            int i = AnonymousClass4.$SwitchMap$net$time4j$calendar$bahai$BadiCalendar$Unit[this.unit.ordinal()];
            if (i == 1) {
                return Unit.YEARS.between(badiCalendar, badiCalendar2) / 19;
            }
            if (i == 2) {
                int iElapsedYears = elapsedYears(badiCalendar2) - elapsedYears(badiCalendar);
                if (iElapsedYears > 0 && badiCalendar2.getDayOfYear() < badiCalendar.getDayOfYear()) {
                    iElapsedYears--;
                } else if (iElapsedYears < 0 && badiCalendar2.getDayOfYear() > badiCalendar.getDayOfYear()) {
                    iElapsedYears++;
                }
                return iElapsedYears;
            }
            if (i != 3) {
                if (i == 4) {
                    return Unit.DAYS.between(badiCalendar, badiCalendar2) / 7;
                }
                if (i == 5) {
                    return BadiCalendar.CALSYS.transform(badiCalendar2) - BadiCalendar.CALSYS.transform(badiCalendar);
                }
                throw new UnsupportedOperationException(this.unit.name());
            }
            long jElapsedMonths = elapsedMonths(badiCalendar2) - elapsedMonths(badiCalendar);
            boolean zIsIntercalaryDay = badiCalendar.isIntercalaryDay();
            int i2 = badiCalendar.day;
            if (zIsIntercalaryDay) {
                i2 += 19;
            }
            boolean zIsIntercalaryDay2 = badiCalendar2.isIntercalaryDay();
            int i3 = badiCalendar2.day;
            if (zIsIntercalaryDay2) {
                i3 += 19;
            }
            if (jElapsedMonths <= 0 || i3 >= i2) {
                return (jElapsedMonths >= 0 || i3 <= i2) ? jElapsedMonths : jElapsedMonths + 1;
            }
            return jElapsedMonths - 1;
        }

        private static int elapsedYears(BadiCalendar badiCalendar) {
            return (((((badiCalendar.major - 1) * 19) + (badiCalendar.cycle - 1)) * 19) + badiCalendar.year) - 1;
        }

        private static int elapsedMonths(BadiCalendar badiCalendar) {
            return ((elapsedYears(badiCalendar) * 19) + (badiCalendar.isIntercalaryDay() ? 18 : badiCalendar.getMonth().getValue())) - 1;
        }
    }

    /* JADX INFO: renamed from: net.time4j.calendar.bahai.BadiCalendar$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$calendar$bahai$BadiCalendar$Unit;

        static {
            int[] iArr = new int[Unit.values().length];
            $SwitchMap$net$time4j$calendar$bahai$BadiCalendar$Unit = iArr;
            try {
                iArr[Unit.VAHID_CYCLES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$time4j$calendar$bahai$BadiCalendar$Unit[Unit.YEARS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$net$time4j$calendar$bahai$BadiCalendar$Unit[Unit.MONTHS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$net$time4j$calendar$bahai$BadiCalendar$Unit[Unit.WEEKS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$net$time4j$calendar$bahai$BadiCalendar$Unit[Unit.DAYS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}
