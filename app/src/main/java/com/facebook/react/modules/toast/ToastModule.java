package com.facebook.react.modules.toast;

import android.widget.Toast;
import com.facebook.fbreact.specs.NativeToastAndroidSpec;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@ReactModule(name = "ToastAndroid")
public final class ToastModule extends NativeToastAndroidSpec {
    public static final Companion Companion = new Companion(null);
    private static final String DURATION_LONG_KEY = "LONG";
    private static final String DURATION_SHORT_KEY = "SHORT";
    private static final String GRAVITY_BOTTOM_KEY = "BOTTOM";
    private static final String GRAVITY_CENTER = "CENTER";
    private static final String GRAVITY_TOP_KEY = "TOP";
    public static final String NAME = "ToastAndroid";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToastModule(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    @Override // com.facebook.fbreact.specs.NativeToastAndroidSpec
    public Map<String, Object> getTypedExportedConstants() {
        return MapsKt__MapsKt.mutableMapOf(TuplesKt.to(DURATION_SHORT_KEY, 0), TuplesKt.to(DURATION_LONG_KEY, 1), TuplesKt.to(GRAVITY_TOP_KEY, 49), TuplesKt.to(GRAVITY_BOTTOM_KEY, 81), TuplesKt.to(GRAVITY_CENTER, 17));
    }

    @Override // com.facebook.fbreact.specs.NativeToastAndroidSpec
    public void show(@Nullable final String str, double d) {
        final int i = (int) d;
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.modules.toast.ToastModule$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                ToastModule.show$lambda$0(this.f$0, str, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$0(ToastModule toastModule, String str, int i) {
        Toast.makeText(toastModule.getReactApplicationContext(), str, i).show();
    }

    @Override // com.facebook.fbreact.specs.NativeToastAndroidSpec
    public void showWithGravity(@Nullable final String str, double d, double d2) {
        final int i = (int) d;
        final int i2 = (int) d2;
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.modules.toast.ToastModule$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ToastModule.showWithGravity$lambda$1(this.f$0, str, i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showWithGravity$lambda$1(ToastModule toastModule, String str, int i, int i2) {
        Toast toastMakeText = Toast.makeText(toastModule.getReactApplicationContext(), str, i);
        toastMakeText.setGravity(i2, 0, 0);
        toastMakeText.show();
    }

    @Override // com.facebook.fbreact.specs.NativeToastAndroidSpec
    public void showWithGravityAndOffset(@Nullable final String str, double d, double d2, double d3, double d4) {
        final int i = (int) d;
        final int i2 = (int) d2;
        final int i3 = (int) d3;
        final int i4 = (int) d4;
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.modules.toast.ToastModule$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ToastModule.showWithGravityAndOffset$lambda$2(this.f$0, str, i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showWithGravityAndOffset$lambda$2(ToastModule toastModule, String str, int i, int i2, int i3, int i4) {
        Toast toastMakeText = Toast.makeText(toastModule.getReactApplicationContext(), str, i);
        toastMakeText.setGravity(i2, i3, i4);
        toastMakeText.show();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
