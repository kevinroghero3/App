package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.fabric.mounting.SurfaceMountingManager;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.systrace.Systrace;
import com.google.firebase.perf.FirebasePerformance;
import com.google.maps.android.BuildConfig;

/* JADX INFO: loaded from: classes4.dex */
final class IntBufferBatchMountItem implements BatchMountItem {
    static final int INSTRUCTION_CREATE = 2;
    static final int INSTRUCTION_DELETE = 4;
    static final int INSTRUCTION_FLAG_MULTIPLE = 1;
    static final int INSTRUCTION_INSERT = 8;
    static final int INSTRUCTION_REMOVE = 16;
    static final int INSTRUCTION_UPDATE_EVENT_EMITTER = 256;
    static final int INSTRUCTION_UPDATE_LAYOUT = 128;
    static final int INSTRUCTION_UPDATE_OVERFLOW_INSET = 1024;
    static final int INSTRUCTION_UPDATE_PADDING = 512;
    static final int INSTRUCTION_UPDATE_PROPS = 32;
    static final int INSTRUCTION_UPDATE_STATE = 64;
    static final String TAG = "IntBufferBatchMountItem";
    private final int mCommitNumber;
    private final int[] mIntBuffer;
    private final int mIntBufferLen;
    private final Object[] mObjBuffer;
    private final int mObjBufferLen;
    private final int mSurfaceId;

    IntBufferBatchMountItem(int i, int[] iArr, Object[] objArr, int i2) {
        this.mSurfaceId = i;
        this.mCommitNumber = i2;
        this.mIntBuffer = iArr;
        this.mObjBuffer = objArr;
        this.mIntBufferLen = iArr.length;
        this.mObjBufferLen = objArr.length;
    }

    private void beginMarkers(String str) {
        Systrace.beginSection(0L, "IntBufferBatchMountItem::" + str);
        int i = this.mCommitNumber;
        if (i > 0) {
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_BATCH_EXECUTION_START, null, i);
        }
    }

    private void endMarkers() {
        int i = this.mCommitNumber;
        if (i > 0) {
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_BATCH_EXECUTION_END, null, i);
        }
        Systrace.endSection(0L);
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
    public void execute(MountingManager mountingManager) {
        int i;
        int i2;
        long j;
        int i3;
        SurfaceMountingManager surfaceManager = mountingManager.getSurfaceManager(this.mSurfaceId);
        if (surfaceManager == null) {
            FLog.e(TAG, "Skipping batch of MountItems; no SurfaceMountingManager found for [%d].", Integer.valueOf(this.mSurfaceId));
            return;
        }
        if (surfaceManager.isStopped()) {
            FLog.e(TAG, "Skipping batch of MountItems; was stopped [%d].", Integer.valueOf(this.mSurfaceId));
            return;
        }
        if (ReactNativeFeatureFlags.enableFabricLogs()) {
            FLog.d(TAG, "Executing IntBufferBatchMountItem on surface [%d]", Integer.valueOf(this.mSurfaceId));
        }
        beginMarkers("mountViews");
        int i4 = 0;
        int i5 = 0;
        while (i4 < this.mIntBufferLen) {
            int[] iArr = this.mIntBuffer;
            int i6 = i4 + 1;
            int i7 = iArr[i4];
            int i8 = i7 & (-2);
            if ((i7 & 1) != 0) {
                int i9 = iArr[i6];
                i6 = i4 + 2;
                i = i9;
            } else {
                i = 1;
            }
            long j2 = 0;
            Systrace.beginSection(0L, "IntBufferBatchMountItem::mountInstructions::" + nameForInstructionString(i8), new String[]{"numInstructions", String.valueOf(i)}, 2);
            int i10 = i5;
            int i11 = i6;
            int i12 = 0;
            while (i12 < i) {
                if (i8 == 2) {
                    String fabricComponentName = FabricNameComponentMapping.getFabricComponentName((String) this.mObjBuffer[i10]);
                    int[] iArr2 = this.mIntBuffer;
                    int i13 = iArr2[i11];
                    Object[] objArr = this.mObjBuffer;
                    int i14 = i10 + 4;
                    i2 = i12;
                    surfaceManager.createView(fabricComponentName, i13, (ReadableMap) objArr[i10 + 1], (StateWrapper) objArr[i10 + 2], (EventEmitterWrapper) objArr[i10 + 3], iArr2[i11 + 1] == 1);
                    i11 += 2;
                    i10 = i14;
                } else {
                    i2 = i12;
                    int i15 = i11;
                    if (i8 == 4) {
                        surfaceManager.deleteView(this.mIntBuffer[i15]);
                        i11 = i15 + 1;
                    } else if (i8 == 8) {
                        int[] iArr3 = this.mIntBuffer;
                        i11 = i15 + 3;
                        surfaceManager.addViewAt(iArr3[i15 + 1], iArr3[i15], iArr3[i15 + 2]);
                    } else if (i8 == 16) {
                        int[] iArr4 = this.mIntBuffer;
                        i11 = i15 + 3;
                        surfaceManager.removeViewAt(iArr4[i15], iArr4[i15 + 1], iArr4[i15 + 2]);
                    } else {
                        if (i8 == 32) {
                            i11 = i15 + 1;
                            i3 = i10 + 1;
                            surfaceManager.updateProps(this.mIntBuffer[i15], (ReadableMap) this.mObjBuffer[i10]);
                        } else {
                            if (i8 == 64) {
                                i11 = i15 + 1;
                                i3 = i10 + 1;
                                surfaceManager.updateState(this.mIntBuffer[i15], (StateWrapper) this.mObjBuffer[i10]);
                            } else if (i8 == 128) {
                                int[] iArr5 = this.mIntBuffer;
                                j = j2;
                                surfaceManager.updateLayout(iArr5[i15], iArr5[i15 + 1], iArr5[i15 + 2], iArr5[i15 + 3], iArr5[i15 + 4], iArr5[i15 + 5], iArr5[i15 + 6], iArr5[i15 + 7]);
                                i11 = i15 + 8;
                            } else {
                                j = j2;
                                if (i8 == 512) {
                                    int[] iArr6 = this.mIntBuffer;
                                    i11 = i15 + 5;
                                    surfaceManager.updatePadding(iArr6[i15], iArr6[i15 + 1], iArr6[i15 + 2], iArr6[i15 + 3], iArr6[i15 + 4]);
                                } else if (i8 == 1024) {
                                    int[] iArr7 = this.mIntBuffer;
                                    i11 = i15 + 5;
                                    surfaceManager.updateOverflowInset(iArr7[i15], iArr7[i15 + 1], iArr7[i15 + 2], iArr7[i15 + 3], iArr7[i15 + 4]);
                                } else if (i8 == 256) {
                                    surfaceManager.updateEventEmitter(this.mIntBuffer[i15], (EventEmitterWrapper) this.mObjBuffer[i10]);
                                    i11 = i15 + 1;
                                    i10++;
                                } else {
                                    throw new IllegalArgumentException("Invalid type argument to IntBufferBatchMountItem: " + i8 + " at index: " + i15);
                                }
                            }
                            i12 = i2 + 1;
                            j2 = j;
                        }
                        i10 = i3;
                    }
                }
                j = j2;
                i12 = i2 + 1;
                j2 = j;
            }
            Systrace.endSection(j2);
            i4 = i11;
            i5 = i10;
        }
        endMarkers();
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
    public int getSurfaceId() {
        return this.mSurfaceId;
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.BatchMountItem
    public boolean isBatchEmpty() {
        return this.mIntBufferLen == 0;
    }

    public String toString() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("IntBufferBatchMountItem [surface:%d]:\n", Integer.valueOf(this.mSurfaceId)));
            int i6 = 0;
            int i7 = 0;
            while (i6 < this.mIntBufferLen) {
                int[] iArr = this.mIntBuffer;
                int i8 = i6 + 1;
                int i9 = iArr[i6];
                int i10 = i9 & (-2);
                if ((i9 & 1) != 0) {
                    i = iArr[i8];
                    i8 = i6 + 2;
                } else {
                    i = 1;
                }
                i6 = i8;
                for (int i11 = 0; i11 < i; i11++) {
                    if (i10 == 2) {
                        String fabricComponentName = FabricNameComponentMapping.getFabricComponentName((String) this.mObjBuffer[i7]);
                        i7 += 4;
                        int[] iArr2 = this.mIntBuffer;
                        i5 = i6 + 2;
                        sb.append(String.format("CREATE [%d] - layoutable:%d - %s\n", Integer.valueOf(iArr2[i6]), Integer.valueOf(iArr2[i6 + 1]), fabricComponentName));
                    } else {
                        if (i10 == 4) {
                            sb.append(String.format("DELETE [%d]\n", Integer.valueOf(this.mIntBuffer[i6])));
                        } else if (i10 == 8) {
                            int[] iArr3 = this.mIntBuffer;
                            i5 = i6 + 3;
                            sb.append(String.format("INSERT [%d]->[%d] @%d\n", Integer.valueOf(iArr3[i6]), Integer.valueOf(iArr3[i6 + 1]), Integer.valueOf(iArr3[i6 + 2])));
                        } else {
                            if (i10 == 16) {
                                int[] iArr4 = this.mIntBuffer;
                                i5 = i6 + 3;
                                sb.append(String.format("REMOVE [%d]->[%d] @%d\n", Integer.valueOf(iArr4[i6]), Integer.valueOf(iArr4[i6 + 1]), Integer.valueOf(iArr4[i6 + 2])));
                            } else {
                                String string = "<null>";
                                if (i10 == 32) {
                                    i3 = i7 + 1;
                                    Object obj = this.mObjBuffer[i7];
                                    if (!FabricUIManager.IS_DEVELOPMENT_ENVIRONMENT) {
                                        string = "<hidden>";
                                    } else if (obj != null) {
                                        string = obj.toString();
                                    }
                                    i4 = i6 + 1;
                                    sb.append(String.format("UPDATE PROPS [%d]: %s\n", Integer.valueOf(this.mIntBuffer[i6]), string));
                                } else if (i10 == 64) {
                                    i3 = i7 + 1;
                                    StateWrapper stateWrapper = (StateWrapper) this.mObjBuffer[i7];
                                    if (!FabricUIManager.IS_DEVELOPMENT_ENVIRONMENT) {
                                        string = "<hidden>";
                                    } else if (stateWrapper != null) {
                                        string = stateWrapper.toString();
                                    }
                                    i4 = i6 + 1;
                                    sb.append(String.format("UPDATE STATE [%d]: %s\n", Integer.valueOf(this.mIntBuffer[i6]), string));
                                } else if (i10 == 128) {
                                    int[] iArr5 = this.mIntBuffer;
                                    sb.append(String.format("UPDATE LAYOUT [%d]->[%d]: x:%d y:%d w:%d h:%d displayType:%d layoutDirection: %d\n", Integer.valueOf(iArr5[i6 + 1]), Integer.valueOf(iArr5[i6]), Integer.valueOf(iArr5[i6 + 2]), Integer.valueOf(iArr5[i6 + 3]), Integer.valueOf(iArr5[i6 + 4]), Integer.valueOf(iArr5[i6 + 5]), Integer.valueOf(iArr5[i6 + 6]), Integer.valueOf(iArr5[i6 + 7])));
                                    i6 += 8;
                                } else {
                                    if (i10 == 512) {
                                        int[] iArr6 = this.mIntBuffer;
                                        i2 = i6 + 5;
                                        sb.append(String.format("UPDATE PADDING [%d]: top:%d right:%d bottom:%d left:%d\n", Integer.valueOf(iArr6[i6]), Integer.valueOf(iArr6[i6 + 1]), Integer.valueOf(iArr6[i6 + 2]), Integer.valueOf(iArr6[i6 + 3]), Integer.valueOf(iArr6[i6 + 4])));
                                    } else if (i10 == 1024) {
                                        int[] iArr7 = this.mIntBuffer;
                                        i2 = i6 + 5;
                                        sb.append(String.format("UPDATE OVERFLOWINSET [%d]: left:%d top:%d right:%d bottom:%d\n", Integer.valueOf(iArr7[i6]), Integer.valueOf(iArr7[i6 + 1]), Integer.valueOf(iArr7[i6 + 2]), Integer.valueOf(iArr7[i6 + 3]), Integer.valueOf(iArr7[i6 + 4])));
                                    } else {
                                        if (i10 != 256) {
                                            FLog.e(TAG, "String so far: " + sb.toString());
                                            throw new IllegalArgumentException("Invalid type argument to IntBufferBatchMountItem: " + i10 + " at index: " + i6);
                                        }
                                        i7++;
                                        sb.append(String.format("UPDATE EVENTEMITTER [%d]\n", Integer.valueOf(this.mIntBuffer[i6])));
                                    }
                                    i6 = i2;
                                }
                                i6 = i4;
                                i7 = i3;
                            }
                        }
                        i6++;
                    }
                    i6 = i5;
                }
            }
            return sb.toString();
        } catch (Exception e) {
            FLog.e(TAG, "Caught exception trying to print", e);
            StringBuilder sb2 = new StringBuilder();
            for (int i12 = 0; i12 < this.mIntBufferLen; i12++) {
                sb2.append(this.mIntBuffer[i12]);
                sb2.append(", ");
            }
            FLog.e(TAG, sb2.toString());
            for (int i13 = 0; i13 < this.mObjBufferLen; i13++) {
                String str = TAG;
                Object obj2 = this.mObjBuffer[i13];
                FLog.e(str, obj2 != null ? obj2.toString() : BuildConfig.TRAVIS);
            }
            return "";
        }
    }

    private static String nameForInstructionString(int i) {
        if (i == 2) {
            return "CREATE";
        }
        if (i == 4) {
            return FirebasePerformance.HttpMethod.DELETE;
        }
        if (i == 8) {
            return "INSERT";
        }
        if (i == 16) {
            return "REMOVE";
        }
        if (i == 32) {
            return "UPDATE_PROPS";
        }
        if (i == 64) {
            return "UPDATE_STATE";
        }
        if (i == 128) {
            return "UPDATE_LAYOUT";
        }
        if (i == 512) {
            return "UPDATE_PADDING";
        }
        if (i == 1024) {
            return "UPDATE_OVERFLOW_INSET";
        }
        if (i == 256) {
            return "UPDATE_EVENT_EMITTER";
        }
        return "UNKNOWN";
    }
}
