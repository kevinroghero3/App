package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ConfigStorageClient {
    private static final String JSON_STRING_ENCODING = "UTF-8";
    private static final Map<String, ConfigStorageClient> clientInstances = new HashMap();
    private final Context context;
    private final String fileName;

    private ConfigStorageClient(Context context, String str) {
        this.context = context;
        this.fileName = str;
    }

    public Void write(ConfigContainer configContainer) throws IOException {
        synchronized (this) {
            FileOutputStream fileOutputStreamOpenFileOutput = this.context.openFileOutput(this.fileName, 0);
            try {
                fileOutputStreamOpenFileOutput.write(configContainer.toString().getBytes("UTF-8"));
                fileOutputStreamOpenFileOutput.close();
            } catch (Throwable th) {
                fileOutputStreamOpenFileOutput.close();
                throw th;
            }
        }
        return null;
    }

    @Nullable
    public ConfigContainer read() throws IOException {
        FileInputStream fileInputStreamOpenFileInput;
        synchronized (this) {
            FileInputStream fileInputStream = null;
            try {
                try {
                    fileInputStreamOpenFileInput = this.context.openFileInput(this.fileName);
                    try {
                        int iAvailable = fileInputStreamOpenFileInput.available();
                        byte[] bArr = new byte[iAvailable];
                        fileInputStreamOpenFileInput.read(bArr, 0, iAvailable);
                        ConfigContainer configContainerCopyOf = ConfigContainer.copyOf(new JSONObject(new String(bArr, "UTF-8")));
                        fileInputStreamOpenFileInput.close();
                        return configContainerCopyOf;
                    } catch (FileNotFoundException | JSONException unused) {
                        if (fileInputStreamOpenFileInput != null) {
                            fileInputStreamOpenFileInput.close();
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStreamOpenFileInput;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                } catch (FileNotFoundException | JSONException unused2) {
                    fileInputStreamOpenFileInput = null;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public Void clear() {
        synchronized (this) {
            this.context.deleteFile(this.fileName);
        }
        return null;
    }

    public static ConfigStorageClient getInstance(Context context, String str) {
        ConfigStorageClient configStorageClient;
        synchronized (ConfigStorageClient.class) {
            Map<String, ConfigStorageClient> map = clientInstances;
            if (!map.containsKey(str)) {
                map.put(str, new ConfigStorageClient(context, str));
            }
            configStorageClient = map.get(str);
        }
        return configStorageClient;
    }

    public static void clearInstancesForTest() {
        synchronized (ConfigStorageClient.class) {
            clientInstances.clear();
        }
    }

    String getFileName() {
        return this.fileName;
    }
}
