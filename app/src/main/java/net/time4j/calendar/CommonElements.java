package net.time4j.calendar;

import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.exifinterface.media.ExifInterface;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.io.ObjectStreamException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import net.time4j.Weekday;
import net.time4j.Weekmodel;
import net.time4j.base.MathUtils;
import net.time4j.calendar.service.StdEnumDateElement;
import net.time4j.calendar.service.StdIntegerDateElement;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.BasicElement;
import net.time4j.engine.CalendarDate;
import net.time4j.engine.CalendarVariant;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoExtension;
import net.time4j.engine.ChronoOperator;
import net.time4j.engine.Chronology;
import net.time4j.engine.ElementRule;
import net.time4j.engine.EpochDays;
import net.time4j.engine.FormattableElement;
import o.ArtificialStackFrames;
import o.onMessageChannelReady;
import o.onRelationshipValidationResult;

/* JADX INFO: loaded from: classes3.dex */
public class CommonElements {

    @FormattableElement(format = "r")
    public static final ChronoElement<Integer> RELATED_GREGORIAN_YEAR = RelatedGregorianYearElement.SINGLETON;

    public static class Weekengine implements ChronoExtension {
        private final Class<? extends ChronoEntity> chronoType;
        private final ChronoElement<Integer> dayOfMonthElement;
        private final ChronoElement<Integer> dayOfYearElement;
        private final Weekmodel defaultWeekmodel;
        private static final byte[] $$a = {Ascii.SYN, -120, 37, 108};
        private static final int $$b = 64;
        private static int $10 = 0;
        private static int $11 = 1;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static char[] validateRelationship = {56279, 56280, 56259, 56257, 56203, 56270, 56284, 56286, 56268, 56271, 56272, 56269, 56256, 56273, 56204, 56201, 56289, 56297, 56267, 56265, 56277, 56318, 56299, 56196, 56312, 56285, 56266, 56217, 56317, 56287, 56274, 56213, 56298, 56300, 56302, 56278, 56276, 56308, 56304, 56275, 56192, 56307};
        private static int warmup = -1044259911;
        private static boolean requestPostMessageChannelWithExtras = true;
        private static boolean ICustomTabsServiceDefault = true;
        private static long onPostMessage = -4566448903749582848L;

        /* JADX WARN: Code duplicated, block: B:10:0x0025  */
        /* JADX WARN: Code duplicated, block: B:8:0x001f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002a). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$c(int r6, short r7, int r8) {
            /*
                int r6 = 121 - r6
                byte[] r0 = net.time4j.calendar.CommonElements.Weekengine.$$a
                int r7 = r7 * 3
                int r1 = 1 - r7
                int r8 = r8 + 4
                byte[] r1 = new byte[r1]
                r2 = 0
                int r7 = 0 - r7
                if (r0 != 0) goto L15
                r6 = r7
                r3 = r8
                r4 = r2
                goto L2a
            L15:
                r3 = r2
            L16:
                int r8 = r8 + 1
                byte r4 = (byte) r6
                r1[r3] = r4
                int r4 = r3 + 1
                if (r3 != r7) goto L25
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                return r6
            L25:
                r3 = r0[r8]
                r5 = r3
                r3 = r8
                r8 = r5
            L2a:
                int r6 = r6 + r8
                r8 = r3
                r3 = r4
                goto L16
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.CommonElements.Weekengine.$$c(int, short, int):java.lang.String");
        }

        @Override // net.time4j.engine.ChronoExtension
        public boolean canResolve(ChronoElement<?> chronoElement) {
            return false;
        }

        @Override // net.time4j.engine.ChronoExtension
        public ChronoEntity<?> resolve(ChronoEntity<?> chronoEntity, Locale locale, AttributeQuery attributeQuery) {
            return chronoEntity;
        }

        private static void b(int i, char[] cArr, Object[] objArr) throws Throwable {
            int i2 = 2 % 2;
            onRelationshipValidationResult onrelationshipvalidationresult = new onRelationshipValidationResult();
            char[] cArrAccessartificialFrame = onRelationshipValidationResult.accessartificialFrame(onPostMessage ^ 2573525503365829440L, cArr, i);
            onrelationshipvalidationresult.e = 4;
            while (onrelationshipvalidationresult.e < cArrAccessartificialFrame.length) {
                int i3 = $10 + b.f40o;
                $11 = i3 % 128;
                int i4 = i3 % 2;
                onrelationshipvalidationresult.d = onrelationshipvalidationresult.e - 4;
                int i5 = onrelationshipvalidationresult.e;
                try {
                    Object[] objArr2 = {Long.valueOf(cArrAccessartificialFrame[onrelationshipvalidationresult.e] ^ cArrAccessartificialFrame[onrelationshipvalidationresult.e % 4]), Long.valueOf(onrelationshipvalidationresult.d), Long.valueOf(onPostMessage)};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(797310229);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 27, (char) (30690 - KeyEvent.getDeadChar(0, 0)), TextUtils.getCapsMode("", 0, 0) + 188, -1327449315, false, "k", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                    }
                    cArrAccessartificialFrame[i5] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    Object[] objArr3 = {onrelationshipvalidationresult, onrelationshipvalidationresult};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(321542193);
                    if (objAccessartificialFrame2 == null) {
                        byte b = (byte) 0;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollBarSize() >> 8) + 33, (char) (ViewConfiguration.getPressedStateDuration() >> 16), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 1483, -1940971975, false, $$c((byte) 10, b, (byte) (b - 1)), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            String str = new String(cArrAccessartificialFrame, 4, cArrAccessartificialFrame.length - 4);
            int i6 = $11 + 91;
            $10 = i6 % 128;
            int i7 = i6 % 2;
            objArr[0] = str;
        }

        private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) throws Throwable {
            int i2 = 2;
            int i3 = 2 % 2;
            onMessageChannelReady onmessagechannelready = new onMessageChannelReady();
            char[] cArr2 = validateRelationship;
            long j = 0;
            if (cArr2 != null) {
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                int i4 = 0;
                while (i4 < length) {
                    int i5 = $10 + 73;
                    $11 = i5 % 128;
                    int i6 = i5 % i2;
                    try {
                        Object[] objArr2 = {Integer.valueOf(cArr2[i4])};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(115862995);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) 0;
                            byte b2 = b;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(27 - (SystemClock.elapsedRealtime() > j ? 1 : (SystemClock.elapsedRealtime() == j ? 0 : -1)), (char) View.MeasureSpec.getMode(0), 1041 - KeyEvent.normalizeMetaState(0), -1719489573, false, $$c(b, b2, (byte) (b2 - 1)), new Class[]{Integer.TYPE});
                        }
                        cArr3[i4] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        i4++;
                        i2 = 2;
                        j = 0;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                cArr2 = cArr3;
            }
            try {
                Object[] objArr3 = {Integer.valueOf(warmup)};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1820173622);
                if (objAccessartificialFrame2 == null) {
                    byte b3 = (byte) 0;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(15 - View.MeasureSpec.getSize(0), (char) (20487 - TextUtils.indexOf((CharSequence) "", '0')), 2148 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 216472770, false, $$c((byte) 54, b3, (byte) (b3 - 1)), new Class[]{Integer.TYPE});
                }
                int iIntValue = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                int i7 = 55;
                int i8 = -2083387879;
                if (ICustomTabsServiceDefault) {
                    onmessagechannelready.c = bArr.length;
                    char[] cArr4 = new char[onmessagechannelready.c];
                    onmessagechannelready.a = 0;
                    while (onmessagechannelready.a < onmessagechannelready.c) {
                        int i9 = $11 + 3;
                        $10 = i9 % 128;
                        if (i9 % 2 != 0) {
                            cArr4[onmessagechannelready.a] = (char) (cArr2[bArr[(onmessagechannelready.c % 0) >>> onmessagechannelready.a] % i] >> iIntValue);
                            Object[] objArr4 = {onmessagechannelready, onmessagechannelready};
                            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                            if (objAccessartificialFrame3 == null) {
                                byte b4 = (byte) 0;
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 21, (char) (Color.blue(0) + 59174), TextUtils.indexOf((CharSequence) "", '0') + 1944, 481771537, false, $$c((byte) 55, b4, (byte) (b4 - 1)), new Class[]{Object.class, Object.class});
                            }
                            ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                        } else {
                            cArr4[onmessagechannelready.a] = (char) (cArr2[bArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] + i] - iIntValue);
                            Object[] objArr5 = {onmessagechannelready, onmessagechannelready};
                            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                            if (objAccessartificialFrame4 == null) {
                                byte b5 = (byte) 0;
                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(22 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) (59174 - TextUtils.getOffsetAfter("", 0)), AndroidCharacter.getMirror('0') + 1895, 481771537, false, $$c((byte) 55, b5, (byte) (b5 - 1)), new Class[]{Object.class, Object.class});
                            }
                            ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                        }
                    }
                    objArr[0] = new String(cArr4);
                    return;
                }
                if (!requestPostMessageChannelWithExtras) {
                    onmessagechannelready.c = iArr.length;
                    char[] cArr5 = new char[onmessagechannelready.c];
                    onmessagechannelready.a = 0;
                    while (onmessagechannelready.a < onmessagechannelready.c) {
                        cArr5[onmessagechannelready.a] = (char) (cArr2[iArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                        onmessagechannelready.a++;
                    }
                    objArr[0] = new String(cArr5);
                    return;
                }
                onmessagechannelready.c = cArr.length;
                char[] cArr6 = new char[onmessagechannelready.c];
                onmessagechannelready.a = 0;
                while (onmessagechannelready.a < onmessagechannelready.c) {
                    int i10 = $11 + 123;
                    $10 = i10 % 128;
                    int i11 = i10 % 2;
                    cArr6[onmessagechannelready.a] = (char) (cArr2[cArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                    Object[] objArr6 = {onmessagechannelready, onmessagechannelready};
                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(i8);
                    if (objAccessartificialFrame5 == null) {
                        byte b6 = (byte) i7;
                        byte b7 = (byte) 0;
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getKeyRepeatDelay() >> 16) + 21, (char) (59175 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 1943, 481771537, false, $$c(b6, b7, (byte) (b7 - 1)), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame5).invoke(null, objArr6);
                    i7 = 55;
                    i8 = -2083387879;
                }
                objArr[0] = new String(cArr6);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }

        Weekengine(Class<? extends ChronoEntity> cls, ChronoElement<Integer> chronoElement, ChronoElement<Integer> chronoElement2, Weekmodel weekmodel) {
            this.chronoType = cls;
            this.dayOfMonthElement = chronoElement;
            this.dayOfYearElement = chronoElement2;
            this.defaultWeekmodel = weekmodel;
        }

        @Override // net.time4j.engine.ChronoExtension
        public boolean accept(Class<?> cls) {
            return this.chronoType.equals(cls);
        }

        @Override // net.time4j.engine.ChronoExtension
        public Set<ChronoElement<?>> getElements(Locale locale, AttributeQuery attributeQuery) {
            Weekmodel weekmodelOf = locale.getCountry().isEmpty() ? this.defaultWeekmodel : Weekmodel.of(locale);
            HashSet hashSet = new HashSet();
            hashSet.add(DayOfWeekElement.of(this.chronoType, weekmodelOf));
            Weekmodel weekmodel = weekmodelOf;
            hashSet.add(CalendarWeekElement.of("WEEK_OF_MONTH", this.chronoType, 1, 5, 'W', weekmodel, this.dayOfMonthElement, false));
            hashSet.add(CalendarWeekElement.of("WEEK_OF_YEAR", this.chronoType, 1, 52, 'w', weekmodel, this.dayOfYearElement, false));
            hashSet.add(CalendarWeekElement.of("BOUNDED_WEEK_OF_MONTH", this.chronoType, 1, 5, (char) 0, weekmodel, this.dayOfMonthElement, true));
            hashSet.add(CalendarWeekElement.of("BOUNDED_WEEK_OF_YEAR", this.chronoType, 1, 52, (char) 0, weekmodel, this.dayOfYearElement, true));
            return Collections.unmodifiableSet(hashSet);
        }

        /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
            java.util.NoSuchElementException
            	at java.base/java.util.TreeMap.key(Unknown Source)
            	at java.base/java.util.TreeMap.lastKey(Unknown Source)
            	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
            	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
            	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
            */
        public static java.lang.Object[] accessartificialFrame(android.content.Context r22, int r23, int r24) {
            /*
                Method dump skipped, instruction units count: 2933
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.CommonElements.Weekengine.accessartificialFrame(android.content.Context, int, int):java.lang.Object[]");
        }
    }

    private CommonElements() {
    }

    @FormattableElement(alt = "c", format = "e")
    public static <T extends ChronoEntity<T> & CalendarDate> StdCalendarElement<Weekday, T> localDayOfWeek(Chronology<T> chronology, Weekmodel weekmodel) {
        checkSevenDayWeek(chronology);
        return new DayOfWeekElement(chronology.getChronoType(), weekmodel);
    }

    @FormattableElement(format = "w")
    public static <T extends ChronoEntity<T> & CalendarDate> StdCalendarElement<Integer, T> weekOfYear(Chronology<T> chronology, Weekmodel weekmodel) {
        ChronoElement<Integer> chronoElementFindDayElement = findDayElement(chronology, "DAY_OF_YEAR");
        if (chronoElementFindDayElement == null) {
            throw new IllegalArgumentException("Cannot derive a rule for given chronology: " + chronology);
        }
        return new CalendarWeekElement("WEEK_OF_YEAR", chronology.getChronoType(), 1, 52, 'w', weekmodel, chronoElementFindDayElement, false);
    }

    @FormattableElement(format = ExifInterface.LONGITUDE_WEST)
    public static <T extends ChronoEntity<T> & CalendarDate> StdCalendarElement<Integer, T> weekOfMonth(Chronology<T> chronology, Weekmodel weekmodel) {
        ChronoElement<Integer> chronoElementFindDayElement = findDayElement(chronology, "DAY_OF_MONTH");
        if (chronoElementFindDayElement == null) {
            throw new IllegalArgumentException("Cannot derive a rule for given chronology: " + chronology);
        }
        return new CalendarWeekElement("WEEK_OF_MONTH", chronology.getChronoType(), 1, 5, 'W', weekmodel, chronoElementFindDayElement, false);
    }

    public static <T extends ChronoEntity<T> & CalendarDate> StdCalendarElement<Integer, T> boundedWeekOfYear(Chronology<T> chronology, Weekmodel weekmodel) {
        ChronoElement<Integer> chronoElementFindDayElement = findDayElement(chronology, "DAY_OF_YEAR");
        if (chronoElementFindDayElement == null) {
            throw new IllegalArgumentException("Cannot derive a rule for given chronology: " + chronology);
        }
        return new CalendarWeekElement("BOUNDED_WEEK_OF_YEAR", chronology.getChronoType(), 1, 52, (char) 0, weekmodel, chronoElementFindDayElement, true);
    }

    public static <T extends ChronoEntity<T> & CalendarDate> StdCalendarElement<Integer, T> boundedWeekOfMonth(Chronology<T> chronology, Weekmodel weekmodel) {
        ChronoElement<Integer> chronoElementFindDayElement = findDayElement(chronology, "DAY_OF_MONTH");
        if (chronoElementFindDayElement == null) {
            throw new IllegalArgumentException("Cannot derive a rule for given chronology: " + chronology);
        }
        return new CalendarWeekElement("BOUNDED_WEEK_OF_MONTH", chronology.getChronoType(), 1, 5, (char) 0, weekmodel, chronoElementFindDayElement, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <D extends ChronoEntity<D>> int getMax(ChronoElement<?> chronoElement, D d) {
        return ((Integer) Integer.class.cast(d.getMaximum(chronoElement))).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Weekday getDayOfWeek(long j) {
        return Weekday.valueOf(MathUtils.floorModulo(j + 5, 7) + 1);
    }

    private static void checkSevenDayWeek(Chronology<?> chronology) {
        Object[] enumConstants;
        if (CalendarDate.class.isAssignableFrom(chronology.getChronoType())) {
            for (ChronoElement<?> chronoElement : chronology.getRegisteredElements()) {
                if (chronoElement.name().equals("DAY_OF_WEEK") && (enumConstants = chronoElement.getType().getEnumConstants()) != null && enumConstants.length == 7) {
                    return;
                }
            }
        }
        throw new IllegalArgumentException("No 7-day-week: " + chronology);
    }

    private static <D extends ChronoEntity<D>> ChronoElement<Integer> findDayElement(Chronology<D> chronology, String str) {
        checkSevenDayWeek(chronology);
        Iterator<ChronoElement<?>> it2 = chronology.getRegisteredElements().iterator();
        while (it2.hasNext()) {
            ChronoElement<Integer> chronoElement = (ChronoElement) it2.next();
            if (chronoElement.name().equals(str)) {
                if (chronoElement.getType() == Integer.class) {
                    return chronoElement;
                }
                return null;
            }
        }
        return null;
    }

    static class CalendarWeekElement<T extends ChronoEntity<T>> extends StdIntegerDateElement<T> {
        private static final long serialVersionUID = -7471192143785466686L;
        private final boolean bounded;
        private final ChronoElement<Integer> dayElement;
        private final Weekmodel model;

        @Override // net.time4j.engine.BasicElement, net.time4j.engine.ChronoElement
        public boolean isLenient() {
            return true;
        }

        @Override // net.time4j.calendar.service.StdDateElement
        public Object readResolve() throws ObjectStreamException {
            return this;
        }

        CalendarWeekElement(String str, Class<T> cls, int i, int i2, char c, Weekmodel weekmodel, ChronoElement<Integer> chronoElement, boolean z) {
            super(str, cls, i, i2, c);
            if (weekmodel == null) {
                throw new NullPointerException("Missing week model.");
            }
            this.model = weekmodel;
            this.dayElement = chronoElement;
            this.bounded = z;
        }

        static <T extends ChronoEntity<T>> CalendarWeekElement<T> of(String str, Class<T> cls, int i, int i2, char c, Weekmodel weekmodel, ChronoElement<Integer> chronoElement, boolean z) {
            return new CalendarWeekElement<>(str, cls, i, i2, c, weekmodel, chronoElement, z);
        }

        @Override // net.time4j.calendar.service.StdIntegerDateElement, net.time4j.calendar.service.StdDateElement, net.time4j.calendar.StdCalendarElement
        public ChronoOperator<T> decremented() {
            return new DayOperator(-7);
        }

        @Override // net.time4j.calendar.service.StdIntegerDateElement, net.time4j.calendar.service.StdDateElement, net.time4j.calendar.StdCalendarElement
        public ChronoOperator<T> incremented() {
            return new DayOperator(7);
        }

        @Override // net.time4j.calendar.service.StdDateElement, net.time4j.engine.BasicElement
        public boolean doEquals(BasicElement<?> basicElement) {
            if (super.doEquals(basicElement)) {
                CalendarWeekElement calendarWeekElement = (CalendarWeekElement) CalendarWeekElement.class.cast(basicElement);
                if (this.model.equals(calendarWeekElement.model) && this.bounded == calendarWeekElement.bounded) {
                    return true;
                }
            }
            return false;
        }

        @Override // net.time4j.engine.BasicElement
        public <D extends ChronoEntity<D>> ElementRule<D, Integer> derive(Chronology<D> chronology) {
            if (getChronoType().equals(chronology.getChronoType())) {
                return this.bounded ? new BWRule(this) : new CWRule(this);
            }
            return null;
        }
    }

    static class CWRule<D extends ChronoEntity<D>> implements ElementRule<D, Integer> {
        private final CalendarWeekElement<?> owner;

        private CWRule(CalendarWeekElement<?> calendarWeekElement) {
            this.owner = calendarWeekElement;
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getValue(D d) {
            return Integer.valueOf(getCalendarWeek(d));
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getMinimum(D d) {
            return 1;
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getMaximum(D d) {
            return Integer.valueOf(getMaxCalendarWeek(d));
        }

        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: isValid, reason: merged with bridge method [inline-methods] */
        public boolean isValid2(D d, Integer num) {
            int iIntValue;
            return num != null && (iIntValue = num.intValue()) >= 1 && iIntValue <= getMaxCalendarWeek(d);
        }

        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: withValue, reason: merged with bridge method [inline-methods] */
        public D withValue2(D d, Integer num, boolean z) {
            int iIntValue = num.intValue();
            if (!z && !isValid2((ChronoEntity) d, num)) {
                throw new IllegalArgumentException("Invalid value: " + iIntValue + " (context=" + d + ")");
            }
            return (D) setCalendarWeek(d, iIntValue);
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtFloor(D d) {
            return getChild(d.getClass());
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtCeiling(D d) {
            return getChild(d.getClass());
        }

        private ChronoElement<?> getChild(Object obj) {
            return new DayOfWeekElement((Class) obj, ((CalendarWeekElement) this.owner).model);
        }

        private int getMaxCalendarWeek(D d) {
            int i = d.getInt(((CalendarWeekElement) this.owner).dayElement);
            int firstCalendarWeekAsDay = getFirstCalendarWeekAsDay(d, 0);
            if (firstCalendarWeekAsDay <= i) {
                int firstCalendarWeekAsDay2 = getFirstCalendarWeekAsDay(d, 1) + getLengthOfYM(d, 0);
                if (firstCalendarWeekAsDay2 <= i) {
                    try {
                        int firstCalendarWeekAsDay3 = getFirstCalendarWeekAsDay(d, 1);
                        EpochDays epochDays = EpochDays.UTC;
                        firstCalendarWeekAsDay2 = getFirstCalendarWeekAsDay(d.with(epochDays, ((Long) d.get(epochDays)).longValue() + 7), 1) + getLengthOfYM(d, 1);
                        firstCalendarWeekAsDay = firstCalendarWeekAsDay3;
                    } catch (RuntimeException unused) {
                        firstCalendarWeekAsDay2 += 7;
                    }
                }
                return (firstCalendarWeekAsDay2 - firstCalendarWeekAsDay) / 7;
            }
            return ((firstCalendarWeekAsDay + getLengthOfYM(d, -1)) - getFirstCalendarWeekAsDay(d, -1)) / 7;
        }

        private int getFirstCalendarWeekAsDay(D d, int i) {
            Weekday weekdayStart = getWeekdayStart(d, i);
            Weekmodel weekmodel = ((CalendarWeekElement) this.owner).model;
            int value = weekdayStart.getValue(weekmodel);
            return value <= 8 - weekmodel.getMinimalDaysInFirstWeek() ? 2 - value : 9 - value;
        }

        private Weekday getWeekdayStart(D d, int i) {
            int i2 = d.getInt(((CalendarWeekElement) this.owner).dayElement);
            if (i == -1) {
                EpochDays epochDays = EpochDays.UTC;
                long jLongValue = ((Long) d.get(epochDays)).longValue() - ((long) i2);
                return CommonElements.getDayOfWeek((jLongValue - ((long) d.with(epochDays, jLongValue).getInt(((CalendarWeekElement) this.owner).dayElement))) + 1);
            }
            if (i == 0) {
                return CommonElements.getDayOfWeek((((Long) d.get(EpochDays.UTC)).longValue() - ((long) i2)) + 1);
            }
            if (i == 1) {
                return CommonElements.getDayOfWeek(((((Long) d.get(EpochDays.UTC)).longValue() + ((long) CommonElements.getMax(((CalendarWeekElement) this.owner).dayElement, d))) + 1) - ((long) i2));
            }
            throw new AssertionError("Unexpected: " + i);
        }

        private int getLengthOfYM(D d, int i) {
            int i2 = d.getInt(((CalendarWeekElement) this.owner).dayElement);
            if (i == -1) {
                ChronoElement chronoElement = ((CalendarWeekElement) this.owner).dayElement;
                EpochDays epochDays = EpochDays.UTC;
                return CommonElements.getMax(chronoElement, d.with(epochDays, ((Long) d.get(epochDays)).longValue() - ((long) i2)));
            }
            if (i == 0) {
                return CommonElements.getMax(((CalendarWeekElement) this.owner).dayElement, d);
            }
            if (i == 1) {
                int max = CommonElements.getMax(((CalendarWeekElement) this.owner).dayElement, d);
                ChronoElement chronoElement2 = ((CalendarWeekElement) this.owner).dayElement;
                EpochDays epochDays2 = EpochDays.UTC;
                return CommonElements.getMax(chronoElement2, d.with(epochDays2, ((((Long) d.get(epochDays2)).longValue() + ((long) max)) + 1) - ((long) i2)));
            }
            throw new AssertionError("Unexpected: " + i);
        }

        private int getCalendarWeek(D d) {
            int lengthOfYM;
            int i = d.getInt(((CalendarWeekElement) this.owner).dayElement);
            int firstCalendarWeekAsDay = getFirstCalendarWeekAsDay(d, 0);
            if (firstCalendarWeekAsDay <= i) {
                if (getFirstCalendarWeekAsDay(d, 1) + getLengthOfYM(d, 0) <= i) {
                    return 1;
                }
                lengthOfYM = (i - firstCalendarWeekAsDay) / 7;
            } else {
                lengthOfYM = ((i + getLengthOfYM(d, -1)) - getFirstCalendarWeekAsDay(d, -1)) / 7;
            }
            return lengthOfYM + 1;
        }

        private D setCalendarWeek(D d, int i) {
            int calendarWeek = getCalendarWeek(d);
            if (i == calendarWeek) {
                return d;
            }
            EpochDays epochDays = EpochDays.UTC;
            return (D) d.with(epochDays, ((Long) d.get(epochDays)).longValue() + ((long) ((i - calendarWeek) * 7)));
        }
    }

    static class BWRule<D extends ChronoEntity<D>> implements ElementRule<D, Integer> {
        private final CalendarWeekElement<?> owner;

        private BWRule(CalendarWeekElement<?> calendarWeekElement) {
            this.owner = calendarWeekElement;
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getValue(D d) {
            return Integer.valueOf(getWeek(d));
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getMinimum(D d) {
            return Integer.valueOf(getMinWeek(d));
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getMaximum(D d) {
            return Integer.valueOf(getMaxWeek(d));
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtFloor(D d) {
            return getChild(d, false);
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtCeiling(D d) {
            return getChild(d, true);
        }

        private ChronoElement<?> getChild(D d, boolean z) {
            DayOfWeekElement dayOfWeekElementOf = DayOfWeekElement.of(d.getClass(), ((CalendarWeekElement) this.owner).model);
            int week = getWeek(d);
            EpochDays epochDays = EpochDays.UTC;
            long jLongValue = ((Long) d.get(epochDays)).longValue();
            int i = d.getInt(((CalendarWeekElement) this.owner).dayElement);
            if (z) {
                if (((Integer) d.getMaximum(((CalendarWeekElement) this.owner).dayElement)).intValue() < ((long) i) + (((Long) d.with(dayOfWeekElementOf, d.getMaximum(dayOfWeekElementOf)).get(epochDays)).longValue() - jLongValue)) {
                    return ((CalendarWeekElement) this.owner).dayElement;
                }
            } else if (week <= 1) {
                if (((Integer) d.getMinimum(((CalendarWeekElement) this.owner).dayElement)).intValue() > ((long) i) - (jLongValue - ((Long) d.with(dayOfWeekElementOf, d.getMinimum(dayOfWeekElementOf)).get(epochDays)).longValue())) {
                    return ((CalendarWeekElement) this.owner).dayElement;
                }
            }
            return dayOfWeekElementOf;
        }

        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: isValid, reason: merged with bridge method [inline-methods] */
        public boolean isValid2(D d, Integer num) {
            int iIntValue;
            return num != null && (iIntValue = num.intValue()) >= getMinWeek(d) && iIntValue <= getMaxWeek(d);
        }

        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: withValue, reason: merged with bridge method [inline-methods] */
        public D withValue2(D d, Integer num, boolean z) {
            if (num == null || (!z && !isValid2((ChronoEntity) d, num))) {
                throw new IllegalArgumentException("Invalid value: " + num + " (context=" + d + ")");
            }
            return (D) setWeek(d, num.intValue());
        }

        private int getWeek(D d) {
            return getWeek(d, 0);
        }

        private int getMinWeek(D d) {
            return getWeek(d, -1);
        }

        private int getMaxWeek(D d) {
            return getWeek(d, 1);
        }

        private int getWeek(D d, int i) {
            int iIntValue = d.getInt(((CalendarWeekElement) this.owner).dayElement);
            int value = CommonElements.getDayOfWeek((((Long) d.get(EpochDays.UTC)).longValue() - ((long) iIntValue)) + 1).getValue(((CalendarWeekElement) this.owner).model);
            int i2 = value <= 8 - ((CalendarWeekElement) this.owner).model.getMinimalDaysInFirstWeek() ? 2 - value : 9 - value;
            if (i == -1) {
                iIntValue = 1;
            } else if (i != 0) {
                if (i == 1) {
                    iIntValue = ((Integer) d.getMaximum(((CalendarWeekElement) this.owner).dayElement)).intValue();
                } else {
                    throw new AssertionError("Unexpected: " + i);
                }
            }
            return MathUtils.floorDivide(iIntValue - i2, 7) + 1;
        }

        private D setWeek(D d, int i) {
            int week = getWeek(d);
            if (i == week) {
                return d;
            }
            EpochDays epochDays = EpochDays.UTC;
            return (D) d.with(epochDays, ((Long) d.get(epochDays)).longValue() + ((long) ((i - week) * 7)));
        }
    }

    static class DayOfWeekElement<T extends ChronoEntity<T>> extends StdEnumDateElement<Weekday, T> {
        private static final long serialVersionUID = 5613494586572932860L;
        private final Weekmodel model;

        @Override // net.time4j.calendar.service.StdEnumDateElement
        public boolean isWeekdayElement() {
            return true;
        }

        @Override // net.time4j.calendar.service.StdDateElement
        public Object readResolve() throws ObjectStreamException {
            return this;
        }

        DayOfWeekElement(Class<T> cls, Weekmodel weekmodel) {
            super("LOCAL_DAY_OF_WEEK", cls, Weekday.class, 'e');
            this.model = weekmodel;
        }

        static <T extends ChronoEntity<T>> DayOfWeekElement<T> of(Class<T> cls, Weekmodel weekmodel) {
            return new DayOfWeekElement<>(cls, weekmodel);
        }

        @Override // net.time4j.calendar.service.StdEnumDateElement, net.time4j.calendar.service.StdDateElement, net.time4j.calendar.StdCalendarElement
        public ChronoOperator<T> decremented() {
            return new DayOperator(-1);
        }

        @Override // net.time4j.calendar.service.StdEnumDateElement, net.time4j.calendar.service.StdDateElement, net.time4j.calendar.StdCalendarElement
        public ChronoOperator<T> incremented() {
            return new DayOperator(1);
        }

        @Override // net.time4j.calendar.service.StdEnumDateElement, net.time4j.format.NumericalElement
        public int numerical(Weekday weekday) {
            return weekday.getValue(this.model);
        }

        @Override // net.time4j.calendar.service.StdEnumDateElement, net.time4j.engine.ChronoElement
        public Weekday getDefaultMinimum() {
            return this.model.getFirstDayOfWeek();
        }

        @Override // net.time4j.calendar.service.StdEnumDateElement, net.time4j.engine.ChronoElement
        public Weekday getDefaultMaximum() {
            return this.model.getFirstDayOfWeek().roll(6);
        }

        @Override // net.time4j.engine.BasicElement, java.util.Comparator
        public int compare(ChronoDisplay chronoDisplay, ChronoDisplay chronoDisplay2) {
            int value = ((Weekday) chronoDisplay.get(this)).getValue(this.model);
            int value2 = ((Weekday) chronoDisplay2.get(this)).getValue(this.model);
            if (value < value2) {
                return -1;
            }
            return value == value2 ? 0 : 1;
        }

        @Override // net.time4j.calendar.service.StdDateElement, net.time4j.engine.BasicElement
        public boolean doEquals(BasicElement<?> basicElement) {
            if (!super.doEquals(basicElement)) {
                return false;
            }
            return this.model.equals(((DayOfWeekElement) DayOfWeekElement.class.cast(basicElement)).model);
        }

        @Override // net.time4j.engine.BasicElement
        public <D extends ChronoEntity<D>> ElementRule<D, Weekday> derive(Chronology<D> chronology) {
            if (getChronoType().equals(chronology.getChronoType())) {
                return new DRule(this);
            }
            return null;
        }
    }

    static class DRule<T extends ChronoEntity<T>> implements ElementRule<T, Weekday> {
        private final DayOfWeekElement<?> element;

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtCeiling(T t) {
            return null;
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtFloor(T t) {
            return null;
        }

        private DRule(DayOfWeekElement<?> dayOfWeekElement) {
            this.element = dayOfWeekElement;
        }

        @Override // net.time4j.engine.ElementRule
        public Weekday getValue(T t) {
            return CommonElements.getDayOfWeek(((Long) t.get(EpochDays.UTC)).longValue());
        }

        @Override // net.time4j.engine.ElementRule
        public Weekday getMinimum(T t) {
            long minimumSinceUTC;
            Chronology chronologyLookup = Chronology.lookup(t.getClass());
            if (t instanceof CalendarVariant) {
                minimumSinceUTC = chronologyLookup.getCalendarSystem(((CalendarVariant) CalendarVariant.class.cast(t)).getVariant()).getMinimumSinceUTC();
            } else {
                minimumSinceUTC = chronologyLookup.getCalendarSystem().getMinimumSinceUTC();
            }
            long jLongValue = ((Long) t.get(EpochDays.UTC)).longValue();
            if ((1 + jLongValue) - ((long) CommonElements.getDayOfWeek(jLongValue).getValue(((DayOfWeekElement) this.element).model)) < minimumSinceUTC) {
                return CommonElements.getDayOfWeek(minimumSinceUTC);
            }
            return this.element.getDefaultMinimum();
        }

        @Override // net.time4j.engine.ElementRule
        public Weekday getMaximum(T t) {
            long maximumSinceUTC;
            Chronology chronologyLookup = Chronology.lookup(t.getClass());
            if (t instanceof CalendarVariant) {
                maximumSinceUTC = chronologyLookup.getCalendarSystem(((CalendarVariant) CalendarVariant.class.cast(t)).getVariant()).getMaximumSinceUTC();
            } else {
                maximumSinceUTC = chronologyLookup.getCalendarSystem().getMaximumSinceUTC();
            }
            long jLongValue = ((Long) t.get(EpochDays.UTC)).longValue();
            if ((7 + jLongValue) - ((long) CommonElements.getDayOfWeek(jLongValue).getValue(((DayOfWeekElement) this.element).model)) > maximumSinceUTC) {
                return CommonElements.getDayOfWeek(maximumSinceUTC);
            }
            return this.element.getDefaultMaximum();
        }

        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: isValid, reason: merged with bridge method [inline-methods] */
        public boolean isValid2(T t, Weekday weekday) {
            if (weekday == null) {
                return false;
            }
            try {
                withValue2((ChronoEntity) t, weekday, false);
                return true;
            } catch (ArithmeticException | IllegalArgumentException unused) {
                return false;
            }
        }

        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: withValue, reason: merged with bridge method [inline-methods] */
        public T withValue2(T t, Weekday weekday, boolean z) {
            EpochDays epochDays = EpochDays.UTC;
            long jLongValue = ((Long) t.get(epochDays)).longValue();
            Weekday dayOfWeek = CommonElements.getDayOfWeek(jLongValue);
            if (weekday == dayOfWeek) {
                return t;
            }
            int value = dayOfWeek.getValue(((DayOfWeekElement) this.element).model);
            return (T) t.with(epochDays, (jLongValue + ((long) weekday.getValue(((DayOfWeekElement) this.element).model))) - ((long) value));
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    static class DayOperator<T extends ChronoEntity<T>> implements ChronoOperator<T> {
        private final int amount;

        DayOperator(int i) {
            this.amount = i;
        }

        @Override // net.time4j.engine.ChronoOperator
        public T apply(T t) {
            EpochDays epochDays = EpochDays.UTC;
            return (T) t.with(epochDays, MathUtils.safeAdd(((Long) t.get(epochDays)).longValue(), this.amount));
        }
    }
}
