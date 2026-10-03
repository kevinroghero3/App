package com.facebook.appevents.ml;

import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class Model {
    private static final int SEQ_LEN = 128;
    private final MTensor convs0Bias;
    private final MTensor convs0Weight;
    private final MTensor convs1Bias;
    private final MTensor convs1Weight;
    private final MTensor convs2Bias;
    private final MTensor convs2Weight;
    private final MTensor embedding;
    private final MTensor fc1Bias;
    private final MTensor fc1Weight;
    private final MTensor fc2Bias;
    private final MTensor fc2Weight;
    private final Map<String, MTensor> finalWeights;
    public static final Companion Companion = new Companion(null);
    private static final Map<String, String> mapping = MapsKt__MapsKt.hashMapOf(TuplesKt.to("embedding.weight", "embed.weight"), TuplesKt.to("dense1.weight", "fc1.weight"), TuplesKt.to("dense2.weight", "fc2.weight"), TuplesKt.to("dense3.weight", "fc3.weight"), TuplesKt.to("dense1.bias", "fc1.bias"), TuplesKt.to("dense2.bias", "fc2.bias"), TuplesKt.to("dense3.bias", "fc3.bias"));

    public /* synthetic */ Model(Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(map);
    }

    private Model(Map<String, MTensor> map) {
        MTensor mTensor = map.get("embed.weight");
        if (mTensor == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.embedding = mTensor;
        MTensor mTensor2 = map.get("convs.0.weight");
        if (mTensor2 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.convs0Weight = Operator.transpose3D(mTensor2);
        MTensor mTensor3 = map.get("convs.1.weight");
        if (mTensor3 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.convs1Weight = Operator.transpose3D(mTensor3);
        MTensor mTensor4 = map.get("convs.2.weight");
        if (mTensor4 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.convs2Weight = Operator.transpose3D(mTensor4);
        MTensor mTensor5 = map.get("convs.0.bias");
        if (mTensor5 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.convs0Bias = mTensor5;
        MTensor mTensor6 = map.get("convs.1.bias");
        if (mTensor6 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.convs1Bias = mTensor6;
        MTensor mTensor7 = map.get("convs.2.bias");
        if (mTensor7 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.convs2Bias = mTensor7;
        MTensor mTensor8 = map.get("fc1.weight");
        if (mTensor8 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.fc1Weight = Operator.transpose2D(mTensor8);
        MTensor mTensor9 = map.get("fc2.weight");
        if (mTensor9 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.fc2Weight = Operator.transpose2D(mTensor9);
        MTensor mTensor10 = map.get("fc1.bias");
        if (mTensor10 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.fc1Bias = mTensor10;
        MTensor mTensor11 = map.get("fc2.bias");
        if (mTensor11 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.fc2Bias = mTensor11;
        this.finalWeights = new HashMap();
        for (String str : SetsKt__SetsKt.setOf((Object[]) new String[]{ModelManager.Task.MTML_INTEGRITY_DETECT.toKey(), ModelManager.Task.MTML_APP_EVENT_PREDICTION.toKey()})) {
            String str2 = str + ".weight";
            String str3 = str + ".bias";
            MTensor mTensor12 = map.get(str2);
            MTensor mTensor13 = map.get(str3);
            if (mTensor12 != null) {
                this.finalWeights.put(str2, Operator.transpose2D(mTensor12));
            }
            if (mTensor13 != null) {
                this.finalWeights.put(str3, mTensor13);
            }
        }
    }

    public static final /* synthetic */ Map access$getMapping$cp() {
        if (CrashShieldHandler.isObjectCrashing(Model.class)) {
            return null;
        }
        try {
            return mapping;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Model.class);
            return null;
        }
    }

    public final MTensor predictOnMTML(@NotNull MTensor dense, @NotNull String[] texts, @NotNull String task) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(dense, "dense");
            Intrinsics.checkNotNullParameter(texts, "texts");
            Intrinsics.checkNotNullParameter(task, "task");
            MTensor mTensorConv1D = Operator.conv1D(Operator.embedding(texts, 128, this.embedding), this.convs0Weight);
            Operator.addmv(mTensorConv1D, this.convs0Bias);
            Operator.relu(mTensorConv1D);
            MTensor mTensorConv1D2 = Operator.conv1D(mTensorConv1D, this.convs1Weight);
            Operator.addmv(mTensorConv1D2, this.convs1Bias);
            Operator.relu(mTensorConv1D2);
            MTensor mTensorMaxPool1D = Operator.maxPool1D(mTensorConv1D2, 2);
            MTensor mTensorConv1D3 = Operator.conv1D(mTensorMaxPool1D, this.convs2Weight);
            Operator.addmv(mTensorConv1D3, this.convs2Bias);
            Operator.relu(mTensorConv1D3);
            MTensor mTensorMaxPool1D2 = Operator.maxPool1D(mTensorConv1D, mTensorConv1D.getShape(1));
            MTensor mTensorMaxPool1D3 = Operator.maxPool1D(mTensorMaxPool1D, mTensorMaxPool1D.getShape(1));
            MTensor mTensorMaxPool1D4 = Operator.maxPool1D(mTensorConv1D3, mTensorConv1D3.getShape(1));
            Operator.flatten(mTensorMaxPool1D2, 1);
            Operator.flatten(mTensorMaxPool1D3, 1);
            Operator.flatten(mTensorMaxPool1D4, 1);
            MTensor mTensorDense = Operator.dense(Operator.concatenate(new MTensor[]{mTensorMaxPool1D2, mTensorMaxPool1D3, mTensorMaxPool1D4, dense}), this.fc1Weight, this.fc1Bias);
            Operator.relu(mTensorDense);
            MTensor mTensorDense2 = Operator.dense(mTensorDense, this.fc2Weight, this.fc2Bias);
            Operator.relu(mTensorDense2);
            MTensor mTensor = this.finalWeights.get(task + ".weight");
            MTensor mTensor2 = this.finalWeights.get(task + ".bias");
            if (mTensor != null && mTensor2 != null) {
                MTensor mTensorDense3 = Operator.dense(mTensorDense2, mTensor, mTensor2);
                Operator.softmax(mTensorDense3);
                return mTensorDense3;
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Model build(@NotNull File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            Map<String, MTensor> map = parse(file);
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (map == null) {
                return null;
            }
            try {
                return new Model(map, defaultConstructorMarker);
            } catch (Exception unused) {
                return null;
            }
        }

        private final Map<String, MTensor> parse(File file) {
            Map<String, MTensor> modelWeights = Utils.parseModelWeights(file);
            if (modelWeights == null) {
                return null;
            }
            HashMap map = new HashMap();
            Map mapAccess$getMapping$cp = Model.access$getMapping$cp();
            for (Map.Entry<String, MTensor> entry : modelWeights.entrySet()) {
                String key = entry.getKey();
                if (mapAccess$getMapping$cp.containsKey(entry.getKey()) && (key = (String) mapAccess$getMapping$cp.get(entry.getKey())) == null) {
                    return null;
                }
                map.put(key, entry.getValue());
            }
            return map;
        }
    }
}
