package com.alpha0010.fs;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReadableMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FileAccessSpec extends ReactContextBaseJavaModule {
    public abstract void addListener(@NotNull String str);

    public abstract void appendFile(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Promise promise);

    public abstract void cancelFetch(double d, @NotNull Promise promise);

    public abstract void concatFiles(@NotNull String str, @NotNull String str2, @NotNull Promise promise);

    public abstract void cp(@NotNull String str, @NotNull String str2, @NotNull Promise promise);

    public abstract void cpAsset(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Promise promise);

    public abstract void cpExternal(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Promise promise);

    public abstract void df(@NotNull Promise promise);

    public abstract void exists(@NotNull String str, @NotNull Promise promise);

    public abstract void fetch(double d, @NotNull String str, @NotNull ReadableMap readableMap);

    public abstract void getAppGroupDir(@NotNull String str, @NotNull Promise promise);

    protected abstract Map<String, String> getTypedExportedConstants();

    public abstract void hardlink(@NotNull String str, @NotNull String str2, @NotNull Promise promise);

    public abstract void hash(@NotNull String str, @NotNull String str2, @NotNull Promise promise);

    public abstract void isDir(@NotNull String str, @NotNull Promise promise);

    public abstract void ls(@NotNull String str, @NotNull Promise promise);

    public abstract void mkdir(@NotNull String str, @NotNull Promise promise);

    public abstract void mv(@NotNull String str, @NotNull String str2, @NotNull Promise promise);

    public abstract void readFile(@NotNull String str, @NotNull String str2, @NotNull Promise promise);

    public abstract void readFileChunk(@NotNull String str, double d, double d2, @NotNull String str2, @NotNull Promise promise);

    public abstract void removeListeners(double d);

    public abstract void stat(@NotNull String str, @NotNull Promise promise);

    public abstract void statDir(@NotNull String str, @NotNull Promise promise);

    public abstract void symlink(@NotNull String str, @NotNull String str2, @NotNull Promise promise);

    public abstract void unlink(@NotNull String str, @NotNull Promise promise);

    public abstract void unzip(@NotNull String str, @NotNull String str2, @NotNull Promise promise);

    public abstract void writeFile(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Promise promise);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileAccessSpec(@NotNull ReactApplicationContext context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, String> getConstants() {
        return getTypedExportedConstants();
    }
}
