package io.sentry;

import java.io.IOException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public interface ObjectWriter {
    ObjectWriter beginArray() throws IOException;

    ObjectWriter beginObject() throws IOException;

    ObjectWriter endArray() throws IOException;

    ObjectWriter endObject() throws IOException;

    String getIndent();

    ObjectWriter jsonValue(@Nullable String str) throws IOException;

    ObjectWriter name(@NotNull String str) throws IOException;

    ObjectWriter nullValue() throws IOException;

    void setIndent(@Nullable String str);

    void setLenient(boolean z);

    ObjectWriter value(double d) throws IOException;

    ObjectWriter value(long j) throws IOException;

    ObjectWriter value(@NotNull ILogger iLogger, @Nullable Object obj) throws IOException;

    ObjectWriter value(@Nullable Boolean bool) throws IOException;

    ObjectWriter value(@Nullable Number number) throws IOException;

    ObjectWriter value(@Nullable String str) throws IOException;

    ObjectWriter value(boolean z) throws IOException;
}
