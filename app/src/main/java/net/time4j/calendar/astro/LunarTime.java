package net.time4j.calendar.astro;

import com.facebook.imagepipeline.common.RotationOptions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import net.time4j.CalendarUnit;
import net.time4j.Moment;
import net.time4j.PlainDate;
import net.time4j.PlainTime;
import net.time4j.PlainTimestamp;
import net.time4j.engine.CalendarDate;
import net.time4j.scale.TimeScale;
import net.time4j.scale.UniversalTime;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;

/* JADX INFO: loaded from: classes6.dex */
public final class LunarTime implements GeoLocation, Serializable {
    private static final int MRD = 1000000000;
    private static final long serialVersionUID = -8029871830105935048L;
    private final int altitude;
    private final double latitude;
    private final double longitude;
    private final TZID observerZoneID;

    private static double toJulianCenturies(double d) {
        return (d - 51544.5d) / 36525.0d;
    }

    private LunarTime(double d, double d2, int i, TZID tzid) {
        check(d, d2, i, tzid);
        this.latitude = d;
        this.longitude = d2;
        this.altitude = i;
        this.observerZoneID = tzid;
    }

    public static Builder ofLocation(TZID tzid) {
        if (tzid == null) {
            throw new NullPointerException("Missing observer timezone.");
        }
        return new Builder(tzid);
    }

    public static LunarTime ofLocation(TZID tzid, double d, double d2) {
        return ofLocation(tzid, d, d2, 0);
    }

    public static LunarTime ofLocation(TZID tzid, double d, double d2, int i) {
        return new LunarTime(d, d2, i, tzid);
    }

    @Override // net.time4j.calendar.astro.GeoLocation
    public double getLatitude() {
        return this.latitude;
    }

    @Override // net.time4j.calendar.astro.GeoLocation
    public double getLongitude() {
        return this.longitude;
    }

    @Override // net.time4j.calendar.astro.GeoLocation
    public int getAltitude() {
        return this.altitude;
    }

    public TZID getObserverZoneID() {
        return this.observerZoneID;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LunarTime)) {
            return false;
        }
        LunarTime lunarTime = (LunarTime) obj;
        return this.altitude == lunarTime.altitude && Double.compare(this.latitude, lunarTime.latitude) == 0 && Double.compare(this.longitude, lunarTime.longitude) == 0 && this.observerZoneID.canonical().equals(lunarTime.observerZoneID.canonical());
    }

    public int hashCode() {
        return (AstroUtils.hashCode(this.latitude) * 7) + (AstroUtils.hashCode(this.longitude) * 31) + (this.altitude * 37);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LunarTime[");
        sb.append(",observer-tz=");
        sb.append(this.observerZoneID.canonical());
        sb.append(",latitude=");
        sb.append(this.latitude);
        sb.append(",longitude=");
        sb.append(this.longitude);
        if (this.altitude != 0) {
            sb.append(",altitude=");
            sb.append(this.altitude);
        }
        sb.append(']');
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0139  */
    /* JADX WARN: Code duplicated, block: B:44:0x0153  */
    public Moonlight on(CalendarDate calendarDate) {
        Moment momentAtFirstMoment;
        int i;
        double d;
        double d2;
        Moment momentAdd;
        Moment moment;
        PlainDate gregorian = SolarTime.toGregorian(calendarDate);
        Timezone timezoneOf = Timezone.of(this.observerZoneID);
        if (timezoneOf.getHistory() == null) {
            momentAtFirstMoment = gregorian.at(PlainTime.midnightAtStartOfDay()).in(timezoneOf);
        } else {
            momentAtFirstMoment = gregorian.atFirstMoment(this.observerZoneID);
        }
        double mjd = JulianDay.ofMeanSolarTime(momentAtFirstMoment).getMJD();
        double radians = Math.toRadians(this.longitude);
        double dCos = Math.cos(Math.toRadians(this.latitude));
        double dSin = Math.sin(Math.toRadians(this.latitude));
        double geodeticAngle = StdSolarCalculator.TIME4J.getGeodeticAngle(this.latitude, this.altitude);
        double dRefractionFactorOfStdAtmosphere = (AstroUtils.refractionFactorOfStdAtmosphere(this.altitude) * 34.0d) / 60.0d;
        double dDeltaT = TimeScale.deltaT(gregorian);
        double dSinAlt = sinAlt(mjd, 0.0d, radians, dCos, dSin, geodeticAngle, dRefractionFactorOfStdAtmosphere, dDeltaT);
        double[] dArr = new double[4];
        int i2 = 1;
        boolean z = dSinAlt > 0.0d;
        double d3 = dSinAlt;
        int i3 = 0;
        int i4 = 0;
        double d4 = Double.NaN;
        double d5 = Double.NaN;
        double d6 = 1.0d;
        while (true) {
            int i5 = i3;
            double[] dArr2 = dArr;
            int i6 = i2;
            double dSinAlt2 = sinAlt(mjd, d6, radians, dCos, dSin, geodeticAngle, dRefractionFactorOfStdAtmosphere, dDeltaT);
            double dSinAlt3 = sinAlt(mjd, d6 + 1.0d, radians, dCos, dSin, geodeticAngle, dRefractionFactorOfStdAtmosphere, dDeltaT);
            int iInterpolate = interpolate(d3, dSinAlt2, dSinAlt3, dArr2);
            if (iInterpolate == i6) {
                double d7 = dArr2[2];
                if (Double.isNaN(d7)) {
                    d7 = dArr2[3];
                }
                if (d3 < 0.0d) {
                    d4 = d6 + d7;
                    i = i6;
                } else {
                    d5 = d6 + d7;
                    i = i5;
                    i4 = i6;
                }
            } else {
                if (iInterpolate == 2) {
                    if (dArr2[i6] < 0.0d) {
                        d = d6 + dArr2[3];
                        d2 = d6 + dArr2[2];
                    } else {
                        d = d6 + dArr2[2];
                        d2 = d6 + dArr2[3];
                    }
                    i = i6;
                    i4 = i;
                } else {
                    i = i5;
                }
                d6 += 2.0d;
                if (d6 > 25.0d || !(i == 0 || i4 == 0)) {
                    break;
                }
                d3 = dSinAlt3;
                d4 = d;
                d5 = d2;
                dArr = dArr2;
                int i7 = i;
                i2 = i6;
                i3 = i7;
            }
            d = d4;
            d2 = d5;
            d6 += 2.0d;
            if (d6 > 25.0d) {
                break;
            }
            break;
            break;
        }
        if (i != 0) {
            momentAdd = add(momentAtFirstMoment, d);
            if (!momentAdd.toZonalTimestamp(this.observerZoneID).getCalendarDate().equals(gregorian)) {
                momentAdd = null;
            }
        } else {
            momentAdd = null;
        }
        if (i4 != 0) {
            Moment momentAdd2 = add(momentAtFirstMoment, d2);
            if (momentAdd2.toZonalTimestamp(this.observerZoneID).getCalendarDate().equals(gregorian)) {
                moment = momentAdd2;
            } else {
                moment = null;
            }
        } else {
            moment = null;
        }
        return new Moonlight(gregorian, this.observerZoneID, momentAdd, moment, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Moment add(Moment moment, double d) {
        double d2 = d * 3600.0d;
        long jFloor = (long) Math.floor(d2);
        long j = (long) ((d2 - jFloor) * 1.0E9d);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return (Moment) moment.plus(jFloor, timeUnit).plus(j, TimeUnit.NANOSECONDS).with(Moment.PRECISION, timeUnit);
    }

    private static double sinAlt(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        double d9 = (d2 / 24.0d) + d;
        double[] dArrCalculateMeeus47 = MoonPosition.calculateMeeus47(toJulianCenturies((d8 / 86400.0d) + d9));
        double d10 = dArrCalculateMeeus47[0];
        double dCos = Math.cos(Math.toRadians(dArrCalculateMeeus47[1]));
        double dGmst = AstroUtils.gmst(d9);
        double radians = Math.toRadians(d10 * dCos);
        double radians2 = Math.toRadians(dArrCalculateMeeus47[2]);
        double radians3 = Math.toRadians(dArrCalculateMeeus47[3]);
        double dSin = Math.sin(radians3);
        double dCos2 = Math.cos(radians3);
        return ((dSin * d5) + ((dCos2 * d4) * Math.cos(((dGmst + radians) + d3) - radians2))) - Math.sin(Math.toRadians(((getHorizontalParallax(dArrCalculateMeeus47[4]) * 0.7275d) - d7) - d6));
    }

    private static int interpolate(double d, double d2, double d3, double[] dArr) {
        int i;
        double d4;
        double d5 = ((d3 + d) * 0.5d) - d2;
        double d6 = (d3 - d) * 0.5d;
        double d7 = (-d6) / (2.0d * d5);
        double d8 = (d6 * d6) - ((4.0d * d5) * d2);
        double d9 = Double.NaN;
        if (d8 >= 0.0d) {
            double dSqrt = (Math.sqrt(d8) * 0.5d) / Math.abs(d5);
            double d10 = d7 - dSqrt;
            if (Math.abs(d10) <= 1.0d) {
                i = 1;
            } else {
                i = 0;
                d10 = Double.NaN;
            }
            double d11 = dSqrt + d7;
            if (Math.abs(d11) <= 1.0d) {
                i++;
                d9 = d11;
            }
            double d12 = d10;
            d4 = d9;
            d9 = d12;
        } else {
            i = 0;
            d4 = Double.NaN;
        }
        dArr[0] = d7;
        dArr[1] = (((d5 * d7) + d6) * d7) + d2;
        dArr[2] = d9;
        dArr[3] = d4;
        return i;
    }

    private static double getHorizontalParallax(double d) {
        return Math.toDegrees(Math.asin(6378.14d / d));
    }

    private static void check(double d, double d2, int i, TZID tzid) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException("Latitude must be a finite value: " + d);
        }
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException("Longitude must be a finite value: " + d2);
        }
        if (Double.compare(d, 90.0d) > 0 || Double.compare(d, -90.0d) < 0) {
            throw new IllegalArgumentException("Degrees out of range -90.0 <= latitude <= +90.0: " + d);
        }
        if (Double.compare(d2, 180.0d) >= 0 || Double.compare(d2, -180.0d) < 0) {
            throw new IllegalArgumentException("Degrees out of range -180.0 <= longitude < +180.0: " + d2);
        }
        double d3 = i;
        if (Double.isNaN(d3) || Double.isInfinite(d3)) {
            throw new IllegalArgumentException("Altitude must be finite: " + i);
        }
        if (i < 0 || i >= 11000) {
            throw new IllegalArgumentException("Meters out of range 0 <= altitude < +11,000: " + i);
        }
        Timezone.of(tzid);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        check(this.latitude, this.longitude, this.altitude, this.observerZoneID);
    }

    public static class Builder {
        private int altitude;
        private double latitude;
        private double longitude;
        private final TZID observerZoneID;

        private Builder(TZID tzid) {
            this.latitude = Double.NaN;
            this.longitude = Double.NaN;
            this.altitude = 0;
            this.observerZoneID = tzid;
        }

        public Builder northernLatitude(int i, int i2, double d) {
            check(i, i2, d, 90);
            if (Double.isNaN(this.latitude)) {
                this.latitude = ((double) i) + (((double) i2) / 60.0d) + (d / 3600.0d);
                return this;
            }
            throw new IllegalStateException("Latitude has already been set.");
        }

        public Builder southernLatitude(int i, int i2, double d) {
            check(i, i2, d, 90);
            if (Double.isNaN(this.latitude)) {
                this.latitude = (((double) i) + (((double) i2) / 60.0d) + (d / 3600.0d)) * (-1.0d);
                return this;
            }
            throw new IllegalStateException("Latitude has already been set.");
        }

        public Builder easternLongitude(int i, int i2, double d) {
            check(i, i2, d, 179);
            if (Double.isNaN(this.longitude)) {
                this.longitude = ((double) i) + (((double) i2) / 60.0d) + (d / 3600.0d);
                return this;
            }
            throw new IllegalStateException("Longitude has already been set.");
        }

        public Builder westernLongitude(int i, int i2, double d) {
            check(i, i2, d, RotationOptions.ROTATE_180);
            if (Double.isNaN(this.longitude)) {
                this.longitude = (((double) i) + (((double) i2) / 60.0d) + (d / 3600.0d)) * (-1.0d);
                return this;
            }
            throw new IllegalStateException("Longitude has already been set.");
        }

        public Builder atAltitude(int i) {
            double d = i;
            if (Double.isInfinite(d) || Double.isNaN(d)) {
                throw new IllegalArgumentException("Altitude must be finite: " + i);
            }
            if (i < 0 || i >= 11000) {
                throw new IllegalArgumentException("Meters out of range 0 <= altitude < +11,000: " + i);
            }
            this.altitude = i;
            return this;
        }

        public LunarTime build() {
            if (Double.isNaN(this.latitude)) {
                throw new IllegalStateException("Latitude was not yet set.");
            }
            if (Double.isNaN(this.longitude)) {
                throw new IllegalStateException("Longitude was not yet set.");
            }
            return new LunarTime(this.latitude, this.longitude, this.altitude, this.observerZoneID);
        }

        private static void check(int i, int i2, double d, int i3) {
            if (i < 0 || i > i3 || (i == i3 && i3 != 179 && (i2 > 0 || Double.compare(d, 0.0d) > 0))) {
                throw new IllegalArgumentException("Degrees out of range: " + i + " (decimal=" + (((double) i) + (((double) i2) / 60.0d) + (d / 3600.0d)) + ")");
            }
            if (i2 < 0 || i2 >= 60) {
                throw new IllegalArgumentException("Arc minutes out of range: " + i2);
            }
            if (Double.isNaN(d) || Double.isInfinite(d)) {
                throw new IllegalArgumentException("Arc seconds must be finite.");
            }
            if (Double.compare(d, 0.0d) < 0 || Double.compare(d, 60.0d) >= 0) {
                throw new IllegalArgumentException("Arc seconds out of range: " + d);
            }
        }
    }

    public static class Moonlight {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final boolean above;
        private final Moment endOfDay;
        private final Moment moonrise;
        private final Moment moonset;
        private final TZID observerZoneID;
        private final Moment startOfDay;

        /* JADX WARN: Multi-variable type inference failed */
        private Moonlight(PlainDate plainDate, TZID tzid, Moment moment, Moment moment2, boolean z) {
            this.observerZoneID = tzid;
            Timezone timezoneOf = Timezone.of(tzid);
            PlainDate plainDate2 = (PlainDate) plainDate.plus(1L, CalendarUnit.DAYS);
            if (timezoneOf.getHistory() == null) {
                this.startOfDay = plainDate.atStartOfDay().in(timezoneOf);
                this.endOfDay = plainDate2.atStartOfDay().in(timezoneOf);
            } else {
                this.startOfDay = plainDate.atFirstMoment(tzid);
                this.endOfDay = plainDate2.atFirstMoment(tzid);
            }
            this.moonrise = moment;
            this.moonset = moment2;
            this.above = z;
        }

        public Moment moonrise() {
            return this.moonrise;
        }

        public PlainTimestamp moonriseLocal() {
            Moment moment = this.moonrise;
            if (moment == null) {
                return null;
            }
            return moment.toZonalTimestamp(this.observerZoneID);
        }

        public PlainTimestamp moonrise(TZID tzid) {
            Moment moment = this.moonrise;
            if (moment == null) {
                return null;
            }
            return moment.toZonalTimestamp(tzid);
        }

        public Moment moonset() {
            return this.moonset;
        }

        public PlainTimestamp moonsetLocal() {
            Moment moment = this.moonset;
            if (moment == null) {
                return null;
            }
            return moment.toZonalTimestamp(this.observerZoneID);
        }

        public PlainTimestamp moonset(TZID tzid) {
            Moment moment = this.moonset;
            if (moment == null) {
                return null;
            }
            return moment.toZonalTimestamp(tzid);
        }

        public boolean isPresent(Moment moment) {
            if (moment.isBefore(this.startOfDay) || !moment.isBefore(this.endOfDay)) {
                return false;
            }
            Moment moment2 = this.moonrise;
            if (moment2 == null) {
                UniversalTime universalTime = this.moonset;
                if (universalTime == null) {
                    return this.above;
                }
                return moment.isBefore(universalTime);
            }
            Moment moment3 = this.moonset;
            if (moment3 == null) {
                return !moment.isBefore((UniversalTime) moment2);
            }
            if (moment2.isBefore((UniversalTime) moment3)) {
                return !moment.isBefore(this.moonrise) && moment.isBefore(this.moonset);
            }
            return moment.isBefore(this.moonset) || !moment.isBefore(this.moonrise);
        }

        public boolean isPresentAllDay() {
            return this.above && this.moonrise == null && this.moonset == null;
        }

        public boolean isAbsent() {
            return length() == 0;
        }

        public int length() {
            long jUntil;
            Moment moment = this.moonrise;
            if (moment == null) {
                Moment moment2 = this.moonset;
                if (moment2 == null) {
                    if (!this.above) {
                        return 0;
                    }
                    jUntil = this.startOfDay.until(this.endOfDay, TimeUnit.SECONDS);
                } else {
                    jUntil = this.startOfDay.until(moment2, TimeUnit.SECONDS);
                }
            } else {
                Moment moment3 = this.moonset;
                if (moment3 == null) {
                    jUntil = moment.until(this.endOfDay, TimeUnit.SECONDS);
                } else if (moment.isBefore((UniversalTime) moment3)) {
                    jUntil = this.moonrise.until(this.moonset, TimeUnit.SECONDS);
                } else {
                    Moment moment4 = this.startOfDay;
                    Moment moment5 = this.moonset;
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    jUntil = moment4.until(moment5, timeUnit) + this.moonrise.until(this.endOfDay, timeUnit);
                }
            }
            return (int) jUntil;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Moonlight[");
            sb.append("tz=");
            sb.append(this.observerZoneID.canonical());
            sb.append(" | ");
            Moment moment = this.moonrise;
            if (moment == null) {
                if (this.moonset == null) {
                    sb.append("always ");
                    sb.append(this.above ? "up" : "down");
                } else {
                    sb.append("moonset=");
                    sb.append(this.moonset.toZonalTimestamp(this.observerZoneID));
                }
            } else {
                Moment moment2 = this.moonset;
                if (moment2 == null) {
                    sb.append("moonrise=");
                    sb.append(this.moonrise.toZonalTimestamp(this.observerZoneID));
                } else if (moment.isBefore((UniversalTime) moment2)) {
                    sb.append("moonrise=");
                    sb.append(this.moonrise.toZonalTimestamp(this.observerZoneID));
                    sb.append(" | moonset=");
                    sb.append(this.moonset.toZonalTimestamp(this.observerZoneID));
                } else {
                    sb.append("moonset=");
                    sb.append(this.moonset.toZonalTimestamp(this.observerZoneID));
                    sb.append(" | moonrise=");
                    sb.append(this.moonrise.toZonalTimestamp(this.observerZoneID));
                }
            }
            sb.append(" | length=");
            sb.append(length());
            sb.append(']');
            return sb.toString();
        }
    }
}
