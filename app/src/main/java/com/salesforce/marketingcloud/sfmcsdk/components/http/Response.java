package com.salesforce.marketingcloud.sfmcsdk.components.http;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class Response implements Parcelable {
    private final String body;
    private final int code;
    private final long endTimeMillis;
    private final Map<String, List<String>> headers;
    private final String message;
    private final long startTimeMillis;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<Response> CREATOR = new Creator();

    public static final class Creator implements Parcelable.Creator<Response> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Response createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            String string = parcel.readString();
            String string2 = parcel.readString();
            long j = parcel.readLong();
            long j2 = parcel.readLong();
            int i2 = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(i2);
            for (int i3 = 0; i3 != i2; i3++) {
                linkedHashMap.put(parcel.readString(), parcel.createStringArrayList());
            }
            return new Response(i, string, string2, j, j2, linkedHashMap);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Response[] newArray(int i) {
            return new Response[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(this.code);
        out.writeString(this.body);
        out.writeString(this.message);
        out.writeLong(this.startTimeMillis);
        out.writeLong(this.endTimeMillis);
        Map<String, List<String>> map = this.headers;
        out.writeInt(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            out.writeString(entry.getKey());
            out.writeStringList(entry.getValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Response(int i, @Nullable String str, @Nullable String str2, long j, long j2, @NotNull Map<String, ? extends List<String>> headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.code = i;
        this.body = str;
        this.message = str2;
        this.startTimeMillis = j;
        this.endTimeMillis = j2;
        this.headers = headers;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getBody() {
        return this.body;
    }

    public final String getMessage() {
        return this.message;
    }

    public final long getStartTimeMillis() {
        return this.startTimeMillis;
    }

    public final long getEndTimeMillis() {
        return this.endTimeMillis;
    }

    public final Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Response error$sfmcsdk_release(@NotNull String message, int i) {
            Intrinsics.checkNotNullParameter(message, "message");
            long jCurrentTimeMillis = System.currentTimeMillis();
            return new Builder().code(i).message(message).startTimeMillis(jCurrentTimeMillis).endTimeMillis(jCurrentTimeMillis).build();
        }
    }

    public final boolean isSuccessful() {
        int i = this.code;
        return 200 <= i && i < 300;
    }

    public final long timeToExecute() {
        return this.endTimeMillis - this.startTimeMillis;
    }

    public static final class Builder {
        private String body;
        private int code;
        private long endTimeMillis;
        private Map<String, ? extends List<String>> headers;
        private String message;
        private long startTimeMillis;

        public final Builder code(int i) {
            this.code = i;
            return this;
        }

        public final Builder body(@NotNull String body) {
            Intrinsics.checkNotNullParameter(body, "body");
            this.body = body;
            return this;
        }

        public final Builder message(@NotNull String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
            return this;
        }

        public final Builder startTimeMillis(long j) {
            this.startTimeMillis = j;
            return this;
        }

        public final Builder endTimeMillis(long j) {
            this.endTimeMillis = j;
            return this;
        }

        public final Builder headers(@NotNull Map<String, ? extends List<String>> headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            this.headers = headers;
            return this;
        }

        public final Response build() {
            int i = this.code;
            String str = this.body;
            String str2 = this.message;
            long j = this.startTimeMillis;
            long j2 = this.endTimeMillis;
            Map<String, ? extends List<String>> mapEmptyMap = this.headers;
            if (mapEmptyMap == null) {
                mapEmptyMap = MapsKt__MapsKt.emptyMap();
            }
            return new Response(i, str, str2, j, j2, mapEmptyMap);
        }
    }
}
