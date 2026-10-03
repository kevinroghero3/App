package com.th3rdwave.safeareacontext;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = SafeAreaContextModule.NAME)
public final class SafeAreaContextModule extends NativeSafeAreaContextSpec {
    public static final Companion Companion = new Companion(null);
    public static final String NAME = "RNCSafeAreaContext";

    public SafeAreaContextModule(@Nullable ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.th3rdwave.safeareacontext.NativeSafeAreaContextSpec
    public Map<String, Object> getTypedExportedConstants() {
        return MapsKt__MapsJVMKt.mapOf(TuplesKt.to("initialWindowMetrics", getInitialWindowMetrics()));
    }

    private final Map<String, Object> getInitialWindowMetrics() {
        View viewFindViewById;
        Window window;
        Activity currentActivity = getReactApplicationContext().getCurrentActivity();
        ViewGroup viewGroup = (ViewGroup) ((currentActivity == null || (window = currentActivity.getWindow()) == null) ? null : window.getDecorView());
        if (viewGroup == null || (viewFindViewById = viewGroup.findViewById(android.R.id.content)) == null) {
            return null;
        }
        EdgeInsets safeAreaInsets = SafeAreaUtilsKt.getSafeAreaInsets(viewGroup);
        Rect frame = SafeAreaUtilsKt.getFrame(viewGroup, viewFindViewById);
        if (safeAreaInsets == null || frame == null) {
            return null;
        }
        return MapsKt__MapsKt.mapOf(TuplesKt.to("insets", SerializationUtilsKt.edgeInsetsToJavaMap(safeAreaInsets)), TuplesKt.to(TypedValues.AttributesType.S_FRAME, SerializationUtilsKt.rectToJavaMap(frame)));
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
