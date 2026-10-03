package com.rnmaps.maps;

import android.content.Context;
import android.content.res.AssetManager;
import android.media.AudioTrack;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.TileProvider;
import io.sentry.instrumentation.file.SentryFileInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;

/* JADX INFO: loaded from: classes3.dex */
public class MapLocalTile extends MapFeature {
    private String pathTemplate;
    private TileOverlay tileOverlay;
    private TileOverlayOptions tileOverlayOptions;
    private AIRMapLocalTileProvider tileProvider;
    private float tileSize;
    private boolean useAssets;
    private float zIndex;

    class AIRMapLocalTileProvider implements TileProvider {
        private static final int BUFFER_SIZE = 16384;
        private static int artificialFrame = 1;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
        private String pathTemplate;
        private int tileSize;
        private final boolean useAssets;

        public AIRMapLocalTileProvider(int i, String str, boolean z) {
            this.tileSize = i;
            this.pathTemplate = str;
            this.useAssets = z;
        }

        @Override // com.google.android.gms.maps.model.TileProvider
        public Tile getTile(int i, int i2, int i3) throws Throwable {
            byte[] tileImage = readTileImage(i, i2, i3);
            if (tileImage == null) {
                return TileProvider.NO_TILE;
            }
            int i4 = this.tileSize;
            return new Tile(i4, i4, tileImage);
        }

        public void setPathTemplate(String str) {
            this.pathTemplate = str;
        }

        public void setTileSize(int i) {
            this.tileSize = i;
        }

        /* JADX WARN: Code duplicated, block: B:90:0x012a A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:99:0x012f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v12, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r13v13, types: [java.lang.Object, java.lang.String] */
        /* JADX WARN: Type inference failed for: r13v15, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r13v2 */
        /* JADX WARN: Type inference failed for: r13v24 */
        /* JADX WARN: Type inference failed for: r13v25 */
        /* JADX WARN: Type inference failed for: r13v5 */
        /* JADX WARN: Type inference failed for: r13v7, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r14v0, types: [int] */
        /* JADX WARN: Type inference failed for: r14v1 */
        /* JADX WARN: Type inference failed for: r14v11 */
        /* JADX WARN: Type inference failed for: r14v3, types: [java.io.ByteArrayOutputStream] */
        private byte[] readTileImage(int i, int i2, int i3) throws Throwable {
            Throwable th;
            ?? tileFilename;
            Throwable e;
            ByteArrayOutputStream byteArrayOutputStream;
            int i4 = 2 % 2;
            int i5 = artificialFrame + 101;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i5 % 128;
            try {
                if (i5 % 2 != 0) {
                    getTileFilename(i, i2, i3);
                    throw null;
                }
                tileFilename = getTileFilename(i, i2, i3);
                try {
                    if (this.useAssets) {
                        int i6 = getARTIFICIAL_FRAME_PACKAGE_NAME + 99;
                        artificialFrame = i6 % 128;
                        if (i6 % 2 == 0) {
                            try {
                                Object[] objArr = {MapLocalTile.this.getContext().getAssets(), tileFilename};
                                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-982065286);
                                if (objAccessartificialFrame == null) {
                                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(ExpandableListView.getPackedPositionGroup(0L) + 12, (char) (7115 - TextUtils.lastIndexOf("", '0')), 37 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 1511233906, false, "accessartificialFrame", new Class[]{AssetManager.class, String.class});
                                }
                                throw null;
                            } catch (Throwable th2) {
                                Throwable cause = th2.getCause();
                                if (cause != null) {
                                    throw cause;
                                }
                                throw th2;
                            }
                        }
                        try {
                            Object[] objArr2 = {MapLocalTile.this.getContext().getAssets(), tileFilename};
                            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-982065286);
                            if (objAccessartificialFrame2 == null) {
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(12 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (7117 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), 38 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 1511233906, false, "accessartificialFrame", new Class[]{AssetManager.class, String.class});
                            }
                            tileFilename = (InputStream) ((Method) objAccessartificialFrame2).invoke(null, objArr2);
                        } catch (Throwable th3) {
                            Throwable cause2 = th3.getCause();
                            if (cause2 != null) {
                                throw cause2;
                            }
                            throw th3;
                        }
                    } else {
                        FileInputStream fileInputStreamCreate = SentryFileInputStream.Factory.create(new FileInputStream((String) tileFilename), (String) tileFilename);
                        int i7 = artificialFrame + 39;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i7 % 128;
                        int i8 = i7 % 2;
                        tileFilename = fileInputStreamCreate;
                    }
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            byte[] bArr = new byte[16384];
                            while (true) {
                                int i9 = tileFilename.read(bArr, 0, 16384);
                                if (i9 == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, i9);
                            }
                            byteArrayOutputStream.flush();
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            try {
                                tileFilename.close();
                            } catch (Exception unused) {
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused2) {
                            }
                            return byteArray;
                        } catch (IOException e2) {
                            e = e2;
                            e.printStackTrace();
                            if (tileFilename != 0) {
                                try {
                                    tileFilename.close();
                                } catch (Exception unused3) {
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Exception unused4) {
                                }
                            }
                            return null;
                        } catch (OutOfMemoryError e3) {
                            e = e3;
                            e.printStackTrace();
                            if (tileFilename != 0) {
                                tileFilename.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            return null;
                        }
                    } catch (IOException e4) {
                        e = e4;
                        e = e;
                        byteArrayOutputStream = null;
                        e.printStackTrace();
                        if (tileFilename != 0) {
                            tileFilename.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return null;
                    } catch (OutOfMemoryError e5) {
                        e = e5;
                        e = e;
                        byteArrayOutputStream = null;
                        e.printStackTrace();
                        if (tileFilename != 0) {
                            tileFilename.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return null;
                    } catch (Throwable th4) {
                        th = th4;
                        i2 = 0;
                        if (tileFilename != 0) {
                            try {
                                tileFilename.close();
                            } catch (Exception unused5) {
                            }
                        }
                        if (i2 == 0) {
                            throw th;
                        }
                        int i10 = artificialFrame + 13;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i10 % 128;
                        try {
                            if (i10 % 2 == 0) {
                                i2.close();
                                throw th;
                            }
                            i2.close();
                            try {
                                throw null;
                            } catch (Throwable th5) {
                                throw th5;
                            }
                        } catch (Exception unused6) {
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (IOException e6) {
                e = e6;
                e = e;
                tileFilename = 0;
                byteArrayOutputStream = null;
                e.printStackTrace();
                if (tileFilename != 0) {
                    tileFilename.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return null;
            } catch (OutOfMemoryError e7) {
                e = e7;
                e = e;
                tileFilename = 0;
                byteArrayOutputStream = null;
                e.printStackTrace();
                if (tileFilename != 0) {
                    tileFilename.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return null;
            } catch (Throwable th7) {
                th = th7;
                tileFilename = 0;
                i2 = 0;
            }
        }

        private String getTileFilename(int i, int i2, int i3) {
            return this.pathTemplate.replace("{x}", Integer.toString(i)).replace("{y}", Integer.toString(i2)).replace("{z}", Integer.toString(i3));
        }
    }

    public MapLocalTile(Context context) {
        super(context);
    }

    public void setPathTemplate(String str) {
        this.pathTemplate = str;
        AIRMapLocalTileProvider aIRMapLocalTileProvider = this.tileProvider;
        if (aIRMapLocalTileProvider != null) {
            aIRMapLocalTileProvider.setPathTemplate(str);
        }
        TileOverlay tileOverlay = this.tileOverlay;
        if (tileOverlay != null) {
            tileOverlay.clearTileCache();
        }
    }

    public void setZIndex(float f) {
        this.zIndex = f;
        TileOverlay tileOverlay = this.tileOverlay;
        if (tileOverlay != null) {
            tileOverlay.setZIndex(f);
        }
    }

    public void setTileSize(float f) {
        this.tileSize = f;
        AIRMapLocalTileProvider aIRMapLocalTileProvider = this.tileProvider;
        if (aIRMapLocalTileProvider != null) {
            aIRMapLocalTileProvider.setTileSize((int) f);
        }
    }

    public void setUseAssets(boolean z) {
        this.useAssets = z;
    }

    public TileOverlayOptions getTileOverlayOptions() {
        if (this.tileOverlayOptions == null) {
            this.tileOverlayOptions = createTileOverlayOptions();
        }
        return this.tileOverlayOptions;
    }

    private TileOverlayOptions createTileOverlayOptions() {
        TileOverlayOptions tileOverlayOptions = new TileOverlayOptions();
        tileOverlayOptions.zIndex(this.zIndex);
        AIRMapLocalTileProvider aIRMapLocalTileProvider = new AIRMapLocalTileProvider((int) this.tileSize, this.pathTemplate, this.useAssets);
        this.tileProvider = aIRMapLocalTileProvider;
        tileOverlayOptions.tileProvider(aIRMapLocalTileProvider);
        return tileOverlayOptions;
    }

    @Override // com.rnmaps.maps.MapFeature
    public Object getFeature() {
        return this.tileOverlay;
    }

    @Override // com.rnmaps.maps.MapFeature
    public void addToMap(Object obj) {
        this.tileOverlay = ((GoogleMap) obj).addTileOverlay(getTileOverlayOptions());
    }

    @Override // com.rnmaps.maps.MapFeature
    public void removeFromMap(Object obj) {
        this.tileOverlay.remove();
    }
}
