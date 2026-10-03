package com.guhungry.photomanipulator.helper;

import java.io.File;
import java.io.FileOutputStream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public interface AndroidFile {
    File createTempFile(@NotNull String str, @Nullable String str2, @Nullable File file);

    FileOutputStream makeFileOutputStream(@NotNull File file);
}
