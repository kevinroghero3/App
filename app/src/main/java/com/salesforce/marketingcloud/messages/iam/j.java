package com.salesforce.marketingcloud.messages.iam;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public class j implements Parcelable {
    public static final Parcelable.Creator<j> CREATOR = new a();
    public static final String f = "buttonClicked";
    public static final String g = "dismissed";
    public static final String h = "autoDismissed";
    public static final String i = "unknown";
    final String b;
    final InAppMessage.Button c;
    final long d;
    final Date e;

    class a implements Parcelable.Creator<j> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public j createFromParcel(Parcel parcel) {
            return new j(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public j[] newArray(int i) {
            return new j[i];
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    @interface b {
    }

    private j(@NonNull String str, @NonNull Date date, long j, @Nullable InAppMessage.Button button) {
        this.b = str;
        this.d = j;
        this.c = button;
        this.e = date;
    }

    static j a(Date date, long j) {
        return new j(h, date, j, null);
    }

    static j b(Date date, long j) {
        return new j("dismissed", date, j, null);
    }

    static j m() {
        return new j("unknown", new Date(), -1L, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public InAppMessage.Button h() {
        return this.c;
    }

    public long j() {
        return this.d;
    }

    public Date k() {
        return this.e;
    }

    public String l() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeString(this.b);
        parcel.writeParcelable(this.c, i2);
        parcel.writeLong(this.d);
        parcel.writeLong(this.e.getTime());
    }

    static j a(Date date, long j, InAppMessage.Button button) {
        return new j(f, date, j, button);
    }

    protected j(@NonNull Parcel parcel) {
        this.b = parcel.readString();
        this.c = (InAppMessage.Button) parcel.readParcelable(InAppMessage.Button.class.getClassLoader());
        this.d = parcel.readLong();
        this.e = new Date(parcel.readLong());
    }
}
