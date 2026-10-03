package kotlin.time;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.joda.time.DateTimeConstants;

/* JADX INFO: loaded from: classes6.dex */
final class UnboundLocalDateTime {
    public static final Companion Companion = new Companion(null);
    private final int day;
    private final int hour;
    private final int minute;
    private final int month;
    private final int nanosecond;
    private final int second;
    private final int year;

    public UnboundLocalDateTime(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.year = i;
        this.month = i2;
        this.day = i3;
        this.hour = i4;
        this.minute = i5;
        this.second = i6;
        this.nanosecond = i7;
    }

    public final int getYear() {
        return this.year;
    }

    public final int getMonth() {
        return this.month;
    }

    public final int getDay() {
        return this.day;
    }

    public final int getHour() {
        return this.hour;
    }

    public final int getMinute() {
        return this.minute;
    }

    public final int getSecond() {
        return this.second;
    }

    public final int getNanosecond() {
        return this.nanosecond;
    }

    public final Instant toInstant(int i) {
        long j;
        int i2 = this.year;
        long j2 = i2;
        long j3 = ((long) 365) * j2;
        if (j2 >= 0) {
            j = j3 + (((((long) 3) + j2) / ((long) 4)) - ((((long) 99) + j2) / ((long) 100))) + ((j2 + ((long) 399)) / ((long) 400));
        } else {
            j = j3 - (((j2 / ((long) (-4))) - (j2 / ((long) (-100)))) + (j2 / ((long) (-400))));
        }
        int i3 = this.month;
        long j4 = j + ((long) (((i3 * 367) - 362) / 12)) + ((long) (this.day - 1));
        if (i3 > 2) {
            j4 = !InstantKt.isLeapYear(i2) ? j4 - 2 : j4 - 1;
        }
        long j5 = (((j4 - ((long) 719528)) * ((long) DateTimeConstants.SECONDS_PER_DAY)) + ((long) (((this.hour * DateTimeConstants.SECONDS_PER_HOUR) + (this.minute * 60)) + this.second))) - ((long) i);
        Instant.Companion companion = Instant.Companion;
        if (j5 < companion.getMIN$kotlin_stdlib().getEpochSeconds() || j5 > companion.getMAX$kotlin_stdlib().getEpochSeconds()) {
            throw new InstantFormatException("The parsed date is outside the range representable by Instant (Unix epoch second " + j5 + CoreConstants.RIGHT_PARENTHESIS_CHAR);
        }
        return companion.fromEpochSeconds(j5, this.nanosecond);
    }

    public String toString() {
        return "UnboundLocalDateTime(" + this.year + CoreConstants.DASH_CHAR + this.month + CoreConstants.DASH_CHAR + this.day + ' ' + this.hour + CoreConstants.COLON_CHAR + this.minute + CoreConstants.COLON_CHAR + this.second + '.' + this.nanosecond + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UnboundLocalDateTime fromInstant(@NotNull Instant instant) {
            long j;
            Intrinsics.checkNotNullParameter(instant, "instant");
            long epochSeconds = instant.getEpochSeconds();
            long j2 = epochSeconds / 86400;
            if ((epochSeconds ^ 86400) < 0 && j2 * 86400 != epochSeconds) {
                j2--;
            }
            long j3 = epochSeconds % 86400;
            int i = (int) (j3 + (86400 & (((j3 ^ 86400) & ((-j3) | j3)) >> 63)));
            long j4 = (j2 + ((long) 719528)) - ((long) 60);
            if (j4 < 0) {
                long j5 = 146097;
                long j6 = ((j4 + 1) / j5) - 1;
                j = ((long) 400) * j6;
                j4 += (-j6) * j5;
            } else {
                j = 0;
            }
            long j7 = 400;
            long j8 = ((j7 * j4) + ((long) 591)) / ((long) 146097);
            long j9 = 365;
            long j10 = 4;
            long j11 = 100;
            long j12 = j4 - ((((j9 * j8) + (j8 / j10)) - (j8 / j11)) + (j8 / j7));
            if (j12 < 0) {
                j8--;
                j12 = j4 - ((((j9 * j8) + (j8 / j10)) - (j8 / j11)) + (j8 / j7));
            }
            int i2 = (int) j12;
            int i3 = ((i2 * 5) + 2) / 153;
            int i4 = ((i3 * 306) + 5) / 10;
            int i5 = (int) (j8 + j + ((long) (i3 / 10)));
            int i6 = i / DateTimeConstants.SECONDS_PER_HOUR;
            int i7 = i - (i6 * DateTimeConstants.SECONDS_PER_HOUR);
            int i8 = i7 / 60;
            return new UnboundLocalDateTime(i5, ((i3 + 2) % 12) + 1, (i2 - i4) + 1, i6, i8, i7 - (i8 * 60), instant.getNanosecondsOfSecond());
        }
    }
}
