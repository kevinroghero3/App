package com.salesforce.marketingcloud.push.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.AppEventsConstants;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public interface Template extends Parcelable {

    public enum Type implements Parcelable {
        RichButtons("-1"),
        CarouselFull(AppEventsConstants.EVENT_PARAM_VALUE_NO);

        private final String value;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        public static final Parcelable.Creator<Type> CREATOR = new a();

        public static final class a implements Parcelable.Creator<Type> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Type createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return Type.valueOf(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Type[] newArray(int i) {
                return new Type[i];
            }
        }

        Type(String str) {
            this.value = str;
        }

        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final String getValue() {
            return this.value;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel out, int i) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeString(name());
        }
    }

    Style a();

    String d();

    Type f();
}
