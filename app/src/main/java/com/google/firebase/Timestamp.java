package com.google.firebase;

import android.os.Parcel;
import android.os.Parcelable;
import ch.qos.logback.core.CoreConstants;
import java.time.Instant;
import java.util.Date;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.time.DurationKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class Timestamp implements Comparable<Timestamp>, Parcelable {
    private final int nanoseconds;
    private final long seconds;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<Timestamp> CREATOR = new Parcelable.Creator<Timestamp>() { // from class: com.google.firebase.Timestamp$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Timestamp createFromParcel(@NotNull Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new Timestamp(source.readLong(), source.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Timestamp[] newArray(int i) {
            return new Timestamp[i];
        }
    };

    @JvmStatic
    public static final Timestamp now() {
        return Companion.now();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final long getSeconds() {
        return this.seconds;
    }

    public final int getNanoseconds() {
        return this.nanoseconds;
    }

    public Timestamp(long j, int i) {
        Companion.validateRange(j, i);
        this.seconds = j;
        this.nanoseconds = i;
    }

    public Timestamp(@NotNull Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        Companion companion = Companion;
        Pair preciseTime = companion.toPreciseTime(date);
        long jLongValue = ((Number) preciseTime.component1()).longValue();
        int iIntValue = ((Number) preciseTime.component2()).intValue();
        companion.validateRange(jLongValue, iIntValue);
        this.seconds = jLongValue;
        this.nanoseconds = iIntValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Timestamp(@NotNull Instant time) {
        this(time.getEpochSecond(), time.getNano());
        Intrinsics.checkNotNullParameter(time, "time");
    }

    public final Date toDate() {
        return new Date((this.seconds * ((long) 1000)) + ((long) (this.nanoseconds / DurationKt.NANOS_IN_MILLIS)));
    }

    public final Instant toInstant() {
        Instant instantOfEpochSecond = Instant.ofEpochSecond(this.seconds, this.nanoseconds);
        Intrinsics.checkNotNullExpressionValue(instantOfEpochSecond, "ofEpochSecond(seconds, nanoseconds.toLong())");
        return instantOfEpochSecond;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull Timestamp other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return ComparisonsKt__ComparisonsKt.compareValuesBy(this, other, (Function1<? super Timestamp, ? extends Comparable<?>>[]) ((Function1<? super Object, ? extends Comparable<?>>[]) new Function1[]{new PropertyReference1Impl() { // from class: com.google.firebase.Timestamp.compareTo.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(@Nullable Object obj) {
                return Long.valueOf(((Timestamp) obj).getSeconds());
            }
        }, new PropertyReference1Impl() { // from class: com.google.firebase.Timestamp.compareTo.2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(@Nullable Object obj) {
                return Integer.valueOf(((Timestamp) obj).getNanoseconds());
            }
        }}));
    }

    public boolean equals(@Nullable Object obj) {
        return obj == this || ((obj instanceof Timestamp) && compareTo((Timestamp) obj) == 0);
    }

    public int hashCode() {
        long j = this.seconds;
        return (((((int) j) * 1369) + ((int) (j >> 32))) * 37) + this.nanoseconds;
    }

    public String toString() {
        return "Timestamp(seconds=" + this.seconds + ", nanoseconds=" + this.nanoseconds + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int i) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeLong(this.seconds);
        dest.writeInt(this.nanoseconds);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Timestamp now() {
            return new Timestamp(new Date());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Pair<Long, Integer> toPreciseTime(Date date) {
            long j = 1000;
            long time = date.getTime() / j;
            int time2 = (int) ((date.getTime() % j) * ((long) DurationKt.NANOS_IN_MILLIS));
            if (time2 < 0) {
                return TuplesKt.to(Long.valueOf(time - 1), Integer.valueOf(time2 + 1000000000));
            }
            return TuplesKt.to(Long.valueOf(time), Integer.valueOf(time2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void validateRange(long j, int i) {
            if (i < 0 || i >= 1000000000) {
                throw new IllegalArgumentException(("Timestamp nanoseconds out of range: " + i).toString());
            }
            if (-62135596800L > j || j >= 253402300800L) {
                throw new IllegalArgumentException(("Timestamp seconds out of range: " + j).toString());
            }
        }
    }
}
