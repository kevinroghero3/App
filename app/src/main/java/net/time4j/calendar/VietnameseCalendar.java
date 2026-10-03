package net.time4j.calendar;

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
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes6.dex */
@CalendarType("vietnam")
public final class VietnameseCalendar extends EastAsianCalendar<Unit, VietnameseCalendar> implements LocalizedPatternSupport {
    private static final EastAsianCS<VietnameseCalendar> CALSYS;
    public static final ChronoElement<Integer> CYCLE;

    @FormattableElement(format = DateTokenConverter.CONVERTER_KEY)
    public static final StdCalendarElement<Integer, VietnameseCalendar> DAY_OF_MONTH;

    @FormattableElement(format = ExifInterface.LONGITUDE_EAST)
    public static final StdCalendarElement<Weekday, VietnameseCalendar> DAY_OF_WEEK;

    @FormattableElement(format = "D")
    public static final StdCalendarElement<Integer, VietnameseCalendar> DAY_OF_YEAR;
    private static final TimeAxis<Unit, VietnameseCalendar> ENGINE;
    private static final int[] LEAP_MONTHS;
    public static final StdCalendarElement<Integer, VietnameseCalendar> MONTH_AS_ORDINAL;

    @FormattableElement(alt = "L", format = "M")
    public static final TextElement<EastAsianMonth> MONTH_OF_YEAR;
    public static final ChronoElement<SolarTerm> SOLAR_TERM;

    @FormattableElement(format = "F")
    public static final OrdinalWeekdayElement<VietnameseCalendar> WEEKDAY_IN_MONTH;
    private static final WeekdayInMonthElement<VietnameseCalendar> WIM_ELEMENT;

    @FormattableElement(format = "U")
    public static final TextElement<CyclicYear> YEAR_OF_CYCLE;
    private static final long serialVersionUID = -3151525803739185874L;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.time4j.engine.ChronoEntity
    public VietnameseCalendar getContext() {
        return this;
    }

    static {
        int[] iArr = new int[876];
        int[] iArr2 = new int[876];
        ByteBuffer.wrap("\u0000\u0000\u0011b\u0000\u0000\u0000\u0002\u0000\u0000\u0011d\u0000\u0000\u0000\u0006\u0000\u0000\u0011g\u0000\u0000\u0000\u0004\u0000\u0000\u0011j\u0000\u0000\u0000\u0003\u0000\u0000\u0011l\u0000\u0000\u0000\u0007\u0000\u0000\u0011o\u0000\u0000\u0000\u0005\u0000\u0000\u0011r\u0000\u0000\u0000\u0004\u0000\u0000\u0011t\u0000\u0000\u0000\t\u0000\u0000\u0011w\u0000\u0000\u0000\u0006\u0000\u0000\u0011z\u0000\u0000\u0000\u0004\u0000\u0000\u0011}\u0000\u0000\u0000\u0003\u0000\u0000\u0011\u007f\u0000\u0000\u0000\u0007\u0000\u0000\u0011\u0082\u0000\u0000\u0000\u0005\u0000\u0000\u0011\u0085\u0000\u0000\u0000\u0004\u0000\u0000\u0011\u0087\u0000\u0000\u0000\b\u0000\u0000\u0011\u008a\u0000\u0000\u0000\u0007\u0000\u0000\u0011\u008d\u0000\u0000\u0000\u0005\u0000\u0000\u0011\u0090\u0000\u0000\u0000\u0003\u0000\u0000\u0011\u0092\u0000\u0000\u0000\b\u0000\u0000\u0011\u0095\u0000\u0000\u0000\u0005\u0000\u0000\u0011\u0098\u0000\u0000\u0000\u0004\u0000\u0000\u0011\u009a\u0000\u0000\u0000\n\u0000\u0000\u0011\u009d\u0000\u0000\u0000\u0006\u0000\u0000\u0011 \u0000\u0000\u0000\u0005\u0000\u0000\u0011£\u0000\u0000\u0000\u0003\u0000\u0000\u0011¥\u0000\u0000\u0000\u0007\u0000\u0000\u0011¨\u0000\u0000\u0000\u0005\u0000\u0000\u0011«\u0000\u0000\u0000\u0004\u0000\u0000\u0011®\u0000\u0000\u0000\u0002\u0000\u0000\u0011°\u0000\u0000\u0000\u0006\u0000\u0000\u0011³\u0000\u0000\u0000\u0005\u0000\u0000\u0011¶\u0000\u0000\u0000\u0003\u0000\u0000\u0011¸\u0000\u0000\u0000\b\u0000\u0000\u0011»\u0000\u0000\u0000\u0005\u0000\u0000\u0011¾\u0000\u0000\u0000\u0004\u0000\u0000\u0011Á\u0000\u0000\u0000\u0002\u0000\u0000\u0011Ã\u0000\u0000\u0000\u0006\u0000\u0000\u0011Æ\u0000\u0000\u0000\u0005\u0000\u0000\u0011É\u0000\u0000\u0000\u0003\u0000\u0000\u0011Ë\u0000\u0000\u0000\u0007\u0000\u0000\u0011Î\u0000\u0000\u0000\u0006\u0000\u0000\u0011Ñ\u0000\u0000\u0000\u0004\u0000\u0000\u0011Ô\u0000\u0000\u0000\u0002\u0000\u0000\u0011Ö\u0000\u0000\u0000\u0006\u0000\u0000\u0011Ù\u0000\u0000\u0000\u0005\u0000\u0000\u0011Ü\u0000\u0000\u0000\u0003\u0000\u0000\u0011Þ\u0000\u0000\u0000\u0007\u0000\u0000\u0011á\u0000\u0000\u0000\u0006\u0000\u0000\u0011ä\u0000\u0000\u0000\u0004\u0000\u0000\u0011ç\u0000\u0000\u0000\u0002\u0000\u0000\u0011é\u0000\u0000\u0000\u0007\u0000\u0000\u0011ì\u0000\u0000\u0000\u0005\u0000\u0000\u0011ï\u0000\u0000\u0000\u0003\u0000\u0000\u0011ñ\u0000\u0000\u0000\b\u0000\u0000\u0011ô\u0000\u0000\u0000\u0006\u0000\u0000\u0011÷\u0000\u0000\u0000\u0004\u0000\u0000\u0011ú\u0000\u0000\u0000\u0003\u0000\u0000\u0011ü\u0000\u0000\u0000\u0007\u0000\u0000\u0011ÿ\u0000\u0000\u0000\u0005\u0000\u0000\u0012\u0002\u0000\u0000\u0000\u0004\u0000\u0000\u0012\u0004\u0000\u0000\u0000\b\u0000\u0000\u0012\u0007\u0000\u0000\u0000\u0006\u0000\u0000\u0012\n\u0000\u0000\u0000\u0004\u0000\u0000\u0012\r\u0000\u0000\u0000\u0002\u0000\u0000\u0012\u000f\u0000\u0000\u0000\u0007\u0000\u0000\u0012\u0012\u0000\u0000\u0000\u0005\u0000\u0000\u0012\u0015\u0000\u0000\u0000\u0003\u0000\u0000\u0012\u0017\u0000\u0000\u0000\b\u0000\u0000\u0012\u001a\u0000\u0000\u0000\u0005\u0000\u0000\u0012\u001d\u0000\u0000\u0000\u0004\u0000\u0000\u0012 \u0000\u0000\u0000\u0002\u0000\u0000\u0012\"\u0000\u0000\u0000\u0007\u0000\u0000\u0012%\u0000\u0000\u0000\u0005\u0000\u0000\u0012(\u0000\u0000\u0000\u0004\u0000\u0000\u0012*\u0000\u0000\u0000\t\u0000\u0000\u0012-\u0000\u0000\u0000\u0006\u0000\u0000\u00120\u0000\u0000\u0000\u0004\u0000\u0000\u00123\u0000\u0000\u0000\u0002\u0000\u0000\u00125\u0000\u0000\u0000\u0006\u0000\u0000\u00128\u0000\u0000\u0000\u0005\u0000\u0000\u0012;\u0000\u0000\u0000\u0003\u0000\u0000\u0012=\u0000\u0000\u0000\u000b\u0000\u0000\u0012@\u0000\u0000\u0000\u0006\u0000\u0000\u0012C\u0000\u0000\u0000\u0005\u0000\u0000\u0012F\u0000\u0000\u0000\u0002\u0000\u0000\u0012H\u0000\u0000\u0000\u0007\u0000\u0000\u0012K\u0000\u0000\u0000\u0005\u0000\u0000\u0012N\u0000\u0000\u0000\u0003\u0000\u0000\u0012P\u0000\u0000\u0000\b\u0000\u0000\u0012S\u0000\u0000\u0000\u0006\u0000\u0000\u0012V\u0000\u0000\u0000\u0004\u0000\u0000\u0012Y\u0000\u0000\u0000\u0003\u0000\u0000\u0012[\u0000\u0000\u0000\u0007\u0000\u0000\u0012^\u0000\u0000\u0000\u0005\u0000\u0000\u0012a\u0000\u0000\u0000\u0004\u0000\u0000\u0012c\u0000\u0000\u0000\b\u0000\u0000\u0012f\u0000\u0000\u0000\u0006\u0000\u0000\u0012i\u0000\u0000\u0000\u0004\u0000\u0000\u0012l\u0000\u0000\u0000\u0003\u0000\u0000\u0012n\u0000\u0000\u0000\u0007\u0000\u0000\u0012q\u0000\u0000\u0000\u0005\u0000\u0000\u0012t\u0000\u0000\u0000\u0004\u0000\u0000\u0012v\u0000\u0000\u0000\b\u0000\u0000\u0012y\u0000\u0000\u0000\u0006\u0000\u0000\u0012|\u0000\u0000\u0000\u0004\u0000\u0000\u0012\u007f\u0000\u0000\u0000\u0002\u0000\u0000\u0012\u0081\u0000\u0000\u0000\u0007\u0000\u0000\u0012\u0084\u0000\u0000\u0000\u0005\u0000\u0000\u0012\u0087\u0000\u0000\u0000\u0004\u0000\u0000\u0012\u0089\u0000\u0000\u0000\t\u0000\u0000\u0012\u008c\u0000\u0000\u0000\u0006\u0000\u0000\u0012\u008f\u0000\u0000\u0000\u0004\u0000\u0000\u0012\u0092\u0000\u0000\u0000\u0003\u0000\u0000\u0012\u0094\u0000\u0000\u0000\u0007\u0000\u0000\u0012\u0097\u0000\u0000\u0000\u0005\u0000\u0000\u0012\u009a\u0000\u0000\u0000\u0004\u0000\u0000\u0012\u009c\u0000\u0000\u0000\u000b\u0000\u0000\u0012\u009f\u0000\u0000\u0000\u0006\u0000\u0000\u0012¢\u0000\u0000\u0000\u0005\u0000\u0000\u0012¥\u0000\u0000\u0000\u0002\u0000\u0000\u0012§\u0000\u0000\u0000\u0007\u0000\u0000\u0012ª\u0000\u0000\u0000\u0005\u0000\u0000\u0012\u00ad\u0000\u0000\u0000\u0004\u0000\u0000\u0012°\u0000\u0000\u0000\u0001\u0000\u0000\u0012²\u0000\u0000\u0000\u0006\u0000\u0000\u0012µ\u0000\u0000\u0000\u0005\u0000\u0000\u0012¸\u0000\u0000\u0000\u0003\u0000\u0000\u0012º\u0000\u0000\u0000\u0007\u0000\u0000\u0012½\u0000\u0000\u0000\u0006\u0000\u0000\u0012À\u0000\u0000\u0000\u0004\u0000\u0000\u0012Â\u0000\u0000\u0000\n\u0000\u0000\u0012Å\u0000\u0000\u0000\u0006\u0000\u0000\u0012È\u0000\u0000\u0000\u0005\u0000\u0000\u0012Ë\u0000\u0000\u0000\u0003\u0000\u0000\u0012Í\u0000\u0000\u0000\u0007\u0000\u0000\u0012Ð\u0000\u0000\u0000\u0006\u0000\u0000\u0012Ó\u0000\u0000\u0000\u0004\u0000\u0000\u0012Ö\u0000\u0000\u0000\u0002\u0000\u0000\u0012Ø\u0000\u0000\u0000\u0006\u0000\u0000\u0012Û\u0000\u0000\u0000\u0005\u0000\u0000\u0012Þ\u0000\u0000\u0000\u0003\u0000\u0000\u0012à\u0000\u0000\u0000\u0007\u0000\u0000\u0012ã\u0000\u0000\u0000\u0006\u0000\u0000\u0012æ\u0000\u0000\u0000\u0004\u0000\u0000\u0012è\u0000\u0000\u0000\t\u0000\u0000\u0012ë\u0000\u0000\u0000\u0006\u0000\u0000\u0012î\u0000\u0000\u0000\u0004\u0000\u0000\u0012ñ\u0000\u0000\u0000\u0003\u0000\u0000\u0012ó\u0000\u0000\u0000\u0007\u0000\u0000\u0012ö\u0000\u0000\u0000\u0005\u0000\u0000\u0012ù\u0000\u0000\u0000\u0004\u0000\u0000\u0012û\u0000\u0000\u0000\u000b\u0000\u0000\u0012þ\u0000\u0000\u0000\u0007\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0005\u0000\u0000\u0013\u0004\u0000\u0000\u0000\u0003\u0000\u0000\u0013\u0006\u0000\u0000\u0000\b\u0000\u0000\u0013\t\u0000\u0000\u0000\u0005\u0000\u0000\u0013\f\u0000\u0000\u0000\u0004\u0000\u0000\u0013\u000e\u0000\u0000\u0000\u000b\u0000\u0000\u0013\u0011\u0000\u0000\u0000\u0006\u0000\u0000\u0013\u0014\u0000\u0000\u0000\u0005\u0000\u0000\u0013\u0017\u0000\u0000\u0000\u0003\u0000\u0000\u0013\u0019\u0000\u0000\u0000\u0007\u0000\u0000\u0013\u001c\u0000\u0000\u0000\u0006\u0000\u0000\u0013\u001f\u0000\u0000\u0000\u0004\u0000\u0000\u0013\"\u0000\u0000\u0000\u0001\u0000\u0000\u0013$\u0000\u0000\u0000\u0006\u0000\u0000\u0013'\u0000\u0000\u0000\u0005\u0000\u0000\u0013*\u0000\u0000\u0000\u0003\u0000\u0000\u0013,\u0000\u0000\u0000\b\u0000\u0000\u0013/\u0000\u0000\u0000\u0006\u0000\u0000\u00132\u0000\u0000\u0000\u0004\u0000\u0000\u00135\u0000\u0000\u0000\u0002\u0000\u0000\u00137\u0000\u0000\u0000\u0006\u0000\u0000\u0013:\u0000\u0000\u0000\u0005\u0000\u0000\u0013=\u0000\u0000\u0000\u0003\u0000\u0000\u0013?\u0000\u0000\u0000\u0007\u0000\u0000\u0013B\u0000\u0000\u0000\u0006\u0000\u0000\u0013E\u0000\u0000\u0000\u0004\u0000\u0000\u0013H\u0000\u0000\u0000\u0002\u0000\u0000\u0013J\u0000\u0000\u0000\u0006\u0000\u0000\u0013M\u0000\u0000\u0000\u0005\u0000\u0000\u0013P\u0000\u0000\u0000\u0003\u0000\u0000\u0013R\u0000\u0000\u0000\u0007\u0000\u0000\u0013U\u0000\u0000\u0000\u0006\u0000\u0000\u0013X\u0000\u0000\u0000\u0004\u0000\u0000\u0013Z\u0000\u0000\u0000\n\u0000\u0000\u0013]\u0000\u0000\u0000\u0007\u0000\u0000\u0013`\u0000\u0000\u0000\u0005\u0000\u0000\u0013c\u0000\u0000\u0000\u0003\u0000\u0000\u0013e\u0000\u0000\u0000\b\u0000\u0000\u0013h\u0000\u0000\u0000\u0006\u0000\u0000\u0013k\u0000\u0000\u0000\u0004\u0000\u0000\u0013n\u0000\u0000\u0000\u0003\u0000\u0000\u0013p\u0000\u0000\u0000\u0007\u0000\u0000\u0013s\u0000\u0000\u0000\u0005\u0000\u0000\u0013v\u0000\u0000\u0000\u0004\u0000\u0000\u0013x\u0000\u0000\u0000\b\u0000\u0000\u0013{\u0000\u0000\u0000\u0006\u0000\u0000\u0013~\u0000\u0000\u0000\u0005\u0000\u0000\u0013\u0081\u0000\u0000\u0000\u0001\u0000\u0000\u0013\u0083\u0000\u0000\u0000\u0007\u0000\u0000\u0013\u0086\u0000\u0000\u0000\u0005\u0000\u0000\u0013\u0089\u0000\u0000\u0000\u0004\u0000\u0000\u0013\u008b\u0000\u0000\u0000\b\u0000\u0000\u0013\u008e\u0000\u0000\u0000\u0006\u0000\u0000\u0013\u0091\u0000\u0000\u0000\u0005\u0000\u0000\u0013\u0094\u0000\u0000\u0000\u0002\u0000\u0000\u0013\u0096\u0000\u0000\u0000\u0007\u0000\u0000\u0013\u0099\u0000\u0000\u0000\u0005\u0000\u0000\u0013\u009c\u0000\u0000\u0000\u0004\u0000\u0000\u0013\u009e\u0000\u0000\u0000\n\u0000\u0000\u0013¡\u0000\u0000\u0000\u0006\u0000\u0000\u0013¤\u0000\u0000\u0000\u0004\u0000\u0000\u0013§\u0000\u0000\u0000\u0002\u0000\u0000\u0013©\u0000\u0000\u0000\u0006\u0000\u0000\u0013¬\u0000\u0000\u0000\u0005\u0000\u0000\u0013¯\u0000\u0000\u0000\u0003\u0000\u0000\u0013±\u0000\u0000\u0000\u0007\u0000\u0000\u0013´\u0000\u0000\u0000\u0006\u0000\u0000\u0013·\u0000\u0000\u0000\u0005\u0000\u0000\u0013º\u0000\u0000\u0000\u0002\u0000\u0000\u0013¼\u0000\u0000\u0000\u0007\u0000\u0000\u0013¿\u0000\u0000\u0000\u0005\u0000\u0000\u0013Â\u0000\u0000\u0000\u0003\u0000\u0000\u0013Ä\u0000\u0000\u0000\b\u0000\u0000\u0013Ç\u0000\u0000\u0000\u0006\u0000\u0000\u0013Ê\u0000\u0000\u0000\u0004\u0000\u0000\u0013Í\u0000\u0000\u0000\u0003\u0000\u0000\u0013Ï\u0000\u0000\u0000\u0007\u0000\u0000\u0013Ò\u0000\u0000\u0000\u0005\u0000\u0000\u0013Õ\u0000\u0000\u0000\u0004\u0000\u0000\u0013×\u0000\u0000\u0000\b\u0000\u0000\u0013Ú\u0000\u0000\u0000\u0007\u0000\u0000\u0013Ý\u0000\u0000\u0000\u0005\u0000\u0000\u0013à\u0000\u0000\u0000\u0003\u0000\u0000\u0013â\u0000\u0000\u0000\b\u0000\u0000\u0013å\u0000\u0000\u0000\u0005\u0000\u0000\u0013è\u0000\u0000\u0000\u0004\u0000\u0000\u0013ê\u0000\u0000\u0000\b\u0000\u0000\u0013í\u0000\u0000\u0000\u0006\u0000\u0000\u0013ð\u0000\u0000\u0000\u0005\u0000\u0000\u0013ó\u0000\u0000\u0000\u0003\u0000\u0000\u0013õ\u0000\u0000\u0000\u0007\u0000\u0000\u0013ø\u0000\u0000\u0000\u0005\u0000\u0000\u0013û\u0000\u0000\u0000\u0004\u0000\u0000\u0013ý\u0000\u0000\u0000\n\u0000\u0000\u0014\u0000\u0000\u0000\u0000\u0006\u0000\u0000\u0014\u0003\u0000\u0000\u0000\u0005\u0000\u0000\u0014\u0006\u0000\u0000\u0000\u0003\u0000\u0000\u0014\b\u0000\u0000\u0000\u0007\u0000\u0000\u0014\u000b\u0000\u0000\u0000\u0005\u0000\u0000\u0014\u000e\u0000\u0000\u0000\u0004\u0000\u0000\u0014\u0010\u0000\u0000\u0000\n\u0000\u0000\u0014\u0013\u0000\u0000\u0000\u0006\u0000\u0000\u0014\u0016\u0000\u0000\u0000\u0005\u0000\u0000\u0014\u0019\u0000\u0000\u0000\u0002\u0000\u0000\u0014\u001b\u0000\u0000\u0000\u0007\u0000\u0000\u0014\u001e\u0000\u0000\u0000\u0006\u0000\u0000\u0014!\u0000\u0000\u0000\u0004\u0000\u0000\u0014$\u0000\u0000\u0000\u0001\u0000\u0000\u0014&\u0000\u0000\u0000\u0006\u0000\u0000\u0014)\u0000\u0000\u0000\u0005\u0000\u0000\u0014,\u0000\u0000\u0000\u0003\u0000\u0000\u0014.\u0000\u0000\u0000\u0007\u0000\u0000\u00141\u0000\u0000\u0000\u0006\u0000\u0000\u00144\u0000\u0000\u0000\u0004\u0000\u0000\u00146\u0000\u0000\u0000\n\u0000\u0000\u00149\u0000\u0000\u0000\u0007\u0000\u0000\u0014<\u0000\u0000\u0000\u0005\u0000\u0000\u0014?\u0000\u0000\u0000\u0003\u0000\u0000\u0014A\u0000\u0000\u0000\u0007\u0000\u0000\u0014D\u0000\u0000\u0000\u0006\u0000\u0000\u0014G\u0000\u0000\u0000\u0004\u0000\u0000\u0014I\u0000\u0000\u0000\b\u0000\u0000\u0014L\u0000\u0000\u0000\u0007\u0000\u0000\u0014O\u0000\u0000\u0000\u0005\u0000\u0000\u0014R\u0000\u0000\u0000\u0003\u0000\u0000\u0014T\u0000\u0000\u0000\u0007\u0000\u0000\u0014W\u0000\u0000\u0000\u0006\u0000\u0000\u0014Z\u0000\u0000\u0000\u0004\u0000\u0000\u0014\\\u0000\u0000\u0000\n\u0000\u0000\u0014_\u0000\u0000\u0000\u0006\u0000\u0000\u0014b\u0000\u0000\u0000\u0005\u0000\u0000\u0014e\u0000\u0000\u0000\u0003\u0000\u0000\u0014g\u0000\u0000\u0000\u0007\u0000\u0000\u0014j\u0000\u0000\u0000\u0005\u0000\u0000\u0014m\u0000\u0000\u0000\u0004\u0000\u0000\u0014o\u0000\u0000\u0000\t\u0000\u0000\u0014r\u0000\u0000\u0000\u0007\u0000\u0000\u0014u\u0000\u0000\u0000\u0005\u0000\u0000\u0014x\u0000\u0000\u0000\u0003\u0000\u0000\u0014z\u0000\u0000\u0000\b\u0000\u0000\u0014}\u0000\u0000\u0000\u0006\u0000\u0000\u0014\u0080\u0000\u0000\u0000\u0004\u0000\u0000\u0014\u0082\u0000\u0000\u0000\u000b\u0000\u0000\u0014\u0085\u0000\u0000\u0000\u0006\u0000\u0000\u0014\u0088\u0000\u0000\u0000\u0005\u0000\u0000\u0014\u008b\u0000\u0000\u0000\u0003\u0000\u0000\u0014\u008d\u0000\u0000\u0000\b\u0000\u0000\u0014\u0090\u0000\u0000\u0000\u0006\u0000\u0000\u0014\u0093\u0000\u0000\u0000\u0005\u0000\u0000\u0014\u0096\u0000\u0000\u0000\u0001\u0000\u0000\u0014\u0098\u0000\u0000\u0000\u0007\u0000\u0000\u0014\u009b\u0000\u0000\u0000\u0005\u0000\u0000\u0014\u009e\u0000\u0000\u0000\u0003\u0000\u0000\u0014 \u0000\u0000\u0000\b\u0000\u0000\u0014£\u0000\u0000\u0000\u0006\u0000\u0000\u0014¦\u0000\u0000\u0000\u0004\u0000\u0000\u0014©\u0000\u0000\u0000\u0002\u0000\u0000\u0014«\u0000\u0000\u0000\u0007\u0000\u0000\u0014®\u0000\u0000\u0000\u0005\u0000\u0000\u0014±\u0000\u0000\u0000\u0003\u0000\u0000\u0014³\u0000\u0000\u0000\u0007\u0000\u0000\u0014¶\u0000\u0000\u0000\u0006\u0000\u0000\u0014¹\u0000\u0000\u0000\u0004\u0000\u0000\u0014¼\u0000\u0000\u0000\u0003\u0000\u0000\u0014¾\u0000\u0000\u0000\u0007\u0000\u0000\u0014Á\u0000\u0000\u0000\u0005\u0000\u0000\u0014Ä\u0000\u0000\u0000\u0003\u0000\u0000\u0014Æ\u0000\u0000\u0000\u0007\u0000\u0000\u0014É\u0000\u0000\u0000\u0006\u0000\u0000\u0014Ì\u0000\u0000\u0000\u0004\u0000\u0000\u0014Ï\u0000\u0000\u0000\u0002\u0000\u0000\u0014Ñ\u0000\u0000\u0000\u0007\u0000\u0000\u0014Ô\u0000\u0000\u0000\u0005\u0000\u0000\u0014×\u0000\u0000\u0000\u0003\u0000\u0000\u0014Ù\u0000\u0000\u0000\b\u0000\u0000\u0014Ü\u0000\u0000\u0000\u0006\u0000\u0000\u0014ß\u0000\u0000\u0000\u0004\u0000\u0000\u0014â\u0000\u0000\u0000\u0003\u0000\u0000\u0014ä\u0000\u0000\u0000\u0007\u0000\u0000\u0014ç\u0000\u0000\u0000\u0005\u0000\u0000\u0014ê\u0000\u0000\u0000\u0004\u0000\u0000\u0014ì\u0000\u0000\u0000\t\u0000\u0000\u0014ï\u0000\u0000\u0000\u0006\u0000\u0000\u0014ò\u0000\u0000\u0000\u0005\u0000\u0000\u0014ô\u0000\u0000\u0000\u000b\u0000\u0000\u0014÷\u0000\u0000\u0000\u0007\u0000\u0000\u0014ú\u0000\u0000\u0000\u0005\u0000\u0000\u0014ý\u0000\u0000\u0000\u0004\u0000\u0000\u0014ÿ\u0000\u0000\u0000\t\u0000\u0000\u0015\u0002\u0000\u0000\u0000\u0006\u0000\u0000\u0015\u0005\u0000\u0000\u0000\u0005\u0000\u0000\u0015\b\u0000\u0000\u0000\u0002\u0000\u0000\u0015\n\u0000\u0000\u0000\u0007\u0000\u0000\u0015\r\u0000\u0000\u0000\u0006\u0000\u0000\u0015\u0010\u0000\u0000\u0000\u0004\u0000\u0000\u0015\u0012\u0000\u0000\u0000\b\u0000\u0000\u0015\u0015\u0000\u0000\u0000\u0006\u0000\u0000\u0015\u0018\u0000\u0000\u0000\u0005\u0000\u0000\u0015\u001b\u0000\u0000\u0000\u0003\u0000\u0000\u0015\u001d\u0000\u0000\u0000\u0007\u0000\u0000\u0015 \u0000\u0000\u0000\u0006\u0000\u0000\u0015#\u0000\u0000\u0000\u0003\u0000\u0000\u0015%\u0000\u0000\u0000\b\u0000\u0000\u0015(\u0000\u0000\u0000\u0006\u0000\u0000\u0015+\u0000\u0000\u0000\u0005\u0000\u0000\u0015.\u0000\u0000\u0000\u0003\u0000\u0000\u00150\u0000\u0000\u0000\u0007\u0000\u0000\u00153\u0000\u0000\u0000\u0006\u0000\u0000\u00156\u0000\u0000\u0000\u0003\u0000\u0000\u00158\u0000\u0000\u0000\b\u0000\u0000\u0015;\u0000\u0000\u0000\u0006\u0000\u0000\u0015>\u0000\u0000\u0000\u0004\u0000\u0000\u0015A\u0000\u0000\u0000\u0003\u0000\u0000\u0015C\u0000\u0000\u0000\u0007\u0000\u0000\u0015F\u0000\u0000\u0000\u0006\u0000\u0000\u0015I\u0000\u0000\u0000\u0004\u0000\u0000\u0015K\u0000\u0000\u0000\t\u0000\u0000\u0015N\u0000\u0000\u0000\u0007\u0000\u0000\u0015Q\u0000\u0000\u0000\u0005\u0000\u0000\u0015T\u0000\u0000\u0000\u0003\u0000\u0000\u0015V\u0000\u0000\u0000\b\u0000\u0000\u0015Y\u0000\u0000\u0000\u0005\u0000\u0000\u0015\\\u0000\u0000\u0000\u0004\u0000\u0000\u0015^\u0000\u0000\u0000\t\u0000\u0000\u0015a\u0000\u0000\u0000\u0006\u0000\u0000\u0015d\u0000\u0000\u0000\u0005\u0000\u0000\u0015g\u0000\u0000\u0000\u0003\u0000\u0000\u0015i\u0000\u0000\u0000\b\u0000\u0000\u0015l\u0000\u0000\u0000\u0006\u0000\u0000\u0015o\u0000\u0000\u0000\u0005\u0000\u0000\u0015q\u0000\u0000\u0000\t\u0000\u0000\u0015t\u0000\u0000\u0000\u0007\u0000\u0000\u0015w\u0000\u0000\u0000\u0005\u0000\u0000\u0015z\u0000\u0000\u0000\u0003\u0000\u0000\u0015|\u0000\u0000\u0000\u0007\u0000\u0000\u0015\u007f\u0000\u0000\u0000\u0006\u0000\u0000\u0015\u0082\u0000\u0000\u0000\u0004\u0000\u0000\u0015\u0084\u0000\u0000\u0000\n\u0000\u0000\u0015\u0087\u0000\u0000\u0000\u0006\u0000\u0000\u0015\u008a\u0000\u0000\u0000\u0005\u0000\u0000\u0015\u008d\u0000\u0000\u0000\u0003\u0000\u0000\u0015\u008f\u0000\u0000\u0000\u0007\u0000\u0000\u0015\u0092\u0000\u0000\u0000\u0006\u0000\u0000\u0015\u0095\u0000\u0000\u0000\u0004\u0000\u0000\u0015\u0097\u0000\u0000\u0000\n\u0000\u0000\u0015\u009a\u0000\u0000\u0000\u0006\u0000\u0000\u0015\u009d\u0000\u0000\u0000\u0005\u0000\u0000\u0015 \u0000\u0000\u0000\u0003\u0000\u0000\u0015¢\u0000\u0000\u0000\u0007\u0000\u0000\u0015¥\u0000\u0000\u0000\u0006\u0000\u0000\u0015¨\u0000\u0000\u0000\u0004\u0000\u0000\u0015ª\u0000\u0000\u0000\u000b\u0000\u0000\u0015\u00ad\u0000\u0000\u0000\u0007\u0000\u0000\u0015°\u0000\u0000\u0000\u0005\u0000\u0000\u0015³\u0000\u0000\u0000\u0003\u0000\u0000\u0015µ\u0000\u0000\u0000\b\u0000\u0000\u0015¸\u0000\u0000\u0000\u0006\u0000\u0000\u0015»\u0000\u0000\u0000\u0004\u0000\u0000\u0015½\u0000\u0000\u0000\t\u0000\u0000\u0015À\u0000\u0000\u0000\u0007\u0000\u0000\u0015Ã\u0000\u0000\u0000\u0005\u0000\u0000\u0015Æ\u0000\u0000\u0000\u0004\u0000\u0000\u0015È\u0000\u0000\u0000\b\u0000\u0000\u0015Ë\u0000\u0000\u0000\u0006\u0000\u0000\u0015Î\u0000\u0000\u0000\u0004\u0000\u0000\u0015Ð\u0000\u0000\u0000\b\u0000\u0000\u0015Ó\u0000\u0000\u0000\u0007\u0000\u0000\u0015Ö\u0000\u0000\u0000\u0005\u0000\u0000\u0015Ù\u0000\u0000\u0000\u0004\u0000\u0000\u0015Û\u0000\u0000\u0000\b\u0000\u0000\u0015Þ\u0000\u0000\u0000\u0006\u0000\u0000\u0015á\u0000\u0000\u0000\u0004\u0000\u0000\u0015ã\u0000\u0000\u0000\n\u0000\u0000\u0015æ\u0000\u0000\u0000\u0007\u0000\u0000\u0015é\u0000\u0000\u0000\u0005\u0000\u0000\u0015ì\u0000\u0000\u0000\u0003\u0000\u0000\u0015î\u0000\u0000\u0000\b\u0000\u0000\u0015ñ\u0000\u0000\u0000\u0006\u0000\u0000\u0015ô\u0000\u0000\u0000\u0004\u0000\u0000\u0015ö\u0000\u0000\u0000\n\u0000\u0000\u0015ù\u0000\u0000\u0000\u0006\u0000\u0000\u0015ü\u0000\u0000\u0000\u0005\u0000\u0000\u0015ÿ\u0000\u0000\u0000\u0003\u0000\u0000\u0016\u0001\u0000\u0000\u0000\b\u0000\u0000\u0016\u0004\u0000\u0000\u0000\u0006".getBytes(CharEncoding.ISO_8859_1)).asIntBuffer().get(iArr2, 0, 876);
        System.arraycopy(iArr2, 0, iArr, 0, 876);
        LEAP_MONTHS = iArr;
        StdIntegerDateElement stdIntegerDateElement = new StdIntegerDateElement("CYCLE", VietnameseCalendar.class, 75, 94, (char) 0, null, null);
        CYCLE = stdIntegerDateElement;
        EastAsianCY eastAsianCY = EastAsianCY.SINGLETON;
        YEAR_OF_CYCLE = eastAsianCY;
        EastAsianST eastAsianST = EastAsianST.getInstance();
        SOLAR_TERM = eastAsianST;
        EastAsianME eastAsianME = EastAsianME.SINGLETON_EA;
        MONTH_OF_YEAR = eastAsianME;
        StdIntegerDateElement stdIntegerDateElement2 = new StdIntegerDateElement("MONTH_AS_ORDINAL", VietnameseCalendar.class, 1, 12, (char) 0, null, null);
        MONTH_AS_ORDINAL = stdIntegerDateElement2;
        StdIntegerDateElement stdIntegerDateElement3 = new StdIntegerDateElement("DAY_OF_MONTH", VietnameseCalendar.class, 1, 30, 'd');
        DAY_OF_MONTH = stdIntegerDateElement3;
        StdIntegerDateElement stdIntegerDateElement4 = new StdIntegerDateElement("DAY_OF_YEAR", VietnameseCalendar.class, 1, 355, 'D');
        DAY_OF_YEAR = stdIntegerDateElement4;
        StdWeekdayElement stdWeekdayElement = new StdWeekdayElement(VietnameseCalendar.class, getDefaultWeekmodel());
        DAY_OF_WEEK = stdWeekdayElement;
        WeekdayInMonthElement<VietnameseCalendar> weekdayInMonthElement = new WeekdayInMonthElement<>(VietnameseCalendar.class, stdIntegerDateElement3, stdWeekdayElement);
        WIM_ELEMENT = weekdayInMonthElement;
        WEEKDAY_IN_MONTH = weekdayInMonthElement;
        Transformer transformer = new Transformer();
        CALSYS = transformer;
        TimeAxis.Builder builderAppendElement = TimeAxis.Builder.setUp(Unit.class, VietnameseCalendar.class, new Merger(), transformer).appendElement((ChronoElement) stdIntegerDateElement, EastAsianCalendar.getCycleRule(eastAsianCY));
        ElementRule vietYearOfCycleRule = EastAsianCalendar.getVietYearOfCycleRule(eastAsianME);
        Unit unit = Unit.YEARS;
        TimeAxis.Builder builderAppendElement2 = builderAppendElement.appendElement(eastAsianCY, vietYearOfCycleRule, unit).appendElement((ChronoElement) eastAsianST, (ElementRule) EastAsianST.getInstance());
        ElementRule monthOfYearRule = EastAsianCalendar.getMonthOfYearRule(stdIntegerDateElement3);
        Unit unit2 = Unit.MONTHS;
        TimeAxis.Builder builderAppendElement3 = builderAppendElement2.appendElement(eastAsianME, monthOfYearRule, unit2).appendElement(stdIntegerDateElement2, EastAsianCalendar.getMonthAsOrdinalRule(stdIntegerDateElement3), unit2);
        ElementRule dayOfMonthRule = EastAsianCalendar.getDayOfMonthRule();
        Unit unit3 = Unit.DAYS;
        TimeAxis.Builder builderAppendElement4 = builderAppendElement3.appendElement(stdIntegerDateElement3, dayOfMonthRule, unit3).appendElement(stdIntegerDateElement4, EastAsianCalendar.getDayOfYearRule(), unit3).appendElement(stdWeekdayElement, new WeekdayRule(getDefaultWeekmodel(), new ChronoFunction<VietnameseCalendar, CalendarSystem<VietnameseCalendar>>() { // from class: net.time4j.calendar.VietnameseCalendar.1
            @Override // net.time4j.engine.ChronoFunction
            public CalendarSystem<VietnameseCalendar> apply(VietnameseCalendar vietnameseCalendar) {
                return VietnameseCalendar.CALSYS;
            }
        }), unit3).appendElement((ChronoElement) weekdayInMonthElement, WeekdayInMonthElement.getRule(weekdayInMonthElement)).appendElement((ChronoElement) CommonElements.RELATED_GREGORIAN_YEAR, (ElementRule) new RelatedGregorianYearRule(transformer, stdIntegerDateElement4));
        Unit unit4 = Unit.CYCLES;
        TimeAxis.Builder builderAppendUnit = builderAppendElement4.appendUnit(unit4, EastAsianCalendar.getUnitRule(0), unit4.getLength(), Collections.singleton(unit)).appendUnit(unit, EastAsianCalendar.getUnitRule(1), unit.getLength(), Collections.singleton(unit4)).appendUnit(unit2, EastAsianCalendar.getUnitRule(2), unit2.getLength(), Collections.emptySet());
        Unit unit5 = Unit.WEEKS;
        ENGINE = builderAppendUnit.appendUnit(unit5, EastAsianCalendar.getUnitRule(3), unit5.getLength(), Collections.singleton(unit3)).appendUnit(unit3, EastAsianCalendar.getUnitRule(4), unit3.getLength(), Collections.singleton(unit5)).appendExtension((ChronoExtension) new CommonElements.Weekengine(VietnameseCalendar.class, stdIntegerDateElement3, stdIntegerDateElement4, getDefaultWeekmodel())).build();
    }

    private VietnameseCalendar(int i, int i2, EastAsianMonth eastAsianMonth, int i3, long j) {
        super(i, i2, eastAsianMonth, i3, j);
    }

    public static VietnameseCalendar ofTet(int i) {
        return of(EastAsianYear.forGregorian(i), EastAsianMonth.valueOf(1), 1);
    }

    public static VietnameseCalendar of(EastAsianYear eastAsianYear, EastAsianMonth eastAsianMonth, int i) {
        return of(eastAsianYear.getCycle(), eastAsianYear.getYearOfCycle().getNumber(), eastAsianMonth, i);
    }

    public static VietnameseCalendar nowInSystemTime() {
        return (VietnameseCalendar) SystemClock.inLocalView().now(axis());
    }

    public static boolean isValid(EastAsianYear eastAsianYear, EastAsianMonth eastAsianMonth, int i) {
        return CALSYS.isValid(eastAsianYear.getCycle(), eastAsianYear.getYearOfCycle().getNumber(), eastAsianMonth, i);
    }

    public static Weekmodel getDefaultWeekmodel() {
        return Weekmodel.of(new Locale("vi", "VN"));
    }

    public static TimeAxis<Unit, VietnameseCalendar> axis() {
        return ENGINE;
    }

    @Override // net.time4j.engine.TimePoint, net.time4j.engine.ChronoEntity
    public TimeAxis<Unit, VietnameseCalendar> getChronology() {
        return ENGINE;
    }

    @Override // net.time4j.calendar.EastAsianCalendar
    EastAsianCS<VietnameseCalendar> getCalendarSystem() {
        return CALSYS;
    }

    static VietnameseCalendar of(int i, int i2, EastAsianMonth eastAsianMonth, int i3) {
        return new VietnameseCalendar(i, i2, eastAsianMonth, i3, CALSYS.transform(i, i2, eastAsianMonth, i3));
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

        public int between(VietnameseCalendar vietnameseCalendar, VietnameseCalendar vietnameseCalendar2) {
            return (int) vietnameseCalendar.until(vietnameseCalendar2, this);
        }
    }

    static class Transformer extends EastAsianCS<VietnameseCalendar> {
        private static final long MIN_LIMIT;
        private static final List<ZonalOffset> OFFSETS;
        private static final long OFFSET_SWITCH_1841;
        private static final long OFFSET_SWITCH_1954;
        private static final long OFFSET_SWITCH_1968;

        private Transformer() {
        }

        static {
            ArrayList arrayList = new ArrayList(5);
            OffsetSign offsetSign = OffsetSign.AHEAD_OF_UTC;
            arrayList.add(ZonalOffset.atLongitude(offsetSign, 116, 25, 0.0d));
            arrayList.add(ZonalOffset.atLongitude(offsetSign, 107, 35, 0.0d));
            arrayList.add(ZonalOffset.ofHours(offsetSign, 8));
            arrayList.add(ZonalOffset.ofHours(offsetSign, 7));
            OFFSETS = Collections.unmodifiableList(arrayList);
            OFFSET_SWITCH_1841 = PlainDate.of(1841, 1, 1).getDaysSinceEpochUTC();
            OFFSET_SWITCH_1954 = PlainDate.of(1954, 7, 1).getDaysSinceEpochUTC();
            OFFSET_SWITCH_1968 = PlainDate.of(1968, 1, 1).getDaysSinceEpochUTC();
            MIN_LIMIT = PlainDate.of(1813, 2, 1).getDaysSinceEpochUTC();
        }

        @Override // net.time4j.calendar.EastAsianCS, net.time4j.engine.CalendarSystem
        public long getMinimumSinceUTC() {
            return MIN_LIMIT;
        }

        @Override // net.time4j.engine.CalendarSystem
        public List<CalendarEra> getEras() {
            return Collections.emptyList();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // net.time4j.calendar.EastAsianCS
        public VietnameseCalendar create(int i, int i2, EastAsianMonth eastAsianMonth, int i3, long j) {
            return new VietnameseCalendar(i, i2, eastAsianMonth, i3, j);
        }

        @Override // net.time4j.calendar.EastAsianCS
        ZonalOffset getOffset(long j) {
            List<ZonalOffset> list;
            int i;
            if (j < OFFSET_SWITCH_1841) {
                return OFFSETS.get(0);
            }
            if (j < OFFSET_SWITCH_1954) {
                return OFFSETS.get(1);
            }
            if (j < OFFSET_SWITCH_1968) {
                list = OFFSETS;
                i = 2;
            } else {
                list = OFFSETS;
                i = 3;
            }
            return list.get(i);
        }

        @Override // net.time4j.calendar.EastAsianCS
        int[] getLeapMonths() {
            return VietnameseCalendar.LEAP_MONTHS;
        }

        @Override // net.time4j.calendar.EastAsianCS
        boolean isValid(int i, int i2, EastAsianMonth eastAsianMonth, int i3) {
            if (i < 75) {
                return false;
            }
            if (i != 75 || i2 >= 10) {
                return super.isValid(i, i2, eastAsianMonth, i3);
            }
            return false;
        }
    }

    static class Merger extends AbstractMergerEA<VietnameseCalendar> {
        @Override // net.time4j.calendar.AbstractMergerEA, net.time4j.engine.ChronoMerger
        public /* bridge */ /* synthetic */ Object createFrom(ChronoEntity chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            return createFrom((ChronoEntity<?>) chronoEntity, attributeQuery, z, z2);
        }

        @Override // net.time4j.calendar.AbstractMergerEA, net.time4j.engine.ChronoMerger
        public /* bridge */ /* synthetic */ EastAsianCalendar createFrom(ChronoEntity chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            return createFrom((ChronoEntity<?>) chronoEntity, attributeQuery, z, z2);
        }

        Merger() {
            super(VietnameseCalendar.class);
        }

        /* JADX WARN: Code duplicated, block: B:9:0x0026  */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // net.time4j.calendar.AbstractMergerEA, net.time4j.engine.ChronoMerger
        public VietnameseCalendar createFrom(ChronoEntity<?> chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            EastAsianYear eastAsianYearForGregorian;
            int i = chronoEntity.getInt(CommonElements.RELATED_GREGORIAN_YEAR);
            if (i == Integer.MIN_VALUE) {
                TextElement<CyclicYear> textElement = VietnameseCalendar.YEAR_OF_CYCLE;
                if (chronoEntity.contains(textElement)) {
                    CyclicYear cyclicYear = (CyclicYear) chronoEntity.get(textElement);
                    int i2 = chronoEntity.getInt(VietnameseCalendar.CYCLE);
                    if (i2 != Integer.MIN_VALUE) {
                        eastAsianYearForGregorian = cyclicYear.inCycle(i2);
                    } else {
                        eastAsianYearForGregorian = null;
                    }
                } else {
                    eastAsianYearForGregorian = null;
                }
            } else {
                eastAsianYearForGregorian = EastAsianYear.forGregorian(i);
            }
            if (eastAsianYearForGregorian == null) {
                chronoEntity.with(ValidationElement.ERROR_MESSAGE, "Cannot determine East Asian year.");
                return null;
            }
            TextElement<EastAsianMonth> textElement2 = VietnameseCalendar.MONTH_OF_YEAR;
            if (chronoEntity.contains(textElement2)) {
                EastAsianMonth eastAsianMonth = (EastAsianMonth) chronoEntity.get(textElement2);
                int i3 = chronoEntity.getInt(VietnameseCalendar.DAY_OF_MONTH);
                if (i3 != Integer.MIN_VALUE) {
                    return VietnameseCalendar.of(eastAsianYearForGregorian, eastAsianMonth, i3);
                }
            } else {
                int i4 = chronoEntity.getInt(VietnameseCalendar.DAY_OF_YEAR);
                if (i4 != Integer.MIN_VALUE && i4 >= 1) {
                    return (VietnameseCalendar) VietnameseCalendar.of(eastAsianYearForGregorian, EastAsianMonth.valueOf(1), 1).plus(i4 - 1, Unit.DAYS);
                }
            }
            return null;
        }
    }

    static class SPX implements Externalizable {
        private static final int VIETNAMESE = 16;
        private static final long serialVersionUID = 1;
        private transient Object obj;

        public SPX() {
        }

        SPX(Object obj) {
            this.obj = obj;
        }

        @Override // java.io.Externalizable
        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeByte(16);
            writeVietnamese(objectOutput);
        }

        @Override // java.io.Externalizable
        public void readExternal(ObjectInput objectInput) throws IOException {
            if (objectInput.readByte() == 16) {
                this.obj = readVietnamese(objectInput);
                return;
            }
            throw new InvalidObjectException("Unknown calendar type.");
        }

        private Object readResolve() throws ObjectStreamException {
            return this.obj;
        }

        private void writeVietnamese(ObjectOutput objectOutput) throws IOException {
            EastAsianCalendar eastAsianCalendar = (EastAsianCalendar) this.obj;
            objectOutput.writeByte(eastAsianCalendar.getCycle());
            objectOutput.writeByte(eastAsianCalendar.getYear().getNumber());
            objectOutput.writeByte(eastAsianCalendar.getMonth().getNumber());
            objectOutput.writeBoolean(eastAsianCalendar.getMonth().isLeap());
            objectOutput.writeByte(eastAsianCalendar.getDayOfMonth());
        }

        private VietnameseCalendar readVietnamese(ObjectInput objectInput) throws IOException {
            byte b = objectInput.readByte();
            byte b2 = objectInput.readByte();
            byte b3 = objectInput.readByte();
            boolean z = objectInput.readBoolean();
            byte b4 = objectInput.readByte();
            EastAsianMonth eastAsianMonthValueOf = EastAsianMonth.valueOf(b3);
            if (z) {
                eastAsianMonthValueOf = eastAsianMonthValueOf.withLeap();
            }
            return VietnameseCalendar.of(b, b2, eastAsianMonthValueOf, b4);
        }
    }
}
