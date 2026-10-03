package net.time4j.calendar;

import androidx.core.text.util.LocalePreferences;
import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.rolling.helper.DateTokenConverter;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import net.time4j.PlainDate;
import net.time4j.SystemClock;
import net.time4j.Weekday;
import net.time4j.Weekmodel;
import net.time4j.calendar.service.StdIntegerDateElement;
import net.time4j.calendar.service.StdWeekdayElement;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.CalendarEra;
import net.time4j.engine.CalendarSystem;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoExtension;
import net.time4j.engine.ChronoFunction;
import net.time4j.engine.ChronoUnit;
import net.time4j.engine.ElementRule;
import net.time4j.engine.FormattableElement;
import net.time4j.engine.TimeAxis;
import net.time4j.engine.ValidationElement;
import net.time4j.format.CalendarType;
import net.time4j.format.LocalizedPatternSupport;
import net.time4j.format.TextElement;
import net.time4j.tz.OffsetSign;
import net.time4j.tz.ZonalOffset;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes3.dex */
@CalendarType(LocalePreferences.CalendarType.DANGI)
public final class KoreanCalendar extends EastAsianCalendar<Unit, KoreanCalendar> implements LocalizedPatternSupport {
    private static final EastAsianCS<KoreanCalendar> CALSYS;
    public static final ChronoElement<Integer> CYCLE;

    @FormattableElement(format = DateTokenConverter.CONVERTER_KEY)
    public static final StdCalendarElement<Integer, KoreanCalendar> DAY_OF_MONTH;

    @FormattableElement(format = ExifInterface.LONGITUDE_EAST)
    public static final StdCalendarElement<Weekday, KoreanCalendar> DAY_OF_WEEK;

    @FormattableElement(format = "D")
    public static final StdCalendarElement<Integer, KoreanCalendar> DAY_OF_YEAR;
    private static final TimeAxis<Unit, KoreanCalendar> ENGINE;

    @FormattableElement(format = "G")
    public static final ChronoElement<KoreanEra> ERA;
    private static final int[] LEAP_MONTHS;
    public static final StdCalendarElement<Integer, KoreanCalendar> MONTH_AS_ORDINAL;

    @FormattableElement(alt = "L", format = "M")
    public static final TextElement<EastAsianMonth> MONTH_OF_YEAR;
    public static final ChronoElement<SolarTerm> SOLAR_TERM;

    @FormattableElement(format = "F")
    public static final OrdinalWeekdayElement<KoreanCalendar> WEEKDAY_IN_MONTH;
    private static final WeekdayInMonthElement<KoreanCalendar> WIM_ELEMENT;

    @FormattableElement(format = "U")
    public static final TextElement<CyclicYear> YEAR_OF_CYCLE;

    @FormattableElement(format = "y")
    public static final ChronoElement<Integer> YEAR_OF_ERA;
    private static final long serialVersionUID = -4284841131270593971L;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.time4j.engine.ChronoEntity
    public KoreanCalendar getContext() {
        return this;
    }

    static {
        int[] iArr = new int[1000];
        int[] iArr2 = new int[1000];
        ByteBuffer.wrap("\u0000\u0000\u0010¹\u0000\u0000\u0000\u0005\u0000\u0000\u0010¼\u0000\u0000\u0000\u0004\u0000\u0000\u0010¿\u0000\u0000\u0000\u0001\u0000\u0000\u0010Á\u0000\u0000\u0000\u0006\u0000\u0000\u0010Ä\u0000\u0000\u0000\u0005\u0000\u0000\u0010Ç\u0000\u0000\u0000\u0003\u0000\u0000\u0010É\u0000\u0000\u0000\u0007\u0000\u0000\u0010Ì\u0000\u0000\u0000\u0006\u0000\u0000\u0010Ï\u0000\u0000\u0000\u0004\u0000\u0000\u0010Ò\u0000\u0000\u0000\u0002\u0000\u0000\u0010Ô\u0000\u0000\u0000\u0007\u0000\u0000\u0010×\u0000\u0000\u0000\u0005\u0000\u0000\u0010Ú\u0000\u0000\u0000\u0003\u0000\u0000\u0010Ü\u0000\u0000\u0000\b\u0000\u0000\u0010ß\u0000\u0000\u0000\u0006\u0000\u0000\u0010â\u0000\u0000\u0000\u0004\u0000\u0000\u0010å\u0000\u0000\u0000\u0003\u0000\u0000\u0010ç\u0000\u0000\u0000\u0007\u0000\u0000\u0010ê\u0000\u0000\u0000\u0005\u0000\u0000\u0010í\u0000\u0000\u0000\u0003\u0000\u0000\u0010ï\u0000\u0000\u0000\u0007\u0000\u0000\u0010ò\u0000\u0000\u0000\u0006\u0000\u0000\u0010õ\u0000\u0000\u0000\u0004\u0000\u0000\u0010ø\u0000\u0000\u0000\u0003\u0000\u0000\u0010ú\u0000\u0000\u0000\u0007\u0000\u0000\u0010ý\u0000\u0000\u0000\u0005\u0000\u0000\u0011\u0000\u0000\u0000\u0000\u0003\u0000\u0000\u0011\u0002\u0000\u0000\u0000\b\u0000\u0000\u0011\u0005\u0000\u0000\u0000\u0006\u0000\u0000\u0011\b\u0000\u0000\u0000\u0004\u0000\u0000\u0011\u000b\u0000\u0000\u0000\u0002\u0000\u0000\u0011\r\u0000\u0000\u0000\u0007\u0000\u0000\u0011\u0010\u0000\u0000\u0000\u0005\u0000\u0000\u0011\u0013\u0000\u0000\u0000\u0003\u0000\u0000\u0011\u0015\u0000\u0000\u0000\t\u0000\u0000\u0011\u0018\u0000\u0000\u0000\u0006\u0000\u0000\u0011\u001b\u0000\u0000\u0000\u0004\u0000\u0000\u0011\u001e\u0000\u0000\u0000\u0003\u0000\u0000\u0011 \u0000\u0000\u0000\u0007\u0000\u0000\u0011#\u0000\u0000\u0000\u0005\u0000\u0000\u0011&\u0000\u0000\u0000\u0004\u0000\u0000\u0011(\u0000\u0000\u0000\t\u0000\u0000\u0011+\u0000\u0000\u0000\u0006\u0000\u0000\u0011.\u0000\u0000\u0000\u0005\u0000\u0000\u00111\u0000\u0000\u0000\u0002\u0000\u0000\u00113\u0000\u0000\u0000\u0007\u0000\u0000\u00116\u0000\u0000\u0000\u0005\u0000\u0000\u00119\u0000\u0000\u0000\u0003\u0000\u0000\u0011;\u0000\u0000\u0000\n\u0000\u0000\u0011>\u0000\u0000\u0000\u0006\u0000\u0000\u0011A\u0000\u0000\u0000\u0005\u0000\u0000\u0011D\u0000\u0000\u0000\u0003\u0000\u0000\u0011F\u0000\u0000\u0000\u0007\u0000\u0000\u0011I\u0000\u0000\u0000\u0006\u0000\u0000\u0011L\u0000\u0000\u0000\u0004\u0000\u0000\u0011O\u0000\u0000\u0000\u0002\u0000\u0000\u0011Q\u0000\u0000\u0000\u0006\u0000\u0000\u0011T\u0000\u0000\u0000\u0004\u0000\u0000\u0011W\u0000\u0000\u0000\u0003\u0000\u0000\u0011Y\u0000\u0000\u0000\u0006\u0000\u0000\u0011\\\u0000\u0000\u0000\u0005\u0000\u0000\u0011_\u0000\u0000\u0000\u0003\u0000\u0000\u0011b\u0000\u0000\u0000\u0002\u0000\u0000\u0011d\u0000\u0000\u0000\u0006\u0000\u0000\u0011g\u0000\u0000\u0000\u0004\u0000\u0000\u0011j\u0000\u0000\u0000\u0003\u0000\u0000\u0011l\u0000\u0000\u0000\u0007\u0000\u0000\u0011o\u0000\u0000\u0000\u0005\u0000\u0000\u0011r\u0000\u0000\u0000\u0004\u0000\u0000\u0011t\u0000\u0000\u0000\t\u0000\u0000\u0011w\u0000\u0000\u0000\u0006\u0000\u0000\u0011z\u0000\u0000\u0000\u0004\u0000\u0000\u0011}\u0000\u0000\u0000\u0003\u0000\u0000\u0011\u007f\u0000\u0000\u0000\u0007\u0000\u0000\u0011\u0082\u0000\u0000\u0000\u0005\u0000\u0000\u0011\u0085\u0000\u0000\u0000\u0004\u0000\u0000\u0011\u0087\u0000\u0000\u0000\u000b\u0000\u0000\u0011\u008a\u0000\u0000\u0000\u0007\u0000\u0000\u0011\u008d\u0000\u0000\u0000\u0005\u0000\u0000\u0011\u0090\u0000\u0000\u0000\u0003\u0000\u0000\u0011\u0092\u0000\u0000\u0000\b\u0000\u0000\u0011\u0095\u0000\u0000\u0000\u0005\u0000\u0000\u0011\u0098\u0000\u0000\u0000\u0004\u0000\u0000\u0011\u009a\u0000\u0000\u0000\n\u0000\u0000\u0011\u009d\u0000\u0000\u0000\u0006\u0000\u0000\u0011 \u0000\u0000\u0000\u0005\u0000\u0000\u0011£\u0000\u0000\u0000\u0003\u0000\u0000\u0011¥\u0000\u0000\u0000\u0007\u0000\u0000\u0011¨\u0000\u0000\u0000\u0005\u0000\u0000\u0011«\u0000\u0000\u0000\u0004\u0000\u0000\u0011\u00ad\u0000\u0000\u0000\f\u0000\u0000\u0011°\u0000\u0000\u0000\u0006\u0000\u0000\u0011³\u0000\u0000\u0000\u0005\u0000\u0000\u0011¶\u0000\u0000\u0000\u0003\u0000\u0000\u0011¸\u0000\u0000\u0000\b\u0000\u0000\u0011»\u0000\u0000\u0000\u0005\u0000\u0000\u0011¾\u0000\u0000\u0000\u0004\u0000\u0000\u0011Á\u0000\u0000\u0000\u0002\u0000\u0000\u0011Ã\u0000\u0000\u0000\u0006\u0000\u0000\u0011Æ\u0000\u0000\u0000\u0005\u0000\u0000\u0011É\u0000\u0000\u0000\u0002\u0000\u0000\u0011Ë\u0000\u0000\u0000\u0007\u0000\u0000\u0011Î\u0000\u0000\u0000\u0005\u0000\u0000\u0011Ñ\u0000\u0000\u0000\u0004\u0000\u0000\u0011Ô\u0000\u0000\u0000\u0002\u0000\u0000\u0011Ö\u0000\u0000\u0000\u0006\u0000\u0000\u0011Ù\u0000\u0000\u0000\u0005\u0000\u0000\u0011Ü\u0000\u0000\u0000\u0003\u0000\u0000\u0011Þ\u0000\u0000\u0000\u0007\u0000\u0000\u0011á\u0000\u0000\u0000\u0006\u0000\u0000\u0011ä\u0000\u0000\u0000\u0004\u0000\u0000\u0011ç\u0000\u0000\u0000\u0002\u0000\u0000\u0011é\u0000\u0000\u0000\u0007\u0000\u0000\u0011ì\u0000\u0000\u0000\u0005\u0000\u0000\u0011ï\u0000\u0000\u0000\u0003\u0000\u0000\u0011ñ\u0000\u0000\u0000\b\u0000\u0000\u0011ô\u0000\u0000\u0000\u0006\u0000\u0000\u0011÷\u0000\u0000\u0000\u0004\u0000\u0000\u0011ú\u0000\u0000\u0000\u0003\u0000\u0000\u0011ü\u0000\u0000\u0000\u0007\u0000\u0000\u0011ÿ\u0000\u0000\u0000\u0005\u0000\u0000\u0012\u0002\u0000\u0000\u0000\u0004\u0000\u0000\u0012\u0004\u0000\u0000\u0000\b\u0000\u0000\u0012\u0007\u0000\u0000\u0000\u0006\u0000\u0000\u0012\n\u0000\u0000\u0000\u0004\u0000\u0000\u0012\f\u0000\u0000\u0000\n\u0000\u0000\u0012\u000f\u0000\u0000\u0000\u0006\u0000\u0000\u0012\u0012\u0000\u0000\u0000\u0005\u0000\u0000\u0012\u0015\u0000\u0000\u0000\u0003\u0000\u0000\u0012\u0017\u0000\u0000\u0000\b\u0000\u0000\u0012\u001a\u0000\u0000\u0000\u0005\u0000\u0000\u0012\u001d\u0000\u0000\u0000\u0004\u0000\u0000\u0012 \u0000\u0000\u0000\u0002\u0000\u0000\u0012\"\u0000\u0000\u0000\u0007\u0000\u0000\u0012%\u0000\u0000\u0000\u0005\u0000\u0000\u0012(\u0000\u0000\u0000\u0003\u0000\u0000\u0012*\u0000\u0000\u0000\t\u0000\u0000\u0012-\u0000\u0000\u0000\u0005\u0000\u0000\u00120\u0000\u0000\u0000\u0004\u0000\u0000\u00123\u0000\u0000\u0000\u0002\u0000\u0000\u00125\u0000\u0000\u0000\u0006\u0000\u0000\u00128\u0000\u0000\u0000\u0005\u0000\u0000\u0012;\u0000\u0000\u0000\u0003\u0000\u0000\u0012=\u0000\u0000\u0000\u000b\u0000\u0000\u0012@\u0000\u0000\u0000\u0006\u0000\u0000\u0012C\u0000\u0000\u0000\u0005\u0000\u0000\u0012F\u0000\u0000\u0000\u0002\u0000\u0000\u0012H\u0000\u0000\u0000\u0007\u0000\u0000\u0012K\u0000\u0000\u0000\u0005\u0000\u0000\u0012N\u0000\u0000\u0000\u0003\u0000\u0000\u0012P\u0000\u0000\u0000\b\u0000\u0000\u0012S\u0000\u0000\u0000\u0006\u0000\u0000\u0012V\u0000\u0000\u0000\u0004\u0000\u0000\u0012Y\u0000\u0000\u0000\u0003\u0000\u0000\u0012[\u0000\u0000\u0000\u0007\u0000\u0000\u0012^\u0000\u0000\u0000\u0005\u0000\u0000\u0012a\u0000\u0000\u0000\u0004\u0000\u0000\u0012c\u0000\u0000\u0000\b\u0000\u0000\u0012f\u0000\u0000\u0000\u0006\u0000\u0000\u0012i\u0000\u0000\u0000\u0004\u0000\u0000\u0012l\u0000\u0000\u0000\u0003\u0000\u0000\u0012n\u0000\u0000\u0000\u0007\u0000\u0000\u0012q\u0000\u0000\u0000\u0005\u0000\u0000\u0012t\u0000\u0000\u0000\u0004\u0000\u0000\u0012v\u0000\u0000\u0000\b\u0000\u0000\u0012y\u0000\u0000\u0000\u0006\u0000\u0000\u0012|\u0000\u0000\u0000\u0004\u0000\u0000\u0012\u007f\u0000\u0000\u0000\u0003\u0000\u0000\u0012\u0081\u0000\u0000\u0000\u0007\u0000\u0000\u0012\u0084\u0000\u0000\u0000\u0005\u0000\u0000\u0012\u0087\u0000\u0000\u0000\u0004\u0000\u0000\u0012\u0089\u0000\u0000\u0000\t\u0000\u0000\u0012\u008c\u0000\u0000\u0000\u0006\u0000\u0000\u0012\u008f\u0000\u0000\u0000\u0004\u0000\u0000\u0012\u0092\u0000\u0000\u0000\u0003\u0000\u0000\u0012\u0094\u0000\u0000\u0000\u0007\u0000\u0000\u0012\u0097\u0000\u0000\u0000\u0005\u0000\u0000\u0012\u009a\u0000\u0000\u0000\u0004\u0000\u0000\u0012\u009c\u0000\u0000\u0000\t\u0000\u0000\u0012\u009f\u0000\u0000\u0000\u0006\u0000\u0000\u0012¢\u0000\u0000\u0000\u0005\u0000\u0000\u0012¥\u0000\u0000\u0000\u0002\u0000\u0000\u0012§\u0000\u0000\u0000\u0007\u0000\u0000\u0012ª\u0000\u0000\u0000\u0005\u0000\u0000\u0012\u00ad\u0000\u0000\u0000\u0004\u0000\u0000\u0012¯\u0000\u0000\u0000\u000b\u0000\u0000\u0012²\u0000\u0000\u0000\u0006\u0000\u0000\u0012µ\u0000\u0000\u0000\u0005\u0000\u0000\u0012¸\u0000\u0000\u0000\u0003\u0000\u0000\u0012º\u0000\u0000\u0000\u0007\u0000\u0000\u0012½\u0000\u0000\u0000\u0006\u0000\u0000\u0012À\u0000\u0000\u0000\u0004\u0000\u0000\u0012Â\u0000\u0000\u0000\n\u0000\u0000\u0012Å\u0000\u0000\u0000\u0006\u0000\u0000\u0012È\u0000\u0000\u0000\u0004\u0000\u0000\u0012Ë\u0000\u0000\u0000\u0003\u0000\u0000\u0012Í\u0000\u0000\u0000\u0007\u0000\u0000\u0012Ð\u0000\u0000\u0000\u0006\u0000\u0000\u0012Ó\u0000\u0000\u0000\u0004\u0000\u0000\u0012Ö\u0000\u0000\u0000\u0002\u0000\u0000\u0012Ø\u0000\u0000\u0000\u0007\u0000\u0000\u0012Û\u0000\u0000\u0000\u0005\u0000\u0000\u0012Þ\u0000\u0000\u0000\u0003\u0000\u0000\u0012à\u0000\u0000\u0000\u0007\u0000\u0000\u0012ã\u0000\u0000\u0000\u0006\u0000\u0000\u0012æ\u0000\u0000\u0000\u0004\u0000\u0000\u0012è\u0000\u0000\u0000\t\u0000\u0000\u0012ë\u0000\u0000\u0000\u0006\u0000\u0000\u0012î\u0000\u0000\u0000\u0004\u0000\u0000\u0012ñ\u0000\u0000\u0000\u0003\u0000\u0000\u0012ó\u0000\u0000\u0000\u0007\u0000\u0000\u0012ö\u0000\u0000\u0000\u0005\u0000\u0000\u0012ù\u0000\u0000\u0000\u0004\u0000\u0000\u0012û\u0000\u0000\u0000\t\u0000\u0000\u0012þ\u0000\u0000\u0000\u0007\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0005\u0000\u0000\u0013\u0004\u0000\u0000\u0000\u0003\u0000\u0000\u0013\u0006\u0000\u0000\u0000\b\u0000\u0000\u0013\t\u0000\u0000\u0000\u0005\u0000\u0000\u0013\f\u0000\u0000\u0000\u0004\u0000\u0000\u0013\u000e\u0000\u0000\u0000\u000b\u0000\u0000\u0013\u0011\u0000\u0000\u0000\u0006\u0000\u0000\u0013\u0014\u0000\u0000\u0000\u0005\u0000\u0000\u0013\u0017\u0000\u0000\u0000\u0003\u0000\u0000\u0013\u0019\u0000\u0000\u0000\b\u0000\u0000\u0013\u001c\u0000\u0000\u0000\u0006\u0000\u0000\u0013\u001f\u0000\u0000\u0000\u0004\u0000\u0000\u0013\"\u0000\u0000\u0000\u0001\u0000\u0000\u0013$\u0000\u0000\u0000\u0006\u0000\u0000\u0013'\u0000\u0000\u0000\u0005\u0000\u0000\u0013*\u0000\u0000\u0000\u0003\u0000\u0000\u0013,\u0000\u0000\u0000\b\u0000\u0000\u0013/\u0000\u0000\u0000\u0006\u0000\u0000\u00132\u0000\u0000\u0000\u0004\u0000\u0000\u00135\u0000\u0000\u0000\u0002\u0000\u0000\u00137\u0000\u0000\u0000\u0006\u0000\u0000\u0013:\u0000\u0000\u0000\u0005\u0000\u0000\u0013=\u0000\u0000\u0000\u0003\u0000\u0000\u0013?\u0000\u0000\u0000\u0007\u0000\u0000\u0013B\u0000\u0000\u0000\u0006\u0000\u0000\u0013E\u0000\u0000\u0000\u0004\u0000\u0000\u0013H\u0000\u0000\u0000\u0002\u0000\u0000\u0013J\u0000\u0000\u0000\u0006\u0000\u0000\u0013M\u0000\u0000\u0000\u0005\u0000\u0000\u0013P\u0000\u0000\u0000\u0003\u0000\u0000\u0013R\u0000\u0000\u0000\u0007\u0000\u0000\u0013U\u0000\u0000\u0000\u0006\u0000\u0000\u0013X\u0000\u0000\u0000\u0004\u0000\u0000\u0013[\u0000\u0000\u0000\u0002\u0000\u0000\u0013]\u0000\u0000\u0000\u0007\u0000\u0000\u0013`\u0000\u0000\u0000\u0005\u0000\u0000\u0013c\u0000\u0000\u0000\u0003\u0000\u0000\u0013e\u0000\u0000\u0000\b\u0000\u0000\u0013h\u0000\u0000\u0000\u0006\u0000\u0000\u0013k\u0000\u0000\u0000\u0004\u0000\u0000\u0013n\u0000\u0000\u0000\u0003\u0000\u0000\u0013p\u0000\u0000\u0000\u0007\u0000\u0000\u0013s\u0000\u0000\u0000\u0005\u0000\u0000\u0013v\u0000\u0000\u0000\u0004\u0000\u0000\u0013x\u0000\u0000\u0000\b\u0000\u0000\u0013{\u0000\u0000\u0000\u0006\u0000\u0000\u0013~\u0000\u0000\u0000\u0005\u0000\u0000\u0013\u0081\u0000\u0000\u0000\u0002\u0000\u0000\u0013\u0083\u0000\u0000\u0000\u0007\u0000\u0000\u0013\u0086\u0000\u0000\u0000\u0005\u0000\u0000\u0013\u0089\u0000\u0000\u0000\u0004\u0000\u0000\u0013\u008b\u0000\u0000\u0000\b\u0000\u0000\u0013\u008e\u0000\u0000\u0000\u0006\u0000\u0000\u0013\u0091\u0000\u0000\u0000\u0005\u0000\u0000\u0013\u0094\u0000\u0000\u0000\u0002\u0000\u0000\u0013\u0096\u0000\u0000\u0000\u0007\u0000\u0000\u0013\u0099\u0000\u0000\u0000\u0005\u0000\u0000\u0013\u009c\u0000\u0000\u0000\u0004\u0000\u0000\u0013\u009e\u0000\u0000\u0000\n\u0000\u0000\u0013¡\u0000\u0000\u0000\u0006\u0000\u0000\u0013¤\u0000\u0000\u0000\u0004\u0000\u0000\u0013§\u0000\u0000\u0000\u0002\u0000\u0000\u0013©\u0000\u0000\u0000\u0006\u0000\u0000\u0013¬\u0000\u0000\u0000\u0005\u0000\u0000\u0013¯\u0000\u0000\u0000\u0003\u0000\u0000\u0013±\u0000\u0000\u0000\b\u0000\u0000\u0013´\u0000\u0000\u0000\u0006\u0000\u0000\u0013·\u0000\u0000\u0000\u0005\u0000\u0000\u0013º\u0000\u0000\u0000\u0002\u0000\u0000\u0013¼\u0000\u0000\u0000\u0007\u0000\u0000\u0013¿\u0000\u0000\u0000\u0005\u0000\u0000\u0013Â\u0000\u0000\u0000\u0003\u0000\u0000\u0013Ä\u0000\u0000\u0000\b\u0000\u0000\u0013Ç\u0000\u0000\u0000\u0006\u0000\u0000\u0013Ê\u0000\u0000\u0000\u0004\u0000\u0000\u0013Í\u0000\u0000\u0000\u0003\u0000\u0000\u0013Ï\u0000\u0000\u0000\u0007\u0000\u0000\u0013Ò\u0000\u0000\u0000\u0005\u0000\u0000\u0013Õ\u0000\u0000\u0000\u0004\u0000\u0000\u0013×\u0000\u0000\u0000\b\u0000\u0000\u0013Ú\u0000\u0000\u0000\u0006\u0000\u0000\u0013Ý\u0000\u0000\u0000\u0005\u0000\u0000\u0013à\u0000\u0000\u0000\u0003\u0000\u0000\u0013â\u0000\u0000\u0000\b\u0000\u0000\u0013å\u0000\u0000\u0000\u0005\u0000\u0000\u0013è\u0000\u0000\u0000\u0004\u0000\u0000\u0013ê\u0000\u0000\u0000\b\u0000\u0000\u0013í\u0000\u0000\u0000\u0006\u0000\u0000\u0013ð\u0000\u0000\u0000\u0005\u0000\u0000\u0013ó\u0000\u0000\u0000\u0003\u0000\u0000\u0013õ\u0000\u0000\u0000\u0007\u0000\u0000\u0013ø\u0000\u0000\u0000\u0005\u0000\u0000\u0013û\u0000\u0000\u0000\u0004\u0000\u0000\u0013ý\u0000\u0000\u0000\b\u0000\u0000\u0014\u0000\u0000\u0000\u0000\u0006\u0000\u0000\u0014\u0003\u0000\u0000\u0000\u0005\u0000\u0000\u0014\u0006\u0000\u0000\u0000\u0003\u0000\u0000\u0014\b\u0000\u0000\u0000\u0007\u0000\u0000\u0014\u000b\u0000\u0000\u0000\u0005\u0000\u0000\u0014\u000e\u0000\u0000\u0000\u0004\u0000\u0000\u0014\u0010\u0000\u0000\u0000\n\u0000\u0000\u0014\u0013\u0000\u0000\u0000\u0006\u0000\u0000\u0014\u0016\u0000\u0000\u0000\u0005\u0000\u0000\u0014\u0019\u0000\u0000\u0000\u0002\u0000\u0000\u0014\u001b\u0000\u0000\u0000\u0007\u0000\u0000\u0014\u001e\u0000\u0000\u0000\u0005\u0000\u0000\u0014!\u0000\u0000\u0000\u0004\u0000\u0000\u0014$\u0000\u0000\u0000\u0002\u0000\u0000\u0014&\u0000\u0000\u0000\u0006\u0000\u0000\u0014)\u0000\u0000\u0000\u0005\u0000\u0000\u0014,\u0000\u0000\u0000\u0003\u0000\u0000\u0014.\u0000\u0000\u0000\u0007\u0000\u0000\u00141\u0000\u0000\u0000\u0006\u0000\u0000\u00144\u0000\u0000\u0000\u0004\u0000\u0000\u00147\u0000\u0000\u0000\u0001\u0000\u0000\u00149\u0000\u0000\u0000\u0007\u0000\u0000\u0014<\u0000\u0000\u0000\u0005\u0000\u0000\u0014?\u0000\u0000\u0000\u0003\u0000\u0000\u0014A\u0000\u0000\u0000\b\u0000\u0000\u0014D\u0000\u0000\u0000\u0006\u0000\u0000\u0014G\u0000\u0000\u0000\u0004\u0000\u0000\u0014I\u0000\u0000\u0000\b\u0000\u0000\u0014L\u0000\u0000\u0000\u0007\u0000\u0000\u0014O\u0000\u0000\u0000\u0005\u0000\u0000\u0014R\u0000\u0000\u0000\u0004\u0000\u0000\u0014T\u0000\u0000\u0000\b\u0000\u0000\u0014W\u0000\u0000\u0000\u0006\u0000\u0000\u0014Z\u0000\u0000\u0000\u0004\u0000\u0000\u0014\\\u0000\u0000\u0000\b\u0000\u0000\u0014_\u0000\u0000\u0000\u0007\u0000\u0000\u0014b\u0000\u0000\u0000\u0005\u0000\u0000\u0014e\u0000\u0000\u0000\u0003\u0000\u0000\u0014g\u0000\u0000\u0000\u0007\u0000\u0000\u0014j\u0000\u0000\u0000\u0006\u0000\u0000\u0014m\u0000\u0000\u0000\u0004\u0000\u0000\u0014o\u0000\u0000\u0000\n\u0000\u0000\u0014r\u0000\u0000\u0000\u0007\u0000\u0000\u0014u\u0000\u0000\u0000\u0005\u0000\u0000\u0014x\u0000\u0000\u0000\u0003\u0000\u0000\u0014z\u0000\u0000\u0000\b\u0000\u0000\u0014}\u0000\u0000\u0000\u0005\u0000\u0000\u0014\u0080\u0000\u0000\u0000\u0004\u0000\u0000\u0014\u0082\u0000\u0000\u0000\u000b\u0000\u0000\u0014\u0085\u0000\u0000\u0000\u0006\u0000\u0000\u0014\u0088\u0000\u0000\u0000\u0005\u0000\u0000\u0014\u008b\u0000\u0000\u0000\u0003\u0000\u0000\u0014\u008d\u0000\u0000\u0000\b\u0000\u0000\u0014\u0090\u0000\u0000\u0000\u0006\u0000\u0000\u0014\u0093\u0000\u0000\u0000\u0005\u0000\u0000\u0014\u0096\u0000\u0000\u0000\u0001\u0000\u0000\u0014\u0098\u0000\u0000\u0000\u0007\u0000\u0000\u0014\u009b\u0000\u0000\u0000\u0005\u0000\u0000\u0014\u009e\u0000\u0000\u0000\u0003\u0000\u0000\u0014 \u0000\u0000\u0000\b\u0000\u0000\u0014£\u0000\u0000\u0000\u0006\u0000\u0000\u0014¦\u0000\u0000\u0000\u0004\u0000\u0000\u0014©\u0000\u0000\u0000\u0002\u0000\u0000\u0014«\u0000\u0000\u0000\u0007\u0000\u0000\u0014®\u0000\u0000\u0000\u0005\u0000\u0000\u0014±\u0000\u0000\u0000\u0003\u0000\u0000\u0014³\u0000\u0000\u0000\b\u0000\u0000\u0014¶\u0000\u0000\u0000\u0006\u0000\u0000\u0014¹\u0000\u0000\u0000\u0004\u0000\u0000\u0014¼\u0000\u0000\u0000\u0003\u0000\u0000\u0014¾\u0000\u0000\u0000\u0007\u0000\u0000\u0014Á\u0000\u0000\u0000\u0005\u0000\u0000\u0014Ä\u0000\u0000\u0000\u0003\u0000\u0000\u0014Æ\u0000\u0000\u0000\u0007\u0000\u0000\u0014É\u0000\u0000\u0000\u0006\u0000\u0000\u0014Ì\u0000\u0000\u0000\u0004\u0000\u0000\u0014Ï\u0000\u0000\u0000\u0003\u0000\u0000\u0014Ñ\u0000\u0000\u0000\u0007\u0000\u0000\u0014Ô\u0000\u0000\u0000\u0005\u0000\u0000\u0014×\u0000\u0000\u0000\u0003\u0000\u0000\u0014Ù\u0000\u0000\u0000\b\u0000\u0000\u0014Ü\u0000\u0000\u0000\u0006\u0000\u0000\u0014ß\u0000\u0000\u0000\u0004\u0000\u0000\u0014á\u0000\u0000\u0000\n\u0000\u0000\u0014ä\u0000\u0000\u0000\u0007\u0000\u0000\u0014ç\u0000\u0000\u0000\u0005\u0000\u0000\u0014ê\u0000\u0000\u0000\u0004\u0000\u0000\u0014ì\u0000\u0000\u0000\t\u0000\u0000\u0014ï\u0000\u0000\u0000\u0006\u0000\u0000\u0014ò\u0000\u0000\u0000\u0005\u0000\u0000\u0014ô\u0000\u0000\u0000\u000b\u0000\u0000\u0014÷\u0000\u0000\u0000\u0007\u0000\u0000\u0014ú\u0000\u0000\u0000\u0005\u0000\u0000\u0014ý\u0000\u0000\u0000\u0004\u0000\u0000\u0014ÿ\u0000\u0000\u0000\t\u0000\u0000\u0015\u0002\u0000\u0000\u0000\u0006\u0000\u0000\u0015\u0005\u0000\u0000\u0000\u0005\u0000\u0000\u0015\b\u0000\u0000\u0000\u0001\u0000\u0000\u0015\n\u0000\u0000\u0000\u0007\u0000\u0000\u0015\r\u0000\u0000\u0000\u0006\u0000\u0000\u0015\u0010\u0000\u0000\u0000\u0004\u0000\u0000\u0015\u0012\u0000\u0000\u0000\b\u0000\u0000\u0015\u0015\u0000\u0000\u0000\u0006\u0000\u0000\u0015\u0018\u0000\u0000\u0000\u0005\u0000\u0000\u0015\u001b\u0000\u0000\u0000\u0003\u0000\u0000\u0015\u001d\u0000\u0000\u0000\u0007\u0000\u0000\u0015 \u0000\u0000\u0000\u0006\u0000\u0000\u0015#\u0000\u0000\u0000\u0004\u0000\u0000\u0015%\u0000\u0000\u0000\b\u0000\u0000\u0015(\u0000\u0000\u0000\u0006\u0000\u0000\u0015+\u0000\u0000\u0000\u0005\u0000\u0000\u0015.\u0000\u0000\u0000\u0003\u0000\u0000\u00150\u0000\u0000\u0000\u0007\u0000\u0000\u00153\u0000\u0000\u0000\u0006\u0000\u0000\u00156\u0000\u0000\u0000\u0003\u0000\u0000\u00158\u0000\u0000\u0000\b\u0000\u0000\u0015;\u0000\u0000\u0000\u0006\u0000\u0000\u0015>\u0000\u0000\u0000\u0004\u0000\u0000\u0015A\u0000\u0000\u0000\u0003\u0000\u0000\u0015C\u0000\u0000\u0000\u0007\u0000\u0000\u0015F\u0000\u0000\u0000\u0006\u0000\u0000\u0015I\u0000\u0000\u0000\u0004\u0000\u0000\u0015K\u0000\u0000\u0000\t\u0000\u0000\u0015N\u0000\u0000\u0000\u0007\u0000\u0000\u0015Q\u0000\u0000\u0000\u0005\u0000\u0000\u0015T\u0000\u0000\u0000\u0003\u0000\u0000\u0015V\u0000\u0000\u0000\b\u0000\u0000\u0015Y\u0000\u0000\u0000\u0005\u0000\u0000\u0015\\\u0000\u0000\u0000\u0004\u0000\u0000\u0015^\u0000\u0000\u0000\t\u0000\u0000\u0015a\u0000\u0000\u0000\u0006\u0000\u0000\u0015d\u0000\u0000\u0000\u0005\u0000\u0000\u0015g\u0000\u0000\u0000\u0003\u0000\u0000\u0015i\u0000\u0000\u0000\b\u0000\u0000\u0015l\u0000\u0000\u0000\u0006\u0000\u0000\u0015o\u0000\u0000\u0000\u0004\u0000\u0000\u0015q\u0000\u0000\u0000\t\u0000\u0000\u0015t\u0000\u0000\u0000\u0006\u0000\u0000\u0015w\u0000\u0000\u0000\u0005\u0000\u0000\u0015z\u0000\u0000\u0000\u0003\u0000\u0000\u0015|\u0000\u0000\u0000\u0007\u0000\u0000\u0015\u007f\u0000\u0000\u0000\u0006\u0000\u0000\u0015\u0082\u0000\u0000\u0000\u0004\u0000\u0000\u0015\u0084\u0000\u0000\u0000\n\u0000\u0000\u0015\u0087\u0000\u0000\u0000\u0006\u0000\u0000\u0015\u008a\u0000\u0000\u0000\u0005\u0000\u0000\u0015\u008d\u0000\u0000\u0000\u0003\u0000\u0000\u0015\u008f\u0000\u0000\u0000\u0007\u0000\u0000\u0015\u0092\u0000\u0000\u0000\u0006\u0000\u0000\u0015\u0095\u0000\u0000\u0000\u0004\u0000\u0000\u0015\u0097\u0000\u0000\u0000\n\u0000\u0000\u0015\u009a\u0000\u0000\u0000\u0006\u0000\u0000\u0015\u009d\u0000\u0000\u0000\u0005\u0000\u0000\u0015 \u0000\u0000\u0000\u0003\u0000\u0000\u0015¢\u0000\u0000\u0000\u0007\u0000\u0000\u0015¥\u0000\u0000\u0000\u0006\u0000\u0000\u0015¨\u0000\u0000\u0000\u0004\u0000\u0000\u0015ª\u0000\u0000\u0000\u000b\u0000\u0000\u0015\u00ad\u0000\u0000\u0000\u0007\u0000\u0000\u0015°\u0000\u0000\u0000\u0005\u0000\u0000\u0015³\u0000\u0000\u0000\u0003\u0000\u0000\u0015µ\u0000\u0000\u0000\b\u0000\u0000\u0015¸\u0000\u0000\u0000\u0006\u0000\u0000\u0015»\u0000\u0000\u0000\u0004\u0000\u0000\u0015½\u0000\u0000\u0000\t\u0000\u0000\u0015À\u0000\u0000\u0000\u0007\u0000\u0000\u0015Ã\u0000\u0000\u0000\u0005\u0000\u0000\u0015Æ\u0000\u0000\u0000\u0004\u0000\u0000\u0015È\u0000\u0000\u0000\b\u0000\u0000\u0015Ë\u0000\u0000\u0000\u0006\u0000\u0000\u0015Î\u0000\u0000\u0000\u0004\u0000\u0000\u0015Ð\u0000\u0000\u0000\u000b\u0000\u0000\u0015Ó\u0000\u0000\u0000\u0007\u0000\u0000\u0015Ö\u0000\u0000\u0000\u0005\u0000\u0000\u0015Ù\u0000\u0000\u0000\u0004\u0000\u0000\u0015Û\u0000\u0000\u0000\b\u0000\u0000\u0015Þ\u0000\u0000\u0000\u0006\u0000\u0000\u0015á\u0000\u0000\u0000\u0005\u0000\u0000\u0015ã\u0000\u0000\u0000\n\u0000\u0000\u0015æ\u0000\u0000\u0000\u0007\u0000\u0000\u0015é\u0000\u0000\u0000\u0005\u0000\u0000\u0015ì\u0000\u0000\u0000\u0003\u0000\u0000\u0015î\u0000\u0000\u0000\b\u0000\u0000\u0015ñ\u0000\u0000\u0000\u0006\u0000\u0000\u0015ô\u0000\u0000\u0000\u0004\u0000\u0000\u0015ö\u0000\u0000\u0000\n\u0000\u0000\u0015ù\u0000\u0000\u0000\u0006\u0000\u0000\u0015ü\u0000\u0000\u0000\u0005\u0000\u0000\u0015ÿ\u0000\u0000\u0000\u0004\u0000\u0000\u0016\u0001\u0000\u0000\u0000\t\u0000\u0000\u0016\u0004\u0000\u0000\u0000\u0006".getBytes(CharEncoding.ISO_8859_1)).asIntBuffer().get(iArr2, 0, 1000);
        System.arraycopy(iArr2, 0, iArr, 0, 1000);
        LEAP_MONTHS = iArr;
        KoreanEra koreanEra = KoreanEra.DANGI;
        ChronoElement<KoreanEra> chronoElementEra = koreanEra.era();
        ERA = chronoElementEra;
        StdIntegerDateElement stdIntegerDateElement = new StdIntegerDateElement("CYCLE", KoreanCalendar.class, 72, 94, (char) 0, null, null);
        CYCLE = stdIntegerDateElement;
        ChronoElement<Integer> chronoElementYearOfEra = koreanEra.yearOfEra();
        YEAR_OF_ERA = chronoElementYearOfEra;
        EastAsianCY eastAsianCY = EastAsianCY.SINGLETON;
        YEAR_OF_CYCLE = eastAsianCY;
        EastAsianST eastAsianST = EastAsianST.getInstance();
        SOLAR_TERM = eastAsianST;
        EastAsianME eastAsianME = EastAsianME.SINGLETON_EA;
        MONTH_OF_YEAR = eastAsianME;
        StdIntegerDateElement stdIntegerDateElement2 = new StdIntegerDateElement("MONTH_AS_ORDINAL", KoreanCalendar.class, 1, 12, (char) 0, null, null);
        MONTH_AS_ORDINAL = stdIntegerDateElement2;
        StdIntegerDateElement stdIntegerDateElement3 = new StdIntegerDateElement("DAY_OF_MONTH", KoreanCalendar.class, 1, 30, 'd');
        DAY_OF_MONTH = stdIntegerDateElement3;
        StdIntegerDateElement stdIntegerDateElement4 = new StdIntegerDateElement("DAY_OF_YEAR", KoreanCalendar.class, 1, 355, 'D');
        DAY_OF_YEAR = stdIntegerDateElement4;
        StdWeekdayElement stdWeekdayElement = new StdWeekdayElement(KoreanCalendar.class, getDefaultWeekmodel());
        DAY_OF_WEEK = stdWeekdayElement;
        WeekdayInMonthElement<KoreanCalendar> weekdayInMonthElement = new WeekdayInMonthElement<>(KoreanCalendar.class, stdIntegerDateElement3, stdWeekdayElement);
        WIM_ELEMENT = weekdayInMonthElement;
        WEEKDAY_IN_MONTH = weekdayInMonthElement;
        Transformer transformer = new Transformer();
        CALSYS = transformer;
        TimeAxis.Builder builderAppendElement = TimeAxis.Builder.setUp(Unit.class, KoreanCalendar.class, new Merger(), transformer).appendElement((ChronoElement) chronoElementEra, (ElementRule) new EraRule()).appendElement((ChronoElement) stdIntegerDateElement, EastAsianCalendar.getCycleRule(eastAsianCY));
        YearOfEraRule yearOfEraRule = new YearOfEraRule();
        Unit unit = Unit.YEARS;
        TimeAxis.Builder builderAppendElement2 = builderAppendElement.appendElement(chronoElementYearOfEra, yearOfEraRule, unit).appendElement(eastAsianCY, EastAsianCalendar.getYearOfCycleRule(eastAsianME), unit).appendElement((ChronoElement) eastAsianST, (ElementRule) EastAsianST.getInstance());
        ElementRule monthOfYearRule = EastAsianCalendar.getMonthOfYearRule(stdIntegerDateElement3);
        Unit unit2 = Unit.MONTHS;
        TimeAxis.Builder builderAppendElement3 = builderAppendElement2.appendElement(eastAsianME, monthOfYearRule, unit2).appendElement(stdIntegerDateElement2, EastAsianCalendar.getMonthAsOrdinalRule(stdIntegerDateElement3), unit2);
        ElementRule dayOfMonthRule = EastAsianCalendar.getDayOfMonthRule();
        Unit unit3 = Unit.DAYS;
        TimeAxis.Builder builderAppendElement4 = builderAppendElement3.appendElement(stdIntegerDateElement3, dayOfMonthRule, unit3).appendElement(stdIntegerDateElement4, EastAsianCalendar.getDayOfYearRule(), unit3).appendElement(stdWeekdayElement, new WeekdayRule(getDefaultWeekmodel(), new ChronoFunction<KoreanCalendar, CalendarSystem<KoreanCalendar>>() { // from class: net.time4j.calendar.KoreanCalendar.1
            @Override // net.time4j.engine.ChronoFunction
            public CalendarSystem<KoreanCalendar> apply(KoreanCalendar koreanCalendar) {
                return KoreanCalendar.CALSYS;
            }
        }), unit3).appendElement((ChronoElement) weekdayInMonthElement, WeekdayInMonthElement.getRule(weekdayInMonthElement)).appendElement((ChronoElement) CommonElements.RELATED_GREGORIAN_YEAR, (ElementRule) new RelatedGregorianYearRule(transformer, stdIntegerDateElement4));
        Unit unit4 = Unit.CYCLES;
        TimeAxis.Builder builderAppendUnit = builderAppendElement4.appendUnit(unit4, EastAsianCalendar.getUnitRule(0), unit4.getLength(), Collections.singleton(unit)).appendUnit(unit, EastAsianCalendar.getUnitRule(1), unit.getLength(), Collections.singleton(unit4)).appendUnit(unit2, EastAsianCalendar.getUnitRule(2), unit2.getLength(), Collections.emptySet());
        Unit unit5 = Unit.WEEKS;
        ENGINE = builderAppendUnit.appendUnit(unit5, EastAsianCalendar.getUnitRule(3), unit5.getLength(), Collections.singleton(unit3)).appendUnit(unit3, EastAsianCalendar.getUnitRule(4), unit3.getLength(), Collections.singleton(unit5)).appendExtension((ChronoExtension) new CommonElements.Weekengine(KoreanCalendar.class, stdIntegerDateElement3, stdIntegerDateElement4, getDefaultWeekmodel())).build();
    }

    private KoreanCalendar(int i, int i2, EastAsianMonth eastAsianMonth, int i3, long j) {
        super(i, i2, eastAsianMonth, i3, j);
    }

    public static KoreanCalendar ofNewYear(int i) {
        return of(EastAsianYear.forGregorian(i), EastAsianMonth.valueOf(1), 1);
    }

    public static KoreanCalendar of(EastAsianYear eastAsianYear, EastAsianMonth eastAsianMonth, int i) {
        return of(eastAsianYear.getCycle(), eastAsianYear.getYearOfCycle().getNumber(), eastAsianMonth, i);
    }

    public static KoreanCalendar nowInSystemTime() {
        return (KoreanCalendar) SystemClock.inLocalView().now(axis());
    }

    public static boolean isValid(EastAsianYear eastAsianYear, EastAsianMonth eastAsianMonth, int i) {
        return CALSYS.isValid(eastAsianYear.getCycle(), eastAsianYear.getYearOfCycle().getNumber(), eastAsianMonth, i);
    }

    public static Weekmodel getDefaultWeekmodel() {
        return Weekmodel.of(new Locale("ko", "KR"));
    }

    public static TimeAxis<Unit, KoreanCalendar> axis() {
        return ENGINE;
    }

    @Override // net.time4j.engine.TimePoint, net.time4j.engine.ChronoEntity
    public TimeAxis<Unit, KoreanCalendar> getChronology() {
        return ENGINE;
    }

    @Override // net.time4j.calendar.EastAsianCalendar
    EastAsianCS<KoreanCalendar> getCalendarSystem() {
        return CALSYS;
    }

    static KoreanCalendar of(int i, int i2, EastAsianMonth eastAsianMonth, int i3) {
        return new KoreanCalendar(i, i2, eastAsianMonth, i3, CALSYS.transform(i, i2, eastAsianMonth, i3));
    }

    private Object writeReplace() {
        return new SPX(this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    public enum Unit implements ChronoUnit {
        CYCLES(1.893415507776E9d),
        YEARS(3.15569251296E7d),
        MONTHS(2551442.8775903997d),
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

        public int between(KoreanCalendar koreanCalendar, KoreanCalendar koreanCalendar2) {
            return (int) koreanCalendar.until(koreanCalendar2, this);
        }
    }

    static class Transformer extends EastAsianCS<KoreanCalendar> {
        private static final long DATE_1908_04_01;
        private static final long DATE_1912_01_01;
        private static final long DATE_1954_03_21;
        private static final long DATE_1961_08_10;
        private static final List<ZonalOffset> OFFSETS;

        private Transformer() {
        }

        static {
            ArrayList arrayList = new ArrayList(5);
            OffsetSign offsetSign = OffsetSign.AHEAD_OF_UTC;
            arrayList.add(ZonalOffset.atLongitude(offsetSign, WebSocketProtocol.PAYLOAD_SHORT, 58, 0.0d));
            arrayList.add(ZonalOffset.ofHoursMinutes(offsetSign, 8, 30));
            arrayList.add(ZonalOffset.ofHoursMinutes(offsetSign, 9, 0));
            arrayList.add(ZonalOffset.ofHoursMinutes(offsetSign, 8, 30));
            arrayList.add(ZonalOffset.ofHoursMinutes(offsetSign, 9, 0));
            OFFSETS = Collections.unmodifiableList(arrayList);
            DATE_1908_04_01 = PlainDate.of(1908, 4, 1).getDaysSinceEpochUTC();
            DATE_1912_01_01 = PlainDate.of(1912, 1, 1).getDaysSinceEpochUTC();
            DATE_1954_03_21 = PlainDate.of(1954, 3, 21).getDaysSinceEpochUTC();
            DATE_1961_08_10 = PlainDate.of(1961, 8, 10).getDaysSinceEpochUTC();
        }

        @Override // net.time4j.engine.CalendarSystem
        public List<CalendarEra> getEras() {
            return Collections.singletonList(KoreanEra.DANGI);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // net.time4j.calendar.EastAsianCS
        public KoreanCalendar create(int i, int i2, EastAsianMonth eastAsianMonth, int i3, long j) {
            return new KoreanCalendar(i, i2, eastAsianMonth, i3, j);
        }

        @Override // net.time4j.calendar.EastAsianCS
        ZonalOffset getOffset(long j) {
            if (j < DATE_1908_04_01) {
                return OFFSETS.get(0);
            }
            if (j < DATE_1912_01_01) {
                return OFFSETS.get(1);
            }
            if (j < DATE_1954_03_21) {
                return OFFSETS.get(2);
            }
            if (j < DATE_1961_08_10) {
                return OFFSETS.get(3);
            }
            return OFFSETS.get(4);
        }

        @Override // net.time4j.calendar.EastAsianCS
        int[] getLeapMonths() {
            return KoreanCalendar.LEAP_MONTHS;
        }
    }

    static class EraRule implements ElementRule<KoreanCalendar, KoreanEra> {
        private EraRule() {
        }

        @Override // net.time4j.engine.ElementRule
        public KoreanEra getValue(KoreanCalendar koreanCalendar) {
            return KoreanEra.DANGI;
        }

        @Override // net.time4j.engine.ElementRule
        public KoreanEra getMinimum(KoreanCalendar koreanCalendar) {
            return KoreanEra.DANGI;
        }

        @Override // net.time4j.engine.ElementRule
        public KoreanEra getMaximum(KoreanCalendar koreanCalendar) {
            return KoreanEra.DANGI;
        }

        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: isValid, reason: avoid collision after fix types in other method */
        public boolean isValid2(KoreanCalendar koreanCalendar, KoreanEra koreanEra) {
            return koreanEra == KoreanEra.DANGI;
        }

        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: withValue, reason: avoid collision after fix types in other method */
        public KoreanCalendar withValue2(KoreanCalendar koreanCalendar, KoreanEra koreanEra, boolean z) {
            if (isValid2(koreanCalendar, koreanEra)) {
                return koreanCalendar;
            }
            throw new IllegalArgumentException("Invalid Korean era: " + koreanEra);
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtFloor(KoreanCalendar koreanCalendar) {
            throw new AbstractMethodError("Never called.");
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtCeiling(KoreanCalendar koreanCalendar) {
            throw new AbstractMethodError("Never called.");
        }
    }

    static class YearOfEraRule implements ElementRule<KoreanCalendar, Integer> {
        private YearOfEraRule() {
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getValue(KoreanCalendar koreanCalendar) {
            return Integer.valueOf(getInt(koreanCalendar));
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getMinimum(KoreanCalendar koreanCalendar) {
            return 3978;
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getMaximum(KoreanCalendar koreanCalendar) {
            return 5332;
        }

        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: isValid, reason: avoid collision after fix types in other method */
        public boolean isValid2(KoreanCalendar koreanCalendar, Integer num) {
            if (num == null) {
                return false;
            }
            return num.intValue() >= getMinimum(koreanCalendar).intValue() && num.intValue() <= getMaximum(koreanCalendar).intValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: withValue, reason: avoid collision after fix types in other method */
        public KoreanCalendar withValue2(KoreanCalendar koreanCalendar, Integer num, boolean z) {
            if (num == null) {
                throw new IllegalArgumentException("Missing year of era.");
            }
            if (isValid2(koreanCalendar, num)) {
                return (KoreanCalendar) koreanCalendar.plus(num.intValue() - getInt(koreanCalendar), Unit.YEARS);
            }
            throw new IllegalArgumentException("Invalid year of era: " + num);
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtFloor(KoreanCalendar koreanCalendar) {
            throw new AbstractMethodError("Never called.");
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtCeiling(KoreanCalendar koreanCalendar) {
            throw new AbstractMethodError("Never called.");
        }

        private int getInt(KoreanCalendar koreanCalendar) {
            return ((koreanCalendar.getCycle() * 60) + koreanCalendar.getYear().getNumber()) - 364;
        }
    }

    static class Merger extends AbstractMergerEA<KoreanCalendar> {
        @Override // net.time4j.calendar.AbstractMergerEA, net.time4j.engine.ChronoMerger
        public /* bridge */ /* synthetic */ Object createFrom(ChronoEntity chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            return createFrom((ChronoEntity<?>) chronoEntity, attributeQuery, z, z2);
        }

        @Override // net.time4j.calendar.AbstractMergerEA, net.time4j.engine.ChronoMerger
        public /* bridge */ /* synthetic */ EastAsianCalendar createFrom(ChronoEntity chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            return createFrom((ChronoEntity<?>) chronoEntity, attributeQuery, z, z2);
        }

        Merger() {
            super(KoreanCalendar.class);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0036  */
        /* JADX WARN: Code duplicated, block: B:12:0x003b  */
        /* JADX WARN: Code duplicated, block: B:9:0x002a  */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // net.time4j.calendar.AbstractMergerEA, net.time4j.engine.ChronoMerger
        public KoreanCalendar createFrom(ChronoEntity<?> chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            EastAsianYear eastAsianYearForGregorian;
            int i;
            int i2 = chronoEntity.getInt(CommonElements.RELATED_GREGORIAN_YEAR);
            if (i2 == Integer.MIN_VALUE) {
                TextElement<CyclicYear> textElement = KoreanCalendar.YEAR_OF_CYCLE;
                if (chronoEntity.contains(textElement)) {
                    ChronoElement<Integer> chronoElement = KoreanCalendar.CYCLE;
                    if (chronoEntity.contains(chronoElement)) {
                        eastAsianYearForGregorian = ((CyclicYear) chronoEntity.get(textElement)).inCycle(chronoEntity.getInt(chronoElement));
                    } else {
                        i = chronoEntity.getInt(KoreanEra.DANGI.yearOfEra());
                        if (i != Integer.MIN_VALUE) {
                            eastAsianYearForGregorian = EastAsianYear.forDangi(i);
                        } else {
                            eastAsianYearForGregorian = null;
                        }
                    }
                } else {
                    i = chronoEntity.getInt(KoreanEra.DANGI.yearOfEra());
                    if (i != Integer.MIN_VALUE) {
                        eastAsianYearForGregorian = EastAsianYear.forDangi(i);
                    } else {
                        eastAsianYearForGregorian = null;
                    }
                }
            } else {
                eastAsianYearForGregorian = EastAsianYear.forGregorian(i2);
            }
            if (eastAsianYearForGregorian == null) {
                chronoEntity.with(ValidationElement.ERROR_MESSAGE, "Cannot determine East Asian year.");
                return null;
            }
            TextElement<EastAsianMonth> textElement2 = KoreanCalendar.MONTH_OF_YEAR;
            if (chronoEntity.contains(textElement2)) {
                EastAsianMonth eastAsianMonth = (EastAsianMonth) chronoEntity.get(textElement2);
                int i3 = chronoEntity.getInt(KoreanCalendar.DAY_OF_MONTH);
                if (i3 != Integer.MIN_VALUE) {
                    return KoreanCalendar.of(eastAsianYearForGregorian, eastAsianMonth, i3);
                }
            } else {
                int i4 = chronoEntity.getInt(KoreanCalendar.DAY_OF_YEAR);
                if (i4 != Integer.MIN_VALUE && i4 >= 1) {
                    return (KoreanCalendar) KoreanCalendar.of(eastAsianYearForGregorian, EastAsianMonth.valueOf(1), 1).plus(i4 - 1, Unit.DAYS);
                }
            }
            return null;
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    static class SPX implements Externalizable {
        private static final int KOREAN = 15;
        private static final long serialVersionUID = 1;
        private transient Object obj;

        public SPX() {
        }

        SPX(Object obj) {
            this.obj = obj;
        }

        @Override // java.io.Externalizable
        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeByte(15);
            writeKorean(objectOutput);
        }

        @Override // java.io.Externalizable
        public void readExternal(ObjectInput objectInput) throws IOException {
            if (objectInput.readByte() == 15) {
                this.obj = readKorean(objectInput);
                return;
            }
            throw new InvalidObjectException("Unknown calendar type.");
        }

        private Object readResolve() throws ObjectStreamException {
            return this.obj;
        }

        private void writeKorean(ObjectOutput objectOutput) throws IOException {
            EastAsianCalendar eastAsianCalendar = (EastAsianCalendar) this.obj;
            objectOutput.writeByte(eastAsianCalendar.getCycle());
            objectOutput.writeByte(eastAsianCalendar.getYear().getNumber());
            objectOutput.writeByte(eastAsianCalendar.getMonth().getNumber());
            objectOutput.writeBoolean(eastAsianCalendar.getMonth().isLeap());
            objectOutput.writeByte(eastAsianCalendar.getDayOfMonth());
        }

        private KoreanCalendar readKorean(ObjectInput objectInput) throws IOException {
            byte b = objectInput.readByte();
            byte b2 = objectInput.readByte();
            byte b3 = objectInput.readByte();
            boolean z = objectInput.readBoolean();
            byte b4 = objectInput.readByte();
            EastAsianMonth eastAsianMonthValueOf = EastAsianMonth.valueOf(b3);
            if (z) {
                eastAsianMonthValueOf = eastAsianMonthValueOf.withLeap();
            }
            return KoreanCalendar.of(b, b2, eastAsianMonthValueOf, b4);
        }
    }
}
