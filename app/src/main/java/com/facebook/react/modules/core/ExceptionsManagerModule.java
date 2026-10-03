package com.facebook.react.modules.core;

import com.facebook.common.logging.FLog;
import com.facebook.fbreact.specs.NativeExceptionsManagerSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.JavascriptException;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.devsupport.StackTraceHelper;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.util.ExceptionDataHelper;
import com.facebook.react.util.JSStackTrace;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@ReactModule(name = NativeExceptionsManagerSpec.NAME)
public class ExceptionsManagerModule extends NativeExceptionsManagerSpec {
    private final DevSupportManager devSupportManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExceptionsManagerModule(@NotNull DevSupportManager devSupportManager) {
        super(null);
        Intrinsics.checkNotNullParameter(devSupportManager, "devSupportManager");
        this.devSupportManager = devSupportManager;
    }

    @Override // com.facebook.fbreact.specs.NativeExceptionsManagerSpec
    public void reportFatalException(@Nullable String str, @Nullable ReadableArray readableArray, double d) {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.putString("message", str);
        javaOnlyMap.putArray(StackTraceHelper.STACK_KEY, readableArray);
        javaOnlyMap.putInt("id", (int) d);
        javaOnlyMap.putBoolean(StackTraceHelper.IS_FATAL_KEY, true);
        reportException(javaOnlyMap);
    }

    @Override // com.facebook.fbreact.specs.NativeExceptionsManagerSpec
    public void reportSoftException(@Nullable String str, @Nullable ReadableArray readableArray, double d) {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.putString("message", str);
        javaOnlyMap.putArray(StackTraceHelper.STACK_KEY, readableArray);
        javaOnlyMap.putInt("id", (int) d);
        javaOnlyMap.putBoolean(StackTraceHelper.IS_FATAL_KEY, false);
        reportException(javaOnlyMap);
    }

    @Override // com.facebook.fbreact.specs.NativeExceptionsManagerSpec
    public void reportException(@NotNull ReadableMap data) {
        Intrinsics.checkNotNullParameter(data, "data");
        String string = data.getString("message");
        if (string == null) {
            string = "";
        }
        ReadableArray array = data.getArray(StackTraceHelper.STACK_KEY);
        if (array == null) {
            array = Arguments.createArray();
        }
        boolean z = data.hasKey(StackTraceHelper.IS_FATAL_KEY) ? data.getBoolean(StackTraceHelper.IS_FATAL_KEY) : false;
        String extraDataAsJson = ExceptionDataHelper.getExtraDataAsJson(data);
        if (z) {
            Intrinsics.checkNotNull(array);
            JavascriptException javascriptException = new JavascriptException(JSStackTrace.format(string, array));
            javascriptException.setExtraDataAsJson(extraDataAsJson);
            throw javascriptException;
        }
        Intrinsics.checkNotNull(array);
        FLog.e(ReactConstants.TAG, JSStackTrace.format(string, array));
        if (extraDataAsJson != null) {
            FLog.d(ReactConstants.TAG, "extraData: %s", extraDataAsJson);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeExceptionsManagerSpec
    public void dismissRedbox() {
        if (this.devSupportManager.getDevSupportEnabled()) {
            this.devSupportManager.hideRedboxDialog();
        }
    }
}
