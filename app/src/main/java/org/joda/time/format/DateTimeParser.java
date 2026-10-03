package org.joda.time.format;

/* JADX INFO: loaded from: classes3.dex */
public interface DateTimeParser {
    int estimateParsedLength();

    int parseInto(DateTimeParserBucket dateTimeParserBucket, String str, int i);
}
