package com.google.gson.internal.sql;

import android.os.Process;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes3.dex */
public final class SqlDateTypeAdapter extends TypeAdapter<Date> {
    static final TypeAdapterFactory FACTORY = new AnonymousClass1();
    private final DateFormat format;

    /* synthetic */ SqlDateTypeAdapter(AnonymousClass1 anonymousClass1) {
        this();
    }

    /* JADX INFO: renamed from: com.google.gson.internal.sql.SqlDateTypeAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements TypeAdapterFactory {
        public static int MediaBrowserCompatMediaBrowserImplBase3;
        public static int MediaBrowserCompatMediaBrowserImplBase5;

        AnonymousClass1() {
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            AnonymousClass1 anonymousClass1 = null;
            if (typeToken.getRawType() == Date.class) {
                return new SqlDateTypeAdapter(anonymousClass1);
            }
            return null;
        }

        public static int INotificationSideChannel() {
            int i = MediaBrowserCompatMediaBrowserImplBase3;
            int i2 = i % 7138551;
            MediaBrowserCompatMediaBrowserImplBase3 = i + 1;
            if (i2 != 0) {
                return MediaBrowserCompatMediaBrowserImplBase5;
            }
            int iMyUid = Process.myUid();
            MediaBrowserCompatMediaBrowserImplBase5 = iMyUid;
            return iMyUid;
        }
    }

    private SqlDateTypeAdapter() {
        this.format = new SimpleDateFormat("MMM d, yyyy");
    }

    @Override // com.google.gson.TypeAdapter
    public Date read(JsonReader jsonReader) throws IOException {
        Date date;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        String strNextString = jsonReader.nextString();
        synchronized (this) {
            TimeZone timeZone = this.format.getTimeZone();
            try {
                try {
                    date = new Date(this.format.parse(strNextString).getTime());
                    this.format.setTimeZone(timeZone);
                } catch (ParseException e) {
                    throw new JsonSyntaxException("Failed parsing '" + strNextString + "' as SQL Date; at path " + jsonReader.getPreviousPath(), e);
                }
            } catch (Throwable th) {
                this.format.setTimeZone(timeZone);
                throw th;
            }
        }
        return date;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Date date) throws IOException {
        String str;
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        synchronized (this) {
            str = this.format.format((java.util.Date) date);
        }
        jsonWriter.value(str);
    }
}
