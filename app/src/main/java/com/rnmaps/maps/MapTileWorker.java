package com.rnmaps.maps;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import io.sentry.instrumentation.file.SentryFileOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public class MapTileWorker extends Worker {
    private static final int BUFFER_SIZE = 16384;

    public MapTileWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() throws Throwable {
        String string = getInputData().getString("filename");
        try {
            int i = getInputData().getInt("maxAge", 0);
            if (i >= 0) {
                if ((System.currentTimeMillis() - new File(string).lastModified()) / 1000 < i) {
                    return ListenableWorker.Result.failure();
                }
            }
            try {
                byte[] bArrFetchTile = fetchTile(new URL(getInputData().getString("url")));
                if (bArrFetchTile != null) {
                    if (!writeTileImage(bArrFetchTile, string)) {
                        return ListenableWorker.Result.failure();
                    }
                    Log.d("urlTile", "Worker fetched " + string);
                    return ListenableWorker.Result.success();
                }
                return ListenableWorker.Result.retry();
            } catch (MalformedURLException e) {
                throw new AssertionError(e);
            }
        } catch (Error unused) {
            return ListenableWorker.Result.failure();
        }
    }

    /* JADX WARN: Code duplicated, block: B:49:0x004c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x0047 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v5 */
    private byte[] fetchTile(URL url) throws Throwable {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable e;
        InputStream inputStreamOpenStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        ?? r0 = 0;
        try {
            try {
                inputStreamOpenStream = FirebasePerfUrlConnection.openStream(url);
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[16384];
                        while (true) {
                            int i = inputStreamOpenStream.read(bArr, 0, 16384);
                            if (i == -1) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr, 0, i);
                        }
                        byteArrayOutputStream2.flush();
                        byte[] byteArray = byteArrayOutputStream2.toByteArray();
                        try {
                            inputStreamOpenStream.close();
                        } catch (Exception unused) {
                        }
                        try {
                            byteArrayOutputStream2.close();
                        } catch (Exception unused2) {
                        }
                        return byteArray;
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                        if (inputStreamOpenStream != null) {
                            try {
                                inputStreamOpenStream.close();
                            } catch (Exception unused3) {
                            }
                        }
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (Exception unused4) {
                            }
                        }
                        return null;
                    } catch (OutOfMemoryError e3) {
                        e = e3;
                        e.printStackTrace();
                        if (inputStreamOpenStream != null) {
                            inputStreamOpenStream.close();
                        }
                        if (byteArrayOutputStream2 != null) {
                            byteArrayOutputStream2.close();
                        }
                        return null;
                    }
                } catch (IOException e4) {
                    e = e4;
                    e = e;
                    byteArrayOutputStream2 = null;
                    e.printStackTrace();
                    if (inputStreamOpenStream != null) {
                        inputStreamOpenStream.close();
                    }
                    if (byteArrayOutputStream2 != null) {
                        byteArrayOutputStream2.close();
                    }
                    return null;
                } catch (OutOfMemoryError e5) {
                    e = e5;
                    e = e;
                    byteArrayOutputStream2 = null;
                    e.printStackTrace();
                    if (inputStreamOpenStream != null) {
                        inputStreamOpenStream.close();
                    }
                    if (byteArrayOutputStream2 != null) {
                        byteArrayOutputStream2.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    r0 = inputStreamOpenStream;
                    th = th2;
                    byteArrayOutputStream = null;
                    if (r0 != 0) {
                        try {
                            r0.close();
                        } catch (Exception unused5) {
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                            throw th;
                        } catch (Exception unused6) {
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
                e = e;
                inputStreamOpenStream = null;
                byteArrayOutputStream2 = null;
                e.printStackTrace();
                if (inputStreamOpenStream != null) {
                    inputStreamOpenStream.close();
                }
                if (byteArrayOutputStream2 != null) {
                    byteArrayOutputStream2.close();
                }
                return null;
            } catch (OutOfMemoryError e7) {
                e = e7;
                e = e;
                inputStreamOpenStream = null;
                byteArrayOutputStream2 = null;
                e.printStackTrace();
                if (inputStreamOpenStream != null) {
                    inputStreamOpenStream.close();
                }
                if (byteArrayOutputStream2 != null) {
                    byteArrayOutputStream2.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th4) {
            r0 = url;
            th = th4;
        }
    }

    private boolean writeTileImage(byte[] bArr, String str) {
        if (str == null) {
            return false;
        }
        FileOutputStream fileOutputStreamCreate = null;
        try {
            try {
                File file = new File(str);
                file.getParentFile().mkdirs();
                fileOutputStreamCreate = SentryFileOutputStream.Factory.create(new FileOutputStream(file), file);
                fileOutputStreamCreate.write(bArr);
                try {
                    fileOutputStreamCreate.close();
                    return true;
                } catch (Exception unused) {
                    return true;
                }
            } catch (IOException | OutOfMemoryError e) {
                e.printStackTrace();
                if (fileOutputStreamCreate != null) {
                    try {
                        fileOutputStreamCreate.close();
                    } catch (Exception unused2) {
                    }
                }
                return false;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    fileOutputStreamCreate.close();
                } catch (Exception unused3) {
                }
            }
            throw th;
        }
    }
}
