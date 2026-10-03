package com.imagepicker;

import android.content.Context;
import android.net.Uri;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class VideoMetadata extends Metadata {
    private int bitrate;
    private int duration;

    public VideoMetadata(Uri uri, Context context) {
        try {
            CustomMediaMetadataRetriever customMediaMetadataRetriever = new CustomMediaMetadataRetriever();
            try {
                customMediaMetadataRetriever.setDataSource(context, uri);
                String strExtractMetadata = customMediaMetadataRetriever.extractMetadata(9);
                String strExtractMetadata2 = customMediaMetadataRetriever.extractMetadata(20);
                String strExtractMetadata3 = customMediaMetadataRetriever.extractMetadata(5);
                if (strExtractMetadata != null) {
                    this.duration = Math.round(Float.parseFloat(strExtractMetadata)) / 1000;
                }
                if (strExtractMetadata2 != null) {
                    this.bitrate = Integer.parseInt(strExtractMetadata2);
                }
                int i = 0;
                if (strExtractMetadata3 != null) {
                    this.datetime = getDateTimeInUTC(strExtractMetadata3.substring(0, strExtractMetadata3.indexOf(".")) + "+GMT", "yyyyMMdd'T'HHmmss+zzz");
                }
                String strExtractMetadata4 = customMediaMetadataRetriever.extractMetadata(18);
                String strExtractMetadata5 = customMediaMetadataRetriever.extractMetadata(19);
                if (strExtractMetadata5 != null && strExtractMetadata4 != null) {
                    String strExtractMetadata6 = customMediaMetadataRetriever.extractMetadata(24);
                    if (strExtractMetadata6 != null) {
                        i = Integer.parseInt(strExtractMetadata6);
                    }
                    if (i == 90 || i == 270) {
                        this.width = Integer.parseInt(strExtractMetadata5);
                        this.height = Integer.parseInt(strExtractMetadata4);
                    } else {
                        this.width = Integer.parseInt(strExtractMetadata4);
                        this.height = Integer.parseInt(strExtractMetadata5);
                    }
                }
                customMediaMetadataRetriever.close();
            } catch (Throwable th) {
                try {
                    customMediaMetadataRetriever.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getBitrate() {
        return this.bitrate;
    }

    public int getDuration() {
        return this.duration;
    }

    @Override // com.imagepicker.Metadata
    public String getDateTime() {
        return this.datetime;
    }

    @Override // com.imagepicker.Metadata
    public int getWidth() {
        return this.width;
    }

    @Override // com.imagepicker.Metadata
    public int getHeight() {
        return this.height;
    }
}
