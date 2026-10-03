package it.aep_italia.vts.sdk.internal.database.images;

import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface ImageDao {
    void deleteImages(List<StoredImage> list);

    List<StoredImage> readByNotUsedSince(long j);

    StoredImage readByVTokenUID(long j);

    int readTotalSize();

    void saveImage(StoredImage storedImage);

    void updateImage(StoredImage storedImage);
}
